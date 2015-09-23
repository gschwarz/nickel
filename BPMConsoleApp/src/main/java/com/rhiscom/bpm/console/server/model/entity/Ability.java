package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "seg_ability")
public class Ability extends BaseValue {

    @Id
    @GeneratedValue
    @Column(name = "segAbilityId")
    private Long segAbilityId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;

    public Ability(long segAbilityId, String name, String description, int status) {
	this.segAbilityId = segAbilityId;
	this.name = name;
	this.description = description;
	this.status = status;
    }

    public Long getSegAbilityId() {
	return segAbilityId;
    }

    public void setSegAbilityId(Long segAbilityId) {
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

    public Ability() {

    }

}
