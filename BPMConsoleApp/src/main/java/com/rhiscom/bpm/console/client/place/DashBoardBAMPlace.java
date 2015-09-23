package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class DashBoardBAMPlace extends Place {

    private String cellName;

    public DashBoardBAMPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<DashBoardBAMPlace> {
	@Override
	public String getToken(DashBoardBAMPlace place) {
	    return place.getCellName();
	}

	@Override
	public DashBoardBAMPlace getPlace(String token) {
	    return new DashBoardBAMPlace(token);
	}
    }

}
