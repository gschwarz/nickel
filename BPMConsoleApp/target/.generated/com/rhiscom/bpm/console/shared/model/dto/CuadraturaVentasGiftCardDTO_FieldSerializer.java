package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CuadraturaVentasGiftCardDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getAnulacionesVtaNCAGifCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::anulacionesVtaNCAGifCorporativa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setAnulacionesVtaNCAGifCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::anulacionesVtaNCAGifCorporativa = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getAnulacionesVtaNCAGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::anulacionesVtaNCAGiftCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setAnulacionesVtaNCAGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::anulacionesVtaNCAGiftCMR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPlacuadMpvgc(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::diferenciaPlacuadMpvgc;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPlacuadMpvgc(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::diferenciaPlacuadMpvgc = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDonacionesGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::donacionesGiftCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDonacionesGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::donacionesGiftCMR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDonacionesGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::donacionesGiftCorporativa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDonacionesGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::donacionesGiftCorporativa = value;
  }-*/;
  
  private static native java.util.Date getFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::fechaTrx;
  }-*/;
  
  private static native void setFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::fechaTrx = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::id;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::id = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getNcrGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::ncrGiftCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setNcrGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::ncrGiftCMR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getNcrGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::ncrGiftCorporativa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setNcrGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::ncrGiftCorporativa = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::sucursal;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::sucursal = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSumatoriaMpvgc(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::sumatoriaMpvgc;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSumatoriaMpvgc(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::sumatoriaMpvgc = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSumatoriaPlcua(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::sumatoriaPlcua;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSumatoriaPlcua(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::sumatoriaPlcua = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionesNCRGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalAnulacionesNCRGiftCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionesNCRGiftCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalAnulacionesNCRGiftCMR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionesNCRGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalAnulacionesNCRGiftCorporativa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionesNCRGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalAnulacionesNCRGiftCorporativa = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalGifCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalGifCorporativa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalGifCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalGifCorporativa = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPlaCuaCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalPlaCuaCorporativa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPlaCuaCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalPlaCuaCorporativa = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPlaCuadCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalPlaCuadCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPlaCuadCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalPlaCuadCMR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasGiftCMRPVGC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalVentasGiftCMRPVGC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasGiftCMRPVGC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalVentasGiftCMRPVGC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasGiftCardCMRPVGC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalVentasGiftCardCMRPVGC;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasGiftCardCMRPVGC(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalVentasGiftCardCMRPVGC = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalVentasGiftCorporativa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::totalVentasGiftCorporativa = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getVentasGiftCardCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::ventasGiftCardCMR;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setVentasGiftCardCMR(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::ventasGiftCardCMR = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getVentasGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::ventasGiftCorporativa;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setVentasGiftCorporativa(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::ventasGiftCorporativa = value;
  }-*/;
  
  private static native java.lang.String getVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::versionPOS;
  }-*/;
  
  private static native void setVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO::versionPOS = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) throws SerializationException {
    setAnulacionesVtaNCAGifCorporativa(instance, streamReader.readLong());
    setAnulacionesVtaNCAGiftCMR(instance, streamReader.readLong());
    setDiferenciaPlacuadMpvgc(instance, streamReader.readLong());
    setDonacionesGiftCMR(instance, streamReader.readLong());
    setDonacionesGiftCorporativa(instance, streamReader.readLong());
    setFechaTrx(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readLong());
    setNcrGiftCMR(instance, streamReader.readLong());
    setNcrGiftCorporativa(instance, streamReader.readLong());
    setSucursal(instance, streamReader.readLong());
    setSumatoriaMpvgc(instance, streamReader.readLong());
    setSumatoriaPlcua(instance, streamReader.readLong());
    setTotalAnulacionesNCRGiftCMR(instance, streamReader.readLong());
    setTotalAnulacionesNCRGiftCorporativa(instance, streamReader.readLong());
    setTotalGifCorporativa(instance, streamReader.readLong());
    setTotalPlaCuaCorporativa(instance, streamReader.readLong());
    setTotalPlaCuadCMR(instance, streamReader.readLong());
    setTotalVentasGiftCMRPVGC(instance, streamReader.readLong());
    setTotalVentasGiftCardCMRPVGC(instance, streamReader.readLong());
    setTotalVentasGiftCorporativa(instance, streamReader.readLong());
    setVentasGiftCardCMR(instance, streamReader.readLong());
    setVentasGiftCorporativa(instance, streamReader.readLong());
    setVersionPOS(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO instance) throws SerializationException {
    streamWriter.writeLong(getAnulacionesVtaNCAGifCorporativa(instance));
    streamWriter.writeLong(getAnulacionesVtaNCAGiftCMR(instance));
    streamWriter.writeLong(getDiferenciaPlacuadMpvgc(instance));
    streamWriter.writeLong(getDonacionesGiftCMR(instance));
    streamWriter.writeLong(getDonacionesGiftCorporativa(instance));
    streamWriter.writeObject(getFechaTrx(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeLong(getNcrGiftCMR(instance));
    streamWriter.writeLong(getNcrGiftCorporativa(instance));
    streamWriter.writeLong(getSucursal(instance));
    streamWriter.writeLong(getSumatoriaMpvgc(instance));
    streamWriter.writeLong(getSumatoriaPlcua(instance));
    streamWriter.writeLong(getTotalAnulacionesNCRGiftCMR(instance));
    streamWriter.writeLong(getTotalAnulacionesNCRGiftCorporativa(instance));
    streamWriter.writeLong(getTotalGifCorporativa(instance));
    streamWriter.writeLong(getTotalPlaCuaCorporativa(instance));
    streamWriter.writeLong(getTotalPlaCuadCMR(instance));
    streamWriter.writeLong(getTotalVentasGiftCMRPVGC(instance));
    streamWriter.writeLong(getTotalVentasGiftCardCMRPVGC(instance));
    streamWriter.writeLong(getTotalVentasGiftCorporativa(instance));
    streamWriter.writeLong(getVentasGiftCardCMR(instance));
    streamWriter.writeLong(getVentasGiftCorporativa(instance));
    streamWriter.writeString(getVersionPOS(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO)object);
  }
  
}
