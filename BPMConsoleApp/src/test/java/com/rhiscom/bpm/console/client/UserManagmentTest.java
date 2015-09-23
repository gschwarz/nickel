package com.rhiscom.bpm.console.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rhiscom.bpm.console.server.services.ResolverGroupsServiceImpl;
import com.rhiscom.bpm.console.server.services.SecurityServiceImpl;
import com.rhiscom.bpm.console.server.services.UserServiceImpl;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.PersonDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.WorkerDTO;

public class UserManagmentTest {

    protected EntityManagerFactory emf;

    protected EntityManager em;

    @Before
    public void antesDeCadaTest() {
	emf = Persistence.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	em = emf.createEntityManager();
    }

    @After
    public void despuesDeCadaTest() {
	em.close();
	emf.close();
    }

    @Test
    public void createUser() {

	try {

	    SecurityServiceImpl security = new SecurityServiceImpl();
	    ProfileDTO profile = security.getProfileById(new Long(1));
	    List<ProfileDTO> profileList = new ArrayList<ProfileDTO>();
	    profileList.add(profile);
	    ResolverGroupsServiceImpl service = new ResolverGroupsServiceImpl();

	    Set<ResolverGroupDTO> list = new HashSet<ResolverGroupDTO>();

	    list.addAll(service.getAll());

	    UserServiceImpl userService = new UserServiceImpl();

	    PersonDTO p = new PersonDTO("1", "15355600as", "Marcos", "Antonio", "Ribo", new Long(1),
		    "marcoantonio@gmail.com");
	    WorkerDTO k = new WorkerDTO(p);

	    OperatorDTO operatorDTO = new OperatorDTO("mriboass", "mriborr", list, k, new Date(), profile);

	    userService.addOperator(operatorDTO);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Test
    public void editUser() {
	try {
	    UserServiceImpl userService = new UserServiceImpl();
	    SecurityServiceImpl security = new SecurityServiceImpl();
	    ProfileDTO profile = security.getProfileById(new Long(2));
	    List<ProfileDTO> profileList = new ArrayList<ProfileDTO>();
	    profileList.add(profile);
	    ResolverGroupsServiceImpl service = new ResolverGroupsServiceImpl();

	    Set<ResolverGroupDTO> list = new HashSet<ResolverGroupDTO>();

	    list.addAll(service.getAll());

	    Set<ResolverGroupDTO> listNuevo = new HashSet<ResolverGroupDTO>();
	    for (int i = 0; i <= 2; i++) {
		listNuevo.add(service.getAll().get(i));

	    }

	    OperatorDTO op = new OperatorDTO();
	    op = userService.getById(new Long(14));
	    op.setWorkGroups(new HashSet<ResolverGroupDTO>(listNuevo));

	    op.setProfileDTO(profile);

	    userService.editOperator(op);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Test
    public void getUser() {
	UserServiceImpl userService = new UserServiceImpl();
	try {

	    OperatorDTO dto = userService.getById(new Long(3));
	    System.out.println("OP :" + dto.getUser());
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Test
    public void getAllOperator() {
	UserServiceImpl userService = new UserServiceImpl();
	try {
	    Assert.assertTrue(userService.getAllOperator().size() > 0);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Test
    public void deleteUser() {

	try {

	    SecurityServiceImpl security = new SecurityServiceImpl();
	    ProfileDTO profile = security.getProfileById(new Long(18));
	    List<ProfileDTO> profileList = new ArrayList<ProfileDTO>();
	    profileList.add(profile);

	    UserServiceImpl userService = new UserServiceImpl();

	    ResolverGroupsServiceImpl service = new ResolverGroupsServiceImpl();

	    Set<ResolverGroupDTO> list = new HashSet<ResolverGroupDTO>();

	    list.addAll(service.getAll());

	    PersonDTO p = new PersonDTO("1", "8888888888", "8888888888", "8888888888", "8888888888", new Long(3),
		    "pcaceresferreira@gmail.com");

	    p.setPersonId(new Long(16));
	    WorkerDTO k = new WorkerDTO(p);
	    k.setWorkerId(new Long(16));

	    OperatorDTO op = new OperatorDTO("pcaceres", "8888888888", list, k, new Date(), profile);
	    op.setOperatorId(new Long(15));
	    userService.deleteOperator(op);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Test
    public void searchUser() {
	UserServiceImpl userService = new UserServiceImpl();
	try {
	    OperatorDTO op = userService.searchOperator("pcaceres");
	    System.out.println("OP :" + op.getUser());
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}
