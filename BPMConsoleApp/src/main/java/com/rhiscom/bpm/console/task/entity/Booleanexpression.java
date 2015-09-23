package com.rhiscom.bpm.console.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the booleanexpression database table.
 * 
 */
@Entity
@XmlRootElement
public class Booleanexpression implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String expression;
	private String type;
	private Escalation escalation;

    public Booleanexpression() {
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
	public String getExpression() {
		return this.expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	//bi-directional many-to-one association to Escalation
    @ManyToOne
	@JoinColumn(name="Escalation_Constraints_Id")
	public Escalation getEscalation() {
		return this.escalation;
	}

	public void setEscalation(Escalation escalation) {
		this.escalation = escalation;
	}
	
}