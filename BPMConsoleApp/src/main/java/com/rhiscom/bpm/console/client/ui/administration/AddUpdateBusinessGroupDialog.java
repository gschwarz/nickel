package com.rhiscom.bpm.console.client.ui.administration;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.event.UpdateBusinessGroupEvent;
import com.rhiscom.bpm.console.client.remote.RetailDomainServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public class AddUpdateBusinessGroupDialog extends DialogBox {
    ClientFactory clientFactory;
    private RetailDomainServiceAsync retailDomainServiceLocal;
    private List<BusinessGroupDTO> listBusinessGroupDTO = new ArrayList<BusinessGroupDTO>();
    private List<BusinessGroupDTO> listadoVigentes = new ArrayList<BusinessGroupDTO>();
    private static final Binder binder = GWT.create(Binder.class);
    private BusinessGroupDTO businessGroupDTOLocal = null;
    public static final String viewCode = "madm_fnbng";

    interface Binder extends UiBinder<Widget, AddUpdateBusinessGroupDialog> {
    }

    @UiField(provided = true)
    TextBox txtName;

    @UiField(provided = true)
    Label lblError;
    @UiField
    Button btnGuardar;

    @UiField
    Button btnCancelar;

    @UiField(provided = true)
    ListBox listadoNiveles;

    @UiField(provided = true)
    ListBox listadoEstadoListBox;

    @UiField(provided = true)
    HorizontalPanel parentPanel;
    @UiField(provided = true)
    ListBox listadoBusinessGroup;

    private List<AbilityDTO> abilityList;

    /**
     * Constructor para edici�n
     * 
     * @param retailDomainService
     * @param businessGroupDTOLocal
     * @param clientFactory
     */
    public AddUpdateBusinessGroupDialog(RetailDomainServiceAsync retailDomainService, List<BusinessGroupDTO> listado,
	    BusinessGroupDTO businessGroupDTO, ClientFactory clientFactory) {

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	listadoVigentes = listado;
	constructDialog(retailDomainService, clientFactory);

	this.businessGroupDTOLocal = businessGroupDTO;

	txtName.setText(businessGroupDTO.getNameBusinessGroup());

	if (businessGroupDTOLocal != null) {

	    if (businessGroupDTOLocal.getStatus() == 1) {

		listadoEstadoListBox.setItemSelected(0, true);
	    } else {
		listadoEstadoListBox.setItemSelected(1, true);
	    }

	    if (businessGroupDTOLocal.getIdLevelBusinessGroup() == 1) {
		listadoNiveles.setItemSelected(0, true);
		listadoNiveles.setEnabled(false);
	    } else {
		listadoNiveles.setItemSelected(1, true);
		parentPanel.setVisible(true);
		if (businessGroupDTOLocal.getParentBusinessGroup() != null) {

		    int count = listadoBusinessGroup.getItemCount();

		    for (int i = 0; i <= count - 1; i++) {
			String value = listadoBusinessGroup.getValue(i);
			if (Integer.valueOf(value).intValue() == businessGroupDTOLocal.getParentBusinessGroup()
				.getIdBusinessGroup()) {
			    listadoBusinessGroup.setSelectedIndex(i);
			    break;
			}

		    }

		} else {
		    listadoBusinessGroup.setSelectedIndex(0);
		}

	    }
	}

	setWidget(binder.createAndBindUi(this));
	if (!PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnGuardar")) {

	    btnGuardar.setEnabled(false);
	}
    }

    /**
     * Constructor para agregaci�n.
     * 
     * @param retailDomainService
     * @param clientFactory
     */
    public AddUpdateBusinessGroupDialog(RetailDomainServiceAsync retailDomainService, List<BusinessGroupDTO> listado,
	    ClientFactory clientFactory) {
	listadoVigentes = listado;
	constructDialog(retailDomainService, clientFactory);
	setWidget(binder.createAndBindUi(this));
    }

    private void constructDialog(RetailDomainServiceAsync retailDomainService, ClientFactory clientFactory2) {
	parentPanel = new HorizontalPanel();
	parentPanel.setVisible(false);
	this.clientFactory = clientFactory2;
	this.retailDomainServiceLocal = retailDomainService;
	lblError = new Label();
	lblError.setVisible(false);
	lblError.setStyleName("lblError");
	listadoNiveles = new ListBox();
	listadoEstadoListBox = new ListBox();
	txtName = new TextBox();

	listadoBusinessGroup = new ListBox();
	listadoBusinessGroup.addItem(LocaleMessages.LANG.select(), "0");

	for (int i = 0; i <= listadoVigentes.size() - 1; i++) {
	    listadoBusinessGroup.addItem(listadoVigentes.get(i).getNameBusinessGroup(),
		    String.valueOf(listadoVigentes.get(i).getIdBusinessGroup()));

	}

	setAnimationEnabled(false);
	setGlassEnabled(true);
	setText(LocaleMessages.LANG.businessGroupTitle());
	listadoEstadoListBox.addItem(LocaleMessages.LANG.valid(), "1");
	listadoEstadoListBox.addItem(LocaleMessages.LANG.notValid(), "0");
	listadoNiveles.addItem(LocaleMessages.LANG.level1(), "1");
	listadoNiveles.addItem(LocaleMessages.LANG.level2(), "2");

	listadoEstadoListBox.setVisibleItemCount(1);
	listadoNiveles.setVisibleItemCount(1);

	listadoNiveles.addChangeHandler(new ChangeHandler() {
	    public void onChange(ChangeEvent event) {
		int selectedIndex = listadoNiveles.getSelectedIndex();

		String level = listadoNiveles.getValue(selectedIndex);

		if (level.equals("2")) {

		    parentPanel.setVisible(true);

		}
		if (level.equals("1")) {

		    parentPanel.setVisible(false);

		}

	    }

	});

    }

    @UiHandler("btnGuardar")
    void onClickGuardar(ClickEvent e) {
	boolean error = true;
	boolean errorNombre = true;
	boolean errorNivel = true;
	boolean errorExistencia = true;
	boolean errorSegundoNivel = true;
	long idParent = Long.valueOf(listadoBusinessGroup.getValue(this.listadoBusinessGroup.getSelectedIndex()));
	long level = Long.valueOf(listadoNiveles.getValue(this.listadoNiveles.getSelectedIndex()));
	String name = this.txtName.getText();

	// Se agrega un nuevo objeto

	if (name.trim().length() > 2 && name.trim().length() <= 15) {
	    error = false;
	    errorNombre = false;

	} else {
	    lblError.setVisible(true);
	    lblError.setText(LocaleMessages.LANG.groupMustHaveaName());
	    this.txtName.setStyleName("redBorderAlert", true);
	}

	if (errorNombre == false) {

	    if (idParent != 0) {

		BusinessGroupDTO businessGroupDTOParent = null;
		for (int i = 0; i <= listadoVigentes.size(); i++) {

		    if (idParent == listadoVigentes.get(i).getIdBusinessGroup()) {

			businessGroupDTOParent = listadoVigentes.get(i);
			break;

		    }

		}
		if (businessGroupDTOParent.getIdLevelBusinessGroup() == 2) {
		    listadoBusinessGroup.setStyleName("redBorderAlert", true);
		    lblError.setVisible(true);
		    lblError.setText(LocaleMessages.LANG.unitParentError());

		} else {
		    errorSegundoNivel = false;

		}
	    } else {
		errorSegundoNivel = false;
	    }
	}

	if (errorSegundoNivel == false) {

	    if (level == 2 && idParent == 0) {
		lblError.setVisible(true);

		lblError.setText(LocaleMessages.LANG.unitAsociateParentError());
	    } else {
		error = false;
		errorNivel = false;

	    }

	}
	if (errorNivel == false) {
	    if (listBusinessGroupDTO.size() > 0) {
		for (int i = 0; i <= listBusinessGroupDTO.size() - 1; i++) {

		    if (listBusinessGroupDTO.get(i).getNameBusinessGroup().trim().equals(name.trim())
			    || listBusinessGroupDTO.get(i).getNameBusinessGroup().compareToIgnoreCase(name.trim()) == 0) {
			txtName.setStyleName("redBorderAlert", true);
			lblError.setVisible(true);
			lblError.setText(LocaleMessages.LANG.unitGroupExist());
			errorExistencia = true;
			break;

		    } else {
			error = false;
			errorExistencia = false;
		    }

		}
	    } else {
		error = false;
		errorExistencia = false;
	    }
	}

	if (businessGroupDTOLocal == null) {

	    if (!error && !errorExistencia && !errorSegundoNivel) {
		agregarNuevaUnidadDeNegocio();
		lblError.setVisible(false);
		this.hide();
	    }
	    // Se edita objeto existente.
	}

	else {

	    if (!error && !errorExistencia && !errorSegundoNivel) {
		editarGrupo();
		lblError.setVisible(false);
		this.hide();
	    }
	}

    }

    @UiHandler("btnCancelar")
    void onClickCancelar(ClickEvent e) {

	this.hide();

    }

    private void agregarNuevaUnidadDeNegocio() {
	final Notification not = new Notification(true, true);
	try {

	    BusinessGroupDTO businessGroupDTO = new BusinessGroupDTO();
	    BusinessGroupDTO businessGroupDTOParent = new BusinessGroupDTO();

	    businessGroupDTO.setNameBusinessGroup(this.txtName.getText());

	    businessGroupDTO.setStatus(Integer.valueOf(listadoEstadoListBox.getValue(this.listadoEstadoListBox
		    .getSelectedIndex())));
	    businessGroupDTO.setIdLevelBusinessGroup(Long.valueOf(listadoNiveles.getValue(this.listadoNiveles
		    .getSelectedIndex())));

	    String idParent = listadoBusinessGroup.getValue(this.listadoBusinessGroup.getSelectedIndex());

	    if (idParent.compareTo("0") != 0) {

		for (int i = 0; i <= listadoVigentes.size(); i++) {

		    if (idParent.equals(String.valueOf(listadoVigentes.get(i).getIdBusinessGroup()))) {

			businessGroupDTOParent = listadoVigentes.get(i);
			break;

		    }

		}

		businessGroupDTO.setParentBusinessGroup(businessGroupDTOParent);

	    } else {
		businessGroupDTO.setParentBusinessGroup(null);
	    }

	    retailDomainServiceLocal.addBusinessGroup(businessGroupDTO, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {

		    clientFactory.getEventBus().fireEvent(new UpdateBusinessGroupEvent());
		    not.show(5000, LocaleMessages.LANG.unitGroupAddOk(), Notification.OK);

		}

	    });

	} catch (Exception ex) {
	}
    }

    /**
     * M�todo que permite la edici�n del grupo.
     */
    private void editarGrupo() {
	final Notification not = new Notification(true, true);
	try {

	    BusinessGroupDTO businessGroupDTOEdit = new BusinessGroupDTO();
	    BusinessGroupDTO businessGroupDTOParent = new BusinessGroupDTO();
	    String idParent = listadoBusinessGroup.getValue(this.listadoBusinessGroup.getSelectedIndex());

	    for (int i = 0; i <= listadoVigentes.size(); i++) {

		if (idParent.equals(String.valueOf(listadoVigentes.get(i).getIdBusinessGroup()))) {

		    businessGroupDTOParent = listadoVigentes.get(i);
		    break;

		}

	    }

	    businessGroupDTOEdit.setParentBusinessGroup(businessGroupDTOParent);

	    businessGroupDTOEdit.setIdBusinessGroup(new Long(businessGroupDTOLocal.getIdBusinessGroup()));
	    businessGroupDTOEdit.setNameBusinessGroup(this.txtName.getText());

	    businessGroupDTOEdit.setStatus(Integer.valueOf(listadoEstadoListBox.getValue(this.listadoEstadoListBox
		    .getSelectedIndex())));
	    businessGroupDTOEdit.setIdLevelBusinessGroup(Long.valueOf(listadoNiveles.getValue(this.listadoNiveles
		    .getSelectedIndex())));
	    if (businessGroupDTOEdit.getIdLevelBusinessGroup() == 1) {
		businessGroupDTOEdit.setParentBusinessGroup(null);
	    } else {
		businessGroupDTOEdit.setParentBusinessGroup(businessGroupDTOParent);
	    }

	    retailDomainServiceLocal.updateBusinessGroup(businessGroupDTOEdit, new AsyncCallback<BusinessGroupDTO>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(BusinessGroupDTO arg0) {

		    clientFactory.getEventBus().fireEvent(new UpdateBusinessGroupEvent());
		    not.show(5000, LocaleMessages.LANG.unitGroupEditOK(), Notification.OK);

		}

	    });

	} catch (Exception ex) {
	}

    }
}
