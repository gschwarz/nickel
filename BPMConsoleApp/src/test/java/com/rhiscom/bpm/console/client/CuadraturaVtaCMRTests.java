package com.rhiscom.bpm.console.client;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.rhiscom.bpm.console.server.services.dao.QuadratureDAO;
import com.rhiscom.bpm.console.server.services.dao.ServiceDAOFactory;

public class CuadraturaVtaCMRTests {

    @Test
    public void getCuadraturaVtaCMR() {

	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	Date date = new Date(2013 - 1900, 0, 3);
	Assert.assertNotNull(dao.getCuadraturaVtaCMR("", 905));

    }

}