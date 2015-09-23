package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class NodeInstanceLogDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Long getId(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::id = value;
  }-*/;
  
  private static native java.util.Date getLogDate(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::logDate;
  }-*/;
  
  private static native void setLogDate(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::logDate = value;
  }-*/;
  
  private static native java.lang.String getNodeId(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::nodeId;
  }-*/;
  
  private static native void setNodeId(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::nodeId = value;
  }-*/;
  
  private static native java.lang.String getNodeInstanceId(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::nodeInstanceId;
  }-*/;
  
  private static native void setNodeInstanceId(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::nodeInstanceId = value;
  }-*/;
  
  private static native java.lang.String getNodeName(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::nodeName;
  }-*/;
  
  private static native void setNodeName(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::nodeName = value;
  }-*/;
  
  private static native java.lang.String getProcessId(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::processId;
  }-*/;
  
  private static native void setProcessId(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::processId = value;
  }-*/;
  
  private static native java.lang.Long getProcessInstanceId(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::processInstanceId;
  }-*/;
  
  private static native void setProcessInstanceId(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::processInstanceId = value;
  }-*/;
  
  private static native java.lang.Integer getType(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::type;
  }-*/;
  
  private static native void setType(com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance, java.lang.Integer value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO::type = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance) throws SerializationException {
    setId(instance, (java.lang.Long) streamReader.readObject());
    setLogDate(instance, (java.util.Date) streamReader.readObject());
    setNodeId(instance, streamReader.readString());
    setNodeInstanceId(instance, streamReader.readString());
    setNodeName(instance, streamReader.readString());
    setProcessId(instance, streamReader.readString());
    setProcessInstanceId(instance, (java.lang.Long) streamReader.readObject());
    setType(instance, (java.lang.Integer) streamReader.readObject());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO instance) throws SerializationException {
    streamWriter.writeObject(getId(instance));
    streamWriter.writeObject(getLogDate(instance));
    streamWriter.writeString(getNodeId(instance));
    streamWriter.writeString(getNodeInstanceId(instance));
    streamWriter.writeString(getNodeName(instance));
    streamWriter.writeString(getProcessId(instance));
    streamWriter.writeObject(getProcessInstanceId(instance));
    streamWriter.writeObject(getType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO)object);
  }
  
}
