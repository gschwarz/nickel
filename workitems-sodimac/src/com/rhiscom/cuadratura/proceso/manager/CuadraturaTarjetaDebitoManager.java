package com.rhiscom.cuadratura.proceso.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.cuadratura.files.manager.ARQDBManager;
import com.rhiscom.cuadratura.files.manager.PLACUADManager;
import com.rhiscom.cuadratura.files.manager.PLDManager;
import com.rhiscom.cuadratura.model.CuadraturaTarjetaDebitoEntity;
import com.rhiscom.cuadratura.model.PLCUAEntity;
import com.rhiscom.cuadratura.model.PSDEBEntity;

public class CuadraturaTarjetaDebitoManager {
	protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void generarCuadratura(Date fechaNegocio, String sucursal) throws Exception {

		try {
			PLACUADManager placuadManager = new PLACUADManager();
			ARQDBManager arqdbManager = new ARQDBManager();
			PLDManager pldManager = new PLDManager();

			PLCUAEntity plcuaEntity = placuadManager.obtenerPLACUADPorFechaYSucursal(fechaNegocio, sucursal);

			long tarjetaDebitoPLCUA = plcuaEntity.getTarjetaDebito() + plcuaEntity.getTarjetaDebitoECommerce();

			PSDEBEntity psdebEntity = arqdbManager.obtenerARQDBPorFechaYSucursal(fechaNegocio, sucursal);

			long totalVentasTarjetaDebitoPSDEB = psdebEntity.getTotalVentasTarjetaDebito();
			long totalVentasInternetTarjetaDebitoPSDEB = psdebEntity.getTotalVentasInternetDebito();
			long totalTarjetaDebitoPSDEB = totalVentasTarjetaDebitoPSDEB + totalVentasInternetTarjetaDebitoPSDEB;

			long diferenciaPLCUAPSDEB = tarjetaDebitoPLCUA - totalTarjetaDebitoPSDEB;

			long totalVentasInternetDebitoPLD = pldManager
					.obtenerTotalVentasInternetDebito(fechaNegocio, sucursal);
			long totalVentasTarjetaDebitoPLD = pldManager.obtenerTotalVentasDebito(fechaNegocio, sucursal);

			long totalVEntasDEbitoPLD = totalVentasInternetDebitoPLD + totalVentasTarjetaDebitoPLD;

			long diferenciaPSDEBPLD = totalTarjetaDebitoPSDEB - totalVEntasDEbitoPLD;

			/**
			 * Pago Remoto
			 */
			long pagoRemotoDebitoPLCUA = plcuaEntity.getPagoRemotoDebito();

			long totalVentasPagoRemotoDebitoPSDEB = psdebEntity.getTotalVentasPagoRemotoDebito();
			long totalAnulacionesPagoRemotoDebitoPSDEB = psdebEntity.getTotalAnulacionPagoRemotoDebito();
			long totalPagoRemotoPSDEB = totalVentasPagoRemotoDebitoPSDEB - totalAnulacionesPagoRemotoDebitoPSDEB;

			long totalVentasPagoRemotoDebitoPLD = pldManager.obtenerTotalVentasPagoRemotoDebito(fechaNegocio,
					sucursal);
			long totalAnulacionPagoRemotoDebitoPLD = pldManager.obtenerAnulacionPagoRemotoDebito(fechaNegocio,
					sucursal);
			
			long totalPagoRemotoDebitoPLD =totalVentasPagoRemotoDebitoPLD- totalAnulacionPagoRemotoDebitoPLD;
			
			
			long diferenciaPagoRemotoPLCUAPSDEB =pagoRemotoDebitoPLCUA-totalPagoRemotoPSDEB;
			long diferenciaPagoRemotoPSDEBPLD= totalPagoRemotoPSDEB- totalPagoRemotoDebitoPLD;

			// Persistencia del entity.

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();

			String deleteQuery = "delete from CuadraturaTarjetaDebitoEntity where sucursal ='" + sucursal
					+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "'";
			Query query = em.createQuery(deleteQuery);
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			CuadraturaTarjetaDebitoEntity entity = new CuadraturaTarjetaDebitoEntity();

			entity.setDiferenciaPLCUAPSDEB(diferenciaPLCUAPSDEB);
			entity.setDiferenciaPSDEBPLD(diferenciaPSDEBPLD);
			entity.setFechaTrx(fechaNegocio);
			entity.setSucursal(Long.valueOf(sucursal));
			entity.setTotalTarjetaDebitoPSDEB(totalTarjetaDebitoPSDEB);
			entity.setTotalVEntasDEbitoPLD(totalVEntasDEbitoPLD);
			entity.setTotalVentasInternetDebitoPLD(totalVentasInternetDebitoPLD);
			entity.setTotalVentasInternetTarjetaDebitoPSDEB(totalVentasInternetTarjetaDebitoPSDEB);
			entity.setTotalVentasTarjetaDebitoPLD(totalVentasTarjetaDebitoPLD);
			entity.setTotalVentasTarjetaDebitoPSDEB(totalVentasTarjetaDebitoPSDEB);
			entity.setPagoRemotoDebitoPLCUA(pagoRemotoDebitoPLCUA);
			entity.setTotalAnulacionesPagoRemotoDebitoPSDEB(totalAnulacionesPagoRemotoDebitoPSDEB);
			entity.setTotalPagoRemotoPSDEB(totalPagoRemotoPSDEB);
			entity.setTotalVentasPagoRemotoDebitoPLD(totalVentasPagoRemotoDebitoPLD);
			entity.setTotalAnulacionPagoRemotoDebitoPLD(totalAnulacionPagoRemotoDebitoPLD);
			entity.setTotalVentasPagoRemotoDebitoPSDEB(totalVentasPagoRemotoDebitoPSDEB);
			entity.setDiferenciaPagoRemotoPLCUAPSDEB(diferenciaPagoRemotoPLCUAPSDEB);
			entity.setDiferenciaPagoRemotoPSDEBPLD(diferenciaPagoRemotoPSDEBPLD);
			entity.setTarjetaDebitoPLCUA(tarjetaDebitoPLCUA);
			entity.setTotalPagoRemotoDebitoPLD(totalPagoRemotoDebitoPLD);

			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			em.close();
			emf.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}
}
