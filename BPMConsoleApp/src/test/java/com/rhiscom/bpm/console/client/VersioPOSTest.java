package com.rhiscom.bpm.console.client;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.rhiscom.bpm.console.server.services.dao.QuadratureDAO;
import com.rhiscom.bpm.console.server.services.dao.ServiceDAOFactory;
import com.rhiscom.bpm.console.shared.model.dto.VersionDTO;

public class VersioPOSTest {

    @Test
    public void getAllVersions() {

	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	List<VersionDTO> result = dao.getAllVersionPOS();
	Assert.assertTrue(result.size() > 0);
    }

    @Test
    public void deleteVersion() {

	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();

	try {
	    dao.deleteVersion(1);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Test
    public void getVersionByDate() {
	Date date = new Date(2014 - 1900, 9, 15);
	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	Assert.assertNotNull(dao.getVersionByDate(""));

    }
}
