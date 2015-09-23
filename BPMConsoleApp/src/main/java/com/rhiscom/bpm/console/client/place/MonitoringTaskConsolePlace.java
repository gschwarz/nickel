package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MonitoringTaskConsolePlace extends Place {

    private String cellName;

    public String getCellName() {
	return cellName;
    }

    public MonitoringTaskConsolePlace(String token) {
	this.cellName = token;
    }

    public static class Tokenizer implements PlaceTokenizer<MonitoringTaskConsolePlace> {
	@Override
	public String getToken(MonitoringTaskConsolePlace place) {
	    return place.getCellName();
	}

	@Override
	public MonitoringTaskConsolePlace getPlace(String token) {
	    return new MonitoringTaskConsolePlace(token);
	}
    }
}