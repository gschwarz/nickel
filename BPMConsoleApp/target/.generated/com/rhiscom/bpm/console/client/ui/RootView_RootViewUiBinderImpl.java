package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class RootView_RootViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.RootView>, com.rhiscom.bpm.console.client.ui.RootView.RootViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <table cellpadding='0' cellspacing='0' style='float: right; vertical-align:middle; height:22px; position: absolute; top:2px; left: 83%'> <tr> <td align='right' height='50' valign='middle' width='200px'> <table cellpadding='0' cellspacing='2' style='float: right; color:#FFF;vertical-align:middle; height:20px;' width='200px'> <tr> <td align='left' class='tdTextLoginImg' height='20' width='24px'> <span id='{1}'></span> </td> <td align='left' class='tdTextLoginImg' height='20' width='24px'> <img src='img/User-Go-32.png' width='23'> </td> <td align='left' class='tdTextLogin' height='20' width='90px'> <span id='{2}'></span> </td> <td align='left' height='20' width='200px'> <h5> v1.0.23 </h5> </td> </tr> </table> </td> </tr> </table>")
    SafeHtml html1(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.RootView owner) {

    com.rhiscom.bpm.console.client.ui.RootView_RootViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.RootView_RootViewUiBinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.RootView_RootViewUiBinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.RootViewImageResources res = (com.rhiscom.bpm.console.client.ui.RootViewImageResources) GWT.create(com.rhiscom.bpm.console.client.ui.RootViewImageResources.class);
    com.rhiscom.bpm.console.client.LocaleMessages i18n = (com.rhiscom.bpm.console.client.LocaleMessages) GWT.create(com.rhiscom.bpm.console.client.LocaleMessages.class);
    com.rhiscom.bpm.console.client.ui.RootView_RootViewUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Image f_Image4 = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Image logoutButton = owner.logoutButton;
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label userLogged = owner.userLogged;
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId0, domId1, domId2).asString());
    com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
    com.google.gwt.user.client.ui.SimplePanel leftPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
    com.google.gwt.user.client.ui.ScrollPanel rightPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.DockLayoutPanel f_DockLayoutPanel1 = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.EM);

    f_Image4.setStyleName("" + style.margin() + "");
    f_Image4.setWidth("97px");
    f_Image4.setUrl("img/logo-header.png");
    f_Image4.setHeight("50px");
    logoutButton.setStyleName("" + style.logoutButton() + "");
    logoutButton.setTitle("" + i18n.logout() + "");
    logoutButton.setPixelSize(24, 20);
    logoutButton.setUrl("" + res.getCloseIcon().getSafeUri().asString() + "");
    userLogged.setStyleName("" + style.textLogged() + "");
    f_HTMLPanel3.setStyleName("" + style.titleBar() + "");
    f_FlowPanel2.add(f_HTMLPanel3);
    f_FlowPanel2.setStyleName("" + style.northPanel() + "");
    f_DockLayoutPanel1.addNorth(f_FlowPanel2, 4);
    leftPanel.setStyleName("" + style.eastPanel() + "");
    f_DockLayoutPanel1.addWest(leftPanel, 19);
    rightPanel.setStyleName("" + style.rightHorizontalPanel() + "");
    f_DockLayoutPanel1.add(rightPanel);

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord0.detach();
    f_HTMLPanel3.addAndReplaceElement(f_Image4, domId0Element);
    f_HTMLPanel3.addAndReplaceElement(logoutButton, domId1Element);
    f_HTMLPanel3.addAndReplaceElement(userLogged, domId2Element);


    owner.leftPanel = leftPanel;
    owner.rightPanel = rightPanel;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_DockLayoutPanel1;
  }
}
