package com.rhiscom.bpm.console.rest.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.rhiscom.bpm.console.server.services.TaskService;
import com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskWrapper;
import com.rhiscom.bpm.console.task.entity.Task;

@Path("/ConsoleServerRestService")
public class ConsoleServerRest {
    private static Logger logger = Logger.getLogger(ConsoleServerRest.class.getName());

    @GET
    @Path("getTaskById/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTaskDetail(@PathParam("taskId") String taskId) {

	return createJsonResponse(getTaskById(taskId));

    }

    private TaskWrapper getTaskById(String taskId) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TaskPersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	try {
	    System.out.println("entityManagerFactory :" + entityManagerFactory);

	    logger.log(Level.INFO, ":: getTaskDetail :: taskId = " + taskId);

	    Task task = entityManager.find(Task.class, taskId);

	    TaskDetailRS taskDetailRS = new TaskDetailRS();

	    taskDetailRS.setActivationTime(task.getActivationTime());
	    taskDetailRS.setAllowedToDelegate(task.getAllowedToDelegate());
	    taskDetailRS.setCreatedOn(task.getCreatedOn());
	    taskDetailRS.setDocumentAccessType(task.getDocumentAccessType());
	    taskDetailRS.setDocumentContentId(task.getDocumentContentId());
	    taskDetailRS.setDocumentType(task.getDocumentType());
	    taskDetailRS.setExpirationTime(task.getExpirationTime());
	    taskDetailRS.setId(task.getId());
	    taskDetailRS.setPriority(task.getPriority());
	    taskDetailRS.setProcessId(task.getProcessId());
	    taskDetailRS.setProcessInstanceId(task.getProcessInstanceId());
	    taskDetailRS.setProcessSessionId(task.getProcessSessionId());

	    TaskWrapper wrapper = new TaskWrapper();
	    wrapper.setTasks(taskDetailRS);

	    return wrapper;

	} catch (Exception e) {
	    logger.log(Level.SEVERE, ":: getTaskDetail :: Error :" + e);

	    return null;

	} finally {

	}
    }

    @GET
    @Path("getAllTaskOpen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTaskOpen() {
	TaskService service = new TaskService();
	return createJsonResponse(service.getAllTaskOpen());
    }

    @GET
    @Path("getTaskByOwner/{owner}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTaskByOwner(@PathParam("owner") String owner) {
	TaskService service = new TaskService();
	return createJsonResponse(service.getTaskByOwnerService(owner));
    }

    private Response createJsonResponse(Object wrapper) {
	Gson gson = GsonFactory.createInstance();
	String json = gson.toJson(wrapper);
	return Response.ok(json).type("application/json").build();
    }
}
