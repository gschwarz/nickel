package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the attachment database table.
 * 
 */
@Entity
@XmlRootElement
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Integer accessType;
	private Date attachedAt;
	private Integer attachmentSize;
	private BigInteger attachmentContentId;
	private String contentType;
	private String name;
	private Task task;
	private Organizationalentity organizationalentity;

    public Attachment() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Integer getAccessType() {
		return this.accessType;
	}

	public void setAccessType(Integer accessType) {
		this.accessType = accessType;
	}


    @Temporal( TemporalType.TIMESTAMP)
	public Date getAttachedAt() {
		return this.attachedAt;
	}

	public void setAttachedAt(Date attachedAt) {
		this.attachedAt = attachedAt;
	}


	@Column(name="attachment_size")
	public Integer getAttachmentSize() {
		return this.attachmentSize;
	}

	public void setAttachmentSize(Integer attachmentSize) {
		this.attachmentSize = attachmentSize;
	}


	public BigInteger getAttachmentContentId() {
		return this.attachmentContentId;
	}

	public void setAttachmentContentId(BigInteger attachmentContentId) {
		this.attachmentContentId = attachmentContentId;
	}


	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Task
    @ManyToOne
	@JoinColumn(name="TaskData_Attachments_Id")
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	

	//bi-directional many-to-one association to Organizationalentity
    @ManyToOne
	@JoinColumn(name="attachedBy_id")
	public Organizationalentity getOrganizationalentity() {
		return this.organizationalentity;
	}

	public void setOrganizationalentity(Organizationalentity organizationalentity) {
		this.organizationalentity = organizationalentity;
	}
	
}