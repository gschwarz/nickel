package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TaskUserRS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Collection getTasks(com.rhiscom.bpm.console.shared.model.rs.TaskUserRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.TaskUserRS::tasks;
  }-*/;
  
  private static native void setTasks(com.rhiscom.bpm.console.shared.model.rs.TaskUserRS instance, java.util.Collection value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.TaskUserRS::tasks = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.TaskUserRS instance) throws SerializationException {
    setTasks(instance, (java.util.Collection) streamReader.readObject());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.TaskUserRS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.TaskUserRS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.TaskUserRS instance) throws SerializationException {
    streamWriter.writeObject(getTasks(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.TaskUserRS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.TaskUserRS_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.TaskUserRS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.TaskUserRS_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.TaskUserRS)object);
  }
  
}
