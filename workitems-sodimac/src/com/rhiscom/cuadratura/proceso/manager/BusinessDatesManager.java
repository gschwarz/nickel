package com.rhiscom.cuadratura.proceso.manager;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BusinessDatesManager {

	public List<Date> getFechas() {

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			
			//List<Date> fechas = new ArrayList<Date>();

			List<Date> fechas = em.createQuery("Select DISTINCT fechaTrx from RSATEntity ").getResultList();

			/*for (int i = 0; i <= result.size() - 1; i++) {
				fechas.add(result.get(i).getFechaTrx());
			}*/

			System.out.println(" Fechas a cuadrar por RSAT :" + fechas);
			em.close();
			emf.close();
			return fechas;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}
		finally {
			
		}

		/*
		 * List<String> resultado = new ArrayList<String>();
		 * resultado.add("905");
		 * 
		 * return resultado;
		 */

	}

}
