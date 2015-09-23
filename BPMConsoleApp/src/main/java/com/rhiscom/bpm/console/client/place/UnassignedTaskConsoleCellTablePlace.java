package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class UnassignedTaskConsoleCellTablePlace extends Place {
    private String cellName;

    public UnassignedTaskConsoleCellTablePlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<UnassignedTaskConsoleCellTablePlace> {
	@Override
	public String getToken(UnassignedTaskConsoleCellTablePlace place) {
	    return place.getCellName();
	}

	@Override
	public UnassignedTaskConsoleCellTablePlace getPlace(String token) {
	    return new UnassignedTaskConsoleCellTablePlace(token);
	}
    }
}
