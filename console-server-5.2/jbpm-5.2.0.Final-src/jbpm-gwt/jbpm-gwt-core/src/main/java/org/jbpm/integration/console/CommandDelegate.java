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

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.WorkingMemory;
import org.drools.agent.KnowledgeAgent;
import org.drools.agent.KnowledgeAgentConfiguration;
import org.drools.agent.KnowledgeAgentFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.command.Context;
import org.drools.command.impl.CommandBasedStatefulKnowledgeSession;
import org.drools.command.impl.GenericCommand;
import org.drools.command.impl.KnowledgeCommandContext;
import org.drools.compiler.BPMN2ProcessFactory;
import org.drools.compiler.ProcessBuilderFactory;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.process.Process;
import org.drools.event.ActivationCancelledEvent;
import org.drools.event.ActivationCreatedEvent;
import org.drools.event.AfterActivationFiredEvent;
import org.drools.event.AgendaGroupPoppedEvent;
import org.drools.event.AgendaGroupPushedEvent;
import org.drools.event.BeforeActivationFiredEvent;
import org.drools.event.RuleFlowGroupActivatedEvent;
import org.drools.event.RuleFlowGroupDeactivatedEvent;
import org.drools.event.process.DefaultProcessEventListener;
import org.drools.event.process.ProcessCompletedEvent;
import org.drools.event.process.ProcessStartedEvent;
import org.drools.event.rule.AgendaEventListener;
import org.drools.event.rule.DefaultAgendaEventListener;

import org.drools.impl.StatefulKnowledgeSessionImpl;
import org.drools.io.ResourceChangeScannerConfiguration;
import org.drools.io.ResourceFactory;
import org.drools.marshalling.impl.ProcessMarshallerFactory;
import org.drools.persistence.jpa.JPAKnowledgeService;
import org.drools.runtime.Environment;
import org.drools.runtime.EnvironmentName;
import org.drools.runtime.KnowledgeSessionConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.drools.runtime.process.ProcessRuntimeFactory;
import org.jbpm.bpmn2.BPMN2ProcessProviderImpl;
import org.jbpm.integration.console.shared.GuvnorConnectionUtils;
import org.jbpm.marshalling.impl.ProcessMarshallerFactoryServiceImpl;
import org.jbpm.process.audit.ProcessInstanceDbLog;
import org.jbpm.process.audit.ProcessInstanceLog;
import org.jbpm.process.audit.WorkingMemoryDbLogger;
import org.jbpm.process.builder.ProcessBuilderFactoryServiceImpl;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.process.instance.ProcessRuntimeFactoryServiceImpl;
import org.jbpm.process.instance.context.variable.VariableScopeInstance;
import org.jbpm.process.workitem.wsht.CommandBasedWSHumanTaskHandler;
import org.jbpm.process.workitem.wsht.SyncWSHumanTaskHandler;
import org.jbpm.task.service.TaskService;
import org.jbpm.task.service.local.LocalTaskService;
import org.jbpm.workflow.instance.impl.WorkflowProcessInstanceImpl;

import com.rhiscom.cuadratura.files.workitem.GetFromARQGMWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromCRCMRWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromLDTAWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromPLCUAWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromPLCWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromPLDTFWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromPLDWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromPLGCWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromPSCREWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromPSDEBWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromPSTFPWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromPVGCWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromRSATWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromSATWorkItemHandler;
import com.rhiscom.cuadratura.files.workitem.GetFromSCTFAWorkItemHandler;
import com.rhiscom.cuadratura.net.workitem.ReadFileFTPWorkItem;
import com.rhiscom.cuadratura.net.workitem.notification.SendEmailWorkItem;
import com.rhiscom.cuadratura.proceso.workitem.CuadraturaActivacionGiftCardWorkItem;
import com.rhiscom.cuadratura.proceso.workitem.CuadraturaAvanceSuperAvanceWorkItem;
import com.rhiscom.cuadratura.proceso.workitem.CuadraturaNotaDeCreditoWorkItem;
import com.rhiscom.cuadratura.proceso.workitem.CuadraturaPagosCRMWorkitem;
import com.rhiscom.cuadratura.proceso.workitem.CuadraturaTarjetaDeCreditoWorkItem;
import com.rhiscom.cuadratura.proceso.workitem.CuadraturaTarjetaDebitoWorkItem;
import com.rhiscom.cuadratura.proceso.workitem.CuadraturaVentaGiftCardWorkItem;
import com.rhiscom.cuadratura.proceso.workitem.CuadraturaVtaCMRWorkItem;
import com.rhiscom.cuadratura.proceso.workitem.GetBusinessDatesWorkitem;
import com.rhiscom.cuadratura.proceso.workitem.GetBusinessUnitWorkitem;
import com.rhiscom.cuadratura.proceso.workitem.NeteoRSATWorkitem;
import com.rhiscom.cuadratura.proceso.workitem.NeteoSATWorkitem;


