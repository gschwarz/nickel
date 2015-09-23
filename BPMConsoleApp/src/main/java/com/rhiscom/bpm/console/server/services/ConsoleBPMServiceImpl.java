package com.rhiscom.bpm.console.server.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMService;
import com.rhiscom.bpm.console.server.ServerMessageGeneratorServiceImpl;
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

public class ConsoleBPMServiceImpl extends RemoteServiceServlet implements ConsoleBPMService {
    static Logger logger = Logger.getLogger(ConsoleBPMServiceImpl.class.getName());
    private static final long serialVersionUID = 1L;
    ServerMessageGeneratorServiceImpl server = ServerMessageGeneratorServiceImpl.getInstance();
    ConsoleBPMProxy proxy = ConsoleBPMProxy.instance();
    private static ProcessDefinitionsRS definitions = null;

    @Override
    public ProcessDefinitionsRS getDefinitions() throws Exception {
	try {
	    if (definitions == null) {
		definitions = proxy.getDefinitions();
	    }
	    return definitions;
	} catch (Exception ex) {
	    ConsoleBPMProxy proxy = ConsoleBPMProxy.instance();

	    return proxy.getDefinitions();

	}
    }

    @Override
    public List<ProcessInstancesCommentDTO> getCommentsByProcessId(long id, String processId) {
	TaskService service = new TaskService();
	return service.getCommentByProcessInstanceId(id, processId);
    }

    @Override
    public TaskListWrapper getAllTaskNotCompleted() {
	TaskService service = new TaskService();
	TaskListWrapper wrapper = service.getAllTask();
	DefinitionsRS processDefinition;
	TaskListWrapper wrapperResultado = new TaskListWrapper();

	List<TaskDetailRS> taskListResult = new ArrayList<TaskDetailRS>();

	for (int i = 0; i <= wrapper.getTaskList().size() - 1; i++) {

	    TaskDetailRS t = new TaskDetailRS();
	    t = wrapper.getTaskList().get(i);
	    processDefinition = new DefinitionsRS();
	    processDefinition.setId(t.getProcessId());
	    try {
		t.setProcessId(getDefinition(processDefinition).getName());
		taskListResult.add(t);
	    } catch (Exception e) {
		// TODO Auto-generated catch block

	    }

	}
	wrapperResultado.setTaskList(taskListResult);
	return wrapperResultado;

    }

    /**
     * Método que agrega comentario a una tarea que pertenece a una instancia de
     * proceso.
     * 
     * @param comment
     * @throws Exception
     */

    @Override
    public void addTaskComment(TaskCommentDTO comment) throws Exception {
	TaskService service = new TaskService();
	service.addCommentToTask(comment);
    }

    @Override
    public ProcessDefinitionInstancesRS getProcessInstances(DefinitionsRS definitionsRS) throws Exception {
	try {
	    return proxy.getProcessInstances(definitionsRS);
	} catch (Exception ex) {
	    proxy = ConsoleBPMProxy.instance();
	    return proxy.getProcessInstances(definitionsRS);

	}
    }

    @Override
    public InstancesRS getProcessInstance(InstancesRS instancesRS) throws Exception {
	try {
	    return proxy.getProcessInstance(instancesRS);
	} catch (Exception ex) {
	    proxy = ConsoleBPMProxy.instance();
	    return proxy.getProcessInstance(instancesRS);

	}
    }

    @Override
    public void deleteInstance(InstancesRS instance) throws Exception {
	server.sendEvent("START_PROCESS_EVENT");
	proxy.deleteInstance(instance);

    }

    @Override
    public InstancesRS startInstace(DefinitionsRS definitionsRS) throws Exception {
	server.sendEvent("START_PROCESS_EVENT");
	return proxy.startInstace(definitionsRS);
    }

    @Override
    public Collection<ActiveNodeInfoRS> getActiveNodeInfo(InstancesRS instance) throws Exception {

	return proxy.getActiveNodeInfo(instance);
    }

    @Override
    public DefinitionsRS getDefinition(DefinitionsRS definition) throws Exception {

	return proxy.getDefinition(definition);
    }

    @Override
    public String getUrlImage(DefinitionsRS definitionsRS) throws Exception {

	return proxy.getUrlImage(definitionsRS);

    }

