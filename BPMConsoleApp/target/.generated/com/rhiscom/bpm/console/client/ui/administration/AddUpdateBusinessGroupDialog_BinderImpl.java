package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AddUpdateBusinessGroupDialog_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog>, com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<h4> " + "{0}" + ".</h4>")
    SafeHtml html1(String arg0);
     
    @Template("<div style='margin-top:10px;left:0px;float:left;margin-left:2px;'> <span id='{0}'></span> </div>")
    SafeHtml html2(String arg0);
     
    @Template("<div style='margin-top:10px;right:0px;float:right;margin-right:2px;'> <span id='{0}'></span> </div>")
    SafeHtml html3(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog owner) {

    com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.LocaleMessages i18n = (com.rhiscom.bpm.console.client.LocaleMessages) GWT.create(com.rhiscom.bpm.console.client.LocaleMessages.class);
    com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTML f_HTML2 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label lblError = owner.lblError;
    com.google.gwt.user.client.ui.Label lblNombre = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtName = owner.txtName;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox listadoEstadoListBox = owner.listadoEstadoListBox;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label lblNivelPadre = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox listadoNiveles = owner.listadoNiveles;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel7 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label lblParent = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox listadoBusinessGroup = owner.listadoBusinessGroup;
    com.google.gwt.user.client.ui.HorizontalPanel parentPanel = owner.parentPanel;
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel8 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button btnCancelar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId0).asString());
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button btnGuardar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId1).asString());
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel9 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel1.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    f_HTML2.setHTML(template.html1("" + i18n.businessGroupTitle() + "").asString());
    f_HTML2.setWordWrap(true);
    f_HTML2.setHeight("15px");
    f_VerticalPanel1.add(f_HTML2);
    lblError.setStyleName("" + style.lblError() + "");
    lblError.setHeight("20px");
    f_VerticalPanel1.add(lblError);
    f_VerticalPanel1.setCellHeight(lblError, "20px");
    f_VerticalPanel3.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_HorizontalPanel4.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    lblNombre.setStyleName("" + style.td() + "");
    lblNombre.setWidth("80px");
    lblNombre.setText("" + i18n.name() + "");
    f_HorizontalPanel4.add(lblNombre);
    f_HorizontalPanel4.setCellVerticalAlignment(lblNombre, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    txtName.setStyleName("" + style.td() + "");
    f_HorizontalPanel4.add(txtName);
    f_VerticalPanel3.add(f_HorizontalPanel4);
    f_Label6.setWidth("80px");
    f_Label6.setText("Estado");
    f_HorizontalPanel5.add(f_Label6);
    f_HorizontalPanel5.setCellVerticalAlignment(f_Label6, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    listadoEstadoListBox.setWidth("100px");
    f_HorizontalPanel5.add(listadoEstadoListBox);
    f_VerticalPanel3.add(f_HorizontalPanel5);
    f_HorizontalPanel7.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    lblNivelPadre.setStyleName("" + style.td() + "");
    lblNivelPadre.setWidth("80px");
    lblNivelPadre.setText("" + i18n.level() + "");
    f_HorizontalPanel7.add(lblNivelPadre);
    f_HorizontalPanel7.setCellVerticalAlignment(lblNivelPadre, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    listadoNiveles.setStyleName("" + style.td() + "");
    listadoNiveles.setWidth("100px");
    f_HorizontalPanel7.add(listadoNiveles);
    f_VerticalPanel3.add(f_HorizontalPanel7);
    parentPanel.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    lblParent.setStyleName("" + style.td() + "");
    lblParent.setWidth("80px");
    lblParent.setText("" + i18n.parentLevel() + "");
    parentPanel.add(lblParent);
    parentPanel.setCellVerticalAlignment(lblParent, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    listadoBusinessGroup.setStyleName("" + style.td() + "");
    listadoBusinessGroup.setWidth("100px");
    parentPanel.add(listadoBusinessGroup);
    parentPanel.setWidth("145px");
    f_VerticalPanel3.add(parentPanel);
    f_VerticalPanel3.setCellWidth(parentPanel, "145px");
    f_VerticalPanel3.setStyleName("" + style.borderDecorator() + "");
    f_VerticalPanel3.setWidth("430px");
    f_VerticalPanel3.setHeight("123px");
    f_VerticalPanel1.add(f_VerticalPanel3);
    f_VerticalPanel1.setCellHeight(f_VerticalPanel3, "30");
    f_VerticalPanel8.setHeight("25px");
    f_VerticalPanel1.add(f_VerticalPanel8);
    btnCancelar.setWidth("80px");
    btnCancelar.setText("" + i18n.cancel() + "");
    btnCancelar.setHeight("25px");
    f_HorizontalPanel9.add(f_HTMLPanel10);
    btnGuardar.setWidth("80px");
    btnGuardar.setText("" + i18n.save() + "");
    btnGuardar.setHeight("25px");
    f_HorizontalPanel9.add(f_HTMLPanel11);
    f_HorizontalPanel9.setWidth("450px");
    f_VerticalPanel1.add(f_HorizontalPanel9);
    f_VerticalPanel1.setCellWidth(f_HorizontalPanel9, "450px");
    f_VerticalPanel1.setStyleName("" + style.panel() + "");
    f_VerticalPanel1.setWidth("400px");
    f_VerticalPanel1.setHeight("250px");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel10.addAndReplaceElement(btnCancelar, domId0Element);
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord1.detach();
    f_HTMLPanel11.addAndReplaceElement(btnGuardar, domId1Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickGuardar(event);
      }
    };
    btnGuardar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickCancelar(event);
      }
    };
    btnCancelar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    owner.btnCancelar = btnCancelar;
    owner.btnGuardar = btnGuardar;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
