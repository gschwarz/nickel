package com.rhiscom.cuadratura.files.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rhiscom.cuadratura.base.manager.BaseManager;
import com.rhiscom.cuadratura.ftp.manager.FTPFileManager;
import com.rhiscom.cuadratura.model.PSTFPEntity;

public class PS057Manager extends BaseManager {
	private final static Logger logger = Logger.getLogger(PS057Manager.class.getName());

	public void readFile(Date fechaNegocio, String sucursal) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		long valorTotal;
		long valorDonaciones;
		long valorEfectivo;
		long valorCheque;
		long valorChequeF1;
		long valorNotaCredito;
		long valorTarjetaDebito;
		long valorTarjetaBancaria;
		long valorTarjetaDinners;
		long valorA1;
		long valorCupones;
		long valorGiftC;
		long valorOrden;
		long valorTarjetaCMR;

		ArrayList<String> arregloTotales = new ArrayList<String>();
		try {


			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			
			logger.info("::readFile:: Eliminando datos anteriores..");
			String deleteQuery = "delete from PSTFPEntity where sucursal ='" + sucursal + "' and fechaTrx='"
					+ formatter2.format(fechaNegocio) + "'";

			Query query = em.createQuery(deleteQuery);
			
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();
			
			
			String pathToFile =FILE_DIRECTORY+"PS057x" + readerFormatter.format(fechaNegocio) + "x00"
					+ sucursal + ".txt";
			String file = "PS057x" + readerFormatter.format(fechaNegocio) + "x00" + sucursal + ".txt";
			File archivo = new File(pathToFile);
			FileReader fr;
			BufferedReader br;
			PSTFPEntity entity = new PSTFPEntity();

			try {
				fr = new FileReader(archivo);

				br = new BufferedReader(fr);

			} catch (IOException ex) {
				logger.info("::readFile:: Archivo "+file+" no encontrado, se carga todo en cero");
				
				entity = new PSTFPEntity();

				entity.setValorTotal(0l);
				entity.setValorA1(0l);
				entity.setValorCheque(0l);
				entity.setValorChequeF1(0l);
				entity.setValorCupones(0l);
				entity.setValorDonaciones(0l);
				entity.setValorEfectivo(0l);
				entity.setValorGiftC(0l);
				entity.setValorNotaCredito(0l);
				entity.setValorOrden(0l);
				entity.setValorTarjetaBancaria(0l);
				entity.setValorTarjetaCMR(0l);
				entity.setValorTarjetaDebito(0l);
				entity.setValorTarjetaDinners(0l);
				entity.setSucursal(Long.valueOf(sucursal));
				entity.setFechaTrx(fechaNegocio);

				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return;
			}

			String linea;
			int lineas = 0;
		

			
			logger.info("::readFile:: Archivo "+file+"  encontrado, se cargan los valores rescatados");
			while ((linea = br.readLine()) != null) {
				String lineaOriginal = linea;
				lineas++;
				linea = linea.replace(" ", "");

				if (linea.contains("GRANTOTAL")) {

					String[] arregloLineas = lineaOriginal.split(" ");

					for (int i = 0; i <= arregloLineas.length - 1; i++) {
						String numero = arregloLineas[i];

						if (numero.matches("^(\\d|-)?(\\d|,)*\\.?\\d*$")) {

							if (numero.length() > 0) {
								arregloTotales.add(numero);
							}
						}

					}

				}

			} // fin while lectura archivo
			if (arregloTotales.size() > 0) {

				valorTotal = Long.valueOf(arregloTotales.get(0).replace(",", ""));
				valorDonaciones = Long.valueOf(arregloTotales.get(1).replace(",", ""));
				valorEfectivo = Long.valueOf(arregloTotales.get(2).replace(",", ""));
				valorCheque = Long.valueOf(arregloTotales.get(3).replace(",", ""));
				valorChequeF1 = Long.valueOf(arregloTotales.get(4).replace(",", ""));
				valorNotaCredito = Long.valueOf(arregloTotales.get(5).replace(",", ""));
				valorTarjetaDebito = Long.valueOf(arregloTotales.get(6).replace(",", ""));
				valorTarjetaBancaria = Long.valueOf(arregloTotales.get(7).replace(",", ""));
				valorTarjetaDinners = Long.valueOf(arregloTotales.get(8).replace(",", ""));
				valorA1 = Long.valueOf(arregloTotales.get(9).replace(",", ""));
				valorCupones = Long.valueOf(arregloTotales.get(10).replace(",", ""));
				valorGiftC = Long.valueOf(arregloTotales.get(11).replace(",", ""));
				valorOrden = Long.valueOf(arregloTotales.get(12).replace(",", ""));
				valorTarjetaCMR = Long.valueOf(arregloTotales.get(13).replace(",", ""));

				entity = new PSTFPEntity();

				entity.setValorTotal(valorTotal);
				entity.setValorA1(valorA1);
				entity.setValorCheque(valorCheque);
				entity.setValorChequeF1(valorChequeF1);
				entity.setValorCupones(valorCupones);
				entity.setValorDonaciones(valorDonaciones);
				entity.setValorEfectivo(valorEfectivo);
				entity.setValorGiftC(valorGiftC);
				entity.setValorNotaCredito(valorNotaCredito);
				entity.setValorOrden(valorOrden);
				entity.setValorTarjetaBancaria(valorTarjetaBancaria);
				entity.setValorTarjetaCMR(valorTarjetaCMR);
				entity.setValorTarjetaDebito(valorTarjetaDebito);
				entity.setValorTarjetaDinners(valorTarjetaDinners);
				entity.setSucursal(Long.valueOf(sucursal));
				entity.setFechaTrx(fechaNegocio);

				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				
			}
			logger.info("::readFile:: Se mueve archivo "+file+" a carpeta procesados");
			FTPFileManager manager = new FTPFileManager();
			manager.subirArchivoAFTP(pathToFile, file);
			em.close();
			emf.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
