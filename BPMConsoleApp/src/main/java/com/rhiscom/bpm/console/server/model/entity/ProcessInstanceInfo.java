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
@Table(name = "processinstanceinfo")
public class ProcessInstanceInfo extends BaseValue {

    private Long instanceId;
    private Date lastModificationDate;
    private Date lastReadDate;
    private String processId;
    private byte[] processInstanceByteArray;
    private Date startDate;
    private int state;
    private Integer optlock;

    public ProcessInstanceInfo() {
    }

    public ProcessInstanceInfo(int state) {
	this.state = state;
    }

    public ProcessInstanceInfo(Date lastModificationDate, Date lastReadDate, String processId,
	    byte[] processInstanceByteArray, Date startDate, int state, Integer optlock) {
	this.lastModificationDate = lastModificationDate;
	this.lastReadDate = lastReadDate;
	this.processId = processId;
	this.processInstanceByteArray = processInstanceByteArray;
	this.startDate = startDate;
	this.state = state;
	this.optlock = optlock;

    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "InstanceId", unique = true, nullable = false)
    public Long getInstanceId() {
	return this.instanceId;
    }

    public void setInstanceId(Long instanceId) {
	this.instanceId = instanceId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastModificationDate", length = 19)
    public Date getLastModificationDate() {
	return this.lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
	this.lastModificationDate = lastModificationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastReadDate", length = 19)
    public Date getLastReadDate() {
	return this.lastReadDate;
    }

    public void setLastReadDate(Date lastReadDate) {
	this.lastReadDate = lastReadDate;
    }

    @Column(name = "processId")
    public String getProcessId() {
	return this.processId;
    }

    public void setProcessId(String processId) {
	this.processId = processId;
    }

    @Column(name = "processInstanceByteArray")
    public byte[] getProcessInstanceByteArray() {
	return this.processInstanceByteArray;
    }

    public void setProcessInstanceByteArray(byte[] processInstanceByteArray) {
	this.processInstanceByteArray = processInstanceByteArray;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "startDate", length = 19)
    public Date getStartDate() {
	return this.startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    @Column(name = "state", nullable = false)
    public int getState() {
	return this.state;
    }

    public void setState(int state) {
	this.state = state;
    }

    @Column(name = "OPTLOCK")
    public Integer getOptlock() {
	return this.optlock;
    }

    public void setOptlock(Integer optlock) {
	this.optlock = optlock;
    }

}
