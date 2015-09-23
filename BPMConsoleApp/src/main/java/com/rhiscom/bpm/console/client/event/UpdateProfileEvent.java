package com.rhiscom.bpm.console.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateProfileEvent extends GwtEvent<UpdateProfileEventHandler> {

    public static Type<UpdateProfileEventHandler> TYPE = new Type<UpdateProfileEventHandler>();

    @Override
    protected void dispatch(UpdateProfileEventHandler handler) {
	handler.update(this);

    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<UpdateProfileEventHandler> getAssociatedType() {
	return TYPE;
    }

}
