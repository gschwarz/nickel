package com.rhiscom.bpm.console.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class LoginImageResources_en_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.login.LoginImageResources {
  private static LoginImageResources_en_StaticClientBundleGenerator _instance0 = new LoginImageResources_en_StaticClientBundleGenerator();
  private void getLoadingIconInitializer() {
    getLoadingIcon = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "getLoadingIcon",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 66, 66, true, false
    );
  }
  private static class getLoadingIconInitializer {
    static {
      _instance0.getLoadingIconInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return getLoadingIcon;
    }
  }
  public com.google.gwt.resources.client.ImageResource getLoadingIcon() {
    return getLoadingIconInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = GWT.getModuleBaseURL() + "2F94CBB2C4CE4195DC548A76E92A2D1E.cache.gif";
  private static com.google.gwt.resources.client.ImageResource getLoadingIcon;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      getLoadingIcon(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("getLoadingIcon", getLoadingIcon());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'getLoadingIcon': return this.@com.rhiscom.bpm.console.client.ui.login.LoginImageResources::getLoadingIcon()();
    }
    return null;
  }-*/;
}
