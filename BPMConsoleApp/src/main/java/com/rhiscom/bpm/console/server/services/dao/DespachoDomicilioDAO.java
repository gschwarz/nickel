package com.rhiscom.bpm.console.server.services.dao;

import com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO;

public interface DespachoDomicilioDAO {

    VentaDomicilioDTO traerVentaPorId(long idVenta) throws Exception;

}
