package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class UserMaintainerCellTablePlace extends Place {

    private String cellName;

    public UserMaintainerCellTablePlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<UserMaintainerCellTablePlace> {
	@Override
	public String getToken(UserMaintainerCellTablePlace place) {
	    return place.getCellName();
	}

	@Override
	public UserMaintainerCellTablePlace getPlace(String token) {
	    return new UserMaintainerCellTablePlace(token);
	}
    }

}
