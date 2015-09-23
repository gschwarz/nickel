package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class SuiteTestCaseLogDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String type;
    private String id;
    private String atnId;
    private Date stateDate;

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

}
