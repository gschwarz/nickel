package com.rhiscom.bpm.console.client.ui.bam;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class DashBoardBAMView_BinderImpl_GenBundle_es_CL_InlineClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.bam.DashBoardBAMView_BinderImpl_GenBundle {
  private static DashBoardBAMView_BinderImpl_GenBundle_es_CL_InlineClientBundleGenerator _instance0 = new DashBoardBAMView_BinderImpl_GenBundle_es_CL_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.bam.DashBoardBAMView_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MLN{height:" + ("100%")  + ";width:" + ("100%")  + ";border:" + ("0"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("right")  + ";padding:" + ("5px")  + ";}")) : ((".MLN{height:" + ("100%")  + ";width:" + ("100%")  + ";border:" + ("0"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("left")  + ";padding:" + ("5px")  + ";}"));
      }
      public java.lang.String cellTable(){
        return "MLN";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.bam.DashBoardBAMView_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.bam.DashBoardBAMView_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.bam.DashBoardBAMView_BinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.bam.DashBoardBAMView_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}