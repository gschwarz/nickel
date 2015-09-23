package com.rhiscom.bpm.console.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl>, com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl.LoginPanelViewImplUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<div id='backgroundLogin'> </div>")
    SafeHtml html1();
     
    @Template("<table cellpadding='0' cellspacing='0' class='shadow' height='100%' valign='top' width='100%'> <tr> <td align='center' heigth='70px' width='100%'> <div style='heigth=70px;'> <strong> " + "{0}" + "</strong> </div> <hr> </td> </tr> <tr> <td align='center'> <span id='{1}'></span> </td> </tr> <tr> <td> <table cellpadding='0' cellspacing='0' class='shadow' height='100%' valign='top' width='100%'> <tr> <td style='padding: 10px;' width='100%'> <table cellpadding='0' cellspacing='0' height='100%' valign='top' width='100%'> <tr> <td align='left' style='height:20px;' width='70px'> <span>" + "{2}" + " :</span> </td> <td align='left' style='height:20px;' width='90px'> <span id='{3}'></span> </td> </tr> <tr> <td align='left' style='height:20px;' width='70px'> <span>" + "{4}" + " :</span> </td> <td align='left' style='height:20px;' width='90px'> <span id='{5}'></span> </td> </tr> <tr> <td class='alignRight' colspan='2' style='height:20px;' width='300px'> <div style='margin-top:10px;right:0px;float:right;margin-right:2px;'> <span id='{6}'></span> </div> </td> </tr> </table> </td> </tr> </table> </td> </tr> </table>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.LocaleMessages i18n = (com.rhiscom.bpm.console.client.LocaleMessages) GWT.create(com.rhiscom.bpm.console.client.LocaleMessages.class);
    com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1().asString());
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label lblError = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox Username = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.PasswordTextBox password = owner.password;
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button button = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2("" + i18n.loginTitle() + "", domId0, "" + i18n.user() + "", domId1, "" + i18n.password() + "", domId2, domId3).asString());
    com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);

    f_FlowPanel1.add(f_HTMLPanel2);
    lblError.setStyleName("" + style.lblError() + "");
    lblError.setHeight("20px");
    Username.setWidth("90px");
    Username.setHeight("20px");
    password.setWidth("90px");
    password.setHeight("20px");
    button.setWidth("80px");
    button.setText("" + i18n.login() + "");
    button.setHeight("25px");
    f_HTMLPanel3.setStyleName("" + style.loginTable() + "");
    f_HTMLPanel3.setWidth("400px");
    f_HTMLPanel3.setHeight("190px");
    f_FlowPanel1.add(f_HTMLPanel3);

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    attachRecord0.detach();
    f_HTMLPanel3.addAndReplaceElement(lblError, domId0Element);
    f_HTMLPanel3.addAndReplaceElement(Username, domId1Element);
    f_HTMLPanel3.addAndReplaceElement(password, domId2Element);
    f_HTMLPanel3.addAndReplaceElement(button, domId3Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClick(event);
      }
    };
    button.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.Username = Username;
    owner.button = button;
    owner.lblError = lblError;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_FlowPanel1;
  }
}
