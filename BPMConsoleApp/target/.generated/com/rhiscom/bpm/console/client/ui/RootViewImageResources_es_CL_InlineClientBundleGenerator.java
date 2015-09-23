package com.rhiscom.bpm.console.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class RootViewImageResources_es_CL_InlineClientBundleGenerator implements com.rhiscom.bpm.console.client.ui.RootViewImageResources {
  private static RootViewImageResources_es_CL_InlineClientBundleGenerator _instance0 = new RootViewImageResources_es_CL_InlineClientBundleGenerator();
  private void getCloseIconInitializer() {
    getCloseIcon = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "getCloseIcon",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 32, 32, false, false
    );
  }
  private static class getCloseIconInitializer {
    static {
      _instance0.getCloseIconInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return getCloseIcon;
    }
  }
  public com.google.gwt.resources.client.ImageResource getCloseIcon() {
    return getCloseIconInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAENElEQVR42u1XW08TYRD1H/gDTExMfPXJFyvdLcGieOMmiCIqEgWvIREwMTzBo39BY2Iwiv4DxYIIsV6gtdvLdpduty3Ig/HBBDVpQjKeGXexoJSt+OADm0y22f1mzvlmzsx+3bZt69q6ylxjweD2kN/fNFZVtbNiX/iIL2L8FfgzVd31QlHyscFBwr04pqrtnsGxln0c3/xEdfXuysFVdcF+8IC+RiL0eXqaAy3jWdtGvryG17LPt1iMcg8fEsfimBWBZ+/epdzt26Q3N1P2xg36+PjxTxKK0rIuON7xmsUnT6jQ30+Zjg76ODxMHMsTCa4Xp0zAb90ivamJ9MZGSuOevXaNFsuQKAXPA9wCuHX2LFnnztHC0BBl792TcpTVxLiq1kdv3iR7YECA9YYGAU8jC8aJE5KJxdFR0UQpCQe8uPj0KeXhK8AOuNzPn6cFZCLa10eMsS4BFgsHSoB9pqdnZfcuAaO1lezeXuJd8jpWOdsqcIBm2QDqGpcj3d0tPhsK0lHwspC4fFkICHhLC5kgYJ48SXlkySlHUcCRlQJKZpUCd3aK8XMDm+GYnjvJJZHk9F258osAwM22Npo7dUpIcIewrQJ3gNnm/wZ8bTslQCJ79aqkf4XA6dOUaW8ni4EuXJA6Z0sI2HhWCu6lfcu2VZKDX78uBOZKCGTOnFlRe+nuV4GXadtKSBSTALDRBb8RcNTuEigBL24afC0JngVzjgYybhmcLEgJQIBnwD8FFwKBQC0CfhctsA7cUqwlAhJ59DqvZZ9/Ah5S1RoOmEBwGwTSGE4G5oOB2WA6rTnnELJAqAAC+qVLQuK5ogQ2Bc4BONA8PigswmRdHaUOH6b00aOUPnaMjOPHyQAhE4RMnhc8sGA8kNhnUyRc8MLIiEzFeCBA8ZoaShw4QKlgkPTaWtKZzJEjlMbdgOn4nQS5BO4W5sTCo0dCAmcDf6WHCb+AYxfpixcp6vORVlVFmt9PcUURMnZ3D9nISg6dkcOwSoJQAsQ03COwd/idwns3E55JjPv9e+GwlMdZQMNAebNvH83u308fmADANYBnMdfjaD8RG0xaFCQ0gDL4e9zDyNYULILsFX6SWMI03OOl5UK5+/dpBkFfYcdhVaX31dUURTAN6bcYHG3HwCJQp0NYpNwlMyhF+NAhmjp4kCZAJASfWZCw+UygKKNeCEzF0FZJ9PQkQKcR5A2CRRA4A3AN71zwP3WKhVkRrq+nSWhhAlqYhFBNEJtFl2DNHa/1L2ro73hXF01iN68BbmIXMTxbT9kuCS6NCV28BIkJmA7wKNoU7zTPB1Q+NMiHCMMljl2l0Ncx9PhGYnLFyyUyAJzC51xI4zgW8vl2VNYJ+HyGkUI+F3zAsBEReVCyQ2KJy6hhA/j9xZP4/jgFFaUT9glB3nJ3ePXjtfB7yXqCSH1b/7D+6+sHfCQiHOwcjqgAAAAASUVORK5CYII=";
  private static com.google.gwt.resources.client.ImageResource getCloseIcon;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      getCloseIcon(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("getCloseIcon", getCloseIcon());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'getCloseIcon': return this.@com.rhiscom.bpm.console.client.ui.RootViewImageResources::getCloseIcon()();
    }
    return null;
  }-*/;
}
