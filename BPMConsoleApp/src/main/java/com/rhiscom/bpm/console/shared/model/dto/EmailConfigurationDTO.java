package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class EmailConfigurationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long emailConfigurationId;
    private String senderEmail;
    private String password;
    private String emailServer;
    private String emailPort;

    public EmailConfigurationDTO(Long emailConfigurationId2, String emailPort2, String emailServer2, String password2,
	    String senderEmail2) {
	emailConfigurationId = emailConfigurationId2;
	senderEmail = senderEmail2;
	password = password2;
	emailServer = emailServer2;
	emailPort = emailPort2;
    }

    public EmailConfigurationDTO() {
	// TODO Auto-generated constructor stub
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
