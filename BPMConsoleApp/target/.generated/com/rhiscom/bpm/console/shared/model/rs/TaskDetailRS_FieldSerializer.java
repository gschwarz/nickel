package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TaskDetailRS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getActivationTime(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::activationTime;
  }-*/;
  
  private static native void setActivationTime(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::activationTime = value;
  }-*/;
  
  private static native java.lang.String getAllowedToDelegate(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::allowedToDelegate;
  }-*/;
  
  private static native void setAllowedToDelegate(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::allowedToDelegate = value;
  }-*/;
  
  private static native java.util.Date getCreatedOn(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::createdOn;
  }-*/;
  
  private static native void setCreatedOn(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::createdOn = value;
  }-*/;
  
  private static native java.lang.String getDescription(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::description;
  }-*/;
  
  private static native void setDescription(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::description = value;
  }-*/;
  
  private static native java.lang.Integer getDocumentAccessType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::documentAccessType;
  }-*/;
  
  private static native void setDocumentAccessType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.Integer value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::documentAccessType = value;
  }-*/;
  
  private static native java.math.BigInteger getDocumentContentId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::documentContentId;
  }-*/;
  
  private static native void setDocumentContentId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.math.BigInteger value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::documentContentId = value;
  }-*/;
  
  private static native java.lang.String getDocumentType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::documentType;
  }-*/;
  
  private static native void setDocumentType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::documentType = value;
  }-*/;
  
  private static native java.util.Date getExpirationTime(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::expirationTime;
  }-*/;
  
  private static native void setExpirationTime(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::expirationTime = value;
  }-*/;
  
  private static native java.lang.Integer getFaultAccessType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::faultAccessType;
  }-*/;
  
  private static native void setFaultAccessType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.Integer value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::faultAccessType = value;
  }-*/;
  
  private static native java.math.BigInteger getFaultContentId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::faultContentId;
  }-*/;
  
  private static native void setFaultContentId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.math.BigInteger value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::faultContentId = value;
  }-*/;
  
  private static native java.lang.String getFaultName(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::faultName;
  }-*/;
  
  private static native void setFaultName(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::faultName = value;
  }-*/;
  
  private static native java.lang.String getFaultType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::faultType;
  }-*/;
  
  private static native void setFaultType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::faultType = value;
  }-*/;
  
  private static native java.lang.String getId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::id = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::name = value;
  }-*/;
  
  private static native java.lang.Integer getOutputAccessType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::outputAccessType;
  }-*/;
  
  private static native void setOutputAccessType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.Integer value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::outputAccessType = value;
  }-*/;
  
  private static native java.math.BigInteger getOutputContentId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::outputContentId;
  }-*/;
  
  private static native void setOutputContentId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.math.BigInteger value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::outputContentId = value;
  }-*/;
  
  private static native java.lang.String getOutputType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::outputType;
  }-*/;
  
  private static native void setOutputType(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::outputType = value;
  }-*/;
  
  private static native java.lang.String getOwner(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::owner;
  }-*/;
  
  private static native void setOwner(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::owner = value;
  }-*/;
  
  private static native java.math.BigInteger getParentId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::parentId;
  }-*/;
  
  private static native void setParentId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.math.BigInteger value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::parentId = value;
  }-*/;
  
  private static native java.lang.Integer getPreviousStatus(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::previousStatus;
  }-*/;
  
  private static native void setPreviousStatus(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.Integer value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::previousStatus = value;
  }-*/;
  
  private static native java.lang.Integer getPriority(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::priority;
  }-*/;
  
  private static native void setPriority(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.Integer value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::priority = value;
  }-*/;
  
  private static native java.lang.String getProcessId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::processId;
  }-*/;
  
  private static native void setProcessId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::processId = value;
  }-*/;
  
  private static native java.math.BigInteger getProcessInstanceId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::processInstanceId;
  }-*/;
  
  private static native void setProcessInstanceId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.math.BigInteger value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::processInstanceId = value;
  }-*/;
  
  private static native java.lang.Integer getProcessSessionId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::processSessionId;
  }-*/;
  
  private static native void setProcessSessionId(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.Integer value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::processSessionId = value;
  }-*/;
  
  private static native byte getSkipable(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::skipable;
  }-*/;
  
  private static native void setSkipable(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, byte value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::skipable = value;
  }-*/;
  
  private static native java.lang.String getStatus(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::status;
  }-*/;
  
  private static native void setStatus(com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) throws SerializationException {
    setActivationTime(instance, (java.util.Date) streamReader.readObject());
    setAllowedToDelegate(instance, streamReader.readString());
    setCreatedOn(instance, (java.util.Date) streamReader.readObject());
    setDescription(instance, streamReader.readString());
    setDocumentAccessType(instance, (java.lang.Integer) streamReader.readObject());
    setDocumentContentId(instance, (java.math.BigInteger) streamReader.readObject());
    setDocumentType(instance, streamReader.readString());
    setExpirationTime(instance, (java.util.Date) streamReader.readObject());
    setFaultAccessType(instance, (java.lang.Integer) streamReader.readObject());
    setFaultContentId(instance, (java.math.BigInteger) streamReader.readObject());
    setFaultName(instance, streamReader.readString());
    setFaultType(instance, streamReader.readString());
    setId(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setOutputAccessType(instance, (java.lang.Integer) streamReader.readObject());
    setOutputContentId(instance, (java.math.BigInteger) streamReader.readObject());
    setOutputType(instance, streamReader.readString());
    setOwner(instance, streamReader.readString());
    setParentId(instance, (java.math.BigInteger) streamReader.readObject());
    setPreviousStatus(instance, (java.lang.Integer) streamReader.readObject());
    setPriority(instance, (java.lang.Integer) streamReader.readObject());
    setProcessId(instance, streamReader.readString());
    setProcessInstanceId(instance, (java.math.BigInteger) streamReader.readObject());
    setProcessSessionId(instance, (java.lang.Integer) streamReader.readObject());
    setSkipable(instance, streamReader.readByte());
    setStatus(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS instance) throws SerializationException {
    streamWriter.writeObject(getActivationTime(instance));
    streamWriter.writeString(getAllowedToDelegate(instance));
    streamWriter.writeObject(getCreatedOn(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getDocumentAccessType(instance));
    streamWriter.writeObject(getDocumentContentId(instance));
    streamWriter.writeString(getDocumentType(instance));
    streamWriter.writeObject(getExpirationTime(instance));
    streamWriter.writeObject(getFaultAccessType(instance));
    streamWriter.writeObject(getFaultContentId(instance));
    streamWriter.writeString(getFaultName(instance));
    streamWriter.writeString(getFaultType(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getOutputAccessType(instance));
    streamWriter.writeObject(getOutputContentId(instance));
    streamWriter.writeString(getOutputType(instance));
    streamWriter.writeString(getOwner(instance));
    streamWriter.writeObject(getParentId(instance));
    streamWriter.writeObject(getPreviousStatus(instance));
    streamWriter.writeObject(getPriority(instance));
    streamWriter.writeString(getProcessId(instance));
    streamWriter.writeObject(getProcessInstanceId(instance));
    streamWriter.writeObject(getProcessSessionId(instance));
    streamWriter.writeByte(getSkipable(instance));
    streamWriter.writeString(getStatus(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS)object);
  }
  
}
