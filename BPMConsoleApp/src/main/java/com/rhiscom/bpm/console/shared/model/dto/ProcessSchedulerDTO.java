package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class ProcessSchedulerDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date initDate;
    private Date endDate;
    private Boolean isLunes;
    private Boolean isMartes;
    private Boolean isMiercoles;
    private Boolean isJueves;
    private Boolean isViernes;
    private Boolean isSabado;
    private Boolean isDomingo;
    private String horaInicio;
    private String minutoInicio;
    private String processId;

    public String getHoraInicio() {
	return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
	this.horaInicio = horaInicio;
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

    public Boolean getIsLunes() {
	return isLunes;
    }

    public void setIsLunes(Boolean isLunes) {
	this.isLunes = isLunes;
    }

    public Boolean getIsMartes() {
	return isMartes;
    }

    public void setIsMartes(Boolean isMartes) {
	this.isMartes = isMartes;
    }

    public Boolean getIsMiercoles() {
	return isMiercoles;
    }

    public void setIsMiercoles(Boolean isMiercoles) {
	this.isMiercoles = isMiercoles;
    }

    public Boolean getIsJueves() {
	return isJueves;
    }

    public void setIsJueves(Boolean isJueves) {
	this.isJueves = isJueves;
    }

    public Boolean getIsViernes() {
	return isViernes;
    }

    public void setIsViernes(Boolean isViernes) {
	this.isViernes = isViernes;
    }

    public Boolean getIsSabado() {
	return isSabado;
    }

    public void setIsSabado(Boolean isSabado) {
	this.isSabado = isSabado;
    }

    public Boolean getIsDomingo() {
	return isDomingo;
    }

    public void setIsDomingo(Boolean isDomingo) {
	this.isDomingo = isDomingo;
    }

    public String getProcessId() {
	return processId;
    }

    public void setProcessId(String processId) {
	this.processId = processId;
    }

    public String getMinutoInicio() {
	return minutoInicio;
    }

    public void setMinutoInicio(String minutoInicio) {
	this.minutoInicio = minutoInicio;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

}
