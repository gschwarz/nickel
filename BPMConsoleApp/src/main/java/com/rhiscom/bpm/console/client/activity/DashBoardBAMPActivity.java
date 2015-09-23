package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.DashBoardBAMPlace;
import com.rhiscom.bpm.console.client.ui.bam.DashBoardBAM;

public class DashBoardBAMPActivity extends AbstractActivity implements DashBoardBAM.Presenter {

    private ClientFactory clientFactory;

    public DashBoardBAMPActivity(DashBoardBAMPlace place, ClientFactory clientFactory) {
	// this.name = place.getHelloName();
	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {

	DashBoardBAM dashBoardHomeView = clientFactory.getDashBoardBAM();
	dashBoardHomeView.setPresenter(this);
	containerWidget.setWidget(dashBoardHomeView.asWidget());

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
