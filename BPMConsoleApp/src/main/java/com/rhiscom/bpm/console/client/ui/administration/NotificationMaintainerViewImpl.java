package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NotificationMaintainerViewImpl extends Composite {

    private static final Binder binder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Widget, NotificationMaintainerViewImpl> {
    }

    public NotificationMaintainerViewImpl() {
	initWidget(binder.createAndBindUi(this));
    }

}
