package com.rhiscom.bpm.console.server.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.ReportService;
import com.rhiscom.bpm.console.shared.model.dto.ProjectDTO;
import com.rhiscom.bpm.console.shared.model.rs.ProjectsRS;

public class ReportServiceImpl extends RemoteServiceServlet implements ReportService {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    ConsoleBPMProxy proxy = ConsoleBPMProxy.instance();

    /**
     * Método que retorna los Planes para generar el reporte.
     */
    @Override
    public List<ProjectDTO> getAllPlansATN() {
	List<ProjectDTO> result = null;
	try {
	    ProjectsRS listPlans = proxy.getAllATNProjects();
	    result = new ArrayList<ProjectDTO>(listPlans.getProjectList());
	    return result;
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	}

    }

}
