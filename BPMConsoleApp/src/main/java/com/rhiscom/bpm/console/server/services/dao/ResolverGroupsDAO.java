package com.rhiscom.bpm.console.server.services.dao;

import java.util.List;

import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;

public interface ResolverGroupsDAO {

    void addResolutionGroup(ResolverGroupDTO resolverGroupDTO) throws Exception;

    List<ResolverGroupDTO> getAll() throws Exception;

    ResolverGroupDTO getById(Long id) throws Exception;

    ResolverGroupDTO update(ResolverGroupDTO dto) throws Exception;

    List<ResolverGroupDTO> getAllOK() throws Exception;

    void deleteResolverGroup(ResolverGroupDTO resolverGroupDTO) throws Exception;

}
