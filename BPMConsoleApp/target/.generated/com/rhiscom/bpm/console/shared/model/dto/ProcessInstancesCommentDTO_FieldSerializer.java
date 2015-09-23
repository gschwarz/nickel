package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProcessInstancesCommentDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getComment(com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO::comment;
  }-*/;
  
  private static native void setComment(com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO::comment = value;
  }-*/;
  
  private static native java.util.Date getCreateDate(com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO::createDate;
  }-*/;
  
  private static native void setCreateDate(com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO::createDate = value;
  }-*/;
  
  private static native java.lang.String getProcessId(com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO::processId;
  }-*/;
  
  private static native void setProcessId(com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO::processId = value;
  }-*/;
  
  private static native java.lang.String getTaskId(com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO::taskId;
  }-*/;
  
  private static native void setTaskId(com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO::taskId = value;
  }-*/;
  
  private static native java.lang.String getUser(com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO::user;
  }-*/;
  
  private static native void setUser(com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO::user = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance) throws SerializationException {
    setComment(instance, streamReader.readString());
    setCreateDate(instance, (java.util.Date) streamReader.readObject());
    setProcessId(instance, streamReader.readString());
    setTaskId(instance, streamReader.readString());
    setUser(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO instance) throws SerializationException {
    streamWriter.writeString(getComment(instance));
    streamWriter.writeObject(getCreateDate(instance));
    streamWriter.writeString(getProcessId(instance));
    streamWriter.writeString(getTaskId(instance));
    streamWriter.writeString(getUser(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO)object);
  }
  
}
