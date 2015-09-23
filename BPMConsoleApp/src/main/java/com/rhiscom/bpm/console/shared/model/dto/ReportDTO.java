package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class ReportDTO implements Serializable {

    private Long id;
    private String name;
    private String desc;
    private String code;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDesc() {
	return desc;
    }

    public void setDesc(String desc) {
	this.desc = desc;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

}
