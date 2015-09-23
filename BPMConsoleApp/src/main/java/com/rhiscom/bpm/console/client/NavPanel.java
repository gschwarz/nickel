package com.rhiscom.bpm.console.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class NavPanel extends Composite {

	private static NavPanelUiBinder uiBinder = GWT
			.create(NavPanelUiBinder.class);

	public DeckLayoutPanel content = new DeckLayoutPanel();

	interface NavPanelUiBinder extends UiBinder<Widget, NavPanel> {
	}

	@UiField
	Button servicios;
	@UiField
	Button estados;

	public NavPanel() {
		initWidget(uiBinder.createAndBindUi(this));

		servicios.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

			}
		});
		estados.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

			}
		});
	}
}
