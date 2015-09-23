package com.rhiscom.bpm.console.client.event;

import java.io.Serializable;
import java.util.Date;

public class HttpEventATN implements Serializable {

    private static final long serialVersionUID = 1L;
    private String type;
    private String atnId;
    private Date eventDate;
    private String code;
    private String name;

    public HttpEventATN(String eventType, String name, String atnId2, Date dateTime, String message2) {
	this.type = eventType;
	this.atnId = atnId2;
	this.eventDate = dateTime;
	this.setCode(message2);
	this.name = name;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getAtnId() {
	return atnId;
    }

    public void setAtnId(String atnId) {
	this.atnId = atnId;
    }

    public Date getEventDate() {
	return eventDate;
    }

    public void setEventDate(Date eventDate) {
	this.eventDate = eventDate;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
