package com.rhiscom.bpm.console.client.ui.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMService;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.rs.TaskRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskUserRS;
import com.rhiscom.bpm.console.shared.model.rs.UserTaskVO;

public class UnassignedTaskConsoleCellTableViewImpl extends Composite implements UnassignedTaskConsoleCellTableView {

    Presenter presenter;
    String instance = "-1";

    @UiField(provided = true)
    CellTable<TaskRS> cellTableUnassignedAsignedTask;

    @UiField(provided = true)
    SimplePager pager;

    @UiField
    MenuItem btnRefrescar;

    final ListDataProvider<TaskRS> unassignedTaskDataProvider;
    private static DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd:hh:mm ");
    private static DateTimeFormat dateFormatView = DateTimeFormat.getFormat("dd/MM/yyyy hh:mm:ss");
    final ConsoleBPMServiceAsync consoleBPMService = GWT.create(ConsoleBPMService.class);
    private List<AbilityDTO> abilityList;

    private static UnassignedTaskConsoleCellTableViewImplUiBinder uiBinder = GWT
	    .create(UnassignedTaskConsoleCellTableViewImplUiBinder.class);

    interface UnassignedTaskConsoleCellTableViewImplUiBinder extends
	    UiBinder<Widget, UnassignedTaskConsoleCellTableViewImpl> {
    }

    public UnassignedTaskConsoleCellTableViewImpl() {

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	unassignedTaskDataProvider = new ListDataProvider<TaskRS>();
	cellTableUnassignedAsignedTask = this.createUnassignedTaskAsignedCellTable();

	unassignedTaskDataProvider.addDataDisplay(cellTableUnassignedAsignedTask);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTableUnassignedAsignedTask);

	initWidget(uiBinder.createAndBindUi(this));

	btnRefrescar.setCommand(cmdRefrescarTareasNoAsignadas);

