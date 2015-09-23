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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO;

public class CuadraturaActivacionGiftCardViewImpl extends Composite implements CuadraturaActivacionGiftCardView {
    final QuadratureServiceAsync quadratureService = GWT.create(QuadratureService.class);
    final RetailDomainServiceAsync retailDomainService = GWT.create(RetailDomainService.class);
    private static final DateTimeFormat dtf = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_LONG);
    private static final DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static final DateTimeFormat dfStr = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static final Binder binder = GWT.create(Binder.class);
    NumberFormat fmt = NumberFormat.getDecimalFormat();
    @UiField
    Label lblActivacionGiftCardCMR;
    @UiField
    Label lblAnulacionGiftCardCMR;
    @UiField
    Label lblActivacionGiftCardCorporativa;
    @UiField
    Label lblAnulacionGiftCardCorporativa;
    @UiField
    Label lblTotalGiftCard;
    @UiField
    ListBox sucursalSeleccionada;
    @UiField(provided = true)
    DateBox dateOfBusinessDateBox;
    @UiField
    Label lblError;
    @UiField
    Label lblActivacionCMRCod55;
    @UiField
    Label lblAnulacionCMRCod58;
    @UiField
    Label lbl1;
    @UiField
    Label lblSubTotalGiftCardCMR;
    @UiField
    Label lblSubTotalGiftCardCorporativa;
    @UiField
    Label lblSubTotalCod05;
    @UiField
    Label lblSubTotalCod03;
    @UiField
    Label lblActivacionCorporativaCod55;
    @UiField
    Label lblAnulacionCorporativaCod58;
    @UiField
    Label lblTotal2;

    @UiField
    Label lblSubTotalGiftCardCorporativa2;
    @UiField
    Label lblSubTotalGiftCardCMR2;
    @UiField
    Label lblTotal3;
    @UiField
    Label lblDiferencia;
    @UiField
    Label lblVersionPOS;

    interface Binder extends UiBinder<Widget, CuadraturaActivacionGiftCardViewImpl> {
    }

    public CuadraturaActivacionGiftCardViewImpl() {

	dateOfBusinessDateBox = new DateBox();
	dateOfBusinessDateBox.setValue(new Date());
	dateOfBusinessDateBox.setFormat(new DateBox.DefaultFormat(dtf));

	initWidget(binder.createAndBindUi(this));
	traerUnidadesDeNegocios(true);
	lblError.setVisible(false);
	setCeroEnLabels();
    }

    @UiHandler("filterButton")
    public void onClickCSV(ClickEvent e) {
	lblError.setVisible(false);
	traerCuadraturaActivacionGiftCard();

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
	    String url = GWT.getModuleBaseURL() + "ExcelActivacionGiftCard?businessDate=" + fechaNegocio + "&sucursal="
		    + sucursal;
	    Window.open(url, "", "");
	}
    }

    private void traerCuadraturaActivacionGiftCard() {

	Date fechaNegocio = dateOfBusinessDateBox.getValue();
	String fechaNegocioStr = dfStr.format(fechaNegocio);
	long sucursal = Long.valueOf(sucursalSeleccionada.getValue(sucursalSeleccionada.getSelectedIndex()));

	if (sucursal == -1) {
	    lblError.setVisible(true);
	    lblError.setText("Debe seleccionar sucursal");
	} else {

	    try {

		quadratureService.getCuadraturaActivacionGiftCard(fechaNegocioStr, sucursal,
			new AsyncCallback<CuadraturaActivacionGiftcardDTO>() {
			    @Override
			    public void onFailure(Throwable ex) {

			    }

			    @Override
			    public void onSuccess(CuadraturaActivacionGiftcardDTO result) {

				if (result != null) {

				    lblActivacionGiftCardCMR.setText(String.valueOf(fmt.format(result
					    .getActivacionGiftCardCMR())));
				    lblAnulacionGiftCardCMR.setText(String.valueOf(fmt.format(result
					    .getAnulacionGiftCardCMR())));
				    lblActivacionGiftCardCorporativa.setText(String.valueOf(fmt.format(result
					    .getActivacionGiftCardCorporativa())));
				    lblAnulacionGiftCardCorporativa.setText(String.valueOf(fmt.format(result
					    .getAnulacionGiftCardCorporativa())));

				    lblSubTotalGiftCardCMR.setText(String.valueOf(fmt.format(result.getTotalGiftCMR())));
				    lblSubTotalGiftCardCorporativa.setText(String.valueOf(fmt.format(result
					    .getTotalGiftCorporativa())));

				    lblTotalGiftCard.setText(String.valueOf(fmt.format(result.getTotalGiftCard())));

				    lblActivacionCMRCod55.setText(String.valueOf(fmt.format(result.getTotalActGiftCMR())));
				    lblAnulacionCMRCod58.setText(String.valueOf(fmt.format(result.getTotalACCGiftCMR())));
				    lblSubTotalCod05.setText(String.valueOf(fmt.format(result.getTotalGiftCMR2())));

				    lblActivacionCorporativaCod55.setText(String.valueOf(fmt.format(result
					    .getTotalActGiftCorporativa())));
				    lblAnulacionCorporativaCod58.setText(String.valueOf(fmt.format(result
					    .getTotalACCGiftCorporativa())));

				    lblSubTotalCod03.setText(String.valueOf(fmt.format(result
					    .getTotalGiftCorporativa2())));
				    lblTotal2.setText(String.valueOf(fmt.format(result.getTotalGiftCard2())));

				    lblSubTotalGiftCardCorporativa2.setText(String.valueOf(fmt.format(result
					    .getTotalGiftCorporativa())));
				    lblSubTotalGiftCardCMR2.setText(String.valueOf(fmt.format(result.getTotalGiftCMR())));
				    lblSubTotalGiftCardCorporativa.setText(String.valueOf(fmt.format(result
					    .getTotalGiftCorporativa())));
				    lblTotal3.setText(String.valueOf(fmt.format(result.getTotalGiftCard2())));

				    lblDiferencia.setText(String.valueOf(fmt.format(result
					    .getDiferenciaPlaCuadConPLGC())));
				    lblVersionPOS.setText(result.getVersionPOS());
				} else {

				    lblError.setVisible(true);
				    lblError.setText("Resultados no encontrados");
				    setCeroEnLabels();
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

    private void setCeroEnLabels() {
	lblActivacionGiftCardCMR.setText("0");
	lblAnulacionGiftCardCMR.setText("0");
	lblActivacionGiftCardCorporativa.setText("0");
	lblAnulacionGiftCardCorporativa.setText("0");

	lblSubTotalGiftCardCMR.setText("0");
	lblSubTotalGiftCardCorporativa.setText("0");

	lblTotalGiftCard.setText("0");

	lblActivacionCMRCod55.setText("0");
	lblAnulacionCMRCod58.setText("0");
	lblSubTotalCod05.setText("0");

	lblActivacionCorporativaCod55.setText("0");
	lblAnulacionCorporativaCod58.setText("0");

	lblSubTotalCod03.setText("0");
	lblTotal2.setText("0");

	lblSubTotalGiftCardCorporativa2.setText("0");
	lblSubTotalGiftCardCMR2.setText("0");
	lblTotal3.setText("0");

	lblDiferencia.setText("0");
	lblVersionPOS.setText("0");
    }
}
