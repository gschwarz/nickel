package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class CuadraturaVtaCMRDTO implements Serializable {
    /**
     * 
     */

    public CuadraturaVtaCMRDTO() {

    }

    private static final long serialVersionUID = 1L;
    private int id;
    private long cuotasNormales;
    private long cuotasDiferidas;
    private long tresCC;
    private long donacionCMR;
    private long ncrTFTotal;
    private long totalFinalPlaCuad;

    private long granTotalVentas;
    private long granTotalRecaudaciones;
    private long granTotalDevolucionesCMRNCA;
    private long granTotalDevolucionesCMRNCR;
    private long granTotalAnulacionGiftcard;
    private long totalFinalARQTF;

    private long transacciones200;
    private long transacciones400;

    private long totalFinalTRX;

    private long diferenciaPlaCuadConVtaCMR;
    private long diferenciaPlaCuadARQTF;
    private long diferenciaVtaCRMConARQTF;

    private long pldtf;
    private long arqTFNCR;
    private long diferenciaPldtfNCRConArqTFNCR;

    private long placuadNCR;
    private long diferenciaPlaCuadNCRConArqTFNCR;

    private long ldta;
    private long ldtaDonacion;
    private long ArqTFDonacion;
    private long diferenciaLdtaConArqTFDonacion;

    private Date fechaTrx;
    private long sucursal;
    private String versionPOS;

    private long totalTrx200SAT;
    private long totalTrx400SAT;
    private long totalFinalSAT;

    private long totalTrx200RSAT;
    private long totalTrx400RSAT;
    private long totalFinalRSAT;

    private long diferenciaSATCRCMR;
    private long diferenciaRSATCRCMR;

    public long getTotalTrx200SAT() {
	return totalTrx200SAT;
    }

    public void setTotalTrx200SAT(long totalTrx200SAT) {
	this.totalTrx200SAT = totalTrx200SAT;
    }

    public long getTotalTrx400SAT() {
	return totalTrx400SAT;
    }

    public void setTotalTrx400SAT(long totalTrx400SAT) {
	this.totalTrx400SAT = totalTrx400SAT;
    }

    public long getTotalFinalSAT() {
	return totalFinalSAT;
    }

    public void setTotalFinalSAT(long totalFinalSAT) {
	this.totalFinalSAT = totalFinalSAT;
    }

    public long getTotalTrx200RSAT() {
	return totalTrx200RSAT;
    }

    public void setTotalTrx200RSAT(long totalTrx200RSAT) {
	this.totalTrx200RSAT = totalTrx200RSAT;
    }

    public long getTotalTrx400RSAT() {
	return totalTrx400RSAT;
    }

    public void setTotalTrx400RSAT(long totalTrx400RSAT) {
	this.totalTrx400RSAT = totalTrx400RSAT;
    }

    public long getTotalFinalRSAT() {
	return totalFinalRSAT;
    }

    public void setTotalFinalRSAT(long totalFinalRSAT) {
	this.totalFinalRSAT = totalFinalRSAT;
    }

    public long getDiferenciaRSATCRCMR() {
	return diferenciaRSATCRCMR;
    }

    public void setDiferenciaRSATCRCMR(long diferenciaRSATCRCMR) {
	this.diferenciaRSATCRCMR = diferenciaRSATCRCMR;
    }

    public long getDiferenciaSATCRCMR() {
	return diferenciaSATCRCMR;
    }

    public void setDiferenciaSATCRCMR(long diferenciaSATCRCMR) {
	this.diferenciaSATCRCMR = diferenciaSATCRCMR;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public long getCuotasNormales() {
	return cuotasNormales;
    }

    public void setCuotasNormales(long cuotasNormales) {
	this.cuotasNormales = cuotasNormales;
    }

    public long getCuotasDiferidas() {
	return cuotasDiferidas;
    }

    public void setCuotasDiferidas(long cuotasDiferidas) {
	this.cuotasDiferidas = cuotasDiferidas;
    }

    public long getTresCC() {
	return tresCC;
    }

    public void setTresCC(long tresCC) {
	this.tresCC = tresCC;
    }

    public long getDonacionCMR() {
	return donacionCMR;
    }

    public void setDonacionCMR(long donacionCMR) {
	this.donacionCMR = donacionCMR;
    }

    public long getNcrTFTotal() {
	return ncrTFTotal;
    }

    public void setNcrTFTotal(long ncrTFTotal) {
	this.ncrTFTotal = ncrTFTotal;
    }

    public long getTotalFinalPlaCuad() {
	return totalFinalPlaCuad;
    }

    public void setTotalFinalPlaCuad(long totalFinalPlaCuad) {
	this.totalFinalPlaCuad = totalFinalPlaCuad;
    }

    public long getGranTotalVentas() {
	return granTotalVentas;
    }

    public void setGranTotalVentas(long granTotalVentas) {
	this.granTotalVentas = granTotalVentas;
    }

    public long getGranTotalRecaudaciones() {
	return granTotalRecaudaciones;
    }

    public void setGranTotalRecaudaciones(long granTotalRecaudaciones) {
	this.granTotalRecaudaciones = granTotalRecaudaciones;
    }

    public long getGranTotalDevolucionesCMRNCA() {
	return granTotalDevolucionesCMRNCA;
    }

    public void setGranTotalDevolucionesCMRNCA(long granTotalDevolucionesCMRNCA) {
	this.granTotalDevolucionesCMRNCA = granTotalDevolucionesCMRNCA;
    }

    public long getGranTotalDevolucionesCMRNCR() {
	return granTotalDevolucionesCMRNCR;
    }

    public void setGranTotalDevolucionesCMRNCR(long granTotalDevolucionesCMRNCR) {
	this.granTotalDevolucionesCMRNCR = granTotalDevolucionesCMRNCR;
    }

    public long getGranTotalAnulacionGiftcard() {
	return granTotalAnulacionGiftcard;
    }

    public void setGranTotalAnulacionGiftcard(long granTotalAnulacionGiftcard) {
	this.granTotalAnulacionGiftcard = granTotalAnulacionGiftcard;
    }

    public long getTotalFinalARQTF() {
	return totalFinalARQTF;
    }

    public void setTotalFinalARQTF(long totalFinalARQTF) {
	this.totalFinalARQTF = totalFinalARQTF;
    }

    public long getTransacciones200() {
	return transacciones200;
    }

    public void setTransacciones200(long transacciones200) {
	this.transacciones200 = transacciones200;
    }

    public long getTransacciones400() {
	return transacciones400;
    }

    public void setTransacciones400(long transacciones400) {
	this.transacciones400 = transacciones400;
    }

    public long getTotalFinalTRX() {
	return totalFinalTRX;
    }

    public void setTotalFinalTRX(long totalFinalTRX) {
	this.totalFinalTRX = totalFinalTRX;
    }

    public long getDiferenciaPlaCuadConVtaCMR() {
	return diferenciaPlaCuadConVtaCMR;
    }

    public void setDiferenciaPlaCuadConVtaCMR(long diferenciaPlaCuadConVtaCMR) {
	this.diferenciaPlaCuadConVtaCMR = diferenciaPlaCuadConVtaCMR;
    }

    public long getDiferenciaPlaCuadARQTF() {
	return diferenciaPlaCuadARQTF;
    }

    public void setDiferenciaPlaCuadARQTF(long diferenciaPlaCuadARQTF) {
	this.diferenciaPlaCuadARQTF = diferenciaPlaCuadARQTF;
    }

    public long getDiferenciaVtaCRMConARQTF() {
	return diferenciaVtaCRMConARQTF;
    }

    public void setDiferenciaVtaCRMConARQTF(long diferenciaVtaCRMConARQTF) {
	this.diferenciaVtaCRMConARQTF = diferenciaVtaCRMConARQTF;
    }

    public long getPldtf() {
	return pldtf;
    }

    public void setPldtf(long pldtf) {
	this.pldtf = pldtf;
    }

    public long getArqTFNCR() {
	return arqTFNCR;
    }

    public void setArqTFNCR(long arqTFNCR) {
	this.arqTFNCR = arqTFNCR;
    }

    public long getDiferenciaPldtfNCRConArqTFNCR() {
	return diferenciaPldtfNCRConArqTFNCR;
    }

    public void setDiferenciaPldtfNCRConArqTFNCR(long diferenciaPldtfNCRConArqTFNCR) {
	this.diferenciaPldtfNCRConArqTFNCR = diferenciaPldtfNCRConArqTFNCR;
    }

    public long getPlacuadNCR() {
	return placuadNCR;
    }

    public void setPlacuadNCR(long placuadNCR) {
	this.placuadNCR = placuadNCR;
    }

    public long getDiferenciaPlaCuadNCRConArqTFNCR() {
	return diferenciaPlaCuadNCRConArqTFNCR;
    }

    public void setDiferenciaPlaCuadNCRConArqTFNCR(long diferenciaPlaCuadNCRConArqTFNCR) {
	this.diferenciaPlaCuadNCRConArqTFNCR = diferenciaPlaCuadNCRConArqTFNCR;
    }

    public long getLdta() {
	return ldta;
    }

    public void setLdta(long ldta) {
	this.ldta = ldta;
    }

    public long getLdtaDonacion() {
	return ldtaDonacion;
    }

    public void setLdtaDonacion(long ldtaDonacion) {
	this.ldtaDonacion = ldtaDonacion;
    }

    public long getArqTFDonacion() {
	return ArqTFDonacion;
    }

    public void setArqTFDonacion(long arqTFDonacion) {
	ArqTFDonacion = arqTFDonacion;
    }

    public long getDiferenciaLdtaConArqTFDonacion() {
	return diferenciaLdtaConArqTFDonacion;
    }

    public void setDiferenciaLdtaConArqTFDonacion(long diferenciaLdtaConArqTFDonacion) {
	this.diferenciaLdtaConArqTFDonacion = diferenciaLdtaConArqTFDonacion;
    }

    public Date getFechaTrx() {
	return fechaTrx;
    }

    public void setFechaTrx(Date fechaTrx) {
	this.fechaTrx = fechaTrx;
    }

    public long getSucursal() {
	return sucursal;
    }

    public void setSucursal(long sucursal) {
	this.sucursal = sucursal;
    }

    public String getVersionPOS() {
	return versionPOS;
    }

    public void setVersionPOS(String versionPOS) {
	this.versionPOS = versionPOS;
    }
}
