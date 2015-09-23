package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resource_en_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.process.Resource {
  private static Resource_en_StaticClientBundleGenerator _instance0 = new Resource_en_StaticClientBundleGenerator();
  private void ProcessAcceptInitializer() {
    ProcessAccept = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "ProcessAccept",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(bundledImage_None),
      0, 0, 32, 32, false, false
    );
  }
  private static class ProcessAcceptInitializer {
    static {
      _instance0.ProcessAcceptInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return ProcessAccept;
    }
  }
  public com.google.gwt.resources.client.ImageResource ProcessAccept() {
    return ProcessAcceptInitializer.get();
  }
  private void ProcessAddInitializer() {
    ProcessAdd = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "ProcessAdd",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(bundledImage_None),
      32, 0, 28, 28, false, false
    );
  }
  private static class ProcessAddInitializer {
    static {
      _instance0.ProcessAddInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return ProcessAdd;
    }
  }
  public com.google.gwt.resources.client.ImageResource ProcessAdd() {
    return ProcessAddInitializer.get();
  }
  private void cssInitializer() {
    css = new com.rhiscom.bpm.console.client.ui.process.Resource.Css() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MMI{border:" + ("1px"+ " " +"solid"+ " " +"#ffe45c")  + ";}.MNI{background-color:" + ("#c1defd")  + ";}.MOI{height:" + ("100px")  + ";text-align:" + ("right")  + ";width:" + ("200px")  + ";margin:" + ("10px")  + ";overflow:" + ("auto")  + ";}")) : ((".MMI{border:" + ("1px"+ " " +"solid"+ " " +"#ffe45c")  + ";}.MNI{background-color:" + ("#c1defd")  + ";}.MOI{height:" + ("100px")  + ";text-align:" + ("left")  + ";width:" + ("200px")  + ";margin:" + ("10px")  + ";overflow:" + ("auto")  + ";}"));
      }
      public java.lang.String dragHover(){
        return "MLI";
      }
      public java.lang.String droppableActive(){
        return "MMI";
      }
      public java.lang.String droppableHover(){
        return "MNI";
      }
      public java.lang.String exportCellList(){
        return "MOI";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.process.Resource.Css get() {
      return css;
    }
  }
  public com.rhiscom.bpm.console.client.ui.process.Resource.Css css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseURL() + "C02A743489DF4EFDFFBFC93B7AC69CBB.cache.png";
  private static com.google.gwt.resources.client.ImageResource ProcessAccept;
  private static com.google.gwt.resources.client.ImageResource ProcessAdd;
  private static com.rhiscom.bpm.console.client.ui.process.Resource.Css css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      ProcessAccept(), 
      ProcessAdd(), 
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("ProcessAccept", ProcessAccept());
        resourceMap.put("ProcessAdd", ProcessAdd());
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'ProcessAccept': return this.@com.rhiscom.bpm.console.client.ui.process.Resource::ProcessAccept()();
      case 'ProcessAdd': return this.@com.rhiscom.bpm.console.client.ui.process.Resource::ProcessAdd()();
      case 'css': return this.@com.rhiscom.bpm.console.client.ui.process.Resource::css()();
    }
    return null;
  }-*/;
}
