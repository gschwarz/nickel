package com.rhiscom.bpm.console.server.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_id")
    private Long id;
    private String numeroCliente;
    private String direccion;
    private String email;
    private String telefonoContacto1;
    private String telefonoContacto2;
    private String nombre;
    private String segundoNombre;
    private String apellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private String barrio;
    private long ciudad;
    private long zona;
    private String tipoDocumento;

    public String getBarrio() {
	return barrio;
    }

    public void setBarrio(String barrio) {
	this.barrio = barrio;
    }

    public long getCiudad() {
	return ciudad;
    }

    public void setCiudad(long ciudad) {
	this.ciudad = ciudad;
    }

    public long getZona() {
	return zona;
    }

    public void setZona(long zona) {
	this.zona = zona;
    }

    public String getTipoDocumento() {
	return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
	this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroCliente() {
	return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
	this.numeroCliente = numeroCliente;
    }

    public String getDireccion() {
	return direccion;
    }

    public void setDireccion(String direccion) {
	this.direccion = direccion;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getTelefonoContacto1() {
	return telefonoContacto1;
    }

    public void setTelefonoContacto1(String telefonoContacto1) {
	this.telefonoContacto1 = telefonoContacto1;
    }

    public String getTelefonoContacto2() {
	return telefonoContacto2;
    }

    public void setTelefonoContacto2(String telefonoContacto2) {
	this.telefonoContacto2 = telefonoContacto2;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getSegundoNombre() {
	return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
	this.segundoNombre = segundoNombre;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public String getSegundoApellido() {
	return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
	this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
	return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

}
