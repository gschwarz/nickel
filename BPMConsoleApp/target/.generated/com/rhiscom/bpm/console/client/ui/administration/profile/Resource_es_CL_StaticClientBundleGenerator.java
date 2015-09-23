package com.rhiscom.bpm.console.client.ui.administration.profile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resource_es_CL_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.administration.profile.Resource {
  private static Resource_es_CL_StaticClientBundleGenerator _instance0 = new Resource_es_CL_StaticClientBundleGenerator();
  private void cssInitializer() {
    css = new com.rhiscom.bpm.console.client.ui.administration.profile.Resource.Css() {
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
        return "css";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MGI{overflow:" + ("auto")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";height:" + ("400px")  + ";text-align:" + ("right")  + ";width:" + ("300px")  + ";margin:" + ("10px")  + ";}.MHI{border:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";width:" + ("200px")  + ";margin:" + ("10px")  + ";margin-left:" + ("50px")  + ";}.MFI{background-color:") + (("#c1defd")  + ";}.MEI{border:" + ("1px"+ " " +"solid"+ " " +"#9c9")  + ";background-color:" + ("#efe")  + ";padding:" + ("3px")  + ";}")) : ((".MGI{overflow:" + ("auto")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";height:" + ("400px")  + ";text-align:" + ("left")  + ";width:" + ("300px")  + ";margin:" + ("10px")  + ";}.MHI{border:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";width:" + ("200px")  + ";margin:" + ("10px")  + ";margin-right:" + ("50px")  + ";}.MFI{background-color:") + (("#c1defd")  + ";}.MEI{border:" + ("1px"+ " " +"solid"+ " " +"#9c9")  + ";background-color:" + ("#efe")  + ";padding:" + ("3px")  + ";}"));
      }
      public java.lang.String dragHelper(){
        return "MEI";
      }
      public java.lang.String droppableHover(){
        return "MFI";
      }
      public java.lang.String memberList(){
        return "MGI";
      }
      public java.lang.String permissionTree(){
        return "MHI";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.administration.profile.Resource.Css get() {
      return css;
    }
  }
  public com.rhiscom.bpm.console.client.ui.administration.profile.Resource.Css css() {
    return cssInitializer.get();
  }
  private void templatesInitializer() {
    templates = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "templates",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(bundledImage_None),
      0, 0, 16, 16, false, false
    );
  }
  private static class templatesInitializer {
    static {
      _instance0.templatesInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return templates;
    }
  }
  public com.google.gwt.resources.client.ImageResource templates() {
    return templatesInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.administration.profile.Resource.Css css;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseURL() + "29D81A38960CC3CC368575E9723C54E2.cache.png";
  private static com.google.gwt.resources.client.ImageResource templates;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
      templates(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
        resourceMap.put("templates", templates());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@com.rhiscom.bpm.console.client.ui.administration.profile.Resource::css()();
      case 'templates': return this.@com.rhiscom.bpm.console.client.ui.administration.profile.Resource::templates()();
    }
    return null;
  }-*/;
}
