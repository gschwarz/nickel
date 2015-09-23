package com.rhiscom.bpm.console.shared.model.rs;

import java.io.Serializable;

public class DefinitionsRS implements Serializable {

    private static final long serialVersionUID = -7671239098177597355L;

    private String id;
    private String name;
    private String version;
    private String packageName;
    private String deploymentId;
    private String suspended;
    private String diagramUrl;
    private String formUrl = null;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getVersion() {
	return version;
    }

    public void setVersion(String version) {
	this.version = version;
    }

    public String getPackageName() {
	return packageName;
    }

    public void setPackageName(String packageName) {
	this.packageName = packageName;
    }

    public String getDeploymentId() {
	return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
	this.deploymentId = deploymentId;
    }

    public String getSuspended() {
	return suspended;
    }

    public void setSuspended(String suspended) {
	this.suspended = suspended;
    }

    public String getDiagramUrl() {
	return diagramUrl;
    }

    public void setDiagramUrl(String diagramUrl) {
	this.diagramUrl = diagramUrl;
    }

    public void setFormUrl(String formUrl) {
	this.formUrl = formUrl;
    }

    public String getFormUrl() {
	return formUrl;
    }

    @Override
    public String toString() {
	return "DefinitionsRS [id=" + id + ", name=" + name + ", version=" + version + ", packageName=" + packageName
		+ ", deploymentId=" + deploymentId + ", suspended=" + suspended + ", diagramUrl=" + diagramUrl
		+ ", formUrl=" + formUrl + "]";
    }

}
