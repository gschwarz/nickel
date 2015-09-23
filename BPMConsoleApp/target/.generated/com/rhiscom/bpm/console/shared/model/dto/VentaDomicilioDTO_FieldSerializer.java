package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class VentaDomicilioDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.rhiscom.bpm.console.shared.model.dto.ClienteDTO getCliente(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::cliente;
  }-*/;
  
  private static native void setCliente(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance, com.rhiscom.bpm.console.shared.model.dto.ClienteDTO value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::cliente = value;
  }-*/;
  
  private static native java.util.List getDetalle(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::detalle;
  }-*/;
  
  private static native void setDetalle(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance, java.util.List value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::detalle = value;
  }-*/;
  
  private static native java.lang.String getEstado(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::estado;
  }-*/;
  
  private static native void setEstado(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::estado = value;
  }-*/;
  
  private static native java.util.Date getFecha(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::fecha;
  }-*/;
  
  private static native void setFecha(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::fecha = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getId(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::id;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::id = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getLocal(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::local;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setLocal(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::local = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotal(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::total;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotal(com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO::total = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance) throws SerializationException {
    setCliente(instance, (com.rhiscom.bpm.console.shared.model.dto.ClienteDTO) streamReader.readObject());
    setDetalle(instance, (java.util.List) streamReader.readObject());
    setEstado(instance, streamReader.readString());
    setFecha(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readLong());
    setLocal(instance, streamReader.readLong());
    setTotal(instance, streamReader.readLong());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO instance) throws SerializationException {
    streamWriter.writeObject(getCliente(instance));
    streamWriter.writeObject(getDetalle(instance));
    streamWriter.writeString(getEstado(instance));
    streamWriter.writeObject(getFecha(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeLong(getLocal(instance));
    streamWriter.writeLong(getTotal(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO)object);
  }
  
}
