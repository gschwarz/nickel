package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProcessDefinitionInstancesRS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Collection getInstances(com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS::instances;
  }-*/;
  
  private static native void setInstances(com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS instance, java.util.Collection value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS::instances = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS instance) throws SerializationException {
    setInstances(instance, (java.util.Collection) streamReader.readObject());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS instance) throws SerializationException {
    streamWriter.writeObject(getInstances(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS)object);
  }
  
}
