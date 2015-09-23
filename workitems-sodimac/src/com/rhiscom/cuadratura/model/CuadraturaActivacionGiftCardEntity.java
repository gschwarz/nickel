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
@Table(name = "cuad_actgifcard")
public class CuadraturaActivacionGiftCardEntity {

	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "cuad_actgifcard.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Long id;

	
	
	private Long activacionGiftCardCMR;
	private Long anulacionGiftCardCMR;
	private Long activacionGiftCardCorporativa;
	private Long anulacionGiftCardCorporativa;
	private Long totalGiftCMR;
	private Long totalGiftCorporativa;
	private Long totalGiftCard;
	private Long totalActGiftCMR;
	private Long totalACCGiftCMR;
	private Long totalGiftCMR2;
	private Long totalActGiftCorporativa;
	private Long totalACCGiftCorporativa;
	private Long totalGiftCorporativa2;
	private Long totalGiftCard2;
	private Long diferenciaPlaCuadConPLGC;
	private Long sucursal;
	private Date fechaTrx;

	public Long getActivacionGiftCardCMR() {
		return activacionGiftCardCMR;
	}

	public void setActivacionGiftCardCMR(Long activacionGiftCardCMR) {
		this.activacionGiftCardCMR = activacionGiftCardCMR;
	}

	public Long getAnulacionGiftCardCMR() {
		return anulacionGiftCardCMR;
	}

	public void setAnulacionGiftCardCMR(Long anulacionGiftCardCMR) {
		this.anulacionGiftCardCMR = anulacionGiftCardCMR;
	}

	public Long getActivacionGiftCardCorporativa() {
		return activacionGiftCardCorporativa;
	}

	public void setActivacionGiftCardCorporativa(Long activacionGiftCardCorporativa) {
		this.activacionGiftCardCorporativa = activacionGiftCardCorporativa;
	}

	public Long getAnulacionGiftCardCorporativa() {
		return anulacionGiftCardCorporativa;
	}

	public void setAnulacionGiftCardCorporativa(Long anulacionGiftCardCorporativa) {
		this.anulacionGiftCardCorporativa = anulacionGiftCardCorporativa;
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

	public Long getTotalGiftCMR() {
		return totalGiftCMR;
	}

	public void setTotalGiftCMR(Long totalGiftCMR) {
		this.totalGiftCMR = totalGiftCMR;
	}

	public Long getTotalGiftCorporativa() {
		return totalGiftCorporativa;
	}

	public void setTotalGiftCorporativa(Long totalGiftCorporativa) {
		this.totalGiftCorporativa = totalGiftCorporativa;
	}

	public Long getTotalGiftCard() {
		return totalGiftCard;
	}

	public void setTotalGiftCard(Long totalGiftCard) {
		this.totalGiftCard = totalGiftCard;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotalActGiftCMR() {
		return totalActGiftCMR;
	}

	public void setTotalActGiftCMR(Long totalActGiftCMR) {
		this.totalActGiftCMR = totalActGiftCMR;
	}

	public Long getTotalACCGiftCMR() {
		return totalACCGiftCMR;
	}

	public void setTotalACCGiftCMR(Long totalACCGiftCMR) {
		this.totalACCGiftCMR = totalACCGiftCMR;
	}

	public Long getTotalGiftCMR2() {
		return totalGiftCMR2;
	}

	public void setTotalGiftCMR2(Long totalGiftCMR2) {
		this.totalGiftCMR2 = totalGiftCMR2;
	}

	public Long getTotalActGiftCorporativa() {
		return totalActGiftCorporativa;
	}

	public void setTotalActGiftCorporativa(Long totalActGiftCorporativa) {
		this.totalActGiftCorporativa = totalActGiftCorporativa;
	}

	public Long getTotalACCGiftCorporativa() {
		return totalACCGiftCorporativa;
	}

	public void setTotalACCGiftCorporativa(Long totalACCGiftCorporativa) {
		this.totalACCGiftCorporativa = totalACCGiftCorporativa;
	}

	public Long getTotalGiftCorporativa2() {
		return totalGiftCorporativa2;
	}

	public void setTotalGiftCorporativa2(Long totalGiftCorporativa2) {
		this.totalGiftCorporativa2 = totalGiftCorporativa2;
	}

	public Long getTotalGiftCard2() {
		return totalGiftCard2;
	}

	public void setTotalGiftCard2(Long totalGiftCard2) {
		this.totalGiftCard2 = totalGiftCard2;
	}

	public Long getDiferenciaPlaCuadConPLGC() {
		return diferenciaPlaCuadConPLGC;
	}

	public void setDiferenciaPlaCuadConPLGC(Long diferenciaPlaCuadConPLGC) {
		this.diferenciaPlaCuadConPLGC = diferenciaPlaCuadConPLGC;
	}

}
