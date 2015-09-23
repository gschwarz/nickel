package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class EmailRecipientsConfigurationViewImpl_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationViewImpl>, com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationViewImpl.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table valign='top' width='100%'> <tr style='background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> " + "{0}" + " </span> </div> </td> </tr> </table>")
    SafeHtml html1(String arg0);
     
    @Template("" + "{0}" + "")
    SafeHtml html2(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationViewImpl_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationViewImpl_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationViewImpl_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.administration.EmailRecipientsConfigurationViewImpl_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.rhiscom.bpm.console.client.LocaleMessages i18n = (com.rhiscom.bpm.console.client.LocaleMessages) GWT.create(com.rhiscom.bpm.console.client.LocaleMessages.class);
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1("" + i18n.recipientsConfiguration() + "").asString());
    com.google.gwt.user.client.ui.Label lblErrorRecipients = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox lstEvents = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextArea txtTo = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Button btnGuardarDest = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel7 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    htmlPanel.setWidth("100%");
    f_VerticalPanel1.add(htmlPanel);
    lblErrorRecipients.setStyleName("" + style.lblError() + "");
    lblErrorRecipients.setHeight("18px");
    f_VerticalPanel2.add(lblErrorRecipients);
    f_HorizontalPanel3.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label4.setText("Evento asociado");
    f_HorizontalPanel3.add(f_Label4);
    f_HorizontalPanel3.setCellWidth(f_Label4, "152px");
    lstEvents.addItem("Seleccione", "0");
    lstEvents.addItem("Notificaciones en Cuadratura", "ERROR_CUADRATURA");
    lstEvents.addItem("Finalización Cuadratura", "TERMINO_CUADRATURA");
    lstEvents.setWidth("336px");
    f_HorizontalPanel3.add(lstEvents);
    f_VerticalPanel2.add(f_HorizontalPanel3);
    f_HorizontalPanel5.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    f_Label6.setWidth("152px");
    f_Label6.setText("Destinatarios");
    f_HorizontalPanel5.add(f_Label6);
    txtTo.setWidth("342px");
    txtTo.setHeight("102px");
    f_HorizontalPanel5.add(txtTo);
    f_VerticalPanel2.add(f_HorizontalPanel5);
    f_HorizontalPanel7.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    btnGuardarDest.setHTML(template.html2("" + i18n.save() + "").asString());
    f_HorizontalPanel7.add(btnGuardarDest);
    f_HorizontalPanel7.setWidth("100%");
    f_VerticalPanel2.add(f_HorizontalPanel7);
    f_VerticalPanel2.setStyleName("" + style.cellTable() + "");
    f_VerticalPanel2.setSpacing(1);
    f_VerticalPanel2.setWidth("100%");
    f_VerticalPanel1.add(f_VerticalPanel2);
    f_VerticalPanel1.setStyleName("" + style.panel() + "");
    f_VerticalPanel1.setSpacing(1);
    f_VerticalPanel1.setWidth("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickGuardarRecipients(event);
      }
    };
    btnGuardarDest.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.btnGuardarDest = btnGuardarDest;
    owner.lblErrorRecipients = lblErrorRecipients;
    owner.lstEvents = lstEvents;
    owner.txtTo = txtTo;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
