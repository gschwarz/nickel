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
@Table(name = "file_psdeb")
public class PSDEBEntity {
	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "pa_psdeb.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Integer id;

	private Date fechaTrx;
	private Long sucursal;
	private Long totalVentasTarjetaDebito;
	private Long totalVentasInternetDebito;
	private Long totalRecaudaciones;
	private Long totalVentasPagoRemotoDebito;
	private Long totalAnulacionPagoRemotoDebito;
	
	public Long getTotalVentasPagoRemotoDebito() {
		return totalVentasPagoRemotoDebito;
	}
	public void setTotalVentasPagoRemotoDebito(Long totalVentasPagoRemotoDebito) {
		this.totalVentasPagoRemotoDebito = totalVentasPagoRemotoDebito;
	}
	public Long getTotalAnulacionPagoRemotoDebito() {
		return totalAnulacionPagoRemotoDebito;
	}
	public void setTotalAnulacionPagoRemotoDebito(Long totalAnulacionPagoRemotoDebito) {
		this.totalAnulacionPagoRemotoDebito = totalAnulacionPagoRemotoDebito;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Long getTotalVentasTarjetaDebito() {
		return totalVentasTarjetaDebito;
	}
	public void setTotalVentasTarjetaDebito(Long totalVentasTarjetaDebito) {
		this.totalVentasTarjetaDebito = totalVentasTarjetaDebito;
	}
	public Long getTotalVentasInternetDebito() {
		return totalVentasInternetDebito;
	}
	public void setTotalVentasInternetDebito(Long totalVentasInternetDebito) {
		this.totalVentasInternetDebito = totalVentasInternetDebito;
	}
	public Long getTotalRecaudaciones() {
		return totalRecaudaciones;
	}
	public void setTotalRecaudaciones(Long totalRecaudaciones) {
		this.totalRecaudaciones = totalRecaudaciones;
	}
	

}
