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

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
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
import com.rhiscom.bpm.console.client.place.DashBoardHomeViewPlace;
import com.rhiscom.bpm.console.client.place.EmailConfigurationPlace;
import com.rhiscom.bpm.console.client.place.EmailRecipientsConfigurationPlace;
import com.rhiscom.bpm.console.client.place.EventATNMonitorPlace;
import com.rhiscom.bpm.console.client.place.HelloPlace;
import com.rhiscom.bpm.console.client.place.LeftSidePlace;
import com.rhiscom.bpm.console.client.place.LoginPanelPlace;
import com.rhiscom.bpm.console.client.place.MonitoringProcessPlace;
import com.rhiscom.bpm.console.client.place.MonitoringTaskConsolePlace;
import com.rhiscom.bpm.console.client.place.ProcessConsoleCellTablePlace;
import com.rhiscom.bpm.console.client.place.ProcessCoreCaseManagementPlace;
import com.rhiscom.bpm.console.client.place.ProcessManagementPlace;
import com.rhiscom.bpm.console.client.place.ProcessSchedulerPlace;
import com.rhiscom.bpm.console.client.place.ProfileMaintainerCellTablePlace;
import com.rhiscom.bpm.console.client.place.ReportViewPlace;
import com.rhiscom.bpm.console.client.place.RightSidePlace;
import com.rhiscom.bpm.console.client.place.RootPlace;
import com.rhiscom.bpm.console.client.place.UnassignedTaskConsoleCellTablePlace;
import com.rhiscom.bpm.console.client.place.UserMaintainerCellTablePlace;

@WithTokenizers({ HelloPlace.Tokenizer.class, RootPlace.Tokenizer.class, CellTableEstadoTiendaPlace.Tokenizer.class,
	ProcessConsoleCellTablePlace.Tokenizer.class, RightSidePlace.Tokenizer.class, LeftSidePlace.Tokenizer.class,
	LoginPanelPlace.Tokenizer.class, AsignedTaskConsoleCellTablePlace.Tokenizer.class,
	BusinessGroupMaintainerCellTablePlace.Tokenizer.class, UnassignedTaskConsoleCellTablePlace.Tokenizer.class,
	UserMaintainerCellTablePlace.Tokenizer.class, DashBoardHomeViewPlace.Tokenizer.class,
	ProfileMaintainerCellTablePlace.Tokenizer.class, ReportViewPlace.Tokenizer.class,
	BusinessUnitMaintainerCellTablePlace.Tokenizer.class, DashBoardBAMPlace.Tokenizer.class,
	EventATNMonitorPlace.Tokenizer.class, MonitoringTaskConsolePlace.Tokenizer.class,
	ProcessManagementPlace.Tokenizer.class, ProcessSchedulerPlace.Tokenizer.class,
	MonitoringProcessPlace.Tokenizer.class, EmailConfigurationPlace.Tokenizer.class,
	EmailRecipientsConfigurationPlace.Tokenizer.class, ProcessCoreCaseManagementPlace.Tokenizer.class,
	CuadraturaVtaCMRViewPlace.Tokenizer.class, CuadraturaActivacionGiftCardPlace.Tokenizer.class,
	ProcessConsoleCellTablePlace.Tokenizer.class, CuadraturaVentasGiftCardPlace.Tokenizer.class,
	CuadraturaAvanceSuperAvancePlace.Tokenizer.class, CuadraturaPagosCMRPlace.Tokenizer.class,
	CuadraturaTarjetaCreditoPlace.Tokenizer.class, CuadraturaNotaCreditoPlace.Tokenizer.class,
	CuadraturaTarjetaDebitoPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

    /*
     * At GWT compile time, GWT generates (see PlaceHistoryMapperGenerator) a
     * class based on your interface that extends AbstractPlaceHistoryMapper.
     * PlaceHistoryMapper is the link between your PlaceTokenizers and GWT's
     * PlaceHistoryHandler that synchronizes the browser URL with each Place.
     * 
     * For more control of the PlaceHistoryMapper, you can use the @Prefix
     * annotation on a PlaceTokenizer to change the first part of the URL
     * associated with the Place. For even more control, you can instead
     * implement PlaceHistoryMapperWithFactory and provide a TokenizerFactory
     * that, in turn, provides individual PlaceTokenizers.
     */
}
