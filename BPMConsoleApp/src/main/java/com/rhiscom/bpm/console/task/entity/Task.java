package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@XmlRootElement
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private BigInteger workItemId;
    private List<Attachment> attachments;
    private List<Deadline> deadlines1;
    private List<Deadline> deadlines2;
    private List<Organizationalentity> organizationalentities1;
    private List<I18ntext> i18ntexts1;
    private List<I18ntext> i18ntexts2;
    private List<I18ntext> i18ntexts3;
    private List<Organizationalentity> organizationalentities2;
    private List<Organizationalentity> organizationalentities3;
    private List<Organizationalentity> organizationalentities4;
    private List<Organizationalentity> organizationalentities5;
    private List<Organizationalentity> organizationalentities6;
    private List<Subtasksstrategy> subtasksstrategies;
    private Organizationalentity organizationalentity1;
    private Organizationalentity organizationalentity2;
    private Organizationalentity organizationalentity3;
    private List<TaskComment> taskComments;

    public Task() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
	return this.id;
    }

    public void setId(String id) {
	this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getActivationTime() {
	return this.activationTime;
    }

    public void setActivationTime(Date activationTime) {
	this.activationTime = activationTime;
    }

    public String getAllowedToDelegate() {
	return this.allowedToDelegate;
    }

    public void setAllowedToDelegate(String allowedToDelegate) {
	this.allowedToDelegate = allowedToDelegate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedOn() {
	return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
    }

    public Integer getDocumentAccessType() {
	return this.documentAccessType;
    }

    public void setDocumentAccessType(Integer documentAccessType) {
	this.documentAccessType = documentAccessType;
    }

    public BigInteger getDocumentContentId() {
	return this.documentContentId;
    }

    public void setDocumentContentId(BigInteger documentContentId) {
	this.documentContentId = documentContentId;
    }

    public String getDocumentType() {
	return this.documentType;
    }

    public void setDocumentType(String documentType) {
	this.documentType = documentType;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getExpirationTime() {
	return this.expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
	this.expirationTime = expirationTime;
    }

    public Integer getFaultAccessType() {
	return this.faultAccessType;
    }

    public void setFaultAccessType(Integer faultAccessType) {
	this.faultAccessType = faultAccessType;
    }

    public BigInteger getFaultContentId() {
	return this.faultContentId;
    }

    public void setFaultContentId(BigInteger faultContentId) {
	this.faultContentId = faultContentId;
    }

    public String getFaultName() {
	return this.faultName;
    }

    public void setFaultName(String faultName) {
	this.faultName = faultName;
    }

    public String getFaultType() {
	return this.faultType;
    }

    public void setFaultType(String faultType) {
	this.faultType = faultType;
    }

    public Integer getOutputAccessType() {
	return this.outputAccessType;
    }

    public void setOutputAccessType(Integer outputAccessType) {
	this.outputAccessType = outputAccessType;
    }

    public BigInteger getOutputContentId() {
	return this.outputContentId;
    }

    public void setOutputContentId(BigInteger outputContentId) {
	this.outputContentId = outputContentId;
    }

    public String getOutputType() {
	return this.outputType;
    }

    public void setOutputType(String outputType) {
	this.outputType = outputType;
    }

    public BigInteger getParentId() {
	return this.parentId;
    }

    public void setParentId(BigInteger parentId) {
	this.parentId = parentId;
    }

    public Integer getPreviousStatus() {
	return this.previousStatus;
    }

    public void setPreviousStatus(Integer previousStatus) {
	this.previousStatus = previousStatus;
    }

    public Integer getPriority() {
	return this.priority;
    }

    public void setPriority(Integer priority) {
	this.priority = priority;
    }

    public String getProcessId() {
	return this.processId;
    }

    public void setProcessId(String processId) {
	this.processId = processId;
    }

    public BigInteger getProcessInstanceId() {
	return this.processInstanceId;
    }

    public void setProcessInstanceId(BigInteger processInstanceId) {
	this.processInstanceId = processInstanceId;
    }

    public Integer getProcessSessionId() {
	return this.processSessionId;
    }

    public void setProcessSessionId(Integer processSessionId) {
	this.processSessionId = processSessionId;
    }

    public byte getSkipable() {
	return this.skipable;
    }

    public void setSkipable(byte skipable) {
	this.skipable = skipable;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public BigInteger getWorkItemId() {
	return this.workItemId;
    }

    public void setWorkItemId(BigInteger workItemId) {
	this.workItemId = workItemId;
    }

    // bi-directional many-to-one association to Attachment
    @OneToMany(mappedBy = "task")
    public List<Attachment> getAttachments() {
	return this.attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
	this.attachments = attachments;
    }

    // bi-directional many-to-one association to Deadline
    @OneToMany(mappedBy = "task1")
    public List<Deadline> getDeadlines1() {
	return this.deadlines1;
    }

    public void setDeadlines1(List<Deadline> deadlines1) {
	this.deadlines1 = deadlines1;
    }

    // bi-directional many-to-one association to Deadline
    @OneToMany(mappedBy = "task2")
    public List<Deadline> getDeadlines2() {
	return this.deadlines2;
    }

    public void setDeadlines2(List<Deadline> deadlines2) {
	this.deadlines2 = deadlines2;
    }

    // bi-directional many-to-many association to Organizationalentity
    @ManyToMany(mappedBy = "tasks1")
    public List<Organizationalentity> getOrganizationalentities1() {
	return this.organizationalentities1;
    }

    public void setOrganizationalentities1(List<Organizationalentity> organizationalentities1) {
	this.organizationalentities1 = organizationalentities1;
    }

    // bi-directional many-to-one association to I18ntext
    @OneToMany(mappedBy = "task1")
    public List<I18ntext> getI18ntexts1() {
	return this.i18ntexts1;
    }

    public void setI18ntexts1(List<I18ntext> i18ntexts1) {
	this.i18ntexts1 = i18ntexts1;
    }

    // bi-directional many-to-one association to I18ntext
    @OneToMany(mappedBy = "task2")
    public List<I18ntext> getI18ntexts2() {
	return this.i18ntexts2;
    }

    public void setI18ntexts2(List<I18ntext> i18ntexts2) {
	this.i18ntexts2 = i18ntexts2;
    }

    // bi-directional many-to-one association to I18ntext
    @OneToMany(mappedBy = "task3")
    public List<I18ntext> getI18ntexts3() {
	return this.i18ntexts3;
    }

    public void setI18ntexts3(List<I18ntext> i18ntexts3) {
	this.i18ntexts3 = i18ntexts3;
    }

    // bi-directional many-to-many association to Organizationalentity
    @ManyToMany(mappedBy = "tasks2")
    public List<Organizationalentity> getOrganizationalentities2() {
	return this.organizationalentities2;
    }

    public void setOrganizationalentities2(List<Organizationalentity> organizationalentities2) {
	this.organizationalentities2 = organizationalentities2;
    }

    // bi-directional many-to-many association to Organizationalentity
    @ManyToMany(mappedBy = "tasks3")
    public List<Organizationalentity> getOrganizationalentities3() {
	return this.organizationalentities3;
    }

    public void setOrganizationalentities3(List<Organizationalentity> organizationalentities3) {
	this.organizationalentities3 = organizationalentities3;
    }

    // bi-directional many-to-many association to Organizationalentity
    @ManyToMany(mappedBy = "tasks4")
    public List<Organizationalentity> getOrganizationalentities4() {
	return this.organizationalentities4;
    }

    public void setOrganizationalentities4(List<Organizationalentity> organizationalentities4) {
	this.organizationalentities4 = organizationalentities4;
    }

    // bi-directional many-to-many association to Organizationalentity
    @ManyToMany(mappedBy = "tasks5")
    public List<Organizationalentity> getOrganizationalentities5() {
	return this.organizationalentities5;
    }

    public void setOrganizationalentities5(List<Organizationalentity> organizationalentities5) {
	this.organizationalentities5 = organizationalentities5;
    }

    // bi-directional many-to-many association to Organizationalentity
    @ManyToMany(mappedBy = "tasks6")
    public List<Organizationalentity> getOrganizationalentities6() {
	return this.organizationalentities6;
    }

    public void setOrganizationalentities6(List<Organizationalentity> organizationalentities6) {
	this.organizationalentities6 = organizationalentities6;
    }

    // bi-directional many-to-one association to Subtasksstrategy
    @OneToMany(mappedBy = "task")
    public List<Subtasksstrategy> getSubtasksstrategies() {
	return this.subtasksstrategies;
    }

    public void setSubtasksstrategies(List<Subtasksstrategy> subtasksstrategies) {
	this.subtasksstrategies = subtasksstrategies;
    }

    // bi-directional many-to-one association to Organizationalentity
    @ManyToOne
    @JoinColumn(name = "taskInitiator_id")
    public Organizationalentity getOrganizationalentity1() {
	return this.organizationalentity1;
    }

    public void setOrganizationalentity1(Organizationalentity organizationalentity1) {
	this.organizationalentity1 = organizationalentity1;
    }

    // bi-directional many-to-one association to Organizationalentity
    @ManyToOne
    @JoinColumn(name = "actualOwner_id")
    public Organizationalentity getOrganizationalentity2() {
	return this.organizationalentity2;
    }

    public void setOrganizationalentity2(Organizationalentity organizationalentity2) {
	this.organizationalentity2 = organizationalentity2;
    }

    // bi-directional many-to-one association to Organizationalentity
    @ManyToOne
    @JoinColumn(name = "createdBy_id")
    public Organizationalentity getOrganizationalentity3() {
	return this.organizationalentity3;
    }

    public void setOrganizationalentity3(Organizationalentity organizationalentity3) {
	this.organizationalentity3 = organizationalentity3;
    }

    // bi-directional many-to-one association to TaskComment
    @OneToMany(mappedBy = "task")
    public List<TaskComment> getTaskComments() {
	return this.taskComments;
    }

    public void setTaskComments(List<TaskComment> taskComments) {
	this.taskComments = taskComments;
    }

}