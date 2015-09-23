package com.rhiscom.bpm.console.client.ui.administration.profile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AddUpdateProfilesDialog_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.administration.profile.AddUpdateProfilesDialog>, com.rhiscom.bpm.console.client.ui.administration.profile.AddUpdateProfilesDialog.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<h4> Administración de Perfiles del sistema</h4>")
    SafeHtml html1();
     
    @Template("<div style='margin-top:10px;left:0px;float:left;margin-left:2px;'> <span id='{0}'></span> </div>")
    SafeHtml html2(String arg0);
     
    @Template("<div style='margin-top:10px;right:0px;float:right;margin-right:2px;'> <span id='{0}'></span> </div>")
    SafeHtml html3(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.administration.profile.AddUpdateProfilesDialog owner) {

    com.rhiscom.bpm.console.client.ui.administration.profile.AddUpdateProfilesDialog_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.administration.profile.AddUpdateProfilesDialog_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.administration.profile.AddUpdateProfilesDialog_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.administration.profile.AddUpdateProfilesDialog_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTML f_HTML2 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label lblError = owner.lblError;
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtPerfil = owner.txtPerfil;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtDescription = owner.txtDescription;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel6 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    gwtquery.plugins.droppable.client.gwt.DroppableWidget cellListAbility = owner.cellListAbility;
    gwtquery.plugins.droppable.client.gwt.DragAndDropCellTree cellTreeModules = owner.cellTreeModules;
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel11 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel10 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel9 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel8 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button btnCancelar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel13 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId0).asString());
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button btnGuardar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel14 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId1).asString());
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel12 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_HTML2.setHTML(template.html1().asString());
    f_HTML2.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_HTML2.setWordWrap(true);
    f_HTML2.setHeight("25px");
    f_VerticalPanel1.add(f_HTML2);
    lblError.setStyleName("" + style.lblError() + "");
    lblError.setHeight("20px");
    f_VerticalPanel1.add(lblError);
    f_VerticalPanel1.setCellHeight(lblError, "18px");
    f_Label5.setWidth("122px");
    f_Label5.setText("Perfil :");
    f_HorizontalPanel4.add(f_Label5);
    f_HorizontalPanel4.setCellVerticalAlignment(f_Label5, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel4.setCellWidth(f_Label5, "122px");
    txtPerfil.setWidth("139px");
    f_HorizontalPanel4.add(txtPerfil);
    f_HorizontalPanel4.setCellWidth(txtPerfil, "139px");
    f_VerticalPanel3.add(f_HorizontalPanel4);
    f_Label7.setWidth("122px");
    f_Label7.setText("Descripcion :");
    f_HorizontalPanel6.add(f_Label7);
    f_HorizontalPanel6.setCellVerticalAlignment(f_Label7, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel6.setCellWidth(f_Label7, "122px");
    txtDescription.setWidth("139px");
    f_HorizontalPanel6.add(txtDescription);
    f_HorizontalPanel6.setCellWidth(txtDescription, "139px");
    f_VerticalPanel3.add(f_HorizontalPanel6);
    f_VerticalPanel3.setStyleName("" + style.borderDecorator() + "");
    f_VerticalPanel3.setHeight("81px");
    f_VerticalPanel1.add(f_VerticalPanel3);
    f_HorizontalPanel10.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    cellListAbility.setStyleName("" + style.cellTableAbility() + "");
    f_HorizontalPanel10.add(cellListAbility);
    f_HorizontalPanel10.setCellWidth(cellListAbility, "50%");
    cellTreeModules.setStyleName("" + style.cellTableTree() + "");
    f_ScrollPanel11.add(cellTreeModules);
    f_ScrollPanel11.setWidth("100%");
    f_ScrollPanel11.setHeight("320px");
    f_HorizontalPanel10.add(f_ScrollPanel11);
    f_HorizontalPanel10.setCellWidth(f_ScrollPanel11, "50%");
    f_HorizontalPanel10.setWidth("100%");
    f_VerticalPanel9.add(f_HorizontalPanel10);
    f_VerticalPanel9.setWidth("100%");
    f_VerticalPanel9.setHeight("320px");
    f_HorizontalPanel8.add(f_VerticalPanel9);
    f_HorizontalPanel8.setStyleName("" + style.borderDecorator() + "");
    f_HorizontalPanel8.setWidth("795px");
    f_VerticalPanel1.add(f_HorizontalPanel8);
    btnCancelar.setWidth("80px");
    btnCancelar.setText("Cancelar");
    btnCancelar.setHeight("25px");
    f_HorizontalPanel12.add(f_HTMLPanel13);
    btnGuardar.setWidth("80px");
    btnGuardar.setText("Guardar");
    btnGuardar.setHeight("25px");
    f_HorizontalPanel12.add(f_HTMLPanel14);
    f_HorizontalPanel12.setWidth("800px");
    f_VerticalPanel1.add(f_HorizontalPanel12);
    f_VerticalPanel1.setSpacing(2);
    f_VerticalPanel1.setWidth("800px");
    f_VerticalPanel1.setHeight("500px");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel13.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel13.addAndReplaceElement(btnCancelar, domId0Element);
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel14.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord1.detach();
    f_HTMLPanel14.addAndReplaceElement(btnGuardar, domId1Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickCancelar(event);
      }
    };
    btnCancelar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickGuardar(event);
      }
    };
    btnGuardar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    owner.btnCancelar = btnCancelar;
    owner.btnGuardar = btnGuardar;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
