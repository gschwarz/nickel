package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface Resource extends ClientBundle {

    public interface Css extends CssResource {
	String dragHover();

	String droppableActive();

	String droppableHover();

	String exportCellList();

    }

    public Resource INSTANCE = GWT.create(Resource.class);

    @Source("style.css")
    public Css css();

    ImageResource ProcessAccept();

    ImageResource ProcessAdd();

}
