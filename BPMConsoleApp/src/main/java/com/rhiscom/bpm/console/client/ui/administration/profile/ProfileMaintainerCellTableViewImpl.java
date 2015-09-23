package com.rhiscom.bpm.console.client.ui.administration.profile;

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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.event.shared.EventBus;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.event.UpdateProfileEvent;
import com.rhiscom.bpm.console.client.event.UpdateProfileEventHandler;
import com.rhiscom.bpm.console.client.remote.SecurityService;
import com.rhiscom.bpm.console.client.remote.SecurityServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

public class ProfileMaintainerCellTableViewImpl extends Composite implements ProfileMaintainerCellTableView {

    Presenter presenter;
    ClientFactory clientFactory;

    private static ProfileMaintainerCellTableViewImplUiBinder uiBinder = GWT
	    .create(ProfileMaintainerCellTableViewImplUiBinder.class);

    interface ProfileMaintainerCellTableViewImplUiBinder extends UiBinder<Widget, ProfileMaintainerCellTableViewImpl> {
    }

    private List<AbilityDTO> abilityList = new ArrayList<AbilityDTO>();
    private List<ProfileDTO> profileList = new ArrayList<ProfileDTO>();
    private List<FunctionalityModuleDTO> moduleList = new ArrayList<FunctionalityModuleDTO>();

    @UiField(provided = true)
    CellTable<ProfileDTO> cellTableProfiles;

    @UiField(provided = true)
    SimplePager pager;

    @UiField
    MenuItem btnRefrescar;

    @UiField
    MenuItem btnAgregar;

    final ListDataProvider<ProfileDTO> dataProvider;

    final SecurityServiceAsync service = GWT.create(SecurityService.class);
    AddUpdateProfilesDialog addDialog;

