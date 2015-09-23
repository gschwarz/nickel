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
@Table(name = "file_pscre")
public class PSCREEntity {

	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "pa_pscre.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Integer id;
	
	private Date fechaTrx;
	private Long sucursal;
	private Long totalVentasTarjetaCredito;
	private Long totalVentasInternetCredito;
	private Long totalAnulacionesNCR;
	private Long totalAnulacionesNCA;
	private Long totalAnulacionesInternetNCA;
	private Long totalAnulacionesInternetNCR;
	private Long totalRecaudaciones;
	private Long totalAnulacionesRecaudacion;
	private Long totalAnulacionPagoRemotoCredito;
	private Long totalPagoRemotoCredito;
	
	
	
	public Long getTotalAnulacionPagoRemotoCredito() {
		return totalAnulacionPagoRemotoCredito;
	}
	public void setTotalAnulacionPagoRemotoCredito(Long totalAnulacionPagoRemotoCredito) {
		this.totalAnulacionPagoRemotoCredito = totalAnulacionPagoRemotoCredito;
	}
	public Long getTotalPagoRemotoCredito() {
		return totalPagoRemotoCredito;
	}
	public void setTotalPagoRemotoCredito(Long totalPagoRemotoCredito) {
		this.totalPagoRemotoCredito = totalPagoRemotoCredito;
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
	public Long getTotalVentasTarjetaCredito() {
		return totalVentasTarjetaCredito;
	}
	public void setTotalVentasTarjetaCredito(Long totalVentasTarjetaCredito) {
		this.totalVentasTarjetaCredito = totalVentasTarjetaCredito;
	}
	public Long getTotalVentasInternetCredito() {
		return totalVentasInternetCredito;
	}
	public void setTotalVentasInternetCredito(Long totalVentasInternetCredito) {
		this.totalVentasInternetCredito = totalVentasInternetCredito;
	}
	public Long getTotalAnulacionesNCR() {
		return totalAnulacionesNCR;
	}
	public void setTotalAnulacionesNCR(Long totalAnulacionesNCR) {
		this.totalAnulacionesNCR = totalAnulacionesNCR;
	}
	public Long getTotalAnulacionesNCA() {
		return totalAnulacionesNCA;
	}
	public void setTotalAnulacionesNCA(Long totalAnulacionesNCA) {
		this.totalAnulacionesNCA = totalAnulacionesNCA;
	}
	public Long getTotalAnulacionesInternetNCA() {
		return totalAnulacionesInternetNCA;
	}
	public void setTotalAnulacionesInternetNCA(Long totalAnulacionesInternetNCA) {
		this.totalAnulacionesInternetNCA = totalAnulacionesInternetNCA;
	}
	public Long getTotalAnulacionesInternetNCR() {
		return totalAnulacionesInternetNCR;
	}
	public void setTotalAnulacionesInternetNCR(Long totalAnulacionesInternetNCR) {
		this.totalAnulacionesInternetNCR = totalAnulacionesInternetNCR;
	}
	public Long getTotalRecaudaciones() {
		return totalRecaudaciones;
	}
	public void setTotalRecaudaciones(Long totalRecaudaciones) {
		this.totalRecaudaciones = totalRecaudaciones;
	}
	public Long getTotalAnulacionesRecaudacion() {
		return totalAnulacionesRecaudacion;
	}
	public void setTotalAnulacionesRecaudacion(Long totalAnulacionesRecaudacion) {
		this.totalAnulacionesRecaudacion = totalAnulacionesRecaudacion;
	}
	
	
	
	
}
