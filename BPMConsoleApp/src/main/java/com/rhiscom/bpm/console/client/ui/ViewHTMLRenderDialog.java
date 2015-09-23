package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.shared.ApplicationContext;

public class ViewHTMLRenderDialog extends DialogBox {

    public ViewHTMLRenderDialog(String html) {
	// Set the dialog box's caption.
	setText(LocaleMessages.LANG.information());

	// Enable animation.
	setAnimationEnabled(false);

	// Enable glass background.
	setGlassEnabled(true);

	// Label label = new Label("Consulta enviada al servidor");

	final Hidden user = new Hidden();
	final Hidden password = new Hidden();

	user.setName("user");
	user.setValue(ApplicationContext.getAuth().getUser());
	password.setValue(ApplicationContext.getAuth().getPass());
	password.setName("password");

	Button ok = new Button(LocaleMessages.LANG.accept());
	ok.addClickHandler(new ClickHandler() {
	    public void onClick(ClickEvent event) {
		ViewHTMLRenderDialog.this.hide();
	    }
	});

	VerticalPanel panel = new VerticalPanel();
	HTMLPanel htmlPanel = new HTMLPanel(html);

	panel.setHeight("500px");
	panel.setWidth("800px");

	panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);

	panel.add(htmlPanel);
	panel.add(ok);
	panel.add(user);
	panel.add(password);

	final FormPanel form = new FormPanel();

	form.setAction("BPMConsoleApp/complete");
	form.setHeight("475px");
	form.setWidth("800px");

	form.addSubmitHandler(new FormPanel.SubmitHandler() {
	    @Override
	    public void onSubmit(SubmitEvent event) {
		// This event is fired just before the form is submitted.
		// We can take this opportunity to perform validation.

		// event.cancel();

	    }
	});

	form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
	    @Override
	    public void onSubmitComplete(SubmitCompleteEvent event) {
		// When the form submission is successfully completed,
		// this event is fired. Assuming the service returned
		// a response of type text/html, we can get the result
		// here.
		// Window.alert(event.getResults());
	    }
	});
	form.add(panel);
	setWidget(form);
    }
}
