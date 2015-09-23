package com.rhiscom.bpm.console.client.event;

import de.novanic.eventservice.client.event.Event;

public class ErrorEvent extends ATNEvent {

    private String message;

    public ErrorEvent(String message) {
	this.message = message;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

}
