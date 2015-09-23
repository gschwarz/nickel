package com.rhiscom.bpm.console.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.event.dom.client.ContextMenuHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.rhiscom.bpm.console.client.MonitoreoService;
import com.rhiscom.bpm.console.client.MonitoreoServiceAsync;
import com.rhiscom.bpm.console.client.event.ServerGeneratedMessageEvent;
import com.rhiscom.bpm.console.shared.model.POSProcessStatus;

import de.novanic.eventservice.client.event.Event;
import de.novanic.eventservice.client.event.RemoteEventService;
import de.novanic.eventservice.client.event.RemoteEventServiceFactory;
import de.novanic.eventservice.client.event.listener.RemoteEventListener;

public class CellTableEstadoTiendaViewImpl extends Composite implements HasText, CellTableEstadoTiendaView {

    @UiField(provided = true)
    CellTable<POSProcessStatus> cellTableEstadoTienda;

    @UiField(provided = true)
    SimplePager pager;

    @UiField
    MenuItem btnConsultarTiendas;

    @UiField
    MenuItem btnAbrirTienda;

    @UiField
    MenuItem btnCerrarTienda;
    private static CellTableEstadoTiendaImplUiBinder uiBinder = GWT.create(CellTableEstadoTiendaImplUiBinder.class);

    interface CellTableEstadoTiendaImplUiBinder extends UiBinder<Widget, CellTableEstadoTiendaViewImpl> {
    }

    Presenter presenter;

    final MonitoreoServiceAsync monitoreoService = GWT.create(MonitoreoService.class);
    final ListDataProvider<POSProcessStatus> dataProvider;

    public CellTableEstadoTiendaViewImpl() {

	cellTableEstadoTienda = createCellTable();

	dataProvider = new ListDataProvider<POSProcessStatus>();

	// Connect the table to the data provider.
	dataProvider.addDataDisplay(cellTableEstadoTienda);

	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTableEstadoTienda);

	RemoteEventService theRemoteEventService = RemoteEventServiceFactory.getInstance().getRemoteEventService();
	// add a listener to the SERVER_MESSAGE_DOMAIN
	theRemoteEventService.addListener(ServerGeneratedMessageEvent.SERVER_MESSAGE_DOMAIN, new RemoteEventListener() {
	    public void apply(Event anEvent) {

	    }
	});

	initWidget(uiBinder.createAndBindUi(this));

