package com.rhiscom.cuadratura.files.workitem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Logger;

import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;

import com.rhiscom.cuadratura.files.manager.PLDTFManager;

public class GetFromPLDTFWorkItemHandler implements WorkItemHandler {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	private final static Logger logger = Logger.getLogger(GetFromPLDTFWorkItemHandler.class.getName());
	
	private StatefulKnowledgeSession session;
	public GetFromPLDTFWorkItemHandler(StatefulKnowledgeSession ksession) {
		session=ksession;
	}

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager arg1) {
		Map<String, Object> parameters = workItem.getParameters();

		String fechaNegocio = (String) parameters.get("businessDate");
		String sucursal = (String) parameters.get("sucursal");
		
		
		logger.info("Fecha de negocio :" + fechaNegocio);
		logger.info("sucursal :" + sucursal);
		
		
		PLDTFManager manager = new PLDTFManager();
	
			try {
				manager.readFile(formatter.parse(fechaNegocio),sucursal);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	
			session.getWorkItemManager().completeWorkItem(workItem.getId(),null);

	}

}