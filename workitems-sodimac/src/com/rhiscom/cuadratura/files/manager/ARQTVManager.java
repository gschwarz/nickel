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
import com.rhiscom.cuadratura.model.PSCREEntity;

public class ARQTVManager extends BaseManager {

	private final static String tituloABuscar = "TOTALPORSUCURSAL";
	boolean tituloEncontrado = false;
	private final static Logger logger = Logger.getLogger(ARQTVManager.class.getName());

	@Override
	public void readFile(Date fechaNegocio, String sucursal) {

		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from PSCREEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";
			Query query = em.createQuery(deleteQuery);
			
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			String pathToFile = FILE_DIRECTORY+"ARQ_TVx" + readerFormatter.format(fechaNegocio) + "x00"
					+ sucursal + ".txt";
			String file = "ARQ_TVx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".txt";

			File archivo = new File(pathToFile);
			FileReader fr;
			BufferedReader br = null;
			try {

				fr = new FileReader(archivo);

				br = new BufferedReader(fr);
			} catch (IOException ex) {

				PSCREEntity entity = new PSCREEntity();

				entity.setFechaTrx(fechaNegocio);
				entity.setSucursal(Long.valueOf(sucursal));
				entity.setTotalAnulacionesInternetNCA(0l);
				entity.setTotalAnulacionesInternetNCR(0l);
				entity.setTotalAnulacionesNCA(0l);
				entity.setTotalAnulacionesNCR(0l);
				entity.setTotalAnulacionesRecaudacion(0l);
				entity.setTotalRecaudaciones(0l);
				entity.setTotalVentasInternetCredito(0l);
				entity.setTotalVentasTarjetaCredito(0l);
				entity.setTotalPagoRemotoCredito(0l);
				entity.setTotalAnulacionPagoRemotoCredito(0l);

				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return;
			}

			String linea;
			// String busqueda="CuotasNormalesCMR";

			boolean totalVentasTarjetasCreditoEncontrado = false;
			boolean totalVentasInternetCreditoEncontrado = false;
			boolean totalAnulacionesNCAEncontrado = false;
			boolean totalAnulacionesNCREncontrado = false;
			boolean totalAnulacionesInternetNCAEncontrado = false;
			boolean totalAnulacionesInternetNCREncontrado = false;
			boolean totalRecaudacionesEncontrado = false;
			boolean totalAnulacionesRecaudacionEncontrado = false;
			boolean totalPagoRemotoCreditoEncontrado=false;
			boolean totalAnulacionPagoRemotoCreditoEncontrado=false;
			

			long totalVentasTarjetaCredito = 0;
			long totalVentasInternetCredito = 0;
			long totalAnulacionesNCR = 0;
			long totalAnulacionesNCA = 0;
			long totalAnulacionesInternetNCA = 0;
			long totalAnulacionesInternetNCR = 0;
			long totalRecaudaciones = 0;
			long totalAnulacionesRecaudacion = 0;
			long totalPagoRemotoCredito=0;
			long totalAnulacionPagoRemotoCredito=0;

			while ((linea = br.readLine()) != null) {
				if (!totalVentasTarjetasCreditoEncontrado)
					totalVentasTarjetaCredito = getMontoPorTexto(linea, "TOTALVENTASTARJETASCREDITO");
				if (totalVentasTarjetaCredito > 0)
					totalVentasTarjetasCreditoEncontrado = true;
				if (!totalVentasInternetCreditoEncontrado)
					totalVentasInternetCredito = getMontoPorTexto(linea, "TOTALVENTASINTERNETCREDITO");
				if (totalVentasInternetCredito > 0)
					totalVentasInternetCreditoEncontrado = true;
				if (!totalAnulacionesNCREncontrado)
					totalAnulacionesNCA = getMontoPorTexto(linea, "TOTALANULACIONESxNCA");
				if (totalAnulacionesNCA > 0)
					totalAnulacionesNCREncontrado = true;
				if (!totalAnulacionesNCAEncontrado)
					totalAnulacionesNCR = getMontoPorTexto(linea, "TOTALANULACIONESxNCR");
				if (totalAnulacionesNCR > 0)
					totalAnulacionesNCAEncontrado = true;
				if (!totalAnulacionesInternetNCAEncontrado)
					totalAnulacionesInternetNCA = getMontoPorTexto(linea, "TOTALANULINTERNETNCA");
				if (totalAnulacionesInternetNCA > 0)
					totalAnulacionesInternetNCAEncontrado = true;
				if (!totalAnulacionesInternetNCREncontrado)
					totalAnulacionesInternetNCR = getMontoPorTexto(linea, "TOTALANULINTERNETNCR");
				if (totalAnulacionesInternetNCR > 0)
					totalAnulacionesInternetNCREncontrado = true;
				if (!totalRecaudacionesEncontrado)
					totalRecaudaciones = getMontoPorTexto(linea, "TOTALRECAUDACIONES");
				if (totalRecaudaciones > 0)
					totalRecaudacionesEncontrado = true;
				if (!totalAnulacionesRecaudacionEncontrado)
					totalAnulacionesRecaudacion = getMontoPorTexto(linea, "TOTALANULACIONRECAUDACIONES");
				if (totalAnulacionesRecaudacion > 0)
					totalAnulacionesRecaudacionEncontrado = true;
				
				if (!totalPagoRemotoCreditoEncontrado)
					totalPagoRemotoCredito = getMontoPorTexto(linea, "TOTALVENTASPAGOREMOTOCREDITO");
				if (totalPagoRemotoCredito > 0)
					totalPagoRemotoCreditoEncontrado = true;
				
				
				if (!totalAnulacionPagoRemotoCreditoEncontrado)
					totalAnulacionPagoRemotoCredito = getMontoPorTexto(linea, "TOTALANULACIONPAGOREMOTOCRE");
				if (totalAnulacionPagoRemotoCredito > 0)
					totalAnulacionPagoRemotoCreditoEncontrado = true;

			}
			PSCREEntity entity = new PSCREEntity();

			entity.setFechaTrx(fechaNegocio);
			entity.setSucursal(Long.valueOf(sucursal));
			entity.setTotalAnulacionesInternetNCA(totalAnulacionesInternetNCA);
			entity.setTotalAnulacionesInternetNCR(totalAnulacionesInternetNCR);
			entity.setTotalAnulacionesNCA(totalAnulacionesNCA);
			entity.setTotalAnulacionesNCR(totalAnulacionesNCR);
			entity.setTotalAnulacionesRecaudacion(totalAnulacionesRecaudacion);
			entity.setTotalRecaudaciones(totalRecaudaciones);
			entity.setTotalVentasInternetCredito(totalVentasInternetCredito);
			entity.setTotalVentasTarjetaCredito(totalVentasTarjetaCredito);
			entity.setTotalPagoRemotoCredito(totalPagoRemotoCredito);
			entity.setTotalAnulacionPagoRemotoCredito(totalAnulacionPagoRemotoCredito);

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

	public PSCREEntity obtenerPSCREPorFechaYSucursal(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		PSCREEntity psCREEntity = new PSCREEntity();
		String selectQuery = "from PSCREEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "'";
		Query query = em.createQuery(selectQuery);
		psCREEntity = (PSCREEntity) query.getSingleResult();

		
		
		em.close();
		emf.close();

		return psCREEntity;
	}
}
