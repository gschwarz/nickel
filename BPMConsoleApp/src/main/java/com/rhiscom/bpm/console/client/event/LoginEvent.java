package com.rhiscom.bpm.console.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class LoginEvent extends GwtEvent<LoginEventHandler> {

    public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();

    @Override
    protected void dispatch(LoginEventHandler handler) {
	handler.login(this);

    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<LoginEventHandler> getAssociatedType() {
	return TYPE;
    }

}
