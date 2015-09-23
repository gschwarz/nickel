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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.remote.EmailConfigurationService;
import com.rhiscom.bpm.console.client.remote.EmailConfigurationServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO;

public class EmailRecipientsConfigurationViewImpl extends Composite implements EmailRecipientsConfigurationView{
    private static final Binder binder = GWT.create(Binder.class);
    @UiField
    ListBox lstEvents;
    @UiField
    TextArea txtTo;
    @UiField
    Button btnGuardarDest;
    @UiField
    Label lblErrorRecipients;
    
    private RecipientsByEventDTO recipients = null;
    final EmailConfigurationServiceAsync emailService = GWT.create(EmailConfigurationService.class);
    
    interface Binder extends UiBinder<Widget, EmailRecipientsConfigurationViewImpl> {
    }
    
    public EmailRecipientsConfigurationViewImpl() {
	initWidget(binder.createAndBindUi(this));
	lblErrorRecipients.setVisible(false);
	lstEvents.addChangeHandler(new ChangeHandler() {
	    public void onChange(ChangeEvent event) {
		int selectedIndex = lstEvents.getSelectedIndex();
		if (selectedIndex > 0)
		    emailService.getRecipientByEvent(lstEvents.getValue(selectedIndex),
			    new AsyncCallback<RecipientsByEventDTO>() {

				@Override
				public void onFailure(Throwable ex) {
				    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
				    dialog.center();
				    dialog.show();
				}

				@Override
				public void onSuccess(RecipientsByEventDTO dto) {
				    recipients = dto;
				    txtTo.setText(dto.getRecipients());
				}
			    });

	    }
	});
    }

    @UiHandler("btnGuardarDest")
    void onClickGuardarRecipients(ClickEvent e) {
	final Notification not = new Notification(true, true);
	if (recipients == null) {
	    recipients = new RecipientsByEventDTO();
	}

	int selectedIndex = lstEvents.getSelectedIndex();

	String to = txtTo.getText();
	if (to.trim().length() == 0) {
	    lblErrorRecipients.setVisible(true);
	    lblErrorRecipients.setText("Debe ingresar destinatarios");

	} else if (selectedIndex == 0) {
	    lblErrorRecipients.setVisible(true);
	    lblErrorRecipients.setText("Debe ingresar un evento asociado");
	} else {
	    lblErrorRecipients.setVisible(false);
	    RecipientsByEventDTO dto = new RecipientsByEventDTO();

	    dto.setRecipientsId(recipients.getRecipientsId());
	    dto.setRecipients(to);
	    dto.setEvent(lstEvents.getValue(selectedIndex));

	    List<RecipientsByEventDTO> list = new ArrayList<RecipientsByEventDTO>();
	    list.add(dto);

	    emailService.saveOrUpdateRecipients(list, new AsyncCallback() {

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
    

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub
	
    }
    
}
