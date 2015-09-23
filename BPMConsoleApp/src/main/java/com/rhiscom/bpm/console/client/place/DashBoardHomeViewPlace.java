package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class DashBoardHomeViewPlace extends Place {

    private String cellName;

    public DashBoardHomeViewPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<DashBoardHomeViewPlace> {
	@Override
	public String getToken(DashBoardHomeViewPlace place) {
	    return place.getCellName();
	}

	@Override
	public DashBoardHomeViewPlace getPlace(String token) {
	    return new DashBoardHomeViewPlace(token);
	}
    }
}