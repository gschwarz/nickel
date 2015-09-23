package com.rhiscom.bpm.console.shared.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OperatorDTO implements Serializable {

    private long operatorId;

    private String user;

    private String password;

    private Set<ResolverGroupDTO> workGroups = new HashSet<ResolverGroupDTO>(0);

    private WorkerDTO worker;

    private Date createDate;

    private String sessionId;

    private boolean loggedIn;

    private ProfileDTO profileDTO;

    private BusinessUnitDTO bussinessUnitDTO;

    public OperatorDTO() {

    }

    public OperatorDTO(String user, String password, Set<ResolverGroupDTO> workGroup, WorkerDTO worker,
	    Date createDate, ProfileDTO profile) {
	super();
	this.user = user;
	this.password = password;
	this.setWorkGroups(workGroup);
	this.worker = worker;
	this.createDate = createDate;
	setProfileDTO(profile);
    }

    public OperatorDTO(long operatorId, String user, String password, Set<ResolverGroupDTO> workGroup,
	    WorkerDTO worker, Date createDate, ProfileDTO profile) {
	super();
	this.operatorId = operatorId;
	this.user = user;
	this.password = password;
	this.setWorkGroups(workGroup);
	this.worker = worker;
	this.createDate = createDate;
	setProfileDTO(profile);
    }

    public WorkerDTO getWorker() {
	return worker;
    }

    public void setWorker(WorkerDTO worker) {
	this.worker = worker;
    }

    public long getOperatorId() {
	return operatorId;
    }

    public void setOperatorId(long operatorId) {
	this.operatorId = operatorId;
    }

    public String getUser() {
	return user;
    }

    public void setUser(String user) {
	this.user = user;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Date getCreateDate() {
	return createDate;
    }

    public void setCreateDate(Date createDate) {
	this.createDate = createDate;
    }

    public Set<ResolverGroupDTO> getWorkGroups() {
	return workGroups;
    }

    public void setWorkGroups(Set<ResolverGroupDTO> workGroups) {
	this.workGroups = workGroups;
    }

    public String getSessionId() {
	return sessionId;
    }

    public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
    }

    public boolean isLoggedIn() {
	return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
	this.loggedIn = loggedIn;
    }

    public ProfileDTO getProfileDTO() {
	return profileDTO;
    }

    public void setProfileDTO(ProfileDTO profileDTO) {
	this.profileDTO = profileDTO;
    }

    public BusinessUnitDTO getBussinessUnitDTO() {
	return bussinessUnitDTO;
    }

    public void setBussinessUnitDTO(BusinessUnitDTO bussinessUnitDTO) {
	this.bussinessUnitDTO = bussinessUnitDTO;
    }

}
