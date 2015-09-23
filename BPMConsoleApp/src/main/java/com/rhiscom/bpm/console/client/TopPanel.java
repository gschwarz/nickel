package com.rhiscom.bpm.console.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TopPanel extends Composite {

	interface Binder extends UiBinder<Widget, TopPanel> {
	}

	private static final Binder binder = GWT.create(Binder.class);

	@UiField
	Anchor signOutLink;
	@UiField
	Anchor aboutLink;

	public TopPanel() {
		initWidget(binder.createAndBindUi(this));
	}

	@UiHandler("aboutLink")
	void onAboutClicked(ClickEvent event) {
		// When the 'About' item is selected, show the AboutDialog.
		// Note that showing a dialog box does not block -- execution continues
		// normally, and the dialog fires an event when it is closed.

	}

	@UiHandler("signOutLink")
	void onSignOutClicked(ClickEvent event) {
		Window.alert("If this were implemented, you would be signed out now.");
	}
}