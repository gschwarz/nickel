package com.rhiscom.bpm.console.server.services.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO;

public interface ProcessDAO {

    List<NodeInstanceLogDTO> getDetailInstance(Long instanceId) throws Exception;

    Map<String, Integer> getTotalInstancesInExecution() throws Exception;

    List<ProcessInstanceLogDTO> getInstancesLog() throws Exception;

    Map<Date, List<ProcessInstanceLogDTO>> getProcessHistory() throws Exception;

    void saveProcessScheduler(ProcessSchedulerDTO dto) throws Exception;

    ProcessSchedulerDTO getProcessSchedulerByProcessId(String processID) throws Exception;

}
