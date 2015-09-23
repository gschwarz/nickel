package com.rhiscom.bpm.console.server.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuad_notacredito")
public class CuadraturaNotaCredito implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private Long ncrTvPLCUa;
    private Long totalAnulacionesNCRPSCRE;
    private Long diferenciaPLACUAPSCRE;
    private Long totalAnulacionesNCRPLC;
    private Long diferenciaPSCREPLC;
    private Long sucursal;
    private Date fechaTrx;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getNcrTvPLCUa() {
	return ncrTvPLCUa;
    }

    public void setNcrTvPLCUa(Long ncrTvPLCUa) {
	this.ncrTvPLCUa = ncrTvPLCUa;
    }

    public Long getTotalAnulacionesNCRPSCRE() {
	return totalAnulacionesNCRPSCRE;
    }

    public void setTotalAnulacionesNCRPSCRE(Long totalAnulacionesNCRPSCRE) {
	this.totalAnulacionesNCRPSCRE = totalAnulacionesNCRPSCRE;
    }

    public Long getDiferenciaPLACUAPSCRE() {
	return diferenciaPLACUAPSCRE;
    }

    public void setDiferenciaPLACUAPSCRE(Long diferenciaPLACUAPSCRE) {
	this.diferenciaPLACUAPSCRE = diferenciaPLACUAPSCRE;
    }

    public Long getTotalAnulacionesNCRPLC() {
	return totalAnulacionesNCRPLC;
    }

    public void setTotalAnulacionesNCRPLC(Long totalAnulacionesNCRPLC) {
	this.totalAnulacionesNCRPLC = totalAnulacionesNCRPLC;
    }

    public Long getDiferenciaPSCREPLC() {
	return diferenciaPSCREPLC;
    }

    public void setDiferenciaPSCREPLC(Long diferenciaPSCREPLC) {
	this.diferenciaPSCREPLC = diferenciaPSCREPLC;
    }

    public Long getSucursal() {
	return sucursal;
    }

    public void setSucursal(Long sucursal) {
	this.sucursal = sucursal;
    }

    public Date getFechaTrx() {
	return fechaTrx;
    }

    public void setFechaTrx(Date fechaTrx) {
	this.fechaTrx = fechaTrx;
    }

}
