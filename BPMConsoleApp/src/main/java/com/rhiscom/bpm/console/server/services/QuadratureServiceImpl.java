package com.rhiscom.bpm.console.server.services;

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.QuadratureService;
import com.rhiscom.bpm.console.server.services.dao.QuadratureDAO;
import com.rhiscom.bpm.console.server.services.dao.ServiceDAOFactory;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaAvanceSuperAvanceDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO;
import com.rhiscom.bpm.console.shared.model.dto.VersionDTO;

public class QuadratureServiceImpl extends RemoteServiceServlet implements QuadratureService {

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(QuadratureServiceImpl.class.getName());

    @Override
    public CuadraturaVtaCMRDTO getCuadraturaVtaCMR(String fechaNegocio, long sucursal) {
	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();

	logger.info("::getCuadraturaVtaCMR:: FECHA NEGOCIO : " + fechaNegocio);

	return dao.getCuadraturaVtaCMR(fechaNegocio, sucursal);
    }

    @Override
    public CuadraturaVentasGiftCardDTO getCuadraturaVtaGiftCard(String fechaNegocio, long sucursal) {
	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	return dao.getCuadraturaVentasGiftCard(fechaNegocio, sucursal);
    }

    @Override
    public CuadraturaActivacionGiftcardDTO getCuadraturaActivacionGiftCard(String fechaNegocio, long sucursal) {
	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	return dao.getCuadraturaActivacionGiftCard(fechaNegocio, sucursal);
    }

    @Override
    public CuadraturaAvanceSuperAvanceDTO getCuadraturaAvanceSuperAvance(String fechaNegocio, long sucursal) {
	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	return dao.getCuadraturaAvanceSuperAvance(fechaNegocio, sucursal);
    }

    @Override
    public CuadraturaPagosCMRDTO getCuadraturaPagosCMR(String fechaNegocio, long sucursal) {
	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	return dao.getCuadraturaPagosCMR(fechaNegocio, sucursal);
    }

    @Override
    public CuadraturaNotaCreditoDTO getCuadraturaNotaCredito(String fechaNegocio, long sucursal) {
	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	return dao.getCuadraturaNotaCredito(fechaNegocio, sucursal);
    }

    @Override
    public CuadraturaTarjetaCreditoDTO getCuadraturaTarjetaCredito(String fechaNegocio, long sucursal) {
	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	return dao.getCuadraturaTarjetaCredito(fechaNegocio, sucursal);
    }

    @Override
    public CuadraturaTarjetaDebitoDTO getCuadraturaTarjetaDebito(String fechaNegocio, long sucursal) {
	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	return dao.getCuadraturaTarjetaDebito(fechaNegocio, sucursal);
    }

    @Override
    public void addNewVersion(VersionDTO dto) throws Exception {

	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	dao.addNewVersion(dto);

    }

    @Override
    public void deleteVersion(long id) throws Exception {

	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	dao.deleteVersion(id);

    }

    @Override
    public void updateVersion(VersionDTO dto) throws Exception {

	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	dao.updateVersion(dto);

    }

    @Override
    public List<VersionDTO> getAllVersionPOS() {
	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	return dao.getAllVersionPOS();

    }
}
