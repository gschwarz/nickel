package com.rhiscom.bpm.console.server.services.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.rhiscom.bpm.console.server.model.entity.BusinessGroup;
import com.rhiscom.bpm.console.server.model.entity.BusinessGroupLevel;
import com.rhiscom.bpm.console.server.model.entity.BusinessUnit;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupLevelDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;

public class DomainDAOImpl implements DomainDAO {
    private EntityManager em;

    public DomainDAOImpl(EntityManager entityManager) {
	em = entityManager;

    }

    @Override
    public List<BusinessGroupLevelDTO> getBusinessGroupLevelAll() throws Exception {

	Query query = em.createQuery("SELECT bgl FROM BusinessGroupLevel bgl");
	@SuppressWarnings("unchecked")
	List<BusinessGroupLevel> list = (List<BusinessGroupLevel>) query.getResultList();
	List<BusinessGroupLevelDTO> resultListDTO = new ArrayList<BusinessGroupLevelDTO>();

	for (int i = 0; i <= list.size() - 1; i++) {

	    BusinessGroupLevelDTO businessGroupLevelDTO = new BusinessGroupLevelDTO(list.get(i)

	    .getIdLevelBusinessGroup(), list.get(i).getIdParentLevelBusinessGroup(), list.get(i)
		    .getNameLevelBusinessGroup(), list.get(i).getCreateStamp(), list.get(i).getLastUpdatedStamp());
	    resultListDTO.add(businessGroupLevelDTO);
	}

	return resultListDTO;
    }

    @Override
    public List<BusinessGroupDTO> getBusinessGroupAll() throws Exception {
	// TODO Auto-generated method stub

	Query query = em.createQuery("SELECT bg FROM BusinessGroup bg");

	@SuppressWarnings("unchecked")
	List<BusinessGroup> list = (List<BusinessGroup>) query.getResultList();

	List<BusinessGroupDTO> resultListDTO = new ArrayList<BusinessGroupDTO>();

	for (int i = 0; i <= list.size() - 1; i++) {

	    BusinessGroupDTO businessGroupDTOParent = null;

	    if (list.get(i).getParentBusinessGroup() != null) {
		businessGroupDTOParent = new BusinessGroupDTO(
			list.get(i).getParentBusinessGroup().getIdBusinessGroup(), list.get(i).getParentBusinessGroup()
				.getIdLevelBusinessGroup(),
			list.get(i).getParentBusinessGroup().getNameBusinessGroup(), list.get(i)
				.getParentBusinessGroup().getCreateStamp(), list.get(i).getParentBusinessGroup()
				.getLastUpdatedStamp(), list.get(i).getParentBusinessGroup().getStatus());
	    }
	    BusinessGroupDTO businessGroupDTO = new BusinessGroupDTO(list.get(i).getIdBusinessGroup(), list.get(i)
		    .getIdLevelBusinessGroup(), list.get(i).getNameBusinessGroup(), list.get(i).getCreateStamp(), list
		    .get(i).getLastUpdatedStamp(), list.get(i).getStatus());
	    businessGroupDTO.setParentBusinessGroup(businessGroupDTOParent);

	    resultListDTO.add(businessGroupDTO);
	}

	return resultListDTO;
    }

    @Override
    public List<BusinessUnitDTO> getBusinessUnitAll() throws Exception {
	Query query = em.createQuery("SELECT bu FROM BusinessUnit bu");
	@SuppressWarnings("unchecked")
	List<BusinessUnit> list = (List<BusinessUnit>) query.getResultList();
	List<BusinessUnitDTO> resultListDTO = new ArrayList<BusinessUnitDTO>();

	List<BusinessGroupDTO> listBusinessGroup = new ArrayList<BusinessGroupDTO>();

	listBusinessGroup = this.getBusinessGroupAll();

	for (int i = 0; i <= list.size() - 1; i++) {

	    BusinessUnitDTO businessUnitDTO = new BusinessUnitDTO(list.get(i).getIdBusinessUnit(), list.get(i)
		    .getIdBusinessGroup(), list.get(i).getNameBusinessUnit(), list.get(i).getCreateStamp(), list.get(i)
		    .getLastUpdatedStamp(), list.get(i).getStatus(), list.get(i).getCode());

	    for (int j = 0; j <= listBusinessGroup.size() - 1; j++) {
		if (listBusinessGroup.get(j).getIdBusinessGroup() == list.get(i).getIdBusinessGroup()) {
		    businessUnitDTO.setBusinessGroupName(listBusinessGroup.get(j).getNameBusinessGroup());
		    break;
		}
	    }

	    resultListDTO.add(businessUnitDTO);
	}

	return resultListDTO;
    }

