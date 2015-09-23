package com.rhiscom.bpm.console.client.ui.bam;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

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
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
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

public class MonitoringProcessViewImpl extends Composite implements MonitoringProcessView {

    private static final Binder binder = GWT.create(Binder.class);
    private final static Logger logger = Logger.getLogger(MonitoringProcessViewImpl.class.getName()); 
    interface Binder extends UiBinder<Widget, MonitoringProcessViewImpl> {
    }

    private ClientFactory clientFactory;

    @UiField(provided = true)
    CellTable<ProcessInstanceLogDTO> cellTablelog;
    @UiField(provided = true)
    SimplePager pager;
    final ListDataProvider<ProcessInstanceLogDTO> logDataProvider;
    final ProcessServiceAsync bamService = GWT.create(ProcessService.class);

    public MonitoringProcessViewImpl(ClientFactory clientFactory2) {
	this.clientFactory = clientFactory2;
	cellTablelog = this.createLogCellTable();
	logDataProvider = new ListDataProvider<ProcessInstanceLogDTO>();
	logDataProvider.addDataDisplay(cellTablelog);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTablelog);

	initWidget(binder.createAndBindUi(this));

	RemoteEventService theRemoteEventService = RemoteEventServiceFactory.getInstance().getRemoteEventService();
	// add a listener to the SERVER_MESSAGE_DOMAIN
	theRemoteEventService.addListener(ServerGeneratedMessageEvent.SERVER_MESSAGE_DOMAIN, new RemoteEventListener() {
	    public void apply(Event anEvent) {

		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
		    @Override
		    public void execute() {
			GWT.log("::EVENTO RECEPCIONADO::");

			traerLogInstancias();
		    }
		});
	    }
	});

	EventBus eventBusLogin = clientFactory.getEventBus();

	eventBusLogin.addHandler(InstancesProcessEvent.TYPE, new InstancesProcessEventHandler() {

	    @Override
	    public void update(InstancesProcessEvent event) {
		GWT.log("BAM :: Recepcionado evento refrescar instancias y LOG");

		traerLogInstancias();

	    }

	});

	Scheduler.get().scheduleDeferred(new ScheduledCommand() {
	    @Override
	    public void execute() {

		traerLogInstancias();
	    }
	});

    }

    @UiHandler("btnRefrescar")
    void onClickRefresh(ClickEvent e) {
	traerLogInstancias();
    }

    /**
     * Método que trae log de ejecución de procesos.
     */
    private void traerLogInstancias() {
	try {

	    bamService.getInstancesLog(new AsyncCallback<List<ProcessInstanceLogDTO>>() {

		@Override
		public void onFailure(Throwable arg0) {

		}

		@Override
		public void onSuccess(List<ProcessInstanceLogDTO> list) {
		    GWT.log("BAM :: Recepcionado evento refrescar LOG");
		    logDataProvider.setList(list);
		    logDataProvider.refresh();
		    cellTablelog.redraw();

		}

	    });
	} catch (Exception ex) {
	}

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
		DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yy HH:mm:ss");
		return fmtDate.format(definition.getStartDate());
	    }
	};

	TextColumn<ProcessInstanceLogDTO> endDate = new TextColumn<ProcessInstanceLogDTO>() {
	    @Override
	    public String getValue(ProcessInstanceLogDTO definition) {
		DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yy HH:mm:ss");
		if (definition.getEndDate() == null)
		    return " ";
		else
		    return fmtDate.format(definition.getEndDate());
	    }
	};
	
	TextColumn<ProcessInstanceLogDTO> status = new TextColumn<ProcessInstanceLogDTO>() {
	    @Override
	    public String getValue(ProcessInstanceLogDTO definition) {
		logger.info("::MONITORING:: Estado recepcionado :"+definition.getStatus());
		if(definition.getStatus().equals("1")) {
		    return "En proceso"; 
		}
		if(definition.getStatus().equals("2")) {
		    return "Terminado";
		}
		if(definition.getStatus().equals("3")) {
		    return "Cancelado";
		}
		
		return "N/D";
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

		int seconds = (int) (total / 1000) % 60;
		int minutes = (int) ((total / (1000 * 60)) % 60);
		int hours = (int) ((total / (1000 * 60 * 60)) % 24);
		int days = (int) ((total / (1000 * 60 * 60 * 24)) % 7);

		return String.valueOf(days + "d " + hours + " hrs " + minutes + " mins " + seconds +" s");

	    }
	};

	// Add the columns.

	table.addColumn(idProceso, LocaleMessages.LANG.process());
	table.addColumn(startDate, LocaleMessages.LANG.startDate());
	table.addColumn(endDate, LocaleMessages.LANG.endDate());
	table.addColumn(status, LocaleMessages.LANG.status());
	table.addColumn(totalTime, LocaleMessages.LANG.timeExecuted());
	table.setWidth("100%");

	table.setColumnWidth(idProceso, 20.0, Unit.PCT);
	table.setColumnWidth(status, 20.0, Unit.PCT);
	table.setColumnWidth(startDate, 20.0, Unit.PCT);
	table.setColumnWidth(endDate, 20.0, Unit.PCT);
	table.setColumnWidth(totalTime, 45.0, Unit.PCT);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }
}
