package com.rhiscom.bpm.console.client.ui.process;

import static com.google.gwt.query.client.GQuery.$;
import gwtquery.plugins.draggable.client.DraggableOptions;
import gwtquery.plugins.draggable.client.DraggableOptions.RevertOption;
import gwtquery.plugins.draggable.client.events.DragStartEvent;
import gwtquery.plugins.draggable.client.events.DragStartEvent.DragStartEventHandler;
import gwtquery.plugins.droppable.client.events.DropEvent;
import gwtquery.plugins.droppable.client.events.DropEvent.DropEventHandler;
import gwtquery.plugins.droppable.client.gwt.DragAndDropCellTable;
import gwtquery.plugins.droppable.client.gwt.DragAndDropColumn;
import gwtquery.plugins.droppable.client.gwt.DroppableWidget;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMService;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMServiceAsync;
import com.rhiscom.bpm.console.client.remote.ProcessService;
import com.rhiscom.bpm.console.client.remote.ProcessServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.WidgetBuilder;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.InstancesRS;
import com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionInstancesRS;
import com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.UserTaskVO;

/**
 * 
 * @author Pablo C�ceres
 * 
 */
public class ProcessConsoleCellTableViewImpl extends Composite implements HasText, ProcessConsoleCellTableView {

    private static Logger logger = Logger.getLogger(ProcessConsoleCellTableViewImpl.class.getName());

    @UiField(provided = true)
    DragAndDropCellTable<DefinitionsRS> cellTableProcessDefinitions;

    CellTable<NodeInstanceLogDTO> cellTableProcessDetailInstance;
    @UiField(provided = true)
    DroppableWidget<CellList<InstancesRS>> instancesCellList;

    @UiField(provided = true)
    SimplePager pager;

    @UiField(provided = true)
    SimplePager pagerCellList;

    @UiField
    MenuItem btnIniciarProceso;

    @UiField
    MenuItem btnDetenerInstancia;

    @UiField
    MenuItem btnRefrescar;

    static interface Templates extends SafeHtmlTemplates {
	Templates INSTANCE = GWT.create(Templates.class);

	@Template("<div id='dragHelper' style='border:1px solid black; background-color:#ffffff; color:black; width:150px;'></div>")
	SafeHtml outerHelper();
    }

    private static ProcessConsoleCellTableViewImplUiBinder uiBinder = GWT
	    .create(ProcessConsoleCellTableViewImplUiBinder.class);

    interface ProcessConsoleCellTableViewImplUiBinder extends UiBinder<Widget, ProcessConsoleCellTableViewImpl> {
    }

    /* Elementos UI */

    final ConsoleBPMServiceAsync consoleBPMService = GWT.create(ConsoleBPMService.class);
    final ProcessServiceAsync processService = GWT.create(ProcessService.class);
    final ListDataProvider<DefinitionsRS> dataProvider;
    final ListDataProvider<InstancesRS> dataProviderInstances;
    final ListDataProvider<InstancesRS> instancesList = new ListDataProvider<InstancesRS>();
    final ListDataProvider<NodeInstanceLogDTO> instanceDetailListProvider = new ListDataProvider<NodeInstanceLogDTO>();
    /* Atributos */
    private Presenter presenter;
    private DefinitionsRS definicionSeleccionada = null;
    private InstancesRS instanciaSeleccionada = null;
    private CellList<InstancesRS> cellList;
    private InformationDialog dialog;
    private ViewProcessHTMLRenderDialog dialogRender;
    private List<AbilityDTO> abilityList;

