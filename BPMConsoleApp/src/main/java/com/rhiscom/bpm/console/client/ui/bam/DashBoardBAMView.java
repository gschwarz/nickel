package com.rhiscom.bpm.console.client.ui.bam;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.ChartArea;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.LegendPosition;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.corechart.AxisOptions;
import com.google.gwt.visualization.client.visualizations.corechart.ColumnChart;
import com.google.gwt.visualization.client.visualizations.corechart.CoreChart;
import com.google.gwt.visualization.client.visualizations.corechart.Options;
import com.google.gwt.visualization.client.visualizations.corechart.PieChart;
import com.google.gwt.visualization.client.visualizations.corechart.PieChart.PieOptions;
import com.google.web.bindery.event.shared.EventBus;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.event.InstancesProcessEvent;
import com.rhiscom.bpm.console.client.event.InstancesProcessEventHandler;
import com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent;
import com.rhiscom.bpm.console.client.remote.ProcessService;
import com.rhiscom.bpm.console.client.remote.ProcessServiceAsync;
import com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO;

import de.novanic.eventservice.client.event.Event;
import de.novanic.eventservice.client.event.RemoteEventService;
import de.novanic.eventservice.client.event.RemoteEventServiceFactory;
import de.novanic.eventservice.client.event.listener.RemoteEventListener;

public class DashBoardBAMView extends Composite implements DashBoardBAM {

    private static final Binder binder = GWT.create(Binder.class);

    private ClientFactory clientFactory;

    @UiField(provided = true)
    VerticalPanel dashPanel;

    @UiField
    Button btnRefrescar;
    @UiField(provided = true)
    SimplePanel instancesPanel;
    @UiField(provided = true)
    SimplePanel historyPanel;

    private ColumnChart viz;
    private PieChart instances;
    private Table logChart;
    Map<String, Integer> mapInstancias;
    Map<Date, List<ProcessInstanceLogDTO>> mapProcessInstances;

    interface Binder extends UiBinder<Widget, DashBoardBAMView> {
    }

    final ProcessServiceAsync bamService = GWT.create(ProcessService.class);

