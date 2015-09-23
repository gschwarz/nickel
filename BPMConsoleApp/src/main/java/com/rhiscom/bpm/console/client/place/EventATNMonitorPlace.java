package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class EventATNMonitorPlace extends Place {
    private String cellName;

    public EventATNMonitorPlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<EventATNMonitorPlace> {
	@Override
	public String getToken(EventATNMonitorPlace place) {
	    return place.getCellName();
	}

	@Override
	public EventATNMonitorPlace getPlace(String token) {
	    return new EventATNMonitorPlace(token);
	}
    }
}
