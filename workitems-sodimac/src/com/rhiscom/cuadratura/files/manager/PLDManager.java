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
import com.rhiscom.cuadratura.model.PLDEntity;

public class PLDManager extends BaseManager {

	private final static Logger logger = Logger.getLogger(PLDManager.class.getName());

	public void readFile(Date fechaNegocio, String sucursal) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		String columnaFecha = "Fecha";
		String columnaTipoTrx = "Tip. Trans.";
		String columnaEstado = "Estado";
		String columnaTipoVenta = "Tipo Venta";
		String columnaMonto = "Monto";
		String columnaTipoDoc = "TipDoc";
		String columnaSucursalBusqueda = "Sucursal";
		String columnaDonacion = "Donacion";
		String columnaPagoRemoto = "Pago Remoto";

		int indexFecha = 0;
		int indexColumnaTipoTrx = 0;
		int indexColumnaTipoVenta = 0;
		int indexcolumnaEstado = 0;
		int indexcolumnaMonto = 0;
		int indexColumnaTipoDoc = 0;
		int indexColumnaSucursalBusqueda = 0;
		int indexColumnaDonacion = 0;
		int indexColumnaPagoRemoto=0;

		String valorFechaTrx;
		String valorTipoTrx;
		String valorEstado;
		String valorTipoVenta;
		String valorPagoRemoto;
		Long valorMonto;
		Long valorDonacion;
		String valorTipoDocumento;
		Long valorSucursal;

		try {

			String pathToFile = FILE_DIRECTORY+"PLDx" + readerFormatter.format(fechaNegocio) + "x00"
					+ sucursal + ".csv";
			String file = "PLDx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".csv";

			File archivo = new File(pathToFile);

			PLDEntity entity = new PLDEntity();

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			

			String deleteQuery = "delete from PLDEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";
			
			Query query = em.createQuery(deleteQuery);
			
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();
			
			FileReader fr;
			BufferedReader br;
			try {
				fr = new FileReader(archivo);

				br = new BufferedReader(fr);

			} catch (IOException ex) {
				entity = new PLDEntity();
				logger.info("::readFile:: Archivo " + file + " no encontrado, se carga todo en cero");

				entity.setFechaTrx(fechaNegocio);
				entity.setTipoTrx("NA");
				entity.setEstado("NA");
				entity.setTipoVenta("NA");
				entity.setMonto(0l);
				entity.setDonacion(0l);
				entity.setTipoDocumento("NA");
				entity.setPagoRemoto("NA");
				
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

						if (codigo.compareToIgnoreCase(columnaTipoVenta) == 0) {
							indexColumnaTipoVenta = i;
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
					valorTipoVenta = arregloColumnas[indexColumnaTipoVenta];
					valorMonto = Long.valueOf(arregloColumnas[indexcolumnaMonto]);
					valorDonacion = Long.valueOf(arregloColumnas[indexColumnaDonacion]);
					valorTipoDocumento = arregloColumnas[indexColumnaTipoDoc];
					valorSucursal = Long.valueOf(arregloColumnas[indexColumnaSucursalBusqueda]);
					valorPagoRemoto=arregloColumnas[indexColumnaPagoRemoto];

					entity = new PLDEntity();

					entity.setFechaTrx(formatter.parse(valorFechaTrx));
					entity.setTipoTrx(valorTipoTrx);
					entity.setEstado(valorEstado);
					entity.setTipoVenta(valorTipoVenta);
					entity.setMonto(valorMonto);
					entity.setDonacion(valorDonacion);
					entity.setTipoDocumento(valorTipoDocumento);
					entity.setSucursal(valorSucursal);
					entity.setPagoRemoto(valorPagoRemoto);


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
			emf.close();;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public long obtenerTotalVentasInternetDebito(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLDEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='DEB' and " +
						" ( tipoDocumento='BLT' or tipoDocumento='FME' )";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerTotalVentasInternetDebito:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();
		
		return result;
	}

	public long obtenerTotalVentasDebito(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLDEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='MDB' and " +
						" ( tipoDocumento='BLT' or tipoDocumento='FME' or tipoDocumento='REC' )";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerTotalVentasDebito:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();
		
		return result;
	}

	public long obtenerTotalVentasPagoRemotoDebito(Date fechaNegocio, String sucursal) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLDEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='PRC' and pagoRemoto='SI'";
		
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerTotalVentasPagoRemotoDebito:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();
		
		return result;
	}

	public long obtenerAnulacionPagoRemotoDebito(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(monto) from PLDEntity where sucursal ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and  tipoTrx='ARC' and pagoRemoto='SI'" +
						" and tipoDocumento='NCA'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerAnulacionPagoRemotoDebito:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();
		
		return result;
	}

}
