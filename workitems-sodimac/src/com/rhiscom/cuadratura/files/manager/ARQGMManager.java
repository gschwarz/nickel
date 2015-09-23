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
import com.rhiscom.cuadratura.model.ARQGMEntity;

public class ARQGMManager extends BaseManager {

	private final static String tituloABuscar = "TOTALPORSUCURSAL";
	boolean tituloEncontrado = false;
	private final static Logger logger = Logger.getLogger(ARQGMManager.class.getName());

	public void readFile(Date fechaNegocio, String sucursal) {

		try {

			String pathToFile = FILE_DIRECTORY+"ARQ_GMx" + readerFormatter.format(fechaNegocio) + "x00"
					+ sucursal + ".txt";
			String file = "ARQ_GMx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".txt";
			File archivo = new File(pathToFile);
			FileReader fr;
			BufferedReader br;
			
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			
			
			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from ARQGMEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";
			Query query = em.createQuery(deleteQuery);
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();
			try {

				fr = new FileReader(archivo);

				br = new BufferedReader(fr);
			} catch (IOException ex) {
				logger.info("::readFile:: Archivo " + file + " no encontrado, se carga todo en cero");
				ARQGMEntity entity = new ARQGMEntity();

				entity.setFechaTrx(fechaNegocio);
				entity.setSucursal(Long.valueOf(sucursal));
				entity.setGranTotalAbono(0l);
				entity.setGrantotalActivacionGiftCMR(0l);
				entity.setGranTotalAnulacionAbono(0l);
				entity.setGranTotalAnulacionActivacion(0l);
				entity.setGranTotalAnulacionVentas(0l);
				entity.setGranTotalVentasConGiftCMR(0l);

				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return;
			}
			
			String linea;
		

			boolean granTotalActivacionGIFTCMREncontrado = false;
			boolean granTotalVentasConGiftEncontrado = false;
			boolean granTotalAnulacionActivacionEncontrado = false;
			boolean granTotalAnulacionVentasEncontrado = false;
			boolean granTotalAbonoEncontrado = false;
			boolean granTotalAnulacionAbonoEncontrado = false;

			long grantotalActivacionGiftCMR = 0;
			long granTotalVentasConGiftCMR = 0;
			long granTotalAnulacionActivacion = 0;
			long granTotalAnulacionVentas = 0;
			long granTotalAbono = 0;
			long granTotalAnulacionAbono = 0;

			logger.info("::readFile:: Archivo " + file + "  encontrado, se cargan los valores rescatados");
			while ((linea = br.readLine()) != null) {
				if (!granTotalActivacionGIFTCMREncontrado)
					grantotalActivacionGiftCMR = getMontoPorTexto(linea, "GRANTOTALACTIVACIONGIFTCMR");
				if (grantotalActivacionGiftCMR > 0)
					granTotalActivacionGIFTCMREncontrado = true;

				if (!granTotalVentasConGiftEncontrado)
					granTotalVentasConGiftCMR = getMontoPorTexto(linea, "GRANTOTALVENTASCONGIFTCMR");
				if (granTotalVentasConGiftCMR > 0)
					granTotalVentasConGiftEncontrado = true;

				if (!granTotalAnulacionActivacionEncontrado)
					granTotalAnulacionActivacion = getMontoPorTexto(linea, "GRANTOTALANULACIONACTIVACION");
				if (granTotalAnulacionActivacion > 0)
					granTotalAnulacionActivacionEncontrado = true;

				if (!granTotalAnulacionVentasEncontrado)
					granTotalAnulacionVentas = getMontoPorTexto(linea, "GRANTOTALANULACIONVENTAS");
				if (granTotalAnulacionVentas > 0)
					granTotalAnulacionVentasEncontrado = true;

				if (!granTotalAbonoEncontrado)
					granTotalAbono = getMontoPorTexto(linea, "GRANTOTALABONO");
				if (granTotalAbono > 0)
					granTotalAbonoEncontrado = true;

				if (!granTotalAnulacionAbonoEncontrado)
					granTotalAnulacionAbono = getMontoPorTexto(linea, "GRANTOTALANULACIONABONO ");
				if (granTotalAnulacionAbono > 0)
					granTotalAnulacionAbonoEncontrado = true;

			}
			ARQGMEntity entity = new ARQGMEntity();

			entity.setFechaTrx(fechaNegocio);
			entity.setSucursal(Long.valueOf(sucursal));
			entity.setGranTotalAbono(granTotalAbono);
			entity.setGrantotalActivacionGiftCMR(grantotalActivacionGiftCMR);
			entity.setGranTotalAnulacionAbono(granTotalAnulacionAbono);
			entity.setGranTotalAnulacionActivacion(granTotalAnulacionActivacion);
			entity.setGranTotalAnulacionVentas(granTotalAnulacionVentas);
			entity.setGranTotalVentasConGiftCMR(granTotalVentasConGiftCMR);

			em.getTransaction().begin();  
			em.persist(entity);
			em.getTransaction().commit();
			logger.info("::readFile:: Se mueve archivo " + file + " a carpeta procesados");
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

				int posicion = limpio.indexOf(busqueda);

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
}
