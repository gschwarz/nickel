package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class NodeInstanceLogDTO implements Serializable {
    private Long id;
    private Integer type;
    private String nodeInstanceId;
    private String nodeId;
    private String nodeName;
    private Long processInstanceId;
    private String processId;
    private Date logDate;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Integer getType() {
	return type;
    }

    public void setType(Integer type) {
	this.type = type;
    }

    public String getNodeInstanceId() {
	return nodeInstanceId;
    }

    public void setNodeInstanceId(String nodeInstanceId) {
	this.nodeInstanceId = nodeInstanceId;
    }

    public String getNodeId() {
	return nodeId;
    }

    public void setNodeId(String nodeId) {
	this.nodeId = nodeId;
    }

    public String getNodeName() {
	return nodeName;
    }

    public void setNodeName(String nodeName) {
	this.nodeName = nodeName;
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

    public Date getLogDate() {
	return logDate;
    }

    public void setLogDate(Date logDate) {
	this.logDate = logDate;
    }

}
