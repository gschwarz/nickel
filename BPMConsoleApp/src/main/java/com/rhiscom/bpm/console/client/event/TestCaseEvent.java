package com.rhiscom.bpm.console.client.event;

import java.io.Serializable;
import java.util.Date;

public class TestCaseEvent extends ATNEvent implements Serializable {
    private String type;
    private int id;
    private String stcId;
    private String atnId;
    private Date stateDate;
    private Date endDate;
    private String name;
    private String state;

    public TestCaseEvent() {

    }

    public TestCaseEvent(String type, String name, String atnId2, int id2, String stcId2, Date eventDate,
	    String state) {
	this.type = type;
	this.setId(id2);
	this.atnId = atnId2;
	this.stcId = stcId2;
	this.stateDate = eventDate;
	this.setName(name);
	this.state = state;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getStcId() {
	return stcId;
    }

    public void setStcId(String stcId) {
	this.stcId = stcId;
    }

    public String getAtnId() {
	return atnId;
    }

    public void setAtnId(String atnId) {
	this.atnId = atnId;
    }

    public Date getStateDate() {
	return stateDate;
    }

    public void setStateDate(Date stateDate) {
	this.stateDate = stateDate;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

}
