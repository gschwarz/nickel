package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

public class ControllerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private int local;

    private String nombre;

    private String rol;

    private int tipo;

    private String ip;

    private String estado;

    private int marca;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getLocal() {
	return local;
    }

    public void setLocal(int local) {
	this.local = local;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getRol() {
	return rol;
    }

    public void setRol(String rol) {
	this.rol = rol;
    }

    public int getTipo() {
	return tipo;
    }

    public void setTipo(int tipo) {
	this.tipo = tipo;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }

    public int getMarca() {
	return marca;
    }

    public void setMarca(int marca) {
	this.marca = marca;
    }

}
