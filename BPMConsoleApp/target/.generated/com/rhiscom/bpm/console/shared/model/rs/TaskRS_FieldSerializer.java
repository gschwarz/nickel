package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TaskRS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getAssignee(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::assignee;
  }-*/;
  
  private static native void setAssignee(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::assignee = value;
  }-*/;
  
  private static native java.util.Date getCreatedOn(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::createdOn;
  }-*/;
  
  private static native void setCreatedOn(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::createdOn = value;
  }-*/;
  
  private static native java.lang.String getCurrentState(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::currentState;
  }-*/;
  
  private static native void setCurrentState(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::currentState = value;
  }-*/;
  
  private static native java.lang.String getId(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::id = value;
  }-*/;
  
  private static native java.lang.String getIsBlocking(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::isBlocking;
  }-*/;
  
  private static native void setIsBlocking(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::isBlocking = value;
  }-*/;
  
  private static native java.lang.String getIsSignalling(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::isSignalling;
  }-*/;
  
  private static native void setIsSignalling(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::isSignalling = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::name = value;
  }-*/;
  
  private static native java.lang.String getPriority(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::priority;
  }-*/;
  
  private static native void setPriority(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::priority = value;
  }-*/;
  
  private static native java.lang.String getProcessId(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::processId;
  }-*/;
  
  private static native void setProcessId(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::processId = value;
  }-*/;
  
  private static native java.lang.String getProcessInstanceId(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::processInstanceId;
  }-*/;
  
  private static native void setProcessInstanceId(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::processInstanceId = value;
  }-*/;
  
  private static native java.lang.String getUrl(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::url;
  }-*/;
  
  private static native void setUrl(com.rhiscom.bpm.console.shared.model.rs.TaskRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskRS::url = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) throws SerializationException {
    setAssignee(instance, streamReader.readString());
    setCreatedOn(instance, (java.util.Date) streamReader.readObject());
    setCurrentState(instance, streamReader.readString());
    setId(instance, streamReader.readString());
    setIsBlocking(instance, streamReader.readString());
    setIsSignalling(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setPriority(instance, streamReader.readString());
    setProcessId(instance, streamReader.readString());
    setProcessInstanceId(instance, streamReader.readString());
    setUrl(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.TaskRS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.TaskRS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.TaskRS instance) throws SerializationException {
    streamWriter.writeString(getAssignee(instance));
    streamWriter.writeObject(getCreatedOn(instance));
    streamWriter.writeString(getCurrentState(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeString(getIsBlocking(instance));
    streamWriter.writeString(getIsSignalling(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getPriority(instance));
    streamWriter.writeString(getProcessId(instance));
    streamWriter.writeString(getProcessInstanceId(instance));
    streamWriter.writeString(getUrl(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.TaskRS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.TaskRS_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.TaskRS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.TaskRS_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.TaskRS)object);
  }
  
}
