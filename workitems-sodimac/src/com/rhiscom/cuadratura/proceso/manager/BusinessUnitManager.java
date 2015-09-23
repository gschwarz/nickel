package com.rhiscom.cuadratura.proceso.manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rhiscom.cuadratura.model.BusinessUnit;

public class BusinessUnitManager {

	public List<String> getSucursales() {

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();

			List<String> listadoSucursales = new ArrayList<String>();

			List<BusinessUnit> result = em.createQuery("Select bu from BusinessUnit bu where bu.status='1'")
					.getResultList();

			for (int i = 0; i <= result.size() - 1; i++) {
				listadoSucursales.add(result.get(i).getCode());
			}

			System.out.println(" LISTADO A RETORNAR :" + listadoSucursales);
			em.close();
			emf.close();
			return listadoSucursales;

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
