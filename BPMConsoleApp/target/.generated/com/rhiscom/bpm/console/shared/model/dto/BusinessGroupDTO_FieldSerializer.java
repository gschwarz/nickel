package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BusinessGroupDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getCreateStamp(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::createStamp;
  }-*/;
  
  private static native void setCreateStamp(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::createStamp = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getIdBusinessGroup(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::idBusinessGroup;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setIdBusinessGroup(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::idBusinessGroup = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getIdLevelBusinessGroup(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::idLevelBusinessGroup;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setIdLevelBusinessGroup(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::idLevelBusinessGroup = value;
  }-*/;
  
  private static native java.util.Date getLastUpdatedStamp(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::lastUpdatedStamp;
  }-*/;
  
  private static native void setLastUpdatedStamp(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::lastUpdatedStamp = value;
  }-*/;
  
  private static native java.lang.String getNameBusinessGroup(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::nameBusinessGroup;
  }-*/;
  
  private static native void setNameBusinessGroup(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::nameBusinessGroup = value;
  }-*/;
  
  private static native com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO getParentBusinessGroup(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::parentBusinessGroup;
  }-*/;
  
  private static native void setParentBusinessGroup(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance, com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::parentBusinessGroup = value;
  }-*/;
  
  private static native int getStatus(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::status;
  }-*/;
  
  private static native void setStatus(com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance, int value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance) throws SerializationException {
    setCreateStamp(instance, (java.util.Date) streamReader.readObject());
    setIdBusinessGroup(instance, streamReader.readLong());
    setIdLevelBusinessGroup(instance, streamReader.readLong());
    setLastUpdatedStamp(instance, (java.util.Date) streamReader.readObject());
    setNameBusinessGroup(instance, streamReader.readString());
    setParentBusinessGroup(instance, (com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO) streamReader.readObject());
    setStatus(instance, streamReader.readInt());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO instance) throws SerializationException {
    streamWriter.writeObject(getCreateStamp(instance));
    streamWriter.writeLong(getIdBusinessGroup(instance));
    streamWriter.writeLong(getIdLevelBusinessGroup(instance));
    streamWriter.writeObject(getLastUpdatedStamp(instance));
    streamWriter.writeString(getNameBusinessGroup(instance));
    streamWriter.writeObject(getParentBusinessGroup(instance));
    streamWriter.writeInt(getStatus(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO)object);
  }
  
}
