package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProcessConsoleCellTablePlace extends Place {

    private String cellName;

    public ProcessConsoleCellTablePlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<ProcessConsoleCellTablePlace> {
	@Override
	public String getToken(ProcessConsoleCellTablePlace place) {
	    return place.getCellName();
	}

	@Override
	public ProcessConsoleCellTablePlace getPlace(String token) {
	    return new ProcessConsoleCellTablePlace(token);
	}
    }
}
