package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import org.junit.Test;

import com.rhiscom.cuadratura.proceso.manager.CuadraturaPagosCMRManager;

public class CuadraturaPagosCMRTest {

	@Test
	public void generarCuadraturaPagosCMR() throws Exception {
		
		CuadraturaPagosCMRManager manager = new CuadraturaPagosCMRManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.generarCuadratura(date, "905");
		
	}
}
