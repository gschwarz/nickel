/**
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.integration.console;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import java.util.logging.Level;
import org.drools.SystemEventListenerFactory;
import org.jboss.bpm.console.client.model.TaskRef;
import org.jbpm.task.AccessType;
import org.jbpm.task.Status;
import org.jbpm.task.Task;
import org.jbpm.task.TaskService;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.ContentData;
import org.jbpm.task.service.TaskClient;
import org.jbpm.task.service.local.LocalTaskService;
import org.jbpm.task.service.mina.MinaTaskClientConnector;
import org.jbpm.task.service.mina.MinaTaskClientHandler;
import org.jbpm.task.service.responsehandlers.BlockingGetTaskResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingTaskOperationResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;

import java.sql.*;

public class TaskManagement implements
		org.jboss.bpm.console.server.integration.TaskManagement {

	public static String TASK_SERVICE_STRATEGY = "Mina";
	private final static Logger log = Logger.getLogger(TaskManagement.class.getName()); 

	private String ipAddress = "127.0.0.1";
	private int port = 9123;
	private TaskService service;
	private TaskClient client;
	private Map<String, List<String>> groupListMap = new HashMap<String, List<String>>();

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/bpm_db";
	static final String USER = "root";
	static final String PASS = "rhiscom";

	public void setConnection(String ipAddress, int port) {
		this.ipAddress = ipAddress;
		this.port = port;
	}

	public void connect() {
		log.log(Level.INFO, "[TaskManagement]:: Connect :"+ client);
		
		if ("Mina".equals(TASK_SERVICE_STRATEGY)) {
			if (client == null) {
				client = new TaskClient(new MinaTaskClientConnector(
						"org.drools.process.workitem.wsht.WSHumanTaskHandler",
						new MinaTaskClientHandler(
								SystemEventListenerFactory
										.getSystemEventListener())));
				boolean connected = client.connect(ipAddress, port);
				if (!connected) {
					throw new IllegalArgumentException(
							"Could not connect task client");
				}
				loadUserGroups();
			}
		} else if ("Local".equals(TASK_SERVICE_STRATEGY)) {
			if (service == null) {
				org.jbpm.task.service.TaskService taskService = HumanTaskService
						.getService();
				service = new LocalTaskService(taskService.createSession());
				loadUserGroups();
			}
		}
		log.log(Level.INFO, "[TaskManagement]:: Connected :"+ client);
	}

	public void reconnect() {
		client=null;
		log.log(Level.INFO, "[TaskManagement]:: reconnect :"+ client);
		connect();
	}
	public void loadUserGroups() {
		Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to a selected database...");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
					
			stmt = conn.createStatement();

			String sqlUser = "SELECT operatorId, user FROM bpm_db.wg_operator";

			ResultSet rs = stmt.executeQuery(sqlUser);

			List<String> listadWorkGroup = new ArrayList<String>();
			List<String> listadoUsuarios = new ArrayList<String>();

			while (rs.next()) {

				String user = rs.getString("user");
				String id = rs.getString("operatorId");
				listadoUsuarios.add(user);

			}

			for (int i = 0; i <= listadoUsuarios.size() - 1; i++) {
				listadWorkGroup = new ArrayList<String>();
				String user = listadoUsuarios.get(i);
			
				String sqlWorkgroup = "select pa_wkgrp.name as workgroup from operator_resolvergroup, wg_operator, pa_wkgrp  where operator_resolvergroup.workGroupId=pa_wkgrp.workGroupId " + 
							" and operator_resolvergroup.operatorId= wg_operator.operatorId and  wg_operator.user='"+ user+"'";
				System.out.println("SQL PARA CONSULTAR WORKGROUPS "
						+ sqlWorkgroup);
				ResultSet rsWorkGroup = stmt.executeQuery(sqlWorkgroup);

				while (rsWorkGroup.next()) {
					String workgroup = rsWorkGroup.getString("workgroup");
					System.out.println("workgroup: " + workgroup);
					listadWorkGroup.add(workgroup);

				}

				String key = user;
				groupListMap.put(key, listadWorkGroup);

				System.out.println(" MAPA USUARIOS " + groupListMap);
				
				
			}

		
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
	}

	public TaskRef getTaskById(long taskId) {
		log.log(Level.INFO, "[TaskManagement]:: getTaskById :"+ client);
		reconnect();
		loadUserGroups();
		Task task = null;
		if ("Mina".equals(TASK_SERVICE_STRATEGY)) {
			BlockingGetTaskResponseHandler responseHandler = new BlockingGetTaskResponseHandler();
			client.getTask(taskId, responseHandler);
			task = responseHandler.getTask();
		} else if ("Local".equals(TASK_SERVICE_STRATEGY)) {
			task = service.getTask(taskId);
		}
		return Transform.task(task);
	}

	public void assignTask(long taskId, String idRef, String userId) {
		log.log(Level.INFO, "[TaskManagement]:: assignTask :"+ client);
		log.log(Level.INFO, "[TaskManagement]:: assignTask :"+ client);
		log.log(Level.INFO, "[TaskManagement]:: assignTask :"+ client);
		reconnect();
		loadUserGroups();
		if ("Mina".equals(TASK_SERVICE_STRATEGY)) {
			BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
			if (idRef == null) {
				client.release(taskId, userId, responseHandler);
			} else if (idRef.equals(userId)) {
				List<String> roles = groupListMap.get(userId);
				if (roles == null) {
					client.claim(taskId, idRef, responseHandler);
				} else {
					client.claim(taskId, idRef, roles, responseHandler);
				}
			} else {
				client.delegate(taskId, userId, idRef, responseHandler);
			}
			responseHandler.waitTillDone(5000);
		} else if ("Local".equals(TASK_SERVICE_STRATEGY)) {
			if (idRef == null) {
				service.release(taskId, userId);
			} else if (idRef.equals(userId)) {
				List<String> roles = groupListMap.get(userId);
				if (roles == null) {
					service.claim(taskId, idRef);
				} else {
					service.claim(taskId, idRef, roles);
				}
			} else {
				service.delegate(taskId, userId, idRef);
			}
		}
	}

	public void completeTask(long taskId, Map data, String userId) {
		log.log(Level.INFO, "[TaskManagement]:: completeTask :"+ client);
		reconnect();
		loadUserGroups();
		if ("Mina".equals(TASK_SERVICE_STRATEGY)) {
			BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
			client.start(taskId, userId, responseHandler);
			responseHandler.waitTillDone(5000);
		} else if ("Local".equals(TASK_SERVICE_STRATEGY)) {
			service.start(taskId, userId);
		}
		ContentData contentData = null;
		if (data != null) {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out;
			try {
				out = new ObjectOutputStream(bos);
				out.writeObject(data);
				out.close();
				contentData = new ContentData();
				contentData.setContent(bos.toByteArray());
				contentData.setAccessType(AccessType.Inline);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ("Mina".equals(TASK_SERVICE_STRATEGY)) {
			BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
			client.complete(taskId, userId, contentData, responseHandler);
			responseHandler.waitTillDone(5000);
		} else if ("Local".equals(TASK_SERVICE_STRATEGY)) {
			service.complete(taskId, userId, contentData);
		}
	}

	@SuppressWarnings("unchecked")
	public void completeTask(long taskId, String outcome, Map data,
			String userId) {
		loadUserGroups();
		data.put("outcome", outcome);
		completeTask(taskId, data, userId);
	}

	public void releaseTask(long taskId, String userId) {
		// TODO: this method is not being invoked, it's using
		// assignTask with null parameter instead
		reconnect();
		loadUserGroups();
		if ("Mina".equals(TASK_SERVICE_STRATEGY)) {
			BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
			client.release(taskId, userId, responseHandler);
			responseHandler.waitTillDone(5000);
		} else if ("Local".equals(TASK_SERVICE_STRATEGY)) {
			service.release(taskId, userId);
		}
	}

	public List<TaskRef> getAssignedTasks(String idRef) {
		log.log(Level.INFO, "[TaskManagement]:: getAssignedTasks :"+ client);
		reconnect();
		loadUserGroups();
		List<TaskRef> result = new ArrayList<TaskRef>();
		try {
			List<TaskSummary> tasks = null;
			if ("Mina".equals(TASK_SERVICE_STRATEGY)) {
				BlockingTaskSummaryResponseHandler responseHandler = new BlockingTaskSummaryResponseHandler();
				client.getTasksOwned(idRef, "es_CL", responseHandler);
				tasks = responseHandler.getResults();
			} else if ("Local".equals(TASK_SERVICE_STRATEGY)) {
				tasks = service.getTasksOwned(idRef, "es_CL");
			}
			for (TaskSummary task : tasks) {
				if (task.getStatus() == Status.Reserved) {
					result.add(Transform.task(task));
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return result;
	}

	public List<TaskRef> getUnassignedTasks(String idRef,
			String participationType) {
		log.log(Level.INFO, "[TaskManagement]:: getUnassignedTasks :"+ client);
		reconnect();
		loadUserGroups();
		List<TaskRef> result = new ArrayList<TaskRef>();
		try {
			List<String> roles = groupListMap.get(idRef);
			List<TaskSummary> tasks = null;
			if ("Mina".equals(TASK_SERVICE_STRATEGY)) {
				BlockingTaskSummaryResponseHandler responseHandler = new BlockingTaskSummaryResponseHandler();
				if (roles == null) {
					client.getTasksAssignedAsPotentialOwner(idRef, "es_CL",
							responseHandler);
				} else {
					client.getTasksAssignedAsPotentialOwner(idRef, roles,
							"es_CL", responseHandler);
				}
				tasks = responseHandler.getResults();
			} else if ("Local".equals(TASK_SERVICE_STRATEGY)) {
				if (roles == null) {
					tasks = service.getTasksAssignedAsPotentialOwner(idRef,
							"es_CL");
				} else {
					tasks = service.getTasksAssignedAsPotentialOwner(idRef,
							roles, "es_CL");
				}
			}
			for (TaskSummary task : tasks) {
				result.add(Transform.task(task));
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return result;
	}

}
