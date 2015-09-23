package com.rhiscom.bpm.console.server.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.DespachoDomicilioService;
import com.rhiscom.bpm.console.server.services.dao.DespachoDomicilioDAOImpl;
import com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO;

public class DespachoDomicilioServiceImpl extends RemoteServiceServlet implements DespachoDomicilioService {

    private static final long serialVersionUID = 1L;

    @Override
    public VentaDomicilioDTO traerVentaPorId(long idVenta) throws Exception {
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	DespachoDomicilioDAOImpl despachoDAO = new DespachoDomicilioDAOImpl(entityManager);

	return despachoDAO.traerVentaPorId(idVenta);

    }

}
