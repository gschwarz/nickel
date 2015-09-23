package com.rhiscom.bpm.console.server.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.UserService;
import com.rhiscom.bpm.console.server.model.entity.AccessProfileFunctionalityAbility;
import com.rhiscom.bpm.console.server.services.dao.ServiceDAOFactory;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

/**
 * Servicio que maneja los usuarios en el sistema.
 * 
 * @author Pablo Cáceres
 * 
 */
public class UserServiceImpl extends RemoteServiceServlet implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    private static final long serialVersionUID = 1L;

    /**
     * Método que retorna todos los operadores existentes.
     */
    @Override
    public List<OperatorDTO> getAllOperator() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getAllOperator]::");
	    return ServiceDAOFactory.getInstance().getUserDAO().getAllOperator();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getAllOperator]:: ERROR :" + ex);
	    ex.printStackTrace();
	    throw new Exception(ex);
	}
    }

    private Set<AccessProfileFunctionalityAbility> getAccessByProfile(
	    Set<AccessProfileFunctionalityAbility> accesslist, long profileId) {
	Set<AccessProfileFunctionalityAbility> result = new HashSet<AccessProfileFunctionalityAbility>();

	for (int i = 0; i <= accesslist.size(); i++) {

	    for (Iterator<AccessProfileFunctionalityAbility> iterator = accesslist.iterator(); iterator.hasNext();) {
		AccessProfileFunctionalityAbility access = iterator.next();
		if (access.getSegProfileId() == profileId) {
		    result.add(access);
		}

	    }

	}
	return result;

    }

    /**
     * Método que retorna un operador según su id.
     */
    @Override
    public OperatorDTO getById(Long id) throws Exception {

	try {
	    logger.log(Level.INFO, "::[getById]::");
	    return ServiceDAOFactory.getInstance().getUserDAO().getById(id);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getById]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    /**
     * método que agrega un operador.
     */
    @Override
    public void addOperator(OperatorDTO operatorDTO) throws Exception {
	try {
	    logger.log(Level.INFO, "::[addOperator]::");
	    ServiceDAOFactory.getInstance().getUserDAO().addOperator(operatorDTO);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[addOperator]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    /**
     * Método que edita un operador.
     */
    @Override
    public OperatorDTO editOperator(OperatorDTO operatorDTO) throws Exception {
	try {
	    logger.log(Level.INFO, "::[editOperator]::");
	    return ServiceDAOFactory.getInstance().getUserDAO().editOperator(operatorDTO);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[editOperator]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    /**
     * Método que elimina un operador.
     */
    @Override
    public void deleteOperator(OperatorDTO operatorDTO) throws Exception {
	try {
	    logger.log(Level.INFO, "::[deleteOperator]::");
	    ServiceDAOFactory.getInstance().getUserDAO().deleteOperator(operatorDTO);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[deleteOperator]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public OperatorDTO searchOperator(String user) throws Exception {
	try {
	    logger.log(Level.INFO, "::[searchOperator]::");
	    return ServiceDAOFactory.getInstance().getUserDAO().searchOperator(user);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[searchOperator]:: ERROR :" + ex);
	    throw new Exception(ex);
	}

    }

}
