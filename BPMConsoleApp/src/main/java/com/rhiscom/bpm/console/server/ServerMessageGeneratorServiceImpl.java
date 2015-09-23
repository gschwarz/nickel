/*
 * GWTEventService
 * Copyright (c) 2011 and beyond, strawbill UG (haftungsbeschränkt)
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 * Other licensing for GWTEventService may also be possible on request.
 * Please view the license.txt of the project for more information.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.rhiscom.bpm.console.server;

import com.rhiscom.bpm.console.client.ServerMessageGeneratorService;
import com.rhiscom.bpm.console.client.event.ATNEvent;
import com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent;
import com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent;
import com.rhiscom.bpm.console.client.event.TestCaseEvent;
import com.rhiscom.bpm.console.shared.model.EventoConsultaTienda;

import de.novanic.eventservice.client.event.Event;
import de.novanic.eventservice.service.RemoteEventServiceServlet;

/**
 * @author sstrohschein <br>
 *         Date: 19.02.2010 <br>
 *         Time: 23:21:42
 */
public class ServerMessageGeneratorServiceImpl extends RemoteEventServiceServlet implements
	ServerMessageGeneratorService {

    private static ServerMessageGeneratorServiceImpl instance = null;

    public ServerMessageGeneratorServiceImpl() {

    }

    public static ServerMessageGeneratorServiceImpl getInstance() {
	if (instance == null)
	    instance = new ServerMessageGeneratorServiceImpl();

	return instance;

    }

    public void sendEvent(String event) {

	Event theEvent = new ServerGeneratedMessageEvent(event);
	// add the event, so clients can receive it
	addEvent(ServerGeneratedMessageEvent.SERVER_MESSAGE_DOMAIN, theEvent);

    }

    public void sendEvent(EventoConsultaTienda event) {

	Event theEvent = new ServerGeneratedMessageEvent(event);
	// add the event, so clients can receive it
	addEvent(ServerGeneratedMessageEvent.SERVER_MESSAGE_DOMAIN, theEvent);

    }

    public void sendEvent(ATNEvent event) {

	if (event instanceof SuiteTestCaseEvent) {
	    SuiteTestCaseEvent stc = (SuiteTestCaseEvent) event;
	    Event theEvent = new ServerGeneratedMessageEvent(stc);
	    // add the event, so clients can receive it
	    addEvent(ServerGeneratedMessageEvent.SERVER_MESSAGE_DOMAIN, theEvent);
	}

	if (event instanceof TestCaseEvent) {
	    TestCaseEvent tc = (TestCaseEvent) event;
	    Event theEvent = new ServerGeneratedMessageEvent(tc);
	    // add the event, so clients can receive it
	    addEvent(ServerGeneratedMessageEvent.SERVER_MESSAGE_DOMAIN, theEvent);
	}

    }

}