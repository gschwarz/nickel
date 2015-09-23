package com.rhiscom.bpm.console.client.ui.administration;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.event.shared.EventBus;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.event.UpdateBusinessUnitEvent;
import com.rhiscom.bpm.console.client.event.UpdateBusinessUnitEventHandler;
import com.rhiscom.bpm.console.client.event.UpdateProfileEvent;
import com.rhiscom.bpm.console.client.event.UpdateProfileEventHandler;
import com.rhiscom.bpm.console.client.event.UpdateUserEvent;
import com.rhiscom.bpm.console.client.event.UpdateUserEventHandler;
import com.rhiscom.bpm.console.client.remote.ResolverGroupsService;
import com.rhiscom.bpm.console.client.remote.ResolverGroupsServiceAsync;
import com.rhiscom.bpm.console.client.remote.RetailDomainService;
import com.rhiscom.bpm.console.client.remote.RetailDomainServiceAsync;
import com.rhiscom.bpm.console.client.remote.SecurityService;
import com.rhiscom.bpm.console.client.remote.SecurityServiceAsync;
import com.rhiscom.bpm.console.client.remote.UserService;
import com.rhiscom.bpm.console.client.remote.UserServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;

public class UserMaintainerCellTableViewImpl extends Composite implements UserMaintainerCellTableView {

    private static final Binder binder = GWT.create(Binder.class);
    private Presenter presenter;
    private ClientFactory clientFactory;
    private List<ResolverGroupDTO> workGroupList;
    private List<ProfileDTO> profileList;
    InformationDialog dialog;
    AddUpdateUserDialog addDialog;

    interface Binder extends UiBinder<Widget, UserMaintainerCellTableViewImpl> {
    }

    @UiField(provided = true)
    CellTable<OperatorDTO> cellTableUsers;

    @UiField(provided = true)
    SimplePager pager;

    @UiField
    TextBox txtUsuarioBuscar;
    @UiField(provided = true)
    Label lblError;

    @UiField
    MenuItem btnAgregar;
    @UiField
    MenuItem btnRefrescar;

    final ListDataProvider<OperatorDTO> dataProvider;
    final UserServiceAsync service = GWT.create(UserService.class);
    final ResolverGroupsServiceAsync resolverGroupService = GWT.create(ResolverGroupsService.class);
    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    final SecurityServiceAsync securityService = GWT.create(SecurityService.class);
    private List<AbilityDTO> abilityList;
    private List<BusinessUnitDTO> listBusinessUnitVigentes = new ArrayList<BusinessUnitDTO>();

    public UserMaintainerCellTableViewImpl(ClientFactory clientFactoryImpl) {

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	this.clientFactory = clientFactoryImpl;
	lblError = new Label();
	lblError.setVisible(false);

	dataProvider = new ListDataProvider<OperatorDTO>();

	cellTableUsers = this.createUserCellTable();

	dataProvider.addDataDisplay(cellTableUsers);
	
	
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTableUsers);
	pager.setPageSize(12);
	
	
	
	
	initWidget(binder.createAndBindUi(this));
	
	
	traerTodosLosUsuarios();
	
	
	traerGruposVigentes();
	traerPerfiles();
	traerUnidadesDeNegocios(true);
	EventBus eventBusLogin = clientFactory.getEventBus();

	eventBusLogin.addHandler(UpdateUserEvent.TYPE, new UpdateUserEventHandler() {

	    @Override
	    public void update(UpdateUserEvent event) {

		traerTodosLosUsuarios();

	    }

	});

	eventBusLogin.addHandler(UpdateBusinessUnitEvent.TYPE, new UpdateBusinessUnitEventHandler() {

	    @Override
	    public void update(UpdateBusinessUnitEvent event) {

		traerUnidadesDeNegocios(true);

	    }

	});