    @Override
    public TaskUserRS getListUserTask(UserTaskVO userTaskVO) throws Exception {
	TaskService service = new TaskService();
	logger.log(Level.INFO, "::getListUserTask::");
	TaskUserRS taskUsr = proxy.getListUserTask(userTaskVO);
	logger.log(Level.INFO, "::getListUserTask:: taskUsr =" + taskUsr);

	List<TaskRS> taskList = new ArrayList<TaskRS>(taskUsr.getTasks());
	TaskListWrapper result = null;
	try {
	    result = service.getTaskByOwnerService(userTaskVO.getUsername());
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	logger.log(Level.INFO, "::getListUserTask:: TaskListWrapper =" + result);
	List<TaskDetailRS> taskConsoleList = new ArrayList<TaskDetailRS>(result.getTaskList());
	List<TaskRS> resultadoFinal = new ArrayList<TaskRS>();
	TaskUserRS resultadoWrapper = new TaskUserRS();

	DefinitionsRS processDefinition;

	for (int i = 0; i < taskList.size(); i++) {
	    for (int j = 0; j < taskConsoleList.size(); j++) {
		if (taskList.get(i).getId().compareTo(taskConsoleList.get(j).getId()) == 0) {
		    TaskRS t = taskList.get(i);
		    t.setCreatedOn(taskConsoleList.get(j).getCreatedOn());
		    t.setName(taskConsoleList.get(j).getDescription());
		    processDefinition = new DefinitionsRS();
		    processDefinition.setId(t.getProcessId());
		    t.setProcessId(getDefinition(processDefinition).getName());
		    resultadoFinal.add(t);
		    logger.log(Level.INFO, "::getListUserTask user =" + userTaskVO.getUsername());
		    logger.log(Level.INFO, "::getListUserTask taskId =" + t.getId());

		}
	    }
	}

	Collection<TaskRS> collection = new ArrayList<TaskRS>(resultadoFinal);
	resultadoWrapper.setTasks(collection);
	logger.log(Level.INFO, "::getListUserTask return wrapper =" + resultadoWrapper);
	return resultadoWrapper;
    }

    @Override
    public TaskDetailRS getTaskDetail(String idTask) throws Exception {

	return proxy.getTaskDetail(idTask);
    }

    @Override
    public TaskUserRS getListUnassignedTask(UserTaskVO userTaskVO) throws Exception {

	TaskService service = new TaskService();
	TaskUserRS taskRs = new TaskUserRS();
	TaskUserRS resultadoWrapper = new TaskUserRS();
	List<TaskRS> resultadoFinal = new ArrayList<TaskRS>();
	taskRs = proxy.getListUnassignedTask(userTaskVO);
	TaskListWrapper result = service.getAllTaskOpen();
	List<TaskRS> taskList = new ArrayList<TaskRS>(taskRs.getTasks());
	List<TaskDetailRS> taskConsoleList = new ArrayList<TaskDetailRS>(result.getTaskList());
	DefinitionsRS processDefinition;

	for (int i = 0; i < taskList.size(); i++) {
	    for (int j = 0; j < taskConsoleList.size(); j++) {

		if (taskList.get(i).getId().compareTo(taskConsoleList.get(j).getId()) == 0) {
		    TaskRS t = taskList.get(i);
		    t.setCreatedOn(taskConsoleList.get(j).getCreatedOn());
		    t.setName(taskConsoleList.get(j).getDescription());

		    processDefinition = new DefinitionsRS();
		    processDefinition.setId(t.getProcessId());
		    t.setProcessId(getDefinition(processDefinition).getName());
		    resultadoFinal.add(t);
		}
	    }
	}
	Collection<TaskRS> collection = new ArrayList<TaskRS>(resultadoFinal);
	resultadoWrapper.setTasks(collection);

	return resultadoWrapper;
    }

    @Override
    public String assignedTask(UserTaskVO userTaskVO, String idTask) throws Exception {

	return proxy.assignedTask(userTaskVO, idTask);
    }

    @Override
    public TaskRS getUserTask(UserTaskVO userTaskVO) throws Exception {

	return proxy.getUserTask(userTaskVO);
    }

    @Override
    public String getProcessRenderHTML(DefinitionsRS pd, UserTaskVO userTaskVO) throws Exception {

	return proxy.getProcessRenderHTML(pd, userTaskVO);
    }

    @Override
    public String getTaskRenderHTML(UserTaskVO userTaskVO) throws Exception {

	return proxy.getTaskRenderHTML(userTaskVO);
    }

    @Override
    public String processComplete(DefinitionsRS definitionsRS, UserTaskVO userTaskVO) throws Exception {
	server.sendEvent("START_PROCESS_EVENT");
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	return proxy.processComplete(definitionsRS, userTaskVO);
    }

    @Override
    public String processComplete(DefinitionsRS definitionsRS, Map<String, Object> params, UserTaskVO userTaskVO)
	    throws Exception {
	server.sendEvent("START_PROCESS_EVENT");

	return proxy.processComplete(definitionsRS, params, userTaskVO);
    }

    @Override
    public String taskComplete(TaskRS taskRS, Map<String, Object> params, UserTaskVO userTaskVO) throws Exception {

	return proxy.taskComplete(taskRS, params, userTaskVO);
    }

    @Override
    public String taskComplete(UserTaskVO userTaskVO, Map<String, Object> params) throws Exception {

	return proxy.taskComplete(userTaskVO, params);
    }

    @Override
    public void userInvalidate() throws Exception {

	proxy.userInvalidate();

    }

    @Override
    public String getSid() throws Exception {

	return proxy.getSid();
    }

    @Override
    public String getSecureSid() throws Exception {

	return proxy.getSecureSid();
    }

    @Override
    public String getDataSet(TaskRS taskRS) throws Exception {

	return proxy.getDataSet(taskRS);
    }

    public void login(String user, String password) {

	proxy.login(user, password);
    }

}
