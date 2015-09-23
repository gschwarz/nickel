package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class PersonDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getEmail(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::email;
  }-*/;
  
  private static native void setEmail(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::email = value;
  }-*/;
  
  private static native java.lang.String getFirstName(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::firstName;
  }-*/;
  
  private static native void setFirstName(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::firstName = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getGender(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::gender;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setGender(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::gender = value;
  }-*/;
  
  private static native java.lang.String getIdentification(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::identification;
  }-*/;
  
  private static native void setIdentification(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::identification = value;
  }-*/;
  
  private static native java.lang.String getLastName(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::lastName;
  }-*/;
  
  private static native void setLastName(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::lastName = value;
  }-*/;
  
  private static native java.lang.String getMiddleName(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::middleName;
  }-*/;
  
  private static native void setMiddleName(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::middleName = value;
  }-*/;
  
  private static native java.lang.String getPartyId(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::partyId;
  }-*/;
  
  private static native void setPartyId(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::partyId = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getPersonId(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::personId;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setPersonId(com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.PersonDTO::personId = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance) throws SerializationException {
    setEmail(instance, streamReader.readString());
    setFirstName(instance, streamReader.readString());
    setGender(instance, streamReader.readLong());
    setIdentification(instance, streamReader.readString());
    setLastName(instance, streamReader.readString());
    setMiddleName(instance, streamReader.readString());
    setPartyId(instance, streamReader.readString());
    setPersonId(instance, streamReader.readLong());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.PersonDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.PersonDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.PersonDTO instance) throws SerializationException {
    streamWriter.writeString(getEmail(instance));
    streamWriter.writeString(getFirstName(instance));
    streamWriter.writeLong(getGender(instance));
    streamWriter.writeString(getIdentification(instance));
    streamWriter.writeString(getLastName(instance));
    streamWriter.writeString(getMiddleName(instance));
    streamWriter.writeString(getPartyId(instance));
    streamWriter.writeLong(getPersonId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.PersonDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.PersonDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.PersonDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.PersonDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.PersonDTO)object);
  }
  
}
