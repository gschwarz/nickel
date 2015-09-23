package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface ProcessSchedulerView extends IsWidget {
    static final String viewCode = "mproc_fnprocscheduler";

    void setPresenter(Presenter presenter);

    public interface Presenter {

	void goTo(Place place);

	void onLinkClicked();
    }

}