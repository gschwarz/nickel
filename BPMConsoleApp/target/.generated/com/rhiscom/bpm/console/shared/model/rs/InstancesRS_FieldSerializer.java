package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class InstancesRS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getDefinitionId(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.InstancesRS::definitionId;
  }-*/;
  
  private static native void setDefinitionId(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.InstancesRS::definitionId = value;
  }-*/;
  
  private static native java.lang.String getId(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.InstancesRS::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.InstancesRS::id = value;
  }-*/;
  
  private static native com.rhiscom.bpm.console.shared.model.rs.RootTokenRS getRootToken(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.InstancesRS::rootToken;
  }-*/;
  
  private static native void setRootToken(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance, com.rhiscom.bpm.console.shared.model.rs.RootTokenRS value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.InstancesRS::rootToken = value;
  }-*/;
  
  private static native java.lang.String getStartDate(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.InstancesRS::startDate;
  }-*/;
  
  private static native void setStartDate(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.InstancesRS::startDate = value;
  }-*/;
  
  private static native java.lang.String getSuspended(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.InstancesRS::suspended;
  }-*/;
  
  private static native void setSuspended(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.InstancesRS::suspended = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance) throws SerializationException {
    setDefinitionId(instance, streamReader.readString());
    setId(instance, streamReader.readString());
    setRootToken(instance, (com.rhiscom.bpm.console.shared.model.rs.RootTokenRS) streamReader.readObject());
    setStartDate(instance, streamReader.readString());
    setSuspended(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.InstancesRS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.InstancesRS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance) throws SerializationException {
    streamWriter.writeString(getDefinitionId(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeObject(getRootToken(instance));
    streamWriter.writeString(getStartDate(instance));
    streamWriter.writeString(getSuspended(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.InstancesRS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.InstancesRS_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.InstancesRS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.InstancesRS_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.InstancesRS)object);
  }
  
}
