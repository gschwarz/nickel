package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class VersionDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private long id;
    private Date initDate;
    private Date endDate;
    private String server;
    private String description;
    private String year;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Date getInitDate() {
	return initDate;
    }

    public void setInitDate(Date initDate) {
	this.initDate = initDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public String getServer() {
	return server;
    }

    public void setServer(String server) {
	this.server = server;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getYear() {
	return year;
    }

    public void setYear(String year) {
	this.year = year;
    }

}
