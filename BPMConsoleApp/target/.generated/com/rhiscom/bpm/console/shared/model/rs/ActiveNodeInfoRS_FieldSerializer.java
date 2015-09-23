package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ActiveNodeInfoRS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS getActiveNode(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS::activeNode;
  }-*/;
  
  private static native void setActiveNode(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS instance, com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS::activeNode = value;
  }-*/;
  
  private static native java.lang.String getHeight(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS::height;
  }-*/;
  
  private static native void setHeight(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS::height = value;
  }-*/;
  
  private static native java.lang.String getWidth(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS::width;
  }-*/;
  
  private static native void setWidth(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS::width = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS instance) throws SerializationException {
    setActiveNode(instance, (com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS) streamReader.readObject());
    setHeight(instance, streamReader.readString());
    setWidth(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS instance) throws SerializationException {
    streamWriter.writeObject(getActiveNode(instance));
    streamWriter.writeString(getHeight(instance));
    streamWriter.writeString(getWidth(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS)object);
  }
  
}
