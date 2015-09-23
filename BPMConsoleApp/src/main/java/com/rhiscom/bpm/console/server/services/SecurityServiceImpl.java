package com.rhiscom.bpm.console.server.services;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.SecurityService;
import com.rhiscom.bpm.console.server.model.entity.AccessProfileFunctionalityAbility;
import com.rhiscom.bpm.console.server.services.dao.SecurityDAOImpl;
import com.rhiscom.bpm.console.server.services.dao.ServiceDAOFactory;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

public class SecurityServiceImpl extends RemoteServiceServlet implements SecurityService {
    private static final Logger logger = Logger.getLogger(SecurityDAOImpl.class.getName());
    private static final long serialVersionUID = 1L;

    public Set<AccessProfileFunctionalityAbility> getAccessByProfileId(Long profileId) throws Exception {
	try {
	    logger.log(Level.INFO, "::[getAccessByProfileId]::");
	    return ServiceDAOFactory.getInstance().getSecurityDAO().getAccessByProfileId(profileId);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getAccessByProfileId]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public void addProfile(ProfileDTO profileDTO) throws Exception {
	try {
	    logger.log(Level.INFO, "::[addProfile]::");
	    ServiceDAOFactory.getInstance().getSecurityDAO().addProfile(profileDTO);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[addProfile]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public void updateProfile(ProfileDTO profileDTO) throws Exception {
	try {
	    logger.log(Level.INFO, "::[updateProfile]::");
	    ServiceDAOFactory.getInstance().getSecurityDAO().updateProfile(profileDTO);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[updateProfile]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public ProfileDTO getProfileById(Long id) throws Exception {
	try {
	    logger.log(Level.INFO, "::[getProfileById]::");
	    return ServiceDAOFactory.getInstance().getSecurityDAO().getProfileById(id);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getProfileById]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public void deleteProfile(ProfileDTO profileDTO) throws Exception {
	try {
	    logger.log(Level.INFO, "::[deleteProfile]::");
	    ServiceDAOFactory.getInstance().getSecurityDAO().deleteProfile(profileDTO);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[deleteProfile]:: ERROR :" + ex);
	    throw new Exception(ex.getLocalizedMessage());
	}
    }

    @Override
    public List<ProfileDTO> getAllProfiles() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getAllProfiles]::");
	    return ServiceDAOFactory.getInstance().getSecurityDAO().getAllProfiles();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getAllProfiles]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public List<AbilityDTO> getAllAbilityes() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getAllAbilityes]::");
	    return ServiceDAOFactory.getInstance().getSecurityDAO().getAllAbilityes();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getAllAbilityes]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public List<FunctionalityModuleDTO> getAllModules() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getAllModules]::");
	    return ServiceDAOFactory.getInstance().getSecurityDAO().getAllModules();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getAllModules]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }
}
