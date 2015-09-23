package com.rhiscom.bpm.console.client.ui.administration.profile;

import gwtquery.plugins.droppable.client.DroppableOptions;
import gwtquery.plugins.droppable.client.DroppableOptions.DroppableFunction;
import gwtquery.plugins.droppable.client.events.DragAndDropContext;
import gwtquery.plugins.droppable.client.gwt.DragAndDropNodeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.shared.model.dto.AbilityDTO;
import com.rhiscom.bpm.console.shared.model.dto.FunctionalityModuleDTO;

/**
 * The {@link TreeViewModel} used to organize members into a permission
 * hierarchy.
 */
public class ModulesTreeViewModel implements TreeViewModel {

    /**
     * A Cell used to render the member inside the tree.
     */
    private static class AbilityCell extends AbstractCell<AbilityDTO> {

	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context, AbilityDTO value, SafeHtmlBuilder sb) {
	    if (value != null) {

		sb.appendEscaped(value.getName());
	    }

	}
    }

    /**
     * The cell used to render permission.
     */
    private static class ModulesCell extends AbstractCell<FunctionalityModuleDTO> {

	public ModulesCell() {
	}

	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context, FunctionalityModuleDTO value,
		SafeHtmlBuilder sb) {
	    if (value != null) {
		sb.appendHtmlConstant("<div style='padding:15px 3px 3px 3px;' >");
		sb.appendEscaped(value.getDescription());
		sb.appendHtmlConstant("</div>");
	    }

	}
    }

    private AbilityCell abilityCell;
    private ModulesCell modulesCell;
    private final ListDataProvider<FunctionalityModuleDTO> modulesDataProvider;

    public ModulesTreeViewModel(List<FunctionalityModuleDTO> moduleList) {

	modulesDataProvider = new ListDataProvider<FunctionalityModuleDTO>();
	List<FunctionalityModuleDTO> permissionList = modulesDataProvider.getList();
	permissionList = moduleList;

	modulesDataProvider.setList(permissionList);
	modulesCell = new ModulesCell();
	abilityCell = new AbilityCell();

    }

    public <T> NodeInfo<?> getNodeInfo(T value) {

	if (value == null) {
	    // FunctionalityModuleDTO tree node
	    DragAndDropNodeInfo<FunctionalityModuleDTO> permissionNodeInfo = new DragAndDropNodeInfo<FunctionalityModuleDTO>(
		    modulesDataProvider, modulesCell);

	    // setup drop operation
	    DroppableOptions options = permissionNodeInfo.getDroppableOptions();
	    options.setDroppableHoverClass(Resource.INSTANCE.css().droppableHover());
	    // use a DroppableFunction here. We can also add a DropHandler in
	    // the tree
	    // itself
	    options.setOnDrop(new DroppableFunction() {

		public void f(DragAndDropContext context) {
		    AbilityDTO droppedMember = new AbilityDTO();
		    droppedMember = context.getDraggableData();
		    FunctionalityModuleDTO dropModule = context.getDroppableData();
		    // Window.alert("ID modulo habilidad DROP :" +
		    // droppedMember.getModuleIdTemp());
		    // Window.alert("ID modulo DROP :" +
		    // dropModule.getSegFuncModuleId());

		    Map<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>> mapModules = ModulesAbilityDataBase
			    .getInstance().getMapModules();
		    if (mapModules.get(dropModule) == null) {

			ListDataProvider<AbilityDTO> listAbility = new ListDataProvider<AbilityDTO>();
			AbilityDTO ability = new AbilityDTO((long) -1, LocaleMessages.LANG.selectAbilities(),
				"Seleccion", 0);
			AbilityDTO ability2 = new AbilityDTO(droppedMember.getSegAbilityId(), droppedMember.getName(),
				droppedMember.getDescription(), droppedMember.getStatus());
			List<AbilityDTO> list = new ArrayList<AbilityDTO>();
			ability2.setModuleIdTemp(dropModule.getSegFuncModuleId());
			list.add(ability);
			list.add(ability2);
			listAbility.setList(list);
			mapModules.put(dropModule, listAbility);
			listAbility.refresh();
			// Window.alert("ID modulo habilidad DROP 2 :" +
			// ability2.getModuleIdTemp());
			ModulesAbilityDataBase.getInstance().setMapModules(mapModules);

		    } else {
			ListDataProvider<AbilityDTO> listAbility = (mapModules.get(dropModule));
			List<AbilityDTO> list = listAbility.getList();
			boolean exist = false;
			for (int i = 0; i <= list.size() - 1; i++) {
			    if (droppedMember.getName().contains(list.get(i).getName())) {
				exist = true;
				Window.alert("EXISTE");
				break;
			    }
			}
			if (exist == false) {
			    AbilityDTO ability2 = new AbilityDTO(droppedMember.getSegAbilityId(), droppedMember
				    .getName(), droppedMember.getDescription(), droppedMember.getStatus());
			    ability2.setModuleIdTemp(dropModule.getSegFuncModuleId());
			    // Window.alert("ID modulo habilidad DROP 3 :" +
			    // ability2.getModuleIdTemp());
			    list.add(ability2);
			    listAbility.setList(list);
			    mapModules.put(dropModule, listAbility);
			    listAbility.refresh();
			    ModulesAbilityDataBase.getInstance().setMapModules(mapModules);
			}

		    }

		}
	    });
	    // permission cell are not draggable
	    permissionNodeInfo.setCellDroppableOnly();
	    return permissionNodeInfo;

	} else if (value instanceof FunctionalityModuleDTO) {
	    // member tree node
	    FunctionalityModuleDTO p = (FunctionalityModuleDTO) value;
	    ListDataProvider<AbilityDTO> dataProvider;
	    Map<FunctionalityModuleDTO, ListDataProvider<AbilityDTO>> mapModules = ModulesAbilityDataBase.getInstance()
		    .getMapModules();
	    if (mapModules.get(p) == null) {

		dataProvider = new ListDataProvider<AbilityDTO>();
		List<AbilityDTO> list = new ArrayList<AbilityDTO>();
		AbilityDTO ability = new AbilityDTO((long) -1, LocaleMessages.LANG.selectAbilities(), "Seleccion", 0);
		list.add(ability);
		dataProvider.setList(list);
	    } else {
		dataProvider = mapModules.get(p);
	    }
	    mapModules.put(p, dataProvider);

	    ModulesAbilityDataBase.getInstance().setMapModules(mapModules);

	    DragAndDropNodeInfo<AbilityDTO> memberNodeInfo = new DragAndDropNodeInfo<AbilityDTO>(dataProvider,
		    abilityCell, new SingleSelectionModel<AbilityDTO>(), null);

	    // setup the drag operation
	    AddUpdateProfilesDialog.configureDragOperation(memberNodeInfo.getDraggableOptions());
	    // member cell are only draggable
	    memberNodeInfo.setCellDraggableOnly();

	    return memberNodeInfo;
	}

	String type = value.getClass().getName();
	throw new IllegalArgumentException("Unsupported object type: " + type);
    }

    public boolean isLeaf(Object value) {
	return value instanceof AbilityDTO;
    }

}
