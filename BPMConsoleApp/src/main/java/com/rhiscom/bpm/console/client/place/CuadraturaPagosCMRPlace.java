package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CuadraturaPagosCMRPlace extends Place {

    private String cellName;

    public CuadraturaPagosCMRPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<CuadraturaPagosCMRPlace> {
	@Override
	public String getToken(CuadraturaPagosCMRPlace place) {
	    return place.getCellName();
	}

	@Override
	public CuadraturaPagosCMRPlace getPlace(String token) {
	    return new CuadraturaPagosCMRPlace(token);
	}
    }
}