    public DashBoardBAMView(ClientFactory clientFactory2) {
	this.clientFactory = clientFactory2;

	dashPanel = new VerticalPanel();

	instancesPanel = new SimplePanel();
	instancesPanel.setStyleName("border-decorator");
	historyPanel = new SimplePanel();
	historyPanel.setStyleName("border-decorator");

	final Runnable onLoadCallback = new Runnable() {

	    public void run() {

		DataTable dataPieChart = createProcessInstances(null);
		DataTable columChart = createHistoryTable(null);
		viz = new ColumnChart(columChart, getOptionsColumnChart());
		instances = new PieChart(dataPieChart, getOptionsPieChart());

		instancesPanel.add(instances);
		historyPanel.add(viz);

		traerEjecucionesPorHora();
		traerInstanciasPorProceso();

	    }

	};
	initWidget(binder.createAndBindUi(this));
	VisualizationUtils.loadVisualizationApi(onLoadCallback, CoreChart.PACKAGE);

	RemoteEventService theRemoteEventService = RemoteEventServiceFactory.getInstance().getRemoteEventService();
	// add a listener to the SERVER_MESSAGE_DOMAIN
	theRemoteEventService.addListener(ServerGeneratedMessageEvent.SERVER_MESSAGE_DOMAIN, new RemoteEventListener() {
	    public void apply(Event anEvent) {

		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
		    @Override
		    public void execute() {
			GWT.log("::EVENTO RECEPCIONADO::");
			traerEjecucionesPorHora();
			traerInstanciasPorProceso();

		    }
		});
	    }
	});

	EventBus eventBusLogin = clientFactory.getEventBus();

	eventBusLogin.addHandler(InstancesProcessEvent.TYPE, new InstancesProcessEventHandler() {

	    @Override
	    public void update(InstancesProcessEvent event) {
		GWT.log("BAM :: Recepcionado evento refrescar Historial");
		refreshHistorial();
	    }

	});

	eventBusLogin.addHandler(InstancesProcessEvent.TYPE, new InstancesProcessEventHandler() {

	    @Override
	    public void update(InstancesProcessEvent event) {
		GWT.log("BAM :: Recepcionado evento refrescar instancias y LOG");
		refreshInstancias();

	    }

	});

    }

    public void refreshHistorial() {

	Scheduler.get().scheduleDeferred(new ScheduledCommand() {

	    @Override
	    public void execute() {
		DataTable dataProcess = createHistoryTable(mapProcessInstances);
		viz.draw(dataProcess, getOptionsColumnChart());
	    }
	});

    }

    public void refreshInstancias() {

	Scheduler.get().scheduleDeferred(new ScheduledCommand() {

	    @Override
	    public void execute() {
		DataTable data = createProcessInstances(mapInstancias);
		instances.draw(data, getOptionsPieChart());
	    }
	});

    }

    @UiHandler("btnRefrescar")
    void onClickRefresh(ClickEvent e) {
	traerEjecucionesPorHora();
	traerInstanciasPorProceso();

    }

    private void traerInstanciasPorProceso() {
	try {

	    bamService.getTotalInstancesInExecution(new AsyncCallback<Map<String, Integer>>() {

		@Override
		public void onFailure(Throwable arg0) {

		}

		@Override
		public void onSuccess(Map<String, Integer> map) {
		    mapInstancias = map;
		    clientFactory.getEventBus().fireEvent(new InstancesProcessEvent());

		}

	    });
	} catch (Exception ex) {
	}
    }

    /**
     * Método que consulta ejecuciones por hora.
     */
    public void traerEjecucionesPorHora() {

	try {

	    bamService.getProcessHistory(new AsyncCallback<Map<Date, List<ProcessInstanceLogDTO>>>() {

		@Override
		public void onFailure(Throwable arg0) {

		}

		@Override
		public void onSuccess(final Map<Date, List<ProcessInstanceLogDTO>> map) {
		    mapProcessInstances = map;
		    GWT.log(":: Antes de evento ejecuciones por Hora");
		    clientFactory.getEventBus().fireEvent(new InstancesProcessEvent());

		}

	    });
	} catch (Exception ex) {
	}

    }

    private Options getOptionsColumnChart() {
	Options options = CoreChart.createOptions();
	options.setHeight(230);
	options.setTitle(LocaleMessages.LANG.processHistory());

	options.setWidth(900);
	options.setFontSize(12);
	AxisOptions vAxisOptions = AxisOptions.create();
	options.setLegend(LegendPosition.BOTTOM);
	options.setVAxisOptions(vAxisOptions);
	return options;
    }

    private Options getOptionsPieChart() {
	PieOptions options = PieChart.createPieOptions();
	options.setWidth(830);
	options.setHeight(300);
	options.set3D(true);
	options.setTitle(LocaleMessages.LANG.instancesPerProcess());
	options.setFontSize(12);
	options.setLegend(LegendPosition.RIGHT);

	ChartArea chartArea = ChartArea.create();
	chartArea.setWidth("800x");
	chartArea.setHeight("350px");
	options.setChartArea(chartArea);
	return options;
    }

    private AnnotatedTimeLine.Options getOptions() {
	AnnotatedTimeLine.Options options;

	options = AnnotatedTimeLine.Options.create();

	options.setDisplayZoomButtons(true);
	options.setScaleType(AnnotatedTimeLine.ScaleType.FIXED);
	options.setLegendPosition(AnnotatedTimeLine.AnnotatedLegendPosition.SAME_ROW);
	options.setAllowRedraw(true);
	options.setDisplayRangeSelector(false);

	options.setDisplayAnnotations(true);

	return options;
    }

    private DataTable createHistoryTable(Map<Date, List<ProcessInstanceLogDTO>> map) {

	DataTable data = DataTable.create();

	data.addColumn(AbstractDataTable.ColumnType.DATETIME, LocaleMessages.LANG.hour());
	data.addColumn(AbstractDataTable.ColumnType.NUMBER, LocaleMessages.LANG.processes());

	if (map != null) {
	    data.addRows(map.size());

	    Iterator<Entry<Date, List<ProcessInstanceLogDTO>>> it = map.entrySet().iterator();

	    int count = 0;
	    while (it.hasNext()) {

		@SuppressWarnings("rawtypes")
		Map.Entry pairs = (Map.Entry) it.next();

		Date date = (Date) pairs.getKey();
		List<ProcessInstanceLogDTO> list = map.get(date);
		data.setValue(count, 0, date);
		data.setValue(count, 1, list.size());
		count++;
	    }
	}

	return data;
    }

    private DataTable createProcessInstances(Map<String, Integer> map) {

	DataTable data = DataTable.create();
	// data.removeRows(0, data.getNumberOfRows());
	data.addColumn(AbstractDataTable.ColumnType.STRING, LocaleMessages.LANG.process());
	data.addColumn(AbstractDataTable.ColumnType.NUMBER, LocaleMessages.LANG.instances());

	if (map != null) {

	    data.addRows(map.size());

	    Iterator<Entry<String, Integer>> it = map.entrySet().iterator();

	    int count = 0;
	    while (it.hasNext()) {

		@SuppressWarnings("rawtypes")
		Map.Entry pairs = (Map.Entry) it.next();

		String processId = (String) pairs.getKey();
		Integer instances = (Integer) pairs.getValue();

		data.setValue(count, 0, processId);
		data.setValue(count, 1, instances);
		count++;
	    }
	}
	return data;
    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }

    /**
     * Método que consutruye la tabla donde muestra logs de ejecución.
     * 
     * @return
     */
    public CellTable<ProcessInstanceLogDTO> createLogCellTable() {
	final CellTable<ProcessInstanceLogDTO> table = new CellTable<ProcessInstanceLogDTO>();
	// Create name column.

	TextColumn<ProcessInstanceLogDTO> idProceso = new TextColumn<ProcessInstanceLogDTO>() {
	    @Override
	    public String getValue(ProcessInstanceLogDTO definition) {
		return String.valueOf(definition.getProcessId());
	    }
	};

	TextColumn<ProcessInstanceLogDTO> startDate = new TextColumn<ProcessInstanceLogDTO>() {
	    @Override
	    public String getValue(ProcessInstanceLogDTO definition) {
		DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy hh:mm:ss");
		return fmtDate.format(definition.getStartDate());
	    }
	};

	TextColumn<ProcessInstanceLogDTO> endDate = new TextColumn<ProcessInstanceLogDTO>() {
	    @Override
	    public String getValue(ProcessInstanceLogDTO definition) {
		DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy");
		if (definition.getEndDate() == null)
		    return " ";
		else
		    return fmtDate.format(definition.getEndDate());
	    }
	};
	TextColumn<ProcessInstanceLogDTO> totalTime = new TextColumn<ProcessInstanceLogDTO>() {
	    @Override
	    public String getValue(ProcessInstanceLogDTO definition) {
		long total = 0;
		if (definition.getEndDate() == null) {

		    total = new Date().getTime() - definition.getStartDate().getTime();
		} else {

		    total = definition.getEndDate().getTime() - definition.getStartDate().getTime();
		}
		total = total / 1000;
		return String.valueOf(total + " seg");
	    }
	};

	// Add the columns.

	table.addColumn(idProceso, LocaleMessages.LANG.process());
	table.addColumn(startDate, LocaleMessages.LANG.startDate());
	table.addColumn(endDate, LocaleMessages.LANG.endDate());
	table.addColumn(totalTime, LocaleMessages.LANG.timeExecuted());
	table.setWidth("100%");

	table.setColumnWidth(idProceso, 25.0, Unit.PCT);
	table.setColumnWidth(startDate, 25.0, Unit.PCT);
	table.setColumnWidth(endDate, 25.0, Unit.PCT);
	table.setColumnWidth(totalTime, 25.0, Unit.PCT);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }
}
