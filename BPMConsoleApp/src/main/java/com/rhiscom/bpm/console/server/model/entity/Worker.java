package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pa_worker")
public class Worker {

    @Id
    @GeneratedValue
    @Column(name = "workerId")
    private Long workerId;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    public Worker() {

    }

    public Worker(Long workerId, Person person) {
	super();
	this.workerId = workerId;
	this.person = person;
    }

    public Worker(Person person) {
	super();
	this.person = person;
    }

    public Long getWorkerId() {
	return workerId;
    }

    public void setWorkerId(Long workerId) {
	this.workerId = workerId;
    }

    public Person getPerson() {
	return person;
    }

    public void setPerson(Person person) {
	this.person = person;
    }

}
