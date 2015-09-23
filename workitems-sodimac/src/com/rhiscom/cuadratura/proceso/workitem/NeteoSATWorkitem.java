package com.rhiscom.cuadratura.proceso.workitem;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;

import com.rhiscom.bpm.rules.CuadraturaEvent;
import com.rhiscom.cuadratura.proceso.manager.NeteoSATManager;

public class NeteoSATWorkitem implements WorkItemHandler {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	private StatefulKnowledgeSession session;

	public NeteoSATWorkitem(StatefulKnowledgeSession ksession) {
		session = ksession;
	}

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		Map<String, Object> parameters = workItem.getParameters();

		String fechaNegocio = (String) parameters.get("Fecha");
		String sucursal = (String) parameters.get("sucursal");

		System.out.println(":: Neteo ::" + fechaNegocio + " - " + sucursal);

		NeteoSATManager manager = new NeteoSATManager();

		try {
			manager.NetearSAT(fechaNegocio, sucursal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			insertEvent("ERROR NETEO", e.getMessage() ,"RSAT");

		}
		workItemManager.completeWorkItem(workItem.getId(), null);
	}
	protected void insertEvent(String type, String message, String source) {

		CuadraturaEvent event = new CuadraturaEvent(type, message, source);
		session.insert(event);
	}
}
