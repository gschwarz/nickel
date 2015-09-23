package com.rhiscom.bpm.console.client.remote;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO;
import com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO;
import com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS;
import com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.InstancesRS;
import com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS;
import com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper;
import com.rhiscom.bpm.console.shared.model.rs.TaskRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskUserRS;
import com.rhiscom.bpm.console.shared.model.rs.UserTaskVO;

public interface ConsoleBPMServiceAsync {

    void getDefinitions(AsyncCallback<ProcessDefinitionsRS> callback);

    void getProcessInstances(DefinitionsRS definitionsRS, AsyncCallback<ProcessDefinitionInstancesRS> callback);

    void getProcessInstance(InstancesRS instancesRS, AsyncCallback<InstancesRS> callback);

    void deleteInstance(InstancesRS instance, AsyncCallback callback);

    void startInstace(DefinitionsRS definitionsRS, AsyncCallback<InstancesRS> callback);

    void getActiveNodeInfo(InstancesRS instance, AsyncCallback<Collection<ActiveNodeInfoRS>> callback);

    void getDefinition(DefinitionsRS definition, AsyncCallback<DefinitionsRS> callback);

    void getUrlImage(DefinitionsRS definitionsRS, AsyncCallback<String> callback);

    void getListUserTask(UserTaskVO userTaskVO, AsyncCallback<TaskUserRS> callback);

    void getTaskDetail(String idTask, AsyncCallback<TaskDetailRS> callback);

    void getListUnassignedTask(UserTaskVO userTaskVO, AsyncCallback<TaskUserRS> callback);

    void assignedTask(UserTaskVO userTaskVO, String idTask, AsyncCallback<String> callback);

    void getUserTask(UserTaskVO userTaskVO, AsyncCallback<TaskRS> callback);

    void getProcessRenderHTML(DefinitionsRS pd, UserTaskVO userTaskVO, AsyncCallback<String> callback);

    void getTaskRenderHTML(UserTaskVO userTaskVO, AsyncCallback<String> callback);

    void processComplete(DefinitionsRS definitionsRS, UserTaskVO userTaskVO, AsyncCallback<String> callback);

    void processComplete(DefinitionsRS definitionsRS, Map<String, Object> params, UserTaskVO userTaskVO,
	    AsyncCallback<String> callback);

    void taskComplete(TaskRS taskRS, Map<String, Object> params, UserTaskVO userTaskVO, AsyncCallback<String> callback);

    void taskComplete(UserTaskVO userTaskVO, Map<String, Object> params, AsyncCallback<String> callback);

    void userInvalidate(AsyncCallback callback);

    void getSid(AsyncCallback<String> callback);

    void getSecureSid(AsyncCallback<String> callback);

    void getDataSet(TaskRS taskRS, AsyncCallback<String> callback);

    void login(String user, String passeord, AsyncCallback callback);

    void addTaskComment(TaskCommentDTO comment, AsyncCallback callback) throws Exception;

    void getCommentsByProcessId(long id, String processId, AsyncCallback<List<ProcessInstancesCommentDTO>> callBack);

    void getAllTaskNotCompleted(AsyncCallback<TaskListWrapper> taskList);
}
