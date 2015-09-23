package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class WorkerDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.rhiscom.bpm.console.shared.model.dto.PersonDTO getPerson(com.rhiscom.bpm.console.shared.model.dto.WorkerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.WorkerDTO::person;
  }-*/;
  
  private static native void setPerson(com.rhiscom.bpm.console.shared.model.dto.WorkerDTO instance, com.rhiscom.bpm.console.shared.model.dto.PersonDTO value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.WorkerDTO::person = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getWorkerId(com.rhiscom.bpm.console.shared.model.dto.WorkerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.WorkerDTO::workerId;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setWorkerId(com.rhiscom.bpm.console.shared.model.dto.WorkerDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.WorkerDTO::workerId = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.WorkerDTO instance) throws SerializationException {
    setPerson(instance, (com.rhiscom.bpm.console.shared.model.dto.PersonDTO) streamReader.readObject());
    setWorkerId(instance, streamReader.readLong());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.WorkerDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.WorkerDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.WorkerDTO instance) throws SerializationException {
    streamWriter.writeObject(getPerson(instance));
    streamWriter.writeLong(getWorkerId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.WorkerDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.WorkerDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.WorkerDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.WorkerDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.WorkerDTO)object);
  }
  
}
