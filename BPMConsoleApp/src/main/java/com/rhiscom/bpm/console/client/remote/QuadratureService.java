package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaAvanceSuperAvanceDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO;
import com.rhiscom.bpm.console.shared.model.dto.VersionDTO;

@RemoteServiceRelativePath("quadratureService")
public interface QuadratureService extends RemoteService {

    public CuadraturaVtaCMRDTO getCuadraturaVtaCMR(String fechaNegocio, long sucursal);

    public CuadraturaActivacionGiftcardDTO getCuadraturaActivacionGiftCard(String fechaNegocio, long sucursal);

    void addNewVersion(VersionDTO dto) throws Exception;

    void deleteVersion(long id) throws Exception;

    void updateVersion(VersionDTO dto) throws Exception;

    List<VersionDTO> getAllVersionPOS();

    CuadraturaVentasGiftCardDTO getCuadraturaVtaGiftCard(String fechaNegocio, long sucursal);

    CuadraturaAvanceSuperAvanceDTO getCuadraturaAvanceSuperAvance(String fechaNegocio, long sucursal);

    CuadraturaPagosCMRDTO getCuadraturaPagosCMR(String fechaNegocio, long sucursal);

    CuadraturaTarjetaCreditoDTO getCuadraturaTarjetaCredito(String fechaNegocio, long sucursal);

    CuadraturaNotaCreditoDTO getCuadraturaNotaCredito(String fechaNegocio, long sucursal);

    CuadraturaTarjetaDebitoDTO getCuadraturaTarjetaDebito(String fechaNegocio, long sucursal);
}
