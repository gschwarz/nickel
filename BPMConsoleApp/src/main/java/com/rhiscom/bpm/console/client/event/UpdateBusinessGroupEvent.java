package com.rhiscom.bpm.console.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateBusinessGroupEvent extends GwtEvent<UpdateBusinessGroupEventHandler> {

    public static Type<UpdateBusinessGroupEventHandler> TYPE = new Type<UpdateBusinessGroupEventHandler>();

    @Override
    protected void dispatch(UpdateBusinessGroupEventHandler handler) {
	handler.update(this);

    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<UpdateBusinessGroupEventHandler> getAssociatedType() {
	return TYPE;
    }

}
