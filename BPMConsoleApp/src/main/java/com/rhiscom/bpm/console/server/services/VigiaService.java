package com.rhiscom.bpm.console.server.services;

import java.util.List;

import com.rhiscom.bpm.console.shared.model.dto.ControllerDTO;

/**
 * Interface del servicio VigiaService.
 * 
 * @author Pablo Cáceres
 * 
 */
public interface VigiaService {

    public void crearController(ControllerDTO controllerDTO);

    public ControllerDTO actualizarController(ControllerDTO controllerDTO);

    public List<ControllerDTO> traerControlladoresVigentes();
}
