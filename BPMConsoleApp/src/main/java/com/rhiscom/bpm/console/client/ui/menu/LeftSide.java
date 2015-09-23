/*
 * Copyright 2010, L.Pelov
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.rhiscom.bpm.console.client.ui.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.LocaleMessages;
import com.rhiscom.bpm.console.client.PermisionUtil;
import com.rhiscom.bpm.console.client.place.RootPlace;
import com.rhiscom.bpm.console.client.ui.ProfilesUtil;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

/**
 * Left side panel
 * 
 * @author L.Pelov
 */
public class LeftSide extends Composite {

    private static LeftSideUiBinder uiBinder = GWT.create(LeftSideUiBinder.class);

    interface LeftSideUiBinder extends UiBinder<Widget, LeftSide> {
    }

    private ClientFactory clientFactory;
    private OperatorDTO loggedOperator;
    private Map<String, List<String>> modulesMap = new HashMap<String, List<String>>();
    private List<String> viewList = new ArrayList<String>();

    @UiField(provided = true)
    StackLayoutPanel menuStackPanel;

    public interface Images extends ClientBundle, Tree.Resources {

	ImageResource home();

	ImageResource services();

	ImageResource tasksgroup();

	ImageResource group();

	ImageResource Workgroup();

	ImageResource Tasklist();

	ImageResource GroupGo32();

	ImageResource Group32();

	ImageResource Process32();

	ImageResource Building22();

	ImageResource User22();

	ImageResource Profiles();

	ImageResource Report22();

	ImageResource ShopBuilding22();

	ImageResource Monitoring();

	ImageResource Activitymonitoring();

	ImageResource EmailConfig();

	ImageResource Corecase();

	ImageResource Piechart22();

	ImageResource Version22();

	@Source("noimage.png")
	ImageResource treeLeaf();
    }

    @SuppressWarnings("unchecked")
    public LeftSide(final ClientFactory clientFactory) {
	viewList = PermisionUtil.getInstance().getViews();

	Map<String, List<String>> modules = buildModules(viewList);
	ProfilesUtil util = new ProfilesUtil();
	modulesMap = util.buildAccess();

	Images images = GWT.create(Images.class);
	menuStackPanel = new StackLayoutPanel(Unit.EM);

	menuStackPanel.setSize("235px", "100%");

	Widget homeHeader = createHeaderWidget("Inicio");
	menuStackPanel.add(buildTreeInicio(clientFactory, images), homeHeader, 2.3);

	Iterator it = modules.entrySet().iterator();

	while (it.hasNext()) {

	    Map.Entry pairs = (Map.Entry) it.next();

	    System.out.println(pairs.getKey() + " = " + pairs.getValue());

	    if (modulesMap.containsKey(pairs.getKey())) {

		if (pairs.getKey().toString().equals("mproc")) {
		    Widget procesosHeader = createHeaderWidget(LocaleMessages.LANG.businessProcessManagement());
		    menuStackPanel
			    .add(buildTreeMenuProcesos(clientFactory, images,
				    (List<String>) modulesMap.get(pairs.getKey())), procesosHeader, 2.3);
		}

		if (pairs.getKey().toString().equals("madm")) {
		    Widget administracionHeader = createHeaderWidget(LocaleMessages.LANG.administration());
		    menuStackPanel.add(
			    buildTreeMenuAdministracion(clientFactory, images, modulesMap.get(pairs.getKey())),
			    administracionHeader, 2.3);
		}
		if (pairs.getKey().toString().equals("mrpt")) {
		    Widget reporteHeader = createHeaderWidget(LocaleMessages.LANG.reportsMonitoring());
		    menuStackPanel.add(buildTreeMenuReportes(clientFactory, images, modulesMap.get(pairs.getKey())),
			    reporteHeader, 2.3);
		}

	    }

	}
	initWidget(uiBinder.createAndBindUi(this));

	this.clientFactory = clientFactory;

    }

    private Map<String, List<String>> buildModules(List<String> viewList2) {
	Map<String, List<String>> modules = new HashMap<String, List<String>>();
	List<String> fnList = null;

	for (int i = 0; i <= viewList2.size() - 1; i++) {
	    int index = viewList2.get(i).indexOf("_");
	    String module = viewList2.get(i).substring(0, index);

	    fnList = modules.get(module);
	    if (fnList == null)
		fnList = new ArrayList<String>();

	    String function = viewList2.get(i).substring(index + 1, viewList2.get(i).length());
	    fnList.add(function);
	    modules.put(module, fnList);

	}

	return modules;

    }

