package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.CellTableEstadoTiendaPlace;
import com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaView;

public class CellTableEstadoTiendaActivity extends AbstractActivity implements CellTableEstadoTiendaView.Presenter {

    private ClientFactory clientFactory;

    public CellTableEstadoTiendaActivity(CellTableEstadoTiendaPlace place, ClientFactory clientFactory) {
	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {

	CellTableEstadoTiendaView cellTableEstadoTiendaView = clientFactory.getCellTableEstadoTiendaView();

	cellTableEstadoTiendaView.setPresenter(this);
	containerWidget.setWidget(cellTableEstadoTiendaView.asWidget());

    }

    @Override
    public String mayStop() {
	// return "Please hold on. This activity is stopping.";
	return super.mayStop();
    }

    @Override
    public void goTo(Place place) {
	this.clientFactory.getPlaceController().goTo(place);

    }

    @Override
    public void onLinkClicked() {
	// TODO Auto-generated method stub

    }

}