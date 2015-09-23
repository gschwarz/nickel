package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

public interface SecurityServiceAsync {

    public void getAllModules(AsyncCallback<List<FunctionalityModuleDTO>> callback) throws Exception;

    public void getAllAbilityes(AsyncCallback<List<AbilityDTO>> callback) throws Exception;

    public void getAllProfiles(AsyncCallback<List<ProfileDTO>> callback) throws Exception;

    public void deleteProfile(ProfileDTO profileDTO, AsyncCallback callback) throws Exception;

    public void getProfileById(Long id, AsyncCallback<ProfileDTO> callback) throws Exception;

    public void updateProfile(ProfileDTO profileDTO, AsyncCallback callback) throws Exception;

    public void addProfile(ProfileDTO profileDTO, AsyncCallback callbac) throws Exception;
}
