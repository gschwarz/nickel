package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserTaskVO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getPassword(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.UserTaskVO::password;
  }-*/;
  
  private static native void setPassword(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.UserTaskVO::password = value;
  }-*/;
  
  private static native com.rhiscom.bpm.console.shared.model.rs.TaskRS getTaskRS(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.UserTaskVO::taskRS;
  }-*/;
  
  private static native void setTaskRS(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO instance, com.rhiscom.bpm.console.shared.model.rs.TaskRS value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.UserTaskVO::taskRS = value;
  }-*/;
  
  private static native java.lang.String getUsername(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.UserTaskVO::username;
  }-*/;
  
  private static native void setUsername(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.UserTaskVO::username = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.UserTaskVO instance) throws SerializationException {
    setPassword(instance, streamReader.readString());
    setTaskRS(instance, (com.rhiscom.bpm.console.shared.model.rs.TaskRS) streamReader.readObject());
    setUsername(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.UserTaskVO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.UserTaskVO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.UserTaskVO instance) throws SerializationException {
    streamWriter.writeString(getPassword(instance));
    streamWriter.writeObject(getTaskRS(instance));
    streamWriter.writeString(getUsername(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.UserTaskVO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.UserTaskVO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.UserTaskVO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.UserTaskVO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.UserTaskVO)object);
  }
  
}
