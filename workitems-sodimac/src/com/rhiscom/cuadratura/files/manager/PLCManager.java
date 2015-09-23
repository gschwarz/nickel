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
import com.rhiscom.cuadratura.model.PLCEntity;

public class PLCManager extends BaseManager {
	private final static Logger logger = Logger.getLogger(PLCManager.class.getName());
	public void readFile(Date fechaNegocio, String sucursal) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		
		FileReader fr;
		BufferedReader br ;
		String columnaFecha = "Fecha";
		String columnaTipoTrx = "Tip. Trans.";
		String columnaEstado = "Estado";
		String columnaTipoTarjeta = "Tipo Tarjeta";
		String columnaMonto = "Monto";
		String columnaTipoDoc = "TipDoc";
		String columnaSucursalBusqueda = "Sucursal";
		String columnaDonacion = "Donacion";
		String columnaPagoRemoto="Pago Remoto";

		int indexFecha = 0;
		int indexColumnaTipoTrx = 0;
		int indexColumnaTipoTarjeta = 0;
		int indexcolumnaEstado = 0;
		int indexcolumnaMonto = 0;
		int indexColumnaTipoDoc = 0;
		int indexColumnaSucursalBusqueda = 0;
		int indexColumnaDonacion = 0;
		int indexColumnaPagoRemoto=0;

		String valorFechaTrx;
		String valorTipoTrx;
		String valorEstado;
		String valorTipoTarjeta;
		Long valorMonto;
		Long valorDonacion;
		String valorTipoDocumento;
		Long valorSucursal;
		String pagoRemoto;

		try {

			String pathToFile = FILE_DIRECTORY+"PLCx" + readerFormatter.format(fechaNegocio) + "x00"
					+ sucursal + ".csv";
			String file = "PLCx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".csv";

			File archivo = new File(pathToFile);
			
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			
			
			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from PLCEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";

			Query query = em.createQuery(deleteQuery);
			
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();
			
			
			PLCEntity entity = new PLCEntity();
			try {
				fr = new FileReader(archivo);
                br = new BufferedReader(fr);
			} catch (IOException ex) {
				logger.info("::readFile:: Archivo "+file+" no encontrado, se carga todo en cero");
				entity = new PLCEntity();

				entity.setFechaTrx(fechaNegocio);
				entity.setTipoTrx("NA");
				entity.setEstado("NA");
				entity.setTipoTarjeta("NA");
				entity.setMonto(0l);
				entity.setDonacion(0l);
				entity.setTipoDocumento("NA");
				entity.setSucursal(Long.valueOf(sucursal));
				entity.setPagoRemoto("NA");
				entity.setPagoRemoto("NA");
				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return;
			}

			String linea;
			int lineas = 0;
			 entity = new PLCEntity();

			

			while ((linea = br.readLine()) != null) {
				lineas++;

				String[] arregloColumnas = linea.split(",");
				if (lineas <= 2) {
					for (int i = 0; i <= arregloColumnas.length - 1; i++) {
						String codigo = arregloColumnas[i];

						if (codigo.compareToIgnoreCase(columnaFecha) == 0) {
							indexFecha = i;
						}

						if (codigo.compareToIgnoreCase(columnaTipoTrx) == 0) {
							indexColumnaTipoTrx = i;
						}
						if (codigo.compareToIgnoreCase(columnaEstado) == 0) {
							indexcolumnaEstado = i;
						}

						if (codigo.compareToIgnoreCase(columnaTipoTarjeta) == 0) {
							indexColumnaTipoTarjeta = i;
						}

						if (codigo.compareToIgnoreCase(columnaMonto) == 0) {
							indexcolumnaMonto = i;
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
						
						if (codigo.compareToIgnoreCase(columnaPagoRemoto) == 0) {
							indexColumnaPagoRemoto = i;
						}

					}

				} else {

					valorFechaTrx = arregloColumnas[indexFecha];
					valorTipoTrx = arregloColumnas[indexColumnaTipoTrx];
					valorEstado = arregloColumnas[indexcolumnaEstado];
					valorTipoTarjeta = arregloColumnas[indexColumnaTipoTarjeta];
					valorMonto = Long.valueOf(arregloColumnas[indexcolumnaMonto]);
					valorDonacion = Long.valueOf(arregloColumnas[indexColumnaDonacion]);
					valorTipoDocumento = arregloColumnas[indexColumnaTipoDoc];
					valorSucursal = Long.valueOf(arregloColumnas[indexColumnaSucursalBusqueda]);
					pagoRemoto= arregloColumnas[indexColumnaPagoRemoto];

					entity = new PLCEntity();

					entity.setFechaTrx(formatter.parse(valorFechaTrx));
					entity.setTipoTrx(valorTipoTrx);
					entity.setEstado(valorEstado);
					entity.setTipoTarjeta(valorTipoTarjeta);
					entity.setMonto(valorMonto);
					entity.setDonacion(valorDonacion);
					entity.setTipoDocumento(valorTipoDocumento);
					entity.setSucursal(valorSucursal);
					entity.setPagoRemoto(pagoRemoto);

					em.getTransaction().begin();
					em.persist(entity);
					em.getTransaction().commit();

				}
			}
			logger.info("::readFile:: Se mueve archivo "+file+" a carpeta procesados");
			FTPFileManager manager = new FTPFileManager();
			manager.subirArchivoAFTP(pathToFile,file);
			
			archivo.delete();
			em.close();
			emf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public long obtenerTotalVentasTarjetaCredito(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		//TODO Falta sumar campo donación cuando sea <> 0
		
		String selectQuery = "select sum(monto) from PLCEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='CRE' and (" +
						" tipoDocumento='BLT' or tipoDocumento='FME' or " +
						" tipoDocumento='REC' or  tipoDocumento='ACT')";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerTotalVentasTarjetaCredito:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}
	
	public long obtenerTotalDonacionesVentasTarjetaCredito(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		//TODO Falta sumar campo donación cuando sea <> 0
		
		String selectQuery = "select sum(donacion) from PLCEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='CRE' and (" +
						" tipoDocumento='BLT' or tipoDocumento='FME' or " +
						" tipoDocumento='REC' or  tipoDocumento='ACT') and donacion<>0";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerTotalVentasTarjetaCredito:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}
	public long obtenerVentasInternetCredito(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLCEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='MCR' and (" +
						" tipoDocumento='BLT' or tipoDocumento='FME')";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerVentasInternetCredito:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}
	public long obtenerTotalAnulacionesNCA(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLCEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='DCR' and " +
						" tipoDocumento='NCA'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerTotalAnulacionesNCA:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}
	public long obtenerTotalRecaudaciones(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLCEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='CRE' and " +
						" (tipoDocumento='ACT' or tipoDocumento='REC')";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerTotalRecaudaciones:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}
	public long obtenerTotalAnulacionesRecaudaciones(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLCEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='ACR' and " +
						"( tipoDocumento='ACT' or tipoDocumento='REC' )";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerTotalAnulacionesRecaudaciones:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}
	public long obtenerMontoPagoRemotoCredito(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLCEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='PRC' and " +
						" pagoRemoto='SI'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerMontoPagoRemotoCredito:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}
	
	
	public long obtenerMontoPagoRemotoAnulaciones(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLCEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='ARC' and " +
						" pagoRemoto='SI' and tipoDocumento='NCA'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerMontoPagoRemotoAnulaciones:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}
	public long obtenerTotalAnulacionesNCR(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLCEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='DCR' and " +
						" ( tipoDocumento='BLT' or tipoDocumento='FME' )";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerTotalAnulacionesNCR:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}

}
