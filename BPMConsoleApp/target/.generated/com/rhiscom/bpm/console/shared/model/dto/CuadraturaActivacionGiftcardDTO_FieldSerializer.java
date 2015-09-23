package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CuadraturaActivacionGiftcardDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Long getActivacionGiftCardCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::activacionGiftCardCMR;
  }-*/;
  
  private static native void setActivacionGiftCardCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::activacionGiftCardCMR = value;
  }-*/;
  
  private static native java.lang.Long getActivacionGiftCardCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::activacionGiftCardCorporativa;
  }-*/;
  
  private static native void setActivacionGiftCardCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::activacionGiftCardCorporativa = value;
  }-*/;
  
  private static native java.lang.Long getAnulacionGiftCardCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::anulacionGiftCardCMR;
  }-*/;
  
  private static native void setAnulacionGiftCardCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::anulacionGiftCardCMR = value;
  }-*/;
  
  private static native java.lang.Long getAnulacionGiftCardCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::anulacionGiftCardCorporativa;
  }-*/;
  
  private static native void setAnulacionGiftCardCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::anulacionGiftCardCorporativa = value;
  }-*/;
  
  private static native java.lang.Long getDiferenciaPlaCuadConPLGC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::diferenciaPlaCuadConPLGC;
  }-*/;
  
  private static native void setDiferenciaPlaCuadConPLGC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::diferenciaPlaCuadConPLGC = value;
  }-*/;
  
  private static native java.util.Date getFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::fechaTrx;
  }-*/;
  
  private static native void setFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::fechaTrx = value;
  }-*/;
  
  private static native java.lang.Integer getId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Integer value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::id = value;
  }-*/;
  
  private static native java.lang.Long getSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::sucursal;
  }-*/;
  
  private static native void setSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::sucursal = value;
  }-*/;
  
  private static native java.lang.Long getTotalACCGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalACCGiftCMR;
  }-*/;
  
  private static native void setTotalACCGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalACCGiftCMR = value;
  }-*/;
  
  private static native java.lang.Long getTotalACCGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalACCGiftCorporativa;
  }-*/;
  
  private static native void setTotalACCGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalACCGiftCorporativa = value;
  }-*/;
  
  private static native java.lang.Long getTotalActGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalActGiftCMR;
  }-*/;
  
  private static native void setTotalActGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalActGiftCMR = value;
  }-*/;
  
  private static native java.lang.Long getTotalActGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalActGiftCorporativa;
  }-*/;
  
  private static native void setTotalActGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalActGiftCorporativa = value;
  }-*/;
  
  private static native java.lang.Long getTotalGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCMR;
  }-*/;
  
  private static native void setTotalGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCMR = value;
  }-*/;
  
  private static native java.lang.Long getTotalGiftCMR2(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCMR2;
  }-*/;
  
  private static native void setTotalGiftCMR2(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCMR2 = value;
  }-*/;
  
  private static native java.lang.Long getTotalGiftCard(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCard;
  }-*/;
  
  private static native void setTotalGiftCard(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCard = value;
  }-*/;
  
  private static native java.lang.Long getTotalGiftCard2(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCard2;
  }-*/;
  
  private static native void setTotalGiftCard2(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCard2 = value;
  }-*/;
  
  private static native java.lang.Long getTotalGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCorporativa;
  }-*/;
  
  private static native void setTotalGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCorporativa = value;
  }-*/;
  
  private static native java.lang.Long getTotalGiftCorporativa2(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCorporativa2;
  }-*/;
  
  private static native void setTotalGiftCorporativa2(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::totalGiftCorporativa2 = value;
  }-*/;
  
  private static native java.lang.String getVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::versionPOS;
  }-*/;
  
  private static native void setVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO::versionPOS = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) throws SerializationException {
    setActivacionGiftCardCMR(instance, (java.lang.Long) streamReader.readObject());
    setActivacionGiftCardCorporativa(instance, (java.lang.Long) streamReader.readObject());
    setAnulacionGiftCardCMR(instance, (java.lang.Long) streamReader.readObject());
    setAnulacionGiftCardCorporativa(instance, (java.lang.Long) streamReader.readObject());
    setDiferenciaPlaCuadConPLGC(instance, (java.lang.Long) streamReader.readObject());
    setFechaTrx(instance, (java.util.Date) streamReader.readObject());
    setId(instance, (java.lang.Integer) streamReader.readObject());
    setSucursal(instance, (java.lang.Long) streamReader.readObject());
    setTotalACCGiftCMR(instance, (java.lang.Long) streamReader.readObject());
    setTotalACCGiftCorporativa(instance, (java.lang.Long) streamReader.readObject());
    setTotalActGiftCMR(instance, (java.lang.Long) streamReader.readObject());
    setTotalActGiftCorporativa(instance, (java.lang.Long) streamReader.readObject());
    setTotalGiftCMR(instance, (java.lang.Long) streamReader.readObject());
    setTotalGiftCMR2(instance, (java.lang.Long) streamReader.readObject());
    setTotalGiftCard(instance, (java.lang.Long) streamReader.readObject());
    setTotalGiftCard2(instance, (java.lang.Long) streamReader.readObject());
    setTotalGiftCorporativa(instance, (java.lang.Long) streamReader.readObject());
    setTotalGiftCorporativa2(instance, (java.lang.Long) streamReader.readObject());
    setVersionPOS(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO instance) throws SerializationException {
    streamWriter.writeObject(getActivacionGiftCardCMR(instance));
    streamWriter.writeObject(getActivacionGiftCardCorporativa(instance));
    streamWriter.writeObject(getAnulacionGiftCardCMR(instance));
    streamWriter.writeObject(getAnulacionGiftCardCorporativa(instance));
    streamWriter.writeObject(getDiferenciaPlaCuadConPLGC(instance));
    streamWriter.writeObject(getFechaTrx(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeObject(getSucursal(instance));
    streamWriter.writeObject(getTotalACCGiftCMR(instance));
    streamWriter.writeObject(getTotalACCGiftCorporativa(instance));
    streamWriter.writeObject(getTotalActGiftCMR(instance));
    streamWriter.writeObject(getTotalActGiftCorporativa(instance));
    streamWriter.writeObject(getTotalGiftCMR(instance));
    streamWriter.writeObject(getTotalGiftCMR2(instance));
    streamWriter.writeObject(getTotalGiftCard(instance));
    streamWriter.writeObject(getTotalGiftCard2(instance));
    streamWriter.writeObject(getTotalGiftCorporativa(instance));
    streamWriter.writeObject(getTotalGiftCorporativa2(instance));
    streamWriter.writeString(getVersionPOS(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO)object);
  }
  
}
