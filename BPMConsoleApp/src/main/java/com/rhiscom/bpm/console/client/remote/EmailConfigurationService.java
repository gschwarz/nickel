package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO;
import com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO;

@RemoteServiceRelativePath("emailConfigurationService")
public interface EmailConfigurationService extends RemoteService {

    void saveOrUpdateConfiguration(EmailConfigurationDTO dto);

    EmailConfigurationDTO getConfiguration() throws Exception;

    void saveOrUpdateRecipients(List<RecipientsByEventDTO> dto);

    RecipientsByEventDTO getRecipientByEvent(String event);

}
