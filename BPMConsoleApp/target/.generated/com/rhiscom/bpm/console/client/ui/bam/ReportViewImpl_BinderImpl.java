package com.rhiscom.bpm.console.client.ui.bam;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ReportViewImpl_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.bam.ReportViewImpl>, com.rhiscom.bpm.console.client.ui.bam.ReportViewImpl.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table valign='top' width='100%'> <tr style='background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> Reportes </span> </div> </td> </tr> </table>")
    SafeHtml html1();
     
    @Template("<table style='border: 1px solid #c5c5c5' width='500px'> <tr> <td><span id='{0}'></span></td> <td><span id='{1}'></span></td> <td><span id='{2}'></span></td> <td><span id='{3}'></span></td> </tr> </table>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.bam.ReportViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.bam.ReportViewImpl_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.bam.ReportViewImpl_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.bam.ReportViewImpl_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.bam.ReportViewImpl_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1().asString());
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.datepicker.client.DateBox initDate = (com.google.gwt.user.datepicker.client.DateBox) GWT.create(com.google.gwt.user.datepicker.client.DateBox.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.datepicker.client.DateBox endDate = (com.google.gwt.user.datepicker.client.DateBox) GWT.create(com.google.gwt.user.datepicker.client.DateBox.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId0, domId1, domId2, domId3).asString());
    com.google.gwt.user.client.ui.ListBox lstReport = owner.lstReport;
    com.google.gwt.user.client.ui.ListBox lstProjects = owner.lstProjects;
    com.google.gwt.user.client.ui.Button btnGenerarReporte = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel6 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Frame frameReport = (com.google.gwt.user.client.ui.Frame) GWT.create(com.google.gwt.user.client.ui.Frame.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.add(htmlPanel);
    f_Label4.setText("Fecha inicio");
    f_Label5.setText("Fecha termino");
    f_VerticalPanel2.add(f_HTMLPanel3);
    lstReport.setWidth("160px");
    f_HorizontalPanel6.add(lstReport);
    lstProjects.setWidth("160px");
    f_HorizontalPanel6.add(lstProjects);
    btnGenerarReporte.setText("Generar");
    f_HorizontalPanel6.add(btnGenerarReporte);
    f_HorizontalPanel6.setSpacing(3);
    f_HorizontalPanel6.setWidth("210px");
    f_VerticalPanel2.add(f_HorizontalPanel6);
    frameReport.setWidth("100%");
    frameReport.setUrl("");
    frameReport.setHeight("100%");
    f_VerticalPanel2.add(frameReport);
    f_VerticalPanel2.setCellWidth(frameReport, "100%");
    f_VerticalPanel2.setCellHeight(frameReport, "99%");
    f_VerticalPanel2.setWidth("99%");
    f_VerticalPanel2.setHeight("500px");
    f_VerticalPanel1.add(f_VerticalPanel2);
    f_VerticalPanel1.setWidth("100%");
    f_VerticalPanel1.setHeight("100%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    attachRecord0.detach();
    f_HTMLPanel3.addAndReplaceElement(f_Label4, domId0Element);
    f_HTMLPanel3.addAndReplaceElement(initDate, domId1Element);
    f_HTMLPanel3.addAndReplaceElement(f_Label5, domId2Element);
    f_HTMLPanel3.addAndReplaceElement(endDate, domId3Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickGenerarReporte(event);
      }
    };
    btnGenerarReporte.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.btnGenerarReporte = btnGenerarReporte;
    owner.endDate = endDate;
    owner.frameReport = frameReport;
    owner.initDate = initDate;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
