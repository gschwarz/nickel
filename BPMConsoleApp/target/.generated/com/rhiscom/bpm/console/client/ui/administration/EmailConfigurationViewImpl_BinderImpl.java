package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class EmailConfigurationViewImpl_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationViewImpl>, com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationViewImpl.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table valign='top' width='100%'> <tr style='background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> " + "{0}" + " </span> </div> </td> </tr> </table>")
    SafeHtml html1(String arg0);
     
    @Template("<h4> " + "{0}" + " </h4>")
    SafeHtml html2(String arg0);
     
    @Template("" + "{0}" + "")
    SafeHtml html3(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationViewImpl_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationViewImpl_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationViewImpl_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.LocaleMessages i18n = (com.rhiscom.bpm.console.client.LocaleMessages) GWT.create(com.rhiscom.bpm.console.client.LocaleMessages.class);
    com.rhiscom.bpm.console.client.ui.administration.EmailConfigurationViewImpl_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1("" + i18n.emailServer() + "").asString());
    com.google.gwt.user.client.ui.HTML f_HTML3 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label lblErrorServer = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox emailSender = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.PasswordTextBox password = (com.google.gwt.user.client.ui.PasswordTextBox) GWT.create(com.google.gwt.user.client.ui.PasswordTextBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel6 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox emailServer = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel8 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox emailPort = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel10 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label13 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel12 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Button btnGuardar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel14 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    htmlPanel.setWidth("100%");
    f_VerticalPanel1.add(htmlPanel);
    f_HTML3.setHTML(template.html2("" + i18n.configEmailServer() + "").asString());
    f_VerticalPanel2.add(f_HTML3);
    lblErrorServer.setStyleName("" + style.lblError() + "");
    lblErrorServer.setHeight("18px");
    f_VerticalPanel2.add(lblErrorServer);
    f_HorizontalPanel4.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_HorizontalPanel4.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label5.setWidth("152px");
    f_Label5.setText("" + i18n.senderEmail() + " :");
    f_HorizontalPanel4.add(f_Label5);
    f_HorizontalPanel4.setCellWidth(f_Label5, "162px");
    emailSender.setWidth("230px");
    f_HorizontalPanel4.add(emailSender);
    f_HorizontalPanel4.setWidth("500px");
    f_VerticalPanel2.add(f_HorizontalPanel4);
    f_HorizontalPanel6.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_HorizontalPanel6.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label7.setWidth("152px");
    f_Label7.setText("Password :");
    f_HorizontalPanel6.add(f_Label7);
    f_HorizontalPanel6.setCellWidth(f_Label7, "162px");
    f_HorizontalPanel6.add(password);
    f_HorizontalPanel6.setWidth("500px");
    f_VerticalPanel2.add(f_HorizontalPanel6);
    f_HorizontalPanel8.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_HorizontalPanel8.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label9.setWidth("152px");
    f_Label9.setText("" + i18n.emailServer() + " :");
    f_HorizontalPanel8.add(f_Label9);
    f_HorizontalPanel8.setCellWidth(f_Label9, "162px");
    f_HorizontalPanel8.add(emailServer);
    f_HorizontalPanel8.setWidth("500px");
    f_VerticalPanel2.add(f_HorizontalPanel8);
    f_HorizontalPanel10.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_HorizontalPanel10.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label11.setWidth("152px");
    f_Label11.setText("" + i18n.serverEmailPort() + " :");
    f_HorizontalPanel10.add(f_Label11);
    f_HorizontalPanel10.setCellWidth(f_Label11, "162px");
    f_HorizontalPanel10.add(emailPort);
    f_HorizontalPanel10.setWidth("500px");
    f_VerticalPanel2.add(f_HorizontalPanel10);
    f_HorizontalPanel12.add(f_Label13);
    f_VerticalPanel2.add(f_HorizontalPanel12);
    f_HorizontalPanel14.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    btnGuardar.setHTML(template.html3("" + i18n.save() + "").asString());
    f_HorizontalPanel14.add(btnGuardar);
    f_HorizontalPanel14.setWidth("100%");
    f_VerticalPanel2.add(f_HorizontalPanel14);
    f_VerticalPanel2.setStyleName("" + style.cellTable() + "");
    f_VerticalPanel2.setSpacing(1);
    f_VerticalPanel2.setWidth("100%");
    f_VerticalPanel1.add(f_VerticalPanel2);
    f_VerticalPanel1.setStyleName("" + style.panel() + "");
    f_VerticalPanel1.setSpacing(1);
    f_VerticalPanel1.setWidth("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickGuardar(event);
      }
    };
    btnGuardar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.btnGuardar = btnGuardar;
    owner.emailPort = emailPort;
    owner.emailSender = emailSender;
    owner.emailServer = emailServer;
    owner.lblErrorServer = lblErrorServer;
    owner.password = password;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
