package com.rhiscom.cuadratura.model;

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
@Table(name = "file_plc")
public class PLCEntity implements Serializable {

	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "pa_plc.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private int id;
	
	private Date fechaTrx;
	private String tipoTrx;
	private String estado;
	private String tipoTarjeta;
	private Long monto;
	private String tipoDocumento;
	private Long sucursal;
	private Long donacion;
	private String pagoRemoto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaTrx() {
		return fechaTrx;
	}
	public void setFechaTrx(Date fechaTrx) {
		this.fechaTrx = fechaTrx;
	}
	public String getTipoTrx() {
		return tipoTrx;
	}
	public void setTipoTrx(String tipoTrx) {
		this.tipoTrx = tipoTrx;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
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
	public String getPagoRemoto() {
		return pagoRemoto;
	}
	public void setPagoRemoto(String pagoRemoto) {
		this.pagoRemoto = pagoRemoto;
	}
	
	
	

}
