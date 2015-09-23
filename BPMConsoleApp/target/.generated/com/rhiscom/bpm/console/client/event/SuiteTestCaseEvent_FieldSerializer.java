package com.rhiscom.bpm.console.client.event;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SuiteTestCaseEvent_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getAtnId(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::atnId;
  }-*/;
  
  private static native void setAtnId(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::atnId = value;
  }-*/;
  
  private static native java.lang.String getId(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::id = value;
  }-*/;
  
  private static native java.lang.String getMyServerGeneratedMessage(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::myServerGeneratedMessage;
  }-*/;
  
  private static native void setMyServerGeneratedMessage(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::myServerGeneratedMessage = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::name = value;
  }-*/;
  
  private static native java.util.Date getStateDate(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::stateDate;
  }-*/;
  
  private static native void setStateDate(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::stateDate = value;
  }-*/;
  
  private static native java.lang.String getType(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::type;
  }-*/;
  
  private static native void setType(com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent::type = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance) throws SerializationException {
    setAtnId(instance, streamReader.readString());
    setId(instance, streamReader.readString());
    setMyServerGeneratedMessage(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setStateDate(instance, (java.util.Date) streamReader.readObject());
    setType(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent instance) throws SerializationException {
    streamWriter.writeString(getAtnId(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeString(getMyServerGeneratedMessage(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getStateDate(instance));
    streamWriter.writeString(getType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent)object);
  }
  
}
