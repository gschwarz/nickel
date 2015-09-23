package com.rhiscom.bpm.console.server.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.DeleteDataService;

public class DeleteDataServiceImpl extends RemoteServiceServlet implements DeleteDataService {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void deleteData(Date fecha) throws Exception {

	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	String fechaString = format1.format(fecha);

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager em = emf.createEntityManager();

	// Inicio sección archivos

	String deleteQuery = "delete from PSDEBEntity where fechaTrx <'" + fechaString + "'";
	Query query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from ARQGMEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from CRCMREntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from LDTAEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from PLCEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from PLCUAEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from PLDEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from PLDTFEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from PLGCEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from PSCREEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from PSTFPEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from PVGCEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from SCTFAEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from RSATEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from SATEntity where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	// Inicio sección Cuadraturas

	deleteQuery = "delete from CuadraturaVtaCMR where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from CuadraturaActivacionGiftCard where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from CuadraturaVentasGiftCard where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from CuadraturaAvanceSuperAvance where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from CuadraturaPagosCMR where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from CuadraturaTarjetaCredito where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from CuadraturaNotaCredito where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	deleteQuery = "delete from CuadraturaTarjetaDebito where fechaTrx <'" + fechaString + "'";
	query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();

	em.close();
    }

}
