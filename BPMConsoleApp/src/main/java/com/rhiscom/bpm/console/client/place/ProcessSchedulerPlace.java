package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProcessSchedulerPlace extends Place {

    private String cellName;

    public ProcessSchedulerPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<ProcessSchedulerPlace> {
	@Override
	public String getToken(ProcessSchedulerPlace place) {
	    return place.getCellName();
	}

	@Override
	public ProcessSchedulerPlace getPlace(String token) {
	    return new ProcessSchedulerPlace(token);
	}
    }

}