package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DefinitionsRS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getDeploymentId(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::deploymentId;
  }-*/;
  
  private static native void setDeploymentId(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::deploymentId = value;
  }-*/;
  
  private static native java.lang.String getDiagramUrl(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::diagramUrl;
  }-*/;
  
  private static native void setDiagramUrl(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::diagramUrl = value;
  }-*/;
  
  private static native java.lang.String getFormUrl(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::formUrl;
  }-*/;
  
  private static native void setFormUrl(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::formUrl = value;
  }-*/;
  
  private static native java.lang.String getId(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::id = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::name = value;
  }-*/;
  
  private static native java.lang.String getPackageName(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::packageName;
  }-*/;
  
  private static native void setPackageName(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::packageName = value;
  }-*/;
  
  private static native java.lang.String getSuspended(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::suspended;
  }-*/;
  
  private static native void setSuspended(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::suspended = value;
  }-*/;
  
  private static native java.lang.String getVersion(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::version;
  }-*/;
  
  private static native void setVersion(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS::version = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance) throws SerializationException {
    setDeploymentId(instance, streamReader.readString());
    setDiagramUrl(instance, streamReader.readString());
    setFormUrl(instance, streamReader.readString());
    setId(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setPackageName(instance, streamReader.readString());
    setSuspended(instance, streamReader.readString());
    setVersion(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS instance) throws SerializationException {
    streamWriter.writeString(getDeploymentId(instance));
    streamWriter.writeString(getDiagramUrl(instance));
    streamWriter.writeString(getFormUrl(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getPackageName(instance));
    streamWriter.writeString(getSuspended(instance));
    streamWriter.writeString(getVersion(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS)object);
  }
  
}
