package com.rhiscom.bpm.console.server.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuad_tarjetadebito")
public class CuadraturaTarjetaDebito implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private Long totalVentasTarjetaDebitoPSDEB;
    private Long totalVentasInternetTarjetaDebitoPSDEB;
    private Long totalTarjetaDebitoPSDEB;
    private Long diferenciaPLCUAPSDEB;
    private Long totalVentasInternetDebitoPLD;
    private Long totalVentasTarjetaDebitoPLD;
    private Long totalVEntasDEbitoPLD;
    private Long diferenciaPSDEBPLD;
    private Long sucursal;
    private Date fechaTrx;
    private Long tarjetaDebitoPLCUA;
    // Pago Remoto

    private Long pagoRemotoDebitoPLCUA;

    private Long totalVentasPagoRemotoDebitoPSDEB;
    private Long totalAnulacionesPagoRemotoDebitoPSDEB;
    private Long totalPagoRemotoPSDEB;
    private Long totalPagoRemotoDebitoPLD;
    private Long totalVentasPagoRemotoDebitoPLD;
    private Long totalAnulacionPagoRemotoDebitoPLD;
    private Long diferenciaPagoRemotoPLCUAPSDEB;
    private Long diferenciaPagoRemotoPSDEBPLD;

    public Long getDiferenciaPagoRemotoPLCUAPSDEB() {
	return diferenciaPagoRemotoPLCUAPSDEB;
    }

    public void setDiferenciaPagoRemotoPLCUAPSDEB(Long diferenciaPagoRemotoPLCUAPSDEB) {
	this.diferenciaPagoRemotoPLCUAPSDEB = diferenciaPagoRemotoPLCUAPSDEB;
    }

    public Long getDiferenciaPagoRemotoPSDEBPLD() {
	return diferenciaPagoRemotoPSDEBPLD;
    }

    public void setDiferenciaPagoRemotoPSDEBPLD(Long diferenciaPagoRemotoPSDEBPLD) {
	this.diferenciaPagoRemotoPSDEBPLD = diferenciaPagoRemotoPSDEBPLD;
    }

    public Long getPagoRemotoDebitoPLCUA() {
	return pagoRemotoDebitoPLCUA;
    }

    public void setPagoRemotoDebitoPLCUA(Long pagoRemotoDebitoPLCUA) {
	this.pagoRemotoDebitoPLCUA = pagoRemotoDebitoPLCUA;
    }

    public Long getTotalVentasPagoRemotoDebitoPSDEB() {
	return totalVentasPagoRemotoDebitoPSDEB;
    }

    public void setTotalVentasPagoRemotoDebitoPSDEB(Long totalVentasPagoRemotoDebitoPSDEB) {
	this.totalVentasPagoRemotoDebitoPSDEB = totalVentasPagoRemotoDebitoPSDEB;
    }

    public Long getTotalAnulacionesPagoRemotoDebitoPSDEB() {
	return totalAnulacionesPagoRemotoDebitoPSDEB;
    }

    public void setTotalAnulacionesPagoRemotoDebitoPSDEB(Long totalAnulacionesPagoRemotoDebitoPSDEB) {
	this.totalAnulacionesPagoRemotoDebitoPSDEB = totalAnulacionesPagoRemotoDebitoPSDEB;
    }

    public Long getTotalPagoRemotoPSDEB() {
	return totalPagoRemotoPSDEB;
    }

    public void setTotalPagoRemotoPSDEB(Long totalPagoRemotoPSDEB) {
	this.totalPagoRemotoPSDEB = totalPagoRemotoPSDEB;
    }

    public Long getTotalVentasPagoRemotoDebitoPLD() {
	return totalVentasPagoRemotoDebitoPLD;
    }

    public void setTotalVentasPagoRemotoDebitoPLD(Long totalVentasPagoRemotoDebitoPLD) {
	this.totalVentasPagoRemotoDebitoPLD = totalVentasPagoRemotoDebitoPLD;
    }

    public Long getTotalAnulacionPagoRemotoDebitoPLD() {
	return totalAnulacionPagoRemotoDebitoPLD;
    }

    public void setTotalAnulacionPagoRemotoDebitoPLD(Long totalAnulacionPagoRemotoDebitoPLD) {
	this.totalAnulacionPagoRemotoDebitoPLD = totalAnulacionPagoRemotoDebitoPLD;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Long getTotalVentasTarjetaDebitoPSDEB() {
	return totalVentasTarjetaDebitoPSDEB;
    }

    public void setTotalVentasTarjetaDebitoPSDEB(Long totalVentasTarjetaDebitoPSDEB) {
	this.totalVentasTarjetaDebitoPSDEB = totalVentasTarjetaDebitoPSDEB;
    }

    public Long getTotalVentasInternetTarjetaDebitoPSDEB() {
	return totalVentasInternetTarjetaDebitoPSDEB;
    }

    public void setTotalVentasInternetTarjetaDebitoPSDEB(Long totalVentasInternetTarjetaDebitoPSDEB) {
	this.totalVentasInternetTarjetaDebitoPSDEB = totalVentasInternetTarjetaDebitoPSDEB;
    }

    public Long getTotalTarjetaDebitoPSDEB() {
	return totalTarjetaDebitoPSDEB;
    }

    public void setTotalTarjetaDebitoPSDEB(Long totalTarjetaDebitoPSDEB) {
	this.totalTarjetaDebitoPSDEB = totalTarjetaDebitoPSDEB;
    }

    public Long getDiferenciaPLCUAPSDEB() {
	return diferenciaPLCUAPSDEB;
    }

    public void setDiferenciaPLCUAPSDEB(Long diferenciaPLCUAPSDEB) {
	this.diferenciaPLCUAPSDEB = diferenciaPLCUAPSDEB;
    }

    public Long getTotalVentasInternetDebitoPLD() {
	return totalVentasInternetDebitoPLD;
    }

    public void setTotalVentasInternetDebitoPLD(Long totalVentasInternetDebitoPLD) {
	this.totalVentasInternetDebitoPLD = totalVentasInternetDebitoPLD;
    }

    public Long getTotalVentasTarjetaDebitoPLD() {
	return totalVentasTarjetaDebitoPLD;
    }

    public void setTotalVentasTarjetaDebitoPLD(Long totalVentasTarjetaDebitoPLD) {
	this.totalVentasTarjetaDebitoPLD = totalVentasTarjetaDebitoPLD;
    }

    public Long getTotalVEntasDEbitoPLD() {
	return totalVEntasDEbitoPLD;
    }

    public void setTotalVEntasDEbitoPLD(Long totalVEntasDEbitoPLD) {
	this.totalVEntasDEbitoPLD = totalVEntasDEbitoPLD;
    }

    public Long getDiferenciaPSDEBPLD() {
	return diferenciaPSDEBPLD;
    }

    public void setDiferenciaPSDEBPLD(Long diferenciaPSDEBPLD) {
	this.diferenciaPSDEBPLD = diferenciaPSDEBPLD;
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

    public Long getTarjetaDebitoPLCUA() {
	return tarjetaDebitoPLCUA;
    }

    public void setTarjetaDebitoPLCUA(Long tarjetaDebitoPLCUA) {
	this.tarjetaDebitoPLCUA = tarjetaDebitoPLCUA;
    }

    public Long getTotalPagoRemotoDebitoPLD() {
	return totalPagoRemotoDebitoPLD;
    }

    public void setTotalPagoRemotoDebitoPLD(Long totalPagoRemotoDebitoPLD) {
	this.totalPagoRemotoDebitoPLD = totalPagoRemotoDebitoPLD;
    }

}
