package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ProcessSchedulerViewImpl_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerViewImpl>, com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerViewImpl.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table width='100%'> <tr style='height:39px;background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 12px; font-weight:bold;'> Configuración horas de ejecución </span> </div> </td> </tr> </table> <span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html1(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerViewImpl_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerViewImpl_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerViewImpl_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.process.ProcessSchedulerViewImpl_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.MenuItem btnRefrescar = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar menuBarProcesos = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.cellview.client.CellList cellList = owner.cellList;
    com.google.gwt.user.cellview.client.SimplePager pagerCellList = new com.google.gwt.user.cellview.client.SimplePager(com.google.gwt.user.cellview.client.SimplePager.TextLocation.LEFT);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label lblProceso = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblError = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel7 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.CheckBox chkLunes = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    com.google.gwt.user.client.ui.CheckBox chkMartes = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    com.google.gwt.user.client.ui.CheckBox chkMiercoles = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    com.google.gwt.user.client.ui.CheckBox chkJueves = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    com.google.gwt.user.client.ui.CheckBox chkViernes = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    com.google.gwt.user.client.ui.CheckBox chkSabado = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    com.google.gwt.user.client.ui.CheckBox chkDomingo = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel8 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox cmbHoras = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
    com.google.gwt.user.client.ui.Label f_Label12 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox cmbMinutos = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
    com.google.gwt.user.client.ui.Label f_Label13 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel10 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label15 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.datepicker.client.DateBox initDate = (com.google.gwt.user.datepicker.client.DateBox) GWT.create(com.google.gwt.user.datepicker.client.DateBox.class);
    com.google.gwt.user.client.ui.Label f_Label16 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.datepicker.client.DateBox endDate = (com.google.gwt.user.datepicker.client.DateBox) GWT.create(com.google.gwt.user.datepicker.client.DateBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel14 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel17 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Button btnGuardar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel18 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.cellview.client.CellTable detailInstance = (com.google.gwt.user.cellview.client.CellTable) GWT.create(com.google.gwt.user.cellview.client.CellTable.class);
    com.google.gwt.user.client.ui.SimplePanel f_SimplePanel19 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel6 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel20 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label22 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel21 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId0, domId1).asString());

    btnRefrescar.setStyleName("" + style.gwtMenuItem() + "");
    btnRefrescar.setWidth("130px");
    btnRefrescar.setText("Refrescar definiciones");
    menuBarProcesos.addItem(btnRefrescar);
    menuBarProcesos.setAutoOpen(false);
    menuBarProcesos.setTitle("Main");
    menuBarProcesos.setAnimationEnabled(true);
    f_HorizontalPanel1.add(menuBarProcesos);
    f_HorizontalPanel1.setStyleName("" + style.rightHorizontalPanel() + "");
    f_HorizontalPanel1.setWidth("100%");
    f_VerticalPanel3.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label4.setStyleName("" + style.title() + "");
    f_Label4.setText("Procesos registrados");
    f_VerticalPanel3.add(f_Label4);
    f_HorizontalPanel5.setStyleName("" + style.demoHr() + "");
    f_HorizontalPanel5.setWidth("100%");
    f_HorizontalPanel5.setHeight("1px");
    f_VerticalPanel3.add(f_HorizontalPanel5);
    cellList.setWidth("100%");
    cellList.setPageSize(12);
    f_VerticalPanel3.add(cellList);
    f_VerticalPanel3.add(pagerCellList);
    f_VerticalPanel3.addStyleName("" + style.cellTable() + "");
    f_VerticalPanel3.setWidth("300px");
    f_VerticalPanel3.setHeight("100%");
    f_HorizontalPanel2.add(f_VerticalPanel3);
    f_HorizontalPanel2.setCellWidth(f_VerticalPanel3, "400px");
    lblProceso.setStyleName("" + style.lblMessage() + "");
    lblProceso.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    lblProceso.setWidth("100%");
    f_VerticalPanel7.add(lblProceso);
    lblError.setStyleName("" + style.lblError() + "");
    lblError.setHeight("18px");
    f_VerticalPanel7.add(lblError);
    f_VerticalPanel7.setWidth("100%");
    f_VerticalPanel6.add(f_VerticalPanel7);
    f_Label9.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label9.setWidth("200px");
    f_Label9.setText("Periodicidad");
    f_HorizontalPanel8.add(f_Label9);
    f_HorizontalPanel8.setCellVerticalAlignment(f_Label9, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    chkLunes.setStyleName("" + style.checkboxk() + "");
    chkLunes.setText("L");
    f_HorizontalPanel8.add(chkLunes);
    chkMartes.setStyleName("" + style.checkboxk() + "");
    chkMartes.setText("M");
    f_HorizontalPanel8.add(chkMartes);
    chkMiercoles.setStyleName("" + style.checkboxk() + "");
    chkMiercoles.setText("M");
    f_HorizontalPanel8.add(chkMiercoles);
    chkJueves.setStyleName("" + style.checkboxk() + "");
    chkJueves.setText("J");
    f_HorizontalPanel8.add(chkJueves);
    chkViernes.setStyleName("" + style.checkboxk() + "");
    chkViernes.setText("V");
    f_HorizontalPanel8.add(chkViernes);
    chkSabado.setStyleName("" + style.checkboxk() + "");
    chkSabado.setText("S");
    f_HorizontalPanel8.add(chkSabado);
    chkDomingo.setStyleName("" + style.checkboxk() + "");
    chkDomingo.setText("D");
    f_HorizontalPanel8.add(chkDomingo);
    f_VerticalPanel6.add(f_HorizontalPanel8);
    f_HorizontalPanel10.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label11.setWidth("200px");
    f_Label11.setText("Horario de ejecución");
    f_HorizontalPanel10.add(f_Label11);
    f_HorizontalPanel10.setCellVerticalAlignment(f_Label11, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    cmbHoras.setWidth("45px");
    f_HorizontalPanel10.add(cmbHoras);
    f_Label12.setStyleName("" + style.checkboxk() + "");
    f_Label12.setWidth("27px");
    f_Label12.setText("hrs");
    f_HorizontalPanel10.add(f_Label12);
    f_HorizontalPanel10.setCellVerticalAlignment(f_Label12, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    cmbMinutos.setWidth("45px");
    f_HorizontalPanel10.add(cmbMinutos);
    f_Label13.setStyleName("" + style.checkboxk() + "");
    f_Label13.setWidth("38px");
    f_Label13.setText("mins");
    f_HorizontalPanel10.add(f_Label13);
    f_HorizontalPanel10.setCellVerticalAlignment(f_Label13, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_VerticalPanel6.add(f_HorizontalPanel10);
    f_Label15.setWidth("200px");
    f_Label15.setText("Fecha Inicio ejecución");
    f_HorizontalPanel14.add(f_Label15);
    f_HorizontalPanel14.setCellVerticalAlignment(f_Label15, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel14.setCellWidth(f_Label15, "200px");
    f_HorizontalPanel14.add(initDate);
    f_Label16.setWidth("127px");
    f_Label16.setText("Fecha fin ejecución");
    f_HorizontalPanel14.add(f_Label16);
    f_HorizontalPanel14.setCellHorizontalAlignment(f_Label16, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_HorizontalPanel14.setCellVerticalAlignment(f_Label16, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel14.setCellWidth(f_Label16, "200px");
    f_HorizontalPanel14.add(endDate);
    f_VerticalPanel6.add(f_HorizontalPanel14);
    f_VerticalPanel6.add(f_HorizontalPanel17);
    btnGuardar.setText("Guardar");
    f_HorizontalPanel18.add(btnGuardar);
    f_HorizontalPanel18.setWidth("");
    f_VerticalPanel6.add(f_HorizontalPanel18);
    f_VerticalPanel6.setCellHorizontalAlignment(f_HorizontalPanel18, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_VerticalPanel6.setCellWidth(f_HorizontalPanel18, "");
    detailInstance.setWidth("100%");
    f_SimplePanel19.add(detailInstance);
    f_SimplePanel19.setWidth("400px");
    f_VerticalPanel6.add(f_SimplePanel19);
    f_VerticalPanel6.addStyleName("" + style.cellTable() + "");
    f_VerticalPanel6.setWidth("99%");
    f_VerticalPanel6.setHeight("100%");
    f_HorizontalPanel2.add(f_VerticalPanel6);
    f_HorizontalPanel2.setCellWidth(f_VerticalPanel6, "99%");
    f_HorizontalPanel2.add(f_VerticalPanel20);
    f_VerticalPanel21.add(f_Label22);
    f_HorizontalPanel2.add(f_VerticalPanel21);
    f_HorizontalPanel2.setWidth("100%");
    htmlPanel.setWidth("100%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(htmlPanel.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord0.detach();
    htmlPanel.addAndReplaceElement(f_HorizontalPanel1, domId0Element);
    htmlPanel.addAndReplaceElement(f_HorizontalPanel2, domId1Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickGuardar(event);
      }
    };
    btnGuardar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.btnGuardar = btnGuardar;
    owner.btnRefrescar = btnRefrescar;
    owner.chkDomingo = chkDomingo;
    owner.chkJueves = chkJueves;
    owner.chkLunes = chkLunes;
    owner.chkMartes = chkMartes;
    owner.chkMiercoles = chkMiercoles;
    owner.chkSabado = chkSabado;
    owner.chkViernes = chkViernes;
    owner.cmbHoras = cmbHoras;
    owner.cmbMinutos = cmbMinutos;
    owner.detailInstance = detailInstance;
    owner.endDate = endDate;
    owner.initDate = initDate;
    owner.lblError = lblError;
    owner.lblProceso = lblProceso;
    owner.pagerCellList = pagerCellList;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return htmlPanel;
  }
}
