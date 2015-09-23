package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.dto.NotificationDTO;

@RemoteServiceRelativePath("notificationService")
public interface NotificationService extends RemoteService {

    void addNotification(NotificationDTO notificationTO) throws Exception;

    void updateNotification(NotificationDTO notificationTO) throws Exception;

    List<NotificationDTO> getAllNotification() throws Exception;

    NotificationDTO getNotificationById(Long id) throws Exception;

    void deleteNotification(Long notificationId) throws Exception;

}
