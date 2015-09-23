package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CuadraturaActivacionGiftCardPlace extends Place {

    private String cellName;

    public CuadraturaActivacionGiftCardPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<CuadraturaActivacionGiftCardPlace> {
	@Override
	public String getToken(CuadraturaActivacionGiftCardPlace place) {
	    return place.getCellName();
	}

	@Override
	public CuadraturaActivacionGiftCardPlace getPlace(String token) {
	    return new CuadraturaActivacionGiftCardPlace(token);
	}
    }
}
