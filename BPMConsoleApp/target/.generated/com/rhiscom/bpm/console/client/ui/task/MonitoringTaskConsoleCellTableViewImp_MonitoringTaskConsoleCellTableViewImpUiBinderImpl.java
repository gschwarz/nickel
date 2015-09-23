package com.rhiscom.bpm.console.client.ui.task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MonitoringTaskConsoleCellTableViewImp_MonitoringTaskConsoleCellTableViewImpUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.task.MonitoringTaskConsoleCellTableViewImp>, com.rhiscom.bpm.console.client.ui.task.MonitoringTaskConsoleCellTableViewImp.MonitoringTaskConsoleCellTableViewImpUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table height='100%' width='100%'> <tr style='height:39px; background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> Monitoreo de Tareas en curso </span> </div> </td> </tr> </table>")
    SafeHtml html1();
     
    @Template("<table height='500px' width='100%'> <tr> <td height='100%' width='100%'> <span id='{0}'></span> </td> </tr> </table>")
    SafeHtml html2(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.task.MonitoringTaskConsoleCellTableViewImp owner) {

    com.rhiscom.bpm.console.client.ui.task.MonitoringTaskConsoleCellTableViewImp_MonitoringTaskConsoleCellTableViewImpUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.task.MonitoringTaskConsoleCellTableViewImp_MonitoringTaskConsoleCellTableViewImpUiBinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.task.MonitoringTaskConsoleCellTableViewImp_MonitoringTaskConsoleCellTableViewImpUiBinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.task.MonitoringTaskConsoleCellTableViewImp_MonitoringTaskConsoleCellTableViewImpUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1().asString());
    com.google.gwt.user.client.ui.MenuItem btnRefrescar = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar menuBarProcesos = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.cellview.client.CellTable cellTableAsignedTask = owner.cellTableAsignedTask;
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel4 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId0).asString());
    com.google.gwt.user.cellview.client.SimplePager pager = owner.pager;
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
    cellTableAsignedTask.setPageSize(8);
    cellTableAsignedTask.setHeight("100%");
    f_ScrollPanel4.add(cellTableAsignedTask);
    f_ScrollPanel4.setStyleName("" + style.simplePanel() + "");
    f_ScrollPanel4.setWidth("99%");
    f_ScrollPanel4.setHeight("100%");
    htmlPanel.add(f_HTMLPanel3);
    pager.setHeight("20px");
    htmlPanel.add(pager);
    htmlPanel.setStyleName("" + style.divContent() + "");
    htmlPanel.setWidth("100%");
    htmlPanel.setHeight("100%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel3.addAndReplaceElement(f_ScrollPanel4, domId0Element);


    owner.btnRefrescar = btnRefrescar;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return htmlPanel;
  }
}
