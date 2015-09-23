package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "seg_profile")
public class Profile extends BaseValue {

    @Id
    @GeneratedValue
    @Column(name = "segProfileId")
    private Long segProfileId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;

    @Column(name = "createStamp")
    private Date createStamp;

    @Column(name = "updateStamp")
    private Date updateStamp;

    /**
     * Constructor para la creación de una nueva entidad.
     * 
     * @param name
     * @param status
     * @param createStamp
     * @param accessProfileFunctionalityAbility
     */
    public Profile(String name, String description, int status, Date createStamp) {
	this.name = name;
	this.status = status;
	this.createStamp = createStamp;

	this.description = description;
    }

    /**
     * Constructor para la edición de una entidad.
     * 
     * @param segProfileId
     * @param name
     * @param status
     * @param updateStamp
     * @param accessProfileFunctionalityAbility
     */
    public Profile(long segProfileId, String name, String description, int status, Date createStamp,
	    Date updateStamp) {

	this.segProfileId = segProfileId;
	this.name = name;
	this.status = status;
	this.updateStamp = updateStamp;
	this.createStamp = createStamp;
	this.description = description;

    }

    public Long getSegProfileId() {
	return segProfileId;
    }

    public void setSegProfileId(Long segProfileId) {
	this.segProfileId = segProfileId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getStatus() {
	return status;
    }

    public void setStatus(Integer status) {
	this.status = status;
    }

    public Date getCreateStamp() {
	return createStamp;
    }

    public void setCreateStamp(Date createStamp) {
	this.createStamp = createStamp;
    }

    public Date getUpdateStamp() {
	return updateStamp;
    }

    public void setUpdateStamp(Date updateStamp) {
	this.updateStamp = updateStamp;
    }

    public Profile() {

    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
