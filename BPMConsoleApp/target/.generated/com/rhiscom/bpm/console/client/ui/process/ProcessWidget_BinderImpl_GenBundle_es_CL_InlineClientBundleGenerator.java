package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ProcessWidget_BinderImpl_GenBundle_es_CL_InlineClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.process.ProcessWidget_BinderImpl_GenBundle {
  private static ProcessWidget_BinderImpl_GenBundle_es_CL_InlineClientBundleGenerator _instance0 = new ProcessWidget_BinderImpl_GenBundle_es_CL_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.process.ProcessWidget_BinderImpl_GenCss_style() {
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
        return (".MD2{border:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";background-color:" + ("#f5f5f5")  + ";-webkit-user-select:" + ("none")  + ";-khtml-user-select:" + ("none")  + ";-moz-user-select:" + ("none")  + ";-o-user-select:" + ("none")  + ";-ms-user-select:" + ("none")  + ";user-select:" + ("none")  + ";}.MD2:hover{background-color:" + ("#f5f5f5")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";}");
      }
      public java.lang.String panel(){
        return "MD2";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.process.ProcessWidget_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.process.ProcessWidget_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.process.ProcessWidget_BinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.process.ProcessWidget_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}