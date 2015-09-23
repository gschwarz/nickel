package com.rhiscom.bpm.console.server.services.dao;

import javax.persistence.EntityManager;

import com.rhiscom.bpm.console.server.model.entity.CoreCase;
import com.rhiscom.bpm.console.shared.model.dto.CoreCaseDTO;

public class CoreCaseDAOImpl implements CoreCaseDAO {
    private EntityManager em;

    public CoreCaseDAOImpl(EntityManager entityManager) {
	em = entityManager;

    }

    @Override
    public void addOrUpdateCoreCase(CoreCaseDTO dto) {
	CoreCase core = new CoreCase(dto.getId(), dto.getEstado(), dto.getFechaGeneracion(), dto.getFechaGeneracion(),
		dto.getFechaUltimaModificacion(), dto.getIdProceso(), dto.getLocal(), dto.getNombre(), dto.getOrigen());
	try {
	    em.getTransaction().begin();
	    em.persist(core);
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}
