package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class QuadratureGeoPOSEBSDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String branchCode;
    private String branchName;

    private int numberOfTransactionsGeoPOS;
    private int totalAmountGeoPOS;

    private int numberOfTransactionsEBSOM;
    private int totalAmountEBSOM;

    private int numberOfTransactionsEBSGL;
    private int totalAmountEBSGL;

    

    public QuadratureGeoPOSEBSDTO(){
	
    }
    
    public QuadratureGeoPOSEBSDTO(String branchCode, String branchName, int numberOfTransactionsGeoPOS, int totalAmountGeoPOS,
	    int numberOfTransactionsEBSOM, int totalAmountEBSOM, int numberOfTransactionsEBSGL, int totalAmountEBSGL) {
	super();
	this.branchCode = branchCode;
	this.branchName = branchName;
	this.numberOfTransactionsGeoPOS = numberOfTransactionsGeoPOS;
	this.totalAmountGeoPOS = totalAmountGeoPOS;
	this.numberOfTransactionsEBSOM = numberOfTransactionsEBSOM;
	this.totalAmountEBSOM = totalAmountEBSOM;
	this.numberOfTransactionsEBSGL = numberOfTransactionsEBSGL;
	this.totalAmountEBSGL = totalAmountEBSGL;
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

    public int getNumberOfTransactionsGeoPOS() {
	return numberOfTransactionsGeoPOS;
    }

    public void setNumberOfTransactionsGeoPOS(int numberOfTransactionsGeoPOS) {
	this.numberOfTransactionsGeoPOS = numberOfTransactionsGeoPOS;
    }

    public int getTotalAmountGeoPOS() {
	return totalAmountGeoPOS;
    }

    public void setTotalAmountGeoPOS(int totalAmountGeoPOS) {
	this.totalAmountGeoPOS = totalAmountGeoPOS;
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

    

}
