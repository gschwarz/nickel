package com.rhiscom.bpm.console.client.ui.process;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class ConfigurationProcessWidget extends Composite {

    private static final Binder binder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Widget, ConfigurationProcessWidget> {
    }

    @UiField
    DateBox initDate;

    public ConfigurationProcessWidget() {
	initWidget(binder.createAndBindUi(this));

	initDate.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("yyyy/MM/dd hh:mm")));
	initDate.getDatePicker().setWidth("170px");
	initDate.addValueChangeHandler(new ValueChangeHandler<Date>() {

	    public void onValueChange(ValueChangeEvent<Date> event) {

	    }

	});
    }

}
