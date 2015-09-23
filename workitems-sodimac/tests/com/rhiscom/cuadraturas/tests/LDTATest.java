package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.rhiscom.cuadratura.files.manager.LDTAManager;

public class LDTATest {

	
	@Test
	public void getTotalMontoTFTest() {
		
		
		LDTAManager manager = new LDTAManager();
		@SuppressWarnings("deprecation")
		Date date = new Date(2013 - 1900, 0, 3);
		Assert.assertTrue(manager.getTotalMontoTF(date, "905")>0);
	}
}
