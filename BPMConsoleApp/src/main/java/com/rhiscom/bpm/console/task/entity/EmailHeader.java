package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the email_header database table.
 * 
 */
@Entity
@XmlRootElement
@Table(name="email_header")
public class EmailHeader implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String body;
	private String fromAddress;
	private String language;
	private String replyToAddress;
	private String subject;
	private List<NotificationEmailHeader> notificationEmailHeaders;

    public EmailHeader() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


    @Lob()
	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}


	public String getFromAddress() {
		return this.fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}


	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public String getReplyToAddress() {
		return this.replyToAddress;
	}

	public void setReplyToAddress(String replyToAddress) {
		this.replyToAddress = replyToAddress;
	}


	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	//bi-directional many-to-one association to NotificationEmailHeader
	@OneToMany(mappedBy="emailHeader")
	public List<NotificationEmailHeader> getNotificationEmailHeaders() {
		return this.notificationEmailHeaders;
	}

	public void setNotificationEmailHeaders(List<NotificationEmailHeader> notificationEmailHeaders) {
		this.notificationEmailHeaders = notificationEmailHeaders;
	}
	
}