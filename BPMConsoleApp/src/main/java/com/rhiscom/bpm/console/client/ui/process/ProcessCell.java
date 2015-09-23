package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.rhiscom.bpm.console.shared.model.rs.DefinitionsRS;

public class ProcessCell extends AbstractCell<DefinitionsRS> {

    private final String imageHtml;

    public ProcessCell(ImageResource image) {
	this.imageHtml = AbstractImagePrototype.create(image).getHTML();

    }

    @Override
    public void render(com.google.gwt.cell.client.Cell.Context context, DefinitionsRS value, SafeHtmlBuilder sb) {
	if (value != null) {
	    // sb.appendEscaped(value.getName());
	}

	sb.appendHtmlConstant("<table>");

	// Add the contact image.
	sb.appendHtmlConstant("<tr><td rowspan='3'>");
	sb.appendHtmlConstant(imageHtml);
	sb.appendHtmlConstant("</td>");

	// Add the name and address.
	sb.appendHtmlConstant("<td style='font-size:95%;'>");
	sb.appendEscaped(value.getName());
	sb.appendHtmlConstant("</td></tr></table>");

    }

}
