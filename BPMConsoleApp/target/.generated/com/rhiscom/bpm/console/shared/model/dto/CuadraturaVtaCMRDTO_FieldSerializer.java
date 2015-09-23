package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CuadraturaVtaCMRDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getArqTFDonacion(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::ArqTFDonacion;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setArqTFDonacion(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::ArqTFDonacion = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getArqTFNCR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::arqTFNCR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setArqTFNCR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::arqTFNCR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getCuotasDiferidas(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::cuotasDiferidas;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setCuotasDiferidas(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::cuotasDiferidas = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getCuotasNormales(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::cuotasNormales;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setCuotasNormales(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::cuotasNormales = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaLdtaConArqTFDonacion(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaLdtaConArqTFDonacion;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaLdtaConArqTFDonacion(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaLdtaConArqTFDonacion = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPlaCuadARQTF(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaPlaCuadARQTF;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPlaCuadARQTF(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaPlaCuadARQTF = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPlaCuadConVtaCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaPlaCuadConVtaCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPlaCuadConVtaCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaPlaCuadConVtaCMR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPlaCuadNCRConArqTFNCR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaPlaCuadNCRConArqTFNCR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPlaCuadNCRConArqTFNCR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaPlaCuadNCRConArqTFNCR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPldtfNCRConArqTFNCR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaPldtfNCRConArqTFNCR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPldtfNCRConArqTFNCR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaPldtfNCRConArqTFNCR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaRSATCRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaRSATCRCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaRSATCRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaRSATCRCMR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaSATCRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaSATCRCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaSATCRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaSATCRCMR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaVtaCRMConARQTF(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaVtaCRMConARQTF;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaVtaCRMConARQTF(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::diferenciaVtaCRMConARQTF = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDonacionCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::donacionCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDonacionCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::donacionCMR = value;
  }-*/;
  
  private static native java.util.Date getFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::fechaTrx;
  }-*/;
  
  private static native void setFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::fechaTrx = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getGranTotalAnulacionGiftcard(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::granTotalAnulacionGiftcard;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setGranTotalAnulacionGiftcard(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::granTotalAnulacionGiftcard = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getGranTotalDevolucionesCMRNCA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::granTotalDevolucionesCMRNCA;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setGranTotalDevolucionesCMRNCA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::granTotalDevolucionesCMRNCA = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getGranTotalDevolucionesCMRNCR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::granTotalDevolucionesCMRNCR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setGranTotalDevolucionesCMRNCR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::granTotalDevolucionesCMRNCR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getGranTotalRecaudaciones(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::granTotalRecaudaciones;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setGranTotalRecaudaciones(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::granTotalRecaudaciones = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getGranTotalVentas(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::granTotalVentas;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setGranTotalVentas(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::granTotalVentas = value;
  }-*/;
  
  private static native int getId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, int value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::id = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getLdta(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::ldta;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setLdta(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::ldta = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getLdtaDonacion(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::ldtaDonacion;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setLdtaDonacion(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::ldtaDonacion = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getNcrTFTotal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::ncrTFTotal;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setNcrTFTotal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::ncrTFTotal = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getPlacuadNCR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::placuadNCR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setPlacuadNCR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::placuadNCR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getPldtf(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::pldtf;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setPldtf(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::pldtf = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::sucursal;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::sucursal = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalFinalARQTF(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalFinalARQTF;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalFinalARQTF(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalFinalARQTF = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalFinalPlaCuad(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalFinalPlaCuad;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalFinalPlaCuad(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalFinalPlaCuad = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalFinalRSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalFinalRSAT;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalFinalRSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalFinalRSAT = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalFinalSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalFinalSAT;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalFinalSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalFinalSAT = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalFinalTRX(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalFinalTRX;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalFinalTRX(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalFinalTRX = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalTrx200RSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalTrx200RSAT;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalTrx200RSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalTrx200RSAT = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalTrx200SAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalTrx200SAT;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalTrx200SAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalTrx200SAT = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalTrx400RSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalTrx400RSAT;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalTrx400RSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalTrx400RSAT = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalTrx400SAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalTrx400SAT;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalTrx400SAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::totalTrx400SAT = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTransacciones200(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::transacciones200;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTransacciones200(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::transacciones200 = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTransacciones400(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::transacciones400;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTransacciones400(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::transacciones400 = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTresCC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::tresCC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTresCC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::tresCC = value;
  }-*/;
  
  private static native java.lang.String getVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::versionPOS;
  }-*/;
  
  private static native void setVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO::versionPOS = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) throws SerializationException {
    setArqTFDonacion(instance, streamReader.readLong());
    setArqTFNCR(instance, streamReader.readLong());
    setCuotasDiferidas(instance, streamReader.readLong());
    setCuotasNormales(instance, streamReader.readLong());
    setDiferenciaLdtaConArqTFDonacion(instance, streamReader.readLong());
    setDiferenciaPlaCuadARQTF(instance, streamReader.readLong());
    setDiferenciaPlaCuadConVtaCMR(instance, streamReader.readLong());
    setDiferenciaPlaCuadNCRConArqTFNCR(instance, streamReader.readLong());
    setDiferenciaPldtfNCRConArqTFNCR(instance, streamReader.readLong());
    setDiferenciaRSATCRCMR(instance, streamReader.readLong());
    setDiferenciaSATCRCMR(instance, streamReader.readLong());
    setDiferenciaVtaCRMConARQTF(instance, streamReader.readLong());
    setDonacionCMR(instance, streamReader.readLong());
    setFechaTrx(instance, (java.util.Date) streamReader.readObject());
    setGranTotalAnulacionGiftcard(instance, streamReader.readLong());
    setGranTotalDevolucionesCMRNCA(instance, streamReader.readLong());
    setGranTotalDevolucionesCMRNCR(instance, streamReader.readLong());
    setGranTotalRecaudaciones(instance, streamReader.readLong());
    setGranTotalVentas(instance, streamReader.readLong());
    setId(instance, streamReader.readInt());
    setLdta(instance, streamReader.readLong());
    setLdtaDonacion(instance, streamReader.readLong());
    setNcrTFTotal(instance, streamReader.readLong());
    setPlacuadNCR(instance, streamReader.readLong());
    setPldtf(instance, streamReader.readLong());
    setSucursal(instance, streamReader.readLong());
    setTotalFinalARQTF(instance, streamReader.readLong());
    setTotalFinalPlaCuad(instance, streamReader.readLong());
    setTotalFinalRSAT(instance, streamReader.readLong());
    setTotalFinalSAT(instance, streamReader.readLong());
    setTotalFinalTRX(instance, streamReader.readLong());
    setTotalTrx200RSAT(instance, streamReader.readLong());
    setTotalTrx200SAT(instance, streamReader.readLong());
    setTotalTrx400RSAT(instance, streamReader.readLong());
    setTotalTrx400SAT(instance, streamReader.readLong());
    setTransacciones200(instance, streamReader.readLong());
    setTransacciones400(instance, streamReader.readLong());
    setTresCC(instance, streamReader.readLong());
    setVersionPOS(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO instance) throws SerializationException {
    streamWriter.writeLong(getArqTFDonacion(instance));
    streamWriter.writeLong(getArqTFNCR(instance));
    streamWriter.writeLong(getCuotasDiferidas(instance));
    streamWriter.writeLong(getCuotasNormales(instance));
    streamWriter.writeLong(getDiferenciaLdtaConArqTFDonacion(instance));
    streamWriter.writeLong(getDiferenciaPlaCuadARQTF(instance));
    streamWriter.writeLong(getDiferenciaPlaCuadConVtaCMR(instance));
    streamWriter.writeLong(getDiferenciaPlaCuadNCRConArqTFNCR(instance));
    streamWriter.writeLong(getDiferenciaPldtfNCRConArqTFNCR(instance));
    streamWriter.writeLong(getDiferenciaRSATCRCMR(instance));
    streamWriter.writeLong(getDiferenciaSATCRCMR(instance));
    streamWriter.writeLong(getDiferenciaVtaCRMConARQTF(instance));
    streamWriter.writeLong(getDonacionCMR(instance));
    streamWriter.writeObject(getFechaTrx(instance));
    streamWriter.writeLong(getGranTotalAnulacionGiftcard(instance));
    streamWriter.writeLong(getGranTotalDevolucionesCMRNCA(instance));
    streamWriter.writeLong(getGranTotalDevolucionesCMRNCR(instance));
    streamWriter.writeLong(getGranTotalRecaudaciones(instance));
    streamWriter.writeLong(getGranTotalVentas(instance));
    streamWriter.writeInt(getId(instance));
    streamWriter.writeLong(getLdta(instance));
    streamWriter.writeLong(getLdtaDonacion(instance));
    streamWriter.writeLong(getNcrTFTotal(instance));
    streamWriter.writeLong(getPlacuadNCR(instance));
    streamWriter.writeLong(getPldtf(instance));
    streamWriter.writeLong(getSucursal(instance));
    streamWriter.writeLong(getTotalFinalARQTF(instance));
    streamWriter.writeLong(getTotalFinalPlaCuad(instance));
    streamWriter.writeLong(getTotalFinalRSAT(instance));
    streamWriter.writeLong(getTotalFinalSAT(instance));
    streamWriter.writeLong(getTotalFinalTRX(instance));
    streamWriter.writeLong(getTotalTrx200RSAT(instance));
    streamWriter.writeLong(getTotalTrx200SAT(instance));
    streamWriter.writeLong(getTotalTrx400RSAT(instance));
    streamWriter.writeLong(getTotalTrx400SAT(instance));
    streamWriter.writeLong(getTransacciones200(instance));
    streamWriter.writeLong(getTransacciones400(instance));
    streamWriter.writeLong(getTresCC(instance));
    streamWriter.writeString(getVersionPOS(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO)object);
  }
  
}
