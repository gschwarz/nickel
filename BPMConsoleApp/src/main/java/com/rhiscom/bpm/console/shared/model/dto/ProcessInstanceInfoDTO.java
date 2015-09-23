package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class ProcessInstanceInfoDTO implements Serializable {
    private Long instanceId;
    private Date lastModificationDate;
    private Date lastReadDate;
    private String processId;
    private Date startDate;
    private int state;
    private Integer optlock;

    public Long getInstanceId() {
	return instanceId;
    }

    public void setInstanceId(Long instanceId) {
	this.instanceId = instanceId;
    }

    public Date getLastModificationDate() {
	return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
	this.lastModificationDate = lastModificationDate;
    }

    public Date getLastReadDate() {
	return lastReadDate;
    }

    public void setLastReadDate(Date lastReadDate) {
	this.lastReadDate = lastReadDate;
    }

    public String getProcessId() {
	return processId;
    }

    public void setProcessId(String processId) {
	this.processId = processId;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public int getState() {
	return state;
    }

    public void setState(int state) {
	this.state = state;
    }

    public Integer getOptlock() {
	return optlock;
    }

    public void setOptlock(Integer optlock) {
	this.optlock = optlock;
    }

}
