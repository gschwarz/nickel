package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

@RemoteServiceRelativePath("userservice")
public interface UserService extends RemoteService {

    public List<OperatorDTO> getAllOperator() throws Exception;

    public OperatorDTO getById(Long id) throws Exception;

    public OperatorDTO editOperator(OperatorDTO operatorDTO) throws Exception;

    public void deleteOperator(OperatorDTO operatorDTO) throws Exception;

    public void addOperator(OperatorDTO operatorDTO) throws Exception;

    public OperatorDTO searchOperator(String user) throws Exception;

}
