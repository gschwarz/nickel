package com.rhiscom.bpm.console.server.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.ResolverGroupsService;
import com.rhiscom.bpm.console.server.services.dao.ServiceDAOFactory;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;

public class ResolverGroupsServiceImpl extends RemoteServiceServlet implements ResolverGroupsService {
    private static final Logger logger = Logger.getLogger(ResolverGroupsServiceImpl.class.getName());
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void addResolutionGroup(ResolverGroupDTO resolverGroupDTO) throws Exception {

	try {
	    logger.log(Level.INFO, "::[addResolutionGroup]::");
	    ServiceDAOFactory.getInstance().getResolverGroupsDAO().addResolutionGroup(resolverGroupDTO);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[addResolutionGroup]:: ERROR :" + ex);
	    throw new Exception(ex);
	}

    }

    @Override
    public List<ResolverGroupDTO> getAll() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getAll]::");
	    return ServiceDAOFactory.getInstance().getResolverGroupsDAO().getAll();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getAll]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public ResolverGroupDTO getById(Long id) throws Exception {
	try {
	    logger.log(Level.INFO, "::[getById]::");
	    return ServiceDAOFactory.getInstance().getResolverGroupsDAO().getById(id);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getById]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public ResolverGroupDTO update(ResolverGroupDTO dto) throws Exception {

	try {
	    logger.log(Level.INFO, "::[getById]::");
	    return ServiceDAOFactory.getInstance().getResolverGroupsDAO().update(dto);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getById]:: ERROR :" + ex);
	    throw new Exception(ex);
	}

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ResolverGroupDTO> getAllOK() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getAllOK]::");
	    return ServiceDAOFactory.getInstance().getResolverGroupsDAO().getAllOK();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getAllOK]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public void deleteResolverGroup(ResolverGroupDTO resolverGroupDTO) throws Exception {

	try {
	    logger.log(Level.INFO, "::[deleteResolverGroup]::");
	    ServiceDAOFactory.getInstance().getResolverGroupsDAO().deleteResolverGroup(resolverGroupDTO);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[deleteResolverGroup]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }
}
