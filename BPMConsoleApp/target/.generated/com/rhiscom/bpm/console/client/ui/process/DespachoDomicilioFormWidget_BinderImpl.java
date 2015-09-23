package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class DespachoDomicilioFormWidget_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.process.DespachoDomicilioFormWidget>, com.rhiscom.bpm.console.client.ui.process.DespachoDomicilioFormWidget.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table width='100%'> <tr style='height:39px;background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 12px; font-weight:600;'> Datos del cliente </span> </div> </td> </tr> </table>")
    SafeHtml html1();
     
    @Template("<table width='100%'> <tr style='height:39px;background: #d3def6 url(BPMConsoleApp/gwt/chrome/images/hborder.png) repeat-x 0px -989px'> <td colspan='2' style='height:30px;' width='100%'> <div style='width:100%;height:100%;overflow:hidden;text-align:center; margin-top:6px'> <span style='font-size: 12px; font-weight:600;'> Datos de la venta </span> </div> </td> </tr> </table>")
    SafeHtml html2();
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.process.DespachoDomicilioFormWidget owner) {

    com.rhiscom.bpm.console.client.ui.process.DespachoDomicilioFormWidget_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.process.DespachoDomicilioFormWidget_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.process.DespachoDomicilioFormWidget_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.process.DespachoDomicilioFormWidget_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel htmlCliente = new com.google.gwt.user.client.ui.HTMLPanel(template.html1().asString());
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblNumeroCliente = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblNombreCompleto = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblDireccion = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel lblPanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblCorreo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel8 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblTelefono = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel10 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel htmlVenta = new com.google.gwt.user.client.ui.HTMLPanel(template.html2().asString());
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel12 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label14 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblIdPedido = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel13 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label15 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblfechaGeneracion = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel lblFecha = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label17 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblTotalVenta = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel16 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label19 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblLocal = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel18 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label21 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblEstadoVenta = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel20 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    htmlCliente.setWidth("100%");
    f_HorizontalPanel2.add(htmlCliente);
    f_HorizontalPanel2.setWidth("100%");
    f_VerticalPanel1.add(f_HorizontalPanel2);
    f_Label4.setWidth("125px");
    f_Label4.setText("Numero de cliente :");
    f_HorizontalPanel3.add(f_Label4);
    lblNumeroCliente.setWidth("150px");
    f_HorizontalPanel3.add(lblNumeroCliente);
    f_HorizontalPanel3.setWidth("275px");
    f_VerticalPanel1.add(f_HorizontalPanel3);
    f_Label6.setWidth("125px");
    f_Label6.setText("Nombre completo :");
    f_HorizontalPanel5.add(f_Label6);
    lblNombreCompleto.setWidth("150px");
    f_HorizontalPanel5.add(lblNombreCompleto);
    f_HorizontalPanel5.setWidth("275px");
    f_VerticalPanel1.add(f_HorizontalPanel5);
    f_Label7.setWidth("125px");
    f_Label7.setText("Dirección de envío :");
    lblPanel.add(f_Label7);
    lblDireccion.setWidth("150px");
    lblPanel.add(lblDireccion);
    lblPanel.setWidth("275px");
    f_VerticalPanel1.add(lblPanel);
    f_Label9.setWidth("125px");
    f_Label9.setText("Correo electrónico :");
    f_HorizontalPanel8.add(f_Label9);
    lblCorreo.setWidth("150px");
    f_HorizontalPanel8.add(lblCorreo);
    f_HorizontalPanel8.setWidth("275px");
    f_VerticalPanel1.add(f_HorizontalPanel8);
    f_Label11.setWidth("125px");
    f_Label11.setText("Telefono de contacto :");
    f_HorizontalPanel10.add(f_Label11);
    lblTelefono.setWidth("150px");
    f_HorizontalPanel10.add(lblTelefono);
    f_HorizontalPanel10.setWidth("275px");
    f_VerticalPanel1.add(f_HorizontalPanel10);
    htmlVenta.setWidth("100%");
    f_HorizontalPanel12.add(htmlVenta);
    f_HorizontalPanel12.setWidth("100%");
    f_VerticalPanel1.add(f_HorizontalPanel12);
    f_HorizontalPanel13.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label14.setWidth("125px");
    f_Label14.setText("Id Pedido :");
    f_HorizontalPanel13.add(f_Label14);
    lblIdPedido.setWidth("150px");
    lblIdPedido.setHeight("");
    f_HorizontalPanel13.add(lblIdPedido);
    f_HorizontalPanel13.setWidth("275px");
    f_HorizontalPanel13.setHeight("21px");
    f_VerticalPanel1.add(f_HorizontalPanel13);
    f_Label15.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label15.setWidth("125px");
    f_Label15.setText("Fecha de generación :");
    lblFecha.add(f_Label15);
    lblfechaGeneracion.setWidth("150px");
    lblFecha.add(lblfechaGeneracion);
    lblFecha.setWidth("275px");
    f_VerticalPanel1.add(lblFecha);
    f_Label17.setWidth("125px");
    f_Label17.setText("Total venta :");
    f_HorizontalPanel16.add(f_Label17);
    lblTotalVenta.setWidth("150px");
    f_HorizontalPanel16.add(lblTotalVenta);
    f_HorizontalPanel16.setWidth("275px");
    f_VerticalPanel1.add(f_HorizontalPanel16);
    f_Label19.setWidth("125px");
    f_Label19.setText("Local de generación :");
    f_HorizontalPanel18.add(f_Label19);
    lblLocal.setWidth("150px");
    f_HorizontalPanel18.add(lblLocal);
    f_HorizontalPanel18.setWidth("275px");
    f_VerticalPanel1.add(f_HorizontalPanel18);
    f_Label21.setWidth("125px");
    f_Label21.setText("Estado :");
    f_HorizontalPanel20.add(f_Label21);
    lblEstadoVenta.setWidth("150px");
    f_HorizontalPanel20.add(lblEstadoVenta);
    f_HorizontalPanel20.setWidth("275px");
    f_VerticalPanel1.add(f_HorizontalPanel20);
    f_VerticalPanel1.setWidth("100%");



    owner.lblCorreo = lblCorreo;
    owner.lblDireccion = lblDireccion;
    owner.lblEstadoVenta = lblEstadoVenta;
    owner.lblFecha = lblFecha;
    owner.lblIdPedido = lblIdPedido;
    owner.lblLocal = lblLocal;
    owner.lblNombreCompleto = lblNombreCompleto;
    owner.lblNumeroCliente = lblNumeroCliente;
    owner.lblPanel = lblPanel;
    owner.lblTelefono = lblTelefono;
    owner.lblTotalVenta = lblTotalVenta;
    owner.lblfechaGeneracion = lblfechaGeneracion;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
