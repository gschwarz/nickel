package com.rhiscom.bpm.console.server.services.dao;

import java.util.List;

import com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaAvanceSuperAvanceDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO;
import com.rhiscom.bpm.console.shared.model.dto.VersionDTO;

public interface QuadratureDAO {

    public CuadraturaVtaCMRDTO getCuadraturaVtaCMR(String fechaNegocio, long sucursal);

    public CuadraturaActivacionGiftcardDTO getCuadraturaActivacionGiftCard(String fechaNegocio, long sucursal);

    void addNewVersion(VersionDTO dto) throws Exception;

    public List<VersionDTO> getAllVersionPOS();

    void updateVersion(VersionDTO dto) throws Exception;

    void deleteVersion(long id) throws Exception;

    VersionDTO getVersionByDate(String date);

    CuadraturaVentasGiftCardDTO getCuadraturaVentasGiftCard(String fechaNegocio, long sucursal);

    CuadraturaAvanceSuperAvanceDTO getCuadraturaAvanceSuperAvance(String fechaNegocio, long sucursal);

    CuadraturaPagosCMRDTO getCuadraturaPagosCMR(String fechaNegocio, long sucursal);

    CuadraturaTarjetaCreditoDTO getCuadraturaTarjetaCredito(String fechaNegocio, long sucursal);

    CuadraturaNotaCreditoDTO getCuadraturaNotaCredito(String fechaNegocio, long sucursal);

    CuadraturaTarjetaDebitoDTO getCuadraturaTarjetaDebito(String fechaNegocio, long sucursal);

}
