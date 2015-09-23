package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class AccessProfileFunctionalityAbilityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long segAccessProfileFuncAbilityId;
    private long segProfileId;
    private FunctionalityModuleDTO segAccessProfileFunc;
    private AbilityDTO segAbility;

    public AccessProfileFunctionalityAbilityDTO(AbilityDTO segAbility,
	    FunctionalityModuleDTO segAccessProfileFunc, long segAccessProfileFuncAbilityId) {
	this.segAbility = segAbility;
	this.segAccessProfileFunc = segAccessProfileFunc;
	this.segAccessProfileFuncAbilityId = segAccessProfileFuncAbilityId;

    }

    public AccessProfileFunctionalityAbilityDTO() {
	// TODO Auto-generated constructor stub
    }

    public long getSegAccessProfileFuncAbilityId() {
	return segAccessProfileFuncAbilityId;
    }

    public void setSegAccessProfileFuncAbilityId(long segAccessProfileFuncAbilityId) {
	this.segAccessProfileFuncAbilityId = segAccessProfileFuncAbilityId;
    }

    public long getSegProfileId() {
	return segProfileId;
    }

    public void setSegProfileId(long segProfileId) {
	this.segProfileId = segProfileId;
    }

    public FunctionalityModuleDTO getSegAccessProfileFunc() {
	return segAccessProfileFunc;
    }

    public void setSegAccessProfileFunc(FunctionalityModuleDTO segAccessProfileFunc) {
	this.segAccessProfileFunc = segAccessProfileFunc;
    }

    public AbilityDTO getSegAbility() {
	return segAbility;
    }

    public void setSegAbility(AbilityDTO segAbility) {
	this.segAbility = segAbility;
    }

}
