package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import org.junit.Test;

import com.rhiscom.cuadratura.proceso.manager.CuadraturaVentasCMRManager;

public class CuadraturaVentaCMRTest {
	
	@Test
	public void generarCuadraturaVentaCMR() {
		try {
		CuadraturaVentasCMRManager manager = new CuadraturaVentasCMRManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.generarCuadratura(date, "905");
		}
		catch (Exception ex) {
			
		}
	}

}