    @Override
    public BusinessGroupDTO getByIdBusinessGroup(Long id) throws Exception {
	BusinessGroupDTO businessGroupDTOParent = null;

	BusinessGroup businessGroup = em.find(BusinessGroup.class, id);

	if (businessGroup.getParentBusinessGroup() != null) {
	    businessGroupDTOParent = new BusinessGroupDTO(businessGroup.getParentBusinessGroup().getIdBusinessGroup(),
		    businessGroup.getParentBusinessGroup().getIdLevelBusinessGroup(), businessGroup
			    .getParentBusinessGroup().getNameBusinessGroup(), businessGroup.getParentBusinessGroup()
			    .getCreateStamp(), businessGroup.getParentBusinessGroup().getLastUpdatedStamp(),
		    businessGroup.getParentBusinessGroup().getStatus());
	    System.out.println("PARENT :" + businessGroupDTOParent);
	}

	BusinessGroupDTO businessGroupDTO = new BusinessGroupDTO(businessGroup.getIdBusinessGroup(),
		businessGroup.getIdLevelBusinessGroup(), businessGroup.getNameBusinessGroup(),
		businessGroup.getCreateStamp(), businessGroup.getLastUpdatedStamp(), businessGroup.getStatus());
	businessGroupDTO.setParentBusinessGroup(businessGroupDTOParent);

	return businessGroupDTO;
    }

    @Override
    public BusinessUnitDTO getByIdBusinessUnit(Long id) throws Exception {

	BusinessUnit businessUnit = em.find(BusinessUnit.class, id);

	List<BusinessGroupDTO> listBusinessGroup = new ArrayList<BusinessGroupDTO>();

	listBusinessGroup = this.getBusinessGroupAll();

	BusinessUnitDTO businessUnitDTO = new BusinessUnitDTO(businessUnit.getIdBusinessUnit(),
		businessUnit.getIdBusinessGroup(), businessUnit.getNameBusinessUnit(), businessUnit.getCreateStamp(),
		businessUnit.getLastUpdatedStamp(), businessUnit.getStatus(), businessUnit.getCode());

	for (int j = 0; j <= listBusinessGroup.size() - 1; j++) {
	    if (listBusinessGroup.get(j).getIdBusinessGroup() == businessUnitDTO.getIdBusinessGroup()) {
		businessUnitDTO.setBusinessGroupName(listBusinessGroup.get(j).getNameBusinessGroup());
		break;
	    }
	}

	;
	return businessUnitDTO;

    }

