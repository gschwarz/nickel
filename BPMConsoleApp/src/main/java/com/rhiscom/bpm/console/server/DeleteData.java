package com.rhiscom.bpm.console.server;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteData() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {

	String businessDate = request.getParameter("businessDate");

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	EntityManager em = emf.createEntityManager();
	String deleteQuery = "delete from PSDEBEntity where fechaTrx <'" + businessDate + "'";
	Query query = em.createQuery(deleteQuery);
	em.getTransaction().begin();
	query.executeUpdate();
	em.getTransaction().commit();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	    IOException {

	this.processRequest(request, response);
    }

}
