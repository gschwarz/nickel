package com.rhiscom.bpm.console.client.event;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ServerGeneratedMessageEvent_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.rhiscom.bpm.console.shared.model.EventoConsultaTienda getEvento(com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent::evento;
  }-*/;
  
  private static native void setEvento(com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instance, com.rhiscom.bpm.console.shared.model.EventoConsultaTienda value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent::evento = value;
  }-*/;
  
  private static native java.lang.String getMyServerGeneratedMessage(com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent::myServerGeneratedMessage;
  }-*/;
  
  private static native void setMyServerGeneratedMessage(com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent::myServerGeneratedMessage = value;
  }-*/;
  
  private static native com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent getSuiteTestCaseEvent(com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent::suiteTestCaseEvent;
  }-*/;
  
  private static native void setSuiteTestCaseEvent(com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instance, com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent::suiteTestCaseEvent = value;
  }-*/;
  
  private static native com.rhiscom.bpm.console.client.event.TestCaseEvent getTestCaseEvent(com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instance) /*-{
    return instance.@com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent::testCaseEvent;
  }-*/;
  
  private static native void setTestCaseEvent(com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instance, com.rhiscom.bpm.console.client.event.TestCaseEvent value) 
  /*-{
    instance.@com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent::testCaseEvent = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instance) throws SerializationException {
    setEvento(instance, (com.rhiscom.bpm.console.shared.model.EventoConsultaTienda) streamReader.readObject());
    setMyServerGeneratedMessage(instance, streamReader.readString());
    setSuiteTestCaseEvent(instance, (com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent) streamReader.readObject());
    setTestCaseEvent(instance, (com.rhiscom.bpm.console.client.event.TestCaseEvent) streamReader.readObject());
    
  }
  
  public static com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent instance) throws SerializationException {
    streamWriter.writeObject(getEvento(instance));
    streamWriter.writeString(getMyServerGeneratedMessage(instance));
    streamWriter.writeObject(getSuiteTestCaseEvent(instance));
    streamWriter.writeObject(getTestCaseEvent(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent)object);
  }
  
}
