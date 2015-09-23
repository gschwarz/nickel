package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.ProcessSchedulerPlace;
import com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerView;

public class ProcessSchedulerActivity extends AbstractActivity implements ProcessSchedulerView.Presenter {

    // Used to obtain views, eventBus, placeControllerView
    // Alternatively, could be injected via GIN
    private ClientFactory clientFactory;

    public ProcessSchedulerActivity(ProcessSchedulerPlace place, ClientFactory clientFactory) {
	// this.name = place.getHelloName();
	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
	ProcessSchedulerView processScheduler = clientFactory.getProcessSchedulertView();

	processScheduler.setPresenter(this);
	containerWidget.setWidget(processScheduler.asWidget());

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
