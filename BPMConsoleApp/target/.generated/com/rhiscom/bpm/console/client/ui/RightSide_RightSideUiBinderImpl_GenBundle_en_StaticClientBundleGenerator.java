package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class RightSide_RightSideUiBinderImpl_GenBundle_en_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.RightSide_RightSideUiBinderImpl_GenBundle {
  private static RightSide_RightSideUiBinderImpl_GenBundle_en_StaticClientBundleGenerator _instance0 = new RightSide_RightSideUiBinderImpl_GenBundle_en_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.RightSide_RightSideUiBinderImpl_GenCss_style() {
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
        return (".MPI{font-weight:" + ("bold")  + ";}");
      }
      public java.lang.String important(){
        return "MPI";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.RightSide_RightSideUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.RightSide_RightSideUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.RightSide_RightSideUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.RightSide_RightSideUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}