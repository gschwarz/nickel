package com.rhiscom.bpm.console.client.ui.menu;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.CssResource.Import;

public interface LeftSide_LeftSideUiBinderImpl_GenBundle extends ClientBundle {
  @Source("uibinder:com.rhiscom.bpm.console.client.ui.menu.LeftSide_LeftSideUiBinderImpl_GenCss_style.css")
  LeftSide_LeftSideUiBinderImpl_GenCss_style style();

  @Source("gradient_bg_dark.png")
  @ImageOptions(repeatStyle=ImageResource.RepeatStyle.Horizontal)
  ImageResource gradient();
}
