package com.rhiscom.bpm.console.client.ui.bam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.rhiscom.bpm.console.client.remote.ReportService;
import com.rhiscom.bpm.console.client.remote.ReportServiceAsync;
import com.rhiscom.bpm.console.shared.model.dto.ProjectDTO;
import com.rhiscom.bpm.console.shared.model.dto.ReportDTO;

public class ReportViewImpl extends Composite implements ReportView {

    private static final Binder binder = GWT.create(Binder.class);
    @UiField(provided = true)
    ListBox lstReport;
    @UiField(provided = true)
    ListBox lstProjects;
    @UiField
    Button btnGenerarReporte;
    @UiField
    Frame frameReport;
    @UiField
    DateBox initDate;
    @UiField
    DateBox endDate;

    Date init;
    Date end;
    DateTimeFormat fmtDate = DateTimeFormat.getFormat("yyyy/MM/dd");

    interface Binder extends UiBinder<Widget, ReportViewImpl> {
    }

    final ReportServiceAsync reportService = GWT.create(ReportService.class);
    private static final String urlReport = "reportServer";

    /**
     * 
     */
    public ReportViewImpl() {

	List<ReportDTO> reportList = new ArrayList<ReportDTO>();

	ReportDTO report = new ReportDTO();
	report.setName("Detalle de ejecuci\u00f3n");
	report.setDesc("Detalle de procesos en ejecuci\u00f3n");
	report.setId(new Long(1));
	report.setCode("basicReport.jasper");

	reportList.add(report);

	lstReport = new ListBox();
	lstProjects = new ListBox();
	lstReport.addItem("--Seleccione--", "-1");
	lstProjects.addItem("--Seleccione--", "-1");

	for (int i = 0; i <= reportList.size() - 1; i++) {
	    lstReport.addItem(reportList.get(i).getName(), reportList.get(i).getCode());
	}

	initWidget(binder.createAndBindUi(this));
	getAllATNPlans();
	initDate.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("MMMM dd, yyyy")));
	initDate.getDatePicker().setWidth("170px");
	initDate.addValueChangeHandler(new ValueChangeHandler<Date>() {

	    public void onValueChange(ValueChangeEvent<Date> event) {

	    }

	});

	endDate.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("MMMM dd, yyyy")));
	endDate.getDatePicker().setWidth("170px");
	endDate.addValueChangeHandler(new ValueChangeHandler<Date>() {

	    public void onValueChange(ValueChangeEvent<Date> event) {

	    }

	});

    }

    @Override
    public void setPresenter(Presenter presenter) {
	// TODO Auto-generated method stub

    }

    private void getAllATNPlans() {
	try {

	    reportService.getAllPlansATN(new AsyncCallback<List<ProjectDTO>>() {

		@Override
		public void onFailure(Throwable arg0) {

		}

		@Override
		public void onSuccess(List<ProjectDTO> list) {
		    if (list != null && list.size() > 0) {
			for (int i = 0; i <= list.size() - 1; i++) {
			    lstProjects.addItem(list.get(i).getName(), String.valueOf(list.get(i).getProjectID()));

			}
		    }
		}
	    });
	} catch (Exception ex) {
	}

	// TODO Auto-generated method stub

    }

    @UiHandler("btnGenerarReporte")
    void onClickGenerarReporte(ClickEvent e) {
	init = initDate.getValue();
	end = endDate.getValue();
	String reportId = lstReport.getValue(lstReport.getSelectedIndex());
	if (reportId.compareToIgnoreCase("-1") != 0)
	    frameReport.setUrl(urlReport + "?initDate=" + fmtDate.format(init) + "&endDate=" + fmtDate.format(end)
		    + "&resourceName=" + reportId);
    }
}
