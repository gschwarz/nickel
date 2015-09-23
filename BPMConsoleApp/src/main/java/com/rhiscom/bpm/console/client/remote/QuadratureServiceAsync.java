package com.rhiscom.bpm.console.client.remote;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaAvanceSuperAvanceDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO;
import com.rhiscom.bpm.console.shared.model.dto.VersionDTO;

public interface QuadratureServiceAsync {

    public void getCuadraturaVtaCMR(String fechaNegocioStr, long sucursal, AsyncCallback<CuadraturaVtaCMRDTO> callBack);

    public void getCuadraturaActivacionGiftCard(String fechaNegocio, long sucursal,
	    AsyncCallback<CuadraturaActivacionGiftcardDTO> callBack);

    public void getCuadraturaVtaGiftCard(String fechaNegocio, long sucursal,
	    AsyncCallback<CuadraturaVentasGiftCardDTO> callBack);

    public void getCuadraturaAvanceSuperAvance(String fechaNegocio, long sucursal,
	    AsyncCallback<CuadraturaAvanceSuperAvanceDTO> callBack);

    public void getCuadraturaTarjetaCredito(String fechaNegocio, long sucursal,
	    AsyncCallback<CuadraturaTarjetaCreditoDTO> callBack);

    public void getCuadraturaNotaCredito(String fechaNegocio, long sucursal,
	    AsyncCallback<CuadraturaNotaCreditoDTO> callBack);

    public void getCuadraturaTarjetaDebito(String fechaNegocio, long sucursal,
	    AsyncCallback<CuadraturaTarjetaDebitoDTO> callBack);

    public void getCuadraturaPagosCMR(String fechaNegocio, long sucursal, AsyncCallback<CuadraturaPagosCMRDTO> callBack);

    public void addNewVersion(VersionDTO dto, AsyncCallback callBack) throws Exception;

    void deleteVersion(long id, AsyncCallback callBack) throws Exception;

    void updateVersion(VersionDTO dto, AsyncCallback callBack) throws Exception;

    public void getAllVersionPOS(AsyncCallback<List<VersionDTO>> callBack);

}