    /**
     * Constructor de la vista.
     */
    public ProcessConsoleCellTableViewImpl() {

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	ProvidesKey<InstancesRS> keyProvider = new ProvidesKey<InstancesRS>() {
	    public Object getKey(InstancesRS item) {
		// Always do a null check.
		return (item == null) ? null : item.getId();
	    }
	};

	cellList = new CellList<InstancesRS>(new InstanceCell(Resource.INSTANCE.ProcessAdd()), keyProvider);
	cellList.setPageSize(7);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pagerCellList = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pagerCellList.setDisplay(cellList);

	cellList.addStyleName(Resource.INSTANCE.css().exportCellList());

	final SingleSelectionModel<InstancesRS> selectionModelInstancesRS = new SingleSelectionModel<InstancesRS>();
	Handler tableInstancesHandler = new SelectionChangeEvent.Handler() {
	    @Override
	    public void onSelectionChange(SelectionChangeEvent event) {

		InstancesRS clickedObj = selectionModelInstancesRS.getSelectedObject();
		traerDetalleInstancia(clickedObj);
		instanciaSeleccionada = clickedObj;

	    }
	};
	selectionModelInstancesRS.addSelectionChangeHandler(tableInstancesHandler);
	cellList.setSelectionModel(selectionModelInstancesRS);
	cellList.addCellPreviewHandler(new CellPreviewEvent.Handler<InstancesRS>() {

	    @Override
	    public void onCellPreview(CellPreviewEvent<InstancesRS> event) {

		if (event.getNativeEvent().getType().contains("click")
			|| event.getNativeEvent().getType().contains("mousedown")) {

		    instanceDetailListProvider.setList(new ArrayList<NodeInstanceLogDTO>());
		    instanceDetailListProvider.refresh();
		    cellTableProcessDetailInstance.redraw();
		    traerDetalleInstancia(event.getValue());
		    instanciaSeleccionada = event.getValue();

		}
	    }
	});

	instancesList.addDataDisplay(cellList);
	cellTableProcessDetailInstance = WidgetBuilder.createProcessInstancesTable();
	instanceDetailListProvider.addDataDisplay(cellTableProcessDetailInstance);

	instancesCellList = new DroppableWidget<CellList<InstancesRS>>(cellList);

	// setup the drop operation
	instancesCellList.setDroppableHoverClass(Resource.INSTANCE.css().droppableHover());
	instancesCellList.setActiveClass(Resource.INSTANCE.css().droppableActive());
	instancesCellList.addDropHandler(new DropEventHandler() {

	    public void onDrop(DropEvent event) {

		if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnIniciarProceso")) {

		    DefinitionsRS def = event.getDraggableData();

		    iniciarProceso(def);
		} else {
		    Window.alert("No tiene permisos suficientes");
		}

	    }
	});

	instancesCellList.setStyleName("exportCellList");
	instancesCellList.setHeight("353px");

	/**
	 * Creaci�n dataProviders.
	 */
	dataProvider = new ListDataProvider<DefinitionsRS>();
	dataProviderInstances = new ListDataProvider<InstancesRS>();
	/**
	 * Creaci�n de las tablas.
	 */
	cellTableProcessDefinitions = this.createProcessDefinitionTable();

	cellTableProcessDefinitions.addCellPreviewHandler(new CellPreviewEvent.Handler<DefinitionsRS>() {

	    @Override
	    public void onCellPreview(CellPreviewEvent<DefinitionsRS> event) {

		if (event.getNativeEvent().getType().contains("click")
			|| event.getNativeEvent().getType().contains("mousedown")) {

		    traerInstanciasProceso(event.getValue());
		    instanceDetailListProvider.setList(new ArrayList<NodeInstanceLogDTO>());
		    instanceDetailListProvider.refresh();
		    cellTableProcessDetailInstance.redraw();
		    definicionSeleccionada = event.getValue();

		}
	    }
	});

	final SingleSelectionModel<DefinitionsRS> selectionModelDefinitionsRS = new SingleSelectionModel<DefinitionsRS>();
	Handler tableHandler = new SelectionChangeEvent.Handler() {
	    @Override
	    public void onSelectionChange(SelectionChangeEvent event) {

		DefinitionsRS clickedObj = selectionModelDefinitionsRS.getSelectedObject();
		definicionSeleccionada = clickedObj;

	    }
	};

	// Add the handler to the selection model
	selectionModelDefinitionsRS.addSelectionChangeHandler(tableHandler);

	// Add the selection model to the table
	cellTableProcessDefinitions.setSelectionModel(selectionModelDefinitionsRS);

	dataProvider.addDataDisplay(cellTableProcessDefinitions);

