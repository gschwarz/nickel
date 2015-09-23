package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class CuadraturaAvanceSuperAvanceDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private long id;

    private long totalAvanceCMR;
    private long totalAnulacionesAvanceCMR;
    private long totalAvance;
    private long totalSuperAvanceCMR;
    private long totalAnulacionesSuperAvanceCMR;
    private long totalSuperavance;
    private long totalAvanceCMRARQTF;
    private long totalAnulacionesAvanceCMRARQTF;
    private long totalAvanceARQTF;
    private long totalSuperAvanceCMRARQTF;
    private long totalAnulacionesSuperAvanceCMRARQTF;
    private long totalSuperAvanceARQTF;
    private long totalAvanceCMRCRCMR;
    private long totalAvanceAnuladosCMRCRCMR;
    private long totalAvanceCRCMR;
    private long totalSuperAvanceCMRCRCMR;
    private long totalAnulacionesSuperAvanceCRCMR;
    private long totalSuperAvanceCRCMR;
    private long diferenciaAvancePLCUACRCMR;
    private long diferenciaSuperAvancePLCUACRCMR;
    private long diferenciaAvanceSCTFACRCMR;
    private long diferenciaSuperAvanceSCTFACRCMR;
    private long diferenciaAvancePLCUASCTFA;
    private long diferenciaSuperAvancePLCUASCTFA;
    private String versionPOS;

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

    public long getDiferenciaAvancePLCUACRCMR() {
	return diferenciaAvancePLCUACRCMR;
    }

    public void setDiferenciaAvancePLCUACRCMR(long diferenciaAvancePLCUACRCMR) {
	this.diferenciaAvancePLCUACRCMR = diferenciaAvancePLCUACRCMR;
    }

    public long getDiferenciaSuperAvancePLCUACRCMR() {
	return diferenciaSuperAvancePLCUACRCMR;
    }

    public void setDiferenciaSuperAvancePLCUACRCMR(long diferenciaSuperAvancePLCUACRCMR) {
	this.diferenciaSuperAvancePLCUACRCMR = diferenciaSuperAvancePLCUACRCMR;
    }

    public long getDiferenciaAvanceSCTFACRCMR() {
	return diferenciaAvanceSCTFACRCMR;
    }

    public void setDiferenciaAvanceSCTFACRCMR(long diferenciaAvanceSCTFACRCMR) {
	this.diferenciaAvanceSCTFACRCMR = diferenciaAvanceSCTFACRCMR;
    }

    public long getDiferenciaSuperAvanceSCTFACRCMR() {
	return diferenciaSuperAvanceSCTFACRCMR;
    }

    public void setDiferenciaSuperAvanceSCTFACRCMR(long diferenciaSuperAvanceSCTFACRCMR) {
	this.diferenciaSuperAvanceSCTFACRCMR = diferenciaSuperAvanceSCTFACRCMR;
    }

    public long getDiferenciaAvancePLCUASCTFA() {
	return diferenciaAvancePLCUASCTFA;
    }

    public void setDiferenciaAvancePLCUASCTFA(long diferenciaAvancePLCUASCTFA) {
	this.diferenciaAvancePLCUASCTFA = diferenciaAvancePLCUASCTFA;
    }

    public long getDiferenciaSuperAvancePLCUASCTFA() {
	return diferenciaSuperAvancePLCUASCTFA;
    }

    public void setDiferenciaSuperAvancePLCUASCTFA(long diferenciaSuperAvancePLCUASCTFA) {
	this.diferenciaSuperAvancePLCUASCTFA = diferenciaSuperAvancePLCUASCTFA;
    }

    public long getTotalSuperAvanceCMRCRCMR() {
	return totalSuperAvanceCMRCRCMR;
    }

    public void setTotalSuperAvanceCMRCRCMR(long totalSuperAvanceCMRCRCMR) {
	this.totalSuperAvanceCMRCRCMR = totalSuperAvanceCMRCRCMR;
    }

    public long getTotalAnulacionesSuperAvanceCRCMR() {
	return totalAnulacionesSuperAvanceCRCMR;
    }

    public void setTotalAnulacionesSuperAvanceCRCMR(long totalAnulacionesSuperAvanceCRCMR) {
	this.totalAnulacionesSuperAvanceCRCMR = totalAnulacionesSuperAvanceCRCMR;
    }

    public long getTotalSuperAvanceCRCMR() {
	return totalSuperAvanceCRCMR;
    }

    public void setTotalSuperAvanceCRCMR(long totalSuperAvanceCRCMR) {
	this.totalSuperAvanceCRCMR = totalSuperAvanceCRCMR;
    }

    public long getTotalAvanceCMRCRCMR() {
	return totalAvanceCMRCRCMR;
    }

    public void setTotalAvanceCMRCRCMR(long totalAvanceCMRCRCMR) {
	this.totalAvanceCMRCRCMR = totalAvanceCMRCRCMR;
    }

    public long getTotalAvanceAnuladosCMRCRCMR() {
	return totalAvanceAnuladosCMRCRCMR;
    }

    public void setTotalAvanceAnuladosCMRCRCMR(long totalAvanceAnuladosCMRCRCMR) {
	this.totalAvanceAnuladosCMRCRCMR = totalAvanceAnuladosCMRCRCMR;
    }

    public long getTotalAvanceCRCMR() {
	return totalAvanceCRCMR;
    }

    public void setTotalAvanceCRCMR(long totalAvanceCRCMR) {
	this.totalAvanceCRCMR = totalAvanceCRCMR;
    }

    public long getTotalSuperAvanceCMRARQTF() {
	return totalSuperAvanceCMRARQTF;
    }

    public void setTotalSuperAvanceCMRARQTF(long totalSuperAvanceCMRARQTF) {
	this.totalSuperAvanceCMRARQTF = totalSuperAvanceCMRARQTF;
    }

    public long getTotalAnulacionesSuperAvanceCMRARQTF() {
	return totalAnulacionesSuperAvanceCMRARQTF;
    }

    public void setTotalAnulacionesSuperAvanceCMRARQTF(long totalAnulacionesSuperAvanceCMRARQTF) {
	this.totalAnulacionesSuperAvanceCMRARQTF = totalAnulacionesSuperAvanceCMRARQTF;
    }

    public long getTotalAvanceCMRARQTF() {
	return totalAvanceCMRARQTF;
    }

    public void setTotalAvanceCMRARQTF(long totalAvanceCMRARQTF) {
	this.totalAvanceCMRARQTF = totalAvanceCMRARQTF;
    }

    public long getTotalAnulacionesAvanceCMRARQTF() {
	return totalAnulacionesAvanceCMRARQTF;
    }

    public void setTotalAnulacionesAvanceCMRARQTF(long totalAnulacionesAvanceCMRARQTF) {
	this.totalAnulacionesAvanceCMRARQTF = totalAnulacionesAvanceCMRARQTF;
    }

    public long getTotalSuperAvanceCMR() {
	return totalSuperAvanceCMR;
    }

    public void setTotalSuperAvanceCMR(long totalSuperAvanceCMR) {
	this.totalSuperAvanceCMR = totalSuperAvanceCMR;
    }

    public long getTotalAnulacionesSuperAvanceCMR() {
	return totalAnulacionesSuperAvanceCMR;
    }

    public void setTotalAnulacionesSuperAvanceCMR(long totalAnulacionesSuperAvanceCMR) {
	this.totalAnulacionesSuperAvanceCMR = totalAnulacionesSuperAvanceCMR;
    }

    public long getTotalSuperavance() {
	return totalSuperavance;
    }

    public void setTotalSuperavance(long totalSuperavance) {
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

    public long getTotalAvanceCMR() {
	return totalAvanceCMR;
    }

    public void setTotalAvanceCMR(long totalAvanceCMR) {
	this.totalAvanceCMR = totalAvanceCMR;
    }

    public long getTotalAnulacionesAvanceCMR() {
	return totalAnulacionesAvanceCMR;
    }

    public void setTotalAnulacionesAvanceCMR(long totalAnulacionesAvanceCMR) {
	this.totalAnulacionesAvanceCMR = totalAnulacionesAvanceCMR;
    }

    public long getTotalAvance() {
	return totalAvance;
    }

    public void setTotalAvance(long totalAvance) {
	this.totalAvance = totalAvance;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public long getTotalAvanceARQTF() {
	return totalAvanceARQTF;
    }

    public void setTotalAvanceARQTF(long totalAvanceARQTF) {
	this.totalAvanceARQTF = totalAvanceARQTF;
    }

    public long getTotalSuperAvanceARQTF() {
	return totalSuperAvanceARQTF;
    }

    public void setTotalSuperAvanceARQTF(long totalSuperAvanceARQTF) {
	this.totalSuperAvanceARQTF = totalSuperAvanceARQTF;
    }

    public String getVersionPOS() {
	return versionPOS;
    }

    public void setVersionPOS(String versionPOS) {
	this.versionPOS = versionPOS;
    }

}
