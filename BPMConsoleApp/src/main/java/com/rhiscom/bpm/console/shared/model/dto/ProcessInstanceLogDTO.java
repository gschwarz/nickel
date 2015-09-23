package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class ProcessInstanceLogDTO implements Serializable {
    private Long id;
    private Long processInstanceId;
    private String processId;
    private Date startDate;
    private Date endDate;
    private String status;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getProcessInstanceId() {
	return processInstanceId;
    }

    public void setProcessInstanceId(Long processInstanceId) {
	this.processInstanceId = processInstanceId;
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

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }
}
