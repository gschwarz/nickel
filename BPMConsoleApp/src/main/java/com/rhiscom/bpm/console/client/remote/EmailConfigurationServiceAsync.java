package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.EmailConfigurationDTO;
import com.rhiscom.bpm.console.shared.model.dto.RecipientsByEventDTO;

public interface EmailConfigurationServiceAsync {

    void saveOrUpdateConfiguration(EmailConfigurationDTO dto, AsyncCallback callBack);

    void getConfiguration(AsyncCallback<EmailConfigurationDTO> callBack) throws Exception;

    void saveOrUpdateRecipients(List<RecipientsByEventDTO> dto, AsyncCallback callBack);

    void getRecipientByEvent(String event, AsyncCallback<RecipientsByEventDTO> callBack);
}
