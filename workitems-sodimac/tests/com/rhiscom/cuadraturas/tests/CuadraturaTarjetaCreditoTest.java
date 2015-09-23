package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import org.junit.Test;

import com.rhiscom.cuadratura.proceso.manager.CuadraturaNotaDeCreditoManager;

public class CuadraturaTarjetaCreditoTest {
	@Test
	public void generarCuadratura() throws Exception{
		CuadraturaNotaDeCreditoManager manager = new CuadraturaNotaDeCreditoManager();
	//	Date date = new Date(2013 - 1900, 0, 3);
		Date date = new Date(2014 - 1900, 9, 22);
		manager.generarCuadratura(date, "905");
	}

}
