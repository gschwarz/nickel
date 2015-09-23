package com.rhiscom.bpm.console.client.ui.process;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SingleSelectionModel;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMService;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMServiceAsync;
import com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS;

public class ProcessManagementViewImpl extends Composite implements ProcessManagementView {

    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    FlexTable flexProcessTable;
    // CellList<DefinitionsRS> cellList;
    @UiField
    MenuItem btnRefrescar;

    final ListDataProvider<DefinitionsRS> definitionList = new ListDataProvider<DefinitionsRS>();
    final ConsoleBPMServiceAsync consoleBPMService = GWT.create(ConsoleBPMService.class);
    final FlexTable flexTable = new FlexTable();
    DefinitionsRS definitionSelected;
    private ViewProcessHTMLRenderDialog dialogRender;
    private int columns = 10;

    interface Binder extends UiBinder<Widget, ProcessManagementViewImpl> {
    }

    public ProcessManagementViewImpl() {

	ProvidesKey<DefinitionsRS> keyProvider = new ProvidesKey<DefinitionsRS>() {
	    public Object getKey(DefinitionsRS item) {
		// Always do a null check.
		return (item == null) ? null : item.getId();
	    }
	};
	final SingleSelectionModel<DefinitionsRS> selectionModelInstancesRS = new SingleSelectionModel<DefinitionsRS>();
	// cellList = new CellList<DefinitionsRS>(new
	// ProcessCell(Resource.INSTANCE.ProcessAccept()), keyProvider);
	// cellList.setSelectionModel(selectionModelInstancesRS);

	// cellList.addDomHandler(new DoubleClickHandler() {
	//
	// @Override
	// public void onDoubleClick(DoubleClickEvent event) {
	//
	// consoleBPMService.getProcessRenderHTML(definitionSelected, new
	// AsyncCallback<String>() {
	//
	// @Override
	// public void onFailure(Throwable ex) { // TODO
	//
	// }
	//
	// @Override
	// public void onSuccess(String html) {
	// dialogRender = new ViewProcessHTMLRenderDialog(html);
	// dialogRender.center();
	// dialogRender.show();
	//
	// }
	//
	// });
	// }
	// }, DoubleClickEvent.getType());
	// cellList.addCellPreviewHandler(new
	// CellPreviewEvent.Handler<DefinitionsRS>() {
	//
	// @Override
	// public void onCellPreview(CellPreviewEvent<DefinitionsRS> event) {
	//
	// if (event.getNativeEvent().getType().contains("click")
	// || event.getNativeEvent().getType().contains("mousedown")) {
	//
	// definitionSelected = event.getValue();
	//
	// }
	// }
	// });
	// definitionList.addDataDisplay(cellList);
	// flexTable.setWidget(0, 1, cellList);

	initWidget(binder.createAndBindUi(this));

	traerDefinicionesDeProcesos();

	btnRefrescar.setCommand(cmdRefrescarDefiniciones);
    }

    Command cmdRefrescarDefiniciones = new Command() {
	public void execute() {

	    traerDefinicionesDeProcesos();

	}
    };

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
		    /*
		     * InformationDialog dialog = new InformationDialog(
		     * "Error al consultar definiciones de procesos :" +
		     * ex.toString()); dialog.center(); dialog.show();
		     */
		}

		@Override
		public void onSuccess(ProcessDefinitionsRS processDefinitionsRS) {

		    List<DefinitionsRS> listDefinitionsRS = new ArrayList<DefinitionsRS>();

		    listDefinitionsRS.addAll(processDefinitionsRS.getDefinitions());

		    definitionList.setList(listDefinitionsRS);
		    definitionList.refresh();

		    int row = 0;
		    int col = 0;
		    for (int i = 0; i <= listDefinitionsRS.size() - 1; i++) {

			flexProcessTable.setWidget(row, col, new ProcessWidget(listDefinitionsRS.get(i)));
			flexProcessTable.getFlexCellFormatter().setStyleName(row, col, "demo-table-cell");
			col++;
			if (col == 5) {
			    row++;
			    col = 0;
			}

		    }
		    // cellList.redraw();
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
