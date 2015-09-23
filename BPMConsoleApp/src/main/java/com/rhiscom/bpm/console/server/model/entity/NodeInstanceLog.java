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

@Entity
@Table(name = "nodeinstancelog")
public class NodeInstanceLog implements java.io.Serializable {

    private Long id;
    private Integer type;
    private String nodeInstanceId;
    private String nodeId;
    private String nodeName;
    private Long processInstanceId;
    private String processId;
    private Date logDate;

    public NodeInstanceLog() {
    }

    public NodeInstanceLog(Integer type, String nodeInstanceId, String nodeId, String nodeName,
	    Long processInstanceId, String processId, Date logDate) {
	this.type = type;
	this.nodeInstanceId = nodeInstanceId;
	this.nodeId = nodeId;
	this.nodeName = nodeName;
	this.processInstanceId = processInstanceId;
	this.processId = processId;
	this.logDate = logDate;
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

    @Column(name = "type")
    public Integer getType() {
	return this.type;
    }

    public void setType(Integer type) {
	this.type = type;
    }

    @Column(name = "nodeInstanceId")
    public String getNodeInstanceId() {
	return this.nodeInstanceId;
    }

    public void setNodeInstanceId(String nodeInstanceId) {
	this.nodeInstanceId = nodeInstanceId;
    }

    @Column(name = "nodeId")
    public String getNodeId() {
	return this.nodeId;
    }

    public void setNodeId(String nodeId) {
	this.nodeId = nodeId;
    }

    @Column(name = "nodeName")
    public String getNodeName() {
	return this.nodeName;
    }

    public void setNodeName(String nodeName) {
	this.nodeName = nodeName;
    }

    @Column(name = "processInstanceId")
    public Long getProcessInstanceId() {
	return this.processInstanceId;
    }

    public void setProcessInstanceId(Long processInstanceId) {
	this.processInstanceId = processInstanceId;
    }

    @Column(name = "processId")
    public String getProcessId() {
	return this.processId;
    }

    public void setProcessId(String processId) {
	this.processId = processId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOG_DATE", length = 19)
    public Date getLogDate() {
	return this.logDate;
    }

    public void setLogDate(Date logDate) {
	this.logDate = logDate;
    }

}
