package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.rhiscom.bpm.console.shared.ApplicationContext;

public class SimpleRenderHTMLProcess extends SimplePanel {
    Hidden user;
    Hidden password;
    FormPanel formComplete;
    VerticalPanel verticalPanelForm;
    HTMLPanel htmlPanel;

    public SimpleRenderHTMLProcess(String html) {
	VerticalPanel panel = new VerticalPanel();
	user = new Hidden();
	password = new Hidden();

	user.setName("user");
	user.setValue(ApplicationContext.getAuth().getUser());
	password.setValue(ApplicationContext.getAuth().getPass());
	password.setName("password");

	formComplete = new FormPanel();
	formComplete.setHeight("480px");
	formComplete.setWidth("800px");

	verticalPanelForm = new VerticalPanel();
	formComplete.setAction("BPMConsoleApp/complete");

	htmlPanel = new HTMLPanel(html);

	verticalPanelForm.setHeight("500px");
	verticalPanelForm.setWidth("800px");

	verticalPanelForm.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	verticalPanelForm.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);

	verticalPanelForm.add(htmlPanel);

	panel.add(verticalPanelForm);
	panel.add(formComplete);
	formComplete.addSubmitHandler(new FormPanel.SubmitHandler() {
	    @Override
	    public void onSubmit(SubmitEvent event) {

	    }
	});

	formComplete.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
	    @Override
	    public void onSubmitComplete(SubmitCompleteEvent event) {

		if (event.getResults().contains("Success")) {

		}

	    }
	});
	this.add(panel);
    }

}
