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

public class DeleteDataService_Proxy extends RemoteServiceProxy implements com.rhiscom.bpm.console.client.remote.DeleteDataServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.rhiscom.bpm.console.client.remote.DeleteDataService";
  private static final String SERIALIZATION_POLICY ="8964C9C60977453BBE6FDF24222AA2F2";
  private static final com.rhiscom.bpm.console.client.remote.DeleteDataService_TypeSerializer SERIALIZER = new com.rhiscom.bpm.console.client.remote.DeleteDataService_TypeSerializer();
  
  public DeleteDataService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "DeleteDataServiceImpl", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void deleteData(java.util.Date fecha, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("DeleteDataService_Proxy", "deleteData");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.util.Date/3385151746");
      streamWriter.writeObject(fecha);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
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
