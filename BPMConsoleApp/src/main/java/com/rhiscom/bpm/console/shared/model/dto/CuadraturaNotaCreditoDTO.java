package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class CuadraturaNotaCreditoDTO implements Serializable {

    private long id;

    private long ncrTvPLCUa;
    private long totalAnulacionesNCRPSCRE;
    private long diferenciaPLACUAPSCRE;
    private long totalAnulacionesNCRPLC;
    private long diferenciaPSCREPLC;
    private long sucursal;
    private Date fechaTrx;
    private String versionPOS;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public long getNcrTvPLCUa() {
	return ncrTvPLCUa;
    }

    public void setNcrTvPLCUa(long ncrTvPLCUa) {
	this.ncrTvPLCUa = ncrTvPLCUa;
    }

    public long getTotalAnulacionesNCRPSCRE() {
	return totalAnulacionesNCRPSCRE;
    }

    public void setTotalAnulacionesNCRPSCRE(long totalAnulacionesNCRPSCRE) {
	this.totalAnulacionesNCRPSCRE = totalAnulacionesNCRPSCRE;
    }

    public long getDiferenciaPLACUAPSCRE() {
	return diferenciaPLACUAPSCRE;
    }

    public void setDiferenciaPLACUAPSCRE(long diferenciaPLACUAPSCRE) {
	this.diferenciaPLACUAPSCRE = diferenciaPLACUAPSCRE;
    }

    public long getTotalAnulacionesNCRPLC() {
	return totalAnulacionesNCRPLC;
    }

    public void setTotalAnulacionesNCRPLC(long totalAnulacionesNCRPLC) {
	this.totalAnulacionesNCRPLC = totalAnulacionesNCRPLC;
    }

    public long getDiferenciaPSCREPLC() {
	return diferenciaPSCREPLC;
    }

    public void setDiferenciaPSCREPLC(long diferenciaPSCREPLC) {
	this.diferenciaPSCREPLC = diferenciaPSCREPLC;
    }

    public long getSucursal() {
	return sucursal;
    }

    public void setSucursal(long sucursal) {
	this.sucursal = sucursal;
    }

    public Date getFechaTrx() {
	return fechaTrx;
    }

    public void setFechaTrx(Date fechaTrx) {
	this.fechaTrx = fechaTrx;
    }

    public String getVersionPOS() {
	return versionPOS;
    }

    public void setVersionPOS(String versionPOS) {
	this.versionPOS = versionPOS;
    }

}
