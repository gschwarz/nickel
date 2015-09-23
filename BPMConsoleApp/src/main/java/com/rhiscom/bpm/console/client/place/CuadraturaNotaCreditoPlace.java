package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CuadraturaNotaCreditoPlace extends Place {

    private String cellName;

    public CuadraturaNotaCreditoPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<CuadraturaNotaCreditoPlace> {
	@Override
	public String getToken(CuadraturaNotaCreditoPlace place) {
	    return place.getCellName();
	}

	@Override
	public CuadraturaNotaCreditoPlace getPlace(String token) {
	    return new CuadraturaNotaCreditoPlace(token);
	}
    }
}