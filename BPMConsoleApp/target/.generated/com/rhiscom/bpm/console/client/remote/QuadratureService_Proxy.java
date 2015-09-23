package com.rhiscom.bpm.console.client.remote;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class QuadratureService_Proxy extends RemoteServiceProxy implements com.rhiscom.bpm.console.client.remote.QuadratureServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.rhiscom.bpm.console.client.remote.QuadratureService";
  private static final String SERIALIZATION_POLICY ="6FF31B174D5ECBF927601E1B73428115";
  private static final com.rhiscom.bpm.console.client.remote.QuadratureService_TypeSerializer SERIALIZER = new com.rhiscom.bpm.console.client.remote.QuadratureService_TypeSerializer();
  
  public QuadratureService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "quadratureService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void addNewVersion(com.rhiscom.bpm.console.shared.model.dto.VersionDTO dto, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "addNewVersion");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.dto.VersionDTO/3025227562");
      streamWriter.writeObject(dto);
      helper.finish(callBack, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void deleteVersion(long id, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "deleteVersion");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("J");
      streamWriter.writeLong(id);
      helper.finish(callBack, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getAllVersionPOS(com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "getAllVersionPOS");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getCuadraturaActivacionGiftCard(java.lang.String fechaNegocio, long sucursal, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "getCuadraturaActivacionGiftCard");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("J");
      streamWriter.writeString(fechaNegocio);
      streamWriter.writeLong(sucursal);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getCuadraturaAvanceSuperAvance(java.lang.String fechaNegocio, long sucursal, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "getCuadraturaAvanceSuperAvance");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("J");
      streamWriter.writeString(fechaNegocio);
      streamWriter.writeLong(sucursal);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getCuadraturaNotaCredito(java.lang.String fechaNegocio, long sucursal, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "getCuadraturaNotaCredito");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("J");
      streamWriter.writeString(fechaNegocio);
      streamWriter.writeLong(sucursal);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getCuadraturaPagosCMR(java.lang.String fechaNegocio, long sucursal, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "getCuadraturaPagosCMR");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("J");
      streamWriter.writeString(fechaNegocio);
      streamWriter.writeLong(sucursal);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getCuadraturaTarjetaCredito(java.lang.String fechaNegocio, long sucursal, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "getCuadraturaTarjetaCredito");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("J");
      streamWriter.writeString(fechaNegocio);
      streamWriter.writeLong(sucursal);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getCuadraturaTarjetaDebito(java.lang.String fechaNegocio, long sucursal, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "getCuadraturaTarjetaDebito");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("J");
      streamWriter.writeString(fechaNegocio);
      streamWriter.writeLong(sucursal);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getCuadraturaVtaCMR(java.lang.String fechaNegocioStr, long sucursal, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "getCuadraturaVtaCMR");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("J");
      streamWriter.writeString(fechaNegocioStr);
      streamWriter.writeLong(sucursal);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getCuadraturaVtaGiftCard(java.lang.String fechaNegocio, long sucursal, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "getCuadraturaVtaGiftCard");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("J");
      streamWriter.writeString(fechaNegocio);
      streamWriter.writeLong(sucursal);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void updateVersion(com.rhiscom.bpm.console.shared.model.dto.VersionDTO dto, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("QuadratureService_Proxy", "updateVersion");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.dto.VersionDTO/3025227562");
      streamWriter.writeObject(dto);
      helper.finish(callBack, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
