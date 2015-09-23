package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class LoadingWidget extends SimplePanel {

    public LoadingWidget() {

	setWidth("300");
	HTMLPanel panel = new HTMLPanel("<img src='img/ajax-loader.gif'/>");
	this.add(panel);

    }
}
