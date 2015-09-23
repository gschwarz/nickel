package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class AccessProfileFunctionalityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long segAccessProfileFuncId;
    private long segProfileId;
    private long segFuncModuleId;

    public long getSegAccessProfileFuncId() {
	return segAccessProfileFuncId;
    }

    public void setSegAccessProfileFuncId(long segAccessProfileFuncId) {
	this.segAccessProfileFuncId = segAccessProfileFuncId;
    }

    public long getSegProfileId() {
	return segProfileId;
    }

    public void setSegProfileId(long segProfileId) {
	this.segProfileId = segProfileId;
    }

    public long getSegFuncModuleId() {
	return segFuncModuleId;
    }

    public void setSegFuncModuleId(long segFuncModuleId) {
	this.segFuncModuleId = segFuncModuleId;
    }

    public AccessProfileFunctionalityDTO() {

    }

}
