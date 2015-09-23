package com.rhiscom.cuadratura.proceso.workitem;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.runtime.KnowledgeRuntime;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;

import com.rhiscom.cuadratura.proceso.manager.BusinessDatesManager;

public class GetBusinessDatesWorkitem  implements WorkItemHandler {

	
	
	private StatefulKnowledgeSession session;
	
	public GetBusinessDatesWorkitem(StatefulKnowledgeSession ksession) {
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
		BusinessDatesManager manager = new BusinessDatesManager();
		List<Date> listadoFechas =manager.getFechas();
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("fechas", listadoFechas);
		session.getWorkItemManager().completeWorkItem(workItem.getId(),result);
		
	}

}