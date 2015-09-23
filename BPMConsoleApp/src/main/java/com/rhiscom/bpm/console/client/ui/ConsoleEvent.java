package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent;

import de.novanic.eventservice.client.event.Event;
import de.novanic.eventservice.client.event.RemoteEventService;
import de.novanic.eventservice.client.event.RemoteEventServiceFactory;
import de.novanic.eventservice.client.event.listener.RemoteEventListener;

public class ConsoleEvent extends Composite implements HasText {

	private static ConsoleEventUiBinder uiBinder = GWT
			.create(ConsoleEventUiBinder.class);

	interface ConsoleEventUiBinder extends UiBinder<Widget, ConsoleEvent> {
	}

	@UiField(provided = true)
	ListBox myEventReceiveBoxUI;

	public ConsoleEvent() {

		RemoteEventService theRemoteEventService = RemoteEventServiceFactory
				.getInstance().getRemoteEventService();
		// add a listener to the SERVER_MESSAGE_DOMAIN
		theRemoteEventService.addListener(
				ServerGeneratedMessageEvent.SERVER_MESSAGE_DOMAIN,
				new RemoteEventListener() {
					public void apply(Event anEvent) {
						if (anEvent instanceof ServerGeneratedMessageEvent) {
							ServerGeneratedMessageEvent theServerGeneratedMessageEvent = (ServerGeneratedMessageEvent) anEvent;
							myEventReceiveBoxUI
									.addItem(theServerGeneratedMessageEvent
											.getServerGeneratedMessage());
						}
					}
				});

		myEventReceiveBoxUI = new ListBox(true);

		initWidget(uiBinder.createAndBindUi(this));
		myEventReceiveBoxUI.setSize("100%", "100%");
		myEventReceiveBoxUI.addItem("Listening for events...");

	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String arg0) {
		// TODO Auto-generated method stub

	}

}
