package com.rhiscom.bpm.console.server.services.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.rhiscom.bpm.console.server.model.entity.Ability;
import com.rhiscom.bpm.console.server.model.entity.AccessProfileFunctionalityAbility;
import com.rhiscom.bpm.console.server.model.entity.FunctionalityModule;
import com.rhiscom.bpm.console.server.model.entity.Profile;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

public class SecurityDAOImpl implements SecurityDAO {
    private static final Logger logger = Logger.getLogger(SecurityDAOImpl.class.getName());
    EntityManager em;

    public SecurityDAOImpl(EntityManager entityManager) {
	em = entityManager;
    }

    @Override
    public Set<AccessProfileFunctionalityAbility> getAccessByProfileId(Long profileId) {

	Query q = em.createQuery("SELECT a from AccessProfileFunctionalityAbility  a Where a.segProfileId='"
		+ profileId + "'");
	ArrayList<AccessProfileFunctionalityAbility> resultList = (ArrayList<AccessProfileFunctionalityAbility>) q
		.getResultList();
	Set<AccessProfileFunctionalityAbility> list = new HashSet<AccessProfileFunctionalityAbility>(resultList);

	return list;
    }

    @Override
    public void addProfile(ProfileDTO profileDTO) throws Exception {

	AbilityDTO abilityDTO;
	FunctionalityModuleDTO moduleDTO;
	FunctionalityModule module;
	Ability ability;
	Set<AccessProfileFunctionalityAbility> listadoAccesosPorModulos = null;
	Profile profile = new Profile(profileDTO.getName(), profileDTO.getDescription(), profileDTO.getStatus(),
		profileDTO.getCreateStamp());
	if (profileDTO.getAccessProfileFunctionalityAbility() != null) {
	    listadoAccesosPorModulos = new HashSet<AccessProfileFunctionalityAbility>();
	    for (Iterator iterator = profileDTO.getAccessProfileFunctionalityAbility().iterator(); iterator.hasNext();) {

		AccessProfileFunctionalityAbilityDTO dto = (AccessProfileFunctionalityAbilityDTO) iterator.next();
		abilityDTO = dto.getSegAbility();
		moduleDTO = new FunctionalityModuleDTO();
		moduleDTO = dto.getSegAccessProfileFunc();
		module = new FunctionalityModule(moduleDTO.getSegFuncModuleId(), moduleDTO.getModule(),
			moduleDTO.getDescription(), moduleDTO.getStatus(), moduleDTO.getCode());
		System.out.println("MODULE :" + module);

		ability = new Ability(abilityDTO.getSegAbilityId(), abilityDTO.getName(), abilityDTO.getDescription(),
			abilityDTO.getStatus());
		System.out.println("Abilidad  :" + ability);
		AccessProfileFunctionalityAbility entity = new AccessProfileFunctionalityAbility(module, ability);

		listadoAccesosPorModulos.add(entity);
	    }
	}

	System.out.println("Profile  :" + profile);
	try {

	    em.getTransaction().begin();
	    em.persist(profile);

	    for (Iterator<AccessProfileFunctionalityAbility> iterator = listadoAccesosPorModulos.iterator(); iterator
		    .hasNext();) {
		AccessProfileFunctionalityAbility entity = iterator.next();
		entity.setSegProfileId(profile.getSegProfileId());
		entity.setSegAccessProfileFuncAbilityId(null);
		em.persist(entity);

	    }
	    em.getTransaction().commit();

	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();

	    throw new Exception("PERSISTENCE :" + e.toString());

	} catch (Exception ex) {
	    ex.printStackTrace();

	    throw new Exception("ERROR :" + ex.toString());

	} finally {

	}

    }

