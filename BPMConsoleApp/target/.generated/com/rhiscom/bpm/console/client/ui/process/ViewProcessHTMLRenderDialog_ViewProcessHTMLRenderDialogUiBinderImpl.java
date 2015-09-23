package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog>, com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog.ViewProcessHTMLRenderDialogUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<div style='margin-top:10px;left:0px;float:left;margin-left:2px;'>   </div>")
    SafeHtml html1();
     
    @Template("<div style='margin-top:10px;right:0px;float:right;margin-right:2px;'> <span id='{0}'></span> </div>")
    SafeHtml html2(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog owner) {

    com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.Hidden user = owner.user;
    com.google.gwt.user.client.ui.Hidden password = owner.password;
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel verticalPanelForm = owner.verticalPanelForm;
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1().asString());
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Button btnAceptar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId0).asString());
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel1.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    f_HorizontalPanel2.add(user);
    f_HorizontalPanel2.add(password);
    verticalPanelForm.add(f_HorizontalPanel2);
    f_VerticalPanel1.add(verticalPanelForm);
    f_HorizontalPanel3.add(f_HTMLPanel4);
    btnAceptar.setWidth("80px");
    btnAceptar.setText("Cerrar");
    btnAceptar.setHeight("25px");
    f_HorizontalPanel3.add(f_HTMLPanel5);
    f_HorizontalPanel3.setWidth("1150px");
    f_VerticalPanel1.add(f_HorizontalPanel3);
    f_VerticalPanel1.setStyleName("" + style.panel() + "");
    f_VerticalPanel1.setWidth("90%");
    f_VerticalPanel1.setHeight("500px");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel5.addAndReplaceElement(btnAceptar, domId0Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickAceptar(event);
      }
    };
    btnAceptar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.btnAceptar = btnAceptar;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
