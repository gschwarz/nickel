package com.rhiscom.bpm.console.shared.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class EventoConsultaTienda_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getFechaConsulta(com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.EventoConsultaTienda::fechaConsulta;
  }-*/;
  
  private static native void setFechaConsulta(com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.EventoConsultaTienda::fechaConsulta = value;
  }-*/;
  
  private static native java.lang.String getTienda(com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.EventoConsultaTienda::tienda;
  }-*/;
  
  private static native void setTienda(com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.EventoConsultaTienda::tienda = value;
  }-*/;
  
  private static native java.lang.String getTiendaEnConjunto(com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.EventoConsultaTienda::tiendaEnConjunto;
  }-*/;
  
  private static native void setTiendaEnConjunto(com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.EventoConsultaTienda::tiendaEnConjunto = value;
  }-*/;
  
  private static native java.lang.String getUsuario(com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.EventoConsultaTienda::usuario;
  }-*/;
  
  private static native void setUsuario(com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.EventoConsultaTienda::usuario = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instance) throws SerializationException {
    setFechaConsulta(instance, streamReader.readString());
    setTienda(instance, streamReader.readString());
    setTiendaEnConjunto(instance, streamReader.readString());
    setUsuario(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.EventoConsultaTienda();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.EventoConsultaTienda instance) throws SerializationException {
    streamWriter.writeString(getFechaConsulta(instance));
    streamWriter.writeString(getTienda(instance));
    streamWriter.writeString(getTiendaEnConjunto(instance));
    streamWriter.writeString(getUsuario(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.EventoConsultaTienda_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.EventoConsultaTienda_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.EventoConsultaTienda)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.EventoConsultaTienda_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.EventoConsultaTienda)object);
  }
  
}
