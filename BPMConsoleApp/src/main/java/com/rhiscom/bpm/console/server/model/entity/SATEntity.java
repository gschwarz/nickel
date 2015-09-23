package com.rhiscom.bpm.console.server.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "file_sat")
public class SATEntity {

	@Id
	@TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "file_sat.id", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@Column(name = "id", nullable = false)
	private Integer id;

	private Date fechaTrx;

	private String codigoEntidad;
	private String codigoPais;
	private String codigoDeMerchant;
	private String codigoDeFuncion;
	private String origenTrx;
	private Date fecha;
	private String hora;
	private Long local;
	private String estructuraMerchant;
	private String caja;
	private String secuenciaTerminal;
	private String codigoAutorizacionTrxPrevia;
	private String modalidad;
	private String numeroDeLote;
	private String codigoActividad;
	private String identificadorCreditoDebito;
	private String indicador;
	private String indentificadorAdquiriente;
	private String referenciaOperacion;
	private String indicadorCuotas;
	private String numeroTarjeta;
	private String tipoDocumentoIdentificacion;
	private String numeroDocumentoIdentificacion;
	private String tipoMoneda;
	private String factorCambioMoneda;
	private String modoDePago;
	private String plazoPagoDiferido;
	private Long montoTransaccion1;
	private String montoTransaccion2;
	private String montoTransaccion3;
	private String montoTransaccion4;
	private String montoTransaccion5;
	private String numeroCuotas;
	private String importeDeLaCuota;
	private String importePropina;
	private String importeDescuento;
	private String tasaInteres;
	private String importeAbono;
	private String tipoDocumentoVenta;
	private String numeroDocumentoVenta;
	private String vendedor;
	private String codigoConvenio;
	private String modoCapturaPin;
	private String indicadorComprasMultiples;
	private String codigoOCuenta;
	private String numeroPlazaCheque;
	private String numeroDelCheque;
	private String codigoBancoCheque;
	private String rutCheque;
	private String fechaContable;
	private String codigoAutorizacion;
	private String fechaArchivoNegativo;
	private String numeroDelNegativo;
	private String volumen;
	private String modoDeOperar;
	private String fechaProcesoArchivo;
	private String codigoRespuesta;
	private String fechaLiquidacion;
	private String terminalRemesado;
	private String identificacionDeOperacion;
	private String codigoRespuestaInterna;
	private String montoImpuesto;
	private String baseDelImpuesto;

	public String getCodigoEntidad() {
		return codigoEntidad;
	}