    @Override
    public void updateProfile(ProfileDTO profileDTO) throws Exception {
	Set<AccessProfileFunctionalityAbility> listadoAccesosPorModulos = null;
	AbilityDTO abilityDTO;
	FunctionalityModuleDTO moduleDTO;
	FunctionalityModule module;
	Ability ability;
	Profile profile = new Profile(profileDTO.getSegProfileId(), profileDTO.getName(), profileDTO.getDescription(),
		profileDTO.getStatus(), profileDTO.getCreateStamp(), profileDTO.getUpdateStamp());

	if (profileDTO.getAccessProfileFunctionalityAbility() != null) {
	    listadoAccesosPorModulos = new HashSet<AccessProfileFunctionalityAbility>();
	    for (Iterator iterator = profileDTO.getAccessProfileFunctionalityAbility().iterator(); iterator.hasNext();) {
		AccessProfileFunctionalityAbilityDTO dto = (AccessProfileFunctionalityAbilityDTO) iterator.next();

		abilityDTO = dto.getSegAbility();
		moduleDTO = dto.getSegAccessProfileFunc();
		module = new FunctionalityModule(moduleDTO.getSegFuncModuleId(), moduleDTO.getModule(),
			moduleDTO.getDescription(), moduleDTO.getStatus(), moduleDTO.getCode());

		ability = new Ability(abilityDTO.getSegAbilityId(), abilityDTO.getName(), abilityDTO.getDescription(),
			abilityDTO.getStatus());

		AccessProfileFunctionalityAbility entity = new AccessProfileFunctionalityAbility(
			dto.getSegAccessProfileFuncAbilityId(), module, ability);
		entity.setSegProfileId(profile.getSegProfileId());
		listadoAccesosPorModulos.add(entity);
	    }
	}

	try {

	    em.getTransaction().begin();
	    Query q = em.createNativeQuery("Delete from seg_access_profile_func_ability Where segProfileId ="
		    + profile.getSegProfileId() + "");
	    q.executeUpdate();
	    em.getTransaction().commit();
	    em.getTransaction().begin();
	    em.merge(profile);

	    for (Iterator<AccessProfileFunctionalityAbility> iterator = listadoAccesosPorModulos.iterator(); iterator
		    .hasNext();) {
		AccessProfileFunctionalityAbility entity = iterator.next();
		entity.setSegAccessProfileFuncAbilityId(null);

		em.persist(entity);

	    }
	    em.getTransaction().commit();

	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();

	    throw new Exception("PERSISTENCE :" + e.toString());

	} catch (Exception ex) {
	    ex.printStackTrace();

	    throw new Exception("ERROR :" + ex.toString());

	}
    }

    @Override
    public ProfileDTO getProfileById(Long id) throws Exception {
	ProfileDTO profileDTO = null;
	AbilityDTO abilityDTO;
	FunctionalityModuleDTO funcionalityModuleDTO;

	try {

	    Profile profile = em.find(Profile.class, id);
	    if (profile != null) {

		Query q = em.createQuery("SELECT a from AccessProfileFunctionalityAbility  a Where a.segProfileId='"
			+ profile.getSegProfileId() + "'");
		ArrayList<AccessProfileFunctionalityAbility> resultList = (ArrayList<AccessProfileFunctionalityAbility>) q
			.getResultList();
		Set<AccessProfileFunctionalityAbility> list = new HashSet<AccessProfileFunctionalityAbility>(resultList);
		Set<AccessProfileFunctionalityAbilityDTO> listAccessProfileFunctionalityAbility = null;

		if (list != null) {
		    listAccessProfileFunctionalityAbility = new HashSet<AccessProfileFunctionalityAbilityDTO>();

		    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			AccessProfileFunctionalityAbility entity = (AccessProfileFunctionalityAbility) iterator.next();

			abilityDTO = new AbilityDTO(entity.getSegAbility().getSegAbilityId(), entity.getSegAbility()
				.getName(), entity.getSegAbility().getDescription(), entity.getSegAbility().getStatus());
			funcionalityModuleDTO = new FunctionalityModuleDTO(entity.getSegAccessProfileFunc()
				.getSegFuncModuleId(), entity.getSegAccessProfileFunc().getModule(), entity
				.getSegAccessProfileFunc().getDescription(), entity.getSegAccessProfileFunc()
				.getStatus(), entity.getSegAccessProfileFunc().getCode());

			AccessProfileFunctionalityAbilityDTO dto = new AccessProfileFunctionalityAbilityDTO(abilityDTO,
				funcionalityModuleDTO, entity.getSegAccessProfileFuncAbilityId());
			dto.setSegProfileId(entity.getSegProfileId());
			listAccessProfileFunctionalityAbility.add(dto);
		    }

		}

		profileDTO = new ProfileDTO(profile.getSegProfileId(), profile.getName(), profile.getDescription(),
			profile.getStatus(), profile.getCreateStamp(), profile.getUpdateStamp(),
			listAccessProfileFunctionalityAbility);
	    }

	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();

	    throw new Exception("PERSISTENCE :" + e.toString());

	} catch (Exception ex) {
	    ex.printStackTrace();

	    throw new Exception("ERROR :" + ex.toString());
	}

