package com.rhiscom.bpm.console.client.ui.bam;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface ReportView extends IsWidget {
    public static final String viewCode = "mrpt_fnbam";

    void setPresenter(Presenter presenter);

    public interface Presenter {

	void goTo(Place place);

	void onLinkClicked();
    }

}
