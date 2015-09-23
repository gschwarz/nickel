package com.rhiscom.bpm.console.client.ui.task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenBundle_default_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenBundle {
  private static AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MEY{font-weight:" + ("bold")  + ";}.MHY{height:" + ("280px")  + " !important;}.MOX{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";}.MBY{position:" + ("static")  + ";}.MAY{background-color:" + ("#f5f5f5")  + ";border-top:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";bottom:" + ("0")  + ";right:" + ("0")  + ";padding-right:" + ("3px")  + ";padding-left:" + ("3px")  + ";}.MPX{height:") + (("100%")  + ";width:" + ("100%")  + ";border:" + ("0"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("right")  + ";padding:" + ("5px")  + ";}.MDY{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";}.MPX tbody tr{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";height:" + ("25px")  + ";}.MPX td{border:" + ("0"+ " " +"solid"+ " " +"#ccc")  + ";font-size:" + ("10px")  + ";}.MPX thead{height:" + ("30px") ) + (";}.MGY{margin-left:" + ("5px")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#e8e8e8")  + ";}.MFY{background-color:" + ("#628cd5")  + " !important;}.MCY{width:" + ("90px")  + ";padding:" + ("1px")  + ";background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-left:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-top:" + ("0")  + ";border-right:") + (("0")  + ";font-size:" + ("12px")  + ";color:" + ("black")  + ";padding-right:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-right:" + ("10px")  + ";margin-left:" + ("10px")  + ";outline-width:" + ("0")  + ";}.MCY:hover{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px") ) + (";background-color:" + ("#f5f5f0")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";border-left:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";border-top:" + ("0")  + ";border-right:" + ("0")  + ";font-size:" + ("12px")  + ";color:" + ("black")  + ";padding-right:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-right:") + (("10px")  + ";margin-left:" + ("10px")  + ";outline-width:" + ("0")  + ";}")) : ((".MEY{font-weight:" + ("bold")  + ";}.MHY{height:" + ("280px")  + " !important;}.MOX{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";}.MBY{position:" + ("static")  + ";}.MAY{background-color:" + ("#f5f5f5")  + ";border-top:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";bottom:" + ("0")  + ";left:" + ("0")  + ";padding-left:" + ("3px")  + ";padding-right:" + ("3px")  + ";}.MPX{height:") + (("100%")  + ";width:" + ("100%")  + ";border:" + ("0"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("left")  + ";padding:" + ("5px")  + ";}.MDY{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";}.MPX tbody tr{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";height:" + ("25px")  + ";}.MPX td{border:" + ("0"+ " " +"solid"+ " " +"#ccc")  + ";font-size:" + ("10px")  + ";}.MPX thead{height:" + ("30px") ) + (";}.MGY{margin-right:" + ("5px")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#e8e8e8")  + ";}.MFY{background-color:" + ("#628cd5")  + " !important;}.MCY{width:" + ("90px")  + ";padding:" + ("1px")  + ";background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-right:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-top:" + ("0")  + ";border-left:") + (("0")  + ";font-size:" + ("12px")  + ";color:" + ("black")  + ";padding-left:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-left:" + ("10px")  + ";margin-right:" + ("10px")  + ";outline-width:" + ("0")  + ";}.MCY:hover{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px") ) + (";background-color:" + ("#f5f5f0")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";border-right:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";border-top:" + ("0")  + ";border-left:" + ("0")  + ";font-size:" + ("12px")  + ";color:" + ("black")  + ";padding-left:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-left:") + (("10px")  + ";margin-right:" + ("10px")  + ";outline-width:" + ("0")  + ";}"));
      }
      public java.lang.String borderBottom(){
        return "MOX";
      }
      public java.lang.String cellTable(){
        return "MPX";
      }
      public java.lang.String detailPanel(){
        return "MAY";
      }
      public java.lang.String divContent(){
        return "MBY";
      }
      public java.lang.String gwtMenuItem(){
        return "MCY";
      }
      public java.lang.String headerH2(){
        return "MDY";
      }
      public java.lang.String important(){
        return "MEY";
      }
      public java.lang.String redBackground(){
        return "MFY";
      }
      public java.lang.String rightHorizontalPanel(){
        return "MGY";
      }
      public java.lang.String simplePanel(){
        return "MHY";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.task.AsignedTaskConsoleCellTableViewImp_AsignedTaskConsoleCellTableViewImpUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
