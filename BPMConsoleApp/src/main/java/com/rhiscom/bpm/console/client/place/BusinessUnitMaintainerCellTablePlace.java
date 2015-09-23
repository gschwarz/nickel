package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class BusinessUnitMaintainerCellTablePlace extends Place {

    private String cellName;

    public BusinessUnitMaintainerCellTablePlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<BusinessUnitMaintainerCellTablePlace> {
	@Override
	public String getToken(BusinessUnitMaintainerCellTablePlace place) {
	    return place.getCellName();
	}

	@Override
	public BusinessUnitMaintainerCellTablePlace getPlace(String token) {
	    return new BusinessUnitMaintainerCellTablePlace(token);
	}
    }

}
