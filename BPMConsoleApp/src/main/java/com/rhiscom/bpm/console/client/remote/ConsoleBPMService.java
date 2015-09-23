package com.rhiscom.bpm.console.client.remote;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
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

@RemoteServiceRelativePath("bpmservice")
public interface ConsoleBPMService extends RemoteService {

    public ProcessDefinitionsRS getDefinitions() throws Exception;

    public ProcessDefinitionInstancesRS getProcessInstances(DefinitionsRS definitionsRS) throws Exception;

    public InstancesRS getProcessInstance(InstancesRS instancesRS) throws Exception;

    public void deleteInstance(InstancesRS instance) throws Exception;

    public InstancesRS startInstace(DefinitionsRS definitionsRS) throws Exception;

    public Collection<ActiveNodeInfoRS> getActiveNodeInfo(InstancesRS instance) throws Exception;

    public DefinitionsRS getDefinition(DefinitionsRS definition) throws Exception;

    public String getUrlImage(DefinitionsRS definitionsRS) throws Exception;

    // public InputStream getImage(DefinitionsRS definitionsRS) throws
    // Exception;

    public TaskUserRS getListUserTask(UserTaskVO userTaskVO) throws Exception;

    public TaskDetailRS getTaskDetail(String idTask) throws Exception;

    public TaskUserRS getListUnassignedTask(UserTaskVO userTaskVO) throws Exception;

    public String assignedTask(UserTaskVO userTaskVO, String idTask) throws Exception;

    public TaskRS getUserTask(UserTaskVO userTaskVO) throws Exception;

    public String getProcessRenderHTML(DefinitionsRS pd, UserTaskVO userTaskVO) throws Exception;

    public String getTaskRenderHTML(UserTaskVO userTaskVO) throws Exception;

    // public InputStream getProcessRender(DefinitionsRS pd) throws Exception;

    // public InputStream getTaskRender(UserTaskVO userTaskVO) throws Exception;

    public String processComplete(DefinitionsRS definitionsRS, UserTaskVO userTaskVO) throws Exception;

    public String processComplete(DefinitionsRS definitionsRS, Map<String, Object> params, UserTaskVO userTaskVO)
	    throws Exception;

    public String taskComplete(TaskRS taskRS, Map<String, Object> params, UserTaskVO userTaskVO) throws Exception;

    public String taskComplete(UserTaskVO userTaskVO, Map<String, Object> params) throws Exception;

    public void userInvalidate() throws Exception;

    public String getSid() throws Exception;

    public String getSecureSid() throws Exception;

    public String getDataSet(TaskRS taskRS) throws Exception;

    public void login(String user, String password) throws Exception;

    public void addTaskComment(TaskCommentDTO comment) throws Exception;

    public List<ProcessInstancesCommentDTO> getCommentsByProcessId(long id, String processId);

    public TaskListWrapper getAllTaskNotCompleted();

}
