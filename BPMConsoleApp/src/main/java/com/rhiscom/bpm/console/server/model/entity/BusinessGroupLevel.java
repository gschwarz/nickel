package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "co_bsngp_lv")
public class BusinessGroupLevel {

    @Id
    @GeneratedValue
    @Column(name = "ID_BSNGP_LV")
    private Long idLevelBusinessGroup;

    @Column(name = "ID_BSNGP_LV_PRNT")
    private Long idParentLevelBusinessGroup;

    @Column(name = "NM_BSNGP_LV")
    private String nameLevelBusinessGroup;

    @Column(name = "CREATED_STAMP")
    private Date createStamp;

    @Column(name = "LAST_UPDATED_STAMP")
    private Date lastUpdatedStamp;

    public Long getIdLevelBusinessGroup() {
	return idLevelBusinessGroup;
    }

    public void setIdLevelBusinessGroup(Long idLevelBusinessGroup) {
	this.idLevelBusinessGroup = idLevelBusinessGroup;
    }

    public Long getIdParentLevelBusinessGroup() {
	return idParentLevelBusinessGroup;
    }

    public void setIdParentLevelBusinessGroup(Long idParentLevelBusinessGroup) {
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
