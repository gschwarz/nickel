package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.rhiscom.bpm.console.client.remote.DeleteDataService;
import com.rhiscom.bpm.console.client.remote.DeleteDataServiceAsync;

public class DeleteDataViewImpl extends Composite implements DeleteDataView {

    private static deleteDataUiBinder uiBinder = GWT.create(deleteDataUiBinder.class);
    final DeleteDataServiceAsync deleteDataService = GWT.create(DeleteDataService.class);

    interface deleteDataUiBinder extends UiBinder<Widget, DeleteDataViewImpl> {
    }

    public DeleteDataViewImpl() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    Button button;
    @UiField
    DatePicker Calendario;

    public DeleteDataViewImpl(String firstName) {
	initWidget(uiBinder.createAndBindUi(this));
	button.setText(firstName);

    }

    @UiHandler("button")
    void onClick(ClickEvent e) {

	deleteDataService.deleteData(Calendario.getValue(), new AsyncCallback() {
	    @Override
	    public void onFailure(Throwable ex) {
		ex.printStackTrace();
	    }

	    @Override
	    public void onSuccess(Object arg0) {
		System.out.println(">>> servicio funciono");
	    }
	});

    }

    public void setText(String text) {
	button.setText(text);
    }

    public String getText() {
	return button.getText();
    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }

}
