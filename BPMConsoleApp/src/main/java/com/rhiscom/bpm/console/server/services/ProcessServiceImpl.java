package com.rhiscom.bpm.console.server.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.ProcessService;
import com.rhiscom.bpm.console.server.services.dao.ServiceDAOFactory;
import com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO;

public class ProcessServiceImpl extends RemoteServiceServlet implements ProcessService {

    private static Logger logger = Logger.getLogger(ProcessServiceImpl.class.getName());

    @SuppressWarnings({ "unchecked", "null" })
    @Override
    public List<NodeInstanceLogDTO> getDetailInstance(Long instanceId) throws Exception {
	try {
	    logger.log(Level.INFO, "::[getDetailInstance]::");
	    return ServiceDAOFactory.getInstance().getProcessDAO().getDetailInstance(instanceId);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getDetailInstance]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Integer> getTotalInstancesInExecution() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getTotalInstancesInExecution]::");
	    return ServiceDAOFactory.getInstance().getProcessDAO().getTotalInstancesInExecution();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getTotalInstancesInExecution]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProcessInstanceLogDTO> getInstancesLog() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getProcessHistory]::");
	    return ServiceDAOFactory.getInstance().getProcessDAO().getInstancesLog();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getInstagetProcessHistoryncesLog]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public Map<Date, List<ProcessInstanceLogDTO>> getProcessHistory() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getProcessHistory]::");
	    return ServiceDAOFactory.getInstance().getProcessDAO().getProcessHistory();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getProcessHistory]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public void saveProcessScheduler(ProcessSchedulerDTO dto) throws Exception {
	try {
	    logger.log(Level.INFO, "::[saveProcessScheduler]::");
	    ServiceDAOFactory.getInstance().getProcessDAO().saveProcessScheduler(dto);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[saveProcessScheduler]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public ProcessSchedulerDTO getProcessSchedulerByProcessId(String processId) throws Exception {
	try {
	    logger.log(Level.INFO, "::[getProcessSchedulerByProcessId]::");
	    return ServiceDAOFactory.getInstance().getProcessDAO().getProcessSchedulerByProcessId(processId);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getProcessSchedulerByProcessId]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

}