	public void setCodigoEntidad(String codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getCodigoDeMerchant() {
		return codigoDeMerchant;
	}

	public void setCodigoDeMerchant(String codigoDeMerchant) {
		this.codigoDeMerchant = codigoDeMerchant;
	}

	public String getCodigoDeFuncion() {
		return codigoDeFuncion;
	}

	public void setCodigoDeFuncion(String codigoDeFuncion) {
		this.codigoDeFuncion = codigoDeFuncion;
	}

	public String getOrigenTrx() {
		return origenTrx;
	}

	public void setOrigenTrx(String origenTrx) {
		this.origenTrx = origenTrx;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Long getLocal() {
		return local;
	}

	public void setLocal(Long local) {
		this.local = local;
	}

	public String getEstructuraMerchant() {
		return estructuraMerchant;
	}

	public void setEstructuraMerchant(String estructuraMerchant) {
		this.estructuraMerchant = estructuraMerchant;
	}

	public String getCaja() {
		return caja;
	}

	public void setCaja(String caja) {
		this.caja = caja;
	}

	public String getSecuenciaTerminal() {
		return secuenciaTerminal;
	}

	public void setSecuenciaTerminal(String secuenciaTerminal) {
		this.secuenciaTerminal = secuenciaTerminal;
	}

	public String getCodigoAutorizacionTrxPrevia() {
		return codigoAutorizacionTrxPrevia;
	}

	public void setCodigoAutorizacionTrxPrevia(String codigoAutorizacionTrxPrevia) {
		this.codigoAutorizacionTrxPrevia = codigoAutorizacionTrxPrevia;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getNumeroDeLote() {
		return numeroDeLote;
	}

	public void setNumeroDeLote(String numeroDeLote) {
		this.numeroDeLote = numeroDeLote;
	}

	public String getCodigoActividad() {
		return codigoActividad;
	}

	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
	}

	public String getIdentificadorCreditoDebito() {
		return identificadorCreditoDebito;
	}

	public void setIdentificadorCreditoDebito(String identificadorCreditoDebito) {
		this.identificadorCreditoDebito = identificadorCreditoDebito;
	}

	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}

	public String getIndentificadorAdquiriente() {
		return indentificadorAdquiriente;
	}

	public void setIndentificadorAdquiriente(String indentificadorAdquiriente) {
		this.indentificadorAdquiriente = indentificadorAdquiriente;
	}

	public String getReferenciaOperacion() {
		return referenciaOperacion;
	}

	public void setReferenciaOperacion(String referenciaOperacion) {
		this.referenciaOperacion = referenciaOperacion;
	}

	public String getIndicadorCuotas() {
		return indicadorCuotas;
	}

	public void setIndicadorCuotas(String indicadorCuotas) {
		this.indicadorCuotas = indicadorCuotas;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getTipoDocumentoIdentificacion() {
		return tipoDocumentoIdentificacion;
	}

	public void setTipoDocumentoIdentificacion(String tipoDocumentoIdentificacion) {
		this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
	}

	public String getNumeroDocumentoIdentificacion() {
		return numeroDocumentoIdentificacion;
	}

	public void setNumeroDocumentoIdentificacion(String numeroDocumentoIdentificacion) {
		this.numeroDocumentoIdentificacion = numeroDocumentoIdentificacion;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getFactorCambioMoneda() {
		return factorCambioMoneda;
	}

	public void setFactorCambioMoneda(String factorCambioMoneda) {
		this.factorCambioMoneda = factorCambioMoneda;
	}

	public String getModoDePago() {
		return modoDePago;
	}

	public void setModoDePago(String modoDePago) {
		this.modoDePago = modoDePago;
	}

	public String getPlazoPagoDiferido() {
		return plazoPagoDiferido;
	}

	public void setPlazoPagoDiferido(String plazoPagoDiferido) {
		this.plazoPagoDiferido = plazoPagoDiferido;
	}

	public Long getMontoTransaccion1() {
		return montoTransaccion1;
	}

	public void setMontoTransaccion1(Long montoTransaccion1) {
		this.montoTransaccion1 = montoTransaccion1;
	}

	public String getMontoTransaccion2() {
		return montoTransaccion2;
	}

	public void setMontoTransaccion2(String montoTransaccion2) {
		this.montoTransaccion2 = montoTransaccion2;
	}

	public String getMontoTransaccion3() {
		return montoTransaccion3;
	}

	public void setMontoTransaccion3(String montoTransaccion3) {
		this.montoTransaccion3 = montoTransaccion3;
	}

	public String getMontoTransaccion4() {
		return montoTransaccion4;
	}

	public void setMontoTransaccion4(String montoTransaccion4) {
		this.montoTransaccion4 = montoTransaccion4;
	}

	public String getMontoTransaccion5() {
		return montoTransaccion5;
	}

	public void setMontoTransaccion5(String montoTransaccion5) {
		this.montoTransaccion5 = montoTransaccion5;
	}

	public String getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(String numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public String getImporteDeLaCuota() {
		return importeDeLaCuota;
	}

	public void setImporteDeLaCuota(String importeDeLaCuota) {
		this.importeDeLaCuota = importeDeLaCuota;
	}

	public String getImportePropina() {
		return importePropina;
	}

	public void setImportePropina(String importePropina) {
		this.importePropina = importePropina;
	}

	public String getImporteDescuento() {
		return importeDescuento;
	}

	public void setImporteDescuento(String importeDescuento) {
		this.importeDescuento = importeDescuento;
	}

	public String getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(String tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

	public String getImporteAbono() {
		return importeAbono;
	}

	public void setImporteAbono(String importeAbono) {
		this.importeAbono = importeAbono;
	}

	public String getTipoDocumentoVenta() {
		return tipoDocumentoVenta;
	}

	public void setTipoDocumentoVenta(String tipoDocumentoVenta) {
		this.tipoDocumentoVenta = tipoDocumentoVenta;
	}

	public String getNumeroDocumentoVenta() {
		return numeroDocumentoVenta;
	}

	public void setNumeroDocumentoVenta(String numeroDocumentoVenta) {
		this.numeroDocumentoVenta = numeroDocumentoVenta;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(String codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}

	public String getModoCapturaPin() {
		return modoCapturaPin;
	}

	public void setModoCapturaPin(String modoCapturaPin) {
		this.modoCapturaPin = modoCapturaPin;
	}

	public String getIndicadorComprasMultiples() {
		return indicadorComprasMultiples;
	}

	public void setIndicadorComprasMultiples(String indicadorComprasMultiples) {
		this.indicadorComprasMultiples = indicadorComprasMultiples;
	}

	public String getCodigoOCuenta() {
		return codigoOCuenta;
	}

	public void setCodigoOCuenta(String codigoOCuenta) {
		this.codigoOCuenta = codigoOCuenta;
	}

	public String getNumeroPlazaCheque() {
		return numeroPlazaCheque;
	}

	public void setNumeroPlazaCheque(String numeroPlazaCheque) {
		this.numeroPlazaCheque = numeroPlazaCheque;
	}

	public String getNumeroDelCheque() {
		return numeroDelCheque;
	}

	public void setNumeroDelCheque(String numeroDelCheque) {
		this.numeroDelCheque = numeroDelCheque;
	}

	public String getCodigoBancoCheque() {
		return codigoBancoCheque;
	}

	public void setCodigoBancoCheque(String codigoBancoCheque) {
		this.codigoBancoCheque = codigoBancoCheque;
	}

	public String getRutCheque() {
		return rutCheque;
	}

	public void setRutCheque(String rutCheque) {
		this.rutCheque = rutCheque;
	}

	public String getFechaContable() {
		return fechaContable;
	}

	public void setFechaContable(String fechaContable) {
		this.fechaContable = fechaContable;
	}

	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public void setCodigoAutorizacion(String codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	public String getFechaArchivoNegativo() {
		return fechaArchivoNegativo;
	}

	public void setFechaArchivoNegativo(String fechaArchivoNegativo) {
		this.fechaArchivoNegativo = fechaArchivoNegativo;
	}

	public String getNumeroDelNegativo() {
		return numeroDelNegativo;
	}

	public void setNumeroDelNegativo(String numeroDelNegativo) {
		this.numeroDelNegativo = numeroDelNegativo;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getModoDeOperar() {
		return modoDeOperar;
	}

	public void setModoDeOperar(String modoDeOperar) {
		this.modoDeOperar = modoDeOperar;
	}

	public String getFechaProcesoArchivo() {
		return fechaProcesoArchivo;
	}

	public void setFechaProcesoArchivo(String fechaProcesoArchivo) {
		this.fechaProcesoArchivo = fechaProcesoArchivo;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getFechaLiquidacion() {
		return fechaLiquidacion;
	}

	public void setFechaLiquidacion(String fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}

	public String getTerminalRemesado() {
		return terminalRemesado;
	}

	public void setTerminalRemesado(String terminalRemesado) {
		this.terminalRemesado = terminalRemesado;
	}

	public String getIdentificacionDeOperacion() {
		return identificacionDeOperacion;
	}

	public void setIdentificacionDeOperacion(String identificacionDeOperacion) {
		this.identificacionDeOperacion = identificacionDeOperacion;
	}

	public String getCodigoRespuestaInterna() {
		return codigoRespuestaInterna;
	}

	public void setCodigoRespuestaInterna(String codigoRespuestaInterna) {
		this.codigoRespuestaInterna = codigoRespuestaInterna;
	}

	public String getMontoImpuesto() {
		return montoImpuesto;
	}

	public void setMontoImpuesto(String montoImpuesto) {
		this.montoImpuesto = montoImpuesto;
	}

	public String getBaseDelImpuesto() {
		return baseDelImpuesto;
	}

	public void setBaseDelImpuesto(String baseDelImpuesto) {
		this.baseDelImpuesto = baseDelImpuesto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaTrx() {
		return fechaTrx;
	}

	public void setFechaTrx(Date fechaTrx) {
		this.fechaTrx = fechaTrx;
	}

}
