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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO;

public class CuadraturaTarjetaDebitoViewImpl extends Composite implements CuadraturaTarjetaDebitoView {

    private static final Binder binder = GWT.create(Binder.class);

    final QuadratureServiceAsync quadratureService = GWT.create(QuadratureService.class);
    private static final DateTimeFormat dtf = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_LONG);
    private static final DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static final DateTimeFormat dfStr = DateTimeFormat.getFormat("yyyy-MM-dd");
    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    NumberFormat fmt = NumberFormat.getDecimalFormat();

    interface Binder extends UiBinder<Widget, CuadraturaTarjetaDebitoViewImpl> {
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
    Label lblTarjetaDebitoPLCUA;
    @UiField
    Label lblTotalVentasTarjetaDebitoPSDEB;
    @UiField
    Label lblTotalVentasInternetDebitoPSDEB;
    @UiField
    Label lblTotalRecaudacionesPSDEB;
    @UiField
    Label lblTotalPSDEB;
    @UiField
    Label lblTotalVentasTarjetaDebitoPLD;
    @UiField
    Label lblTotalVentasInternetTarjetaDebitoPLD;
    @UiField
    Label lblTotalPLD;
    @UiField
    Label lblTotalPLCUA;
    @UiField
    Label lblTotalPSDEB2;
    @UiField
    Label lblTotalPSDEB3;
    @UiField
    Label lblTotalPLD2;
    @UiField
    Label lblPagoRemotoPLCUA;
    @UiField
    Label lblTotalVentasPagoRemotoPSDEB;
    @UiField
    Label lblTotalAnulacionPagoRemotoPSDEB;
    @UiField
    Label totalPagoRemotoPSDEB;
    @UiField
    Label totlaVentasPagoRemotoPLD;
    @UiField
    Label lblTotalAnulacionPagoRemotoPLD;
    @UiField
    Label totalPagoRemotoPLD;
    @UiField
    Label lblTotalPagoRemotoPLCUA2;
    @UiField
    Label lblTotalPagoRemotoPSDEB;
    @UiField
    Label lblDiferenciaPagoRemotoPLCUAPSDEB;
    @UiField
    Label lblTotalPagoRemotoPDEB2;
    @UiField
    Label lblTotalPagoRemotoPLD;
    @UiField
    Label lblDiferenciaPagoRemotoPSDEBPLD;
    @UiField
    Label lblDiferenciaPLCUAPSDEB;
    @UiField
    Label lblDiferenciaPSDEBPLD;

    public CuadraturaTarjetaDebitoViewImpl() {

	dateOfBusinessDateBox = new DateBox();
	dateOfBusinessDateBox.setValue(new Date());
	dateOfBusinessDateBox.setFormat(new DateBox.DefaultFormat(dtf));

	initWidget(binder.createAndBindUi(this));

	lblError.setVisible(false);
	traerUnidadesDeNegocios(true);
	setCerosEnLabels();
    }

    private void setCerosEnLabels() {
	lblTarjetaDebitoPLCUA.setText("0");

	lblTotalVentasTarjetaDebitoPSDEB.setText("0");

	lblTotalVentasInternetDebitoPSDEB.setText("0");

	lblTotalRecaudacionesPSDEB.setText(fmt.format(0));

	lblTotalPSDEB.setText("0");

	lblTotalVentasTarjetaDebitoPLD.setText("0");
	lblTotalVentasInternetTarjetaDebitoPLD.setText("0");
	lblTotalPLD.setText("0");
	lblTotalPLCUA.setText("0");
	lblTotalPSDEB2.setText("0");
	lblTotalPSDEB3.setText("0");
	lblTotalPLD2.setText("0");
	lblPagoRemotoPLCUA.setText("0");
	lblTotalVentasPagoRemotoPSDEB.setText("0");
	lblTotalAnulacionPagoRemotoPSDEB.setText("0");
	totalPagoRemotoPSDEB.setText("0");
	totlaVentasPagoRemotoPLD.setText("0");
	lblTotalAnulacionPagoRemotoPLD.setText("0");
	totalPagoRemotoPLD.setText("0");
	lblTotalPagoRemotoPLCUA2.setText("0");
	lblTotalPagoRemotoPSDEB.setText("0");
	lblDiferenciaPagoRemotoPLCUAPSDEB.setText("0");
	lblTotalPagoRemotoPDEB2.setText("0");
	lblTotalPagoRemotoPLD.setText("0");
	lblDiferenciaPagoRemotoPSDEBPLD.setText("0");
	lblDiferenciaPLCUAPSDEB.setText("0");
	lblDiferenciaPSDEBPLD.setText("0");
	lblVersionPOS.setText("0");

    }

    @UiHandler("filterButton")
    public void onClickCSV(ClickEvent e) {
	lblError.setVisible(false);
	traerCuadraturaTarjetaDebito();
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
	    String url = GWT.getModuleBaseURL() + "ExcelTarjetaDebito?businessDate=" + fechaNegocio + "&sucursal="
		    + sucursal;
	    Window.open(url, "", "");
	}
    }

    private void traerCuadraturaTarjetaDebito() {
	Date fechaNegocio = dateOfBusinessDateBox.getValue();
	long sucursal = Long.valueOf(sucursalSeleccionada.getValue(sucursalSeleccionada.getSelectedIndex()));
	String fechaNegocioStr = dfStr.format(fechaNegocio);
	if (sucursal == -1) {
	    lblError.setVisible(true);
	    lblError.setText("Debe seleccionar sucursal");
	} else {
	    try {

		quadratureService.getCuadraturaTarjetaDebito(fechaNegocioStr, sucursal,
			new AsyncCallback<CuadraturaTarjetaDebitoDTO>() {
			    @Override
			    public void onFailure(Throwable ex) {

			    }

			    @Override
			    public void onSuccess(CuadraturaTarjetaDebitoDTO result) {
				if (result != null) {

				    lblTarjetaDebitoPLCUA.setText(fmt.format(result.getTarjetaDebitoPLCUA()));

				    lblTotalVentasTarjetaDebitoPSDEB.setText(fmt.format(result
					    .getTotalVentasTarjetaDebitoPSDEB()));

				    lblTotalVentasInternetDebitoPSDEB.setText(fmt.format(result
					    .getTotalVentasInternetTarjetaDebitoPSDEB()));

				    lblTotalRecaudacionesPSDEB.setText(fmt.format(0));

				    lblTotalPSDEB.setText(fmt.format(result.getTotalTarjetaDebitoPSDEB()));

				    // ///////////////cambiado según obs de QA
				    lblTotalVentasTarjetaDebitoPLD.setText(fmt.format(result
					    .getTotalVentasInternetDebitoPLD()));
				    lblTotalVentasInternetTarjetaDebitoPLD.setText(fmt.format(result
					    .getTotalVentasTarjetaDebitoPLD()));

				    lblTotalPLD.setText(fmt.format(result.getTotalVEntasDEbitoPLD()));
				    lblTotalPLCUA.setText(fmt.format(result.getTarjetaDebitoPLCUA()));
				    lblTotalPSDEB2.setText(fmt.format(result.getTotalTarjetaDebitoPSDEB()));
				    lblTotalPSDEB3.setText(fmt.format(result.getTotalTarjetaDebitoPSDEB()));
				    lblTotalPLD2.setText(fmt.format(result.getTotalVEntasDEbitoPLD()));
				    lblPagoRemotoPLCUA.setText(fmt.format(result.getPagoRemotoDebitoPLCUA()));
				    lblTotalVentasPagoRemotoPSDEB.setText(fmt.format(result
					    .getTotalVentasPagoRemotoDebitoPSDEB()));
				    lblTotalAnulacionPagoRemotoPSDEB.setText(fmt.format(result
					    .getTotalAnulacionesPagoRemotoDebitoPSDEB()));
				    totalPagoRemotoPSDEB.setText(fmt.format(result.getTotalPagoRemotoPSDEB()));
				    totlaVentasPagoRemotoPLD.setText(fmt.format(result
					    .getTotalVentasPagoRemotoDebitoPLD()));
				    lblTotalAnulacionPagoRemotoPLD.setText(fmt.format(result
					    .getTotalAnulacionPagoRemotoDebitoPLD()));
				    totalPagoRemotoPLD.setText(fmt.format(result.getTotalPagoRemotoDebitoPLD()));
				    lblTotalPagoRemotoPLCUA2.setText(fmt.format(result.getPagoRemotoDebitoPLCUA()));
				    lblTotalPagoRemotoPSDEB.setText(fmt.format(result.getTotalPagoRemotoPSDEB()));
				    lblDiferenciaPagoRemotoPLCUAPSDEB.setText(fmt.format(result
					    .getDiferenciaPagoRemotoPLCUAPSDEB()));
				    lblTotalPagoRemotoPDEB2.setText(fmt.format(result.getTotalPagoRemotoPSDEB()));
				    lblTotalPagoRemotoPLD.setText(fmt.format(result.getTotalPagoRemotoDebitoPLD()));
				    lblDiferenciaPagoRemotoPSDEBPLD.setText(fmt.format(result
					    .getDiferenciaPagoRemotoPSDEBPLD()));
				    lblDiferenciaPLCUAPSDEB.setText(fmt.format(result.getDiferenciaPLCUAPSDEB()));
				    lblDiferenciaPSDEBPLD.setText(fmt.format(result.getDiferenciaPSDEBPLD()));
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
     * Mï¿½todo que consulta solo los grupos vigentes.
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

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }

}
