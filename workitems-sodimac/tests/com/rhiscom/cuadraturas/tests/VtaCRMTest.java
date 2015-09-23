package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.rhiscom.cuadratura.files.manager.VtaCMRManager;

public class VtaCRMTest {

	@Test
	public void getTrx200Test() {
		
		
		VtaCMRManager manager = new VtaCMRManager();
		Date date = new Date(2013 - 1900, 0, 3);
		long result =manager.totalTrx200(date, "905");
		Assert.assertTrue(result>0);
	}
	
	@Test
	public void getTrx400Test() {
		
		
		VtaCMRManager manager = new VtaCMRManager();
		Date date = new Date(2013 - 1900, 0, 3);
		long result =manager.totalTrx400(date, "905");
		Assert.assertTrue(result>0);
	}
	
}
