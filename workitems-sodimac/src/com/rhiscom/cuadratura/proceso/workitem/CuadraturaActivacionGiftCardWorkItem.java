package com.rhiscom.cuadratura.proceso.workitem;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Logger;

import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;

import com.rhiscom.bpm.rules.CuadraturaEvent;
import com.rhiscom.cuadratura.proceso.manager.CuadraturaActivacionGiftCardManager;

public class CuadraturaActivacionGiftCardWorkItem implements WorkItemHandler {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	private final static Logger logger = Logger.getLogger(CuadraturaActivacionGiftCardWorkItem.class.getName());
	private StatefulKnowledgeSession session;
	public CuadraturaActivacionGiftCardWorkItem(StatefulKnowledgeSession ksession) {
		session=ksession;
	}

	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

		Map<String, Object> parameters = workItem.getParameters();

		String fechaNegocio = (String) parameters.get("fechaNegocio");
		String sucursal = (String) parameters.get("sucursal");

		logger.info("::[execute]:: Inicio cuadratura activacion GIFTCARD");
		
		CuadraturaActivacionGiftCardManager manager = new CuadraturaActivacionGiftCardManager();

		try {
			manager.generarCuadratura(formatter.parse(fechaNegocio), sucursal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			insertEvent("ERROR_CUADRATURA", e.getMessage() ,"ACTIVACION GIFTCARD");
			
		
		}
		logger.info("::[execute]:: Termino de cuadratura activacion GIFTCARD");
		workItemManager.completeWorkItem(workItem.getId(), null);
	}
	
	protected void insertEvent(String type, String message, String source) {

		CuadraturaEvent event = new CuadraturaEvent(type, message, source);
		session.insert(event);
	}

}
