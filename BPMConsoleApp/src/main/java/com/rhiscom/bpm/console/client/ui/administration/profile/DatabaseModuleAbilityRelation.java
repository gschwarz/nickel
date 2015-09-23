package com.rhiscom.bpm.console.client.ui.administration.profile;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.view.client.ListDataProvider;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;

public class DatabaseModuleAbilityRelation {

    Map<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>> projectMembersByPermission = new HashMap<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>>();

}
