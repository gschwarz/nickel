package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BusinessUnitDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getBusinessGroupName(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::businessGroupName;
  }-*/;
  
  private static native void setBusinessGroupName(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::businessGroupName = value;
  }-*/;
  
  private static native java.lang.String getCode(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::code;
  }-*/;
  
  private static native void setCode(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::code = value;
  }-*/;
  
  private static native java.util.Date getCreateStamp(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::createStamp;
  }-*/;
  
  private static native void setCreateStamp(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::createStamp = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getIdBusinessGroup(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::idBusinessGroup;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setIdBusinessGroup(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::idBusinessGroup = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getIdBusinessUnit(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::idBusinessUnit;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setIdBusinessUnit(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::idBusinessUnit = value;
  }-*/;
  
  private static native java.util.Date getLastUpdatedStamp(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::lastUpdatedStamp;
  }-*/;
  
  private static native void setLastUpdatedStamp(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::lastUpdatedStamp = value;
  }-*/;
  
  private static native java.lang.String getNameBusinessUnit(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::nameBusinessUnit;
  }-*/;
  
  private static native void setNameBusinessUnit(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::nameBusinessUnit = value;
  }-*/;
  
  private static native int getStatus(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::status;
  }-*/;
  
  private static native void setStatus(com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance, int value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance) throws SerializationException {
    setBusinessGroupName(instance, streamReader.readString());
    setCode(instance, streamReader.readString());
    setCreateStamp(instance, (java.util.Date) streamReader.readObject());
    setIdBusinessGroup(instance, streamReader.readLong());
    setIdBusinessUnit(instance, streamReader.readLong());
    setLastUpdatedStamp(instance, (java.util.Date) streamReader.readObject());
    setNameBusinessUnit(instance, streamReader.readString());
    setStatus(instance, streamReader.readInt());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO instance) throws SerializationException {
    streamWriter.writeString(getBusinessGroupName(instance));
    streamWriter.writeString(getCode(instance));
    streamWriter.writeObject(getCreateStamp(instance));
    streamWriter.writeLong(getIdBusinessGroup(instance));
    streamWriter.writeLong(getIdBusinessUnit(instance));
    streamWriter.writeObject(getLastUpdatedStamp(instance));
    streamWriter.writeString(getNameBusinessUnit(instance));
    streamWriter.writeInt(getStatus(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO)object);
  }
  
}
