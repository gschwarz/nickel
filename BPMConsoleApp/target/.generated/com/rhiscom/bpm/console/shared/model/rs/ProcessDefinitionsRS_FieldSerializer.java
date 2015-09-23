package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProcessDefinitionsRS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Collection getDefinitions(com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS::definitions;
  }-*/;
  
  private static native void setDefinitions(com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS instance, java.util.Collection value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS::definitions = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS instance) throws SerializationException {
    setDefinitions(instance, (java.util.Collection) streamReader.readObject());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS instance) throws SerializationException {
    streamWriter.writeObject(getDefinitions(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS)object);
  }
  
}
