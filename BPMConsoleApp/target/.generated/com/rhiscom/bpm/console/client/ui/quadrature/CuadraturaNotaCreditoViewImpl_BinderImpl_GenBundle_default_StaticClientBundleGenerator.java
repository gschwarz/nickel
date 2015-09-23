package com.rhiscom.bpm.console.client.ui.quadrature;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CuadraturaNotaCreditoViewImpl_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaNotaCreditoViewImpl_BinderImpl_GenBundle {
  private static CuadraturaNotaCreditoViewImpl_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new CuadraturaNotaCreditoViewImpl_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaNotaCreditoViewImpl_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MHS{padding:" + ("2px")  + ";}.MPR{border:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";-webkit-border-radius:" + ("5px")  + ";-moz-border-radius:" + ("5px")  + ";border-radius:" + ("5px")  + ";padding:" + ("10px")  + ";height:" + ("100%")  + ";margin:" + ("5px")  + ";}.MAS{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";}.MLS{font-size:" + ("1.1em")  + ";font-weight:") + (("bold")  + ";}.MJS{font-size:" + ("1em")  + ";font-weight:" + ("bold")  + ";}.MIS{font-size:" + ("1em")  + ";font-weight:" + ("bold")  + ";color:" + ("red")  + ";}.MMS{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";}.MNS{width:" + ("100%")  + ";height:" + ("100%")  + ";overflow:" + ("hidden")  + ";text-align:" + ("center") ) + (";margin-top:" + ("6px")  + ";}.MOR{padding-right:" + ("10px")  + ";}.MDS{padding-right:" + ("15px")  + ";}.MES{padding:" + ("15px")  + ";}.MFS{background-color:" + ("#ff2828")  + ";font-size:" + ("11px")  + ";color:" + ("black")  + ";font-weight:" + ("bold")  + ";border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";height:" + ("25px")  + ";}.datePickerDays{width:") + (("100%")  + ";background:" + ("#41ce47")  + ";}.datePickerDayIsWeekend{background:" + ("#41ce47")  + ";}.mismatchDay{background:" + ("#c80000")  + ";}.MKS th td{border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";}")) : ((".MHS{padding:" + ("2px")  + ";}.MPR{border:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";-webkit-border-radius:" + ("5px")  + ";-moz-border-radius:" + ("5px")  + ";border-radius:" + ("5px")  + ";padding:" + ("10px")  + ";height:" + ("100%")  + ";margin:" + ("5px")  + ";}.MAS{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#c5c5c5")  + ";}.MLS{font-size:" + ("1.1em")  + ";font-weight:") + (("bold")  + ";}.MJS{font-size:" + ("1em")  + ";font-weight:" + ("bold")  + ";}.MIS{font-size:" + ("1em")  + ";font-weight:" + ("bold")  + ";color:" + ("red")  + ";}.MMS{background:" + ("#d3def6"+ " " +"url(BPMConsoleApp/gwt/chrome/images/hborder.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + ";}.MNS{width:" + ("100%")  + ";height:" + ("100%")  + ";overflow:" + ("hidden")  + ";text-align:" + ("center") ) + (";margin-top:" + ("6px")  + ";}.MOR{padding-left:" + ("10px")  + ";}.MDS{padding-left:" + ("15px")  + ";}.MES{padding:" + ("15px")  + ";}.MFS{background-color:" + ("#ff2828")  + ";font-size:" + ("11px")  + ";color:" + ("black")  + ";font-weight:" + ("bold")  + ";border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";height:" + ("25px")  + ";}.datePickerDays{width:") + (("100%")  + ";background:" + ("#41ce47")  + ";}.datePickerDayIsWeekend{background:" + ("#41ce47")  + ";}.mismatchDay{background:" + ("#c80000")  + ";}.MKS th td{border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";}"));
      }
      public java.lang.String amounts(){
        return "MOR";
      }
      public java.lang.String borderDecorator(){
        return "MPR";
      }
      public java.lang.String borderSimple(){
        return "MAS";
      }
      public java.lang.String datePickerDayIsWeekend(){
        return "datePickerDayIsWeekend";
      }
      public java.lang.String datePickerDays(){
        return "datePickerDays";
      }
      public java.lang.String filters(){
        return "MDS";
      }
      public java.lang.String grid(){
        return "MES";
      }
      public java.lang.String lblError(){
        return "MFS";
      }
      public java.lang.String mismatchDay(){
        return "mismatchDay";
      }
      public java.lang.String panel(){
        return "MHS";
      }
      public java.lang.String redTitle(){
        return "MIS";
      }
      public java.lang.String secondTitle(){
        return "MJS";
      }
      public java.lang.String tableUi(){
        return "MKS";
      }
      public java.lang.String title(){
        return "MLS";
      }
      public java.lang.String titleBackground(){
        return "MMS";
      }
      public java.lang.String titleBackgroundPosition(){
        return "MNS";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaNotaCreditoViewImpl_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaNotaCreditoViewImpl_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaNotaCreditoViewImpl_BinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.rhiscom.bpm.console.client.ui.quadrature.CuadraturaNotaCreditoViewImpl_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
