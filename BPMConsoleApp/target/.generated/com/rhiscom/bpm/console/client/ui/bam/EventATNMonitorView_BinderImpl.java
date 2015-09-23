package com.rhiscom.bpm.console.client.ui.bam;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class EventATNMonitorView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.bam.EventATNMonitorView>, com.rhiscom.bpm.console.client.ui.bam.EventATNMonitorView.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table valign='top' width='100%'> <tr style='background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> SuiteTestCase Activity Monitoring </span> </div> </td> </tr> </table>")
    SafeHtml html1();
     
    @Template("<table style='border: 1px solid #ccc' width='100%'> <thead> <th width='100%'> Suite Test Case </th> </thead> <tr> <td width='50%'> Nombre plan de Pruebas : </td> <td width='50%'> <span id='{0}'></span> </td> </tr> <tr> <td width='50%'> Fecha Inicio : </td> <td width='50%'> <span id='{1}'></span> </td> </tr> <tr> <td width='50%'> Fecha termino : </td> <td width='50%'> <span id='{2}'></span> </td> </tr> </table>")
    SafeHtml html2(String arg0, String arg1, String arg2);
     
    @Template("<div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> " + "{0}" + " </span> </div> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.bam.EventATNMonitorView owner) {

    com.rhiscom.bpm.console.client.ui.bam.EventATNMonitorView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.bam.EventATNMonitorView_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.bam.EventATNMonitorView_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.LocaleMessages i18n = (com.rhiscom.bpm.console.client.LocaleMessages) GWT.create(com.rhiscom.bpm.console.client.LocaleMessages.class);
    com.rhiscom.bpm.console.client.ui.bam.EventATNMonitorView_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1().asString());
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label STCName = owner.STCName;
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label STCStartDate = owner.STCStartDate;
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label STCEndDate = owner.STCEndDate;
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId1, domId2, domId3).asString());
    com.google.gwt.user.client.ui.SimplePanel instancesPanel = owner.instancesPanel;
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel4 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.cellview.client.CellTable cellTablelog = owner.cellTablelog;
    com.google.gwt.user.cellview.client.SimplePager pager = owner.pager;
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel6 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3("" + i18n.executionLog() + "", domId0).asString());
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.add(htmlPanel);
    f_VerticalPanel4.add(f_HTMLPanel5);
    f_VerticalPanel4.add(instancesPanel);
    f_VerticalPanel4.setSpacing(1);
    f_VerticalPanel4.setWidth("100%");
    f_HorizontalPanel3.add(f_VerticalPanel4);
    f_VerticalPanel6.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_VerticalPanel6.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    cellTablelog.addStyleName("" + style.cellTable() + "");
    cellTablelog.setPageSize(10);
    f_VerticalPanel6.add(cellTablelog);
    f_VerticalPanel6.add(pager);
    f_VerticalPanel6.setSpacing(1);
    f_VerticalPanel6.setWidth("680px");
    f_HorizontalPanel3.add(f_VerticalPanel6);
    f_HorizontalPanel3.setWidth("100%");
    f_HTMLPanel2.setWidth("100%");
    f_VerticalPanel1.add(f_HTMLPanel2);
    f_VerticalPanel1.setWidth("100%");
    f_VerticalPanel1.setHeight("100%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    attachRecord1.detach();
    f_HTMLPanel5.addAndReplaceElement(STCName, domId1Element);
    f_HTMLPanel5.addAndReplaceElement(STCStartDate, domId2Element);
    f_HTMLPanel5.addAndReplaceElement(STCEndDate, domId3Element);
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel2.addAndReplaceElement(f_HorizontalPanel3, domId0Element);


    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
