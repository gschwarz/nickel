package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.rhiscom.cuadratura.files.manager.PLGCManager;

public class PLGCManagerTest {

	@Test
	public void obtenerMontoSegunCodigoGiftYFuncion() {
		PLGCManager plgcManager = new PLGCManager();
		Date date = new Date(2013 - 1900, 0, 3);
		
	Assert.assertTrue(plgcManager.obtenerMontoSegunCodigoGiftYFuncion("5", "55", "905", date)>0);
	Assert.assertTrue(plgcManager.obtenerMontoSegunCodigoGiftYFuncion("5", "58", "905", date)>0);
	}
}
