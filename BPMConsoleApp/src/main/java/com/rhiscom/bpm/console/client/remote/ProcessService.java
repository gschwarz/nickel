package com.rhiscom.bpm.console.client.remote;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO;

@RemoteServiceRelativePath("processService")
public interface ProcessService extends RemoteService {

    public List<NodeInstanceLogDTO> getDetailInstance(Long instanceId) throws Exception;

    public Map<Date, List<ProcessInstanceLogDTO>> getProcessHistory() throws Exception;

    public Map<String, Integer> getTotalInstancesInExecution() throws Exception;

    public List<ProcessInstanceLogDTO> getInstancesLog() throws Exception;

    public void saveProcessScheduler(ProcessSchedulerDTO dto) throws Exception;

    ProcessSchedulerDTO getProcessSchedulerByProcessId(String processId) throws Exception;

}
