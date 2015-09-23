package com.rhiscom.bpm.console.client.ui.bam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.ChartArea;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.LegendPosition;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.corechart.CoreChart;
import com.google.gwt.visualization.client.visualizations.corechart.Options;
import com.google.gwt.visualization.client.visualizations.corechart.PieChart;
import com.google.gwt.visualization.client.visualizations.corechart.PieChart.PieOptions;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent;
import com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent;
import com.rhiscom.bpm.console.client.event.TestCaseEvent;
import com.rhiscom.bpm.console.shared.TestCaseComparator;

import de.novanic.eventservice.client.event.Event;
import de.novanic.eventservice.client.event.RemoteEventService;
import de.novanic.eventservice.client.event.RemoteEventServiceFactory;
import de.novanic.eventservice.client.event.listener.RemoteEventListener;

public class EventATNMonitorView extends Composite implements EventATNMonitor {

    private static final Binder binder = GWT.create(Binder.class);

    @UiField(provided = true)
    CellTable<TestCaseEvent> cellTablelog;
    @UiField(provided = true)
    Label STCName;
    @UiField(provided = true)
    Label STCStartDate;
    @UiField(provided = true)
    Label STCEndDate;
    @UiField(provided = true)
    SimplePanel instancesPanel;
    @UiField(provided = true)
    SimplePager pager;
    private PieChart instances;
    final ListDataProvider<TestCaseEvent> logDataProvider;
    Map<Integer, TestCaseEvent> testCaseMap = new HashMap<Integer, TestCaseEvent>();
    Map<String, Integer> testCaseMapByStatus = new HashMap<String, Integer>();
    Map<String, SuiteTestCaseEvent> suiteTestCaseMap = new HashMap<String, SuiteTestCaseEvent>();
    private DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy hh:mm:ss");
    /**
     * Flag que indica inicio de un plan de pruebas.
     */
    private boolean startedPlan = false;
    private static Logger bamLogger = Logger.getLogger(EventATNMonitorView.class.getName());

    interface Binder extends UiBinder<Widget, EventATNMonitorView> {
    }

    public EventATNMonitorView() {
	STCName = new Label();
	STCName.setWidth("200px");
	STCStartDate = new Label();
	STCStartDate.setWidth("200px");
	STCEndDate = new Label();
	STCEndDate.setWidth("200px");

	logDataProvider = new ListDataProvider<TestCaseEvent>();
	cellTablelog = this.createLogCellTable();
	logDataProvider.addDataDisplay(cellTablelog);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTablelog);
	instancesPanel = new SimplePanel();

	testCaseMapByStatus.put("Running", 0);
	testCaseMapByStatus.put("OK", 0);
	testCaseMapByStatus.put("NOK", 0);
	testCaseMapByStatus.put("BLOCK", 0);

	Runnable onLoadCallback = new Runnable() {

	    public void run() {

		DataTable dataPieChart = createProcessInstances(null);
		instances = new PieChart(dataPieChart, getOptionsPieChart());
		instancesPanel.add(instances);

	    }

	};

	initWidget(binder.createAndBindUi(this));
	VisualizationUtils.loadVisualizationApi(onLoadCallback, CoreChart.PACKAGE);

	RemoteEventService theRemoteEventService = RemoteEventServiceFactory.getInstance().getRemoteEventService();

