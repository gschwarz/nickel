package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProfileDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Set getAccessProfileFunctionalityAbility(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::accessProfileFunctionalityAbility;
  }-*/;
  
  private static native void setAccessProfileFunctionalityAbility(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance, java.util.Set value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::accessProfileFunctionalityAbility = value;
  }-*/;
  
  private static native java.util.Date getCreateStamp(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::createStamp;
  }-*/;
  
  private static native void setCreateStamp(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::createStamp = value;
  }-*/;
  
  private static native java.lang.String getDescription(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::description;
  }-*/;
  
  private static native void setDescription(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::description = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::name = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSegProfileId(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::segProfileId;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSegProfileId(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::segProfileId = value;
  }-*/;
  
  private static native int getStatus(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::status;
  }-*/;
  
  private static native void setStatus(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance, int value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::status = value;
  }-*/;
  
  private static native java.util.Date getUpdateStamp(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::updateStamp;
  }-*/;
  
  private static native void setUpdateStamp(com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProfileDTO::updateStamp = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance) throws SerializationException {
    setAccessProfileFunctionalityAbility(instance, (java.util.Set) streamReader.readObject());
    setCreateStamp(instance, (java.util.Date) streamReader.readObject());
    setDescription(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setSegProfileId(instance, streamReader.readLong());
    setStatus(instance, streamReader.readInt());
    setUpdateStamp(instance, (java.util.Date) streamReader.readObject());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.ProfileDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.ProfileDTO instance) throws SerializationException {
    streamWriter.writeObject(getAccessProfileFunctionalityAbility(instance));
    streamWriter.writeObject(getCreateStamp(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeLong(getSegProfileId(instance));
    streamWriter.writeInt(getStatus(instance));
    streamWriter.writeObject(getUpdateStamp(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.ProfileDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ProfileDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.ProfileDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ProfileDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.ProfileDTO)object);
  }
  
}