	return profileDTO;
    }

    @Override
    public void deleteProfile(ProfileDTO profileDTO) throws Exception {
	Set<AccessProfileFunctionalityAbility> listadoAccesosPorModulos = null;

	AbilityDTO abilityDTO;
	FunctionalityModuleDTO moduleDTO;
	FunctionalityModule module;
	Ability ability;

	if (profileDTO.getAccessProfileFunctionalityAbility() != null) {
	    listadoAccesosPorModulos = new HashSet<AccessProfileFunctionalityAbility>();
	    for (Iterator iterator = profileDTO.getAccessProfileFunctionalityAbility().iterator(); iterator.hasNext();) {
		AccessProfileFunctionalityAbilityDTO dto = (AccessProfileFunctionalityAbilityDTO) iterator.next();

		abilityDTO = dto.getSegAbility();
		moduleDTO = dto.getSegAccessProfileFunc();
		module = new FunctionalityModule(moduleDTO.getSegFuncModuleId(), moduleDTO.getModule(),
			moduleDTO.getDescription(), moduleDTO.getStatus(), moduleDTO.getCode());

		ability = new Ability(abilityDTO.getSegAbilityId(), abilityDTO.getName(), abilityDTO.getDescription(),
			abilityDTO.getStatus());

		AccessProfileFunctionalityAbility entity = new AccessProfileFunctionalityAbility(
			dto.getSegAccessProfileFuncAbilityId(), module, ability);
		listadoAccesosPorModulos.add(entity);
	    }
	}

	Profile profile = new Profile(profileDTO.getSegProfileId(), profileDTO.getName(), profileDTO.getDescription(),
		profileDTO.getStatus(), profileDTO.getCreateStamp(), profileDTO.getUpdateStamp());
	try {

	    em.getTransaction().begin();

	    Query q = em.createNativeQuery("Delete from seg_access_profile_func_ability Where segProfileId ='"
		    + profile.getSegProfileId() + "'");
	    q.executeUpdate();
	    em.getTransaction().commit();
	    em.getTransaction().begin();
	    em.remove(em.merge(profile));
	    em.getTransaction().commit();

	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();

	    throw new Exception("PERSISTENCE :" + e.toString());

	} catch (Exception ex) {
	    ex.printStackTrace();

	    throw new Exception("ERROR :" + ex.toString());

	}
    }

    @Override
    public List<ProfileDTO> getAllProfiles() throws Exception {
	List<ProfileDTO> resultListDTO = null;
	AbilityDTO abilityDTO;
	FunctionalityModuleDTO funcionalityModuleDTO;

	try {

	    Query query = em.createQuery("SELECT p FROM Profile p");
	    @SuppressWarnings("unchecked")
	    List<Profile> list = (List<Profile>) query.getResultList();

	    if (list != null && list.size() > 0) {

		resultListDTO = new ArrayList<ProfileDTO>();

		for (int i = 0; i <= list.size() - 1; i++) {
		    Profile profile = new Profile();
		    ProfileDTO profileDTO = new ProfileDTO();

		    profile = list.get(i);
		    profileDTO = new ProfileDTO();

		    Query q = em
			    .createQuery("SELECT a from AccessProfileFunctionalityAbility  a Where a.segProfileId='"
				    + profile.getSegProfileId() + "'");

		    ArrayList<AccessProfileFunctionalityAbility> resultList = (ArrayList<AccessProfileFunctionalityAbility>) q
			    .getResultList();

		    Set<AccessProfileFunctionalityAbility> list1 = new HashSet<AccessProfileFunctionalityAbility>(
			    resultList);

		    Set<AccessProfileFunctionalityAbilityDTO> listAccessProfileFunctionalityAbility = null;

		    if (list1 != null) {
			listAccessProfileFunctionalityAbility = new HashSet<AccessProfileFunctionalityAbilityDTO>();
			Set<AccessProfileFunctionalityAbility> resultListAccessProfileFunctionalityAbility = list1;
			for (Iterator<AccessProfileFunctionalityAbility> iterator = resultListAccessProfileFunctionalityAbility
				.iterator(); iterator.hasNext();) {
			    AccessProfileFunctionalityAbility entity = (AccessProfileFunctionalityAbility) iterator
				    .next();

			    abilityDTO = new AbilityDTO(entity.getSegAbility().getSegAbilityId(), entity
				    .getSegAbility().getName(), entity.getSegAbility().getDescription(), entity
				    .getSegAbility().getStatus());
			    funcionalityModuleDTO = new FunctionalityModuleDTO(entity.getSegAccessProfileFunc()
				    .getSegFuncModuleId(), entity.getSegAccessProfileFunc().getModule(), entity
				    .getSegAccessProfileFunc().getDescription(), entity.getSegAccessProfileFunc()
				    .getStatus(), entity.getSegAccessProfileFunc().getCode());

			    AccessProfileFunctionalityAbilityDTO dto = new AccessProfileFunctionalityAbilityDTO(
				    abilityDTO, funcionalityModuleDTO, entity.getSegAccessProfileFuncAbilityId());
			    dto.setSegProfileId(entity.getSegProfileId());
			    listAccessProfileFunctionalityAbility.add(dto);
			}

		    }

		    profileDTO = new ProfileDTO(profile.getSegProfileId(), profile.getName(), profile.getDescription(),
			    profile.getStatus(), profile.getCreateStamp(), profile.getUpdateStamp(),
			    listAccessProfileFunctionalityAbility);
		    resultListDTO.add(profileDTO);
		}

	    }

	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();

	    throw new Exception("PERSISTENCE :" + e.toString());

	} catch (Exception ex) {
	    ex.printStackTrace();

	    throw new Exception("PERSISTENCE :" + ex.toString());

	}
	return resultListDTO;
    }

    @Override
    public List<AbilityDTO> getAllAbilityes() throws Exception {
	List<AbilityDTO> listAbilityDTO = new ArrayList<AbilityDTO>();
	AbilityDTO abilityDTO;

	try {

	    Query query = em.createQuery("SELECT a FROM Ability a");
	    @SuppressWarnings("unchecked")
	    List<Ability> list = (List<Ability>) query.getResultList();

	    if (list != null) {

		for (int i = 0; i <= list.size() - 1; i++) {
		    abilityDTO = new AbilityDTO(list.get(i).getSegAbilityId(), list.get(i).getName(), list.get(i)
			    .getDescription(), list.get(i).getStatus());
		    listAbilityDTO.add(abilityDTO);
		}
	    }

	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();

	    throw new Exception("PERSISTENCE :" + e.toString());

	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new Exception("ERROR :" + ex.toString());

	}
	return listAbilityDTO;
    }

    @Override
    public List<FunctionalityModuleDTO> getAllModules() throws Exception {
	List<FunctionalityModuleDTO> listModuleDTO = new ArrayList<FunctionalityModuleDTO>();
	FunctionalityModuleDTO dto;

	try {

	    Query query = em.createQuery("SELECT a FROM FunctionalityModule a");
	    @SuppressWarnings("unchecked")
	    List<FunctionalityModule> list = (List<FunctionalityModule>) query.getResultList();

	    if (list != null) {

		for (int i = 0; i <= list.size() - 1; i++) {
		    dto = new FunctionalityModuleDTO(list.get(i).getSegFuncModuleId(), list.get(i).getModule(), list
			    .get(i).getDescription(), list.get(i).getStatus(), list.get(i).getCode());
		    listModuleDTO.add(dto);
		}
	    }

	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();
	    throw new Exception("PERSISTENCE :" + e.toString());

	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new Exception("ERROR :" + ex.toString());

	}
	return listModuleDTO;
    }
}
