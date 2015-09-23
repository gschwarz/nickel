package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TaskCommentDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getAddedAt(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::addedAt;
  }-*/;
  
  private static native void setAddedAt(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::addedAt = value;
  }-*/;
  
  private static native java.lang.String getComment(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::comment;
  }-*/;
  
  private static native void setComment(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::comment = value;
  }-*/;
  
  private static native java.lang.String getId(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::id = value;
  }-*/;
  
  private static native java.lang.String getTaskId(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::taskId;
  }-*/;
  
  private static native void setTaskId(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::taskId = value;
  }-*/;
  
  private static native java.lang.String getText(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::text;
  }-*/;
  
  private static native void setText(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::text = value;
  }-*/;
  
  private static native java.lang.String getUser(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::user;
  }-*/;
  
  private static native void setUser(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO::user = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance) throws SerializationException {
    setAddedAt(instance, (java.util.Date) streamReader.readObject());
    setComment(instance, streamReader.readString());
    setId(instance, streamReader.readString());
    setTaskId(instance, streamReader.readString());
    setText(instance, streamReader.readString());
    setUser(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO instance) throws SerializationException {
    streamWriter.writeObject(getAddedAt(instance));
    streamWriter.writeString(getComment(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeString(getTaskId(instance));
    streamWriter.writeString(getText(instance));
    streamWriter.writeString(getUser(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO)object);
  }
  
}
