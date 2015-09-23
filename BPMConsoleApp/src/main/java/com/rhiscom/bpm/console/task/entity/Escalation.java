package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.rhiscom.bpm.console.server.model.entity.Reassignment;

import java.util.List;


/**
 * The persistent class for the escalation database table.
 * 
 */
@Entity
@XmlRootElement
public class Escalation implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private List<Booleanexpression> booleanexpressions;
	private Deadline deadline;
	private List<Notification> notifications;
	private List<Reassignment> reassignments;

    public Escalation() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Booleanexpression
	@OneToMany(mappedBy="escalation")
	public List<Booleanexpression> getBooleanexpressions() {
		return this.booleanexpressions;
	}

	public void setBooleanexpressions(List<Booleanexpression> booleanexpressions) {
		this.booleanexpressions = booleanexpressions;
	}
	

	//bi-directional many-to-one association to Deadline
    @ManyToOne
	@JoinColumn(name="Deadline_Escalation_Id")
	public Deadline getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}
	

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="escalation")
	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	

	//bi-directional many-to-one association to Reassignment
	@OneToMany(mappedBy="escalation")
	public List<Reassignment> getReassignments() {
		return this.reassignments;
	}

	public void setReassignments(List<Reassignment> reassignments) {
		this.reassignments = reassignments;
	}
	
}