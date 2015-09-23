package com.rhiscom.cuadratura.proceso.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.cuadratura.files.manager.PLACUADManager;
import com.rhiscom.cuadratura.files.manager.PLGCManager;
import com.rhiscom.cuadratura.model.CuadraturaActivacionGiftCardEntity;
import com.rhiscom.cuadratura.model.PLCUAEntity;

public class CuadraturaActivacionGiftCardManager {

	protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void generarCuadratura(Date fechaNegocio, String sucursal) throws Exception {

		try {
			PLACUADManager placuadManager = new PLACUADManager();
			PLGCManager plgcManager = new PLGCManager();

			PLCUAEntity plcuaEntity = placuadManager.obtenerPLACUADPorFechaYSucursal(fechaNegocio, sucursal);
			long activacionGiftCardCMR = plcuaEntity.getActivacionGiftCardCMR();
			long anulacionGiftCardCMR = plcuaEntity.getAnulacionesActGiftcardCMR();
			;
			long activacionGiftCardCorporativa = plcuaEntity.getActivacionesGiftCardCorporativa();
			long anulacionGiftCardCorporativa = plcuaEntity.getAnulacionesGiftCardCorporativa();

			long totalGiftCMR = plcuaEntity.getActivacionGiftCardCMR()
					- plcuaEntity.getAnulacionesActGiftcardCMR();
			long totalGiftCorporativa = plcuaEntity.getActivacionesGiftCardCorporativa()
					- plcuaEntity.getAnulacionesGiftCardCorporativa();
			long totalGiftCard = totalGiftCMR + totalGiftCorporativa;

			long totalActGiftCMR = plgcManager.obtenerMontoSegunCodigoGiftYFuncion("5", "55", sucursal,
					fechaNegocio);

			long totalACCGiftCMR = plgcManager.obtenerMontoSegunCodigoGiftYFuncion("5", "58", sucursal,
					fechaNegocio);

			long totalGiftCMR2 = totalActGiftCMR - totalACCGiftCMR;

			long totalActGiftCorporativa = plgcManager.obtenerMontoSegunCodigoGiftYFuncion("3", "55", sucursal,
					fechaNegocio);

			long totalACCGiftCorporativa = plgcManager.obtenerMontoSegunCodigoGiftYFuncion("3", "58", sucursal,
					fechaNegocio);

			long totalGiftCorporativa2 = totalActGiftCorporativa - totalACCGiftCorporativa;

			long totalGiftCard2 = totalGiftCMR2 + totalGiftCorporativa2;

			long diferenciaPlaCuadConPLGC = totalGiftCard - totalGiftCard2;

			CuadraturaActivacionGiftCardEntity entity = new CuadraturaActivacionGiftCardEntity();

			entity.setActivacionGiftCardCMR(activacionGiftCardCMR);
			entity.setAnulacionGiftCardCMR(anulacionGiftCardCMR);
			entity.setActivacionGiftCardCorporativa(activacionGiftCardCorporativa);
			entity.setAnulacionGiftCardCorporativa(anulacionGiftCardCorporativa);
			entity.setTotalGiftCMR(totalGiftCMR);
			entity.setTotalGiftCorporativa(totalGiftCorporativa);
			entity.setTotalGiftCard(totalGiftCard);
			entity.setDiferenciaPlaCuadConPLGC(diferenciaPlaCuadConPLGC);
			entity.setTotalACCGiftCMR(totalACCGiftCMR);
			entity.setTotalACCGiftCorporativa(totalACCGiftCorporativa);
			entity.setTotalActGiftCMR(totalActGiftCMR);
			entity.setTotalActGiftCorporativa(totalActGiftCorporativa);
			entity.setTotalGiftCard2(totalGiftCard2);
			entity.setTotalGiftCMR2(totalGiftCMR2);
			entity.setTotalGiftCorporativa2(totalGiftCorporativa2);

			entity.setSucursal(Long.valueOf(sucursal));
			entity.setFechaTrx(fechaNegocio);

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();

			String deleteQuery = "delete from CuadraturaActivacionGiftCardEntity where sucursal ='" + sucursal
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
			throw new Exception(ex.getMessage());
		}

	}
}
