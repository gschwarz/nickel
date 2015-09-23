package com.rhiscom.bpm.console.client.ui.administration;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.event.UpdateUserEvent;
import com.rhiscom.bpm.console.client.remote.ResolverGroupsService;
import com.rhiscom.bpm.console.client.remote.ResolverGroupsServiceAsync;
import com.rhiscom.bpm.console.client.remote.SecurityService;
import com.rhiscom.bpm.console.client.remote.SecurityServiceAsync;
import com.rhiscom.bpm.console.client.remote.UserServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.PersonDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.WorkerDTO;

public class AddUpdateUserDialog extends DialogBox {

    private static final Binder binder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Widget, AddUpdateUserDialog> {
    }

    public static final String viewCode = "madm_fnusr";
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    boolean errorExistencia = true;

    ClientFactory clientFactory;
    UserServiceAsync service;

    @UiField(provided = true)
    TextBox txtSegundoNombre;
    @UiField(provided = true)
    TextBox txtApellido;
    @UiField(provided = true)
    TextBox txtNombre;
    @UiField(provided = true)
    TextBox txtEmail;
    @UiField(provided = true)
    TextBox txtIdentification;
    @UiField
    ListBox lstGender;
    @UiField(provided = true)
    ListBox lstBusinessUnit;
    @UiField(provided = true)
    TextBox txtUser;
    @UiField(provided = true)
    PasswordTextBox txtPassword;
    @UiField
    Button btnCancelar;
    @UiField(provided = true)
    Label lblError;
    @UiField
    Button btnGuardar;
    @UiField
    ListBox lstParty;
    @UiField(provided = true)
    ListBox lstPerfil;

    private OperatorDTO operatorDTO = null;
    final ListDataProvider<ResolverGroupDTO> dataProvider;
    private List<ProfileDTO> profileList;

    final ResolverGroupsServiceAsync resolverGroupService = GWT.create(ResolverGroupsService.class);
    final SecurityServiceAsync profileService = GWT.create(SecurityService.class);
    private List<AbilityDTO> abilityList;
    private List<BusinessUnitDTO> listBusinessUnitVigentes;
    List<ResolverGroupDTO> workGroupListLocal;

    /**
     * Constructor para agregar nuevo usuario.
     * 
     * @param service
     * @param clientFactory
     */
    public AddUpdateUserDialog(UserServiceAsync service, List<ResolverGroupDTO> workGroupList,
	    ClientFactory clientFactory, List<ProfileDTO> profileList2, List<BusinessUnitDTO> listBusinessUnitVigentes2) {
	this.listBusinessUnitVigentes = listBusinessUnitVigentes2;
	dataProvider = new ListDataProvider<ResolverGroupDTO>();
	profileList = profileList2;

	defaultConstructor(service, workGroupList, clientFactory);

	try {
	    setWidget(binder.createAndBindUi(this));
	} catch (Exception ex) {

	}

	List<ResolverGroupDTO> list = new ArrayList<ResolverGroupDTO>();

	txtUser.addBlurHandler(new BlurHandlerUser());
	dataProvider.setList(list);
	dataProvider.refresh();

    }

