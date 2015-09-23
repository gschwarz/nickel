package com.rhiscom.bpm.console.client.ui.administration;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.event.UpdateBusinessUnitEvent;
import com.rhiscom.bpm.console.client.remote.RetailDomainServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public class AddUpdateBusinessUnitDialog extends DialogBox {
    public static final String viewCode = "madm_fnbunit";
    private static final Binder binder = GWT.create(Binder.class);
    ClientFactory clientFactory;
    private RetailDomainServiceAsync retailDomainServiceLocal;
    private List<BusinessGroupDTO> listBusinessGroupDTO = new ArrayList<BusinessGroupDTO>();
    private List<BusinessUnitDTO> listBusinessUnit = new ArrayList<BusinessUnitDTO>();
    private List<BusinessGroupDTO> listadoBusinessGroupVigentes = new ArrayList<BusinessGroupDTO>();
    private BusinessUnitDTO businessUnitDTOLocal = null;

    interface Binder extends UiBinder<Widget, AddUpdateBusinessUnitDialog> {
    }

    @UiField(provided = true)
    TextBox txtName;

    @UiField(provided = true)
    TextBox txtCode;

    @UiField(provided = true)
    Label lblError;
    @UiField
    Button btnGuardar;

    @UiField
    Button btnCancelar;

    @UiField(provided = true)
    ListBox listadoEstadoListBox;

    @UiField(provided = true)
    ListBox listadoBusinessGroup;

    private List<AbilityDTO> abilityList;

    public AddUpdateBusinessUnitDialog(RetailDomainServiceAsync retailDomainService, List<BusinessGroupDTO> listado,
	    List<BusinessUnitDTO> listBusinessUnit2, ClientFactory clientFactory) {
	listadoBusinessGroupVigentes = listado;
	listBusinessUnit = listBusinessUnit2;
	constructDialog(retailDomainService, clientFactory);

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	if (!PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnGuardar")) {

	    btnGuardar.setEnabled(false);
	}

	setWidget(binder.createAndBindUi(this));
    }

    public AddUpdateBusinessUnitDialog(RetailDomainServiceAsync retailDomainService, List<BusinessGroupDTO> listado,
	    List<BusinessUnitDTO> listBusinessUnit2, BusinessUnitDTO businessUnit, ClientFactory clientFactory) {
	listadoBusinessGroupVigentes = listado;
	businessUnitDTOLocal = businessUnit;
	listBusinessUnit = listBusinessUnit2;
	constructDialog(retailDomainService, clientFactory);

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	if (!PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnGuardar")) {

	    btnGuardar.setEnabled(false);
	}

	setWidget(binder.createAndBindUi(this));

	txtName.setText(businessUnitDTOLocal.getNameBusinessUnit());
	txtCode.setText(businessUnitDTOLocal.getCode());

	if (businessUnitDTOLocal != null) {

	    if (businessUnitDTOLocal.getStatus() == 1) {

		listadoEstadoListBox.setItemSelected(0, true);
	    } else {
		listadoEstadoListBox.setItemSelected(1, true);
	    }

	    if (businessUnitDTOLocal.getIdBusinessGroup() != 0) {

		int count = listadoBusinessGroup.getItemCount();

		for (int i = 0; i <= count - 1; i++) {
		    String value = listadoBusinessGroup.getValue(i);
		    if (Integer.valueOf(value).intValue() == businessUnitDTOLocal.getIdBusinessGroup()) {
			listadoBusinessGroup.setSelectedIndex(i);
			break;
		    }

		}

	    } else {
		listadoBusinessGroup.setSelectedIndex(0);
	    }

	}

    }

    private void constructDialog(RetailDomainServiceAsync retailDomainService, ClientFactory clientFactory2) {

	this.clientFactory = clientFactory2;
	this.retailDomainServiceLocal = retailDomainService;
	lblError = new Label();
	lblError.setVisible(false);
	lblError.setStyleName("lblError");

	listadoEstadoListBox = new ListBox();

	txtName = new TextBox();
	txtCode = new TextBox();

	listadoBusinessGroup = new ListBox();
	listadoBusinessGroup.addItem(LocaleMessages.LANG.select(), "0");

	for (int i = 0; i <= listadoBusinessGroupVigentes.size() - 1; i++) {

	    listadoBusinessGroup.addItem(listadoBusinessGroupVigentes.get(i).getNameBusinessGroup(),
		    String.valueOf(listadoBusinessGroupVigentes.get(i).getIdBusinessGroup()));

	}

	setAnimationEnabled(false);
	setGlassEnabled(true);
	setText(LocaleMessages.LANG.businessUnitEdition());
	listadoEstadoListBox.addItem(LocaleMessages.LANG.valid(), "1");
	listadoEstadoListBox.addItem(LocaleMessages.LANG.notValid(), "0");
	listadoEstadoListBox.setVisibleItemCount(1);

    }

    @UiHandler("btnGuardar")
    void onClickGuardar(ClickEvent e) {
	boolean error = true;
	boolean errorNombre = true;
	boolean errorCodigo = true;
	boolean errorExistencia = true;
	boolean errorExistenciaCodigo = true;
	boolean errorIdParent = true;
	long idParent = Long.valueOf(listadoBusinessGroup.getValue(this.listadoBusinessGroup.getSelectedIndex()));

	String name = this.txtName.getText();
	String code = this.txtCode.getText();

	if (businessUnitDTOLocal == null) {
	    if (name.trim().length() > 2 && name.trim().length() <= 15) {
		error = false;
		errorNombre = false;

	    } else {
		lblError.setVisible(true);
		lblError.setText(LocaleMessages.LANG.businessUnitMutBeAName());
		this.txtName.setStyleName("redBorderAlert", true);
		this.txtCode.removeStyleName("redBorderAlert");
	    }

	    if (errorNombre == false) {

		if (idParent == 0) {
		    lblError.setVisible(true);
		    lblError.setText("Debe seleccionar grupo de negocio asociado");
		    listadoBusinessGroup.setStyleName("redBorderAlert", true);
		    this.txtName.removeStyleName("redBorderAlert");
		    this.txtCode.removeStyleName("redBorderAlert");
		} else {
		    error = false;
		    errorIdParent = false;
		}
	    }
	    if (errorIdParent == false) {
		if (code.length() > 0) {
		    error = false;
		    errorCodigo = false;

		} else {
		    lblError.setVisible(true);
		    lblError.setText(LocaleMessages.LANG.businessUnitMustBeACode());
		    this.txtCode.setStyleName("redBorderAlert", true);
		    this.txtName.removeStyleName("redBorderAlert");
		    listadoBusinessGroup.removeStyleName("redBorderAlert");
		}
	    }
	    if (errorCodigo == false) {
		if (listBusinessUnit.size() > 0) {
		    for (int i = 0; i <= listBusinessUnit.size() - 1; i++) {

			if (listBusinessUnit.get(i).getNameBusinessUnit().trim().equals(name.trim())
				|| listBusinessUnit.get(i).getNameBusinessUnit().compareToIgnoreCase(name.trim()) == 0) {
			    txtName.setStyleName("redBorderAlert", true);
			    lblError.setVisible(true);
			    lblError.setText(LocaleMessages.LANG.businessUnitAlreadyExist());
			    errorExistencia = true;
			    break;

			} else {
			    error = false;
			    errorExistencia = false;
			    errorExistenciaCodigo = false;
			}

		    }
		} else {
		    error = false;
		    errorExistencia = false;
		    errorExistenciaCodigo = false;
		}
	    }
	    if (errorExistenciaCodigo == false) {
		if (listBusinessUnit.size() > 0) {
		    for (int i = 0; i <= listBusinessUnit.size() - 1; i++) {

			if (listBusinessUnit.get(i).getCode().trim().equals(code.trim())
				|| listBusinessUnit.get(i).getCode().compareToIgnoreCase(code.trim()) == 0) {
			    txtCode.setStyleName("redBorderAlert", true);
			    lblError.setVisible(true);
			    lblError.setText("El c\u00F3digo ya existe");
			    errorExistenciaCodigo = true;
			    break;

			} else {
			    error = false;
			    errorExistencia = false;
			    errorExistenciaCodigo = false;
			}

		    }
		} else {
		    error = false;
		    errorExistenciaCodigo = false;
		}
	    }
	    if (errorNombre == false && errorCodigo == false && errorExistencia == false
		    && errorExistenciaCodigo == false && errorIdParent == false) {
		agregarNuevaUnidadDeNegocio();
		this.hide();
	    }
	} else {
	    if (name.length() > 0) {
		error = false;
		errorNombre = false;

	    } else {
		lblError.setVisible(true);
		lblError.setText(LocaleMessages.LANG.businessUnitMutBeAName());
	    }
	    if (errorNombre == false) {
		if (idParent == 0) {
		    lblError.setVisible(true);
		    lblError.setText("Debe seleccionar grupo de negocio asociado");
		    listadoBusinessGroup.setStyleName("redBorderAlert", true);
		} else {
		    error = false;
		    errorIdParent = false;
		}
	    }
	    if (errorIdParent == false) {
		if (code.length() > 0) {
		    error = false;
		    errorCodigo = false;

		} else {
		    lblError.setVisible(true);
		    lblError.setText(LocaleMessages.LANG.businessUnitMustBeACode());
		}
	    }

	    if (businessUnitDTOLocal.getNameBusinessUnit().compareToIgnoreCase(name.trim()) != 0) {
		if (errorCodigo == false) {
		    if (listBusinessUnit.size() > 0) {
			for (int i = 0; i <= listBusinessUnit.size() - 1; i++) {

			    if (listBusinessUnit.get(i).getNameBusinessUnit().trim().equals(name.trim())
				    || listBusinessUnit.get(i).getNameBusinessUnit().compareToIgnoreCase(name.trim()) == 0) {
				txtName.setStyleName("redBorderAlert", true);
				lblError.setVisible(true);
				lblError.setText(LocaleMessages.LANG.businessUnitAlreadyExist());
				errorExistencia = true;
				break;

			    } else {
				error = false;
				errorExistencia = false;
				errorExistenciaCodigo = false;
			    }

			}
		    }
		}
	    } else {
		error = false;
		errorExistencia = false;
		errorExistenciaCodigo = false;

	    }
	    if (businessUnitDTOLocal.getCode().compareToIgnoreCase(code.trim()) != 0) {
		if (errorExistenciaCodigo == false) {
		    if (listBusinessUnit.size() > 0) {
			for (int i = 0; i <= listBusinessUnit.size() - 1; i++) {

			    if (listBusinessUnit.get(i).getCode().trim().equals(code.trim())
				    || listBusinessUnit.get(i).getCode().compareToIgnoreCase(code.trim()) == 0) {
				txtCode.setStyleName("redBorderAlert", true);
				lblError.setVisible(true);
				lblError.setText("El c\u00F3digo ya existe");
				errorExistenciaCodigo = true;
				break;

			    } else {
				error = false;

				errorExistenciaCodigo = false;
			    }

			}
		    } else {
			error = false;
			errorExistenciaCodigo = false;
		    }
		}
	    } else {
		error = false;

	    }
	    if (errorNombre == false && errorCodigo == false && errorExistencia == false
		    && errorExistenciaCodigo == false && errorIdParent == false) {
		editarUnidadDeNegocio();

		this.hide();
	    }
	}

    }

    @UiHandler("btnCancelar")
    void onClickCerrar(ClickEvent e) {
	this.hide();

    }

    private void agregarNuevaUnidadDeNegocio() {
	final Notification not = new Notification(true, true);
	try {

	    BusinessUnitDTO businessUnitDTO = new BusinessUnitDTO();
	    businessUnitDTO.setNameBusinessUnit(this.txtName.getText());
	    businessUnitDTO.setCode(this.txtCode.getText());
	    businessUnitDTO.setStatus(Integer.valueOf(listadoEstadoListBox.getValue(this.listadoEstadoListBox
		    .getSelectedIndex())));
	    String idParent = listadoBusinessGroup.getValue(this.listadoBusinessGroup.getSelectedIndex());
	    if (idParent.compareTo("-1") == 0) {
		businessUnitDTO.setIdBusinessGroup(new Long(0));
	    } else {
		businessUnitDTO.setIdBusinessGroup(new Long(idParent));
	    }

	    retailDomainServiceLocal.addBusinessUnit(businessUnitDTO, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {

		    clientFactory.getEventBus().fireEvent(new UpdateBusinessUnitEvent());
		    not.show(5000, LocaleMessages.LANG.businessUnitCreateOK(), Notification.OK);

		}

	    });

	} catch (Exception ex) {
	}
    }

    /**
     * Método que permite la edición del grupo.
     */
    private void editarUnidadDeNegocio() {
	final Notification not = new Notification(true, true);
	try {

	    BusinessUnitDTO businessUnitDTOEdit = new BusinessUnitDTO();
	    businessUnitDTOEdit.setNameBusinessUnit(this.txtName.getText());
	    businessUnitDTOEdit.setCode(this.txtCode.getText());

	    businessUnitDTOEdit.setStatus(Integer.valueOf(listadoEstadoListBox.getValue(this.listadoEstadoListBox
		    .getSelectedIndex())));
	    String idParent = listadoBusinessGroup.getValue(this.listadoBusinessGroup.getSelectedIndex());

	    businessUnitDTOEdit.setIdBusinessGroup(new Long(idParent));
	    businessUnitDTOEdit.setCreateStamp(businessUnitDTOLocal.getCreateStamp());
	    businessUnitDTOEdit.setIdBusinessUnit(businessUnitDTOLocal.getIdBusinessUnit());

	    retailDomainServiceLocal.updateBusinessUnit(businessUnitDTOEdit, new AsyncCallback<BusinessUnitDTO>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(BusinessUnitDTO arg0) {

		    clientFactory.getEventBus().fireEvent(new UpdateBusinessUnitEvent());
		    not.show(5000, LocaleMessages.LANG.businessUnitEditOK(), Notification.OK);

		}

	    });

	} catch (Exception ex) {
	}

    }
}
