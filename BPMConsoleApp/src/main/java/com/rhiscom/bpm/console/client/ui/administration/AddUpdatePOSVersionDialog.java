package com.rhiscom.bpm.console.client.ui.administration;

import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
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
import com.google.gwt.user.datepicker.client.DateBox;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.event.UpdateResolverGroupEvent;
import com.rhiscom.bpm.console.client.remote.QuadratureServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;
import com.rhiscom.bpm.console.shared.model.dto.VersionDTO;

public class AddUpdatePOSVersionDialog extends DialogBox {

    private static final Binder binder = GWT.create(Binder.class);
    ClientFactory clientFactory;
    public static final String viewCode = "madm_posversion";
    private static final DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");

    interface Binder extends UiBinder<Widget, AddUpdatePOSVersionDialog> {
    }

    private QuadratureServiceAsync quadratureService;

    private VersionDTO versionDTO = null;
    private List<VersionDTO> listVersionDTO = null;
    private List<BusinessUnitDTO> listBusinessUnitVigentes;

    @UiField
    TextBox txtDescription;
    @UiField(provided = true)
    ListBox lstBusinessUnit;
    @UiField(provided = true)
    Label lblError;
    @UiField
    Button btnGuardar;
    @UiField
    Button btnCancelar;
    @UiField(provided = true)
    DateBox initDate;
    @UiField(provided = true)
    DateBox endDate;

    public AddUpdatePOSVersionDialog(QuadratureServiceAsync quadratureService, List<VersionDTO> listadoVersiones,
	    ClientFactory clientFactory, List<BusinessUnitDTO> listBusinessUnitVigentes2) {
	this.listBusinessUnitVigentes = listBusinessUnitVigentes2;
	lblError = new Label();
	lblError.setVisible(false);
	lblError.setStyleName("lblError");

	initDate = new DateBox();
	initDate.setValue(new Date());
	initDate.setFormat(new DateBox.DefaultFormat(dtf));

	endDate = new DateBox();
	endDate.setValue(new Date());
	endDate.setFormat(new DateBox.DefaultFormat(dtf));

	lstBusinessUnit = new ListBox();
	lstBusinessUnit.addItem(LocaleMessages.LANG.select(), "-1");
	for (int i = 0; i <= this.listBusinessUnitVigentes.size() - 1; i++) {
	    lstBusinessUnit.addItem(listBusinessUnitVigentes.get(i).getNameBusinessUnit(),
		    String.valueOf(listBusinessUnitVigentes.get(i).getIdBusinessUnit()));
	}
	setWidget(binder.createAndBindUi(this));

	constructDialog(quadratureService, listadoVersiones, clientFactory);

    }

    public AddUpdatePOSVersionDialog(QuadratureServiceAsync quadratureService, VersionDTO versionDTO,
	    List<VersionDTO> listadoVersiones, ClientFactory clientFactory,
	    List<BusinessUnitDTO> listBusinessUnitVigentes2) {
	this.listBusinessUnitVigentes = listBusinessUnitVigentes2;
	this.versionDTO = versionDTO;
	lblError = new Label();
	lblError.setVisible(false);
	lblError.setStyleName("lblError");

	initDate = new DateBox();
	initDate.setValue(new Date());
	initDate.setFormat(new DateBox.DefaultFormat(dtf));

	endDate = new DateBox();
	endDate.setValue(new Date());
	endDate.setFormat(new DateBox.DefaultFormat(dtf));

	setWidget(binder.createAndBindUi(this));

	constructDialog(quadratureService, listadoVersiones, clientFactory);
	lblError.setVisible(false);

	txtDescription.setText(versionDTO.getDescription());
	lstBusinessUnit.getValue(lstBusinessUnit.getSelectedIndex());
	initDate.setValue(versionDTO.getInitDate());
	endDate.setValue(versionDTO.getEndDate());
	lblError = new Label();
	lblError.setVisible(false);
	lblError.setStyleName("lblError");
	lstBusinessUnit = new ListBox();
	lstBusinessUnit.addItem(LocaleMessages.LANG.select(), "-1");
	for (int i = 0; i <= this.listBusinessUnitVigentes.size() - 1; i++) {
	    lstBusinessUnit.addItem(listBusinessUnitVigentes.get(i).getNameBusinessUnit(),
		    String.valueOf(listBusinessUnitVigentes.get(i).getIdBusinessUnit()));
	}
    }

    private void constructDialog(QuadratureServiceAsync quadratureService, List<VersionDTO> listadoVersiones,
	    ClientFactory clientFactory2) {

	listVersionDTO = listadoVersiones;
	this.clientFactory = clientFactory2;
	this.quadratureService = quadratureService;

	setAnimationEnabled(false);
	setGlassEnabled(true);
	setText("Versi\u00F3nes de POS ");

    }

