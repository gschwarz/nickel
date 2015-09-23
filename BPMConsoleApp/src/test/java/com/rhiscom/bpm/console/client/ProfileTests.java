package com.rhiscom.bpm.console.client;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rhiscom.bpm.console.server.services.SecurityServiceImpl;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

public class ProfileTests {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addProfileTest() {

	AccessProfileFunctionalityAbilityDTO dto1 = new AccessProfileFunctionalityAbilityDTO();
	AbilityDTO abilityDTO = new AbilityDTO();
	FunctionalityModuleDTO funcDTO = new FunctionalityModuleDTO();

	funcDTO.setSegFuncModuleId(1);
	funcDTO.setModule("Procesos");
	funcDTO.setStatus(1);
	funcDTO.setCode("mproc_fnproc");
	funcDTO.setDescription("Procesos");

	abilityDTO.setSegAbilityId(1);
	abilityDTO.setName("administrador");
	abilityDTO.setDescription("Administrador de modulo");
	abilityDTO.setStatus(1);

	dto1.setSegAbility(abilityDTO);
	dto1.setSegAccessProfileFunc(funcDTO);

	abilityDTO = new AbilityDTO();
	abilityDTO.setSegAbilityId(2);
	abilityDTO.setName("visualizador");
	abilityDTO.setDescription("Visualizador del modulo");
	abilityDTO.setStatus(1);

	funcDTO = new FunctionalityModuleDTO();
	funcDTO.setSegFuncModuleId(1);
	funcDTO.setModule("Procesos");
	funcDTO.setStatus(1);
	funcDTO.setCode("mproc_fnproc");
	funcDTO.setDescription("Procesos");

	AccessProfileFunctionalityAbilityDTO dto2 = new AccessProfileFunctionalityAbilityDTO();
	dto2.setSegAbility(abilityDTO);
	dto2.setSegAccessProfileFunc(funcDTO);

	Set<AccessProfileFunctionalityAbilityDTO> list = new HashSet<AccessProfileFunctionalityAbilityDTO>();

	list.add(dto1);
	list.add(dto2);

	ProfileDTO profileDTO = new ProfileDTO("Administrador generala", "Desca", 1, new Date(), list);
	SecurityServiceImpl service = new SecurityServiceImpl();
	try {
	    service.addProfile(profileDTO);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    System.out.println("Mensaje :" + e);
	}

    }

    @Test
    public void updateProfileTests() {
	SecurityServiceImpl service = new SecurityServiceImpl();

	ProfileDTO profileDTO = null;
	try {
	    profileDTO = service.getProfileById(new Long(8));
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	AccessProfileFunctionalityAbilityDTO dto2 = new AccessProfileFunctionalityAbilityDTO();

	AbilityDTO abilityDTO = new AbilityDTO();
	FunctionalityModuleDTO funcDTO = new FunctionalityModuleDTO();

	funcDTO.setSegFuncModuleId(4);
	funcDTO.setModule("Administración");
	funcDTO.setStatus(1);
	funcDTO.setCode("mtskmng_fnaut");
	funcDTO.setDescription("Unidades de negocio");

	abilityDTO.setSegAbilityId(1);
	abilityDTO.setName("administrador");
	abilityDTO.setDescription("Administrador de modulo");
	abilityDTO.setStatus(1);

	dto2.setSegAbility(abilityDTO);
	dto2.setSegAccessProfileFunc(funcDTO);

	profileDTO.getAccessProfileFunctionalityAbility().add(dto2);

	try {
	    service.updateProfile(profileDTO);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Test
    public void getById() {
	SecurityServiceImpl service = new SecurityServiceImpl();

	ProfileDTO profileDTO = null;
	try {
	    profileDTO = service.getProfileById(new Long(8));
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	Assert.assertNotNull(profileDTO);
	System.out.println(profileDTO);

    }

    @Test
    public void deleteProfile() {
	SecurityServiceImpl service = new SecurityServiceImpl();

	ProfileDTO profileDTO = null;
	try {
	    profileDTO = service.getProfileById(new Long(1));
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	try {
	    service.deleteProfile(profileDTO);
	} catch (Exception ex) {

	}
    }

    @Test
    public void getAll() {
	SecurityServiceImpl service = new SecurityServiceImpl();
	try {
	    List<ProfileDTO> listadoProfileDTO = service.getAllProfiles();
	    System.out.println(listadoProfileDTO);
	    Assert.assertTrue(listadoProfileDTO.size() > 0);
	} catch (Exception ex) {

	}
    }

    @Test
    public void getAllAbilityes() {
	SecurityServiceImpl service = new SecurityServiceImpl();
	List<AbilityDTO> listAbilityDTO;
	try {
	    listAbilityDTO = service.getAllAbilityes();
	    Assert.assertTrue(listAbilityDTO.size() > 0);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Test
    public void getAllModules() {
	SecurityServiceImpl service = new SecurityServiceImpl();
	List<FunctionalityModuleDTO> listModuleDTO;
	try {
	    listModuleDTO = service.getAllModules();
	    Assert.assertTrue(listModuleDTO.size() > 0);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}
