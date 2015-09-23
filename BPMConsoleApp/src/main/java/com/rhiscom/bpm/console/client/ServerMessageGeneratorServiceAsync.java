package com.rhiscom.bpm.console.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServerMessageGeneratorServiceAsync {
	void sendEvent(String event, AsyncCallback<Void> anAsyncCallback);
}
