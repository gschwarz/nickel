package com.rhiscom.bpm.console.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.rhiscom.bpm.console.client.event.DeleteProfileEvent;
import com.rhiscom.bpm.console.client.event.DeleteProfileEventHandler;
import com.rhiscom.bpm.console.client.event.UpdateProfileEvent;
import com.rhiscom.bpm.console.client.remote.SecurityService;
import com.rhiscom.bpm.console.client.remote.SecurityServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;

public class LocalDataBaseObject {

    private List<ProfileDTO> profileGlobalList;
    private List<OperatorDTO> operatorGlobalList;
    private List<AbilityDTO> abilityGlobalList;
    private List<FunctionalityModuleDTO> moduleGlobalList;
    private List<ResolverGroupDTO> workGroupGlobalList;
    private ClientFactory clientFactory;
    final SecurityServiceAsync service;
    private static LocalDataBaseObject instance = null;

    private LocalDataBaseObject(ClientFactory clientFactory2) {
	this.clientFactory = clientFactory2;
	service = GWT.create(SecurityService.class);
	EventBus eventBusLogin = new SimpleEventBus();

	eventBusLogin.addHandler(DeleteProfileEvent.TYPE, new DeleteProfileEventHandler() {

	    @Override
	    public void delete(DeleteProfileEvent event) {
		ProfileDTO profile = event.profile;
		eliminarPerfil(profile);

	    }

	});

	/*
	 * traerTodosLosPerfiles(); traerTodasLasHabilidades();
	 * traerTodosLosModulos();
	 */

    }

    public static LocalDataBaseObject getInstance(ClientFactory clientFactory) {
	if (instance == null)
	    instance = new LocalDataBaseObject(clientFactory);
	return instance;
    }

    public static LocalDataBaseObject getInstance() {
	return instance;
    }

    public List<ProfileDTO> getProfileGlobalList() {
	return profileGlobalList;
    }

    public List<OperatorDTO> getOperatorGlobalList() {
	return operatorGlobalList;
    }

    public List<AbilityDTO> getAbilityGlobalList() {
	return abilityGlobalList;

    }

    public List<FunctionalityModuleDTO> getModuleGlobalList() {
	return moduleGlobalList;
    }

    private void traerTodosLosPerfiles() {
	try {

	    service.getAllProfiles(new AsyncCallback<List<ProfileDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error traer prefiles :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(List<ProfileDTO> list) {
		    profileGlobalList = list;
		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog("Error traer perfiles :" + ex.toString());
	    dialog.center();
	    dialog.show();
	}

    }

    private void traerTodasLasHabilidades() {
	try {

	    service.getAllAbilityes(new AsyncCallback<List<AbilityDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error traer prefiles :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(List<AbilityDTO> list) {
		    abilityGlobalList = list;
		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog("Error traer perfiles :" + ex.toString());
	    dialog.center();
	    dialog.show();
	}

    }

    private void traerTodosLosModulos() {
	try {

	    service.getAllModules(new AsyncCallback<List<FunctionalityModuleDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error traer prefiles :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(List<FunctionalityModuleDTO> list) {
		    moduleGlobalList = list;
		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog("Error traer perfiles :" + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

    private void eliminarPerfil(ProfileDTO profileDTO) {

	try {

	    service.deleteProfile(profileDTO, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error al eliminar perfil :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {
		    clientFactory.getEventBus().fireEvent(new UpdateProfileEvent());
		    traerTodosLosPerfiles();

		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog("Error al eliminar perfil :" + ex.toString());
	    dialog.center();
	    dialog.show();
	}

    }
}