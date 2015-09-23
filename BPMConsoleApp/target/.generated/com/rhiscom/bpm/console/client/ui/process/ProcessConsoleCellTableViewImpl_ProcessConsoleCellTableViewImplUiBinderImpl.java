package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl>, com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl.ProcessConsoleCellTableViewImplUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table width='100%'> <tr style='height:39px;background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 12px; font-weight:bold;'> Administración de Procesos </span> </div> </td> </tr> <tr> <td valign='top' width='50%'> <span id='{0}'></span> <span id='{1}'></span> </td>  <td valign='top' width='50%'> <span id='{2}'></span> <span id='{3}'></span>  </td> </tr> <tr> <td> <span id='{4}'></span> </td> <td> <span id='{5}'></span> </td> </tr> </table>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.MenuItem btnRefrescar = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem btnIniciarProceso = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar menuBarProcesos = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    gwtquery.plugins.droppable.client.gwt.DragAndDropCellTable cellTableProcessDefinitions = owner.cellTableProcessDefinitions;
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.MenuItem btnDetenerInstancia = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar menuBarInstancias = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel9 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    gwtquery.plugins.droppable.client.gwt.DroppableWidget instancesCellList = owner.instancesCellList;
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel7 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel6 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.cellview.client.SimplePager pager = owner.pager;
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.cellview.client.SimplePager pagerCellList = owner.pagerCellList;
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId0, domId1, domId2, domId3, domId4, domId5).asString());

    btnRefrescar.setStyleName("" + style.gwtMenuItem() + "");
    btnRefrescar.setText("Refrescar");
    menuBarProcesos.addItem(btnRefrescar);
    btnIniciarProceso.setStyleName("" + style.gwtMenuItem() + "");
    btnIniciarProceso.setText("Iniciar proceso");
    menuBarProcesos.addItem(btnIniciarProceso);
    menuBarProcesos.setAutoOpen(false);
    menuBarProcesos.setTitle("Main");
    menuBarProcesos.setAnimationEnabled(true);
    f_HorizontalPanel1.add(menuBarProcesos);
    f_HorizontalPanel1.setStyleName("" + style.rightHorizontalPanel() + "");
    f_HorizontalPanel1.setWidth("100%");
    f_VerticalPanel2.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_Label3.setStyleName("" + style.title() + "");
    f_Label3.setText("Procesos registrados");
    f_VerticalPanel2.add(f_Label3);
    f_HorizontalPanel4.setStyleName("" + style.demoHr() + "");
    f_HorizontalPanel4.setWidth("100%");
    f_HorizontalPanel4.setHeight("0px");
    f_VerticalPanel2.add(f_HorizontalPanel4);
    cellTableProcessDefinitions.setWidth("100%");
    cellTableProcessDefinitions.setPageSize(10);
    f_VerticalPanel2.add(cellTableProcessDefinitions);
    f_VerticalPanel2.addStyleName("" + style.cellTable() + "");
    btnDetenerInstancia.setStyleName("" + style.gwtMenuItem() + "");
    btnDetenerInstancia.setText("Detener");
    menuBarInstancias.addItem(btnDetenerInstancia);
    menuBarInstancias.setAutoOpen(true);
    menuBarInstancias.setTitle("Main");
    menuBarInstancias.setAnimationEnabled(false);
    f_HorizontalPanel5.add(menuBarInstancias);
    f_HorizontalPanel5.setStyleName("" + style.rightHorizontalPanel() + "");
    f_HorizontalPanel5.setWidth("100%");
    f_VerticalPanel7.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_Label8.setStyleName("" + style.title() + "");
    f_Label8.setText("Instancias");
    f_VerticalPanel7.add(f_Label8);
    f_HorizontalPanel9.setStyleName("" + style.demoHr() + "");
    f_HorizontalPanel9.setWidth("100%");
    f_HorizontalPanel9.setHeight("0px");
    f_VerticalPanel7.add(f_HorizontalPanel9);
    instancesCellList.setWidth("430px");
    f_VerticalPanel7.add(instancesCellList);
    f_VerticalPanel7.setCellWidth(instancesCellList, "100%");
    f_VerticalPanel7.addStyleName("" + style.cellTable() + "");
    f_HorizontalPanel6.add(f_VerticalPanel7);
    f_HorizontalPanel6.setSpacing(1);

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(htmlPanel.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    attachRecord0.detach();
    htmlPanel.addAndReplaceElement(f_HorizontalPanel1, domId0Element);
    htmlPanel.addAndReplaceElement(f_VerticalPanel2, domId1Element);
    htmlPanel.addAndReplaceElement(f_HorizontalPanel5, domId2Element);
    htmlPanel.addAndReplaceElement(f_HorizontalPanel6, domId3Element);
    htmlPanel.addAndReplaceElement(pager, domId4Element);
    htmlPanel.addAndReplaceElement(pagerCellList, domId5Element);


    owner.btnDetenerInstancia = btnDetenerInstancia;
    owner.btnIniciarProceso = btnIniciarProceso;
    owner.btnRefrescar = btnRefrescar;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return htmlPanel;
  }
}
