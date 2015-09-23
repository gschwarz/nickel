package com.rhiscom.bpm.console.client;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rhiscom.bpm.console.server.services.ResolverGroupsServiceImpl;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;

public class ResolverGroupsServiceTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAddResolutionGroups() {
	ResolverGroupDTO dto = new ResolverGroupDTO();

	dto.setDescription("hola");
	dto.setName("prueba");

	ResolverGroupsServiceImpl service = new ResolverGroupsServiceImpl();
	try {
	    service.addResolutionGroup(dto);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Test
    public void getAll() {

	ResolverGroupsServiceImpl service = new ResolverGroupsServiceImpl();
	try {
	    Assert.assertTrue(service.getAll().size() > 0);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Test
    public void getAllOK() {

	ResolverGroupsServiceImpl service = new ResolverGroupsServiceImpl();
	try {
	    Assert.assertTrue(service.getAllOK().size() > 0);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Test
    public void getById() {

	ResolverGroupsServiceImpl service = new ResolverGroupsServiceImpl();
	try {
	    Assert.assertNotNull(service.getById(new Long(1)));

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Test
    public void edit() {

	ResolverGroupsServiceImpl service = new ResolverGroupsServiceImpl();
	try {
	    // Assert.assertNotNull(service.getById(new Long(1)));
	    ResolverGroupDTO dto = new ResolverGroupDTO(new Long(3), "Pricing", "Dpto pricing");
	    service.update(dto);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}
