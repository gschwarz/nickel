package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CuadraturaTarjetaCreditoPlace extends Place {

    private String cellName;

    public CuadraturaTarjetaCreditoPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<CuadraturaTarjetaCreditoPlace> {
	@Override
	public String getToken(CuadraturaTarjetaCreditoPlace place) {
	    return place.getCellName();
	}

	@Override
	public CuadraturaTarjetaCreditoPlace getPlace(String token) {
	    return new CuadraturaTarjetaCreditoPlace(token);
	}
    }
}