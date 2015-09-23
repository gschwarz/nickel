package com.rhiscom.bpm.console.server.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.bpm.console.server.model.entity.AccessProfileFunctionalityAbility;
import com.rhiscom.bpm.console.server.model.entity.BusinessUnit;
import com.rhiscom.bpm.console.server.model.entity.Operator;
import com.rhiscom.bpm.console.server.model.entity.OperatorResolverGroup;
import com.rhiscom.bpm.console.server.model.entity.Person;
import com.rhiscom.bpm.console.server.model.entity.Profile;
import com.rhiscom.bpm.console.server.model.entity.ResolverGroup;
import com.rhiscom.bpm.console.server.model.entity.Worker;
import com.rhiscom.bpm.console.server.services.RetailDomainServiceImpl;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.PersonDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;
import com.rhiscom.bpm.console.shared.model.dto.WorkerDTO;

public class UserDAOImpl implements UserDAO {
    private static Logger logger = Logger.getLogger(UserDAOImpl.class.getName());
    private static final long serialVersionUID = 1L;
    private EntityManager em;

    public UserDAOImpl(EntityManager entityManager) {
	em = entityManager;
    }

    /**
     * Método que retorna todos los operadores existentes.
     */
    @Override
    public List<OperatorDTO> getAllOperator() throws Exception {
	List<OperatorDTO> resultListDTO = new ArrayList<OperatorDTO>();
	RetailDomainServiceImpl retailService = new RetailDomainServiceImpl();
	List<BusinessUnitDTO> listBusinessUnit = retailService.getBusinessUnitAll();
	try {
	    long init = System.currentTimeMillis();

	    long initManager = System.currentTimeMillis();

	    long endManager = System.currentTimeMillis();
	    long totalManager = endManager - initManager;
	    logger.log(Level.INFO, "[UserServiceImpl] :: getAllOperator:: tiempo total ejecucion creación manager :"
		    + totalManager);
	    Query query = em.createQuery("SELECT op FROM Operator op");
	    @SuppressWarnings("unchecked")
	    List<Operator> list = (List<Operator>) query.getResultList();

	    Query q = em.createQuery("SELECT a from AccessProfileFunctionalityAbility a");
	    @SuppressWarnings("unchecked")
	    ArrayList<AccessProfileFunctionalityAbility> resultList = (ArrayList<AccessProfileFunctionalityAbility>) q
		    .getResultList();
	    Set<AccessProfileFunctionalityAbility> accesslist = new HashSet<AccessProfileFunctionalityAbility>(
		    resultList);

	    for (int i = 0; i <= list.size() - 1; i++) {

		Operator operator = list.get(i);

		Query queryResolverOperator = em
			.createQuery("SELECT org from OperatorResolverGroup org where org.operator.operatorId='"
				+ operator.getOperatorId().intValue() + "'");
		@SuppressWarnings("unchecked")
		List<OperatorResolverGroup> orgList = (ArrayList<OperatorResolverGroup>) queryResolverOperator
			.getResultList();
		Set<OperatorResolverGroup> orgSet = new HashSet<OperatorResolverGroup>(orgList);

		PersonDTO personDTO = new PersonDTO(operator.getWorker().getPerson().getPersonId(), operator
			.getWorker().getPerson().getPartyId(), operator.getWorker().getPerson().getIdentification(),
			operator.getWorker().getPerson().getFirstName(), operator.getWorker().getPerson()
				.getMiddleName(), operator.getWorker().getPerson().getLastName(), operator.getWorker()
				.getPerson().getGender(), operator.getWorker().getPerson().getEmail());

		WorkerDTO workerDTO = new WorkerDTO(operator.getWorker().getWorkerId().longValue(), personDTO);

		Set<ResolverGroupDTO> setWorkGroup = new HashSet<ResolverGroupDTO>();

		for (Iterator<OperatorResolverGroup> iterator = orgSet.iterator(); iterator.hasNext();) {
		    OperatorResolverGroup op = iterator.next();
		    ResolverGroup resolverGroup = op.getResolverGroup();
		    ResolverGroupDTO dto = new ResolverGroupDTO(resolverGroup.getWorkGroupId(),
			    resolverGroup.getName(), resolverGroup.getDescription());
		    setWorkGroup.add(dto);
		}

		Profile pro = operator.getProfile();

		Set<AccessProfileFunctionalityAbilityDTO> listAccessProfileFunctionalityAbility = null;

		Set<AccessProfileFunctionalityAbility> accessResultList = getAccessByProfile(accesslist,
			pro.getSegProfileId());
		if (accessResultList != null) {
		    listAccessProfileFunctionalityAbility = new HashSet<AccessProfileFunctionalityAbilityDTO>();

		    for (Iterator iterator = accessResultList.iterator(); iterator.hasNext();) {
			AccessProfileFunctionalityAbility entity = (AccessProfileFunctionalityAbility) iterator.next();

			AbilityDTO abilityDTO = new AbilityDTO(entity.getSegAbility().getSegAbilityId(), entity
				.getSegAbility().getName(), entity.getSegAbility().getDescription(), entity
				.getSegAbility().getStatus());
			FunctionalityModuleDTO funcionalityModuleDTO = new FunctionalityModuleDTO(entity
				.getSegAccessProfileFunc().getSegFuncModuleId(), entity.getSegAccessProfileFunc()
				.getModule(), entity.getSegAccessProfileFunc().getDescription(), entity
				.getSegAccessProfileFunc().getStatus(), entity.getSegAccessProfileFunc().getCode());

			AccessProfileFunctionalityAbilityDTO dto = new AccessProfileFunctionalityAbilityDTO(abilityDTO,
				funcionalityModuleDTO, entity.getSegAccessProfileFuncAbilityId());
			listAccessProfileFunctionalityAbility.add(dto);
		    }

		}

		ProfileDTO profileDTO = new ProfileDTO(pro.getSegProfileId(), pro.getName(), pro.getDescription(),
			pro.getStatus(), pro.getCreateStamp(), pro.getUpdateStamp(),
			listAccessProfileFunctionalityAbility);

		OperatorDTO operatorDTO = new OperatorDTO(operator.getOperatorId().longValue(), operator.getUser(),
			operator.getPassword(), setWorkGroup, workerDTO, operator.getCreateDate(), profileDTO);

		for (int k = 0; k <= listBusinessUnit.size() - 1; k++) {
		    if (operator.getBusinessUnit().getIdBusinessUnit() == listBusinessUnit.get(k).getIdBusinessUnit()) {
			operatorDTO.setBussinessUnitDTO(listBusinessUnit.get(k));
			break;
		    }

		}

		resultListDTO.add(operatorDTO);

	    }

	    long end = System.currentTimeMillis();
	    long total = end - init;

	    logger.log(Level.INFO, "[UserServiceImpl] ::getAllOperator:: tiempo total ejecucion :" + total);
	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new Exception();
	}
	return resultListDTO;
    }

