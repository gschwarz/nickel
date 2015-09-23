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
import com.rhiscom.cuadratura.model.CuadraturaAvanceSuperAvanceEntity;
import com.rhiscom.cuadratura.model.PLCUAEntity;
import com.rhiscom.cuadratura.model.SCTFAEntity;

public class CuadraturaAvanceSuperAvanceManager {
	protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void generarCuadratura(Date fechaNegocio, String sucursal) throws Exception {

		try {
			PLACUADManager placuadManager = new PLACUADManager();
			ARQTFManager argtfManager = new ARQTFManager();
			VtaCMRManager vtaCMRManager = new VtaCMRManager();

			
			SCTFAEntity sctfaEntity = argtfManager.obtenerARQTFPorFechaYSucursal(fechaNegocio, sucursal);
			
			SATManager satManager = new SATManager();
			RSATManager rsatManager = new RSATManager();
			PLCUAEntity plcuaEntity = placuadManager.obtenerPLACUADPorFechaYSucursal(fechaNegocio, sucursal);
			
			/**
			 * PLCUA
			 */
			long totalAvanceCMR = plcuaEntity.getAvanceEfectivoCMR();
			long totalAnulacionesAvanceCMR = plcuaEntity.getAvanceEfectivoAnuladoCMR();
			long totalAvance = totalAvanceCMR - totalAnulacionesAvanceCMR;

			long totalSuperAvanceCMR = plcuaEntity.getSuperAvanceEfectivoCMR();
			long totalAnulacionesSuperAvanceCMR = plcuaEntity.getSuperAvanceEfectivoAnuladoCMR();
			long totalSuperAvance = totalSuperAvanceCMR - totalAnulacionesSuperAvanceCMR;

			/**
			 * SCTFA
			 */
			long totalAvanceCMRARQTF = sctfaEntity.getTotalAvanceEfectivo();
			long totalAnulacionesAvanceCMRARQTF = sctfaEntity.getTotalAnulacionesAvanceEfectivo();
			long totalAvanceARQTF = totalAvanceCMRARQTF - totalAnulacionesAvanceCMRARQTF;

			long totalSuperAvanceCMRARQTF = sctfaEntity.getTotalSuperAvanceEfectivo();
			long totalAnulacionesSuperAvanceCMRARQTF = sctfaEntity.getTotalAnulacionesSuperAvance();
			long totalSuperAvanceARQTF = totalSuperAvanceCMRARQTF - totalAnulacionesSuperAvanceCMRARQTF;

			/**
			 * CRCMR
			 */
			long totalAvanceCMRCRCMR = vtaCMRManager.totalTrx220(fechaNegocio, sucursal);
			long totalAvanceAnuladosCMRCRCMR = vtaCMRManager.totalTrx403(fechaNegocio, sucursal);
			long totalAvanceCRCMR = totalAvanceCMRCRCMR - totalAvanceAnuladosCMRCRCMR;

			long totalSuperAvanceCMRCRCMR = vtaCMRManager.totalTrx274(fechaNegocio, sucursal);
			long totalAnulacionesSuperAvanceCRCMR = vtaCMRManager.totalTrx473(fechaNegocio, sucursal);
			long totalSuperAvanceCRCMR = totalSuperAvanceCMRCRCMR - totalAnulacionesSuperAvanceCRCMR;

			/**
			 * DIFERENCIAS
			 */
			long diferenciaAvancePLCUACRCMR = totalAvance - totalAvanceCRCMR;
			long diferenciaSuperAvancePLCUACRCMR = totalSuperAvance - totalSuperAvanceCRCMR;

			long diferenciaAvanceSCTFACRCMR = totalAvanceARQTF - totalAvanceCRCMR;
			long diferenciaSuperAvanceSCTFACRCMR = totalSuperAvanceARQTF - totalSuperAvanceCRCMR;

			long diferenciaAvancePLCUASCTFA = totalAvance - totalAvanceARQTF;
			long diferenciaSuperAvancePLCUASCTFA = totalSuperAvance - totalSuperAvanceARQTF;
			
			
			/**
			 * Avance SAT RSAT
			 */
			long totalTrx220SAT = satManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0220");
			long totalTrx403SAT = satManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0403");
			long totalAvanceFinalSAT = totalTrx220SAT-totalTrx403SAT;
			
			
			
			long totalTrx220RSAT = rsatManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0220");
			long totalTrx403RSAT = rsatManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0403");
			long totalAvanceFinalRSAT = totalTrx220RSAT-totalTrx403RSAT;
			
			long diferenciaSATCRCMRAvance = totalAvanceCRCMR- totalAvanceFinalSAT;
			long diferenciaRSATCRCMRAvance = totalAvanceCRCMR- totalAvanceFinalRSAT;
			
			
			/**
			 * SuperAvance SAT RSAT
			 */
			long totalTrx274SAT = satManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0274");
			long totalTrx473SAT = satManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0473");
			long totalSuperAvanceFinalSAT = totalTrx274SAT-totalTrx473SAT;
			
			
			
			long totalTrx274RSAT = rsatManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0274");
			long totalTrx473RSAT = rsatManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0473");
			long totalSuperAvanceFinalRSAT = totalTrx274RSAT-totalTrx473RSAT;
			
			long diferenciaSATCRCMRSuperAvance = totalSuperAvanceCRCMR- totalSuperAvanceFinalSAT;
			long diferenciaRSATCRCMRSuperAvance = totalSuperAvanceCRCMR- totalSuperAvanceFinalRSAT;
			
			
			/**
			 * Persistencia de la cuadratura
			 */
			CuadraturaAvanceSuperAvanceEntity entity = new CuadraturaAvanceSuperAvanceEntity();
			
			
			
			entity.setTotalTrx220RSAT(totalTrx220RSAT);
			entity.setTotalTrx220SAT(totalTrx220SAT);
			
			entity.setTotalTrx274SAT(totalTrx274SAT);
			entity.setTotalTrx274RSAT(totalTrx274RSAT);
			
			entity.setTotalTrx403RSAT(totalTrx403RSAT);
			entity.setTotalTrx403SAT(totalTrx403SAT);
			
			entity.setTotalTrx473RSAT(totalTrx473RSAT);
			entity.setTotalTrx473SAT(totalTrx473SAT);
			
			entity.setTotalAvanceFinalRSAT(totalAvanceFinalRSAT);
			entity.setTotalAvanceFinalSAT(totalAvanceFinalSAT);
			
			entity.setTotalSuperAvanceFinalSAT(totalSuperAvanceFinalSAT);
			entity.setTotalSuperAvanceFinalRSAT(totalSuperAvanceFinalRSAT);
			
			entity.setDiferenciaRSATCRCMRAvance(diferenciaRSATCRCMRAvance);
			entity.setDiferenciaSATCRCMRAvance(diferenciaSATCRCMRAvance);
			
			entity.setDiferenciaSATCRCMRSuperAvance(diferenciaSATCRCMRSuperAvance);
			entity.setDiferenciaRSATCRCMRSuperAvance(diferenciaRSATCRCMRSuperAvance);
			
			
			
			entity.setTotalAnulacionesAvanceCMR(totalAnulacionesAvanceCMR);
			entity.setTotalAvance(totalAvance);
			entity.setTotalAvanceCMR(totalAvanceCMR);
			entity.setSucursal(sucursal);
			entity.setFechaTrx(fechaNegocio);
			entity.setTotalAnulacionesSuperAvanceCMR(totalAnulacionesSuperAvanceCMR);
			entity.setTotalSuperavance(totalSuperAvance);
			entity.setTotalSuperAvanceCMR(totalSuperAvanceCMR);
			entity.setTotalAnulacionesAvanceCMRARQTF(totalAnulacionesAvanceCMRARQTF);
			entity.setTotalAvanceCMRARQTF(totalAvanceCMRARQTF);
			entity.setTotalAvanceCMRARQTF(totalAvanceCMRARQTF);
			entity.setTotalAvanceARQTF(totalAvanceARQTF);
			entity.setTotalSuperAvanceCMRARQTF(totalSuperAvanceCMRARQTF);
			entity.setTotalAnulacionesSuperAvanceCMRARQTF(totalAnulacionesSuperAvanceCMRARQTF);
			entity.setTotalSuperAvanceARQTF(totalSuperAvanceARQTF);
			entity.setTotalAvanceCMRCRCMR(totalAvanceCMRCRCMR);
			entity.setTotalAvanceAnuladosCMRCRCMR(totalAvanceAnuladosCMRCRCMR);
			entity.setTotalAvanceCRCMR(totalAvanceCRCMR);
			entity.setTotalSuperAvanceCMRCRCMR(totalSuperAvanceCMRCRCMR);
			entity.setTotalAnulacionesSuperAvanceCRCMR(totalAnulacionesSuperAvanceCRCMR);
			entity.setTotalSuperAvanceCRCMR(totalSuperAvanceCRCMR);

			entity.setDiferenciaAvancePLCUACRCMR(diferenciaAvancePLCUACRCMR);
			entity.setDiferenciaAvancePLCUASCTFA(diferenciaAvancePLCUASCTFA);
			entity.setDiferenciaAvanceSCTFACRCMR(diferenciaAvanceSCTFACRCMR);
			entity.setDiferenciaSuperAvancePLCUACRCMR(diferenciaSuperAvancePLCUACRCMR);
			entity.setDiferenciaSuperAvancePLCUASCTFA(diferenciaSuperAvancePLCUASCTFA);
			entity.setDiferenciaSuperAvanceSCTFACRCMR(diferenciaSuperAvanceSCTFACRCMR);

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();

			String deleteQuery = "delete from CuadraturaAvanceSuperAvanceEntity where sucursal ='" + sucursal
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
