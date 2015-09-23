package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

@RemoteServiceRelativePath("securityService")
public interface SecurityService extends RemoteService {

    List<FunctionalityModuleDTO> getAllModules() throws Exception;

    List<AbilityDTO> getAllAbilityes() throws Exception;

    List<ProfileDTO> getAllProfiles() throws Exception;

    void deleteProfile(ProfileDTO profileDTO) throws Exception;

    ProfileDTO getProfileById(Long id) throws Exception;

    void updateProfile(ProfileDTO profileDTO) throws Exception;

    void addProfile(ProfileDTO profileDTO) throws Exception;

}
