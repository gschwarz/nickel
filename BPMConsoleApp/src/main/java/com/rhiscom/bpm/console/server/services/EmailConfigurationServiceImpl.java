package com.rhiscom.bpm.console.server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.EmailConfigurationService;
import com.rhiscom.bpm.console.server.model.entity.EmailConfiguration;
import com.rhiscom.bpm.console.server.model.entity.RecipientsByEvent;
import com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO;
import com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO;

public class EmailConfigurationServiceImpl extends RemoteServiceServlet implements EmailConfigurationService {
    /**
     * 
     */
    private static final Logger logger = Logger.getLogger(EmailConfigurationServiceImpl.class.getName());
    private static final long serialVersionUID = 1L;

    @Override
    public void saveOrUpdateConfiguration(EmailConfigurationDTO dto) {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EmailConfiguration configuration = new EmailConfiguration(dto.getEmailConfigurationId(), dto.getEmailPort(),
		dto.getEmailServer(), dto.getPassword(), dto.getSenderEmail());

	try {
	    logger.info("::[saveOrUpdateConfiguration]::" + configuration);
	    entityManager.getTransaction().begin();
	    entityManager.merge(configuration);
	    entityManager.getTransaction().commit();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[saveOrUpdateConfiguration]:: Error :" + ex);

	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public EmailConfigurationDTO getConfiguration() throws Exception {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	List<EmailConfiguration> resultList = null;
	List<EmailConfigurationDTO> emailDTOresultList = null;
	try {

	    Query query = entityManager.createQuery("SELECT mail FROM EmailConfiguration mail");
	    resultList = query.getResultList();

	} catch (NoResultException ne) {
	    ne.printStackTrace();
	    throw new Exception("NO_EXISTE");
	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new Exception("ERROR_PERSISTENCIA :" + ex.toString());
	}
	if (resultList.size() > 0) {
	    logger.info("::[getConfiguration]::Resultado configuracion " + resultList);
	    emailDTOresultList = new ArrayList<EmailConfigurationDTO>();
	    EmailConfigurationDTO emailConfigurationDTO = new EmailConfigurationDTO();
	    for (int i = 0; i <= resultList.size() - 1; i++) {
		emailConfigurationDTO = new EmailConfigurationDTO(resultList.get(i).getEmailConfigurationId(),
			resultList.get(i).getEmailPort(), resultList.get(i).getEmailServer(), resultList.get(i)
				.getPassword(), resultList.get(i).getSenderEmail());

		emailDTOresultList.add(emailConfigurationDTO);
	    }
	    return emailDTOresultList.get(0);

	} else {
	    logger.info("::[getConfiguration]: Retornando NULL");
	    return null;
	}

    }

    @Override
    public void saveOrUpdateRecipients(List<RecipientsByEventDTO> recipientsList) {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	for (int i = 0; i <= recipientsList.size() - 1; i++) {
	    RecipientsByEventDTO dto = recipientsList.get(i);
	    RecipientsByEvent recipients = new RecipientsByEvent(dto.getRecipientsId(), dto.getEvent(),
		    dto.getRecipients());

	    try {
		logger.info("::[saveOrUpdateRecipients]::" + recipients);
		entityManager.getTransaction().begin();
		entityManager.merge(recipients);
		entityManager.getTransaction().commit();
	    } catch (Exception ex) {
		logger.log(Level.SEVERE, "::[saveOrUpdateRecipients]:: Error :" + ex);

	    }
	}
    }

    @Override
    public RecipientsByEventDTO getRecipientByEvent(String event) {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	Query query = entityManager
		.createQuery("SELECT rep FROM RecipientsByEvent rep where rep.event='" + event + "'");
	List<RecipientsByEvent> resultList = query.getResultList();
	if (resultList.size() > 0) {

	    RecipientsByEventDTO result = new RecipientsByEventDTO(resultList.get(0).getRecipientsId(), resultList.get(
		    0).getRecipients(), resultList.get(0).getEvent());
	    return result;
	} else
	    return null;
    }
}