    @Override
    public BusinessGroupDTO updateBusinessGroup(BusinessGroupDTO dto) {

	BusinessGroup businessGroup = new BusinessGroup(dto.getIdBusinessGroup(), dto.getIdLevelBusinessGroup(),
		dto.getNameBusinessGroup(), dto.getLastUpdatedStamp(), dto.getStatus());

	if (dto.getParentBusinessGroup() != null) {

	    BusinessGroup businessGroupParent = new BusinessGroup(dto.getParentBusinessGroup().getIdBusinessGroup(),
		    dto.getParentBusinessGroup().getIdLevelBusinessGroup(), dto.getParentBusinessGroup()
			    .getNameBusinessGroup(), dto.getParentBusinessGroup().getLastUpdatedStamp(), dto
			    .getParentBusinessGroup().getStatus());

	    businessGroup.setParentBusinessGroup(businessGroupParent);
	    businessGroup.setLastUpdatedStamp(new Date());
	}
	try {
	    em.getTransaction().begin();
	    em.merge(businessGroup);
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	BusinessGroup result = em.find(BusinessGroup.class, dto.getIdBusinessGroup());

	BusinessGroupDTO businessGroupDTOParent = new BusinessGroupDTO(result.getParentBusinessGroup()
		.getIdBusinessGroup(), result.getParentBusinessGroup().getIdLevelBusinessGroup(), result
		.getParentBusinessGroup().getNameBusinessGroup(), result.getParentBusinessGroup().getCreateStamp(),
		result.getParentBusinessGroup().getLastUpdatedStamp(), result.getParentBusinessGroup().getStatus());
	BusinessGroupDTO businessGroupDTO = new BusinessGroupDTO(result.getIdBusinessGroup(),
		result.getIdLevelBusinessGroup(), result.getNameBusinessGroup(), result.getCreateStamp(),
		result.getLastUpdatedStamp(), result.getStatus());
	businessGroupDTO.setParentBusinessGroup(businessGroupDTOParent);

	return businessGroupDTO;

    }

    @Override
    public BusinessUnitDTO updateBusinessUnit(BusinessUnitDTO dto) throws Exception {

	BusinessUnit businessUnit = new BusinessUnit(dto.getIdBusinessUnit(), dto.getIdBusinessGroup(),
		dto.getNameBusinessUnit(), dto.getCreateStamp(), dto.getLastUpdatedStamp(), dto.getStatus(),
		dto.getCode());
	businessUnit.setLastUpdatedStamp(new Date());
	try {
	    em.getTransaction().begin();
	    em.merge(businessUnit);
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	BusinessUnit result = em.find(BusinessUnit.class, dto.getIdBusinessUnit());

	return new BusinessUnitDTO(result.getIdBusinessUnit(), result.getIdBusinessGroup(),
		result.getNameBusinessUnit(), result.getCreateStamp(), result.getLastUpdatedStamp(),
		result.getStatus(), result.getCode());
    }

    @Override
    public void addBusinessGroup(BusinessGroupDTO businessGroupDTO) throws Exception {

	BusinessGroup businessGroup = new BusinessGroup(businessGroupDTO.getIdLevelBusinessGroup(),
		businessGroupDTO.getNameBusinessGroup(), businessGroupDTO.getCreateStamp(),
		businessGroupDTO.getStatus());

	if (businessGroupDTO.getParentBusinessGroup() != null) {
	    BusinessGroup businessGroupParent = new BusinessGroup(businessGroupDTO.getParentBusinessGroup()
		    .getIdBusinessGroup(), businessGroupDTO.getParentBusinessGroup().getIdLevelBusinessGroup(),
		    businessGroupDTO.getParentBusinessGroup().getNameBusinessGroup(), businessGroupDTO
			    .getParentBusinessGroup().getCreateStamp(), businessGroupDTO.getParentBusinessGroup()
			    .getStatus());

	    businessGroup.setParentBusinessGroup(businessGroupParent);
	    businessGroup.setCreateStamp(new Date());
	}
	try {
	    em.getTransaction().begin();
	    em.persist(businessGroup);
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

    }

    @Override
    public void addBusinessUnit(BusinessUnitDTO businessUnitDTO) throws Exception {

	BusinessUnit businessUnit = new BusinessUnit(businessUnitDTO.getIdBusinessGroup(),
		businessUnitDTO.getNameBusinessUnit(), businessUnitDTO.getCreateStamp(), businessUnitDTO.getStatus(),
		businessUnitDTO.getCode());
	businessUnit.setCreateStamp(new Date());
	try {
	    em.getTransaction().begin();
	    em.persist(businessUnit);
	    em.getTransaction().commit();

	} catch (Exception ex) {
	    ex.printStackTrace();
	}

    }

}
