package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class FunctionalityModuleDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getCode(com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO::code;
  }-*/;
  
  private static native void setCode(com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO::code = value;
  }-*/;
  
  private static native java.lang.String getDescription(com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO::description;
  }-*/;
  
  private static native void setDescription(com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO::description = value;
  }-*/;
  
  private static native java.lang.String getModule(com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO::module;
  }-*/;
  
  private static native void setModule(com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO::module = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSegFuncModuleId(com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO::segFuncModuleId;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSegFuncModuleId(com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO::segFuncModuleId = value;
  }-*/;
  
  private static native int getStatus(com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO::status;
  }-*/;
  
  private static native void setStatus(com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance, int value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance) throws SerializationException {
    setCode(instance, streamReader.readString());
    setDescription(instance, streamReader.readString());
    setModule(instance, streamReader.readString());
    setSegFuncModuleId(instance, streamReader.readLong());
    setStatus(instance, streamReader.readInt());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO instance) throws SerializationException {
    streamWriter.writeString(getCode(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getModule(instance));
    streamWriter.writeLong(getSegFuncModuleId(instance));
    streamWriter.writeInt(getStatus(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO)object);
  }
  
}
