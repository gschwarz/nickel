package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lo_bsn_un")
public class BusinessUnit {

    @Id
    @GeneratedValue
    @Column(name = "ID_BSN_UN")
    private Long idBusinessUnit;

    @Column(name = "ID_BSN_CODE")
    private String code;

    @Column(name = "ID_BSNGP")
    private Long idBusinessGroup;

    @Column(name = "NM_BSN_UN")
    private String nameBusinessUnit;

    @Column(name = "CREATED_STAMP")
    private Date createStamp;

    @Column(name = "LAST_UPDATED_STAMP")
    private Date lastUpdatedStamp;

    @Column(name = "STATUS")
    private Integer status;

    public BusinessUnit() {

    }

    public BusinessUnit(Long idBusinessUnit, Long idBusinessGroup, String nameBusinessUnit, Date createStamp,
	    Date lastUpdatedStamp, Integer status, String code) {
	// TODO Auto-generated constructor stub

	this.idBusinessUnit = idBusinessUnit;
	this.idBusinessGroup = idBusinessGroup;
	this.nameBusinessUnit = nameBusinessUnit;
	this.createStamp = createStamp;
	this.lastUpdatedStamp = lastUpdatedStamp;
	this.status = status;
	this.code = code;

    }

    // INGRESO
    public BusinessUnit(Long idBusinessGroup, String nameBusinessUnit, Date createStamp, int status, String code) {
	// TODO Auto-generated constructor stub

	this.idBusinessGroup = idBusinessGroup;
	this.nameBusinessUnit = nameBusinessUnit;
	this.createStamp = createStamp;
	this.status = status;
	this.code = code;

    }

    // UPDATE
    public BusinessUnit(Long idBusinessUnit, Long idBusinessGroup, String nameBusinessUnit, Date lastUpdatedStamp,
	    Integer status, String code) {
	// TODO Auto-generated constructor stub

	this.idBusinessUnit = idBusinessUnit;
	this.idBusinessGroup = idBusinessGroup;
	this.nameBusinessUnit = nameBusinessUnit;
	this.lastUpdatedStamp = lastUpdatedStamp;
	this.status = status;
	this.code = code;

    }

    public Long getIdBusinessUnit() {
	return idBusinessUnit;
    }

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public void setIdBusinessUnit(Long idBusinessUnit) {
	this.idBusinessUnit = idBusinessUnit;
    }

    public Long getIdBusinessGroup() {
	return idBusinessGroup;
    }

    public void setIdBusinessGroup(Long idBusinessGroup) {
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

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

}
