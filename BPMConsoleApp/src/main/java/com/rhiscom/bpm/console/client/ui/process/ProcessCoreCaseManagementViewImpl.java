package com.rhiscom.bpm.console.client.ui.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMService;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMServiceAsync;
import com.rhiscom.bpm.console.client.remote.DespachoDomicilioService;
import com.rhiscom.bpm.console.client.remote.DespachoDomicilioServiceAsync;
import com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO;
import com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS;

public class ProcessCoreCaseManagementViewImpl extends Composite implements ProcessCoreCaseManagementView {

    private static final Binder binder = GWT.create(Binder.class);
    @UiField
    ListBox lstProcesos;
    @UiField
    Button btnBuscar;
    @UiField
    SimplePanel formWidget;
    @UiField
    FlexTable flexProcessTable;
    @UiField
    TextBox txtCaso;

    interface Binder extends UiBinder<Widget, ProcessCoreCaseManagementViewImpl> {
    }

    final ConsoleBPMServiceAsync consoleBPMService = GWT.create(ConsoleBPMService.class);
    final DespachoDomicilioServiceAsync despachoDomicilioService = GWT.create(DespachoDomicilioService.class);
    final ListDataProvider<DefinitionsRS> definitionList = new ListDataProvider<DefinitionsRS>();
    private Map<Integer, String> mapDefiniciones = new HashMap<Integer, String>();

    public ProcessCoreCaseManagementViewImpl() {
	initWidget(binder.createAndBindUi(this));

	traerDefinicionesDeProcesos();
    }

    /**
     * Metodo que consulta todos los procesos existentes.
     * 
     * @param tienda
     * @param fechaConsulta
     */
    public void traerDefinicionesDeProcesos() {
	try {

	    definitionList.setList(new ArrayList<DefinitionsRS>());
	    definitionList.refresh();
	    // cellList.redraw();

	    consoleBPMService.getDefinitions(new AsyncCallback<ProcessDefinitionsRS>() {

		@Override
		public void onFailure(Throwable ex) {

		}

		@Override
		public void onSuccess(ProcessDefinitionsRS processDefinitionsRS) {

		    List<DefinitionsRS> listDefinitionsRS = new ArrayList<DefinitionsRS>();

		    listDefinitionsRS.addAll(processDefinitionsRS.getDefinitions());
		    int i = 0;
		    for (Iterator iterator = processDefinitionsRS.getDefinitions().iterator(); iterator.hasNext();) {
			DefinitionsRS type = (DefinitionsRS) iterator.next();

			lstProcesos.addItem(type.getName(), type.getId());
			i++;
		    }

		}

	    });
	} catch (Exception ex) {
	}
    }

    @UiHandler("btnBuscar")
    void onClickGuardar(ClickEvent e) {

	try {

	    long idVenta = Long.valueOf(txtCaso.getText()).longValue();
	    despachoDomicilioService.traerVentaPorId(idVenta, new AsyncCallback<VentaDomicilioDTO>() {

		@Override
		public void onFailure(Throwable ex) {

		}

		@Override
		public void onSuccess(VentaDomicilioDTO dto) {
		    DespachoDomicilioFormWidget form = new DespachoDomicilioFormWidget(dto);
		    flexProcessTable.setWidget(0, 0, form);
		    flexProcessTable.getFlexCellFormatter().setStyleName(0, 0, "demo-table-cell");
		}

	    });
	} catch (Exception ex) {
	}
    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }
}
