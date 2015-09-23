package com.rhiscom.bpm.console.server.services.listener;

import com.rhiscom.bpm.console.client.event.ATNEvent;
import com.rhiscom.bpm.console.client.event.ErrorEvent;
import com.rhiscom.bpm.console.client.event.HttpEventATN;
import com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent;
import com.rhiscom.bpm.console.client.event.TestCaseEvent;

public class EventListenerService {

    private static EventListenerService instance = null;

    public static EventListenerService getInstance() {

	if (instance == null)
	    instance = new EventListenerService();
	return instance;
    }

    public ATNEvent buildHttpATNEvent(HttpEventATN event) {

	if (event.getType().compareToIgnoreCase("STC_ATN_INIT") == 0) {
	    String message = event.getCode();
	    String[] messageArray = message.split(";");
	    String[] ids = messageArray[0].split("=");
	    String id = ids[1];

	    return new SuiteTestCaseEvent("STC_ATN_INIT", event.getName(), event.getAtnId(), id,
		    event.getEventDate());

	}

	if (event.getType().compareToIgnoreCase("STC_ATN_END") == 0) {
	    String message = event.getCode();
	    String[] messageArray = message.split(";");
	    String[] ids = messageArray[0].split("=");
	    String id = ids[1];

	    return new SuiteTestCaseEvent("STC_ATN_END", event.getName(), event.getAtnId(), id,
		    event.getEventDate());

	}

	if (event.getType().compareToIgnoreCase("TC_ATN_INIT") == 0) {
	    String message = event.getCode();
	    String[] messageArray = message.split(";");
	    String[] ids = messageArray[0].split("=");
	    String id = ids[1];

	    String[] stcids = messageArray[1].split("=");
	    String stcId = stcids[1];

	    String[] statusArray = messageArray[2].split("=");
	    String status = statusArray[1];
	    return new TestCaseEvent("TC_ATN_INIT", event.getName(), event.getAtnId(), Integer.valueOf(id)
		    .intValue(), stcId, event.getEventDate(), status);

	}

	if (event.getType().compareToIgnoreCase("TC_ATN_END") == 0) {
	    String message = event.getCode();
	    String[] messageArray = message.split(";");
	    String[] ids = messageArray[0].split("=");
	    String id = ids[1];

	    String[] stcids = messageArray[1].split("=");
	    String stcId = stcids[1];

	    String[] statusArray = messageArray[2].split("=");
	    String status = statusArray[1];

	    return new TestCaseEvent("TC_ATN_END", event.getName(), event.getAtnId(), Integer.valueOf(id)
		    .intValue(), stcId, event.getEventDate(), status);

	}
	return new ErrorEvent("MENSAJE_DESCONOCIDO :" + event.getType());
    }
}
