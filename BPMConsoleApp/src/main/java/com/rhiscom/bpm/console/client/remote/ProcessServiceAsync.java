package com.rhiscom.bpm.console.client.remote;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO;

public interface ProcessServiceAsync {

    public void getDetailInstance(Long instanceId, AsyncCallback<List<NodeInstanceLogDTO>> callback) throws Exception;

    public void getProcessHistory(AsyncCallback<Map<Date, List<ProcessInstanceLogDTO>>> callback) throws Exception;

    public void getTotalInstancesInExecution(AsyncCallback<Map<String, Integer>> callback);

    public void getInstancesLog(AsyncCallback<List<ProcessInstanceLogDTO>> callback);

    public void saveProcessScheduler(ProcessSchedulerDTO dto, AsyncCallback callBack) throws Exception;

    public void getProcessSchedulerByProcessId(String processId, AsyncCallback<ProcessSchedulerDTO> callback)
	    throws Exception;

}
