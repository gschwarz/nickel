package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl>, com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl.CellTableEstadoTiendaImplUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table width='100%'> <tr> <td> <span id='{0}'></span> </td> </tr> <tr> <td valign='top'> <span id='{1}'></span> </td> <td valign='top'> <span id='{2}'></span> </td> </tr> <tr> <td> <span id='{3}'></span> </td> </tr> </table>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.MenuItem btnConsultarTiendas = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar f_MenuBar2 = new com.google.gwt.user.client.ui.MenuBar(true);
    com.google.gwt.user.client.ui.MenuItem btnConsultar = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem btnAbrirTienda = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem btnCerrarTienda = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar f_MenuBar3 = new com.google.gwt.user.client.ui.MenuBar(true);
    com.google.gwt.user.client.ui.MenuItem btnAccount = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar menuBar = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.cellview.client.CellTable cellTableEstadoTienda = owner.cellTableEstadoTienda;
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel4 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel5 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.cellview.client.SimplePager pager = owner.pager;
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId0, domId1, domId2, domId3).asString());

    btnConsultarTiendas.setText("Todas las tiendas");
    f_MenuBar2.addItem(btnConsultarTiendas);
    btnConsultar.setSubMenu(f_MenuBar2);
    btnConsultar.setText("Consultar");
    menuBar.addItem(btnConsultar);
    btnAbrirTienda.setText("Abrir todas tiendas");
    f_MenuBar3.addItem(btnAbrirTienda);
    btnCerrarTienda.setText("Cerrar todas tiendas");
    f_MenuBar3.addItem(btnCerrarTienda);
    btnAccount.setSubMenu(f_MenuBar3);
    btnAccount.setText("Acciones");
    menuBar.addItem(btnAccount);
    menuBar.setAutoOpen(true);
    menuBar.setTitle("Main");
    menuBar.setAnimationEnabled(false);
    f_HorizontalPanel1.add(menuBar);
    f_HorizontalPanel1.setStyleName("" + style.rightHorizontalPanel() + "");
    cellTableEstadoTienda.addStyleName("" + style.cellTable() + "");
    cellTableEstadoTienda.setPageSize(16);
    f_ScrollPanel4.add(cellTableEstadoTienda);
    f_ScrollPanel4.setWidth("50%");
    f_ScrollPanel4.setHeight("100%");
    f_ScrollPanel5.setWidth("50%");
    f_ScrollPanel5.setHeight("100%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(htmlPanel.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    attachRecord0.detach();
    htmlPanel.addAndReplaceElement(f_HorizontalPanel1, domId0Element);
    htmlPanel.addAndReplaceElement(f_ScrollPanel4, domId1Element);
    htmlPanel.addAndReplaceElement(f_ScrollPanel5, domId2Element);
    htmlPanel.addAndReplaceElement(pager, domId3Element);


    owner.btnAbrirTienda = btnAbrirTienda;
    owner.btnCerrarTienda = btnCerrarTienda;
    owner.btnConsultarTiendas = btnConsultarTiendas;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return htmlPanel;
  }
}
