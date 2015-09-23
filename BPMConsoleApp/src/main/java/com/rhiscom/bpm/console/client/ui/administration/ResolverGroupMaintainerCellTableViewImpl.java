package com.rhiscom.bpm.console.client.ui.administration;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.event.shared.EventBus;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.ClientFactoryImpl;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.event.UpdateResolverGroupEvent;
import com.rhiscom.bpm.console.client.event.UpdateResolverGroupEventHandler;
import com.rhiscom.bpm.console.client.remote.ResolverGroupsService;
import com.rhiscom.bpm.console.client.remote.ResolverGroupsServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ResolverGroupDTO;

public class ResolverGroupMaintainerCellTableViewImpl extends Composite implements ResolverGroupMaintainerCellTableView {
    Presenter presenter;
    ClientFactory clientFactory;

    private static ResolverGroupMaintainerCellTableViewImplUiBinder uiBinder = GWT
	    .create(ResolverGroupMaintainerCellTableViewImplUiBinder.class);

    interface ResolverGroupMaintainerCellTableViewImplUiBinder extends
	    UiBinder<Widget, ResolverGroupMaintainerCellTableViewImpl> {
    }

    @UiField(provided = true)
    CellTable<ResolverGroupDTO> cellTableResolverGroup;

    @UiField(provided = true)
    SimplePager pager;

    @UiField
    MenuItem btnRefrescar;

    @UiField
    MenuItem btnAgregar;

    final ListDataProvider<ResolverGroupDTO> resolverGroupDataProvider;
    private List<AbilityDTO> abilityList;
    final ResolverGroupsServiceAsync resolverGroupService = GWT.create(ResolverGroupsService.class);

