package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class EmailConfigurationDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Long getEmailConfigurationId(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO::emailConfigurationId;
  }-*/;
  
  private static native void setEmailConfigurationId(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO::emailConfigurationId = value;
  }-*/;
  
  private static native java.lang.String getEmailPort(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO::emailPort;
  }-*/;
  
  private static native void setEmailPort(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO::emailPort = value;
  }-*/;
  
  private static native java.lang.String getEmailServer(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO::emailServer;
  }-*/;
  
  private static native void setEmailServer(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO::emailServer = value;
  }-*/;
  
  private static native java.lang.String getPassword(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO::password;
  }-*/;
  
  private static native void setPassword(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO::password = value;
  }-*/;
  
  private static native java.lang.String getSenderEmail(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO::senderEmail;
  }-*/;
  
  private static native void setSenderEmail(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO::senderEmail = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance) throws SerializationException {
    setEmailConfigurationId(instance, (java.lang.Long) streamReader.readObject());
    setEmailPort(instance, streamReader.readString());
    setEmailServer(instance, streamReader.readString());
    setPassword(instance, streamReader.readString());
    setSenderEmail(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO instance) throws SerializationException {
    streamWriter.writeObject(getEmailConfigurationId(instance));
    streamWriter.writeString(getEmailPort(instance));
    streamWriter.writeString(getEmailServer(instance));
    streamWriter.writeString(getPassword(instance));
    streamWriter.writeString(getSenderEmail(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO)object);
  }
  
}
