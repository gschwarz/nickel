package com.rhiscom.cuadraturas.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.rhiscom.cuadratura.files.manager.ARQDBManager;
import com.rhiscom.cuadratura.files.manager.ARQGMManager;
import com.rhiscom.cuadratura.files.manager.ARQTFManager;
import com.rhiscom.cuadratura.files.manager.ARQTVManager;
import com.rhiscom.cuadratura.files.manager.LDTAManager;
import com.rhiscom.cuadratura.files.manager.PLACUADManager;
import com.rhiscom.cuadratura.files.manager.PLCManager;
import com.rhiscom.cuadratura.files.manager.PLDManager;
import com.rhiscom.cuadratura.files.manager.PLDTFManager;
import com.rhiscom.cuadratura.files.manager.PLGCManager;
import com.rhiscom.cuadratura.files.manager.PS057Manager;
import com.rhiscom.cuadratura.files.manager.PVGCManager;
import com.rhiscom.cuadratura.files.manager.RSATManager;
import com.rhiscom.cuadratura.files.manager.SATManager;
import com.rhiscom.cuadratura.files.manager.VtaCMRManager;

public class FileManagerTest {

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	@SuppressWarnings("deprecation")
	Date date = new Date(2014 - 1900, 7, 22);

	@Test
	public void readCMR() {
		VtaCMRManager manager = new VtaCMRManager();
		//Date date = new Date(2013 - 1900, 0, 3);
		Date date = new Date(2014 - 1900, 11, 10);
		manager.readFile(date, "910");
	}

	@Test
	public void readARQTF() {
		ARQTFManager manager = new ARQTFManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.readFile(date, "905");
	}

	@Test
	public void readPLCUA() {
		PLACUADManager manager = new PLACUADManager();
	//	Date date = new Date(2014 - 1900, 11, 9);
      // Date date = new Date(2014 - 1900, 9, 22);
		Date date = new Date(2013 - 1900, 0, 3);
		manager.readFile(date, "905");
	}

	@Test
	public void readPLDTF() {

		PLDTFManager manager = new PLDTFManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.readFile(date, "905");
	}

	@Test
	public void readLDTA() {

		LDTAManager manager = new LDTAManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.readFile(date, "905");
	}

	@Test
	public void readPLC() {

		PLCManager manager = new PLCManager();
		Date date = new Date(2014 - 1900, 9, 22);
		//	Date date = new Date(2013 - 1900, 0, 3);
		manager.readFile(date, "905");
	}

	@Test
	public void readPLD() {

		PLDManager manager = new PLDManager();
		Date date = new Date(2014 - 1900, 9, 22);
		manager.readFile(date, "905");
	}

	@Test
	public void readPVGC() {

		PVGCManager manager = new PVGCManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.readFile(date, "905");
	}

	@Test
	public void readPLGC() {

		PLGCManager manager = new PLGCManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.readFile(date, "905");
	}

	@Test
	public void readARQTVTest() {

		ARQTVManager manager = new ARQTVManager();
		//Date date = new Date(2013 - 1900, 0, 3);
		Date date = new Date(2014 - 1900, 11, 11);
		manager.readFile(date, "910");
	}
	@Test
	public void readARQDBTest() {

		ARQDBManager manager = new ARQDBManager();
		//Date date = new Date(2013 - 1900, 0, 3);
		Date date = new Date(2014 - 1900, 9, 22);
		manager.readFile(date, "905");
	}
	
	@Test
	public void readPS057Test() {
		PS057Manager manager = new PS057Manager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.readFile(date, "905");
	}
	
	@Test
	public void readARQGM() {
		ARQGMManager manager = new ARQGMManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.readFile(date, "905");
	}
	@Test
	public void readRSAT() {
		RSATManager manager = new RSATManager();
		Date date = new Date(2014 - 1900, 11, 10);
		manager.readFile(date, "905");
	}
	@Test
	public void readSAT() {
		SATManager manager = new SATManager();
		Date date = new Date(2013 - 1900, 0, 3);
		manager.readFile(date, "905");
	}
}

