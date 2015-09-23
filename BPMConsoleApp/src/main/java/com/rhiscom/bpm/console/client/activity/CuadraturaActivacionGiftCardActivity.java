package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.CuadraturaActivacionGiftCardPlace;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardView;

public class CuadraturaActivacionGiftCardActivity extends AbstractActivity implements
	CuadraturaActivacionGiftCardView.Presenter {

    // Used to obtain views, eventBus, placeController
    // Alternatively, could be injected via GIN
    private ClientFactory clientFactory;

    public CuadraturaActivacionGiftCardActivity(CuadraturaActivacionGiftCardPlace place, ClientFactory clientFactory) {
	// this.name = place.getHelloName();
	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
	CuadraturaActivacionGiftCardView cuadraturaActivacionGiftCardView = clientFactory
		.getCuadraturaActifacionGiftCard();
	cuadraturaActivacionGiftCardView.setPresenter(this);
	containerWidget.setWidget(cuadraturaActivacionGiftCardView.asWidget());

    }

    @Override
    public void goTo(Place place) {
	this.clientFactory.getPlaceController().goTo(place);
    }

    @Override
    public void onLinkClicked() {
	// TODO Auto-generated method stub

    }

    @Override
    public String mayStop() {
	// return "Please hold on. This activity is stopping.";
	return super.mayStop();
    }
}