    private Set<AccessProfileFunctionalityAbility> getAccessByProfile(
	    Set<AccessProfileFunctionalityAbility> accesslist, long profileId) {
	Set<AccessProfileFunctionalityAbility> result = new HashSet<AccessProfileFunctionalityAbility>();

	for (int i = 0; i <= accesslist.size(); i++) {

	    for (Iterator<AccessProfileFunctionalityAbility> iterator = accesslist.iterator(); iterator.hasNext();) {
		AccessProfileFunctionalityAbility access = iterator.next();
		if (access.getSegProfileId() == profileId) {
		    result.add(access);
		}

	    }

	}
	return result;

    }

    /**
     * Método que retorna un operador según su id.
     */
    @Override
    public OperatorDTO getById(Long id) throws Exception {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");

	Operator operator = em.find(Operator.class, id);

	Query q = em.createQuery("SELECT a from AccessProfileFunctionalityAbility a");
	ArrayList<AccessProfileFunctionalityAbility> resultList = (ArrayList<AccessProfileFunctionalityAbility>) q
		.getResultList();
	Set<AccessProfileFunctionalityAbility> accesslist = new HashSet<AccessProfileFunctionalityAbility>(resultList);

	Query queryResolverOperator = em
		.createQuery("SELECT org from OperatorResolverGroup org where org.operator.operatorId='"
			+ id.intValue() + "'");
	@SuppressWarnings("unchecked")
	List<OperatorResolverGroup> orgList = (ArrayList<OperatorResolverGroup>) queryResolverOperator.getResultList();
	Set<OperatorResolverGroup> orgSet = new HashSet<OperatorResolverGroup>(orgList);

	PersonDTO personDTO = new PersonDTO(operator.getWorker().getPerson().getPersonId(), operator.getWorker()
		.getPerson().getPartyId(), operator.getWorker().getPerson().getIdentification(), operator.getWorker()
		.getPerson().getFirstName(), operator.getWorker().getPerson().getMiddleName(), operator.getWorker()
		.getPerson().getLastName(), operator.getWorker().getPerson().getGender(), operator.getWorker()
		.getPerson().getEmail());

	WorkerDTO workerDTO = new WorkerDTO(operator.getWorker().getWorkerId().longValue(), personDTO);

	Set<ResolverGroupDTO> setWorkGroup = new HashSet<ResolverGroupDTO>();

	for (Iterator<OperatorResolverGroup> iterator = orgSet.iterator(); iterator.hasNext();) {
	    OperatorResolverGroup op = iterator.next();
	    ResolverGroup resolverGroup = op.getResolverGroup();
	    ResolverGroupDTO dto = new ResolverGroupDTO(resolverGroup.getWorkGroupId(), resolverGroup.getName(),
		    resolverGroup.getDescription());
	    setWorkGroup.add(dto);
	}

	Profile pro = operator.getProfile();

	Set<AccessProfileFunctionalityAbilityDTO> listAccessProfileFunctionalityAbility = null;
	Set<AccessProfileFunctionalityAbility> accessResultList = this.getAccessByProfile(accesslist,
		pro.getSegProfileId());
	if (accessResultList != null) {
	    listAccessProfileFunctionalityAbility = new HashSet<AccessProfileFunctionalityAbilityDTO>();

	    for (Iterator iterator = accessResultList.iterator(); iterator.hasNext();) {
		AccessProfileFunctionalityAbility entity = (AccessProfileFunctionalityAbility) iterator.next();

		AbilityDTO abilityDTO = new AbilityDTO(entity.getSegAbility().getSegAbilityId(), entity.getSegAbility()
			.getName(), entity.getSegAbility().getDescription(), entity.getSegAbility().getStatus());
		FunctionalityModuleDTO funcionalityModuleDTO = new FunctionalityModuleDTO(entity
			.getSegAccessProfileFunc().getSegFuncModuleId(), entity.getSegAccessProfileFunc().getModule(),
			entity.getSegAccessProfileFunc().getDescription(),
			entity.getSegAccessProfileFunc().getStatus(), entity.getSegAccessProfileFunc().getCode());

		AccessProfileFunctionalityAbilityDTO dto = new AccessProfileFunctionalityAbilityDTO(abilityDTO,
			funcionalityModuleDTO, entity.getSegAccessProfileFuncAbilityId());
		listAccessProfileFunctionalityAbility.add(dto);
	    }

	}

	ProfileDTO profileDTO = new ProfileDTO(pro.getSegProfileId(), pro.getName(), pro.getDescription(),
		pro.getStatus(), pro.getCreateStamp(), pro.getUpdateStamp(), listAccessProfileFunctionalityAbility);
	BusinessUnitDTO bunsinessUnitDTO = new BusinessUnitDTO(operator.getBusinessUnit().getIdBusinessUnit(), operator
		.getBusinessUnit().getIdBusinessGroup(), operator.getBusinessUnit().getNameBusinessUnit(), operator
		.getBusinessUnit().getCreateStamp(), operator.getBusinessUnit().getLastUpdatedStamp(), operator
		.getBusinessUnit().getStatus(), operator.getBusinessUnit().getCode());

	OperatorDTO operatorDTO = new OperatorDTO(operator.getOperatorId().longValue(), operator.getUser(),
		operator.getPassword(), setWorkGroup, workerDTO, operator.getCreateDate(), profileDTO);
	operatorDTO.setBussinessUnitDTO(bunsinessUnitDTO);

	return operatorDTO;
    }

