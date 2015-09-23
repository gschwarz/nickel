package com.rhiscom.bpm.console.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateResolverGroupEvent extends GwtEvent<UpdateResolverGroupEventHandler> {

    public static Type<UpdateResolverGroupEventHandler> TYPE = new Type<UpdateResolverGroupEventHandler>();

    @Override
    protected void dispatch(UpdateResolverGroupEventHandler handler) {
	handler.update(this);

    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<UpdateResolverGroupEventHandler> getAssociatedType() {
	return TYPE;
    }

}
