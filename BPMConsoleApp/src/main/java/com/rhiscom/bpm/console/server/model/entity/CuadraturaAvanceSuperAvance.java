package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuad_avancesuperavance")
public class CuadraturaAvanceSuperAvance {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private Long totalAvanceCMR;
    private Long totalAnulacionesAvanceCMR;
    private Long totalAvance;
    private Long totalSuperAvanceCMR;
    private Long totalAnulacionesSuperAvanceCMR;
    private Long totalSuperavance;
    private Long totalAvanceCMRARQTF;
    private Long totalAnulacionesAvanceCMRARQTF;
    private Long totalAvanceARQTF;
    private Long totalSuperAvanceCMRARQTF;
    private Long totalAnulacionesSuperAvanceCMRARQTF;
    private Long totalSuperAvanceARQTF;
    private Long totalAvanceCMRCRCMR;
    private Long totalAvanceAnuladosCMRCRCMR;
    private Long totalAvanceCRCMR;
    private Long totalSuperAvanceCMRCRCMR;
    private Long totalAnulacionesSuperAvanceCRCMR;
    private Long totalSuperAvanceCRCMR;
    private Long diferenciaAvancePLCUACRCMR;
    private Long diferenciaSuperAvancePLCUACRCMR;
    private Long diferenciaAvanceSCTFACRCMR;
    private Long diferenciaSuperAvanceSCTFACRCMR;
    private Long diferenciaAvancePLCUASCTFA;
    private Long diferenciaSuperAvancePLCUASCTFA;

    /**
     * Avance
     */
    private Long totalTrx220SAT;
    private Long totalTrx403SAT;
    private Long totalAvanceFinalSAT;

    private Long totalTrx220RSAT;
    private Long totalTrx403RSAT;
    private Long totalAvanceFinalRSAT;

    private Long diferenciaSATCRCMRAvance;
    private Long diferenciaRSATCRCMRAvance;

    /**
     * SuperAvance
     */
    private Long totalTrx274SAT;
    private Long totalTrx473SAT;
    private Long totalSuperAvanceFinalSAT;

    private Long totalTrx274RSAT;
    private Long totalTrx473RSAT;
    private Long totalSuperAvanceFinalRSAT;

    private Long diferenciaSATCRCMRSuperAvance;
    private Long diferenciaRSATCRCMRSuperAvance;

    private String sucursal;
    private Date fechaTrx;

    public Long getTotalTrx220SAT() {
	return totalTrx220SAT;
    }

    public void setTotalTrx220SAT(Long totalTrx220SAT) {
	this.totalTrx220SAT = totalTrx220SAT;
    }

    public Long getTotalTrx403SAT() {
	return totalTrx403SAT;
    }

    public void setTotalTrx403SAT(Long totalTrx403SAT) {
	this.totalTrx403SAT = totalTrx403SAT;
    }

    public Long getTotalAvanceFinalSAT() {
	return totalAvanceFinalSAT;
    }

    public void setTotalAvanceFinalSAT(Long totalAvanceFinalSAT) {
	this.totalAvanceFinalSAT = totalAvanceFinalSAT;
    }

    public Long getTotalTrx220RSAT() {
	return totalTrx220RSAT;
    }

    public void setTotalTrx220RSAT(Long totalTrx220RSAT) {
	this.totalTrx220RSAT = totalTrx220RSAT;
    }

    public Long getTotalTrx403RSAT() {
	return totalTrx403RSAT;
    }

    public void setTotalTrx403RSAT(Long totalTrx403RSAT) {
	this.totalTrx403RSAT = totalTrx403RSAT;
    }

    public Long getTotalAvanceFinalRSAT() {
	return totalAvanceFinalRSAT;
    }

    public void setTotalAvanceFinalRSAT(Long totalAvanceFinalRSAT) {
	this.totalAvanceFinalRSAT = totalAvanceFinalRSAT;
    }

    public Long getDiferenciaSATCRCMRAvance() {
	return diferenciaSATCRCMRAvance;
    }

    public void setDiferenciaSATCRCMRAvance(Long diferenciaSATCRCMRAvance) {
	this.diferenciaSATCRCMRAvance = diferenciaSATCRCMRAvance;
    }

    public Long getDiferenciaRSATCRCMRAvance() {
	return diferenciaRSATCRCMRAvance;
    }

    public void setDiferenciaRSATCRCMRAvance(Long diferenciaRSATCRCMRAvance) {
	this.diferenciaRSATCRCMRAvance = diferenciaRSATCRCMRAvance;
    }

    public Long getTotalTrx274SAT() {
	return totalTrx274SAT;
    }

    public void setTotalTrx274SAT(Long totalTrx274SAT) {
	this.totalTrx274SAT = totalTrx274SAT;
    }

    public Long getTotalTrx473SAT() {
	return totalTrx473SAT;
    }

    public void setTotalTrx473SAT(Long totalTrx473SAT) {
	this.totalTrx473SAT = totalTrx473SAT;
    }

