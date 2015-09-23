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
@Table(name = "file_plcua")
public class PLCUAEntity implements Serializable {

	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "pa_plcua.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Integer id;

	private Long cuotasNormales;
	private Long cuotasDiferidas;
	private Long tresCC;
	private Long donacion;
	private Long donacionCMRFalabella;
	private Long NCRTF;
	private Long pagoCMRNormal;
	private Long tarjetasBancariasVISA;
	private Date fechatrx;
	private Long sucursal;
	private Long activacionGiftCardCMR;
	private	Long anulacionesActGiftcardCMR;
	private	Long activacionesGiftCardCorporativa;
	private	Long anulacionesGiftCardCorporativa;
	private	Long tarjetaGiftCardCMR;
	private Long tarjetaGiftCardCorporativa;
	private Long ncrGiftCardCMR;
	private Long ncrGiftCardCorporativa;
	private Long donacionesGiftCardCMR;
	private Long donacionesGiftCardCorporativa;
	private Long avanceEfectivoCMR;
	private Long avanceEfectivoAnuladoCMR;
	private Long superAvanceEfectivoAnuladoCMR;
	private Long superAvanceEfectivoCMR;
	private Long pagoCMRRepactado;
	private Long pagoCMRAnulado;
	private Long tarjetaBancariasDiners;
	private Long tarjetasBancarias;
	private Long pagoRemotoCredito;
	private Long pagoRemotoDebito;
	private Long ncrTv;
	private Long tarjetaDebito;
	private Long tarjetaDebitoECommerce;
	
