package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.rs.TaskRS;

public class WidgetBuilder {
    /**
     * M�todo que genera tabla con resultados de los estados de las tiendas.
     * 
     * @return
     */
    static DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy hh:mm:ss");

    public static CellTable<NodeInstanceLogDTO> createProcessInstancesTable() {
	final CellTable<NodeInstanceLogDTO> table = new CellTable<NodeInstanceLogDTO>();
	// Create name column.
	table.setWidth("350px");
	TextColumn<NodeInstanceLogDTO> nodeName = new TextColumn<NodeInstanceLogDTO>() {
	    @Override
	    public String getValue(NodeInstanceLogDTO definition) {

		return String.valueOf(definition.getNodeName() + " - " + fmtDate.format(definition.getLogDate()));
	    }
	};

	// Add the columns.

	table.addColumn(nodeName, "Historial");

	table.setColumnWidth(nodeName, 100.0, Unit.PCT);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    public static CellTable<TaskRS> createTaskAsignedCellTable() {
	final CellTable<TaskRS> table = new CellTable<TaskRS>();
	// Create name column.
	TextColumn<TaskRS> identificadorInstancia = new TextColumn<TaskRS>() {
	    @Override
	    public String getValue(TaskRS definition) {
		return String.valueOf(definition.getId());
	    }
	};

	TextColumn<TaskRS> nombreTarea = new TextColumn<TaskRS>() {
	    @Override
	    public String getValue(TaskRS definition) {
		return String.valueOf(definition.getName());
	    }
	};

	// Create address column.
	TextColumn<TaskRS> procesoAsociado = new TextColumn<TaskRS>() {
	    @Override
	    public String getValue(TaskRS definition) {
		return definition.getProcessId();
	    }
	};

	TextColumn<TaskRS> estado = new TextColumn<TaskRS>() {
	    @Override
	    public String getValue(TaskRS definition) {
		return definition.getCurrentState();
	    }
	};

	Column<TaskRS, String> verTareaBtn = new Column<TaskRS, String>(new ButtonCell()) {

	    @Override
	    public String getValue(TaskRS c) {

		return "Actualizar";

	    }

	};
	verTareaBtn.setCellStyleNames("buttonActualizar");

	verTareaBtn.setFieldUpdater(new FieldUpdater<TaskRS, String>() {

	    @Override
	    public void update(int index, TaskRS object, String value) {
		// generarConsultarEstadoPorTienda(String.valueOf(object.getId()));
	    }

	});

	// Add the columns.

	table.addColumn(identificadorInstancia, "Id");
	table.addColumn(procesoAsociado, "Proceso");
	table.addColumn(nombreTarea, "Tarea");
	table.addColumn(estado, "Estado");
	table.addColumn(verTareaBtn, "Ver tarea");

	table.setColumnWidth(identificadorInstancia, 120.0, Unit.PX);
	table.setColumnWidth(procesoAsociado, 150.0, Unit.PX);
	table.setColumnWidth(nombreTarea, 150.0, Unit.PX);
	table.setColumnWidth(estado, 120.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }
}
