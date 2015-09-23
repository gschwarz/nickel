package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AsignedTaskConsoleCellTablePlace extends Place {

    private String cellName;

    public AsignedTaskConsoleCellTablePlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<AsignedTaskConsoleCellTablePlace> {
	@Override
	public String getToken(AsignedTaskConsoleCellTablePlace place) {
	    return place.getCellName();
	}

	@Override
	public AsignedTaskConsoleCellTablePlace getPlace(String token) {
	    return new AsignedTaskConsoleCellTablePlace(token);
	}
    }
}
