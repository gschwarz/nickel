package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class ProfileDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long segProfileId;
    private String name;
    private String description;
    private int status;
    private Date createStamp;
    private Date updateStamp;
    private Set<AccessProfileFunctionalityAbilityDTO> accessProfileFunctionalityAbility;

    public ProfileDTO(String name, String description, int status, Date createStamp,
	    Set<AccessProfileFunctionalityAbilityDTO> accessProfileFunctionalityAbility) {

	this.name = name;
	this.status = status;
	this.createStamp = createStamp;
	this.accessProfileFunctionalityAbility = accessProfileFunctionalityAbility;
	this.description = description;

    }

    public ProfileDTO(long id, String name, String description, int status, Date createStamp, Date updateStamp,
	    Set<AccessProfileFunctionalityAbilityDTO> accessProfileFunctionalityAbility) {

	this.segProfileId = id;
	this.name = name;
	this.status = status;
	this.createStamp = createStamp;
	this.updateStamp = updateStamp;
	this.description = description;
	this.accessProfileFunctionalityAbility = accessProfileFunctionalityAbility;
    }

    public ProfileDTO() {
	// TODO Auto-generated constructor stub
    }

    public long getSegProfileId() {
	return segProfileId;
    }

    public void setSegProfileId(long segProfileId) {
	this.segProfileId = segProfileId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
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

    public Set<AccessProfileFunctionalityAbilityDTO> getAccessProfileFunctionalityAbility() {
	return accessProfileFunctionalityAbility;
    }

    public void setAccessProfileFunctionalityAbility(
	    Set<AccessProfileFunctionalityAbilityDTO> accessProfileFunctionalityAbility) {
	this.accessProfileFunctionalityAbility = accessProfileFunctionalityAbility;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
