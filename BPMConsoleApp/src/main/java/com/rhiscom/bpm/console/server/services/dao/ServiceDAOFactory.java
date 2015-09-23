package com.rhiscom.bpm.console.server.services.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServiceDAOFactory {
    private static ServiceDAOFactory instance = null;
    private static EntityManagerFactory entityManagerFactory;

    private static EntityManagerFactory entityManagerFactoryProcess;
    private static EntityManager entityManager;

    private static EntityManager entityManagerProcess;

    private ServiceDAOFactory() {
	entityManagerFactory = Persistence.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
	entityManager = entityManagerFactory.createEntityManager();

	entityManagerFactoryProcess = Persistence.createEntityManagerFactory("ProcessPersistenceUnit");
	entityManagerProcess = entityManagerFactoryProcess.createEntityManager();
    }

    private EntityManager getConfigurationConsoleEntityManager() {

	return entityManager;
    }

    private EntityManager getProcessManagementEntityManager() {

	return entityManagerProcess;
    }

    public static ServiceDAOFactory getInstance() {
	if (instance == null)
	    instance = new ServiceDAOFactory();
	return instance;
    }

    public DomainDAO getDomainDAO() {

	return new DomainDAOImpl(getConfigurationConsoleEntityManager());
    }

    public UserDAO getUserDAO() {

	return new UserDAOImpl(getConfigurationConsoleEntityManager());
    }

    public ResolverGroupsDAO getResolverGroupsDAO() {

	return new ResolverGroupsImpl(getConfigurationConsoleEntityManager());
    }

    public SecurityDAO getSecurityDAO() {

	return new SecurityDAOImpl(getConfigurationConsoleEntityManager());
    }

    public ProcessDAO getProcessDAO() {

	return new ProcessDAOImpl(getConfigurationConsoleEntityManager());
    }

    public QuadratureDAO getQuadratureDAO() {

	return new QuadratureDAOImpl(getConfigurationConsoleEntityManager());
    }

}
