package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CuadraturaVtaCMRViewPlace extends Place {

    private String cellName;

    public CuadraturaVtaCMRViewPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<CuadraturaVtaCMRViewPlace> {
	@Override
	public String getToken(CuadraturaVtaCMRViewPlace place) {
	    return place.getCellName();
	}

	@Override
	public CuadraturaVtaCMRViewPlace getPlace(String token) {
	    return new CuadraturaVtaCMRViewPlace(token);
	}
    }
}