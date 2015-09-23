package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "seg_func_module")
public class FunctionalityModule extends BaseValue {

    @Id
    @GeneratedValue
    @Column(name = "segFuncModuleId")
    private Long segFuncModuleId;

    @Column(name = "description")
    private String description;

    @Column(name = "module")
    private String module;

    @Column(name = "status")
    private int status;
    @Column(name = "code")
    private String code;

    public FunctionalityModule(long segFuncModuleId, String module, String description, int status, String code) {
	this.segFuncModuleId = segFuncModuleId;
	this.module = module;
	this.description = description;
	this.status = status;
	this.setCode(code);
    }

    public Long getSegFuncModuleId() {
	return segFuncModuleId;
    }

    public void setSegFuncModuleId(Long segFuncModuleId) {
	this.segFuncModuleId = segFuncModuleId;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getModule() {
	return module;
    }

    public void setModule(String module) {
	this.module = module;
    }

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public FunctionalityModule() {

    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

}
