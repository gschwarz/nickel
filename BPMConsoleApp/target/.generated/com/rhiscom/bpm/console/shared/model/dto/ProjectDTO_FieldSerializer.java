package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProjectDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getCreationDate(com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProjectDTO::creationDate;
  }-*/;
  
  private static native void setCreationDate(com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProjectDTO::creationDate = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getExternalProviderID(com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProjectDTO::externalProviderID;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setExternalProviderID(com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProjectDTO::externalProviderID = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProjectDTO::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProjectDTO::name = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getProjectID(com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProjectDTO::projectID;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setProjectID(com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProjectDTO::projectID = value;
  }-*/;
  
  private static native java.lang.String getSummary(com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProjectDTO::summary;
  }-*/;
  
  private static native void setSummary(com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProjectDTO::summary = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance) throws SerializationException {
    setCreationDate(instance, (java.util.Date) streamReader.readObject());
    setExternalProviderID(instance, streamReader.readLong());
    setName(instance, streamReader.readString());
    setProjectID(instance, streamReader.readLong());
    setSummary(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.ProjectDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.ProjectDTO instance) throws SerializationException {
    streamWriter.writeObject(getCreationDate(instance));
    streamWriter.writeLong(getExternalProviderID(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeLong(getProjectID(instance));
    streamWriter.writeString(getSummary(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.ProjectDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ProjectDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.ProjectDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ProjectDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.ProjectDTO)object);
  }
  
}
