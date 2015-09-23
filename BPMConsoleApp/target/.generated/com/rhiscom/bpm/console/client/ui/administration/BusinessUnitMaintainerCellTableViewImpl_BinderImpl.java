package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class BusinessUnitMaintainerCellTableViewImpl_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableViewImpl>, com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableViewImpl.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table valign='top' width='100%'> <tr style='background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> " + "{0}" + ".  </span> </div> </td> </tr> <tr> <td valign='top' width='100%'> <span id='{1}'></span> <span id='{2}'></span>  <span id='{3}'></span> </td>  </tr> <tr> <td> <span id='{4}'></span> </td> </tr> </table>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3, String arg4);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableViewImpl_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableViewImpl_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableViewImpl_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.LocaleMessages i18n = (com.rhiscom.bpm.console.client.LocaleMessages) GWT.create(com.rhiscom.bpm.console.client.LocaleMessages.class);
    com.rhiscom.bpm.console.client.ui.administration.BusinessUnitMaintainerCellTableViewImpl_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.MenuItem btnAgregar = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem btnRefrescar = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar menuBarProcesos = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox listadoEstadoListBox = owner.listadoEstadoListBox;
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox businessGroupListBox = owner.businessGroupListBox;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.cellview.client.CellTable cellTableBusinessUnit = owner.cellTableBusinessUnit;
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel5 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.cellview.client.SimplePager pager = owner.pager;
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1("" + i18n.businessUnitTitle() + "", domId0, domId1, domId2, domId3).asString());

    btnAgregar.setStyleName("" + style.gwtMenuItem() + "");
    btnAgregar.setText("" + i18n.create() + "");
    menuBarProcesos.addItem(btnAgregar);
    btnRefrescar.setStyleName("" + style.gwtMenuItem() + "");
    btnRefrescar.setText("" + i18n.refresh() + "");
    menuBarProcesos.addItem(btnRefrescar);
    menuBarProcesos.setAutoOpen(false);
    menuBarProcesos.setTitle("Main");
    menuBarProcesos.setAnimationEnabled(true);
    f_HorizontalPanel1.add(menuBarProcesos);
    f_HorizontalPanel1.setStyleName("" + style.rightHorizontalPanel() + "");
    f_HorizontalPanel1.setWidth("100%");
    f_Label3.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label3.setWidth("66px");
    f_Label3.setText("" + i18n.status() + " :");
    f_HorizontalPanel2.add(f_Label3);
    f_HorizontalPanel2.setCellVerticalAlignment(f_Label3, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel2.setCellWidth(f_Label3, "55");
    listadoEstadoListBox.setWidth("100px");
    f_HorizontalPanel2.add(listadoEstadoListBox);
    f_HorizontalPanel2.setCellWidth(listadoEstadoListBox, "80");
    f_Label4.setWidth("114px");
    f_Label4.setText("" + i18n.businessGroup() + " :");
    f_HorizontalPanel2.add(f_Label4);
    f_HorizontalPanel2.setCellVerticalAlignment(f_Label4, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel2.setCellWidth(f_Label4, "50");
    businessGroupListBox.setWidth("100px");
    businessGroupListBox.setVisibleItemCount(1);
    f_HorizontalPanel2.add(businessGroupListBox);
    f_HorizontalPanel2.setStyleName("" + style.rightHorizontalPanel() + "");
    f_HorizontalPanel2.setSpacing(1);
    f_HorizontalPanel2.setWidth("100%");
    f_HorizontalPanel2.setHeight("30");
    cellTableBusinessUnit.addStyleName("" + style.cellTable() + "");
    cellTableBusinessUnit.setPageSize(12);
    f_ScrollPanel5.add(cellTableBusinessUnit);
    f_ScrollPanel5.setHeight("100%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(htmlPanel.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    attachRecord0.detach();
    htmlPanel.addAndReplaceElement(f_HorizontalPanel1, domId0Element);
    htmlPanel.addAndReplaceElement(f_HorizontalPanel2, domId1Element);
    htmlPanel.addAndReplaceElement(f_ScrollPanel5, domId2Element);
    htmlPanel.addAndReplaceElement(pager, domId3Element);


    owner.btnAgregar = btnAgregar;
    owner.btnRefrescar = btnRefrescar;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return htmlPanel;
  }
}
