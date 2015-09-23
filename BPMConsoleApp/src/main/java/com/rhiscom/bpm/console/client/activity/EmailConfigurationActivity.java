package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.EmailConfigurationPlace;
import com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationView;

public class EmailConfigurationActivity extends AbstractActivity implements EmailConfigurationView.Presenter {
    private ClientFactory clientFactory;

    public EmailConfigurationActivity(EmailConfigurationPlace place, ClientFactory clientFactory) {

	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus arg1) {
	EmailConfigurationView emailConfigurationPlace = clientFactory.getEmailConfigurator();

	emailConfigurationPlace.setPresenter(this);
	containerWidget.setWidget(emailConfigurationPlace.asWidget());

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
