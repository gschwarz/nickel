package com.rhiscom.cuadratura.model;

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
