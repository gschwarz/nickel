package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenBundle_es_CL_InlineClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenBundle {
  private static ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenBundle_es_CL_InlineClientBundleGenerator _instance0 = new ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenBundle_es_CL_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MCO{font-weight:" + ("bold")  + ";}.MPN{height:" + ("100%")  + ";width:" + ("100%")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("right")  + ";padding:" + ("5px")  + ";}.MPN thead{height:" + ("30px")  + ";}.MEO{margin-left:" + ("5px")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#e8e8e8")  + ";}.MDO{background-color:" + ("#628cd5")  + " !important;}.MFO{font-size:") + (("12px")  + ";color:" + ("#0b173b")  + ";font-weight:" + ("bold")  + ";}.MBO{width:" + ("90px")  + ";padding:" + ("1px")  + ";background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-left:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-top:" + ("0")  + ";border-right:" + ("0") ) + (";font-size:" + ("12px")  + ";color:" + ("black")  + ";padding-right:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-right:" + ("10px")  + ";margin-left:" + ("10px")  + ";outline-width:" + ("0")  + ";}.MBO:hover{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px")  + ";background-color:") + (("#f5f5f0")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";border-left:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";border-top:" + ("0")  + ";border-right:" + ("0")  + ";font-size:" + ("12px")  + ";color:" + ("black")  + ";padding-right:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-right:" + ("10px") ) + (";margin-left:" + ("10px")  + ";outline-width:" + ("0")  + ";}.MAO{border:" + ("1px"+ " " +"solid"+ " " +"#9a9a9a")  + ";}")) : ((".MCO{font-weight:" + ("bold")  + ";}.MPN{height:" + ("100%")  + ";width:" + ("100%")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("left")  + ";padding:" + ("5px")  + ";}.MPN thead{height:" + ("30px")  + ";}.MEO{margin-right:" + ("5px")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#e8e8e8")  + ";}.MDO{background-color:" + ("#628cd5")  + " !important;}.MFO{font-size:") + (("12px")  + ";color:" + ("#0b173b")  + ";font-weight:" + ("bold")  + ";}.MBO{width:" + ("90px")  + ";padding:" + ("1px")  + ";background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-right:" + ("1px"+ " " +"solid"+ " " +"#555")  + ";border-top:" + ("0")  + ";border-left:" + ("0") ) + (";font-size:" + ("12px")  + ";color:" + ("black")  + ";padding-left:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-left:" + ("10px")  + ";margin-right:" + ("10px")  + ";outline-width:" + ("0")  + ";}.MBO:hover{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";height:" + ("20px")  + ";background-color:") + (("#f5f5f0")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";border-right:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";border-top:" + ("0")  + ";border-left:" + ("0")  + ";font-size:" + ("12px")  + ";color:" + ("black")  + ";padding-left:" + ("6px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";margin-left:" + ("10px") ) + (";margin-right:" + ("10px")  + ";outline-width:" + ("0")  + ";}.MAO{border:" + ("1px"+ " " +"solid"+ " " +"#9a9a9a")  + ";}"));
      }
      public java.lang.String cellTable(){
        return "MPN";
      }
      public java.lang.String demoHr(){
        return "MAO";
      }
      public java.lang.String gwtMenuItem(){
        return "MBO";
      }
      public java.lang.String important(){
        return "MCO";
      }
      public java.lang.String redBackground(){
        return "MDO";
      }
      public java.lang.String rightHorizontalPanel(){
        return "MEO";
      }
      public java.lang.String title(){
        return "MFO";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.process.ProcessConsoleCellTableViewImpl_ProcessConsoleCellTableViewImplUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