    /**
     * método que agrega un operador.
     */
    @Override
    public void addOperator(OperatorDTO operatorDTO) throws Exception {
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");

	PersonDTO personDTO = operatorDTO.getWorker().getPerson();

	/** Construyo Persona **/
	Person person = new Person(personDTO.getPartyId(), personDTO.getIdentification(), personDTO.getFirstName(),
		personDTO.getMiddleName(), personDTO.getLastName(), personDTO.getGender(), personDTO.getEmail());
	/** Construyo Worker */
	Worker worker = new Worker(person);

	/** Construyo Operador **/

	Set<ResolverGroup> setWorkGroup = new HashSet<ResolverGroup>();
	Set<OperatorResolverGroup> setOperatorResolverGroup = new HashSet<OperatorResolverGroup>();

	ProfileDTO profileDTO = operatorDTO.getProfileDTO();

	Profile profile = new Profile(profileDTO.getSegProfileId(), profileDTO.getName(), profileDTO.getDescription(),
		profileDTO.getStatus(), profileDTO.getCreateStamp(), profileDTO.getUpdateStamp());

	BusinessUnit businesUnit = em.find(BusinessUnit.class, operatorDTO.getBussinessUnitDTO().getIdBusinessUnit());

	Operator operator = new Operator(operatorDTO.getUser(), operatorDTO.getPassword(), worker, new Date(), profile,
		businesUnit);

	for (Iterator iterator = operatorDTO.getWorkGroups().iterator(); iterator.hasNext();) {
	    OperatorResolverGroup operatorResolver = new OperatorResolverGroup();
	    operatorResolver.setOperator(operator);

	    ResolverGroupDTO resolverGroup = (ResolverGroupDTO) iterator.next();
	    ResolverGroup dto = em.find(ResolverGroup.class, new Long(resolverGroup.getWorkGroupid()));
	    operatorResolver.setResolverGroup(dto);
	    logger.log(Level.INFO, "operatorResolver " + operatorResolver);
	    setOperatorResolverGroup.add(operatorResolver);
	}

	try {
	    logger.log(Level.INFO, "Operator " + operator);
	    em.getTransaction().begin();
	    em.persist(operator);

	    for (Iterator<OperatorResolverGroup> iterator = setOperatorResolverGroup.iterator(); iterator.hasNext();) {
		em.persist(iterator.next());
	    }
	    em.getTransaction().commit();
	    addOperatorToTask(operator.getUser());
	} catch (Exception ex) {
	    ex.printStackTrace();
	    em.getTransaction().rollback();
	} finally {

	}
    }

