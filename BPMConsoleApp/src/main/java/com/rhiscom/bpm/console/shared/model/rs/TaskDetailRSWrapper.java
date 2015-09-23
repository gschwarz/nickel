package com.rhiscom.bpm.console.shared.model.rs;

import java.io.Serializable;

public class TaskDetailRSWrapper implements Serializable {
    private TaskDetailRS tasks;

    public TaskDetailRS getTasks() {
	return tasks;
    }

    public void setTasks(TaskDetailRS tasks) {
	this.tasks = tasks;
    }

}
