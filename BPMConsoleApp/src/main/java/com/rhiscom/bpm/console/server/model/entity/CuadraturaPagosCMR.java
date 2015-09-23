package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuad_pagoscmr")
public class CuadraturaPagosCMR {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private Long sucursal;
    private Date fechaTrx;
    private Long pagoNormal;
    private Long pagoRepactado;
    private Long pagoAnulado;

    private Long totalPagos;

    private Long totalAbonos;
    private Long totalAbonosCMRRepactacion;
    private Long totalAnulacionAbonoNormal;
    private Long totalAnulacionAbonoRepactacion;

    private Long trx217;
    private Long trx402;
    private Long totalCRCMR;
    private Long diferenciaPLCUACRCMR;
    private Long diferenciaSCTFACRCMR;

    private Long totalPagosSctfa;
    private Long diferenciaPLACUASCTFA;

    private Long totalPagosSAT;
    private Long totalAnulacionesSAT;
    private Long totalFinalPagosSAT;

    private Long totalPagosRSAT;
    private Long totalAnulacionesRSAT;
    private Long totalFinalPagosRSAT;

    private Long diferenciaRSATCRCMR;
    private Long diferenciaSATCRCMR;

    public Long getTotalPagosSAT() {
	return totalPagosSAT;
    }

    public void setTotalPagosSAT(Long totalPagosSAT) {
	this.totalPagosSAT = totalPagosSAT;
    }

    public Long getTotalAnulacionesSAT() {
	return totalAnulacionesSAT;
    }

    public void setTotalAnulacionesSAT(Long totalAnulacionesSAT) {
	this.totalAnulacionesSAT = totalAnulacionesSAT;
    }

    public Long getTotalFinalPagosSAT() {
	return totalFinalPagosSAT;
    }

    public void setTotalFinalPagosSAT(Long totalFinalPagosSAT) {
	this.totalFinalPagosSAT = totalFinalPagosSAT;
    }

    public Long getTotalPagosRSAT() {
	return totalPagosRSAT;
    }

    public void setTotalPagosRSAT(Long totalPagosRSAT) {
	this.totalPagosRSAT = totalPagosRSAT;
    }

    public Long getTotalAnulacionesRSAT() {
	return totalAnulacionesRSAT;
    }

    public void setTotalAnulacionesRSAT(Long totalAnulacionesRSAT) {
	this.totalAnulacionesRSAT = totalAnulacionesRSAT;
    }

    public Long getTotalFinalPagosRSAT() {
	return totalFinalPagosRSAT;
    }

    public void setTotalFinalPagosRSAT(Long totalFinalPagosRSAT) {
	this.totalFinalPagosRSAT = totalFinalPagosRSAT;
    }

    public Long getDiferenciaRSATCRCMR() {
	return diferenciaRSATCRCMR;
    }

    public void setDiferenciaRSATCRCMR(Long diferenciaRSATCRCMR) {
	this.diferenciaRSATCRCMR = diferenciaRSATCRCMR;
    }

    public Long getDiferenciaSATCRCMR() {
	return diferenciaSATCRCMR;
    }

    public void setDiferenciaSATCRCMR(Long diferenciaSATCRCMR) {
	this.diferenciaSATCRCMR = diferenciaSATCRCMR;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public Long getPagoNormal() {
	return pagoNormal;
    }

    public void setPagoNormal(Long pagoNormal) {
	this.pagoNormal = pagoNormal;
    }

    public Long getPagoRepactado() {
	return pagoRepactado;
    }

    public void setPagoRepactado(Long pagoRepactado) {
	this.pagoRepactado = pagoRepactado;
    }

    public Long getPagoAnulado() {
	return pagoAnulado;
    }

    public void setPagoAnulado(Long pagoAnulado) {
	this.pagoAnulado = pagoAnulado;
    }

    public Long getTotalPagos() {
	return totalPagos;
    }

    public void setTotalPagos(Long totalPagos) {
	this.totalPagos = totalPagos;
    }

    public Long getTotalAbonos() {
	return totalAbonos;
    }

    public void setTotalAbonos(Long totalAbonos) {
	this.totalAbonos = totalAbonos;
    }

    public Long getTotalAbonosCMRRepactacion() {
	return totalAbonosCMRRepactacion;
    }

    public void setTotalAbonosCMRRepactacion(Long totalAbonosCMRRepactacion) {
	this.totalAbonosCMRRepactacion = totalAbonosCMRRepactacion;
    }

    public Long getTotalAnulacionAbonoNormal() {
	return totalAnulacionAbonoNormal;
    }

    public void setTotalAnulacionAbonoNormal(Long totalAnulacionAbonoNormal) {
	this.totalAnulacionAbonoNormal = totalAnulacionAbonoNormal;
    }

    public Long getTotalAnulacionAbonoRepactacion() {
	return totalAnulacionAbonoRepactacion;
    }

    public void setTotalAnulacionAbonoRepactacion(Long totalAnulacionAbonoRepactacion) {
	this.totalAnulacionAbonoRepactacion = totalAnulacionAbonoRepactacion;
    }

    public Long getTrx217() {
	return trx217;
    }

    public void setTrx217(Long trx217) {
	this.trx217 = trx217;
    }

    public Long getTrx402() {
	return trx402;
    }

    public void setTrx402(Long trx402) {
	this.trx402 = trx402;
    }

    public Long getTotalCRCMR() {
	return totalCRCMR;
    }

    public void setTotalCRCMR(Long totalCRCMR) {
	this.totalCRCMR = totalCRCMR;
    }

    public Long getDiferenciaPLCUACRCMR() {
	return diferenciaPLCUACRCMR;
    }

    public void setDiferenciaPLCUACRCMR(Long diferenciaPLCUACRCMR) {
	this.diferenciaPLCUACRCMR = diferenciaPLCUACRCMR;
    }

    public Long getDiferenciaSCTFACRCMR() {
	return diferenciaSCTFACRCMR;
    }

    public void setDiferenciaSCTFACRCMR(Long diferenciaSCTFACRCMR) {
	this.diferenciaSCTFACRCMR = diferenciaSCTFACRCMR;
    }

    public Long getTotalPagosSctfa() {
	return totalPagosSctfa;
    }

    public void setTotalPagosSctfa(Long totalPagosSctfa) {
	this.totalPagosSctfa = totalPagosSctfa;
    }

    public Long getDiferenciaPLACUASCTFA() {
	return diferenciaPLACUASCTFA;
    }

    public void setDiferenciaPLACUASCTFA(Long diferenciaPLACUASCTFA) {
	this.diferenciaPLACUASCTFA = diferenciaPLACUASCTFA;
    }

}
