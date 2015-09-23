package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.ProcessManagementPlace;
import com.rhiscom.bpm.console.client.ui.process.ProcessManagementView;

public class ProcessManagementViewActivity extends AbstractActivity implements ProcessManagementView.Presenter {

    // Used to obtain views, eventBus, placeControllerView
    // Alternatively, could be injected via GIN
    private ClientFactory clientFactory;

    public ProcessManagementViewActivity(ProcessManagementPlace place, ClientFactory clientFactory) {
	// this.name = place.getHelloName();
	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
	ProcessManagementView processConsoleCellTableView = clientFactory.getProcessConsoleManagementView();

	processConsoleCellTableView.setPresenter(this);
	containerWidget.setWidget(processConsoleCellTableView.asWidget());

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
