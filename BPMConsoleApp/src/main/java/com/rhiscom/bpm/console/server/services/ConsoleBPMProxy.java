package com.rhiscom.bpm.console.server.services;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rhiscom.bpm.console.server.util.EnumJBPMRestType;
import com.rhiscom.bpm.console.server.util.JBPMRestManagementClient;
import com.rhiscom.bpm.console.shared.model.dto.TaskConsoleDTOWrapper;
import com.rhiscom.bpm.console.shared.model.rs.ActiveNodeInfoRS;
import com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.InstancesRS;
import com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS;
import com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.ProjectsRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskUserRS;
import com.rhiscom.bpm.console.shared.model.rs.UserTaskVO;

/**
 * 
 * @author Pablo Cáceres
 * 
 */
public class ConsoleBPMProxy extends JBPMRestManagementClient {
    private static ProcessDefinitionsRS proc = null;
    private static ConsoleBPMProxy self = null;

    public static ConsoleBPMProxy instance() {
	if (self == null) {
	    self = new ConsoleBPMProxy();
	}
	return self;
    }

    private ConsoleBPMProxy() {
	super();
    }

    public ConsoleBPMProxy(String username, String password) {
	super(username, password);
    }

    // TODO: Arreglar los exceptions
    public ProcessDefinitionsRS getDefinitions() throws Exception {
	try {
	    if (proc == null) {
		String url = super.urlForm("process.management.definitions");
		String json = "";
		json = super.getDataFromRestService(url, EnumJBPMRestType.GET);
		System.out.println(":: RESPUESTA CONSULTA DEFINICIONES : " + json);
		Gson gson = new Gson();
		proc = gson.fromJson(json, ProcessDefinitionsRS.class);
		return proc;
	    } else {
		return proc;
	    }
	} catch (Exception ex) {
	    if (proc == null) {

		String url = super.urlForm("process.management.definitions");
		String json = "";
		json = super.getDataFromRestService(url, EnumJBPMRestType.GET);
		System.out.println(":: RESPUESTA CONSULTA DEFINICIONES : " + json);
		Gson gson = new Gson();
		proc = gson.fromJson(json, ProcessDefinitionsRS.class);
		return proc;
	    } else {
		return proc;
	    }
	}
    }

    public ProcessDefinitionInstancesRS getProcessInstances(DefinitionsRS definitionsRS) throws Exception {
	ProcessDefinitionInstancesRS pi = null;
	String url = super.urlForm("process.management.instances", definitionsRS.getId());
	String json = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	Gson gson = new Gson();
	pi = gson.fromJson(json, ProcessDefinitionInstancesRS.class);
	return pi;
    }

    /**
     * requiere definition id e instanceid
     * 
     * @param instancesRS
     * @return
     * @throws Exception
     */
    public InstancesRS getProcessInstance(InstancesRS instancesRS) throws Exception {
	DefinitionsRS definitionsRS = new DefinitionsRS();
	definitionsRS.setId(instancesRS.getDefinitionId());
	ProcessDefinitionInstancesRS pi = this.getProcessInstances(definitionsRS);
	for (InstancesRS instance : pi.getInstances()) {
	    if (instance.getId().equals(instancesRS.getId())) {
		instancesRS = instance;
	    }
	}
	return instancesRS;
    }

    public void deleteInstance(InstancesRS instance) throws Exception {
	String url = super.urlForm("process.management.delete", instance.getId());
	String json = super.getDataFromRestService(url, EnumJBPMRestType.POST);
	System.out.println(json);
    }

    public InstancesRS startInstace(DefinitionsRS definitionsRS) throws Exception {
	InstancesRS inst;
	String url = super.urlForm("process.management.new_instance", definitionsRS.getId());
	String json = super.getDataFromRestService(url, EnumJBPMRestType.POST);
	Gson gson = new Gson();
	inst = gson.fromJson(json, InstancesRS.class);
	return inst;
    }

    public Collection<ActiveNodeInfoRS> getActiveNodeInfo(InstancesRS instance) throws Exception {
	Collection<ActiveNodeInfoRS> list = null;
	String url = super.urlForm("process.management.activeNodeInfo", instance.getId());
	String json = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	Gson gson = new Gson();
	Type collectionType = new TypeToken<Collection<ActiveNodeInfoRS>>() {
	}.getType();
	list = gson.fromJson(json, collectionType);
	return list;
    }

