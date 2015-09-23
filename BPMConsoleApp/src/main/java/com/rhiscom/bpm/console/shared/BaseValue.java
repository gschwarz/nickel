package com.rhiscom.bpm.console.shared;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;

public class BaseValue implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    public String toString() {
	StringBuffer stringBuffer = new StringBuffer();
	try {
		
	    BeanInfo info = Introspector.getBeanInfo(this.getClass());
	    stringBuffer.append("[");
	    PropertyDescriptor[] props = info.getPropertyDescriptors();
	    for (int i = 0; i < props.length; i++) {
		PropertyDescriptor prop = props[i];
		if (!prop.getName().equals("class")) {
		    String data =  prop.getName() + " :" + prop.getReadMethod().invoke(this, null);
		    if (i < props.length - 1) {
			stringBuffer.append(data + " \r\n ");
		    }
		    if (i == props.length - 1) {
			stringBuffer.append(data);
		    }
		}
	    }
	    stringBuffer.append("]");
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return stringBuffer.toString();
    }

}
