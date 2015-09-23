package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class AbilityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long segAbilityId;
    private String name;
    private String description;
    private int status;
    private long moduleIdTemp;

    public AbilityDTO() {

    }

    public AbilityDTO(Long segAbilityId, String name, String description, int status) {
	this.segAbilityId = segAbilityId;
	this.name = name;
	this.description = description;
	this.status = status;
    }

    public long getSegAbilityId() {
	return segAbilityId;
    }

    public void setSegAbilityId(long segAbilityId) {
	this.segAbilityId = segAbilityId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public long getModuleIdTemp() {
	return moduleIdTemp;
    }

    public void setModuleIdTemp(long moduleIdTemp) {
	this.moduleIdTemp = moduleIdTemp;
    }

}
