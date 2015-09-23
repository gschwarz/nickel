package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class BusinessGroupLevelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idLevelBusinessGroup;
    private long idParentLevelBusinessGroup;
    private String nameLevelBusinessGroup;
    private Date createStamp;
    private Date lastUpdatedStamp;

    // Constructor:

    public BusinessGroupLevelDTO(long idLevel, long idParentLevel, String name, Date create, Date update) {

	this.idLevelBusinessGroup = idLevel;
	this.idParentLevelBusinessGroup = idParentLevel;
	this.nameLevelBusinessGroup = name;
	this.createStamp = create;
	this.lastUpdatedStamp = update;

    } //

    public long getIdLevelBusinessGroup() {
	return idLevelBusinessGroup;
    }

    public void setIdLevelBusinessGroup(long idLevelBusinessGroup) {
	this.idLevelBusinessGroup = idLevelBusinessGroup;
    }

    public long getIdParentLevelBusinessGroup() {
	return idParentLevelBusinessGroup;
    }

    public void setIdParentLevelBusinessGroup(long idParentLevelBusinessGroup) {
	this.idParentLevelBusinessGroup = idParentLevelBusinessGroup;
    }

    public String getNameLevelBusinessGroup() {
	return nameLevelBusinessGroup;
    }

    public void setNameLevelBusinessGroup(String nameLevelBusinessGroup) {
	this.nameLevelBusinessGroup = nameLevelBusinessGroup;
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

}
