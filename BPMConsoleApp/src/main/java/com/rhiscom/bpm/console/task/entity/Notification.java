package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@XmlRootElement
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String dtype;
	private Integer priority;
	private List<I18ntext> i18ntexts1;
	private List<I18ntext> i18ntexts2;
	private List<I18ntext> i18ntexts3;
	private List<I18ntext> i18ntexts4;
	private Escalation escalation;
	private List<Organizationalentity> organizationalentities1;
	private List<NotificationEmailHeader> notificationEmailHeaders;
	private List<Organizationalentity> organizationalentities2;

    public Notification() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}


	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	//bi-directional many-to-one association to I18ntext
	@OneToMany(mappedBy="notification1")
	public List<I18ntext> getI18ntexts1() {
		return this.i18ntexts1;
	}

	public void setI18ntexts1(List<I18ntext> i18ntexts1) {
		this.i18ntexts1 = i18ntexts1;
	}
	

	//bi-directional many-to-one association to I18ntext
	@OneToMany(mappedBy="notification2")
	public List<I18ntext> getI18ntexts2() {
		return this.i18ntexts2;
	}

	public void setI18ntexts2(List<I18ntext> i18ntexts2) {
		this.i18ntexts2 = i18ntexts2;
	}
	

	//bi-directional many-to-one association to I18ntext
	@OneToMany(mappedBy="notification3")
	public List<I18ntext> getI18ntexts3() {
		return this.i18ntexts3;
	}

	public void setI18ntexts3(List<I18ntext> i18ntexts3) {
		this.i18ntexts3 = i18ntexts3;
	}
	

	//bi-directional many-to-one association to I18ntext
	@OneToMany(mappedBy="notification4")
	public List<I18ntext> getI18ntexts4() {
		return this.i18ntexts4;
	}

	public void setI18ntexts4(List<I18ntext> i18ntexts4) {
		this.i18ntexts4 = i18ntexts4;
	}
	

	//bi-directional many-to-one association to Escalation
    @ManyToOne
	@JoinColumn(name="Escalation_Notifications_Id")
	public Escalation getEscalation() {
		return this.escalation;
	}

	public void setEscalation(Escalation escalation) {
		this.escalation = escalation;
	}
	

	//bi-directional many-to-many association to Organizationalentity
	@ManyToMany(mappedBy="notifications1")
	public List<Organizationalentity> getOrganizationalentities1() {
		return this.organizationalentities1;
	}

	public void setOrganizationalentities1(List<Organizationalentity> organizationalentities1) {
		this.organizationalentities1 = organizationalentities1;
	}
	

	//bi-directional many-to-one association to NotificationEmailHeader
	@OneToMany(mappedBy="notification")
	public List<NotificationEmailHeader> getNotificationEmailHeaders() {
		return this.notificationEmailHeaders;
	}

	public void setNotificationEmailHeaders(List<NotificationEmailHeader> notificationEmailHeaders) {
		this.notificationEmailHeaders = notificationEmailHeaders;
	}
	

	//bi-directional many-to-many association to Organizationalentity
	@ManyToMany(mappedBy="notifications2")
	public List<Organizationalentity> getOrganizationalentities2() {
		return this.organizationalentities2;
	}

	public void setOrganizationalentities2(List<Organizationalentity> organizationalentities2) {
		this.organizationalentities2 = organizationalentities2;
	}
	
}