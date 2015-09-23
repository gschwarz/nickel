package com.rhiscom.bpm.console.client.event;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TestCaseEvent_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getAtnId(com.rhiscom.bpm.console.client.event.TestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::atnId;
  }-*/;
  
  private static native void setAtnId(com.rhiscom.bpm.console.client.event.TestCaseEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::atnId = value;
  }-*/;
  
  private static native java.util.Date getEndDate(com.rhiscom.bpm.console.client.event.TestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::endDate;
  }-*/;
  
  private static native void setEndDate(com.rhiscom.bpm.console.client.event.TestCaseEvent instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::endDate = value;
  }-*/;
  
  private static native int getId(com.rhiscom.bpm.console.client.event.TestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.client.event.TestCaseEvent instance, int value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::id = value;
  }-*/;
  
  private static native java.lang.String getName(com.rhiscom.bpm.console.client.event.TestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::name;
  }-*/;
  
  private static native void setName(com.rhiscom.bpm.console.client.event.TestCaseEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::name = value;
  }-*/;
  
  private static native java.lang.String getState(com.rhiscom.bpm.console.client.event.TestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::state;
  }-*/;
  
  private static native void setState(com.rhiscom.bpm.console.client.event.TestCaseEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::state = value;
  }-*/;
  
  private static native java.util.Date getStateDate(com.rhiscom.bpm.console.client.event.TestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::stateDate;
  }-*/;
  
  private static native void setStateDate(com.rhiscom.bpm.console.client.event.TestCaseEvent instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::stateDate = value;
  }-*/;
  
  private static native java.lang.String getStcId(com.rhiscom.bpm.console.client.event.TestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::stcId;
  }-*/;
  
  private static native void setStcId(com.rhiscom.bpm.console.client.event.TestCaseEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::stcId = value;
  }-*/;
  
  private static native java.lang.String getType(com.rhiscom.bpm.console.client.event.TestCaseEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::type;
  }-*/;
  
  private static native void setType(com.rhiscom.bpm.console.client.event.TestCaseEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.TestCaseEvent::type = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.client.event.TestCaseEvent instance) throws SerializationException {
    setAtnId(instance, streamReader.readString());
    setEndDate(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readInt());
    setName(instance, streamReader.readString());
    setState(instance, streamReader.readString());
    setStateDate(instance, (java.util.Date) streamReader.readObject());
    setStcId(instance, streamReader.readString());
    setType(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.client.event.TestCaseEvent instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.client.event.TestCaseEvent();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.client.event.TestCaseEvent instance) throws SerializationException {
    streamWriter.writeString(getAtnId(instance));
    streamWriter.writeObject(getEndDate(instance));
    streamWriter.writeInt(getId(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getState(instance));
    streamWriter.writeObject(getStateDate(instance));
    streamWriter.writeString(getStcId(instance));
    streamWriter.writeString(getType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.client.event.TestCaseEvent_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.client.event.TestCaseEvent_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.client.event.TestCaseEvent)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.client.event.TestCaseEvent_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.client.event.TestCaseEvent)object);
  }
  
}
