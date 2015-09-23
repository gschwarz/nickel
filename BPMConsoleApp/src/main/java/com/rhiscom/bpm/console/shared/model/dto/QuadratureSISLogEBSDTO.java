package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class QuadratureSISLogEBSDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String branchCode;
    private String branchName;
    private int stockSISLog;
    private int stockEBSINV;

    public QuadratureSISLogEBSDTO() {

    }
    
    public QuadratureSISLogEBSDTO(String branchCode,  int stockSISLog , int stockEBSINV) {
	super();
	this.branchCode = branchCode;
	//this.branchName = branchName;
	this.stockSISLog = stockSISLog;
	this.stockEBSINV = stockEBSINV;
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

    public int getTotalAmountSISLog() {
        return stockSISLog;
    }

    public void setTotalAmountSISLog(int totalAmountSISLog) {
        this.stockSISLog = totalAmountSISLog;
    }
    
    public int getTotalAmountEBSINV() {
        return stockEBSINV;
    }

    public void setTotalAmountEBSINV(int totalAmountEBSINV) {
        this.stockEBSINV = totalAmountEBSINV;
    }
    
}