	theRemoteEventService.addListener(ServerGeneratedMessageEvent.SERVER_MESSAGE_DOMAIN, new RemoteEventListener() {
	    public void apply(Event anEvent) {

		if (anEvent instanceof ServerGeneratedMessageEvent) {
		    ServerGeneratedMessageEvent serverGeneratedMessageEvent = (ServerGeneratedMessageEvent) anEvent;

		    if (serverGeneratedMessageEvent.getSuiteTestCaseEvent() != null) {

			SuiteTestCaseEvent suiteTestCaseEvent = serverGeneratedMessageEvent.getSuiteTestCaseEvent();

			if (suiteTestCaseEvent.getType().compareToIgnoreCase("STC_ATN_INIT") == 0) {
			    bamLogger.log(Level.INFO, "Recepcionado evento STC_ATN_INIT");
			    GWT.log("Evento Recepcionado : STC_ATN_INIT");
			    startedPlan = true;

			    STCName.setText(suiteTestCaseEvent.getName());

			    STCStartDate.setText(fmtDate.format(suiteTestCaseEvent.getStateDate()));
			    testCaseMap = new HashMap<Integer, TestCaseEvent>();
			    STCEndDate.setText("--");
			    testCaseMapByStatus = new HashMap<String, Integer>();
			    redrawLog(true);
			}

			if (suiteTestCaseEvent.getType().compareToIgnoreCase("STC_ATN_END") == 0) {
			    STCEndDate.setText(fmtDate.format(suiteTestCaseEvent.getStateDate()));
			    bamLogger.log(Level.INFO, "Recepcionado evento STC_ATN_END");
			    GWT.log("Evento Recepcionado : STC_ATN_END");
			    startedPlan = false;
			}

		    }
		    if (serverGeneratedMessageEvent.getTestCaseEvent() != null) {
			if (startedPlan == true) {
			    TestCaseEvent testCaseEvent = serverGeneratedMessageEvent.getTestCaseEvent();
			    if (testCaseEvent.getType().compareToIgnoreCase("TC_ATN_INIT") == 0) {
				bamLogger.log(Level.INFO, "Recepcionado evento TC_ATN_INIT");
				GWT.log("Evento Recepcionado : TC_ATN_INIT");
				testCaseMap.put(testCaseEvent.getId(), testCaseEvent);

				Integer count = testCaseMapByStatus.get(testCaseEvent.getState());
				if (count == null || count == 0) {
				    count = new Integer(0);
				}
				count++;
				testCaseMapByStatus.put(testCaseEvent.getState(), count);

				redrawLog(false);

			    }

			    if (testCaseEvent.getType().compareToIgnoreCase("TC_ATN_END") == 0) {
				bamLogger.log(Level.INFO, "Recepcionado evento TC_ATN_END");
				GWT.log("Evento Recepcionado : TC_ATN_END");
				TestCaseEvent event = testCaseMap.get(testCaseEvent.getId());
				event.setEndDate(testCaseEvent.getStateDate());
				event.setState(testCaseEvent.getState());
				Integer count = testCaseMapByStatus.get(testCaseEvent.getState());
				if (count == null || count == 0) {
				    count = new Integer(0);
				}
				count++;
				testCaseMapByStatus.put(testCaseEvent.getState(), count);

				Integer countRunning = testCaseMapByStatus.get("Running");
				if (countRunning == null || countRunning == 0) {
				    countRunning = new Integer(0);
				}
				countRunning--;
				testCaseMapByStatus.put("Running", countRunning);

				testCaseMap.put(testCaseEvent.getId(), event);

				redrawLog(true);
			    }
			}
		    }
		}
	    }

	});

    }

    private void redrawLog(boolean flag) {

	List<TestCaseEvent> list = new ArrayList<TestCaseEvent>(testCaseMap.values());
	Collections.sort(list, new TestCaseComparator());
	logDataProvider.setList(list);
	logDataProvider.refresh();
	cellTablelog.redraw();

	Scheduler.get().scheduleDeferred(new ScheduledCommand() {

	    @Override
	    public void execute() {
		DataTable data = createProcessInstances(testCaseMapByStatus);
		instances.draw(data, getOptionsPieChart());

	    }
	});

    }

    private Options getOptionsPieChart() {
	PieOptions options = PieChart.createPieOptions();
	options.setWidth(400);
	options.setHeight(330);
	options.set3D(true);
	options.setTitle("TestCase Status");
	options.setFontSize(12);
	options.setLegend(LegendPosition.LEFT);

	ChartArea chartArea = ChartArea.create();
	chartArea.setWidth("400x");
	chartArea.setHeight("330px");
	options.setChartArea(chartArea);
	return options;
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

    /**
     * Método que consutruye la tabla donde muestra los grupos rolutores.
     * 
     * @return
     */
    public CellTable<TestCaseEvent> createLogCellTable() {
	final CellTable<TestCaseEvent> table = new CellTable<TestCaseEvent>();
	// Create name column.

	TextColumn<TestCaseEvent> idTestCase = new TextColumn<TestCaseEvent>() {
	    @Override
	    public String getValue(TestCaseEvent definition) {
		return String.valueOf(definition.getId());
	    }
	};

	TextColumn<TestCaseEvent> name = new TextColumn<TestCaseEvent>() {
	    @Override
	    public String getValue(TestCaseEvent definition) {

		return definition.getName();
	    }
	};

	TextColumn<TestCaseEvent> startDate = new TextColumn<TestCaseEvent>() {
	    @Override
	    public String getValue(TestCaseEvent definition) {
		DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy hh:mm:ss");
		if (definition.getStateDate() == null)
		    return " ";
		else
		    return fmtDate.format(definition.getStateDate());
	    }
	};
	TextColumn<TestCaseEvent> endDate = new TextColumn<TestCaseEvent>() {
	    @Override
	    public String getValue(TestCaseEvent definition) {
		DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy hh:mm:ss");
		if (definition.getEndDate() == null)
		    return " ";
		else
		    return fmtDate.format(definition.getEndDate());
	    }
	};

	TextColumn<TestCaseEvent> state = new TextColumn<TestCaseEvent>() {
	    @Override
	    public String getValue(TestCaseEvent definition) {

		return definition.getState();
	    }
	};
	TextColumn<TestCaseEvent> totalTime = new TextColumn<TestCaseEvent>() {
	    @Override
	    public String getValue(TestCaseEvent definition) {
		long total = 0;
		if (definition.getEndDate() == null) {

		    total = new Date().getTime() - definition.getStateDate().getTime();
		} else {

		    total = definition.getEndDate().getTime() - definition.getStateDate().getTime();
		}
		total = total / 1000;
		return String.valueOf(total + " seg");
	    }
	};

	// Add the columns.

	table.addColumn(idTestCase, "Id");
	table.addColumn(name, LocaleMessages.LANG.name());
	table.addColumn(startDate, LocaleMessages.LANG.startDate());
	table.addColumn(endDate, LocaleMessages.LANG.endDate());
	table.addColumn(state, LocaleMessages.LANG.status());
	table.addColumn(totalTime, LocaleMessages.LANG.timeExecuted());
	table.setWidth("680px");

	table.setColumnWidth(idTestCase, 10.0, Unit.PCT);
	table.setColumnWidth(name, 28.0, Unit.PCT);
	table.setColumnWidth(state, 10.0, Unit.PCT);
	table.setColumnWidth(startDate, 16.0, Unit.PCT);
	table.setColumnWidth(endDate, 16.0, Unit.PCT);
	table.setColumnWidth(totalTime, 18.0, Unit.PCT);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }

}
