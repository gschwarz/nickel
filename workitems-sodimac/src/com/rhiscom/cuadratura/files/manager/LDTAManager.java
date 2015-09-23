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
import com.rhiscom.cuadratura.model.LDTAEntity;

public class LDTAManager extends BaseManager {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static Logger logger = Logger.getLogger(LDTAManager.class.getName());
	SimpleDateFormat readerFormatter = new SimpleDateFormat("yyyyMMdd");

	public void readFile(Date fechaNegocio, String sucursal) {

		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from LDTAEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter.format(fechaNegocio) + "'";
			
			Query query = em.createQuery(deleteQuery);
			
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			String pathToFile = FILE_DIRECTORY + "LDTAx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal
					+ ".txt";
			String file = "LDTAx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".txt";

			File archivo = new File(pathToFile);
			FileReader fr;
			BufferedReader br = null;
			LDTAEntity entity = new LDTAEntity();
			try {
				fr = new FileReader(archivo);
				br = new BufferedReader(fr);

			} catch (IOException ex) {
				logger.info("::readFile:: Archivo " + file + " no encontrado, se carga todo en cero");
				
				entity = new LDTAEntity();
				entity.setFechaTrx(fechaNegocio);
				entity.setMonto(0l);
				entity.setSucursal(Long.valueOf(sucursal));
				
				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return;
			}

			String linea;
			long montoTF;
			logger.info("::readFile:: Archivo " + file + "  encontrado, se cargan los valores rescatados");
			while ((linea = br.readLine()) != null) {

				String[] arregloDeTexto = linea.split("\t");

				montoTF = getMontoPorTexto(linea, "TF");

				if (montoTF != -1) {

					
					entity = new LDTAEntity();
					entity.setFechaTrx(fechaNegocio);
					entity.setMonto(montoTF);
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

	protected long getMontoPorTexto(String linea, String busqueda) {

		String limpio = linea.trim();

		String textoSinFormato = limpio;

		if (textoSinFormato.contains(busqueda)) {

			boolean encontrado = false;

			int posicion = textoSinFormato.indexOf(busqueda);

			for (int i = posicion; i <= linea.length() - 1; i++) {

				if (!encontrado) {

					String restoDeTexto = textoSinFormato.substring(posicion + busqueda.length());
					String monto = buscarMonto(restoDeTexto, encontrado);

					return Long.valueOf(monto);

				}

			}

		} else {
			return -1;
		}
		return -1;
	}

	private String buscarMonto(String texto, boolean encontrado) {
		StringBuilder monto = new StringBuilder();
		char[] arreglo = texto.toCharArray();
		int contador = 0;
		boolean fin = true;
		for (int j = 0; j <= arreglo.length - 1; j++) {
			char c = arreglo[j];

			if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
					|| c == '9' || c == '0') {

				contador++;
				if (contador > 3) {
					fin = false;
					break;
				} else {
					monto.append(c);
				}
			}
			if (c == '.') {

				contador = 0;
			}

			if(c=='0' && j==0) {
				contador = 0;

				break;
			}

			if (fin == false) {

				contador = 0;

				break;
			}

		}

		encontrado = true;

		return monto.toString();
	}

	public Long getTotalMontoTF(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from LDTAEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		em.close();
		
		
		if (result == null)
			return 0l;

	

		return result;
	}
}
