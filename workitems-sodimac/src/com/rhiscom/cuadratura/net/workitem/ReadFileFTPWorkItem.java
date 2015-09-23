package com.rhiscom.cuadratura.net.workitem;

import org.drools.runtime.KnowledgeRuntime;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;

import com.rhiscom.cuadratura.ftp.manager.FTPFileManager;

public class ReadFileFTPWorkItem implements WorkItemHandler {

	
	private String archivo;
	private KnowledgeRuntime session;
	private String sucursal;
	private String fechaNegocio;
	private String extension;


	public ReadFileFTPWorkItem(KnowledgeRuntime session2) {

		this.session = session2;

	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

	}

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

		archivo = (String) workItem.getParameter("archivo");
		
		System.out.println("WORKITEM  ReadFileFTPWorkItem: "+ archivo);
		sucursal = (String) workItem.getParameter("sucursal");
		fechaNegocio = (String) workItem.getParameter("fechaNegocio");
		extension = (String) workItem.getParameter("extension");
		
		FTPFileManager manager = new FTPFileManager();
		
		manager.moverArchivoFTPToFile(archivo, sucursal, fechaNegocio, extension);
		workItemManager.completeWorkItem(workItem.getId(),null);

	}

	

	
		
}
