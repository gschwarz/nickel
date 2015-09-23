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
import com.rhiscom.cuadratura.model.PVGCEntity;

public class PVGCManager extends BaseManager {
	private final static Logger logger = Logger.getLogger(PLCManager.class.getName());

	public void readFile(Date fechaNegocio, String sucursal) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		String columnaFecha = "Fecha";
		String columnaCodigoFuncion = "Codigo de Funcion";
		String columnaTipoGift = "Tipo Gift";
		String columnaMonto = "Monto";
		String columnaTipoDoc = "TipDoc";
		String columnaSucursalBusqueda = "Sucursal";
		String columnaDonacion = "Donacion";

		int indexFecha = 0;
		int indexColumnaCodigoFuncion = 0;
		int indexColumnaTipoGift = 0;
		int indexColumnaMonto = 0;
		int indexColumnaTipoDoc = 0;
		int indexColumnaSucursalBusqueda = 0;
		int indexColumnaDonacion = 0;

		String valorFechaTrx;
		String valorCodigoFuncion;
		String valorTipoGift;
		Long valorMonto;
		Long valorDonacion;
		String valorTipoDocumento;
		Long valorSucursal;

		try {

			String pathToFile = FILE_DIRECTORY + "PVGCx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal
					+ ".csv";
			String file = "PVGCx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".csv";

			File archivo = new File(pathToFile);
			BufferedReader br;
			FileReader fr;

			PVGCEntity entity = new PVGCEntity();

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();

			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from PVGCEntity where sucursal ='" + sucursal + "' and fechaTrx='"
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

				entity = new PVGCEntity();

				entity.setFechaTrx(fechaNegocio);
				entity.setCodigoFuncion("NA");
				entity.setTipoGift("NA");
				entity.setMonto(0l);
				entity.setDonacion(0l);
				entity.setTipoDocumento("NA");
				
				

				
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

						if (codigo.compareToIgnoreCase(columnaTipoDoc) == 0) {
							indexColumnaTipoDoc = i;
						}

						if (codigo.compareToIgnoreCase(columnaSucursalBusqueda) == 0) {
							indexColumnaSucursalBusqueda = i;
						}

						if (codigo.compareToIgnoreCase(columnaDonacion) == 0) {
							indexColumnaDonacion = i;
						}

					}

				} else {
					try {
						valorFechaTrx = arregloColumnas[indexFecha];
						valorCodigoFuncion = arregloColumnas[indexColumnaCodigoFuncion];
						valorTipoGift = arregloColumnas[indexColumnaTipoGift];
						valorMonto = Long.valueOf(arregloColumnas[indexColumnaMonto]);
						try {
							valorDonacion = Long.valueOf(arregloColumnas[indexColumnaDonacion]);
						} catch (Exception ex) {
							valorDonacion = 0l;
						}
						valorTipoDocumento = arregloColumnas[indexColumnaTipoDoc];
						valorSucursal = Long.valueOf(arregloColumnas[indexColumnaSucursalBusqueda]);

						entity = new PVGCEntity();

						entity.setFechaTrx(formatter.parse(valorFechaTrx));
						entity.setCodigoFuncion(valorCodigoFuncion);
						entity.setTipoGift(valorTipoGift);
						entity.setMonto(valorMonto);
						entity.setDonacion(valorDonacion);
						entity.setTipoDocumento(valorTipoDocumento);
						entity.setSucursal(valorSucursal);

						em.getTransaction().begin();
						em.persist(entity);
						em.getTransaction().commit();

					} catch (Exception ex) {
						ex.printStackTrace();

					}
				}
			}
			logger.info("::readFile:: Se mueve archivo " + file + " a carpeta procesados");
			FTPFileManager manager = new FTPFileManager();
			manager.subirArchivoAFTP(pathToFile, file);
			em.close();
			emf.close();
			archivo.delete();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Long traerMontoPorTipoGift(String tipoGift, Date fechaNegocio, String sucursal) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PVGCEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and tipoGift='" + tipoGift + "' and codigoFuncion in(1,2)";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		em.close();
		emf.close();
		
		logger.info("::traerMontoPorTipoGift:: resultado obtenido: " + result);
		

		if (result == null)
			return 0l;

		return result;

	}

	public long traerTotalDonacionPorTipoGift(String tipoGift, Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(donacion) from PVGCEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and tipoGift='" + tipoGift + "' and codigoFuncion in(1,2) and  donacion<>0";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		em.close();
		emf.close();

		
		logger.info("::traerTotalDonacionPorTipoGift:: resultado obtenido: " + result);
		
		if (result == null)
			return 0l;

		return result;
	}

	public long traerMontoPorTipoGiftCodFuncion30TipoDocNCA(String tipoGift, Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PVGCEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and tipoGift='" + tipoGift + "' and codigoFuncion='30' and tipoDocumento='NCA'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		
		
		logger.info("::traerMontoPorTipoGiftCodFuncion30TipoDocNCA:: resultado obtenido: " + result);
		
		em.close();
		emf.close();

		if (result == null)
			return 0l;

		return result;
	}

	public long traerTotalDonacionPorTipoGiftCodFuncion30TipoDocNCA(String tipoGift, Date fechaNegocio,
			String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(donacion) from PVGCEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and tipoGift='" + tipoGift + "' and codigoFuncion='30' and tipoDocumento='NCA' and donacion<>0";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		
		
		logger.info("::traerTotalDonacionPorTipoGiftCodFuncion30TipoDocNCA:: resultado obtenido: " + result);
		
		
		em.close();
		emf.close();

		if (result == null)
			return 0l;

		return result;
	}

	public long traerMontoPorTipoGiftCodFuncion30TipoDocNCR(String tipoGift, Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PVGCEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and tipoGift='" + tipoGift + "' and codigoFuncion='30' and tipoDocumento='NCR'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		em.close();
		emf.close();

		logger.info("::traerMontoPorTipoGiftCodFuncion30TipoDocNCR:: resultado obtenido: " + result);
		
		
		if (result == null)
			return 0l;

		return result;
	}

	public long traerTotalMontoPorTipoGiftCodFuncion30TipoDocNCR(String tipoGift, Date fechaNegocio,
			String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PVGCEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "' and tipoGift='" + tipoGift + "' and codigoFuncion='30' and tipoDocumento='NCR'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		em.close();
		emf.close();

		logger.info("::traerTotalDonacionPorTipoGiftCodFuncion30TipoDocNCR:: resultado obtenido: " + result);
		
		
		if (result == null)
			return 0l;

		return result;
	}

}
