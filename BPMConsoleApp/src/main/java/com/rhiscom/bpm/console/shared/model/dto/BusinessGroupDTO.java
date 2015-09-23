package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class BusinessGroupDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idBusinessGroup;
    private long idLevelBusinessGroup;
    private String nameBusinessGroup;
    private Date createStamp;
    private Date lastUpdatedStamp;
    private int status;
    private BusinessGroupDTO parentBusinessGroup;

    // Constructor:

    public BusinessGroupDTO(long idGroup, long idLevel, String name, Date create, Date update, int status) {

	this.idBusinessGroup = idGroup;
	this.idLevelBusinessGroup = idLevel;
	this.nameBusinessGroup = name;
	this.createStamp = create;
	this.lastUpdatedStamp = update;
	this.status = status;

    } //

    public BusinessGroupDTO() {
	// TODO Auto-generated constructor stub
    }

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public long getIdBusinessGroup() {
	return idBusinessGroup;
    }

    public void setIdBusinessGroup(long idBusinessGroup) {
	this.idBusinessGroup = idBusinessGroup;
    }

    public long getIdLevelBusinessGroup() {
	return idLevelBusinessGroup;
    }

    public void setIdLevelBusinessGroup(long idLevelBusinessGroup) {
	this.idLevelBusinessGroup = idLevelBusinessGroup;
    }

    public String getNameBusinessGroup() {
	return nameBusinessGroup;
    }

    public void setNameBusinessGroup(String nameBusinessGroup) {
	this.nameBusinessGroup = nameBusinessGroup;
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

    public BusinessGroupDTO getParentBusinessGroup() {
	return parentBusinessGroup;
    }

    public void setParentBusinessGroup(BusinessGroupDTO parentBusinessGroup) {
	this.parentBusinessGroup = parentBusinessGroup;
    }

}
