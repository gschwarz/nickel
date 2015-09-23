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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO;

public class CuadraturaVtaCMRViewImpl extends Composite implements CuadraturaVtaCMRView {
    final QuadratureServiceAsync quadratureService = GWT.create(QuadratureService.class);
    private static final Binder binder = GWT.create(Binder.class);
    private static final DateTimeFormat dtf = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_LONG);
    private static final DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static final DateTimeFormat dfStr = DateTimeFormat.getFormat("yyyy-MM-dd");
    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    NumberFormat fmt = NumberFormat.getDecimalFormat();
    @UiField
    Label lblCuotasNormales;
    @UiField
    Label lblCuotasDiferidas;
    @UiField
    Label lbl3CC;
    @UiField
    Label lblDonacion;
    @UiField
    Label lblNCRTF;
    @UiField
    Label lblTotalFinalPlaCuad;
    @UiField
    Label lblGranTotalVenta;
    @UiField
    Label lblGranTotalRecaudacion;
    @UiField
    Label lblGranTotalDevolucionCMRNCA;
    @UiField
    Label lblGranTotalDevolucionCMRNCR;
    @UiField
    Label lblGrantotalAnulacionGiftCard;
    @UiField
    Label lblTotalFinalARQTF;
    @UiField
    Label lblTrx200;
    @UiField
    Label lblTRX400;
    @UiField
    Label lblTotalFinalVtaCMR;
    @UiField
    ListBox sucursalSeleccionada;
    @UiField(provided = true)
    DateBox dateOfBusinessDateBox;
    @UiField
    Label lblError;
    @UiField
    Button filterButton;
    @UiField
    Label lblTotalPlaCuad;
    @UiField
    Label lblTotalVtaCMR;
    @UiField
    Label lblDiferenciaPlaCuadVtaCMR;
    @UiField
    Label lblTotalPlaCuad2;
    @UiField
    Label lblTotalFinalARQTF2;
    @UiField
    Label lblTotalCRM2;
    @UiField
    Label lblTotalFinalARQTF3;
    @UiField
    Label lblDiferenciaPlaCuadrARQTF;
    @UiField
    Label lblDiferenciaVtaCMRARQTF;
    @UiField
    Label lblPldtf;
    @UiField
    Label lblArqTFNCR;
    @UiField
    Label lblDiferenciaPldtfNCRConArqTFNCR;
    @UiField
    Label lblPldtf2;
    @UiField
    Label lblPlacuadNCR;
    @UiField
    Label lblDiferenciaPlaCuadNCRConArqTFNCR;
    @UiField
    Label lblLdta;
    @UiField
    Label lblLdtaDonacion;
    @UiField
    Label lblArqTFDonacion;
    @UiField
    Label lblDiferenciaLdtaConArqTFDonacion;
    @UiField
    Label lblVersionPOS;
    @UiField
    Label lblTotalFinalRSAT;
    @UiField
    Label lblDiferenciaRSATCRCMR;
    @UiField
    Label lblTotalFinalSAT;
    @UiField
    Label lblDiferenciaSATCRCMR;
    @UiField
    Label lblTotalCRCMR;
    @UiField
    Label lblTotalCRCMR2;

    interface Binder extends UiBinder<Widget, CuadraturaVtaCMRViewImpl> {
    }

    public CuadraturaVtaCMRViewImpl() {

	dateOfBusinessDateBox = new DateBox();
	dateOfBusinessDateBox.setValue(new Date());
	dateOfBusinessDateBox.setFormat(new DateBox.DefaultFormat(dtf));

	initWidget(binder.createAndBindUi(this));

	lblError.setVisible(false);
	traerUnidadesDeNegocios(true);
	setCeroEnLabels();

    }

    @UiHandler("filterButton")
    public void onClickCSV(ClickEvent e) {
	lblError.setVisible(false);
	traerCuadraturaVtaCMR();
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
	    String url = GWT.getModuleBaseURL() + "ExcelVentasCMR?businessDate=" + fechaNegocio + "&sucursal="
		    + sucursal;
	    Window.open(url, "", "");
	}
    }

    public void traerCuadraturaVtaCMR() {

	Date fechaNegocio = dateOfBusinessDateBox.getValue();

	String fechaNegocioStr = dfStr.format(fechaNegocio);

	long sucursal = Long.valueOf(sucursalSeleccionada.getValue(sucursalSeleccionada.getSelectedIndex()));

	if (sucursal == -1) {
	    lblError.setVisible(true);
	    lblError.setText("Debe seleccionar sucursal");
	} else {

	    try {

		quadratureService.getCuadraturaVtaCMR(fechaNegocioStr, sucursal,
			new AsyncCallback<CuadraturaVtaCMRDTO>() {
			    @Override
			    public void onFailure(Throwable ex) {
				GWT.log(ex.toString());
			    }

			    @Override
			    public void onSuccess(CuadraturaVtaCMRDTO result) {

				if (result != null) {
				    lblCuotasNormales.setText(String.valueOf(fmt.format(result.getCuotasNormales())));
				    lblCuotasDiferidas.setText(String.valueOf(fmt.format(result.getCuotasDiferidas())));
				    lbl3CC.setText(String.valueOf(fmt.format(result.getTresCC())));
				    lblDonacion.setText(String.valueOf(fmt.format(result.getDonacionCMR())));
				    lblNCRTF.setText(String.valueOf(fmt.format(result.getNcrTFTotal())));
				    lblTotalFinalPlaCuad.setText(String.valueOf(fmt.format(result
					    .getTotalFinalPlaCuad())));
				    lblGranTotalVenta.setText(String.valueOf(fmt.format(result.getGranTotalVentas())));
				    lblGranTotalRecaudacion.setText(String.valueOf(fmt.format(result
					    .getGranTotalRecaudaciones())));
				    lblGranTotalDevolucionCMRNCA.setText(String.valueOf(fmt.format(result
					    .getGranTotalDevolucionesCMRNCA())));
				    lblGranTotalDevolucionCMRNCR.setText(String.valueOf(fmt.format(result
					    .getGranTotalDevolucionesCMRNCR())));
				    lblGrantotalAnulacionGiftCard.setText(String.valueOf(fmt.format(result
					    .getGranTotalAnulacionGiftcard())));
				    lblTotalFinalARQTF.setText(String.valueOf(fmt.format(result.getTotalFinalARQTF())));
				    lblTrx200.setText(String.valueOf(fmt.format(result.getTransacciones200())));
				    lblTRX400.setText(String.valueOf(fmt.format(result.getTransacciones400())));
				    lblTotalFinalVtaCMR.setText(String.valueOf(fmt.format(result.getTotalFinalTRX())));
				    lblTotalPlaCuad.setText(String.valueOf(fmt.format(result.getTotalFinalPlaCuad())));
				    lblTotalVtaCMR.setText(String.valueOf(fmt.format(result.getTotalFinalTRX())));
				    lblDiferenciaPlaCuadVtaCMR.setText(String.valueOf(fmt.format(result
					    .getDiferenciaPlaCuadConVtaCMR())));
				    lblTotalPlaCuad2.setText(String.valueOf(fmt.format(result.getTotalFinalPlaCuad())));
				    lblTotalFinalARQTF2.setText(String.valueOf(fmt.format(result.getTotalFinalARQTF())));
				    lblDiferenciaPlaCuadrARQTF.setText(String.valueOf(fmt.format(result
					    .getDiferenciaPlaCuadARQTF())));
				    lblTotalCRM2.setText(String.valueOf(fmt.format(result.getTotalFinalTRX())));
				    lblTotalFinalARQTF3.setText(String.valueOf(fmt.format(result.getTotalFinalARQTF())));
				    lblDiferenciaVtaCMRARQTF.setText(String.valueOf(fmt.format(result
					    .getDiferenciaVtaCRMConARQTF())));
				    lblPldtf.setText(String.valueOf(fmt.format(result.getPldtf())));
				    lblArqTFNCR.setText(String.valueOf(fmt.format(result.getArqTFNCR())));
				    lblDiferenciaPldtfNCRConArqTFNCR.setText(String.valueOf(fmt.format(result
					    .getDiferenciaPldtfNCRConArqTFNCR())));
				    lblPldtf2.setText(String.valueOf(fmt.format(result.getPldtf())));
				    lblPlacuadNCR.setText(String.valueOf(fmt.format(result.getPlacuadNCR())));
				    lblDiferenciaPlaCuadNCRConArqTFNCR.setText(String.valueOf(fmt.format(result
					    .getDiferenciaPlaCuadNCRConArqTFNCR())));
				    lblLdta.setText(String.valueOf(fmt.format(result.getLdta())));
				    lblLdtaDonacion.setText(String.valueOf(fmt.format(result.getLdtaDonacion())));
				    lblArqTFDonacion.setText(String.valueOf(fmt.format(result.getArqTFDonacion())));
				    lblDiferenciaLdtaConArqTFDonacion.setText(String.valueOf(fmt.format(result
					    .getDiferenciaLdtaConArqTFDonacion())));
				    lblVersionPOS.setText(result.getVersionPOS());

				    lblTotalFinalRSAT.setText(fmt.format(result.getTotalFinalRSAT()));
				    lblTotalFinalSAT.setText(fmt.format(result.getTotalFinalSAT()));
				    lblTotalCRCMR.setText(fmt.format(result.getTotalFinalTRX()));
				    lblTotalCRCMR2.setText(fmt.format(result.getTotalFinalTRX()));
				    lblDiferenciaSATCRCMR.setText(fmt.format(result.getDiferenciaSATCRCMR()));
				    lblDiferenciaRSATCRCMR.setText(fmt.format(result.getDiferenciaRSATCRCMR()));
				} else {

				    lblError.setVisible(true);
				    lblError.setText("Resultados no encontrados");
				    setCeroEnLabels();
				}
			    }

			});
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	}
    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

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

    private void setCeroEnLabels() {
	lblCuotasNormales.setText("0");
	lblCuotasDiferidas.setText("0");
	lbl3CC.setText("0");
	lblDonacion.setText("0");
	lblNCRTF.setText("0");
	lblTotalFinalPlaCuad.setText("0");
	lblGranTotalVenta.setText("0");
	lblGranTotalRecaudacion.setText("0");
	lblGranTotalDevolucionCMRNCA.setText("0");
	lblGranTotalDevolucionCMRNCR.setText("0");
	lblGrantotalAnulacionGiftCard.setText("0");
	lblTotalFinalARQTF.setText("0");
	lblTrx200.setText("0");
	lblTRX400.setText("0");
	lblTotalFinalVtaCMR.setText("0");
	lblTotalPlaCuad.setText("0");
	lblTotalVtaCMR.setText("0");
	lblDiferenciaPlaCuadVtaCMR.setText("0");
	lblTotalPlaCuad2.setText("0");
	lblTotalFinalARQTF2.setText("0");
	lblDiferenciaPlaCuadrARQTF.setText("0");
	lblTotalCRM2.setText("0");
	lblTotalFinalARQTF3.setText("0");
	lblDiferenciaVtaCMRARQTF.setText("0");
	lblPldtf.setText("0");
	lblArqTFNCR.setText("0");
	lblDiferenciaPldtfNCRConArqTFNCR.setText("0");
	lblPldtf2.setText("0");
	lblPlacuadNCR.setText("0");
	lblDiferenciaPlaCuadNCRConArqTFNCR.setText("0");
	lblLdta.setText("0");
	lblLdtaDonacion.setText("0");
	lblArqTFDonacion.setText("0");
	lblDiferenciaLdtaConArqTFDonacion.setText("0");
    }
}
