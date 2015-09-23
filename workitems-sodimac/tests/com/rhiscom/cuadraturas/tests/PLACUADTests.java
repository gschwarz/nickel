package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.rhiscom.cuadratura.files.manager.PLACUADManager;

public class PLACUADTests {

	@Test
	public void obtenerPLACUADPorFechaYSucursal() {

		PLACUADManager manager = new PLACUADManager();
		@SuppressWarnings("deprecation")
		Date date = new Date(2013 - 1900, 0, 3);
		Assert.assertNotNull(manager.obtenerPLACUADPorFechaYSucursal(date, "905"));
	}

}
