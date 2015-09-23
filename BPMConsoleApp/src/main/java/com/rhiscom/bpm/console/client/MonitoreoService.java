package com.rhiscom.bpm.console.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.POSProcessStatus;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("eventos")
public interface MonitoreoService extends RemoteService {
	List<POSProcessStatus> traerEstadoTodasLasTiendas(String usuario)
			throws IllegalArgumentException;

	POSProcessStatus traerEstadoPorTienda(String tienda, String usuario)
			throws IllegalArgumentException;

	void generarConsultaEstadoPorTienda(String tienda, String usuario);

	void generarConsultaEstadoTodasLasTiendas(String usuario);
}
