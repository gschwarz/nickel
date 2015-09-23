package com.rhiscom.bpm.console.server.services.listener;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rhiscom.bpm.console.client.event.ATNEvent;
import com.rhiscom.bpm.console.client.event.HttpEventATN;
import com.rhiscom.bpm.console.server.ServerMessageGeneratorServiceImpl;
import com.rhiscom.bpm.console.server.services.CompleteServlet;

public class HttpEventListenerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	String eventType = req.getParameter("eventType");
	String atnId = req.getParameter("atnId");
	String name = req.getParameter("name");
	String date = req.getParameter("statusDate");
	String code = req.getParameter("code");

	System.out.println(":: SERVLET LISTENER eventType :" + eventType);
	System.out.println(":: SERVLET LISTENER atnId :" + atnId);
	System.out.println(":: SERVLET LISTENER fecha :" + date);
	System.out.println(":: SERVLET LISTENER code :" + code);
	System.out.println(":: SERVLET LISTENER name :" + name);

	HttpEventATN httpEvent = null;

	Date datetime;

	datetime = new Date(Long.valueOf(date).longValue());
	httpEvent = new HttpEventATN(eventType, name, atnId, datetime, code);

	ATNEvent event = EventListenerService.getInstance().buildHttpATNEvent(httpEvent);
	ServerMessageGeneratorServiceImpl server = ServerMessageGeneratorServiceImpl.getInstance();
	server.sendEvent(event);
	CompleteServlet complete = new CompleteServlet();
	complete.completeEvent(event);
    }

}
