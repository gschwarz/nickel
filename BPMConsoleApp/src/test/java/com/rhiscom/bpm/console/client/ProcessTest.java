package com.rhiscom.bpm.console.client;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rhiscom.bpm.console.server.services.ProcessServiceImpl;

public class ProcessTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getHistoryProcess() {
	ProcessServiceImpl service = new ProcessServiceImpl();
	try {
	    service.getProcessHistory();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public void getProcessInstances() {
	ProcessServiceImpl service = new ProcessServiceImpl();
	try {
	    service.getTotalInstancesInExecution();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void getProcessLog() {
	ProcessServiceImpl service = new ProcessServiceImpl();
	try {
	    service.getInstancesLog();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
