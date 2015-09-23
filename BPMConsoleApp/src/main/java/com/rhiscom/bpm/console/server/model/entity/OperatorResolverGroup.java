package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "operator_resolvergroup")
public class OperatorResolverGroup extends BaseValue {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "operatorResolverGroupId")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "operatorId", nullable = false)
    private Operator operator;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workGroupId", nullable = false)
    private ResolverGroup resolverGroup;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Operator getOperator() {
	return operator;
    }

    public void setOperator(Operator operator) {
	this.operator = operator;
    }

    public ResolverGroup getResolverGroup() {
	return resolverGroup;
    }

    public void setResolverGroup(ResolverGroup resolverGroup) {
	this.resolverGroup = resolverGroup;
    }

}
