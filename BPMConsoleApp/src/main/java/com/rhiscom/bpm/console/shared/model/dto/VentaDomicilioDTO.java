package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VentaDomicilioDTO implements Serializable {

    private long id;
    private long total;
    private Date fecha;
    private long local;
    private String estado;
    private List<DetalleVentaDTO> detalle = new ArrayList<DetalleVentaDTO>();
    private ClienteDTO cliente;

    public VentaDomicilioDTO(long id2, String estado2, Date fecha2, ClienteDTO cliente2, long local2, long total2) {
	id = id2;
	estado = estado2;
	fecha = fecha2;
	setCliente(cliente2);
	local = local2;
	total = total2;
    }

    public VentaDomicilioDTO() {

    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public long getTotal() {
	return total;
    }

    public void setTotal(long total) {
	this.total = total;
    }

    public Date getFecha() {
	return fecha;
    }

    public void setFecha(Date fecha) {
	this.fecha = fecha;
    }

    public long getLocal() {
	return local;
    }

    public void setLocal(long local) {
	this.local = local;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }

    public List<DetalleVentaDTO> getDetalle() {
	return detalle;
    }

    public void setDetalle(List<DetalleVentaDTO> detalle) {
	this.detalle = detalle;
    }

    public ClienteDTO getCliente() {
	return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
	this.cliente = cliente;
    }

}
