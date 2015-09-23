package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class CoreCaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String idProceso;

    private Date fechaGeneracion;
    private Date fechaUltimaModificacion;
    private String origen;
    private Long local;
    private String estado;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getIdProceso() {
	return idProceso;
    }

    public void setIdProceso(String idProceso) {
	this.idProceso = idProceso;
    }

    public Date getFechaGeneracion() {
	return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
	this.fechaGeneracion = fechaGeneracion;
    }

    public Date getFechaUltimaModificacion() {
	return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
	this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public String getOrigen() {
	return origen;
    }

    public void setOrigen(String origen) {
	this.origen = origen;
    }

    public Long getLocal() {
	return local;
    }

    public void setLocal(Long local) {
	this.local = local;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }

}
