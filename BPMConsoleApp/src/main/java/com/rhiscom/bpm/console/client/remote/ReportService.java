package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.dto.ProjectDTO;

@RemoteServiceRelativePath("reportService")
public interface ReportService extends RemoteService {

    List<ProjectDTO> getAllPlansATN();

}
