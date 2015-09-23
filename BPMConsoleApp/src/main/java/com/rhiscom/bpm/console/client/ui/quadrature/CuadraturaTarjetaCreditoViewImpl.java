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
import com.google.gwt.user.client.ui.Button;
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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO;

public class CuadraturaTarjetaCreditoViewImpl extends Composite implements CuadraturaTarjetaCreditoView {

    private static final Binder binder = GWT.create(Binder.class);

    final QuadratureServiceAsync quadratureService = GWT.create(QuadratureService.class);
    private static final DateTimeFormat dtf = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_LONG);
    private static final DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static final DateTimeFormat dfStr = DateTimeFormat.getFormat("yyyy-MM-dd");
    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    NumberFormat fmt = NumberFormat.getDecimalFormat();

    interface Binder extends UiBinder<Widget, CuadraturaTarjetaCreditoViewImpl> {
    }

    @UiField
    ListBox sucursalSeleccionada;
    @UiField(provided = true)
    DateBox dateOfBusinessDateBox;
    @UiField
    Label lblError;
    @UiField
    Button filterButton;
    @UiField
    Label lblVersionPOS;
    @UiField
    Label lblTarjetaBancariaVisa;
    @UiField
    Label lblTarjetaBancariaDiners;
    @UiField
    Label lblDonacionesPLCUA;
    @UiField
    Label totalPLCUA1;
    @UiField
    Label lblTotalPLCUA2;
    @UiField
    Label lblTotalPSCRE2;
    @UiField
    Label lblTotalPSCRE1;
    @UiField
    Label lblTotalVentasTarjetaCreditoPSCRE;
    @UiField
    Label lblTotalVentasInternteCreditoPSCRE;
    @UiField
    Label lblTotalVentasAnulacionesNCAPSCRE;

    @UiField
    Label lblRecaudacionesPCRE;
    @UiField
    Label lblAnulacionRecaudacionesPSCRE;
    @UiField
    Label lblTotalVentasCreditoPLC;
    @UiField
    Label lblTotalVentasInternetCreditoPLC;
    @UiField
    Label lblTotalAnulacionesNCAPLC;
    @UiField
    Label lblTotalAnulacionesNCRPLC;
    @UiField
    Label lblTotalAnulacionesInternetNCAPLC;
    @UiField
    Label lblTotalAnulacionesInternetNCRPLC;
    @UiField
    Label lblTotalRecaudacionesPLC;
    @UiField
    Label lblTotalAnulacionesRecaudacionesPLC;
    @UiField
    Label lblTotalPLC1;
    @UiField
    Label lblPagoRemotoCreditoPLCUA;
    @UiField
    Label lblTotalPSCRE3;
    @UiField
    Label lblTotalPLC2;
    @UiField
    Label lblDirerenciaPLCAPSCRE;
    @UiField
    Label lblDiferenciaPSCREPLC;
    @UiField
    Label lblTotalVentasPagoRemotoCrditoPSCRE;
    @UiField
    Label lblTotalAnulacionPagoRemotoCreditoPSCRE;
    @UiField
    Label lblTotalVentasPagoRemotoCreditoPLC;
    @UiField
    Label lblTotalAnulacionPagoRemotoCreditoPLC;
    @UiField
    Label lblTotalPagoRemotoPLCUA;
    @UiField
    Label lblTotalPagoRemotoPSCRE;
    @UiField
    Label lblDiferenciaPagoRemotoPLCUAPSCRE;
    @UiField
    Label lblTotalPagoRemotoPSCRE2;
    @UiField
    Label lblTotalPagoRemotoPLC;
    @UiField
    Label lblDiferenciaPagoRemotoPSCREPLC;
    @UiField
    Label lblTotalPagoRemotoPLC1;
    @UiField
    Label lblDonacionesPSCRE;

    public CuadraturaTarjetaCreditoViewImpl() {

	dateOfBusinessDateBox = new DateBox();
	dateOfBusinessDateBox.setValue(new Date());
	dateOfBusinessDateBox.setFormat(new DateBox.DefaultFormat(dtf));

	initWidget(binder.createAndBindUi(this));

	lblError.setVisible(false);
	traerUnidadesDeNegocios(true);
	setCerosEnLabels();
    }

    @UiHandler("filterButton")
    public void onClickCSV(ClickEvent e) {
	lblError.setVisible(false);
	traerCuadraturaTarjetaCredito();
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
	    String url = GWT.getModuleBaseURL() + "ExcelTarjetaCredito?businessDate=" + fechaNegocio + "&sucursal="
		    + sucursal;
	    Window.open(url, "", "");
	}
    }

    private void traerCuadraturaTarjetaCredito() {
	Date fechaNegocio = dateOfBusinessDateBox.getValue();
	long sucursal = Long.valueOf(sucursalSeleccionada.getValue(sucursalSeleccionada.getSelectedIndex()));
	String fechaNegocioStr = dfStr.format(fechaNegocio);
	if (sucursal == -1) {
	    lblError.setVisible(true);
	    lblError.setText("Debe seleccionar sucursal");
	} else {
	    try {

		quadratureService.getCuadraturaTarjetaCredito(fechaNegocioStr, sucursal,
			new AsyncCallback<CuadraturaTarjetaCreditoDTO>() {
			    @Override
			    public void onFailure(Throwable ex) {

			    }

			    @Override
			    public void onSuccess(CuadraturaTarjetaCreditoDTO result) {
				if (result != null) {

				    lblTarjetaBancariaVisa.setText(fmt.format(result.getTarjetaBancariaVisa()));

				    lblTarjetaBancariaDiners.setText(fmt.format(result.getTarjetaBancariaDiners()));

				    lblDonacionesPLCUA.setText(fmt.format(result.getDonaciones()));

				    totalPLCUA1.setText(fmt.format(result.getTotalPLCUA()));

				    lblTotalPLCUA2.setText(fmt.format(result.getTotalPLCUA()));

				    lblTotalPSCRE2.setText(fmt.format(result.getTotalPSCRE()));

				    lblTotalPSCRE1.setText(fmt.format(result.getTotalPSCRE()));

				    lblTotalVentasTarjetaCreditoPSCRE.setText(fmt.format(result
					    .getTotalVentasTarjetaCreditoPSCRE()));

				    lblTotalVentasInternteCreditoPSCRE.setText(fmt.format(result
					    .getTotalVentasInternetCreditoPSCRE()));

				    lblTotalVentasAnulacionesNCAPSCRE.setText(fmt.format(result
					    .getTotalVentasAnulacionesPSCRE()));

				    lblRecaudacionesPCRE.setText(fmt.format(result.getRecaudacionesPSCRE()));

				    lblAnulacionRecaudacionesPSCRE.setText(fmt.format(result
					    .getAnulacionRecaudacionesPSCRE()));

				    lblTotalVentasCreditoPLC.setText(fmt.format(result
					    .getTotalVentasTarjetaCreditoPLC()));

				    lblTotalVentasInternetCreditoPLC.setText(fmt.format(result
					    .getTotalVentasInternetCreditoPLC()));

				    lblTotalAnulacionesNCAPLC.setText(fmt.format(result.getTotalAnulacionesNCAPLC()));

				    lblTotalAnulacionesNCRPLC.setText(fmt.format(0));

				    lblTotalAnulacionesInternetNCAPLC.setText(fmt.format(0));

				    lblTotalAnulacionesInternetNCRPLC.setText(fmt.format(0));

				    lblTotalRecaudacionesPLC.setText(fmt.format(result.getTotalRecaudacionesPLC()));

				    lblTotalAnulacionesRecaudacionesPLC.setText(fmt.format(result
					    .getTotalAnulacionRecaudacionesPLC()));

				    lblTotalPLC1.setText(fmt.format(result.getTotalPLC()));

				    lblDonacionesPSCRE.setText(fmt.format(result.getDonaciones()));

				    lblPagoRemotoCreditoPLCUA.setText(fmt.format(result.getPagoRemotoCreditoPLCUA()));

				    lblTotalPSCRE3.setText(fmt.format(result.getTotalPSCRE()));

				    lblTotalPLC2.setText(fmt.format(result.getTotalPLC()));

				    lblDirerenciaPLCAPSCRE.setText(fmt.format(result.getDiferenciaPLCUAPSCRE()));

				    lblDiferenciaPSCREPLC.setText(fmt.format(result.getDiferenciaPSCREPLC()));

				    lblTotalVentasPagoRemotoCrditoPSCRE.setText(fmt.format(result
					    .getPagoRemotoCreditoPSCRE()));

				    lblTotalAnulacionPagoRemotoCreditoPSCRE.setText(fmt.format(result
					    .getTotalAnulacionesPagoRemoto()));

				    lblTotalVentasPagoRemotoCreditoPLC.setText(fmt.format(result
					    .getTotalVentasPagoRemotoCreditoPLC()));

				    lblTotalAnulacionPagoRemotoCreditoPLC.setText(fmt.format(result
					    .getTotalAnulacionesPagoRemotoCreditoPLC()));

				    lblTotalPagoRemotoPLCUA.setText(fmt.format(result.getPagoRemotoCreditoPLCUA()));

				    lblTotalPagoRemotoPSCRE.setText(fmt.format(result.getTotalPagoRemotoPSCRE()));

				    lblDiferenciaPagoRemotoPLCUAPSCRE.setText(fmt.format(result
					    .getDiferenciaPagoRemotoPLCUAPSCRE()));
				    lblTotalPagoRemotoPSCRE2.setText(fmt.format(result.getTotalPagoRemotoPSCRE()));

				    lblTotalPagoRemotoPLC.setText(fmt.format(result.getTotalPagoRemotoPLC()));

				    lblDiferenciaPagoRemotoPSCREPLC.setText(fmt.format(result
					    .getDiferenciaPagoRemotoPSCREPLC()));

				    lblTotalPagoRemotoPLC1.setText(fmt.format(result.getTotalPagoRemotoPLC()));
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

    private void setCerosEnLabels() {

	lblTarjetaBancariaVisa.setText("0");

	lblTarjetaBancariaDiners.setText("0");

	lblDonacionesPLCUA.setText("0");

	totalPLCUA1.setText("0");

	lblTotalPLCUA2.setText("0");

	lblTotalPSCRE2.setText("0");

	lblTotalPSCRE1.setText("0");

	lblTotalVentasTarjetaCreditoPSCRE.setText("0");

	lblTotalVentasInternteCreditoPSCRE.setText("0");

	lblTotalVentasAnulacionesNCAPSCRE.setText("0");

	lblRecaudacionesPCRE.setText("0");

	lblAnulacionRecaudacionesPSCRE.setText("0");

	lblTotalVentasCreditoPLC.setText("0");

	lblTotalVentasInternetCreditoPLC.setText("0");

	lblTotalAnulacionesNCAPLC.setText("0");

	lblTotalAnulacionesNCRPLC.setText(fmt.format(0));

	lblTotalAnulacionesInternetNCAPLC.setText(fmt.format(0));

	lblTotalAnulacionesInternetNCRPLC.setText(fmt.format(0));

	lblTotalRecaudacionesPLC.setText("0");

	lblTotalAnulacionesRecaudacionesPLC.setText("0");

	lblTotalPLC1.setText("0");

	lblDonacionesPSCRE.setText("0");

	lblPagoRemotoCreditoPLCUA.setText("0");

	lblTotalPSCRE3.setText("0");

	lblTotalPLC2.setText("0");

	lblDirerenciaPLCAPSCRE.setText("0");

	lblDiferenciaPSCREPLC.setText("0");

	lblTotalVentasPagoRemotoCrditoPSCRE.setText("0");

	lblTotalAnulacionPagoRemotoCreditoPSCRE.setText("0");

	lblTotalVentasPagoRemotoCreditoPLC.setText("0");

	lblTotalAnulacionPagoRemotoCreditoPLC.setText("0");

	lblTotalPagoRemotoPSCRE.setText("0");

	lblDiferenciaPagoRemotoPLCUAPSCRE.setText("0");
	lblTotalPagoRemotoPSCRE2.setText("0");

	lblTotalPagoRemotoPLC.setText("0");

	lblDiferenciaPagoRemotoPSCREPLC.setText("0");

	lblTotalPagoRemotoPLC1.setText("0");
	lblVersionPOS.setText("0");

    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }
}
