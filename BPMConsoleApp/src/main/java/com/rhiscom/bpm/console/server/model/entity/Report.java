package com.rhiscom.bpm.console.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rhiscom.bpm.console.shared.BaseValue;

@Entity
@Table(name = "report")
public class Report extends BaseValue {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "report_id")
    private Long id;

    @Column(name = "report_name")
    private String name;

    @Column(name = "report_description")
    private String desc;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDesc() {
	return desc;
    }

    public void setDesc(String desc) {
	this.desc = desc;
    }

}
