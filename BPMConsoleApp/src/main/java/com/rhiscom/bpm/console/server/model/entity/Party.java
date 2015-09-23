package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Grupo de personas en el sistema.
 * 
 * @author Pablo Cáceres
 * 
 */
@Entity
@Table(name = "pa_party")
public class Party {

    @Id
    @GeneratedValue
    @Column(name = "partyId")
    private Long partyId;

    @Column(name = "description")
    private String description;

    public Long getPartyId() {
	return partyId;
    }

    public void setPartyId(Long partyId) {
	this.partyId = partyId;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
