package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rhiscom.bpm.console.util.BaseValue;

@Entity
@Table(name = "proc_config_scheduler")
public class ProcessScheduler extends BaseValue {

    private static final long serialVersionUID = 1L;

    public ProcessScheduler() {
	
    }
    @Id
    @GeneratedValue
    @Column(name = "proc_config_scheduler_id")
    private Long processConfigId;

    @Column(name = "initDate", nullable = true)
    private Date initDate;

    @Column(name = "endDate", nullable = true)
    private Date endDate;
    private int isLunes;
    private int isMartes;
    private int isMiercoles;
    private int isJueves;
    private int isViernes;
    private int isSabado;
    private int isDomingo;
    private String horaInicio;
    private String minutoInicio;
    private String processId;

    public int getIsLunes() {
	return isLunes;
    }

    public void setIsLunes(int isLunes) {
	this.isLunes = isLunes;
    }

    public int getIsMartes() {
	return isMartes;
    }

    public void setIsMartes(int isMartes) {
	this.isMartes = isMartes;
    }

    public int getIsMiercoles() {
	return isMiercoles;
    }

    public void setIsMiercoles(int isMiercoles) {
	this.isMiercoles = isMiercoles;
    }

    public int getIsJueves() {
	return isJueves;
    }

    public void setIsJueves(int isJueves) {
	this.isJueves = isJueves;
    }

    public int getIsViernes() {
	return isViernes;
    }

    public void setIsViernes(int isViernes) {
	this.isViernes = isViernes;
    }

    public int getIsSabado() {
	return isSabado;
    }

    public void setIsSabado(int isSabado) {
	this.isSabado = isSabado;
    }

    public int getIsDomingo() {
	return isDomingo;
    }

    public void setIsDomingo(int isDomingo) {
	this.isDomingo = isDomingo;
    }

    public Long getProcessConfigId() {
	return processConfigId;
    }

    public void setProcessConfigId(Long processConfigId) {
	this.processConfigId = processConfigId;
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

    public String getHoraInicio() {
	return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
	this.horaInicio = horaInicio;
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

}
