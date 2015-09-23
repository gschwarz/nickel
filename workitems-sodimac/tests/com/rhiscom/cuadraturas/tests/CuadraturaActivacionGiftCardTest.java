package com.rhiscom.cuadraturas.tests;

import java.util.Date;

import org.junit.Test;

import com.rhiscom.cuadratura.proceso.manager.BusinessUnitManager;
import com.rhiscom.cuadratura.proceso.manager.CuadraturaActivacionGiftCardManager;

public class CuadraturaActivacionGiftCardTest {

	@Test
	public void generarCuadratura() throws Exception {
		CuadraturaActivacionGiftCardManager manager = new CuadraturaActivacionGiftCardManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.generarCuadratura(date, "905");
	}
	
	@Test
	public void traerSucursales() {
	
	BusinessUnitManager mnamager =new BusinessUnitManager();
	mnamager.getSucursales();
	}
}
