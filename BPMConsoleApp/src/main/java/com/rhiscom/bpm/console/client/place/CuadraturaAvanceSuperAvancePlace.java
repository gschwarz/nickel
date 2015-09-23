package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CuadraturaAvanceSuperAvancePlace extends Place {

    private String cellName;

    public CuadraturaAvanceSuperAvancePlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<CuadraturaAvanceSuperAvancePlace> {
	@Override
	public String getToken(CuadraturaAvanceSuperAvancePlace place) {
	    return place.getCellName();
	}

	@Override
	public CuadraturaAvanceSuperAvancePlace getPlace(String token) {
	    return new CuadraturaAvanceSuperAvancePlace(token);
	}
    }
}