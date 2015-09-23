package com.rhiscom.bpm.console.server.services.dao;

import java.util.List;
import java.util.Set;

import com.rhiscom.bpm.console.server.model.entity.AccessProfileFunctionalityAbility;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

public interface SecurityDAO {

    Set<AccessProfileFunctionalityAbility> getAccessByProfileId(Long profileId);

    void addProfile(ProfileDTO profileDTO) throws Exception;

    void updateProfile(ProfileDTO profileDTO) throws Exception;

    ProfileDTO getProfileById(Long id) throws Exception;

    void deleteProfile(ProfileDTO profileDTO) throws Exception;

    List<ProfileDTO> getAllProfiles() throws Exception;

    List<AbilityDTO> getAllAbilityes() throws Exception;

    List<FunctionalityModuleDTO> getAllModules() throws Exception;

}