public class CommandDelegate {
	private static final Logger logger = Logger.getLogger(CommandDelegate.class.getName());

	private static StatefulKnowledgeSession ksession;

	public CommandDelegate() {
		getSession();
	}

	private StatefulKnowledgeSession newStatefulKnowledgeSession() {
		try {
			KnowledgeBase kbase = null;
			Properties jbpmconsoleproperties = new Properties();
			try {
				jbpmconsoleproperties.load(CommandDelegate.class.getResourceAsStream("/jbpm.console.properties"));
			} catch (IOException e) {
				throw new RuntimeException("Could not load jbpm.console.properties", e);
			}
			GuvnorConnectionUtils guvnorUtils = new GuvnorConnectionUtils();
			if (guvnorUtils.guvnorExists()) {
				try {
					ResourceChangeScannerConfiguration sconf = ResourceFactory.getResourceChangeScannerService()
							.newResourceChangeScannerConfiguration();
					sconf.setProperty("drools.resource.scanner.interval", "10");
					ResourceFactory.getResourceChangeScannerService().configure(sconf);
					ResourceFactory.getResourceChangeScannerService().start();
					ResourceFactory.getResourceChangeNotifierService().start();
					KnowledgeAgentConfiguration aconf = KnowledgeAgentFactory.newKnowledgeAgentConfiguration();
					aconf.setProperty("drools.agent.newInstance", "false");
					KnowledgeAgent kagent = KnowledgeAgentFactory.newKnowledgeAgent("Guvnor default", aconf);
					kagent.applyChangeSet(ResourceFactory.newReaderResource(guvnorUtils.createChangeSet()));
					kbase = kagent.getKnowledgeBase();
				} catch (Throwable t) {
					logger.info("Could not load processes from Guvnor: " + t.getMessage());
				}
			} else {
				logger.info("Could not connect to Guvnor.");
			}
			if (kbase == null) {
				kbase = KnowledgeBaseFactory.newKnowledgeBase();
			}

			String directory = System.getProperty("jbpm.console.directory") == null ? jbpmconsoleproperties
					.getProperty("jbpm.console.directory") : System.getProperty("jbpm.console.directory");
			if (directory == null || directory.length() < 1) {
				logger.info("jbpm.console.directory property not found");
			} else {
				File file = new File(directory);
				if (!file.exists()) {
					throw new IllegalArgumentException("Could not find " + directory);
				}
				if (!file.isDirectory()) {
					throw new IllegalArgumentException(directory + " is not a directory");
				}
				ProcessBuilderFactory.setProcessBuilderFactoryService(new ProcessBuilderFactoryServiceImpl());
				ProcessMarshallerFactory
						.setProcessMarshallerFactoryService(new ProcessMarshallerFactoryServiceImpl());
				ProcessRuntimeFactory.setProcessRuntimeFactoryService(new ProcessRuntimeFactoryServiceImpl());
				BPMN2ProcessFactory.setBPMN2ProcessProvider(new BPMN2ProcessProviderImpl());
				KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
				for (File subfile : file.listFiles(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.endsWith(".bpmn") || name.endsWith("bpmn2");
					}
				})) {
					logger.info("Loading process from file system: " + subfile.getName());
					kbuilder.add(ResourceFactory.newFileResource(subfile), ResourceType.BPMN2);
				}
				kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
			}
			StatefulKnowledgeSession ksession = null;
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.jbpm.persistence.jpa");
			Environment env = KnowledgeBaseFactory.newEnvironment();
			env.set(EnvironmentName.ENTITY_MANAGER_FACTORY, emf);
			Properties sessionconfigproperties = new Properties();
			sessionconfigproperties.put("drools.processInstanceManagerFactory",
					"org.jbpm.persistence.processinstance.JPAProcessInstanceManagerFactory");
			sessionconfigproperties.put("drools.processSignalManagerFactory",
					"org.jbpm.persistence.processinstance.JPASignalManagerFactory");
			KnowledgeSessionConfiguration config = KnowledgeBaseFactory
					.newKnowledgeSessionConfiguration(sessionconfigproperties);
			try {
				logger.info("Loading session data ...");
				ksession = JPAKnowledgeService.loadStatefulKnowledgeSession(1, kbase, config, env);
			} catch (RuntimeException e) {
				logger.info("Error loading session data: " + e.getMessage());
				if (e instanceof IllegalStateException) {
					Throwable cause = ((IllegalStateException) e).getCause();
					if (cause instanceof InvocationTargetException) {
						cause = cause.getCause();
						if (cause != null && "Could not find session data for id 1".equals(cause.getMessage())) {
							logger.info("Creating new session data ...");
							env = KnowledgeBaseFactory.newEnvironment();
							env.set(EnvironmentName.ENTITY_MANAGER_FACTORY, emf);
							ksession = JPAKnowledgeService.newStatefulKnowledgeSession(kbase, config, env);
						} else {
							logger.info("Error loading session data: " + cause);
							throw e;
						}
					} else {
						logger.info("Error loading session data: " + cause);
						throw e;
					}
				} else {
					logger.info("Error loading session data: " + e.getMessage());
					throw e;
				}
			}
			new WorkingMemoryDbLogger(ksession);

