package com.rhiscom.cuadratura.files.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.cuadratura.base.manager.BaseManager;
import com.rhiscom.cuadratura.ftp.manager.FTPFileManager;
import com.rhiscom.cuadratura.model.PSDEBEntity;

public class ARQDBManager extends BaseManager {
	private final static Logger logger = Logger.getLogger(LDTAManager.class.getName());
	private final static String tituloABuscar = "TOTALPORSUCURSAL";
	boolean tituloEncontrado = false;

	public void readFile(Date fechaNegocio, String sucursal) {

		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from PSDEBEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";
			Query query = em.createQuery(deleteQuery);
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();
			
			String pathToFile = FILE_DIRECTORY+"ARQ_DBx" + readerFormatter.format(fechaNegocio) + "x00"
					+ sucursal + ".txt";
			String file = "ARQ_DBx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".txt";
			File archivo = new File(pathToFile);
			FileReader fr;
			BufferedReader br;

			try {
				fr = new FileReader(archivo);
				br = new BufferedReader(fr);
			} catch (IOException ex) {
				logger.info("::readFile:: Archivo "+file+" NO encontrado, se carga todo en cero");
				
				PSDEBEntity entity = new PSDEBEntity();

				entity.setFechaTrx(fechaNegocio);
				entity.setSucursal(Long.valueOf(sucursal));
				entity.setTotalRecaudaciones(0l);
				entity.setTotalVentasInternetDebito(0l);
				entity.setTotalVentasTarjetaDebito(0l);
				entity.setTotalVentasPagoRemotoDebito(0l);
				entity.setTotalAnulacionPagoRemotoDebito(0l);
				
				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return;
			}

			String linea;
			boolean totalVentasTarjetasDebitoEncontrado = false;
			boolean totalVentasInternetDeitoEncontrado = false;
			boolean totalRecaudacionesEncontrado = false;
			boolean totalVentasPagoRemotoDebitoEncontrado=false;
			boolean totalAnulacionPagoRemotoDebitoEncontrado=false;

			long totalVentasInternetDebito = 0;
			long totalVentasTarjetaDebito = 0;
			long totalRecaudaciones = 0;
			long totalVentasPagoRemotoDebito=0;
			long totalAnulacionPagoRemotoDebito=0;
			logger.info("::readFile:: Archivo "+file+"  encontrado, se cargan los valores rescatados");
			while ((linea = br.readLine()) != null) {
				if (!totalVentasTarjetasDebitoEncontrado)
					totalVentasTarjetaDebito = getMontoPorTexto(linea, "TOTALVENTASTARJETASDEBITO");
				if (totalVentasTarjetaDebito > 0)
					totalVentasTarjetasDebitoEncontrado = true;
				if (!totalVentasInternetDeitoEncontrado)
					totalVentasInternetDebito = getMontoPorTexto(linea, "TOTALVENTASINTERNETDEBITO");
				if (totalVentasInternetDebito > 0)
					totalVentasInternetDeitoEncontrado = true;
				if (!totalRecaudacionesEncontrado)
					totalRecaudaciones = getMontoPorTexto(linea, "TOTALRECAUDACIONES");
				if (totalRecaudaciones > 0)
					totalRecaudacionesEncontrado = true;
				
				
				if (!totalVentasPagoRemotoDebitoEncontrado)
					totalVentasPagoRemotoDebito = getMontoPorTexto(linea, "TOTALVENTASPAGOREMOTODEBITO");
				if (totalVentasPagoRemotoDebito > 0)
					totalVentasPagoRemotoDebitoEncontrado = true;
				
				
				if (!totalAnulacionPagoRemotoDebitoEncontrado)
					totalAnulacionPagoRemotoDebito = getMontoPorTexto(linea, "TOTALANULACIONPAGOREMOTODEB");
				if (totalAnulacionPagoRemotoDebito > 0)
					totalAnulacionPagoRemotoDebitoEncontrado = true;

			}
			PSDEBEntity entity = new PSDEBEntity();

			entity.setFechaTrx(fechaNegocio);
			entity.setSucursal(Long.valueOf(sucursal));
			entity.setTotalRecaudaciones(totalRecaudaciones);
			entity.setTotalVentasInternetDebito(totalVentasInternetDebito);
			entity.setTotalVentasTarjetaDebito(totalVentasTarjetaDebito);
			entity.setTotalVentasPagoRemotoDebito(totalVentasPagoRemotoDebito);
			entity.setTotalAnulacionPagoRemotoDebito(totalAnulacionPagoRemotoDebito);
			

			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			
			
			logger.info("::readFile:: Se mueve archivo "+file+" a carpeta procesados");
			FTPFileManager manager = new FTPFileManager();
			manager.subirArchivoAFTP(pathToFile, file);
			em.close();
			emf.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long getMontoPorTexto(String linea, String busqueda) {

		boolean encontrado = false;

		String limpio = linea.trim();

		String textoSinFormato = limpio.replace(" ", "");

		if (textoSinFormato.contains(tituloABuscar)) {

			tituloEncontrado = true;
		}
		if (tituloEncontrado) {

			if (textoSinFormato.contains(busqueda)) {

				if (!encontrado) {

					String restoDeTexto = limpio.substring(busqueda.length());
					String monto1 = buscarMontoSinDecimalesParaSCTFA(restoDeTexto, encontrado);
					encontrado = false;

					return Long.valueOf(monto1);

				}
			}
		}
		return 0;
	}

	private String buscarMontoSinDecimalesParaSCTFA(String texto, boolean encontrado) {
		StringBuilder monto = new StringBuilder();
		char[] arreglo = texto.toCharArray();
		int contador = 0;
		boolean fin = true;
		int index = texto.indexOf("$");
		for (int j = index; j <= arreglo.length - 1; j++) {
			char c = arreglo[j];

			if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
					|| c == '9' || c == '0') {

				contador++;
				monto.append(c);

			}
			if (c == ' ' && monto.length() > 0) {

				break;
			}

		}

		encontrado = true;

		return monto.toString();
	}

	public PSDEBEntity obtenerARQDBPorFechaYSucursal(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		PSDEBEntity psdebEntity = new PSDEBEntity();
		String selectQuery = "from PSDEBEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "'";
		Query query = em.createQuery(selectQuery);
		psdebEntity = (PSDEBEntity) query.getSingleResult();

		
		
		em.close();
		emf.close();

		return psdebEntity;
		
	}
}
