package com.rhiscom.bpm.console.client.event;

import java.io.Serializable;
import java.util.Date;

public class SuiteTestCaseEvent extends ATNEvent implements Serializable {

    private String type;
    private String id;
    private String atnId;
    private String name;
    private Date stateDate;
    private String myServerGeneratedMessage;

    public SuiteTestCaseEvent() {

    }

    public SuiteTestCaseEvent(String type, String name, String atnId, String id, Date eventDate) {
	this.type = type;
	this.id = id;
	this.atnId = atnId;
	this.stateDate = eventDate;
	this.setName(name);

    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Date getStateDate() {
	return stateDate;
    }

    public void setStateDate(Date stateDate) {
	this.stateDate = stateDate;
    }

    public String getAtnId() {
	return atnId;
    }

    public void setAtnId(String atnId) {
	this.atnId = atnId;
    }

    public String toString() {
	StringBuilder theStringBuilder = new StringBuilder(100);
	theStringBuilder.append(ServerGeneratedMessageEvent.class.getName());
	theStringBuilder.append(new char[] { ' ', '(' });
	theStringBuilder.append(myServerGeneratedMessage);
	theStringBuilder.append(')');
	return theStringBuilder.toString();
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
