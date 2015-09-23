package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the task_comment database table.
 * 
 */
@Entity
@Table(name = "task_comment")
@XmlRootElement
public class TaskComment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private Date addedAt;
    private String text;
    private Organizationalentity organizationalentity;
    private Task task;

    public TaskComment() {
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
    public Date getAddedAt() {
	return this.addedAt;
    }

    public void setAddedAt(Date addedAt) {
	this.addedAt = addedAt;
    }

    @Column(length = 1000000)
    public String getText() {
	return this.text;
    }

    public void setText(String text) {
	this.text = text;
    }

    // bi-directional many-to-one association to Organizationalentity
    @ManyToOne
    @JoinColumn(name = "addedBy_id")
    public Organizationalentity getOrganizationalentity() {
	return this.organizationalentity;
    }

    public void setOrganizationalentity(Organizationalentity organizationalentity) {
	this.organizationalentity = organizationalentity;
    }

    // bi-directional many-to-one association to Task
    @ManyToOne
    @JoinColumn(name = "TaskData_Comments_Id")
    public Task getTask() {
	return this.task;
    }

    public void setTask(Task task) {
	this.task = task;
    }

}