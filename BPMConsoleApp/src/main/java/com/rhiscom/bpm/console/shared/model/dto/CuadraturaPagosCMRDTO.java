package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class CuadraturaPagosCMRDTO implements Serializable {

    private long id;
    private long sucursal;
    private Date fechaTrx;
    private long pagoNormal;
    private long pagoRepactado;
    private long pagoAnulado;

    private long totalPagos;

    private long totalAbonos;
    private long totalAbonosCMRRepactacion;
    private long totalAnulacionAbonoNormal;
    private long totalAnulacionAbonoRepactacion;

    private long trx217;
    private long trx402;
    private long totalCRCMR;
    private long diferenciaPLCUACRCMR;
    private long diferenciaSCTFACRCMR;

    private long totalPagosSctfa;
    private long diferenciaPLACUASCTFA;
    private String versionPOS;

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

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
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

    public long getPagoNormal() {
	return pagoNormal;
    }

    public void setPagoNormal(long pagoNormal) {
	this.pagoNormal = pagoNormal;
    }

    public long getPagoRepactado() {
	return pagoRepactado;
    }

    public void setPagoRepactado(long pagoRepactado) {
	this.pagoRepactado = pagoRepactado;
    }

    public long getPagoAnulado() {
	return pagoAnulado;
    }

    public void setPagoAnulado(long pagoAnulado) {
	this.pagoAnulado = pagoAnulado;
    }

    public long getTotalPagos() {
	return totalPagos;
    }

    public void setTotalPagos(long totalPagos) {
	this.totalPagos = totalPagos;
    }

    public long getTotalAbonos() {
	return totalAbonos;
    }

    public void setTotalAbonos(long totalAbonos) {
	this.totalAbonos = totalAbonos;
    }

    public long getTotalAbonosCMRRepactacion() {
	return totalAbonosCMRRepactacion;
    }

    public void setTotalAbonosCMRRepactacion(long totalAbonosCMRRepactacion) {
	this.totalAbonosCMRRepactacion = totalAbonosCMRRepactacion;
    }

    public long getTotalAnulacionAbonoNormal() {
	return totalAnulacionAbonoNormal;
    }

    public void setTotalAnulacionAbonoNormal(long totalAnulacionAbonoNormal) {
	this.totalAnulacionAbonoNormal = totalAnulacionAbonoNormal;
    }

    public long getTotalAnulacionAbonoRepactacion() {
	return totalAnulacionAbonoRepactacion;
    }

    public void setTotalAnulacionAbonoRepactacion(long totalAnulacionAbonoRepactacion) {
	this.totalAnulacionAbonoRepactacion = totalAnulacionAbonoRepactacion;
    }

    public long getTrx217() {
	return trx217;
    }

    public void setTrx217(long trx217) {
	this.trx217 = trx217;
    }

    public long getTrx402() {
	return trx402;
    }

    public void setTrx402(long trx402) {
	this.trx402 = trx402;
    }

    public long getTotalCRCMR() {
	return totalCRCMR;
    }

    public void setTotalCRCMR(long totalCRCMR) {
	this.totalCRCMR = totalCRCMR;
    }

    public long getDiferenciaPLCUACRCMR() {
	return diferenciaPLCUACRCMR;
    }

    public void setDiferenciaPLCUACRCMR(long diferenciaPLCUACRCMR) {
	this.diferenciaPLCUACRCMR = diferenciaPLCUACRCMR;
    }

    public long getDiferenciaSCTFACRCMR() {
	return diferenciaSCTFACRCMR;
    }

    public void setDiferenciaSCTFACRCMR(long diferenciaSCTFACRCMR) {
	this.diferenciaSCTFACRCMR = diferenciaSCTFACRCMR;
    }

    public long getTotalPagosSctfa() {
	return totalPagosSctfa;
    }

    public void setTotalPagosSctfa(long totalPagosSctfa) {
	this.totalPagosSctfa = totalPagosSctfa;
    }

    public long getDiferenciaPLACUASCTFA() {
	return diferenciaPLACUASCTFA;
    }

    public void setDiferenciaPLACUASCTFA(long diferenciaPLACUASCTFA) {
	this.diferenciaPLACUASCTFA = diferenciaPLACUASCTFA;
    }

    public String getVersionPOS() {
	return versionPOS;
    }

    public void setVersionPOS(String versionPOS) {
	this.versionPOS = versionPOS;
    }

}
