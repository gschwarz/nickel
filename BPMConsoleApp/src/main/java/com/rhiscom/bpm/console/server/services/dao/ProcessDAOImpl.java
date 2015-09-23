package com.rhiscom.bpm.console.server.services.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.bpm.console.server.model.entity.NodeInstanceLog;
import com.rhiscom.bpm.console.server.model.entity.ProcessInstanceLog;
import com.rhiscom.bpm.console.server.model.entity.ProcessScheduler;
import com.rhiscom.bpm.console.server.services.ProcessServiceImpl;
import com.rhiscom.bpm.console.shared.model.dto.NodeInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessInstanceLogDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProcessSchedulerDTO;

public class ProcessDAOImpl implements ProcessDAO {

    private static Logger logger = Logger.getLogger(ProcessServiceImpl.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProcessPersistenceUnit");
    EntityManager entityManager;

    public ProcessDAOImpl(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    @SuppressWarnings({ "unchecked", "null" })
    @Override
    public List<NodeInstanceLogDTO> getDetailInstance(Long instanceId) throws Exception {
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	List<NodeInstanceLog> resultList = null;
	List<NodeInstanceLogDTO> resultListDTO = null;

	try {
	    logger.log(Level.INFO, "::getDetailInstance::  instanceId= " + instanceId);

	    Query query = entityManager.createQuery("SELECT nl FROM NodeInstanceLog nl Where nl.processInstanceId='"
		    + instanceId.longValue() + "' and type='0'");
	    resultList = query.getResultList();

	    if (resultList != null || resultList.size() > 0) {
		resultListDTO = new ArrayList<NodeInstanceLogDTO>();
		logger.log(Level.INFO, "::getDetailInstance::  Tiene instacias");
		for (int i = 0; i <= resultList.size() - 1; i++) {
		    NodeInstanceLogDTO dto = new NodeInstanceLogDTO();
		    dto.setId(resultList.get(i).getId());
		    dto.setLogDate(resultList.get(i).getLogDate());
		    dto.setNodeId(resultList.get(i).getNodeId());
		    dto.setNodeInstanceId(resultList.get(i).getNodeInstanceId());
		    dto.setNodeName(resultList.get(i).getNodeName());
		    dto.setProcessId(resultList.get(i).getProcessId());
		    dto.setProcessInstanceId(resultList.get(i).getProcessInstanceId());
		    dto.setType(resultList.get(i).getType());
		    resultListDTO.add(dto);

		}
		logger.log(Level.SEVERE, "::getDetailInstance::  FIN for");
	    }
	} catch (NoResultException ne) {
	    ne.printStackTrace();
	    logger.log(Level.SEVERE, "::getDetailInstance::  NO existen datos");
	    throw new Exception("NO_EXISTE");
	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new Exception("ERROR_PERSISTENCIA :" + ex.toString());
	} finally {
	    logger.log(Level.SEVERE, "::getDetailInstance::  cierro entityManager");

	}
	return resultListDTO;

    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Integer> getTotalInstancesInExecution() throws Exception {
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	List<ProcessInstanceLog> resultList = null;
	entityManagerFactory = Persistence.createEntityManagerFactory("ProcessPersistenceUnit");
	entityManager = entityManagerFactory.createEntityManager();

	Map<String, Integer> resultado = new HashMap<String, Integer>();
	try {

	    String hql = "select nl FROM ProcessInstanceLog as nl";

	    Query q = entityManager.createQuery(hql);

	    resultList = q.getResultList();

	    Integer contador = 0;
	    for (int i = 0; i <= resultList.size() - 1; i++) {
		ProcessInstanceLogDTO dto = new ProcessInstanceLogDTO();
		dto.setEndDate(resultList.get(i).getEndDate());
		dto.setId(resultList.get(i).getId());
		dto.setProcessId(resultList.get(i).getProcessId());
		dto.setProcessInstanceId(resultList.get(i).getProcessInstanceId());
		dto.setStartDate(resultList.get(i).getStartDate());

		contador = resultado.get(resultList.get(i).getProcessId());
		if (contador == null)
		    contador = new Integer(0);
		if (dto.getEndDate() == null)
		    contador++;
		resultado.put(resultList.get(i).getProcessId(), contador);
		contador = 0;

	    }
	    System.out.println("Resultado :" + resultado);
	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new Exception("PERSISTENCE_EXCEPTION " + ex.toString());

	} finally {

	}
	return resultado;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProcessInstanceLogDTO> getInstancesLog() throws Exception {
	List<ProcessInstanceLog> resultList = null;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	List<ProcessInstanceLogDTO> resultado = new ArrayList<ProcessInstanceLogDTO>();
	try {
	    String hql = "select nl FROM ProcessInstanceLog as nl where nl.startDate >= :date1 order by nl.startDate desc";

	    Calendar startCalendar = Calendar.getInstance();

	    Date startDate = startCalendar.getTime();
	    long tiempoActual = startDate.getTime();

	    long undia = 7 * 12 * 60 * 60 * 1000; // calculo una semana de
						  // ejecución.
	    Date fechaAyer = new Date(tiempoActual - undia);

	    Query q = entityManager.createQuery(hql).setParameter("date1", fechaAyer);

	    resultList = q.getResultList();

	    for (int i = 0; i <= resultList.size() - 1; i++) {
		ProcessInstanceLogDTO dto = new ProcessInstanceLogDTO();
		dto.setEndDate(resultList.get(i).getEndDate());
		dto.setId(resultList.get(i).getId());
		dto.setProcessId(resultList.get(i).getProcessId());
		dto.setProcessInstanceId(resultList.get(i).getProcessInstanceId());
		dto.setStartDate(resultList.get(i).getStartDate());
		dto.setStatus(resultList.get(i).getStatus());

		resultado.add(dto);

	    }
	} catch (Exception ex) {
	    throw new Exception("PERSISTENCE_EXCEPTION " + ex.toString());
	} finally {

	}
	System.out.println("Resultado Log:" + resultado);
	return resultado;
    }

    @Override
    public Map<Date, List<ProcessInstanceLogDTO>> getProcessHistory() throws Exception {
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	Map<Date, List<ProcessInstanceLogDTO>> resultado = new HashMap<Date, List<ProcessInstanceLogDTO>>();

	List<ProcessInstanceLog> resultList = null;

	try {

	    String hql = "select nl FROM ProcessInstanceLog as nl where nl.startDate <= :date1 and nl.startDate >= :date2";
	    Calendar startCalendar = Calendar.getInstance();
	    int hour = startCalendar.get(Calendar.HOUR);

	    startCalendar.set(Calendar.HOUR, hour + 1);
	    startCalendar.set(Calendar.MINUTE, 30);
	    startCalendar.set(Calendar.SECOND, 0);
	    startCalendar.set(Calendar.MILLISECOND, 0);

	    Date startDate = startCalendar.getTime();
	    long tiempoActual = startDate.getTime();

	    long unaHora = 1 * 12 * 60 * 60 * 1000;
	    Date fechaAyer = new Date(tiempoActual - unaHora);

	    Query q = entityManager.createQuery(hql).setParameter("date1", startDate).setParameter("date2", fechaAyer);

	    resultList = q.getResultList();
	    System.out.println("Result :" + resultList);
	    Calendar temp = Calendar.getInstance();
	    Calendar tempFin = Calendar.getInstance();

	    Calendar fechaFin = Calendar.getInstance();
	    fechaFin.setTime(fechaAyer);

	    Calendar fechaActual = Calendar.getInstance();
	    fechaActual.setTime(fechaFin.getTime());

	    for (int j = 1; j <= 13; j++) {

		List<ProcessInstanceLogDTO> list = resultado.get(fechaActual.getTime());
		if (list == null) {
		    list = new ArrayList<ProcessInstanceLogDTO>();
		}

		for (int i = 0; i <= resultList.size() - 1; i++) {

		    temp.setTime(fechaActual.getTime());
		    temp.set(Calendar.MILLISECOND, 0);
		    temp.set(Calendar.SECOND, 0);
		    temp.set(Calendar.MINUTE, 0);

		    tempFin.setTime(fechaActual.getTime());
		    tempFin.set(Calendar.SECOND, 59);
		    tempFin.set(Calendar.MINUTE, 59);

		    ProcessInstanceLogDTO dto = new ProcessInstanceLogDTO();
		    dto.setEndDate(resultList.get(i).getEndDate());
		    dto.setId(resultList.get(i).getId());
		    dto.setProcessId(resultList.get(i).getProcessId());
		    dto.setProcessInstanceId(resultList.get(i).getProcessInstanceId());
		    dto.setStartDate(resultList.get(i).getStartDate());
		    Date d1 = temp.getTime();
		    Date d2 = tempFin.getTime();

		    if (d1.before(dto.getStartDate()) && d2.after(dto.getStartDate())) {
			list.add(dto);
		    }
		}
		resultado.put(fechaActual.getTime(), list);
		fechaActual.set(Calendar.HOUR, fechaActual.get(Calendar.HOUR) + 1);
		Date fechaActual2 = fechaActual.getTime();
		System.out.println(fechaActual2 + "Size :" + list.size());

	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new Exception(ex.getCause());

	} finally {

	}
	System.out.println(resultado);
	return resultado;
    }

    @Override
    public void saveProcessScheduler(ProcessSchedulerDTO dto) throws Exception {

	ProcessScheduler entity = new ProcessScheduler();

	entity.setProcessConfigId(dto.getId());
	entity.setEndDate(dto.getEndDate());
	entity.setInitDate(dto.getInitDate());
	entity.setMinutoInicio(dto.getMinutoInicio());
	entity.setHoraInicio(dto.getHoraInicio());

	if (dto.getIsDomingo() == true)
	    entity.setIsDomingo(1);
	else
	    entity.setIsDomingo(0);

	if (dto.getIsSabado() == true)
	    entity.setIsSabado(1);
	else
	    entity.setIsSabado(0);

	if (dto.getIsViernes() == true)
	    entity.setIsViernes(1);
	else
	    entity.setIsViernes(0);

	if (dto.getIsJueves() == true)
	    entity.setIsJueves(1);
	else
	    entity.setIsJueves(0);

	if (dto.getIsMiercoles() == true)
	    entity.setIsMiercoles(1);
	else
	    entity.setIsMiercoles(0);

	if (dto.getIsMartes() == true)
	    entity.setIsMartes(1);
	else
	    entity.setIsMartes(0);

	if (dto.getIsLunes() == true)
	    entity.setIsLunes(1);
	else
	    entity.setIsLunes(0);

	entity.setProcessId(dto.getProcessId());
	try {
	    entityManager.getTransaction().begin();

	    entityManager.merge(entity);
	    entityManager.getTransaction().commit();

	} catch (Exception ex) {
	    throw new Exception(ex.getCause());
	}
    }

    @Override
    public ProcessSchedulerDTO getProcessSchedulerByProcessId(String processID) throws Exception {

	Query query = entityManager.createQuery("SELECT r FROM ProcessScheduler r where r.processId='" + processID
		+ "'");

	ProcessSchedulerDTO dto = new ProcessSchedulerDTO();

	try {
	    ProcessScheduler result = (ProcessScheduler) query.getSingleResult();
	    logger.log(Level.INFO, ":: RESULTADO ::" + result);
	    dto.setEndDate(result.getEndDate());
	    dto.setInitDate(result.getInitDate());
	    dto.setMinutoInicio(result.getMinutoInicio());
	    dto.setHoraInicio(result.getHoraInicio());

	    if (result.getIsDomingo() == 1)
		dto.setIsDomingo(true);
	    else
		dto.setIsDomingo(false);

	    if (result.getIsSabado() == 1)
		dto.setIsSabado(true);
	    else
		dto.setIsSabado(false);

	    if (result.getIsViernes() == 1)
		dto.setIsViernes(true);
	    else
		dto.setIsViernes(false);

	    if (result.getIsJueves() == 1)
		dto.setIsJueves(true);
	    else
		dto.setIsJueves(false);

	    if (result.getIsMiercoles() == 1)
		dto.setIsMiercoles(true);
	    else
		dto.setIsMiercoles(false);

	    if (result.getIsMartes() == 1)
		dto.setIsMartes(true);
	    else
		dto.setIsMartes(false);

	    if (result.getIsLunes() == 1)
		dto.setIsLunes(true);
	    else
		dto.setIsLunes(false);

	    dto.setProcessId(result.getProcessId());
	    dto.setId(result.getProcessConfigId());
	    return dto;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new Exception(ex.getCause());
	}
    }
}
