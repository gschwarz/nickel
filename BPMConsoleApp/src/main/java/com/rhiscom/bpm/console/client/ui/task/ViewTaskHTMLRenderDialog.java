package com.rhiscom.bpm.console.client.ui.task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMService;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.model.dto.TaskCommentDTO;

public class ViewTaskHTMLRenderDialog extends DialogBox {

    private static final Binder binder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Widget, ViewTaskHTMLRenderDialog> {
    }

    @UiField(provided = true)
    VerticalPanel verticalPanelForm;

    @UiField
    Button btnAceptar;
    @UiField(provided = true)
    Hidden user;
    @UiField(provided = true)
    Hidden password;
    private InformationDialog dialog;
    @UiField
    TextArea txtComentario;
    private String taskId;

    final ConsoleBPMServiceAsync consoleBPMService = GWT.create(ConsoleBPMService.class);

    public ViewTaskHTMLRenderDialog(String html, String taskIdRemote) {

	this.taskId = taskIdRemote;
	setAnimationEnabled(false);
	setGlassEnabled(true);
	setText("Completar Tarea");

	user = new Hidden();
	password = new Hidden();

	user.setName("user");
	user.setValue(ApplicationContext.getAuth().getUser());
	password.setValue(ApplicationContext.getAuth().getPass());
	password.setName("password");

	verticalPanelForm = new VerticalPanel();
	Frame frame = new Frame(html);
	frame.setHeight("400px");
	frame.setWidth("100%");
	verticalPanelForm.setHeight("400px");
	verticalPanelForm.setWidth("100%");

	verticalPanelForm.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	verticalPanelForm.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);

	verticalPanelForm.add(frame);

	setWidget(binder.createAndBindUi(this));

    }

    @UiHandler("btnAceptar")
    void onClickAceptar(ClickEvent e) {

	this.hide();

    }

    /**
     * Metodo que agrega un comentario a la tarea.
     * 
     */
    public void agregarComentario(TaskCommentDTO comment) {
	final Notification not = new Notification(true, true);
	try {

	    consoleBPMService.addTaskComment(comment, new AsyncCallback() {

		@Override
		public void onFailure(Throwable arg0) {

		}

		@Override
		public void onSuccess(Object arg0) {
		    // TODO Auto-generated method stub

		}

	    });
	} catch (Exception ex) {
	}
    }
}
