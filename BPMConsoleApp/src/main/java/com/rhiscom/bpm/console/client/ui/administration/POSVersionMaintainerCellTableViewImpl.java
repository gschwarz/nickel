package com.rhiscom.bpm.console.client.ui.administration;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.event.shared.EventBus;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.ClientFactoryImpl;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.event.UpdateResolverGroupEvent;
import com.rhiscom.bpm.console.client.event.UpdateResolverGroupEventHandler;
import com.rhiscom.bpm.console.client.remote.QuadratureService;
import com.rhiscom.bpm.console.client.remote.QuadratureServiceAsync;
import com.rhiscom.bpm.console.client.remote.RetailDomainService;
import com.rhiscom.bpm.console.client.remote.RetailDomainServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.VersionDTO;

public class POSVersionMaintainerCellTableViewImpl extends Composite implements POSVersionMaintainerView {
    Presenter presenter;
    ClientFactory clientFactory;
    private static final DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);

    private static POSVersionMaintainerCellTableViewImplUiBinder uiBinder = GWT
	    .create(POSVersionMaintainerCellTableViewImplUiBinder.class);

    interface POSVersionMaintainerCellTableViewImplUiBinder extends
	    UiBinder<Widget, POSVersionMaintainerCellTableViewImpl> {
    }

    @UiField(provided = true)
    CellTable<VersionDTO> cellTablePOSVersion;
    List<VersionDTO> listadoVersionDTO;

    @UiField(provided = true)
    SimplePager pager;

    @UiField
    MenuItem btnRefrescar;

    @UiField
    MenuItem btnAgregar;

    final ListDataProvider<VersionDTO> posversionDataProvider;
    private List<AbilityDTO> abilityList;
    final QuadratureServiceAsync quadratureService = GWT.create(QuadratureService.class);
    private List<BusinessUnitDTO> listBusinessUnitVigentes = new ArrayList<BusinessUnitDTO>();

    public POSVersionMaintainerCellTableViewImpl(ClientFactoryImpl clientFactoryImpl) {
	this.clientFactory = clientFactoryImpl;
	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);
	posversionDataProvider = new ListDataProvider<VersionDTO>();
	cellTablePOSVersion = this.createResolverGroupsCellTable();

	posversionDataProvider.addDataDisplay(cellTablePOSVersion);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTablePOSVersion);

	initWidget(uiBinder.createAndBindUi(this));

	btnRefrescar.setCommand(cmdRefrescar);
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnAgregar")) {
	    btnAgregar.setCommand(cmdAgregar);
	} else {
	    btnAgregar.setVisible(false);
	}

	EventBus eventBusLogin = clientFactory.getEventBus();

	eventBusLogin.addHandler(UpdateResolverGroupEvent.TYPE, new UpdateResolverGroupEventHandler() {

	    @Override
	    public void update(UpdateResolverGroupEvent event) {

		traerTodos();

	    }

	});

	traerTodos();
	traerUnidadesDeNegocios(true);

    }

    Command cmdRefrescar = new Command() {
	public void execute() {

	    traerTodos();

	}
    };

    Command cmdAgregar = new Command() {
	public void execute() {
	    AddUpdatePOSVersionDialog dialog = new AddUpdatePOSVersionDialog(quadratureService, listadoVersionDTO,
		    clientFactory, listBusinessUnitVigentes);

	    dialog.center();
	    int top = dialog.getAbsoluteTop();
	    int left = dialog.getAbsoluteLeft();
	    dialog.setPopupPosition(left, top - 100);
	    dialog.show();

	}
    };

    /**
     * M�todo que consutruye la tabla donde muestra los grupos rolutores.
     * 
     * @return
     */
    public CellTable<VersionDTO> createResolverGroupsCellTable() {
	final CellTable<VersionDTO> table = new CellTable<VersionDTO>();
	// Create name column.
	TextColumn<VersionDTO> id = new TextColumn<VersionDTO>() {
	    @Override
	    public String getValue(VersionDTO definition) {
		return String.valueOf(definition.getId());
	    }
	};

	TextColumn<VersionDTO> description = new TextColumn<VersionDTO>() {
	    @Override
	    public String getValue(VersionDTO definition) {
		return String.valueOf(definition.getDescription());
	    }
	};

	TextColumn<VersionDTO> initDate = new TextColumn<VersionDTO>() {
	    @Override
	    public String getValue(VersionDTO definition) {
		return dtf.format(definition.getInitDate());
	    }
	};

	TextColumn<VersionDTO> endDate = new TextColumn<VersionDTO>() {
	    @Override
	    public String getValue(VersionDTO definition) {

		return dtf.format(definition.getEndDate());

	    }
	};

	TextColumn<VersionDTO> servidor = new TextColumn<VersionDTO>() {
	    @Override
	    public String getValue(VersionDTO definition) {

		return definition.getServer();

	    }
	};

	Column<VersionDTO, String> editarBtn = new Column<VersionDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(VersionDTO c) {

		return "Editar ";

	    }

	};
	editarBtn.setCellStyleNames("buttonEditar");

	editarBtn.setFieldUpdater(new FieldUpdater<VersionDTO, String>() {

	    @Override
	    public void update(int index, VersionDTO VersionDTO, String value) {
		editarGrupoResolutor(VersionDTO);
	    }

	});

	Column<VersionDTO, String> eliminarBtn = new Column<VersionDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(VersionDTO c) {

		return "Eliminar ";

	    }

	};
	eliminarBtn.setCellStyleNames("buttonBorrar");

	eliminarBtn.setFieldUpdater(new FieldUpdater<VersionDTO, String>() {

	    @Override
	    public void update(int index, VersionDTO VersionDTO, String value) {
		eliminarGrupoResolutor(VersionDTO);
	    }

	});

	// Add the columns.
	table.setWidth("700px");
	table.addColumn(id, "Id");
	table.addColumn(description, "Nombre");
	table.addColumn(initDate, "Fecha inicio");
	table.addColumn(endDate, "Fecha Fin");
	table.addColumn(servidor, "Servidor");
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "editarBtn")) {
	    table.addColumn(editarBtn, " ");
	}
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "eliminarBtn")) {
	    table.addColumn(eliminarBtn, " ");
	}
	table.setColumnWidth(id, 15.0, Unit.PX);
	table.setColumnWidth(description, 120.0, Unit.PX);
	table.setColumnWidth(initDate, 400.0, Unit.PX);
	table.setColumnWidth(endDate, 400.0, Unit.PX);
	table.setColumnWidth(editarBtn, 90.0, Unit.PX);
	table.setColumnWidth(eliminarBtn, 90.0, Unit.PX);
	table.setColumnWidth(servidor, 200.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    private void editarGrupoResolutor(VersionDTO versionDTO) {
	AddUpdatePOSVersionDialog dialog = new AddUpdatePOSVersionDialog(quadratureService, versionDTO,
		listadoVersionDTO, clientFactory, listBusinessUnitVigentes);

	dialog.center();
	int top = dialog.getAbsoluteTop();
	int left = dialog.getAbsoluteLeft();
	dialog.setPopupPosition(left, top - 100);
	dialog.show();

    }

    private void eliminarGrupoResolutor(VersionDTO versionDTO) {

	try {
	    // Window.alert("NO VIGENTES");
	    quadratureService.deleteVersion(versionDTO.getId(), new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorDeleteGroup()
			    + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {

		    traerTodos();

		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorDeleteGroup() + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

    /**
     * Metodo que consulta las tarea asignadas al usuario
     * 
     */
    public void traerTodos() {
	try {
	    // Window.alert("NO VIGENTES");
	    quadratureService.getAllVersionPOS(new AsyncCallback<List<VersionDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorSearchGroups()
			    + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(List<VersionDTO> list) {
		    listadoVersionDTO = list;
		    posversionDataProvider.setList(list);
		    posversionDataProvider.refresh();
		    cellTablePOSVersion.redraw();
		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorSearchGroups() + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

    @Override
    public void setPresenter(Presenter presenter) {
	this.presenter = presenter;

    }

    public void traerUnidadesDeNegocios(final boolean vigentes) {
	try {

	    retailDomainService.getBusinessUnitAll(new AsyncCallback<List<BusinessUnitDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    Window.alert("Servicio no disponible :" + ex.toString());
		}

		@Override
		public void onSuccess(List<BusinessUnitDTO> list) {

		    List<BusinessUnitDTO> listVigentes = new ArrayList<BusinessUnitDTO>();
		    List<BusinessUnitDTO> listNoVigentes = new ArrayList<BusinessUnitDTO>();

		    for (int i = 0; i <= list.size() - 1; i++) {
			if (list.get(i).getStatus() == 1) {
			    listVigentes.add(list.get(i));
			}
			listNoVigentes.add(list.get(i));
		    }
		    listBusinessUnitVigentes = listVigentes;
		}

	    });
	} catch (Exception ex) {
	}
    }

}
