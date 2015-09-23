package com.rhiscom.bpm.console.client.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.Authentication;
import com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

public class ProfilesUtil {
    private Map<String, List<String>> modulesMap = new HashMap<String, List<String>>();

    public Map<String, List<String>> buildAccess() {
	Authentication auth = ApplicationContext.getAuth();
	List<String> fnList = null;
	OperatorDTO loggedOperator = auth.getOperator();
	ProfileDTO profiles = loggedOperator.getProfileDTO();
	if (profiles != null) {
	    ProfileDTO profileDTO = profiles;
	    Set<AccessProfileFunctionalityAbilityDTO> accessList = profileDTO
		    .getAccessProfileFunctionalityAbility();

	    for (Iterator iterator = accessList.iterator(); iterator.hasNext();) {

		FunctionalityModuleDTO module = ((AccessProfileFunctionalityAbilityDTO) iterator.next())
			.getSegAccessProfileFunc();
		int index = module.getCode().indexOf("_");
		String mod = module.getCode().substring(0, index);
		fnList = modulesMap.get(mod);
		if (fnList == null) {
		    fnList = new ArrayList<String>();
		}

		String function = module.getCode().substring(index + 1, module.getCode().length());
		fnList.add(function);
		modulesMap.put(mod, fnList);

	    }
	}
	return modulesMap;

    }
}
