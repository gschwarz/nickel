package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class DashBoardHomeViewImpl_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.DashBoardHomeViewImpl>, com.rhiscom.bpm.console.client.ui.DashBoardHomeViewImpl.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.DashBoardHomeViewImpl owner) {

    com.rhiscom.bpm.console.client.ui.DashBoardHomeViewImpl_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.DashBoardHomeViewImpl_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.DashBoardHomeViewImpl_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.DashBoardHomeViewImpl_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);

    f_FlowPanel1.setStyleName("" + style.panel() + "");
    f_FlowPanel1.setWidth("99%");
    f_FlowPanel1.setHeight("100%");



    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_FlowPanel1;
  }
}
