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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO;

public class CuadraturaNotaCreditoViewImpl extends Composite implements CuadraturaNotaCreditoView {

    private static final Binder binder = GWT.create(Binder.class);

    final QuadratureServiceAsync quadratureService = GWT.create(QuadratureService.class);
    private static final DateTimeFormat dtf = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_LONG);
    private static final DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static final DateTimeFormat dfStr = DateTimeFormat.getFormat("yyyy-MM-dd");
    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    NumberFormat fmt = NumberFormat.getDecimalFormat();

    interface Binder extends UiBinder<Widget, CuadraturaNotaCreditoViewImpl> {
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
    Label lblNcrtvplcua;
    @UiField
    Label lblAnulacionesNCRPSCRE;
    @UiField
    Label lblAnulacionesNCRPLC;
    @UiField
    Label lblTotalNCRTVPLCUA;
    @UiField
    Label lblTotalAnulacionesNCRPSCRE;
    @UiField
    Label lblTotalAnulacionesNCRPSCRE2;
    @UiField
    Label lblTotalAnulacionPLC;
    @UiField
    Label lblDirefenciaPLCUAPSCRE;
    @UiField
    Label lblDiferenciaPSCREPLC;

    public CuadraturaNotaCreditoViewImpl() {
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
	traerCuadraturaNotaDeCredito();
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
	    String url = GWT.getModuleBaseURL() + "ExcelNotaCredito?businessDate=" + fechaNegocio + "&sucursal="
		    + sucursal;
	    Window.open(url, "", "");
	}
    }

    private void traerCuadraturaNotaDeCredito() {
	Date fechaNegocio = dateOfBusinessDateBox.getValue();
	long sucursal = Long.valueOf(sucursalSeleccionada.getValue(sucursalSeleccionada.getSelectedIndex()));
	String fechaNegocioStr = dfStr.format(fechaNegocio);
	if (sucursal == -1) {
	    lblError.setVisible(true);
	    lblError.setText("Debe seleccionar sucursal");
	} else {
	    try {

		quadratureService.getCuadraturaNotaCredito(fechaNegocioStr, sucursal,
			new AsyncCallback<CuadraturaNotaCreditoDTO>() {
			    @Override
			    public void onFailure(Throwable ex) {

			    }

			    @Override
			    public void onSuccess(CuadraturaNotaCreditoDTO result) {
				if (result != null) {

				    lblVersionPOS.setText(result.getVersionPOS());

				    lblNcrtvplcua.setText(fmt.format(result.getNcrTvPLCUa()));

				    lblAnulacionesNCRPSCRE.setText(fmt.format(result.getTotalAnulacionesNCRPSCRE()));

				    lblAnulacionesNCRPLC.setText(fmt.format(result.getTotalAnulacionesNCRPLC()));

				    lblTotalNCRTVPLCUA.setText(fmt.format(result.getNcrTvPLCUa()));

				    lblTotalAnulacionesNCRPSCRE.setText(fmt.format(result.getTotalAnulacionesNCRPSCRE()));

				    lblTotalAnulacionesNCRPSCRE2.setText(fmt.format(result
					    .getTotalAnulacionesNCRPSCRE()));

				    lblTotalAnulacionPLC.setText(fmt.format(result.getTotalAnulacionesNCRPLC()));

				    lblDirefenciaPLCUAPSCRE.setText(fmt.format(result.getDiferenciaPLACUAPSCRE()));

				    lblDiferenciaPSCREPLC.setText(fmt.format(result.getDiferenciaPSCREPLC()));

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

	lblVersionPOS.setText("0");

	lblNcrtvplcua.setText("0");

	lblAnulacionesNCRPSCRE.setText("0");

	lblAnulacionesNCRPLC.setText("0");

	lblTotalNCRTVPLCUA.setText("0");

	lblTotalAnulacionesNCRPSCRE.setText("0");

	lblTotalAnulacionesNCRPSCRE2.setText("0");

	lblTotalAnulacionPLC.setText("0");

	lblDirefenciaPLCUAPSCRE.setText("0");

	lblDiferenciaPSCREPLC.setText("0");
	lblVersionPOS.setText("0");

    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }

}
