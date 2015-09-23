package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "pa_email_configuration")
public class EmailConfiguration extends BaseValue {

    @Id
    @GeneratedValue
    @Column(name = "emailConfigurationId")
    private Long emailConfigurationId;

    private String senderEmail;

    private String password;

    private String emailServer;

    private String emailPort;

    public EmailConfiguration(Long emailConfigurationId2, String emailPort2, String emailServer2, String password2,
	    String senderEmail2) {
	emailConfigurationId = emailConfigurationId2;
	emailPort = emailPort2;
	emailServer = emailServer2;
	password = password2;
	senderEmail = senderEmail2;
    }

    public EmailConfiguration() {

    }

    public Long getEmailConfigurationId() {
	return emailConfigurationId;
    }

    public void setEmailConfigurationId(Long emailConfigurationId) {
	this.emailConfigurationId = emailConfigurationId;
    }

    public String getSenderEmail() {
	return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
	this.senderEmail = senderEmail;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmailServer() {
	return emailServer;
    }

    public void setEmailServer(String emailServer) {
	this.emailServer = emailServer;
    }

    public String getEmailPort() {
	return emailPort;
    }

    public void setEmailPort(String emailPort) {
	this.emailPort = emailPort;
    }

}
