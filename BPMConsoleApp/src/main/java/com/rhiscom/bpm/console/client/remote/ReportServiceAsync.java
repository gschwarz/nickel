package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.ProjectDTO;

public interface ReportServiceAsync {

    public void getAllPlansATN(AsyncCallback<List<ProjectDTO>> callback);
}
