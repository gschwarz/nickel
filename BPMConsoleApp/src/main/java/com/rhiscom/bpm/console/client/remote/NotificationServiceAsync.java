package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.NotificationDTO;

public interface NotificationServiceAsync {

    public void addNotification(NotificationDTO notificationTO, AsyncCallback callback);

    public void updateNotification(NotificationDTO notificationTO, AsyncCallback callback) throws Exception;

    public void getAllNotification(AsyncCallback<List<NotificationDTO>> callback) throws Exception;

    public void getNotificationById(Long id, AsyncCallback<NotificationDTO> callback) throws Exception;

    public void deleteNotification(Long notificationId, AsyncCallback callback) throws Exception;

}
