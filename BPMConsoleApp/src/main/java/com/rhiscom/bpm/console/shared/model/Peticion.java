package com.rhiscom.bpm.console.shared.model;

import java.io.Serializable;
import java.util.Date;

public class Peticion implements Serializable {

    private String idUsuario;
    private String transaccion;
    private Date fechaConsulta;

    public String getIdUsuario() {
	return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
	this.idUsuario = idUsuario;
    }

    public String getTransaccion() {
	return transaccion;
    }

    public void setTransaccion(String transaccion) {
	this.transaccion = transaccion;
    }

    public Date getFechaConsulta() {
	return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
	this.fechaConsulta = fechaConsulta;
    }

}
