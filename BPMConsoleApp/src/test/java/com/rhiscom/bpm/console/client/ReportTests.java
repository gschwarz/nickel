package com.rhiscom.bpm.console.client;

import org.junit.Test;

import com.rhiscom.bpm.console.server.services.ReportServiceImpl;

public class ReportTests {

    @Test
    public void getAllAtnPlans()

    {
	ReportServiceImpl s = new ReportServiceImpl();
	s.getAllPlansATN();
    }
}
