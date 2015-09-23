package com.rhiscom.bpm.console.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;

public class PermisionUtil {

    private static Map<String, Map<String, List<Object>>> viewsPermision;
    private static PermisionUtil instance = null;
    private static List<String> viewsList;
    private static Map<String, String> resultsMap;

    interface Resources extends ClientBundle {
	Resources INSTANCE = GWT.create(Resources.class);

	@Source("views.properties")
	TextResource views();

    }

    private PermisionUtil() {
	viewsPermision = new HashMap<String, Map<String, List<Object>>>();
	String views = Resources.INSTANCE.views().getText();
	viewsList = new ArrayList<String>(Arrays.asList(views.split(",")));
	resultsMap = new HashMap<String, String>();

	for (String view : viewsList) {
	    resultsMap.put(view.trim(), view.trim());
	}
	/**
	 * Vista de los procesos.
	 */
	if (resultsMap.containsKey("mproc_fnproc".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnIniciarProceso", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnDetenerInstancia", listPermision);

	    viewsPermision.put("mproc_fnproc", access);

	}

	if (resultsMap.containsKey("mngproc_fnprocmng".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnIniciarProceso", listPermision);

	    viewsPermision.put("mngproc_fnprocmng", access);

	}
	/**
	 * Vista de los tareas.
	 */
	if (resultsMap.containsKey("mtskmng_fntsk".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");
	    listPermision.add("ver");
	    listPermision.add("eliminar");

	    access.put("verTareaBtn", listPermision);

	    viewsPermision.put("mtskmng_fntsk", access);

	}
	/**
	 * Vista de la autoasignación de tareas
	 */
	if (resultsMap.containsKey("mtskmng_fnaut".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");
	    listPermision.add("eliminar");

	    access.put("asignarTareaBtn", listPermision);

	    viewsPermision.put("mtskmng_fnaut", access);

	}
	/**
	 * Vista de la grupos de unidades de negocio
	 */
	if (resultsMap.containsKey("madm_fnbng".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnAgregar", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");
	    listPermision.add("ver");

	    access.put("editarBtn", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");
	    access.put("btnGuardar", listPermision);

	    viewsPermision.put("madm_fnbng", access);

	}
	/**
	 * Vista de la grupos de unidades de negocio
	 */
	if (resultsMap.containsKey("madm_fnbunit".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnAgregar", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");
	    listPermision.add("ver");

	    access.put("editarBtn", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnGuardar", listPermision);

	    viewsPermision.put("madm_fnbng", access);

	}
	/**
	 * Vista de Usuarios
	 */
	if (resultsMap.containsKey("madm_fnusr".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnAgregar", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");
	    listPermision.add("ver");

	    access.put("editarBtn", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("eliminar");
	    listPermision.add("administrar");

	    access.put("deleteBtn", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnGuardar", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnAgregarWorkGroup", listPermision);

	    viewsPermision.put("madm_fnusr", access);

	}
	/**
	 * Vista grupos resolutores
	 */
	if (resultsMap.containsKey("madm_fnwkg".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnAgregar", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("eliminar");
	    listPermision.add("administrar");

	    access.put("eliminarBtn", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("administrar");
	    listPermision.add("ver");

	    access.put("editarBtn", listPermision);

	    viewsPermision.put("madm_fnwkg", access);
	}

	if (resultsMap.containsKey("madm_fnposversion".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnAgregar", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("eliminar");
	    listPermision.add("administrar");

	    access.put("eliminarBtn", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("administrar");
	    listPermision.add("ver");

	    access.put("editarBtn", listPermision);

	    viewsPermision.put("madm_fnposversion", access);
	}

	if (resultsMap.containsKey("madm_posversion".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnAgregar", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("eliminar");
	    listPermision.add("administrar");

	    access.put("eliminarBtn", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("administrar");
	    listPermision.add("ver");

	    access.put("editarBtn", listPermision);

	    viewsPermision.put("madm_posversion", access);
	}

	if (resultsMap.containsKey("madm_deletedata".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("eliminar");
	    listPermision.add("administrar");

	    access.put("button", listPermision);

	    viewsPermision.put("madm_deletedata", access);
	}

	/**
	 * Vista perfiles
	 */
	if (resultsMap.containsKey("madm_fnprf".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();
	    listPermision.add("crear");
	    listPermision.add("administrar");

	    access.put("btnAgregar", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("eliminar");
	    listPermision.add("administrar");

	    access.put("eliminarBtn", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("administrar");
	    listPermision.add("ver");

	    access.put("editarBtn", listPermision);

	    listPermision = new ArrayList<Object>();
	    listPermision.add("administrar");

	    access.put("btnGuardar", listPermision);

	    viewsPermision.put("madm_fnprf", access);
	}

	if (resultsMap.containsKey("madm_fnemail".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();

	    listPermision.add("administrar");
	    listPermision.add("ver");
	    access.put("btnGuardar", listPermision);
	    viewsPermision.put("madm_fnemail", access);
	}

	if (resultsMap.containsKey("madm_fnemailrecipients".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();

	    List<Object> listPermision = new ArrayList<Object>();

	    listPermision.add("administrar");
	    listPermision.add("ver");
	    access.put("btnGuardarDest", listPermision);
	    viewsPermision.put("madm_fnemailrecipients", access);
	}

	/**
	 * Vista Reportes
	 */
	if (resultsMap.containsKey("mrpt_fnbam".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();
	    viewsPermision.put("mrpt_fnbam", access);
	}

	if (resultsMap.containsKey("mrpt_fnbamdash".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();
	    viewsPermision.put("mrpt_fnbamdash", access);
	}

	if (resultsMap.containsKey("mrpt_fnbamdashatn".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();
	    viewsPermision.put("mrpt_fnbamdashatn", access);
	}

	if (resultsMap.containsKey("mrpt_cuadvtacmr".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();
	    viewsPermision.put("mrpt_cuadvtacmr", access);
	}
	if (resultsMap.containsKey("mrpt_cuadactgiftcard".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();
	    viewsPermision.put("mrpt_cuadactgiftcard", access);
	}
	if (resultsMap.containsKey("mrpt_cuadvtagiftcard".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();
	    viewsPermision.put("mrpt_cuadvtagiftcard", access);
	}
	if (resultsMap.containsKey("mrpt_cuadavancesuperavance".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();
	    viewsPermision.put("mrpt_cuadavancesuperavance", access);
	}
	if (resultsMap.containsKey("mrpt_cuadpagoscmr".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();
	    viewsPermision.put("mrpt_cuadpagoscmr", access);
	}

	if (resultsMap.containsKey("mrpt_cuadtarjetacredito".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();
	    viewsPermision.put("mrpt_cuadtarjetacredito", access);
	}
	if (resultsMap.containsKey("mrpt_cuadnotacredito".trim())) {
	    Map<String, List<Object>> access = new HashMap<String, List<Object>>();
	    viewsPermision.put("mrpt_cuadnotacredito", access);
	}

    }

    public static PermisionUtil getInstance() {

	if (instance == null)
	    instance = new PermisionUtil();
	return instance;
    }

    public List<String> getViews() {

	return viewsList;
    }

    public boolean checkPermision(List<AbilityDTO> abilityList, String view, String action) {

	Map<String, List<Object>> access = viewsPermision.get(view);
	if (access != null) {
	    List<Object> list = access.get(action);

	    for (int i = 0; i <= abilityList.size() - 1; i++) {

		if (list.contains(abilityList.get(i).getName().trim())) {
		    return true;

		}

	    }
	} else {
	    return true;
	}

	return false;
    }
}
