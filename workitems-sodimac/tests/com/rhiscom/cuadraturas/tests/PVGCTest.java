package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.rhiscom.cuadratura.files.manager.PVGCManager;

public class PVGCTest {
	
	@Test
	public void traerMontoPorTipoGiftTest() {
		Date date = new Date(2013 - 1900, 0, 3);
		PVGCManager manager= new PVGCManager();
		Assert.assertNotNull(manager.traerMontoPorTipoGift("5", date, "905"));
		Assert.assertTrue(manager.traerMontoPorTipoGift("5", date, "905")>0);
	}
	
	@Test
	public void traerTotalDonacionPorTipoGiftTest() {
		Date date = new Date(2013 - 1900, 0, 3);
		PVGCManager manager= new PVGCManager();
		Assert.assertNotNull(manager.traerTotalDonacionPorTipoGift("5", date, "905"));
		Assert.assertTrue(manager.traerTotalDonacionPorTipoGift("5", date, "905")>0);
	}

}
