package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class POSVersionMaintainerViewPlace extends Place {
    private String cellName;

    public POSVersionMaintainerViewPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<POSVersionMaintainerViewPlace> {
	@Override
	public String getToken(POSVersionMaintainerViewPlace place) {
	    return place.getCellName();
	}

	@Override
	public POSVersionMaintainerViewPlace getPlace(String token) {
	    return new POSVersionMaintainerViewPlace(token);
	}
    }
}
