package com.rhiscom.bpm.console.server.services;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.shared.model.dto.ControllerDTO;

/**
 * Servlet que tiene la lógica de negocio del subsistema funcional VIGIA.
 * 
 * @author Pablo Cáceres.
 * 
 */
public class VigiaServiceImpl extends RemoteServiceServlet implements VigiaService {

    @Override
    public void crearController(ControllerDTO controllerDTO) {
	// TODO Auto-generated method stub

    }

    @Override
    public ControllerDTO actualizarController(ControllerDTO controllerDTO) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ControllerDTO> traerControlladoresVigentes() {
	// TODO Auto-generated method stub
	return null;
    }

    /*
     * private static final long serialVersionUID = 1L;
     * 
     * public void crearController(ControllerDTO controllerDTO) { ControllerDAO
     * controllerDAO = new ControllerDAO();
     * controllerDAO.ingresar(controllerDTO);
     * 
     * }
     * 
     * public ControllerDTO actualizarController(ControllerDTO controllerDTO) {
     * ControllerDAO controllerDAO = new ControllerDAO(); return
     * controllerDAO.actualizar(controllerDTO);
     * 
     * }
     * 
     * public List<ControllerDTO> traerControlladoresVigentes() { ControllerDAO
     * controllerDAO = new ControllerDAO(); return
     * controllerDAO.traerControlladoresVigentes(); }
     */
}
