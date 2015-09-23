package com.rhiscom.bpm.console.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface LoginEventHandler extends EventHandler {
    void login(LoginEvent event);
}
