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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaAvanceSuperAvanceDTO;

public class CuadraturaAvanceSuperAvanceViewImpl extends Composite implements CuadraturaAvanceSuperAvanceView {

    private static final Binder binder = GWT.create(Binder.class);

    final QuadratureServiceAsync quadratureService = GWT.create(QuadratureService.class);
    private static final DateTimeFormat dtf = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_LONG);
    private static final DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static final DateTimeFormat dfStr = DateTimeFormat.getFormat("yyyy-MM-dd");
    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    NumberFormat fmt = NumberFormat.getDecimalFormat();

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
    Label lblAvancePLCUA;
    @UiField
    Label lblAvanceAnuladosPLCUA;
    @UiField
    Label lblTotalAvancePLCUA;
    @UiField
    Label lblSuperAvancePLCUA;
    @UiField
    Label lblSuperAvanceAnuladoPLCUA;
    @UiField
    Label lblTotalAvancePLCUA2;
    @UiField
    Label lblTotalAvanceCRCMR2;
    @UiField
    Label lblDiferenciaAvacePLCUACRCMR;
    @UiField
    Label lblTotalSuperAvancePLCUA2;
    @UiField
    Label lblTotalSuperAvanceCRCMR2;
    @UiField
    Label lblDiferenciaSuperAvancePLCUACRCMR;
    @UiField
    Label lblTotalSuperAvance;
    @UiField
    Label lblAvanceSCTFA;
    @UiField
    Label lblAvanceAnuladosSCTFA;
    @UiField
    Label lblTotalAvanceSCTFA;
    @UiField
    Label lblSuperAvanceSCTFA;
    @UiField
    Label lblSuperAvanceAnuladosSCTFA;
    @UiField
    Label lblTotalSuperAvanceSCTFA;
    @UiField
    Label lblTotalAvancePLCUA3;
    @UiField
    Label lblTotalAvanceSCTFA2;
    @UiField
    Label lblDiferenciaAvancePLCUASCTFA;
    @UiField
    Label lblTotalSuperAvancePLCUA3;
    @UiField
    Label lblTotalSuperAvanceSCTFA2;
    @UiField
    Label lblDiferenciaSuperAvancePLCUASCTFA;
    @UiField
    Label lblDiferenciaSuperAvanceCRCMRSCTFA;
    @UiField
    Label lblDiferenciaAvanceCRCMRSCTFA;
    @UiField
    Label lblTotalAvanceCMRCRCMR;
    @UiField
    Label lblTotalAvanceAnuladosCMRCRCMR;
    @UiField
    Label lblTotalSuperAvanceCMRCRCMR;
    @UiField
    Label lblTotalAnulacionesSuperAvanceCRCMR;
    @UiField
    Label lblTotalSuperAvanceCRCMR12;
    @UiField
    Label lblTotalAvanceCRCMR3;
    @UiField
    Label lblTotalAvanceSCTFA3;
    @UiField
    Label lblTotalSuperavanceCRCMR2;
    @UiField
    Label lblTotalSuperAvanceSCTFA3;
    @UiField
    Label lblTotalAvanceCRCMR;
    @UiField
    Label lblTotalSuperAvanceCRCMR;

    @UiField
    Label lblTrx220SAT;
    @UiField
    Label lblTrx403SAT;
    @UiField
    Label lblTotalTrxAvanceSAT;
    @UiField
    Label lblTrx274SAT;
    @UiField
    Label lblTrx473SAT;
    @UiField
    Label lblTotalFinalSuperAvanceSAT;
    @UiField
    Label lblTrx220RSAT;
    @UiField
    Label lblTrx403RSAT;
    @UiField
    Label lblTotalAvanceRSAT;
    @UiField
    Label lblTRX274RSAT;
    @UiField
    Label lblTrx473RSAT;
    @UiField
    Label lblTotalSuperAvanceRSAT;
    @UiField
    Label lblTotalAvanceSAT;
    @UiField
    Label lblTotalAvanceCRCMR4;
    @UiField
    Label lblTotalAvanceRSAT1;
    @UiField
    Label lblTotalAvanceCRCMR5;
    @UiField
    Label lblDiferenciaCRCMRSATAvance;
    @UiField
    Label lblTotalSuperAvanceSAT;
    @UiField
    Label lblTotalSuperAvanceSAT2;
    @UiField
    Label lblDiferenciaCRCMRSATSuperAvance;
    @UiField
    Label lblDiferenciaCRCMRRSATSuperAvance;
    @UiField
    Label lblTotalSuperAvanceCRCMR3;
    @UiField
    Label lblTotalSuperAvanceRSAT2;
    @UiField
    Label lblDiferenciaCRCMRSATAvance2;

    interface Binder extends UiBinder<Widget, CuadraturaAvanceSuperAvanceViewImpl> {
    }

    public CuadraturaAvanceSuperAvanceViewImpl() {

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
	traerCuadraturaAvanceSuperAvance();
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
	    String url = GWT.getModuleBaseURL() + "ExcelAvanceSuperAvance?businessDate=" + fechaNegocio + "&sucursal="
		    + sucursal;
	    Window.open(url, "", "");
	}
    }

    private void traerCuadraturaAvanceSuperAvance() {
	Date fechaNegocio = dateOfBusinessDateBox.getValue();
	long sucursal = Long.valueOf(sucursalSeleccionada.getValue(sucursalSeleccionada.getSelectedIndex()));
	String fechaNegocioStr = dfStr.format(fechaNegocio);
	if (sucursal == -1) {
	    lblError.setVisible(true);
	    lblError.setText("Debe seleccionar sucursal");
	} else {
	    try {

		quadratureService.getCuadraturaAvanceSuperAvance(fechaNegocioStr, sucursal,
			new AsyncCallback<CuadraturaAvanceSuperAvanceDTO>() {
			    @Override
			    public void onFailure(Throwable ex) {

			    }

			    @Override
			    public void onSuccess(CuadraturaAvanceSuperAvanceDTO result) {
				if (result != null) {
				    /**
				     * Avance PLCUA
				     */
				    lblAvancePLCUA.setText(fmt.format(result.getTotalAvanceCMR()));
				    lblAvanceAnuladosPLCUA.setText(fmt.format(result.getTotalAnulacionesAvanceCMR()));
				    lblTotalAvancePLCUA.setText(fmt.format(result.getTotalAvance()));

				    /**
				     * Super Avance PLCUA
				     */
				    lblSuperAvancePLCUA.setText(fmt.format(result.getTotalSuperAvanceCMR()));
				    lblSuperAvanceAnuladoPLCUA.setText(fmt.format(result
					    .getTotalAnulacionesSuperAvanceCMR()));
				    lblTotalSuperAvance.setText(fmt.format(result.getTotalSuperavance()));

				    /**
				     * Totales
				     * 
				     */
				    lblTotalAvancePLCUA2.setText(fmt.format(result.getTotalAvance()));
				    lblTotalAvanceCRCMR2.setText(fmt.format(result.getTotalAvanceCRCMR()));

				    lblDiferenciaAvacePLCUACRCMR.setText(fmt.format(result
					    .getDiferenciaAvancePLCUACRCMR()));

				    lblTotalSuperAvancePLCUA2.setText(fmt.format(result.getTotalSuperavance()));
				    lblTotalSuperAvanceCRCMR2.setText(fmt.format(result.getTotalSuperAvanceCRCMR()));

				    lblDiferenciaSuperAvancePLCUACRCMR.setText(fmt.format(result
					    .getDiferenciaSuperAvancePLCUACRCMR()));

				    /**
				     * Avances SCTFA
				     * 
				     */

				    lblAvanceSCTFA.setText(fmt.format(result.getTotalAvanceCMRARQTF()));
				    lblAvanceAnuladosSCTFA.setText(fmt.format(result
					    .getTotalAnulacionesAvanceCMRARQTF()));
				    lblTotalAvanceSCTFA.setText(fmt.format(result.getTotalAvanceARQTF()));
				    /**
				     * Super Avance SCTFA
				     */

				    lblSuperAvanceSCTFA.setText(fmt.format(result.getTotalSuperAvanceCMRARQTF()));
				    lblSuperAvanceAnuladosSCTFA.setText(fmt.format(result
					    .getTotalAnulacionesSuperAvanceCMRARQTF()));
				    lblTotalSuperAvanceSCTFA.setText(fmt.format(result.getTotalSuperAvanceARQTF()));

				    /**
				     * Totales
				     * 
				     */
				    lblTotalAvancePLCUA3.setText(fmt.format(result.getTotalAvance()));
				    lblTotalAvanceSCTFA2.setText(fmt.format(result.getTotalAvanceARQTF()));

				    lblDiferenciaAvancePLCUASCTFA.setText(fmt.format(result
					    .getDiferenciaAvancePLCUASCTFA()));

				    lblTotalSuperAvancePLCUA3.setText(fmt.format(result.getTotalSuperavance()));
				    lblTotalSuperAvanceSCTFA2.setText(fmt.format(result.getTotalSuperAvanceARQTF()));
				    lblDiferenciaSuperAvancePLCUASCTFA.setText(fmt.format(result
					    .getDiferenciaSuperAvancePLCUASCTFA()));

				    /**
				     * Avance CRCMR
				     */

				    lblTotalAvanceCMRCRCMR.setText(fmt.format(result.getTotalAvanceCMRCRCMR()));
				    lblTotalAvanceAnuladosCMRCRCMR.setText(fmt.format(result
					    .getTotalAvanceAnuladosCMRCRCMR()));
				    lblTotalAvanceCRCMR.setText(fmt.format(result.getTotalAvanceCRCMR()));

				    /**
				     * SuperAvance CRCMR
				     */
				    lblTotalSuperAvanceCMRCRCMR.setText(fmt.format(result.getTotalSuperAvanceCMRCRCMR()));
				    lblTotalAnulacionesSuperAvanceCRCMR.setText(fmt.format(result
					    .getTotalAnulacionesSuperAvanceCRCMR()));
				    lblTotalSuperAvanceCRCMR.setText(fmt.format(result.getTotalSuperAvanceCRCMR()));
				    /**
				     * Totales
				     */
				    lblTotalAvanceCRCMR3.setText(fmt.format(result.getTotalAvanceCRCMR()));
				    lblTotalAvanceSCTFA3.setText(fmt.format(result.getTotalAvanceARQTF()));
				    lblDiferenciaAvanceCRCMRSCTFA.setText(fmt.format(result
					    .getDiferenciaAvanceSCTFACRCMR()));

				    lblTotalSuperavanceCRCMR2.setText(fmt.format(result.getTotalSuperAvanceCRCMR()));
				    lblTotalSuperAvanceSCTFA3.setText(fmt.format(result.getTotalSuperAvanceARQTF()));
				    lblDiferenciaSuperAvanceCRCMRSCTFA.setText(fmt.format(result
					    .getDiferenciaSuperAvanceSCTFACRCMR()));

				    lblVersionPOS.setText(result.getVersionPOS());

				    lblTrx220SAT.setText(fmt.format(result.getTotalTrx220SAT()));
				    lblTrx403SAT.setText(fmt.format(result.getTotalTrx403SAT()));
				    lblTotalTrxAvanceSAT.setText(fmt.format(result.getTotalAvanceFinalSAT()));

				    lblTrx274SAT.setText(fmt.format(result.getTotalTrx274SAT()));
				    lblTrx473SAT.setText(fmt.format(result.getTotalTrx473SAT()));
				    lblTotalFinalSuperAvanceSAT.setText(fmt.format(result.getTotalSuperAvanceFinalSAT()));

				    lblTrx220RSAT.setText(fmt.format(result.getTotalTrx220RSAT()));
				    lblTrx403RSAT.setText(fmt.format(result.getTotalTrx403RSAT()));
				    lblTotalAvanceRSAT.setText(fmt.format(result.getTotalAvanceFinalRSAT()));

				    lblTRX274RSAT.setText(fmt.format(result.getTotalTrx274RSAT()));
				    lblTrx473RSAT.setText(fmt.format(result.getTotalTrx473RSAT()));
				    lblTotalSuperAvanceRSAT.setText(fmt.format(result.getTotalSuperAvanceFinalRSAT()));

				    lblTotalAvanceSAT.setText(fmt.format(result.getTotalAvanceFinalSAT()));

				    lblTotalAvanceCRCMR4.setText(fmt.format(result.getTotalAvanceCRCMR()));

				    lblTotalAvanceRSAT1.setText(fmt.format(result.getTotalAvanceFinalRSAT()));

				    lblTotalAvanceCRCMR5.setText(fmt.format(result.getTotalAvanceCRCMR()));

				    lblDiferenciaCRCMRSATAvance2.setText(fmt.format(result
					    .getDiferenciaSATCRCMRAvance()));

				    lblDiferenciaCRCMRSATAvance.setText(fmt.format(result
					    .getDiferenciaRSATCRCMRAvance()));

				    lblTotalSuperAvanceSAT.setText(fmt.format(result.getTotalSuperAvanceFinalSAT()));

				    lblTotalSuperAvanceSAT2.setText(fmt.format(result.getTotalSuperAvanceFinalSAT()));

				    lblDiferenciaCRCMRSATSuperAvance.setText(fmt.format(result
					    .getDiferenciaSATCRCMRSuperAvance()));

				    lblDiferenciaCRCMRRSATSuperAvance.setText(fmt.format(result
					    .getDiferenciaRSATCRCMRSuperAvance()));

				    lblTotalSuperAvanceCRCMR3.setText(fmt.format(result.getTotalSuperAvanceCRCMR()));

				    lblTotalSuperAvanceRSAT2.setText(fmt.format(result.getTotalSuperAvanceFinalRSAT()));

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

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }

    private void setCerosEnLabels() {
	lblAvancePLCUA.setText("0");
	lblAvanceAnuladosPLCUA.setText("0");
	lblTotalAvancePLCUA.setText("0");

	/**
	 * Super Avance PLCUA
	 */
	lblSuperAvancePLCUA.setText("0");
	lblSuperAvanceAnuladoPLCUA.setText("0");
	lblTotalSuperAvance.setText("0");

	/**
	 * Totales
	 * 
	 */
	lblTotalAvancePLCUA2.setText("0");
	lblTotalAvanceCRCMR2.setText("0");

	lblDiferenciaAvacePLCUACRCMR.setText("0");

	lblTotalSuperAvancePLCUA2.setText("0");
	lblTotalSuperAvanceCRCMR2.setText("0");

	lblDiferenciaSuperAvancePLCUACRCMR.setText("0");

	/**
	 * Avances SCTFA
	 * 
	 */

	lblAvanceSCTFA.setText("0");
	lblAvanceAnuladosSCTFA.setText("0");
	lblTotalAvanceSCTFA.setText("0");
	/**
	 * Super Avance SCTFA
	 */

	lblSuperAvanceSCTFA.setText("0");
	lblSuperAvanceAnuladosSCTFA.setText("0");
	lblTotalSuperAvanceSCTFA.setText("0");

	/**
	 * Totales
	 * 
	 */
	lblTotalAvancePLCUA3.setText("0");
	lblTotalAvanceSCTFA2.setText("0");

	lblDiferenciaAvancePLCUASCTFA.setText("0");

	lblTotalSuperAvancePLCUA3.setText("0");
	lblTotalSuperAvanceSCTFA2.setText("0");
	lblDiferenciaSuperAvancePLCUASCTFA.setText("0");

	/**
	 * Avance CRCMR
	 */

	lblTotalAvanceCMRCRCMR.setText("0");
	lblTotalAvanceAnuladosCMRCRCMR.setText("0");
	lblTotalAvanceCRCMR.setText("0");

	/**
	 * SuperAvance CRCMR
	 */
	lblTotalSuperAvanceCMRCRCMR.setText("0");
	lblTotalAnulacionesSuperAvanceCRCMR.setText("0");
	lblTotalSuperAvanceCRCMR.setText("0");
	/**
	 * Totales
	 */
	lblTotalAvanceCRCMR3.setText("0");
	lblTotalAvanceSCTFA3.setText("0");
	lblDiferenciaAvanceCRCMRSCTFA.setText("0");

	lblTotalSuperavanceCRCMR2.setText("0");
	lblTotalSuperAvanceSCTFA3.setText("0");
	lblDiferenciaSuperAvanceCRCMRSCTFA.setText("0");

	lblVersionPOS.setText("0");
    }
}
