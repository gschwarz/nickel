package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class OperatorDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO getBussinessUnitDTO(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::bussinessUnitDTO;
  }-*/;
  
  private static native void setBussinessUnitDTO(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance, com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::bussinessUnitDTO = value;
  }-*/;
  
  private static native java.util.Date getCreateDate(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::createDate;
  }-*/;
  
  private static native void setCreateDate(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::createDate = value;
  }-*/;
  
  private static native boolean getLoggedIn(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::loggedIn;
  }-*/;
  
  private static native void setLoggedIn(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance, boolean value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::loggedIn = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getOperatorId(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::operatorId;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setOperatorId(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::operatorId = value;
  }-*/;
  
  private static native java.lang.String getPassword(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::password;
  }-*/;
  
  private static native void setPassword(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::password = value;
  }-*/;
  
  private static native com.rhiscom.bpm.console.shared.model.dto.ProfileDTO getProfileDTO(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::profileDTO;
  }-*/;
  
  private static native void setProfileDTO(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance, com.rhiscom.bpm.console.shared.model.dto.ProfileDTO value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::profileDTO = value;
  }-*/;
  
  private static native java.lang.String getSessionId(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::sessionId;
  }-*/;
  
  private static native void setSessionId(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::sessionId = value;
  }-*/;
  
  private static native java.lang.String getUser(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::user;
  }-*/;
  
  private static native void setUser(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::user = value;
  }-*/;
  
  private static native java.util.Set getWorkGroups(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::workGroups;
  }-*/;
  
  private static native void setWorkGroups(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance, java.util.Set value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::workGroups = value;
  }-*/;
  
  private static native com.rhiscom.bpm.console.shared.model.dto.WorkerDTO getWorker(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::worker;
  }-*/;
  
  private static native void setWorker(com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance, com.rhiscom.bpm.console.shared.model.dto.WorkerDTO value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.OperatorDTO::worker = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) throws SerializationException {
    setBussinessUnitDTO(instance, (com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO) streamReader.readObject());
    setCreateDate(instance, (java.util.Date) streamReader.readObject());
    setLoggedIn(instance, streamReader.readBoolean());
    setOperatorId(instance, streamReader.readLong());
    setPassword(instance, streamReader.readString());
    setProfileDTO(instance, (com.rhiscom.bpm.console.shared.model.dto.ProfileDTO) streamReader.readObject());
    setSessionId(instance, streamReader.readString());
    setUser(instance, streamReader.readString());
    setWorkGroups(instance, (java.util.Set) streamReader.readObject());
    setWorker(instance, (com.rhiscom.bpm.console.shared.model.dto.WorkerDTO) streamReader.readObject());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.OperatorDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.OperatorDTO instance) throws SerializationException {
    streamWriter.writeObject(getBussinessUnitDTO(instance));
    streamWriter.writeObject(getCreateDate(instance));
    streamWriter.writeBoolean(getLoggedIn(instance));
    streamWriter.writeLong(getOperatorId(instance));
    streamWriter.writeString(getPassword(instance));
    streamWriter.writeObject(getProfileDTO(instance));
    streamWriter.writeString(getSessionId(instance));
    streamWriter.writeString(getUser(instance));
    streamWriter.writeObject(getWorkGroups(instance));
    streamWriter.writeObject(getWorker(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.OperatorDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.OperatorDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.OperatorDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.OperatorDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.OperatorDTO)object);
  }
  
}
