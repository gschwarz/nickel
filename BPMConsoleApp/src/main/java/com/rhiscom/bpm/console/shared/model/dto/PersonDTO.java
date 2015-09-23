package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable {

    private long personId;

    private String partyId;

    private String identification;

    private String firstName;

    private String middleName;

    private String lastName;

    private long gender;

    private String email;

    public PersonDTO() {

    }

    public PersonDTO(String partyId, String identification, String firstName, String middleName, String lastName,
	    long gender, String email) {
	super();
	this.partyId = partyId;
	this.identification = identification;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.gender = gender;
	this.email = email;
    }

    public PersonDTO(long personId, String partyId, String identification, String firstName, String middleName,
	    String lastName, long gender, String email) {
	super();
	this.personId = personId;
	this.partyId = partyId;
	this.identification = identification;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.gender = gender;
	this.email = email;
    }

    public long getPersonId() {
	return personId;
    }

    public void setPersonId(long personId) {
	this.personId = personId;
    }

    public String getPartyId() {
	return partyId;
    }

    public void setPartyId(String partyId) {
	this.partyId = partyId;
    }

    public String getIdentification() {
	return identification;
    }

    public void setIdentification(String identification) {
	this.identification = identification;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getMiddleName() {
	return middleName;
    }

    public void setMiddleName(String middleName) {
	this.middleName = middleName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public long getGender() {
	return gender;
    }

    public void setGender(long gender) {
	this.gender = gender;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

}
