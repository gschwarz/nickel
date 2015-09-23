package com.rhiscom.bpm.console.client.ui.quadrature;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface CuadraturaVtaCMRView extends IsWidget {
    static final String viewCode = "mrpt_cuadvtacmr";

    void setPresenter(Presenter presenter);

    public interface Presenter {

	void goTo(Place place);

	void onLinkClicked();
    }

}
