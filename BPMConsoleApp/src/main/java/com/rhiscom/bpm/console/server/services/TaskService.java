package com.rhiscom.bpm.console.server.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.bpm.console.rest.services.ConsoleServerRest;
import com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO;
import com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO;
import com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper;
import com.rhiscom.bpm.console.task.entity.I18ntext;
import com.rhiscom.bpm.console.task.entity.Organizationalentity;
import com.rhiscom.bpm.console.task.entity.Task;
import com.rhiscom.bpm.console.task.entity.TaskComment;

public class TaskService {
    private static Logger logger = Logger.getLogger(ConsoleServerRest.class.getName());

    public TaskListWrapper getAllTask() {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TaskPersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	try {
	    logger.log(Level.INFO, "::getAllTask::");

	    String query = "SELECT tsk FROM Task tsk where tsk.status<>'Completed'";

	    Query q = entityManager.createQuery(query);
	    @SuppressWarnings("unchecked")
	    List<Task> resultList = q.getResultList();
	    List<TaskDetailRS> resultTaskList = new ArrayList<TaskDetailRS>();
	    Task task = new Task();

	    TaskDetailRS taskDetailRS = new TaskDetailRS();

	    for (int i = 0; i <= resultList.size() - 1; i++) {
		task = resultList.get(i);
		String queryI18Text = "SELECT i18n FROM I18ntext i18n where i18n.task1.id='" + task.getId()
			+ "' and language='es_CL'";
		Query qi18n = entityManager.createQuery(queryI18Text);
		I18ntext i18n = null;
		List<I18ntext> i18nList = qi18n.getResultList();
		if (i18nList.size() > 0)
		    i18n = i18nList.get(0);
		taskDetailRS = new TaskDetailRS();
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
		if (i18n != null)
		    taskDetailRS.setDescription(i18n.getText());
		if (task.getOrganizationalentity2() != null)
		    taskDetailRS.setOwner(task.getOrganizationalentity2().getId());
		taskDetailRS.setStatus(task.getStatus());
		resultTaskList.add(taskDetailRS);

	    }
	    TaskListWrapper wrapper = new TaskListWrapper();
	    wrapper.setTaskList(resultTaskList);
	    logger.log(Level.INFO, "[::getAllTask::] Return");
	    return wrapper;

	} catch (Exception e) {
	    logger.log(Level.SEVERE, "::getAllTaskOpenService:: Error: " + e);

	    return null;

	} finally {

	}
    }

    /**
     * Método que retorna tareas no asignadas y abiertas
     * 
     * @return
     */
    public TaskListWrapper getAllTaskOpen() {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TaskPersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	try {
	    logger.log(Level.INFO, "::getAllTaskOpenService::");

	    String query = "SELECT tsk FROM Task tsk where  tsk.status<>'Completed'";
	    Query q = entityManager.createQuery(query);
	    @SuppressWarnings("unchecked")
	    List<Task> resultList = q.getResultList();
	    List<TaskDetailRS> resultTaskList = new ArrayList<TaskDetailRS>();

	    System.out.println("List :" + resultList);

	    Task task = new Task();

	    TaskDetailRS taskDetailRS = new TaskDetailRS();

	    for (int i = 0; i <= resultList.size() - 1; i++) {
		task = resultList.get(i);

		if (task.getOrganizationalentity2() == null) {
		    String queryI18Text = "SELECT i18n FROM I18ntext i18n where i18n.task1.id='" + task.getId()
			    + "' and language='es_CL'";
		    Query qi18n = entityManager.createQuery(queryI18Text);
		    List<I18ntext> i18nList = qi18n.getResultList();
		    I18ntext i18n = null;
		    if (i18nList.size() > 0)
			i18n = i18nList.get(0);

		    taskDetailRS = new TaskDetailRS();
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
		    if (i18n != null)
			taskDetailRS.setDescription(i18n.getText());
		    if (task.getOrganizationalentity2() != null)
			taskDetailRS.setOwner(task.getOrganizationalentity2().getId());
		    resultTaskList.add(taskDetailRS);
		}
	    }
	    TaskListWrapper wrapper = new TaskListWrapper();
	    wrapper.setTaskList(resultTaskList);

	    return wrapper;

	} catch (Exception e) {
	    logger.log(Level.SEVERE, "::getAllTaskOpenService:: Error: " + e);

	    return null;

	} finally {

	}
    }

