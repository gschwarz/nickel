package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class BusinessGroupMaintainerCellTablePlace extends Place {

    private String cellName;

    public BusinessGroupMaintainerCellTablePlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<BusinessGroupMaintainerCellTablePlace> {
	@Override
	public String getToken(BusinessGroupMaintainerCellTablePlace place) {
	    return place.getCellName();
	}

	@Override
	public BusinessGroupMaintainerCellTablePlace getPlace(String token) {
	    return new BusinessGroupMaintainerCellTablePlace(token);
	}
    }
}
