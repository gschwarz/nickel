package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CuadraturaNotaCreditoDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPLACUAPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::diferenciaPLACUAPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPLACUAPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::diferenciaPLACUAPSCRE = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPSCREPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::diferenciaPSCREPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPSCREPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::diferenciaPSCREPLC = value;
  }-*/;
  
  private static native java.util.Date getFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::fechaTrx;
  }-*/;
  
  private static native void setFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::fechaTrx = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::id;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::id = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getNcrTvPLCUa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::ncrTvPLCUa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setNcrTvPLCUa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::ncrTvPLCUa = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::sucursal;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::sucursal = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionesNCRPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::totalAnulacionesNCRPLC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionesNCRPLC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::totalAnulacionesNCRPLC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionesNCRPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::totalAnulacionesNCRPSCRE;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionesNCRPSCRE(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::totalAnulacionesNCRPSCRE = value;
  }-*/;
  
  private static native java.lang.String getVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::versionPOS;
  }-*/;
  
  private static native void setVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO::versionPOS = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) throws SerializationException {
    setDiferenciaPLACUAPSCRE(instance, streamReader.readLong());
    setDiferenciaPSCREPLC(instance, streamReader.readLong());
    setFechaTrx(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readLong());
    setNcrTvPLCUa(instance, streamReader.readLong());
    setSucursal(instance, streamReader.readLong());
    setTotalAnulacionesNCRPLC(instance, streamReader.readLong());
    setTotalAnulacionesNCRPSCRE(instance, streamReader.readLong());
    setVersionPOS(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO instance) throws SerializationException {
    streamWriter.writeLong(getDiferenciaPLACUAPSCRE(instance));
    streamWriter.writeLong(getDiferenciaPSCREPLC(instance));
    streamWriter.writeObject(getFechaTrx(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeLong(getNcrTvPLCUa(instance));
    streamWriter.writeLong(getSucursal(instance));
    streamWriter.writeLong(getTotalAnulacionesNCRPLC(instance));
    streamWriter.writeLong(getTotalAnulacionesNCRPSCRE(instance));
    streamWriter.writeString(getVersionPOS(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO)object);
  }
  
}
