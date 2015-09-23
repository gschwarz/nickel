package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ProcessWidget_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.rhiscom.bpm.console.client.ui.process.ProcessWidget>, com.rhiscom.bpm.console.client.ui.process.ProcessWidget.Binder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.rhiscom.bpm.console.client.ui.process.ProcessWidget owner) {

    com.rhiscom.bpm.console.client.ui.process.ProcessWidget_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.rhiscom.bpm.console.client.ui.process.ProcessWidget_BinderImpl_GenBundle) GWT.create(com.rhiscom.bpm.console.client.ui.process.ProcessWidget_BinderImpl_GenBundle.class);
    com.rhiscom.bpm.console.client.ui.process.ProcessWidget_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.Image f_Image3 = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    com.google.gwt.user.client.ui.Label processName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_HorizontalPanel2.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    f_Image3.setWidth("28px");
    f_Image3.setUrl("img/ProcessAdd.png");
    f_Image3.setHeight("28px");
    f_HorizontalPanel2.add(f_Image3);
    processName.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    processName.setWidth("150px");
    processName.setText("Process Name");
    processName.setHeight("70px");
    f_HorizontalPanel2.add(processName);
    f_HorizontalPanel2.setStyleName("" + style.panel() + "");
    f_HorizontalPanel2.setWidth("213px");
    f_HorizontalPanel2.setHeight("70px");
    f_VerticalPanel1.add(f_HorizontalPanel2);



    owner.processName = processName;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