    @UiHandler("btnGuardar")
    void onClickGuardar(ClickEvent e) {
	boolean error = true;
	boolean errorExistencia = false;

	String name = txtDescription.getText();
	String server = lstBusinessUnit.getValue(lstBusinessUnit.getSelectedIndex());

	// Se agrega un nuevo objeto
	if (versionDTO == null) {

	    if (name.length() > 0) {
		error = false;

	    } else {
		lblError.setVisible(true);
		lblError.setText("La  versi\u00F3n debe tener un nombre");
	    }
	    if (listVersionDTO != null && listVersionDTO.size() > 0) {
		for (int i = 0; i <= listVersionDTO.size() - 1; i++) {

		    if (listVersionDTO.get(i).getServer().trim().equals(server.trim())) {
			if (listVersionDTO.get(i).getInitDate().before(initDate.getValue())) {
			    if (!listVersionDTO.get(i).getEndDate().before(initDate.getValue())) {
			errorExistencia = true;
			break;
			    }

			}
			if (listVersionDTO.get(i).getInitDate().after(initDate.getValue())) {
			    if (!listVersionDTO.get(i).getInitDate().after(endDate.getValue())) {
				errorExistencia = true;
				break;
		    }
			}
		}
		}
		if (errorExistencia) {
		    endDate.setStyleName("redBorderAlert", true);
		    initDate.setStyleName("redBorderAlert", true);
		    lblError.setVisible(true);
		    lblError.setText("El servidor ya cuenta con una versión de POS para algún día dentro del rango de fechas.");
		    errorExistencia = true;
		}
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
		lblError.setText("La  versi\u00F3n debe tener un nombre");
	    }

		if (listVersionDTO != null && listVersionDTO.size() > 0) {
		    for (int i = 0; i <= listVersionDTO.size() - 1; i++) {
			// Window.alert("NOMBRE 2 :" +
			// listResolverGroupDTO.get(i).getName());
		    if (listVersionDTO.get(i).getServer().trim().equals(server.trim())) {
			if (listVersionDTO.get(i).getInitDate().before(initDate.getValue())) {
			    if (!listVersionDTO.get(i).getEndDate().before(initDate.getValue())) {
			    errorExistencia = true;
			    break;
			    }

			}
			if (listVersionDTO.get(i).getInitDate().after(initDate.getValue())) {
			    if (!listVersionDTO.get(i).getInitDate().after(endDate.getValue())) {
				errorExistencia = true;
				break;
			}
			}
		    }
		    if (errorExistencia) {
			endDate.setStyleName("redBorderAlert", true);
			initDate.setStyleName("redBorderAlert", true);
			lblError.setVisible(true);
			lblError.setText("El servidor ya cuenta con una versión de POS para algún día dentro del rango de fechas.");
			errorExistencia = true;
			break;
		}
	    }
	    }
	    if (!error && errorExistencia) {
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
	    VersionDTO versionDTO = new VersionDTO();
	    versionDTO.setDescription(txtDescription.getValue());
	    versionDTO.setServer(lstBusinessUnit.getValue(lstBusinessUnit.getSelectedIndex()));
	    versionDTO.setInitDate(initDate.getValue());
	    versionDTO.setEndDate(endDate.getValue());

	    quadratureService.addNewVersion(versionDTO, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {
		    clientFactory.getEventBus().fireEvent(new UpdateResolverGroupEvent());

		    not.show(5000, "Versi\u00F3n creada exitosamente", Notification.OK);

		}

	    });
	} catch (Exception ex) {

	}
    }

    /**
     * M�todo que permite la edici�n de un Grupo.
     */
    private void editarGrupo() {
	final Notification not = new Notification(true, true);
	try {
	    // Window.alert("DTO ID :" + resolverGroupDTO.getWorkGroupid());
	    VersionDTO versionDTO = new VersionDTO();
	    versionDTO.setDescription(txtDescription.getValue());
	    versionDTO.setServer(lstBusinessUnit.getValue(lstBusinessUnit.getSelectedIndex()));
	    versionDTO.setInitDate(initDate.getValue());
	    versionDTO.setEndDate(endDate.getValue());
	    versionDTO.setId(this.versionDTO.getId());

	    quadratureService.updateVersion(versionDTO, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object result) {
		    clientFactory.getEventBus().fireEvent(new UpdateResolverGroupEvent());
		    not.show(5000, "Versi\u00F3n editada exitosamente", Notification.OK);

		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

}
