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
import com.rhiscom.cuadratura.model.SCTFAEntity;

/**
 * Maneja archivo SCTFA
 * 
 * @author Pablo Caceres
 * 
 */
public class ARQTFManager extends BaseManager {
	private final static Logger logger = Logger.getLogger(ARQTFManager.class.getName());
	private final static String tituloABuscar = "TOTALPORSUCURSAL";
	private boolean aparicionTituloABuscar = false;
	private boolean recuperarDatos=false;
	boolean tituloEncontrado = false;

	public void readFile(Date fechaNegocio, String sucursal) {

		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from SCTFAEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";
			Query query = em.createQuery(deleteQuery);

			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			String pathToFile = FILE_DIRECTORY + "ARQ_TFx" + readerFormatter.format(fechaNegocio) + "x00"
					+ sucursal + ".txt";
			String file = "ARQ_TFx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".txt";

			File archivo = new File(pathToFile);
			FileReader fr;
			BufferedReader br;

			try {
				fr = new FileReader(archivo);

				br = new BufferedReader(fr);

			} catch (IOException ex) {
				logger.info("::readFile:: Archivo " + file + " no encontrado, se carga todo en cero");
				SCTFAEntity entity = new SCTFAEntity();
				entity.setGranTotalAnulacionGiftCard(0l);
				entity.setGranTotalDevolucionesCMRNCA(0l);
				entity.setGranTotalDevolucionesCMRNCR(0l);
				entity.setGranTotalRecaudaciones(0l);
				entity.setGranTotalVentas(0l);
				entity.setFechaTrx(fechaNegocio);
				entity.setSucursal(Long.valueOf(sucursal));
				entity.setTotalAnulacionesAvanceEfectivo(0l);
				entity.setTotalAvanceEfectivo(0l);
				entity.setTotalSuperAvanceEfectivo(0l);
				entity.setTotalAnulacionesSuperAvance(0l);

				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return;
			}
			ArrayList<String> list = new ArrayList<String>();

			String linea;
			// String busqueda="CuotasNormalesCMR";

			boolean granTotalVentasEncontrado = false;
			boolean granTotalRecaudacionesEncontrado = false;
			boolean granTotalDevolucionCMRNCAEncontrado = false;
			boolean granTotalDevolucionCMRNCREncontrado = false;
			boolean granTotalAnulacionGiftCarEncontrado = false;
			boolean totalAvanceEfectivoEncontrado = false;
			boolean totalAnulacionAvanceEfectivoEncontrado = false;
			boolean totalSuperAvanceEfectivoEncontrado=false;
			boolean totalAnulacionesSuperAvanceEfectivoEncontrado=false;
			boolean totalAbonosEncontrados=false;
			boolean totalAbonosRepactacionEncontrados=false;
			boolean totalAnulacionAbonoNormalEncontrados=false;
			boolean totalAnulacionAbonoRepactacionEncontrados=false;

			long granTotalVentas = 0;
			long granTotalRecaudaciones = 0;
			long granTotalDevolucionCMRNCA = 0;
			long granTotalDevolucionCMRNCR = 0;
			long granTotalAnulacionGiftCard = 0;
			long totalAvanceEfectivo = 0;
			long totalAnulacionesAvanceEfectivo = 0;
			long totalSuperAvanceEfectivo=0;
			long totalAnulacionesSuperAvance=0;
			long totalAbonos=0;
			long totalAbonosRepactacion=0;
			long totalAnulacionAbonoNormal=0;
			long totalAnulacionAbonoRepactacion=0;
			

			logger.info("::readFile:: Archivo " + file + "  encontrado, se cargan los valores rescatados");
			while ((linea = br.readLine()) != null) {
				if (!granTotalVentasEncontrado)
					granTotalVentas = getMontoPorTexto(linea, "GRANTOTALVENTAS");
				if (granTotalVentas > 0)
					granTotalVentasEncontrado = true;
				
				if (!granTotalRecaudacionesEncontrado)
					granTotalRecaudaciones = getMontoPorTexto(linea, "GRANTOTALRECAUDACIONES");
				if (granTotalRecaudaciones > 0)
					granTotalRecaudacionesEncontrado = true;
				
				if (!granTotalDevolucionCMRNCREncontrado)
					granTotalDevolucionCMRNCR = getMontoPorTexto(linea, "GRANTOTALDEVOLUCIONCMRXNCR");
				if (granTotalDevolucionCMRNCR > 0)
					granTotalDevolucionCMRNCREncontrado = true;
				
				if (!granTotalDevolucionCMRNCAEncontrado)
					granTotalDevolucionCMRNCA = getMontoPorTexto(linea, "GRANTOTALDEVOLUCIONCMRXNCA");
				if (granTotalDevolucionCMRNCA > 0)
					granTotalDevolucionCMRNCAEncontrado = true;
				
				if (!granTotalAnulacionGiftCarEncontrado)
					granTotalAnulacionGiftCard = getMontoPorTexto(linea, "GRANTOTALANULACIONGIFTCARD");
				if (granTotalAnulacionGiftCard > 0)
					granTotalAnulacionGiftCarEncontrado = true;

				if (!totalAvanceEfectivoEncontrado)
					totalAvanceEfectivo = getMontoPorTexto(linea, "TOTALAVANCESENEFECTIVO");
				if (totalAvanceEfectivo > 0)
					totalAvanceEfectivoEncontrado = true;

				if (!totalAnulacionAvanceEfectivoEncontrado)
					totalAnulacionesAvanceEfectivo = getMontoPorTexto(linea, "TOTALANULACIONAVANCEENEFECTIVO");
				if (totalAnulacionesAvanceEfectivo > 0)
					totalAnulacionAvanceEfectivoEncontrado = true;
				
				if (!totalSuperAvanceEfectivoEncontrado)
					totalSuperAvanceEfectivo = getMontoPorTexto(linea, "TOTALSUPERAVANCESENEFECTIVO");
				if (totalSuperAvanceEfectivo > 0)
					totalSuperAvanceEfectivoEncontrado = true;
								
				if (!totalAnulacionesSuperAvanceEfectivoEncontrado)
					totalAnulacionesSuperAvance = getMontoPorTexto(linea, "TOTALANULACIONSUPERAVANCEEFE.");
				if (totalAnulacionesSuperAvance > 0)
					totalAnulacionesSuperAvanceEfectivoEncontrado = true;
				
				if (!totalAbonosEncontrados)
					totalAbonos = getMontoPorTexto(linea, "TOTALABONOS");
				if (totalAbonos > 0)
					totalAbonosEncontrados = true;
				
				if (!totalAbonosRepactacionEncontrados)
					totalAbonosRepactacion = getMontoPorTexto(linea, "TOTALABONOS(CMRREPACTACION)");
				if (totalAbonosRepactacion > 0)
					totalAbonosRepactacionEncontrados = true;
				
				if (!totalAnulacionAbonoNormalEncontrados)
					totalAnulacionAbonoNormal = getMontoPorTexto(linea, "TOTALANULACIONABONONORMAL");
				if (totalAnulacionAbonoNormal > 0 || totalAnulacionAbonoNormal <0)
					totalAnulacionAbonoNormalEncontrados = true;
				
				if (!totalAnulacionAbonoRepactacionEncontrados)
					totalAnulacionAbonoRepactacion = getMontoPorTexto(linea, "TOTALANULACIONABONOSREPACTACION");
				if (totalAnulacionAbonoRepactacion > 0 || totalAnulacionAbonoRepactacion<0 )
					totalAnulacionAbonoRepactacionEncontrados = true;
				if(aparicionTituloABuscar)
					recuperarDatos=true;

			}
			SCTFAEntity entity = new SCTFAEntity();
			entity.setGranTotalAnulacionGiftCard(granTotalAnulacionGiftCard);
			entity.setGranTotalDevolucionesCMRNCA(granTotalDevolucionCMRNCA);
			entity.setGranTotalDevolucionesCMRNCR(granTotalDevolucionCMRNCR);
			entity.setGranTotalRecaudaciones(granTotalRecaudaciones);
			entity.setGranTotalVentas(granTotalVentas);
			entity.setFechaTrx(fechaNegocio);
			entity.setSucursal(Long.valueOf(sucursal));
			entity.setTotalAnulacionesAvanceEfectivo(totalAnulacionesAvanceEfectivo);
			entity.setTotalAvanceEfectivo(totalAvanceEfectivo);
			entity.setTotalSuperAvanceEfectivo(totalSuperAvanceEfectivo);
			entity.setTotalAnulacionesSuperAvance(totalAnulacionesSuperAvance);
			entity.setTotalAbonoRepactacion(totalAbonosRepactacion);
			entity.setTotalAbonos(totalAbonos);
			entity.setTotalAnulacionAbonoNormal(totalAnulacionAbonoNormal);
			entity.setTotalAnulacionAbonoRepactacion(totalAnulacionAbonoRepactacion);
			
			
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

	private long getMontoPorTexto(String linea, String busqueda) {

		boolean encontrado = false;

		String limpio = linea.trim();

		String textoSinFormato = limpio.replace(" ", "");

		if (textoSinFormato.contains(tituloABuscar)) {
			
			if(recuperarDatos)			
				tituloEncontrado = true;
			else
				aparicionTituloABuscar=true;
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

	public SCTFAEntity obtenerARQTFPorFechaYSucursal(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();
		SCTFAEntity sctfaEntity = new SCTFAEntity();
		String selectQuery = "from SCTFAEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "'";
		Query query = em.createQuery(selectQuery);
		sctfaEntity = (SCTFAEntity) query.getSingleResult();

		em.close();

		return sctfaEntity;
	}
}
