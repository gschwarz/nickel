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
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaView;
import com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl;
import com.rhiscom.bpm.console.client.ui.DashBoardHomeView;
import com.rhiscom.bpm.console.client.ui.DashBoardHomeViewImpl;
import com.rhiscom.bpm.console.client.ui.MainView;
import com.rhiscom.bpm.console.client.ui.RightSide;
import com.rhiscom.bpm.console.client.ui.RootView;
import com.rhiscom.bpm.console.client.ui.administration.BusinessGroupMaintainerCellTableView;
import com.rhiscom.bpm.console.client.ui.administration.BusinessGroupMaintainerCellTableViewImpl;
import com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableView;
import com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableViewImpl;
import com.rhiscom.bpm.console.client.ui.administration.DeleteDataView;
import com.rhiscom.bpm.console.client.ui.administration.DeleteDataViewImpl;
import com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationView;
import com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationViewImpl;
import com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationView;
import com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationViewImpl;
import com.rhiscom.bpm.console.client.ui.administration.POSVersionMaintainerCellTableViewImpl;
import com.rhiscom.bpm.console.client.ui.administration.POSVersionMaintainerView;
import com.rhiscom.bpm.console.client.ui.administration.ResolverGroupMaintainerCellTableView;
import com.rhiscom.bpm.console.client.ui.administration.ResolverGroupMaintainerCellTableViewImpl;
import com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableView;
import com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl;
import com.rhiscom.bpm.console.client.ui.administration.profile.ProfileMaintainerCellTableView;
import com.rhiscom.bpm.console.client.ui.administration.profile.ProfileMaintainerCellTableViewImpl;
import com.rhiscom.bpm.console.client.ui.bam.DashBoardBAM;
import com.rhiscom.bpm.console.client.ui.bam.DashBoardBAMView;
import com.rhiscom.bpm.console.client.ui.bam.EventATNMonitor;
import com.rhiscom.bpm.console.client.ui.bam.EventATNMonitorView;
import com.rhiscom.bpm.console.client.ui.bam.MonitoringProcessView;
import com.rhiscom.bpm.console.client.ui.bam.MonitoringProcessViewImpl;
import com.rhiscom.bpm.console.client.ui.bam.ReportView;
import com.rhiscom.bpm.console.client.ui.bam.ReportViewImpl;
import com.rhiscom.bpm.console.client.ui.menu.LeftSide;
import com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableView;
import com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl;
import com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementView;
import com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementViewImpl;
import com.rhiscom.bpm.console.client.ui.process.ProcessManagementView;
import com.rhiscom.bpm.console.client.ui.process.ProcessManagementViewImpl;
import com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerView;
import com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerViewImpl;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardViewImpl;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaAvanceSuperAvanceView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaAvanceSuperAvanceViewImpl;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaNotaCreditoView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaNotaCreditoViewImpl;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaPagosCMRView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaPagosCMRViewImpl;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaTarjetaCreditoView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaTarjetaCreditoViewImpl;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaTarjetaDebitoView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaTarjetaDebitoViewImpl;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaVentasGiftCardView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaVentasGiftCardViewImpl;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaVtaCMRView;
import com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaVtaCMRViewImpl;
import com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableView;
import com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp;
import com.rhiscom.bpm.console.client.ui.task.MonitoringTaskConsoleCellTableView;
import com.rhiscom.bpm.console.client.ui.task.MonitoringTaskConsoleCellTableViewImp;
import com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableView;
import com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableViewImpl;

