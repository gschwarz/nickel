package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AddUpdateBusinessGroupDialog_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog_BinderImpl_GenBundle {
  private static AddUpdateBusinessGroupDialog_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new AddUpdateBusinessGroupDialog_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MM-{paddign:" + ("50px")  + ";}.MM- td{height:" + ("20px")  + " !important;}.MJ-{margin-top:" + ("10px")  + ";left:" + ("0")  + ";float:" + ("left")  + ";margin-left:" + ("2px")  + ";}.ML-{background-color:" + ("#ff2828")  + ";font-size:" + ("11px")  + ";color:" + ("black")  + ";font-weight:" + ("bold")  + ";border:") + (("1px"+ " " +"solid"+ " " +"black")  + ";height:" + ("25px")  + ";}.MI-{margin-top:" + ("10px")  + ";right:" + ("0")  + ";float:" + ("right")  + ";margin-right:" + ("2px")  + ";}.MN-{height:" + ("20px")  + " !important;vertical-align:" + ("top")  + ";}.MK-{margin-top:" + ("6px")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";-webkit-border-radius:" + ("5px") ) + (";-moz-border-radius:" + ("5px")  + ";border-radius:" + ("5px")  + ";padding:" + ("7px")  + ";}")) : ((".MM-{paddign:" + ("50px")  + ";}.MM- td{height:" + ("20px")  + " !important;}.MJ-{margin-top:" + ("10px")  + ";right:" + ("0")  + ";float:" + ("right")  + ";margin-right:" + ("2px")  + ";}.ML-{background-color:" + ("#ff2828")  + ";font-size:" + ("11px")  + ";color:" + ("black")  + ";font-weight:" + ("bold")  + ";border:") + (("1px"+ " " +"solid"+ " " +"black")  + ";height:" + ("25px")  + ";}.MI-{margin-top:" + ("10px")  + ";left:" + ("0")  + ";float:" + ("left")  + ";margin-left:" + ("2px")  + ";}.MN-{height:" + ("20px")  + " !important;vertical-align:" + ("top")  + ";}.MK-{margin-top:" + ("6px")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";-webkit-border-radius:" + ("5px") ) + (";-moz-border-radius:" + ("5px")  + ";border-radius:" + ("5px")  + ";padding:" + ("7px")  + ";}"));
      }
      public java.lang.String alignLeft(){
        return "MI-";
      }
      public java.lang.String alignRight(){
        return "MJ-";
      }
      public java.lang.String borderDecorator(){
        return "MK-";
      }
      public java.lang.String lblError(){
        return "ML-";
      }
      public java.lang.String panel(){
        return "MM-";
      }
      public java.lang.String td(){
        return "MN-";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog_BinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.administration.AddUpdateBusinessGroupDialog_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
