package com.rhiscom.bpm.console.server.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rhiscom.bpm.console.client.event.ATNEvent;
import com.rhiscom.bpm.console.client.event.SuiteTestCaseEvent;
import com.rhiscom.bpm.console.client.event.TestCaseEvent;
import com.rhiscom.bpm.console.server.ServerMessageGeneratorServiceImpl;
import com.rhiscom.bpm.console.server.services.dao.CoreCaseDAO;
import com.rhiscom.bpm.console.server.services.dao.CoreCaseDAOImpl;
import com.rhiscom.bpm.console.shared.model.dto.CoreCaseDTO;
import com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.TaskRS;
import com.rhiscom.bpm.console.shared.model.rs.UserTaskVO;

/**
 * Servlet implementation class CompleteServlet
 */
public class CompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConsoleBPMProxy proxy = ConsoleBPMProxy.instance();
    ServerMessageGeneratorServiceImpl server = ServerMessageGeneratorServiceImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	    IOException {

	System.out.println("::: SERVLET :::");

	String resp = null;
	DefinitionsRS defnitionRS = new DefinitionsRS();
	String _e_pID = null, _e_tID = null;
	TaskRS taskRS = new TaskRS();

	String user = request.getParameter("user");
	String password = request.getParameter("password");

	System.out.println("::: SERVLET ::: USER: :" + user + " PASS :" + password);

	UserTaskVO userTaskVO = new UserTaskVO(user, password);

	Map<String, Object> params = new HashMap<String, Object>();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	Enumeration paramNames = request.getParameterNames();
	String[] paramValues = null;
	while (paramNames.hasMoreElements()) {

	    String paramName = (String) paramNames.nextElement();
	    paramValues = null;

	    System.out.println(paramName);
	    if ("_e_pID".equals(paramName)) {

		paramValues = request.getParameterValues(paramName);

		if (paramValues.length == 1) {
		    _e_pID = paramValues[0];
		}

	    } else {

		if ("_e_tID".equals(paramName)) {
		    paramValues = request.getParameterValues(paramName);
		    if (paramValues.length == 1) {
			_e_tID = paramValues[0];
		    }
		}

		else
		    params.put(paramName, request.getParameterValues(paramName)[0]);

	    }
	}
	if (_e_tID != null) {
	    taskRS.setId(_e_tID);

	    userTaskVO.setTaskRS(taskRS);
	    try {
		System.out.println("::: PARAMETROS TASK::" + params);
		// proxy.login(user, password);
		resp = proxy.taskComplete(userTaskVO, params);
		out.println("Tarea completada Exitosamente, puede cerrar la ventana");
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	} else {
	    defnitionRS.setId(_e_pID);
	    try {
		String name = (String) params.get("_e_pName");
		defnitionRS.setName(name);
		System.out.println("::: PARAMETROS PROCESS::" + params);
		resp = proxy.processComplete(defnitionRS, params, userTaskVO);

		EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("ConfigurationConsolePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CoreCaseDAO coreCaseDAO = new CoreCaseDAOImpl(entityManager);
		CoreCaseDTO dto = new CoreCaseDTO();

		dto.setEstado("Ingresado");
		dto.setFechaGeneracion(new Date());
		dto.setFechaUltimaModificacion(new Date());
		dto.setIdProceso(defnitionRS.getId());
		dto.setNombre(defnitionRS.getName());
		dto.setOrigen(userTaskVO.getUsername());
		coreCaseDAO.addOrUpdateCoreCase(dto);

		server.sendEvent("START_PROCESS_EVENT");
		out.println("Proceso iniciado Exitosamente, puede cerrar la ventana");
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

    }

    /**
     * Inicia proceso Listener para analizar los eventos que se van generando.
     * 
     * @param event
     */
    public void completeEvent(ATNEvent event) {
	DefinitionsRS defnitionRS = new DefinitionsRS();
	Map<String, Object> params = new HashMap<String, Object>();
	String resp = null;
	defnitionRS.setId("ListenerEvent");
	TestCaseEvent tc = null;
	SuiteTestCaseEvent stc = null;
	if (event instanceof TestCaseEvent) {
	    tc = (TestCaseEvent) event;

	    System.out.println("EVENTO A ENVIAR" + tc);

	    params.put("type", tc.getType());
	    params.put("stateDate", String.valueOf(new Date().getTime()));
	    params.put("name", tc.getName());
	    params.put("state", tc.getState());

	    try {
		System.out.println("::: PARAMETROS PROCESS::" + params);
		UserTaskVO userTaskVO = new UserTaskVO("admin", "admin");
		resp = proxy.processComplete(defnitionRS, params, userTaskVO);
		server.sendEvent("START_PROCESS_EVENT");

	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	} else if (event instanceof SuiteTestCaseEvent) {

	    stc = (SuiteTestCaseEvent) event;

	    System.out.println("EVENTO A ENVIAR" + stc);

	    params.put("type", stc.getType());
	    params.put("stateDate", String.valueOf(new Date().getTime()));
	    params.put("name", stc.getName());

	    try {
		System.out.println("::: PARAMETROS PROCESS::" + params);
		UserTaskVO userTaskVO = new UserTaskVO("admin", "admin");
		resp = proxy.processComplete(defnitionRS, params, userTaskVO);
		server.sendEvent("START_PROCESS_EVENT");

	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	service(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	    IOException {
	service(request, response);
    }

}
