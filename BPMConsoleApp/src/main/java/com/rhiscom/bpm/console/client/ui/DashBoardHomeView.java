package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface DashBoardHomeView extends IsWidget {
    void setPresenter(Presenter presenter);

    public interface Presenter {

	void goTo(Place place);

	void onLinkClicked();
    }

}
