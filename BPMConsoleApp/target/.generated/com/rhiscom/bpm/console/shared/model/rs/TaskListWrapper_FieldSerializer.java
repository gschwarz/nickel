package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TaskListWrapper_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.List getTaskList(com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper::taskList;
  }-*/;
  
  private static native void setTaskList(com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper instance, java.util.List value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper::taskList = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper instance) throws SerializationException {
    setTaskList(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper instance) throws SerializationException {
    streamWriter.writeObject(getTaskList(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper)object);
  }
  
}
