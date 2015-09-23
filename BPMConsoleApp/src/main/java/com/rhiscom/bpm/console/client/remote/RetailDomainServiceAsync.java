package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessGroupLevelDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;

public interface RetailDomainServiceAsync {

    public void getBusinessGroupLevelAll(AsyncCallback<List<BusinessGroupLevelDTO>> callback);

    public void getBusinessGroupAll(AsyncCallback<List<BusinessGroupDTO>> callback);

    public void getBusinessUnitAll(AsyncCallback<List<BusinessUnitDTO>> callback);

    public void getByIdBusinessGroup(Long id, AsyncCallback<BusinessGroupDTO> callback);

    public void getByIdBusinessUnit(Long id, AsyncCallback<BusinessUnitDTO> callback);

    public void updateBusinessGroup(BusinessGroupDTO dto, AsyncCallback<BusinessGroupDTO> callback);

    public void updateBusinessUnit(BusinessUnitDTO dto, AsyncCallback<BusinessUnitDTO> callback);

    public void addBusinessGroup(BusinessGroupDTO businessGroupDTO, AsyncCallback callback);

    public void addBusinessUnit(BusinessUnitDTO businessUnitDTO, AsyncCallback callback);

}
