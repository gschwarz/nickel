package com.rhiscom.bpm.console.server.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS;
import com.rhiscom.bpm.console.shared.model.rs.ProcessSchedulerRS;

public class SchedulerService {
    private static final Logger log = Logger.getLogger(SchedulerService.class.getName());
    private static SchedulerService instance = null;
    ResourceBundle bundle = ResourceBundle.getBundle("processResources");
    /** Hora de ejecución: 23 horas */
    private static final int START_HOUR = 23;

    /** Minutos de ejecución: 0 minutos */
    private static final int START_MINUTES = 0;

    /** Segundos de ejecución: 00 */
    private static final int START_SECONDS = 0;

    /** Intervalo de la ejecución: 1440 = 24 horas */
    private static final int INTERVAL_IN_MINUTES = 1440;

    private SchedulerService() {

    }

    public static SchedulerService getInstance() {
	if (instance == null)
	    instance = new SchedulerService();
	return instance;
    }

    public void timerToStartProcess() {

	log.info("startUpTimer - alarm scheduler service is active.");

	Calendar initialExpiration = Calendar.getInstance();
	initialExpiration.set(Calendar.HOUR_OF_DAY, START_HOUR);
	initialExpiration.set(Calendar.MINUTE, START_MINUTES);
	initialExpiration.set(Calendar.SECOND, START_SECONDS);

	TimerTask timerTask = new TimerTask() {
	    public void run() {

		log.info("TIMER!!");
		long date = System.currentTimeMillis();

		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date);

		int day = c.get(Calendar.DAY_OF_WEEK);
		log.info(":[startUpTimer:] DAY :" + day);

		int year = c.get(Calendar.YEAR);
		log.info(":[startUpTimer:] year :" + year);
		int min = c.get(Calendar.MINUTE);
		log.info(":[startUpTimer:] min :" + min);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		log.info(":[startUpTimer:] hour :" + hour);

		String horaInicio;
		String minutoInicio;
		int isDomingo;
		int isLunes;
		int isMartes;
		int isMiercoles;
		int isJueves;
		int isViernes;
		int isSabado;
		String processId;

		try {
		    Connection con = getConnection();

		    java.sql.Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT proc_config_scheduler_id, initDate, endDate, horaInicio, "
			    + " initDate,isDomingo, isJueves, isMartes,isMiercoles,isSabado,isViernes, "
			    + " isLunes , minutoInicio, processId FROM proc_config_scheduler;");

		    List<ProcessSchedulerRS> result = new ArrayList<ProcessSchedulerRS>();

		    ProcessSchedulerRS dto = new ProcessSchedulerRS();

		    while (rs.next()) {
			dto = new ProcessSchedulerRS();
			horaInicio = rs.getString("horaInicio");
			dto.setHoraInicio(horaInicio);

			minutoInicio = rs.getString("minutoInicio");
			dto.setMinutoInicio(minutoInicio);

			processId = rs.getString("processId");
			dto.setProcessId(processId);
			isLunes = rs.getInt("isLunes");
			dto.setIsLunes(isLunes);
			isMartes = rs.getInt("isMartes");
			dto.setIsMartes(isMartes);
			isMiercoles = rs.getInt("isMiercoles");
			dto.setIsMiercoles(isMiercoles);
			isJueves = rs.getInt("isJueves");
			dto.setIsJueves(isJueves);
			isViernes = rs.getInt("isViernes");
			dto.setIsViernes(isViernes);
			isSabado = rs.getInt("isSabado");
			dto.setIsSabado(isSabado);
			isDomingo = rs.getInt("isDomingo");
			dto.setIsDomingo(isDomingo);
			dto.setInitDate(rs.getDate("initDate"));
			dto.setEndDate(rs.getDate("endDate"));
			result.add(dto);
		    }

		    dto = new ProcessSchedulerRS();
		    for (int i = 0; i <= result.size() - 1; i++) {
			dto = new ProcessSchedulerRS();

			dto = result.get(i);
			if (day == 1) // domingo
			{
			    if (dto.getIsDomingo() == 1)

			    {

				validarInicioProceso(hour, min, dto);
			    }

			}
			if (day == 2) // Lunes
			{
			    if (dto.getIsLunes() == 1)

			    {

				validarInicioProceso(hour, min, dto);
			    }

			}
			if (day == 3) // Martes
			{
			    if (dto.getIsMartes() == 1)

			    {

				validarInicioProceso(hour, min, dto);
			    }

			}
			if (day == 4) // Miercoles
			{
			    if (dto.getIsMiercoles() == 1)

				validarInicioProceso(hour, min, dto);
			}
			if (day == 5) // Jueves
			{
			    if (dto.getIsJueves() == 1)

				validarInicioProceso(hour, min, dto);

			}
			if (day == 6) // Viernes
			{
			    if (dto.getIsViernes() == 1) {

				validarInicioProceso(hour, min, dto);

			    }
			}
			if (day == 7) // Sabado
			{
			    if (dto.getIsSabado() == 1) {

				validarInicioProceso(hour, min, dto);
			    }
			}

		    }
		    con.close();
		} catch (SQLException ex) {
		    System.out.println("Error de mysql :" + ex);
		} catch (Exception e) {
		    System.out.println("Se produjo un error inesperado: " + e.getMessage());
		}

	    }

	};
	Timer timer = new Timer();
	// Dentro de 0 milisegundos avísame cada 1000 milisegundos
	timer.scheduleAtFixedRate(timerTask, 0, 1000 * 60);
    }

    private void validarInicioProceso(int hour, int min, ProcessSchedulerRS dto) {

	Date actual = Calendar.getInstance().getTime();

	DefinitionsRS definitionRS = new DefinitionsRS();
	// despues de la fecha de inicio
	if (dto.getInitDate() == null || dto.getEndDate() == null) {
	    generarInicioProceso(hour, min, dto, definitionRS);
	} else {

	    Calendar c1 = Calendar.getInstance();
	    c1.setTime(actual);
	    c1.set(Calendar.HOUR, 0);
	    c1.set(Calendar.MINUTE, 0);
	    c1.set(Calendar.SECOND, 0);
	    c1.set(Calendar.MILLISECOND, 0);

	    actual = c1.getTime();

	    Date initDate = dto.getInitDate();
	    Date endDate = dto.getEndDate();

	    c1.setTime(initDate);
	    c1.set(Calendar.HOUR, 0);
	    c1.set(Calendar.MINUTE, 0);
	    c1.set(Calendar.SECOND, 0);
	    c1.set(Calendar.MILLISECOND, 0);

	    dto.setInitDate(c1.getTime());

	    c1.setTime(endDate);
	    c1.set(Calendar.HOUR, 0);
	    c1.set(Calendar.MINUTE, 0);
	    c1.set(Calendar.SECOND, 0);
	    c1.set(Calendar.MILLISECOND, 0);

	    dto.setEndDate(c1.getTime());

	    if (actual.after(dto.getInitDate()) && actual.before(dto.getEndDate())) {
		log.info(":[startUpTimer:] existe diferencia de fechas");

		generarInicioProceso(hour, min, dto, definitionRS);
	    } else if (actual.compareTo(dto.getInitDate()) == 0) {

		log.info(":[startUpTimer:] las fechas de inicio y fin son iguales");
		generarInicioProceso(hour, min, dto, definitionRS);
	    }
	}
    }

    private void generarInicioProceso(int hour, int min, ProcessSchedulerRS dto, DefinitionsRS definitionRS) {

	definitionRS.setId(dto.getProcessId());
	log.info("[iniciarProceso] proceso para el dia actual " + dto.getProcessId());
	log.info("[iniciarProceso] HORA INICIO :" + dto.getHoraInicio());
	log.info("[iniciarProceso] Minuto INICIO :" + dto.getMinutoInicio());
	log.info("[iniciarProceso] HORA ACTUAL :" + hour);
	log.info("[iniciarProceso] Minutos actual " + min);

	log.info("[iniciarProceso] : Validar si es inicio de proceso");
	int horaInicio = Integer.valueOf(dto.getHoraInicio()).intValue();
	int minutoInicio = Integer.valueOf(dto.getMinutoInicio()).intValue();

	if (horaInicio == hour) {

	    log.info("[iniciarProceso] la hora es la misma  :" + horaInicio);
	    log.info("[iniciarProceso] el minuto de inicio es : " + minutoInicio);
	    log.info("[iniciarProceso] el minuto a validar es : " + min);

	    if (minutoInicio == min) {

		log.info("[iniciarProceso] : INICIAR PROCESO !");

		try {

		    String host = bundle.getString("process.host");

		    HttpClient client = new DefaultHttpClient();
		    HttpPost post = new HttpPost("http://" + host + "/BPMConsoleApp/BPMConsoleApp/complete");
		    try {
			// Add your data
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("user", "admin"));
			nameValuePairs.add(new BasicNameValuePair("password", "admin"));
			nameValuePairs.add(new BasicNameValuePair("_e_pID", dto.getProcessId()));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			// executing the POST request
			HttpResponse rsp = client.execute(post);

			// reading response data
			HttpEntity entity = rsp.getEntity();
			InputStream inputStream = entity.getContent();
			String response = convertStreamToString(inputStream);

		    } catch (ClientProtocolException e) {
			e.printStackTrace();
		    } catch (IOException e) {
			e.printStackTrace();
		    }

		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }

	}
    }

    private String convertStreamToString(InputStream is) {

	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	StringBuilder sb = new StringBuilder();

	String line = null;
	try {
	    while ((line = reader.readLine()) != null) {
		sb.append(line + "\n");
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		is.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return sb.toString();
    }

    private Connection getConnection() {
	try {
	    // Cargamos el puente JDBC =&gt; Mysql
	    log.info("::getConnection: Intentando cargar el conector...");
	    Class.forName("com.mysql.jdbc.Driver");

	    // Intentamos conectarnos a la base de Datos en este caso una base
	    // llamada temp
	    System.out.println("Conectando a la base...");

	    String database = bundle.getString("database.host");
	    String user = bundle.getString("database.user");
	    String password = bundle.getString("database.password");

	    Connection con = DriverManager.getConnection("jdbc:mysql://" + database, user, password);
	    log.info("::getConnection:: Conexion a BD establecida");
	    return con;
	} catch (SQLException ex) {
	    log.log(Level.SEVERE, "Error de conexión a mysql : " + ex.getMessage());
	    return null;
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	    return null;
	} catch (Exception e) {
	    log.info("::getConnection:: Se produjo un error inesperado: " + e.getMessage());
	    return null;
	}
    }
}
