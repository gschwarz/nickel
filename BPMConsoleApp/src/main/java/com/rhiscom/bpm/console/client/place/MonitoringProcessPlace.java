package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MonitoringProcessPlace extends Place {

    private String cellName;

    public String getCellName() {
	return cellName;
    }

    public MonitoringProcessPlace(String token) {
	this.cellName = token;
    }

    public static class Tokenizer implements PlaceTokenizer<MonitoringProcessPlace> {
	@Override
	public String getToken(MonitoringProcessPlace place) {
	    return place.getCellName();
	}

	@Override
	public MonitoringProcessPlace getPlace(String token) {
	    return new MonitoringProcessPlace(token);
	}
    }
}