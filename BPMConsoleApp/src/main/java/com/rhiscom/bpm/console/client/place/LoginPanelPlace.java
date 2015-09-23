package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LoginPanelPlace extends Place {

    private String cellName;

    public String getCellName() {
	return cellName;
    }

    public LoginPanelPlace(String token) {
	this.cellName = token;
    }

    public static class Tokenizer implements PlaceTokenizer<LoginPanelPlace> {
	@Override
	public String getToken(LoginPanelPlace place) {
	    return place.getCellName();
	}

	@Override
	public LoginPanelPlace getPlace(String token) {
	    return new LoginPanelPlace(token);
	}
    }
}
