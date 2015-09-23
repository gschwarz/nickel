package com.rhiscom.bpm.console.shared.model.rs;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ActiveNodeRS_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getHeight(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS::height;
  }-*/;
  
  private static native void setHeight(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS::height = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS::name = value;
  }-*/;
  
  private static native java.lang.String getWidth(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS::width;
  }-*/;
  
  private static native void setWidth(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS::width = value;
  }-*/;
  
  private static native java.lang.String getX(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS::x;
  }-*/;
  
  private static native void setX(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS::x = value;
  }-*/;
  
  private static native java.lang.String getY(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS::y;
  }-*/;
  
  private static native void setY(com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS::y = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance) throws SerializationException {
    setHeight(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setWidth(instance, streamReader.readString());
    setX(instance, streamReader.readString());
    setY(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS instance) throws SerializationException {
    streamWriter.writeString(getHeight(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getWidth(instance));
    streamWriter.writeString(getX(instance));
    streamWriter.writeString(getY(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.rs.ActiveNodeRS)object);
  }
  
}
