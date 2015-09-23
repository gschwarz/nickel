package com.rhiscom.bpm.console.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class HistoryInstancesEvent extends GwtEvent<HistoryInstancesEventHandler> {

    public static Type<HistoryInstancesEventHandler> TYPE = new Type<HistoryInstancesEventHandler>();

    @Override
    protected void dispatch(HistoryInstancesEventHandler handler) {
	handler.update(this);

    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<HistoryInstancesEventHandler> getAssociatedType() {
	return TYPE;
    }

}
