package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.remote.EmailConfigurationService;
import com.rhiscom.bpm.console.client.remote.EmailConfigurationServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO;

public class EmailConfigurationViewImpl extends Composite implements EmailConfigurationView {

    private static final Binder binder = GWT.create(Binder.class);
    @UiField
    PasswordTextBox password;
    @UiField
    TextBox emailServer;
    @UiField
    TextBox emailPort;
    @UiField
    TextBox emailSender;
    @UiField
    Label lblErrorServer;
    @UiField
    Button btnGuardar;
  
    private EmailConfigurationDTO configuration = null;
    final EmailConfigurationServiceAsync emailService = GWT.create(EmailConfigurationService.class);

    interface Binder extends UiBinder<Widget, EmailConfigurationViewImpl> {
    }

    public EmailConfigurationViewImpl() {
	initWidget(binder.createAndBindUi(this));
	lblErrorServer.setVisible(false);
	
	traerConfiguracion();

	
    }

    @UiHandler("btnGuardar")
    void onClickGuardar(ClickEvent e) {
	boolean errorEmail = true;
	boolean errorPassword = true;
	boolean errorServer = true;
	boolean errorPort = true;

	final Notification not = new Notification(true, true);
	EmailConfigurationDTO dto = new EmailConfigurationDTO();
	if (configuration == null) {
	    configuration = new EmailConfigurationDTO();
	}

	String email = emailSender.getText();
	String passwordStr = String.valueOf(password.getValue());
	String server = emailServer.getText();
	String port = emailPort.getText();

	if (email.trim().length() == 0) {
	    lblErrorServer.setVisible(true);
	    lblErrorServer.setText("Debe ingresar correo remitente");
	} else {
	    errorEmail = false;
	    lblErrorServer.setVisible(false);
	}

	if (errorEmail == false) {

	    if (passwordStr.trim().length() == 0) {
		lblErrorServer.setVisible(true);
		lblErrorServer.setText("Debe ingresar password");
	    } else {
		errorPassword = false;
		lblErrorServer.setVisible(false);
	    }

	}

	if (errorPassword == false) {
	    if (server.trim().length() == 0) {
		lblErrorServer.setVisible(true);
		lblErrorServer.setText("Debe ingresar servidor de salida");
	    } else {
		errorServer = false;
		lblErrorServer.setVisible(false);
	    }
	}
	if (errorServer == false) {
	    if (port.trim().length() == 0) {
		lblErrorServer.setVisible(true);
		lblErrorServer.setText("Debe ingresar puerto del servidor de salida");
	    } else {
		errorPort = false;
		lblErrorServer.setVisible(false);
	    }

	}

	dto.setEmailConfigurationId(configuration.getEmailConfigurationId());
	dto.setEmailPort(port);
	dto.setEmailServer(server);
	dto.setSenderEmail(email);
	dto.setPassword(passwordStr);

	if (errorEmail == false && errorPassword == false && errorServer == false && errorPort == false)

	{
	    emailService.saveOrUpdateConfiguration(dto, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error  :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {

		    not.show(5000, LocaleMessages.LANG.emailConfigurationOk(), Notification.OK);
		}

	    });

	}
    }

    

    public void traerConfiguracion() {

	try {
	    emailService.getConfiguration(new AsyncCallback<EmailConfigurationDTO>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();
		}

		@Override
		public void onSuccess(EmailConfigurationDTO dto) {
		    configuration = dto;
		    emailPort.setText(dto.getEmailPort());
		    emailServer.setText(dto.getEmailServer());
		    emailSender.setText(dto.getSenderEmail());
		    password.setValue(dto.getPassword());
		}

	    });
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }
}
