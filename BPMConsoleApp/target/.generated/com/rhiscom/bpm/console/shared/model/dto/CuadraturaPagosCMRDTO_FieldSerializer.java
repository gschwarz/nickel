package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CuadraturaPagosCMRDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPLACUASCTFA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::diferenciaPLACUASCTFA;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPLACUASCTFA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::diferenciaPLACUASCTFA = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPLCUACRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::diferenciaPLCUACRCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPLCUACRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::diferenciaPLCUACRCMR = value;
  }-*/;
  
  private static native java.lang.Long getDiferenciaRSATCRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::diferenciaRSATCRCMR;
  }-*/;
  
  private static native void setDiferenciaRSATCRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::diferenciaRSATCRCMR = value;
  }-*/;
  
  private static native java.lang.Long getDiferenciaSATCRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::diferenciaSATCRCMR;
  }-*/;
  
  private static native void setDiferenciaSATCRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::diferenciaSATCRCMR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaSCTFACRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::diferenciaSCTFACRCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaSCTFACRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::diferenciaSCTFACRCMR = value;
  }-*/;
  
  private static native java.util.Date getFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::fechaTrx;
  }-*/;
  
  private static native void setFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::fechaTrx = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::id;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::id = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getPagoAnulado(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::pagoAnulado;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setPagoAnulado(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::pagoAnulado = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getPagoNormal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::pagoNormal;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setPagoNormal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::pagoNormal = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getPagoRepactado(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::pagoRepactado;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setPagoRepactado(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::pagoRepactado = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::sucursal;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::sucursal = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAbonos(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAbonos;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAbonos(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAbonos = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAbonosCMRRepactacion(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAbonosCMRRepactacion;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAbonosCMRRepactacion(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAbonosCMRRepactacion = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionAbonoNormal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAnulacionAbonoNormal;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionAbonoNormal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAnulacionAbonoNormal = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionAbonoRepactacion(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAnulacionAbonoRepactacion;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionAbonoRepactacion(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAnulacionAbonoRepactacion = value;
  }-*/;
  
  private static native java.lang.Long getTotalAnulacionesRSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAnulacionesRSAT;
  }-*/;
  
  private static native void setTotalAnulacionesRSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAnulacionesRSAT = value;
  }-*/;
  
  private static native java.lang.Long getTotalAnulacionesSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAnulacionesSAT;
  }-*/;
  
  private static native void setTotalAnulacionesSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalAnulacionesSAT = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalCRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalCRCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalCRCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalCRCMR = value;
  }-*/;
  
  private static native java.lang.Long getTotalFinalPagosRSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalFinalPagosRSAT;
  }-*/;
  
  private static native void setTotalFinalPagosRSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalFinalPagosRSAT = value;
  }-*/;
  
  private static native java.lang.Long getTotalFinalPagosSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalFinalPagosSAT;
  }-*/;
  
  private static native void setTotalFinalPagosSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalFinalPagosSAT = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPagos(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalPagos;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPagos(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalPagos = value;
  }-*/;
  
  private static native java.lang.Long getTotalPagosRSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalPagosRSAT;
  }-*/;
  
  private static native void setTotalPagosRSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalPagosRSAT = value;
  }-*/;
  
  private static native java.lang.Long getTotalPagosSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalPagosSAT;
  }-*/;
  
  private static native void setTotalPagosSAT(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalPagosSAT = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPagosSctfa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalPagosSctfa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPagosSctfa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::totalPagosSctfa = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTrx217(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::trx217;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTrx217(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::trx217 = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTrx402(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::trx402;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTrx402(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::trx402 = value;
  }-*/;
  
  private static native java.lang.String getVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::versionPOS;
  }-*/;
  
  private static native void setVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO::versionPOS = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) throws SerializationException {
    setDiferenciaPLACUASCTFA(instance, streamReader.readLong());
    setDiferenciaPLCUACRCMR(instance, streamReader.readLong());
    setDiferenciaRSATCRCMR(instance, (java.lang.Long) streamReader.readObject());
    setDiferenciaSATCRCMR(instance, (java.lang.Long) streamReader.readObject());
    setDiferenciaSCTFACRCMR(instance, streamReader.readLong());
    setFechaTrx(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readLong());
    setPagoAnulado(instance, streamReader.readLong());
    setPagoNormal(instance, streamReader.readLong());
    setPagoRepactado(instance, streamReader.readLong());
    setSucursal(instance, streamReader.readLong());
    setTotalAbonos(instance, streamReader.readLong());
    setTotalAbonosCMRRepactacion(instance, streamReader.readLong());
    setTotalAnulacionAbonoNormal(instance, streamReader.readLong());
    setTotalAnulacionAbonoRepactacion(instance, streamReader.readLong());
    setTotalAnulacionesRSAT(instance, (java.lang.Long) streamReader.readObject());
    setTotalAnulacionesSAT(instance, (java.lang.Long) streamReader.readObject());
    setTotalCRCMR(instance, streamReader.readLong());
    setTotalFinalPagosRSAT(instance, (java.lang.Long) streamReader.readObject());
    setTotalFinalPagosSAT(instance, (java.lang.Long) streamReader.readObject());
    setTotalPagos(instance, streamReader.readLong());
    setTotalPagosRSAT(instance, (java.lang.Long) streamReader.readObject());
    setTotalPagosSAT(instance, (java.lang.Long) streamReader.readObject());
    setTotalPagosSctfa(instance, streamReader.readLong());
    setTrx217(instance, streamReader.readLong());
    setTrx402(instance, streamReader.readLong());
    setVersionPOS(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO instance) throws SerializationException {
    streamWriter.writeLong(getDiferenciaPLACUASCTFA(instance));
    streamWriter.writeLong(getDiferenciaPLCUACRCMR(instance));
    streamWriter.writeObject(getDiferenciaRSATCRCMR(instance));
    streamWriter.writeObject(getDiferenciaSATCRCMR(instance));
    streamWriter.writeLong(getDiferenciaSCTFACRCMR(instance));
    streamWriter.writeObject(getFechaTrx(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeLong(getPagoAnulado(instance));
    streamWriter.writeLong(getPagoNormal(instance));
    streamWriter.writeLong(getPagoRepactado(instance));
    streamWriter.writeLong(getSucursal(instance));
    streamWriter.writeLong(getTotalAbonos(instance));
    streamWriter.writeLong(getTotalAbonosCMRRepactacion(instance));
    streamWriter.writeLong(getTotalAnulacionAbonoNormal(instance));
    streamWriter.writeLong(getTotalAnulacionAbonoRepactacion(instance));
    streamWriter.writeObject(getTotalAnulacionesRSAT(instance));
    streamWriter.writeObject(getTotalAnulacionesSAT(instance));
    streamWriter.writeLong(getTotalCRCMR(instance));
    streamWriter.writeObject(getTotalFinalPagosRSAT(instance));
    streamWriter.writeObject(getTotalFinalPagosSAT(instance));
    streamWriter.writeLong(getTotalPagos(instance));
    streamWriter.writeObject(getTotalPagosRSAT(instance));
    streamWriter.writeObject(getTotalPagosSAT(instance));
    streamWriter.writeLong(getTotalPagosSctfa(instance));
    streamWriter.writeLong(getTrx217(instance));
    streamWriter.writeLong(getTrx402(instance));
    streamWriter.writeString(getVersionPOS(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO)object);
  }
  
}
