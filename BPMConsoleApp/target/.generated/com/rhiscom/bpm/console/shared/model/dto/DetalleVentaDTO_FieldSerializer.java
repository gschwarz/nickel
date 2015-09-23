package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DetalleVentaDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getCantidad(com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO::cantidad;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setCantidad(com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO::cantidad = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getId(com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO::id;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO::id = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getIdProducto(com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO::idProducto;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setIdProducto(com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO::idProducto = value;
  }-*/;
  
  private static native java.lang.String getNombre(com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO::nombre;
  }-*/;
  
  private static native void setNombre(com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO::nombre = value;
  }-*/;
  
  private static native double getPrecio(com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO::precio;
  }-*/;
  
  private static native void setPrecio(com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance, double value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO::precio = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance) throws SerializationException {
    setCantidad(instance, streamReader.readLong());
    setId(instance, streamReader.readLong());
    setIdProducto(instance, streamReader.readLong());
    setNombre(instance, streamReader.readString());
    setPrecio(instance, streamReader.readDouble());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO instance) throws SerializationException {
    streamWriter.writeLong(getCantidad(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeLong(getIdProducto(instance));
    streamWriter.writeString(getNombre(instance));
    streamWriter.writeDouble(getPrecio(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO)object);
  }
  
}
