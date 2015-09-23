package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RootTokenRS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getCurrentNodeName(com.rhiscom.bpm.console.shared.model.rs.RootTokenRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.RootTokenRS::currentNodeName;
  }-*/;
  
  private static native void setCurrentNodeName(com.rhiscom.bpm.console.shared.model.rs.RootTokenRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.RootTokenRS::currentNodeName = value;
  }-*/;
  
  private static native java.lang.String getId(com.rhiscom.bpm.console.shared.model.rs.RootTokenRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.RootTokenRS::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.rs.RootTokenRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.RootTokenRS::id = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.shared.model.rs.RootTokenRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.RootTokenRS::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.shared.model.rs.RootTokenRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.RootTokenRS::name = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.RootTokenRS instance) throws SerializationException {
    setCurrentNodeName(instance, streamReader.readString());
    setId(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.RootTokenRS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.RootTokenRS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.RootTokenRS instance) throws SerializationException {
    streamWriter.writeString(getCurrentNodeName(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.RootTokenRS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.RootTokenRS_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.RootTokenRS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.RootTokenRS_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.RootTokenRS)object);
  }
  
}
