package com.rhiscom.bpm.console.client.ui.administration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class UserMaintainerCellTableViewImpl_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl_BinderImpl_GenBundle {
  private static UserMaintainerCellTableViewImpl_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new UserMaintainerCellTableViewImpl_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MAN{font-weight:" + ("bold")  + ";}.MNM{height:" + ("100%")  + ";width:" + ("100%")  + ";border:" + ("0"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("right")  + ";padding:" + ("5px")  + ";}.MCN{border:" + ("0")  + ";}.MPM{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";}.MBN{background-color:" + ("#ff2828")  + ";font-size:" + ("11px")  + ";color:") + (("black")  + ";font-weight:" + ("bold")  + ";border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";height:" + ("30px")  + ";vertical-align:" + ("middle")  + ";}.MNM tbody tr{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";height:" + ("25px")  + ";}.MNM tbody td{border:" + ("0"+ " " +"solid"+ " " +"#ccc")  + ";}.MNM thead{height:" + ("30px")  + ";}.MEN{margin-left:" + ("5px")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#e8e8e8") ) + (";}.MDN{background-color:" + ("#628cd5")  + " !important;}.MOM{width:" + ("90px")  + ";padding:" + ("1px")  + ";background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-left:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-top:" + ("0")  + ";border-right:" + ("0")  + ";font-size:" + ("12px")  + ";color:") + (("black")  + ";padding-right:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-right:" + ("10px")  + ";margin-left:" + ("10px")  + ";outline-width:" + ("0")  + ";}.MOM:hover{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px")  + ";background-color:" + ("#f5f5f0")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#aaa") ) + (";border-left:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";border-top:" + ("0")  + ";border-right:" + ("0")  + ";font-size:" + ("12px")  + ";color:" + ("black")  + ";padding-right:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-right:" + ("10px")  + ";margin-left:" + ("10px")  + ";outline-width:") + (("0")  + ";}")) : ((".MAN{font-weight:" + ("bold")  + ";}.MNM{height:" + ("100%")  + ";width:" + ("100%")  + ";border:" + ("0"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("left")  + ";padding:" + ("5px")  + ";}.MCN{border:" + ("0")  + ";}.MPM{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";}.MBN{background-color:" + ("#ff2828")  + ";font-size:" + ("11px")  + ";color:") + (("black")  + ";font-weight:" + ("bold")  + ";border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";height:" + ("30px")  + ";vertical-align:" + ("middle")  + ";}.MNM tbody tr{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";height:" + ("25px")  + ";}.MNM tbody td{border:" + ("0"+ " " +"solid"+ " " +"#ccc")  + ";}.MNM thead{height:" + ("30px")  + ";}.MEN{margin-right:" + ("5px")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#e8e8e8") ) + (";}.MDN{background-color:" + ("#628cd5")  + " !important;}.MOM{width:" + ("90px")  + ";padding:" + ("1px")  + ";background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-right:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-top:" + ("0")  + ";border-left:" + ("0")  + ";font-size:" + ("12px")  + ";color:") + (("black")  + ";padding-left:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-left:" + ("10px")  + ";margin-right:" + ("10px")  + ";outline-width:" + ("0")  + ";}.MOM:hover{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px")  + ";background-color:" + ("#f5f5f0")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#aaa") ) + (";border-right:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";border-top:" + ("0")  + ";border-left:" + ("0")  + ";font-size:" + ("12px")  + ";color:" + ("black")  + ";padding-left:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-left:" + ("10px")  + ";margin-right:" + ("10px")  + ";outline-width:") + (("0")  + ";}"));
      }
      public java.lang.String cellTable(){
        return "MNM";
      }
      public java.lang.String gwtMenuItem(){
        return "MOM";
      }
      public java.lang.String headerH2(){
        return "MPM";
      }
      public java.lang.String important(){
        return "MAN";
      }
      public java.lang.String lblError(){
        return "MBN";
      }
      public java.lang.String messagePanel(){
        return "MCN";
      }
      public java.lang.String redBackground(){
        return "MDN";
      }
      public java.lang.String rightHorizontalPanel(){
        return "MEN";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl_BinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.administration.UserMaintainerCellTableViewImpl_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
