package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CuadraturaVentasGiftCardPlace extends Place {

    private String cellName;

    public CuadraturaVentasGiftCardPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<CuadraturaVentasGiftCardPlace> {
	@Override
	public String getToken(CuadraturaVentasGiftCardPlace place) {
	    return place.getCellName();
	}

	@Override
	public CuadraturaVentasGiftCardPlace getPlace(String token) {
	    return new CuadraturaVentasGiftCardPlace(token);
	}
    }
}