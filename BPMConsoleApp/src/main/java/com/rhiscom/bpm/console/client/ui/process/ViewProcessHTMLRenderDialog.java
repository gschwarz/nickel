package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.shared.ApplicationContext;

public class ViewProcessHTMLRenderDialog extends DialogBox {

    private static ViewProcessHTMLRenderDialogUiBinder uiBinder = GWT.create(ViewProcessHTMLRenderDialogUiBinder.class);

    private InformationDialog dialog;

    interface ViewProcessHTMLRenderDialogUiBinder extends UiBinder<Widget, ViewProcessHTMLRenderDialog> {
    }

    @UiField(provided = true)
    VerticalPanel verticalPanelForm;

    @UiField
    Button btnAceptar;
    @UiField(provided = true)
    Hidden user;
    @UiField(provided = true)
    Hidden password;

    public ViewProcessHTMLRenderDialog(String html) {

	setAnimationEnabled(false);
	setGlassEnabled(true);
	setText("Iniciar Procesos");

	user = new Hidden();
	password = new Hidden();

	user.setName("user");
	user.setValue(ApplicationContext.getAuth().getUser());
	password.setValue(ApplicationContext.getAuth().getPass());
	password.setName("password");

	Frame f = new Frame(html);
	f.setWidth("100%");
	f.setHeight("490px");
	verticalPanelForm = new VerticalPanel();

	verticalPanelForm.setHeight("500px");
	verticalPanelForm.setWidth("100%");
	verticalPanelForm.add(f);
	verticalPanelForm.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	verticalPanelForm.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);

	setWidget(uiBinder.createAndBindUi(this));

    }

    @UiHandler("btnAceptar")
    void onClickAceptar(ClickEvent e) {

	this.hide();

    }
}
