package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pa_recipients_by_event")
public class RecipientsByEvent {
    @Id
    @GeneratedValue
    @Column(name = "recipientsId")
    private Long recipientsId;

    private String event;
    private String recipients;

    public RecipientsByEvent(Long recipientsId2, String event2, String recipients2) {
	recipientsId = recipientsId2;
	event = event2;
	recipients = recipients2;
    }

    public RecipientsByEvent() {

    }

    public Long getRecipientsId() {
	return recipientsId;
    }

    public void setRecipientsId(Long recipientsId) {
	this.recipientsId = recipientsId;
    }

    public String getEvent() {
	return event;
    }

    public void setEvent(String event) {
	this.event = event;
    }

    public String getRecipients() {
	return recipients;
    }

    public void setRecipients(String recipients) {
	this.recipients = recipients;
    }

}
