package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ProcessCoreCaseManagementViewImpl_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementViewImpl>, com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementViewImpl.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table> <tr> <td heigth='100%' width='600px'> <span id='{0}'></span> </td> </tr> </table>")
    SafeHtml html1(String arg0);
     
    @Template("<table width='100%'> <tr style='height:39px;background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 12px; font-weight:600;'> Seguimiento de casos ingresados </span> </div> </td>  </tr>  <tr> <td valign='top' width='40%'> <span id='{0}'></span> </td>  </tr> <tr> <td> <span id='{1}'></span> </td>  </tr> </table>")
    SafeHtml html2(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementViewImpl_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementViewImpl_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementViewImpl_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.process.ProcessCoreCaseManagementViewImpl_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox txtCaso = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox lstProcesos = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
    com.google.gwt.user.client.ui.Button btnBuscar = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId1).asString());
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.FlexTable flexProcessTable = (com.google.gwt.user.client.ui.FlexTable) GWT.create(com.google.gwt.user.client.ui.FlexTable.class);
    com.google.gwt.user.client.ui.SimplePanel formWidget = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId0, domId2).asString());

    f_HorizontalPanel3.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label4.setWidth("90px");
    f_Label4.setText("N° de caso :");
    f_HorizontalPanel3.add(f_Label4);
    f_HorizontalPanel3.add(txtCaso);
    f_VerticalPanel2.add(f_HorizontalPanel3);
    f_HorizontalPanel5.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label6.setWidth("90px");
    f_Label6.setText("Proceso :");
    f_HorizontalPanel5.add(f_Label6);
    lstProcesos.setWidth("200px");
    f_HorizontalPanel5.add(lstProcesos);
    btnBuscar.setText("Buscar");
    f_HorizontalPanel5.add(btnBuscar);
    f_VerticalPanel2.add(f_HorizontalPanel5);
    f_HTMLPanel1.setWidth("100%");
    f_HTMLPanel1.setHeight("100%");
    flexProcessTable.setBorderWidth(0);
    flexProcessTable.setWidth("100%");
    flexProcessTable.setHeight("100%");
    formWidget.add(flexProcessTable);
    formWidget.setStyleName("" + style.cellTable() + "");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(htmlPanel.getElement());
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord1.detach();
    f_HTMLPanel1.addAndReplaceElement(f_VerticalPanel2, domId1Element);
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord0.detach();
    htmlPanel.addAndReplaceElement(f_HTMLPanel1, domId0Element);
    htmlPanel.addAndReplaceElement(formWidget, domId2Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickGuardar(event);
      }
    };
    btnBuscar.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.btnBuscar = btnBuscar;
    owner.flexProcessTable = flexProcessTable;
    owner.formWidget = formWidget;
    owner.lstProcesos = lstProcesos;
    owner.txtCaso = txtCaso;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return htmlPanel;
  }
}
