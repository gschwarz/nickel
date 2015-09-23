package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.mapper.LeftSideActivityMapper;
import com.rhiscom.bpm.console.client.mapper.RightActivityMapper;
import com.rhiscom.bpm.console.client.remote.LoginService;
import com.rhiscom.bpm.console.shared.ApplicationContext;

public class RootView extends Composite implements MainView {

    private static RootViewUiBinder uiBinder = GWT.create(RootViewUiBinder.class);

    interface RootViewUiBinder extends UiBinder<Widget, RootView> {
    }

    Presenter presenter;
    private ClientFactory clientFactory;

    @UiField
    SimplePanel leftPanel;
    @UiField
    ScrollPanel rightPanel;
    @UiField(provided = true)
    Label userLogged;
    @UiField(provided = true)
    Image logoutButton;
    
    public RootView(final ClientFactory clientFactory) {
	this.clientFactory = clientFactory;
	
	// north panel 
	userLogged = new Label();
	userLogged.setWidth("90px");
	userLogged.setText(ApplicationContext.getAuth().getUser());

	logoutButton = new Image();
	logoutButton.addClickHandler(new ClickHandler() {
	    
	    @Override
	    public void onClick(ClickEvent event) {
		LoginService.Util.getInstance().logout(new AsyncCallback() {
		    @Override
		    public void onFailure(Throwable arg0) {
			Window.alert("No fue posible cerrar la sesión");
		    }

		    @Override
		    public void onSuccess(Object arg0) {
			Window.Location.reload();
		    }
		});
	    }
	});
	initWidget(uiBinder.createAndBindUi(this));

	// Start ActivityManager for the main widget with our ActivityMapper
	ActivityMapper leftActivityMapper = new LeftSideActivityMapper(clientFactory);
	ActivityManager leftActivityManager = new ActivityManager(leftActivityMapper, this.clientFactory.getEventBus());
	leftActivityManager.setDisplay(leftPanel);

	leftPanel.getElement().setId("menu-left");
	
	// right side
	ActivityMapper rightActivityMapper = new RightActivityMapper(clientFactory);
	ActivityManager rightActivityManager = new ActivityManager(rightActivityMapper,
		this.clientFactory.getEventBus());
	rightActivityManager.setDisplay(rightPanel);

	// check to see if local storage API can be used!
	// TODO: How to make application work offline!!!?!?!?
	if (Storage.isSupported()) {
	    // Window.alert("This browser supports local storage");

	    // OK if suport then get somethign from there

	    Storage localStorage = Storage.getLocalStorageIfSupported();
	    localStorage.setItem("myitem", "offline value");

	} else {
	    Window.alert("No local storage support");
	}

    }

    @Override
    public void setWidgetName(String widgetName) {

    }

    @Override
    public void setPresenter(Presenter presenter) {
	this.presenter = presenter;
    }

    @Override
    public ClientFactory getClientFactory() {
	return clientFactory;
    }

}