    /**
     * Constructor para edición
     * 
     * @param service
     * @param operatorDTO
     * @param clientFactory
     */
    public AddUpdateUserDialog(UserServiceAsync service, List<ResolverGroupDTO> workGroupList,
	    OperatorDTO operatorDTO2, ClientFactory clientFactory, List<ProfileDTO> profileList2,
	    List<BusinessUnitDTO> listBusinessUnitVigentes2) {

	OperatorDTO loggedOperator = ApplicationContext.getAuth().getOperator();
	this.listBusinessUnitVigentes = listBusinessUnitVigentes2;
	abilityList = SecurityUtil.getAbilityes(loggedOperator, viewCode);

	dataProvider = new ListDataProvider<ResolverGroupDTO>();
	profileList = profileList2;
	defaultConstructor(service, workGroupList, clientFactory);

	txtSegundoNombre.setText(operatorDTO2.getWorker().getPerson().getLastName());
	txtNombre.setText(operatorDTO2.getWorker().getPerson().getFirstName());
	txtSegundoNombre.setText(operatorDTO2.getWorker().getPerson().getMiddleName());
	txtEmail.setText(operatorDTO2.getWorker().getPerson().getEmail());
	txtUser.setText(operatorDTO2.getUser());
	txtApellido.setText(operatorDTO2.getWorker().getPerson().getLastName());
	txtUser.setEnabled(false);
	txtIdentification.setEnabled(false);
	txtPassword.setText(operatorDTO2.getPassword());
	errorExistencia = false;
	this.operatorDTO = operatorDTO2;

	List<ResolverGroupDTO> list = new ArrayList<ResolverGroupDTO>(operatorDTO.getWorkGroups());
	dataProvider.setList(list);
	dataProvider.refresh();

	try {
	    setWidget(binder.createAndBindUi(this));
	} catch (Exception ex) {

	}

	if (operatorDTO != null) {

	    if (operatorDTO.getWorker().getPerson().getGender() == 1) {

		lstGender.setItemSelected(0, true);
	    } else {
		lstGender.setItemSelected(1, true);
	    }

	    if (operatorDTO.getWorker().getPerson().getPartyId().equals("1")) {

		lstParty.setItemSelected(0, true);
	    } else {
		lstParty.setItemSelected(1, true);
	    }

	    int count = 0;

	    count = lstPerfil.getItemCount();
	    for (int i = 0; i <= count - 1; i++) {
		if (operatorDTO.getProfileDTO() != null) {
		    long index = operatorDTO.getProfileDTO().getSegProfileId();
		    if (lstPerfil.getValue(i).compareTo(String.valueOf(index)) == 0) {
			lstPerfil.setItemSelected(i, true);
			break;
		    }

		}
	    }

	    count = lstBusinessUnit.getItemCount();
	    for (int i = 0; i <= count - 1; i++) {
		if (operatorDTO.getBussinessUnitDTO() != null) {
		    long index = operatorDTO.getBussinessUnitDTO().getIdBusinessUnit();
		    if (lstBusinessUnit.getValue(i).compareTo(String.valueOf(index)) == 0) {
			lstBusinessUnit.setItemSelected(i, true);
			break;
		    }

		}
	    }
	}

	txtUser.addBlurHandler(new BlurHandlerUser());

	if (!PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnGuardar"))
	    btnGuardar.setEnabled(false);

    }

    /**
     * Manejador del evento click para el boton Guardar.
     * 
     * @param e
     */
    @UiHandler("btnGuardar")
    void onClickGuardar(ClickEvent e) {
	boolean error = true;
	boolean errorNombre = true;
	boolean errorSegundoNombre = true;
	boolean errorApellido = true;
	boolean errorId = true;
	boolean errorEmail = true;
	boolean errorUser = true;
	boolean errorPassword = true;
	boolean errorProfile = true;
	boolean errorBusinessGroup = true;

	String nombre = this.txtNombre.getText();
	String apellido = this.txtApellido.getText();
	String segundoNombre = this.txtSegundoNombre.getText();
	String email = this.txtEmail.getText();
	String user = this.txtUser.getText();
	String password = this.txtPassword.getText();

	// Se agrega un nuevo objeto

	if (nombre.trim().length() > 2) {
	    error = false;
	    errorNombre = false;

	} else {
	    lblError.setVisible(true);
	    lblError.setText(LocaleMessages.LANG.errorNameUserAdd());
	    this.txtNombre.setFocus(true);
	    error = true;
	}

	if (errorNombre == false) {
	    if (segundoNombre.length() > 2) {
		error = false;
		errorSegundoNombre = false;
	    } else {
		lblError.setVisible(true);
		lblError.setText(LocaleMessages.LANG.errorSecondNameUserAdd());
		this.txtSegundoNombre.setFocus(true);
		error = true;
	    }

	}

	if (errorSegundoNombre == false) {
	    if (apellido.trim().length() > 2) {
		error = false;
		errorApellido = false;

	    } else {
		lblError.setVisible(true);
		lblError.setText(LocaleMessages.LANG.errorLastNameUserAdd());
		this.txtApellido.setFocus(true);
		error = true;
	    }
	}
	if (errorApellido == false) {
	    if (email.trim().length() > 0 && !errorApellido) {

		if (email.matches(PATTERN_EMAIL)) {

		    error = false;
		    errorId = false;
		}

		else {
		    lblError.setVisible(true);
		    lblError.setText(LocaleMessages.LANG.errorMailUserAdd());
		    this.txtEmail.setFocus(true);
		    errorEmail = true;
		    error = true;

		}

	    } else {
		lblError.setVisible(true);
		lblError.setText(LocaleMessages.LANG.errorMailUserAdd());
		this.txtEmail.setFocus(true);
		errorEmail = true;
		error = true;
	    }
	}

	if (errorId == false) {
	    if (user.trim().length() > 2 && !errorEmail) {

		error = false;
		errorEmail = false; // chain the next verification

	    } else {
		lblError.setVisible(true);
		lblError.setText(LocaleMessages.LANG.errorLoginUserAdd());
		this.txtUser.setFocus(true);
		error = true;
	    }
	}

	if (errorEmail == false) {
	    if (user.trim().length() > 2 && !errorEmail) {

		error = false;
		errorUser = false;

	    } else {
		lblError.setVisible(true);
		lblError.setText(LocaleMessages.LANG.errorLoginUserAdd());
		this.txtUser.setFocus(true);
		error = true;
	    }
	}
	if (errorUser == false) {
	    if (password.trim().length() > 7 && !errorUser) {

		if (!password.contains(user)) {

		    error = false;
		    errorPassword = false;
		} else {
		    lblError.setVisible(true);
		    lblError.setText(LocaleMessages.LANG.errorPasswordSameUser());
		    this.txtPassword.setFocus(true);
		    error = true;
		    errorPassword = true;
		}

	    } else {
		lblError.setVisible(true);
		lblError.setText(LocaleMessages.LANG.errorPasswordUserAdd());
		this.txtPassword.setFocus(true);
		error = true;
		errorPassword = true;
	    }
	}
	if (errorPassword == false) {
	    if (lstPerfil.getSelectedIndex() > 0) {
		error = false;
		errorProfile = false;

	    } else {
		lblError.setVisible(true);
		lblError.setText("Debe seleccionar perfil");
		this.lstPerfil.setFocus(true);
		error = true;
	    }

	}
	if (errorProfile == false) {
	    if (this.lstBusinessUnit.getSelectedIndex() > 0) {
		error = false;
		errorProfile = false;

	    } else {
		lblError.setVisible(true);
		lblError.setText("Debe seleccionar unidad de negocio");
		this.lstPerfil.setFocus(true);
		error = true;
	    }
	}

	/*** Se consulta si se edita o agrega nuevo usuario ****/

	if (operatorDTO == null) {

	    if (!error && !errorExistencia) {
		agregarNuevoUsuario();
		lblError.setVisible(false);
		this.hide();
	    }
	    // Se edita objeto existente.
	} else {

	    if (!error && !errorExistencia) {
		editarUsuario();
		lblError.setVisible(false);
		this.hide();
	    }
	}

    }

    @SuppressWarnings("unchecked")
    private void editarUsuario() {
	try {

	    String nombre = this.txtNombre.getText();
	    String apellido = this.txtApellido.getText();
	    String segundoNombre = this.txtSegundoNombre.getText();
	    String email = this.txtEmail.getText();
	    String user = this.txtUser.getText();
	    String password = this.txtPassword.getText();
	    List<ResolverGroupDTO> listadoGrupoResolutores = dataProvider.getList();
	    Set<ResolverGroupDTO> grupoResolutoresSet = new HashSet<ResolverGroupDTO>(listadoGrupoResolutores);
	    String gender = lstGender.getValue(lstGender.getSelectedIndex());
	    String identification = txtIdentification.getText();

	    PersonDTO personDTO = new PersonDTO(operatorDTO.getWorker().getPerson().getPersonId(), operatorDTO
		    .getWorker().getPerson().getPartyId(), identification, nombre, segundoNombre, apellido,
		    Long.valueOf(gender), email);

	    WorkerDTO workerDTO = new WorkerDTO(operatorDTO.getWorker().getWorkerId(), personDTO);

	    OperatorDTO operatorLocal = new OperatorDTO(operatorDTO.getOperatorId(), user, password,
		    grupoResolutoresSet, workerDTO, operatorDTO.getCreateDate(), null);

	    String idProfile = lstPerfil.getValue(lstPerfil.getSelectedIndex());
	    String idBusinesUnit = lstBusinessUnit.getValue(lstBusinessUnit.getSelectedIndex());

	    for (int i = 0; i <= profileList.size() - 1; i++) {
		if (Long.valueOf(idProfile) == profileList.get(i).getSegProfileId()) {
		    operatorLocal.setProfileDTO(profileList.get(i));
		    break;
		}

	    }

	    for (int i = 0; i <= listBusinessUnitVigentes.size() - 1; i++) {
		if (Long.valueOf(idBusinesUnit) == listBusinessUnitVigentes.get(i).getIdBusinessUnit()) {
		    operatorLocal.setBussinessUnitDTO(listBusinessUnitVigentes.get(i));
		    break;
		}

	    }
	    final Notification not = new Notification(true, true);
	    service.editOperator(operatorLocal, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.userEditNOK() + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {

		    clientFactory.getEventBus().fireEvent(new UpdateUserEvent());
		    not.show(5000, LocaleMessages.LANG.userEditOK(), Notification.OK);

		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.userEditNOK() + ex.toString());
	    dialog.center();
	    dialog.show();
	}

    }

    /**
     * M�todo que agrega nuevo usuario.
     */
    private void agregarNuevoUsuario() {

	try {

	    String nombre = this.txtNombre.getText();
	    String apellido = this.txtApellido.getText();
	    String segundoNombre = this.txtSegundoNombre.getText();
	    String email = this.txtEmail.getText();
	    String user = this.txtUser.getText();
	    String password = this.txtPassword.getText();

	    String gender = lstGender.getValue(lstGender.getSelectedIndex());
	    String identification = txtIdentification.getText();
	    List<ResolverGroupDTO> listadoGrupoResolutores = dataProvider.getList();
	    Set<ResolverGroupDTO> grupoResolutoresSet = new HashSet<ResolverGroupDTO>(listadoGrupoResolutores);

	    String idProfile = lstPerfil.getValue(lstPerfil.getSelectedIndex());

	    PersonDTO personDTO = new PersonDTO("1", identification, nombre, segundoNombre, apellido,
		    Long.valueOf(gender), email);

	    WorkerDTO workerDTO = new WorkerDTO(personDTO);

	    OperatorDTO operatorLocal = new OperatorDTO(user, password, grupoResolutoresSet, workerDTO, new Date(),
		    null);

	    String idBusinesUnit = lstBusinessUnit.getValue(lstBusinessUnit.getSelectedIndex());

	    for (int i = 0; i <= listBusinessUnitVigentes.size() - 1; i++) {
		if (Long.valueOf(idBusinesUnit) == listBusinessUnitVigentes.get(i).getIdBusinessUnit()) {
		    operatorLocal.setBussinessUnitDTO(listBusinessUnitVigentes.get(i));
		    break;
		}

	    }

	    for (int i = 0; i <= profileList.size() - 1; i++) {
		if (Long.valueOf(idProfile) == profileList.get(i).getSegProfileId()) {
		    operatorLocal.setProfileDTO(profileList.get(i));
		}

	    }
	    final Notification not = new Notification(true, true);
	    service.addOperator(operatorLocal, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.userAddNOK() + ex.toString());
		    dialog.center();
		    dialog.show();
		}

		@Override
		public void onSuccess(Object arg0) {

		    clientFactory.getEventBus().fireEvent(new UpdateUserEvent());
		    not.show(5000, LocaleMessages.LANG.userAddOk(), Notification.OK);

		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.userAddNOK() + ex.toString());
	    dialog.center();
	    dialog.show();
	}
	// TODO Auto-generated method stub

    }

    /**
     * Manejo evento de cierre.
     * 
     * @param e
     */
    @UiHandler("btnCancelar")
    void onClickCancelar(ClickEvent e) {

	this.hide();

    }

    /**
     * Construye los Uifield provistos
     * 
     * @param service
     * @param clientFactory
     */
    private void defaultConstructor(UserServiceAsync service, List<ResolverGroupDTO> workGroupList,
	    ClientFactory clientFactory) {

	this.clientFactory = clientFactory;
	this.service = service;
	workGroupListLocal = workGroupList;

	traerGruposVigentes();
	lblError = new Label();
	lblError.setVisible(false);
	lblError.setStyleName("lblError");
	txtSegundoNombre = new TextBox();
	txtApellido = new TextBox();
	txtNombre = new TextBox();
	txtEmail = new TextBox();
	txtUser = new TextBox();
	txtPassword = new PasswordTextBox();
	txtIdentification = new TextBox();
	lstPerfil = new ListBox();
	lstBusinessUnit = new ListBox();

	setAnimationEnabled(false);
	setGlassEnabled(true);
	setText(LocaleMessages.LANG.editUserDialog());

	lstPerfil.addItem(LocaleMessages.LANG.select(), "-1");

	for (int i = 0; i <= this.profileList.size() - 1; i++) {
	    lstPerfil.addItem(profileList.get(i).getName(), String.valueOf(profileList.get(i).getSegProfileId()));
	}

	lstBusinessUnit.addItem(LocaleMessages.LANG.select(), "-1");

	for (int i = 0; i <= this.listBusinessUnitVigentes.size() - 1; i++) {
	    lstBusinessUnit.addItem(listBusinessUnitVigentes.get(i).getNameBusinessUnit(),
		    String.valueOf(listBusinessUnitVigentes.get(i).getIdBusinessUnit()));
	}

    }

    /**
     * M�todo para crear tabla de grupos resolutores.
     * 
     * @return
     */
    private CellTable<ResolverGroupDTO> createCellTable() {
	final CellTable<ResolverGroupDTO> table = new CellTable<ResolverGroupDTO>();
	// Create name column.

	TextColumn<ResolverGroupDTO> id = new TextColumn<ResolverGroupDTO>() {
	    @Override
	    public String getValue(ResolverGroupDTO definition) {
		return String.valueOf(definition.getWorkGroupid());
	    }
	};
	TextColumn<ResolverGroupDTO> name = new TextColumn<ResolverGroupDTO>() {
	    @Override
	    public String getValue(ResolverGroupDTO definition) {
		return String.valueOf(definition.getName());
	    }
	};

	TextColumn<ResolverGroupDTO> description = new TextColumn<ResolverGroupDTO>() {
	    @Override
	    public String getValue(ResolverGroupDTO definition) {

		return definition.getDescription();

	    }
	};

	Column<ResolverGroupDTO, String> deleteBtn = new Column<ResolverGroupDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(ResolverGroupDTO c) {

		return LocaleMessages.LANG.delete();

	    }

	};
	deleteBtn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	deleteBtn.setCellStyleNames("buttonBorrar");
	deleteBtn.setFieldUpdater(new FieldUpdater<ResolverGroupDTO, String>() {

	    @Override
	    public void update(int index, ResolverGroupDTO resolverGroupDTO, String value) {
		List<ResolverGroupDTO> list = dataProvider.getList();
		list.remove(resolverGroupDTO);
		dataProvider.setList(list);
		dataProvider.refresh();

	    }

	});

	// Add the columns.

	table.addColumn(id, LocaleMessages.LANG.id());
	table.addColumn(name, LocaleMessages.LANG.login());
	table.addColumn(description, LocaleMessages.LANG.name());

	table.addColumn(deleteBtn, " ");

	table.setColumnWidth(id, 120.0, Unit.PX);
	table.setColumnWidth(name, 120.0, Unit.PX);
	table.setColumnWidth(description, 200.0, Unit.PX);

	table.setColumnWidth(deleteBtn, 60.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    private void traerTodosLosPerfiles() {
	try {

	    profileService.getAllProfiles(new AsyncCallback<List<ProfileDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorGetProfiles()
			    + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(List<ProfileDTO> list) {
		    profileList = list;

		    lstPerfil.addItem(LocaleMessages.LANG.select(), "-1");

		    for (int i = 0; i <= profileList.size() - 1; i++) {
			lstPerfil.addItem(profileList.get(i).getName(),
				String.valueOf(profileList.get(i).getSegProfileId()));
		    }
		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorGetProfiles() + ex.toString());
	    dialog.center();
	    dialog.show();
	}

    }

    class BlurHandlerUser implements BlurHandler {

	@Override
	public void onBlur(BlurEvent arg0) {
	    final String usuario = txtUser.getText();

	    try {
		service.searchOperator(usuario, new AsyncCallback<OperatorDTO>() {

		    @Override
		    public void onFailure(Throwable ex) {
			if (ex.getMessage().contains("NO_EXISTE") == true) {
			    errorExistencia = false;
			} else {
			    errorExistencia = false;
			    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorGetUser()
				    + ex.toString());
			    dialog.center();
			    dialog.show();
			}
		    }

		    @Override
		    public void onSuccess(OperatorDTO op) {
			if (op.getUser().equals(usuario)) {
			    errorExistencia = true;
			    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.userExist());
			    dialog.center();
			    dialog.show();
			} else {
			    errorExistencia = false;
			}
		    }

		});
	    } catch (Exception e) {

		if (e.getMessage().contains("NO_EXISTE") == true) {
		    errorExistencia = false;
		} else {
		    InformationDialog dialog = new InformationDialog("Error :" + e.getLocalizedMessage());
		    dialog.center();
		    dialog.show();
		}

	    }
	}
    }

    /**
     * M�todo que consulta solo los grupos vigentes.
     */
    public void traerGruposVigentes() {

	resolverGroupService.getAllOK(new AsyncCallback<List<ResolverGroupDTO>>() {

	    @Override
	    public void onFailure(Throwable arg0) {

	    }

	    @Override
	    public void onSuccess(List<ResolverGroupDTO> list) {
		workGroupListLocal = list;

	    }
	});
    }
}
