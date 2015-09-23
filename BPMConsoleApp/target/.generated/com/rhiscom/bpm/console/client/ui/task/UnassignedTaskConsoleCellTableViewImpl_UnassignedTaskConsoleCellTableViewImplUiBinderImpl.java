package com.rhiscom.bpm.console.client.ui.task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class UnassignedTaskConsoleCellTableViewImpl_UnassignedTaskConsoleCellTableViewImplUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableViewImpl>, com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableViewImpl.UnassignedTaskConsoleCellTableViewImplUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table width='100%'> <tr style='height:39px;background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> Administración de tareas no asignadas </span> </div> </td> </tr> <tr> <td valign='top' width='100%'> <span id='{0}'></span> <span id='{1}'></span> </td>  </tr> <tr> <td> <span id='{2}'></span> </td> </tr> </table>")
    SafeHtml html1(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableViewImpl_UnassignedTaskConsoleCellTableViewImplUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableViewImpl_UnassignedTaskConsoleCellTableViewImplUiBinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableViewImpl_UnassignedTaskConsoleCellTableViewImplUiBinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.task.UnassignedTaskConsoleCellTableViewImpl_UnassignedTaskConsoleCellTableViewImplUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.MenuItem btnRefrescar = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar menuBarProcesos = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.cellview.client.CellTable cellTableUnassignedAsignedTask = owner.cellTableUnassignedAsignedTask;
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel2 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.cellview.client.SimplePager pager = owner.pager;
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId0, domId1, domId2).asString());

    btnRefrescar.setStyleName("" + style.gwtMenuItem() + "");
    btnRefrescar.setText("Refrescar");
    menuBarProcesos.addItem(btnRefrescar);
    menuBarProcesos.setAutoOpen(false);
    menuBarProcesos.setTitle("Main");
    menuBarProcesos.setAnimationEnabled(true);
    f_HorizontalPanel1.add(menuBarProcesos);
    f_HorizontalPanel1.setStyleName("" + style.rightHorizontalPanel() + "");
    f_HorizontalPanel1.setWidth("100%");
    cellTableUnassignedAsignedTask.addStyleName("" + style.cellTable() + "");
    cellTableUnassignedAsignedTask.setPageSize(12);
    f_ScrollPanel2.add(cellTableUnassignedAsignedTask);
    f_ScrollPanel2.setHeight("100%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(htmlPanel.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord0.detach();
    htmlPanel.addAndReplaceElement(f_HorizontalPanel1, domId0Element);
    htmlPanel.addAndReplaceElement(f_ScrollPanel2, domId1Element);
    htmlPanel.addAndReplaceElement(pager, domId2Element);


    owner.btnRefrescar = btnRefrescar;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return htmlPanel;
  }
}
