package com.rhiscom.bpm.console.client.ui.bam;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MonitoringProcessViewImpl_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.bam.MonitoringProcessViewImpl>, com.rhiscom.bpm.console.client.ui.bam.MonitoringProcessViewImpl.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table valign='top' width='100%'> <tr style='background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 1.1em; font-weight:bold;'> " + "{0}" + " </span> </div> </td> </tr> </table>")
    SafeHtml html1(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.bam.MonitoringProcessViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.bam.MonitoringProcessViewImpl_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.bam.MonitoringProcessViewImpl_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.bam.MonitoringProcessViewImpl_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.LocaleMessages i18n = (com.rhiscom.bpm.console.client.LocaleMessages) GWT.create(com.rhiscom.bpm.console.client.LocaleMessages.class);
    com.rhiscom.bpm.console.client.ui.bam.MonitoringProcessViewImpl_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1("" + i18n.executionLog() + "").asString());
    com.google.gwt.user.client.ui.Button btnRefrescar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.cellview.client.CellTable cellTablelog = owner.cellTablelog;
    com.google.gwt.user.cellview.client.SimplePager pager = owner.pager;
    com.google.gwt.user.client.ui.VerticalPanel logPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.add(htmlPanel);
    f_HorizontalPanel3.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    btnRefrescar.setWidth("90px");
    btnRefrescar.setText("Refrescar");
    btnRefrescar.setHeight("23px");
    f_HorizontalPanel3.add(btnRefrescar);
    f_HorizontalPanel3.setWidth("100%");
    f_HorizontalPanel3.setHeight("25px");
    f_VerticalPanel2.add(f_HorizontalPanel3);
    f_VerticalPanel2.setCellHorizontalAlignment(f_HorizontalPanel3, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_VerticalPanel2.setCellWidth(f_HorizontalPanel3, "100%");
    f_VerticalPanel2.setCellHeight(f_HorizontalPanel3, "25px");
    logPanel.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    logPanel.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    cellTablelog.addStyleName("" + style.cellTable() + "");
    cellTablelog.setPageSize(11);
    logPanel.add(cellTablelog);
    logPanel.add(pager);
    logPanel.setSpacing(1);
    logPanel.setWidth("99%");
    f_VerticalPanel2.add(logPanel);
    f_VerticalPanel2.setWidth("99%");
    f_VerticalPanel2.setHeight("99%px");
    f_VerticalPanel1.add(f_VerticalPanel2);
    f_VerticalPanel1.setWidth("100%");
    f_VerticalPanel1.setHeight("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickRefresh(event);
      }
    };
    btnRefrescar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