    public ProfileMaintainerCellTableViewImpl(ClientFactory clientFactory) {
	traerTodasLasHabilidades();

	traerTodosLosPerfiles();
	traerTodosLosModulos();
	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);
	this.clientFactory = clientFactory;
	dataProvider = new ListDataProvider<ProfileDTO>();
	cellTableProfiles = this.createCellTableProfiles();
	dataProvider.addDataDisplay(cellTableProfiles);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTableProfiles);
	pager.setPageSize(8);
	initWidget(uiBinder.createAndBindUi(this));
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnAgregar")) {
	    btnAgregar.setCommand(cmdAgregar);

	} else {
	    btnAgregar.setVisible(false);
	}

	btnRefrescar.setCommand(cmdRefrescar);
	btnRefrescar.setTitle("Refrecar listado");
	btnAgregar.setTitle("Agregar nuevo perfil");

	EventBus eventBusLogin = clientFactory.getEventBus();

	eventBusLogin.addHandler(UpdateProfileEvent.TYPE, new UpdateProfileEventHandler() {

	    @Override
	    public void update(UpdateProfileEvent event) {
		traerTodosLosPerfiles();

	    }

	});

    }

    Command cmdAgregar = new Command() {
	public void execute() {
	    addDialog = new AddUpdateProfilesDialog(abilityList, moduleList, service, clientFactory, profileList);
	    addDialog.center();
	    int top = addDialog.getAbsoluteTop();
	    int left = addDialog.getAbsoluteLeft();
	    addDialog.setPopupPosition(left, top - 10);
	    addDialog.show();
	}
    };
    Command cmdRefrescar = new Command() {
	public void execute() {
	    dataProvider.setList(new ArrayList<ProfileDTO>());
	    dataProvider.refresh();
	    cellTableProfiles.redraw();
	    traerTodosLosPerfiles();
	    traerTodasLasHabilidades();
	    traerTodosLosModulos();
	}
    };

    private CellTable<ProfileDTO> createCellTableProfiles() {
	final CellTable<ProfileDTO> table = new CellTable<ProfileDTO>();
	// Create name column.
	TextColumn<ProfileDTO> id = new TextColumn<ProfileDTO>() {
	    @Override
	    public String getValue(ProfileDTO definition) {
		return String.valueOf(definition.getSegProfileId());
	    }
	};

	TextColumn<ProfileDTO> name = new TextColumn<ProfileDTO>() {
	    @Override
	    public String getValue(ProfileDTO definition) {
		return String.valueOf(definition.getName());
	    }
	};

	TextColumn<ProfileDTO> createStamp = new TextColumn<ProfileDTO>() {
	    @Override
	    public String getValue(ProfileDTO definition) {
		DateTimeFormat fmtDate = DateTimeFormat.getFormat("dd/MM/yyyy");

		return fmtDate.format(definition.getCreateStamp());
	    }
	};

	Column<ProfileDTO, String> editarBtn = new Column<ProfileDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(ProfileDTO c) {

		return "Editar ";

	    }

	};
	editarBtn.setCellStyleNames("buttonEditar");

	editarBtn.setFieldUpdater(new FieldUpdater<ProfileDTO, String>() {

	    @Override
	    public void update(int index, ProfileDTO ProfileDTO, String value) {
		editarPerfil(ProfileDTO);
	    }

	});

	Column<ProfileDTO, String> eliminarBtn = new Column<ProfileDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(ProfileDTO c) {

		return "Eliminar ";

	    }

	};
	eliminarBtn.setCellStyleNames("buttonBorrar");

	eliminarBtn.setFieldUpdater(new FieldUpdater<ProfileDTO, String>() {

	    @Override
	    public void update(int index, ProfileDTO profileDTO, String value) {
		eliminarPerfil(profileDTO);
	    }

	});
	
	table.addColumn(id, "Id");
	table.addColumn(name, LocaleMessages.LANG.name());
	table.addColumn(createStamp, LocaleMessages.LANG.createDate());
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "editarBtn"))
	    table.addColumn(editarBtn, " ");

	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "eliminarBtn"))
	    table.addColumn(eliminarBtn, " ");

	table.setColumnWidth(id, 15.0, Unit.PX);
	table.setColumnWidth(name, 250.0, Unit.PX);
	table.setColumnWidth(createStamp, 250.0, Unit.PX);
	table.setColumnWidth(editarBtn, 90.0, Unit.PX);
	table.setColumnWidth(eliminarBtn, 90.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    private void editarPerfil(ProfileDTO profileDTO) {
	addDialog = new AddUpdateProfilesDialog(abilityList, moduleList, service, clientFactory, profileDTO,
		profileList);
	addDialog.center();
	int top = addDialog.getAbsoluteTop();
	int left = addDialog.getAbsoluteLeft();
	addDialog.setPopupPosition(left, top - 10);
	addDialog.show();
    }

    private void eliminarPerfil(ProfileDTO profileDTO) {

	if (profileDTO.getName().compareToIgnoreCase("administrador") != 0) {

	    final Notification not = new Notification(true, true);
	    try {

		service.deleteProfile(profileDTO, new AsyncCallback() {

		    @Override
		    public void onFailure(Throwable ex) {
			InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorDeleteProfile()
				+ " : " + ex.getLocalizedMessage());
			dialog.center();
			dialog.show();

		    }

		    @Override
		    public void onSuccess(Object arg0) {
			traerTodosLosPerfiles();
			not.show(5000, "Perfil eliminado exitosamente", Notification.OK);
			clientFactory.getEventBus().fireEvent(new UpdateProfileEvent());
		    }

		});
	    } catch (Exception ex) {
		InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorDeleteProfile() + " : "
			+ ex.getLocalizedMessage());
		dialog.center();
		dialog.show();
	    }
	} else {
	    InformationDialog dialog = new InformationDialog("No se puede elimiar este perfil");
	    dialog.center();
	    dialog.show();
	}
    }

    private void traerTodosLosPerfiles() {
	try {

	    service.getAllProfiles(new AsyncCallback<List<ProfileDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorGetProfiles() + " :"
			    + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(List<ProfileDTO> list) {
		    dataProvider.setList(list);
		    dataProvider.refresh();
		    cellTableProfiles.redraw();
		    profileList=list;
		    
		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorGetProfiles() + " :"
		    + ex.toString());
	    dialog.center();
	    dialog.show();
	}

    }

    private void traerTodasLasHabilidades() {
	try {

	    service.getAllAbilityes(new AsyncCallback<List<AbilityDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorGetAbilities() + " :"
			    + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(List<AbilityDTO> list) {
		    abilityList = list;
		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorGetAbilities() + " :"
		    + ex.toString());
	    dialog.center();
	    dialog.show();
	}

    }

    private void traerTodosLosModulos() {
	try {

	    service.getAllModules(new AsyncCallback<List<FunctionalityModuleDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(List<FunctionalityModuleDTO> list) {
		    moduleList = list;
		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog("Error  :" + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

    @Override
    public void setPresenter(Presenter presenter) {
	this.presenter = presenter;

    }

}
