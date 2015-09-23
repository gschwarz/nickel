package com.rhiscom.bpm.console.server.services.dao;

import java.util.List;

import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupLevelDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;

public interface DomainDAO {

    List<BusinessGroupLevelDTO> getBusinessGroupLevelAll() throws Exception;

    public List<BusinessGroupDTO> getBusinessGroupAll() throws Exception;

    public List<BusinessUnitDTO> getBusinessUnitAll() throws Exception;

    public BusinessGroupDTO getByIdBusinessGroup(Long id) throws Exception;

    public BusinessUnitDTO getByIdBusinessUnit(Long id) throws Exception;

    public BusinessGroupDTO updateBusinessGroup(BusinessGroupDTO dto) throws Exception;

    public BusinessUnitDTO updateBusinessUnit(BusinessUnitDTO dto) throws Exception;

    public void addBusinessGroup(BusinessGroupDTO businessGroupDTO) throws Exception;

    public void addBusinessUnit(BusinessUnitDTO businessUnitDTO) throws Exception;

}
