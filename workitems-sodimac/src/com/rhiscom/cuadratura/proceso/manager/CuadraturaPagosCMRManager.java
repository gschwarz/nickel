package com.rhiscom.cuadratura.proceso.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.cuadratura.files.manager.ARQTFManager;
import com.rhiscom.cuadratura.files.manager.PLACUADManager;
import com.rhiscom.cuadratura.files.manager.RSATManager;
import com.rhiscom.cuadratura.files.manager.SATManager;
import com.rhiscom.cuadratura.files.manager.VtaCMRManager;
import com.rhiscom.cuadratura.model.CuadraturaPagosCMREntity;
import com.rhiscom.cuadratura.model.PLCUAEntity;
import com.rhiscom.cuadratura.model.SCTFAEntity;

public class CuadraturaPagosCMRManager {
	protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void generarCuadratura(Date fechaNegocio, String sucursal) throws Exception {

		try {
			PLACUADManager placuadManager = new PLACUADManager();
			ARQTFManager arqtfManager = new ARQTFManager();
			VtaCMRManager vtaCMRManager = new VtaCMRManager();
			SATManager satManager = new SATManager();
			RSATManager rsatManager = new RSATManager();

			PLCUAEntity plcuaEntity = placuadManager.obtenerPLACUADPorFechaYSucursal(fechaNegocio, sucursal);
			SCTFAEntity sctfaEntity = arqtfManager.obtenerARQTFPorFechaYSucursal(fechaNegocio, sucursal);

			long pagoNormal = plcuaEntity.getPagoCMRNormal();
			long pagoRepactado = plcuaEntity.getPagoCMRRepactado();
			long pagoAnulado = plcuaEntity.getPagoCMRAnulado();

			long totalPagos = pagoNormal + pagoRepactado + pagoAnulado;

			long totalAbonos = sctfaEntity.getTotalAbonos();
			long totalAbonosCMRRepactacion = sctfaEntity.getTotalAbonoRepactacion();
			long totalAnulacionAbonoNormal = sctfaEntity.getTotalAnulacionAbonoNormal();
			long totalAnulacionAbonoRepactacion = sctfaEntity.getTotalAnulacionAbonoRepactacion();

			long totalPagosSctfa = totalAbonos + totalAbonosCMRRepactacion
					- (totalAnulacionAbonoNormal + totalAnulacionAbonoRepactacion);

			long diferenciaPLACUASCTFA = totalPagos - totalPagosSctfa;

			long trx217 = vtaCMRManager.totalTrx217(fechaNegocio, sucursal);
			long trx238 = vtaCMRManager.totalTrx238(fechaNegocio, sucursal);

			trx217 = trx217 + trx238;

			long trx402 = vtaCMRManager.totalTrx402(fechaNegocio, sucursal);
			long trx401 = vtaCMRManager.totalTrx401(fechaNegocio, sucursal);

			trx402 = trx402 + trx401;

			long totalCRCMR = trx217 - trx402;
			long diferenciaPLCUACRCMR = totalPagos - totalCRCMR;
			long diferenciaSCTFACRCMR = totalPagosSctfa - totalCRCMR;

			/**
			 * SAT
			 */

			long totalPagosSAT = satManager.obtenerMontoFuncion217Y238(fechaNegocio, sucursal);
			long totalAnulacionesSAT = satManager.obtenerMontoFuncion402Y401(fechaNegocio, sucursal);
			long totalFinalPagosSAT = totalPagosSAT - totalAnulacionesSAT;

			/**
			 * RSAT
			 */

			long totalPagosRSAT = rsatManager.obtenerMontoFuncion217Y238(fechaNegocio, sucursal);
			long totalAnulacionesRSAT = rsatManager.obtenerMontoFuncion402Y401(fechaNegocio, sucursal);
			long totalFinalPagosRSAT = totalPagosRSAT - totalAnulacionesRSAT;

			long diferenciaRSATCRCMR = totalCRCMR - totalFinalPagosRSAT;
			long diferenciaSATCRCMR = totalCRCMR - totalFinalPagosSAT;

			/**
			 * Persistencia Entity
			 */
			CuadraturaPagosCMREntity entity = new CuadraturaPagosCMREntity();

			entity.setDiferenciaPLACUASCTFA(diferenciaPLACUASCTFA);
			entity.setPagoAnulado(pagoAnulado);
			entity.setPagoNormal(pagoNormal);
			entity.setPagoRepactado(pagoRepactado);
			entity.setTotalAbonos(totalAbonos);
			entity.setTotalAbonosCMRRepactacion(totalAbonosCMRRepactacion);
			entity.setTotalAnulacionAbonoNormal(totalAnulacionAbonoNormal);
			entity.setTotalAnulacionAbonoRepactacion(totalAnulacionAbonoRepactacion);
			entity.setTotalPagos(totalPagos);
			entity.setTotalPagosSctfa(totalPagosSctfa);
			entity.setSucursal(Long.valueOf(sucursal));
			entity.setFechaTrx(fechaNegocio);
			entity.setTrx217(trx217);
			entity.setTrx402(trx402);
			entity.setTotalCRCMR(totalCRCMR);
			entity.setDiferenciaPLCUACRCMR(diferenciaPLCUACRCMR);
			entity.setDiferenciaSCTFACRCMR(diferenciaSCTFACRCMR);

			entity.setTotalPagosSAT(totalPagosSAT);
			entity.setTotalAnulacionesSAT(totalAnulacionesSAT);
			entity.setTotalFinalPagosSAT(totalFinalPagosSAT);

			entity.setTotalPagosRSAT(totalPagosRSAT);
			entity.setTotalAnulacionesRSAT(totalAnulacionesRSAT);
			entity.setTotalFinalPagosRSAT(totalFinalPagosRSAT);

			entity.setDiferenciaRSATCRCMR(diferenciaRSATCRCMR);
			entity.setDiferenciaSATCRCMR(diferenciaSATCRCMR);

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();

			String deleteQuery = "delete from CuadraturaPagosCMREntity where sucursal ='" + sucursal
					+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "'";
			Query query = em.createQuery(deleteQuery);
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();

			em.close();
			emf.close();
		} catch (Exception ex) {
			//throw new Exception(ex.getMessage());
		}

	}
}
