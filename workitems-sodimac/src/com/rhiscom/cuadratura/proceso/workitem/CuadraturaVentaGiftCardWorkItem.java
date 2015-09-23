package com.rhiscom.cuadratura.proceso.workitem;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Logger;

import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;

import com.rhiscom.bpm.rules.CuadraturaEvent;
import com.rhiscom.cuadratura.proceso.manager.CuadraturaVentaGiftCardManager;

public class CuadraturaVentaGiftCardWorkItem implements WorkItemHandler {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	private final static Logger logger = Logger.getLogger(CuadraturaVentaGiftCardWorkItem.class.getName());
	private StatefulKnowledgeSession session;
	public CuadraturaVentaGiftCardWorkItem(StatefulKnowledgeSession ksession) {
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

		logger.info("::Inicio CUADRATURA VENTA GIFTCARD ::");
		
		CuadraturaVentaGiftCardManager manager = new CuadraturaVentaGiftCardManager();

		try {
			manager.generarCuadratura(formatter.parse(fechaNegocio), sucursal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			insertEvent("ERROR_CUADRATURA", e.getMessage() ,"VENTA GIFTCARD");
		}
		
		logger.info("::Termino CUADRATURA VENTA GIFTCARD ::");
		workItemManager.completeWorkItem(workItem.getId(), null);
	}
		
	protected void insertEvent(String type, String message, String source) {

		CuadraturaEvent event = new CuadraturaEvent(type, message, source);
		session.insert(event);
	}

}
