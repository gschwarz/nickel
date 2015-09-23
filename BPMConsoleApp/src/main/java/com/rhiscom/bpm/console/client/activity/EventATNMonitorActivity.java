package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.EventATNMonitorPlace;
import com.rhiscom.bpm.console.client.ui.bam.EventATNMonitor;

public class EventATNMonitorActivity extends AbstractActivity implements EventATNMonitor.Presenter {
    private ClientFactory clientFactory;

    public EventATNMonitorActivity(EventATNMonitorPlace place, ClientFactory clientFactory) {
	// this.name = place.getHelloName();
	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus arg1) {
	EventATNMonitor eventAtnMonitor = clientFactory.getAtnMonitor();

	eventAtnMonitor.setPresenter(this);
	containerWidget.setWidget(eventAtnMonitor.asWidget());

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
