package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import org.junit.Test;

import com.rhiscom.cuadratura.proceso.manager.CuadraturaTarjetaDebitoManager;

public class CuadraturaTarjetaDebitoTest {
	@Test
	public void generarCuadratura()throws Exception {
		CuadraturaTarjetaDebitoManager manager = new CuadraturaTarjetaDebitoManager();
	//	Date date = new Date(2013 - 1900, 0, 3);
		Date date = new Date(2014 - 1900, 11, 9);
		manager.generarCuadratura(date, "910");
	}

}
