package com.rhiscom.cuadratura.proceso.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.cuadratura.files.manager.ARQTVManager;
import com.rhiscom.cuadratura.files.manager.PLACUADManager;
import com.rhiscom.cuadratura.files.manager.PLCManager;
import com.rhiscom.cuadratura.model.CuadraturaTarjetaDeCreditoEntity;
import com.rhiscom.cuadratura.model.PLCUAEntity;
import com.rhiscom.cuadratura.model.PSCREEntity;

public class CuadraturaTarjetaCreditoManager {
	protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void generarCuadratura(Date fechaNegocio, String sucursal) throws Exception {
		
		try {
		PLACUADManager placuadManager = new PLACUADManager();
		ARQTVManager arqTVManager = new ARQTVManager();
		PLCManager plcManager = new PLCManager();
		
		PLCUAEntity plcuaEntity = placuadManager.obtenerPLACUADPorFechaYSucursal(fechaNegocio, sucursal);
		PSCREEntity psCreEntity = arqTVManager.obtenerPSCREPorFechaYSucursal(fechaNegocio, sucursal);
		
		/**PLCUA**/
		long tarjetaBancariaVisa = plcuaEntity.getTarjetasBancariasVISA();
		long tarjetaBancariaDiners =plcuaEntity.getTarjetaBancariasDiners();
		long donaciones= plcuaEntity.getTarjetasBancarias();
		
		long totalPLCUA = tarjetaBancariaVisa+ tarjetaBancariaDiners+donaciones;
		
		/**ARQ_TV**/
		
		long totalVentasTarjetaCreditoPSCRE = psCreEntity.getTotalVentasTarjetaCredito();
		long totalVentasInternetCreditoPSCRE = psCreEntity.getTotalVentasInternetCredito();
		long recaudacionesPSCRE = psCreEntity.getTotalRecaudaciones();		
		long totalVentasAnulacionesPSCRE= psCreEntity.getTotalAnulacionesNCA();
		long anulacionRecaudacionesPSCRE = psCreEntity.getTotalAnulacionesRecaudacion();
		
		long totalPSCRE = totalVentasTarjetaCreditoPSCRE+totalVentasInternetCreditoPSCRE+donaciones
				-(totalVentasAnulacionesPSCRE+anulacionRecaudacionesPSCRE);
		
		/** PLC	 */
		long totalVentasTarjetaCreditoPLC=plcManager.obtenerTotalVentasTarjetaCredito(fechaNegocio, sucursal);
		long donacionesPLC = plcManager.obtenerTotalDonacionesVentasTarjetaCredito(fechaNegocio, sucursal);
		totalVentasTarjetaCreditoPLC = totalVentasTarjetaCreditoPLC + donacionesPLC;
		long totalVentasInternetCreditoPLC =plcManager.obtenerVentasInternetCredito(fechaNegocio, sucursal);
		long totalAnulacionesNCAPLC=plcManager.obtenerTotalAnulacionesNCA(fechaNegocio, sucursal);
		long totalRecaudacionesPLC=plcManager.obtenerTotalRecaudaciones(fechaNegocio, sucursal);
		long totalAnulacionRecaudacionesPLC = plcManager.obtenerTotalAnulacionesRecaudaciones(fechaNegocio, sucursal);
		
		
		
		long totalPLC = totalVentasTarjetaCreditoPLC+totalVentasInternetCreditoPLC - 
				(totalAnulacionesNCAPLC+totalAnulacionRecaudacionesPLC);
		
		long diferenciaPLCUAPSCRE = totalPLCUA -totalPSCRE;
		long diferenciaPSCREPLC = totalPSCRE-totalPLC;
		
		/**
		 * Pago Remoto
		 */
		
		long pagoRemotoCreditoPLCUA = plcuaEntity.getPagoRemotoCredito();
		
		long pagoRemotoCreditoPSCRE = psCreEntity.getTotalPagoRemotoCredito();
		long totalAnulacionesPagoRemoto = psCreEntity.getTotalAnulacionPagoRemotoCredito();
		
		long totalPagoRemotoPSCRE = pagoRemotoCreditoPSCRE- totalAnulacionesPagoRemoto;
		
		long totalVentasPagoRemotoCreditoPLC = plcManager.obtenerMontoPagoRemotoCredito(fechaNegocio, sucursal);
		long totalAnulacionesPagoRemotoCreditoPLC = plcManager.obtenerMontoPagoRemotoAnulaciones(fechaNegocio, sucursal);
		
		long totalPagoRemotoPLC = totalVentasPagoRemotoCreditoPLC- totalAnulacionesPagoRemotoCreditoPLC;
		
		long diferenciaPagoRemotoPLCUAPSCRE= pagoRemotoCreditoPLCUA - totalPagoRemotoPSCRE;
		long diferenciaPagoRemotoPSCREPLC = totalPagoRemotoPSCRE-totalPagoRemotoPLC;
				
		
		// Persistencia del entity.
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		String deleteQuery = "delete from CuadraturaTarjetaDeCreditoEntity where sucursal ='" + sucursal + "' and fechaTrx='"
				+ formatter2.format(fechaNegocio) + "'";
		Query query = em.createQuery(deleteQuery);
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		
		CuadraturaTarjetaDeCreditoEntity entity = new CuadraturaTarjetaDeCreditoEntity();
		
		entity.setAnulacionRecaudacionesPSCRE(anulacionRecaudacionesPSCRE);
		entity.setDiferenciaPLCUAPSCRE(diferenciaPLCUAPSCRE);
		entity.setDiferenciaPSCREPLC(diferenciaPSCREPLC);
		entity.setDonaciones(donaciones);
		entity.setFechaTrx(fechaNegocio);
		entity.setRecaudacionesPSCRE(recaudacionesPSCRE);
		entity.setSucursal(Long.valueOf(sucursal));
		entity.setTarjetaBancariaDiners(tarjetaBancariaDiners);
		entity.setTarjetaBancariaVisa(tarjetaBancariaVisa);
		entity.setTotalAnulacionesNCAPLC(totalAnulacionesNCAPLC);
		entity.setTotalAnulacionRecaudacionesPLC(totalAnulacionRecaudacionesPLC);
		entity.setTotalPLC(totalPLC);
		entity.setTotalPLCUA(totalPLCUA);
		entity.setTotalPSCRE(totalPSCRE);
		entity.setTotalRecaudacionesPLC(totalRecaudacionesPLC);
		entity.setTotalVentasAnulacionesPSCRE(totalVentasAnulacionesPSCRE);
		entity.setTotalVentasInternetCreditoPLC(totalVentasInternetCreditoPLC);
		entity.setTotalVentasInternetCreditoPSCRE(totalVentasInternetCreditoPSCRE);
		entity.setTotalVentasTarjetaCreditoPLC(totalVentasTarjetaCreditoPLC);
		entity.setTotalVentasTarjetaCreditoPSCRE(totalVentasTarjetaCreditoPSCRE);
		
		entity.setPagoRemotoCreditoPLCUA(pagoRemotoCreditoPLCUA);
		entity.setPagoRemotoCreditoPSCRE(pagoRemotoCreditoPSCRE);
		entity.setTotalPagoRemotoPSCRE(totalPagoRemotoPSCRE);
		entity.setTotalAnulacionesPagoRemoto(totalAnulacionesPagoRemoto);
		entity.setTotalAnulacionesPagoRemotoCreditoPLC(totalAnulacionesPagoRemotoCreditoPLC);
		entity.setTotalVentasPagoRemotoCreditoPLC(totalVentasPagoRemotoCreditoPLC);
		entity.setTotalPagoRemotoPLC(totalPagoRemotoPLC);
		
		entity.setDiferenciaPagoRemotoPLCUAPSCRE(diferenciaPagoRemotoPLCUAPSCRE);
		entity.setDiferenciaPagoRemotoPSCREPLC(diferenciaPagoRemotoPSCREPLC);
		
		
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		
	}
}
