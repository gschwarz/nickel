package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class WorkerDTO implements Serializable {

    private long workerId;
    private PersonDTO person;

    public WorkerDTO() {

    }

    public WorkerDTO(PersonDTO person) {
	super();
	this.person = person;
    }

    public WorkerDTO(long workerId, PersonDTO person) {
	super();
	this.workerId = workerId;
	this.person = person;
    }

    public long getWorkerId() {
	return workerId;
    }

    public void setWorkerId(long workerId) {
	this.workerId = workerId;
    }

    public PersonDTO getPerson() {
	return person;
    }

    public void setPerson(PersonDTO person) {
	this.person = person;
    }

}
