package com.rhiscom.bpm.console.client.ui.task;

import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.ListDataProvider;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMService;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMServiceAsync;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO;
import com.rhiscom.bpm.console.shared.model.rs.TaskDetailRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskListWrapper;
import com.rhiscom.bpm.console.shared.model.rs.UserTaskVO;

public class MonitoringTaskConsoleCellTableViewImp extends Composite implements HasText,
	MonitoringTaskConsoleCellTableView {

    Presenter presenter;

    @UiField(provided = true)
    CellTable<TaskDetailRS> cellTableAsignedTask;

    String instance = "-1";

    @UiField(provided = true)
    SimplePager pager;

    @UiField
    MenuItem btnRefrescar;

    final ListDataProvider<TaskDetailRS> taskDataProvider;
    final ListDataProvider<ProcessInstancesCommentDTO> taskCommentDataProvider;
    TaskDetailRS taskSelected = new TaskDetailRS();

    private static MonitoringTaskConsoleCellTableViewImpUiBinder uiBinder = GWT
	    .create(MonitoringTaskConsoleCellTableViewImpUiBinder.class);

    interface MonitoringTaskConsoleCellTableViewImpUiBinder extends
	    UiBinder<Widget, MonitoringTaskConsoleCellTableViewImp> {
    }

    private static DateTimeFormat dateFormatView = DateTimeFormat.getFormat("dd/MM/yyyy hh:mm:ss");
    final ConsoleBPMServiceAsync consoleBPMService = GWT.create(ConsoleBPMService.class);
    private List<AbilityDTO> abilityList;

    public MonitoringTaskConsoleCellTableViewImp() {
	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	taskDataProvider = new ListDataProvider<TaskDetailRS>();
	taskCommentDataProvider = new ListDataProvider<ProcessInstancesCommentDTO>();
	cellTableAsignedTask = this.createTaskAsignedCellTable();

	cellTableAsignedTask.addCellPreviewHandler(new CellPreviewEvent.Handler<TaskDetailRS>() {

	    @Override
	    public void onCellPreview(CellPreviewEvent<TaskDetailRS> event) {

		if (event.getNativeEvent().getType().contains("click")) {
		    taskSelected = event.getValue();

		}
	    }
	});

	taskDataProvider.addDataDisplay(cellTableAsignedTask);

	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTableAsignedTask);

	traerTareasDelUsuario();
	initWidget(uiBinder.createAndBindUi(this));

	btnRefrescar.setCommand(cmdRefrescarTareas);
    }

    public CellTable<TaskDetailRS> createTaskAsignedCellTable() {
	final CellTable<TaskDetailRS> table = new CellTable<TaskDetailRS>();
	// Create name column.
	TextColumn<TaskDetailRS> identificadorInstancia = new TextColumn<TaskDetailRS>() {
	    @Override
	    public String getValue(TaskDetailRS definition) {
		return String.valueOf(definition.getId());
	    }
	};

	TextColumn<TaskDetailRS> nombreTarea = new TextColumn<TaskDetailRS>() {
	    @Override
	    public String getValue(TaskDetailRS definition) {
		try {
		    StringBuffer buffer = new StringBuffer();

		    for (int i = 0; i <= definition.getDescription().length() - 1; i++) {
			char a = definition.getDescription().charAt(i);

			if (Character.isUpperCase(a) && i != 0) {
			    buffer.append(" ");
			}
			buffer.append(a);

		    }

		    return buffer.toString();
		}

		catch (Exception ex) {
		    return "N/A";
		}
	    }

	};

	// Create address column.
	TextColumn<TaskDetailRS> procesoAsociado = new TextColumn<TaskDetailRS>() {
	    @Override
	    public String getValue(TaskDetailRS definition) {
		return definition.getProcessId();
	    }
	};

	TextColumn<TaskDetailRS> estado = new TextColumn<TaskDetailRS>() {
	    @Override
	    public String getValue(TaskDetailRS definition) {
		return definition.getStatus();
	    }
	};

	TextColumn<TaskDetailRS> usuario = new TextColumn<TaskDetailRS>() {
	    @Override
	    public String getValue(TaskDetailRS definition) {
		if (definition.getOwner() != null) {
		    return definition.getOwner();
		} else
		    return "NO ASIGNADO";
	    }
	};
	TextColumn<TaskDetailRS> fechaInicio = new TextColumn<TaskDetailRS>() {
	    @Override
	    public String getValue(TaskDetailRS definition) {

		return String.valueOf(dateFormatView.format(definition.getCreatedOn()));

	    }
	};

	TextColumn<TaskDetailRS> tiempoTranscurrido = new TextColumn<TaskDetailRS>() {
	    @Override
	    public String getValue(TaskDetailRS definition) {

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

	// Add the columns.

	table.addColumn(identificadorInstancia, "Id");
	table.addColumn(procesoAsociado, "Proceso");
	table.addColumn(nombreTarea, "Tarea");
	table.addColumn(usuario, "Asignada a:");
	table.addColumn(estado, "Estado");

	table.addColumn(fechaInicio, LocaleMessages.LANG.startDate());
	table.addColumn(tiempoTranscurrido, LocaleMessages.LANG.elapsedTime());

	table.setColumnWidth(identificadorInstancia, 10.0, Unit.PX);
	table.setColumnWidth(procesoAsociado, 240.0, Unit.PX);
	table.setColumnWidth(nombreTarea, 300.0, Unit.PX);
	table.setColumnWidth(estado, 200.0, Unit.PX);
	table.setColumnWidth(usuario, 200.0, Unit.PX);
	table.setColumnWidth(fechaInicio, 200.0, Unit.PX);
	table.setColumnWidth(tiempoTranscurrido, 200.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    /**
     * Metodo que consulta las tarea asignadas al usuario
     * 
     */
    public void traerTareasDelUsuario() {
	final Notification not = new Notification(true, true);
	try {
	    UserTaskVO userTaskVO = new UserTaskVO(ApplicationContext.getAuth().getUser(), ApplicationContext.getAuth()
		    .getPass());

	    consoleBPMService.getAllTaskNotCompleted(new AsyncCallback<TaskListWrapper>() {

		@Override
		public void onFailure(Throwable arg0) {

		}

		@Override
		public void onSuccess(TaskListWrapper list) {
		    taskDataProvider.setList(list.getTaskList());

		    taskDataProvider.refresh();
		    cellTableAsignedTask.redraw();
		    if (list.getTaskList().size() == 0) {
			if (instance.compareTo("-1") != 0)
			    not.show(2500, "No existen tareas", Notification.WARNING);
		    }
		}

	    });
	} catch (Exception ex) {
	}
    }

    Command cmdRefrescarTareas = new Command() {
	public void execute() {

	    traerTareasDelUsuario();

	}
    };

    @Override
    public void setPresenter(Presenter presenter) {
	this.presenter = presenter;

    }

    @Override
    public String getText() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setText(String arg0) {
	// TODO Auto-generated method stub

    }

}
