package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class FunctionalityModuleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long segFuncModuleId;
    private String description;
    private int status;
    private String module;
    private String code;

    public FunctionalityModuleDTO(Long segFuncModuleId, String module, String description, int status, String code) {
	this.segFuncModuleId = segFuncModuleId;
	this.module = module;
	this.description = description;
	this.status = status;
	this.code = code;
    }

    public long getSegFuncModuleId() {
	return segFuncModuleId;
    }

    public void setSegFuncModuleId(long segFuncModuleId) {
	this.segFuncModuleId = segFuncModuleId;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public FunctionalityModuleDTO() {

    }

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public String getModule() {
	return module;
    }

    public void setModule(String module) {
	this.module = module;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

}
