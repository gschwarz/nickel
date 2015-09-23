package com.rhiscom.cuadratura.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "cuad_vtacmr")
public class CuadraturaVtaCMREntity {

	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "cuad_ctacmr.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Long id;
	private Long cuotasNormales;
	private Long cuotasDiferidas;
	private Long tresCC;
	private Long donacionCMR;
	private Long ncrTFTotal;
	private Long totalFinalPlaCuad;

	private Long granTotalVentas;
	private Long granTotalRecaudaciones;
	private Long granTotalDevolucionesCMRNCA;
	private Long granTotalDevolucionesCMRNCR;
	private Long granTotalAnulacionGiftcard;
	private Long totalFinalARQTF;

	private Long transacciones200;
	private Long transacciones400;

	private Long totalFinalTRX;

	private Long diferenciaPlaCuadConVtaCMR;
	private Long diferenciaPlaCuadARQTF;
	private Long diferenciaVtaCRMConARQTF;

	private Long pldtf;
	private Long arqTFNCR;
	private Long diferenciaPldtfNCRConArqTFNCR;

	private Long placuadNCR;
	private Long diferenciaPlaCuadNCRConArqTFNCR;

	private Long ldta;
	private Long ldtaDonacion;
	private Long ArqTFDonacion;
	private long diferenciaLdtaConArqTFDonacion;

	private Date fechaTrx;
	private Long sucursal;

	private Long totalTrx200SAT;
	private Long totalTrx400SAT;
	private Long totalFinalSAT;

	private Long totalTrx200RSAT;
	private Long totalTrx400RSAT;
	private Long totalFinalRSAT;

	private Long diferenciaSATCRCMR;
	private Long diferenciaRSATCRCMR;

	public Long getTotalTrx200SAT() {
		return totalTrx200SAT;
	}

	public void setTotalTrx200SAT(Long totalTrx200SAT) {
		this.totalTrx200SAT = totalTrx200SAT;
	}

	public Long getTotalTrx400SAT() {
		return totalTrx400SAT;
	}

	public void setTotalTrx400SAT(Long totalTrx400SAT) {
		this.totalTrx400SAT = totalTrx400SAT;
	}

	public Long getTotalFinalSAT() {
		return totalFinalSAT;
	}

	public void setTotalFinalSAT(Long totalFinalSAT) {
		this.totalFinalSAT = totalFinalSAT;
	}

	public Long getTotalTrx200RSAT() {
		return totalTrx200RSAT;
	}

	public void setTotalTrx200RSAT(Long totalTrx200RSAT) {
		this.totalTrx200RSAT = totalTrx200RSAT;
	}

	public Long getTotalTrx400RSAT() {
		return totalTrx400RSAT;
	}

	public void setTotalTrx400RSAT(Long totalTrx400RSAT) {
		this.totalTrx400RSAT = totalTrx400RSAT;
	}

	public Long getTotalFinalRSAT() {
		return totalFinalRSAT;
	}

	public void setTotalFinalRSAT(Long totalFinalRSAT) {
		this.totalFinalRSAT = totalFinalRSAT;
	}

	public Long getDiferenciaSATCRCMR() {
		return diferenciaSATCRCMR;
	}

	public void setDiferenciaSATCRCMR(Long diferenciaSATCRCMR) {
		this.diferenciaSATCRCMR = diferenciaSATCRCMR;
	}

	public Long getDiferenciaRSATCRCMR() {
		return diferenciaRSATCRCMR;
	}

