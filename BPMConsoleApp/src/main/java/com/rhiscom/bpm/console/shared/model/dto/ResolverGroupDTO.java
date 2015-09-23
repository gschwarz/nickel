package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class ResolverGroupDTO implements Serializable {
    private Long workGroupid;
    private String description;
    private String name;

    private static final long serialVersionUID = 1L;

    public ResolverGroupDTO(Long id, String name, String description) {
	this.workGroupid = id;
	this.description = description;

	this.name = name;

    }

    public ResolverGroupDTO() {
	// TODO Auto-generated constructor stub
    }

    public Long getWorkGroupid() {
	return workGroupid;
    }

    public void setWorkGroupid(Long workGroupid) {
	this.workGroupid = workGroupid;
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
