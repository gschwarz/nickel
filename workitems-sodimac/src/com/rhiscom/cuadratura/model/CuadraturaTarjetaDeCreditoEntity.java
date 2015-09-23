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
@Table(name = "cuad_tarjetacredito")
public class CuadraturaTarjetaDeCreditoEntity {

	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "cuad_tarjetacredito.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Long id;
	
	private Long tarjetaBancariaVisa;
	private Long tarjetaBancariaDiners;
	private Long donaciones;

	private Long totalPLCUA;

	/** ARQ_TV **/

	private Long totalVentasTarjetaCreditoPSCRE;
	private Long totalVentasInternetCreditoPSCRE;
	private Long recaudacionesPSCRE;
	private Long totalVentasAnulacionesPSCRE;
	private Long anulacionRecaudacionesPSCRE;

	private Long totalPSCRE;
	/*
	 * PLC
	 */
	private Long totalVentasTarjetaCreditoPLC;
	private Long totalVentasInternetCreditoPLC;
	private Long totalAnulacionesNCAPLC;
	private Long totalRecaudacionesPLC;
	private Long totalAnulacionRecaudacionesPLC;

	private Long totalPLC;

	private Long diferenciaPLCUAPSCRE;
	private Long diferenciaPSCREPLC;
	private Long sucursal;
	private Date fechaTrx;
	
	/*
	 * Pago Remoto
	 */
	
	private Long pagoRemotoCreditoPLCUA;
	
	private Long pagoRemotoCreditoPSCRE;
	private Long totalAnulacionesPagoRemoto;
	
	private Long totalPagoRemotoPSCRE;
	
	private Long totalVentasPagoRemotoCreditoPLC;
	private Long totalAnulacionesPagoRemotoCreditoPLC;
	
	private Long totalPagoRemotoPLC;
	
	private Long diferenciaPagoRemotoPLCUAPSCRE;
	private Long diferenciaPagoRemotoPSCREPLC;
			
	

	public Long getPagoRemotoCreditoPLCUA() {
		return pagoRemotoCreditoPLCUA;
	}

	public void setPagoRemotoCreditoPLCUA(Long pagoRemotoCreditoPLCUA) {
		this.pagoRemotoCreditoPLCUA = pagoRemotoCreditoPLCUA;
	}

	public Long getPagoRemotoCreditoPSCRE() {
		return pagoRemotoCreditoPSCRE;
	}

	public void setPagoRemotoCreditoPSCRE(Long pagoRemotoCreditoPSCRE) {
		this.pagoRemotoCreditoPSCRE = pagoRemotoCreditoPSCRE;
	}

	public Long getTotalAnulacionesPagoRemoto() {
		return totalAnulacionesPagoRemoto;
	}

	public void setTotalAnulacionesPagoRemoto(Long totalAnulacionesPagoRemoto) {
		this.totalAnulacionesPagoRemoto = totalAnulacionesPagoRemoto;
	}

	public Long getTotalPagoRemotoPSCRE() {
		return totalPagoRemotoPSCRE;
	}

	public void setTotalPagoRemotoPSCRE(Long totalPagoRemotoPSCRE) {
		this.totalPagoRemotoPSCRE = totalPagoRemotoPSCRE;
	}

	public Long getTotalVentasPagoRemotoCreditoPLC() {
		return totalVentasPagoRemotoCreditoPLC;
	}

	public void setTotalVentasPagoRemotoCreditoPLC(Long totalVentasPagoRemotoCreditoPLC) {
		this.totalVentasPagoRemotoCreditoPLC = totalVentasPagoRemotoCreditoPLC;
	}

	public Long getTotalAnulacionesPagoRemotoCreditoPLC() {
		return totalAnulacionesPagoRemotoCreditoPLC;
	}

	public void setTotalAnulacionesPagoRemotoCreditoPLC(Long totalAnulacionesPagoRemotoCreditoPLC) {
		this.totalAnulacionesPagoRemotoCreditoPLC = totalAnulacionesPagoRemotoCreditoPLC;
	}

	public Long getTotalPagoRemotoPLC() {
		return totalPagoRemotoPLC;
	}

	public void setTotalPagoRemotoPLC(Long totalPagoRemotoPLC) {
		this.totalPagoRemotoPLC = totalPagoRemotoPLC;
	}

	public Long getDiferenciaPagoRemotoPLCUAPSCRE() {
		return diferenciaPagoRemotoPLCUAPSCRE;
	}

	public void setDiferenciaPagoRemotoPLCUAPSCRE(Long diferenciaPagoRemotoPLCUAPSCRE) {
		this.diferenciaPagoRemotoPLCUAPSCRE = diferenciaPagoRemotoPLCUAPSCRE;
	}

	public Long getDiferenciaPagoRemotoPSCREPLC() {
		return diferenciaPagoRemotoPSCREPLC;
	}

