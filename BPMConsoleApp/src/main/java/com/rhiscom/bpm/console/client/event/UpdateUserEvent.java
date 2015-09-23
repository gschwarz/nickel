package com.rhiscom.bpm.console.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateUserEvent extends GwtEvent<UpdateUserEventHandler> {

    public static Type<UpdateUserEventHandler> TYPE = new Type<UpdateUserEventHandler>();

    @Override
    protected void dispatch(UpdateUserEventHandler handler) {
	handler.update(this);

    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<UpdateUserEventHandler> getAssociatedType() {
	return TYPE;
    }

}