    public Long getTotalSuperAvanceFinalSAT() {
	return totalSuperAvanceFinalSAT;
    }

    public void setTotalSuperAvanceFinalSAT(Long totalSuperAvanceFinalSAT) {
	this.totalSuperAvanceFinalSAT = totalSuperAvanceFinalSAT;
    }

    public Long getTotalTrx274RSAT() {
	return totalTrx274RSAT;
    }

    public void setTotalTrx274RSAT(Long totalTrx274RSAT) {
	this.totalTrx274RSAT = totalTrx274RSAT;
    }

    public Long getTotalTrx473RSAT() {
	return totalTrx473RSAT;
    }

    public void setTotalTrx473RSAT(Long totalTrx473RSAT) {
	this.totalTrx473RSAT = totalTrx473RSAT;
    }

    public Long getTotalSuperAvanceFinalRSAT() {
	return totalSuperAvanceFinalRSAT;
    }

    public void setTotalSuperAvanceFinalRSAT(Long totalSuperAvanceFinalRSAT) {
	this.totalSuperAvanceFinalRSAT = totalSuperAvanceFinalRSAT;
    }

    public Long getDiferenciaSATCRCMRSuperAvance() {
	return diferenciaSATCRCMRSuperAvance;
    }

    public void setDiferenciaSATCRCMRSuperAvance(Long diferenciaSATCRCMRSuperAvance) {
	this.diferenciaSATCRCMRSuperAvance = diferenciaSATCRCMRSuperAvance;
    }

    public Long getDiferenciaRSATCRCMRSuperAvance() {
	return diferenciaRSATCRCMRSuperAvance;
    }

    public void setDiferenciaRSATCRCMRSuperAvance(Long diferenciaRSATCRCMRSuperAvance) {
	this.diferenciaRSATCRCMRSuperAvance = diferenciaRSATCRCMRSuperAvance;
    }

    public Long getDiferenciaAvancePLCUACRCMR() {
	return diferenciaAvancePLCUACRCMR;
    }

    public void setDiferenciaAvancePLCUACRCMR(Long diferenciaAvancePLCUACRCMR) {
	this.diferenciaAvancePLCUACRCMR = diferenciaAvancePLCUACRCMR;
    }

    public Long getDiferenciaSuperAvancePLCUACRCMR() {
	return diferenciaSuperAvancePLCUACRCMR;
    }

    public void setDiferenciaSuperAvancePLCUACRCMR(Long diferenciaSuperAvancePLCUACRCMR) {
	this.diferenciaSuperAvancePLCUACRCMR = diferenciaSuperAvancePLCUACRCMR;
    }

    public Long getDiferenciaAvanceSCTFACRCMR() {
	return diferenciaAvanceSCTFACRCMR;
    }

    public void setDiferenciaAvanceSCTFACRCMR(Long diferenciaAvanceSCTFACRCMR) {
	this.diferenciaAvanceSCTFACRCMR = diferenciaAvanceSCTFACRCMR;
    }

    public Long getDiferenciaSuperAvanceSCTFACRCMR() {
	return diferenciaSuperAvanceSCTFACRCMR;
    }

    public void setDiferenciaSuperAvanceSCTFACRCMR(Long diferenciaSuperAvanceSCTFACRCMR) {
	this.diferenciaSuperAvanceSCTFACRCMR = diferenciaSuperAvanceSCTFACRCMR;
    }

    public Long getDiferenciaAvancePLCUASCTFA() {
	return diferenciaAvancePLCUASCTFA;
    }

    public void setDiferenciaAvancePLCUASCTFA(Long diferenciaAvancePLCUASCTFA) {
	this.diferenciaAvancePLCUASCTFA = diferenciaAvancePLCUASCTFA;
    }

    public Long getDiferenciaSuperAvancePLCUASCTFA() {
	return diferenciaSuperAvancePLCUASCTFA;
    }

    public void setDiferenciaSuperAvancePLCUASCTFA(Long diferenciaSuperAvancePLCUASCTFA) {
	this.diferenciaSuperAvancePLCUASCTFA = diferenciaSuperAvancePLCUASCTFA;
    }

    public Long getTotalSuperAvanceCMRCRCMR() {
	return totalSuperAvanceCMRCRCMR;
    }

    public void setTotalSuperAvanceCMRCRCMR(Long totalSuperAvanceCMRCRCMR) {
	this.totalSuperAvanceCMRCRCMR = totalSuperAvanceCMRCRCMR;
    }

    public Long getTotalAnulacionesSuperAvanceCRCMR() {
	return totalAnulacionesSuperAvanceCRCMR;
    }

    public void setTotalAnulacionesSuperAvanceCRCMR(Long totalAnulacionesSuperAvanceCRCMR) {
	this.totalAnulacionesSuperAvanceCRCMR = totalAnulacionesSuperAvanceCRCMR;
    }

    public Long getTotalSuperAvanceCRCMR() {
	return totalSuperAvanceCRCMR;
    }