			logger.info("***  ");
			logger.info("*** INICIO Creacion WORKITEMS **** ");
			logger.info("***  ");

			try {

				/**
				 * Aca va el código de creación de los workitems.
				 */
				
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromPLCUA", new GetFromPLCUAWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromCRCMR", new GetFromCRCMRWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromLDTA", new GetFromLDTAWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromPLDTF", new GetFromPLDTFWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromSCTFA", new GetFromSCTFAWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromPLC", new GetFromPLCWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromPLD", new GetFromPLDWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromPLGC", new GetFromPLGCWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromPVGC", new GetFromPVGCWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromPSTFP", new GetFromPSTFPWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromPSCRE", new GetFromPSCREWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromPSDEB", new GetFromPSDEBWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromARQGM", new GetFromARQGMWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFileFTPWorkItem", new ReadFileFTPWorkItem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("CuadraturaActGiftCard", new CuadraturaActivacionGiftCardWorkItem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("CuadraturaVtaCMR", new CuadraturaVtaCMRWorkItem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("GetBusinessUnitWorkitem", new GetBusinessUnitWorkitem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("CuadraturaVentaGiftCardWorkItem", new CuadraturaVentaGiftCardWorkItem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("CuadraturaAvanceSuperAvance", new CuadraturaAvanceSuperAvanceWorkItem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("CuadraturaPagosCMR", new CuadraturaPagosCRMWorkitem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("CuadraturaTarjetaCredito", new CuadraturaTarjetaDeCreditoWorkItem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("CuadraturaTarjetaDebito", new CuadraturaTarjetaDebitoWorkItem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("CuadraturaNotaDeCreditoWorkItem", new CuadraturaNotaDeCreditoWorkItem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("SendEmailWorkItem", new SendEmailWorkItem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromRSAT", new GetFromRSATWorkItemHandler(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("ReadFromSAT", new GetFromSATWorkItemHandler(ksession));
				//Agregado 06-03-2014
				ksession.getWorkItemManager().registerWorkItemHandler("GetBusinessDatesWorkitem", new GetBusinessDatesWorkitem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("NeteoRSATWorkitem", new NeteoRSATWorkitem(ksession));
				ksession.getWorkItemManager().registerWorkItemHandler("NeteoSATWorkitem", new NeteoSATWorkitem(ksession));
				
				logger.info("*** KSESSION Creada  **** " + ksession);

			} catch (Exception ex) {
				
				logger.info("*** ERROR Creacion :**** " + ex.toString());
			}

			

			ksession.addEventListener(new DefaultProcessEventListener() {

				@Override
				public void beforeProcessStarted(ProcessStartedEvent event) {
					System.out.println(" >>> Before Process Started: "
							+ event.getProcessInstance().getProcessName());
					((StatefulKnowledgeSession) event.getKnowledgeRuntime()).fireAllRules();
					PersistProcessEventManager.insertProcess(event.getProcessInstance().getId(), event
							.getProcessInstance().getProcessId(), event.getProcessInstance().getProcessName(), 1);
					logger.info("Inicio de proceso :" + event.getProcessInstance().getProcessId());

				}

				@Override
				public void afterProcessCompleted(ProcessCompletedEvent event) {
					System.out.println(" >>> After Process Completed: "
							+ event.getProcessInstance().getProcessName());
					((StatefulKnowledgeSession) event.getKnowledgeRuntime()).fireAllRules();

					PersistProcessEventManager.endProcess(event.getProcessInstance().getId(), 2);
					logger.info("Termino de proceso :" + event.getProcessInstance().getProcessId());

				}

				@Override
				public void beforeNodeLeft(org.drools.event.process.ProcessNodeLeftEvent event) {
					System.out.println(" >>> Before Node Left: " + event.getNodeInstance().getNodeName());
					((StatefulKnowledgeSession) event.getKnowledgeRuntime()).fireAllRules();
				}
			});

			return ksession;
		} catch (Throwable t) {
			throw new RuntimeException("Could not initialize stateful knowledge session: " + t.getMessage(), t);
		}
	}

	private StatefulKnowledgeSession getSession() {
		if (ksession == null) {
			ksession = newStatefulKnowledgeSession();
		}
		return ksession;
	}

	public List<Process> getProcesses() {
		List<Process> result = new ArrayList<Process>();
		for (KnowledgePackage kpackage : getSession().getKnowledgeBase().getKnowledgePackages()) {
			result.addAll(kpackage.getProcesses());
		}
		return result;
	}

	public Process getProcess(String processId) {
		for (KnowledgePackage kpackage : getSession().getKnowledgeBase().getKnowledgePackages()) {
			for (Process process : kpackage.getProcesses()) {
				if (processId.equals(process.getId())) {
					return process;
				}
			}
		}
		return null;
	}

	public Process getProcessByName(String name) {
		for (KnowledgePackage kpackage : getSession().getKnowledgeBase().getKnowledgePackages()) {
			for (Process process : kpackage.getProcesses()) {
				if (name.equals(process.getName())) {
					return process;
				}
			}
		}
		return null;
	}

	public void removeProcess(String processId) {
		throw new UnsupportedOperationException();
	}

	public ProcessInstanceLog getProcessInstanceLog(String processInstanceId) {
		return ProcessInstanceDbLog.findProcessInstance(new Long(processInstanceId));
	}

	public List<ProcessInstanceLog> getProcessInstanceLogsByProcessId(String processId) {
		return ProcessInstanceDbLog.findProcessInstances(processId);
	}

	public List<ProcessInstanceLog> getActiveProcessInstanceLogsByProcessId(String processId) {
		return ProcessInstanceDbLog.findActiveProcessInstances(processId);
	}

	public ProcessInstanceLog startProcess(String processId, Map<String, Object> parameters) {
		long processInstanceId = ksession.startProcess(processId, parameters).getId();
		ksession.fireAllRules();
		return ProcessInstanceDbLog.findProcessInstance(processInstanceId);
	}

	public void abortProcessInstance(String processInstanceId) {
		ProcessInstance processInstance = ksession.getProcessInstance(new Long(processInstanceId));
		if (processInstance != null) {
			ksession.abortProcessInstance(new Long(processInstanceId));
		} else {

		}

		logger.info("Aborto de proceso :" + processInstanceId);

		PersistProcessEventManager.endProcess(Integer.valueOf(processInstanceId).intValue(), 3);

	}

	public Map<String, Object> getProcessInstanceVariables(String processInstanceId) {
		ProcessInstance processInstance = ksession.getProcessInstance(new Long(processInstanceId));
		if (processInstance != null) {
			Map<String, Object> variables = ((WorkflowProcessInstanceImpl) processInstance).getVariables();
			if (variables == null) {
				return new HashMap<String, Object>();
			}
			// filter out null values
			Map<String, Object> result = new HashMap<String, Object>();
			for (Map.Entry<String, Object> entry : variables.entrySet()) {
				if (entry.getValue() != null) {
					result.put(entry.getKey(), entry.getValue());
				}
			}
			return result;
		} else {
			throw new IllegalArgumentException("Could not find process instance " + processInstanceId);
		}
	}

	/**
	 * This method the variables provided in the map to the instance. NOTE: the
	 * map will be added not replaced
	 * 
	 * @param processInstanceId
	 * @param variables
	 */
	public void setProcessInstanceVariables(final String processInstanceId, final Map<String, Object> variables) {
		((CommandBasedStatefulKnowledgeSession) ksession).getCommandService().execute(new GenericCommand<Void>() {
			public Void execute(Context context) {
				StatefulKnowledgeSession ksession = ((KnowledgeCommandContext) context)
						.getStatefulKnowledgesession();
				ProcessInstance processInstance = ksession.getProcessInstance(new Long(processInstanceId));
				if (processInstance != null) {
					VariableScopeInstance variableScope = (VariableScopeInstance) ((org.jbpm.process.instance.ProcessInstance) processInstance)
							.getContextInstance(VariableScope.VARIABLE_SCOPE);
					if (variableScope == null) {
						throw new IllegalArgumentException("Could not find variable scope for process instance "
								+ processInstanceId);
					}
					for (Map.Entry<String, Object> entry : variables.entrySet()) {
						variableScope.setVariable(entry.getKey(), entry.getValue());
					}
				} else {
					throw new IllegalArgumentException("Could not find process instance " + processInstanceId);
				}
				return null;
			}

		});
	}

	public void signalExecution(String executionId, String signal) {
		ksession.getProcessInstance(new Long(executionId)).signalEvent("signal", signal);
	}

}
