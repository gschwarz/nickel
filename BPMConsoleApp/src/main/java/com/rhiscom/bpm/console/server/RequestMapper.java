package com.rhiscom.bpm.console.server;

import java.util.HashMap;
import java.util.Map;

import com.rhiscom.bpm.console.shared.model.Peticion;

public class RequestMapper {

    private static RequestMapper instance = null;
    private Map<String, Map<String, Peticion>> peticion = new HashMap<String, Map<String, Peticion>>();

    private RequestMapper() {

    }

    public static RequestMapper getInstance() {
	if (instance == null)
	    instance = new RequestMapper();
	return instance;

    }

    public Map<String, Map<String, Peticion>> getPeticion() {
	return peticion;
    }

    public void setPeticion(Map<String, Map<String, Peticion>> peticion) {
	this.peticion = peticion;
    }

}
