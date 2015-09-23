package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProcessManagementPlace extends Place {

    private String cellName;

    public ProcessManagementPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<ProcessManagementPlace> {
	@Override
	public String getToken(ProcessManagementPlace place) {
	    return place.getCellName();
	}

	@Override
	public ProcessManagementPlace getPlace(String token) {
	    return new ProcessManagementPlace(token);
	}
    }

}