package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.rhiscom.bpm.console.server.model.entity.Reassignment;

/**
 * The persistent class for the organizationalentity database table.
 * 
 */
@Entity
@XmlRootElement
public class Organizationalentity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String dtype;
    private List<Attachment> attachments;
    private List<Task> tasks1;
    private List<Notification> notifications1;
    private List<Notification> notifications2;
    private List<Task> tasks2;
    private List<Task> tasks3;
    private List<Task> tasks4;
    private List<Task> tasks5;
    private List<Task> tasks6;
    private List<Reassignment> reassignments;
    private List<Task> tasks7;
    private List<Task> tasks8;
    private List<Task> tasks9;
    private List<TaskComment> taskComments;

    public Organizationalentity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
	return this.id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getDtype() {
	return this.dtype;
    }

    public void setDtype(String dtype) {
	this.dtype = dtype;
    }

    // bi-directional many-to-one association to Attachment
    @OneToMany(mappedBy = "organizationalentity")
    public List<Attachment> getAttachments() {
	return this.attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
	this.attachments = attachments;
    }

    // bi-directional many-to-many association to Task
    @ManyToMany
    @JoinTable(name = "delegation_delegates", joinColumns = { @JoinColumn(name = "entity_id") }, inverseJoinColumns = { @JoinColumn(name = "task_id") })
    public List<Task> getTasks1() {
	return this.tasks1;
    }

    public void setTasks1(List<Task> tasks1) {
	this.tasks1 = tasks1;
    }

    // bi-directional many-to-many association to Notification
    @ManyToMany
    @JoinTable(name = "notification_bas", joinColumns = { @JoinColumn(name = "entity_id") }, inverseJoinColumns = { @JoinColumn(name = "task_id") })
    public List<Notification> getNotifications1() {
	return this.notifications1;
    }

    public void setNotifications1(List<Notification> notifications1) {
	this.notifications1 = notifications1;
    }

    // bi-directional many-to-many association to Notification
    @ManyToMany
    @JoinTable(name = "notification_recipients", joinColumns = { @JoinColumn(name = "entity_id") }, inverseJoinColumns = { @JoinColumn(name = "task_id") })
    public List<Notification> getNotifications2() {
	return this.notifications2;
    }

    public void setNotifications2(List<Notification> notifications2) {
	this.notifications2 = notifications2;
    }

    // bi-directional many-to-many association to Task
    @ManyToMany
    @JoinTable(name = "peopleassignments_bas", joinColumns = { @JoinColumn(name = "entity_id") }, inverseJoinColumns = { @JoinColumn(name = "task_id") })
    public List<Task> getTasks2() {
	return this.tasks2;
    }

    public void setTasks2(List<Task> tasks2) {
	this.tasks2 = tasks2;
    }

    // bi-directional many-to-many association to Task
    @ManyToMany
    @JoinTable(name = "peopleassignments_exclowners", joinColumns = { @JoinColumn(name = "entity_id") }, inverseJoinColumns = { @JoinColumn(name = "task_id") })
    public List<Task> getTasks3() {
	return this.tasks3;
    }

    public void setTasks3(List<Task> tasks3) {
	this.tasks3 = tasks3;
    }

    // bi-directional many-to-many association to Task
    @ManyToMany
    @JoinTable(name = "peopleassignments_potowners", joinColumns = { @JoinColumn(name = "entity_id") }, inverseJoinColumns = { @JoinColumn(name = "task_id") })
    public List<Task> getTasks4() {
	return this.tasks4;
    }

    public void setTasks4(List<Task> tasks4) {
	this.tasks4 = tasks4;
    }

    // bi-directional many-to-many association to Task
    @ManyToMany
    @JoinTable(name = "peopleassignments_recipients", joinColumns = { @JoinColumn(name = "entity_id") }, inverseJoinColumns = { @JoinColumn(name = "task_id") })
    public List<Task> getTasks5() {
	return this.tasks5;
    }

    public void setTasks5(List<Task> tasks5) {
	this.tasks5 = tasks5;
    }

    // bi-directional many-to-many association to Task
    @ManyToMany
    @JoinTable(name = "peopleassignments_stakeholders", joinColumns = { @JoinColumn(name = "entity_id") }, inverseJoinColumns = { @JoinColumn(name = "task_id") })
    public List<Task> getTasks6() {
	return this.tasks6;
    }

    public void setTasks6(List<Task> tasks6) {
	this.tasks6 = tasks6;
    }

    // bi-directional many-to-many association to Reassignment
    @ManyToMany
    @JoinTable(name = "reassignment_potentialowners", joinColumns = { @JoinColumn(name = "entity_id") }, inverseJoinColumns = { @JoinColumn(name = "task_id") })
    public List<Reassignment> getReassignments() {
	return this.reassignments;
    }

    public void setReassignments(List<Reassignment> reassignments) {
	this.reassignments = reassignments;
    }

    // bi-directional many-to-one association to Task
    @OneToMany(mappedBy = "organizationalentity1")
    public List<Task> getTasks7() {
	return this.tasks7;
    }

    public void setTasks7(List<Task> tasks7) {
	this.tasks7 = tasks7;
    }

    // bi-directional many-to-one association to Task
    @OneToMany(mappedBy = "organizationalentity2")
    public List<Task> getTasks8() {
	return this.tasks8;
    }

    public void setTasks8(List<Task> tasks8) {
	this.tasks8 = tasks8;
    }

    // bi-directional many-to-one association to Task
    @OneToMany(mappedBy = "organizationalentity3")
    public List<Task> getTasks9() {
	return this.tasks9;
    }

    public void setTasks9(List<Task> tasks9) {
	this.tasks9 = tasks9;
    }

    // bi-directional many-to-one association to TaskComment
    @OneToMany(mappedBy = "organizationalentity")
    public List<TaskComment> getTaskComments() {
	return this.taskComments;
    }

    public void setTaskComments(List<TaskComment> taskComments) {
	this.taskComments = taskComments;
    }

}