package com.rhiscom.bpm.console.shared.model.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CuadraturaTarjetaDebitoDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPLCUAPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::diferenciaPLCUAPSDEB;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPLCUAPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::diferenciaPLCUAPSDEB = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPSDEBPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::diferenciaPSDEBPLD;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPSDEBPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::diferenciaPSDEBPLD = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPagoRemotoPLCUAPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::diferenciaPagoRemotoPLCUAPSDEB;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPagoRemotoPLCUAPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::diferenciaPagoRemotoPLCUAPSDEB = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getDiferenciaPagoRemotoPSDEBPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::diferenciaPagoRemotoPSDEBPLD;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setDiferenciaPagoRemotoPSDEBPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::diferenciaPagoRemotoPSDEBPLD = value;
  }-*/;
  
  private static native java.util.Date getFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::fechaTrx;
  }-*/;
  
  private static native void setFechaTrx(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, java.util.Date value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::fechaTrx = value;
  }-*/;
  
  private static native int getId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::id;
  }-*/;
  
  private static native void setId(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, int value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::id = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getPagoRemotoDebitoPLCUA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::pagoRemotoDebitoPLCUA;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setPagoRemotoDebitoPLCUA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::pagoRemotoDebitoPLCUA = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::sucursal;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setSucursal(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::sucursal = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTarjetaDebitoPLCUA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::tarjetaDebitoPLCUA;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTarjetaDebitoPLCUA(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::tarjetaDebitoPLCUA = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionPagoRemotoDebitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalAnulacionPagoRemotoDebitoPLD;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionPagoRemotoDebitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalAnulacionPagoRemotoDebitoPLD = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalAnulacionesPagoRemotoDebitoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalAnulacionesPagoRemotoDebitoPSDEB;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalAnulacionesPagoRemotoDebitoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalAnulacionesPagoRemotoDebitoPSDEB = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPagoRemotoDebitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalPagoRemotoDebitoPLD;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPagoRemotoDebitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalPagoRemotoDebitoPLD = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalPagoRemotoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalPagoRemotoPSDEB;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalPagoRemotoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalPagoRemotoPSDEB = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalTarjetaDebitoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalTarjetaDebitoPSDEB;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalTarjetaDebitoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalTarjetaDebitoPSDEB = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVEntasDEbitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVEntasDEbitoPLD;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVEntasDEbitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVEntasDEbitoPLD = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasInternetDebitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasInternetDebitoPLD;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasInternetDebitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasInternetDebitoPLD = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasInternetTarjetaDebitoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasInternetTarjetaDebitoPSDEB;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasInternetTarjetaDebitoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasInternetTarjetaDebitoPSDEB = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasPagoRemotoDebitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasPagoRemotoDebitoPLD;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasPagoRemotoDebitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasPagoRemotoDebitoPLD = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasPagoRemotoDebitoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasPagoRemotoDebitoPSDEB;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasPagoRemotoDebitoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasPagoRemotoDebitoPSDEB = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasTarjetaDebitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasTarjetaDebitoPLD;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasTarjetaDebitoPLD(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasTarjetaDebitoPLD = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getTotalVentasTarjetaDebitoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasTarjetaDebitoPSDEB;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setTotalVentasTarjetaDebitoPSDEB(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, long value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::totalVentasTarjetaDebitoPSDEB = value;
  }-*/;
  
  private static native java.lang.String getVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) /*-{
    return instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::versionPOS;
  }-*/;
  
  private static native void setVersionPOS(com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance, java.lang.String value) 
  /*-{
    instance.@com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO::versionPOS = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) throws SerializationException {
    setDiferenciaPLCUAPSDEB(instance, streamReader.readLong());
    setDiferenciaPSDEBPLD(instance, streamReader.readLong());
    setDiferenciaPagoRemotoPLCUAPSDEB(instance, streamReader.readLong());
    setDiferenciaPagoRemotoPSDEBPLD(instance, streamReader.readLong());
    setFechaTrx(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readInt());
    setPagoRemotoDebitoPLCUA(instance, streamReader.readLong());
    setSucursal(instance, streamReader.readLong());
    setTarjetaDebitoPLCUA(instance, streamReader.readLong());
    setTotalAnulacionPagoRemotoDebitoPLD(instance, streamReader.readLong());
    setTotalAnulacionesPagoRemotoDebitoPSDEB(instance, streamReader.readLong());
    setTotalPagoRemotoDebitoPLD(instance, streamReader.readLong());
    setTotalPagoRemotoPSDEB(instance, streamReader.readLong());
    setTotalTarjetaDebitoPSDEB(instance, streamReader.readLong());
    setTotalVEntasDEbitoPLD(instance, streamReader.readLong());
    setTotalVentasInternetDebitoPLD(instance, streamReader.readLong());
    setTotalVentasInternetTarjetaDebitoPSDEB(instance, streamReader.readLong());
    setTotalVentasPagoRemotoDebitoPLD(instance, streamReader.readLong());
    setTotalVentasPagoRemotoDebitoPSDEB(instance, streamReader.readLong());
    setTotalVentasTarjetaDebitoPLD(instance, streamReader.readLong());
    setTotalVentasTarjetaDebitoPSDEB(instance, streamReader.readLong());
    setVersionPOS(instance, streamReader.readString());
    
  }
  
  public static com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO instance) throws SerializationException {
    streamWriter.writeLong(getDiferenciaPLCUAPSDEB(instance));
    streamWriter.writeLong(getDiferenciaPSDEBPLD(instance));
    streamWriter.writeLong(getDiferenciaPagoRemotoPLCUAPSDEB(instance));
    streamWriter.writeLong(getDiferenciaPagoRemotoPSDEBPLD(instance));
    streamWriter.writeObject(getFechaTrx(instance));
    streamWriter.writeInt(getId(instance));
    streamWriter.writeLong(getPagoRemotoDebitoPLCUA(instance));
    streamWriter.writeLong(getSucursal(instance));
    streamWriter.writeLong(getTarjetaDebitoPLCUA(instance));
    streamWriter.writeLong(getTotalAnulacionPagoRemotoDebitoPLD(instance));
    streamWriter.writeLong(getTotalAnulacionesPagoRemotoDebitoPSDEB(instance));
    streamWriter.writeLong(getTotalPagoRemotoDebitoPLD(instance));
    streamWriter.writeLong(getTotalPagoRemotoPSDEB(instance));
    streamWriter.writeLong(getTotalTarjetaDebitoPSDEB(instance));
    streamWriter.writeLong(getTotalVEntasDEbitoPLD(instance));
    streamWriter.writeLong(getTotalVentasInternetDebitoPLD(instance));
    streamWriter.writeLong(getTotalVentasInternetTarjetaDebitoPSDEB(instance));
    streamWriter.writeLong(getTotalVentasPagoRemotoDebitoPLD(instance));
    streamWriter.writeLong(getTotalVentasPagoRemotoDebitoPSDEB(instance));
    streamWriter.writeLong(getTotalVentasTarjetaDebitoPLD(instance));
    streamWriter.writeLong(getTotalVentasTarjetaDebitoPSDEB(instance));
    streamWriter.writeString(getVersionPOS(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO_FieldSerializer.deserialize(reader, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO_FieldSerializer.serialize(writer, (com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO)object);
  }
  
}