    /**
     * Método que edita un operador.
     */
    @Override
    public OperatorDTO editOperator(OperatorDTO operatorDTO) throws Exception {

	PersonDTO personDTO = operatorDTO.getWorker().getPerson();
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");

	/** Construyo Persona **/
	Person person = new Person(personDTO.getPersonId(), personDTO.getPartyId(), personDTO.getIdentification(),
		personDTO.getFirstName(), personDTO.getMiddleName(), personDTO.getLastName(), personDTO.getGender(),
		personDTO.getEmail());
	/** Construyo Worker */
	Worker worker = new Worker(operatorDTO.getWorker().getWorkerId(), person);

	Set<OperatorResolverGroup> setOperatorResolverGroup = new HashSet<OperatorResolverGroup>();

	ProfileDTO profileDTO = operatorDTO.getProfileDTO();

	Profile profile = new Profile(profileDTO.getSegProfileId(), profileDTO.getName(), profileDTO.getDescription(),
		profileDTO.getStatus(), profileDTO.getCreateStamp(), profileDTO.getUpdateStamp());
	BusinessUnit businesUnit = em.find(BusinessUnit.class, operatorDTO.getBussinessUnitDTO().getIdBusinessUnit());

	/** Construyo Operador **/
	Operator operator = new Operator(operatorDTO.getOperatorId(), operatorDTO.getUser(), operatorDTO.getPassword(),
		worker, operatorDTO.getCreateDate(), profile, businesUnit);

	for (Iterator iterator = operatorDTO.getWorkGroups().iterator(); iterator.hasNext();) {
	    OperatorResolverGroup operatorResolver = new OperatorResolverGroup();
	    operatorResolver.setOperator(operator);
	    ResolverGroupDTO resolverGroup = (ResolverGroupDTO) iterator.next();
	    ResolverGroup dto = em.find(ResolverGroup.class, new Long(resolverGroup.getWorkGroupid()));
	    operatorResolver.setResolverGroup(dto);
	    logger.log(Level.INFO, "operatorResolver " + operatorResolver);
	    setOperatorResolverGroup.add(operatorResolver);
	}

	try {
	    em.getTransaction().begin();
	    Query q = em.createNativeQuery("Delete from operator_resolvergroup Where operatorId ="
		    + operator.getOperatorId() + "");
	    q.executeUpdate();
	    em.getTransaction().commit();

	    System.out.println(":: OPERADOR A PERSISTIR :" + operator);

	    em.getTransaction().begin();
	    em.merge(operator);
	    em.getTransaction().commit();
	    em.getTransaction().begin();
	    for (Iterator<OperatorResolverGroup> iterator = setOperatorResolverGroup.iterator(); iterator.hasNext();) {
		em.persist(iterator.next());
	    }
	    em.getTransaction().commit();

	} catch (Exception ex) {
	    ex.printStackTrace();

	} finally {

	}
	return operatorDTO;
    }

