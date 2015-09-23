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
import com.rhiscom.bpm.console.client.activity.DashBoardHomeViewActivity;
import com.rhiscom.bpm.console.client.activity.DeleteDataViewActivity;
import com.rhiscom.bpm.console.client.activity.EmailConfigurationActivity;
import com.rhiscom.bpm.console.client.activity.EmailRecipientsConfigurationActivity;
import com.rhiscom.bpm.console.client.activity.EventATNMonitorActivity;
import com.rhiscom.bpm.console.client.activity.MonitoringProcessActivity;
import com.rhiscom.bpm.console.client.activity.MonitoringTaskConsoleCellTableActivity;
import com.rhiscom.bpm.console.client.activity.POSVersionMaintainerViewActivity;
import com.rhiscom.bpm.console.client.activity.ProcessConsoleCellTableActivity;
import com.rhiscom.bpm.console.client.activity.ProcessCoreCaseManagementActivity;
import com.rhiscom.bpm.console.client.activity.ProcessManagementViewActivity;
import com.rhiscom.bpm.console.client.activity.ProcessSchedulerActivity;
import com.rhiscom.bpm.console.client.activity.ProfileMaintainerCellTableActivity;
import com.rhiscom.bpm.console.client.activity.ReportViewActivity;
import com.rhiscom.bpm.console.client.activity.ResolverGroupMaintainerCellTableActivity;
import com.rhiscom.bpm.console.client.activity.UnassignedTaskConsoleCellTableActivity;
import com.rhiscom.bpm.console.client.activity.UserMaintainerCellTableActivity;
import com.rhiscom.bpm.console.client.place.RootPlace;

/**
 * Activity Mapper handles the clicks on the right panel
 * 
 * @author L.Pelov
 */
public class RightActivityMapper implements ActivityMapper {

    private ClientFactory clientFactory;

    public RightActivityMapper(ClientFactory clientFactory) {
	super();
	this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
	// The activity you will get here, is the one from the RootView!!!

	if (place instanceof RootPlace) {
	    String name = ((RootPlace) place).getRootName();

	    if (name.equalsIgnoreCase("rootview")) {
		return new DashBoardHomeViewActivity(null, clientFactory);
	    }

	    if (name.equalsIgnoreCase("estadoTienda")) {
		return new CellTableEstadoTiendaActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("processConsole")) {
		return new ProcessConsoleCellTableActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("asignedTaskConsole")) {
		return new AsignedTaskConsoleCellTableActivity(null, clientFactory);
	    }

	    if (name.equalsIgnoreCase("unassignedTaskConsole")) {
		return new UnassignedTaskConsoleCellTableActivity(null, clientFactory);
	    }

	    if (name.equalsIgnoreCase("resolveGroupMaintainer")) {
		return new ResolverGroupMaintainerCellTableActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("businessGroupMaintainer")) {
		return new BusinessGroupMaintainerCellTableActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("userMaintainer")) {
		return new UserMaintainerCellTableActivity(null, clientFactory);
	    }

	    if (name.equalsIgnoreCase("profilesMaintainer")) {
		return new ProfileMaintainerCellTableActivity(null, clientFactory);
	    }

	    if (name.equalsIgnoreCase("reportsActivity")) {
		return new ReportViewActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("businessUnitMaintainer")) {
		return new BusinessUnitMaintainerCellTableActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("dashBoardActivity")) {
		return new DashBoardBAMPActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("atnMonitor")) {
		return new EventATNMonitorActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("taskMonitoring")) {
		return new MonitoringTaskConsoleCellTableActivity(null, clientFactory);
	    }

	    if (name.equalsIgnoreCase("processManagement")) {
		return new ProcessManagementViewActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("processScheduler")) {
		return new ProcessSchedulerActivity(null, clientFactory);
	    }

	    if (name.equalsIgnoreCase("emailConfiguration")) {
		return new EmailConfigurationActivity(null, clientFactory);
	    }

	    if (name.equalsIgnoreCase("recipientsConfiguration")) {
		return new EmailRecipientsConfigurationActivity(null, clientFactory);
	    }

	    if (name.equalsIgnoreCase("processCoreCase")) {
		return new ProcessCoreCaseManagementActivity(null, clientFactory);
	    }

	    if (name.equalsIgnoreCase("monitoringProcess")) {
		return new MonitoringProcessActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("cuadraturaVtaCRM")) {
		return new CuadraturaVtaCMRActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("cuadraturaActGiftCard")) {
		return new CuadraturaActivacionGiftCardActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("posVersion")) {
		return new POSVersionMaintainerViewActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("deleteData")) {
		return new DeleteDataViewActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("cuadraturaVtaGiftcard")) {
		return new CuadraturaVentasGiftCardActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("cuadraturaAvanceSuperAvance")) {
		return new CuadraturaAvanceSuperAvanceActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("cuadraturaPagosCMR")) {
		return new CuadraturaPagosCMRActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("cuadraturaTarjetaCredito")) {
		return new CuadraturaTarjetaCreditoActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("cuadraturaNotaCredito")) {
		return new CuadraturaNotaCreditoActivity(null, clientFactory);
	    }
	    if (name.equalsIgnoreCase("cuadraturaTarjetaDebito")) {
		return new CuadraturaTarjetaDebitoActivity(null, clientFactory);
	    }

	}
	return null;

    }

}
