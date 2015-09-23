package com.rhiscom.bpm.console.server.services.listener;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rhiscom.bpm.console.server.RequestMapper;
import com.rhiscom.bpm.console.server.ServerMessageGeneratorServiceImpl;
import com.rhiscom.bpm.console.shared.model.EventoConsultaTienda;
import com.rhiscom.bpm.console.shared.model.Peticion;

public class EventListenerServlet extends HttpServlet {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	ServerMessageGeneratorServiceImpl server = ServerMessageGeneratorServiceImpl.getInstance();

	String trx = req.getParameter("transaccion");
	String fecha = req.getParameter("fechaConsulta");
	String usuario = req.getParameter("usuario");
	String todasLasTiendas = req.getParameter("todasLasTiendas");
	String numeroTienda = req.getParameter("numeroTienda");

	System.out.println(":: SERVLET LISTENER TRX :" + trx);
	System.out.println(":: SERVLET LISTENER usuario :" + usuario);
	System.out.println(":: SERVLET LISTENER fecha :" + fecha);
	System.out.println(":: SERVLET LISTENER todasLasTiendas :" + todasLasTiendas);
	System.out.println(":: SERVLET LISTENER numeroTienda :" + numeroTienda);

	RequestMapper mapper = RequestMapper.getInstance();

	Map<String, Map<String, Peticion>> peticiones = mapper.getPeticion();
	System.out.println(":: SERVLET LISTENER PETICIONES :" + peticiones);
	if (peticiones.containsKey(usuario)) {

	    if (peticiones.get(usuario).containsKey("045")) {

		Peticion p = peticiones.get(usuario).get("045");

		if (todasLasTiendas.compareTo("false") == 0) {
		    EventoConsultaTienda evento = new EventoConsultaTienda();
		    evento.setTienda(numeroTienda);
		    evento.setTiendaEnConjunto("false");
		    evento.setUsuario(usuario);
		    evento.setFechaConsulta(fecha);

		    server.sendEvent(evento);
		} else {
		    System.out.println(":: SERVLET LISTENER EVENTO TODAS LAS TIENDAS ES TRUE");
		    EventoConsultaTienda evento = new EventoConsultaTienda();
		    evento.setTienda(numeroTienda);
		    evento.setTiendaEnConjunto("true");
		    evento.setUsuario(usuario);
		    System.out.println(":: SERVLET LISTENER EVENTO :" + evento.getTiendaEnConjunto());
		    evento.setFechaConsulta(fecha);
		    server.sendEvent(evento);
		}
		// peticiones.get(usuario).remove("045");
	    }
	}

    }

}
