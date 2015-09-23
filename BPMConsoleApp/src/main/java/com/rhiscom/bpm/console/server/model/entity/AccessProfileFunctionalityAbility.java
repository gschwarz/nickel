package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "seg_access_profile_func_ability")
public class AccessProfileFunctionalityAbility extends BaseValue {

    @Id
    @GeneratedValue
    @Column(name = "segAccessProfileFuncAbilityId")
    private Long segAccessProfileFuncAbilityId;

    @ManyToOne(fetch = FetchType.EAGER)
    private FunctionalityModule segAccessProfileFunc;

    @ManyToOne(fetch = FetchType.EAGER)
    private Ability segAbility;

    @Column(name = "segProfileId")
    private Long segProfileId;

    public AccessProfileFunctionalityAbility(long segAccessProfileFuncAbilityId,
	    FunctionalityModule segAccessProfileFunc, Ability segAbility) {
	this.segAccessProfileFuncAbilityId = segAccessProfileFuncAbilityId;
	this.segAbility = segAbility;
	this.segAccessProfileFunc = segAccessProfileFunc;

    }

    public AccessProfileFunctionalityAbility(FunctionalityModule segAccessProfileFunc, Ability segAbility) {
	this.segAbility = segAbility;
	this.segAccessProfileFunc = segAccessProfileFunc;
    }

    public Long getSegAccessProfileFuncAbilityId() {
	return segAccessProfileFuncAbilityId;
    }

    public void setSegAccessProfileFuncAbilityId(Long segAccessProfileFuncAbilityId) {
	this.segAccessProfileFuncAbilityId = segAccessProfileFuncAbilityId;
    }

    public AccessProfileFunctionalityAbility() {

    }

    public FunctionalityModule getSegAccessProfileFunc() {
	return segAccessProfileFunc;
    }

    public void setSegAccessProfileFunc(FunctionalityModule segAccessProfileFunc) {
	this.segAccessProfileFunc = segAccessProfileFunc;
    }

    public Ability getSegAbility() {
	return segAbility;
    }

    public void setSegAbility(Ability segAbility) {
	this.segAbility = segAbility;
    }

    @Override
    public int hashCode() {
	if (segAccessProfileFuncAbilityId != null) {
	    return segAccessProfileFuncAbilityId.hashCode();
	} else {
	    return super.hashCode();
	}
    }

    public Long getSegProfileId() {
	return segProfileId;
    }

    public void setSegProfileId(Long segProfileId) {
	this.segProfileId = segProfileId;
    }
}
