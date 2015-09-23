package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.rhiscom.cuadratura.files.manager.ARQTFManager;

public class ARQTFTest {

	
	@Test
	public void obtenerARQTFPorFechaYSucursal() {

		ARQTFManager manager = new ARQTFManager();
		@SuppressWarnings("deprecation")
		Date date = new Date(2013 - 1900, 0, 3);
		Assert.assertNotNull(manager.obtenerARQTFPorFechaYSucursal(date, "905"));
	}
}