	btnConsultarTiendas.setCommand(cmdBtnConsultar);

    }

    /**
     * Metodo que gatilla la generación de consulta solo una tienda en
     * particular.
     */
    public void generarConsultarEstadoPorTienda(String tienda) {
	// Window.alert("Se recarga la pagina de 0");

	/*
	 * InformationDialog myDialog = new InformationDialog();
	 * 
	 * int left = Window.getClientWidth() / 2; int top =
	 * Window.getClientHeight() / 2; myDialog.setPopupPosition(left, top);
	 * myDialog.show();
	 */

	monitoreoService.generarConsultaEstadoPorTienda(tienda, "usuario", new AsyncCallback<List<POSProcessStatus>>() {
	    public void onFailure(Throwable caught) {
		// Show the RPC error message to the user

	    }

	    @Override
	    public void onSuccess(List<POSProcessStatus> result) {

	    }
	});
    }

    /**
     * Metodo que gatilla la generación de consulta de todas las tiendas.
     */
    public void generarConsultarEstadoTodasLasTiendas() {
	// Window.alert("Se recarga la pagina de 0");

	InformationDialog myDialog = new InformationDialog();

	/*
	 * int left = (Window.getClientWidth() / 2); int top =
	 * Window.getClientHeight() / 2; myDialog.setPopupPosition(left, top);
	 */
	myDialog.center();
	myDialog.show();

	dataProvider.setList(new ArrayList<POSProcessStatus>());
	dataProvider.refresh();
	cellTableEstadoTienda.redraw();

	monitoreoService.generarConsultaEstadoTodasLasTiendas("usuario", new AsyncCallback<List<POSProcessStatus>>() {
	    public void onFailure(Throwable caught) {
		// Show the RPC error message to the user

	    }

	    @Override
	    public void onSuccess(List<POSProcessStatus> result) {

	    }
	});
    }

    /**
     * Efectúa consulta al servidor para saber el estado de una tienda en
     * particular ya cargada en la grilla
     * 
     * @param tienda
     */
    public void consultarEstadoPorTienda(String tienda, String fechaConsulta) {

	monitoreoService.traerEstadoPorTienda(tienda, fechaConsulta, new AsyncCallback<POSProcessStatus>() {
	    public void onFailure(Throwable caught) {
		// Show the RPC error message to the user

	    }

	    @Override
	    public void onSuccess(POSProcessStatus result) {
		List<POSProcessStatus> list = dataProvider.getList();
		int index = 0;

		for (int i = 0; i < list.size(); i++) {
		    POSProcessStatus t = list.get(i);
		    if (t.getCodigoTienda() == result.getCodigoTienda()) {
			index = i;
			// Window.alert("Indice:" + index);
			break;
		    }

		}

		list.set(index, result);

		dataProvider.setList(list);
		dataProvider.refresh();
		cellTableEstadoTienda.redraw();

	    }
	});
    }

    /**
     * Metodo que efectúa consulta a todas las tiendas existentes para
     * monitorear.
     * 
     * @param tienda
     * @param fechaConsulta
     */
    public void consultaEstadoTodasLasTienda(String tienda, String fechaConsulta) {
	monitoreoService.traerEstadoPorTienda(tienda, fechaConsulta, new AsyncCallback<POSProcessStatus>() {

	    @Override
	    public void onFailure(Throwable arg0) {
		// TODO Auto-generated method stub

	    }

	    @Override
	    public void onSuccess(POSProcessStatus arg0) {
		dataProvider.getList().add(arg0);
		dataProvider.refresh();
		cellTableEstadoTienda.redraw();
	    }

	});
    }

    Command cmdBtnConsultar = new Command() {
	public void execute() {
	    generarConsultarEstadoTodasLasTiendas();

	}
    };

    /**
     * Método que genera tabla con resultados de los estados de las tiendas.
     * 
     * @return
     */
    private CellTable<POSProcessStatus> createCellTable() {

	final CellTable<POSProcessStatus> table = new CellTable<POSProcessStatus>();
	// Create name column.
	TextColumn<POSProcessStatus> numeroTienda = new TextColumn<POSProcessStatus>() {
	    @Override
	    public String getValue(POSProcessStatus contact) {
		return String.valueOf(contact.getNumeroTienda());
	    }
	};

	// Make the name column sortable.
	numeroTienda.setSortable(true);

	// Create address column.
	TextColumn<POSProcessStatus> nombreTienda = new TextColumn<POSProcessStatus>() {
	    @Override
	    public String getValue(POSProcessStatus contact) {
		return contact.getNombreTienda();
	    }
	};

	TextColumn<POSProcessStatus> fechaApertura = new TextColumn<POSProcessStatus>() {
	    @Override
	    public String getValue(POSProcessStatus contact) {
		return contact.getFechaApertura();
	    }
	};

	TextColumn<POSProcessStatus> fechaConsulta = new TextColumn<POSProcessStatus>() {
	    @Override
	    public String getValue(POSProcessStatus contact) {
		return contact.getFechaConsulta();
	    }
	};

	TextColumn<POSProcessStatus> adsPrimarioColumn = new TextColumn<POSProcessStatus>() {
	    @Override
	    public String getValue(POSProcessStatus contact) {
		return contact.getEstadosADS().get("ADS1");
	    }
	};

	TextColumn<POSProcessStatus> adsSecundarioColumn = new TextColumn<POSProcessStatus>() {
	    @Override
	    public String getValue(POSProcessStatus contact) {
		return contact.getEstadosADS().get("ADS2");
	    }
	};

	Column<POSProcessStatus, String> updateBtn = new Column<POSProcessStatus, String>(new ButtonCell()) {

	    @Override
	    public String getValue(POSProcessStatus c) {

		return "Actualizar";

	    }

	};
	updateBtn.setCellStyleNames("buttonActualizar");

	updateBtn.setFieldUpdater(new FieldUpdater<POSProcessStatus, String>() {

	    @Override
	    public void update(int index, POSProcessStatus object, String value) {
		generarConsultarEstadoPorTienda(String.valueOf(object.getCodigoTienda()));
	    }

	});

	// Add the columns.

	table.addColumn(numeroTienda, "Numero Tienda");
	table.addColumn(nombreTienda, "Tienda");
	table.addColumn(fechaApertura, "Fecha Apertura");
	table.addColumn(fechaConsulta, "Fecha Consulta");

	table.addColumn(adsPrimarioColumn, "ADS 1");
	table.addColumn(adsSecundarioColumn, "ADS 2");
	table.addColumn(updateBtn, "");

	// Set the total row count. You might send an RPC request to determine
	// the
	// total row count.

	table.setColumnWidth(numeroTienda, 120.0, Unit.PX);
	table.setColumnWidth(nombreTienda, 180.0, Unit.PX);
	table.setColumnWidth(fechaApertura, 250.0, Unit.PX);
	table.setColumnWidth(fechaConsulta, 250.0, Unit.PX);
	table.setColumnWidth(adsPrimarioColumn, 150.0, Unit.PX);
	table.setColumnWidth(adsSecundarioColumn, 150.0, Unit.PX);
	table.setColumnWidth(updateBtn, 150.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);

	// We know that the data is sorted alphabetically by default.
	table.getColumnSortList().push(numeroTienda);

	table.addDomHandler(new ContextMenuHandler() {

	    @Override
	    public void onContextMenu(ContextMenuEvent event) {

		Window.alert(event.getNativeEvent().getType());
	    }
	}, ContextMenuEvent.getType());

	return table;

    }

    @Override
    public void setPresenter(Presenter presenter) {
	this.presenter = presenter;
    }

    @Override
    public String getText() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setText(String text) {
	// TODO Auto-generated method stub

    }

    /**
     * Clase DialogBox para mostrar ante consultas al servidor.
     * 
     * @author Pablo Cáceres
     * 
     */
    private static class InformationDialog extends DialogBox {

	public InformationDialog() {
	    // Set the dialog box's caption.
	    setText("Informaci\u00f3n de Consulta");

	    // Enable animation.
	    setAnimationEnabled(false);

	    // Enable glass background.
	    setGlassEnabled(true);

	    // DialogBox is a SimplePanel, so you have to set its widget
	    // property to whatever you want its contents to be.
	    Button ok = new Button("OK");
	    ok.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
		    InformationDialog.this.hide();
		}
	    });

	    Label label = new Label("Consulta enviada al servidor");

	    VerticalPanel panel = new VerticalPanel();
	    panel.setHeight("150px");
	    panel.setWidth("200px");
	    panel.setSpacing(10);
	    panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    panel.add(label);
	    panel.add(ok);

	    setWidget(panel);
	}
    }

}