    private Widget buildTreeMenuReportes(final ClientFactory clientFactory, Images images, List<String> fnList) {

	Map<String, String> resultsMap = new HashMap<String, String>();

	for (String view : fnList) {
	    resultsMap.put(view.trim(), view.trim());
	}

	Tree tree;
	tree = new Tree(images);
	tree.setStyleName("treeStyle");
	tree.setWidth("100%");
	tree.setHeight("100%");
	TreeItem root = new TreeItem(imageItemHTML(images.treeLeaf(), "Monitoreo"));
	TreeItem cuadratura = new TreeItem(imageItemHTML(images.treeLeaf(), "Cuadratura"));
	tree.addItem(root);
	tree.addItem(cuadratura);

	if (resultsMap.containsKey("fnbamdash".trim())) {
	    addImageItem(root, LocaleMessages.LANG.processMonitoring(), images.Piechart22());

	}
	if (resultsMap.containsKey("fnbamdashprocess".trim())) {
	    addImageItem(root, "Historial de ejecuci\u00F3n", images.Activitymonitoring());

	}

	if (resultsMap.containsKey("cuadvtacmr".trim())) {
	    addImageItem(cuadratura, "Cuadratura Vta CMR", images.Report22());

	}
	if (resultsMap.containsKey("cuadactgiftcard".trim())) {
	    addImageItem(cuadratura, "Cuadratura Act. GiftCard", images.Report22());

	}

	if (resultsMap.containsKey("cuadvtagiftcard".trim())) {
	    addImageItem(cuadratura, "Cuadratura Vta. Giftcard", images.Report22());

	}

	if (resultsMap.containsKey("cuadavancesuperavance".trim())) {
	    addImageItem(cuadratura, "Cuadratura Avance SuperAvance", images.Report22());

	}

	if (resultsMap.containsKey("cuadpagoscmr".trim())) {
	    addImageItem(cuadratura, "Cuadratura Pagos CMR", images.Report22());

	}
	if (resultsMap.containsKey("cuadtarjetacredito".trim())) {
	    addImageItem(cuadratura, "Cuadratura Tarjeta Cr\u00E9dito", images.Report22());

	}

	if (resultsMap.containsKey("cuadnotacredito".trim())) {
	    addImageItem(cuadratura, "Cuadratura Nota de Cr\u00E9dito", images.Report22());

	}

	if (resultsMap.containsKey("cuadtarjetadebito".trim())) {
	    addImageItem(cuadratura, "Cuadratura Tarjeta Debito", images.Report22());

	}

	root.setState(true);
	cuadratura.setState(true);

	tree.addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> item) {

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.processMonitoring())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("dashBoardActivity"));

		}

		if (item.getSelectedItem().getText().contains("Historial de ejecuci\u00F3n")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("monitoringProcess"));

		}

		if (item.getSelectedItem().getText().contains("Cuadratura Vta CMR")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("cuadraturaVtaCRM"));

		}

		if (item.getSelectedItem().getText().contains("Cuadratura Act. GiftCard")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("cuadraturaActGiftCard"));

		}

		if (item.getSelectedItem().getText().contains("Cuadratura Vta. Giftcard")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("cuadraturaVtaGiftcard"));

		}
		if (item.getSelectedItem().getText().contains("Cuadratura Avance SuperAvance")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("cuadraturaAvanceSuperAvance"));

		}
		if (item.getSelectedItem().getText().contains("Cuadratura Pagos CMR")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("cuadraturaPagosCMR"));

		}

		if (item.getSelectedItem().getText().contains("Cuadratura Tarjeta Cr\u00E9dito")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("cuadraturaTarjetaCredito"));

		}
		if (item.getSelectedItem().getText().contains("Cuadratura Nota de Cr\u00E9dito")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("cuadraturaNotaCredito"));

		}

		if (item.getSelectedItem().getText().contains("Cuadratura Tarjeta Debito")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("cuadraturaTarjetaDebito"));

		}

	    }
	});

	return tree;

    }

    private Widget buildTreeInicio(final ClientFactory clientFactory, Images images) {
	// TODO Auto-generated method stub
	Tree tree;
	tree = new Tree(images);
	tree.setStyleName("treeStyle");
	tree.setWidth("100%");
	tree.setHeight("100%");
	TreeItem root = new TreeItem(imageItemHTML(images.treeLeaf(), "Inicio"));
	tree.addItem(root);

	addImageItem(root, LocaleMessages.LANG.home(), images.home());

	root.setState(true);

	tree.addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> item) {

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.home())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("rootview"));

		}

	    }
	});

	return tree;

    }

    private Widget buildTreeMenuProcesos(final ClientFactory clientFactory, Images images, List<String> fnList) {
	Tree tree;
	tree = new Tree(images);
	tree.setStyleName("treeStyle");
	tree.setWidth("100%");
	tree.setHeight("100%");
	Map<String, String> resultsMap = new HashMap<String, String>();

	for (String view : fnList) {
	    resultsMap.put(view.trim(), view.trim());
	}

	TreeItem root = new TreeItem(imageItemHTML(images.treeLeaf(), "Procesos"));
	tree.addItem(root);
	if (resultsMap.containsKey("fnproc".trim())) {
	    addImageItem(root, LocaleMessages.LANG.process(), images.Process32());
	    addImageItem(root, LocaleMessages.LANG.schedulerProcess(), images.Report22());

	}

	root.setState(true);

	tree.addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> item) {

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.process())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("processConsole"));

		}
		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.schedulerProcess())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("processScheduler"));

		}

	    }
	});

	return tree;
    }

    private Widget buildTreeMenuCasos(final ClientFactory clientFactory, Images images, List<String> fnList) {
	Tree tree;
	tree = new Tree(images);
	tree.setStyleName("treeStyle");
	tree.setWidth("100%");
	tree.setHeight("100%");
	Map<String, String> resultsMap = new HashMap<String, String>();

	for (String view : fnList) {
	    resultsMap.put(view.trim(), view.trim());
	}

	TreeItem root = new TreeItem(imageItemHTML(images.treeLeaf(), LocaleMessages.LANG.newCase()));
	tree.addItem(root);
	if (resultsMap.containsKey("fnprocmng".trim())) {
	    addImageItem(root, LocaleMessages.LANG.insertCase(), images.Process32());
	    addImageItem(root, "Administraci\u00F3n de casos", images.Corecase());
	}

	root.setState(true);

	tree.addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> item) {

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.insertCase())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("processManagement"));

		}

		if (item.getSelectedItem().getText().contains("Administraci\u00F3n de casos")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("processCoreCase"));

		}

	    }
	});

	return tree;
    }

    private Widget buildTreeMenuTareas(final ClientFactory clientFactory, Images images, List<String> fnList) {
	Tree tree;
	tree = new Tree(images);
	tree.setStyleName("treeStyle");
	tree.setWidth("100%");
	tree.setHeight("100%");
	TreeItem root = new TreeItem(imageItemHTML(images.treeLeaf(), "Tareas"));
	tree.addItem(root);
	Map<String, String> resultsMap = new HashMap<String, String>();

	for (String view : fnList) {
	    resultsMap.put(view.trim(), view.trim());
	}

	if (resultsMap.containsKey("fntsk".trim())) {
	    addImageItem(root, LocaleMessages.LANG.myTasks(), images.Tasklist());
	}
	if (resultsMap.containsKey("fnaut".trim())) {
	    addImageItem(root, LocaleMessages.LANG.notAssignedTask(), images.GroupGo32());
	}
	if (resultsMap.containsKey("fnaut".trim())) {
	    addImageItem(root, LocaleMessages.LANG.taskMonitoring(), images.Activitymonitoring());
	}

	root.setState(true);

	tree.addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> item) {

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.myTasks())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("asignedTaskConsole"));

		}

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.notAssignedTask())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("unassignedTaskConsole"));

		}

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.taskMonitoring())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("taskMonitoring"));

		}

	    }
	});

	return tree;
    }

    private Widget buildTreeMenuAdministracion(final ClientFactory clientFactory, Images images, List<String> fnList) {

	Map<String, String> resultsMap = new HashMap<String, String>();

	for (String view : fnList) {
	    resultsMap.put(view.trim(), view.trim());
	}

	Tree tree;
	tree = new Tree(images);
	tree.setStyleName("treeStyle");
	tree.setWidth("100%");
	tree.setHeight("100%");
	TreeItem administracion = new TreeItem(imageItemHTML(images.treeLeaf(), LocaleMessages.LANG.administration()));

	tree.addItem(administracion);

	if (resultsMap.containsKey("fnbng".trim())) {
	    addImageItem(administracion, LocaleMessages.LANG.businessUnitGroups(), images.Building22());
	}
	if (resultsMap.containsKey("fnusr".trim())) {
	    addImageItem(administracion, LocaleMessages.LANG.users(), images.User22());
	}
	if (resultsMap.containsKey("fnprf".trim())) {
	    addImageItem(administracion, LocaleMessages.LANG.profiles(), images.Profiles());
	}

	if (resultsMap.containsKey("fnbunit".trim())) {

	    addImageItem(administracion, LocaleMessages.LANG.businessGroups(), images.ShopBuilding22());
	}
	if (resultsMap.containsKey("fnemail".trim())) {

	    addImageItem(administracion, LocaleMessages.LANG.emailServer(), images.EmailConfig());
	}
	if (resultsMap.containsKey("fnemailrecipients".trim())) {

	    addImageItem(administracion, LocaleMessages.LANG.recipientsConfiguration(), images.EmailConfig());
	}
	if (resultsMap.containsKey("fnposversion".trim())) {

	    addImageItem(administracion, "Versiones de POS", images.Version22());
	}
	if (resultsMap.containsKey("deletedata".trim())) {

	    addImageItem(administracion, "Borrar Datos", images.Version22());
	}

	administracion.setState(true);

	tree.addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> item) {

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.resolverGroups())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("resolveGroupMaintainer"));

		}
		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.businessUnitGroups())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("businessGroupMaintainer"));

		}
		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.users())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("userMaintainer"));

		}
		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.profiles())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("profilesMaintainer"));

		}

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.businessGroups())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("businessUnitMaintainer"));

		}

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.emailServer())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("emailConfiguration"));

		}

		if (item.getSelectedItem().getText().contains(LocaleMessages.LANG.recipientsConfiguration())) {

		    clientFactory.getPlaceController().goTo(new RootPlace("recipientsConfiguration"));

		}

		if (item.getSelectedItem().getText().contains("Versiones de POS")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("posVersion"));

		}
		if (item.getSelectedItem().getText().contains("Borrar Datos")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("deleteData"));

		}

	    }
	});

	return tree;
    }

    private Widget buildTreeMenuAdministracion(final ClientFactory clientFactory, Images images) {
	Tree tree;
	tree = new Tree(images);
	tree.setStyleName("treeStyle");
	tree.setWidth("100%");
	tree.setHeight("100%");
	TreeItem administracion = new TreeItem(imageItemHTML(images.treeLeaf(), "Administraci\u00f3n"));
	TreeItem procesos = new TreeItem(imageItemHTML(images.treeLeaf(), "Procesos y tareas"));
	tree.addItem(administracion);
	tree.addItem(procesos);
	addImageItem(administracion, "Unidades de Negocio", images.Building22());
	addImageItem(administracion, "Usuarios", images.User22());
	addImageItem(administracion, "Perfiles", images.Profiles());

	administracion.setState(true);
	procesos.setState(true);

	tree.addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> item) {

		if (item.getSelectedItem().getText().contains("Grupos resolutores")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("resolveGroupMaintainer"));

		}
		if (item.getSelectedItem().getText().contains("Unidades de Negocio")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("businessGroupMaintainer"));

		}
		if (item.getSelectedItem().getText().contains("Usuarios")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("userMaintainer"));

		}
		if (item.getSelectedItem().getText().contains("Perfiles")) {

		    clientFactory.getPlaceController().goTo(new RootPlace("profilesMaintainer"));

		}

	    }
	});

	return tree;
    }

    /**
     * A helper method to simplify adding tree items that have attached images.
     * {@link #addImageItem(TreeItem, String, ImageResource) code}
     * 
     * @param root
     *            the tree item to which the new item will be added.
     * @param title
     *            the text associated with this item.
     */
    private TreeItem addImageItem(TreeItem root, String title, ImageResource imageProto) {
	TreeItem item = new TreeItem(imageItemHTML(imageProto, title));

	root.addItem(item);
	return item;
    }

    /**
     * Generates HTML for a tree item with an attached icon.
     * 
     * @param imageProto
     *            the image prototype to use
     * @param title
     *            the title of the item
     * @return the resultant HTML
     */
    private String imageItemHTML(ImageResource imageProto, String title) {
	return AbstractImagePrototype.create(imageProto).getHTML() + " " + title;
    }

    private Widget createHeaderWidget(String text) {
	// Add the image and text to a horizontal panel
	HorizontalPanel hPanel = new HorizontalPanel();
	hPanel.setHeight("20px");
	hPanel.setSpacing(0);
	hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	HTML headerText = new HTML(text);
	headerText.setStyleName("cw-StackPanelHeader");
	hPanel.add(headerText);
	hPanel.setStyleName("panel-StackPanelHeader");
	return new SimplePanel(hPanel);
    }

}
