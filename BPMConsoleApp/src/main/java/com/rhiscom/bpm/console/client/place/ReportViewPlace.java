package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ReportViewPlace extends Place {

    private String cellName;

    public ReportViewPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<ReportViewPlace> {
	@Override
	public String getToken(ReportViewPlace place) {
	    return place.getCellName();
	}

	@Override
	public ReportViewPlace getPlace(String token) {
	    return new ReportViewPlace(token);
	}
    }

}
