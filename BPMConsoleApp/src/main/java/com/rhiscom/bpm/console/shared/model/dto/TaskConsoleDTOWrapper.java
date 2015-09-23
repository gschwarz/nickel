package com.rhiscom.bpm.console.shared.model.dto;

import java.util.Collection;

public class TaskConsoleDTOWrapper {
    Collection<TaskConsoleDTO> taskList;

    public Collection<TaskConsoleDTO> getTaskList() {
	return taskList;
    }

    public void setTaskList(Collection<TaskConsoleDTO> taskList) {
	this.taskList = taskList;
    }

}
