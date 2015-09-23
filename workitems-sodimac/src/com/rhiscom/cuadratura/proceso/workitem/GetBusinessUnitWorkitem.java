package com.rhiscom.cuadratura.proceso.workitem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.runtime.KnowledgeRuntime;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;

import com.rhiscom.cuadratura.proceso.manager.BusinessUnitManager;

public class GetBusinessUnitWorkitem  implements WorkItemHandler {

	
	
	private StatefulKnowledgeSession session;
	
	public GetBusinessUnitWorkitem(StatefulKnowledgeSession ksession) {
		session =ksession;
	}

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {

	}

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager arg1) {
		
		
		
		ExecuteWorkItemThread mailThread = new ExecuteWorkItemThread(session, workItem);
		Thread hilo = new Thread(mailThread);
		hilo.start();
		
		
		
	}
	
	class ExecuteWorkItemThread implements Runnable {
		Map<String, Object> resultado;
		KnowledgeRuntime session;
		WorkItem workItem;

		public ExecuteWorkItemThread(KnowledgeRuntime session2, WorkItem workItem2) {
			session = session2;
			workItem = workItem2;
		}

		@Override
		public void run() {
			execute(workItem);
			
		}
		
	}
	
	private void execute(WorkItem workItem) {
		BusinessUnitManager manager = new BusinessUnitManager();
		List<String> listadoSucursales =manager.getSucursales();
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("sucursales", listadoSucursales);
		session.getWorkItemManager().completeWorkItem(workItem.getId(),result);
		
	}

}
