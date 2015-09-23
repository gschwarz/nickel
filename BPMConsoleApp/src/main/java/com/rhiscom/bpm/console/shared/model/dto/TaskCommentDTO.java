package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;

public class TaskCommentDTO implements Serializable {
    private String id;
    private Date addedAt;
    private String text;
    private String user;
    private String taskId;
    private String comment;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Date getAddedAt() {
	return addedAt;
    }

    public void setAddedAt(Date addedAt) {
	this.addedAt = addedAt;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public String getUser() {
	return user;
    }

    public void setUser(String user) {
	this.user = user;
    }

    public String getTaskId() {
	return taskId;
    }

    public void setTaskId(String taskId) {
	this.taskId = taskId;
    }

    public String getComment() {
	return comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

}
