package com.rhiscom.bpm.console.server.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class VentaDomicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "venta_id")
    private long id;
    @Column
    private long total;
    @Column
    private Date fecha;
    @Column
    private long local;
    @Column
    private String estado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "detalle_venta_FK", joinColumns = { @JoinColumn(name = "venta_id") }, inverseJoinColumns = { @JoinColumn(name = "detalle_venta_id") })
    private List<DetalleVenta> detalle = new ArrayList<DetalleVenta>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", nullable = false)
    private Cliente cliente;

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

    public List<DetalleVenta> getDetalle() {
	return detalle;
    }

    public void setDetalle(List<DetalleVenta> detalle) {
	this.detalle = detalle;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }

    public Cliente getCliente() {
	return cliente;
    }

    public void setCliente(Cliente cliente) {
	this.cliente = cliente;
    }

}
