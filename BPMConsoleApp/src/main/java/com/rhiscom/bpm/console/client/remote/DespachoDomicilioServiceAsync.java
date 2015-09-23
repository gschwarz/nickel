package com.rhiscom.bpm.console.client.remote;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO;

public interface DespachoDomicilioServiceAsync {

    public void traerVentaPorId(long idVenta, AsyncCallback<VentaDomicilioDTO> async) throws Exception;
}
