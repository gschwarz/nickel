package com.rhiscom.bpm.console.client.ui.administration.profile;

import static com.google.gwt.query.client.GQuery.$;
import gwtquery.plugins.draggable.client.DraggableOptions;
import gwtquery.plugins.draggable.client.DraggableOptions.CursorAt;
import gwtquery.plugins.draggable.client.DraggableOptions.DragFunction;
import gwtquery.plugins.draggable.client.DraggableOptions.RevertOption;
import gwtquery.plugins.draggable.client.events.DragContext;
import gwtquery.plugins.droppable.client.DroppableOptions.AcceptFunction;
import gwtquery.plugins.droppable.client.events.DragAndDropContext;
import gwtquery.plugins.droppable.client.events.DropEvent;
import gwtquery.plugins.droppable.client.events.DropEvent.DropEventHandler;
import gwtquery.plugins.droppable.client.gwt.DragAndDropCellList;
import gwtquery.plugins.droppable.client.gwt.DragAndDropCellTree;
import gwtquery.plugins.droppable.client.gwt.DragAndDropNodeInfo;
import gwtquery.plugins.droppable.client.gwt.DroppableWidget;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.cellview.client.CellTree.Resources;
import com.google.gwt.user.cellview.client.CellTree.Style;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SingleSelectionModel;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.event.UpdateProfileEvent;
import com.rhiscom.bpm.console.client.remote.SecurityServiceAsync;
import com.rhiscom.bpm.console.client.ui.InformationDialog;
import com.rhiscom.bpm.console.client.ui.widget.Notification;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.SecurityUtil;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.AccessProfileFunctionalityAbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;
import com.rhiscom.bpm.console.shared.model.dto.ProfileDTO;

public class AddUpdateProfilesDialog extends DialogBox {
    public static final String viewCode = "madm_fnprf";

    @UiField(provided = true)
    DroppableWidget<DragAndDropCellList<AbilityDTO>> cellListAbility;
    @UiField(provided = true)
    DragAndDropCellTree cellTreeModules;
    @UiField
    Button btnCancelar;
    @UiField
    Button btnGuardar;
    @UiField(provided = true)
    Label lblError;
    @UiField(provided = true)
    TextBox txtPerfil;
    @UiField(provided = true)
    TextBox txtDescription;

    private ListDataProvider<AbilityDTO> abilityDataProvider = new ListDataProvider<AbilityDTO>();
    List<ProfileDTO> profileListLocal = new ArrayList<ProfileDTO>();
    private List<AbilityDTO> abilityList = new ArrayList<AbilityDTO>();
    private List<AbilityDTO> operatorAbilityList = new ArrayList<AbilityDTO>();
    private List<FunctionalityModuleDTO> moduleList = new ArrayList<FunctionalityModuleDTO>();
    private gwtquery.plugins.droppable.client.gwt.DragAndDropCellTree cellTree;
    private ModulesTreeViewModel moduleTree;
    private ProfileDTO editProfileDTO;
    private ClientFactory clientFactory;
    private SecurityServiceAsync service;

    private static final Binder binder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Widget, AddUpdateProfilesDialog> {
    }

    static class DetailledMemberCell extends AbstractCell<AbilityDTO> {

	private final String imageHtml;

