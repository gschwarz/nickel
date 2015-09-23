package com.rhiscom.bpm.console.server.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "file_sctfa")
public class SCTFAEntity implements Serializable {

	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "pa_sctf.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Integer id;

	private Long granTotalVentas;
	private Long granTotalRecaudaciones;
	private Long granTotalDevolucionesCMRNCA;
	private Long granTotalDevolucionesCMRNCR;
	private Long granTotalAnulacionGiftCard;
	private Date fechaTrx;
	private Long sucursal;
	private Long totalAvanceEfectivo;
	private Long totalAnulacionesAvanceEfectivo;
	private Long totalSuperAvanceEfectivo;
	private Long totalAnulacionesSuperAvance;
	private Long totalAbonos;
	private Long totalAbonoRepactacion;
	private Long totalAnulacionAbonoNormal;
	private Long totalAnulacionAbonoRepactacion;
	
	
	public Long getTotalAbonos() {
		return totalAbonos;
	}
	public void setTotalAbonos(Long totalAbonos) {
		this.totalAbonos = totalAbonos;
	}
	public Long getTotalAbonoRepactacion() {
		return totalAbonoRepactacion;
	}
	public void setTotalAbonoRepactacion(Long totalAbonoRepactacion) {
		this.totalAbonoRepactacion = totalAbonoRepactacion;
	}
	public Long getTotalAvanceEfectivo() {
		return totalAvanceEfectivo;
	}
	public void setTotalAvanceEfectivo(Long totalAvanceEfectivo) {
		this.totalAvanceEfectivo = totalAvanceEfectivo;
	}
	public Long getTotalAnulacionesAvanceEfectivo() {
		return totalAnulacionesAvanceEfectivo;
	}
	public void setTotalAnulacionesAvanceEfectivo(Long totalAnulacionesAvanceEfectivo) {
		this.totalAnulacionesAvanceEfectivo = totalAnulacionesAvanceEfectivo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public Long getGranTotalAnulacionGiftCard() {
		return granTotalAnulacionGiftCard;
	}
	public void setGranTotalAnulacionGiftCard(Long granTotalAnulacionGiftCard) {
		this.granTotalAnulacionGiftCard = granTotalAnulacionGiftCard;
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
	public Long getGranTotalDevolucionesCMRNCR() {
		return granTotalDevolucionesCMRNCR;
	}
	public void setGranTotalDevolucionesCMRNCR(Long granTotalDevolucionesCMRNCR) {
		this.granTotalDevolucionesCMRNCR = granTotalDevolucionesCMRNCR;
	}
	public Long getTotalSuperAvanceEfectivo() {
		return totalSuperAvanceEfectivo;
	}
	public void setTotalSuperAvanceEfectivo(Long totalSuperAvanceEfectivo) {
		this.totalSuperAvanceEfectivo = totalSuperAvanceEfectivo;
	}
	public Long getTotalAnulacionesSuperAvance() {
		return totalAnulacionesSuperAvance;
	}
	public void setTotalAnulacionesSuperAvance(Long totalAnulacionesSuperAvance) {
		this.totalAnulacionesSuperAvance = totalAnulacionesSuperAvance;
	}
	public Long getTotalAnulacionAbonoNormal() {
		return totalAnulacionAbonoNormal;
	}
	public void setTotalAnulacionAbonoNormal(Long totalAnulacionAbonoNormal) {
		this.totalAnulacionAbonoNormal = totalAnulacionAbonoNormal;
	}
	public Long getTotalAnulacionAbonoRepactacion() {
		return totalAnulacionAbonoRepactacion;
	}
	public void setTotalAnulacionAbonoRepactacion(Long totalAnulacionAbonoRepactacion) {
		this.totalAnulacionAbonoRepactacion = totalAnulacionAbonoRepactacion;
	}

	

}
