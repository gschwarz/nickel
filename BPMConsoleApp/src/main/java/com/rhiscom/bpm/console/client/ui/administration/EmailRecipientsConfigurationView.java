package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface EmailRecipientsConfigurationView extends IsWidget {
    public static final String viewCode = "madm_fnemailrecipients";

    void setPresenter(Presenter presenter);

    public interface Presenter {

	void goTo(Place place);

	void onLinkClicked();
    }

}