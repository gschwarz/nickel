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

public class DespachoDomicilioService_Proxy extends RemoteServiceProxy implements com.rhiscom.bpm.console.client.remote.DespachoDomicilioServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.rhiscom.bpm.console.client.remote.DespachoDomicilioService";
  private static final String SERIALIZATION_POLICY ="CB0ED96E46D93FF5627C80333199679A";
  private static final com.rhiscom.bpm.console.client.remote.DespachoDomicilioService_TypeSerializer SERIALIZER = new com.rhiscom.bpm.console.client.remote.DespachoDomicilioService_TypeSerializer();
  
  public DespachoDomicilioService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "despachoDomicilioService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void traerVentaPorId(long idVenta, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("DespachoDomicilioService_Proxy", "traerVentaPorId");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("J");
      streamWriter.writeLong(idVenta);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
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
