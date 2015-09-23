package com.rhiscom.cuadratura.proceso.workitem;

import java.text.SimpleDateFormat;

import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;

import com.rhiscom.bpm.rules.CuadraturaEvent;
import com.rhiscom.cuadratura.proceso.manager.CuadraturaVentasCMRManager;

public class CuadraturaVtaCMRWorkItem implements WorkItemHandler {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	private String sucursal;
	private String fechaNegocio;
	private StatefulKnowledgeSession session;
	public CuadraturaVtaCMRWorkItem(StatefulKnowledgeSession ksession) {
		session=ksession;
	}

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		
		sucursal = (String) workItem.getParameter("sucursal");
		fechaNegocio = (String) workItem.getParameter("fechaNegocio");
		
		System.out.println(":: CUADRATURA VTA CMR::");
		CuadraturaVentasCMRManager manager = new CuadraturaVentasCMRManager();
		
		try {
			manager.generarCuadratura(formatter.parse(fechaNegocio), sucursal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			insertEvent("ERROR_CUADRATURA", e.getMessage() ,"CUADRATURA VTA CMR");
		}
		
		workItemManager.completeWorkItem(workItem.getId(), null);
	}
	protected void insertEvent(String type, String message, String source) {

		CuadraturaEvent event = new CuadraturaEvent(type, message, source);
		session.insert(event);
	}
}
