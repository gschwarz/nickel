package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;

public interface ResolverGroupsServiceAsync {
    public void addResolutionGroup(ResolverGroupDTO resolverGroupDTO, AsyncCallback callback);

    public void getAll(AsyncCallback<List<ResolverGroupDTO>> callback);

    public void getById(Long id, AsyncCallback<ResolverGroupDTO> callback);

    public void update(ResolverGroupDTO resolverGroupDTO, AsyncCallback<ResolverGroupDTO> callback);

    public void getAllOK(AsyncCallback<List<ResolverGroupDTO>> callback);

    public void deleteResolverGroup(ResolverGroupDTO resolverGroupDTO, AsyncCallback callback);
}
