package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface DeleteDataView extends IsWidget {
    public static final String viewCode = "madm_deletedata";

    void setPresenter(Presenter presenter);

    public interface Presenter {

	void goTo(Place place);

	void onLinkClicked();
    }

}