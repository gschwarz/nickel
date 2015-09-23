package com.rhiscom.cuadratura.files.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.cuadratura.base.manager.BaseManager;
import com.rhiscom.cuadratura.ftp.manager.FTPFileManager;
import com.rhiscom.cuadratura.model.CRCMREntity;

public class VtaCMRManager extends BaseManager {

	
	private final static Logger logger = Logger.getLogger(VtaCMRManager.class.getName());
	
	public void readFile(Date fechaNegocio, String sucursal) {
	
		
		String pathToFile = FILE_DIRECTORY+"VTACMRx" + readerFormatter.format(fechaNegocio) + "x00"
				+ sucursal + ".xls";
		String file="VTACMRx" + readerFormatter.format(fechaNegocio) + "x00"	+ sucursal + ".xls";
		
		File archivo = new File(pathToFile);
		FileReader fr;
		BufferedReader br;
		try {



			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			
			
			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";
			Query query = em.createQuery(deleteQuery);
			
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			CRCMREntity entity = new CRCMREntity();

			try {
				fr = new FileReader(archivo);

				br = new BufferedReader(fr);

			} catch (IOException ex) {
				logger.info("::readFile:: Archivo "+file+" no encontrado, se carga todo en cero");
				//ex.printStackTrace();
				entity = new CRCMREntity();
				entity.setCodigoTrx(0l);
				entity.setSucursal(Long.valueOf(sucursal));
				entity.setFechaTrx(fechaNegocio);
				entity.setMonto(0l);
				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return;

			}
			ArrayList<String> list = new ArrayList<String>();

			String linea;
			String codigoTrx = "CODTRX";
			String monto = "MONTO";
			String fecha = "FECHA";
			String busquedaSucursal = "SUCURSAL";

			int columnaCodTrx = 0;
			int columnaMonto = 0;
			int columnaFechaTrx = 0;
			int columnaLocal = 0;

			long valorCodigo;
			long valorMonto;
			String valorFecha;
			String valorLocal;
			Long valorSucursal;

			int lineas = 0;
			logger.info("::readFile:: Archivo "+file+"  encontrado, se cargan los valores rescatados");
			while ((linea = br.readLine()) != null) {
				lineas++;

				String[] arregloColumnas = linea.split("\t");
				if (lineas == 1) {
					for (int i = 0; i <= arregloColumnas.length - 1; i++) {
						String codigo = arregloColumnas[i];

						if (codigo.compareToIgnoreCase(codigoTrx) == 0) {
							columnaCodTrx = i;
						
						}
						if (codigo.compareToIgnoreCase(monto) == 0) {
							columnaMonto = i;
						
						}
						if (codigo.compareToIgnoreCase(fecha) == 0) {
							columnaFechaTrx = i;
							
						}
						if (codigo.compareToIgnoreCase(busquedaSucursal) == 0) {
							columnaLocal = i;
							
						}

					}

				}

				else {
					
					valorCodigo = Long.valueOf(arregloColumnas[columnaCodTrx].trim());
					valorMonto = Long.valueOf(arregloColumnas[columnaMonto].trim());
					valorFecha = arregloColumnas[columnaFechaTrx].trim();
					valorSucursal = Long.valueOf(arregloColumnas[columnaLocal].trim());

					entity = new CRCMREntity();
					entity.setCodigoTrx(valorCodigo);
					entity.setSucursal(valorSucursal);
					entity.setFechaTrx(fechaNegocio);
					entity.setMonto(valorMonto);

					em.getTransaction().begin();
					em.persist(entity);
					em.getTransaction().commit();
				

				}

			}
 			logger.info("::readFile:: Se mueve archivo "+file+" a carpeta procesados");
			FTPFileManager manager = new FTPFileManager();
			manager.subirArchivoAFTP(pathToFile,file);
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Long totalTrx200(Date fechaNegocio, String sucursal) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and codigoTrx='200'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();

	

		em.close();
		emf.close();
		logger.info("::totalTrx200:: resultado obtenido: " + result);
		
		if(result==null) return 0l;
		
		return result;
		
	}

	public Long totalTrx400(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and codigoTrx='400'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		
		em.close();
		emf.close();
		logger.info("::totalTrx400:: resultado obtenido: " + result);
		
		if(result==null) return 0l;
		
		return result;
	}
	public Long totalTrx220(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and codigoTrx='220'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		
		em.close();
		emf.close();
		
		logger.info("::totalTrx220:: resultado obtenido: " + result);
		
		if(result==null) return 0l;
		return result;
	}
	
	public Long totalTrx403(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and codigoTrx='403'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		
		em.close();
		emf.close();
		logger.info("::totalTrx403:: resultado obtenido: " + result);
		
		if(result==null) return 0l;
		return result;
	}
	
	public Long totalTrx274(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and codigoTrx='274'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		em.close();
		emf.close();
		logger.info("::totalTrx274:: resultado obtenido: " + result);
		
		
		if(result==null) return 0l;
		
		
		return result;
	}
	
	public Long totalTrx473(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and codigoTrx='473'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
	
		em.close();
		emf.close();

		
		logger.info("::totalTrx473:: resultado obtenido: " + result);
		
		if(result==null) return 0l;
		
		return result;
	}
	
	public Long totalTrx217(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and codigoTrx='217'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
	
		em.close();
		emf.close();

		
		logger.info("::totalTrx217:: resultado obtenido: " + result);
		
		if(result==null) return 0l;
		
		return result;
	}
	
	public Long totalTrx402(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and codigoTrx='402'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
	
		em.close();
		emf.close();

		
		logger.info("::totalTrx402:: resultado obtenido: " + result);
		
		if(result==null) return 0l;
		
		return result;
	}

	public long totalTrx238(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and codigoTrx='238'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
	
		em.close();
		emf.close();

		
		logger.info("::totalTrx402:: resultado obtenido: " + result);
		
		if(result==null) return 0l;
		
		return result;
	}

	public long totalTrx401(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		
		String selectQuery = "select sum(monto) from CRCMREntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and codigoTrx='401'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
	
		em.close();
		emf.close();

		
		logger.info("::totalTrx402:: resultado obtenido: " + result);
		
		if(result==null) return 0l;
		
		return result;
	}
}
