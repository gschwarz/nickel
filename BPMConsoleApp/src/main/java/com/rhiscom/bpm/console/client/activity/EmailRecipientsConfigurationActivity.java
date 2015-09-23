package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.EmailRecipientsConfigurationPlace;
import com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationView;

public class EmailRecipientsConfigurationActivity extends AbstractActivity implements EmailRecipientsConfigurationView.Presenter{
    private ClientFactory clientFactory;
    
    //TODO eliminar el primer parametro, porque no se ocupa
    public EmailRecipientsConfigurationActivity(EmailRecipientsConfigurationPlace place, ClientFactory clientFactory){
	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
	EmailRecipientsConfigurationView emailRecipientsConfigurationPlace = clientFactory.getEmailRecipientsConfigurationView();
	
	emailRecipientsConfigurationPlace.setPresenter(this);
	panel.setWidget(emailRecipientsConfigurationPlace.asWidget());
    }

    @Override
    public void goTo(Place place) {
	this.clientFactory.getPlaceController().goTo(place);
	
    }

    @Override
    public void onLinkClicked() {
    }

}
