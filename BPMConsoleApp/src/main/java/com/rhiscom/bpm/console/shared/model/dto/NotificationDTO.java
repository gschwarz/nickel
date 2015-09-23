package com.rhiscom.bpm.console.shared.model.dto;

public class NotificationDTO {

    private Long notificationId;

    private String to;

    private String from;

    private String message;

    private String type;

    private String event;

    public NotificationDTO(Long notificationId2, String to2, String from2, String notificationEvent, String notificationType, String notificationMessage) {
	this.notificationId = notificationId2;
	this.from = from2;
	this.to = to2;
	this.event = notificationEvent;
	this.type = notificationType;
	this.message = notificationMessage;
    }

    public NotificationDTO() {
	// TODO Auto-generated constructor stub
    }

    public Long getNotificationId() {
	return notificationId;
    }

    public void setNotificationId(Long notificationId) {
	this.notificationId = notificationId;
    }

    public String getTo() {
	return to;
    }

    public void setTo(String to) {
	this.to = to;
    }

    public String getFrom() {
	return from;
    }

    public void setFrom(String from) {
	this.from = from;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getEvent() {
	return event;
    }

    public void setEvent(String event) {
	this.event = event;
    }

}
