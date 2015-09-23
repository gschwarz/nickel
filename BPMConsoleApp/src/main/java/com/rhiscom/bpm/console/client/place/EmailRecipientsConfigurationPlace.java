package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class EmailRecipientsConfigurationPlace extends Place{
    private String cellName;

    public EmailRecipientsConfigurationPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<EmailRecipientsConfigurationPlace> {
	@Override
	public String getToken(EmailRecipientsConfigurationPlace place) {
	    return place.getCellName();
	}

	@Override
	public EmailRecipientsConfigurationPlace getPlace(String token) {
	    return new EmailRecipientsConfigurationPlace(token);
	}
    }
}