    public TaskListWrapper getTaskByOwnerService(String owner) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TaskPersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	try {

	    String query = "SELECT tsk FROM Task tsk where tsk.organizationalentity2 ='" + owner
		    + "' and tsk.status <> 'Completed'";
	    Query q = entityManager.createQuery(query);
	    List<Task> resultList = q.getResultList();
	    logger.log(Level.INFO, ":: getTaskByOwner ::Owner = " + owner);
	    logger.log(Level.INFO, ":: getTaskByOwner :: result list size = " + resultList.size());
	    List<TaskDetailRS> resultTaskList = new ArrayList<TaskDetailRS>();

	    Task task = new Task();

	    TaskDetailRS taskDetailRS = new TaskDetailRS();

	    for (int i = 0; i <= resultList.size() - 1; i++) {
		task = resultList.get(i);

		if (task.getOrganizationalentity2() != null) {
		    String queryI18Text = "SELECT i18n FROM I18ntext i18n where i18n.task1.id='" + task.getId()
			    + "' and language='es_CL' ";
		    Query qi18n = entityManager.createQuery(queryI18Text);
		    List<I18ntext> i18nList = qi18n.getResultList();
		    I18ntext i18n = null;
		    if (i18nList.size() > 0)
			i18n = i18nList.get(0);
		    taskDetailRS = new TaskDetailRS();
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
		    if (i18n != null)
			taskDetailRS.setDescription(i18n.getText());

		    taskDetailRS.setOwner(owner);
		    resultTaskList.add(taskDetailRS);
		}
	    }
	    TaskListWrapper wrapper = new TaskListWrapper();
	    wrapper.setTaskList(resultTaskList);
	    logger.log(Level.INFO, ":: getTaskByOwner :: return wrapper  = " + wrapper);
	    return wrapper;

	} catch (Exception e) {
	    logger.log(Level.SEVERE, "::getTaskByOwnerService:: Error: " + e);

	    return null;

	} finally {

	}
    }

    public void addCommentToTask(TaskCommentDTO comment) throws Exception {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TaskPersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	Task task = entityManager.find(Task.class, comment.getTaskId());
	String query = "Select o from Organizationalentity o where o.id='" + comment.getUser() + "'";
	Query q = entityManager.createQuery(query);

	List<Organizationalentity> userList = q.getResultList();
	Organizationalentity user = null;
	if (userList.size() > 0) {
	    user = userList.get(0);
	}

	TaskComment taskComment = new TaskComment();
	taskComment.setAddedAt(new Date());
	taskComment.setOrganizationalentity(user);
	taskComment.setTask(task);
	taskComment.setText(comment.getText());

	try {
	    entityManager.getTransaction().begin();
	    entityManager.persist(taskComment);
	    entityManager.getTransaction().commit();

	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();
	    throw new Exception(e);

	} catch (Exception ex) {
	    ex.printStackTrace();
	    entityManager.getTransaction().rollback();
	    throw new Exception(ex);
	} finally {

	}

    }

    public List<ProcessInstancesCommentDTO> getCommentByProcessInstanceId(Long id, String processId) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TaskPersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	List<ProcessInstancesCommentDTO> result = null;

	Query qTask = entityManager
		.createQuery("Select tsk From Task tsk, TaskComment com where tsk.processInstanceId='" + id
			+ "' and tsk.processId='" + processId + "'and tsk.id=com.task.id");

	Map<Integer, List<ProcessInstancesCommentDTO>> hashResult = new HashMap<Integer, List<ProcessInstancesCommentDTO>>();

	List<Task> resultList = qTask.getResultList();
	ProcessInstancesCommentDTO commentDTO = new ProcessInstancesCommentDTO();
	if (resultList.size() > 0) {

	    for (int i = 0; i < resultList.size(); i++) {
		result = new ArrayList<ProcessInstancesCommentDTO>();
		TaskComment taskComment = null;
		commentDTO = new ProcessInstancesCommentDTO();

		Query qComment = entityManager
			.createQuery("Select comment From TaskComment comment where comment.task.id='"
				+ resultList.get(i).getId() + "'");

		List<TaskComment> commentList = qComment.getResultList();

		for (int j = 0; j <= commentList.size() - 1; j++) {
		    commentDTO = new ProcessInstancesCommentDTO();
		    taskComment = new TaskComment();
		    taskComment.setText(resultList.get(i).getTaskComments().get(j).getText());
		    taskComment.setAddedAt(resultList.get(i).getTaskComments().get(j).getAddedAt());
		    commentDTO.setComment(taskComment.getText());
		    commentDTO.setCreateDate(taskComment.getAddedAt());
		    commentDTO.setProcessId(String.valueOf(resultList.get(i).getProcessInstanceId().intValue()));
		    commentDTO.setTaskId(resultList.get(i).getId());
		    commentDTO.setUser(resultList.get(i).getOrganizationalentity2().getId());
		    result.add(commentDTO);

		}
		hashResult.put(new Integer(resultList.get(i).getId()), result);

	    }

	}
	Iterator it = hashResult.entrySet().iterator();
	result = new ArrayList<ProcessInstancesCommentDTO>();
	while (it.hasNext()) {
	    Map.Entry pairs = (Map.Entry) it.next();
	    System.out.println(pairs.getKey() + " = " + pairs.getValue());
	    ArrayList<ProcessInstancesCommentDTO> list = (ArrayList<ProcessInstancesCommentDTO>) pairs.getValue();
	    for (int i = 0; i <= list.size() - 1; i++) {
		result.add(list.get(i));
	    }
	}
	return result;

    }
}
