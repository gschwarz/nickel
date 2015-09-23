package com.rhiscom.cuadratura.ftp.manager;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.rhiscom.cuadratura.files.manager.LDTAManager;
import com.rhiscom.cuadratura.model.LogFileload;

public class FTPFileManager {

	private final static Logger logger = Logger.getLogger(LDTAManager.class.getName());

	static ResourceBundle rb = ResourceBundle.getBundle("ftpproperties");

	private String serverAddres = rb.getString("serverftp");
	private String userName = rb.getString("userftp");
	private String password = rb.getString("passwordftp");
	private String directory = rb.getString("directory");
	private String fileDirectory = rb.getString("fileDirectory");

	public void moverArchivoFTPToFile(String archivo, String sucursal, String fechaNegocio, String extension) {
		String pathToRead = "";
		if (archivo.compareTo("RSAT") == 0) {
			pathToRead = directory + archivo + "x" + fechaNegocio + "." + extension;
		} else if (archivo.compareTo("SAT") == 0) {
			pathToRead = directory + archivo + "x" + fechaNegocio + "." + extension;
		} else {
			pathToRead = directory + archivo + "x" + fechaNegocio + "x00" + sucursal + "." + extension;
		}
		FTPClient ftp = new FTPClient();

		try {

			ftp.connect(serverAddres);
			ftp.login(userName, password);

		} catch (SocketException ex) {
			ex.printStackTrace();

		} catch (IOException ex) {
			ex.printStackTrace();

		}

		int reply = ftp.getReplyCode();

		if (FTPReply.isPositiveCompletion(reply)) {
			System.out.println("Connected Success");
		} else {
			System.out.println("Connection Failed");
			try {
				ftp.disconnect();
			} catch (IOException e) {

				e.printStackTrace();

			}
		}

		BufferedReader reader = null;

		try {
			logger.info("Archivo a rescatar del FTP :" + pathToRead);
			InputStream stream = ftp.retrieveFileStream(pathToRead);

			reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
			copyFile(reader, archivo, fechaNegocio, sucursal, extension);
		} catch (Exception ex) {

			logger.info("Archivo no encontrado : "+ pathToRead);
		}
	}

	private void copyFile(BufferedReader reader, String archivo, String fechaNegocio, String sucursal,
			String extension) throws IOException {

		// String pathToWrite = fileDirectory + archivo + "x" + fechaNegocio +
		// "x00" + sucursal + "." + extension;

		try {
			String pathToWrite = "";
			if (archivo.compareTo("RSAT") == 0) {
				pathToWrite = fileDirectory + archivo + "x" + fechaNegocio + "." + extension;
			} else if (archivo.compareTo("SAT") == 0) {
				pathToWrite = fileDirectory + archivo + "x" + fechaNegocio + "." + extension;
			} else {
				pathToWrite = fileDirectory + archivo + "x" + fechaNegocio + "x00" + sucursal + "." + extension;
			}

			File f = new File(pathToWrite);
			FileWriter fw = new FileWriter(f);

			if (f.exists()) {
				f.delete();
			}
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter wr = new PrintWriter(bw);

			String line = null;

			while ((line = reader.readLine()) != null) {
				wr.write(line);
				wr.write("\n");
			}

			wr.close();
			bw.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void subirArchivoAFTP(String archivo, String file) {

		String pathToWrite = archivo;

		try {
			FTPClient ftpClient = new FTPClient();
			Boolean exito;
			ftpClient.connect(InetAddress.getByName(serverAddres));
			ftpClient.login(userName, password);

			ftpClient.changeWorkingDirectory(directory + "/procesados");
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			BufferedInputStream buffIn = null;
			buffIn = new BufferedInputStream(new FileInputStream(pathToWrite));
			ftpClient.enterLocalPassiveMode();
			exito = ftpClient.storeFile(file, buffIn);

			// logger.info("::readFile:: + " + file + " " + exito);

			ftpClient.changeWorkingDirectory("/" + directory);
			ftpClient.deleteFile(file);
			buffIn.close();
			ftpClient.logout();
			ftpClient.disconnect();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void registrarLogArchivo(String nombreArchivo, String status, String fechaNegocio) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		LogFileload log = new LogFileload();
		log.setFileName(nombreArchivo);
		try {
			log.setLogDate(format.parse(fechaNegocio));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.setStatus(status);
		log.setCurrentDate(new Date());

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(log);
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
