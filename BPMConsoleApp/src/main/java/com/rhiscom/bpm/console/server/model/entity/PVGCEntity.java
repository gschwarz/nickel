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
@Table(name = "file_pvgc")
public class PVGCEntity {
	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "pa_pvgc.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Integer id;
	
	private Date fechaTrx;
	private String codigoFuncion;
	private String tipoGift;
	private Long monto;
	private String tipoDocumento;
	private Long sucursal;
	private Long donacion;
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
	
	public Long getMonto() {
		return monto;
	}
	public void setMonto(Long monto) {
		this.monto = monto;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Long getSucursal() {
		return sucursal;
	}
	public void setSucursal(Long sucursal) {
		this.sucursal = sucursal;
	}
	public Long getDonacion() {
		return donacion;
	}
	public void setDonacion(Long donacion) {
		this.donacion = donacion;
	}
	public String getCodigoFuncion() {
		return codigoFuncion;
	}
	public void setCodigoFuncion(String codigoFuncion) {
		this.codigoFuncion = codigoFuncion;
	}
	public String getTipoGift() {
		return tipoGift;
	}
	public void setTipoGift(String tipoGift) {
		this.tipoGift = tipoGift;
	}
	
	
	
	
}
