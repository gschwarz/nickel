package com.rhiscom.cuadraturas.tests;

import org.junit.Test;

import com.rhiscom.cuadratura.ftp.manager.FTPFileManager;

public class FTPFileTests {

	@Test
	public void ftpPLCUATest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("PLCUA", "905", "20140822", "txt");
	}
	
	@Test
	public void ftpPLDTFTest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("PLDTF", "905", "20130103", "xls");
	}
	
	@Test
	public void ftpVtaCMRest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("VtaCMR", "905", "20130103", "xls");
	}
	
	@Test
	public void ftpLDTATest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("LDTA", "905", "20130103", "txt");
	}
	
	@Test
	public void ftpARQTFTest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("ARQ_TF", "905", "20130103", "txt");
	}
	@Test
	public void ftpPLCTest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("PLC", "905", "20130103", "csv");
	}
	
	@Test
	public void ftpPLDTest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("PLD", "905", "20130103", "csv");
	}
	
	@Test
	public void ftpPVGCTest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("PVGC", "905", "20130103", "csv");
	}
	
	@Test
	public void ftpPLGCTest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("PLGC", "905", "20130103", "csv");
	}
	
	@Test
	public void ftpARQDBTest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("ARQ_DB", "905", "20130103", "txt");
	}
	@Test
	public void ftpARQTVTest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("ARQ_TV", "905", "20130103", "txt");
	}
	
	@Test
	public void ftpPS057Test() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("PS057", "905", "20130103", "txt");
	}
	
	@Test
	public void ftpARQGMTest() {
		
		FTPFileManager manager = new FTPFileManager();
		manager.moverArchivoFTPToFile("ARQ_GM", "905", "20130103", "txt");
	}
}
