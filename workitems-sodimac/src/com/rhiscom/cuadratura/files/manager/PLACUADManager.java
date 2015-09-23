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
import com.rhiscom.cuadratura.model.PLCUAEntity;

public class PLACUADManager extends BaseManager {

	private final static Logger logger = Logger.getLogger(PLACUADManager.class.getName());

	public void readFile(Date fechaNegocio, String sucursal) {

		SimpleDateFormat readerFormatter = new SimpleDateFormat("yyyyMMdd");

		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from PLCUAEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";

			Query query = em.createQuery(deleteQuery);

			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			String pathToFile = FILE_DIRECTORY + "PLA_CUADx" + readerFormatter.format(fechaNegocio) + "x00"
					+ sucursal + ".txt";
			String file = "PLA_CUADx" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".txt";
			File archivo;
			FileReader fr;
			BufferedReader br = null;

			try {
				archivo = new File(pathToFile);
				fr = new FileReader(archivo);
				br = new BufferedReader(fr);

			} catch (IOException ex) {
				logger.info("::readFile:: Archivo " + file + " no encontrado, se carga todo en cero");
				PLCUAEntity plcuaEntity = new PLCUAEntity();
				plcuaEntity.setDonacion(0l);
				plcuaEntity.setCuotasDiferidas(0l);
				plcuaEntity.setCuotasNormales(0l);
				plcuaEntity.setNCRTF(0l);
				plcuaEntity.setTresCC(0l);
				plcuaEntity.setPagoCMRNormal(0l);
				plcuaEntity.setTarjetasBancariasVISA(0l);
				plcuaEntity.setSucursal(Long.valueOf(sucursal));
				plcuaEntity.setFechatrx(fechaNegocio);
				plcuaEntity.setActivacionGiftCardCMR(0l);
				plcuaEntity.setAnulacionesActGiftcardCMR(0l);
				plcuaEntity.setActivacionesGiftCardCorporativa(0l);
				plcuaEntity.setAnulacionesGiftCardCorporativa(0l);
				plcuaEntity.setTarjetaGiftCardCMR(0l);
				plcuaEntity.setTarjetaGiftCardCorporativa(0l);
				plcuaEntity.setNcrGiftCardCMR(0l);
				plcuaEntity.setNcrGiftCardCorporativa(0l);
				plcuaEntity.setDonacionesGiftCardCMR(0l);
				plcuaEntity.setDonacionesGiftCardCorporativa(0l);
				plcuaEntity.setAvanceEfectivoCMR(0l);
				plcuaEntity.setAvanceEfectivoAnuladoCMR(0l);
				plcuaEntity.setSuperAvanceEfectivoAnuladoCMR(0l);
				plcuaEntity.setSuperAvanceEfectivoCMR(0l);
				plcuaEntity.setPagoCMRRepactado(0l);
				plcuaEntity.setPagoCMRAnulado(0l);
				plcuaEntity.setTarjetaBancariasDiners(0l);
				plcuaEntity.setTarjetasBancarias(0l);
				plcuaEntity.setDonacionCMRFalabella(0l);
				plcuaEntity.setPagoRemotoCredito(0l);
				plcuaEntity.setPagoRemotoDebito(0l);
				plcuaEntity.setNcrTv(0l);
				plcuaEntity.setTarjetaDebito(0l);
				plcuaEntity.setTarjetaDebitoECommerce(0l);

				em.getTransaction().begin();
				em.persist(plcuaEntity);
				em.getTransaction().commit();
				em.close();
				emf.close();

				return;
			}

			String linea;

			boolean cuotasDiferidasEncontradas = false;
			boolean ncrTfEncontradas = false;
			boolean cuotasNormalesEncontradas = false;
			boolean tresCCEncontradas = false;
			boolean donacionesEncontradas = false;
			boolean donacionesTarjetaCMRFalabellaEncontradas = false;
			boolean pagoCMRNormalEncontradas = false;
			boolean tarjetasBancariasVISAEncontradas = false;
			boolean activacionGiftCardCMREncontradas = false;
			boolean anulacionesActGiftcardCMREncontradas = false;
			boolean activacionesGiftCardCorporativaEncontradas = false;
			boolean anulacionesGiftCardCorporativaEncontradas = false;
			boolean tarjetaGiftCardCMREncontradas = false;
			boolean tarjetaGiftCardCorporativaEncontradas = false;
			boolean ncrGiftCardCMREncontradas = false;
			boolean ncrGiftCardCorporativaEncontradas = false;
			boolean donacionesGiftCardCMREncontradas = false;
			boolean donacionesGiftCardCorporativaEncontradas = false;
			boolean tituloDonacionesEncontrado = false;
			boolean avanceEfectivoCMREncontrado=false;
			boolean avanceEfectivoCMRAnuladoEncontrado=false;
			boolean superAvanceEfectivoCMRAnuladoEncontrado=false;
			boolean superAvanceEfectivoCMREncontrado=false;
			boolean pagoCMRRepactadoEncontrado=false;
			boolean pagoCMRAnuladoEncontrado=false;
			boolean tarjetaBancariasDinersEncontradas=false;
			boolean tarjetasBancariasEncontradas=false;
			boolean pagoRemotoCreditoEncontrado=false;
			boolean pagoRemotoDebitoEncontrado=false;	
			boolean ncrTvEncontrado=false;
			boolean tarjetaDebitoEncontrado=false;
			boolean tarjetaDebitoECommerceEncontrado=false;

			long cuotasDiferidas = 0;
			long ncrTf = 0;
			long cuotasNormales = 0;
			long tresCC = 0;
			long donaciones = 0;
			long donacionesTarjetaCMRFalabella = 0;
			long pagoCMRNormal = 0;
			long tarjetasBancariasVISA = 0;
			long activacionGiftCardCMR = 0;
			long anulacionesActGiftcardCMR = 0;
			long activacionesGiftCardCorporativa = 0;
			long anulacionesGiftCardCorporativa = 0;
			long tarjetaGiftCardCMR = 0;
			long tarjetaGiftCardCorporativa = 0;
			long ncrGiftCardCMR = 0;
			long ncrGiftCardCorporativa = 0;
			long donacionesGiftCardCMR = 0;
			long donacionesGiftCardCorporativa = 0;
			long avanceEfectivoCMR=0;
			long avanceEfectivoAnuladoCMR=0;
			long superAvanceEfectivoAnuladoCMR=0;
			long superAvanceEfectivoCMR=0;
			long pagoCMRRepactado = 0;
			long pagoCMRAnulado = 0;
			long tarjetaBancariasDiners=0;
			long tarjetasBancarias=0;
			long pagoRemotoCredito=0;
			long pagoRemotoDebito=0;
			long ncrTv=0;
			long tarjetaDebito=0;
			long tarjetaDebitoECommerce=0;

			while ((linea = br.readLine()) != null) {

				if (!cuotasDiferidasEncontradas)
					cuotasDiferidas = getMontoPorTexto(linea, "CuotasDiferidasCMR");
				if (cuotasDiferidas > 0)
					cuotasDiferidasEncontradas = true;

				if (!ncrTfEncontradas)
					ncrTf = getMontoPorTexto(linea, "NCRTF");
				if (ncrTf > 0)
					ncrTfEncontradas = true;

				if (!cuotasNormalesEncontradas)
					cuotasNormales = getMontoPorTexto(linea, "CuotasNormalesCMR");
				if (cuotasNormales > 0)
					cuotasNormalesEncontradas = true;

				if (!tresCCEncontradas)
					tresCC = getMontoPorTexto(linea, "3CC(TarjetaCMR)");
				if (tresCC > 0)
					tresCCEncontradas = true;

				if (!donacionesEncontradas)
					donaciones = getMontoPorTexto(linea, "Donaciones(*)");
				if (donaciones > 0)
					donacionesEncontradas = true;

				

				if (!tarjetasBancariasVISAEncontradas)
					tarjetasBancariasVISA = getMontoPorTexto(linea, "TarjetasBancariasVISA");
				if (tarjetasBancariasVISA > 0 || tarjetasBancariasVISA < 0)
					tarjetasBancariasVISAEncontradas = true;

				if (!donacionesTarjetaCMRFalabellaEncontradas)
					donacionesTarjetaCMRFalabella = getMontoPorTexto(linea, "TarjetaCMRFalabella");
				if (donacionesTarjetaCMRFalabella > 0)
					donacionesTarjetaCMRFalabellaEncontradas = true;

				if (!activacionGiftCardCMREncontradas)
					activacionGiftCardCMR = getMontoPorTexto(linea, "ActivacionesGiftCardCMR");
				if (activacionGiftCardCMR > 0)
					activacionGiftCardCMREncontradas = true;

				if (!anulacionesActGiftcardCMREncontradas)
					anulacionesActGiftcardCMR = getMontoPorTexto(linea, "AnulacionesAct.GiftCardCMR");
				if (anulacionesActGiftcardCMR > 0)
					anulacionesActGiftcardCMREncontradas = true;

				if (!activacionesGiftCardCorporativaEncontradas)
					activacionesGiftCardCorporativa = getMontoPorTexto(linea, "ActivacionesGiftCardCorporativa");
				if (activacionesGiftCardCorporativa > 0)
					activacionesGiftCardCorporativaEncontradas = true;

				if (!anulacionesGiftCardCorporativaEncontradas)
					anulacionesGiftCardCorporativa = getMontoPorTexto(linea, "AnulacionesAct.GiftCardCorpora");
				if (anulacionesGiftCardCorporativa > 0)
					anulacionesGiftCardCorporativaEncontradas = true;

				if (!tarjetaGiftCardCMREncontradas)
					tarjetaGiftCardCMR = getMontoPorTexto(linea, "TarjetaGiftCardCMR");
				if (tarjetaGiftCardCMR > 0)
					tarjetaGiftCardCMREncontradas = true;

				if (!tarjetaGiftCardCorporativaEncontradas)
					tarjetaGiftCardCorporativa = getMontoPorTexto(linea, "TarjetaGiftCardCorporativa");
				if (tarjetaGiftCardCorporativa > 0)
					tarjetaGiftCardCorporativaEncontradas = true;

				if (!ncrGiftCardCMREncontradas)
					ncrGiftCardCMR = getMontoPorTexto(linea, "NCRGiftCardCMR(*)");
				if(ncrGiftCardCMR==0) ncrGiftCardCMR = getMontoPorTexto(linea, "NCRGiftCardCMR");
				if (ncrGiftCardCMR > 0)
					ncrGiftCardCMREncontradas = true;

				if (!ncrGiftCardCorporativaEncontradas)
					ncrGiftCardCorporativa = getMontoPorTexto(linea, "NCRGiftCardCorporativa(*)");
				if(ncrGiftCardCorporativa==0) ncrGiftCardCorporativa= getMontoPorTexto(linea, "NCRGiftCardCorporativa");
				if (ncrGiftCardCorporativa > 0)
					ncrGiftCardCorporativaEncontradas = true;

				if (!tituloDonacionesEncontrado) {
					tituloDonacionesEncontrado = obtenerTituloDonacion(linea, "Donaciones(*)");
				} else {

					if (!donacionesGiftCardCMREncontradas)
						donacionesGiftCardCMR = getMontoPorTexto(linea, "GiftCardCMR");

					if (donacionesGiftCardCMR > 0)
						donacionesGiftCardCMREncontradas = true;

					if (!donacionesGiftCardCorporativaEncontradas)
						donacionesGiftCardCorporativa = getMontoPorTexto(linea, "GiftCardCorporativa");
					if (donacionesGiftCardCorporativa > 0)
						donacionesGiftCardCorporativaEncontradas = true;
					
					if (!tarjetasBancariasEncontradas)
						tarjetasBancarias = getMontoPorTexto(linea, "TarjetasBancarias");
					if (tarjetasBancarias > 0 || tarjetasBancarias < 0)
						tarjetasBancariasEncontradas = true;

				}

				
				
				if (!avanceEfectivoCMREncontrado)
					avanceEfectivoCMR = getMontoPorTexto(linea, "TotalAvances(*)");
				if (avanceEfectivoCMR > 0)
					avanceEfectivoCMREncontrado = true;
				
				
				
				if (!avanceEfectivoCMRAnuladoEncontrado)
					avanceEfectivoAnuladoCMR = getMontoPorTexto(linea, "AvancesAnulados(*)-");
				if (avanceEfectivoAnuladoCMR > 0)
					avanceEfectivoCMRAnuladoEncontrado = true;
				
				
				
				
				if (!superAvanceEfectivoCMRAnuladoEncontrado)
					superAvanceEfectivoAnuladoCMR = getMontoPorTexto(linea, "SuperAvanceAnulados(*)-");
				if (superAvanceEfectivoAnuladoCMR > 0)
					superAvanceEfectivoCMRAnuladoEncontrado = true;
				
				
				
				if (!superAvanceEfectivoCMREncontrado)
					superAvanceEfectivoCMR = getMontoPorTexto(linea, "TotalSuperAvances(*)");
				if (superAvanceEfectivoCMR > 0)
					superAvanceEfectivoCMREncontrado = true;
				
				
				if (!pagoCMRNormalEncontradas)
					pagoCMRNormal = getMontoPorTexto(linea, "PagoCMRNormal");
				if (pagoCMRNormal > 0)
					pagoCMRNormalEncontradas = true;
				
				
				if (!pagoCMRRepactadoEncontrado)
					pagoCMRRepactado = getMontoPorTexto(linea, "PagoCMRRepactado");
				if (pagoCMRRepactado > 0)
					pagoCMRRepactadoEncontrado = true;
				
				if (!pagoCMRAnuladoEncontrado)
					pagoCMRAnulado = getMontoPorTexto(linea, "PagoCMRAnulados");
				if (pagoCMRAnulado > 0 || pagoCMRAnulado<0 )
					pagoCMRAnuladoEncontrado = true;
				
				
				if (!tarjetaBancariasDinersEncontradas)
					tarjetaBancariasDiners = getMontoPorTexto(linea, "TarjetasBancariasDINERS");
				if (tarjetaBancariasDiners > 0 || tarjetaBancariasDiners < 0)
					tarjetaBancariasDinersEncontradas = true;
				
				if (!pagoRemotoCreditoEncontrado)
					pagoRemotoCredito = getMontoPorTexto(linea, "PagoRemotoCredito");
				if (pagoRemotoCredito > 0 || pagoRemotoCredito < 0)
					pagoRemotoCreditoEncontrado = true;
				
				if (!pagoRemotoDebitoEncontrado)
					pagoRemotoDebito = getMontoPorTexto(linea, "PagoRemotoDebito");
				if (pagoRemotoDebito > 0 || pagoRemotoDebito < 0)
					pagoRemotoDebitoEncontrado = true;
				
				if (!ncrTvEncontrado)
					ncrTv = getMontoPorTexto(linea, "NCRTV(*)");
				if(ncrTv==0) ncrTv= getMontoPorTexto(linea, "NCRTV");
				if (ncrTv > 0)
					ncrTvEncontrado = true;
							
				if (!tarjetaDebitoEncontrado)
					tarjetaDebito = getMontoPorTexto(linea, "TarjetasDEBITO");
				if (tarjetaDebito > 0 || tarjetaDebito < 0)
					tarjetaDebitoEncontrado = true;

				if (!tarjetaDebitoECommerceEncontrado)
					tarjetaDebitoECommerce = getMontoPorTexto(linea, "TarjetasDEBITOE-commerce");
				if (tarjetaDebitoECommerce > 0 || tarjetaDebitoECommerce < 0)
					tarjetaDebitoECommerceEncontrado = true;
				
			}
			logger.info("::readFile:: Archivo " + file + "  encontrado, se cargan los valores rescatados");
			PLCUAEntity plcuaEntity = new PLCUAEntity();
			plcuaEntity.setDonacion(donaciones);
			plcuaEntity.setCuotasDiferidas(cuotasDiferidas);
			plcuaEntity.setCuotasNormales(cuotasNormales);
			plcuaEntity.setNCRTF(ncrTf);
			plcuaEntity.setTresCC(tresCC);
			plcuaEntity.setPagoCMRNormal(pagoCMRNormal);
			plcuaEntity.setTarjetasBancariasVISA(tarjetasBancariasVISA);
			plcuaEntity.setSucursal(Long.valueOf(sucursal));
			plcuaEntity.setFechatrx(fechaNegocio);
			plcuaEntity.setDonacionCMRFalabella(donacionesTarjetaCMRFalabella);
			plcuaEntity.setActivacionGiftCardCMR(activacionGiftCardCMR);
			plcuaEntity.setAnulacionesActGiftcardCMR(anulacionesActGiftcardCMR);
			plcuaEntity.setActivacionesGiftCardCorporativa(activacionesGiftCardCorporativa);
			plcuaEntity.setAnulacionesGiftCardCorporativa(anulacionesGiftCardCorporativa);
			plcuaEntity.setTarjetaGiftCardCMR(tarjetaGiftCardCMR);
			plcuaEntity.setTarjetaGiftCardCorporativa(tarjetaGiftCardCorporativa);
			plcuaEntity.setNcrGiftCardCMR(ncrGiftCardCMR);
			plcuaEntity.setNcrGiftCardCorporativa(ncrGiftCardCorporativa);
			logger.info("Donaciones GiftCard CMR = " + donacionesGiftCardCMR);
			plcuaEntity.setDonacionesGiftCardCMR(donacionesGiftCardCMR);
			plcuaEntity.setDonacionesGiftCardCorporativa(donacionesGiftCardCorporativa);
			logger.info("Donaciones GiftCard Corporativa = " + donacionesGiftCardCorporativa);
			plcuaEntity.setAvanceEfectivoCMR(avanceEfectivoCMR);
			plcuaEntity.setAvanceEfectivoAnuladoCMR(avanceEfectivoAnuladoCMR);
			plcuaEntity.setSuperAvanceEfectivoAnuladoCMR(superAvanceEfectivoAnuladoCMR);
			plcuaEntity.setSuperAvanceEfectivoCMR(superAvanceEfectivoCMR);
			logger.info("pagoCMRRepactado = " + pagoCMRRepactado);
			plcuaEntity.setPagoCMRRepactado(pagoCMRRepactado);
			logger.info("pagoCMRAnulado = " + pagoCMRAnulado);
			plcuaEntity.setPagoCMRAnulado(pagoCMRAnulado);
			plcuaEntity.setTarjetaBancariasDiners(tarjetaBancariasDiners);
			plcuaEntity.setTarjetasBancarias(tarjetasBancarias);
			plcuaEntity.setPagoRemotoCredito(pagoRemotoCredito);
			plcuaEntity.setPagoRemotoDebito(pagoRemotoDebito);
			plcuaEntity.setNcrTv(ncrTv);
			plcuaEntity.setTarjetaDebito(tarjetaDebito);
			plcuaEntity.setTarjetaDebitoECommerce(tarjetaDebitoECommerce);
			
			em.getTransaction().begin();
			em.persist(plcuaEntity);
			em.getTransaction().commit();
			logger.info("::readFile:: Se mueve archivo " + file + " a carpeta procesados");
			FTPFileManager manager = new FTPFileManager();
			manager.subirArchivoAFTP(pathToFile, file);

			archivo.delete();
			em.close();
			emf.close();

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private long getMontoPorTexto(String linea, String busqueda) {

		String limpio = linea.trim();

		String textoSinFormato = limpio.replace(" ", "");

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
			return 0;
		}
		return 0;
	}

	private boolean obtenerTituloDonacion(String linea, String busqueda) {

		String limpio = linea.trim();

		String textoSinFormato = limpio.replace(" ", "");

		if (textoSinFormato.contains(busqueda)) {
			return true;
		} else {
			return false;
		}
	}

	private String buscarMonto(String texto, boolean encontrado) {
		StringBuilder monto = new StringBuilder();
		char[] arreglo = texto.toCharArray();
		int contador = 0;
		boolean signoMenos = false;
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

			if (c == '-' && contador == 0) {

				monto.append('-');
				signoMenos= true;

			}
			if(c=='0' && j==1 && signoMenos) {
				contador = 0;

				break;
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

	public PLCUAEntity obtenerPLACUADPorFechaYSucursal(Date fechaNegocio, String sucursal) {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		PLCUAEntity plcuaEntity = new PLCUAEntity();
		String selectQuery = "from PLCUAEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "'";
		Query query = em.createQuery(selectQuery);
		plcuaEntity = (PLCUAEntity) query.getSingleResult();

		
		
		em.close();
		emf.close();

		return plcuaEntity;
	}
}
