package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the deadline database table.
 * 
 */
@Entity
@XmlRootElement
public class Deadline implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date deadlineDate;
	private byte escalated;
	private Task task1;
	private Task task2;
	private List<Escalation> escalations;
	private List<I18ntext> i18ntexts;

    public Deadline() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="deadline_date")
	public Date getDeadlineDate() {
		return this.deadlineDate;
	}

	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}


	public byte getEscalated() {
		return this.escalated;
	}

	public void setEscalated(byte escalated) {
		this.escalated = escalated;
	}


	//bi-directional many-to-one association to Task
    @ManyToOne
	@JoinColumn(name="Deadlines_EndDeadLine_Id")
	public Task getTask1() {
		return this.task1;
	}

	public void setTask1(Task task1) {
		this.task1 = task1;
	}
	

	//bi-directional many-to-one association to Task
    @ManyToOne
	@JoinColumn(name="Deadlines_StartDeadLine_Id")
	public Task getTask2() {
		return this.task2;
	}

	public void setTask2(Task task2) {
		this.task2 = task2;
	}
	

	//bi-directional many-to-one association to Escalation
	@OneToMany(mappedBy="deadline")
	public List<Escalation> getEscalations() {
		return this.escalations;
	}

	public void setEscalations(List<Escalation> escalations) {
		this.escalations = escalations;
	}
	

	//bi-directional many-to-one association to I18ntext
	@OneToMany(mappedBy="deadline")
	public List<I18ntext> getI18ntexts() {
		return this.i18ntexts;
	}

	public void setI18ntexts(List<I18ntext> i18ntexts) {
		this.i18ntexts = i18ntexts;
	}
	
}