package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class MismatchesDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String firstColumn;
    private String secondColumn;
    private String thirdColumn;
    private String fourthColumn;
    
    
    public MismatchesDTO() {
    }

    public MismatchesDTO(String firstColumn, String secondColumn, String thirdColumn) {
	super();
	this.firstColumn = firstColumn;
	this.secondColumn = secondColumn;
	this.thirdColumn = thirdColumn;
    }
    
    public MismatchesDTO(String firstColumn, String secondColumn, String thirdColumn, String fourthColumn) {
	super();
	this.firstColumn = firstColumn;
	this.secondColumn = secondColumn;
	this.thirdColumn = thirdColumn;
	this.fourthColumn = fourthColumn;
    }
    
    public String getFirstColumn() {
        return firstColumn;
    }

    public void setFirstColumn(String firstColumn) {
        this.firstColumn = firstColumn;
    }

    public String getSecondColumn() {
        return secondColumn;
    }

    public void setSecondColumn(String secondColumn) {
        this.secondColumn = secondColumn;
    }

    public String getThirdColumn() {
        return thirdColumn;
    }

    public void setThirdColumn(String thirdColumn) {
        this.thirdColumn = thirdColumn;
    }

    public String getFourthColumn() {
        return fourthColumn;
    }

    public void setFourthColumn(String fourthColumn) {
        this.fourthColumn = fourthColumn;
    }
}