	SimplePager.Resources pagerResourcesCellList = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResourcesCellList, false, 0, true);
	pager.setDisplay(cellTableProcessDefinitions);

	traerDefinicionesDeProcesos();

	cellTableProcessDefinitions.addDragStartHandler(new DragStartEventHandler() {

	    public void onDragStart(DragStartEvent event) {

		DefinitionsRS def = event.getDraggableData();
		Element helper = event.getHelper();
		SafeHtmlBuilder sb = new SafeHtmlBuilder();
		new DefinitionCell(Resource.INSTANCE.ProcessAccept()).render(null, def, sb);
		helper.setInnerHTML(sb.toSafeHtml().asString());

	    }
	});

	initWidget(uiBinder.createAndBindUi(this));

	buildAccess();

	btnRefrescar.setCommand(cmdRefrescarDefiniciones);

    }

    /**
     * M�todo que determina que acci�n habilitar en el men�
     */
    private void buildAccess() {

	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnIniciarProceso")) {
	    btnIniciarProceso.setCommand(cmdIniciarProceso);
	} else {
	    btnIniciarProceso.setVisible(false);
	}
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnDetenerInstancia")) {
	    btnDetenerInstancia.setCommand(cmdDetenerInstancia);
	} else {
	    btnDetenerInstancia.setVisible(false);
	}

    }

    public DragAndDropCellTable<DefinitionsRS> createProcessDefinitionTable() {

	final DragAndDropCellTable<DefinitionsRS> table = new DragAndDropCellTable<DefinitionsRS>();
	// Create name column.
	DragAndDropColumn<DefinitionsRS, String> nombreProceso = new DragAndDropColumn<DefinitionsRS, String>(
		new TextCell()) {
	    @Override
	    public String getValue(DefinitionsRS definition) {
		return String.valueOf(definition.getName());
	    }
	};
	nombreProceso.setCellDraggableOnly();
	initDragOperation(nombreProceso);
	// Create address column.
	DragAndDropColumn<DefinitionsRS, String> packageName = new DragAndDropColumn<DefinitionsRS, String>(
		new TextCell()) {
	    @Override
	    public String getValue(DefinitionsRS definition) {
		return definition.getPackageName();
	    }
	};
	packageName.setCellDraggableOnly();
	initDragOperation(packageName);

	// Add the columns.

	table.addColumn(nombreProceso, "Proceso");
	table.addColumn(packageName, "Ubicaci\u00f3n");

	table.setColumnWidth(nombreProceso, 50.0, Unit.PCT);
	table.setColumnWidth(packageName, 50.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);

	// We know that the data is sorted alphabetically by default.

	return table;

    }

    private void initDragOperation(DragAndDropColumn<?, ?> column) {

	// retrieve draggableOptions on the column
	DraggableOptions draggableOptions = column.getDraggableOptions();
	// use template to construct the helper. The content of the div will be
	// set
	// after
	draggableOptions.setHelper($(Templates.INSTANCE.outerHelper().asString()));
	// opacity of the helper
	draggableOptions.setOpacity((float) 0.8);
	// cursor to use during the drag operation
	draggableOptions.setCursor(Cursor.MOVE);
	// set the revert option
	draggableOptions.setRevert(RevertOption.ON_INVALID_DROP);
	// prevents dragging when user click on the category drop-down list
	draggableOptions.setCancel("select");
    }

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

    Command cmdIniciarProceso = new Command() {
	public void execute() {

	    iniciarProceso(definicionSeleccionada);

	}
    };

    Command cmdDetenerInstancia = new Command() {
	public void execute() {

	    if (instanciaSeleccionada != null) {
		detenerInstancia(instanciaSeleccionada);
	    } else {
		dialog = new InformationDialog("No ha seleccionado la instancia a detener");
		dialog.center();
		dialog.show();
	    }

	}
    };

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

	    instanceDetailListProvider.setList(new ArrayList<NodeInstanceLogDTO>());
	    instanceDetailListProvider.refresh();
	    cellTableProcessDetailInstance.redraw();

	    dataProvider.setList(new ArrayList<DefinitionsRS>());
	    dataProvider.refresh();
	    cellTableProcessDefinitions.redraw();

	    instancesList.setList(new ArrayList<InstancesRS>());
	    instancesList.refresh();
	    cellList.redraw();

	    consoleBPMService.getDefinitions(new AsyncCallback<ProcessDefinitionsRS>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error al consultar definiciones de procesos :"
			    + ex.toString());
		    dialog.center();
		    dialog.show();
		}

		@Override
		public void onSuccess(ProcessDefinitionsRS processDefinitionsRS) {
		    logger.log(Level.INFO, ">> processDefinitionsRS = " + processDefinitionsRS);
		    List<DefinitionsRS> listDefinitionsRS = new ArrayList<DefinitionsRS>();

		    listDefinitionsRS.addAll(processDefinitionsRS.getDefinitions());

		    dataProvider.setList(listDefinitionsRS);
		    dataProvider.refresh();
		    cellTableProcessDefinitions.redraw();
		}

	    });
	} catch (Exception ex) {
	}
    }

    /**
     * Metodo que consulta todos los procesos existentes.
     * 
     */
    public void iniciarProceso(final DefinitionsRS definitionsRS) {

	try {
	    if (definitionsRS.getFormUrl() == null || definitionsRS.getFormUrl().length() == 0) {

		consoleBPMService.startInstace(definitionsRS, new AsyncCallback<InstancesRS>() {

		    @Override
		    public void onFailure(Throwable ex) { // TODO
			InformationDialog dialog = new InformationDialog("Error iniciar proceso :" + ex.toString());
			dialog.center();
			dialog.show();

		    }

		    @Override
		    public void onSuccess(InstancesRS instances) {
			traerInstanciasProceso(definicionSeleccionada);
			InformationDialog dialog = new InformationDialog("Proceso iniciado.");
			dialog.center();
			dialog.show();

		    }

		});

	    } else {
		UserTaskVO userTaskVO = new UserTaskVO(ApplicationContext.getAuth().getUser(), ApplicationContext
			.getAuth().getPass());
		consoleBPMService.getProcessRenderHTML(definitionsRS, userTaskVO, new AsyncCallback<String>() {

		    @Override
		    public void onFailure(Throwable ex) {
			dialog = new InformationDialog("Error al obtener Render :" + ex.toString());
			dialog.center();
			dialog.show();

		    }

		    @Override
		    public void onSuccess(String html) {
			dialogRender = new ViewProcessHTMLRenderDialog(html);
			dialogRender.center();
			dialogRender.show();

		    }

		});
	    }
	} catch (Exception ex) {

	}

    }

    /**
     * Metodo que consulta detalle de las instancias de los procesos.
     * 
     */
    public void traerInstanciasProceso(DefinitionsRS definitionsRS) {
	try {
	    consoleBPMService.getProcessInstances(definitionsRS, new AsyncCallback<ProcessDefinitionInstancesRS>() {

		@Override
		public void onFailure(Throwable ex) {
		    dialog = new InformationDialog("Error al obtener instancias :" + ex.toString());
		    dialog.center();
		    dialog.show();
		}

		@Override
		public void onSuccess(ProcessDefinitionInstancesRS processDefinitionInstancesRS) {

		    List<InstancesRS> listInstancesRS = new ArrayList<InstancesRS>();

		    listInstancesRS.addAll(processDefinitionInstancesRS.getInstances());

		    dataProviderInstances.setList(listInstancesRS);
		    instancesList.setList(listInstancesRS);
		    instancesList.refresh();
		    cellList.redraw();
		    // dataProvider.getList().add(arg0);
		    dataProviderInstances.refresh();
		    cellTableProcessDetailInstance.redraw();
		}

	    });
	} catch (Exception ex) {
	}
    }

    public void detenerInstancia(final InstancesRS instancesRS) {
	try {
	    consoleBPMService.deleteInstance(instancesRS, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    dialog = new InformationDialog("Error detener instancia");
		    dialog.center();
		    dialog.show();
		}

		@Override
		public void onSuccess(Object arg0) {
		    instancesList.getList().remove(instancesRS);
		    instancesList.refresh();

		    cellList.redraw();
		    dialog = new InformationDialog("Instancia detenida");
		    dialog.center();
		    dialog.show();
		    instanciaSeleccionada = null;
		}

	    });
	} catch (Exception ex) {
	}
    }

    public void traerDetalleInstancia(InstancesRS instance) {
	try {
	    processService.getDetailInstance(new Long(instance.getId()), new AsyncCallback<List<NodeInstanceLogDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    dialog = new InformationDialog("Error traer detalle instancia :" + ex.toString());
		    dialog.center();
		    dialog.show();
		}

		@Override
		public void onSuccess(List<NodeInstanceLogDTO> list) {
		    instanceDetailListProvider.setList(list);
		    instanceDetailListProvider.refresh();
		    cellTableProcessDetailInstance.redraw();

		}

	    });
	} catch (Exception ex) {
	}
    }
}