    /**
     * Método que elimina un operador.
     */
    @Override
    public void deleteOperator(OperatorDTO operatorDTO) throws Exception {
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");

	/** Construyo Operador **/
	Operator operator = new Operator(operatorDTO.getOperatorId(), operatorDTO.getUser(), operatorDTO.getPassword(),
		null, operatorDTO.getCreateDate(), null, null);
	try {
	    em.getTransaction().begin();
	    Query q = em.createNativeQuery("Delete from operator_resolvergroup Where operatorId ="
		    + operator.getOperatorId().intValue() + "");
	    q.executeUpdate();
	    em.getTransaction().commit();

	    em.getTransaction().begin();

	    Operator op = em.find(Operator.class, operator.getOperatorId());
	    Long operatorID = op.getOperatorId();
	    em.remove(em.merge(op));
	    em.getTransaction().commit();

	} catch (Exception ex) {
	    ex.printStackTrace();

	} finally {

	}
    }

    @Override
    public OperatorDTO searchOperator(String user) throws Exception {
	Operator operator = null;

	try {
	    Query query = em.createQuery("SELECT op FROM Operator op Where op.user='" + user + "'");
	    operator = (Operator) query.getSingleResult();
	} catch (NoResultException ne) {
	    throw new Exception("NO_EXISTE");
	}

	Query q = em.createQuery("SELECT a from AccessProfileFunctionalityAbility a");
	ArrayList<AccessProfileFunctionalityAbility> resultList = (ArrayList<AccessProfileFunctionalityAbility>) q
		.getResultList();
	Set<AccessProfileFunctionalityAbility> accesslist = new HashSet<AccessProfileFunctionalityAbility>(resultList);

	Query queryResolverOperator = em
		.createQuery("SELECT org from OperatorResolverGroup org where org.operator.operatorId='"
			+ operator.getOperatorId().intValue() + "'");
	@SuppressWarnings("unchecked")
	List<OperatorResolverGroup> orgList = (ArrayList<OperatorResolverGroup>) queryResolverOperator.getResultList();
	Set<OperatorResolverGroup> orgSet = new HashSet<OperatorResolverGroup>(orgList);

	PersonDTO personDTO = new PersonDTO(operator.getWorker().getPerson().getPersonId(), operator.getWorker()
		.getPerson().getPartyId(), operator.getWorker().getPerson().getIdentification(), operator.getWorker()
		.getPerson().getFirstName(), operator.getWorker().getPerson().getMiddleName(), operator.getWorker()
		.getPerson().getLastName(), operator.getWorker().getPerson().getGender(), operator.getWorker()
		.getPerson().getEmail());

	WorkerDTO workerDTO = new WorkerDTO(operator.getWorker().getWorkerId().longValue(), personDTO);

	Set<ResolverGroupDTO> setWorkGroup = new HashSet<ResolverGroupDTO>();

	for (Iterator<OperatorResolverGroup> iterator = orgSet.iterator(); iterator.hasNext();) {
	    OperatorResolverGroup op = iterator.next();
	    ResolverGroup resolverGroup = op.getResolverGroup();
	    ResolverGroupDTO dto = new ResolverGroupDTO(resolverGroup.getWorkGroupId(), resolverGroup.getName(),
		    resolverGroup.getDescription());
	    setWorkGroup.add(dto);
	}

	Profile pro = operator.getProfile();

	Set<AccessProfileFunctionalityAbilityDTO> listAccessProfileFunctionalityAbility = null;
	Set<AccessProfileFunctionalityAbility> accessResultList = this.getAccessByProfile(accesslist,
		pro.getSegProfileId());
	if (accessResultList != null) {
	    listAccessProfileFunctionalityAbility = new HashSet<AccessProfileFunctionalityAbilityDTO>();

	    for (Iterator iterator = accessResultList.iterator(); iterator.hasNext();) {
		AccessProfileFunctionalityAbility entity = (AccessProfileFunctionalityAbility) iterator.next();

		AbilityDTO abilityDTO = new AbilityDTO(entity.getSegAbility().getSegAbilityId(), entity.getSegAbility()
			.getName(), entity.getSegAbility().getDescription(), entity.getSegAbility().getStatus());
		FunctionalityModuleDTO funcionalityModuleDTO = new FunctionalityModuleDTO(entity
			.getSegAccessProfileFunc().getSegFuncModuleId(), entity.getSegAccessProfileFunc().getModule(),
			entity.getSegAccessProfileFunc().getDescription(),
			entity.getSegAccessProfileFunc().getStatus(), entity.getSegAccessProfileFunc().getCode());

		AccessProfileFunctionalityAbilityDTO dto = new AccessProfileFunctionalityAbilityDTO(abilityDTO,
			funcionalityModuleDTO, entity.getSegAccessProfileFuncAbilityId());
		listAccessProfileFunctionalityAbility.add(dto);
	    }

	}

	ProfileDTO profileDTO = new ProfileDTO(pro.getSegProfileId(), pro.getName(), pro.getDescription(),
		pro.getStatus(), pro.getCreateStamp(), pro.getUpdateStamp(), listAccessProfileFunctionalityAbility);
	BusinessUnitDTO bunsinessUnitDTO = new BusinessUnitDTO(operator.getBusinessUnit().getIdBusinessUnit(), operator
		.getBusinessUnit().getIdBusinessGroup(), operator.getBusinessUnit().getNameBusinessUnit(), operator
		.getBusinessUnit().getCreateStamp(), operator.getBusinessUnit().getLastUpdatedStamp(), operator
		.getBusinessUnit().getStatus(), operator.getBusinessUnit().getCode());
	OperatorDTO operatorDTO = new OperatorDTO(operator.getOperatorId().longValue(), operator.getUser(),
		operator.getPassword(), setWorkGroup, workerDTO, operator.getCreateDate(), profileDTO);
	operatorDTO.setBussinessUnitDTO(bunsinessUnitDTO);

	return operatorDTO;

    }

    public void addOperatorToTask(String operator) {

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
	    String insert = "INSERT INTO organizationalentity  (DTYPE, id) VALUES ('User','" + operator + "')";
	    logger.log(Level.INFO, " SQL " + insert);
	    stmt = con.createStatement();
	    stmt.executeUpdate(insert);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
