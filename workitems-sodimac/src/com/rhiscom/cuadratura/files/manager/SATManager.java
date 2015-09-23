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
import com.rhiscom.cuadratura.model.SATEntity;

public class SATManager extends BaseManager {
	private final static Logger logger = Logger.getLogger(LDTAManager.class.getName());

	public void readFile(Date fechaNegocio, String sucursal) {
		try {

			String pathToFile = FILE_DIRECTORY + "SATx" + readerFormatter.format(fechaNegocio) + ".SAT";
			String file = "SATx" + readerFormatter.format(fechaNegocio) + ".SAT";

			// String file =
			// "C:\\Proyectos\\Cuadraturas Sodimac\\1000880120130107.RSAT";

			File archivo = new File(pathToFile);
			FileReader fr;
			BufferedReader br = null;

			String linea;

			fr = new FileReader(archivo);

			br = new BufferedReader(fr);
			int i = 0;
			
			
			
			SATEntity entity = new SATEntity();

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();

			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from SATEntity where  fechaTrx='" + formatter2.format(fechaNegocio) + "'";
			logger.info(deleteQuery);
			Query query = em.createQuery(deleteQuery);

			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();
			
			

			while ((linea = br.readLine()) != null) {
				if (i != 0) {

					String codigoEntidad = linea.substring(0, 4);
					String codigoPais = linea.substring(4, 7);
					String codigoDeMerchant = linea.substring(7, 22);
					String codigoDeFuncion = linea.substring(22, 26);
					String origenTrx = linea.substring(26, 28);
					String fecha = linea.substring(28, 36);
					String hora = linea.substring(36, 42);
					//sucursal leida.
					String local = linea.substring(42, 46);
					String estructuraMerchant = linea.substring(46, 62);
					String caja = linea.substring(62, 78);
					String secuenciaTerminal = linea.substring(78, 86);
					String codigoAutorizacionTrxPrevia = linea.substring(86, 98);
					String modalidad = linea.substring(98, 99);
					String numeroDeLote = linea.substring(99, 109);
					String codigoActividad = linea.substring(109, 111);
					String identificadorCreditoDebito = linea.substring(113, 114);
					String indicador = linea.substring(114, 115);
					String indentificadorAdquiriente = linea.substring(115, 122);
					String referenciaOperacion = linea.substring(123, 146);
					String indicadorCuotas = linea.substring(146, 147);
					String numeroTarjeta = linea.substring(147, 169);
					String tipoDocumentoIdentificacion = linea.substring(169, 171);
					String numeroDocumentoIdentificacion = linea.substring(171, 191);
					String tipoMoneda = linea.substring(191, 194);
					String factorCambioMoneda = linea.substring(194, 203);
					String modoDePago = linea.substring(203, 204);
					String plazoPagoDiferido = linea.substring(204, 206);
					String montoTransaccion1 = linea.substring(207, 221);
					String montoTransaccion2 = linea.substring(221, 240);
					String montoTransaccion3 = linea.substring(240, 257);
					String montoTransaccion4 = linea.substring(257, 274);
					String montoTransaccion5 = linea.substring(274, 291);
					String numeroCuotas = linea.substring(291, 294);
					String importeDeLaCuota = linea.substring(294, 305);
					String importePropina = linea.substring(305, 316);
					String importeDescuento = linea.substring(316, 327);
					String tasaInteres = linea.substring(327, 334);
					String importeAbono = linea.substring(334, 345);
					String tipoDocumentoVenta = linea.substring(345, 346);
					String numeroDocumentoVenta = linea.substring(346, 358);
					String vendedor = linea.substring(358, 366);
					String codigoConvenio = linea.substring(366, 374);
					String modoCapturaPin = linea.substring(430, 431);
					String indicadorComprasMultiples = linea.substring(431, 432);
					String codigoOCuenta = linea.substring(432, 452);
					String numeroPlazaCheque = linea.substring(532, 536);
					String numeroDelCheque = linea.substring(536, 538);
					String codigoBancoCheque = linea.substring(358, 544);
					String rutCheque = linea.substring(548, 568);
					String fechaContable = linea.substring(568, 576);
					String codigoAutorizacion = linea.substring(576, 588);
					String fechaArchivoNegativo = linea.substring(588, 596);
					String numeroDelNegativo = linea.substring(596, 604);
					String volumen = linea.substring(604, 610);
					String modoDeOperar = linea.substring(610, 612);
					String fechaProcesoArchivo = linea.substring(612, 620);
					String codigoRespuesta = linea.substring(620, 623);
					String fechaLiquidacion = linea.substring(623, 631);
					String terminalRemesado = linea.substring(631, 647);
					String identificacionDeOperacion = linea.substring(647, 697);
					String codigoRespuestaInterna = linea.substring(697, 700);
					String montoImpuesto = linea.substring(700, 711);
					String baseDelImpuesto = linea.substring(713, 726);
					
					entity = new SATEntity();
					entity.setBaseDelImpuesto(baseDelImpuesto);
					entity.setCaja(caja);
					entity.setCodigoActividad(codigoActividad);
					entity.setCodigoAutorizacion(codigoAutorizacion);
					entity.setCodigoAutorizacionTrxPrevia(codigoAutorizacionTrxPrevia);
					entity.setCodigoBancoCheque(codigoBancoCheque);
					entity.setCodigoConvenio(codigoConvenio);
					entity.setCodigoDeMerchant(codigoDeMerchant);
					entity.setCodigoEntidad(codigoEntidad);
					entity.setCodigoOCuenta(codigoOCuenta);
					entity.setCodigoPais(codigoPais);
					entity.setCodigoRespuestaInterna(codigoRespuestaInterna);
					entity.setEstructuraMerchant(estructuraMerchant);
					entity.setFactorCambioMoneda(factorCambioMoneda);
					entity.setFechaArchivoNegativo(fechaArchivoNegativo);
					entity.setFechaContable(fechaContable);
					entity.setFechaLiquidacion(fechaLiquidacion);
					entity.setFechaProcesoArchivo(fechaProcesoArchivo);
					entity.setFechaTrx(fechaNegocio);
					entity.setHora(hora);
					entity.setIdentificacionDeOperacion(identificacionDeOperacion);
					entity.setIdentificadorCreditoDebito(identificadorCreditoDebito);
					entity.setImporteAbono(importeAbono);
					entity.setImporteDeLaCuota(importeDeLaCuota);
					entity.setImporteDescuento(importeDescuento);
					entity.setImportePropina(importePropina);
					entity.setIndentificadorAdquiriente(indentificadorAdquiriente);
					entity.setIndicador(indicadorComprasMultiples);
					entity.setIndicadorComprasMultiples(indicadorComprasMultiples);
					entity.setIndicadorCuotas(indicadorCuotas);
					entity.setModalidad(modalidad);
					entity.setModoCapturaPin(modoCapturaPin);
					entity.setModoDeOperar(modoDeOperar);
					entity.setMontoImpuesto(montoImpuesto);
					
					if (montoTransaccion1.trim().length() > 0) {
						entity.setMontoTransaccion1(Long.parseLong(montoTransaccion1.trim()));
						entity.setLocal(Long.parseLong(local));
						entity.setCodigoRespuesta(codigoRespuesta);
						entity.setFecha(fechaNegocio);
						entity.setCodigoDeFuncion(codigoDeFuncion);
				
					em.getTransaction().begin();
					em.persist(entity);
					em.getTransaction().commit();
					}

				}
				i++;
			}
			
			logger.info("::readFile:: Se mueve archivo "+file+" a carpeta procesados");
			FTPFileManager manager = new FTPFileManager();
			manager.subirArchivoAFTP(pathToFile, file);
			em.close();
			emf.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long obtenerMontoFuncion217Y238(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(montoTransaccion1) from SATEntity where local ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and codigoDeFuncion='0217' and codigoDeFuncion='0238'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerMontoFuncion217Y238:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}

	public long obtenerMontoFuncion402Y401(Date fechaNegocio, String sucursal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(montoTransaccion1) from SATEntity where local ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and codigoDeFuncion='0402' and codigoDeFuncion='0401'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerMontoFuncion402Y401:: resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}

	public long obtenerTransaccionesPorCodigo(String sucursal, Date fechaNegocio, String codigo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String selectQuery = "select sum(montoTransaccion1) from SATEntity where local ='" + sucursal
				+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "' and codigoDeFuncion='"+codigo+"'";
		Query query = em.createQuery(selectQuery);
		Long result = (Long) query.getSingleResult();
		logger.info("::obtenerTransaccionesPorCodigo:: "+ codigo +" resultado " + result);
		
		if (result == null)
			return 0l;
	
		em.close();
		emf.close();

		return result;
	}

}
