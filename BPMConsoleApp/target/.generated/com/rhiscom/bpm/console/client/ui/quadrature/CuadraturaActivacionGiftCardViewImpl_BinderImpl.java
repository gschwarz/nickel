package com.rhiscom.bpm.console.client.ui.quadrature;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class CuadraturaActivacionGiftCardViewImpl_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardViewImpl>, com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardViewImpl.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table valign='top' width='100%'> <tr class='{0}'> <td colspan='2' style='height:30px;' width='100%'> <div class='{1}'> <span id='{2}'></span> </div> </td> </tr> </table>")
    SafeHtml html1(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardViewImpl_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardViewImpl_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardViewImpl_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaActivacionGiftCardViewImpl_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label title = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template.html1("" + style.titleBackground() + "", "" + style.titleBackgroundPosition() + "", domId0).asString());
    com.google.gwt.user.client.ui.Label lblError = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox sucursalSeleccionada = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel5 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.datepicker.client.DateBox dateOfBusinessDateBox = owner.dateOfBusinessDateBox;
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel7 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Button filterButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button excelButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Label f_Label10 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblVersionPOS = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel9 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label14 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel13 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label16 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel15 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label19 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblActivacionGiftCardCMR = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel18 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label21 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblAnulacionGiftCardCMR = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel20 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label23 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblSubTotalGiftCardCMR = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel22 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label25 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel24 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label27 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblActivacionGiftCardCorporativa = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel26 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label29 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblAnulacionGiftCardCorporativa = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel28 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label31 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblSubTotalGiftCardCorporativa = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel30 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label33 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblTotalGiftCard = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel32 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel17 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel12 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label36 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel35 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label38 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel37 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label40 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblActivacionCMRCod55 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel39 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label lbl1 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblAnulacionCMRCod58 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel41 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label43 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblSubTotalCod05 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel42 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label45 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel44 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label47 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblActivacionCorporativaCod55 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel46 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label49 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblAnulacionCorporativaCod58 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel48 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label51 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblSubTotalCod03 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel50 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label53 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblTotal2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel52 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel34 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel11 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label57 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblSubTotalGiftCardCorporativa2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel56 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label59 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblSubTotalGiftCardCMR2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel58 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label61 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblTotal3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel60 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label63 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label lblDiferencia = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel62 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel55 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel54 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    title.setStyleName("" + style.title() + "");
    title.setText("Cuadratura Activación GiftCard");
    htmlPanel.setWidth("100%");
    f_VerticalPanel2.add(htmlPanel);
    f_HorizontalPanel3.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    lblError.setStyleName("lblError");
    lblError.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    lblError.setWidth("99%");
    lblError.setText("Debe ingresar fecha de negocio");
    lblError.setHeight("20px");
    f_HorizontalPanel3.add(lblError);
    f_HorizontalPanel3.setWidth("100%");
    f_VerticalPanel2.add(f_HorizontalPanel3);
    f_Label6.setWidth("100px");
    f_Label6.setText("Sucursal");
    f_Label6.setHeight("");
    f_VerticalPanel5.add(f_Label6);
    sucursalSeleccionada.setWidth("100px");
    sucursalSeleccionada.setHeight("25px");
    f_VerticalPanel5.add(sucursalSeleccionada);
    f_HorizontalPanel4.add(f_VerticalPanel5);
    f_Label8.setText("Fecha de negocio");
    f_VerticalPanel7.add(f_Label8);
    f_VerticalPanel7.add(dateOfBusinessDateBox);
    f_HorizontalPanel4.add(f_VerticalPanel7);
    filterButton.setText("Buscar");
    f_HorizontalPanel4.add(filterButton);
    excelButton.setText("Exportar");
    f_HorizontalPanel4.add(excelButton);
    f_Label10.setText("Versión");
    f_VerticalPanel9.add(f_Label10);
    lblVersionPOS.setStyleName("" + style.secondTitle() + "");
    lblVersionPOS.setWidth("100px");
    lblVersionPOS.setHeight("25px");
    f_VerticalPanel9.add(lblVersionPOS);
    f_HorizontalPanel4.add(f_VerticalPanel9);
    f_HorizontalPanel4.setStyleName("" + style.filters() + "");
    f_HorizontalPanel4.setWidth("100%");
    f_VerticalPanel2.add(f_HorizontalPanel4);
    f_Label14.setStyleName("" + style.secondTitle() + "");
    f_Label14.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_Label14.setText("PLACUAD");
    f_VerticalPanel13.add(f_Label14);
    f_VerticalPanel13.setWidth("100%");
    f_VerticalPanel12.add(f_VerticalPanel13);
    f_Label16.setStyleName("" + style.secondTitle() + "");
    f_Label16.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label16.setText("GIFTCARD CMR");
    f_Label16.setHeight("25px");
    f_VerticalPanel15.add(f_Label16);
    f_VerticalPanel15.setWidth("100%");
    f_VerticalPanel12.add(f_VerticalPanel15);
    f_Label19.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label19.setWidth("268px");
    f_Label19.setText("Activación GIFT CARD CMR");
    f_Label19.setHeight("25px");
    f_HorizontalPanel18.add(f_Label19);
    f_HorizontalPanel18.setCellVerticalAlignment(f_Label19, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    lblActivacionGiftCardCMR.setWidth("100px");
    lblActivacionGiftCardCMR.setHeight("25px");
    f_HorizontalPanel18.add(lblActivacionGiftCardCMR);
    f_HorizontalPanel18.setCellHorizontalAlignment(lblActivacionGiftCardCMR, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel18.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel18.setWidth("100%");
    f_VerticalPanel17.add(f_HorizontalPanel18);
    f_Label21.setWidth("268px");
    f_Label21.setText("Anulación GIFTCARD CMR");
    f_Label21.setHeight("25px");
    f_HorizontalPanel20.add(f_Label21);
    lblAnulacionGiftCardCMR.setWidth("100px");
    lblAnulacionGiftCardCMR.setHeight("25px");
    f_HorizontalPanel20.add(lblAnulacionGiftCardCMR);
    f_HorizontalPanel20.setCellHorizontalAlignment(lblAnulacionGiftCardCMR, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel20.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel20.setWidth("100%");
    f_VerticalPanel17.add(f_HorizontalPanel20);
    f_Label23.setStyleName("" + style.secondTitle() + "");
    f_Label23.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_Label23.setWidth("268px");
    f_Label23.setText("Sub total");
    f_Label23.setHeight("25px");
    f_HorizontalPanel22.add(f_Label23);
    lblSubTotalGiftCardCMR.setWidth("100px");
    lblSubTotalGiftCardCMR.setHeight("25px");
    f_HorizontalPanel22.add(lblSubTotalGiftCardCMR);
    f_HorizontalPanel22.setCellHorizontalAlignment(lblSubTotalGiftCardCMR, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel22.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel22.setWidth("100%");
    f_VerticalPanel17.add(f_HorizontalPanel22);
    f_Label25.setStyleName("" + style.secondTitle() + "");
    f_Label25.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label25.setWidth("100%");
    f_Label25.setText("GIFTCARD CORPORATIVA");
    f_Label25.setHeight("25px");
    f_VerticalPanel24.add(f_Label25);
    f_VerticalPanel24.setWidth("100%");
    f_VerticalPanel17.add(f_VerticalPanel24);
    f_Label27.setWidth("268px");
    f_Label27.setText("Activación GIFTCARD Corporativa");
    f_Label27.setHeight("25px");
    f_HorizontalPanel26.add(f_Label27);
    lblActivacionGiftCardCorporativa.setWidth("100px");
    lblActivacionGiftCardCorporativa.setHeight("25px");
    f_HorizontalPanel26.add(lblActivacionGiftCardCorporativa);
    f_HorizontalPanel26.setCellHorizontalAlignment(lblActivacionGiftCardCorporativa, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel26.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel26.setWidth("100%");
    f_VerticalPanel17.add(f_HorizontalPanel26);
    f_Label29.setWidth("268px");
    f_Label29.setText("Anulac. Act. GIFTCARD Corporativa");
    f_Label29.setHeight("30px");
    f_HorizontalPanel28.add(f_Label29);
    lblAnulacionGiftCardCorporativa.setWidth("100px");
    lblAnulacionGiftCardCorporativa.setHeight("25px");
    f_HorizontalPanel28.add(lblAnulacionGiftCardCorporativa);
    f_HorizontalPanel28.setCellHorizontalAlignment(lblAnulacionGiftCardCorporativa, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel28.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel28.setWidth("100%");
    f_VerticalPanel17.add(f_HorizontalPanel28);
    f_Label31.setStyleName("" + style.secondTitle() + "");
    f_Label31.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_Label31.setWidth("268px");
    f_Label31.setText("Sub total");
    f_Label31.setHeight("25px");
    f_HorizontalPanel30.add(f_Label31);
    lblSubTotalGiftCardCorporativa.setWidth("100px");
    lblSubTotalGiftCardCorporativa.setHeight("25px");
    f_HorizontalPanel30.add(lblSubTotalGiftCardCorporativa);
    f_HorizontalPanel30.setCellHorizontalAlignment(lblSubTotalGiftCardCorporativa, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel30.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel30.setWidth("100%");
    f_VerticalPanel17.add(f_HorizontalPanel30);
    f_Label33.setStyleName("" + style.redTitle() + "");
    f_Label33.setWidth("268px");
    f_Label33.setText("Total");
    f_Label33.setHeight("25px");
    f_HorizontalPanel32.add(f_Label33);
    lblTotalGiftCard.setStyleName("" + style.redTitle() + "");
    lblTotalGiftCard.setWidth("100px");
    lblTotalGiftCard.setHeight("25px");
    f_HorizontalPanel32.add(lblTotalGiftCard);
    f_HorizontalPanel32.setCellHorizontalAlignment(lblTotalGiftCard, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel32.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel32.setWidth("100%");
    f_VerticalPanel17.add(f_HorizontalPanel32);
    f_VerticalPanel17.setWidth("100%");
    f_VerticalPanel12.add(f_VerticalPanel17);
    f_VerticalPanel12.setStyleName("" + style.borderDecorator() + "");
    f_VerticalPanel12.setWidth("440px");
    f_HorizontalPanel11.add(f_VerticalPanel12);
    f_Label36.setStyleName("" + style.secondTitle() + "");
    f_Label36.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_Label36.setText("MPAGC");
    f_VerticalPanel35.add(f_Label36);
    f_VerticalPanel35.setWidth("100%");
    f_VerticalPanel34.add(f_VerticalPanel35);
    f_Label38.setStyleName("" + style.secondTitle() + "");
    f_Label38.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label38.setWidth("100%");
    f_Label38.setText("COD. 05");
    f_Label38.setHeight("25px");
    f_VerticalPanel37.add(f_Label38);
    f_VerticalPanel37.setWidth("100%");
    f_VerticalPanel34.add(f_VerticalPanel37);
    f_Label40.setWidth("269px");
    f_Label40.setText("ACT (Activación) CMR COD. 55");
    f_Label40.setHeight("25px");
    f_HorizontalPanel39.add(f_Label40);
    f_HorizontalPanel39.setCellHeight(f_Label40, "25px");
    lblActivacionCMRCod55.setWidth("100px");
    lblActivacionCMRCod55.setHeight("25px");
    f_HorizontalPanel39.add(lblActivacionCMRCod55);
    f_HorizontalPanel39.setCellHorizontalAlignment(lblActivacionCMRCod55, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel39.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel39.setWidth("100%");
    f_VerticalPanel34.add(f_HorizontalPanel39);
    lbl1.setWidth("269px");
    lbl1.setText("ACC (Anulación Activación) CMR COD. 58");
    lbl1.setHeight("25px");
    f_HorizontalPanel41.add(lbl1);
    f_HorizontalPanel41.setCellWidth(lbl1, "198px");
    f_HorizontalPanel41.setCellHeight(lbl1, "25px");
    lblAnulacionCMRCod58.setWidth("100px");
    lblAnulacionCMRCod58.setHeight("25px");
    f_HorizontalPanel41.add(lblAnulacionCMRCod58);
    f_HorizontalPanel41.setCellHorizontalAlignment(lblAnulacionCMRCod58, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel41.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel41.setWidth("100%");
    f_VerticalPanel34.add(f_HorizontalPanel41);
    f_Label43.setStyleName("" + style.secondTitle() + "");
    f_Label43.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_Label43.setWidth("328px");
    f_Label43.setText("Sub Total");
    f_Label43.setHeight("25px");
    f_HorizontalPanel42.add(f_Label43);
    lblSubTotalCod05.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    lblSubTotalCod05.setWidth("100px");
    lblSubTotalCod05.setHeight("25px");
    f_HorizontalPanel42.add(lblSubTotalCod05);
    f_HorizontalPanel42.setWidth("100%");
    f_VerticalPanel34.add(f_HorizontalPanel42);
    f_Label45.setStyleName("" + style.secondTitle() + "");
    f_Label45.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_LEFT);
    f_Label45.setWidth("100%");
    f_Label45.setText("COD. 03");
    f_Label45.setHeight("25px");
    f_VerticalPanel44.add(f_Label45);
    f_VerticalPanel44.setWidth("100%");
    f_VerticalPanel34.add(f_VerticalPanel44);
    f_Label47.setWidth("269px");
    f_Label47.setText("ACT (Activación Corporativa) cod. 55");
    f_Label47.setHeight("30px");
    f_HorizontalPanel46.add(f_Label47);
    f_HorizontalPanel46.setCellWidth(f_Label47, "190px");
    f_HorizontalPanel46.setCellHeight(f_Label47, "25px");
    lblActivacionCorporativaCod55.setWidth("100px");
    lblActivacionCorporativaCod55.setHeight("25px");
    f_HorizontalPanel46.add(lblActivacionCorporativaCod55);
    f_HorizontalPanel46.setCellHorizontalAlignment(lblActivacionCorporativaCod55, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel46.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel46.setWidth("100%");
    f_VerticalPanel34.add(f_HorizontalPanel46);
    f_Label49.setWidth("269px");
    f_Label49.setText("ACC (Anulación Activación) Corporativa COD. 58");
    f_Label49.setHeight("25px");
    f_HorizontalPanel48.add(f_Label49);
    f_HorizontalPanel48.setCellWidth(f_Label49, "190px");
    f_HorizontalPanel48.setCellHeight(f_Label49, "25px");
    lblAnulacionCorporativaCod58.setWidth("40%");
    lblAnulacionCorporativaCod58.setHeight("25px");
    f_HorizontalPanel48.add(lblAnulacionCorporativaCod58);
    f_HorizontalPanel48.setCellHorizontalAlignment(lblAnulacionCorporativaCod58, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel48.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel48.setWidth("100%");
    f_VerticalPanel34.add(f_HorizontalPanel48);
    f_Label51.setStyleName("" + style.secondTitle() + "");
    f_Label51.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_Label51.setWidth("328px");
    f_Label51.setText("Sub Total");
    f_Label51.setHeight("25px");
    f_HorizontalPanel50.add(f_Label51);
    lblSubTotalCod03.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    lblSubTotalCod03.setWidth("100px");
    lblSubTotalCod03.setHeight("25px");
    f_HorizontalPanel50.add(lblSubTotalCod03);
    f_HorizontalPanel50.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel50.setWidth("100%");
    f_VerticalPanel34.add(f_HorizontalPanel50);
    f_Label53.setStyleName("" + style.redTitle() + "");
    f_Label53.setWidth("60%");
    f_Label53.setText("Total");
    f_Label53.setHeight("25px");
    f_HorizontalPanel52.add(f_Label53);
    lblTotal2.setStyleName("" + style.redTitle() + "");
    lblTotal2.setWidth("100px");
    lblTotal2.setHeight("25px");
    f_HorizontalPanel52.add(lblTotal2);
    f_HorizontalPanel52.setCellHorizontalAlignment(lblTotal2, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel52.setStyleName("" + style.borderSimple() + "");
    f_HorizontalPanel52.setWidth("100%");
    f_VerticalPanel34.add(f_HorizontalPanel52);
    f_VerticalPanel34.setStyleName("" + style.borderDecorator() + "");
    f_VerticalPanel34.setWidth("440px");
    f_HorizontalPanel11.add(f_VerticalPanel34);
    f_HorizontalPanel11.setSpacing(2);
    f_HorizontalPanel11.setWidth("890px");
    f_VerticalPanel2.add(f_HorizontalPanel11);
    f_VerticalPanel2.setCellWidth(f_HorizontalPanel11, "100%");
    f_VerticalPanel2.setWidth("100%");
    f_VerticalPanel1.add(f_VerticalPanel2);
    f_Label57.setStyleName("" + style.borderSimple() + "");
    f_Label57.setWidth("314px");
    f_Label57.setText("PLCUA Gift Corporativa");
    f_Label57.setHeight("25px");
    f_HorizontalPanel56.add(f_Label57);
    lblSubTotalGiftCardCorporativa2.setStyleName("" + style.borderSimple() + "");
    lblSubTotalGiftCardCorporativa2.setWidth("100px");
    lblSubTotalGiftCardCorporativa2.setHeight("25px");
    f_HorizontalPanel56.add(lblSubTotalGiftCardCorporativa2);
    f_HorizontalPanel56.setCellHorizontalAlignment(lblSubTotalGiftCardCorporativa2, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel56.setSpacing(2);
    f_HorizontalPanel56.setWidth("300px");
    f_VerticalPanel55.add(f_HorizontalPanel56);
    f_Label59.setStyleName("" + style.borderSimple() + "");
    f_Label59.setWidth("314px");
    f_Label59.setText("PLCUA Gift CMR");
    f_Label59.setHeight("25px");
    f_HorizontalPanel58.add(f_Label59);
    lblSubTotalGiftCardCMR2.setStyleName("" + style.borderSimple() + "");
    lblSubTotalGiftCardCMR2.setWidth("100px");
    lblSubTotalGiftCardCMR2.setHeight("25px");
    f_HorizontalPanel58.add(lblSubTotalGiftCardCMR2);
    f_HorizontalPanel58.setCellHorizontalAlignment(lblSubTotalGiftCardCMR2, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel58.setSpacing(2);
    f_HorizontalPanel58.setWidth("300px");
    f_VerticalPanel55.add(f_HorizontalPanel58);
    f_Label61.setStyleName("" + style.borderSimple() + "");
    f_Label61.setWidth("314px");
    f_Label61.setText("MPAGC CMR+Corporativa");
    f_Label61.setHeight("25px");
    f_HorizontalPanel60.add(f_Label61);
    lblTotal3.setStyleName("" + style.borderSimple() + "");
    lblTotal3.setWidth("100px");
    lblTotal3.setHeight("25px");
    f_HorizontalPanel60.add(lblTotal3);
    f_HorizontalPanel60.setCellHorizontalAlignment(lblTotal3, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel60.setSpacing(2);
    f_HorizontalPanel60.setWidth("300px");
    f_VerticalPanel55.add(f_HorizontalPanel60);
    f_Label63.setStyleName("" + style.redTitle() + "");
    f_Label63.setWidth("314px");
    f_Label63.setText("Diferencia");
    f_Label63.setHeight("25px");
    f_HorizontalPanel62.add(f_Label63);
    lblDiferencia.setStyleName("" + style.redTitle() + "");
    lblDiferencia.setWidth("100px");
    lblDiferencia.setHeight("25px");
    f_HorizontalPanel62.add(lblDiferencia);
    f_HorizontalPanel62.setCellHorizontalAlignment(lblDiferencia, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel62.setSpacing(2);
    f_HorizontalPanel62.setWidth("300px");
    f_VerticalPanel55.add(f_HorizontalPanel62);
    f_VerticalPanel55.setStyleName("" + style.borderDecorator() + "");
    f_VerticalPanel55.setWidth("440px");
    f_VerticalPanel55.setHeight("61px");
    f_HorizontalPanel54.add(f_VerticalPanel55);
    f_HorizontalPanel54.setWidth("445px");
    f_VerticalPanel1.add(f_HorizontalPanel54);
    f_VerticalPanel1.setWidth("100%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(htmlPanel.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    htmlPanel.addAndReplaceElement(title, domId0Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickCSV(event);
      }
    };
    filterButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickExcel(event);
      }
    };
    excelButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    owner.lbl1 = lbl1;
    owner.lblActivacionCMRCod55 = lblActivacionCMRCod55;
    owner.lblActivacionCorporativaCod55 = lblActivacionCorporativaCod55;
    owner.lblActivacionGiftCardCMR = lblActivacionGiftCardCMR;
    owner.lblActivacionGiftCardCorporativa = lblActivacionGiftCardCorporativa;
    owner.lblAnulacionCMRCod58 = lblAnulacionCMRCod58;
    owner.lblAnulacionCorporativaCod58 = lblAnulacionCorporativaCod58;
    owner.lblAnulacionGiftCardCMR = lblAnulacionGiftCardCMR;
    owner.lblAnulacionGiftCardCorporativa = lblAnulacionGiftCardCorporativa;
    owner.lblDiferencia = lblDiferencia;
    owner.lblError = lblError;
    owner.lblSubTotalCod03 = lblSubTotalCod03;
    owner.lblSubTotalCod05 = lblSubTotalCod05;
    owner.lblSubTotalGiftCardCMR = lblSubTotalGiftCardCMR;
    owner.lblSubTotalGiftCardCMR2 = lblSubTotalGiftCardCMR2;
    owner.lblSubTotalGiftCardCorporativa = lblSubTotalGiftCardCorporativa;
    owner.lblSubTotalGiftCardCorporativa2 = lblSubTotalGiftCardCorporativa2;
    owner.lblTotal2 = lblTotal2;
    owner.lblTotal3 = lblTotal3;
    owner.lblTotalGiftCard = lblTotalGiftCard;
    owner.lblVersionPOS = lblVersionPOS;
    owner.sucursalSeleccionada = sucursalSeleccionada;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
