package com.rhiscom.bpm.console.server.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.NotificationService;
import com.rhiscom.bpm.console.server.model.entity.NotificationMessage;
import com.rhiscom.bpm.console.shared.model.dto.NotificationDTO;

public class NotificationServiceImpl extends RemoteServiceServlet implements NotificationService {

    private static final long serialVersionUID = 1L;

    @Override
    public void addNotification(NotificationDTO notificationTO) throws Exception {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	NotificationMessage notificationMessage = new NotificationMessage(notificationTO.getTo(),
		notificationTO.getFrom(), notificationTO.getMessage(), notificationTO.getType(),
		notificationTO.getEvent());

	try {

	    entityManager.getTransaction().begin();
	    entityManager.persist(notificationMessage);
	    entityManager.getTransaction().commit();

	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();

	    throw new Exception("PERSISTENCE");

	} catch (Exception ex) {
	    ex.printStackTrace();

	} finally {

	}
    }

    @Override
    public NotificationDTO getNotificationById(Long id) {
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	NotificationDTO result = null;
	try {
	    NotificationMessage notificationMessage = entityManager.find(NotificationMessage.class, id);

	    result = new NotificationDTO(notificationMessage.getNotificationId(), notificationMessage.getTo(),
		    notificationMessage.getFrom(), notificationMessage.getNotificationEvent(),
		    notificationMessage.getNotificationType(), notificationMessage.getNotificationMessage());

	} catch (Exception ex) {
	    return null;
	}

	return result;
    }

    @Override
    public void updateNotification(NotificationDTO notificationTO) throws Exception {
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	NotificationMessage notificationMessage = new NotificationMessage(notificationTO.getNotificationId(),
		notificationTO.getTo(), notificationTO.getFrom(), notificationTO.getMessage(),
		notificationTO.getType(), notificationTO.getEvent());

	try {

	    entityManager.getTransaction().begin();
	    entityManager.merge(notificationMessage);
	    entityManager.getTransaction().commit();

	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();

	    throw new Exception("PERSISTENCE");

	} catch (Exception ex) {
	    ex.printStackTrace();

	} finally {

	}

    }

    @Override
    public List<NotificationDTO> getAllNotification() throws Exception {
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	List<NotificationMessage> resultList = null;
	List<NotificationDTO> notificationDTOList = null;
	try {

	    Query query = entityManager.createQuery("SELECT notif FROM NotificationMessage notif");
	    resultList = query.getResultList();

	} catch (NoResultException ne) {
	    ne.printStackTrace();
	    throw new Exception("NO_EXISTE");
	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new Exception("ERROR_PERSISTENCIA :" + ex.toString());
	} finally {

	}

	if (resultList != null) {

	    notificationDTOList = new ArrayList<NotificationDTO>();
	    NotificationDTO notification = new NotificationDTO();
	    for (int i = 0; i <= resultList.size() - 1; i++) {
		notification = new NotificationDTO(resultList.get(i).getNotificationId(), resultList.get(i).getTo(),
			resultList.get(i).getFrom(), resultList.get(i).getNotificationEvent(), resultList.get(i)
				.getNotificationType(), resultList.get(i).getNotificationMessage());
		notificationDTOList.add(notification);
	    }

	}
	return notificationDTOList;

    }

    @Override
    public void deleteNotification(Long notificationId) throws Exception {
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	try {

	    entityManager.getTransaction().begin();
	    NotificationMessage not = entityManager.find(NotificationMessage.class, notificationId);
	    entityManager.remove(entityManager.merge(not));
	    entityManager.getTransaction().commit();

	} catch (Exception ne) {
	    ne.printStackTrace();
	    throw new Exception("NO_EXISTE");
	}
    }
}
