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
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.event.UpdateResolverGroupEvent;
import com.rhiscom.bpm.console.client.remote.ResolverGroupsServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;

public class AddUpdateResolverGroupsDialog extends DialogBox {

    private static final Binder binder = GWT.create(Binder.class);
    ClientFactory clientFactory;
    public static final String viewCode = "madm_fnwkg";

    interface Binder extends UiBinder<Widget, AddUpdateResolverGroupsDialog> {
    }

    private ResolverGroupsServiceAsync resolverGroupsService;
    private List<ResolverGroupDTO> listResolverGroupDTO = new ArrayList<ResolverGroupDTO>();

    private ResolverGroupDTO resolverGroupDTO = null;
    private List<AbilityDTO> abilityList;

    @UiField(provided = true)
    TextBox txtName;
    @UiField(provided = true)
    TextArea txtDescription;
    @UiField(provided = true)
    Label lblError;
    @UiField
    Button btnGuardar;
    @UiField
    Button btnCancelar;

    public AddUpdateResolverGroupsDialog(ResolverGroupsServiceAsync resolverGroupService, ClientFactory clientFactory) {

	constructDialog(resolverGroupService, clientFactory);

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);

	setWidget(binder.createAndBindUi(this));

	if (!PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "eliminarBtn")) {
	    btnGuardar.setEnabled(false);
	}

    }

    public AddUpdateResolverGroupsDialog(ResolverGroupsServiceAsync resolverGroupService, ResolverGroupDTO object,
	    ClientFactory clientFactory) {
	resolverGroupDTO = object;
	constructDialog(resolverGroupService, clientFactory);
	txtName.setText(object.getName());
	txtDescription.setText(object.getDescription());

	setWidget(binder.createAndBindUi(this));
    }

    private void constructDialog(ResolverGroupsServiceAsync resolverGroupService, ClientFactory clientFactory2) {
	this.clientFactory = clientFactory2;
	this.resolverGroupsService = resolverGroupService;
	lblError = new Label();
	lblError.setVisible(false);
	lblError.setStyleName("lblError");

	txtName = new TextBox();
	txtDescription = new TextArea();
	txtDescription.setCharacterWidth(15);
	txtDescription.setVisibleLines(6);
	setAnimationEnabled(false);
	setGlassEnabled(true);
	setText(LocaleMessages.LANG.groupEditTitle());

    }

    @UiHandler("btnGuardar")
    void onClickGuardar(ClickEvent e) {
	boolean error = true;
	boolean errorExistencia = true;

	String name = this.txtName.getText();

	// Se agrega un nuevo objeto
	if (resolverGroupDTO == null) {

	    if (name.length() > 0) {
		error = false;

	    } else {
		lblError.setVisible(true);
		lblError.setText(LocaleMessages.LANG.groupMustHaveaName());
	    }
	    if (listResolverGroupDTO.size() > 0) {
		for (int i = 0; i <= listResolverGroupDTO.size() - 1; i++) {

		    if (listResolverGroupDTO.get(i).getName().trim().equals(name.trim())
			    || listResolverGroupDTO.get(i).getName().trim().compareToIgnoreCase(name.trim()) == 0) {
			txtName.setStyleName("redBorderAlert", true);
			lblError.setVisible(true);
			lblError.setText(LocaleMessages.LANG.groupAlreadyExists());
			errorExistencia = true;
			break;

		    } else {
			errorExistencia = false;
		    }

		}
	    } else {
		errorExistencia = false;
	    }

	    if (!error && !errorExistencia) {
		agregarNuevoGrupo();
		lblError.setVisible(false);
		this.hide();
	    }
	    // Se edita objeto existente.
	} else {

	    if (name.length() > 0) {
		error = false;

	    } else {
		lblError.setVisible(true);
		lblError.setText(LocaleMessages.LANG.groupMustHaveaName());
	    }

	    if (!resolverGroupDTO.getName().equals(name)) {
		if (listResolverGroupDTO.size() > 0) {
		    for (int i = 0; i <= listResolverGroupDTO.size() - 1; i++) {
			// Window.alert("NOMBRE 2 :" +
			// listResolverGroupDTO.get(i).getName());

			if (listResolverGroupDTO.get(i).getName().trim().equals(name.trim())) {
			    txtName.setStyleName("redBorderAlert", true);
			    lblError.setVisible(true);
			    lblError.setText(LocaleMessages.LANG.groupAlreadyExists());
			    errorExistencia = true;
			    break;

			} else {
			    errorExistencia = false;
			}

		    }
		} else {
		    errorExistencia = false;
		}
	    } else {
		errorExistencia = false;
	    }

	    if (!error && !errorExistencia) {
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

    /**
     * Metodo que permite la agregacion de un nuevo grupo.
     */
    private void agregarNuevoGrupo() {
	final Notification not = new Notification(true, true);
	try {
	    ResolverGroupDTO resolverGroupDTO = new ResolverGroupDTO();
	    resolverGroupDTO.setName(this.txtName.getText());
	    resolverGroupDTO.setDescription(this.txtDescription.getText());

	    resolverGroupsService.addResolutionGroup(resolverGroupDTO, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {
		    clientFactory.getEventBus().fireEvent(new UpdateResolverGroupEvent());
		    not.show(5000, LocaleMessages.LANG.workGroupCreateOK(), Notification.OK);

		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

    /**
     * M�todo que permite la edici�n de un Grupo.
     */
    private void editarGrupo() {
	final Notification not = new Notification(true, true);
	try {
	    // Window.alert("DTO ID :" + resolverGroupDTO.getWorkGroupid());
	    ResolverGroupDTO resolverGroupDTOEdit = new ResolverGroupDTO();
	    resolverGroupDTOEdit.setWorkGroupid(new Long(resolverGroupDTO.getWorkGroupid()));
	    resolverGroupDTOEdit.setName(this.txtName.getText());
	    resolverGroupDTOEdit.setDescription(this.txtDescription.getText());

	    resolverGroupsService.update(resolverGroupDTOEdit, new AsyncCallback<ResolverGroupDTO>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(ResolverGroupDTO arg0) {

		    clientFactory.getEventBus().fireEvent(new UpdateResolverGroupEvent());
		    not.show(5000, LocaleMessages.LANG.workGroupEditOK(), Notification.OK);

		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

}