	eventBusLogin.addHandler(UpdateProfileEvent.TYPE, new UpdateProfileEventHandler() {

	    @Override
	    public void update(UpdateProfileEvent event) {

		traerPerfiles();
	    }

	});
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnAgregar")) {
	    btnAgregar.setCommand(cmdAgregar);
	} else {
	    btnAgregar.setVisible(false);
	}

	btnRefrescar.setCommand(cmdRefrescar);
	btnAgregar.setTitle("Agregar usuario");
	btnRefrescar.setTitle("Refrescar listado");

    }

    public void traerPerfiles() {

	try {
	    securityService.getAllProfiles(new AsyncCallback<List<ProfileDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		   
		}

		@Override
		public void onSuccess(List<ProfileDTO> list) {
		    profileList = list;
		}
	    });
	} catch (Exception e) {
	   
	}

    }

    /**
     * Método que consulta solo los grupos vigentes.
     */
    public void traerGruposVigentes() {

	resolverGroupService.getAllOK(new AsyncCallback<List<ResolverGroupDTO>>() {

	    @Override
	    public void onFailure(Throwable arg0) {
		dialog = new InformationDialog(LocaleMessages.LANG.errorGetWorkGroup());
		dialog.center();
		dialog.show();
	    }

	    @Override
	    public void onSuccess(List<ResolverGroupDTO> list) {
		workGroupList = list;
	    }
	});
    }

    Command cmdRefrescar = new Command() {
	public void execute() {
	    lblError.setVisible(false);
	    traerGruposVigentes();
	    dataProvider.setList(new ArrayList<OperatorDTO>());
	    dataProvider.refresh();
	    cellTableUsers.redraw();
	    traerTodosLosUsuarios();
	    traerPerfiles();

	}
    };

    @UiHandler("btnBuscar")
    void onClickBuscar(ClickEvent e) {
	traerGruposVigentes();
	String name = this.txtUsuarioBuscar.getText();
	if(name.trim().length()==0) {
	    lblError.setText("Se debe ingresar usuario a buscar");
	     lblError.setVisible(true);
	}else {
	dataProvider.setList(new ArrayList<OperatorDTO>());
	dataProvider.refresh();
	cellTableUsers.redraw();
	traerUsuario(name);
	}
    }

    Command cmdAgregar = new Command() {
	public void execute() {
	    addDialog = new AddUpdateUserDialog(service, workGroupList, clientFactory, profileList,
		    listBusinessUnitVigentes);
	    addDialog.center();
	    addDialog.show();
	}
    };

    public void traerTodosLosUsuarios() {

	try {

	    service.getAllOperator(new AsyncCallback<List<OperatorDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    if (ex.getMessage().contains("NO_EXISTE") == true) {
			lblError.setText(LocaleMessages.LANG.userNotFound());
			lblError.setVisible(true);
		    } else {

			dialog = new InformationDialog(LocaleMessages.LANG.errorGetUser() + ex.toString());
			dialog.center();
			dialog.show();
		    }
		}

		@Override
		public void onSuccess(List<OperatorDTO> list) {
		    dataProvider.setList(list);
		    dataProvider.refresh();
		    cellTableUsers.redraw();

		}

	    });
	} catch (Exception ex) {
	    dialog = new InformationDialog(LocaleMessages.LANG.errorDeleteUser() + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

    public void traerUsuario(String usuario) {
	try {

	    service.searchOperator(usuario, new AsyncCallback<OperatorDTO>() {

		@Override
		public void onFailure(Throwable ex) {
		    if (ex.getMessage().contains("NO_EXISTE") == true) {
			lblError.setText(LocaleMessages.LANG.userNotFound());
			lblError.setVisible(true);
		    } else {

			dialog = new InformationDialog(LocaleMessages.LANG.errorGetUser() + " " + ex.toString());
			dialog.center();
			dialog.show();
		    }
		}

		@Override
		public void onSuccess(OperatorDTO op) {
		    lblError.setVisible(false);
		    List<OperatorDTO> list = new ArrayList<OperatorDTO>();

		    list.add(op);
		    dataProvider.setList(list);
		    dataProvider.refresh();
		    cellTableUsers.redraw();
		}

	    });
	} catch (Exception ex) {
	   
	}
    }

    private void editarUsuario(OperatorDTO operatorDTO) {
	addDialog = new AddUpdateUserDialog(service, workGroupList, operatorDTO, clientFactory, profileList,
		listBusinessUnitVigentes);
	addDialog.center();
	addDialog.show();

    }

    private void eliminarUsuario(OperatorDTO operatorDTO) {

	if (ApplicationContext.getAuth().getUser().compareToIgnoreCase(operatorDTO.getUser()) != 0) {

	    final Notification not = new Notification(true, true);
	    try {

		service.deleteOperator(operatorDTO, new AsyncCallback() {

		    @Override
		    public void onFailure(Throwable ex) {
			dialog = new InformationDialog(LocaleMessages.LANG.errorDeleteUser() + ex.toString());
			dialog.center();
			dialog.show();
		    }

		    @Override
		    public void onSuccess(Object op) {
			not.show(5000, LocaleMessages.LANG.userDeleted(), Notification.OK);

			traerTodosLosUsuarios();

		    }

		});
	    } catch (Exception ex) {
		dialog = new InformationDialog(LocaleMessages.LANG.errorDeleteUser() + ex.toString());
		dialog.center();
		dialog.show();
	    }
	} else {
	    dialog = new InformationDialog("El usuario no se puede eliminar");
	    dialog.center();
	    dialog.show();
	}
    }

    /**
     * Método que construye la tabla donde se listan los usuarios.
     * 
     * @return
     */
    public CellTable<OperatorDTO> createUserCellTable() {
	final CellTable<OperatorDTO> table = new CellTable<OperatorDTO>();
	// Create name column.

	TextColumn<OperatorDTO> username = new TextColumn<OperatorDTO>() {
	    @Override
	    public String getValue(OperatorDTO definition) {
		return String.valueOf(definition.getUser());
	    }
	};

	TextColumn<OperatorDTO> firstName = new TextColumn<OperatorDTO>() {
	    @Override
	    public String getValue(OperatorDTO definition) {

		return definition.getWorker().getPerson().getFirstName();

	    }
	};

	// Create address column.
	TextColumn<OperatorDTO> middleName = new TextColumn<OperatorDTO>() {
	    @Override
	    public String getValue(OperatorDTO definition) {
		return definition.getWorker().getPerson().getMiddleName();
	    }
	};
	// Create address column.
	TextColumn<OperatorDTO> lastName = new TextColumn<OperatorDTO>() {
	    @Override
	    public String getValue(OperatorDTO definition) {
		return definition.getWorker().getPerson().getLastName();
	    }
	};

	TextColumn<OperatorDTO> workGroupName = new TextColumn<OperatorDTO>() {
	    @Override
	    public String getValue(OperatorDTO definition) {
		return definition.getWorkGroups().toArray().toString();
	    }
	};

	TextColumn<OperatorDTO> email = new TextColumn<OperatorDTO>() {
	    @Override
	    public String getValue(OperatorDTO definition) {
		return definition.getWorker().getPerson().getEmail();
	    }
	};

	TextColumn<OperatorDTO> createDate = new TextColumn<OperatorDTO>() {
	    @Override
	    public String getValue(OperatorDTO definition) {
		DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy");

		return fmtDate.format(definition.getCreateDate());
	    }
	};
	Column<OperatorDTO, String> editarBtn = new Column<OperatorDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(OperatorDTO c) {

		return LocaleMessages.LANG.edit();

	    }

	};
	editarBtn.setCellStyleNames("buttonEditar");
	editarBtn.setFieldUpdater(new FieldUpdater<OperatorDTO, String>() {

	    @Override
	    public void update(int index, OperatorDTO operatorDTO, String value) {
		editarUsuario(operatorDTO);
	    }

	});
	editarBtn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

	Column<OperatorDTO, String> deleteBtn = new Column<OperatorDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(OperatorDTO c) {

		return LocaleMessages.LANG.delete();

	    }

	};
	deleteBtn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	deleteBtn.setCellStyleNames("buttonBorrar");
	deleteBtn.setFieldUpdater(new FieldUpdater<OperatorDTO, String>() {

	    @Override
	    public void update(int index, OperatorDTO operatorDTO, String value) {
		eliminarUsuario(operatorDTO);
	    }

	});

	// Add the columns.

	table.addColumn(username, LocaleMessages.LANG.user());
	table.addColumn(firstName, LocaleMessages.LANG.name());
	table.addColumn(lastName, LocaleMessages.LANG.lastName());

	table.addColumn(email, LocaleMessages.LANG.contact());
	table.addColumn(createDate, LocaleMessages.LANG.createDate());

	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "editarBtn")) {
	    table.addColumn(editarBtn, " ");
	}
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "deleteBtn")) {
	    table.addColumn(deleteBtn, " ");
	}
	table.setColumnWidth(username, 90.0, Unit.PX);
	table.setColumnWidth(firstName, 100.0, Unit.PX);
	// table.setColumnWidth(middleName, 120.0, Unit.PX);
	table.setColumnWidth(lastName, 100.0, Unit.PX);
	table.setColumnWidth(email, 100.0, Unit.PX);
	table.setColumnWidth(createDate, 130.0, Unit.PX);

	table.setColumnWidth(editarBtn, 60.0, Unit.PX);
	table.setColumnWidth(deleteBtn, 60.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    /**
     * Método que consulta solo los grupos vigentes.
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
		    listBusinessUnitVigentes = listVigentes;
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
