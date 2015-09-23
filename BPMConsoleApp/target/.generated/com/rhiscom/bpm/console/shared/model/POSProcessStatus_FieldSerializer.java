package com.rhiscom.bpm.console.shared.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class POSProcessStatus_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getCodigoTienda(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::codigoTienda;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setCodigoTienda(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::codigoTienda = value;
  }-*/;
  
  private static native int getEstado(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::estado;
  }-*/;
  
  private static native void setEstado(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, int value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::estado = value;
  }-*/;
  
  private static native java.util.HashMap getEstadosADS(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::estadosADS;
  }-*/;
  
  private static native void setEstadosADS(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, java.util.HashMap value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::estadosADS = value;
  }-*/;
  
  private static native java.lang.String getFechaApertura(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::fechaApertura;
  }-*/;
  
  private static native void setFechaApertura(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::fechaApertura = value;
  }-*/;
  
  private static native java.lang.String getFechaConsulta(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::fechaConsulta;
  }-*/;
  
  private static native void setFechaConsulta(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::fechaConsulta = value;
  }-*/;
  
  private static native java.lang.String getFechaCreacion(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::fechaCreacion;
  }-*/;
  
  private static native void setFechaCreacion(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::fechaCreacion = value;
  }-*/;
  
  private static native java.lang.String getFechaServidor(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::fechaServidor;
  }-*/;
  
  private static native void setFechaServidor(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::fechaServidor = value;
  }-*/;
  
  private static native java.lang.String getFechaUltimaApertura(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::fechaUltimaApertura;
  }-*/;
  
  private static native void setFechaUltimaApertura(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::fechaUltimaApertura = value;
  }-*/;
  
  private static native java.lang.String getNombreTienda(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::nombreTienda;
  }-*/;
  
  private static native void setNombreTienda(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::nombreTienda = value;
  }-*/;
  
  private static native int getNumeroTienda(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::numeroTienda;
  }-*/;
  
  private static native void setNumeroTienda(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, int value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::numeroTienda = value;
  }-*/;
  
  private static native java.lang.String getTipoDocumento(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::tipoDocumento;
  }-*/;
  
  private static native void setTipoDocumento(com.rhiscom.bpm.console.shared.model.POSProcessStatus instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.POSProcessStatus::tipoDocumento = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) throws SerializationException {
    setCodigoTienda(instance, streamReader.readLong());
    setEstado(instance, streamReader.readInt());
    setEstadosADS(instance, (java.util.HashMap) streamReader.readObject());
    setFechaApertura(instance, streamReader.readString());
    setFechaConsulta(instance, streamReader.readString());
    setFechaCreacion(instance, streamReader.readString());
    setFechaServidor(instance, streamReader.readString());
    setFechaUltimaApertura(instance, streamReader.readString());
    setNombreTienda(instance, streamReader.readString());
    setNumeroTienda(instance, streamReader.readInt());
    setTipoDocumento(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.POSProcessStatus instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.POSProcessStatus();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.POSProcessStatus instance) throws SerializationException {
    streamWriter.writeLong(getCodigoTienda(instance));
    streamWriter.writeInt(getEstado(instance));
    streamWriter.writeObject(getEstadosADS(instance));
    streamWriter.writeString(getFechaApertura(instance));
    streamWriter.writeString(getFechaConsulta(instance));
    streamWriter.writeString(getFechaCreacion(instance));
    streamWriter.writeString(getFechaServidor(instance));
    streamWriter.writeString(getFechaUltimaApertura(instance));
    streamWriter.writeString(getNombreTienda(instance));
    streamWriter.writeInt(getNumeroTienda(instance));
    streamWriter.writeString(getTipoDocumento(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.POSProcessStatus_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.POSProcessStatus_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.POSProcessStatus)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.POSProcessStatus_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.POSProcessStatus)object);
  }
  
}
