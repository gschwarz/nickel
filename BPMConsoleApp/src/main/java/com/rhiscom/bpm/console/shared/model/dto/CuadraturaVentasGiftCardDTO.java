package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class CuadraturaVentasGiftCardDTO implements Serializable {
    private long id;

    private long ventasGiftCardCMR;
    private long donacionesGiftCMR;
    private long ncrGiftCMR;

    private long totalPlaCuadCMR;

    private long ventasGiftCorporativa;
    private long donacionesGiftCorporativa;
    private long ncrGiftCorporativa;

    private long totalPlaCuaCorporativa;
    private long totalVentasGiftCardCMRPVGC;
    private long anulacionesVtaNCAGiftCMR;
    private long sucursal;
    private Date fechaTrx;
    private long totalAnulacionesNCRGiftCMR;
    private long totalVentasGiftCMRPVGC;
    private long totalVentasGiftCorporativa;
    private long anulacionesVtaNCAGifCorporativa;
    private long totalAnulacionesNCRGiftCorporativa;
    private long totalGifCorporativa;

    private long sumatoriaPlcua;
    private long sumatoriaMpvgc;
    private long diferenciaPlacuadMpvgc;
    private String versionPOS;

    public long getSumatoriaPlcua() {
	return sumatoriaPlcua;
    }

    public void setSumatoriaPlcua(long sumatoriaPlcua) {
	this.sumatoriaPlcua = sumatoriaPlcua;
    }

    public long getSumatoriaMpvgc() {
	return sumatoriaMpvgc;
    }

    public void setSumatoriaMpvgc(long sumatoriaMpvgc) {
	this.sumatoriaMpvgc = sumatoriaMpvgc;
    }

    public long getDiferenciaPlacuadMpvgc() {
	return diferenciaPlacuadMpvgc;
    }

    public void setDiferenciaPlacuadMpvgc(long diferenciaPlacuadMpvgc) {
	this.diferenciaPlacuadMpvgc = diferenciaPlacuadMpvgc;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public long getVentasGiftCardCMR() {
	return ventasGiftCardCMR;
    }

    public void setVentasGiftCardCMR(long ventasGiftCardCMR) {
	this.ventasGiftCardCMR = ventasGiftCardCMR;
    }

    public long getDonacionesGiftCMR() {
	return donacionesGiftCMR;
    }

    public void setDonacionesGiftCMR(long donacionesGiftCMR) {
	this.donacionesGiftCMR = donacionesGiftCMR;
    }

    public long getNcrGiftCMR() {
	return ncrGiftCMR;
    }

    public void setNcrGiftCMR(long ncrGiftCMR) {
	this.ncrGiftCMR = ncrGiftCMR;
    }

    public long getTotalPlaCuadCMR() {
	return totalPlaCuadCMR;
    }

    public void setTotalPlaCuadCMR(long totalPlaCuadCMR) {
	this.totalPlaCuadCMR = totalPlaCuadCMR;
    }

    public long getVentasGiftCorporativa() {
	return ventasGiftCorporativa;
    }

    public void setVentasGiftCorporativa(long ventasGiftCorporativa) {
	this.ventasGiftCorporativa = ventasGiftCorporativa;
    }

    public long getDonacionesGiftCorporativa() {
	return donacionesGiftCorporativa;
    }

    public void setDonacionesGiftCorporativa(long donacionesGiftCorporativa) {
	this.donacionesGiftCorporativa = donacionesGiftCorporativa;
    }

    public long getNcrGiftCorporativa() {
	return ncrGiftCorporativa;
    }

    public void setNcrGiftCorporativa(long ncrGiftCorporativa) {
	this.ncrGiftCorporativa = ncrGiftCorporativa;
    }

    public long getTotalPlaCuaCorporativa() {
	return totalPlaCuaCorporativa;
    }

    public void setTotalPlaCuaCorporativa(long totalPlaCuaCorporativa) {
	this.totalPlaCuaCorporativa = totalPlaCuaCorporativa;
    }

    public long getTotalVentasGiftCardCMRPVGC() {
	return totalVentasGiftCardCMRPVGC;
    }

    public void setTotalVentasGiftCardCMRPVGC(long totalVentasGiftCardCMRPVGC) {
	this.totalVentasGiftCardCMRPVGC = totalVentasGiftCardCMRPVGC;
    }

    public long getAnulacionesVtaNCAGiftCMR() {
	return anulacionesVtaNCAGiftCMR;
    }

    public void setAnulacionesVtaNCAGiftCMR(long anulacionesVtaNCAGiftCMR) {
	this.anulacionesVtaNCAGiftCMR = anulacionesVtaNCAGiftCMR;
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

    public long getTotalAnulacionesNCRGiftCMR() {
	return totalAnulacionesNCRGiftCMR;
    }

    public void setTotalAnulacionesNCRGiftCMR(long totalAnulacionesNCRGiftCMR) {
	this.totalAnulacionesNCRGiftCMR = totalAnulacionesNCRGiftCMR;
    }

    public long getTotalVentasGiftCMRPVGC() {
	return totalVentasGiftCMRPVGC;
    }

    public void setTotalVentasGiftCMRPVGC(long totalVentasGiftCMRPVGC) {
	this.totalVentasGiftCMRPVGC = totalVentasGiftCMRPVGC;
    }

    public long getTotalVentasGiftCorporativa() {
	return totalVentasGiftCorporativa;
    }

    public void setTotalVentasGiftCorporativa(long totalVentasGiftCorporativa) {
	this.totalVentasGiftCorporativa = totalVentasGiftCorporativa;
    }

    public long getAnulacionesVtaNCAGifCorporativa() {
	return anulacionesVtaNCAGifCorporativa;
    }

    public void setAnulacionesVtaNCAGifCorporativa(long anulacionesVtaNCAGifCorporativa) {
	this.anulacionesVtaNCAGifCorporativa = anulacionesVtaNCAGifCorporativa;
    }

    public long getTotalAnulacionesNCRGiftCorporativa() {
	return totalAnulacionesNCRGiftCorporativa;
    }

    public void setTotalAnulacionesNCRGiftCorporativa(long totalAnulacionesNCRGiftCorporativa) {
	this.totalAnulacionesNCRGiftCorporativa = totalAnulacionesNCRGiftCorporativa;
    }

    public long getTotalGifCorporativa() {
	return totalGifCorporativa;
    }

    public void setTotalGifCorporativa(long totalGifCorporativa) {
	this.totalGifCorporativa = totalGifCorporativa;
    }

    public String getVersionPOS() {
	return versionPOS;
    }

    public void setVersionPOS(String versionPOS) {
	this.versionPOS = versionPOS;
    }

}
