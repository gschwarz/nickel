package com.rhiscom.cuadratura.base.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public abstract class BaseManager {

	protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected SimpleDateFormat readerFormatter = new SimpleDateFormat("yyyyMMdd");
	static ResourceBundle rb = ResourceBundle.getBundle("ftpproperties");
	public static String FILE_DIRECTORY=rb.getString("fileDirectory");
	
	public abstract void readFile(Date fechaNegocio, String sucursal);
	
}