    public void setTotalSuperAvanceCRCMR(Long totalSuperAvanceCRCMR) {
	this.totalSuperAvanceCRCMR = totalSuperAvanceCRCMR;
    }

    public Long getTotalAvanceCMRCRCMR() {
	return totalAvanceCMRCRCMR;
    }

    public void setTotalAvanceCMRCRCMR(Long totalAvanceCMRCRCMR) {
	this.totalAvanceCMRCRCMR = totalAvanceCMRCRCMR;
    }

    public Long getTotalAvanceAnuladosCMRCRCMR() {
	return totalAvanceAnuladosCMRCRCMR;
    }

    public void setTotalAvanceAnuladosCMRCRCMR(Long totalAvanceAnuladosCMRCRCMR) {
	this.totalAvanceAnuladosCMRCRCMR = totalAvanceAnuladosCMRCRCMR;
    }

    public Long getTotalAvanceCRCMR() {
	return totalAvanceCRCMR;
    }

    public void setTotalAvanceCRCMR(Long totalAvanceCRCMR) {
	this.totalAvanceCRCMR = totalAvanceCRCMR;
    }

    public Long getTotalSuperAvanceCMRARQTF() {
	return totalSuperAvanceCMRARQTF;
    }

    public void setTotalSuperAvanceCMRARQTF(Long totalSuperAvanceCMRARQTF) {
	this.totalSuperAvanceCMRARQTF = totalSuperAvanceCMRARQTF;
    }

    public Long getTotalAnulacionesSuperAvanceCMRARQTF() {
	return totalAnulacionesSuperAvanceCMRARQTF;
    }

    public void setTotalAnulacionesSuperAvanceCMRARQTF(Long totalAnulacionesSuperAvanceCMRARQTF) {
	this.totalAnulacionesSuperAvanceCMRARQTF = totalAnulacionesSuperAvanceCMRARQTF;
    }

    public Long getTotalAvanceCMRARQTF() {
	return totalAvanceCMRARQTF;
    }

    public void setTotalAvanceCMRARQTF(Long totalAvanceCMRARQTF) {
	this.totalAvanceCMRARQTF = totalAvanceCMRARQTF;
    }

    public Long getTotalAnulacionesAvanceCMRARQTF() {
	return totalAnulacionesAvanceCMRARQTF;
    }

    public void setTotalAnulacionesAvanceCMRARQTF(Long totalAnulacionesAvanceCMRARQTF) {
	this.totalAnulacionesAvanceCMRARQTF = totalAnulacionesAvanceCMRARQTF;
    }

    public Long getTotalSuperAvanceCMR() {
	return totalSuperAvanceCMR;
    }

    public void setTotalSuperAvanceCMR(Long totalSuperAvanceCMR) {
	this.totalSuperAvanceCMR = totalSuperAvanceCMR;
    }

    public Long getTotalAnulacionesSuperAvanceCMR() {
	return totalAnulacionesSuperAvanceCMR;
    }

    public void setTotalAnulacionesSuperAvanceCMR(Long totalAnulacionesSuperAvanceCMR) {
	this.totalAnulacionesSuperAvanceCMR = totalAnulacionesSuperAvanceCMR;
    }

    public Long getTotalSuperavance() {
	return totalSuperavance;
    }

    public void setTotalSuperavance(Long totalSuperavance) {
	this.totalSuperavance = totalSuperavance;
    }

    public String getSucursal() {
	return sucursal;
    }

    public void setSucursal(String sucursal) {
	this.sucursal = sucursal;
    }

    public Date getFechaTrx() {
	return fechaTrx;
    }

    public void setFechaTrx(Date fechaTrx) {
	this.fechaTrx = fechaTrx;
    }

    public Long getTotalAvanceCMR() {
	return totalAvanceCMR;
    }

    public void setTotalAvanceCMR(Long totalAvanceCMR) {
	this.totalAvanceCMR = totalAvanceCMR;
    }

    public Long getTotalAnulacionesAvanceCMR() {
	return totalAnulacionesAvanceCMR;
    }

    public void setTotalAnulacionesAvanceCMR(Long totalAnulacionesAvanceCMR) {
	this.totalAnulacionesAvanceCMR = totalAnulacionesAvanceCMR;
    }

    public Long getTotalAvance() {
	return totalAvance;
    }

    public void setTotalAvance(Long totalAvance) {
	this.totalAvance = totalAvance;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getTotalAvanceARQTF() {
	return totalAvanceARQTF;
    }

    public void setTotalAvanceARQTF(Long totalAvanceARQTF) {
	this.totalAvanceARQTF = totalAvanceARQTF;
    }

    public Long getTotalSuperAvanceARQTF() {
	return totalSuperAvanceARQTF;
    }

    public void setTotalSuperAvanceARQTF(Long totalSuperAvanceARQTF) {
	this.totalSuperAvanceARQTF = totalSuperAvanceARQTF;
    }

}
