package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.ClientFactory;

public class DashBoardHomeViewImpl extends Composite implements DashBoardHomeView {

    private static final Binder binder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Widget, DashBoardHomeViewImpl> {
    }

    /**
     * Constructor
     */
    public DashBoardHomeViewImpl(ClientFactory factory) {

	initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }
}
