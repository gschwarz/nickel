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
import com.rhiscom.cuadratura.model.PLGCEntity;

public class PLGCManager extends BaseManager {
	
	private final static Logger logger = Logger.getLogger(PLGCManager.class.getName());
	
	public void readFile(Date fechaNegocio, String sucursal) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		String pathToFile = FILE_DIRECTORY+"PLGCx" + readerFormatter.format(fechaNegocio) + "x00"
				+ sucursal + ".csv";
		String file = "PLGCx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".csv";

		File archivo = new File(pathToFile);
		BufferedReader br;
		FileReader fr;
		String columnaFecha = "Fecha";
		String columnaCodigoFuncion = "Codigo de Funcion";
		String columnaTipoGift = "Tipo Gift";
		String columnaMonto = "Monto";
		String columnaSucursalBusqueda = "Sucursal";

		int indexFecha = 0;
		int indexColumnaCodigoFuncion = 0;
		int indexColumnaTipoGift = 0;
		int indexColumnaMonto = 0;
		int indexColumnaSucursalBusqueda = 0;

		String valorFechaTrx;
		String valorCodigoFuncion;
		String valorTipoGift;
		Long valorMonto;
		Long valorSucursal;

		try {
			PLGCEntity entity = new PLGCEntity();

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			
			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from PLGCEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";
			
			Query query = em.createQuery(deleteQuery);
			
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			try {
				fr = new FileReader(archivo);

				br = new BufferedReader(fr);

			} catch (IOException ex) {
				logger.info("::readFile:: Archivo " + file + " NO encontrado, se carga todo en cero");

				entity = new PLGCEntity();

				entity.setFechaTrx(fechaNegocio);
				entity.setCodigoFuncion("NA");
				entity.setTipoGift("NA");
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
			int lineas = 0;

			while ((linea = br.readLine()) != null) {
				lineas++;

				String[] arregloColumnas = linea.split(",");
				if (lineas == 1) {
					for (int i = 0; i <= arregloColumnas.length - 1; i++) {
						String codigo = arregloColumnas[i];

						if (codigo.compareToIgnoreCase(columnaFecha) == 0) {
							indexFecha = i;
						}

						if (codigo.compareToIgnoreCase(columnaCodigoFuncion) == 0) {
							indexColumnaCodigoFuncion = i;
						}
						if (codigo.compareToIgnoreCase(columnaTipoGift) == 0) {
							indexColumnaTipoGift = i;
						}

						if (codigo.compareToIgnoreCase(columnaMonto) == 0) {
							indexColumnaMonto = i;
						}

						if (codigo.compareToIgnoreCase(columnaSucursalBusqueda) == 0) {
							indexColumnaSucursalBusqueda = i;
						}

					}

				} else {

					valorFechaTrx = arregloColumnas[indexFecha];
					valorCodigoFuncion = arregloColumnas[indexColumnaCodigoFuncion];
					valorTipoGift = arregloColumnas[indexColumnaTipoGift];
					valorMonto = Long.valueOf(arregloColumnas[indexColumnaMonto]);

					valorSucursal = Long.valueOf(arregloColumnas[indexColumnaSucursalBusqueda]);

					entity = new PLGCEntity();

					entity.setFechaTrx(formatter.parse(valorFechaTrx));
					entity.setCodigoFuncion(valorCodigoFuncion);
					entity.setTipoGift(valorTipoGift);
					entity.setMonto(valorMonto);
					entity.setSucursal(valorSucursal);

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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Long obtenerMontoSegunCodigoGiftYFuncion(String tipoGif, String codFuncion, String sucursal, Date fechaNegocio) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from PLGCEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and tipoGift='" +tipoGif+ "' and codigoFuncion='" +codFuncion+"'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		
		if(result==null) return 0l;
		
		em.close();
		emf.close();

		return result; 
	}
	
	
}
