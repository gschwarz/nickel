package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.rhiscom.bpm.console.client.LocaleMessages;

public class InformationDialog extends DialogBox {

    public InformationDialog(String html) {

	// Set the dialog box's caption.
	setText(LocaleMessages.LANG.information());

	// Enable animation.
	setAnimationEnabled(false);

	// Enable glass background.
	setGlassEnabled(true);

	Label label = new Label(html);

	Button ok = new Button(LocaleMessages.LANG.accept());
	ok.addClickHandler(new ClickHandler() {
	    public void onClick(ClickEvent event) {
		InformationDialog.this.hide();

	    }
	});

	VerticalPanel panel = new VerticalPanel();
	VerticalPanel panelH = new VerticalPanel();

	panel.setHeight("100px");
	panel.setWidth("180px");

	panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

	panel.add(label);
	panelH.setHeight("40px");
	panel.add(panelH);
	panel.add(ok);

	setWidget(panel);
    }

    public InformationDialog() {
	// TODO Auto-generated constructor stub
    }
}
