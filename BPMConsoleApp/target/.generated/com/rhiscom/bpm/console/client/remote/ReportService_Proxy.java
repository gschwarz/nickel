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

public class ReportService_Proxy extends RemoteServiceProxy implements com.rhiscom.bpm.console.client.remote.ReportServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.rhiscom.bpm.console.client.remote.ReportService";
  private static final String SERIALIZATION_POLICY ="A8576E38906834DA3843ABED056DF3D1";
  private static final com.rhiscom.bpm.console.client.remote.ReportService_TypeSerializer SERIALIZER = new com.rhiscom.bpm.console.client.remote.ReportService_TypeSerializer();
  
  public ReportService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "reportService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void getAllPlansATN(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ReportService_Proxy", "getAllPlansATN");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
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
