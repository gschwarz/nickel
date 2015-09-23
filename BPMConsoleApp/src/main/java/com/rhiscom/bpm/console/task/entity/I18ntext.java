package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.rhiscom.bpm.console.server.model.entity.Reassignment;


/**
 * The persistent class for the i18ntext database table.
 * 
 */
@Entity
@XmlRootElement
public class I18ntext implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String language;
	private String text;
	private Notification notification1;
	private Notification notification2;
	private Deadline deadline;
	private Reassignment reassignment;
	private Task task1;
	private Notification notification3;
	private Task task2;
	private Task task3;
	private Notification notification4;

    public I18ntext() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


    @Lob()
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}


	//bi-directional many-to-one association to Notification
    @ManyToOne
	@JoinColumn(name="Notification_Subjects_Id")
	public Notification getNotification1() {
		return this.notification1;
	}

	public void setNotification1(Notification notification1) {
		this.notification1 = notification1;
	}
	

	//bi-directional many-to-one association to Notification
    @ManyToOne
	@JoinColumn(name="Notification_Descriptions_Id")
	public Notification getNotification2() {
		return this.notification2;
	}

	public void setNotification2(Notification notification2) {
		this.notification2 = notification2;
	}
	

	//bi-directional many-to-one association to Deadline
    @ManyToOne
	@JoinColumn(name="Deadline_Documentation_Id")
	public Deadline getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}
	

	//bi-directional many-to-one association to Reassignment
    @ManyToOne
	@JoinColumn(name="Reassignment_Documentation_Id")
	public Reassignment getReassignment() {
		return this.reassignment;
	}

	public void setReassignment(Reassignment reassignment) {
		this.reassignment = reassignment;
	}
	

	//bi-directional many-to-one association to Task
    @ManyToOne
	@JoinColumn(name="Task_Descriptions_Id")
	public Task getTask1() {
		return this.task1;
	}

	public void setTask1(Task task1) {
		this.task1 = task1;
	}
	

	//bi-directional many-to-one association to Notification
    @ManyToOne
	@JoinColumn(name="Notification_Documentation_Id")
	public Notification getNotification3() {
		return this.notification3;
	}

	public void setNotification3(Notification notification3) {
		this.notification3 = notification3;
	}
	

	//bi-directional many-to-one association to Task
    @ManyToOne
	@JoinColumn(name="Task_Names_Id")
	public Task getTask2() {
		return this.task2;
	}

	public void setTask2(Task task2) {
		this.task2 = task2;
	}
	

	//bi-directional many-to-one association to Task
    @ManyToOne
	@JoinColumn(name="Task_Subjects_Id")
	public Task getTask3() {
		return this.task3;
	}

	public void setTask3(Task task3) {
		this.task3 = task3;
	}
	

	//bi-directional many-to-one association to Notification
    @ManyToOne
	@JoinColumn(name="Notification_Names_Id")
	public Notification getNotification4() {
		return this.notification4;
	}

	public void setNotification4(Notification notification4) {
		this.notification4 = notification4;
	}
	
}