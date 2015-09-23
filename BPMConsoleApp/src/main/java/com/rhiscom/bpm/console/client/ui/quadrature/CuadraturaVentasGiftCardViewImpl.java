package com.rhiscom.bpm.console.client.ui.quadrature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.rhiscom.bpm.console.client.remote.QuadratureService;
import com.rhiscom.bpm.console.client.remote.QuadratureServiceAsync;
import com.rhiscom.bpm.console.client.remote.RetailDomainService;
import com.rhiscom.bpm.console.client.remote.RetailDomainServiceAsync;
import com.rhiscom.bpm.console.shared.model.dto.BusinessUnitDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO;

public class CuadraturaVentasGiftCardViewImpl extends Composite implements CuadraturaVentasGiftCardView {
    final QuadratureServiceAsync quadratureService = GWT.create(QuadratureService.class);
    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    private static final DateTimeFormat dtf = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_LONG);
    private static final DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static final DateTimeFormat dfStr = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static final Binder binder = GWT.create(Binder.class);
    NumberFormat fmt = NumberFormat.getDecimalFormat();

    @UiField
    Label lblError;
    @UiField
    ListBox sucursalSeleccionada;
    @UiField(provided = true)
    DateBox dateOfBusinessDateBox;
    @UiField
    Label lblVentasGiftCardCMR;
    @UiField
    Label lblDonacionesGiftCMR2;
    @UiField
    Label lblNcrGiftCMR;
    @UiField
    Label lblVentasGiftCorporativa;
    @UiField
    Label lblDonacionesGiftCorporativa;
    @UiField
    Label lblNcrGiftCorporativa;
    @UiField
    Label lblTotalPlaCuadCMR;
    @UiField
    Label lblTotalPlaCuaCorporativa;
    @UiField
    Label lblSumatoriaPlcua;
    @UiField
    Label lblTotal;
    @UiField
    Label lblSumatoriaMpvgc;
    @UiField
    Label lblDiferencia;
    @UiField
    Label lblTotalVentasGiftCardCMRPVGC;
    @UiField
    Label lblAnulacionesVtaNCAGiftCMR;
    @UiField
    Label lblTotalAnulacionesNCRGiftCMR;
    @UiField
    Label lblTotalVentasGiftCMRPVGC;
    @UiField
    Label lblTotalVentasGiftCorporativa;
    @UiField
    Label lblAnulacionesVtaNCAGifCorporativa;
    @UiField
    Label lblTotalAnulacionesNCRGiftCorporativa;
    @UiField
    Label lblTotalGifCorporativa;
    @UiField
    Label lblVersionPOS;
    @UiField
    Label lblDonacionesGiftCMR;

    interface Binder extends UiBinder<Widget, CuadraturaVentasGiftCardViewImpl> {
    }

    public CuadraturaVentasGiftCardViewImpl() {

	dateOfBusinessDateBox = new DateBox();
	dateOfBusinessDateBox.setValue(new Date());
	dateOfBusinessDateBox.setFormat(new DateBox.DefaultFormat(dtf));
	initWidget(binder.createAndBindUi(this));

	traerUnidadesDeNegocios(true);
	lblError.setVisible(false);
	setCerosEnLabels();
    }

    @UiHandler("filterButton")
    public void onClickCSV(ClickEvent e) {
	lblError.setVisible(false);
	traerCuadraturaVentasGiftCard();
    }

    @UiHandler("excelButton")
    public void onClickExcel(ClickEvent e) {
	lblError.setVisible(false);
	String fechaNegocio = df.format(dateOfBusinessDateBox.getValue());
	long sucursal = Long.valueOf(sucursalSeleccionada.getValue(sucursalSeleccionada.getSelectedIndex()));

	if (sucursal == -1) {
	    lblError.setVisible(true);
	    lblError.setText("Debe seleccionar sucursal");
	} else {
	    String url = GWT.getModuleBaseURL() + "ExcelVentasGiftCard?businessDate=" + fechaNegocio + "&sucursal="
		    + sucursal;
	    Window.open(url, "", "");
	}
    }

    /**
     * M�todo que consulta solo los grupos vigentes.
     */
    public void traerUnidadesDeNegocios(final boolean vigentes) {
	try {

	    retailDomainService.getBusinessUnitAll(new AsyncCallback<List<BusinessUnitDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    Window.alert("Servicio no disponible :" + ex.toString());
		}

		@Override
		public void onSuccess(List<BusinessUnitDTO> list) {

		    List<BusinessUnitDTO> listVigentes = new ArrayList<BusinessUnitDTO>();
		    List<BusinessUnitDTO> listNoVigentes = new ArrayList<BusinessUnitDTO>();

		    for (int i = 0; i <= list.size() - 1; i++) {
			if (list.get(i).getStatus() == 1) {
			    listVigentes.add(list.get(i));
			} else {
			    listNoVigentes.add(list.get(i));
			}
		    }
		    sucursalSeleccionada.addItem("--Seleccione--", "-1");
		    for (int i = 0; i <= listVigentes.size() - 1; i++) {
			sucursalSeleccionada.addItem(listVigentes.get(i).getCode(), listVigentes.get(i).getCode());
		    }

		}

	    });
	} catch (Exception ex) {
	}
    }

    private void traerCuadraturaVentasGiftCard() {

	Date fechaNegocio = dateOfBusinessDateBox.getValue();
	long sucursal = Long.valueOf(sucursalSeleccionada.getValue(sucursalSeleccionada.getSelectedIndex()));
	String fechaNegocioStr = dfStr.format(fechaNegocio);
	if (sucursal == -1) {
	    lblError.setVisible(true);
	    lblError.setText("Debe seleccionar sucursal");
	} else {

	    try {

		quadratureService.getCuadraturaVtaGiftCard(fechaNegocioStr, sucursal,
			new AsyncCallback<CuadraturaVentasGiftCardDTO>() {
			    @Override
			    public void onFailure(Throwable ex) {

			    }

			    @Override
			    public void onSuccess(CuadraturaVentasGiftCardDTO result) {

				if (result != null) {

				    lblVentasGiftCardCMR.setText(fmt.format(result.getVentasGiftCardCMR()));
				    lblDonacionesGiftCMR.setText(fmt.format(result.getDonacionesGiftCMR()));
				    lblNcrGiftCMR.setText(fmt.format(result.getNcrGiftCMR()));
				    lblTotalPlaCuadCMR.setText(fmt.format(result.getTotalPlaCuadCMR()));
				    lblVentasGiftCorporativa.setText(fmt.format(result.getVentasGiftCorporativa()));
				    lblDonacionesGiftCorporativa.setText(fmt.format(result
					    .getDonacionesGiftCorporativa()));
				    lblNcrGiftCorporativa.setText(fmt.format(result.getNcrGiftCorporativa()));
				    lblTotalPlaCuaCorporativa.setText(fmt.format(result.getTotalPlaCuaCorporativa()));
				    lblTotalVentasGiftCardCMRPVGC.setText(fmt.format(result
					    .getTotalVentasGiftCardCMRPVGC()));
				    lblAnulacionesVtaNCAGiftCMR.setText(fmt.format(result.getAnulacionesVtaNCAGiftCMR()));
				    lblTotalAnulacionesNCRGiftCMR.setText(fmt.format(result
					    .getTotalAnulacionesNCRGiftCMR()));
				    lblTotalVentasGiftCMRPVGC.setText(fmt.format(result.getTotalVentasGiftCMRPVGC()));
				    lblTotalVentasGiftCorporativa.setText(fmt.format(result
					    .getTotalVentasGiftCorporativa()));
				    lblAnulacionesVtaNCAGifCorporativa.setText(fmt.format(result
					    .getAnulacionesVtaNCAGifCorporativa()));
				    lblTotalAnulacionesNCRGiftCorporativa.setText(fmt.format(result
					    .getTotalAnulacionesNCRGiftCorporativa()));
				    lblTotalGifCorporativa.setText(fmt.format(result.getTotalGifCorporativa()));
				    /**
				     * TOTALES FINALES
				     * 
				     */
				    lblSumatoriaPlcua.setText(fmt.format(result.getSumatoriaPlcua()));
				    lblDiferencia.setText(fmt.format(result.getDiferenciaPlacuadMpvgc()));
				    lblSumatoriaMpvgc.setText(fmt.format(result.getSumatoriaMpvgc()));
				    lblVersionPOS.setText(result.getVersionPOS());

				} else {

				    lblError.setVisible(true);
				    lblError.setText("Resultados no encontrados");
				    setCerosEnLabels();
				}
			    }

			});
	    } catch (Exception ex) {
	    }
	}

    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }

    private void setCerosEnLabels() {
	lblVentasGiftCardCMR.setText("0");
	lblDonacionesGiftCMR.setText("0");
	lblNcrGiftCMR.setText("0");
	lblTotalPlaCuadCMR.setText("0");
	lblVentasGiftCorporativa.setText("0");
	lblDonacionesGiftCorporativa.setText("0");
	lblNcrGiftCorporativa.setText("0");
	lblTotalPlaCuaCorporativa.setText("0");
	lblTotalVentasGiftCardCMRPVGC.setText("0");
	lblAnulacionesVtaNCAGiftCMR.setText("0");
	lblTotalAnulacionesNCRGiftCMR.setText("0");
	lblTotalVentasGiftCMRPVGC.setText("0");
	lblTotalVentasGiftCorporativa.setText("0");
	lblAnulacionesVtaNCAGifCorporativa.setText("0");
	lblTotalAnulacionesNCRGiftCorporativa.setText("0");
	lblTotalGifCorporativa.setText("0");
	/**
	 * TOTALES FINALES
	 * 
	 */
	lblSumatoriaPlcua.setText("0");
	lblDiferencia.setText("0");
	lblSumatoriaMpvgc.setText("0");
	lblVersionPOS.setText("0");
    }
}
