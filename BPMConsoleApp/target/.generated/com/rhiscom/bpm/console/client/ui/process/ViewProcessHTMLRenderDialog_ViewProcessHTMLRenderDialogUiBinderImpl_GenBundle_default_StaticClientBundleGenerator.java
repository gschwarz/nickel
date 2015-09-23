package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenBundle_default_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenBundle {
  private static ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenCss_style() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "style";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MB2{paddign:" + ("50px")  + ";}.MB2 td{height:" + ("20px")  + " !important;}.MA2{margin-top:" + ("10px")  + ";left:" + ("0")  + ";float:" + ("left")  + ";margin-left:" + ("2px")  + ";}.MP1{margin-top:" + ("10px")  + ";right:" + ("0")  + ";float:" + ("right")  + ";margin-right:" + ("2px")  + ";}.MC2{height:") + (("20px")  + " !important;vertical-align:" + ("top")  + ";}")) : ((".MB2{paddign:" + ("50px")  + ";}.MB2 td{height:" + ("20px")  + " !important;}.MA2{margin-top:" + ("10px")  + ";right:" + ("0")  + ";float:" + ("right")  + ";margin-right:" + ("2px")  + ";}.MP1{margin-top:" + ("10px")  + ";left:" + ("0")  + ";float:" + ("left")  + ";margin-left:" + ("2px")  + ";}.MC2{height:") + (("20px")  + " !important;vertical-align:" + ("top")  + ";}"));
      }
      public java.lang.String alignLeft(){
        return "MP1";
      }
      public java.lang.String alignRight(){
        return "MA2";
      }
      public java.lang.String panel(){
        return "MB2";
      }
      public java.lang.String td(){
        return "MC2";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.process.ViewProcessHTMLRenderDialog_ViewProcessHTMLRenderDialogUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
