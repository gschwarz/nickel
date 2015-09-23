package com.rhiscom.bpm.console.client.ui.task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ViewTaskHTMLRenderDialog_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.task.ViewTaskHTMLRenderDialog_BinderImpl_GenBundle {
  private static ViewTaskHTMLRenderDialog_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new ViewTaskHTMLRenderDialog_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.task.ViewTaskHTMLRenderDialog_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MG2{paddign:" + ("50px")  + ";}.MG2 td{height:" + ("20px")  + " !important;}.MF2{margin-top:" + ("10px")  + ";left:" + ("0")  + ";float:" + ("left")  + ";margin-left:" + ("2px")  + ";}.ME2{margin-top:" + ("10px")  + ";right:" + ("0")  + ";float:" + ("right")  + ";margin-right:" + ("2px")  + ";}.MH2{height:") + (("20px")  + " !important;vertical-align:" + ("top")  + ";}")) : ((".MG2{paddign:" + ("50px")  + ";}.MG2 td{height:" + ("20px")  + " !important;}.MF2{margin-top:" + ("10px")  + ";right:" + ("0")  + ";float:" + ("right")  + ";margin-right:" + ("2px")  + ";}.ME2{margin-top:" + ("10px")  + ";left:" + ("0")  + ";float:" + ("left")  + ";margin-left:" + ("2px")  + ";}.MH2{height:") + (("20px")  + " !important;vertical-align:" + ("top")  + ";}"));
      }
      public java.lang.String alignLeft(){
        return "ME2";
      }
      public java.lang.String alignRight(){
        return "MF2";
      }
      public java.lang.String panel(){
        return "MG2";
      }
      public java.lang.String td(){
        return "MH2";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.task.ViewTaskHTMLRenderDialog_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.task.ViewTaskHTMLRenderDialog_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.task.ViewTaskHTMLRenderDialog_BinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.task.ViewTaskHTMLRenderDialog_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