	public Long getSuperAvanceEfectivoAnuladoCMR() {
		return superAvanceEfectivoAnuladoCMR;
	}
	public void setSuperAvanceEfectivoAnuladoCMR(Long superAvanceEfectivoAnuladoCMR) {
		this.superAvanceEfectivoAnuladoCMR = superAvanceEfectivoAnuladoCMR;
	}
	public Long getSuperAvanceEfectivoCMR() {
		return superAvanceEfectivoCMR;
	}
	public void setSuperAvanceEfectivoCMR(Long superAvanceEfectivoCMR) {
		this.superAvanceEfectivoCMR = superAvanceEfectivoCMR;
	}
	public Long getActivacionGiftCardCMR() {
		return activacionGiftCardCMR;
	}
	public void setActivacionGiftCardCMR(Long activacionGiftCardCMR) {
		this.activacionGiftCardCMR = activacionGiftCardCMR;
	}
	public Long getAnulacionesActGiftcardCMR() {
		return anulacionesActGiftcardCMR;
	}
	public void setAnulacionesActGiftcardCMR(Long anulacionesActGiftcardCMR) {
		this.anulacionesActGiftcardCMR = anulacionesActGiftcardCMR;
	}
	public Long getActivacionesGiftCardCorporativa() {
		return activacionesGiftCardCorporativa;
	}
	public void setActivacionesGiftCardCorporativa(Long activacionesGiftCardCorporativa) {
		this.activacionesGiftCardCorporativa = activacionesGiftCardCorporativa;
	}
	public Long getAnulacionesGiftCardCorporativa() {
		return anulacionesGiftCardCorporativa;
	}
	public void setAnulacionesGiftCardCorporativa(Long anulacionesGiftCardCorporativa) {
		this.anulacionesGiftCardCorporativa = anulacionesGiftCardCorporativa;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Long getDonacion() {
		return donacion;
	}
	public void setDonacion(Long donacion) {
		this.donacion = donacion;
	}
	public Long getNCRTF() {
		return NCRTF;
	}
	public void setNCRTF(Long nCRTF) {
		NCRTF = nCRTF;
	}
	public Long getPagoCMRNormal() {
		return pagoCMRNormal;
	}
	public void setPagoCMRNormal(Long pagoCMRNormal) {
		this.pagoCMRNormal = pagoCMRNormal;
	}
	public Long getTarjetasBancariasVISA() {
		return tarjetasBancariasVISA;
	}
	public void setTarjetasBancariasVISA(Long tarjetasBancariasVISA) {
		this.tarjetasBancariasVISA = tarjetasBancariasVISA;
	}
	public Date getFechatrx() {
		return fechatrx;
	}
	public void setFechatrx(Date fechatrx) {
		this.fechatrx = fechatrx;
	}
	public Long getSucursal() {
		return sucursal;
	}
	public void setSucursal(Long sucursal) {
		this.sucursal = sucursal;
	}
	public Long getDonacionCMRFalabella() {
		return donacionCMRFalabella;
	}
	public void setDonacionCMRFalabella(Long donacionCMRFalabella) {
		this.donacionCMRFalabella = donacionCMRFalabella;
	}
	public Long getTarjetaGiftCardCMR() {
		return tarjetaGiftCardCMR;
	}
	public void setTarjetaGiftCardCMR(Long tarjetaGiftCardCMR) {
		this.tarjetaGiftCardCMR = tarjetaGiftCardCMR;
	}
	public Long getTarjetaGiftCardCorporativa() {
		return tarjetaGiftCardCorporativa;
	}
	public void setTarjetaGiftCardCorporativa(Long tarjetaGiftCardCorporativa) {
		this.tarjetaGiftCardCorporativa = tarjetaGiftCardCorporativa;
	}
	public Long getNcrGiftCardCMR() {
		return ncrGiftCardCMR;
	}
	public void setNcrGiftCardCMR(Long ncrGiftCardCMR) {
		this.ncrGiftCardCMR = ncrGiftCardCMR;
	}
	public Long getNcrGiftCardCorporativa() {
		return ncrGiftCardCorporativa;
	}
	public void setNcrGiftCardCorporativa(Long ncrGiftCardCorporativa) {
		this.ncrGiftCardCorporativa = ncrGiftCardCorporativa;
	}
	public Long getDonacionesGiftCardCMR() {
		return donacionesGiftCardCMR;
	}
	public void setDonacionesGiftCardCMR(Long donacionesGiftCardCMR) {
		this.donacionesGiftCardCMR = donacionesGiftCardCMR;
	}
	public Long getDonacionesGiftCardCorporativa() {
		return donacionesGiftCardCorporativa;
	}
	public void setDonacionesGiftCardCorporativa(Long donacionesGiftCardCorporativa) {
		this.donacionesGiftCardCorporativa = donacionesGiftCardCorporativa;
	}
	public Long getAvanceEfectivoCMR() {
		return avanceEfectivoCMR;
	}
	public void setAvanceEfectivoCMR(Long avanceEfectivoCMR) {
		this.avanceEfectivoCMR = avanceEfectivoCMR;
	}
	public Long getAvanceEfectivoAnuladoCMR() {
		return avanceEfectivoAnuladoCMR;
	}
	public void setAvanceEfectivoAnuladoCMR(Long avanceEfectivoAnuladoCMR) {
		this.avanceEfectivoAnuladoCMR = avanceEfectivoAnuladoCMR;
	}
	
	public Long getPagoCMRRepactado() {
		return pagoCMRRepactado;
	}
	public void setPagoCMRRepactado(Long pagoCMRRepactado) {
		this.pagoCMRRepactado = pagoCMRRepactado;
	}
	public Long getPagoCMRAnulado() {
		return pagoCMRAnulado;
	}
	public void setPagoCMRAnulado(Long pagoCMRAnulado) {
		this.pagoCMRAnulado = pagoCMRAnulado;
	}
	public Long getTarjetaBancariasDiners() {
		return tarjetaBancariasDiners;
	}
	public void setTarjetaBancariasDiners(Long tarjetaBancariasDiners) {
		this.tarjetaBancariasDiners = tarjetaBancariasDiners;
	}
	public Long getTarjetasBancarias() {
		return tarjetasBancarias;
	}
	public void setTarjetasBancarias(Long tarjetasBancarias) {
		this.tarjetasBancarias = tarjetasBancarias;
	}
	public Long getPagoRemotoCredito() {
		return pagoRemotoCredito;
	}
	public void setPagoRemotoCredito(Long pagoRemotoCredito) {
		this.pagoRemotoCredito = pagoRemotoCredito;
	}
	public Long getPagoRemotoDebito() {
		return pagoRemotoDebito;
	}
	public void setPagoRemotoDebito(Long pagoRemotoDebito) {
		this.pagoRemotoDebito = pagoRemotoDebito;
	}
	public Long getNcrTv() {
		return ncrTv;
	}
	public void setNcrTv(Long ncrTv) {
		this.ncrTv = ncrTv;
	}
	public Long getTarjetaDebito() {
		return tarjetaDebito;
	}
	public void setTarjetaDebito(Long tarjetaDebito) {
		this.tarjetaDebito = tarjetaDebito;
	}
	public Long getTarjetaDebitoECommerce() {
		return tarjetaDebitoECommerce;
	}
	public void setTarjetaDebitoECommerce(Long tarjetaDebitoECommerce) {
		this.tarjetaDebitoECommerce = tarjetaDebitoECommerce;
	}

	

}
