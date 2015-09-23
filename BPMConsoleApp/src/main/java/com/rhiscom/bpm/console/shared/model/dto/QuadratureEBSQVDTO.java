package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class QuadratureEBSQVDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String branchCode;
    private String branchName;

    private int numberOfTransactionsEBSOM;
    private int totalAmountEBSOM;

    private int numberOfTransactionsEBSGL;
    private int totalAmountEBSGL;

    private int numberOfTransactionsQV;
    private int totalAmountQV;

    public QuadratureEBSQVDTO() {

    }

    public QuadratureEBSQVDTO(String branchCode, String branchName, int numberOfTransactionsEBSOM, int totalAmountEBSOM,
	    int numberOfTransactionsEBSGL, int totalAmountEBSGL, int numberOfTransactionsQV, int totalAmountQV) {
	super();
	this.branchCode = branchCode;
	this.branchName = branchName;
	this.numberOfTransactionsEBSOM = numberOfTransactionsEBSOM;
	this.totalAmountEBSOM = totalAmountEBSOM;
	this.numberOfTransactionsEBSGL = numberOfTransactionsEBSGL;
	this.totalAmountEBSGL = totalAmountEBSGL;
	this.numberOfTransactionsQV = numberOfTransactionsQV;
	this.totalAmountQV = totalAmountQV;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    
    public String getBranchName() {
	return branchName;
    }

    public void setBranchName(String branchName) {
	this.branchName = branchName;
    }
    
    public int getNumberOfTransactionsEBSOM() {
	return numberOfTransactionsEBSOM;
    }

    public void setNumberOfTransactionsEBSOM(int numberOfTransactionsEBSOM) {
	this.numberOfTransactionsEBSOM = numberOfTransactionsEBSOM;
    }

    public int getTotalAmountEBSOM() {
	return totalAmountEBSOM;
    }

    public void setTotalAmountEBSOM(int totalAmountEBSOM) {
	this.totalAmountEBSOM = totalAmountEBSOM;
    }

    public int getNumberOfTransactionsEBSGL() {
	return numberOfTransactionsEBSGL;
    }

    public void setNumberOfTransactionsEBSGL(int numberOfTransactionsEBSGL) {
	this.numberOfTransactionsEBSGL = numberOfTransactionsEBSGL;
    }

    public int getTotalAmountEBSGL() {
	return totalAmountEBSGL;
    }

    public void setTotalAmountEBSGL(int totalAmountEBSGL) {
	this.totalAmountEBSGL = totalAmountEBSGL;
    }

    public int getNumberOfTransactionsQV() {
	return numberOfTransactionsQV;
    }

    public void setNumberOfTransactionsQV(int numberOfTransactionsQV) {
	this.numberOfTransactionsQV = numberOfTransactionsQV;
    }

    public int getTotalAmountQV() {
	return totalAmountQV;
    }

    public void setTotalAmountQV(int totalAmountQV) {
	this.totalAmountQV = totalAmountQV;
    }

}
