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

public class ConsoleBPMService_Proxy extends RemoteServiceProxy implements com.rhiscom.bpm.console.client.remote.ConsoleBPMServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.rhiscom.bpm.console.client.remote.ConsoleBPMService";
  private static final String SERIALIZATION_POLICY ="88048AF0B30152443A19FC2BDE5E9362";
  private static final com.rhiscom.bpm.console.client.remote.ConsoleBPMService_TypeSerializer SERIALIZER = new com.rhiscom.bpm.console.client.remote.ConsoleBPMService_TypeSerializer();
  
  public ConsoleBPMService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "bpmservice", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void addTaskComment(com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO comment, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "addTaskComment");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO/4251576705");
      streamWriter.writeObject(comment);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void assignedTask(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO userTaskVO, java.lang.String idTask, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "assignedTask");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.UserTaskVO/1407383170");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(userTaskVO);
      streamWriter.writeString(idTask);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteInstance(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "deleteInstance");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.InstancesRS/2306756568");
      streamWriter.writeObject(instance);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getActiveNodeInfo(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instance, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getActiveNodeInfo");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.InstancesRS/2306756568");
      streamWriter.writeObject(instance);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getAllTaskNotCompleted(com.google.gwt.user.client.rpc.AsyncCallback taskList) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getAllTaskNotCompleted");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(taskList, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      taskList.onFailure(ex);
    }
  }
  
  public void getCommentsByProcessId(long id, java.lang.String processId, com.google.gwt.user.client.rpc.AsyncCallback callBack) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getCommentsByProcessId");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("J");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeLong(id);
      streamWriter.writeString(processId);
      helper.finish(callBack, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callBack.onFailure(ex);
    }
  }
  
  public void getDataSet(com.rhiscom.bpm.console.shared.model.rs.TaskRS taskRS, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getDataSet");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.TaskRS/3526559285");
      streamWriter.writeObject(taskRS);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getDefinition(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS definition, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getDefinition");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS/3291149616");
      streamWriter.writeObject(definition);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getDefinitions(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getDefinitions");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getListUnassignedTask(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO userTaskVO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getListUnassignedTask");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.UserTaskVO/1407383170");
      streamWriter.writeObject(userTaskVO);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getListUserTask(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO userTaskVO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getListUserTask");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.UserTaskVO/1407383170");
      streamWriter.writeObject(userTaskVO);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getProcessInstance(com.rhiscom.bpm.console.shared.model.rs.InstancesRS instancesRS, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getProcessInstance");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.InstancesRS/2306756568");
      streamWriter.writeObject(instancesRS);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getProcessInstances(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS definitionsRS, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getProcessInstances");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS/3291149616");
      streamWriter.writeObject(definitionsRS);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getProcessRenderHTML(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS pd, com.rhiscom.bpm.console.shared.model.rs.UserTaskVO userTaskVO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getProcessRenderHTML");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS/3291149616");
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.UserTaskVO/1407383170");
      streamWriter.writeObject(pd);
      streamWriter.writeObject(userTaskVO);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getSecureSid(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getSecureSid");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getSid(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getSid");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getTaskDetail(java.lang.String idTask, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getTaskDetail");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(idTask);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getTaskRenderHTML(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO userTaskVO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getTaskRenderHTML");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.UserTaskVO/1407383170");
      streamWriter.writeObject(userTaskVO);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getUrlImage(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS definitionsRS, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getUrlImage");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS/3291149616");
      streamWriter.writeObject(definitionsRS);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getUserTask(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO userTaskVO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "getUserTask");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.UserTaskVO/1407383170");
      streamWriter.writeObject(userTaskVO);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void login(java.lang.String user, java.lang.String passeord, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "login");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(user);
      streamWriter.writeString(passeord);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void processComplete(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS definitionsRS, com.rhiscom.bpm.console.shared.model.rs.UserTaskVO userTaskVO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "processComplete");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS/3291149616");
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.UserTaskVO/1407383170");
      streamWriter.writeObject(definitionsRS);
      streamWriter.writeObject(userTaskVO);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void processComplete(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS definitionsRS, java.util.Map params, com.rhiscom.bpm.console.shared.model.rs.UserTaskVO userTaskVO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "processComplete");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS/3291149616");
      streamWriter.writeString("java.util.Map");
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.UserTaskVO/1407383170");
      streamWriter.writeObject(definitionsRS);
      streamWriter.writeObject(params);
      streamWriter.writeObject(userTaskVO);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void startInstace(com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS definitionsRS, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "startInstace");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS/3291149616");
      streamWriter.writeObject(definitionsRS);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void taskComplete(com.rhiscom.bpm.console.shared.model.rs.TaskRS taskRS, java.util.Map params, com.rhiscom.bpm.console.shared.model.rs.UserTaskVO userTaskVO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "taskComplete");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.TaskRS/3526559285");
      streamWriter.writeString("java.util.Map");
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.UserTaskVO/1407383170");
      streamWriter.writeObject(taskRS);
      streamWriter.writeObject(params);
      streamWriter.writeObject(userTaskVO);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void taskComplete(com.rhiscom.bpm.console.shared.model.rs.UserTaskVO userTaskVO, java.util.Map params, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "taskComplete");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("com.rhiscom.bpm.console.shared.model.rs.UserTaskVO/1407383170");
      streamWriter.writeString("java.util.Map");
      streamWriter.writeObject(userTaskVO);
      streamWriter.writeObject(params);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void userInvalidate(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("ConsoleBPMService_Proxy", "userInvalidate");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
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
