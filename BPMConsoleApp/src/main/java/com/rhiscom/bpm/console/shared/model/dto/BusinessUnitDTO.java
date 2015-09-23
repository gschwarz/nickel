package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class BusinessUnitDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idBusinessUnit;
    private long idBusinessGroup;
    private String nameBusinessUnit;
    private String businessGroupName;
    private Date createStamp;
    private Date lastUpdatedStamp;
    private int status;
    private String code;

    // Constructor:

    public BusinessUnitDTO(long id, long idBusinessGroup, String name, Date create, Date update, int status,
	    String code) {

	this.idBusinessUnit = id;
	this.idBusinessGroup = idBusinessGroup;
	this.nameBusinessUnit = name;
	this.createStamp = create;
	this.lastUpdatedStamp = update;
	this.status = status;
	this.setCode(code);

    } //

    public BusinessUnitDTO() {
	// TODO Auto-generated constructor stub
    }

    public int getStatus() {
	return status;
    }

    public long getIdBusinessGroup() {
	return idBusinessGroup;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public long getIdBusinessUnit() {
	return idBusinessUnit;
    }

    public void setIdBusinessUnit(long idBusinessUnit) {
	this.idBusinessUnit = idBusinessUnit;
    }

    public void setIdBusinessGroup(long idBusinessGroup) {
	this.idBusinessGroup = idBusinessGroup;
    }

    public String getNameBusinessUnit() {
	return nameBusinessUnit;
    }

    public void setNameBusinessUnit(String nameBusinessUnit) {
	this.nameBusinessUnit = nameBusinessUnit;
    }

    public Date getCreateStamp() {
	return createStamp;
    }

    public void setCreateStamp(Date createStamp) {
	this.createStamp = createStamp;
    }

    public Date getLastUpdatedStamp() {
	return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(Date lastUpdatedStamp) {
	this.lastUpdatedStamp = lastUpdatedStamp;
    }

    public String getBusinessGroupName() {
	return businessGroupName;
    }

    public void setBusinessGroupName(String businessGroupName) {
	this.businessGroupName = businessGroupName;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

}
