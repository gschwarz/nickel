/*
 * Copyright 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.rhiscom.bpm.console.client.mapper;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.activity.AsignedTaskConsoleCellTableActivity;
import com.rhiscom.bpm.console.client.activity.BusinessGroupMaintainerCellTableActivity;
import com.rhiscom.bpm.console.client.activity.BusinessUnitMaintainerCellTableActivity;
import com.rhiscom.bpm.console.client.activity.CellTableEstadoTiendaActivity;
import com.rhiscom.bpm.console.client.activity.CuadraturaActivacionGiftCardActivity;
import com.rhiscom.bpm.console.client.activity.CuadraturaAvanceSuperAvanceActivity;
import com.rhiscom.bpm.console.client.activity.CuadraturaNotaCreditoActivity;
import com.rhiscom.bpm.console.client.activity.CuadraturaPagosCMRActivity;
import com.rhiscom.bpm.console.client.activity.CuadraturaTarjetaCreditoActivity;
import com.rhiscom.bpm.console.client.activity.CuadraturaTarjetaDebitoActivity;
import com.rhiscom.bpm.console.client.activity.CuadraturaVentasGiftCardActivity;
import com.rhiscom.bpm.console.client.activity.CuadraturaVtaCMRActivity;
import com.rhiscom.bpm.console.client.activity.DashBoardBAMPActivity;
import com.rhiscom.bpm.console.client.activity.DeleteDataViewActivity;
import com.rhiscom.bpm.console.client.activity.EmailConfigurationActivity;
import com.rhiscom.bpm.console.client.activity.EmailRecipientsConfigurationActivity;
import com.rhiscom.bpm.console.client.activity.EventATNMonitorActivity;
import com.rhiscom.bpm.console.client.activity.LeftSideActivity;
import com.rhiscom.bpm.console.client.activity.LoginPanelActivity;
import com.rhiscom.bpm.console.client.activity.MonitoringProcessActivity;
import com.rhiscom.bpm.console.client.activity.MonitoringTaskConsoleCellTableActivity;
import com.rhiscom.bpm.console.client.activity.POSVersionMaintainerViewActivity;
import com.rhiscom.bpm.console.client.activity.ProcessConsoleCellTableActivity;
import com.rhiscom.bpm.console.client.activity.ProcessCoreCaseManagementActivity;
import com.rhiscom.bpm.console.client.activity.ProcessManagementViewActivity;
import com.rhiscom.bpm.console.client.activity.ProcessSchedulerActivity;
import com.rhiscom.bpm.console.client.activity.ProfileMaintainerCellTableActivity;
import com.rhiscom.bpm.console.client.activity.ResolverGroupMaintainerCellTableActivity;
import com.rhiscom.bpm.console.client.activity.RootActivity;
import com.rhiscom.bpm.console.client.activity.UnassignedTaskConsoleCellTableActivity;
import com.rhiscom.bpm.console.client.activity.UserMaintainerCellTableActivity;
import com.rhiscom.bpm.console.client.place.AsignedTaskConsoleCellTablePlace;
import com.rhiscom.bpm.console.client.place.BusinessGroupMaintainerCellTablePlace;
import com.rhiscom.bpm.console.client.place.BusinessUnitMaintainerCellTablePlace;
import com.rhiscom.bpm.console.client.place.CellTableEstadoTiendaPlace;
import com.rhiscom.bpm.console.client.place.CuadraturaActivacionGiftCardPlace;
import com.rhiscom.bpm.console.client.place.CuadraturaAvanceSuperAvancePlace;
import com.rhiscom.bpm.console.client.place.CuadraturaNotaCreditoPlace;
import com.rhiscom.bpm.console.client.place.CuadraturaPagosCMRPlace;
import com.rhiscom.bpm.console.client.place.CuadraturaTarjetaCreditoPlace;
import com.rhiscom.bpm.console.client.place.CuadraturaTarjetaDebitoPlace;
import com.rhiscom.bpm.console.client.place.CuadraturaVentasGiftCardPlace;
import com.rhiscom.bpm.console.client.place.CuadraturaVtaCMRViewPlace;
import com.rhiscom.bpm.console.client.place.DashBoardBAMPlace;
import com.rhiscom.bpm.console.client.place.DeleteDataViewPlace;
import com.rhiscom.bpm.console.client.place.EmailConfigurationPlace;
import com.rhiscom.bpm.console.client.place.EmailRecipientsConfigurationPlace;
import com.rhiscom.bpm.console.client.place.EventATNMonitorPlace;
import com.rhiscom.bpm.console.client.place.LeftSidePlace;
import com.rhiscom.bpm.console.client.place.LoginPanelPlace;
import com.rhiscom.bpm.console.client.place.MonitoringProcessPlace;
import com.rhiscom.bpm.console.client.place.MonitoringTaskConsolePlace;
import com.rhiscom.bpm.console.client.place.POSVersionMaintainerViewPlace;
import com.rhiscom.bpm.console.client.place.ProcessConsoleCellTablePlace;
import com.rhiscom.bpm.console.client.place.ProcessCoreCaseManagementPlace;
import com.rhiscom.bpm.console.client.place.ProcessManagementPlace;
import com.rhiscom.bpm.console.client.place.ProcessSchedulerPlace;
import com.rhiscom.bpm.console.client.place.ProfileMaintainerCellTablePlace;
import com.rhiscom.bpm.console.client.place.ResolverGroupMaintainerCellTablePlace;
import com.rhiscom.bpm.console.client.place.RootPlace;
import com.rhiscom.bpm.console.client.place.UnassignedTaskConsoleCellTablePlace;
import com.rhiscom.bpm.console.client.place.UserMaintainerCellTablePlace;

public class AppActivityMapper implements ActivityMapper {

    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
	super();
	this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {

	if (place instanceof CellTableEstadoTiendaPlace)
	    return new CellTableEstadoTiendaActivity((CellTableEstadoTiendaPlace) place, clientFactory);
	else if (place instanceof ProcessConsoleCellTablePlace)
	    return new ProcessConsoleCellTableActivity((ProcessConsoleCellTablePlace) place, clientFactory);
	else if (place instanceof LeftSidePlace)
	    return new LeftSideActivity((LeftSidePlace) place, clientFactory);
	else if (place instanceof RootPlace)
	    return new RootActivity((RootPlace) place, clientFactory);
	else if (place instanceof LoginPanelPlace)
	    return new LoginPanelActivity((LoginPanelPlace) place, clientFactory);
	else if (place instanceof AsignedTaskConsoleCellTablePlace)
	    return new AsignedTaskConsoleCellTableActivity((AsignedTaskConsoleCellTablePlace) place, clientFactory);
	else if (place instanceof UnassignedTaskConsoleCellTablePlace)
	    return new UnassignedTaskConsoleCellTableActivity((UnassignedTaskConsoleCellTablePlace) place,
		    clientFactory);
	else if (place instanceof ResolverGroupMaintainerCellTablePlace)
	    return new ResolverGroupMaintainerCellTableActivity((ResolverGroupMaintainerCellTablePlace) place,
		    clientFactory);
	else if (place instanceof BusinessGroupMaintainerCellTablePlace)
	    return new BusinessGroupMaintainerCellTableActivity((BusinessGroupMaintainerCellTablePlace) place,
		    clientFactory);
	else if (place instanceof UserMaintainerCellTablePlace)
	    return new UserMaintainerCellTableActivity((UserMaintainerCellTablePlace) place, clientFactory);
	else if (place instanceof ProfileMaintainerCellTablePlace)
	    return new ProfileMaintainerCellTableActivity((ProfileMaintainerCellTablePlace) place, clientFactory);
	else if (place instanceof BusinessUnitMaintainerCellTablePlace)
	    return new BusinessUnitMaintainerCellTableActivity((BusinessUnitMaintainerCellTablePlace) place,
		    clientFactory);
	else if (place instanceof DashBoardBAMPlace)
	    return new DashBoardBAMPActivity((DashBoardBAMPlace) place, clientFactory);

	else if (place instanceof EventATNMonitorPlace) {
	    return new EventATNMonitorActivity((EventATNMonitorPlace) place, clientFactory);
	} else if (place instanceof MonitoringTaskConsolePlace) {
	    return new MonitoringTaskConsoleCellTableActivity((MonitoringTaskConsolePlace) place, clientFactory);

	} else if (place instanceof ProcessManagementPlace) {
	    return new ProcessManagementViewActivity((ProcessManagementPlace) place, clientFactory);

	} else if (place instanceof ProcessSchedulerPlace) {
	    return new ProcessSchedulerActivity((ProcessSchedulerPlace) place, clientFactory);

	} else if (place instanceof EmailConfigurationPlace) {
	    return new EmailConfigurationActivity((EmailConfigurationPlace) place, clientFactory);

	} else if (place instanceof EmailRecipientsConfigurationPlace) {
	    return new EmailRecipientsConfigurationActivity((EmailRecipientsConfigurationPlace) place, clientFactory);

	} else if (place instanceof ProcessCoreCaseManagementPlace) {
	    return new ProcessCoreCaseManagementActivity((ProcessCoreCaseManagementPlace) place, clientFactory);

	}

	else if (place instanceof MonitoringProcessPlace) {
	    return new MonitoringProcessActivity((MonitoringProcessPlace) place, clientFactory);

	}

	else if (place instanceof CuadraturaVtaCMRViewPlace) {
	    return new CuadraturaVtaCMRActivity((CuadraturaVtaCMRViewPlace) place, clientFactory);

	} else if (place instanceof CuadraturaActivacionGiftCardPlace) {
	    return new CuadraturaActivacionGiftCardActivity((CuadraturaActivacionGiftCardPlace) place, clientFactory);

	} else if (place instanceof POSVersionMaintainerViewPlace) {
	    return new POSVersionMaintainerViewActivity((POSVersionMaintainerViewPlace) place, clientFactory);

	} else if (place instanceof CuadraturaVentasGiftCardPlace) {
	    return new CuadraturaVentasGiftCardActivity((CuadraturaVentasGiftCardPlace) place, clientFactory);

	} else if (place instanceof CuadraturaAvanceSuperAvancePlace) {
	    return new CuadraturaAvanceSuperAvanceActivity((CuadraturaAvanceSuperAvancePlace) place, clientFactory);

	} else if (place instanceof CuadraturaPagosCMRPlace) {
	    return new CuadraturaPagosCMRActivity((CuadraturaPagosCMRPlace) place, clientFactory);

	}

	else if (place instanceof CuadraturaTarjetaCreditoPlace) {
	    return new CuadraturaTarjetaCreditoActivity((CuadraturaTarjetaCreditoPlace) place, clientFactory);

	} else if (place instanceof CuadraturaNotaCreditoPlace) {
	    return new CuadraturaNotaCreditoActivity((CuadraturaNotaCreditoPlace) place, clientFactory);

	} else if (place instanceof CuadraturaTarjetaDebitoPlace) {
	    return new CuadraturaTarjetaDebitoActivity((CuadraturaTarjetaDebitoPlace) place, clientFactory);

	} else if (place instanceof DeleteDataViewPlace) {
	    return new DeleteDataViewActivity((DeleteDataViewPlace) place, clientFactory);

	}

	else
	    return null;

    }
}
