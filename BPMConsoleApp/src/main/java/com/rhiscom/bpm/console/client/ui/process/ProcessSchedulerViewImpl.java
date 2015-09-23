package com.rhiscom.bpm.console.client.ui.process;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMService;
import com.rhiscom.bpm.console.client.remote.ConsoleBPMServiceAsync;
import com.rhiscom.bpm.console.client.remote.ProcessService;
import com.rhiscom.bpm.console.client.remote.ProcessServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO;
import com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.InstancesRS;
import com.rhiscom.bpm.console.shared.model.rs.ProcessDefinitionsRS;

public class ProcessSchedulerViewImpl extends Composite implements ProcessSchedulerView {

    private static final Binder binder = GWT.create(Binder.class);

    @UiField(provided = true)
    CellList<DefinitionsRS> cellList;
    @UiField
    SimplePager pagerCellList;
    @UiField
    CheckBox chkLunes;
    @UiField
    CheckBox chkMartes;
    @UiField
    CheckBox chkMiercoles;
    @UiField
    CheckBox chkJueves;
    @UiField
    CheckBox chkViernes;
    @UiField
    DateBox initDate;
    @UiField
    DateBox endDate;
    @UiField
    Button btnGuardar;
    @UiField
    CheckBox chkDomingo;
    @UiField
    CheckBox chkSabado;
    @UiField
    Label lblError;
    @UiField
    Label lblProceso;

    @UiField
    MenuItem btnRefrescar;

    @UiField
    CellTable detailInstance;
    @UiField ListBox cmbHoras;
    @UiField ListBox cmbMinutos;

    final ConsoleBPMServiceAsync consoleBPMService = GWT.create(ConsoleBPMService.class);
    final ListDataProvider<DefinitionsRS> instancesList = new ListDataProvider<DefinitionsRS>();
    private List<AbilityDTO> abilityList;
    private DefinitionsRS definicionSeleccionada;
    final ProcessServiceAsync processService = GWT.create(ProcessService.class);
    final ListDataProvider<NodeInstanceLogDTO> instanceDetailListProvider = new ListDataProvider<NodeInstanceLogDTO>();
    Long dtoId = null;

    interface Binder extends UiBinder<Widget, ProcessSchedulerViewImpl> {
    }