	public void setDiferenciaRSATCRCMR(Long diferenciaRSATCRCMR) {
		this.diferenciaRSATCRCMR = diferenciaRSATCRCMR;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCuotasNormales() {
		return cuotasNormales;
	}

	public void setCuotasNormales(Long cuotasNormales) {
		this.cuotasNormales = cuotasNormales;
	}

	public Long getCuotasDiferidas() {
		return cuotasDiferidas;
	}

	public void setCuotasDiferidas(Long cuotasDiferidas) {
		this.cuotasDiferidas = cuotasDiferidas;
	}

	public Long getTresCC() {
		return tresCC;
	}

	public void setTresCC(Long tresCC) {
		this.tresCC = tresCC;
	}

	public Long getDonacionCMR() {
		return donacionCMR;
	}

	public void setDonacionCMR(Long donacionCMR) {
		this.donacionCMR = donacionCMR;
	}

	public Long getNcrTFTotal() {
		return ncrTFTotal;
	}

	public void setNcrTFTotal(Long ncrTFTotal) {
		this.ncrTFTotal = ncrTFTotal;
	}

	public Long getTotalFinalPlaCuad() {
		return totalFinalPlaCuad;
	}

	public void setTotalFinalPlaCuad(Long totalFinalPlaCuad) {
		this.totalFinalPlaCuad = totalFinalPlaCuad;
	}

	public Long getGranTotalVentas() {
		return granTotalVentas;
	}

	public void setGranTotalVentas(Long granTotalVentas) {
		this.granTotalVentas = granTotalVentas;
	}

	public Long getGranTotalRecaudaciones() {
		return granTotalRecaudaciones;
	}

	public void setGranTotalRecaudaciones(Long granTotalRecaudaciones) {
		this.granTotalRecaudaciones = granTotalRecaudaciones;
	}

	public Long getGranTotalDevolucionesCMRNCA() {
		return granTotalDevolucionesCMRNCA;
	}

	public void setGranTotalDevolucionesCMRNCA(Long granTotalDevolucionesCMRNCA) {
		this.granTotalDevolucionesCMRNCA = granTotalDevolucionesCMRNCA;
	}

	public Long getGranTotalDevolucionesCMRNCR() {
		return granTotalDevolucionesCMRNCR;
	}

	public void setGranTotalDevolucionesCMRNCR(Long granTotalDevolucionesCMRNCR) {
		this.granTotalDevolucionesCMRNCR = granTotalDevolucionesCMRNCR;
	}

	public Long getGranTotalAnulacionGiftcard() {
		return granTotalAnulacionGiftcard;
	}

	public void setGranTotalAnulacionGiftcard(Long granTotalAnulacionGiftcard) {
		this.granTotalAnulacionGiftcard = granTotalAnulacionGiftcard;
	}

	public Long getTotalFinalARQTF() {
		return totalFinalARQTF;
	}

	public void setTotalFinalARQTF(Long totalFinalARQTF) {
		this.totalFinalARQTF = totalFinalARQTF;
	}

	public Long getTransacciones200() {
		return transacciones200;
	}

	public void setTransacciones200(Long transacciones200) {
		this.transacciones200 = transacciones200;
	}

	public Long getTransacciones400() {
		return transacciones400;
	}

	public void setTransacciones400(Long transacciones400) {
		this.transacciones400 = transacciones400;
	}

	public Long getTotalFinalTRX() {
		return totalFinalTRX;
	}

	public void setTotalFinalTRX(Long totalFinalTRX) {
		this.totalFinalTRX = totalFinalTRX;
	}

	public Long getDiferenciaPlaCuadConVtaCMR() {
		return diferenciaPlaCuadConVtaCMR;
	}

	public void setDiferenciaPlaCuadConVtaCMR(Long diferenciaPlaCuadConVtaCMR) {
		this.diferenciaPlaCuadConVtaCMR = diferenciaPlaCuadConVtaCMR;
	}

	public Long getDiferenciaPlaCuadARQTF() {
		return diferenciaPlaCuadARQTF;
	}

	public void setDiferenciaPlaCuadARQTF(Long diferenciaPlaCuadARQTF) {
		this.diferenciaPlaCuadARQTF = diferenciaPlaCuadARQTF;
	}

	public Long getDiferenciaVtaCRMConARQTF() {
		return diferenciaVtaCRMConARQTF;
	}

	public void setDiferenciaVtaCRMConARQTF(Long diferenciaVtaCRMConARQTF) {
		this.diferenciaVtaCRMConARQTF = diferenciaVtaCRMConARQTF;
	}

	public Long getArqTFNCR() {
		return arqTFNCR;
	}

	public void setArqTFNCR(Long arqTFNCR) {
		this.arqTFNCR = arqTFNCR;
	}

	public Long getDiferenciaPldtfNCRConArqTFNCR() {
		return diferenciaPldtfNCRConArqTFNCR;
	}

	public void setDiferenciaPldtfNCRConArqTFNCR(Long diferenciaPldtfNCRConArqTFNCR) {
		this.diferenciaPldtfNCRConArqTFNCR = diferenciaPldtfNCRConArqTFNCR;
	}

	public Long getPlacuadNCR() {
		return placuadNCR;
	}

	public void setPlacuadNCR(Long placuadNCR) {
		this.placuadNCR = placuadNCR;
	}

	public Long getDiferenciaPlaCuadNCRConArqTFNCR() {
		return diferenciaPlaCuadNCRConArqTFNCR;
	}

	public void setDiferenciaPlaCuadNCRConArqTFNCR(Long diferenciaPlaCuadNCRConArqTFNCR) {
		this.diferenciaPlaCuadNCRConArqTFNCR = diferenciaPlaCuadNCRConArqTFNCR;
	}

	public Long getLdta() {
		return ldta;
	}

	public void setLdta(Long ldta) {
		this.ldta = ldta;
	}

	public Long getLdtaDonacion() {
		return ldtaDonacion;
	}

	public void setLdtaDonacion(Long ldtaDonacion) {
		this.ldtaDonacion = ldtaDonacion;
	}

	public Long getArqTFDonacion() {
		return ArqTFDonacion;
	}

	public void setArqTFDonacion(Long arqTFDonacion) {
		ArqTFDonacion = arqTFDonacion;
	}

	public long getDiferenciaLdtaConArqTFDonacion() {
		return diferenciaLdtaConArqTFDonacion;
	}

	public void setDiferenciaLdtaConArqTFDonacion(long diferenciaLdtaConArqTFDonacion) {
		this.diferenciaLdtaConArqTFDonacion = diferenciaLdtaConArqTFDonacion;
	}

	public Long getPldtf() {
		return pldtf;
	}

	public void setPldtf(Long pldtf) {
		this.pldtf = pldtf;
	}

}
