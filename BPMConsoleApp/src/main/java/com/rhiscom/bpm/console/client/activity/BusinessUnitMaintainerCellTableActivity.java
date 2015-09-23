package com.rhiscom.bpm.console.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.BusinessUnitMaintainerCellTablePlace;
import com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableView;

public class BusinessUnitMaintainerCellTableActivity extends AbstractActivity implements
	BusinessUnitMaintainerCellTableView.Presenter {

    private ClientFactory clientFactory;

    public BusinessUnitMaintainerCellTableActivity(BusinessUnitMaintainerCellTablePlace place,
	    ClientFactory clientFactory) {

	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus arg1) {
	BusinessUnitMaintainerCellTableView businessUnitMaintainerCellTableView = clientFactory
		.getBusinessUnitView();

	businessUnitMaintainerCellTableView.setPresenter(this);
	containerWidget.setWidget(businessUnitMaintainerCellTableView.asWidget());

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