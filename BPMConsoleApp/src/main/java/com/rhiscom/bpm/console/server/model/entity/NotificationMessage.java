package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "pa_notification")
public class NotificationMessage extends BaseValue {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "notificationId")
    private long notificationId;

    @Column(name = "notificationTo")
    private String to;

    @Column(name = "notificationFrom")
    private String from;

    @Column(name = "notificationMessage")
    private String notificationMessage;

    @Column(name = "notificationType")
    private String notificationType;

    @Column(name = "notificationEvent")
    private String notificationEvent;

    public NotificationMessage() {

    }

    public NotificationMessage(String to2, String from2, String message2, String type2, String event2) {

	this.to = to2;
	this.from = from2;
	this.notificationMessage = message2;
	this.notificationType = type2;
	this.notificationEvent = event2;
    }

    public NotificationMessage(Long notificationId2, String to2, String from2, String message, String type, String event) {
	this.notificationId = notificationId2;
	this.to = to2;
	this.from = from2;
	this.notificationMessage = message;
	this.notificationType = type;
	this.notificationEvent = event;
    }

    public String getNotificationMessage() {
	return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
	this.notificationMessage = notificationMessage;
    }

    public String getNotificationType() {
	return notificationType;
    }

    public void setNotificationType(String notificationType) {
	this.notificationType = notificationType;
    }

    public String getNotificationEvent() {
	return notificationEvent;
    }

    public void setNotificationEvent(String notificationEvent) {
	this.notificationEvent = notificationEvent;
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

}