	public DetailledMemberCell() {
	    this.imageHtml = AbstractImagePrototype.create(Resource.INSTANCE.templates()).getHTML();
	}

	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context, AbilityDTO value, SafeHtmlBuilder sb) {
	    // Value can be null, so do a null check..
	    if (value == null) {
		return;
	    }

	    sb.appendHtmlConstant("<table>");

	    // Add the contact image.
	    sb.appendHtmlConstant("<tr><td rowspan='3'>");
	    sb.appendHtmlConstant(imageHtml);
	    sb.appendHtmlConstant("</td>");

	    // Add the name and email address.
	    sb.appendHtmlConstant("<td style='font-size:95%;'>");
	    sb.appendEscaped(value.getName());
	    sb.appendHtmlConstant("</td></tr><tr><td>");
	    sb.appendEscaped(value.getDescription());
	    sb.appendHtmlConstant("</td></tr></table>");

	}
    }

    /**
     * Style used for our CellTree. Some style was modified to offer a greater
     * droppable area
     */
    interface DroppableCellTreeResource extends Resources {

	DroppableCellTreeResource INSTANCE = GWT.create(DroppableCellTreeResource.class);

	/**
	 * The styles used in this widget.
	 */
	@Source("DroppableCellTree.css")
	Style cellTreeStyle();
    }

    static interface Templates extends SafeHtmlTemplates {
	Templates INSTANCE = GWT.create(Templates.class);

	@Template("<div id='dragHelper' class='{0}'></div>")
	SafeHtml outerHelper(String cssClassName);
    }

    /**
     * Setup the drag operation for members cell. This method is static in order
     * to reuse it in ModulesTreeViewModel class.
     * 
     * @param nodeInfo
     */
    static void configureDragOperation(DraggableOptions options) {

	// set a custom element as drag helper. The content of the helper will
	// be
	// set when the drag will start
	options.setHelper($(Templates.INSTANCE.outerHelper(Resource.INSTANCE.css().dragHelper()).asString()));
	// opacity of the drag helper
	options.setOpacity((float) 0.9);
	// cursor during the drag operation
	options.setCursor(Cursor.MOVE);
	// the cell being greater than the helper, force the position of the
	// helper on the mouse cursor.
	options.setCursorAt(new CursorAt(10, 10, null, null));
	// append the helper to the body element
	// options.setAppendTo("body");
	// set the revert option
	options.setRevert(RevertOption.ON_INVALID_DROP);
	// use a Function to fill the content of the helper
	// we could also add a DragStartEventHandler on the DragAndDropTreeCell
	// and
	// DragAndDropCellList.
	options.setOnDragStart(new DragFunction() {
	    public void f(DragContext context) {
		AbilityDTO memberInfo = context.getDraggableData();
		context.getHelper().setInnerHTML(memberInfo.getName());
	    }
	});

    }

    ProvidesKey<AbilityDTO> keyProvider = new ProvidesKey<AbilityDTO>() {
	public Object getKey(AbilityDTO item) {
	    // Always do a null check.
	    return (item == null) ? null : item.getSegAbilityId();
	}
    };

    /**
     * Constructor para agregar nuevo perfil
     * 
     * @param abilityList2
     * @param moduleList
     * @param service
     * @param clientFactory
     * @param profileList
     */
    public AddUpdateProfilesDialog(List<AbilityDTO> abilityList2, List<FunctionalityModuleDTO> moduleList,
	    SecurityServiceAsync service, ClientFactory clientFactory, List<ProfileDTO> profileList) {

	defaultConstructor(abilityList2, moduleList, service, clientFactory, profileList);
	setWidget(binder.createAndBindUi(this));
	ModulesAbilityDataBase.getInstance().setMapModules(
		new HashMap<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>>());
	if (!PermisionUtil.getInstance().checkPermision(operatorAbilityList, viewCode, "btnGuardar"))
	    btnGuardar.setEnabled(false);

    }

    /**
     * Constructor para editar perfil existente.
     * 
     * @param abilityList2
     * @param moduleList2
     * @param service2
     * @param clientFactory2
     * @param profileDTO
     * @param profileList
     */
    public AddUpdateProfilesDialog(List<AbilityDTO> abilityList2, List<FunctionalityModuleDTO> moduleList2,
	    SecurityServiceAsync service2, ClientFactory clientFactory2, ProfileDTO profileDTO,
	    List<ProfileDTO> profileList) {
	editProfileDTO = profileDTO;

	defaultConstructor(abilityList2, moduleList2, service2, clientFactory2, profileList);

	Set<AccessProfileFunctionalityAbilityDTO> accessProfileFunctionalityAbility = editProfileDTO
		.getAccessProfileFunctionalityAbility();
	ModulesAbilityDataBase.getInstance().resetDatabase();
	Map<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>> modulesMap = ModulesAbilityDataBase.getInstance()
		.getMapModules();

	for (int i = 0; i <= moduleList.size() - 1; i++) {
	    ListDataProvider<AbilityDTO> provider = modulesMap.get(moduleList.get(i));
	    if (provider == null)
		provider = new ListDataProvider<AbilityDTO>();

	    for (Iterator<AccessProfileFunctionalityAbilityDTO> iterator = accessProfileFunctionalityAbility.iterator(); iterator
		    .hasNext();) {

		AccessProfileFunctionalityAbilityDTO access = (AccessProfileFunctionalityAbilityDTO) iterator.next();

		if (access.getSegAccessProfileFunc().getSegFuncModuleId() == moduleList.get(i).getSegFuncModuleId()) {

		    AbilityDTO ability = access.getSegAbility();
		    /** Se asocia id del modulo a la habilidad **/
		    ability.setModuleIdTemp(moduleList.get(i).getSegFuncModuleId());
		    List<AbilityDTO> list = provider.getList();
		    if (list == null || list.size() == 0) {
			list = new ArrayList<AbilityDTO>();
			AbilityDTO ability2 = new AbilityDTO((long) -1, LocaleMessages.LANG.selectAbilities(),
				"Seleccion", 0);
			if (!list.contains(ability2))
			    list.add(ability2);
		    }

		    list.add(ability);
		    provider.setList(list);
		    modulesMap.put(moduleList.get(i), provider);

		}

	    }

	}
	ModulesAbilityDataBase.getInstance().setMapModules(modulesMap);
	txtPerfil.setText(editProfileDTO.getName());
	txtDescription.setText(editProfileDTO.getDescription());

	setWidget(binder.createAndBindUi(this));

	if (!PermisionUtil.getInstance().checkPermision(operatorAbilityList, viewCode, "btnGuardar"))
	    btnGuardar.setEnabled(false);
    }

    /**
     * Constructor de elementos UI en comun.
     * 
     * @param abilityList2
     * @param moduleList
     * @param service
     * @param clientFactory
     * @param profileList
     */
    private void defaultConstructor(List<AbilityDTO> abilityList2, List<FunctionalityModuleDTO> moduleList,
	    SecurityServiceAsync service, ClientFactory clientFactory, List<ProfileDTO> profileList) {

	OperatorDTO operator = ApplicationContext.getAuth().getOperator();
	operatorAbilityList = SecurityUtil.getAbilityes(operator, viewCode);
	this.profileListLocal = profileList;
	this.abilityList = abilityList2;
	this.service = service;
	this.clientFactory = clientFactory;
	abilityDataProvider.setList(abilityList);
	this.moduleList = moduleList;
	setAnimationEnabled(false);
	setGlassEnabled(true);
	setText("Edici\u00f3n Perfiles");
	Resource.INSTANCE.css().ensureInjected();
	cellListAbility = createAllAbilityList();
	cellTreeModules = createPermissionTree();
	lblError = new Label();
	lblError.setVisible(false);
	lblError.setStyleName("lblError");
	txtPerfil = new TextBox();
	txtDescription = new TextBox();
	txtPerfil.setMaxLength(15);
    }

    /**
     * Create Panel with all members
     * 
     * @param contactForm
     * 
     * @return
     */
    private DroppableWidget<DragAndDropCellList<AbilityDTO>> createAllAbilityList() {

	// use a drag and drop cell list
	DragAndDropCellList<AbilityDTO> cellList = new DragAndDropCellList<AbilityDTO>(new DetailledMemberCell(),
		keyProvider);
	// setup CellList options
	cellList.setPageSize(30);

	final SingleSelectionModel<AbilityDTO> selectionModel = new SingleSelectionModel<AbilityDTO>(keyProvider);
	cellList.setSelectionModel(selectionModel);
	cellList.addStyleName(Resource.INSTANCE.css().memberList());

	// setup drag
	configureDragOperation(cellList.getDraggableOptions());
	// the cells are only draggable, the cellList will be droppable
	cellList.setCellDraggableOnly();
	abilityDataProvider.addDataDisplay(cellList);

	// make the cellList droppable in order to accept member.
	return makeCellListDroppable(cellList);
    }

    /**
     * Create the permission tree. Use a {@link DragAndDropCellTree} instead of
     * a {@link CellTree}. The drag and drop behavior will be configured thanks
     * to the {@link DragAndDropNodeInfo} in {@link ModulesTreeViewModel} class
     * 
     * @return
     */
    private gwtquery.plugins.droppable.client.gwt.DragAndDropCellTree createPermissionTree() {
	moduleTree = new ModulesTreeViewModel(moduleList);
	cellTree = new gwtquery.plugins.droppable.client.gwt.DragAndDropCellTree(moduleTree, null,
		DroppableCellTreeResource.INSTANCE);
	cellTree.setAnimationEnabled(true);
	cellTree.addStyleName(Resource.INSTANCE.css().permissionTree());

	return cellTree;

    }

    /**
     * Make the <code>cellList</code> droppable in order to accept Member.
     * 
     * @param cellList
     * @return
     */
    private DroppableWidget<DragAndDropCellList<AbilityDTO>> makeCellListDroppable(
	    DragAndDropCellList<AbilityDTO> cellList) {

	DroppableWidget<DragAndDropCellList<AbilityDTO>> droppableList = new DroppableWidget<DragAndDropCellList<AbilityDTO>>(
		cellList);
	// setup drop
	droppableList.setDroppableHoverClass(Resource.INSTANCE.css().droppableHover());
	// drop handler
	droppableList.addDropHandler(new DropEventHandler() {

	    public void onDrop(DropEvent event) {
		AbilityDTO droppedMember = new AbilityDTO();
		droppedMember = event.getDraggableData();
		Map<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>> mapModules = new HashMap<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>>();
		mapModules = ModulesAbilityDataBase.getInstance().getMapModules();

		for (int i = 0; i <= moduleList.size() - 1; i++) {

		    if (droppedMember.getModuleIdTemp() == moduleList.get(i).getSegFuncModuleId()) {
			// Window.alert("ID modulo de habilidad :" +
			// droppedMember.getModuleIdTemp());
			FunctionalityModuleDTO module = moduleList.get(i);
			ListDataProvider<AbilityDTO> provider = mapModules.get(module);
			List<AbilityDTO> list = new ArrayList<AbilityDTO>();
			list = provider.getList();
			list.remove(droppedMember);
			provider.setList(list);
			provider.refresh();
			mapModules.put(module, provider);
			ModulesAbilityDataBase.getInstance().setMapModules(mapModules);
			// moduleTree.mapModules.put(module, provider);
			abilityDataProvider.setList(abilityList);
			abilityDataProvider.refresh();
			break;

		    }

		}
	    }

	});
	// Don't accept when a member coming from this cell list
	droppableList.setAccept(new AcceptFunction() {

	    public boolean acceptDrop(DragAndDropContext context) {
		AbilityDTO draggedMember = context.getDraggableData();
		// don't continue drop if member coming from this list
		return true;
	    }

	});

	return droppableList;
    }

    /**
     * Manejo evento de cierre.
     * 
     * @param e
     */
    @UiHandler("btnCancelar")
    void onClickCancelar(ClickEvent e) {

	this.hide();

    }

    @UiHandler("btnGuardar")
    void onClickGuardar(ClickEvent e) {
	boolean errorPerfilUnico = true;
	ProfileDTO profile = new ProfileDTO();
	Set<AccessProfileFunctionalityAbilityDTO> accessProfileFunctionalityAbility = new HashSet<AccessProfileFunctionalityAbilityDTO>();

	Map<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>> modulesMap = ModulesAbilityDataBase.getInstance()
		.getMapModules();
	for (int i = 0; i <= moduleList.size() - 1; i++) {
	    ListDataProvider<AbilityDTO> provider = modulesMap.get(moduleList.get(i));
	    if (provider != null) {
		List<AbilityDTO> list = provider.getList();
		for (int j = 0; j <= list.size() - 1; j++) {
		    AbilityDTO ability = list.get(j);
		    if (ability.getSegAbilityId() != -1) {
			AccessProfileFunctionalityAbilityDTO accessDTO = new AccessProfileFunctionalityAbilityDTO();
			if (this.editProfileDTO != null) {
			    accessDTO.setSegProfileId(editProfileDTO.getSegProfileId());
			}

			accessDTO.setSegAbility(ability);
			accessDTO.setSegAccessProfileFunc(moduleList.get(i));
			accessProfileFunctionalityAbility.add(accessDTO);
		    }

		}
	    }

	}

	profile.setName(txtPerfil.getText());
	profile.setDescription(txtDescription.getText());
	profile.setCreateStamp(new Date());
	profile.setAccessProfileFunctionalityAbility(accessProfileFunctionalityAbility);

	if (txtPerfil.getText().trim().length() > 2 && txtPerfil.getText().trim().length() <= 15) {
	    if (this.editProfileDTO == null) {
		for (int i = 0; i <= profileListLocal.size() - 1; i++) {

		    if (profileListLocal.get(i).getName().compareToIgnoreCase(txtPerfil.getText()) == 0) {
			lblError.setText("El perfil ya existe");
			lblError.setVisible(true);
			errorPerfilUnico = true;
			break;
		    } else {
			errorPerfilUnico = false;
		    }

		}

		if (errorPerfilUnico == false) {
		    agregarProfile(profile);
		    this.hide();
		}
	    } else {

		editProfileDTO.setName(txtPerfil.getText());
		editProfileDTO.setDescription(txtDescription.getText());
		editProfileDTO.setUpdateStamp(new Date());
		editProfileDTO.setAccessProfileFunctionalityAbility(accessProfileFunctionalityAbility);

		editarProfile(editProfileDTO);
		this.hide();
	    }

	}

	else {
	    lblError.setVisible(true);
	    lblError.setText(LocaleMessages.LANG.profileHaveName());
	    txtPerfil.setFocus(true);
	    txtPerfil.setStyleName("redBorderAlert", true);
	}

    }

    private void agregarProfile(ProfileDTO profile) {
	final Notification not = new Notification(true, true);
	try {
	    service.addProfile(profile, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {

		    clientFactory.getEventBus().fireEvent(new UpdateProfileEvent());
		    not.show(5000, LocaleMessages.LANG.profileCreateOK(), Notification.OK);

		}

	    });

	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }

    private void editarProfile(ProfileDTO profile) {
	final Notification not = new Notification(true, true);
	try {
	    service.updateProfile(profile, new AsyncCallback() {

		@Override
		public void onFailure(Throwable ex) {
		    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
		    dialog.center();
		    dialog.show();

		}

		@Override
		public void onSuccess(Object arg0) {

		    clientFactory.getEventBus().fireEvent(new UpdateProfileEvent());
		    not.show(5000, LocaleMessages.LANG.profileEditOK(), Notification.OK);

		}

	    });

	} catch (Exception ex) {
	    InformationDialog dialog = new InformationDialog("Error :" + ex.toString());
	    dialog.center();
	    dialog.show();
	}
    }
}
