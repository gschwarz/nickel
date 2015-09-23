package com.rhiscom.bpm.console.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CellTableEstadoTiendaPlace extends Place {

	private String cellName;

	public CellTableEstadoTiendaPlace(String token) {
		this.cellName = token;
	}

	public String getCellName() {
		return cellName;
	}

	public static class Tokenizer implements
			PlaceTokenizer<CellTableEstadoTiendaPlace> {
		@Override
		public String getToken(CellTableEstadoTiendaPlace place) {
			return place.getCellName();
		}

		@Override
		public CellTableEstadoTiendaPlace getPlace(String token) {
			return new CellTableEstadoTiendaPlace(token);
		}
	}
}
