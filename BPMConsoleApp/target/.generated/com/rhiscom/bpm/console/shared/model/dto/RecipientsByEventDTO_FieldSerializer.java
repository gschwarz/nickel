package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RecipientsByEventDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getEvent(com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO::event;
  }-*/;
  
  private static native void setEvent(com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO::event = value;
  }-*/;
  
  private static native java.lang.String getRecipients(com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO::recipients;
  }-*/;
  
  private static native void setRecipients(com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO::recipients = value;
  }-*/;
  
  private static native java.lang.Long getRecipientsId(com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO::recipientsId;
  }-*/;
  
  private static native void setRecipientsId(com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO::recipientsId = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO instance) throws SerializationException {
    setEvent(instance, streamReader.readString());
    setRecipients(instance, streamReader.readString());
    setRecipientsId(instance, (java.lang.Long) streamReader.readObject());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO instance) throws SerializationException {
    streamWriter.writeString(getEvent(instance));
    streamWriter.writeString(getRecipients(instance));
    streamWriter.writeObject(getRecipientsId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO)object);
  }
  
}
