package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "core_case")
public class CoreCase {

    @Id
    @GeneratedValue
    @Column(name = "id_core_case")
    private Long id;
    @Column(name = "core_case_name")
    private String nombre;
    @Column(name = "core_id_process")
    private String idProceso;

    @Column(name = "core_case_generate")
    private Date fechaGeneracion;
    @Column(name = "core_case_last_modification")
    private Date fechaUltimaModificacion;
    @Column(name = "core_case_origin")
    private String origen;
    @Column(name = "core_case_local")
    private Long local;
    @Column(name = "core_case_status")
    private String estado;

    public CoreCase() {

    }

    public CoreCase(Long id2, String estado2, Date fechaGeneracion2, Date fechaGeneracion3,
	    Date fechaUltimaModificacion2, String idProceso2, Long local2, String nombre2, String origen2) {

	estado = estado2;
	fechaGeneracion = fechaGeneracion2;
	fechaUltimaModificacion = fechaUltimaModificacion2;
	idProceso = idProceso2;
	local = local2;
	nombre = nombre2;
	origen = origen2;

    }

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
