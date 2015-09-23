package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CuadraturaTarjetaCreditoDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getAnulacionRecaudacionesPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::anulacionRecaudacionesPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setAnulacionRecaudacionesPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::anulacionRecaudacionesPSCRE = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPLCUAPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::diferenciaPLCUAPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPLCUAPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::diferenciaPLCUAPSCRE = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPSCREPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::diferenciaPSCREPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPSCREPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::diferenciaPSCREPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPagoRemotoPLCUAPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::diferenciaPagoRemotoPLCUAPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPagoRemotoPLCUAPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::diferenciaPagoRemotoPLCUAPSCRE = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPagoRemotoPSCREPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::diferenciaPagoRemotoPSCREPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPagoRemotoPSCREPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::diferenciaPagoRemotoPSCREPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDonaciones(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::donaciones;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDonaciones(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::donaciones = value;
  }-*/;
  
  private static native java.util.Date getFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::fechaTrx;
  }-*/;
  
  private static native void setFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::fechaTrx = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::id;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::id = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getPagoRemotoCreditoPLCUA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::pagoRemotoCreditoPLCUA;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setPagoRemotoCreditoPLCUA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::pagoRemotoCreditoPLCUA = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getPagoRemotoCreditoPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::pagoRemotoCreditoPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setPagoRemotoCreditoPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::pagoRemotoCreditoPSCRE = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getRecaudacionesPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::recaudacionesPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setRecaudacionesPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::recaudacionesPSCRE = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::sucursal;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::sucursal = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTarjetaBancariaDiners(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::tarjetaBancariaDiners;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTarjetaBancariaDiners(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::tarjetaBancariaDiners = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTarjetaBancariaVisa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::tarjetaBancariaVisa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTarjetaBancariaVisa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::tarjetaBancariaVisa = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionRecaudacionesPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalAnulacionRecaudacionesPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionRecaudacionesPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalAnulacionRecaudacionesPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionesNCAPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalAnulacionesNCAPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionesNCAPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalAnulacionesNCAPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionesPagoRemoto(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalAnulacionesPagoRemoto;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionesPagoRemoto(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalAnulacionesPagoRemoto = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionesPagoRemotoCreditoPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalAnulacionesPagoRemotoCreditoPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionesPagoRemotoCreditoPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalAnulacionesPagoRemotoCreditoPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPLCUA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalPLCUA;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPLCUA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalPLCUA = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalPSCRE = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPagoRemotoPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalPagoRemotoPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPagoRemotoPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalPagoRemotoPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPagoRemotoPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalPagoRemotoPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPagoRemotoPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalPagoRemotoPSCRE = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalRecaudacionesPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalRecaudacionesPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalRecaudacionesPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalRecaudacionesPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasAnulacionesPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasAnulacionesPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasAnulacionesPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasAnulacionesPSCRE = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasInternetCreditoPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasInternetCreditoPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasInternetCreditoPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasInternetCreditoPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasInternetCreditoPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasInternetCreditoPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasInternetCreditoPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasInternetCreditoPSCRE = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasPagoRemotoCreditoPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasPagoRemotoCreditoPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasPagoRemotoCreditoPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasPagoRemotoCreditoPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasTarjetaCreditoPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasTarjetaCreditoPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasTarjetaCreditoPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasTarjetaCreditoPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasTarjetaCreditoPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasTarjetaCreditoPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasTarjetaCreditoPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::totalVentasTarjetaCreditoPSCRE = value;
  }-*/;
  
  private static native java.lang.String getVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::versionPOS;
  }-*/;
  
  private static native void setVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO::versionPOS = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) throws SerializationException {
    setAnulacionRecaudacionesPSCRE(instance, streamReader.readLong());
    setDiferenciaPLCUAPSCRE(instance, streamReader.readLong());
    setDiferenciaPSCREPLC(instance, streamReader.readLong());
    setDiferenciaPagoRemotoPLCUAPSCRE(instance, streamReader.readLong());
    setDiferenciaPagoRemotoPSCREPLC(instance, streamReader.readLong());
    setDonaciones(instance, streamReader.readLong());
    setFechaTrx(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readLong());
    setPagoRemotoCreditoPLCUA(instance, streamReader.readLong());
    setPagoRemotoCreditoPSCRE(instance, streamReader.readLong());
    setRecaudacionesPSCRE(instance, streamReader.readLong());
    setSucursal(instance, streamReader.readLong());
    setTarjetaBancariaDiners(instance, streamReader.readLong());
    setTarjetaBancariaVisa(instance, streamReader.readLong());
    setTotalAnulacionRecaudacionesPLC(instance, streamReader.readLong());
    setTotalAnulacionesNCAPLC(instance, streamReader.readLong());
    setTotalAnulacionesPagoRemoto(instance, streamReader.readLong());
    setTotalAnulacionesPagoRemotoCreditoPLC(instance, streamReader.readLong());
    setTotalPLC(instance, streamReader.readLong());
    setTotalPLCUA(instance, streamReader.readLong());
    setTotalPSCRE(instance, streamReader.readLong());
    setTotalPagoRemotoPLC(instance, streamReader.readLong());
    setTotalPagoRemotoPSCRE(instance, streamReader.readLong());
    setTotalRecaudacionesPLC(instance, streamReader.readLong());
    setTotalVentasAnulacionesPSCRE(instance, streamReader.readLong());
    setTotalVentasInternetCreditoPLC(instance, streamReader.readLong());
    setTotalVentasInternetCreditoPSCRE(instance, streamReader.readLong());
    setTotalVentasPagoRemotoCreditoPLC(instance, streamReader.readLong());
    setTotalVentasTarjetaCreditoPLC(instance, streamReader.readLong());
    setTotalVentasTarjetaCreditoPSCRE(instance, streamReader.readLong());
    setVersionPOS(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO instance) throws SerializationException {
    streamWriter.writeLong(getAnulacionRecaudacionesPSCRE(instance));
    streamWriter.writeLong(getDiferenciaPLCUAPSCRE(instance));
    streamWriter.writeLong(getDiferenciaPSCREPLC(instance));
    streamWriter.writeLong(getDiferenciaPagoRemotoPLCUAPSCRE(instance));
    streamWriter.writeLong(getDiferenciaPagoRemotoPSCREPLC(instance));
    streamWriter.writeLong(getDonaciones(instance));
    streamWriter.writeObject(getFechaTrx(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeLong(getPagoRemotoCreditoPLCUA(instance));
    streamWriter.writeLong(getPagoRemotoCreditoPSCRE(instance));
    streamWriter.writeLong(getRecaudacionesPSCRE(instance));
    streamWriter.writeLong(getSucursal(instance));
    streamWriter.writeLong(getTarjetaBancariaDiners(instance));
    streamWriter.writeLong(getTarjetaBancariaVisa(instance));
    streamWriter.writeLong(getTotalAnulacionRecaudacionesPLC(instance));
    streamWriter.writeLong(getTotalAnulacionesNCAPLC(instance));
    streamWriter.writeLong(getTotalAnulacionesPagoRemoto(instance));
    streamWriter.writeLong(getTotalAnulacionesPagoRemotoCreditoPLC(instance));
    streamWriter.writeLong(getTotalPLC(instance));
    streamWriter.writeLong(getTotalPLCUA(instance));
    streamWriter.writeLong(getTotalPSCRE(instance));
    streamWriter.writeLong(getTotalPagoRemotoPLC(instance));
    streamWriter.writeLong(getTotalPagoRemotoPSCRE(instance));
    streamWriter.writeLong(getTotalRecaudacionesPLC(instance));
    streamWriter.writeLong(getTotalVentasAnulacionesPSCRE(instance));
    streamWriter.writeLong(getTotalVentasInternetCreditoPLC(instance));
    streamWriter.writeLong(getTotalVentasInternetCreditoPSCRE(instance));
    streamWriter.writeLong(getTotalVentasPagoRemotoCreditoPLC(instance));
    streamWriter.writeLong(getTotalVentasTarjetaCreditoPLC(instance));
    streamWriter.writeLong(getTotalVentasTarjetaCreditoPSCRE(instance));
    streamWriter.writeString(getVersionPOS(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO)object);
  }
  
}
