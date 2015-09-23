package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class VersionDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getDescription(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::description;
  }-*/;
  
  private static native void setDescription(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::description = value;
  }-*/;
  
  private static native java.util.Date getEndDate(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::endDate;
  }-*/;
  
  private static native void setEndDate(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::endDate = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getId(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::id;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::id = value;
  }-*/;
  
  private static native java.util.Date getInitDate(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::initDate;
  }-*/;
  
  private static native void setInitDate(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::initDate = value;
  }-*/;
  
  private static native java.lang.String getServer(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::server;
  }-*/;
  
  private static native void setServer(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::server = value;
  }-*/;
  
  private static native java.lang.String getYear(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::year;
  }-*/;
  
  private static native void setYear(com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.VersionDTO::year = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance) throws SerializationException {
    setDescription(instance, streamReader.readString());
    setEndDate(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readLong());
    setInitDate(instance, (java.util.Date) streamReader.readObject());
    setServer(instance, streamReader.readString());
    setYear(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.VersionDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.VersionDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.VersionDTO instance) throws SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getEndDate(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeObject(getInitDate(instance));
    streamWriter.writeString(getServer(instance));
    streamWriter.writeString(getYear(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.VersionDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.VersionDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.VersionDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.VersionDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.VersionDTO)object);
  }
  
}
