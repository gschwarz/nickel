package com.rhiscom.bpm.console.server.services.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.rhiscom.bpm.console.server.model.entity.VentaDomicilio;
import com.rhiscom.bpm.console.shared.model.dto.ClienteDTO;
import com.rhiscom.bpm.console.shared.model.dto.DetalleVentaDTO;
import com.rhiscom.bpm.console.shared.model.dto.VentaDomicilioDTO;

public class DespachoDomicilioDAOImpl implements DespachoDomicilioDAO {
    private EntityManager em;

    public DespachoDomicilioDAOImpl(EntityManager entityManager) {
	em = entityManager;
    }

    @Override
    public VentaDomicilioDTO traerVentaPorId(long idVenta) throws Exception {
	try {
	    VentaDomicilio ventaDomicilio = em.find(VentaDomicilio.class, idVenta);
	    DetalleVentaDTO dto = new DetalleVentaDTO();
	    List<DetalleVentaDTO> listadoDetalle = new ArrayList<DetalleVentaDTO>();
	    for (int i = 0; i <= ventaDomicilio.getDetalle().size() - 1; i++) {
		dto = new DetalleVentaDTO(ventaDomicilio.getDetalle().get(i).getCantidad(), ventaDomicilio.getDetalle()
			.get(i).getId(), ventaDomicilio.getDetalle().get(i).getIdProducto(), ventaDomicilio
			.getDetalle().get(i).getNombre(), ventaDomicilio.getDetalle().get(i).getPrecio());
		listadoDetalle.add(dto);
	    }
	    ClienteDTO clienteDTO = new ClienteDTO(ventaDomicilio.getCliente().getApellido(), ventaDomicilio
		    .getCliente().getBarrio(), ventaDomicilio.getCliente().getCiudad(), ventaDomicilio.getCliente()
		    .getDireccion(), ventaDomicilio.getCliente().getEmail(), ventaDomicilio.getCliente()
		    .getFechaNacimiento(), ventaDomicilio.getCliente().getId(),
		    ventaDomicilio.getCliente().getNombre(), ventaDomicilio.getCliente().getNumeroCliente(),
		    ventaDomicilio.getCliente().getSegundoApellido(), ventaDomicilio.getCliente().getSegundoNombre(),
		    ventaDomicilio.getCliente().getTelefonoContacto1(), ventaDomicilio.getCliente()
			    .getTelefonoContacto2(), ventaDomicilio.getCliente().getTipoDocumento(), ventaDomicilio
			    .getCliente().getZona());
	    VentaDomicilioDTO ventaDomicilioDTO = new VentaDomicilioDTO(ventaDomicilio.getId(),
		    ventaDomicilio.getEstado(), ventaDomicilio.getFecha(), clienteDTO, ventaDomicilio.getLocal(),
		    ventaDomicilio.getTotal());
	    ventaDomicilioDTO.setDetalle(listadoDetalle);
	    return ventaDomicilioDTO;
	} catch (javax.persistence.PersistenceException e) {
	    e.printStackTrace();
	    throw new Exception("PERSISTENCE");

	} catch (Exception ex) {
	    ex.printStackTrace();
	    em.getTransaction().rollback();
	    throw new Exception(ex);
	} finally {

	}

    }
}
