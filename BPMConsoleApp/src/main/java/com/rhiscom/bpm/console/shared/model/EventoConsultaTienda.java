package com.rhiscom.bpm.console.shared.model;

import java.io.Serializable;

public class EventoConsultaTienda implements Serializable {
    private String tienda;
    private String tiendaEnConjunto;
    private String usuario;
    private String fechaConsulta;

    public EventoConsultaTienda() {

    }

    public String getTienda() {
	return tienda;
    }

    public void setTienda(String tienda) {
	this.tienda = tienda;
    }

    public String getTiendaEnConjunto() {
	return tiendaEnConjunto;
    }

    public void setTiendaEnConjunto(String tiendaEnConjunto) {
	this.tiendaEnConjunto = tiendaEnConjunto;
    }

    public String getUsuario() {
	return usuario;
    }

    public void setUsuario(String usuario) {
	this.usuario = usuario;
    }

    public String getFechaConsulta() {
	return fechaConsulta;
    }

    public void setFechaConsulta(String fechaConsulta) {
	this.fechaConsulta = fechaConsulta;
    }

}
