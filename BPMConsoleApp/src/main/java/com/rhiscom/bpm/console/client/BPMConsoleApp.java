package com.rhiscom.bpm.console.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.rhiscom.bpm.console.client.event.LoginEvent;
import com.rhiscom.bpm.console.client.event.LoginEventHandler;
import com.rhiscom.bpm.console.client.mapper.AppActivityMapper;
import com.rhiscom.bpm.console.client.mapper.AppPlaceHistoryMapper;
import com.rhiscom.bpm.console.client.place.RootPlace;
import com.rhiscom.bpm.console.client.remote.LoginService;
import com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl;
import com.rhiscom.bpm.console.client.ui.widget.SimpleWidgetPanel;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.Authentication;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public class BPMConsoleApp implements EntryPoint {

    private Place defaultPlace = new RootPlace("rootview");

    private SimpleWidgetPanel appWidget = new SimpleWidgetPanel();
    LoginPanelViewImpl login;

    public void onModuleLoad() {

	Scheduler.get().scheduleDeferred(new Command() {

	    public void execute() {

		DOM.getElementById("splash_loading").getStyle().setProperty("display", "none");
		DOM.getElementById("splash").getStyle().setProperty("zIndex", "-1");

	    }
	});
	String sessionID = null;
	sessionID = Cookies.getCookie("sid");

	EventBus eventBusLogin = new SimpleEventBus();
	login = new LoginPanelViewImpl(null, eventBusLogin);

	eventBusLogin.addHandler(LoginEvent.TYPE, new LoginEventHandler() {

	    @Override
	    public void login(LoginEvent event) {

		createUi();

	    }
	});

	if (sessionID == null || sessionID.compareToIgnoreCase("null") == 0) {
	    RootLayoutPanel.get().add(login);

	} else {
	    checkWithServerIfSessionIdIsStillLegal(sessionID);
	}
    }

    private void checkWithServerIfSessionIdIsStillLegal(String sessionID) {
	LoginService.Util.getInstance().loginFromSessionServer(new AsyncCallback<OperatorDTO>() {
	    @Override
	    public void onFailure(Throwable caught) {
		RootLayoutPanel.get().add(login);
	    }

	    @Override
	    public void onSuccess(OperatorDTO result) {
		if (result == null) {
		    RootLayoutPanel.get().add(login);
		} else {
		    if (result.isLoggedIn()) {
			Authentication auth = new Authentication();

			auth.setOperator(result);
			auth.setUser(result.getUser());
			auth.setPass(result.getPassword());
			auth.setStatus(true);

			ApplicationContext.setAuth(auth);
			createUi();
		    } else {
			RootLayoutPanel.get().add(login);
		    }
		}
	    }

	});
    }

    private void createUi() {
	PermisionUtil.getInstance();
	final ClientFactory clientFactory = GWT.create(ClientFactory.class);
	EventBus eventBus = clientFactory.getEventBus();
	LocalDataBaseObject.getInstance(clientFactory);
	PlaceController placeController = clientFactory.getPlaceController();

	// Start ActivityManager for the main widget with our
	// ActivityMapper
	ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
	ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
	activityManager.setDisplay(appWidget);

	// Start PlaceHistoryHandler with our PlaceHistoryMapper
	AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
	PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
	historyHandler.register(placeController, eventBus, defaultPlace);
	try {
	    RootLayoutPanel.get().add(appWidget);
	} catch (Exception ex) {

	}

	historyHandler.handleCurrentHistory();
    }

}
