package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import org.junit.Test;

import com.rhiscom.cuadratura.proceso.manager.CuadraturaVentaGiftCardManager;

public class CuadraturaVentaGiftCardTest {

	@Test
	public void generarCuadraturaVentaGiftCard() throws Exception{
		CuadraturaVentaGiftCardManager manager = new CuadraturaVentaGiftCardManager();
		Date date = new Date(2014 - 1900, 11, 2);
		manager.generarCuadratura(date, "910");

	}
}
