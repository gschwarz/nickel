package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.event.dom.client.ContextMenuHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMService;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.InstancesRS;
import com.rhiscom.bpm.console.shared.model.rs.UserTaskVO;

public class ProcessWidget extends Composite implements ContextMenuHandler {

    private static final Binder binder = GWT.create(Binder.class);
    @UiField
    Label processName;
    final ConsoleBPMServiceAsync consoleBPMService = GWT.create(ConsoleBPMService.class);
    private PopupPanel contextMenu;
    private ViewProcessHTMLRenderDialog dialogRender;

    interface Binder extends UiBinder<Widget, ProcessWidget> {
    }

    public ProcessWidget(final DefinitionsRS definition) {
	this.contextMenu = new PopupPanel(true);
	this.contextMenu.add(new HTML("My Context menu!"));
	this.contextMenu.hide();

	initWidget(binder.createAndBindUi(this));
	processName.setText(definition.getName());

	addDomHandler(this, ContextMenuEvent.getType());
	addDomHandler(new DoubleClickHandler() {

	    @Override
	    public void onDoubleClick(DoubleClickEvent event) {

		if (definition.getFormUrl() == null) {

		    consoleBPMService.startInstace(definition, new AsyncCallback<InstancesRS>() {

			@Override
			public void onFailure(Throwable ex) { // TODO
			    InformationDialog dialog = new InformationDialog("Error iniciar proceso :" + ex.toString());
			    dialog.center();
			    dialog.show();

			}

			@Override
			public void onSuccess(InstancesRS instances) {

			}

		    });

		} else {
		    UserTaskVO userTaskVO = new UserTaskVO(ApplicationContext.getAuth().getUser(), ApplicationContext
			    .getAuth().getPass());
		    consoleBPMService.getProcessRenderHTML(definition, userTaskVO, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable ex) { // TODO

			}

			@Override
			public void onSuccess(String html) {
			    dialogRender = new ViewProcessHTMLRenderDialog(html);
			    dialogRender.center();
			    dialogRender.show();

			}

		    });
		}
	    }
	}, DoubleClickEvent.getType());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.google.gwt.event.dom.client.ContextMenuHandler#onContextMenu(com.
     * google.gwt.event.dom.client.ContextMenuEvent)
     */
    @Override
    public void onContextMenu(ContextMenuEvent event) {
	// event.preventDefault();
	// event.stopPropagation();
	// this.contextMenu.setPopupPosition(event.getNativeEvent().getClientX(),
	// event.getNativeEvent().getClientY());
	// this.contextMenu.show();
    }

}
