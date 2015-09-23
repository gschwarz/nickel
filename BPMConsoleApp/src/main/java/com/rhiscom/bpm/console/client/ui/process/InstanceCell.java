package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.rhiscom.bpm.console.shared.model.rs.InstancesRS;

public class InstanceCell extends AbstractCell<InstancesRS> {
    private final String imageHtml;

    public InstanceCell(ImageResource image) {
	this.imageHtml = AbstractImagePrototype.create(image).getHTML();
    }

    @Override
    public void render(com.google.gwt.cell.client.Cell.Context context, InstancesRS value, SafeHtmlBuilder sb) {

	String status;

	if (value.getSuspended().compareToIgnoreCase("false") == 0)
	    status = "En Ejecuci\u00f3n";
	else
	    status = "Detenido";
	sb.appendHtmlConstant("<table style='margin: 1px; border: 1px solid #c5c5c5;' width='270'>");
	sb.appendHtmlConstant("<tr><td rowspan='3'>");
	sb.appendHtmlConstant(imageHtml);
	sb.appendHtmlConstant("</td></tr>");
	// Add the contact image.
	sb.appendHtmlConstant("<tr><td>&nbsp</td><td width='250'>Instancia :" + value.getId() + " -- " + status
		+ "</td></tr>");

	// Add the name and address.
	sb.appendHtmlConstant("<tr><td>&nbsp</td><td width='250' style='font-size:80%;'>");
	sb.appendEscaped("Inicio :" + value.getStartDate());
	sb.appendHtmlConstant("</td></tr></table>");

    }
}
