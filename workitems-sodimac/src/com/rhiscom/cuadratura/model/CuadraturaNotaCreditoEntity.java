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
@Table(name = "cuad_notacredito")
public class CuadraturaNotaCreditoEntity implements Serializable {

	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "cuad_notacredito.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Long id;

	private Long ncrTvPLCUa;
	private Long totalAnulacionesNCRPSCRE;
	private Long diferenciaPLACUAPSCRE;
	private Long totalAnulacionesNCRPLC;
	private Long diferenciaPSCREPLC;
	private Long sucursal;
	private Date fechaTrx;
	

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



	public Long getId() {
		return id;
	}
	
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNcrTvPLCUa() {
		return ncrTvPLCUa;
	}

	public void setNcrTvPLCUa(Long ncrTvPLCUa) {
		this.ncrTvPLCUa = ncrTvPLCUa;
	}

	public Long getTotalAnulacionesNCRPSCRE() {
		return totalAnulacionesNCRPSCRE;
	}

	public void setTotalAnulacionesNCRPSCRE(Long totalAnulacionesNCRPSCRE) {
		this.totalAnulacionesNCRPSCRE = totalAnulacionesNCRPSCRE;
	}

	public Long getDiferenciaPLACUAPSCRE() {
		return diferenciaPLACUAPSCRE;
	}

	public void setDiferenciaPLACUAPSCRE(Long diferenciaPLACUAPSCRE) {
		this.diferenciaPLACUAPSCRE = diferenciaPLACUAPSCRE;
	}

	public Long getTotalAnulacionesNCRPLC() {
		return totalAnulacionesNCRPLC;
	}

	public void setTotalAnulacionesNCRPLC(Long totalAnulacionesNCRPLC) {
		this.totalAnulacionesNCRPLC = totalAnulacionesNCRPLC;
	}

	public Long getDiferenciaPSCREPLC() {
		return diferenciaPSCREPLC;
	}

	public void setDiferenciaPSCREPLC(Long diferenciaPSCREPLC) {
		this.diferenciaPSCREPLC = diferenciaPSCREPLC;
	}

}