	traerTareasNoAsignadas();

    }

    Command cmdRefrescarTareasNoAsignadas = new Command() {
	public void execute() {

	    traerTareasNoAsignadas();

	}
    };

    public CellTable<TaskRS> createUnassignedTaskAsignedCellTable() {
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
		StringBuffer buffer = new StringBuffer();
		try {
		    for (int i = 0; i <= definition.getName().length() - 1; i++) {
			char a = definition.getName().charAt(i);

			if (Character.isUpperCase(a) && i != 0) {
			    buffer.append(" ");
			}
			buffer.append(a);

		    }

		    return buffer.toString();

		} catch (Exception ex) {
		    return "";

		}
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

		if (definition.getCurrentState().compareToIgnoreCase("ASSIGNED") == 0)
		    return LocaleMessages.LANG.assigned();
		else if (definition.getCurrentState().compareTo("OPEN") == 0)
		    return LocaleMessages.LANG.available();
		else

		    return "";
	    }
	};

	TextColumn<TaskRS> fechaInicio = new TextColumn<TaskRS>() {
	    @Override
	    public String getValue(TaskRS definition) {

		return String.valueOf(dateFormatView.format(definition.getCreatedOn()));

	    }
	};

	TextColumn<TaskRS> tiempoTranscurrido = new TextColumn<TaskRS>() {
	    @Override
	    public String getValue(TaskRS definition) {

		Date now = new Date();
		Date createOn = definition.getCreatedOn();
		long dateFinal = now.getTime() - createOn.getTime();

		int seconds = (int) (dateFinal / 1000) % 60;
		int minutes = (int) ((dateFinal / (1000 * 60)) % 60);
		int hours = (int) ((dateFinal / (1000 * 60 * 60)) % 24);
		int days = (int) ((dateFinal / (1000 * 60 * 60 * 24)) % 7);

		return String.valueOf(days + "d " + hours + " hrs " + minutes + " mins");

	    }
	};

	Column<TaskRS, String> asignarTareaBtn = new Column<TaskRS, String>(new ButtonCell()) {

	    @Override
	    public String getValue(TaskRS c) {

		return LocaleMessages.LANG.assign();

	    }

	};
	asignarTareaBtn.setCellStyleNames("buttonAdd");

	asignarTareaBtn.setFieldUpdater(new FieldUpdater<TaskRS, String>() {

	    @Override
	    public void update(int index, TaskRS object, String value) {

		asignarTarea(object.getId());
	    }

	});

	// Add the columns.

	table.addColumn(identificadorInstancia, LocaleMessages.LANG.id());
	table.addColumn(procesoAsociado, LocaleMessages.LANG.process());
	table.addColumn(nombreTarea, LocaleMessages.LANG.task());
	table.addColumn(estado, LocaleMessages.LANG.status());
	table.addColumn(fechaInicio, LocaleMessages.LANG.startDate());
	table.addColumn(tiempoTranscurrido, LocaleMessages.LANG.elapsedTime());
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "asignarTareaBtn")) {
	    table.addColumn(asignarTareaBtn, " ");
	}

	table.setColumnWidth(identificadorInstancia, 10.0, Unit.PX);
	table.setColumnWidth(procesoAsociado, 220.0, Unit.PX);
	table.setColumnWidth(nombreTarea, 300.0, Unit.PX);
	table.setColumnWidth(estado, 100.0, Unit.PX);
	table.setColumnWidth(fechaInicio, 200.0, Unit.PX);
	table.setColumnWidth(tiempoTranscurrido, 200.0, Unit.PX);

	table.setColumnWidth(asignarTareaBtn, 130.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    /**
     * Método par asignar Tarea a un usuario cuando la selecciona.
     * 
     * @param idTask
     */
    private void asignarTarea(String idTask) {
	final Notification not = new Notification(true, true);
	try {
	    UserTaskVO userTaskVO = new UserTaskVO(ApplicationContext.getAuth().getUser(), ApplicationContext.getAuth()
		    .getPass());

	    consoleBPMService.assignedTask(userTaskVO, idTask, new AsyncCallback<String>() {

		@Override
		public void onFailure(Throwable arg0) {
		    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.taskNotAssigned());
		    dialog.center();
		    dialog.show();
		}

		@Override
		public void onSuccess(String arg0) {
		    not.show(5000, LocaleMessages.LANG.taskAssigned(), Notification.OK);
		    traerTareasNoAsignadas();
		}

	    });
	} catch (Exception ex) {

	}

    }

    /**
     * Metodo que consulta las tarea asignadas al usuario
     * 
     */
    public void traerTareasNoAsignadas() {
	final Notification not = new Notification(true, true);

	try {
	    UserTaskVO userTaskVO = new UserTaskVO(ApplicationContext.getAuth().getUser(), ApplicationContext.getAuth()
		    .getPass());

	    consoleBPMService.getListUnassignedTask(userTaskVO, new AsyncCallback<TaskUserRS>() {

		@Override
		public void onFailure(Throwable ex) {

		}

		@Override
		public void onSuccess(TaskUserRS taskUserRS) {

		    List<TaskRS> listDefinitionsRS = new ArrayList<TaskRS>();

		    for (Iterator<TaskRS> iterator = taskUserRS.getTasks().iterator(); iterator.hasNext();) {
			TaskRS type = (TaskRS) iterator.next();
			if (type.getCurrentState().compareTo("ASSIGNED") != 0) {
			    listDefinitionsRS.add(type);
			}
		    }
		    // listDefinitionsRS.addAll(taskUserRS.getTasks());

		    unassignedTaskDataProvider.setList(listDefinitionsRS);
		    unassignedTaskDataProvider.refresh();
		    cellTableUnassignedAsignedTask.redraw();
		    if (listDefinitionsRS.size() == 0) {
			if (instance.compareTo("-1") != 0)
			    not.show(5000, LocaleMessages.LANG.hasNoTask(), Notification.WARNING);
		    }
		    instance = "1";
		}

	    });
	} catch (Exception ex) {

	}
    }

    @Override
    public void setPresenter(Presenter presenter) {
	this.presenter = presenter;

    }

}
