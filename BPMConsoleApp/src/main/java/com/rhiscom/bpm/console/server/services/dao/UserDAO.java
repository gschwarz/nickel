package com.rhiscom.bpm.console.server.services.dao;

import java.util.List;

import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public interface UserDAO {

    List<OperatorDTO> getAllOperator() throws Exception;

    OperatorDTO searchOperator(String user) throws Exception;

    void deleteOperator(OperatorDTO operatorDTO) throws Exception;

    OperatorDTO editOperator(OperatorDTO operatorDTO) throws Exception;

    void addOperator(OperatorDTO operatorDTO) throws Exception;

    OperatorDTO getById(Long id) throws Exception;

}
