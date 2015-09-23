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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO;

public class CuadraturaPagosCMRViewImpl extends Composite implements CuadraturaPagosCMRView {

    final QuadratureServiceAsync quadratureService = GWT.create(QuadratureService.class);
    private static final DateTimeFormat dtf = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_LONG);
    private static final DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static final DateTimeFormat dfStr = DateTimeFormat.getFormat("yyyy-MM-dd");
    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    NumberFormat fmt = NumberFormat.getDecimalFormat();

    private static final Binder binder = GWT.create(Binder.class);

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
    Label lblPagoNormal;
    @UiField
    Label lblPagoRepactado;
    @UiField
    Label lblPagoAnulado;
    @UiField
    Label lblTotalPagos;
    @UiField
    Label lblTotalAbonos;
    @UiField
    Label lblTotalAbonoNormal;
    @UiField
    Label lblTrx402;
    @UiField
    Label lblTotalCRCMR;
    @UiField
    Label lblTrx217;
    @UiField
    Label lblTotalAbonosSCTFA;
    @UiField
    Label lblTotalPagosSAT;
    @UiField
    Label lblTotalAnulacionesSAT;
    @UiField
    Label lblTotalFinalSAT;
    @UiField
    Label lblTotalPagosRSAT;
    @UiField
    Label lblTotalAnulacionesRSAT;
    @UiField
    Label lblTotalFinalRSAT;

    interface Binder extends UiBinder<Widget, CuadraturaPagosCMRViewImpl> {
    }

    public CuadraturaPagosCMRViewImpl() {

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
	traerCuadraturaPagosCMR();
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
	    String url = GWT.getModuleBaseURL() + "ExcelPagosCMR?businessDate=" + fechaNegocio + "&sucursal="
		    + sucursal;
	    Window.open(url, "", "");
	}
    }

    private void traerCuadraturaPagosCMR() {
	Date fechaNegocio = dateOfBusinessDateBox.getValue();
	long sucursal = Long.valueOf(sucursalSeleccionada.getValue(sucursalSeleccionada.getSelectedIndex()));
	String fechaNegocioStr = dfStr.format(fechaNegocio);
	if (sucursal == -1) {
	    lblError.setVisible(true);
	    lblError.setText("Debe seleccionar sucursal");
	} else {
	    try {

		quadratureService.getCuadraturaPagosCMR(fechaNegocioStr, sucursal,
			new AsyncCallback<CuadraturaPagosCMRDTO>() {
			    @Override
			    public void onFailure(Throwable ex) {

			    }

			    @Override
			    public void onSuccess(CuadraturaPagosCMRDTO result) {
				if (result != null) {
				    lblPagoNormal.setText(fmt.format(result.getPagoNormal()));
				    lblPagoRepactado.setText(fmt.format(result.getPagoRepactado()));
				    lblPagoAnulado.setText(fmt.format(result.getPagoAnulado()));
				    lblTotalPagos.setText(fmt.format(result.getTotalPagos()));
				    lblTotalAbonos.setText(fmt.format(result.getTotalAbonos()));
				    lblTotalAbonoNormal.setText(fmt.format(result.getTotalAnulacionAbonoNormal()));
				    lblTrx402.setText(fmt.format(result.getTrx402()));
				    lblTrx217.setText(fmt.format(result.getTrx217()));
				    lblTotalCRCMR.setText(fmt.format(result.getTotalCRCMR()));
				    lblTotalAbonosSCTFA.setText(fmt.format(result.getTotalPagosSctfa()));
				    lblVersionPOS.setText(result.getVersionPOS());
				    lblTotalPagosSAT.setText(fmt.format(result.getTotalPagosSAT()));
				    lblTotalPagosRSAT.setText(fmt.format(result.getTotalPagosRSAT()));
				    lblTotalFinalSAT.setText(fmt.format(result.getTotalFinalPagosSAT()));
				    lblTotalFinalRSAT.setText(fmt.format(result.getTotalFinalPagosRSAT()));
				    lblTotalAnulacionesRSAT.setText(fmt.format(result.getTotalAnulacionesRSAT()));
				    lblTotalAnulacionesSAT.setText(fmt.format(result.getTotalAnulacionesSAT()));
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

    protected void setCerosEnLabels() {
	lblPagoNormal.setText("0");
	lblPagoRepactado.setText("0");
	lblPagoAnulado.setText("0");
	lblTotalPagos.setText("0");
	lblTotalAbonos.setText("0");
	lblTotalAbonoNormal.setText("0");
	lblTrx402.setText("0");
	lblTrx217.setText("0");
	lblTotalCRCMR.setText("0");
	lblTotalAbonosSCTFA.setText("0");

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

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }
}
