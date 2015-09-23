/**
 * 
 */
package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;

/**
 * @author pablo
 * 
 */
public class DetalleVentaDTO implements Serializable {
    private long id;
    private long cantidad;
    private double precio;
    private long idProducto;
    private String nombre;

    public DetalleVentaDTO(long cantidad2, long id2, long idProducto2, String nombre2, double precio2) {
	cantidad = cantidad2;
	id = id2;
	idProducto = idProducto2;
	nombre = nombre2;
    }

    public DetalleVentaDTO() {

    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public long getCantidad() {
	return cantidad;
    }

    public void setCantidad(long cantidad) {
	this.cantidad = cantidad;
    }

    public double getPrecio() {
	return precio;
    }

    public void setPrecio(double precio) {
	this.precio = precio;
    }

    public long getIdProducto() {
	return idProducto;
    }

    public void setIdProducto(long idProducto) {
	this.idProducto = idProducto;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

}
