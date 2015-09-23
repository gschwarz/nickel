package com.rhiscom.bpm.console.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateBusinessUnitEvent extends GwtEvent<UpdateBusinessUnitEventHandler> {

    public static Type<UpdateBusinessUnitEventHandler> TYPE = new Type<UpdateBusinessUnitEventHandler>();

    @Override
    protected void dispatch(UpdateBusinessUnitEventHandler handler) {
	handler.update(this);

    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<UpdateBusinessUnitEventHandler> getAssociatedType() {
	return TYPE;
    }

}