package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class CuadraturaTarjetaCreditoDTO implements Serializable {
    private long id;

    private long tarjetaBancariaVisa;
    private long tarjetaBancariaDiners;
    private long donaciones;

    private long totalPLCUA;

    /** ARQ_TV **/

    private long totalVentasTarjetaCreditoPSCRE;
    private long totalVentasInternetCreditoPSCRE;
    private long recaudacionesPSCRE;
    private long totalVentasAnulacionesPSCRE;
    private long anulacionRecaudacionesPSCRE;

    private long totalPSCRE;
    /*
     * PLC
     */
    private long totalVentasTarjetaCreditoPLC;
    private long totalVentasInternetCreditoPLC;
    private long totalAnulacionesNCAPLC;
    private long totalRecaudacionesPLC;
    private long totalAnulacionRecaudacionesPLC;

    private long totalPLC;

    private long diferenciaPLCUAPSCRE;
    private long diferenciaPSCREPLC;
    private long sucursal;
    private Date fechaTrx;

    private long pagoRemotoCreditoPLCUA;

    private long pagoRemotoCreditoPSCRE;

    private long totalAnulacionesPagoRemoto;

    private long totalPagoRemotoPSCRE;

    private long totalVentasPagoRemotoCreditoPLC;
    private long totalAnulacionesPagoRemotoCreditoPLC;

    private long totalPagoRemotoPLC;

    private long diferenciaPagoRemotoPLCUAPSCRE;
    private long diferenciaPagoRemotoPSCREPLC;

    private String versionPOS;

    public long getPagoRemotoCreditoPLCUA() {
	return pagoRemotoCreditoPLCUA;
    }

    public void setPagoRemotoCreditoPLCUA(long pagoRemotoCreditoPLCUA) {
	this.pagoRemotoCreditoPLCUA = pagoRemotoCreditoPLCUA;
    }

    public long getPagoRemotoCreditoPSCRE() {
	return pagoRemotoCreditoPSCRE;
    }

    public void setPagoRemotoCreditoPSCRE(long pagoRemotoCreditoPSCRE) {
	this.pagoRemotoCreditoPSCRE = pagoRemotoCreditoPSCRE;
    }

    public long getTotalAnulacionesPagoRemoto() {
	return totalAnulacionesPagoRemoto;
    }

    public void setTotalAnulacionesPagoRemoto(long totalAnulacionesPagoRemoto) {
	this.totalAnulacionesPagoRemoto = totalAnulacionesPagoRemoto;
    }

    public long getTotalPagoRemotoPSCRE() {
	return totalPagoRemotoPSCRE;
    }

    public void setTotalPagoRemotoPSCRE(long totalPagoRemotoPSCRE) {
	this.totalPagoRemotoPSCRE = totalPagoRemotoPSCRE;
    }

    public long getTotalVentasPagoRemotoCreditoPLC() {
	return totalVentasPagoRemotoCreditoPLC;
    }

    public void setTotalVentasPagoRemotoCreditoPLC(long totalVentasPagoRemotoCreditoPLC) {
	this.totalVentasPagoRemotoCreditoPLC = totalVentasPagoRemotoCreditoPLC;
    }

    public long getTotalAnulacionesPagoRemotoCreditoPLC() {
	return totalAnulacionesPagoRemotoCreditoPLC;
    }

    public void setTotalAnulacionesPagoRemotoCreditoPLC(long totalAnulacionesPagoRemotoCreditoPLC) {
	this.totalAnulacionesPagoRemotoCreditoPLC = totalAnulacionesPagoRemotoCreditoPLC;
    }

    public long getTotalPagoRemotoPLC() {
	return totalPagoRemotoPLC;
    }

    public void setTotalPagoRemotoPLC(long totalPagoRemotoPLC) {
	this.totalPagoRemotoPLC = totalPagoRemotoPLC;
    }

    public long getDiferenciaPagoRemotoPLCUAPSCRE() {
	return diferenciaPagoRemotoPLCUAPSCRE;
    }

    public void setDiferenciaPagoRemotoPLCUAPSCRE(long diferenciaPagoRemotoPLCUAPSCRE) {
	this.diferenciaPagoRemotoPLCUAPSCRE = diferenciaPagoRemotoPLCUAPSCRE;
    }

    public long getDiferenciaPagoRemotoPSCREPLC() {
	return diferenciaPagoRemotoPSCREPLC;
    }

    public void setDiferenciaPagoRemotoPSCREPLC(long diferenciaPagoRemotoPSCREPLC) {
	this.diferenciaPagoRemotoPSCREPLC = diferenciaPagoRemotoPSCREPLC;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public long getTarjetaBancariaVisa() {
	return tarjetaBancariaVisa;
    }

    public void setTarjetaBancariaVisa(long tarjetaBancariaVisa) {
	this.tarjetaBancariaVisa = tarjetaBancariaVisa;
    }

    public long getTarjetaBancariaDiners() {
	return tarjetaBancariaDiners;
    }

    public void setTarjetaBancariaDiners(long tarjetaBancariaDiners) {
	this.tarjetaBancariaDiners = tarjetaBancariaDiners;
    }

    public long getDonaciones() {
	return donaciones;
    }

    public void setDonaciones(long donaciones) {
	this.donaciones = donaciones;
    }

    public long getTotalPLCUA() {
	return totalPLCUA;
    }

    public void setTotalPLCUA(long totalPLCUA) {
	this.totalPLCUA = totalPLCUA;
    }

    public long getTotalVentasTarjetaCreditoPSCRE() {
	return totalVentasTarjetaCreditoPSCRE;
    }

    public void setTotalVentasTarjetaCreditoPSCRE(long totalVentasTarjetaCreditoPSCRE) {
	this.totalVentasTarjetaCreditoPSCRE = totalVentasTarjetaCreditoPSCRE;
    }

    public long getTotalVentasInternetCreditoPSCRE() {
	return totalVentasInternetCreditoPSCRE;
    }

    public void setTotalVentasInternetCreditoPSCRE(long totalVentasInternetCreditoPSCRE) {
	this.totalVentasInternetCreditoPSCRE = totalVentasInternetCreditoPSCRE;
    }

    public long getRecaudacionesPSCRE() {
	return recaudacionesPSCRE;
    }

    public void setRecaudacionesPSCRE(long recaudacionesPSCRE) {
	this.recaudacionesPSCRE = recaudacionesPSCRE;
    }

    public long getTotalVentasAnulacionesPSCRE() {
	return totalVentasAnulacionesPSCRE;
    }

    public void setTotalVentasAnulacionesPSCRE(long totalVentasAnulacionesPSCRE) {
	this.totalVentasAnulacionesPSCRE = totalVentasAnulacionesPSCRE;
    }

    public long getAnulacionRecaudacionesPSCRE() {
	return anulacionRecaudacionesPSCRE;
    }

    public void setAnulacionRecaudacionesPSCRE(long anulacionRecaudacionesPSCRE) {
	this.anulacionRecaudacionesPSCRE = anulacionRecaudacionesPSCRE;
    }

    public long getTotalPSCRE() {
	return totalPSCRE;
    }

    public void setTotalPSCRE(long totalPSCRE) {
	this.totalPSCRE = totalPSCRE;
    }

    public long getTotalVentasTarjetaCreditoPLC() {
	return totalVentasTarjetaCreditoPLC;
    }

    public void setTotalVentasTarjetaCreditoPLC(long totalVentasTarjetaCreditoPLC) {
	this.totalVentasTarjetaCreditoPLC = totalVentasTarjetaCreditoPLC;
    }

    public long getTotalVentasInternetCreditoPLC() {
	return totalVentasInternetCreditoPLC;
    }

    public void setTotalVentasInternetCreditoPLC(long totalVentasInternetCreditoPLC) {
	this.totalVentasInternetCreditoPLC = totalVentasInternetCreditoPLC;
    }

    public long getTotalAnulacionesNCAPLC() {
	return totalAnulacionesNCAPLC;
    }

    public void setTotalAnulacionesNCAPLC(long totalAnulacionesNCAPLC) {
	this.totalAnulacionesNCAPLC = totalAnulacionesNCAPLC;
    }

    public long getTotalRecaudacionesPLC() {
	return totalRecaudacionesPLC;
    }

    public void setTotalRecaudacionesPLC(long totalRecaudacionesPLC) {
	this.totalRecaudacionesPLC = totalRecaudacionesPLC;
    }

    public long getTotalAnulacionRecaudacionesPLC() {
	return totalAnulacionRecaudacionesPLC;
    }

    public void setTotalAnulacionRecaudacionesPLC(long totalAnulacionRecaudacionesPLC) {
	this.totalAnulacionRecaudacionesPLC = totalAnulacionRecaudacionesPLC;
    }

    public long getTotalPLC() {
	return totalPLC;
    }

    public void setTotalPLC(long totalPLC) {
	this.totalPLC = totalPLC;
    }

    public long getDiferenciaPLCUAPSCRE() {
	return diferenciaPLCUAPSCRE;
    }

    public void setDiferenciaPLCUAPSCRE(long diferenciaPLCUAPSCRE) {
	this.diferenciaPLCUAPSCRE = diferenciaPLCUAPSCRE;
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
