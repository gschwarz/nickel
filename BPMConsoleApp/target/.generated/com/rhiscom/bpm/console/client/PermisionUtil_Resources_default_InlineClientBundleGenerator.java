package com.rhiscom.bpm.console.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class PermisionUtil_Resources_default_InlineClientBundleGenerator implements com.rhiscom.bpm.console.client.PermisionUtil.Resources {
  private static PermisionUtil_Resources_default_InlineClientBundleGenerator _instance0 = new PermisionUtil_Resources_default_InlineClientBundleGenerator();
  private void viewsInitializer() {
    views = new com.google.gwt.resources.client.TextResource() {
      // file:/C:/Proyectos/cuadratura-sodimac/BPMConsoleApp/src/main/java/com/rhiscom/bpm/console/client/views.properties
      public String getText() {
        return "mproc_fnproc,mtskmng_fnaut,mtskmng_fntsk,madm_fnbng,madm_fnusr,madm_fnwkg,madm_fnprf,madm_fnbunit,mrpt_fnbam,mrpt_fnbamdash,mrpt_fnbamdashatn,mngproc_fnprocmng,mproc_fnprocscheduler,madm_fnemail,madm_fnemailrecipients,madm_deletedata,cuad_rptgeoposebs,mrpt_cuadvtacmr,mrpt_cuadactgiftcard,madm_fnposversion,madm_posversion,mrpt_cuadpagoscmr,mrpt_cuadvtagiftcard,mrpt_cuadavancesuperavance,mrpt_cuadtarjetacredito,mrpt_cuadnotacredito,mrpt_cuadtarjetadebito";
      }
      public String getName() {
        return "views";
      }
    }
    ;
  }
  private static class viewsInitializer {
    static {
      _instance0.viewsInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return views;
    }
  }
  public com.google.gwt.resources.client.TextResource views() {
    return viewsInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource views;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      views(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("views", views());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'views': return this.@com.rhiscom.bpm.console.client.PermisionUtil.Resources::views()();
    }
    return null;
  }-*/;
}
