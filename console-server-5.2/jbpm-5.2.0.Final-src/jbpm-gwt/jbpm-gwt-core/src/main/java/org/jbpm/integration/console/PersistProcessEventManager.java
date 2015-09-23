package org.jbpm.integration.console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jboss.bpm.console.client.model.ProcessInstanceRef;
import org.jboss.bpm.console.client.model.TokenReference;

public class PersistProcessEventManager {
	static ResourceBundle rb = ResourceBundle.getBundle("corepersistence");
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = rb.getString("url");
	static final String USER = rb.getString("user");
	static final String PASS = rb.getString("password");

	private static final Logger logger = Logger.getLogger(PersistProcessEventManager.class.getName());

	public static void insertProcess(long id, String name, String description, int state) {

		try {
			Connection conn = getConnection();
			Statement stmt = null;
			stmt = conn.createStatement();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // your
																						// template
																						// here
			String sqlUser = "INSERT INTO pa_process_log (processId,processName,processDescription,status, initDate)"
					+ "VALUES (" + id + ",'" + name + "','" + description + "','" + 1 + "','"
					+ formatter.format(new Date()) + "')";
			logger.log(Level.INFO, " QUERY INSERT :" + sqlUser);
			stmt.executeUpdate(sqlUser);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<ProcessInstanceRef> getInstanceByProcessId(String processId) {

		List<ProcessInstanceRef> resultList = null;
		Connection conn;
		try {
			conn = getConnection();

			Statement stmt = null;

			stmt = conn.createStatement();

			resultList = new ArrayList<ProcessInstanceRef>();

			String queryStr = "SELECT processId,processName, processDescription,initDate,endDate,status from pa_process_log WHERE endDate is null and processName='"
					+ processId + "'";

			logger.log(Level.INFO, " QUERY BUSQUEDA DE PROCESO  :" + queryStr);

			ResultSet rs = stmt.executeQuery(queryStr);

			ProcessInstanceRef result = new ProcessInstanceRef();

			while (rs.next()) {

				result = new ProcessInstanceRef(rs.getString("processId"), rs.getString("processName"),
						rs.getDate("initDate"), rs.getDate("endDate"), false);

				if (rs.getString("status").equals("1")) {
					result.setKey("1");
				} else if (rs.getString("status").equals("2")) {
					result.setKey("2");
				}

				else {
					result.setKey("3");
				}

				TokenReference token = new TokenReference(rs.getString("processName") + "", null, "");
				result.setRootToken(token);

				resultList.add(result);
			}
			logger.log(Level.INFO, processId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultList;

	}

	public static void endProcess(long id, int state) {

		try {
			Connection conn = getConnection();
			Statement stmt = null;

			stmt = conn.createStatement();

			// String queryStr =
			// "SELECT processId from pa_process_log WHERE status=1 and processId="
			// + id + "";
			// logger.log(Level.INFO, " QUERY  :" + queryStr);
			// ResultSet rs = stmt.executeQuery(queryStr);
			//
			// String processId = "";
			// while (rs.next()) {
			// processId = rs.getString("processId");
			// }
			// logger.log(Level.INFO, "Proceso en ejecución encontrado : "+
			// processId);
			// logger.log(Level.INFO, "Proceso en ejecución encontrado : "+
			// processId);
			// logger.log(Level.INFO, "Proceso en ejecución encontrado : "+
			// processId);
			// logger.log(Level.INFO, "Proceso en ejecución encontrado : "+
			// processId);
			//

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // your
																						// template
																						// here

			String sqlUser = "UPDATE pa_process_log SET status='" + state + "', endDate='"
					+ formatter.format(new Date()) + "'" + " WHERE processId=" + id
					+ " and endDate is null and status=1";
			logger.log(Level.INFO, " QUERY UPDATE :" + sqlUser);
			stmt.executeUpdate(sqlUser);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Connection getConnection() throws Exception {

		Connection conn = null;

		try {

			logger.log(Level.INFO, "Connecting to a selected database...");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			logger.log(Level.INFO, "Connected database successfully...");
			return conn;
		} catch (Exception ex) {
			throw new Exception(ex.getCause());
		}

	}
}
