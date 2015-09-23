package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProcessCoreCaseManagementPlace extends Place {

    private String cellName;

    public ProcessCoreCaseManagementPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<ProcessCoreCaseManagementPlace> {
	@Override
	public String getToken(ProcessCoreCaseManagementPlace place) {
	    return place.getCellName();
	}

	@Override
	public ProcessCoreCaseManagementPlace getPlace(String token) {
	    return new ProcessCoreCaseManagementPlace(token);
	}
    }

}
