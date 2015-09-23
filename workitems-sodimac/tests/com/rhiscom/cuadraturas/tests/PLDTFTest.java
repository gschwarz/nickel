package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.rhiscom.cuadratura.files.manager.PLDTFManager;

public class PLDTFTest {

	@Test
	public void getTotalAbonoCRMTest()

	{
		PLDTFManager manager = new PLDTFManager();
		Date date = new Date(2013 - 1900, 0, 3);
		Assert.assertTrue(manager.getTotalMontoAbonoCMRPLDTF(date, "905") > 0);

	}

}
