package com.rhiscom.bpm.console.client.remote;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO;

@RemoteServiceRelativePath("despachoDomicilioService")
public interface DespachoDomicilioService extends RemoteService {

    VentaDomicilioDTO traerVentaPorId(long idVenta) throws Exception;

}
