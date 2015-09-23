package com.rhiscom.bpm.console.server.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "pa_process_log")
public class ProcessInstanceLog extends BaseValue {

    private Long id;
    private Long processInstanceId;
    private String processId;
    private String processDescription;
    private Date startDate;
    private Date endDate;
    private String status;

    public ProcessInstanceLog() {
    }

    public ProcessInstanceLog(Long processInstanceId, String processId, Date startDate, Date endDate) {
	this.processInstanceId = processInstanceId;
	this.processId = processId;
	this.startDate = startDate;
	this.endDate = endDate;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Column(name = "processId")
    public Long getProcessInstanceId() {
	return this.processInstanceId;
    }

    public void setProcessInstanceId(Long processInstanceId) {
	this.processInstanceId = processInstanceId;
    }

    @Column(name = "processName")
    public String getProcessId() {
	return this.processId;
    }

    public void setProcessId(String processId) {
	this.processId = processId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "initDate", length = 19)
    public Date getStartDate() {
	return this.startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endDate", length = 19)
    public Date getEndDate() {
	return this.endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }
    @Column(name = "processDescription")
    public String getProcessDescription() {
	return processDescription;
    }

    public void setProcessDescription(String processDescription) {
	this.processDescription = processDescription;
    }
    @Column(name = "status")
    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

}
