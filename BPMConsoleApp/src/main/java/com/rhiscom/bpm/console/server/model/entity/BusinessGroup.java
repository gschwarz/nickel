package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "co_bsngp")
public class BusinessGroup {

    @Id
    @GeneratedValue
    @Column(name = "ID_BSNGP")
    private Long idBusinessGroup;

    @Column(name = "ID_BSNGP_LV")
    private Long idLevelBusinessGroup;

    @Column(name = "NM_BSNGP")
    private String nameBusinessGroup;

    @Column(name = "CREATED_STAMP")
    private Date createStamp;

    @Column(name = "LAST_UPDATED_STAMP")
    private Date lastUpdatedStamp;

    @Column(name = "STATUS")
    private Integer status;

    @OneToOne(fetch = FetchType.EAGER)
    private BusinessGroup parentBusinessGroup;

    public BusinessGroup() {

    }

    public BusinessGroup(Long idBusinessGroup, Long idLevelBusinessGroup, String nameBusinessGroup,
	    Date createStamp, Date lastUpdatedStamp, Integer status) {
	// TODO Auto-generated constructor stub
	this.idBusinessGroup = idBusinessGroup;
	this.idLevelBusinessGroup = idLevelBusinessGroup;
	this.nameBusinessGroup = nameBusinessGroup;
	this.createStamp = createStamp;
	this.lastUpdatedStamp = lastUpdatedStamp;
	this.status = status;
    }

    // INGRESAR
    public BusinessGroup(Long idLevelBusinessGroup, String nameBusinessGroup, Date createStamp, Integer status) {
	// TODO Auto-generated constructor stub
	this.idLevelBusinessGroup = idLevelBusinessGroup;
	this.nameBusinessGroup = nameBusinessGroup;
	this.createStamp = createStamp;
	this.status = status;

    }

    // UPDATE
    public BusinessGroup(Long idBusinessGroup, Long idLevelBusinessGroup, String nameBusinessGroup,
	    Date lastUpdatedStamp, Integer status) {
	// TODO Auto-generated constructor stub
	this.idLevelBusinessGroup = idLevelBusinessGroup;
	this.nameBusinessGroup = nameBusinessGroup;
	this.lastUpdatedStamp = lastUpdatedStamp;
	this.status = status;
	this.idBusinessGroup = idBusinessGroup;

    }

    public Integer getStatus() {
	return status;
    }

    public void setStatus(Integer status) {
	this.status = status;
    }

    public Long getIdBusinessGroup() {
	return idBusinessGroup;
    }

    public void setIdBusinessGroup(Long idBusinessGroup) {
	this.idBusinessGroup = idBusinessGroup;
    }

    public Long getIdLevelBusinessGroup() {
	return idLevelBusinessGroup;
    }

    public void setIdLevelBusinessGroup(Long idLevelBusinessGroup) {
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

    public BusinessGroup getParentBusinessGroup() {
	return parentBusinessGroup;
    }

    public void setParentBusinessGroup(BusinessGroup parentBusinessGroup) {
	this.parentBusinessGroup = parentBusinessGroup;
    }

}
