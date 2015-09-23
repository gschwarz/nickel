package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ResolverGroupMaintainerCellTablePlace extends Place {

    private String cellName;

    public ResolverGroupMaintainerCellTablePlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<ResolverGroupMaintainerCellTablePlace> {
	@Override
	public String getToken(ResolverGroupMaintainerCellTablePlace place) {
	    return place.getCellName();
	}

	@Override
	public ResolverGroupMaintainerCellTablePlace getPlace(String token) {
	    return new ResolverGroupMaintainerCellTablePlace(token);
	}
    }
}
