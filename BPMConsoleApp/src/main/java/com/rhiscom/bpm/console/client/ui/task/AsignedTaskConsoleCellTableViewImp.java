package com.rhiscom.bpm.console.client.ui.task;

import java.util.ArrayList;
import java.util.Date;
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
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.ListDataProvider;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMService;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMServiceAsync;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessInstancesCommentDTO;
import com.rhiscom.bpm.console.shared.model.rs.TaskRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskUserRS;
import com.rhiscom.bpm.console.shared.model.rs.UserTaskVO;

public class AsignedTaskConsoleCellTableViewImp extends Composite implements HasText, AsignedTaskConsoleCellTableView {

    Presenter presenter;

    @UiField(provided = true)
    CellTable<TaskRS> cellTableAsignedTask;
    @UiField(provided = true)
    CellTable<ProcessInstancesCommentDTO> cellTableComments;
    String instance = "-1";

    @UiField(provided = true)
    SimplePager pager;
    @UiField(provided = true)
    SimplePager pagerComments;

    @UiField
    MenuItem btnRefrescar;
    @UiField
    Label lblEstadoTareaSeleccionada;
    @UiField
    Label lblAsignada;
    @UiField
    Label lblCreada;
    @UiField
    Label lblIdTarea;

    final ListDataProvider<TaskRS> taskDataProvider;
    final ListDataProvider<ProcessInstancesCommentDTO> taskCommentDataProvider;
    TaskRS taskSelected = new TaskRS();

    private static AsignedTaskConsoleCellTableViewImpUiBinder uiBinder = GWT
	    .create(AsignedTaskConsoleCellTableViewImpUiBinder.class);

    interface AsignedTaskConsoleCellTableViewImpUiBinder extends UiBinder<Widget, AsignedTaskConsoleCellTableViewImp> {
    }

    private static DateTimeFormat dateFormatView = DateTimeFormat.getFormat("dd/MM/yyyy hh:mm:ss");
    final ConsoleBPMServiceAsync consoleBPMService = GWT.create(ConsoleBPMService.class);
    private List<AbilityDTO> abilityList;

    public AsignedTaskConsoleCellTableViewImp() {
	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	taskDataProvider = new ListDataProvider<TaskRS>();
	taskCommentDataProvider = new ListDataProvider<ProcessInstancesCommentDTO>();
	cellTableAsignedTask = this.createTaskAsignedCellTable();
	cellTableComments = this.createTaskCommentCellTable();
	cellTableAsignedTask.addCellPreviewHandler(new CellPreviewEvent.Handler<TaskRS>() {

	    @Override
	    public void onCellPreview(CellPreviewEvent<TaskRS> event) {

		if (event.getNativeEvent().getType().contains("click")) {
		    taskSelected = event.getValue();

		    lblEstadoTareaSeleccionada.setText("Asignada");
		    lblAsignada.setText(taskSelected.getAssignee());
		    lblCreada.setText(taskSelected.getCreatedOn().toString());
		    lblIdTarea.setText(taskSelected.getId());

		    taskCommentDataProvider.setList(new ArrayList<ProcessInstancesCommentDTO>());
		    taskCommentDataProvider.refresh();
		    cellTableComments.redraw();

		    traerHistorialComentarios(taskSelected.getProcessInstanceId(), taskSelected.getProcessId());

		}
	    }
	});

	taskDataProvider.addDataDisplay(cellTableAsignedTask);
	taskCommentDataProvider.addDataDisplay(cellTableComments);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTableAsignedTask);

	pagerComments = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pagerComments.setDisplay(cellTableComments);
	traerTareasDelUsuario();
	initWidget(uiBinder.createAndBindUi(this));

