package com.rhiscom.bpm.console.client.mapper;

import com.google.gwt.place.impl.AbstractPlaceHistoryMapper;
import com.rhiscom.bpm.console.client.mapper.AppPlaceHistoryMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.impl.AbstractPlaceHistoryMapper.PrefixAndToken;
import com.google.gwt.core.client.GWT;

public class AppPlaceHistoryMapperImpl extends AbstractPlaceHistoryMapper<Void> implements AppPlaceHistoryMapper {
  
  protected PrefixAndToken getPrefixAndToken(Place newPlace) {
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.AsignedTaskConsoleCellTablePlace) {
      com.rhiscom.bpm.console.client.place.AsignedTaskConsoleCellTablePlace place = (com.rhiscom.bpm.console.client.place.AsignedTaskConsoleCellTablePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.AsignedTaskConsoleCellTablePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.AsignedTaskConsoleCellTablePlace.Tokenizer.class);
      return new PrefixAndToken("AsignedTaskConsoleCellTablePlace", t.getToken((com.rhiscom.bpm.console.client.place.AsignedTaskConsoleCellTablePlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.BusinessGroupMaintainerCellTablePlace) {
      com.rhiscom.bpm.console.client.place.BusinessGroupMaintainerCellTablePlace place = (com.rhiscom.bpm.console.client.place.BusinessGroupMaintainerCellTablePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.BusinessGroupMaintainerCellTablePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.BusinessGroupMaintainerCellTablePlace.Tokenizer.class);
      return new PrefixAndToken("BusinessGroupMaintainerCellTablePlace", t.getToken((com.rhiscom.bpm.console.client.place.BusinessGroupMaintainerCellTablePlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.BusinessUnitMaintainerCellTablePlace) {
      com.rhiscom.bpm.console.client.place.BusinessUnitMaintainerCellTablePlace place = (com.rhiscom.bpm.console.client.place.BusinessUnitMaintainerCellTablePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.BusinessUnitMaintainerCellTablePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.BusinessUnitMaintainerCellTablePlace.Tokenizer.class);
      return new PrefixAndToken("BusinessUnitMaintainerCellTablePlace", t.getToken((com.rhiscom.bpm.console.client.place.BusinessUnitMaintainerCellTablePlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.CellTableEstadoTiendaPlace) {
      com.rhiscom.bpm.console.client.place.CellTableEstadoTiendaPlace place = (com.rhiscom.bpm.console.client.place.CellTableEstadoTiendaPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.CellTableEstadoTiendaPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.CellTableEstadoTiendaPlace.Tokenizer.class);
      return new PrefixAndToken("CellTableEstadoTiendaPlace", t.getToken((com.rhiscom.bpm.console.client.place.CellTableEstadoTiendaPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.CuadraturaActivacionGiftCardPlace) {
      com.rhiscom.bpm.console.client.place.CuadraturaActivacionGiftCardPlace place = (com.rhiscom.bpm.console.client.place.CuadraturaActivacionGiftCardPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.CuadraturaActivacionGiftCardPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaActivacionGiftCardPlace.Tokenizer.class);
      return new PrefixAndToken("CuadraturaActivacionGiftCardPlace", t.getToken((com.rhiscom.bpm.console.client.place.CuadraturaActivacionGiftCardPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.CuadraturaAvanceSuperAvancePlace) {
      com.rhiscom.bpm.console.client.place.CuadraturaAvanceSuperAvancePlace place = (com.rhiscom.bpm.console.client.place.CuadraturaAvanceSuperAvancePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.CuadraturaAvanceSuperAvancePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaAvanceSuperAvancePlace.Tokenizer.class);
      return new PrefixAndToken("CuadraturaAvanceSuperAvancePlace", t.getToken((com.rhiscom.bpm.console.client.place.CuadraturaAvanceSuperAvancePlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.CuadraturaNotaCreditoPlace) {
      com.rhiscom.bpm.console.client.place.CuadraturaNotaCreditoPlace place = (com.rhiscom.bpm.console.client.place.CuadraturaNotaCreditoPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.CuadraturaNotaCreditoPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaNotaCreditoPlace.Tokenizer.class);
      return new PrefixAndToken("CuadraturaNotaCreditoPlace", t.getToken((com.rhiscom.bpm.console.client.place.CuadraturaNotaCreditoPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.CuadraturaPagosCMRPlace) {
      com.rhiscom.bpm.console.client.place.CuadraturaPagosCMRPlace place = (com.rhiscom.bpm.console.client.place.CuadraturaPagosCMRPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.CuadraturaPagosCMRPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaPagosCMRPlace.Tokenizer.class);
      return new PrefixAndToken("CuadraturaPagosCMRPlace", t.getToken((com.rhiscom.bpm.console.client.place.CuadraturaPagosCMRPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.CuadraturaTarjetaCreditoPlace) {
      com.rhiscom.bpm.console.client.place.CuadraturaTarjetaCreditoPlace place = (com.rhiscom.bpm.console.client.place.CuadraturaTarjetaCreditoPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.CuadraturaTarjetaCreditoPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaTarjetaCreditoPlace.Tokenizer.class);
      return new PrefixAndToken("CuadraturaTarjetaCreditoPlace", t.getToken((com.rhiscom.bpm.console.client.place.CuadraturaTarjetaCreditoPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.CuadraturaTarjetaDebitoPlace) {
      com.rhiscom.bpm.console.client.place.CuadraturaTarjetaDebitoPlace place = (com.rhiscom.bpm.console.client.place.CuadraturaTarjetaDebitoPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.CuadraturaTarjetaDebitoPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaTarjetaDebitoPlace.Tokenizer.class);
      return new PrefixAndToken("CuadraturaTarjetaDebitoPlace", t.getToken((com.rhiscom.bpm.console.client.place.CuadraturaTarjetaDebitoPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.CuadraturaVentasGiftCardPlace) {
      com.rhiscom.bpm.console.client.place.CuadraturaVentasGiftCardPlace place = (com.rhiscom.bpm.console.client.place.CuadraturaVentasGiftCardPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.CuadraturaVentasGiftCardPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaVentasGiftCardPlace.Tokenizer.class);
      return new PrefixAndToken("CuadraturaVentasGiftCardPlace", t.getToken((com.rhiscom.bpm.console.client.place.CuadraturaVentasGiftCardPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.CuadraturaVtaCMRViewPlace) {
      com.rhiscom.bpm.console.client.place.CuadraturaVtaCMRViewPlace place = (com.rhiscom.bpm.console.client.place.CuadraturaVtaCMRViewPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.CuadraturaVtaCMRViewPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaVtaCMRViewPlace.Tokenizer.class);
      return new PrefixAndToken("CuadraturaVtaCMRViewPlace", t.getToken((com.rhiscom.bpm.console.client.place.CuadraturaVtaCMRViewPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.DashBoardBAMPlace) {
      com.rhiscom.bpm.console.client.place.DashBoardBAMPlace place = (com.rhiscom.bpm.console.client.place.DashBoardBAMPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.DashBoardBAMPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.DashBoardBAMPlace.Tokenizer.class);
      return new PrefixAndToken("DashBoardBAMPlace", t.getToken((com.rhiscom.bpm.console.client.place.DashBoardBAMPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.DashBoardHomeViewPlace) {
      com.rhiscom.bpm.console.client.place.DashBoardHomeViewPlace place = (com.rhiscom.bpm.console.client.place.DashBoardHomeViewPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.DashBoardHomeViewPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.DashBoardHomeViewPlace.Tokenizer.class);
      return new PrefixAndToken("DashBoardHomeViewPlace", t.getToken((com.rhiscom.bpm.console.client.place.DashBoardHomeViewPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.EmailConfigurationPlace) {
      com.rhiscom.bpm.console.client.place.EmailConfigurationPlace place = (com.rhiscom.bpm.console.client.place.EmailConfigurationPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.EmailConfigurationPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.EmailConfigurationPlace.Tokenizer.class);
      return new PrefixAndToken("EmailConfigurationPlace", t.getToken((com.rhiscom.bpm.console.client.place.EmailConfigurationPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.EmailRecipientsConfigurationPlace) {
      com.rhiscom.bpm.console.client.place.EmailRecipientsConfigurationPlace place = (com.rhiscom.bpm.console.client.place.EmailRecipientsConfigurationPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.EmailRecipientsConfigurationPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.EmailRecipientsConfigurationPlace.Tokenizer.class);
      return new PrefixAndToken("EmailRecipientsConfigurationPlace", t.getToken((com.rhiscom.bpm.console.client.place.EmailRecipientsConfigurationPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.EventATNMonitorPlace) {
      com.rhiscom.bpm.console.client.place.EventATNMonitorPlace place = (com.rhiscom.bpm.console.client.place.EventATNMonitorPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.EventATNMonitorPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.EventATNMonitorPlace.Tokenizer.class);
      return new PrefixAndToken("EventATNMonitorPlace", t.getToken((com.rhiscom.bpm.console.client.place.EventATNMonitorPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.HelloPlace) {
      com.rhiscom.bpm.console.client.place.HelloPlace place = (com.rhiscom.bpm.console.client.place.HelloPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.HelloPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.HelloPlace.Tokenizer.class);
      return new PrefixAndToken("HelloPlace", t.getToken((com.rhiscom.bpm.console.client.place.HelloPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.LeftSidePlace) {
      com.rhiscom.bpm.console.client.place.LeftSidePlace place = (com.rhiscom.bpm.console.client.place.LeftSidePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.LeftSidePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.LeftSidePlace.Tokenizer.class);
      return new PrefixAndToken("LeftSidePlace", t.getToken((com.rhiscom.bpm.console.client.place.LeftSidePlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.LoginPanelPlace) {
      com.rhiscom.bpm.console.client.place.LoginPanelPlace place = (com.rhiscom.bpm.console.client.place.LoginPanelPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.LoginPanelPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.LoginPanelPlace.Tokenizer.class);
      return new PrefixAndToken("LoginPanelPlace", t.getToken((com.rhiscom.bpm.console.client.place.LoginPanelPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.MonitoringProcessPlace) {
      com.rhiscom.bpm.console.client.place.MonitoringProcessPlace place = (com.rhiscom.bpm.console.client.place.MonitoringProcessPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.MonitoringProcessPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.MonitoringProcessPlace.Tokenizer.class);
      return new PrefixAndToken("MonitoringProcessPlace", t.getToken((com.rhiscom.bpm.console.client.place.MonitoringProcessPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.MonitoringTaskConsolePlace) {
      com.rhiscom.bpm.console.client.place.MonitoringTaskConsolePlace place = (com.rhiscom.bpm.console.client.place.MonitoringTaskConsolePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.MonitoringTaskConsolePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.MonitoringTaskConsolePlace.Tokenizer.class);
      return new PrefixAndToken("MonitoringTaskConsolePlace", t.getToken((com.rhiscom.bpm.console.client.place.MonitoringTaskConsolePlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.ProcessConsoleCellTablePlace) {
      com.rhiscom.bpm.console.client.place.ProcessConsoleCellTablePlace place = (com.rhiscom.bpm.console.client.place.ProcessConsoleCellTablePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.ProcessConsoleCellTablePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.ProcessConsoleCellTablePlace.Tokenizer.class);
      return new PrefixAndToken("ProcessConsoleCellTablePlace", t.getToken((com.rhiscom.bpm.console.client.place.ProcessConsoleCellTablePlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.ProcessCoreCaseManagementPlace) {
      com.rhiscom.bpm.console.client.place.ProcessCoreCaseManagementPlace place = (com.rhiscom.bpm.console.client.place.ProcessCoreCaseManagementPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.ProcessCoreCaseManagementPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.ProcessCoreCaseManagementPlace.Tokenizer.class);
      return new PrefixAndToken("ProcessCoreCaseManagementPlace", t.getToken((com.rhiscom.bpm.console.client.place.ProcessCoreCaseManagementPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.ProcessManagementPlace) {
      com.rhiscom.bpm.console.client.place.ProcessManagementPlace place = (com.rhiscom.bpm.console.client.place.ProcessManagementPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.ProcessManagementPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.ProcessManagementPlace.Tokenizer.class);
      return new PrefixAndToken("ProcessManagementPlace", t.getToken((com.rhiscom.bpm.console.client.place.ProcessManagementPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.ProcessSchedulerPlace) {
      com.rhiscom.bpm.console.client.place.ProcessSchedulerPlace place = (com.rhiscom.bpm.console.client.place.ProcessSchedulerPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.ProcessSchedulerPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.ProcessSchedulerPlace.Tokenizer.class);
      return new PrefixAndToken("ProcessSchedulerPlace", t.getToken((com.rhiscom.bpm.console.client.place.ProcessSchedulerPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.ProfileMaintainerCellTablePlace) {
      com.rhiscom.bpm.console.client.place.ProfileMaintainerCellTablePlace place = (com.rhiscom.bpm.console.client.place.ProfileMaintainerCellTablePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.ProfileMaintainerCellTablePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.ProfileMaintainerCellTablePlace.Tokenizer.class);
      return new PrefixAndToken("ProfileMaintainerCellTablePlace", t.getToken((com.rhiscom.bpm.console.client.place.ProfileMaintainerCellTablePlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.ReportViewPlace) {
      com.rhiscom.bpm.console.client.place.ReportViewPlace place = (com.rhiscom.bpm.console.client.place.ReportViewPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.ReportViewPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.ReportViewPlace.Tokenizer.class);
      return new PrefixAndToken("ReportViewPlace", t.getToken((com.rhiscom.bpm.console.client.place.ReportViewPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.RightSidePlace) {
      com.rhiscom.bpm.console.client.place.RightSidePlace place = (com.rhiscom.bpm.console.client.place.RightSidePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.RightSidePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.RightSidePlace.Tokenizer.class);
      return new PrefixAndToken("RightSidePlace", t.getToken((com.rhiscom.bpm.console.client.place.RightSidePlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.RootPlace) {
      com.rhiscom.bpm.console.client.place.RootPlace place = (com.rhiscom.bpm.console.client.place.RootPlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.RootPlace> t = GWT.create(com.rhiscom.bpm.console.client.place.RootPlace.Tokenizer.class);
      return new PrefixAndToken("RootPlace", t.getToken((com.rhiscom.bpm.console.client.place.RootPlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.UnassignedTaskConsoleCellTablePlace) {
      com.rhiscom.bpm.console.client.place.UnassignedTaskConsoleCellTablePlace place = (com.rhiscom.bpm.console.client.place.UnassignedTaskConsoleCellTablePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.UnassignedTaskConsoleCellTablePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.UnassignedTaskConsoleCellTablePlace.Tokenizer.class);
      return new PrefixAndToken("UnassignedTaskConsoleCellTablePlace", t.getToken((com.rhiscom.bpm.console.client.place.UnassignedTaskConsoleCellTablePlace) place));
    }
    if (newPlace instanceof com.rhiscom.bpm.console.client.place.UserMaintainerCellTablePlace) {
      com.rhiscom.bpm.console.client.place.UserMaintainerCellTablePlace place = (com.rhiscom.bpm.console.client.place.UserMaintainerCellTablePlace) newPlace;
      PlaceTokenizer<com.rhiscom.bpm.console.client.place.UserMaintainerCellTablePlace> t = GWT.create(com.rhiscom.bpm.console.client.place.UserMaintainerCellTablePlace.Tokenizer.class);
      return new PrefixAndToken("UserMaintainerCellTablePlace", t.getToken((com.rhiscom.bpm.console.client.place.UserMaintainerCellTablePlace) place));
    }
    return null;
  }
  
  protected PlaceTokenizer<?> getTokenizer(String prefix) {
    if ("CuadraturaVentasGiftCardPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaVentasGiftCardPlace.Tokenizer.class);
    }
    if ("EventATNMonitorPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.EventATNMonitorPlace.Tokenizer.class);
    }
    if ("ProcessManagementPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.ProcessManagementPlace.Tokenizer.class);
    }
    if ("CuadraturaTarjetaDebitoPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaTarjetaDebitoPlace.Tokenizer.class);
    }
    if ("RootPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.RootPlace.Tokenizer.class);
    }
    if ("LoginPanelPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.LoginPanelPlace.Tokenizer.class);
    }
    if ("UnassignedTaskConsoleCellTablePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.UnassignedTaskConsoleCellTablePlace.Tokenizer.class);
    }
    if ("ProfileMaintainerCellTablePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.ProfileMaintainerCellTablePlace.Tokenizer.class);
    }
    if ("RightSidePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.RightSidePlace.Tokenizer.class);
    }
    if ("EmailConfigurationPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.EmailConfigurationPlace.Tokenizer.class);
    }
    if ("CuadraturaTarjetaCreditoPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaTarjetaCreditoPlace.Tokenizer.class);
    }
    if ("MonitoringTaskConsolePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.MonitoringTaskConsolePlace.Tokenizer.class);
    }
    if ("MonitoringProcessPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.MonitoringProcessPlace.Tokenizer.class);
    }
    if ("DashBoardHomeViewPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.DashBoardHomeViewPlace.Tokenizer.class);
    }
    if ("ProcessSchedulerPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.ProcessSchedulerPlace.Tokenizer.class);
    }
    if ("CuadraturaVtaCMRViewPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaVtaCMRViewPlace.Tokenizer.class);
    }
    if ("LeftSidePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.LeftSidePlace.Tokenizer.class);
    }
    if ("CuadraturaPagosCMRPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaPagosCMRPlace.Tokenizer.class);
    }
    if ("BusinessGroupMaintainerCellTablePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.BusinessGroupMaintainerCellTablePlace.Tokenizer.class);
    }
    if ("ProcessCoreCaseManagementPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.ProcessCoreCaseManagementPlace.Tokenizer.class);
    }
    if ("UserMaintainerCellTablePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.UserMaintainerCellTablePlace.Tokenizer.class);
    }
    if ("CellTableEstadoTiendaPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.CellTableEstadoTiendaPlace.Tokenizer.class);
    }
    if ("CuadraturaAvanceSuperAvancePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaAvanceSuperAvancePlace.Tokenizer.class);
    }
    if ("AsignedTaskConsoleCellTablePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.AsignedTaskConsoleCellTablePlace.Tokenizer.class);
    }
    if ("EmailRecipientsConfigurationPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.EmailRecipientsConfigurationPlace.Tokenizer.class);
    }
    if ("ReportViewPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.ReportViewPlace.Tokenizer.class);
    }
    if ("BusinessUnitMaintainerCellTablePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.BusinessUnitMaintainerCellTablePlace.Tokenizer.class);
    }
    if ("CuadraturaNotaCreditoPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaNotaCreditoPlace.Tokenizer.class);
    }
    if ("ProcessConsoleCellTablePlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.ProcessConsoleCellTablePlace.Tokenizer.class);
    }
    if ("DashBoardBAMPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.DashBoardBAMPlace.Tokenizer.class);
    }
    if ("CuadraturaActivacionGiftCardPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.CuadraturaActivacionGiftCardPlace.Tokenizer.class);
    }
    if ("HelloPlace".equals(prefix)) {
      return GWT.create(com.rhiscom.bpm.console.client.place.HelloPlace.Tokenizer.class);
    }
    return null;
  }

}
