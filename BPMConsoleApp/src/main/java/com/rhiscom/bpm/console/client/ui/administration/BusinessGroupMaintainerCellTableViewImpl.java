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
import com.rhiscom.bpm.console.client.remote.RetailDomainService;
import com.rhiscom.bpm.console.client.remote.RetailDomainServiceAsync;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public class BusinessGroupMaintainerCellTableViewImpl extends Composite implements BusinessGroupMaintainerCellTableView {

    private Presenter presenter;
    private ClientFactory clientFactory;
    private List<BusinessGroupDTO> listadoBusinessGroup = new ArrayList<BusinessGroupDTO>();
    private List<BusinessGroupDTO> listadoVigentes = new ArrayList<BusinessGroupDTO>();

    private static final Binder uiBinder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Widget, BusinessGroupMaintainerCellTableViewImpl> {
    }

    @UiField(provided = true)
    CellTable<BusinessGroupDTO> cellTableBusinessGroup;

    @UiField(provided = true)
    SimplePager pager;

    @UiField
    MenuItem btnRefrescar;

    @UiField
    MenuItem btnAgregar;

    @UiField(provided = true)
    ListBox listadoEstadoListBox;

    @UiField(provided = true)
    ListBox nivelListBox;

    final ListDataProvider<BusinessGroupDTO> businessGroupDataProvider;

    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    private List<AbilityDTO> abilityList;

    public BusinessGroupMaintainerCellTableViewImpl(ClientFactoryImpl clientFactoryImpl) {

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	this.clientFactory = clientFactoryImpl;

	businessGroupDataProvider = new ListDataProvider<BusinessGroupDTO>();
	cellTableBusinessGroup = this.createBusinessGroupCellTable();

	listadoEstadoListBox = new ListBox();
	nivelListBox = new ListBox();

	nivelListBox.addItem(LocaleMessages.LANG.select(), "0");
	nivelListBox.addItem(LocaleMessages.LANG.level1(), "1");
	nivelListBox.addItem(LocaleMessages.LANG.level2(), "2");

	listadoEstadoListBox.addItem(LocaleMessages.LANG.valid(), "1");
	listadoEstadoListBox.addItem(LocaleMessages.LANG.all(), "0");

	listadoEstadoListBox.setVisibleItemCount(1);

	businessGroupDataProvider.addDataDisplay(cellTableBusinessGroup);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTableBusinessGroup);

	initWidget(uiBinder.createAndBindUi(this));
	traerGruposDeNegocios(true);
	listadoEstadoListBox.addChangeHandler(new ChangeHandler() {
	    public void onChange(ChangeEvent event) {
		nivelListBox.setSelectedIndex(0);
		int selectedIndex = listadoEstadoListBox.getSelectedIndex();

		if (listadoEstadoListBox.getValue(selectedIndex).contains("1")) {
		    traerGruposDeNegocios(true);
		} else {
		    traerGruposDeNegocios(false);
		}

	    }
	});

	nivelListBox.addChangeHandler(new ChangeHandler() {
	    public void onChange(ChangeEvent event) {

		int selectedIndex = nivelListBox.getSelectedIndex();

		List<BusinessGroupDTO> listadoTemporal = new ArrayList<BusinessGroupDTO>();

		if (nivelListBox.getValue(selectedIndex).contains("1")) {

		    for (int i = 0; i <= listadoBusinessGroup.size() - 1; i++) {
			if (Long.valueOf(listadoBusinessGroup.get(i).getIdLevelBusinessGroup()).intValue() == 1) {
			    listadoTemporal.add(listadoBusinessGroup.get(i));
			}

		    }

		} else if (nivelListBox.getValue(selectedIndex).contains("2")) {
		    for (int i = 0; i <= listadoBusinessGroup.size() - 1; i++) {
			if (Long.valueOf(listadoBusinessGroup.get(i).getIdLevelBusinessGroup()).intValue() == 2) {
			    listadoTemporal.add(listadoBusinessGroup.get(i));
			}
		    }
		} else {
		    listadoTemporal = listadoBusinessGroup;
		}
		businessGroupDataProvider.setList(listadoTemporal);
		businessGroupDataProvider.refresh();
		cellTableBusinessGroup.redraw();
	    }
	});

	btnRefrescar.setCommand(cmdRefrescar);
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnAgregar")) {
	    btnAgregar.setCommand(cmdAgregar);
	} else {
	    btnAgregar.setVisible(false);
	}

	EventBus eventBusLogin = clientFactory.getEventBus();

	eventBusLogin.addHandler(UpdateBusinessGroupEvent.TYPE, new UpdateBusinessGroupEventHandler() {

	    @Override
	    public void update(UpdateBusinessGroupEvent event) {

		nivelListBox.setSelectedIndex(0);
		int selectedIndex = listadoEstadoListBox.getSelectedIndex();

		if (listadoEstadoListBox.getValue(selectedIndex).contains("1")) {
		    traerGruposDeNegocios(true);
		} else {
		    traerGruposDeNegocios(false);
		}

	    }

	});

    }

    Command cmdRefrescar = new Command() {
	public void execute() {

	    traerGruposDeNegocios(false);

	}
    };

    Command cmdAgregar = new Command() {
	public void execute() {
	    AddUpdateBusinessGroupDialog dialog = new AddUpdateBusinessGroupDialog(retailDomainService,
		    listadoVigentes, clientFactory);

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
    public CellTable<BusinessGroupDTO> createBusinessGroupCellTable() {
	final CellTable<BusinessGroupDTO> table = new CellTable<BusinessGroupDTO>();
	// Create name column.

	TextColumn<BusinessGroupDTO> idBusinessGroup = new TextColumn<BusinessGroupDTO>() {
	    @Override
	    public String getValue(BusinessGroupDTO definition) {
		return String.valueOf(definition.getIdBusinessGroup());
	    }
	};

	TextColumn<BusinessGroupDTO> name = new TextColumn<BusinessGroupDTO>() {
	    @Override
	    public String getValue(BusinessGroupDTO definition) {
		return String.valueOf(definition.getNameBusinessGroup());
	    }
	};

	TextColumn<BusinessGroupDTO> status = new TextColumn<BusinessGroupDTO>() {
	    @Override
	    public String getValue(BusinessGroupDTO definition) {
		if (definition.getStatus() == 1) {
		    return LocaleMessages.LANG.valid();
		} else {
		    return LocaleMessages.LANG.notValid();
		}

	    }
	};

	// Create address column.
	TextColumn<BusinessGroupDTO> levelId = new TextColumn<BusinessGroupDTO>() {
	    @Override
	    public String getValue(BusinessGroupDTO definition) {
		return String.valueOf(definition.getIdLevelBusinessGroup());
	    }
	};

	// Create address column.
	TextColumn<BusinessGroupDTO> createDate = new TextColumn<BusinessGroupDTO>() {
	    @Override
	    public String getValue(BusinessGroupDTO definition) {
		DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy");

		if (definition.getCreateStamp() != null) {
		    return fmtDate.format(definition.getCreateStamp());
		} else {
		    return "N/D";
		}
	    }
	};

	TextColumn<BusinessGroupDTO> updateDate = new TextColumn<BusinessGroupDTO>() {
	    @Override
	    public String getValue(BusinessGroupDTO definition) {
		if (definition.getLastUpdatedStamp() != null) {
		    DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy");

		    return fmtDate.format(definition.getLastUpdatedStamp());
		} else {
		    return "N/D";
		}
	    }
	};

	Column<BusinessGroupDTO, String> editarBtn = new Column<BusinessGroupDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(BusinessGroupDTO c) {

		return LocaleMessages.LANG.edit();

	    }

	};
	editarBtn.setCellStyleNames("buttonEditar");

	editarBtn.setFieldUpdater(new FieldUpdater<BusinessGroupDTO, String>() {

	    @Override
	    public void update(int index, BusinessGroupDTO BusinessGroupDTO, String value) {
		editarBusinessGroup(BusinessGroupDTO);
	    }

	});

	// Add the columns.

	table.addColumn(idBusinessGroup, LocaleMessages.LANG.id());
	table.addColumn(name, LocaleMessages.LANG.name());
	table.addColumn(status, LocaleMessages.LANG.status());
	table.addColumn(levelId, LocaleMessages.LANG.superiorLevel());
	table.addColumn(createDate, LocaleMessages.LANG.createDate());
	table.addColumn(updateDate, LocaleMessages.LANG.lastModification());

	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "editarBtn")) {
	    table.addColumn(editarBtn, " ");
	}

	table.setColumnWidth(idBusinessGroup, 15.0, Unit.PX);
	table.setColumnWidth(name, 120.0, Unit.PX);
	table.setColumnWidth(status, 150.0, Unit.PX);
	table.setColumnWidth(levelId, 150.0, Unit.PX);
	table.setColumnWidth(createDate, 150.0, Unit.PX);
	table.setColumnWidth(updateDate, 150.0, Unit.PX);
	table.setColumnWidth(editarBtn, 120.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    private void editarBusinessGroup(BusinessGroupDTO businessGroupDTO) {
	AddUpdateBusinessGroupDialog dialog = new AddUpdateBusinessGroupDialog(retailDomainService, listadoVigentes,
		businessGroupDTO, clientFactory);

	dialog.center();
	int top = dialog.getAbsoluteTop();
	int left = dialog.getAbsoluteLeft();
	dialog.setPopupPosition(left, top - 100);
	dialog.show();

    }

    /**
     * M�todo que consulta solo los grupos vigentes.
     */
    public void traerGruposDeNegocios(final boolean vigentes) {
	try {

	    retailDomainService.getBusinessGroupAll(new AsyncCallback<List<BusinessGroupDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    Window.alert("Servicio no disponible :" + ex.toString());
		}

		@Override
		public void onSuccess(List<BusinessGroupDTO> list) {

		    List<BusinessGroupDTO> listVigentes = new ArrayList<BusinessGroupDTO>();
		    List<BusinessGroupDTO> listNoVigentes = new ArrayList<BusinessGroupDTO>();

		    for (int i = 0; i <= list.size() - 1; i++) {
			if (list.get(i).getStatus() == 1) {
			    listVigentes.add(list.get(i));
			}
			listNoVigentes.add(list.get(i));

		    }

		    if (vigentes) {
			businessGroupDataProvider.setList(listVigentes);

		    } else {
			businessGroupDataProvider.setList(listNoVigentes);
		    }

		    listadoVigentes = listVigentes;
		    listadoBusinessGroup = businessGroupDataProvider.getList();
		    businessGroupDataProvider.refresh();
		    cellTableBusinessGroup.redraw();
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
