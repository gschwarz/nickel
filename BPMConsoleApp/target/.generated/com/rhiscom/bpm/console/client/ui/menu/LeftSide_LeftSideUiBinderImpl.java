package com.rhiscom.bpm.console.client.ui.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class LeftSide_LeftSideUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.menu.LeftSide>, com.rhiscom.bpm.console.client.ui.menu.LeftSide.LeftSideUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.menu.LeftSide owner) {

    com.rhiscom.bpm.console.client.ui.menu.LeftSide_LeftSideUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.menu.LeftSide_LeftSideUiBinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.menu.LeftSide_LeftSideUiBinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.menu.LeftSide_LeftSideUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.resources.client.ImageResource gradient = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.gradient();
    com.google.gwt.user.client.ui.StackLayoutPanel menuStackPanel = owner.menuStackPanel;
    com.google.gwt.user.client.ui.LayoutPanel f_LayoutPanel1 = (com.google.gwt.user.client.ui.LayoutPanel) GWT.create(com.google.gwt.user.client.ui.LayoutPanel.class);

    f_LayoutPanel1.add(menuStackPanel);
    f_LayoutPanel1.setWidgetTopBottom(menuStackPanel, 0, com.google.gwt.dom.client.Style.Unit.EM, 0, com.google.gwt.dom.client.Style.Unit.EM);
    f_LayoutPanel1.setWidth("100%");
    f_LayoutPanel1.setHeight("100%");



    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_LayoutPanel1;
  }
}
