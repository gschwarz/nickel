package com.rhiscom.bpm.console.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ServerMessageGeneratorService")
public interface ServerMessageGeneratorService extends RemoteService {

	void sendEvent(String event);

}
