package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class RecipientsByEventDTO implements Serializable {

    private Long recipientsId;
    private String event;
    private String recipients;

    public RecipientsByEventDTO(Long recipientsId2, String recipients2, String event2) {
	recipientsId = recipientsId2;
	recipients = recipients2;
	event = event2;
    }

    public RecipientsByEventDTO() {

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

    public Long getRecipientsId() {
	return recipientsId;
    }

    public void setRecipientsId(Long recipientsId) {
	this.recipientsId = recipientsId;
    }

}
