package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO;

public class DespachoDomicilioFormWidget extends Composite {

    private static final Binder binder = GWT.create(Binder.class);
    @UiField
    Label lblIdPedido;
    @UiField
    Label lblfechaGeneracion;
    @UiField
    Label lblTotalVenta;
    @UiField
    Label lblLocal;
    @UiField
    Label lblNombreCompleto;
    @UiField
    Label lblCorreo;
    @UiField
    Label lblNumeroCliente;
    @UiField
    Label lblEstadoVenta;
    @UiField
    HorizontalPanel lblPanel;
    @UiField
    HorizontalPanel lblFecha;
    @UiField
    Label lblTelefono;
    @UiField
    Label lblDireccion;

    interface Binder extends UiBinder<Widget, DespachoDomicilioFormWidget> {
    }

    public DespachoDomicilioFormWidget(VentaDomicilioDTO dto) {

	initWidget(binder.createAndBindUi(this));

	lblIdPedido.setText(String.valueOf(dto.getId()));
	lblfechaGeneracion.setText(String.valueOf(dto.getFecha()));
	lblTotalVenta.setText(String.valueOf(dto.getTotal()));
	lblLocal.setText(String.valueOf(dto.getLocal()));
	lblNombreCompleto.setText(dto.getCliente().getNombre() + " " + dto.getCliente().getApellido());
	lblCorreo.setText(dto.getCliente().getEmail());
	lblNumeroCliente.setText(dto.getCliente().getNumeroCliente());
	lblEstadoVenta.setText(dto.getEstado());
	lblDireccion.setText(dto.getCliente().getDireccion());
	lblTelefono.setText(dto.getCliente().getTelefonoContacto1());

    }
}
