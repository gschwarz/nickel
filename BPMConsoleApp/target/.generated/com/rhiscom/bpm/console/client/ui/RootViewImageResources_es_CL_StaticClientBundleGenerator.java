package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class RootViewImageResources_es_CL_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.RootViewImageResources {
  private static RootViewImageResources_es_CL_StaticClientBundleGenerator _instance0 = new RootViewImageResources_es_CL_StaticClientBundleGenerator();
  private void getCloseIconInitializer() {
    getCloseIcon = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "getCloseIcon",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(bundledImage_None),
      0, 0, 32, 32, false, false
    );
  }
  private static class getCloseIconInitializer {
    static {
      _instance0.getCloseIconInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return getCloseIcon;
    }
  }
  public com.google.gwt.resources.client.ImageResource getCloseIcon() {
    return getCloseIconInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseURL() + "03C5652C71DA88CF15370BDB6B2FDD1A.cache.png";
  private static com.google.gwt.resources.client.ImageResource getCloseIcon;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      getCloseIcon(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("getCloseIcon", getCloseIcon());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'getCloseIcon': return this.@com.rhiscom.bpm.console.client.ui.RootViewImageResources::getCloseIcon()();
    }
    return null;
  }-*/;
}
