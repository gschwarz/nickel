package com.rhiscom.bpm.console.server.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.rhiscom.bpm.console.task.entity.Escalation;
import com.rhiscom.bpm.console.task.entity.I18ntext;
import com.rhiscom.bpm.console.task.entity.Organizationalentity;

/**
 * The persistent class for the reassignment database table.
 * 
 */
@Entity
@XmlRootElement
public class Reassignment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private List<I18ntext> i18ntexts;
    private Escalation escalation;
    private List<Organizationalentity> organizationalentities;

    public Reassignment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
	return this.id;
    }

    public void setId(String id) {
	this.id = id;
    }

    // bi-directional many-to-one association to I18ntext
    @OneToMany(mappedBy = "reassignment")
    public List<I18ntext> getI18ntexts() {
	return this.i18ntexts;
    }

    public void setI18ntexts(List<I18ntext> i18ntexts) {
	this.i18ntexts = i18ntexts;
    }

    // bi-directional many-to-one association to Escalation
    @ManyToOne
    @JoinColumn(name = "Escalation_Reassignments_Id")
    public Escalation getEscalation() {
	return this.escalation;
    }

    public void setEscalation(Escalation escalation) {
	this.escalation = escalation;
    }

    // bi-directional many-to-many association to Organizationalentity
    @ManyToMany(mappedBy = "reassignments")
    public List<Organizationalentity> getOrganizationalentities() {
	return this.organizationalentities;
    }

    public void setOrganizationalentities(List<Organizationalentity> organizationalentities) {
	this.organizationalentities = organizationalentities;
    }

}