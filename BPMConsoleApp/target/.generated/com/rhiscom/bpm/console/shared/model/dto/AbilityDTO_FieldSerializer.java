package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AbilityDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getDescription(com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.AbilityDTO::description;
  }-*/;
  
  private static native void setDescription(com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.AbilityDTO::description = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getModuleIdTemp(com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.AbilityDTO::moduleIdTemp;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setModuleIdTemp(com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.AbilityDTO::moduleIdTemp = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.AbilityDTO::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.AbilityDTO::name = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSegAbilityId(com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.AbilityDTO::segAbilityId;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSegAbilityId(com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.AbilityDTO::segAbilityId = value;
  }-*/;
  
  private static native int getStatus(com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.AbilityDTO::status;
  }-*/;
  
  private static native void setStatus(com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance, int value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.AbilityDTO::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance) throws SerializationException {
    setDescription(instance, streamReader.readString());
    setModuleIdTemp(instance, streamReader.readLong());
    setName(instance, streamReader.readString());
    setSegAbilityId(instance, streamReader.readLong());
    setStatus(instance, streamReader.readInt());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.AbilityDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.AbilityDTO instance) throws SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeLong(getModuleIdTemp(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeLong(getSegAbilityId(instance));
    streamWriter.writeInt(getStatus(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.AbilityDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.AbilityDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.AbilityDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.AbilityDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.AbilityDTO)object);
  }
  
}