	btnRefrescar.setCommand(cmdRefrescarTareas);
    }

    public CellTable<TaskRS> createTaskAsignedCellTable() {
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

		try {
		    StringBuffer buffer = new StringBuffer();

		    for (int i = 0; i <= definition.getName().length() - 1; i++) {
			char a = definition.getName().charAt(i);

			if (Character.isUpperCase(a) && i != 0) {
			    buffer.append(" ");
			}
			buffer.append(a);

		    }

		    return buffer.toString();
		}

		catch (Exception ex) {
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
		    return "Asignada";
		else if (definition.getCurrentState().compareTo("OPEN") == 0)
		    return "Disponible";
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

	Column<TaskRS, String> verTareaBtn = new Column<TaskRS, String>(new ButtonCell()) {

	    @Override
	    public String getValue(TaskRS c) {

		return "Ver ";

	    }

	};
	verTareaBtn.setCellStyleNames("buttonVer");

	verTareaBtn.setFieldUpdater(new FieldUpdater<TaskRS, String>() {

	    @Override
	    public void update(int index, TaskRS object, String value) {
		verTareaSeleccionada(object);

	    }

	});

	// Add the columns.

	table.addColumn(identificadorInstancia, "Id");
	table.addColumn(procesoAsociado, "Proceso");
	table.addColumn(nombreTarea, "Tarea");

	table.addColumn(fechaInicio, LocaleMessages.LANG.startDate());
	table.addColumn(tiempoTranscurrido, LocaleMessages.LANG.elapsedTime());
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "verTareaBtn")) {
	    table.addColumn(verTareaBtn, " ");
	}

	table.setColumnWidth(identificadorInstancia, 10.0, Unit.PX);
	table.setColumnWidth(procesoAsociado, 220.0, Unit.PX);
	table.setColumnWidth(nombreTarea, 300.0, Unit.PX);

	table.setColumnWidth(fechaInicio, 200.0, Unit.PX);
	table.setColumnWidth(tiempoTranscurrido, 200.0, Unit.PX);
	table.setColumnWidth(verTareaBtn, 130.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    public CellTable<ProcessInstancesCommentDTO> createTaskCommentCellTable() {
	final CellTable<ProcessInstancesCommentDTO> table = new CellTable<ProcessInstancesCommentDTO>();
	// Create name column.
	TextColumn<ProcessInstancesCommentDTO> user = new TextColumn<ProcessInstancesCommentDTO>() {
	    @Override
	    public String getValue(ProcessInstancesCommentDTO definition) {
		return String.valueOf(definition.getUser());
	    }
	};

	TextColumn<ProcessInstancesCommentDTO> taskId = new TextColumn<ProcessInstancesCommentDTO>() {
	    @Override
	    public String getValue(ProcessInstancesCommentDTO definition) {

		return definition.getTaskId();
	    }
	};

	// Create address column.
	TextColumn<ProcessInstancesCommentDTO> processInstanceId = new TextColumn<ProcessInstancesCommentDTO>() {
	    @Override
	    public String getValue(ProcessInstancesCommentDTO definition) {
		return definition.getProcessId();
	    }
	};

	TextColumn<ProcessInstancesCommentDTO> comment = new TextColumn<ProcessInstancesCommentDTO>() {
	    @Override
	    public String getValue(ProcessInstancesCommentDTO definition) {

		return definition.getComment();
	    }
	};
	TextColumn<ProcessInstancesCommentDTO> fechaInicio = new TextColumn<ProcessInstancesCommentDTO>() {
	    @Override
	    public String getValue(ProcessInstancesCommentDTO definition) {

		return String.valueOf(dateFormatView.format(definition.getCreateDate()));

	    }
	};

	// Add the columns.

	table.addColumn(user, "usuario");
	table.addColumn(taskId, "Id tarea");
	table.addColumn(comment, "Comentario");

	table.addColumn(fechaInicio, LocaleMessages.LANG.startDate());

	table.setColumnWidth(user, 70.0, Unit.PX);
	table.setColumnWidth(taskId, 150.0, Unit.PX);
	table.setColumnWidth(comment, 400.0, Unit.PX);
	table.setColumnWidth(fechaInicio, 280.0, Unit.PX);
	table.setWidth("800px");
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

	    consoleBPMService.getListUserTask(userTaskVO, new AsyncCallback<TaskUserRS>() {

		@Override
		public void onFailure(Throwable arg0) {

		}

		@Override
		public void onSuccess(TaskUserRS taskUserRS) {

		    List<TaskRS> listDefinitionsRS = new ArrayList<TaskRS>();

		    listDefinitionsRS.addAll(taskUserRS.getTasks());

		    taskDataProvider.setList(listDefinitionsRS);

		    taskDataProvider.refresh();
		    cellTableAsignedTask.redraw();
		    if (listDefinitionsRS.size() == 0) {
			if (instance.compareTo("-1") != 0)
			    not.show(2500, "No tiene tareas asignadas", Notification.WARNING);
		    }
		    instance = "1";
		}

	    });
	} catch (Exception ex) {
	}
    }

    /**
     * Metodo que consulta las tarea asignadas al usuario
     * 
     * @param processId
     * 
     */
    public void traerHistorialComentarios(String processInstanceId, String processId) {

	try {

	    consoleBPMService.getCommentsByProcessId(Long.valueOf(processInstanceId).longValue(), processId,
		    new AsyncCallback<List<ProcessInstancesCommentDTO>>() {

			@Override
			public void onFailure(Throwable arg0) {

			}

			@Override
			public void onSuccess(List<ProcessInstancesCommentDTO> list) {
			    if (list != null) {
				taskCommentDataProvider.setList(list);
				taskCommentDataProvider.refresh();
				cellTableComments.redraw();
			    }
			}

		    });
	} catch (Exception ex) {
	}
    }

    /**
     * Metodo que consulta el detalle de una tarea.
     * 
     * @param string
     * 
     */
    public void verTareaSeleccionada(final TaskRS taskRS) {

	UserTaskVO userTaskVO = new UserTaskVO(ApplicationContext.getAuth().getUser(), ApplicationContext.getAuth()
		.getPass());

	userTaskVO.setTaskRS(taskRS);

	consoleBPMService.getTaskRenderHTML(userTaskVO, new AsyncCallback<String>() {

	    @Override
	    public void onFailure(Throwable arg0) {

	    }

	    @Override
	    public void onSuccess(String html) {
		// TODO Auto-generated method stub
		ViewTaskHTMLRenderDialog infoDialog = new ViewTaskHTMLRenderDialog(html, taskRS.getId());
		infoDialog.setModal(true);
		infoDialog.center();
		infoDialog.show();

	    }

	});

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
