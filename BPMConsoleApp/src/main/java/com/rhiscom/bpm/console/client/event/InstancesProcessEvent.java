package com.rhiscom.bpm.console.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class InstancesProcessEvent extends GwtEvent<InstancesProcessEventHandler> {

    public static Type<InstancesProcessEventHandler> TYPE = new Type<InstancesProcessEventHandler>();

    @Override
    protected void dispatch(InstancesProcessEventHandler handler) {
	handler.update(this);

    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<InstancesProcessEventHandler> getAssociatedType() {
	return TYPE;
    }

}