    public ProcessSchedulerViewImpl() {

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	ProvidesKey<DefinitionsRS> keyProvider = new ProvidesKey<DefinitionsRS>() {
	    public Object getKey(DefinitionsRS item) {
		// Always do a null check.
		return (item == null) ? null : item.getId();
	    }
	};

	cellList = new CellList<DefinitionsRS>(new ProcessCell(Resource.INSTANCE.ProcessAdd()), keyProvider);
	cellList.setPageSize(7);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pagerCellList = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pagerCellList.setDisplay(cellList);

	cellList.addStyleName(Resource.INSTANCE.css().exportCellList());

	final SingleSelectionModel<DefinitionsRS> selectionModelInstancesRS = new SingleSelectionModel<DefinitionsRS>();
	Handler tableInstancesHandler = new SelectionChangeEvent.Handler() {
	    @Override
	    public void onSelectionChange(SelectionChangeEvent event) {

		DefinitionsRS clickedObj = selectionModelInstancesRS.getSelectedObject();

	    }
	};
	selectionModelInstancesRS.addSelectionChangeHandler(tableInstancesHandler);
	cellList.setSelectionModel(selectionModelInstancesRS);
	cellList.addCellPreviewHandler(new CellPreviewEvent.Handler<DefinitionsRS>() {

	    @Override
	    public void onCellPreview(CellPreviewEvent<DefinitionsRS> event) {

		if (event.getNativeEvent().getType().contains("click")
			|| event.getNativeEvent().getType().contains("mousedown")) {
		    getProcessSchedulerByProcessId(event.getValue().getId());
		    definicionSeleccionada = event.getValue();
		    lblError.setVisible(false);
		    lblProceso.setText("Configuraci\u00F3n de la periodicidad : " + definicionSeleccionada.getName());
		    // traerDetalleInstancia(event.getValue());

		}
	    }
	});

	instancesList.addDataDisplay(cellList);

	buildAccess();

	initWidget(binder.createAndBindUi(this));
	
	
	for(int i=0; i<=24;i++) {
	    
	    if(i<10)
	    	cmbHoras.addItem("0"+i, "0"+i);
	    else {
		cmbHoras.addItem(i+"", i+"");
	    }
	}
	
	for (int i = 0; i<=59;i++) {
	    if(i<10)
	    	cmbMinutos.addItem("0"+i, "0"+i);
	    else {
		cmbMinutos.addItem(i+"", i+"");
	    }
	}
	
	
	
	lblProceso.setText("Configuraci\u00F3n de la periodicidad : ");
	lblError.setVisible(false);
	initDate.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("yyyy/MM/dd")));
	initDate.getDatePicker().setWidth("170px");
	initDate.addValueChangeHandler(new ValueChangeHandler<Date>() {

	    public void onValueChange(ValueChangeEvent<Date> event) {

	    }

	});

	endDate.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("yyyy/MM/dd")));
	endDate.getDatePicker().setWidth("170px");
	endDate.addValueChangeHandler(new ValueChangeHandler<Date>() {

	    public void onValueChange(ValueChangeEvent<Date> event) {

	    }

	});

	traerDefinicionesDeProcesos();

	btnRefrescar.setCommand(cmdRefrescarDefiniciones);
    }

    Command cmdRefrescarDefiniciones = new Command() {
	public void execute() {

	    traerDefinicionesDeProcesos();

	}
    };

    @UiHandler("btnGuardar")
    void onClickGuardar(ClickEvent e) {

	boolean errorPeriodicidad = true;
	boolean errorMinutos = true;
	boolean errorHoras = true;
	boolean errorFechaInicio = true;
	Date init = initDate.getValue();
	Date end = endDate.getValue();
	Boolean lunes = chkLunes.getValue();
	Boolean martes = chkMartes.getValue();
	Boolean miercoles = chkMiercoles.getValue();
	Boolean jueves = chkJueves.getValue();
	Boolean viernes = chkViernes.getValue();
	Boolean sabado = chkSabado.getValue();
	Boolean domingo = chkDomingo.getValue();

	if (lunes == false && martes == false && miercoles == false && jueves == false && viernes == false
		&& sabado == false && domingo == false) {

	    errorPeriodicidad = true;
	} else {
	    errorPeriodicidad = false;
	}

	
	
	
	
	String hora = cmbHoras.getValue(cmbHoras.getSelectedIndex());

	String minutos = cmbMinutos.getValue(cmbMinutos.getSelectedIndex());

	ProcessSchedulerDTO dto = new ProcessSchedulerDTO();
	dto.setEndDate(end);
	dto.setHoraInicio(hora);
	dto.setInitDate(init);

	dto.setIsDomingo(domingo);
	dto.setIsJueves(jueves);
	dto.setIsLunes(lunes);
	dto.setIsMartes(martes);
	dto.setIsMiercoles(miercoles);
	dto.setIsSabado(sabado);
	dto.setIsViernes(viernes);

	dto.setMinutoInicio(minutos);
	dto.setId(dtoId);
	dto.setProcessId(definicionSeleccionada.getId());

	if (errorPeriodicidad == true) {
	    lblError.setVisible(true);
	    lblError.setText("Debe ingresar periodo de ejecuci\u00F3n");
	    errorPeriodicidad = true;
	} else {
	    errorPeriodicidad = false;
	}

	if (errorPeriodicidad == false)

	    if (hora.trim().length() == 0) {
		errorHoras = true;

		lblError.setVisible(true);
		lblError.setText("Debe ingresar hora de ejecuci\u00F3n");

	    } else {
		errorHoras = false;
		lblError.setVisible(false);
	    }
	if (errorHoras == false) {
	    if (minutos.trim().length() == 0) {
		errorMinutos = true;
		lblError.setVisible(true);
		lblError.setText("Debe ingresar minuto de ejecuci\u00F3n");
	    } else {
		lblError.setVisible(false);
		errorMinutos = false;
	    }
	}
	if (errorMinutos == false) {
	    if (init == null) {
		lblError.setVisible(true);
		lblError.setText("Debe ingresar fecha de inicio de ejecuci\u00F3n");
		errorFechaInicio = true;
	    } else {
		lblError.setVisible(false);
		errorFechaInicio = false;
	    }
	}
	if (errorHoras == false && errorMinutos == false && errorPeriodicidad == false && errorFechaInicio == false) {
	    lblError.setVisible(false);
	    saveProcessScheduler(dto);
	}

    }

    /**
     * M�todo que determina que acci�n habilitar en el men�
     */
    private void buildAccess() {

	// if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode,
	// "btnIniciarProceso")) {
	// btnIniciarProceso.setCommand(cmdIniciarProceso);
	// } else {
	// btnIniciarProceso.setVisible(false);
	// }
	// if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode,
	// "btnDetenerInstancia")) {
	// btnDetenerInstancia.setCommand(cmdDetenerInstancia);
	// } else {
	// btnDetenerInstancia.setVisible(false);
	// }

    }

    /**
     * Metodo que consulta todos los procesos existentes.
     * 
     * @param tienda
     * @param fechaConsulta
     */
    public void traerDefinicionesDeProcesos() {
	try {

	    instancesList.setList(new ArrayList<DefinitionsRS>());
	    instancesList.refresh();
	    cellList.redraw();

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

		    instancesList.setList(listDefinitionsRS);
		    instancesList.refresh();
		    cellList.redraw();
		}

	    });
	} catch (Exception ex) {
	}
    }

    /**
     * Metodo que consulta configuraci�n por id de proceso
     * 
     * @param tienda
     * @param fechaConsulta
     */
    public void getProcessSchedulerByProcessId(String processId) {
	try {

	    processService.getProcessSchedulerByProcessId(processId, new AsyncCallback<ProcessSchedulerDTO>() {

		@Override
		public void onFailure(Throwable ex) {
		    chkLunes.setValue(false);
		    chkMartes.setValue(false);
		    chkMiercoles.setValue(false);
		    chkJueves.setValue(false);
		    chkViernes.setValue(false);
		    chkSabado.setValue(false);
		    chkDomingo.setValue(false);
		    initDate.setValue(null);
		    endDate.setValue(null);
		   cmbHoras.setSelectedIndex(0);
		   cmbMinutos.setSelectedIndex(0);
		    dtoId = null;
		}

		@Override
		public void onSuccess(ProcessSchedulerDTO dto) {

		    chkLunes.setValue(false);
		    chkMartes.setValue(false);
		    chkMiercoles.setValue(false);
		    chkJueves.setValue(false);
		    chkViernes.setValue(false);
		    chkSabado.setValue(false);
		    chkDomingo.setValue(false);
		    initDate.setValue(null);
		    endDate.setValue(null);
		    cmbHoras.setSelectedIndex(0);
		    cmbMinutos.setSelectedIndex(0);

		    chkLunes.setValue(dto.getIsLunes());
		    chkMartes.setValue(dto.getIsMartes());
		    chkMiercoles.setValue(dto.getIsMiercoles());
		    chkJueves.setValue(dto.getIsJueves());
		    chkViernes.setValue(dto.getIsViernes());
		    chkSabado.setValue(dto.getIsSabado());
		    chkDomingo.setValue(dto.getIsDomingo());
		    initDate.setValue(dto.getInitDate());
		    endDate.setValue(dto.getEndDate());
		    
		    for(int i=0; i<cmbHoras.getItemCount();i++) {
			if(cmbHoras.getValue(i).compareTo(dto.getHoraInicio())==0) {
			    cmbHoras.setItemSelected(i, true);
			}
		    }
		    
		    for(int i=0; i<cmbMinutos.getItemCount();i++) {
			if(cmbMinutos.getValue(i).compareTo(dto.getMinutoInicio())==0) {
			    cmbMinutos.setItemSelected(i, true);
			}
		    }
		    dtoId = dto.getId();

		}

	    });
	} catch (Exception ex) {
	    chkLunes.setValue(false);
	    chkMartes.setValue(false);
	    chkMiercoles.setValue(false);
	    chkJueves.setValue(false);
	    chkViernes.setValue(false);
	    chkSabado.setValue(false);
	    chkDomingo.setValue(false);
	    initDate.setValue(null);
	    endDate.setValue(null);
	    cmbHoras.setSelectedIndex(0);
	    cmbMinutos.setSelectedIndex(0);
	    dtoId = null;

	}
    }

    /**
     * Metodo que consulta configuraci�n por id de proceso
     * 
     * @param tienda
     * @param fechaConsulta
     */
    public void saveProcessScheduler(ProcessSchedulerDTO dto) {

	final Notification not = new Notification(true, true);
	try {

	    processService.saveProcessScheduler(dto, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    not.show(5000, LocaleMessages.LANG.schedulerNOK(), Notification.NOK);
		}

		@Override
		public void onSuccess(Object arg0) {
		    not.show(5000, LocaleMessages.LANG.schedulerOk(), Notification.OK);

		}

	    });
	} catch (Exception ex) {
	}
    }

    @Override
    public void setPresenter(Presenter presenter) {

    }

    public void traerDetalleInstancia(InstancesRS instance) {

	try {
	    processService.getDetailInstance(new Long(instance.getId()), new AsyncCallback<List<NodeInstanceLogDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error traer detalle instancia :" + ex.toString());
		    dialog.center();
		    dialog.show();
		}

		@Override
		public void onSuccess(List<NodeInstanceLogDTO> list) {
		    instanceDetailListProvider.setList(list);
		    instanceDetailListProvider.refresh();
		    detailInstance.redraw();

		}

	    });
	} catch (Exception ex) {
	}
    }

}
