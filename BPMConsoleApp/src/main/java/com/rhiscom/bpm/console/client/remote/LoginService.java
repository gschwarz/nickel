package com.rhiscom.bpm.console.client.remote;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

@RemoteServiceRelativePath("LoginService")
public interface LoginService extends RemoteService {
    /**
     * Utility class for simplifying access to the instance of async service.
     */
    public static class Util {
	private static LoginServiceAsync instance;

	public static LoginServiceAsync getInstance() {
	    if (instance == null) {
		instance = GWT.create(LoginService.class);
	    }
	    return instance;
	}
    }

    OperatorDTO loginService(String name, String password) throws Exception;

    OperatorDTO loginFromSessionServer();

    void logout();
}
