package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private long projectID;
    private Date creationDate;
    private long externalProviderID;
    private String name;
    private String summary;

    public long getProjectID() {
	return projectID;
    }

    public void setProjectID(long projectID) {
	this.projectID = projectID;
    }

    public String getSummary() {
	return summary;
    }

    public void setSummary(String summary) {
	this.summary = summary;
    }

    public void setExternalProviderID(long externalProviderID) {
	this.externalProviderID = externalProviderID;
    }

    public Date getCreationDate() {
	return creationDate;
    }

    public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
    }

    public Long getExternalProviderID() {
	return externalProviderID;
    }

    public void setExternalProviderID(Long externalProviderID) {
	this.externalProviderID = externalProviderID;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public ProjectDTO() {

    }

}
