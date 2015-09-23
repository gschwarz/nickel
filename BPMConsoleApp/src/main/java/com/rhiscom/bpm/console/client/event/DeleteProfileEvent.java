package com.rhiscom.bpm.console.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

public class DeleteProfileEvent extends GwtEvent<DeleteProfileEventHandler> {

    public static Type<DeleteProfileEventHandler> TYPE = new Type<DeleteProfileEventHandler>();
    public ProfileDTO profile;

    public DeleteProfileEvent(ProfileDTO profileDTO) {
	profile = profileDTO;
    }

    public DeleteProfileEvent() {
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void dispatch(DeleteProfileEventHandler handler) {
	handler.delete(this);

    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<DeleteProfileEventHandler> getAssociatedType() {
	return TYPE;
    }

}
