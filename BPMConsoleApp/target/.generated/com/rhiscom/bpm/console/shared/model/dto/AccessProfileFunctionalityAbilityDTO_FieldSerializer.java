package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AccessProfileFunctionalityAbilityDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.rhiscom.bpm.console.shared.model.dto.AbilityDTO getSegAbility(com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO::segAbility;
  }-*/;
  
  private static native void setSegAbility(com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instance, com.rhiscom.bpm.console.shared.model.dto.AbilityDTO value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO::segAbility = value;
  }-*/;
  
  private static native com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO getSegAccessProfileFunc(com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO::segAccessProfileFunc;
  }-*/;
  
  private static native void setSegAccessProfileFunc(com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instance, com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO::segAccessProfileFunc = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSegAccessProfileFuncAbilityId(com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO::segAccessProfileFuncAbilityId;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSegAccessProfileFuncAbilityId(com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO::segAccessProfileFuncAbilityId = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSegProfileId(com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO::segProfileId;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSegProfileId(com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO::segProfileId = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instance) throws SerializationException {
    setSegAbility(instance, (com.rhiscom.bpm.console.shared.model.dto.AbilityDTO) streamReader.readObject());
    setSegAccessProfileFunc(instance, (com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO) streamReader.readObject());
    setSegAccessProfileFuncAbilityId(instance, streamReader.readLong());
    setSegProfileId(instance, streamReader.readLong());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO instance) throws SerializationException {
    streamWriter.writeObject(getSegAbility(instance));
    streamWriter.writeObject(getSegAccessProfileFunc(instance));
    streamWriter.writeLong(getSegAccessProfileFuncAbilityId(instance));
    streamWriter.writeLong(getSegProfileId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO)object);
  }
  
}
