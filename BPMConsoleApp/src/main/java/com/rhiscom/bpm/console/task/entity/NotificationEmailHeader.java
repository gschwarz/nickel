package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the notification_email_header database table.
 * 
 */
@Entity
@XmlRootElement
@Table(name="notification_email_header")
public class NotificationEmailHeader implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	
	@Column(name="mapKey")
	private String mapKey;
	
	
	
	//bi-directional many-to-one association to EmailHeader
    @ManyToOne
	@JoinColumn(name="emailHeaders_id")
	private EmailHeader emailHeader;
	
	
    @ManyToOne
    private Notification notification;
    
	
	
	
	public String getMapKey() {
		return mapKey;
	}
	public void setMapKey(String mapKey) {
		this.mapKey = mapKey;
	}
	public EmailHeader getEmailHeader() {
		return emailHeader;
	}
	public void setEmailHeader(EmailHeader emailHeader) {
		this.emailHeader = emailHeader;
	}
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}