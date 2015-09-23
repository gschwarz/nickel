package com.rhiscom.bpm.console.shared.model.rs;

import java.io.Serializable;
import java.util.List;

public class TaskListWrapper implements Serializable {
    public TaskListWrapper() {

    }

    private List<TaskDetailRS> taskList;

    public List<TaskDetailRS> getTaskList() {
	return taskList;
    }

    public void setTaskList(List<TaskDetailRS> taskList) {
	this.taskList = taskList;
    }

}
