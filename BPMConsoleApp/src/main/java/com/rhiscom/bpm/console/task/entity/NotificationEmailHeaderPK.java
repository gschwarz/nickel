package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The primary key class for the notification_email_header database table.
 * 
 */
@Embeddable
@XmlRootElement
public class NotificationEmailHeaderPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String notification_id;
	private String mapkey;

    public NotificationEmailHeaderPK() {
    }

	public String getNotification_id() {
		return this.notification_id;
	}
	public void setNotification_id(String notification_id) {
		this.notification_id = notification_id;
	}

	public String getMapkey() {
		return this.mapkey;
	}
	public void setMapkey(String mapkey) {
		this.mapkey = mapkey;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NotificationEmailHeaderPK)) {
			return false;
		}
		NotificationEmailHeaderPK castOther = (NotificationEmailHeaderPK)other;
		return 
			this.notification_id.equals(castOther.notification_id)
			&& this.mapkey.equals(castOther.mapkey);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.notification_id.hashCode();
		hash = hash * prime + this.mapkey.hashCode();
		
		return hash;
    }
}