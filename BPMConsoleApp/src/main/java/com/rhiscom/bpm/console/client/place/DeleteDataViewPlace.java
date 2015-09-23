package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class DeleteDataViewPlace extends Place {
    private String cellName;

    public DeleteDataViewPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<DeleteDataViewPlace> {
	@Override
	public String getToken(DeleteDataViewPlace place) {
	    return place.getCellName();
	}

	@Override
	public DeleteDataViewPlace getPlace(String token) {
	    return new DeleteDataViewPlace(token);
	}
    }
}
