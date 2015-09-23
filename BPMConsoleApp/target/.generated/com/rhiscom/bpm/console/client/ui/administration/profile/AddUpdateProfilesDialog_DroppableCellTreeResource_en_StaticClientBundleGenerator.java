package com.rhiscom.bpm.console.client.ui.administration.profile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.administration.profile.AddUpdateProfilesDialog.DroppableCellTreeResource {
  private static AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator _instance0 = new AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator();
  private void cellTreeClosedItemInitializer() {
    cellTreeClosedItem = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTreeClosedItem",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_None_rtl : bundledImage_None),
      15, 0, 15, 15, false, false
    );
  }
  private static class cellTreeClosedItemInitializer {
    static {
      _instance0.cellTreeClosedItemInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTreeClosedItem;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTreeClosedItem() {
    return cellTreeClosedItemInitializer.get();
  }
  private void cellTreeLoadingInitializer() {
    cellTreeLoading = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTreeLoading",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?externalImage_rtl : externalImage),
      0, 0, 16, 16, true, false
    );
  }
  private static class cellTreeLoadingInitializer {
    static {
      _instance0.cellTreeLoadingInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTreeLoading;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTreeLoading() {
    return cellTreeLoadingInitializer.get();
  }
  private void cellTreeOpenItemInitializer() {
    cellTreeOpenItem = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTreeOpenItem",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_None_rtl : bundledImage_None),
      0, 0, 15, 15, false, false
    );
  }
  private static class cellTreeOpenItemInitializer {
    static {
      _instance0.cellTreeOpenItemInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTreeOpenItem;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTreeOpenItem() {
    return cellTreeOpenItemInitializer.get();
  }
  private void cellTreeSelectedBackgroundInitializer() {
    cellTreeSelectedBackground = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTreeSelectedBackground",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_Horizontal_rtl : bundledImage_Horizontal),
      0, 0, 82, 26, false, false
    );
  }
  private static class cellTreeSelectedBackgroundInitializer {
    static {
      _instance0.cellTreeSelectedBackgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTreeSelectedBackground;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTreeSelectedBackground() {
    return cellTreeSelectedBackgroundInitializer.get();
  }
  private void cellTreeStyleInitializer() {
    cellTreeStyle = new com.google.gwt.user.cellview.client.CellTree.Style() {
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
        return "cellTreeStyle";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".MEF{padding-right:" + ("16px")  + ";font-style:" + ("italic")  + ";}.MFF{padding-top:" + ("2px")  + ";padding-bottom:" + ("2px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";}.MIF{padding-right:" + ("2px")  + ";padding-left:" + ("2px")  + ";outline:" + ("none")  + ";}.MNF{font-weight:" + ("bold")  + ";color:") + (("#4b4a4a")  + ";padding:" + ("3px"+ " " +"5px"+ " " +"3px"+ " " +"7px")  + " !important;}.MOF{padding-top:" + ("15px")  + ";}.MPF{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#6f7277")  + ";}.MJF{background-color:" + ("#ffc")  + ";outline:" + ("none")  + ";}.MLF{height:" + ((AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator.this.cellTreeSelectedBackground()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator.this.cellTreeSelectedBackground()).getSafeUri().asString() + "\") -" + (AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator.this.cellTreeSelectedBackground()).getLeft() + "px -" + (AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator.this.cellTreeSelectedBackground()).getTop() + "px  repeat-x")  + ";background-color:" + ("#628cd5")  + ";color:" + ("white") ) + (";height:" + ("auto")  + ";overflow:" + ("visible")  + ";}.MMF{padding-right:" + ("10px")  + ";outline:" + ("none")  + ";}")) : ((".MEF{padding-left:" + ("16px")  + ";font-style:" + ("italic")  + ";}.MFF{padding-top:" + ("2px")  + ";padding-bottom:" + ("2px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";}.MIF{padding-left:" + ("2px")  + ";padding-right:" + ("2px")  + ";outline:" + ("none")  + ";}.MNF{font-weight:" + ("bold")  + ";color:") + (("#4b4a4a")  + ";padding:" + ("3px"+ " " +"7px"+ " " +"3px"+ " " +"5px")  + " !important;}.MOF{padding-top:" + ("15px")  + ";}.MPF{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#6f7277")  + ";}.MJF{background-color:" + ("#ffc")  + ";outline:" + ("none")  + ";}.MLF{height:" + ((AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator.this.cellTreeSelectedBackground()).getHeight() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator.this.cellTreeSelectedBackground()).getSafeUri().asString() + "\") -" + (AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator.this.cellTreeSelectedBackground()).getLeft() + "px -" + (AddUpdateProfilesDialog_DroppableCellTreeResource_en_StaticClientBundleGenerator.this.cellTreeSelectedBackground()).getTop() + "px  repeat-x")  + ";background-color:" + ("#628cd5")  + ";color:" + ("white") ) + (";height:" + ("auto")  + ";overflow:" + ("visible")  + ";}.MMF{padding-left:" + ("10px")  + ";outline:" + ("none")  + ";}"));
      }
      public java.lang.String cellTreeEmptyMessage(){
        return "MEF";
      }
      public java.lang.String cellTreeItem(){
        return "MFF";
      }
      public java.lang.String cellTreeItemImage(){
        return "MGF";
      }
      public java.lang.String cellTreeItemImageValue(){
        return "MHF";
      }
      public java.lang.String cellTreeItemValue(){
        return "MIF";
      }
      public java.lang.String cellTreeKeyboardSelectedItem(){
        return "MJF";
      }
      public java.lang.String cellTreeOpenItem(){
        return "MKF";
      }
      public java.lang.String cellTreeSelectedItem(){
        return "MLF";
      }
      public java.lang.String cellTreeShowMoreButton(){
        return "MMF";
      }
      public java.lang.String cellTreeTopItem(){
        return "MNF";
      }
      public java.lang.String cellTreeTopItemImage(){
        return "MOF";
      }
      public java.lang.String cellTreeTopItemImageValue(){
        return "MPF";
      }
      public java.lang.String cellTreeWidget(){
        return "MAG";
      }
    }
    ;
  }
  private static class cellTreeStyleInitializer {
    static {
      _instance0.cellTreeStyleInitializer();
    }
    static com.google.gwt.user.cellview.client.CellTree.Style get() {
      return cellTreeStyle;
    }
  }
  public com.google.gwt.user.cellview.client.CellTree.Style cellTreeStyle() {
    return cellTreeStyleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseURL() + "50A61AF816F970BE24D9D1313AE59069.cache.png";
  private static final java.lang.String bundledImage_None_rtl = GWT.getModuleBaseURL() + "1ED06C53E25AC3363D47D2C80EBD3385.cache.png";
  private static final java.lang.String bundledImage_Horizontal = GWT.getModuleBaseURL() + "CD15EC0BBF9CD57F9198FD5C1C37122E.cache.png";
  private static final java.lang.String bundledImage_Horizontal_rtl = GWT.getModuleBaseURL() + "9760B036C3B6E12FF6DEEDC917855221.cache.png";
  private static final java.lang.String externalImage = GWT.getModuleBaseURL() + "88223A47D6474241981BB15127C39196.cache.gif";
  private static final java.lang.String externalImage_rtl = GWT.getModuleBaseURL() + "5E838E9448E51A6F56321C950EB604A7.cache.png";
  private static com.google.gwt.resources.client.ImageResource cellTreeClosedItem;
  private static com.google.gwt.resources.client.ImageResource cellTreeLoading;
  private static com.google.gwt.resources.client.ImageResource cellTreeOpenItem;
  private static com.google.gwt.resources.client.ImageResource cellTreeSelectedBackground;
  private static com.google.gwt.user.cellview.client.CellTree.Style cellTreeStyle;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      cellTreeClosedItem(), 
      cellTreeLoading(), 
      cellTreeOpenItem(), 
      cellTreeSelectedBackground(), 
      cellTreeStyle(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("cellTreeClosedItem", cellTreeClosedItem());
        resourceMap.put("cellTreeLoading", cellTreeLoading());
        resourceMap.put("cellTreeOpenItem", cellTreeOpenItem());
        resourceMap.put("cellTreeSelectedBackground", cellTreeSelectedBackground());
        resourceMap.put("cellTreeStyle", cellTreeStyle());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'cellTreeClosedItem': return this.@com.google.gwt.user.cellview.client.CellTree.Resources::cellTreeClosedItem()();
      case 'cellTreeLoading': return this.@com.google.gwt.user.cellview.client.CellTree.Resources::cellTreeLoading()();
      case 'cellTreeOpenItem': return this.@com.google.gwt.user.cellview.client.CellTree.Resources::cellTreeOpenItem()();
      case 'cellTreeSelectedBackground': return this.@com.google.gwt.user.cellview.client.CellTree.Resources::cellTreeSelectedBackground()();
      case 'cellTreeStyle': return this.@com.rhiscom.bpm.console.client.ui.administration.profile.AddUpdateProfilesDialog.DroppableCellTreeResource::cellTreeStyle()();
    }
    return null;
  }-*/;
}
