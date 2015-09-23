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
@Table(name = "file_arqgm")
public class ARQGMEntity {

	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "pa_arqgm.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Integer id;
	private Long grantotalActivacionGiftCMR;
	private Long granTotalVentasConGiftCMR;
	private Long granTotalAnulacionActivacion;
	private Long granTotalAnulacionVentas;
	private Long granTotalAbono;
	private Long granTotalAnulacionAbono;
	private Date fechaTrx;
	private Long sucursal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getGrantotalActivacionGiftCMR() {
		return grantotalActivacionGiftCMR;
	}

	public void setGrantotalActivacionGiftCMR(Long grantotalActivacionGiftCMR) {
		this.grantotalActivacionGiftCMR = grantotalActivacionGiftCMR;
	}

	public Long getGranTotalVentasConGiftCMR() {
		return granTotalVentasConGiftCMR;
	}

	public void setGranTotalVentasConGiftCMR(Long granTotalVentasConGiftCMR) {
		this.granTotalVentasConGiftCMR = granTotalVentasConGiftCMR;
	}

	public Long getGranTotalAnulacionActivacion() {
		return granTotalAnulacionActivacion;
	}

	public void setGranTotalAnulacionActivacion(Long granTotalAnulacionActivacion) {
		this.granTotalAnulacionActivacion = granTotalAnulacionActivacion;
	}

	public Long getGranTotalAnulacionVentas() {
		return granTotalAnulacionVentas;
	}

	public void setGranTotalAnulacionVentas(Long granTotalAnulacionVentas) {
		this.granTotalAnulacionVentas = granTotalAnulacionVentas;
	}

	public Long getGranTotalAbono() {
		return granTotalAbono;
	}

	public void setGranTotalAbono(Long granTotalAbono) {
		this.granTotalAbono = granTotalAbono;
	}

	public Long getGranTotalAnulacionAbono() {
		return granTotalAnulacionAbono;
	}

	public void setGranTotalAnulacionAbono(Long granTotalAnulacionAbono) {
		this.granTotalAnulacionAbono = granTotalAnulacionAbono;
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

}
