package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenBundle_en_InlineClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenBundle {
  private static CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenBundle_en_InlineClientBundleGenerator _instance0 = new CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenBundle_en_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MLJ{font-weight:" + ("bold")  + ";}.MKJ{height:" + ("100%")  + ";width:" + ("100%")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("right")  + ";}.MKJ thead{height:" + ("30px")  + ";}.MMJ{margin-left:" + ("5px")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#e8e8e8")  + ";}")) : ((".MLJ{font-weight:" + ("bold")  + ";}.MKJ{height:" + ("100%")  + ";width:" + ("100%")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("left")  + ";}.MKJ thead{height:" + ("30px")  + ";}.MMJ{margin-right:" + ("5px")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#e8e8e8")  + ";}"));
      }
      public java.lang.String cellTable(){
        return "MKJ";
      }
      public java.lang.String important(){
        return "MLJ";
      }
      public java.lang.String rightHorizontalPanel(){
        return "MMJ";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.CellTableEstadoTiendaViewImpl_CellTableEstadoTiendaImplUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
