package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "pa_wkgrp")
public class ResolverGroup extends BaseValue {

    @Id
    @GeneratedValue
    @Column(name = "workGroupId")
    private Long workGroupId;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    public ResolverGroup() {

    }

    public ResolverGroup(String name, String desc) {

	this.description = desc;
	this.name = name;

    }

    public ResolverGroup(Long id, String name, String desc) {

	this.workGroupId = id;
	this.description = desc;

	this.name = name;

    }

    public Long getWorkGroupId() {
	return workGroupId;
    }

    public void setWorkGroupId(Long workGroupId) {
	this.workGroupId = workGroupId;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
