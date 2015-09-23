package com.rhiscom.bpm.console.client;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.rhiscom.bpm.console.client.remote.NotificationService;
import com.rhiscom.bpm.console.server.services.NotificationServiceImpl;
import com.rhiscom.bpm.console.shared.model.dto.NotificationDTO;

public class NotificationTest {

    @Test
    public void addNotification() {

	try {

	    NotificationServiceImpl service = new NotificationServiceImpl();
	    NotificationDTO notificationTO = new NotificationDTO();
	    notificationTO.setEvent("STC_ATN_INIT");
	    notificationTO.setFrom("pcaceres@rhiscom.cl");
	    notificationTO.setTo("bpm@rhiscom.cl");
	    notificationTO.setMessage("Prueba de mensaje");
	    notificationTO.setType("Event");

	    service.addNotification(notificationTO);

	} catch (Exception ex) {
	    ex.printStackTrace();
	    Assert.fail();
	}
    }

    @Test
    public void updateNotification() {

	try {
	    NotificationServiceImpl service = new NotificationServiceImpl();

	    NotificationDTO notificationTO = service.getNotificationById(new Long(1));
	    notificationTO.setEvent("STC_ATN_INIT");
	    notificationTO.setFrom("pcaceres@rhiscom.cl");
	    notificationTO.setTo("bpm@rhiscom.cl");
	    notificationTO.setMessage("Prueba de mensaje modificada por Pablo");
	    notificationTO.setType("Event");
	    notificationTO.setNotificationId((long) 2);
	    service.updateNotification(notificationTO);

	} catch (Exception ex) {
	    ex.printStackTrace();
	    Assert.fail();
	}

    }

    @Test
    public void getAllNotification() {
	NotificationServiceImpl service = new NotificationServiceImpl();
	List<NotificationDTO> list = null;
	try {
	    list = service.getAllNotification();
	} catch (Exception e) {
	    Assert.fail();
	    e.printStackTrace();
	}
	Assert.assertNotNull(list);
    }

    @Test
    public void deleteNotification() {
	NotificationService service = new NotificationServiceImpl();
	NotificationDTO notificationTO = null;
	try {
	    notificationTO = service.getNotificationById(new Long(1));
	} catch (Exception e) {
	    Assert.fail();
	    e.printStackTrace();
	}
	try {
	    service.deleteNotification(notificationTO.getNotificationId());
	    notificationTO = service.getNotificationById(new Long(1));

	} catch (Exception e) {
	    Assert.fail();
	    e.printStackTrace();
	}
    }
}
