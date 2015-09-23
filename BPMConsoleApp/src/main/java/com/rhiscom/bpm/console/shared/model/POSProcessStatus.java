package com.rhiscom.bpm.console.shared.model;

import java.io.Serializable;
import java.util.HashMap;

public class POSProcessStatus implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private int numeroTienda;
    private long codigoTienda;
    private String nombreTienda;

    private int estado;
    private HashMap<String, String> estadosADS;

    private String fechaApertura;
    private String fechaServidor;
    private String tipoDocumento;
    private String fechaCreacion;
    private String fechaUltimaApertura;

    private String fechaConsulta;

    public int getNumeroTienda() {
	return numeroTienda;
    }

    public void setNumeroTienda(int numeroTienda) {
	this.numeroTienda = numeroTienda;
    }

    public long getCodigoTienda() {
	return codigoTienda;
    }

    public void setCodigoTienda(long codigoTienda) {
	this.codigoTienda = codigoTienda;
    }

    public String getNombreTienda() {
	return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
	this.nombreTienda = nombreTienda;
    }

    public int getEstado() {
	return estado;
    }

    public void setEstado(int estado) {
	this.estado = estado;
    }

    public HashMap<String, String> getEstadosADS() {
	return estadosADS;
    }

    public void setEstadosADS(HashMap<String, String> estadosADS) {
	this.estadosADS = estadosADS;
    }

    public String getFechaApertura() {
	return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
	this.fechaApertura = fechaApertura;
    }

    public String getFechaServidor() {
	return fechaServidor;
    }

    public void setFechaServidor(String fechaServidor) {
	this.fechaServidor = fechaServidor;
    }

    public String getTipoDocumento() {
	return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
	this.tipoDocumento = tipoDocumento;
    }

    public String getFechaCreacion() {
	return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
    }

    public String getFechaConsulta() {
	return fechaConsulta;
    }

    public void setFechaConsulta(String fechaConsulta) {
	this.fechaConsulta = fechaConsulta;
    }

    public String getFechaUltimaApertura() {
	return fechaUltimaApertura;
    }

    public void setFechaUltimaApertura(String fechaUltimaApertura) {
	this.fechaUltimaApertura = fechaUltimaApertura;
    }

}