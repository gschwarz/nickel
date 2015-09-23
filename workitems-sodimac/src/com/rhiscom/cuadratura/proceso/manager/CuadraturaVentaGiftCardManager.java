package com.rhiscom.cuadratura.proceso.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.cuadratura.files.manager.PLACUADManager;
import com.rhiscom.cuadratura.files.manager.PVGCManager;
import com.rhiscom.cuadratura.model.CuadraturaVentasGiftCardEntity;
import com.rhiscom.cuadratura.model.PLCUAEntity;

public class CuadraturaVentaGiftCardManager {
	protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void generarCuadratura(Date fechaNegocio, String sucursal) throws Exception {
		
		try {
		PLACUADManager placuadManager = new PLACUADManager();
		PVGCManager pvgcManager= new PVGCManager();;
		
		PLCUAEntity plcuaEntity = placuadManager.obtenerPLACUADPorFechaYSucursal(fechaNegocio, sucursal);
		
		long ventasGiftCardCMR = plcuaEntity.getTarjetaGiftCardCMR();
		long donacionesGiftCMR = plcuaEntity.getDonacionesGiftCardCMR();
		long ncrGiftCMR = plcuaEntity.getNcrGiftCardCMR();
		
		long totalPlaCuadCMR = ventasGiftCardCMR + donacionesGiftCMR- ncrGiftCMR;
		
		long ventasGiftCorporativa = plcuaEntity.getTarjetaGiftCardCorporativa();
		long donacionesGiftCorporativa = plcuaEntity.getDonacionesGiftCardCorporativa();
		long ncrGiftCorporativa = plcuaEntity.getNcrGiftCardCorporativa();
		
		long totalPlaCuaCorporativa = ventasGiftCorporativa + donacionesGiftCorporativa- ncrGiftCorporativa;
		
		/**
		 * GiftCard CMR
		 */
		long ventasGiftCMRPVGC = pvgcManager.traerMontoPorTipoGift("5", fechaNegocio, sucursal);
		long totalVentasGiftCMRDonacionPVGC = pvgcManager.traerTotalDonacionPorTipoGift("5", fechaNegocio,sucursal);
		//Total 1;
		long totalVentasGiftCardCMRPVGC = ventasGiftCMRPVGC+ totalVentasGiftCMRDonacionPVGC;
		
		
		long totalAnulacionesNCAGiftCMR = pvgcManager.traerMontoPorTipoGiftCodFuncion30TipoDocNCA("5", fechaNegocio, sucursal);
		long totalAnulacionesNCAGiftCMRDonacion = pvgcManager.traerTotalDonacionPorTipoGiftCodFuncion30TipoDocNCA("5", fechaNegocio,sucursal);
		long anulacionesVtaNCAGiftCMR = totalAnulacionesNCAGiftCMR+ totalAnulacionesNCAGiftCMRDonacion;
		
		long totalAnulacionesNCRGiftCMR =  pvgcManager.traerMontoPorTipoGiftCodFuncion30TipoDocNCR("5", fechaNegocio, sucursal);
		//Total 2
		long totalVentasGiftCMRPVGC = totalVentasGiftCardCMRPVGC - anulacionesVtaNCAGiftCMR - totalAnulacionesNCRGiftCMR;
		/**
		 * GiftCard Corporativa
		 */
		
		
		long totalVentasGiftCorporativaPVGC=pvgcManager.traerMontoPorTipoGift("3", fechaNegocio, sucursal);
		long totalVentasGiftCorporativaDonacionPVGC=pvgcManager.traerTotalDonacionPorTipoGift("3", fechaNegocio,sucursal);
		long totalVentasGiftCorporativa= totalVentasGiftCorporativaPVGC + totalVentasGiftCorporativaDonacionPVGC;
		
		long totalAnulacionesNCAGiftCorporativa =pvgcManager.traerMontoPorTipoGiftCodFuncion30TipoDocNCA("3", fechaNegocio, sucursal);
		long totalAnulacionesNCAGiftCorporativaDonacion= pvgcManager.traerTotalDonacionPorTipoGiftCodFuncion30TipoDocNCA("3", fechaNegocio,sucursal);
		long anulacionesVtaNCAGifCorporativa=totalAnulacionesNCAGiftCorporativa + totalAnulacionesNCAGiftCorporativaDonacion;
		
		long totalAnulacionesNCRGiftCorporativa= pvgcManager.traerTotalMontoPorTipoGiftCodFuncion30TipoDocNCR("3", fechaNegocio,sucursal);
		long totalGifCorporativa=totalVentasGiftCorporativa - anulacionesVtaNCAGifCorporativa - totalAnulacionesNCRGiftCorporativa;
		
		long sumatoriaPlcua =totalPlaCuadCMR + totalPlaCuaCorporativa;
		long sumatoriaMpvgc=totalVentasGiftCMRPVGC + totalGifCorporativa;
		long diferenciaPlacuadMpvgc=sumatoriaPlcua - sumatoriaMpvgc;
		
		/**
		 * Persistencia de los datos de cuadratura
		 */
		
		CuadraturaVentasGiftCardEntity entity= new CuadraturaVentasGiftCardEntity();
		entity.setSucursal(Long.valueOf(sucursal));
		entity.setFechaTrx(fechaNegocio);
		entity.setDonacionesGiftCMR(donacionesGiftCMR);
		entity.setDonacionesGiftCorporativa(donacionesGiftCorporativa);
		entity.setNcrGiftCMR(ncrGiftCMR);
		entity.setNcrGiftCorporativa(ncrGiftCorporativa);
		entity.setTotalPlaCuaCorporativa(totalPlaCuaCorporativa);
		entity.setTotalPlaCuadCMR(totalPlaCuadCMR);
		entity.setVentasGiftCardCMR(ventasGiftCardCMR);
		entity.setVentasGiftCorporativa(ventasGiftCorporativa);
		entity.setTotalVentasGiftCardCMRPVGC(totalVentasGiftCardCMRPVGC);
		entity.setAnulacionesVtaNCAGiftCMR(anulacionesVtaNCAGiftCMR);
		entity.setTotalAnulacionesNCRGiftCMR(totalAnulacionesNCRGiftCMR);
		entity.setTotalVentasGiftCMRPVGC(totalVentasGiftCMRPVGC);
		entity.setTotalVentasGiftCorporativa(totalVentasGiftCorporativa);
		entity.setAnulacionesVtaNCAGifCorporativa(anulacionesVtaNCAGifCorporativa);
		entity.setTotalAnulacionesNCRGiftCorporativa(totalAnulacionesNCRGiftCorporativa);
		entity.setTotalGifCorporativa(totalGifCorporativa);
		entity.setSumatoriaPlcua(sumatoriaPlcua);
		entity.setDiferenciaPlacuadMpvgc(diferenciaPlacuadMpvgc);
		entity.setSumatoriaMpvgc(sumatoriaMpvgc);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String deleteQuery = "delete from CuadraturaVentasGiftCardEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "'";
		Query query = em.createQuery(deleteQuery);
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		
		
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		}
		catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
		
	}

}
