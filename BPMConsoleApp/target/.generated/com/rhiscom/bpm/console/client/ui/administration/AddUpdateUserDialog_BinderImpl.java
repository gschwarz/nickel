package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AddUpdateUserDialog_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.administration.AddUpdateUserDialog>, com.rhiscom.bpm.console.client.ui.administration.AddUpdateUserDialog.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<h4> " + "{0}" + "</h4>")
    SafeHtml html1(String arg0);
     
    @Template("<h4> " + "{0}" + " </h4>")
    SafeHtml html2(String arg0);
     
    @Template("<h4> " + "{0}" + "</h4>")
    SafeHtml html3(String arg0);
     
    @Template("<div style='margin-top:10px;left:0px;float:left;margin-left:2px;'> <span id='{0}'></span> </div>")
    SafeHtml html4(String arg0);
     
    @Template("<div style='margin-top:10px;right:0px;float:right;margin-right:2px;'> <span id='{0}'></span> </div>")
    SafeHtml html5(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.administration.AddUpdateUserDialog owner) {

    com.rhiscom.bpm.console.client.ui.administration.AddUpdateUserDialog_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.administration.AddUpdateUserDialog_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.administration.AddUpdateUserDialog_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.LocaleMessages i18n = (com.rhiscom.bpm.console.client.LocaleMessages) GWT.create(com.rhiscom.bpm.console.client.LocaleMessages.class);
    com.rhiscom.bpm.console.client.ui.administration.AddUpdateUserDialog_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTML f_HTML2 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label lblError = owner.lblError;
    com.google.gwt.user.client.ui.HTML f_HTML5 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtNombre = owner.txtNombre;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel6 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtSegundoNombre = owner.txtSegundoNombre;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel8 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtApellido = owner.txtApellido;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel10 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label13 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtIdentification = owner.txtIdentification;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel12 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label15 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtEmail = owner.txtEmail;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel14 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label17 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox lstGender = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel16 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel4 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel18 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTML f_HTML20 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label lblNombre = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtUser = owner.txtUser;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel21 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label23 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.PasswordTextBox txtPassword = owner.txtPassword;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel22 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label25 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox lstParty = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel24 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label lblPerfil = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox lstPerfil = owner.lstPerfil;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel26 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label lblBusinessUnit = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox lstBusinessUnit = owner.lstBusinessUnit;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel27 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel28 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel19 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel29 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button btnCancelar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel31 = new com.google.gwt.user.client.ui.HTMLPanel(template.html4(domId0).asString());
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button btnGuardar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel32 = new com.google.gwt.user.client.ui.HTMLPanel(template.html5(domId1).asString());
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel30 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel1.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    f_HTML2.setHTML(template.html1("" + i18n.userMaintainerTitle() + "").asString());
    f_HTML2.setWordWrap(true);
    f_HTML2.setHeight("20px");
    f_VerticalPanel1.add(f_HTML2);
    lblError.setStyleName("" + style.lblError() + "");
    lblError.setHeight("18px");
    f_VerticalPanel1.add(lblError);
    f_VerticalPanel1.setCellHeight(lblError, "18px");
    f_HTML5.setHTML(template.html2("" + i18n.userData() + "").asString());
    f_HTML5.setWordWrap(true);
    f_VerticalPanel4.add(f_HTML5);
    f_Label7.setWidth("122px");
    f_Label7.setText("" + i18n.name() + " :");
    f_HorizontalPanel6.add(f_Label7);
    f_HorizontalPanel6.setCellVerticalAlignment(f_Label7, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel6.setCellWidth(f_Label7, "122px");
    txtNombre.setWidth("139px");
    f_HorizontalPanel6.add(txtNombre);
    f_HorizontalPanel6.setCellWidth(txtNombre, "139px");
    f_HorizontalPanel6.setWidth("270px");
    f_VerticalPanel4.add(f_HorizontalPanel6);
    f_Label9.setWidth("122px");
    f_Label9.setText("" + i18n.middleName() + " :");
    f_HorizontalPanel8.add(f_Label9);
    f_HorizontalPanel8.setCellVerticalAlignment(f_Label9, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel8.setCellWidth(f_Label9, "122px");
    txtSegundoNombre.setWidth("139px");
    f_HorizontalPanel8.add(txtSegundoNombre);
    f_HorizontalPanel8.setWidth("270px");
    f_VerticalPanel4.add(f_HorizontalPanel8);
    f_Label11.setWidth("122px");
    f_Label11.setText("" + i18n.lastName() + " :");
    f_HorizontalPanel10.add(f_Label11);
    f_HorizontalPanel10.setCellVerticalAlignment(f_Label11, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel10.setCellWidth(f_Label11, "122px");
    txtApellido.setWidth("139px");
    f_HorizontalPanel10.add(txtApellido);
    f_HorizontalPanel10.setCellWidth(txtApellido, "139px");
    f_HorizontalPanel10.setWidth("270px");
    f_VerticalPanel4.add(f_HorizontalPanel10);
    f_Label13.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label13.setWidth("122px");
    f_Label13.setText("" + i18n.rut() + " :");
    f_Label13.setHeight("20px");
    f_HorizontalPanel12.add(f_Label13);
    f_HorizontalPanel12.setCellVerticalAlignment(f_Label13, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel12.setCellWidth(f_Label13, "122px");
    txtIdentification.setWidth("139px");
    f_HorizontalPanel12.add(txtIdentification);
    f_HorizontalPanel12.setCellWidth(txtIdentification, "139px");
    f_HorizontalPanel12.setWidth("270px");
    f_VerticalPanel4.add(f_HorizontalPanel12);
    f_Label15.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label15.setWidth("122px");
    f_Label15.setText("" + i18n.email() + " :");
    f_Label15.setHeight("20px");
    f_HorizontalPanel14.add(f_Label15);
    f_HorizontalPanel14.setCellVerticalAlignment(f_Label15, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel14.setCellWidth(f_Label15, "122px");
    f_HorizontalPanel14.setCellHeight(f_Label15, "20px");
    txtEmail.setWidth("139px");
    f_HorizontalPanel14.add(txtEmail);
    f_HorizontalPanel14.setCellWidth(txtEmail, "139px");
    f_HorizontalPanel14.setWidth("270px");
    f_VerticalPanel4.add(f_HorizontalPanel14);
    f_Label17.setWidth("122px");
    f_Label17.setText("" + i18n.gender() + " :");
    f_HorizontalPanel16.add(f_Label17);
    f_HorizontalPanel16.setCellWidth(f_Label17, "122px");
    lstGender.addItem("" + "" + "" + i18n.male() + "" + "" + "", "1");
    lstGender.addItem("" + "" + "" + i18n.female() + "" + "" + "", "2");
    lstGender.setWidth("149px");
    lstGender.setVisibleItemCount(1);
    f_HorizontalPanel16.add(lstGender);
    f_HorizontalPanel16.setCellWidth(lstGender, "139px");
    f_HorizontalPanel16.setWidth("270px");
    f_VerticalPanel4.add(f_HorizontalPanel16);
    f_VerticalPanel4.setStyleName("" + style.borderDecorator() + "");
    f_VerticalPanel4.setWidth("200px");
    f_VerticalPanel4.setHeight("250px");
    f_HorizontalPanel3.add(f_VerticalPanel4);
    f_HorizontalPanel18.setWidth("20px");
    f_HorizontalPanel3.add(f_HorizontalPanel18);
    f_HorizontalPanel3.setCellWidth(f_HorizontalPanel18, "20px");
    f_HTML20.setHTML(template.html3("" + i18n.inputDataUser() + "").asString());
    f_HTML20.setWordWrap(true);
    f_VerticalPanel19.add(f_HTML20);
    f_HorizontalPanel21.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_HorizontalPanel21.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    lblNombre.setStyleName("" + style.td() + "");
    lblNombre.setWidth("122px");
    lblNombre.setText("" + i18n.user() + " :");
    f_HorizontalPanel21.add(lblNombre);
    f_HorizontalPanel21.setCellWidth(lblNombre, "122px");
    txtUser.setStyleName("" + style.td() + "");
    txtUser.setWidth("139px");
    f_HorizontalPanel21.add(txtUser);
    f_HorizontalPanel21.setCellWidth(txtUser, "139px");
    f_HorizontalPanel21.setWidth("270px");
    f_VerticalPanel19.add(f_HorizontalPanel21);
    f_VerticalPanel19.setCellWidth(f_HorizontalPanel21, "270px");
    f_Label23.setWidth("122px");
    f_Label23.setText("" + i18n.password() + " :");
    f_HorizontalPanel22.add(f_Label23);
    f_HorizontalPanel22.setCellVerticalAlignment(f_Label23, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel22.setCellWidth(f_Label23, "122px");
    txtPassword.setStyleName("" + style.td() + "");
    txtPassword.setWidth("139px");
    f_HorizontalPanel22.add(txtPassword);
    f_HorizontalPanel22.setCellWidth(txtPassword, "139px");
    f_HorizontalPanel22.setWidth("270px");
    f_VerticalPanel19.add(f_HorizontalPanel22);
    f_Label25.setWidth("122px");
    f_Label25.setText("" + i18n.userType() + " :");
    f_HorizontalPanel24.add(f_Label25);
    f_HorizontalPanel24.setCellWidth(f_Label25, "122px");
    lstParty.addItem("" + "" + "" + i18n.systemUser() + "" + "" + "", "1");
    lstParty.addItem("" + "" + "" + i18n.client() + "" + "" + "", "2");
    lstParty.setWidth("149px");
    lstParty.setVisibleItemCount(1);
    f_HorizontalPanel24.add(lstParty);
    f_HorizontalPanel24.setCellWidth(lstParty, "150px");
    f_HorizontalPanel24.setWidth("270px");
    f_VerticalPanel19.add(f_HorizontalPanel24);
    f_HorizontalPanel26.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_HorizontalPanel26.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    lblPerfil.setStyleName("" + style.td() + "");
    lblPerfil.setWidth("122px");
    lblPerfil.setText("" + i18n.profile() + " :");
    f_HorizontalPanel26.add(lblPerfil);
    f_HorizontalPanel26.setCellWidth(lblPerfil, "122px");
    lstPerfil.setStyleName("" + style.td() + "");
    lstPerfil.setWidth("149px");
    lstPerfil.setVisibleItemCount(1);
    f_HorizontalPanel26.add(lstPerfil);
    f_HorizontalPanel26.setCellWidth(lstPerfil, "149px");
    f_HorizontalPanel26.setWidth("270px");
    f_VerticalPanel19.add(f_HorizontalPanel26);
    f_HorizontalPanel27.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_HorizontalPanel27.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    lblBusinessUnit.setStyleName("" + style.td() + "");
    lblBusinessUnit.setWidth("122px");
    lblBusinessUnit.setText("" + i18n.businessUnit() + " :");
    f_HorizontalPanel27.add(lblBusinessUnit);
    f_HorizontalPanel27.setCellWidth(lblBusinessUnit, "122px");
    lstBusinessUnit.setStyleName("" + style.td() + "");
    lstBusinessUnit.setWidth("149px");
    lstBusinessUnit.setVisibleItemCount(1);
    f_HorizontalPanel27.add(lstBusinessUnit);
    f_HorizontalPanel27.setCellWidth(lstBusinessUnit, "149px");
    f_HorizontalPanel27.setWidth("270px");
    f_VerticalPanel19.add(f_HorizontalPanel27);
    f_VerticalPanel28.setWidth("100%");
    f_VerticalPanel28.setHeight("10px");
    f_VerticalPanel19.add(f_VerticalPanel28);
    f_VerticalPanel19.setCellWidth(f_VerticalPanel28, "100%");
    f_VerticalPanel19.setStyleName("" + style.borderDecorator() + "");
    f_VerticalPanel19.setWidth("250px");
    f_VerticalPanel19.setHeight("250px");
    f_HorizontalPanel3.add(f_VerticalPanel19);
    f_VerticalPanel1.add(f_HorizontalPanel3);
    f_VerticalPanel1.setCellHeight(f_HorizontalPanel3, "30");
    f_VerticalPanel29.setHeight("10px");
    f_VerticalPanel1.add(f_VerticalPanel29);
    btnCancelar.setWidth("80px");
    btnCancelar.setText("" + i18n.cancel() + "");
    btnCancelar.setHeight("25px");
    f_HorizontalPanel30.add(f_HTMLPanel31);
    btnGuardar.setWidth("80px");
    btnGuardar.setText("" + i18n.save() + "");
    btnGuardar.setHeight("25px");
    f_HorizontalPanel30.add(f_HTMLPanel32);
    f_HorizontalPanel30.setWidth("680px");
    f_VerticalPanel1.add(f_HorizontalPanel30);
    f_VerticalPanel1.setStyleName("" + style.panel() + "");
    f_VerticalPanel1.setWidth("600px");
    f_VerticalPanel1.setHeight("400px");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel31.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel31.addAndReplaceElement(btnCancelar, domId0Element);
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel32.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord1.detach();
    f_HTMLPanel32.addAndReplaceElement(btnGuardar, domId1Element);


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
    owner.lstGender = lstGender;
    owner.lstParty = lstParty;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
