package com.rhiscom.bpm.console.server.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.rhiscom.bpm.console.server.model.entity.ResolverGroup;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;

public class ResolverGroupsImpl implements ResolverGroupsDAO {
    private EntityManager em;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ResolverGroupsImpl(EntityManager entityManager) {
	em = entityManager;
    }

    @Override
    public void addResolutionGroup(ResolverGroupDTO resolverGroupDTO) throws Exception {

	ResolverGroup resolverGroup = new ResolverGroup(resolverGroupDTO.getName(), resolverGroupDTO.getDescription());

	try {

	    em.getTransaction().begin();
	    em.persist(resolverGroup);
	    em.getTransaction().commit();
	    this.addResolverGroup(resolverGroupDTO.getName());

	} catch (javax.persistence.PersistenceException e) {
	    throw new Exception("PERSISTENCE");

	} catch (Exception ex) {
	    ex.printStackTrace();

	} finally {

	}

    }

    @Override
    public List<ResolverGroupDTO> getAll() throws Exception {

	Query query = em.createQuery("SELECT r FROM ResolverGroup r");

	List<ResolverGroup> listResolver = null;
	List<ResolverGroupDTO> resultListDTO = null;
	try {

	    listResolver = (List<ResolverGroup>) query.getResultList();

	    if (listResolver != null) {
		resultListDTO = new ArrayList<ResolverGroupDTO>();

		for (int i = 0; i <= listResolver.size() - 1; i++) {

		    ResolverGroupDTO resolverGroupDTO = new ResolverGroupDTO(listResolver.get(i).getWorkGroupId(),
			    listResolver.get(i).getName(), listResolver.get(i).getDescription());
		    resultListDTO.add(resolverGroupDTO);

		}
	    }
	} catch (javax.persistence.PersistenceException e) {
	    throw new Exception("PERSISTENCE");

	} catch (Exception ex) {
	    ex.printStackTrace();
	    em.getTransaction().rollback();
	} finally {

	}
	return resultListDTO;

    }

    @Override
    public ResolverGroupDTO getById(Long id) throws Exception {

	try {
	    ResolverGroup resolverGroup = em.find(ResolverGroup.class, id);
	    ResolverGroupDTO resolverGroupDTO = new ResolverGroupDTO(resolverGroup.getWorkGroupId(),
		    resolverGroup.getName(), resolverGroup.getDescription());
	    return resolverGroupDTO;
	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();
	    throw new Exception("PERSISTENCE");

	} catch (Exception ex) {
	    ex.printStackTrace();
	    em.getTransaction().rollback();
	    throw new Exception(ex);
	} finally {

	}
    }

    @Override
    public ResolverGroupDTO update(ResolverGroupDTO dto) throws Exception {

	ResolverGroup resolverGroup = new ResolverGroup(dto.getWorkGroupid(), dto.getName(), dto.getDescription());

	try {
	    em.getTransaction().begin();
	    em.merge(resolverGroup);
	    em.getTransaction().commit();
	    ResolverGroup result = em.find(ResolverGroup.class, dto.getWorkGroupid());
	    return new ResolverGroupDTO(result.getWorkGroupId(), result.getName(), result.getDescription());
	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();
	    throw new Exception("PERSISTENCE");

	} catch (Exception ex) {
	    ex.printStackTrace();
	    em.getTransaction().rollback();
	    throw new Exception(ex);
	} finally {

	}
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ResolverGroupDTO> getAllOK() throws Exception {

	try {
	    Query query = em.createQuery("SELECT r FROM ResolverGroup r");
	    List<ResolverGroup> list = (List<ResolverGroup>) query.getResultList();

	    List<ResolverGroupDTO> resultListDTO = new ArrayList<ResolverGroupDTO>();

	    for (int i = 0; i <= list.size() - 1; i++) {

		ResolverGroupDTO resolverGroupDTO = new ResolverGroupDTO(list.get(i).getWorkGroupId(), list.get(i)
			.getName(), list.get(i).getDescription());
		resultListDTO.add(resolverGroupDTO);

	    }

	    return resultListDTO;
	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();
	    throw new Exception(e);

	} catch (Exception ex) {
	    ex.printStackTrace();
	    em.getTransaction().rollback();
	    throw new Exception(ex);
	} finally {

	}
    }

    @Override
    public void deleteResolverGroup(ResolverGroupDTO resolverGroupDTO) throws Exception {

	ResolverGroup resolverGroup = new ResolverGroup(resolverGroupDTO.getWorkGroupid(), resolverGroupDTO.getName(),
		resolverGroupDTO.getDescription());

	try {
	    em.getTransaction().begin();

	    Query q = em.createNativeQuery("delete from operator_workgroup where workGroupId = :workGroupId");
	    q.setParameter("workGroupId", resolverGroup.getWorkGroupId());
	    q.executeUpdate();

	    em.remove(em.merge(resolverGroup));
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new Exception(ex);
	} finally {

	}
    }

    public void addResolverGroup(String group) {

	String sDriver = "com.mysql.jdbc.Driver";
	String sURL = "jdbc:mysql://localhost:3306/bpm_task";
	Connection con = null;
	try {
	    Class.forName(sDriver).newInstance();
	} catch (InstantiationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	try {
	    con = DriverManager.getConnection(sURL, "root", "rhiscom");
	    Statement stmt = con.createStatement();
	    String insert = "INSERT INTO organizationalentity  (DTYPE, id) VALUES ('Group','" + group + "')";

	    stmt = con.createStatement();
	    stmt.executeUpdate(insert);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
