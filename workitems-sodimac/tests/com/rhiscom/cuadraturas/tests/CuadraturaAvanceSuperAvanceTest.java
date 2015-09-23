package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import org.junit.Test;

import com.rhiscom.cuadratura.proceso.manager.CuadraturaAvanceSuperAvanceManager;

public class CuadraturaAvanceSuperAvanceTest {
	
	@Test
	public void generarCuadraturaAvanceSuperAvanceTest() {
		try {
		CuadraturaAvanceSuperAvanceManager manager = new CuadraturaAvanceSuperAvanceManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.generarCuadratura(date, "905");
		
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
