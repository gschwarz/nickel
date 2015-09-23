package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.UserMaintainerCellTablePlace;
import com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableView;

public class UserMaintainerCellTableActivity extends AbstractActivity implements
	UserMaintainerCellTableView.Presenter {
    private ClientFactory clientFactory;

    public UserMaintainerCellTableActivity(UserMaintainerCellTablePlace place, ClientFactory clientFactory) {
	// this.name = place.getHelloName();
	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus arg1) {
	UserMaintainerCellTableView view = clientFactory.getUserMaintainerCellTableView();

	view.setPresenter(this);
	containerWidget.setWidget(view.asWidget());

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