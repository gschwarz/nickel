package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class UserMaintainerCellTableViewImpl_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl>, com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table valign='top' width='100%'> <tr style='background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> " + "{0}" + " </span> </div> </td> </tr> <tr> <td valign='top' width='100%'> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> </td> </tr> </table>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.LocaleMessages i18n = (com.rhiscom.bpm.console.client.LocaleMessages) GWT.create(com.rhiscom.bpm.console.client.LocaleMessages.class);
    com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.MenuItem btnAgregar = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem btnRefrescar = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar menuBarProcesos = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtUsuarioBuscar = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.Button btnBuscar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label lblError = owner.lblError;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.cellview.client.CellTable cellTableUsers = owner.cellTableUsers;
    com.google.gwt.user.cellview.client.SimplePager pager = owner.pager;
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel6 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1("" + i18n.userMaintainerTitle() + "", domId0, domId1, domId2).asString());

    btnAgregar.setStyleName("" + style.gwtMenuItem() + "");
    btnAgregar.setText("" + i18n.create() + "");
    menuBarProcesos.addItem(btnAgregar);
    btnRefrescar.setStyleName("" + style.gwtMenuItem() + "");
    btnRefrescar.setText("" + i18n.refresh() + "");
    menuBarProcesos.addItem(btnRefrescar);
    menuBarProcesos.setAutoOpen(false);
    menuBarProcesos.setTitle("Barra de herramientas");
    menuBarProcesos.setAnimationEnabled(true);
    f_HorizontalPanel1.add(menuBarProcesos);
    f_HorizontalPanel1.setStyleName("" + style.rightHorizontalPanel() + "");
    f_HorizontalPanel1.setWidth("100%");
    f_Label4.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label4.setWidth("55px");
    f_Label4.setText("" + i18n.user() + " :");
    f_HorizontalPanel3.add(f_Label4);
    f_HorizontalPanel3.setCellVerticalAlignment(f_Label4, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel3.setCellWidth(f_Label4, "55px");
    txtUsuarioBuscar.setTextAlignment(com.google.gwt.user.client.ui.TextBoxBase.ALIGN_LEFT);
    txtUsuarioBuscar.setAlignment(com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment.LEFT);
    txtUsuarioBuscar.setMaxLength(15);
    txtUsuarioBuscar.setVisibleLength(15);
    f_HorizontalPanel3.add(txtUsuarioBuscar);
    btnBuscar.setWidth("100");
    btnBuscar.setText("" + i18n.search() + "");
    btnBuscar.setHeight("25");
    f_HorizontalPanel3.add(btnBuscar);
    f_HorizontalPanel3.setCellVerticalAlignment(btnBuscar, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel3.setStyleName("" + style.rightHorizontalPanel() + "");
    f_HorizontalPanel3.setWidth("237px");
    f_HorizontalPanel2.add(f_HorizontalPanel3);
    lblError.setStyleName("" + style.lblError() + "");
    f_HorizontalPanel5.add(lblError);
    f_HorizontalPanel5.setCellVerticalAlignment(lblError, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel5.setStyleName("" + style.messagePanel() + "");
    f_HorizontalPanel5.setWidth("180px");
    f_HorizontalPanel5.setHeight("30px");
    f_HorizontalPanel2.add(f_HorizontalPanel5);
    f_HorizontalPanel2.setWidth("240px");
    cellTableUsers.addStyleName("" + style.cellTable() + "");
    cellTableUsers.setWidth("100%");
    cellTableUsers.setPageSize(12);
    f_VerticalPanel6.add(cellTableUsers);
    f_VerticalPanel6.add(pager);
    f_VerticalPanel6.setWidth("100%");
    f_VerticalPanel6.setHeight("100%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(htmlPanel.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord0.detach();
    htmlPanel.addAndReplaceElement(f_HorizontalPanel1, domId0Element);
    htmlPanel.addAndReplaceElement(f_HorizontalPanel2, domId1Element);
    htmlPanel.addAndReplaceElement(f_VerticalPanel6, domId2Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickBuscar(event);
      }
    };
    btnBuscar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.btnAgregar = btnAgregar;
    owner.btnRefrescar = btnRefrescar;
    owner.txtUsuarioBuscar = txtUsuarioBuscar;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return htmlPanel;
  }
}
