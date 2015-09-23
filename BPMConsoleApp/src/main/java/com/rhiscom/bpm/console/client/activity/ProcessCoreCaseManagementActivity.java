package com.rhiscom.bpm.console.client.activity;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.place.ProcessCoreCaseManagementPlace;
import com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementView;

public class ProcessCoreCaseManagementActivity extends AbstractActivity implements
	ProcessCoreCaseManagementView.Presenter {
    static Logger logger = Logger.getLogger(ProcessCoreCaseManagementActivity.class.getName());
    private ClientFactory clientFactory;

    public ProcessCoreCaseManagementActivity(ProcessCoreCaseManagementPlace place, ClientFactory clientFactory) {
	// this.name = place.getHelloName();
	this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus arg1) {
	logger.log(Level.INFO, "::start::");
	ProcessCoreCaseManagementView processCoreCaseManagementView = clientFactory.getProcessCoreCaseManagementView();

	processCoreCaseManagementView.setPresenter(this);
	containerWidget.setWidget(processCoreCaseManagementView.asWidget());

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
