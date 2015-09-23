package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProcessInstanceLogDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getEndDate(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::endDate;
  }-*/;
  
  private static native void setEndDate(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::endDate = value;
  }-*/;
  
  private static native java.lang.Long getId(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::id = value;
  }-*/;
  
  private static native java.lang.String getProcessId(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::processId;
  }-*/;
  
  private static native void setProcessId(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::processId = value;
  }-*/;
  
  private static native java.lang.Long getProcessInstanceId(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::processInstanceId;
  }-*/;
  
  private static native void setProcessInstanceId(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::processInstanceId = value;
  }-*/;
  
  private static native java.util.Date getStartDate(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::startDate;
  }-*/;
  
  private static native void setStartDate(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::startDate = value;
  }-*/;
  
  private static native java.lang.String getStatus(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::status;
  }-*/;
  
  private static native void setStatus(com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance) throws SerializationException {
    setEndDate(instance, (java.util.Date) streamReader.readObject());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setProcessId(instance, streamReader.readString());
    setProcessInstanceId(instance, (java.lang.Long) streamReader.readObject());
    setStartDate(instance, (java.util.Date) streamReader.readObject());
    setStatus(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO instance) throws SerializationException {
    streamWriter.writeObject(getEndDate(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getProcessId(instance));
    streamWriter.writeObject(getProcessInstanceId(instance));
    streamWriter.writeObject(getStartDate(instance));
    streamWriter.writeString(getStatus(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO)object);
  }
  
}