    public DefinitionsRS getDefinition(DefinitionsRS definition) throws Exception {
	ProcessDefinitionsRS proc = this.getDefinitions();
	Collection<DefinitionsRS> list = proc.getDefinitions();
	for (DefinitionsRS definitionsRS : list) {
	    if (definition.getId().equals(definitionsRS.getId())) {
		definition = definitionsRS;
	    }
	}

	return definition;
    }

    public String getUrlImage(DefinitionsRS definitionsRS) throws Exception {
	String url = super.urlForm("process.management.image", definitionsRS.getId());
	return url;
    }

    public TaskUserRS getListUserTask(UserTaskVO userTaskVO) throws Exception {
	TaskUserRS tu = null;
	String url = super.urlForm("task.list.tasks", userTaskVO.getUsername());
	super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	String json = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	Gson gson = new Gson();
	tu = gson.fromJson(json, TaskUserRS.class);
	return tu;
    }

    /**
     * Metodo que consulta detalle de una tarea
     * 
     * @param userTaskVO
     * @return
     * @throws Exception
     */

    public TaskDetailRS getTaskDetail(String idTask) throws Exception {
	TaskDetailRS tu = null;
	String url = super.urlFormLocal("task.detail.task", idTask);
	// super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	String json = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	Gson gson = new Gson();
	tu = gson.fromJson(json, TaskDetailRS.class);
	return tu;
    }

    public ProjectsRS getAllATNProjects() throws Exception {
	ProjectsRS tu = null;
	String url = super.urlFormLocal("atn.all.plans");
	// super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	String json = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	Gson gson = new Gson();
	tu = gson.fromJson(json, ProjectsRS.class);
	return tu;
    }

    public TaskUserRS getListUnassignedTask(UserTaskVO userTaskVO) throws Exception {
	TaskUserRS tu = null;
	String url = super.urlForm("task.list.participation", userTaskVO.getUsername());
	super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	String json = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	Gson gson = new Gson();
	tu = gson.fromJson(json, TaskUserRS.class);
	return tu;
    }

    /**
     * M�todo que consulta todas las tareas abiertas.
     * 
     * @param userTaskVO
     * @return
     * @throws Exception
     */
    public TaskConsoleDTOWrapper getAllUnassignedTask() throws Exception {
	TaskConsoleDTOWrapper tu = null;
	String url = super.urlFormLocal("task.list.all.open");

	String json = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	Gson gson = new Gson();
	tu = gson.fromJson(json, TaskConsoleDTOWrapper.class);
	return tu;
    }

    /**
     * M�todo que consulta todas las tareas de una persona.
     * 
     * @param userTaskVO
     * @return
     * @throws Exception
     */
    public TaskConsoleDTOWrapper getTaskConsoleDTOByOwner(UserTaskVO userTaskVO) throws Exception {
	TaskConsoleDTOWrapper tu = null;
	String url = super.urlFormLocal("task.by.owner", userTaskVO.getUsername());
	String json = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	Gson gson = new Gson();
	tu = gson.fromJson(json, TaskConsoleDTOWrapper.class);
	return tu;
    }

    public String assignedTask(UserTaskVO userTaskVO, String idTask) throws Exception {
	TaskUserRS tu = null;
	String url = super.urlForm("task.management.asign", idTask, userTaskVO.getUsername());
	super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	String json = super.getDataFromRestService(url, EnumJBPMRestType.POST);
	Gson gson = new Gson();
	tu = gson.fromJson(json, TaskUserRS.class);
	return json;
    }

    /**
     * Requiere username y password y el idTaskRS
     * 
     * @param userTaskVO
     * @return
     * @throws Exception
     */
    public TaskRS getUserTask(UserTaskVO userTaskVO) throws Exception {
	TaskUserRS tu = null;
	TaskRS task = userTaskVO.getTaskRS();
	tu = this.getListUserTask(userTaskVO);
	for (TaskRS iterable_element : tu.getTasks()) {
	    if (iterable_element.getId().equals(task.getId())) {
		task = iterable_element;
	    }
	}
	return task;
    }

