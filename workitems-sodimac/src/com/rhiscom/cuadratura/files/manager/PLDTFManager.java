package com.rhiscom.cuadratura.files.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.cuadratura.base.manager.BaseManager;
import com.rhiscom.cuadratura.ftp.manager.FTPFileManager;
import com.rhiscom.cuadratura.model.PLDTFEntity;

public class PLDTFManager extends BaseManager {

	SimpleDateFormat readerFormatter = new SimpleDateFormat("yyyyMMdd");
	private final static Logger logger = Logger.getLogger(PLDTFManager.class.getName());

	public void readFile(Date fechaNegocio, String sucursal) {

		String pathToFile = FILE_DIRECTORY + "PLDTFx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal
				+ ".xls";
		String file = "PLDTFx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".xls";

		File archivo = new File(pathToFile);
		FileReader fr;
		PLDTFEntity entity = new PLDTFEntity();

		String linea;
		String busqueda = "Abono CMR";
		int columnaCodTrx = 0;
		String monto = null;

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();

			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from PLDTFEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";
			Query query = em.createQuery(deleteQuery);

			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			try {
				fr = new FileReader(archivo);

			} catch (IOException ex) {
				logger.info("::readFile:: Archivo " + file + " no encontrado, se carga todo en cero");
				entity = new PLDTFEntity();
				entity.setMonto(Long.valueOf(0));
				entity.setFechaTrx(fechaNegocio);
				entity.setSucursal(Long.valueOf(sucursal));

				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return;

			}
			logger.info("::readFile:: Archivo " + file + "  encontrado, se cargan los valores rescatados");
			BufferedReader br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {

				String[] arregloColumnas = linea.split("\t");

				for (int i = 0; i <= arregloColumnas.length - 1; i++) {
					String codigo = arregloColumnas[i];

					if (codigo.compareToIgnoreCase(busqueda) == 0) {
						columnaCodTrx = i;

					}

				}

				try {
					monto = arregloColumnas[columnaCodTrx];
				} catch (Exception ex) {
				}

				// System.out.println("MONTO ABONO CRM :" + monto);

				if (monto.matches("[0-9]+")) {

					entity = new PLDTFEntity();
					entity.setMonto(Long.valueOf(monto));
					entity.setFechaTrx(fechaNegocio);
					entity.setSucursal(Long.valueOf(sucursal));

					em.getTransaction().begin();
					em.persist(entity);
					em.getTransaction().commit();

				}

			}
			logger.info("::readFile:: Se mueve archivo " + file + " a carpeta procesados");
			FTPFileManager manager = new FTPFileManager();
			manager.subirArchivoAFTP(pathToFile, file);
			em.close();
			emf.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Long getTotalMontoAbonoCMRPLDTF(Date fechaNegocio, String sucursal) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLDTFEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::getTotalMontoAbonoCMRPLDTF:: resultado " + result);

		if (result == null)
			return 0l;

		em.close();
		emf.close();

		return result;

	}

}
