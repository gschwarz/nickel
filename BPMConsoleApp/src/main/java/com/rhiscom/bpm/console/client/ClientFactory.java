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
package com.rhiscom.bpm.console.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaView;
import com.rhiscom.bpm.console.client.ui.DashBoardHomeView;
import com.rhiscom.bpm.console.client.ui.MainView;
import com.rhiscom.bpm.console.client.ui.RightSide;
import com.rhiscom.bpm.console.client.ui.administration.BusinessGroupMaintainerCellTableView;
import com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableView;
import com.rhiscom.bpm.console.client.ui.administration.DeleteDataView;
import com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationView;
import com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationView;
import com.rhiscom.bpm.console.client.ui.administration.POSVersionMaintainerView;
import com.rhiscom.bpm.console.client.ui.administration.ResolverGroupMaintainerCellTableView;
import com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableView;
import com.rhiscom.bpm.console.client.ui.administration.profile.ProfileMaintainerCellTableView;
import com.rhiscom.bpm.console.client.ui.bam.DashBoardBAM;
import com.rhiscom.bpm.console.client.ui.bam.EventATNMonitor;
import com.rhiscom.bpm.console.client.ui.bam.MonitoringProcessView;
import com.rhiscom.bpm.console.client.ui.bam.ReportView;
import com.rhiscom.bpm.console.client.ui.menu.LeftSide;
import com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableView;
import com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementView;
import com.rhiscom.bpm.console.client.ui.process.ProcessManagementView;
import com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaAvanceSuperAvanceView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaNotaCreditoView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaPagosCMRView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaTarjetaCreditoView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaTarjetaDebitoView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaVentasGiftCardView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaVtaCMRView;
import com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableView;
import com.rhiscom.bpm.console.client.ui.task.MonitoringTaskConsoleCellTableView;
import com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableView;

/**
 * Client Factory Interface
 * 
 * @author L.Pelov
 */
public interface ClientFactory {
    EventBus getEventBus();

    PlaceController getPlaceController();

    MainView getRootView();

    LeftSide getLeftSide();

    RightSide getRightSide();

    CellTableEstadoTiendaView getCellTableEstadoTiendaView();

    ProcessConsoleCellTableView getProcessConsoleCellTableView();

    AsignedTaskConsoleCellTableView getAsignedTaskConsoleCellTableView();

    UnassignedTaskConsoleCellTableView getUnassignedTaskConsoleCellTableView();

    ResolverGroupMaintainerCellTableView getResolverGroupMaintainerCellTableView();

    BusinessGroupMaintainerCellTableView getBusinessGroupMaitainerCellTableView();

    UserMaintainerCellTableView getUserMaintainerCellTableView();

    DashBoardHomeView getDashBoardHomeView();

    ProfileMaintainerCellTableView getProfileMaintainerCellView();

    ReportView getReportView();

    BusinessUnitMaintainerCellTableView getBusinessUnitView();

    DashBoardBAM getDashBoardBAM();

    EventATNMonitor getAtnMonitor();

    MonitoringTaskConsoleCellTableView getMonitoringTaskConsoleCellTableView();

    ProcessManagementView getProcessConsoleManagementView();

    ProcessSchedulerView getProcessSchedulertView();

    EmailConfigurationView getEmailConfigurator();

    EmailRecipientsConfigurationView getEmailRecipientsConfigurationView();

    ProcessCoreCaseManagementView getProcessCoreCaseManagementView();

    MonitoringProcessView getProcessHistoryMonitor();

    CuadraturaVtaCMRView getCuadraturaVtaCRM();

    CuadraturaActivacionGiftCardView getCuadraturaActifacionGiftCard();

    POSVersionMaintainerView getPosVersionCellTableView();

    CuadraturaVentasGiftCardView getCuadraturaVentasGiftCardView();

    CuadraturaAvanceSuperAvanceView getCuadraturaAvanceSuperAvanceViewImpl();

    CuadraturaPagosCMRView getCuadraturaPagosCMRView();

    CuadraturaTarjetaCreditoView getCuadraturaTarjetaCreditoView();

    CuadraturaNotaCreditoView getCuadraturaNotaCreditoView();

    CuadraturaTarjetaDebitoView getCuadraturaTarjetaDebitoView();

    DeleteDataView getDeleteDataView();

}
