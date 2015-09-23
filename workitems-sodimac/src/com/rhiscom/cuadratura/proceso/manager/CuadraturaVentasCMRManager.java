package com.rhiscom.cuadratura.proceso.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.cuadratura.files.manager.ARQTFManager;
import com.rhiscom.cuadratura.files.manager.LDTAManager;
import com.rhiscom.cuadratura.files.manager.PLACUADManager;
import com.rhiscom.cuadratura.files.manager.PLDTFManager;
import com.rhiscom.cuadratura.files.manager.RSATManager;
import com.rhiscom.cuadratura.files.manager.SATManager;
import com.rhiscom.cuadratura.files.manager.VtaCMRManager;
import com.rhiscom.cuadratura.model.CuadraturaVtaCMREntity;
import com.rhiscom.cuadratura.model.PLCUAEntity;
import com.rhiscom.cuadratura.model.SCTFAEntity;

public class CuadraturaVentasCMRManager {
	protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void generarCuadratura(Date fechaNegocio, String sucursal) throws Exception {

		try {
			System.out.println("Cuadratura Ventas CMR");
			System.out.println(fechaNegocio);
			System.out.println(sucursal);
			CuadraturaVtaCMREntity entity = new CuadraturaVtaCMREntity();

			PLACUADManager placuadManager = new PLACUADManager();
			ARQTFManager arqtfManager = new ARQTFManager();
			VtaCMRManager vtaCMRManager = new VtaCMRManager();
			PLDTFManager pldtfManager = new PLDTFManager();
			LDTAManager ldtaManager = new LDTAManager();
			
			SATManager satManager = new SATManager();
			RSATManager rsatManager = new RSATManager();


			PLCUAEntity plcuaEntity = placuadManager.obtenerPLACUADPorFechaYSucursal(fechaNegocio, sucursal);

			SCTFAEntity sctfaEntity = arqtfManager.obtenerARQTFPorFechaYSucursal(fechaNegocio, sucursal);

			// Total Final PLACUAD
			long totalFinalPlaCuad = plcuaEntity.getCuotasNormales() + plcuaEntity.getCuotasDiferidas()
					+ plcuaEntity.getTresCC() + plcuaEntity.getDonacionCMRFalabella() - plcuaEntity.getNCRTF();
			// TOTAL FINAL ARQTF
			long totalfinalARQTF = sctfaEntity.getGranTotalVentas()
					+ sctfaEntity.getGranTotalRecaudaciones()
					- (sctfaEntity.getGranTotalDevolucionesCMRNCA() + sctfaEntity.getGranTotalDevolucionesCMRNCR() + sctfaEntity
							.getGranTotalAnulacionGiftCard());
			// Diferencia entre Total Final de PLCUA y total Final SCTFA o
			// ARQTF;
			long diferenciaPlaCuadSctfa = totalFinalPlaCuad - totalfinalARQTF;

			// Diferencias entre transacciones 200 y 400 para CRCMR;

			long transacciones200 = vtaCMRManager.totalTrx200(fechaNegocio, sucursal);
			long transacciones400 = vtaCMRManager.totalTrx400(fechaNegocio, sucursal);
			// Total final de CRCMR
			long totalFinalCRCMRTrx = transacciones200 - transacciones400;

			// Diferencia entre CRMCMR y TOTAL FINAL SCTFA o ARQTF
			long diferenciaTRXCRCMRConSctfa = totalfinalARQTF - totalFinalCRCMRTrx;

			// Diferencia entre CRMC con PLACUAD
			long diferenciaCRCMRConPlaCuad = totalFinalPlaCuad - totalFinalCRCMRTrx;

			// PLDTF o suma de Campo AbonoCMR
			long totalMontoAbonoCMR = pldtfManager.getTotalMontoAbonoCMRPLDTF(fechaNegocio, sucursal);
			long granTotalDevolucionCMRNCR = sctfaEntity.getGranTotalDevolucionesCMRNCR();
			long plaCuadncrTf = plcuaEntity.getNCRTF();

			long diferenciaNCRTFconTotalMontoAbonoCMR = totalMontoAbonoCMR - plaCuadncrTf;
			long diferenciaPLDTFconGranTotalDevolucionCMRNCR = totalMontoAbonoCMR - granTotalDevolucionCMRNCR;

			long totalTFldta = ldtaManager.getTotalMontoTF(fechaNegocio, sucursal);

			long ncaTFsctfa = sctfaEntity.getGranTotalDevolucionesCMRNCA();

			long diferenciaNcaTFConGranTotalDevolucionNCASctfa = ncaTFsctfa
					- sctfaEntity.getGranTotalDevolucionesCMRNCA();

			long ldtaDonacionNCATF = 0;

			if (diferenciaNcaTFConGranTotalDevolucionNCASctfa < 100) {
				ldtaDonacionNCATF = diferenciaNcaTFConGranTotalDevolucionNCASctfa;
			}

			
			
			long totalTrx200SAT = satManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0200");
			long totalTrx400SAT = satManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0400");
			long totalFinalSAT = totalTrx200SAT-totalTrx400SAT;
			
			
			
			long totalTrx200RSAT = rsatManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0200");
			long totalTrx400RSAT = rsatManager.obtenerTransaccionesPorCodigo(sucursal, fechaNegocio, "0400");
			long totalFinalRSAT = totalTrx200RSAT-totalTrx400RSAT;
			
			long diferenciaSATCRCMR = totalFinalCRCMRTrx- totalFinalSAT;
			long diferenciaRSATCRCMR = totalFinalCRCMRTrx- totalFinalRSAT;
			
			entity.setTotalTrx200RSAT(totalTrx200RSAT);
			entity.setTotalTrx200SAT(totalTrx200SAT);
			entity.setTotalFinalSAT(totalFinalSAT);
			
			entity.setTotalTrx400RSAT(totalTrx400RSAT);
			entity.setTotalTrx400SAT(totalTrx400SAT);
			entity.setTotalFinalRSAT(totalFinalRSAT);
			
			entity.setDiferenciaRSATCRCMR(diferenciaRSATCRCMR);
			entity.setDiferenciaSATCRCMR(diferenciaSATCRCMR);
			
			
			entity.setCuotasDiferidas(plcuaEntity.getCuotasDiferidas());
			entity.setPlacuadNCR(plcuaEntity.getNCRTF());
			entity.setCuotasNormales(plcuaEntity.getCuotasNormales());
			entity.setTresCC(plcuaEntity.getTresCC());
			entity.setDonacionCMR(plcuaEntity.getDonacionCMRFalabella());
			entity.setNcrTFTotal(plcuaEntity.getNCRTF());
			entity.setLdtaDonacion(ldtaDonacionNCATF);

			entity.setGranTotalAnulacionGiftcard(sctfaEntity.getGranTotalAnulacionGiftCard());
			entity.setGranTotalDevolucionesCMRNCA(sctfaEntity.getGranTotalDevolucionesCMRNCA());
			entity.setGranTotalDevolucionesCMRNCR(sctfaEntity.getGranTotalDevolucionesCMRNCR());
			entity.setGranTotalRecaudaciones(sctfaEntity.getGranTotalRecaudaciones());
			entity.setGranTotalVentas(sctfaEntity.getGranTotalVentas());

			// Persisto el total Final de PLACUAD
			entity.setTotalFinalPlaCuad(totalFinalPlaCuad);
			// Persisto el total final de ARQTF o SCTFA
			entity.setTotalFinalARQTF(totalfinalARQTF);

			// Persisto la diferencia de Ambos.
			entity.setDiferenciaPlaCuadARQTF(diferenciaPlaCuadSctfa);

			entity.setTransacciones200(transacciones200);
			entity.setTransacciones400(transacciones400);

			// Persisto el total final de VtaCMR o CRCMR
			entity.setTotalFinalTRX(totalFinalCRCMRTrx);

			// Persisto la diferencia entre VtaCRM con ARQTF o SCTFA
			entity.setDiferenciaVtaCRMConARQTF(diferenciaTRXCRCMRConSctfa);
			// Persisto la diferencia entre VtaCRM con PlaCuad
			entity.setDiferenciaPlaCuadConVtaCMR(diferenciaCRCMRConPlaCuad);
			entity.setPldtf(totalMontoAbonoCMR);
			entity.setGranTotalDevolucionesCMRNCR(granTotalDevolucionCMRNCR);
			entity.setNcrTFTotal(plaCuadncrTf);
			entity.setDiferenciaPldtfNCRConArqTFNCR(diferenciaPLDTFconGranTotalDevolucionCMRNCR);
			entity.setDiferenciaPlaCuadNCRConArqTFNCR(diferenciaNCRTFconTotalMontoAbonoCMR);
			entity.setLdta(totalTFldta);
			entity.setArqTFDonacion(ncaTFsctfa);
			entity.setDiferenciaLdtaConArqTFDonacion(diferenciaNcaTFConGranTotalDevolucionNCASctfa);
			entity.setArqTFNCR(sctfaEntity.getGranTotalDevolucionesCMRNCR());
			entity.setFechaTrx(fechaNegocio);
			entity.setSucursal(Long.valueOf(sucursal));

			

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();

			String deleteQuery = "delete from CuadraturaVtaCMREntity where sucursal ='" + sucursal
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
			//ex.printStackTrace();
			//throw new Exception(ex.getMessage());
		}
	}

}
