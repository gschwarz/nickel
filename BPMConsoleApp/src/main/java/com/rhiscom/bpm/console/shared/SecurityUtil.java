package com.rhiscom.bpm.console.shared;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

public class SecurityUtil {

    public static List<AbilityDTO> getAbilityes(OperatorDTO operator, String viewCode) {
	List<AbilityDTO> abilityList = new ArrayList<AbilityDTO>();
	ProfileDTO profile = operator.getProfileDTO();
	if (profile != null) {
	    Set<AccessProfileFunctionalityAbilityDTO> accessList = profile.getAccessProfileFunctionalityAbility();

	    for (Iterator iterator = accessList.iterator(); iterator.hasNext();) {

		AccessProfileFunctionalityAbilityDTO dto = (AccessProfileFunctionalityAbilityDTO) iterator.next();
		if (dto.getSegAccessProfileFunc().getCode().equals(viewCode)) {
		    abilityList.add(dto.getSegAbility());
		}

	    }
	}
	return abilityList;

    }
}
