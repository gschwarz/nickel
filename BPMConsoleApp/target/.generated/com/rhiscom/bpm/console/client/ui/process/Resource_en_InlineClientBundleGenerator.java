package com.rhiscom.bpm.console.client.ui.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resource_en_InlineClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.process.Resource {
  private static Resource_en_InlineClientBundleGenerator _instance0 = new Resource_en_InlineClientBundleGenerator();
  private void ProcessAcceptInitializer() {
    ProcessAccept = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "ProcessAccept",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
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
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
      0, 0, 28, 28, false, false
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
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAADmUlEQVRYhb2XTWgkRRTHf6+6k5mezG5WYePnQoJxFTHiB3vw5IoHRcGDKAiCFy85eRLU64KIB3FXPO5RFvzAix7EizkokoiK8eAhIrhLzJiIO7rZZHYy3bWH7p55XV3dM7CSgqZTr1+993//96+qiTx0/pLEiZ2Xqcb9iBiLAIIJp7AIlhsfRgCbR7IAAyPyw48vzXbCQRzfbbBn75mbedwYMTeUyQIy3i1J7OC3zr+fPPxh9/Vw+5tPH33sxeUnNwczptuvCZLbNSXufEL7sQbTd92SPPvT6rcfGRO1IxMY0+2nLFmyt3Xm+k3FfEJ7tw+BkbDzxfuNkCSRAkJdrWt32agr2qoPfjIESHte8hnXx+qgxQxVcWTkHA5tklKUV5Ivtlm1kr2tdQIrbeTrtN4lm1jxYx8C0F8K7ItjdCMou9dFJ86A6gJCr1PNyNkb9ntMr30BdB6jP9QKT42C2Nx1Y5K7scOCXX0o6ABYXoTjTXj3V9iPi8eCV8QVR6h1nE2+oNBrKffx73/gqTvglUWIgvp+lz845pIGKKp3CMimiMXCx3/B9gq8fRpubcFbv6RMeE9HVUhBI+rv3K2sAUW7pitowMounFuD03MpE61AVeQ+TlzJiiyLUC0Q8cSS0RM24ecebFyGB4/CsdDBLqMkhcQOEG8LqhU1sp26Gd5cgv0r8MYadEyBQ9fdMymDCLXRVWg+bpqClxfg6dvgwjpcuAgHR/y+NRtgOGwdA8MjORPl8Wl49SQsteG9VfiyC7ad/cjIk1lVaF6MB4WP5AIA0e/McfcafH8Rzm7BTgOCKLUvtmHhiIrmJFzpwIEPhMNy4SDybe4e8NkOhC0IVL+fmYPnF8oJAPoxfN3Br6c8fkEDjKj3IZ5qUqL2nXU4890oUH6T5mfI7Bx+QeQ7w2oAahu6/qWNkU2aR9NHHL9SPq0VymyXrmPxINYZxItKdU+fdgpVqQgvgLpftROc85V+LljvNnQXTXrPa9C+O8H1ddxGGqhA6eIo6XRSZvBrLMSCtZZWAHuxk0X3MTfVacQHxGFIgCiExKb3XQiwdbnHfSciDhA/pRXbyauZqn9gnKp//2MfLITJ/n/x5vau3dy5Oq7b/+uwSZyATczexuqlZNDfPszkAMm1va2kv/enRPMPtKdPLD0RLZ56ARPOHEr2eHBld/2r87MnH1mT+eUPTG9zo9n5/FwLCA4FAMS3P/fa1ejOe3vXAYTFOB0D6lWQAAAAAElFTkSuQmCCOTc4";
  private static final java.lang.String externalImage0 = "data:image/png;base64,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";
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
