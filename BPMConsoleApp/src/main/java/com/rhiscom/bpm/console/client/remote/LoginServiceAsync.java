package com.rhiscom.bpm.console.client.remote;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public interface LoginServiceAsync {

    void loginService(String name, String password, AsyncCallback<OperatorDTO> callback) throws Exception;

    void loginFromSessionServer(AsyncCallback<OperatorDTO> callback);

    void logout(AsyncCallback callback);
}
