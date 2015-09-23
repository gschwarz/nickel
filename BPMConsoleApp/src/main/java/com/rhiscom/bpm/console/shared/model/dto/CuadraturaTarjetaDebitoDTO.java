package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class CuadraturaTarjetaDebitoDTO implements Serializable {

    private int id;

    private long totalVentasTarjetaDebitoPSDEB;
    private long totalVentasInternetTarjetaDebitoPSDEB;
    private long totalTarjetaDebitoPSDEB;
    private long diferenciaPLCUAPSDEB;
    private long totalVentasInternetDebitoPLD;
    private long totalVentasTarjetaDebitoPLD;
    private long totalVEntasDEbitoPLD;
    private long diferenciaPSDEBPLD;
    private long sucursal;
    private Date fechaTrx;
    private long tarjetaDebitoPLCUA;

    // Pago Remoto

    private long pagoRemotoDebitoPLCUA;

    private long totalVentasPagoRemotoDebitoPSDEB;
    private long totalAnulacionesPagoRemotoDebitoPSDEB;
    private long totalPagoRemotoPSDEB;
    private long totalPagoRemotoDebitoPLD;
    private long totalVentasPagoRemotoDebitoPLD;
    private long totalAnulacionPagoRemotoDebitoPLD;
    private long diferenciaPagoRemotoPLCUAPSDEB;
    private long diferenciaPagoRemotoPSDEBPLD;
    private String versionPOS;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public long getTotalVentasTarjetaDebitoPSDEB() {
	return totalVentasTarjetaDebitoPSDEB;
    }

    public void setTotalVentasTarjetaDebitoPSDEB(long totalVentasTarjetaDebitoPSDEB) {
	this.totalVentasTarjetaDebitoPSDEB = totalVentasTarjetaDebitoPSDEB;
    }

    public long getTotalVentasInternetTarjetaDebitoPSDEB() {
	return totalVentasInternetTarjetaDebitoPSDEB;
    }

    public void setTotalVentasInternetTarjetaDebitoPSDEB(long totalVentasInternetTarjetaDebitoPSDEB) {
	this.totalVentasInternetTarjetaDebitoPSDEB = totalVentasInternetTarjetaDebitoPSDEB;
    }

    public long getTotalTarjetaDebitoPSDEB() {
	return totalTarjetaDebitoPSDEB;
    }

    public void setTotalTarjetaDebitoPSDEB(long totalTarjetaDebitoPSDEB) {
	this.totalTarjetaDebitoPSDEB = totalTarjetaDebitoPSDEB;
    }

    public long getDiferenciaPLCUAPSDEB() {
	return diferenciaPLCUAPSDEB;
    }

    public void setDiferenciaPLCUAPSDEB(long diferenciaPLCUAPSDEB) {
	this.diferenciaPLCUAPSDEB = diferenciaPLCUAPSDEB;
    }

    public long getTotalVentasInternetDebitoPLD() {
	return totalVentasInternetDebitoPLD;
    }

    public void setTotalVentasInternetDebitoPLD(long totalVentasInternetDebitoPLD) {
	this.totalVentasInternetDebitoPLD = totalVentasInternetDebitoPLD;
    }

    public long getTotalVentasTarjetaDebitoPLD() {
	return totalVentasTarjetaDebitoPLD;
    }

    public void setTotalVentasTarjetaDebitoPLD(long totalVentasTarjetaDebitoPLD) {
	this.totalVentasTarjetaDebitoPLD = totalVentasTarjetaDebitoPLD;
    }

    public long getTotalVEntasDEbitoPLD() {
	return totalVEntasDEbitoPLD;
    }

    public void setTotalVEntasDEbitoPLD(long totalVEntasDEbitoPLD) {
	this.totalVEntasDEbitoPLD = totalVEntasDEbitoPLD;
    }

    public long getDiferenciaPSDEBPLD() {
	return diferenciaPSDEBPLD;
    }

    public void setDiferenciaPSDEBPLD(long diferenciaPSDEBPLD) {
	this.diferenciaPSDEBPLD = diferenciaPSDEBPLD;
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

    public long getPagoRemotoDebitoPLCUA() {
	return pagoRemotoDebitoPLCUA;
    }

    public void setPagoRemotoDebitoPLCUA(long pagoRemotoDebitoPLCUA) {
	this.pagoRemotoDebitoPLCUA = pagoRemotoDebitoPLCUA;
    }

    public long getTotalVentasPagoRemotoDebitoPSDEB() {
	return totalVentasPagoRemotoDebitoPSDEB;
    }

    public void setTotalVentasPagoRemotoDebitoPSDEB(long totalVentasPagoRemotoDebitoPSDEB) {
	this.totalVentasPagoRemotoDebitoPSDEB = totalVentasPagoRemotoDebitoPSDEB;
    }

    public long getTotalAnulacionesPagoRemotoDebitoPSDEB() {
	return totalAnulacionesPagoRemotoDebitoPSDEB;
    }

    public void setTotalAnulacionesPagoRemotoDebitoPSDEB(long totalAnulacionesPagoRemotoDebitoPSDEB) {
	this.totalAnulacionesPagoRemotoDebitoPSDEB = totalAnulacionesPagoRemotoDebitoPSDEB;
    }

    public long getTotalPagoRemotoPSDEB() {
	return totalPagoRemotoPSDEB;
    }

    public void setTotalPagoRemotoPSDEB(long totalPagoRemotoPSDEB) {
	this.totalPagoRemotoPSDEB = totalPagoRemotoPSDEB;
    }

    public long getTotalVentasPagoRemotoDebitoPLD() {
	return totalVentasPagoRemotoDebitoPLD;
    }

    public void setTotalVentasPagoRemotoDebitoPLD(long totalVentasPagoRemotoDebitoPLD) {
	this.totalVentasPagoRemotoDebitoPLD = totalVentasPagoRemotoDebitoPLD;
    }

    public long getTotalAnulacionPagoRemotoDebitoPLD() {
	return totalAnulacionPagoRemotoDebitoPLD;
    }

    public void setTotalAnulacionPagoRemotoDebitoPLD(long totalAnulacionPagoRemotoDebitoPLD) {
	this.totalAnulacionPagoRemotoDebitoPLD = totalAnulacionPagoRemotoDebitoPLD;
    }

    public long getDiferenciaPagoRemotoPLCUAPSDEB() {
	return diferenciaPagoRemotoPLCUAPSDEB;
    }

    public void setDiferenciaPagoRemotoPLCUAPSDEB(long diferenciaPagoRemotoPLCUAPSDEB) {
	this.diferenciaPagoRemotoPLCUAPSDEB = diferenciaPagoRemotoPLCUAPSDEB;
    }

    public long getDiferenciaPagoRemotoPSDEBPLD() {
	return diferenciaPagoRemotoPSDEBPLD;
    }

    public void setDiferenciaPagoRemotoPSDEBPLD(long diferenciaPagoRemotoPSDEBPLD) {
	this.diferenciaPagoRemotoPSDEBPLD = diferenciaPagoRemotoPSDEBPLD;
    }

    public long getTarjetaDebitoPLCUA() {
	return tarjetaDebitoPLCUA;
    }

    public void setTarjetaDebitoPLCUA(long tarjetaDebitoPLCUA) {
	this.tarjetaDebitoPLCUA = tarjetaDebitoPLCUA;
    }

    public long getTotalPagoRemotoDebitoPLD() {
	return totalPagoRemotoDebitoPLD;
    }

    public void setTotalPagoRemotoDebitoPLD(long totalPagoRemotoDebitoPLD) {
	this.totalPagoRemotoDebitoPLD = totalPagoRemotoDebitoPLD;
    }

    public String getVersionPOS() {
	return versionPOS;
    }

    public void setVersionPOS(String versionPOS) {
	this.versionPOS = versionPOS;
    }

}