	public void setDiferenciaPagoRemotoPSCREPLC(Long diferenciaPagoRemotoPSCREPLC) {
		this.diferenciaPagoRemotoPSCREPLC = diferenciaPagoRemotoPSCREPLC;
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

	public Long getTarjetaBancariaVisa() {
		return tarjetaBancariaVisa;
	}

	public void setTarjetaBancariaVisa(Long tarjetaBancariaVisa) {
		this.tarjetaBancariaVisa = tarjetaBancariaVisa;
	}

	public Long getTarjetaBancariaDiners() {
		return tarjetaBancariaDiners;
	}

	public void setTarjetaBancariaDiners(Long tarjetaBancariaDiners) {
		this.tarjetaBancariaDiners = tarjetaBancariaDiners;
	}

	public Long getDonaciones() {
		return donaciones;
	}

	public void setDonaciones(Long donaciones) {
		this.donaciones = donaciones;
	}

	public Long getTotalPLCUA() {
		return totalPLCUA;
	}

	public void setTotalPLCUA(Long totalPLCUA) {
		this.totalPLCUA = totalPLCUA;
	}

	public Long getTotalVentasTarjetaCreditoPSCRE() {
		return totalVentasTarjetaCreditoPSCRE;
	}

	public void setTotalVentasTarjetaCreditoPSCRE(Long totalVentasTarjetaCreditoPSCRE) {
		this.totalVentasTarjetaCreditoPSCRE = totalVentasTarjetaCreditoPSCRE;
	}

	public Long getTotalVentasInternetCreditoPSCRE() {
		return totalVentasInternetCreditoPSCRE;
	}

	public void setTotalVentasInternetCreditoPSCRE(Long totalVentasInternetCreditoPSCRE) {
		this.totalVentasInternetCreditoPSCRE = totalVentasInternetCreditoPSCRE;
	}

	public Long getRecaudacionesPSCRE() {
		return recaudacionesPSCRE;
	}

	public void setRecaudacionesPSCRE(Long recaudacionesPSCRE) {
		this.recaudacionesPSCRE = recaudacionesPSCRE;
	}

	public Long getTotalVentasAnulacionesPSCRE() {
		return totalVentasAnulacionesPSCRE;
	}

	public void setTotalVentasAnulacionesPSCRE(Long totalVentasAnulacionesPSCRE) {
		this.totalVentasAnulacionesPSCRE = totalVentasAnulacionesPSCRE;
	}

	public Long getAnulacionRecaudacionesPSCRE() {
		return anulacionRecaudacionesPSCRE;
	}

	public void setAnulacionRecaudacionesPSCRE(Long anulacionRecaudacionesPSCRE) {
		this.anulacionRecaudacionesPSCRE = anulacionRecaudacionesPSCRE;
	}

	public Long getTotalPSCRE() {
		return totalPSCRE;
	}

	public void setTotalPSCRE(Long totalPSCRE) {
		this.totalPSCRE = totalPSCRE;
	}

	public Long getTotalVentasTarjetaCreditoPLC() {
		return totalVentasTarjetaCreditoPLC;
	}

	public void setTotalVentasTarjetaCreditoPLC(Long totalVentasTarjetaCreditoPLC) {
		this.totalVentasTarjetaCreditoPLC = totalVentasTarjetaCreditoPLC;
	}

	public Long getTotalVentasInternetCreditoPLC() {
		return totalVentasInternetCreditoPLC;
	}

	public void setTotalVentasInternetCreditoPLC(Long totalVentasInternetCreditoPLC) {
		this.totalVentasInternetCreditoPLC = totalVentasInternetCreditoPLC;
	}

	public Long getTotalAnulacionesNCAPLC() {
		return totalAnulacionesNCAPLC;
	}

	public void setTotalAnulacionesNCAPLC(Long totalAnulacionesNCAPLC) {
		this.totalAnulacionesNCAPLC = totalAnulacionesNCAPLC;
	}

	public Long getTotalRecaudacionesPLC() {
		return totalRecaudacionesPLC;
	}

	public void setTotalRecaudacionesPLC(Long totalRecaudacionesPLC) {
		this.totalRecaudacionesPLC = totalRecaudacionesPLC;
	}

	public Long getTotalAnulacionRecaudacionesPLC() {
		return totalAnulacionRecaudacionesPLC;
	}

	public void setTotalAnulacionRecaudacionesPLC(Long totalAnulacionRecaudacionesPLC) {
		this.totalAnulacionRecaudacionesPLC = totalAnulacionRecaudacionesPLC;
	}

	public Long getTotalPLC() {
		return totalPLC;
	}

	public void setTotalPLC(Long totalPLC) {
		this.totalPLC = totalPLC;
	}

	public Long getDiferenciaPLCUAPSCRE() {
		return diferenciaPLCUAPSCRE;
	}

	public void setDiferenciaPLCUAPSCRE(Long diferenciaPLCUAPSCRE) {
		this.diferenciaPLCUAPSCRE = diferenciaPLCUAPSCRE;
	}

	public Long getDiferenciaPSCREPLC() {
		return diferenciaPSCREPLC;
	}

	public void setDiferenciaPSCREPLC(Long diferenciaPSCREPLC) {
		this.diferenciaPSCREPLC = diferenciaPSCREPLC;
	}

}
