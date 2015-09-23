package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the content database table.
 * 
 */
@Entity
@XmlRootElement
public class Content implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private byte[] content;

    public Content() {
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
	public byte[] getContent() {
		return this.content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}