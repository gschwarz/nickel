package com.rhiscom.cuadratura.proceso.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NeteoRSATManager {
	protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void NetearRSAT(String fechaNegocio, String sucursal) throws Exception {

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkItems");
			EntityManager em = emf.createEntityManager();
			 
	        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	        Date parsed = format.parse(fechaNegocio);
	        java.sql.Date fechaSql = new java.sql.Date(parsed.getTime());
	        			
			List<String> horas = em.createQuery("Select hora from RSATEntity where fecha ='" + fechaSql + "' and codigoDeFuncion =450 ").getResultList();
			
			
			
			for(int x=0;x<horas.size();x++) {
				System.out.println(":: Neteo ::" + fechaNegocio + " - " + sucursal + " - " + horas.get(x));

				String deleteQuery = "delete from RSATEntity where local ='" + sucursal + "' and fechaTrx='"
						+ fechaSql + "' and hora='" + horas.get(x) + "'";
				System.out.println(deleteQuery);
				Query query = em.createQuery(deleteQuery);
				
				em.getTransaction().begin();
				query.executeUpdate();
				em.getTransaction().commit();
			}
			
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
}
