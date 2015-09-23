package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ResolverGroupDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getDescription(com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO::description;
  }-*/;
  
  private static native void setDescription(com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO::description = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO::name = value;
  }-*/;
  
  private static native java.lang.Long getWorkGroupid(com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO::workGroupid;
  }-*/;
  
  private static native void setWorkGroupid(com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO::workGroupid = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO instance) throws SerializationException {
    setDescription(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setWorkGroupid(instance, (java.lang.Long) streamReader.readObject());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO instance) throws SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getWorkGroupid(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO)object);
  }
  
}
