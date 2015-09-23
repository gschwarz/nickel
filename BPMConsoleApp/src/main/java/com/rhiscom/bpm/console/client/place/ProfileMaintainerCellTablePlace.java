package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProfileMaintainerCellTablePlace extends Place {

    private String cellName;

    public ProfileMaintainerCellTablePlace(String token) {
	this.cellName = token;
    }

    public String getCellName() {
	return cellName;
    }

    public static class Tokenizer implements PlaceTokenizer<ProfileMaintainerCellTablePlace> {
	@Override
	public String getToken(ProfileMaintainerCellTablePlace place) {
	    return place.getCellName();
	}

	@Override
	public ProfileMaintainerCellTablePlace getPlace(String token) {
	    return new ProfileMaintainerCellTablePlace(token);
	}
    }

}
