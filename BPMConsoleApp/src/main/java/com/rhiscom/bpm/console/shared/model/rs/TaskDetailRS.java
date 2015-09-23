package com.rhiscom.bpm.console.shared.model.rs;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class TaskDetailRS implements Serializable {
    private String id;
    private Date activationTime;
    private String allowedToDelegate;
    private Date createdOn;
    private Integer documentAccessType;
    private BigInteger documentContentId;
    private String documentType;
    private Date expirationTime;
    private Integer faultAccessType;
    private BigInteger faultContentId;
    private String faultName;
    private String faultType;
    private Integer outputAccessType;
    private BigInteger outputContentId;
    private String outputType;
    private BigInteger parentId;
    private Integer previousStatus;
    private Integer priority;
    private String processId;
    private BigInteger processInstanceId;
    private Integer processSessionId;
    private byte skipable;
    private String status;
    private String owner;
    private String name;
    private String description;

    public TaskDetailRS() {

    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Date getActivationTime() {
	return activationTime;
    }

    public void setActivationTime(Date activationTime) {
	this.activationTime = activationTime;
    }

    public String getAllowedToDelegate() {
	return allowedToDelegate;
    }

    public void setAllowedToDelegate(String allowedToDelegate) {
	this.allowedToDelegate = allowedToDelegate;
    }

    public Date getCreatedOn() {
	return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
    }

    public Integer getDocumentAccessType() {
	return documentAccessType;
    }

    public void setDocumentAccessType(Integer documentAccessType) {
	this.documentAccessType = documentAccessType;
    }

    public BigInteger getDocumentContentId() {
	return documentContentId;
    }

    public void setDocumentContentId(BigInteger documentContentId) {
	this.documentContentId = documentContentId;
    }

    public String getDocumentType() {
	return documentType;
    }

    public void setDocumentType(String documentType) {
	this.documentType = documentType;
    }

    public Date getExpirationTime() {
	return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
	this.expirationTime = expirationTime;
    }

    public Integer getFaultAccessType() {
	return faultAccessType;
    }

    public void setFaultAccessType(Integer faultAccessType) {
	this.faultAccessType = faultAccessType;
    }

    public BigInteger getFaultContentId() {
	return faultContentId;
    }

    public void setFaultContentId(BigInteger faultContentId) {
	this.faultContentId = faultContentId;
    }

    public String getFaultName() {
	return faultName;
    }

    public void setFaultName(String faultName) {
	this.faultName = faultName;
    }

    public String getFaultType() {
	return faultType;
    }

    public void setFaultType(String faultType) {
	this.faultType = faultType;
    }

    public Integer getOutputAccessType() {
	return outputAccessType;
    }

    public void setOutputAccessType(Integer outputAccessType) {
	this.outputAccessType = outputAccessType;
    }

    public BigInteger getOutputContentId() {
	return outputContentId;
    }

    public void setOutputContentId(BigInteger outputContentId) {
	this.outputContentId = outputContentId;
    }

    public String getOutputType() {
	return outputType;
    }

    public void setOutputType(String outputType) {
	this.outputType = outputType;
    }

    public BigInteger getParentId() {
	return parentId;
    }

    public void setParentId(BigInteger parentId) {
	this.parentId = parentId;
    }

    public Integer getPreviousStatus() {
	return previousStatus;
    }

    public void setPreviousStatus(Integer previousStatus) {
	this.previousStatus = previousStatus;
    }

    public Integer getPriority() {
	return priority;
    }

    public void setPriority(Integer priority) {
	this.priority = priority;
    }

    public String getProcessId() {
	return processId;
    }

    public void setProcessId(String processId) {
	this.processId = processId;
    }

    public BigInteger getProcessInstanceId() {
	return processInstanceId;
    }

    public void setProcessInstanceId(BigInteger processInstanceId) {
	this.processInstanceId = processInstanceId;
    }

    public Integer getProcessSessionId() {
	return processSessionId;
    }

    public void setProcessSessionId(Integer processSessionId) {
	this.processSessionId = processSessionId;
    }

    public byte getSkipable() {
	return skipable;
    }

    public void setSkipable(byte skipable) {
	this.skipable = skipable;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getOwner() {
	return owner;
    }

    public void setOwner(String owner) {
	this.owner = owner;
    }

}
