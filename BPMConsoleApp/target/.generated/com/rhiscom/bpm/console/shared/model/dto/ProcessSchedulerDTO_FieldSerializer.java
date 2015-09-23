package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProcessSchedulerDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getEndDate(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::endDate;
  }-*/;
  
  private static native void setEndDate(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::endDate = value;
  }-*/;
  
  private static native java.lang.String getHoraInicio(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::horaInicio;
  }-*/;
  
  private static native void setHoraInicio(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::horaInicio = value;
  }-*/;
  
  private static native java.lang.Long getId(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::id = value;
  }-*/;
  
  private static native java.util.Date getInitDate(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::initDate;
  }-*/;
  
  private static native void setInitDate(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::initDate = value;
  }-*/;
  
  private static native java.lang.Boolean getIsDomingo(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isDomingo;
  }-*/;
  
  private static native void setIsDomingo(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.Boolean value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isDomingo = value;
  }-*/;
  
  private static native java.lang.Boolean getIsJueves(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isJueves;
  }-*/;
  
  private static native void setIsJueves(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.Boolean value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isJueves = value;
  }-*/;
  
  private static native java.lang.Boolean getIsLunes(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isLunes;
  }-*/;
  
  private static native void setIsLunes(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.Boolean value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isLunes = value;
  }-*/;
  
  private static native java.lang.Boolean getIsMartes(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isMartes;
  }-*/;
  
  private static native void setIsMartes(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.Boolean value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isMartes = value;
  }-*/;
  
  private static native java.lang.Boolean getIsMiercoles(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isMiercoles;
  }-*/;
  
  private static native void setIsMiercoles(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.Boolean value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isMiercoles = value;
  }-*/;
  
  private static native java.lang.Boolean getIsSabado(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isSabado;
  }-*/;
  
  private static native void setIsSabado(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.Boolean value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isSabado = value;
  }-*/;
  
  private static native java.lang.Boolean getIsViernes(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isViernes;
  }-*/;
  
  private static native void setIsViernes(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.Boolean value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::isViernes = value;
  }-*/;
  
  private static native java.lang.String getMinutoInicio(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::minutoInicio;
  }-*/;
  
  private static native void setMinutoInicio(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::minutoInicio = value;
  }-*/;
  
  private static native java.lang.String getProcessId(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::processId;
  }-*/;
  
  private static native void setProcessId(com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO::processId = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) throws SerializationException {
    setEndDate(instance, (java.util.Date) streamReader.readObject());
    setHoraInicio(instance, streamReader.readString());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setInitDate(instance, (java.util.Date) streamReader.readObject());
    setIsDomingo(instance, (java.lang.Boolean) streamReader.readObject());
    setIsJueves(instance, (java.lang.Boolean) streamReader.readObject());
    setIsLunes(instance, (java.lang.Boolean) streamReader.readObject());
    setIsMartes(instance, (java.lang.Boolean) streamReader.readObject());
    setIsMiercoles(instance, (java.lang.Boolean) streamReader.readObject());
    setIsSabado(instance, (java.lang.Boolean) streamReader.readObject());
    setIsViernes(instance, (java.lang.Boolean) streamReader.readObject());
    setMinutoInicio(instance, streamReader.readString());
    setProcessId(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO instance) throws SerializationException {
    streamWriter.writeObject(getEndDate(instance));
    streamWriter.writeString(getHoraInicio(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeObject(getInitDate(instance));
    streamWriter.writeObject(getIsDomingo(instance));
    streamWriter.writeObject(getIsJueves(instance));
    streamWriter.writeObject(getIsLunes(instance));
    streamWriter.writeObject(getIsMartes(instance));
    streamWriter.writeObject(getIsMiercoles(instance));
    streamWriter.writeObject(getIsSabado(instance));
    streamWriter.writeObject(getIsViernes(instance));
    streamWriter.writeString(getMinutoInicio(instance));
    streamWriter.writeString(getProcessId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO)object);
  }
  
}