    public String getProcessRenderHTML(DefinitionsRS pd, UserTaskVO userTaskVO) throws Exception {

	String url = super.urlForm("form.process.render", pd.getId());

	String html = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	String formTag = StringUtils.substringBetween(html, "<form", ">");
	formTag = "<form" + formTag + ">";
	String formTagFinal = "<input type='hidden' name='_e_pID' value='" + pd.getId() + "' />";
	html = html.replaceAll(formTag, formTagFinal);
	// html = html.replaceAll(formExp, formExp +
	// "<input type='hidden' name='_e_pID' value='"+pd.getId()+"' />");
	return url + "?user=" + userTaskVO.getUsername() + "&password=" + userTaskVO.getPassword();
    }

    public String getTaskRenderHTML(UserTaskVO userTaskVO) throws Exception {
	String taskId = userTaskVO.getTaskRS().getId();
	String url = super.urlForm("form.task.render", taskId);
	super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	String html = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	String formTag = StringUtils.substringBetween(html, "<form", ">");
	formTag = "<form" + formTag + ">";
	String formTagFinal = "<input type='hidden' name='_e_tID' value='" + taskId + "' />";
	html = html.replaceAll(formTag, formTagFinal);
	return url + "?_e_tID=" + taskId + "&user=" + userTaskVO.getUsername() + "&password="
		+ userTaskVO.getPassword();
    }

    public InputStream getTaskRender(UserTaskVO userTaskVO) throws Exception {
	InputStream render = null;
	String url = super.urlForm("form.task.render", userTaskVO.getTaskRS().getId());
	super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	render = super.getBytesFromRestService(url, EnumJBPMRestType.GET);
	return render;
    }

    public String processComplete(DefinitionsRS definitionsRS, UserTaskVO userTaskVO) throws Exception {
	String resp;
	super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	String url = super.urlForm("form.process.complete", definitionsRS.getId());
	resp = super.getDataFromRestService(url, EnumJBPMRestType.MULTIPART);
	System.out.println(resp);
	return resp;
    }

    public String processComplete(DefinitionsRS definitionsRS, Map<String, Object> params, UserTaskVO userTaskVO)
	    throws Exception {
	String resp;

	super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	String url = super.urlForm("form.process.complete", definitionsRS.getId());
	resp = super.getDataFromRestService(url, EnumJBPMRestType.MULTIPART, params);
	System.out.println(resp);
	return resp;
    }

    public String taskComplete(TaskRS taskRS, Map<String, Object> params, UserTaskVO userTaskVO) throws Exception {
	String resp;

	super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	String url = super.urlForm("form.task.complete", taskRS.getId());
	resp = super.getDataFromRestService(url, EnumJBPMRestType.MULTIPART, params);
	System.out.println(resp);
	return resp;
    }

    public String taskComplete(UserTaskVO userTaskVO, Map<String, Object> params) throws Exception {
	String resp;
	super.relogin(userTaskVO.getUsername(), userTaskVO.getPassword());
	String url = super.urlForm("form.task.complete", userTaskVO.getTaskRS().getId());
	resp = super.getDataFromRestService(url, EnumJBPMRestType.MULTIPART, params);
	// this.getSecureSid();
	System.out.println(resp);
	return resp;
    }

    public void userInvalidate() throws Exception {
	String url = super.urlForm("user.management.invalidate");
	super.getDataFromRestService(url, EnumJBPMRestType.POST);
    }

    public String getSid() throws Exception {
	String url = super.urlForm("user.management.sid");
	return super.getDataFromRestService(url, EnumJBPMRestType.GET);
    }

    public String getSecureSid() throws Exception {
	String url = super.urlForm("user.management.secure.sid");
	return super.getDataFromRestService(url, EnumJBPMRestType.GET);
    }

    public String getDataSet(TaskRS taskRS) throws Exception {
	String data = "";
	String url = super.urlForm("process.management.dataset", taskRS.getId());
	data = super.getDataFromRestService(url, EnumJBPMRestType.GET);
	return data;
    }

}