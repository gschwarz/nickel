package com.rhiscom.bpm.console.client.ui.administration;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.event.shared.EventBus;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.ClientFactoryImpl;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.event.UpdateBusinessGroupEvent;
import com.rhiscom.bpm.console.client.event.UpdateBusinessGroupEventHandler;
import com.rhiscom.bpm.console.client.event.UpdateBusinessUnitEvent;
import com.rhiscom.bpm.console.client.event.UpdateBusinessUnitEventHandler;
import com.rhiscom.bpm.console.client.remote.RetailDomainService;
import com.rhiscom.bpm.console.client.remote.RetailDomainServiceAsync;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public class BusinessUnitMaintainerCellTableViewImpl extends Composite implements BusinessUnitMaintainerCellTableView {

    private static final Binder binder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Widget, BusinessUnitMaintainerCellTableViewImpl> {
    }

    private ClientFactory clientFactory;
    private List<BusinessGroupDTO> listadoBusinessGroup = new ArrayList<BusinessGroupDTO>();
    private List<BusinessUnitDTO> listadoVigentes = new ArrayList<BusinessUnitDTO>();

    @UiField(provided = true)
    CellTable<BusinessUnitDTO> cellTableBusinessUnit;

    @UiField(provided = true)
    SimplePager pager;

    @UiField
    MenuItem btnRefrescar;

    @UiField
    MenuItem btnAgregar;

    @UiField(provided = true)
    ListBox listadoEstadoListBox;

    @UiField(provided = true)
    ListBox businessGroupListBox;

    final ListDataProvider<BusinessUnitDTO> businessUnitDataProvider;

    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    private List<AbilityDTO> abilityList;

    public BusinessUnitMaintainerCellTableViewImpl(ClientFactoryImpl clientFactoryImpl) {

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	this.clientFactory = clientFactoryImpl;

	businessUnitDataProvider = new ListDataProvider<BusinessUnitDTO>();
	cellTableBusinessUnit = this.createBusinessUnitCellTable();

	listadoEstadoListBox = new ListBox();
	businessGroupListBox = new ListBox();
	businessGroupListBox.addItem(LocaleMessages.LANG.select(), "-1");
	listadoEstadoListBox.addItem(LocaleMessages.LANG.valid(), "1");
	listadoEstadoListBox.addItem(LocaleMessages.LANG.all(), "0");

	listadoEstadoListBox.setVisibleItemCount(1);

	businessUnitDataProvider.addDataDisplay(cellTableBusinessUnit);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTableBusinessUnit);
	traerUnidadesDeNegocios(true);
	traerGruposDeNegocios(true);

	initWidget(binder.createAndBindUi(this));

	listadoEstadoListBox.addChangeHandler(new ChangeHandler() {
	    public void onChange(ChangeEvent event) {
		businessGroupListBox.setSelectedIndex(0);
		int selectedIndex = listadoEstadoListBox.getSelectedIndex();

		if (listadoEstadoListBox.getValue(selectedIndex).contains("1")) {
		    traerUnidadesDeNegocios(true);
		} else {
		    traerUnidadesDeNegocios(false);
		}

	    }
	});

	businessGroupListBox.addChangeHandler(new ChangeHandler() {
	    public void onChange(ChangeEvent event) {
		listadoEstadoListBox.setSelectedIndex(0);

		businessUnitDataProvider.setList(new ArrayList<BusinessUnitDTO>());
		businessUnitDataProvider.refresh();
		cellTableBusinessUnit.redraw();

		int selectedIndex = businessGroupListBox.getSelectedIndex();
		String value = businessGroupListBox.getValue(selectedIndex);
		if (value.compareToIgnoreCase("-1") == 0) {
		    businessGroupListBox.setSelectedIndex(0);
		    businessUnitDataProvider.setList(listadoVigentes);
		    businessUnitDataProvider.refresh();
		    cellTableBusinessUnit.redraw();
		} else {

		    List<BusinessUnitDTO> listTmp = new ArrayList<BusinessUnitDTO>();
		    for (int i = 0; i <= listadoVigentes.size() - 1; i++) {

			if (listadoVigentes.get(i).getIdBusinessGroup() == Integer.valueOf(value).longValue()) {
			    listTmp.add(listadoVigentes.get(i));
			    businessUnitDataProvider.setList(listTmp);
			    businessUnitDataProvider.refresh();
			    cellTableBusinessUnit.redraw();

			}

		    }
		}

	    }
	});

	EventBus eventBusLogin = clientFactory.getEventBus();

	eventBusLogin.addHandler(UpdateBusinessGroupEvent.TYPE, new UpdateBusinessGroupEventHandler() {

	    @Override
	    public void update(UpdateBusinessGroupEvent event) {
		int count = businessGroupListBox.getItemCount();

		while (businessGroupListBox.getItemCount() != 0) {
		    businessGroupListBox.removeItem(businessGroupListBox.getItemCount() - 1);

		}

		businessGroupListBox.addItem(LocaleMessages.LANG.select(), "-1");
		traerGruposDeNegocios(true);

	    }

	});

	eventBusLogin.addHandler(UpdateBusinessUnitEvent.TYPE, new UpdateBusinessUnitEventHandler() {

	    @Override
	    public void update(UpdateBusinessUnitEvent event) {

		traerUnidadesDeNegocios(true);

	    }

	});

	btnAgregar.setCommand(cmdAgregar);
	btnRefrescar.setCommand(cmdRefrescar);
    }

    Command cmdRefrescar = new Command() {
	public void execute() {

	    traerUnidadesDeNegocios(true);
	    traerGruposDeNegocios(true);

	}
    };

    Command cmdAgregar = new Command() {
	public void execute() {
	    AddUpdateBusinessUnitDialog dialog = new AddUpdateBusinessUnitDialog(retailDomainService,
		    listadoBusinessGroup, listadoVigentes, clientFactory);

	    dialog.center();
	    int top = dialog.getAbsoluteTop();
	    int left = dialog.getAbsoluteLeft();
	    dialog.setPopupPosition(left, top - 50);
	    dialog.show();

	}
    };

    /**
     * M�todo que consutruye la tabla donde muestra los grupos rolutores.
     * 
     * @return
     */
    public CellTable<BusinessUnitDTO> createBusinessUnitCellTable() {
	final CellTable<BusinessUnitDTO> table = new CellTable<BusinessUnitDTO>();
	// Create name column.

	TextColumn<BusinessUnitDTO> idBusinessGroup = new TextColumn<BusinessUnitDTO>() {
	    @Override
	    public String getValue(BusinessUnitDTO definition) {
		return String.valueOf(definition.getIdBusinessUnit());
	    }
	};

	TextColumn<BusinessUnitDTO> name = new TextColumn<BusinessUnitDTO>() {
	    @Override
	    public String getValue(BusinessUnitDTO definition) {
		return String.valueOf(definition.getNameBusinessUnit());
	    }
	};
	TextColumn<BusinessUnitDTO> codigo = new TextColumn<BusinessUnitDTO>() {
	    @Override
	    public String getValue(BusinessUnitDTO definition) {
		return definition.getCode();

	    }
	};

	TextColumn<BusinessUnitDTO> businessGroup = new TextColumn<BusinessUnitDTO>() {
	    @Override
	    public String getValue(BusinessUnitDTO definition) {
		return String.valueOf(definition.getBusinessGroupName());
	    }
	};

	TextColumn<BusinessUnitDTO> status = new TextColumn<BusinessUnitDTO>() {
	    @Override
	    public String getValue(BusinessUnitDTO definition) {
		if (definition.getStatus() == 1) {
		    return LocaleMessages.LANG.valid();
		} else {
		    return LocaleMessages.LANG.notValid();
		}

	    }
	};

	// Create address column.
	TextColumn<BusinessUnitDTO> createDate = new TextColumn<BusinessUnitDTO>() {
	    @Override
	    public String getValue(BusinessUnitDTO definition) {
		DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy");

		if (definition.getCreateStamp() != null) {
		    return fmtDate.format(definition.getCreateStamp());
		} else {
		    return "N/D";
		}
	    }
	};

	TextColumn<BusinessUnitDTO> updateDate = new TextColumn<BusinessUnitDTO>() {
	    @Override
	    public String getValue(BusinessUnitDTO definition) {
		if (definition.getLastUpdatedStamp() != null) {
		    DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy");

		    return fmtDate.format(definition.getLastUpdatedStamp());
		} else {
		    return "N/D";
		}
	    }
	};

	Column<BusinessUnitDTO, String> editarBtn = new Column<BusinessUnitDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(BusinessUnitDTO c) {

		return "Editar";

	    }

	};
	editarBtn.setCellStyleNames("buttonEditar");

	editarBtn.setFieldUpdater(new FieldUpdater<BusinessUnitDTO, String>() {

	    @Override
	    public void update(int index, BusinessUnitDTO BusinessUnitDTO, String value) {
		editarBusinessUnit(BusinessUnitDTO);
	    }

	});

	// Add the columns.

	table.addColumn(idBusinessGroup, LocaleMessages.LANG.id());
	table.addColumn(name, LocaleMessages.LANG.name());
	table.addColumn(businessGroup, LocaleMessages.LANG.businessGroup());
	table.addColumn(codigo, LocaleMessages.LANG.code());
	table.addColumn(status, LocaleMessages.LANG.status());
	table.addColumn(createDate, LocaleMessages.LANG.createDate());
	table.addColumn(updateDate, LocaleMessages.LANG.lastModification());

	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "editarBtn")) {
	    table.addColumn(editarBtn, " ");
	}

	table.setColumnWidth(idBusinessGroup, 15.0, Unit.PX);
	table.setColumnWidth(name, 160.0, Unit.PX);
	table.setColumnWidth(businessGroup, 120.0, Unit.PX);
	table.setColumnWidth(codigo, 20.0, Unit.PX);
	table.setColumnWidth(status, 80.0, Unit.PX);
	table.setColumnWidth(createDate, 120.0, Unit.PX);
	table.setColumnWidth(updateDate, 120.0, Unit.PX);
	table.setColumnWidth(editarBtn, 95.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    private void editarBusinessUnit(BusinessUnitDTO businessUnitDTO) {
	AddUpdateBusinessUnitDialog dialog = new AddUpdateBusinessUnitDialog(retailDomainService, listadoBusinessGroup,
		listadoVigentes, businessUnitDTO, clientFactory);

	dialog.center();
	int top = dialog.getAbsoluteTop();
	int left = dialog.getAbsoluteLeft();
	dialog.setPopupPosition(left, top - 50);
	dialog.show();
    }

    /**
     * M�todo que consulta solo los grupos vigentes.
     */
    public void traerGruposDeNegocios(final boolean vigentes) {

	try

	{

	    while (businessGroupListBox.getItemCount() != 0)
		businessGroupListBox.removeItem(0);

	    businessGroupListBox.addItem("--Seleccione--", "-1");

	    retailDomainService.getBusinessGroupAll(new AsyncCallback<List<BusinessGroupDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    Window.alert("Servicio no disponible :" + ex.toString());
		}

		@Override
		public void onSuccess(List<BusinessGroupDTO> list) {
		    listadoBusinessGroup = new ArrayList<BusinessGroupDTO>();
		    List<BusinessGroupDTO> listVigentes = new ArrayList<BusinessGroupDTO>();
		    List<BusinessGroupDTO> listNoVigentes = new ArrayList<BusinessGroupDTO>();

		    for (int i = 0; i <= list.size() - 1; i++) {
			if (list.get(i).getStatus() == 1) {

			    listVigentes.add(list.get(i));

			}
			listNoVigentes.add(list.get(i));
		    }

		    listadoBusinessGroup = listVigentes;

		    for (int i = 0; i <= listadoBusinessGroup.size() - 1; i++) {

			businessGroupListBox.addItem(listadoBusinessGroup.get(i).getNameBusinessGroup(),
				String.valueOf(listadoBusinessGroup.get(i).getIdBusinessGroup()));

		    }

		}

	    });

	} catch (Exception ex) {
	    Window.alert("ERROR :" + ex.toString());
	}
    }

    /**
     * M�todo que consulta solo los grupos vigentes.
     */
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

		    if (vigentes) {
			businessUnitDataProvider.setList(listVigentes);

		    } else {
			businessUnitDataProvider.setList(listNoVigentes);
		    }

		    listadoVigentes = listVigentes;
		    businessUnitDataProvider.refresh();
		    cellTableBusinessUnit.redraw();
		}

	    });
	} catch (Exception ex) {
	}
    }

    @Override
    public void setPresenter(Presenter presenter) {

    }

}