    public ResolverGroupMaintainerCellTableViewImpl(ClientFactoryImpl clientFactoryImpl) {
	this.clientFactory = clientFactoryImpl;
	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	abilityList = SecurityUtil.getAbilityes(operator, viewCode);
	resolverGroupDataProvider = new ListDataProvider<ResolverGroupDTO>();
	cellTableResolverGroup = this.createResolverGroupsCellTable();

	resolverGroupDataProvider.addDataDisplay(cellTableResolverGroup);
	SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	pager.setDisplay(cellTableResolverGroup);

	traerGruposVigentes();
	initWidget(uiBinder.createAndBindUi(this));
	traerGruposVigentes();

	btnRefrescar.setCommand(cmdRefrescar);
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "btnAgregar")) {
	    btnAgregar.setCommand(cmdAgregar);
	} else {
	    btnAgregar.setVisible(false);
	}

	EventBus eventBusLogin = clientFactory.getEventBus();

	eventBusLogin.addHandler(UpdateResolverGroupEvent.TYPE, new UpdateResolverGroupEventHandler() {

	    @Override
	    public void update(UpdateResolverGroupEvent event) {

		traerTodos();

	    }

	});

    }

    Command cmdRefrescar = new Command() {
	public void execute() {

	    traerTodos();

	}
    };

    Command cmdAgregar = new Command() {
	public void execute() {
	    AddUpdateResolverGroupsDialog dialog = new AddUpdateResolverGroupsDialog(resolverGroupService,
		    clientFactory);

	    dialog.center();
	    int top = dialog.getAbsoluteTop();
	    int left = dialog.getAbsoluteLeft();
	    dialog.setPopupPosition(left, top - 100);
	    dialog.show();

	}
    };

    /**
     * M�todo que consutruye la tabla donde muestra los grupos rolutores.
     * 
     * @return
     */
    public CellTable<ResolverGroupDTO> createResolverGroupsCellTable() {
	final CellTable<ResolverGroupDTO> table = new CellTable<ResolverGroupDTO>();
	// Create name column.
	TextColumn<ResolverGroupDTO> id = new TextColumn<ResolverGroupDTO>() {
	    @Override
	    public String getValue(ResolverGroupDTO definition) {
		return String.valueOf(definition.getWorkGroupid());
	    }
	};

	TextColumn<ResolverGroupDTO> name = new TextColumn<ResolverGroupDTO>() {
	    @Override
	    public String getValue(ResolverGroupDTO definition) {
		return String.valueOf(definition.getName());
	    }
	};

	Column<ResolverGroupDTO, String> editarBtn = new Column<ResolverGroupDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(ResolverGroupDTO c) {

		return "Editar ";

	    }

	};
	editarBtn.setCellStyleNames("buttonEditar");

	editarBtn.setFieldUpdater(new FieldUpdater<ResolverGroupDTO, String>() {

	    @Override
	    public void update(int index, ResolverGroupDTO resolverGroupDTO, String value) {
		editarGrupoResolutor(resolverGroupDTO);
	    }

	});

	Column<ResolverGroupDTO, String> eliminarBtn = new Column<ResolverGroupDTO, String>(new ButtonCell()) {

	    @Override
	    public String getValue(ResolverGroupDTO c) {

		return "Eliminar ";

	    }

	};
	eliminarBtn.setCellStyleNames("buttonBorrar");

	eliminarBtn.setFieldUpdater(new FieldUpdater<ResolverGroupDTO, String>() {

	    @Override
	    public void update(int index, ResolverGroupDTO resolverGroupDTO, String value) {
		eliminarGrupoResolutor(resolverGroupDTO);
	    }

	});

	// Add the columns.
	table.setWidth("370px");
	table.addColumn(id, "Id");
	table.addColumn(name, "Nombre");
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "editarBtn")) {
	    table.addColumn(editarBtn, " ");
	}
	if (PermisionUtil.getInstance().checkPermision(abilityList, viewCode, "eliminarBtn")) {
	    table.addColumn(eliminarBtn, " ");
	}
	table.setColumnWidth(id, 15.0, Unit.PX);
	table.setColumnWidth(name, 120.0, Unit.PX);
	table.setColumnWidth(editarBtn, 90.0, Unit.PX);
	table.setColumnWidth(eliminarBtn, 90.0, Unit.PX);

	AsyncHandler columnSortHandler = new AsyncHandler(table);
	table.addColumnSortHandler(columnSortHandler);
	return table;
    }

    private void editarGrupoResolutor(ResolverGroupDTO resolverGroupDTO) {
	AddUpdateResolverGroupsDialog dialog = new AddUpdateResolverGroupsDialog(resolverGroupService,
		resolverGroupDTO, clientFactory);

	dialog.center();
	int top = dialog.getAbsoluteTop();
	int left = dialog.getAbsoluteLeft();
	dialog.setPopupPosition(left, top - 100);
	dialog.show();

    }

    private void eliminarGrupoResolutor(ResolverGroupDTO resolverGroupDTO) {

	try {
	    // Window.alert("NO VIGENTES");
	    resolverGroupService.deleteResolverGroup(resolverGroupDTO, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorDeleteGroup()
			    + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {

		    traerTodos();

		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorDeleteGroup() + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

    /**
     * Metodo que consulta las tarea asignadas al usuario
     * 
     */
    public void traerTodos() {
	try {
	    // Window.alert("NO VIGENTES");
	    resolverGroupService.getAll(new AsyncCallback<List<ResolverGroupDTO>>() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorSearchGroups()
			    + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(List<ResolverGroupDTO> list) {
		    resolverGroupDataProvider.setList(list);
		    resolverGroupDataProvider.refresh();
		    cellTableResolverGroup.redraw();
		}

	    });
	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog(LocaleMessages.LANG.errorSearchGroups() + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

    /**
     * M�todo que consulta solo los grupos vigentes.
     */
    public void traerGruposVigentes() {
	try {
	    // Window.alert("VIGENTES");
	    resolverGroupService.getAllOK(new AsyncCallback<List<ResolverGroupDTO>>() {

		@Override
		public void onFailure(Throwable arg0) {

		}

		@Override
		public void onSuccess(List<ResolverGroupDTO> list) {
		    resolverGroupDataProvider.setList(list);
		    resolverGroupDataProvider.refresh();
		    cellTableResolverGroup.redraw();
		}

	    });
	} catch (Exception ex) {
	}
    }

    @Override
    public void setPresenter(Presenter presenter) {
	this.presenter = presenter;

    }

}
