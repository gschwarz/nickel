package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;

@RemoteServiceRelativePath("resolvergroupservice")
public interface ResolverGroupsService extends RemoteService {
    public void addResolutionGroup(ResolverGroupDTO resolverGroupDTO) throws Exception;

    public List<ResolverGroupDTO> getAll() throws Exception;

    public ResolverGroupDTO getById(Long id) throws Exception;

    public ResolverGroupDTO update(ResolverGroupDTO dto) throws Exception;

    public List<ResolverGroupDTO> getAllOK() throws Exception;

    public void deleteResolverGroup(ResolverGroupDTO resolverGroupDTO) throws Exception;

}
