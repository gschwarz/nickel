package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public interface UserServiceAsync {

    public void getAllOperator(AsyncCallback<List<OperatorDTO>> callback) throws Exception;

    public void getById(Long id, AsyncCallback<OperatorDTO> callback) throws Exception;

    public void editOperator(OperatorDTO operatorDTO, AsyncCallback<OperatorDTO> callback) throws Exception;

    public void deleteOperator(OperatorDTO operatorDTO, AsyncCallback callback) throws Exception;

    public void addOperator(OperatorDTO operatorDTO, AsyncCallback callback) throws Exception;

    public void searchOperator(String user, AsyncCallback<OperatorDTO> callback) throws Exception;

}
