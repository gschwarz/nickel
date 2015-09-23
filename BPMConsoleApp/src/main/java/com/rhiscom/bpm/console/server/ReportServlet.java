package com.rhiscom.bpm.console.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

@SuppressWarnings("serial")
public class ReportServlet extends HttpServlet {

    private static final String DEFAULT_REPORTS_SERVICE_PATH = "";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.processRequest(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	    IOException {

	String resourceName = DEFAULT_REPORTS_SERVICE_PATH + "";

	ServletOutputStream servletOutputStream = response.getOutputStream();
	InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream(resourceName);
	response.setContentType("application/pdf");

	HttpServletRequestWrapper srw = new HttpServletRequestWrapper(request);
	String path = srw.getRealPath("") + "\\WEB-INF\\reports\\";
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/automaton", "automaton",
		    "automaton2013");
	    SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");

	    String initDate = request.getParameter("initDate");
	    String endDate = request.getParameter("endDate");
	    String report = request.getParameter("resourceName");
	    resourceName = path + report;
	    Date i = ft.parse(initDate);
	    Date e = ft.parse(endDate);
	    HashMap<String, Object> hm = null;
	    hm = new HashMap<String, Object>();
	    Calendar c = Calendar.getInstance();
	    c.setTime(i);
	    // c.set(2013, 7, 25);
	    Date init = c.getTime();
	    hm.put("startDate", init);
	    // c.set(2013, 7, 30);
	    c.setTime(e);
	    Date end = c.getTime();
	    hm.put("endDate", end);
	    hm.put("path", path);
	    System.out.println(resourceName);
	    byte[] result = JasperRunManager.runReportToPdf(resourceName, hm, connection);

	    System.out.println(servletOutputStream);

	    response.setContentLength(result.length);
	    servletOutputStream.write(result, 0, result.length);

	    servletOutputStream.flush();
	    servletOutputStream.close();

	    connection.close();

	} catch (Exception e) {
	    // display stack trace in the browser
	    StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    e.printStackTrace(printWriter);
	    response.setContentType("text/plain");
	    response.getOutputStream().print(stringWriter.toString());
	} finally {
	    servletOutputStream.flush();
	    servletOutputStream.close();
	}
    }
}
