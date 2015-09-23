package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.UnassignedTaskConsoleCellTablePlace;
import com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableView;

public class UnassignedTaskConsoleCellTableActivity extends AbstractActivity implements
	UnassignedTaskConsoleCellTableView.Presenter {

    private ClientFactory clientFactory;

    public UnassignedTaskConsoleCellTableActivity(UnassignedTaskConsoleCellTablePlace place,
	    ClientFactory clientFactory) {
	// this.name = place.getHelloName();
	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus arg1) {
	UnassignedTaskConsoleCellTableView asignedTaskConsoleCellTableView = clientFactory
		.getUnassignedTaskConsoleCellTableView();

	asignedTaskConsoleCellTableView.setPresenter(this);
	containerWidget.setWidget(asignedTaskConsoleCellTableView.asWidget());

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
