package com.rhiscom.bpm.console.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.POSProcessStatus;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface MonitoreoServiceAsync {

    void traerEstadoTodasLasTiendas(String usuario, AsyncCallback<List<POSProcessStatus>> callback)
	    throws IllegalArgumentException;

    void traerEstadoPorTienda(String tienda, String usuario, AsyncCallback<POSProcessStatus> callback)
	    throws IllegalArgumentException;

    void generarConsultaEstadoPorTienda(String tienda, String usuario, AsyncCallback callback);

    void generarConsultaEstadoTodasLasTiendas(String usuario, AsyncCallback callback);
}
