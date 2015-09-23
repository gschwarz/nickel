package com.rhiscom.bpm.console.client.ui.task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp>, com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp.AsignedTaskConsoleCellTableViewImpUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table height='100%' width='100%'> <tr style='height:39px; background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> Administración de tareas asignadas </span> </div> </td> </tr> </table>")
    SafeHtml html1();
     
    @Template("<table height='100%' width='100%'> <tr style='height:25px; background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px; border: 1px solid #c5c5c5;'> <td colspan='2' style='height:25px;' width='100%'> <div style='width:100%;height:25px;overflow:hidden;text-align:left;'> <span style='font-size: 1.1em; font-weight:bold; margin-left: 3px;'> Detalle Tarea </span> </div> </td> </tr> </table>")
    SafeHtml html2();
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp owner) {

    com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1().asString());
    com.google.gwt.user.client.ui.MenuItem btnRefrescar = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar menuBarProcesos = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.cellview.client.CellTable cellTableAsignedTask = owner.cellTableAsignedTask;
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel3 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.cellview.client.SimplePager pager = owner.pager;
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2().asString());
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblIdTarea = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel8 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblAsignada = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel10 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label13 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblCreada = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel12 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label15 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblEstadoTareaSeleccionada = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel14 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel7 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.cellview.client.CellTable cellTableComments = owner.cellTableComments;
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel18 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel17 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.cellview.client.SimplePager pagerComments = owner.pagerComments;
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel16 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel6 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel4 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel htmlPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    htmlPanel.add(f_HTMLPanel1);
    btnRefrescar.setStyleName("" + style.gwtMenuItem() + "");
    btnRefrescar.setText("Refrescar");
    menuBarProcesos.addItem(btnRefrescar);
    menuBarProcesos.setAutoOpen(false);
    menuBarProcesos.setTitle("Main");
    menuBarProcesos.setAnimationEnabled(true);
    f_HorizontalPanel2.add(menuBarProcesos);
    f_HorizontalPanel2.setStyleName("" + style.rightHorizontalPanel() + "");
    f_HorizontalPanel2.setWidth("100%");
    htmlPanel.add(f_HorizontalPanel2);
    cellTableAsignedTask.addStyleName("" + style.cellTable() + "");
    cellTableAsignedTask.setWidth("100%");
    cellTableAsignedTask.setPageSize(6);
    cellTableAsignedTask.setHeight("100%");
    f_ScrollPanel3.add(cellTableAsignedTask);
    f_ScrollPanel3.setStyleName("" + style.simplePanel() + "");
    f_ScrollPanel3.setWidth("99%");
    f_ScrollPanel3.setHeight("100%");
    htmlPanel.add(f_ScrollPanel3);
    htmlPanel.setCellHeight(f_ScrollPanel3, "60%");
    pager.setHeight("20px");
    htmlPanel.add(pager);
    f_VerticalPanel4.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    f_HTMLPanel5.setWidth("100%");
    f_HTMLPanel5.setHeight("25px");
    f_VerticalPanel4.add(f_HTMLPanel5);
    f_HorizontalPanel6.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    f_HorizontalPanel8.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label9.setStyleName("" + style.important() + "");
    f_Label9.setWidth("70px");
    f_Label9.setText("N° Tarea :");
    f_Label9.setHeight("18px");
    f_HorizontalPanel8.add(f_Label9);
    f_HorizontalPanel8.setCellWidth(f_Label9, "70px");
    lblIdTarea.setWidth("90px");
    lblIdTarea.setText("");
    lblIdTarea.setHeight("18px");
    f_HorizontalPanel8.add(lblIdTarea);
    f_HorizontalPanel8.setWidth("100%");
    f_VerticalPanel7.add(f_HorizontalPanel8);
    f_HorizontalPanel10.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label11.setStyleName("" + style.important() + "");
    f_Label11.setWidth("70px");
    f_Label11.setText("Asingada :");
    f_Label11.setHeight("18px");
    f_HorizontalPanel10.add(f_Label11);
    f_HorizontalPanel10.setCellWidth(f_Label11, "70px");
    lblAsignada.setWidth("90px");
    lblAsignada.setText("");
    lblAsignada.setHeight("18px");
    f_HorizontalPanel10.add(lblAsignada);
    f_HorizontalPanel10.setWidth("100%");
    f_VerticalPanel7.add(f_HorizontalPanel10);
    f_HorizontalPanel12.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label13.setStyleName("" + style.important() + "");
    f_Label13.setWidth("70px");
    f_Label13.setText("Creación :");
    f_HorizontalPanel12.add(f_Label13);
    f_HorizontalPanel12.setCellWidth(f_Label13, "70px");
    lblCreada.setWidth("200px");
    lblCreada.setText("");
    lblCreada.setHeight("18px");
    f_HorizontalPanel12.add(lblCreada);
    f_HorizontalPanel12.setWidth("100%");
    f_VerticalPanel7.add(f_HorizontalPanel12);
    f_HorizontalPanel14.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label15.setStyleName("" + style.important() + "");
    f_Label15.setWidth("70px");
    f_Label15.setText("Estado :");
    f_Label15.setHeight("18px");
    f_HorizontalPanel14.add(f_Label15);
    f_HorizontalPanel14.setCellWidth(f_Label15, "70px");
    lblEstadoTareaSeleccionada.setWidth("90px");
    lblEstadoTareaSeleccionada.setText("");
    lblEstadoTareaSeleccionada.setHeight("18px");
    f_HorizontalPanel14.add(lblEstadoTareaSeleccionada);
    f_HorizontalPanel14.setWidth("100%");
    f_VerticalPanel7.add(f_HorizontalPanel14);
    f_VerticalPanel7.setWidth("35%");
    f_VerticalPanel7.setHeight("100px");
    f_HorizontalPanel6.add(f_VerticalPanel7);
    f_HorizontalPanel6.setCellWidth(f_VerticalPanel7, "250px");
    f_VerticalPanel16.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel17.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    cellTableComments.addStyleName("" + style.cellTable() + "");
    cellTableComments.setWidth("100%");
    cellTableComments.setPageSize(3);
    cellTableComments.setHeight("100%");
    f_ScrollPanel18.add(cellTableComments);
    f_ScrollPanel18.setWidth("100%");
    f_HorizontalPanel17.add(f_ScrollPanel18);
    f_HorizontalPanel17.setCellWidth(f_ScrollPanel18, "800px");
    f_HorizontalPanel17.setWidth("800px");
    f_VerticalPanel16.add(f_HorizontalPanel17);
    f_VerticalPanel16.setCellHorizontalAlignment(f_HorizontalPanel17, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_VerticalPanel16.setCellWidth(f_HorizontalPanel17, "800px");
    pagerComments.setHeight("20px");
    f_VerticalPanel16.add(pagerComments);
    f_VerticalPanel16.setWidth("800px");
    f_VerticalPanel16.setHeight("160px");
    f_HorizontalPanel6.add(f_VerticalPanel16);
    f_HorizontalPanel6.setCellHorizontalAlignment(f_VerticalPanel16, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel6.setCellWidth(f_VerticalPanel16, "800px");
    f_HorizontalPanel6.setStyleName("" + style.detailPanel() + "");
    f_HorizontalPanel6.setWidth("100%");
    f_HorizontalPanel6.setHeight("171px");
    f_VerticalPanel4.add(f_HorizontalPanel6);
    f_VerticalPanel4.setStyleName("" + style.detailPanel() + "");
    f_VerticalPanel4.setWidth("100%");
    f_VerticalPanel4.setHeight("190px");
    htmlPanel.add(f_VerticalPanel4);
    htmlPanel.setCellHeight(f_VerticalPanel4, "190px");
    htmlPanel.setStyleName("" + style.divContent() + "");
    htmlPanel.setWidth("100%");
    htmlPanel.setHeight("100%");



    owner.btnRefrescar = btnRefrescar;
    owner.lblAsignada = lblAsignada;
    owner.lblCreada = lblCreada;
    owner.lblEstadoTareaSeleccionada = lblEstadoTareaSeleccionada;
    owner.lblIdTarea = lblIdTarea;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return htmlPanel;
  }
}
