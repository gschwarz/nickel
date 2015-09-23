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

public class EmailConfigurationService_Proxy extends RemoteServiceProxy implements com.rhiscom.bpm.console.client.remote.EmailConfigurationServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.rhiscom.bpm.console.client.remote.EmailConfigurationService";
  private static final String SERIALIZATION_POLICY ="462B39D50164635BA641587615B9DC1E";
  private static final com.rhiscom.bpm.console.client.remote.EmailConfigurationService_TypeSerializer SERIALIZER = new com.rhiscom.bpm.console.client.remote.EmailConfigurationService_TypeSerializer();
  
  public EmailConfigurationService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "emailConfigurationService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void getConfiguration(com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("EmailConfigurationService_Proxy", "getConfiguration");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getRecipientByEvent(java.lang.String event, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("EmailConfigurationService_Proxy", "getRecipientByEvent");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(event);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void saveOrUpdateConfiguration(com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO dto, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("EmailConfigurationService_Proxy", "saveOrUpdateConfiguration");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO/1152767598");
      streamWriter.writeObject(dto);
      helper.finish(callBack, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void saveOrUpdateRecipients(java.util.List dto, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("EmailConfigurationService_Proxy", "saveOrUpdateRecipients");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.util.List");
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
