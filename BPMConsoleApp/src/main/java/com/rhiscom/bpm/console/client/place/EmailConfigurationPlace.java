package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class EmailConfigurationPlace extends Place {
    private String cellName;

    public EmailConfigurationPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<EmailConfigurationPlace> {
	@Override
	public String getToken(EmailConfigurationPlace place) {
	    return place.getCellName();
	}

	@Override
	public EmailConfigurationPlace getPlace(String token) {
	    return new EmailConfigurationPlace(token);
	}
    }
}