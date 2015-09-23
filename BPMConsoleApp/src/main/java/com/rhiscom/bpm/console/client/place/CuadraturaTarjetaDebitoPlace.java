package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CuadraturaTarjetaDebitoPlace extends Place {

    private String cellName;

    public CuadraturaTarjetaDebitoPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<CuadraturaTarjetaDebitoPlace> {
	@Override
	public String getToken(CuadraturaTarjetaDebitoPlace place) {
	    return place.getCellName();
	}

	@Override
	public CuadraturaTarjetaDebitoPlace getPlace(String token) {
	    return new CuadraturaTarjetaDebitoPlace(token);
	}
    }
}