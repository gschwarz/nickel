package com.rhiscom.bpm.console.client.ui.administration.profile;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.view.client.ListDataProvider;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;

public class ModulesAbilityDataBase {

    private static ModulesAbilityDataBase instance = null;

    private ModulesAbilityDataBase() {

    }

    public static ModulesAbilityDataBase getInstance() {
	if (instance == null)
	    instance = new ModulesAbilityDataBase();
	return instance;

    }

    public void resetDatabase() {
	mapModules = new HashMap<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>>();
    }

    public Map<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>> getMapModules() {
	return mapModules;
    }

    public void setMapModules(Map<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>> mapModules) {
	this.mapModules = mapModules;
    }

    private Map<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>> mapModules = new HashMap<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>>();

}
