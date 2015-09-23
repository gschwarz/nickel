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
@Table(name = "file_pstfp")
public class PSTFPEntity {
	
	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "pa_pstfp.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Integer id;
	
	private Long valorTotal;
	private Long valorDonaciones;
	private Long valorEfectivo;
	private Long valorCheque;
	private Long valorChequeF1;
	private Long valorNotaCredito;
	private Long valorTarjetaDebito;
	private Long valorTarjetaBancaria;
	private Long valorTarjetaDinners;
	private Long valorA1;
	private Long valorCupones;
	private Long valorGiftC;
	private Long valorOrden;
	private Long valorTarjetaCMR;
	private Long sucursal;
	private Date fechaTrx;

	public Long getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Long valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getValorDonaciones() {
		return valorDonaciones;
	}

	public void setValorDonaciones(Long valorDonaciones) {
		this.valorDonaciones = valorDonaciones;
	}

	public Long getValorEfectivo() {
		return valorEfectivo;
	}

	public void setValorEfectivo(Long valorEfectivo) {
		this.valorEfectivo = valorEfectivo;
	}

	public Long getValorCheque() {
		return valorCheque;
	}

	public void setValorCheque(Long valorCheque) {
		this.valorCheque = valorCheque;
	}

	public Long getValorChequeF1() {
		return valorChequeF1;
	}

	public void setValorChequeF1(Long valorChequeF1) {
		this.valorChequeF1 = valorChequeF1;
	}

	public Long getValorNotaCredito() {
		return valorNotaCredito;
	}

	public void setValorNotaCredito(Long valorNotaCredito) {
		this.valorNotaCredito = valorNotaCredito;
	}

	public Long getValorTarjetaDebito() {
		return valorTarjetaDebito;
	}

	public void setValorTarjetaDebito(Long valorTarjetaDebito) {
		this.valorTarjetaDebito = valorTarjetaDebito;
	}

	public Long getValorTarjetaBancaria() {
		return valorTarjetaBancaria;
	}

	public void setValorTarjetaBancaria(Long valorTarjetaBancaria) {
		this.valorTarjetaBancaria = valorTarjetaBancaria;
	}

	public Long getValorTarjetaDinners() {
		return valorTarjetaDinners;
	}

	public void setValorTarjetaDinners(Long valorTarjetaDinners) {
		this.valorTarjetaDinners = valorTarjetaDinners;
	}

	public Long getValorA1() {
		return valorA1;
	}

	public void setValorA1(Long valorA1) {
		this.valorA1 = valorA1;
	}

	public Long getValorCupones() {
		return valorCupones;
	}

	public void setValorCupones(Long valorCupones) {
		this.valorCupones = valorCupones;
	}

	public Long getValorGiftC() {
		return valorGiftC;
	}

	public void setValorGiftC(Long valorGiftC) {
		this.valorGiftC = valorGiftC;
	}

	public Long getValorOrden() {
		return valorOrden;
	}

	public void setValorOrden(Long valorOrden) {
		this.valorOrden = valorOrden;
	}

	public Long getValorTarjetaCMR() {
		return valorTarjetaCMR;
	}

	public void setValorTarjetaCMR(Long valorTarjetaCMR) {
		this.valorTarjetaCMR = valorTarjetaCMR;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}
