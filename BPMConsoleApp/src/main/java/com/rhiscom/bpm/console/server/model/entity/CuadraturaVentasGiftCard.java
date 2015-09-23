package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "cuad_vtagiftcard")
public class CuadraturaVentasGiftCard {
    @Id
    @TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "cuad_vtagiftcard.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
    @Column(name = "id", nullable = false)
    private Long id;

    private Long ventasGiftCardCMR;
    private Long donacionesGiftCMR;
    private Long ncrGiftCMR;

    private Long totalPlaCuadCMR;

    private Long ventasGiftCorporativa;
    private Long donacionesGiftCorporativa;
    private Long ncrGiftCorporativa;

    private Long totalPlaCuaCorporativa;
    private Long totalVentasGiftCardCMRPVGC;
    private Long anulacionesVtaNCAGiftCMR;
    private Long sucursal;
    private Date fechaTrx;
    private Long totalAnulacionesNCRGiftCMR;
    private Long totalVentasGiftCMRPVGC;
    private Long totalVentasGiftCorporativa;
    private Long anulacionesVtaNCAGifCorporativa;
    private Long totalAnulacionesNCRGiftCorporativa;
    private Long totalGifCorporativa;

    private Long sumatoriaPlcua;
    private Long sumatoriaMpvgc;
    private Long diferenciaPlacuadMpvgc;

    public Long getSumatoriaPlcua() {
	return sumatoriaPlcua;
    }

    public void setSumatoriaPlcua(Long sumatoriaPlcua) {
	this.sumatoriaPlcua = sumatoriaPlcua;
    }

    public Long getSumatoriaMpvgc() {
	return sumatoriaMpvgc;
    }

    public void setSumatoriaMpvgc(Long sumatoriaMpvgc) {
	this.sumatoriaMpvgc = sumatoriaMpvgc;
    }

    public Long getDiferenciaPlacuadMpvgc() {
	return diferenciaPlacuadMpvgc;
    }

    public void setDiferenciaPlacuadMpvgc(Long diferenciaPlacuadMpvgc) {
	this.diferenciaPlacuadMpvgc = diferenciaPlacuadMpvgc;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getDonacionesGiftCMR() {
	return donacionesGiftCMR;
    }

    public void setDonacionesGiftCMR(Long donacionesGiftCMR) {
	this.donacionesGiftCMR = donacionesGiftCMR;
    }

    public Long getNcrGiftCMR() {
	return ncrGiftCMR;
    }

    public void setNcrGiftCMR(Long ncrGiftCMR) {
	this.ncrGiftCMR = ncrGiftCMR;
    }

    public Long getTotalPlaCuadCMR() {
	return totalPlaCuadCMR;
    }

    public void setTotalPlaCuadCMR(Long totalPlaCuadCMR) {
	this.totalPlaCuadCMR = totalPlaCuadCMR;
    }

    public Long getVentasGiftCorporativa() {
	return ventasGiftCorporativa;
    }

    public void setVentasGiftCorporativa(Long ventasGiftCorporativa) {
	this.ventasGiftCorporativa = ventasGiftCorporativa;
    }

    public Long getDonacionesGiftCorporativa() {
	return donacionesGiftCorporativa;
    }

    public void setDonacionesGiftCorporativa(Long donacionesGiftCorporativa) {
	this.donacionesGiftCorporativa = donacionesGiftCorporativa;
    }

    public Long getNcrGiftCorporativa() {
	return ncrGiftCorporativa;
    }

    public void setNcrGiftCorporativa(Long ncrGiftCorporativa) {
	this.ncrGiftCorporativa = ncrGiftCorporativa;
    }

    public Long getTotalPlaCuaCorporativa() {
	return totalPlaCuaCorporativa;
    }

    public void setTotalPlaCuaCorporativa(Long totalPlaCuaCorporativa) {
	this.totalPlaCuaCorporativa = totalPlaCuaCorporativa;
    }

    public Long getVentasGiftCardCMR() {
	return ventasGiftCardCMR;
    }

    public void setVentasGiftCardCMR(Long ventasGiftCardCMR) {
	this.ventasGiftCardCMR = ventasGiftCardCMR;
    }

    public Long getTotalVentasGiftCardCMRPVGC() {
	return totalVentasGiftCardCMRPVGC;
    }

    public void setTotalVentasGiftCardCMRPVGC(Long totalVentasGiftCardCMRPVGC) {
	this.totalVentasGiftCardCMRPVGC = totalVentasGiftCardCMRPVGC;
    }

    public Long getAnulacionesVtaNCAGiftCMR() {
	return anulacionesVtaNCAGiftCMR;
    }

    public void setAnulacionesVtaNCAGiftCMR(Long anulacionesVtaNCAGiftCMR) {
	this.anulacionesVtaNCAGiftCMR = anulacionesVtaNCAGiftCMR;
    }

    public Date getFechaTrx() {
	return fechaTrx;
    }

    public void setFechaTrx(Date fechaTrx) {
	this.fechaTrx = fechaTrx;
    }

    public Long getSucursal() {
	return sucursal;
    }

    public void setSucursal(Long sucursal) {
	this.sucursal = sucursal;
    }

    public Long getTotalAnulacionesNCRGiftCMR() {
	return totalAnulacionesNCRGiftCMR;
    }

    public void setTotalAnulacionesNCRGiftCMR(Long totalAnulacionesNCRGiftCMR) {
	this.totalAnulacionesNCRGiftCMR = totalAnulacionesNCRGiftCMR;
    }

    public Long getTotalVentasGiftCMRPVGC() {
	return totalVentasGiftCMRPVGC;
    }

    public void setTotalVentasGiftCMRPVGC(Long totalVentasGiftCMRPVGC) {
	this.totalVentasGiftCMRPVGC = totalVentasGiftCMRPVGC;
    }

    public Long getTotalVentasGiftCorporativa() {
	return totalVentasGiftCorporativa;
    }

    public void setTotalVentasGiftCorporativa(Long totalVentasGiftCorporativa) {
	this.totalVentasGiftCorporativa = totalVentasGiftCorporativa;
    }

    public Long getAnulacionesVtaNCAGifCorporativa() {
	return anulacionesVtaNCAGifCorporativa;
    }

    public void setAnulacionesVtaNCAGifCorporativa(Long anulacionesVtaNCAGifCorporativa) {
	this.anulacionesVtaNCAGifCorporativa = anulacionesVtaNCAGifCorporativa;
    }

    public Long getTotalAnulacionesNCRGiftCorporativa() {
	return totalAnulacionesNCRGiftCorporativa;
    }

    public void setTotalAnulacionesNCRGiftCorporativa(Long totalAnulacionesNCRGiftCorporativa) {
	this.totalAnulacionesNCRGiftCorporativa = totalAnulacionesNCRGiftCorporativa;
    }

    public Long getTotalGifCorporativa() {
	return totalGifCorporativa;
    }

    public void setTotalGifCorporativa(Long totalGifCorporativa) {
	this.totalGifCorporativa = totalGifCorporativa;
    }

}