public class ClientFactoryImpl implements ClientFactory {

    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);

    private final MainView rootView = new RootView(this);
    private final LeftSide leftSide = new LeftSide(this);
    private final RightSide rightSide = new RightSide();
    private static DeleteDataView deleteDataView;

    private static CellTableEstadoTiendaView cellTableEstadoTiendaView = null;
    private static ProcessConsoleCellTableView processConsoleCellTableView = null;
    private static AsignedTaskConsoleCellTableView asignedTaskConsoleCellTableView = null;
    private static UnassignedTaskConsoleCellTableView unassignedTaskConsoleCellTableView = null;
    private static ResolverGroupMaintainerCellTableView resolverGroupMaintainerCellTableView = null;
    private static BusinessGroupMaintainerCellTableView businessGroupMaintainerCellTableView = null;
    private static UserMaintainerCellTableView userMaintainerCellTableView = null;

    private static ProfileMaintainerCellTableView profileMaintainerCellView = null;

    private static DashBoardHomeView dashBoardHomeView = null;
    private static ReportView reportView = null;
    private static BusinessUnitMaintainerCellTableView businessUnitView = null;
    private static DashBoardBAM dashBam = null;

    private static EventATNMonitor atnMonitor = null;
    private static MonitoringTaskConsoleCellTableView monitoringTask = null;

    private static EmailConfigurationView emailConfigurator = null;
    private static EmailRecipientsConfigurationView emailRecipientsConfigurator = null;

    private static ProcessManagementView processConsoleManagementView = null;
    private static ProcessSchedulerView processSchedulerView = null;

    private static ProcessCoreCaseManagementView processCoreCase = null;

    private static MonitoringProcessView monitoringProcessView = null;
    private static CuadraturaVtaCMRView cuadraturaVtaCMRView = null;

    private static CuadraturaActivacionGiftCardView cuadraturaActivacionView = null;

    private static POSVersionMaintainerView posVersionCellTableView = null;
    private static CuadraturaVentasGiftCardView cuadraturaVentasGiftCardView = null;
    private static CuadraturaAvanceSuperAvanceView cuadraturaAvanceSuperAvanceView = null;
    private static CuadraturaPagosCMRView cuadraturaPagosCMRView = null;
    private static CuadraturaTarjetaCreditoView cuadraturaTarjetaCredito = null;
    private static CuadraturaNotaCreditoView cuadraturaNotaCreditoView = null;
    private static CuadraturaTarjetaDebitoView cuadraturaTarjetaDebitoView = null;

    @Override
    public MonitoringTaskConsoleCellTableView getMonitoringTaskConsoleCellTableView() {
	if (monitoringTask == null) {
	    monitoringTask = new MonitoringTaskConsoleCellTableViewImp();
	}
	return monitoringTask;
    }

    @Override
    public DashBoardBAM getDashBoardBAM() {
	if (dashBam == null) {
	    dashBam = new DashBoardBAMView(this);
	}
	return dashBam;
    }

    @Override
    public EventBus getEventBus() {
	return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
	return placeController;
    }

    @Override
    public MainView getRootView() {
	return rootView;
    }

    @Override
    public LeftSide getLeftSide() {
	return leftSide;
    }

    @Override
    public RightSide getRightSide() {
	return rightSide;
    }

    @Override
    public CellTableEstadoTiendaView getCellTableEstadoTiendaView() {
	if (cellTableEstadoTiendaView == null) {
	    cellTableEstadoTiendaView = new CellTableEstadoTiendaViewImpl();
	}
	return cellTableEstadoTiendaView;
    }

    @Override
    public ProcessConsoleCellTableView getProcessConsoleCellTableView() {
	if (processConsoleCellTableView == null) {
	    processConsoleCellTableView = new ProcessConsoleCellTableViewImpl();
	}
	return processConsoleCellTableView;
    }

    @Override
    public AsignedTaskConsoleCellTableView getAsignedTaskConsoleCellTableView() {
	if (asignedTaskConsoleCellTableView == null) {
	    asignedTaskConsoleCellTableView = new AsignedTaskConsoleCellTableViewImp();
	}
	return asignedTaskConsoleCellTableView;
    }

    @Override
    public UnassignedTaskConsoleCellTableView getUnassignedTaskConsoleCellTableView() {
	if (unassignedTaskConsoleCellTableView == null) {
	    unassignedTaskConsoleCellTableView = new UnassignedTaskConsoleCellTableViewImpl();
	}
	return unassignedTaskConsoleCellTableView;
    }

    @Override
    public ResolverGroupMaintainerCellTableView getResolverGroupMaintainerCellTableView() {
	if (resolverGroupMaintainerCellTableView == null) {
	    resolverGroupMaintainerCellTableView = new ResolverGroupMaintainerCellTableViewImpl(this);
	}
	return resolverGroupMaintainerCellTableView;
    }

    @Override
    public BusinessGroupMaintainerCellTableView getBusinessGroupMaitainerCellTableView() {
	if (businessGroupMaintainerCellTableView == null) {
	    businessGroupMaintainerCellTableView = new BusinessGroupMaintainerCellTableViewImpl(this);
	}
	return businessGroupMaintainerCellTableView;
    }

    @Override
    public UserMaintainerCellTableView getUserMaintainerCellTableView() {
	if (userMaintainerCellTableView == null) {
	    userMaintainerCellTableView = new UserMaintainerCellTableViewImpl(this);
	}
	return userMaintainerCellTableView;
    }

    @Override
    public DashBoardHomeView getDashBoardHomeView() {
	if (dashBoardHomeView == null) {
	    dashBoardHomeView = new DashBoardHomeViewImpl(this);
	}
	return dashBoardHomeView;
    }

    @Override
    public ProfileMaintainerCellTableView getProfileMaintainerCellView() {
	if (profileMaintainerCellView == null) {
	    profileMaintainerCellView = new ProfileMaintainerCellTableViewImpl(this);
	}
	return profileMaintainerCellView;
    }

    @Override
    public ReportView getReportView() {
	if (reportView == null) {
	    reportView = new ReportViewImpl();
	}
	return reportView;
    }

    @Override
    public BusinessUnitMaintainerCellTableView getBusinessUnitView() {
	if (businessUnitView == null) {
	    businessUnitView = new BusinessUnitMaintainerCellTableViewImpl(this);
	}
	return businessUnitView;
    }

    @Override
    public EventATNMonitor getAtnMonitor() {
	if (atnMonitor == null) {
	    atnMonitor = new EventATNMonitorView();
	}
	return atnMonitor;
    }

    @Override
    public ProcessManagementView getProcessConsoleManagementView() {
	if (processConsoleManagementView == null) {
	    processConsoleManagementView = new ProcessManagementViewImpl();
	}
	return processConsoleManagementView;
    }

    @Override
    public EmailConfigurationView getEmailConfigurator() {
	if (emailConfigurator == null) {
	    emailConfigurator = new EmailConfigurationViewImpl();
	}
	return emailConfigurator;
    }

    @Override
    public EmailRecipientsConfigurationView getEmailRecipientsConfigurationView() {
	if (emailRecipientsConfigurator == null) {
	    emailRecipientsConfigurator = new EmailRecipientsConfigurationViewImpl();
	}
	return emailRecipientsConfigurator;
    }

    @Override
    public ProcessSchedulerView getProcessSchedulertView() {
	if (processSchedulerView == null) {
	    processSchedulerView = new ProcessSchedulerViewImpl();
	}
	return processSchedulerView;
    }

    @Override
    public ProcessCoreCaseManagementView getProcessCoreCaseManagementView() {
	if (processCoreCase == null) {
	    processCoreCase = new ProcessCoreCaseManagementViewImpl();
	}
	return processCoreCase;
    }

    @Override
    public MonitoringProcessView getProcessHistoryMonitor() {
	if (monitoringProcessView == null) {
	    monitoringProcessView = new MonitoringProcessViewImpl(this);
	}
	return monitoringProcessView;
    }

    @Override
    public CuadraturaVtaCMRView getCuadraturaVtaCRM() {
	if (cuadraturaVtaCMRView == null) {
	    cuadraturaVtaCMRView = new CuadraturaVtaCMRViewImpl();
	}
	return cuadraturaVtaCMRView;
    }

    @Override
    public CuadraturaActivacionGiftCardView getCuadraturaActifacionGiftCard() {
	if (cuadraturaActivacionView == null) {
	    cuadraturaActivacionView = new CuadraturaActivacionGiftCardViewImpl();
	}
	return cuadraturaActivacionView;
    }

    @Override
    public POSVersionMaintainerView getPosVersionCellTableView() {
	if (posVersionCellTableView == null) {
	    posVersionCellTableView = new POSVersionMaintainerCellTableViewImpl(this);
	}
	return posVersionCellTableView;
    }

    @Override
    public CuadraturaVentasGiftCardView getCuadraturaVentasGiftCardView() {

	if (cuadraturaVentasGiftCardView == null) {
	    cuadraturaVentasGiftCardView = new CuadraturaVentasGiftCardViewImpl();
	}
	return cuadraturaVentasGiftCardView;
    }

    @Override
    public CuadraturaAvanceSuperAvanceView getCuadraturaAvanceSuperAvanceViewImpl() {

	if (cuadraturaAvanceSuperAvanceView == null) {
	    cuadraturaAvanceSuperAvanceView = new CuadraturaAvanceSuperAvanceViewImpl();
	}
	return cuadraturaAvanceSuperAvanceView;
    }

    @Override
    public CuadraturaPagosCMRView getCuadraturaPagosCMRView() {
	if (cuadraturaPagosCMRView == null) {
	    cuadraturaPagosCMRView = new CuadraturaPagosCMRViewImpl();
	}
	return cuadraturaPagosCMRView;
    }

    @Override
    public CuadraturaTarjetaCreditoView getCuadraturaTarjetaCreditoView() {
	if (cuadraturaTarjetaCredito == null) {
	    cuadraturaTarjetaCredito = new CuadraturaTarjetaCreditoViewImpl();
	}
	return cuadraturaTarjetaCredito;
    }

    @Override
    public CuadraturaNotaCreditoView getCuadraturaNotaCreditoView() {
	if (cuadraturaNotaCreditoView == null) {
	    cuadraturaNotaCreditoView = new CuadraturaNotaCreditoViewImpl();
	}
	return cuadraturaNotaCreditoView;
    }

    @Override
    public CuadraturaTarjetaDebitoView getCuadraturaTarjetaDebitoView() {
	if (cuadraturaTarjetaDebitoView == null) {
	    cuadraturaTarjetaDebitoView = new CuadraturaTarjetaDebitoViewImpl();
	}
	return cuadraturaTarjetaDebitoView;
    }

    @Override
    public DeleteDataView getDeleteDataView() {
	if (deleteDataView == null) {
	    deleteDataView = new DeleteDataViewImpl();
	}
	return deleteDataView;
    }

}
