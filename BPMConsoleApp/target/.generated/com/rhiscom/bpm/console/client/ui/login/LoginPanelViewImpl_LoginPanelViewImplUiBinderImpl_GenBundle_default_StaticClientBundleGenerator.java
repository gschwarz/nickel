package com.rhiscom.bpm.console.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenBundle_default_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenBundle {
  private static LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MKI{position:" + ("absolute")  + " !important;top:" + ("50%")  + " !important;right:" + ("50%")  + " !important;margin-top:" + ("-100px")  + " !important;margin-right:" + ("-200px")  + " !important;border:" + ("1px"+ " " +"solid"+ " " +"#c0c0c0")  + ";width:" + ("350px")  + ";height:" + ("190px")  + ";-webkit-border-radius:" + ("5px")  + ";-moz-border-radius:" + ("5px")  + ";border-radius:") + (("5px")  + ";background-color:" + ("#f8f8f8")  + " !important;color:" + ("#000")  + ";}.MJI{font-size:" + ("11px")  + ";color:" + ("#ff2828")  + ";font-weight:" + ("bold")  + ";height:" + ("25px")  + ";}.MII{margin-top:" + ("10px")  + ";left:" + ("0")  + ";float:" + ("left")  + ";margin-left:" + ("2px") ) + (";}")) : ((".MKI{position:" + ("absolute")  + " !important;top:" + ("50%")  + " !important;left:" + ("50%")  + " !important;margin-top:" + ("-100px")  + " !important;margin-left:" + ("-200px")  + " !important;border:" + ("1px"+ " " +"solid"+ " " +"#c0c0c0")  + ";width:" + ("350px")  + ";height:" + ("190px")  + ";-webkit-border-radius:" + ("5px")  + ";-moz-border-radius:" + ("5px")  + ";border-radius:") + (("5px")  + ";background-color:" + ("#f8f8f8")  + " !important;color:" + ("#000")  + ";}.MJI{font-size:" + ("11px")  + ";color:" + ("#ff2828")  + ";font-weight:" + ("bold")  + ";height:" + ("25px")  + ";}.MII{margin-top:" + ("10px")  + ";right:" + ("0")  + ";float:" + ("right")  + ";margin-right:" + ("2px") ) + (";}"));
      }
      public java.lang.String alignRight(){
        return "MII";
      }
      public java.lang.String lblError(){
        return "MJI";
      }
      public java.lang.String loginTable(){
        return "MKI";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.login.LoginPanelViewImpl_LoginPanelViewImplUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
