package com.rhiscom.bpm.console.shared.model.rs;

import java.util.ArrayList;
import java.util.Collection;

import com.rhiscom.bpm.console.shared.model.dto.ProjectDTO;

public class ProjectsRS {

    private Collection<ProjectDTO> projectList = new ArrayList<ProjectDTO>();

    public Collection<ProjectDTO> getProjectList() {
	return projectList;
    }

    public void setProjectList(Collection<ProjectDTO> projectList) {
	this.projectList = projectList;
    }

}
