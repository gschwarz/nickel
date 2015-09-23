package com.rhiscom.bpm.console.client.ui.task;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface MonitoringTaskConsoleCellTableView extends IsWidget {
    public static final String viewCode = "mtskmng_fntsk";

    void setPresenter(Presenter presenter);

    public interface Presenter {

	void goTo(Place place);

	void onLinkClicked();
    }

}
