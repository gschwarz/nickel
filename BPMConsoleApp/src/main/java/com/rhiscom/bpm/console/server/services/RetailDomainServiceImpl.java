package com.rhiscom.bpm.console.server.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.RetailDomainService;
import com.rhiscom.bpm.console.server.services.dao.ServiceDAOFactory;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupLevelDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;

public class RetailDomainServiceImpl extends RemoteServiceServlet implements RetailDomainService {
    private static final Logger logger = Logger.getLogger(RetailDomainServiceImpl.class.getName());
    private static final long serialVersionUID = 1L;

    @Override
    public List<BusinessGroupLevelDTO> getBusinessGroupLevelAll() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getBusinessGroupLevelAll]::");
	    return ServiceDAOFactory.getInstance().getDomainDAO().getBusinessGroupLevelAll();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getBusinessGroupLevelAll]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public List<BusinessGroupDTO> getBusinessGroupAll() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getBusinessGroupAll]::");
	    return ServiceDAOFactory.getInstance().getDomainDAO().getBusinessGroupAll();
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getBusinessGroupAll]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public List<BusinessUnitDTO> getBusinessUnitAll() throws Exception {
	try {
	    logger.log(Level.INFO, "::[getBusinessUnitAll]::");
	    return ServiceDAOFactory.getInstance().getDomainDAO().getBusinessUnitAll();
	} catch (Exception ex) {
	    ex.printStackTrace();
	    logger.log(Level.SEVERE, "::[getBusinessUnitAll]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public BusinessGroupDTO getByIdBusinessGroup(Long id) throws Exception {
	try {
	    logger.log(Level.INFO, "::[getByIdBusinessGroup]::");
	    return ServiceDAOFactory.getInstance().getDomainDAO().getByIdBusinessGroup(id);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getByIdBusinessGroup]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public BusinessUnitDTO getByIdBusinessUnit(Long id) throws Exception {
	try {
	    logger.log(Level.INFO, "::[getByIdBusinessUnit]::");
	    return ServiceDAOFactory.getInstance().getDomainDAO().getByIdBusinessUnit(id);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[getByIdBusinessUnit]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public BusinessGroupDTO updateBusinessGroup(BusinessGroupDTO dto) throws Exception {
	try {
	    logger.log(Level.INFO, "::[updateBusinessGroup]::");
	    return ServiceDAOFactory.getInstance().getDomainDAO().updateBusinessGroup(dto);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[updateBusinessGroup]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public BusinessUnitDTO updateBusinessUnit(BusinessUnitDTO dto) throws Exception {
	try {
	    logger.log(Level.INFO, "::[updateBusinessUnit]::");
	    return ServiceDAOFactory.getInstance().getDomainDAO().updateBusinessUnit(dto);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[updateBusinessUnit]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public void addBusinessGroup(BusinessGroupDTO businessGroupDTO) throws Exception {
	try {
	    logger.log(Level.INFO, "::[addBusinessGroup]::");
	    ServiceDAOFactory.getInstance().getDomainDAO().addBusinessGroup(businessGroupDTO);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[addBusinessGroup]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

    @Override
    public void addBusinessUnit(BusinessUnitDTO businessUnitDTO) throws Exception {
	try {
	    logger.log(Level.INFO, "::[addBusinessUnit]::");
	    ServiceDAOFactory.getInstance().getDomainDAO().addBusinessUnit(businessUnitDTO);
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "::[addBuaddBusinessUnitsinessGroup]:: ERROR :" + ex);
	    throw new Exception(ex);
	}
    }

}
