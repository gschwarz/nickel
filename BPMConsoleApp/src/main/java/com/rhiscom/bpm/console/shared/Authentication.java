package com.rhiscom.bpm.console.shared;

import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public class Authentication {

    private String user;
    private String pass;
    private boolean status;
    private OperatorDTO operator;

    public String getUser() {
	return user;
    }

    public void setUser(String user) {
	this.user = user;
    }

    public String getPass() {
	return pass;
    }

    public void setPass(String pass) {
	this.pass = pass;
    }

    public boolean isStatus() {
	return status;
    }

    public void setStatus(boolean status) {
	this.status = status;
    }

    public OperatorDTO getOperator() {
	return operator;
    }

    public void setOperator(OperatorDTO operator) {
	this.operator = operator;
    }

}
