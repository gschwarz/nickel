package com.rhiscom.bpm.console.client;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.ListDataProvider;
import com.rhiscom.bpm.console.shared.model.POSProcessStatus;

public class RefreshDataCommand {

	public void refreshTable(final CellTable<POSProcessStatus> table,
			final ListDataProvider<POSProcessStatus> dataProvider,
			final MonitoreoServiceAsync monitoreoService) {

		/*
		 * monitoreoService .traerListadoEventos(new
		 * AsyncCallback<List<POSProcessStatus>>() { public void
		 * onFailure(Throwable caught) { // Show the RPC error message to the
		 * user
		 * 
		 * }
		 * 
		 * @Override public void onSuccess(List<POSProcessStatus> result) { //
		 * List<POSProcessStatus> list = dataProvider.getList();
		 * dataProvider.setList(result); dataProvider.refresh(); table.redraw();
		 * 
		 * } });
		 */
	}
}
