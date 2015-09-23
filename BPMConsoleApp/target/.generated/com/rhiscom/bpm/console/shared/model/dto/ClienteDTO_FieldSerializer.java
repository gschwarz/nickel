package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ClienteDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getApellido(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::apellido;
  }-*/;
  
  private static native void setApellido(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::apellido = value;
  }-*/;
  
  private static native java.lang.String getBarrio(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::barrio;
  }-*/;
  
  private static native void setBarrio(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::barrio = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getCiudad(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::ciudad;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setCiudad(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::ciudad = value;
  }-*/;
  
  private static native java.lang.String getDireccion(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::direccion;
  }-*/;
  
  private static native void setDireccion(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::direccion = value;
  }-*/;
  
  private static native java.lang.String getEmail(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::email;
  }-*/;
  
  private static native void setEmail(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::email = value;
  }-*/;
  
  private static native java.util.Date getFechaNacimiento(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::fechaNacimiento;
  }-*/;
  
  private static native void setFechaNacimiento(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::fechaNacimiento = value;
  }-*/;
  
  private static native java.lang.Long getId(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::id = value;
  }-*/;
  
  private static native java.lang.String getNombre(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::nombre;
  }-*/;
  
  private static native void setNombre(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::nombre = value;
  }-*/;
  
  private static native java.lang.String getNumeroCliente(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::numeroCliente;
  }-*/;
  
  private static native void setNumeroCliente(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::numeroCliente = value;
  }-*/;
  
  private static native java.lang.String getSegundoApellido(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::segundoApellido;
  }-*/;
  
  private static native void setSegundoApellido(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::segundoApellido = value;
  }-*/;
  
  private static native java.lang.String getSegundoNombre(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::segundoNombre;
  }-*/;
  
  private static native void setSegundoNombre(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::segundoNombre = value;
  }-*/;
  
  private static native java.lang.String getTelefonoContacto1(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::telefonoContacto1;
  }-*/;
  
  private static native void setTelefonoContacto1(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::telefonoContacto1 = value;
  }-*/;
  
  private static native java.lang.String getTelefonoContacto2(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::telefonoContacto2;
  }-*/;
  
  private static native void setTelefonoContacto2(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::telefonoContacto2 = value;
  }-*/;
  
  private static native java.lang.String getTipoDocumento(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::tipoDocumento;
  }-*/;
  
  private static native void setTipoDocumento(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::tipoDocumento = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getZona(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::zona;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setZona(com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ClienteDTO::zona = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) throws SerializationException {
    setApellido(instance, streamReader.readString());
    setBarrio(instance, streamReader.readString());
    setCiudad(instance, streamReader.readLong());
    setDireccion(instance, streamReader.readString());
    setEmail(instance, streamReader.readString());
    setFechaNacimiento(instance, (java.util.Date) streamReader.readObject());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setNombre(instance, streamReader.readString());
    setNumeroCliente(instance, streamReader.readString());
    setSegundoApellido(instance, streamReader.readString());
    setSegundoNombre(instance, streamReader.readString());
    setTelefonoContacto1(instance, streamReader.readString());
    setTelefonoContacto2(instance, streamReader.readString());
    setTipoDocumento(instance, streamReader.readString());
    setZona(instance, streamReader.readLong());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.ClienteDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.ClienteDTO instance) throws SerializationException {
    streamWriter.writeString(getApellido(instance));
    streamWriter.writeString(getBarrio(instance));
    streamWriter.writeLong(getCiudad(instance));
    streamWriter.writeString(getDireccion(instance));
    streamWriter.writeString(getEmail(instance));
    streamWriter.writeObject(getFechaNacimiento(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getNombre(instance));
    streamWriter.writeString(getNumeroCliente(instance));
    streamWriter.writeString(getSegundoApellido(instance));
    streamWriter.writeString(getSegundoNombre(instance));
    streamWriter.writeString(getTelefonoContacto1(instance));
    streamWriter.writeString(getTelefonoContacto2(instance));
    streamWriter.writeString(getTipoDocumento(instance));
    streamWriter.writeLong(getZona(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.ClienteDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ClienteDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.ClienteDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ClienteDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.ClienteDTO)object);
  }
  
}
