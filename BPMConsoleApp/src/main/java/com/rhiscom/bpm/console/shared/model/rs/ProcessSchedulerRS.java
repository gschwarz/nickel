package com.rhiscom.bpm.console.shared.model.rs;

import java.util.Date;

public class ProcessSchedulerRS {
	private Long id;
	private Date initDate;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getMinutoInicio() {
		return minutoInicio;
	}
	public void setMinutoInicio(String minutoInicio) {
		this.minutoInicio = minutoInicio;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public int getIsViernes() {
		return isViernes;
	}
	public void setIsViernes(int isViernes) {
		this.isViernes = isViernes;
	}

}
