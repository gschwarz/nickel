package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "wg_operator")
public class Operator extends BaseValue {

    @Id
    @GeneratedValue
    @Column(name = "operatorId")
    private Long operatorId;

    @Column(name = "user", unique = true)
    private String user;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Worker worker;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "segProfileId", nullable = true)
    private Profile profile;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBusinessUnit", nullable = true)
    private BusinessUnit businessUnit;

    @Column(name = "createDate")
    private Date createDate;

    public Operator() {

    }

    public Operator(Long operatorId, String user, String password, Worker worker, Date createDate,
	    Profile profile, BusinessUnit businessUnit) {
	super();
	this.operatorId = operatorId;
	this.user = user;
	this.password = password;
	this.worker = worker;
	this.createDate = createDate;
	this.businessUnit = businessUnit;
	this.setProfile(profile);
    }

    public Operator(String user, String password, Worker worker, Date createDate, Profile profile,
	    BusinessUnit businessUnit) {

	this.user = user;
	this.password = password;
	this.worker = worker;
	this.createDate = createDate;
	this.setProfile(profile);
	this.businessUnit = businessUnit;
    }

    public Long getOperatorId() {
	return operatorId;
    }

    public void setOperatorId(Long operatorId) {
	this.operatorId = operatorId;
    }

    public String getUser() {
	return user;
    }

    public void setUser(String user) {
	this.user = user;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Worker getWorker() {
	return worker;
    }

    public void setWorker(Worker worker) {
	this.worker = worker;
    }

    public Date getCreateDate() {
	return createDate;
    }

    public void setCreateDate(Date createDate) {
	this.createDate = createDate;
    }

    public Profile getProfile() {
	return profile;
    }

    public void setProfile(Profile profile) {
	this.profile = profile;
    }

    public BusinessUnit getBusinessUnit() {
	return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
	this.businessUnit = businessUnit;
    }

}
