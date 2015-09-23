package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad persona, que puede ser un usuario o cliente, según grupo que
 * pertenesca.
 * 
 * @author Pablo Cáceres
 * 
 */

@Entity
@Table(name = "pa_person")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "personId")
    private Long personId;

    @Column(name = "partyId", nullable = false)
    private String partyId;

    @Column(name = "identification", nullable = true)
    private String identification;

    @Column(name = "firstName", nullable = true)
    private String firstName;

    @Column(name = "middleName", nullable = true)
    private String middleName;

    @Column(name = "lastName", nullable = true)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private Long gender;

    @Column(name = "email", nullable = true)
    private String email;

    public Person(Long personId, String partyId, String identification, String firstName, String middleName,
	    String lastName, Long gender, String email) {
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

    public Person(String partyId, String identification, String firstName, String middleName, String lastName,
	    Long gender, String email) {

	this.partyId = partyId;
	this.identification = identification;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.gender = gender;
	this.email = email;
    }

    public Person() {

    }

    public Long getPersonId() {
	return personId;
    }

    public void setPersonId(Long personId) {
	this.personId = personId;
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

    public Long getGender() {
	return gender;
    }

    public void setGender(Long gender) {
	this.gender = gender;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPartyId() {
	return partyId;
    }

    public void setPartyId(String partyId) {
	this.partyId = partyId;
    }

}
