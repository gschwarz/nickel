package com.rhiscom.bpm.console.client.ui.widget;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class Notification extends PopupPanel {

    public Notification(boolean autoHide, boolean modal) {
	super(autoHide, modal);

	setAnimationEnabled(true);

    }

    public static final String OK = "OK";
    public static final String NOK = "NOK";
    public static final String WARNING = "WARN";

    public void show(int delayMilliseconds, String text, String type) {
	HorizontalPanel panel = new HorizontalPanel();
	panel.setSpacing(2);
	panel.setWidth("170px");
	panel.setHeight("40px");
	Image i = new Image();
	if (type.compareToIgnoreCase("OK") == 0) {
	    i.setUrl("img/success.png");
	} else if (type.compareToIgnoreCase("WARN") == 0) {
	    i.setUrl("img/warning.png");
	} else {
	    i.setUrl("img/warning.png");
	}
	i.setWidth("23px");
	panel.add(i);
	Label l = new Label(text);
	l.setStyleName("notification-text");
	panel.add(l);
	setWidget(panel);
	setHeight("46px");
	setWidth("170px");
	setStyleName("notification");
	int windowHeight = Window.getClientHeight();
	int windowWidth = Window.getClientWidth();
	this.setPopupPosition(windowWidth - 185, windowHeight - 69);
	show();

	Timer t = new Timer() {
	    @Override
	    public void run() {
		Notification.this.hide();
	    }
	};

	// Schedule the timer to close the popup in 3 seconds.
	t.schedule(delayMilliseconds);
    }
}
