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
import com.rhiscom.cuadratura.model.CuadraturaNotaCreditoEntity;

public class CuadraturaNotaDeCreditoManager {
	protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void generarCuadratura(Date fechaNegocio, String sucursal) throws Exception {
		try {
			PLACUADManager placuadManager = new PLACUADManager();
			ARQTVManager arqTVManager = new ARQTVManager();
			PLCManager plcManager = new PLCManager();

			long ncrTvPLCUa = placuadManager.obtenerPLACUADPorFechaYSucursal(fechaNegocio, sucursal).getNcrTv();

			long totalAnulacionesNCRPSCRE = arqTVManager.obtenerPSCREPorFechaYSucursal(fechaNegocio, sucursal)
					.getTotalAnulacionesNCR();

			long diferenciaPLACUAPSCRE = ncrTvPLCUa - totalAnulacionesNCRPSCRE;

			long totalAnulacionesNCRPLC = plcManager.obtenerTotalAnulacionesNCR(fechaNegocio, sucursal);

			long diferenciaPSCREPLC = totalAnulacionesNCRPSCRE - totalAnulacionesNCRPLC;

			// Persistencia del entity.

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();

			String deleteQuery = "delete from CuadraturaNotaCreditoEntity where sucursal ='" + sucursal
					+ "' and fechaTrx='" + formatter2.format(fechaNegocio) + "'";
			Query query = em.createQuery(deleteQuery);
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			CuadraturaNotaCreditoEntity entity = new CuadraturaNotaCreditoEntity();

			entity.setDiferenciaPLACUAPSCRE(diferenciaPLACUAPSCRE);
			entity.setDiferenciaPSCREPLC(diferenciaPSCREPLC);
			entity.setNcrTvPLCUa(ncrTvPLCUa);
			entity.setTotalAnulacionesNCRPLC(totalAnulacionesNCRPLC);
			entity.setTotalAnulacionesNCRPSCRE(totalAnulacionesNCRPSCRE);
			entity.setSucursal(Long.valueOf(sucursal));
			entity.setFechaTrx(fechaNegocio);

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
