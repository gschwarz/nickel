package com.rhiscom.bpm.console.server.services.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.rhiscom.bpm.console.server.model.entity.CuadraturaActivacionGiftCard;
import com.rhiscom.bpm.console.server.model.entity.CuadraturaAvanceSuperAvance;
import com.rhiscom.bpm.console.server.model.entity.CuadraturaNotaCredito;
import com.rhiscom.bpm.console.server.model.entity.CuadraturaPagosCMR;
import com.rhiscom.bpm.console.server.model.entity.CuadraturaTarjetaCredito;
import com.rhiscom.bpm.console.server.model.entity.CuadraturaTarjetaDebito;
import com.rhiscom.bpm.console.server.model.entity.CuadraturaVentasGiftCard;
import com.rhiscom.bpm.console.server.model.entity.CuadraturaVtaCMR;
import com.rhiscom.bpm.console.server.model.entity.POSVersion;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaAvanceSuperAvanceDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVentasGiftCardDTO;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO;
import com.rhiscom.bpm.console.shared.model.dto.VersionDTO;

public class QuadratureDAOImpl implements QuadratureDAO {
    private EntityManager em;

    protected SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
    private static Logger logger = Logger.getLogger(QuadratureDAOImpl.class.getName());

    public QuadratureDAOImpl(EntityManager entityManager) {
	em = entityManager;
    }

    @Override
    public CuadraturaVtaCMRDTO getCuadraturaVtaCMR(String fechaNegocio, long sucursal) {

	logger.info("::getCuadraturaVtaCMR:: FECHA NEGOCIO : " + fechaNegocio);

	try {
	    CuadraturaVtaCMR result = new CuadraturaVtaCMR();
	    CuadraturaVtaCMRDTO resultDTO = new CuadraturaVtaCMRDTO();

	    String selectQuery = "Select cuad from CuadraturaVtaCMR cuad where cuad.sucursal ='" + sucursal
		    + "' and cuad.fechaTrx='" + fechaNegocio + "'";

	    logger.info("::getCuadraturaVtaCMR::");
	    logger.info("::getCuadraturaVtaCMR:: query : " + selectQuery);
	    logger.info("::getCuadraturaVtaCMR:: ");
	    Query query = em.createQuery(selectQuery);
	    result = (CuadraturaVtaCMR) query.getSingleResult();

	    resultDTO.setArqTFDonacion(result.getArqTFDonacion());
	    resultDTO.setArqTFNCR(result.getArqTFNCR());
	    resultDTO.setCuotasDiferidas(result.getCuotasDiferidas());
	    resultDTO.setCuotasNormales(result.getCuotasNormales());
	    resultDTO.setDiferenciaLdtaConArqTFDonacion(result.getDiferenciaLdtaConArqTFDonacion());
	    resultDTO.setDiferenciaPlaCuadARQTF(result.getDiferenciaPlaCuadARQTF());
	    resultDTO.setDiferenciaPlaCuadConVtaCMR(result.getDiferenciaPlaCuadConVtaCMR());
	    resultDTO.setDiferenciaPlaCuadNCRConArqTFNCR(result.getDiferenciaPlaCuadNCRConArqTFNCR());
	    resultDTO.setDiferenciaPldtfNCRConArqTFNCR(result.getDiferenciaPldtfNCRConArqTFNCR());
	    resultDTO.setDiferenciaVtaCRMConARQTF(result.getDiferenciaVtaCRMConARQTF());
	    resultDTO.setDonacionCMR(result.getDonacionCMR());
	    resultDTO.setFechaTrx(result.getFechaTrx());
	    resultDTO.setGranTotalAnulacionGiftcard(result.getGranTotalAnulacionGiftcard());
	    resultDTO.setGranTotalDevolucionesCMRNCA(result.getGranTotalDevolucionesCMRNCA());
	    resultDTO.setGranTotalDevolucionesCMRNCR(result.getGranTotalDevolucionesCMRNCR());
	    resultDTO.setGranTotalRecaudaciones(result.getGranTotalRecaudaciones());
	    resultDTO.setGranTotalVentas(result.getGranTotalVentas());
	    resultDTO.setId(result.getId());
	    resultDTO.setLdta(result.getLdta());
	    resultDTO.setLdtaDonacion(result.getLdtaDonacion());
	    resultDTO.setNcrTFTotal(result.getNcrTFTotal());
	    resultDTO.setPlacuadNCR(result.getPlacuadNCR());
	    resultDTO.setPldtf(result.getPldtf());
	    resultDTO.setSucursal(result.getSucursal());
	    resultDTO.setTotalFinalARQTF(result.getTotalFinalARQTF());
	    resultDTO.setTotalFinalPlaCuad(result.getTotalFinalPlaCuad());
	    resultDTO.setTotalFinalTRX(result.getTotalFinalTRX());
	    resultDTO.setTransacciones200(result.getTransacciones200());
	    resultDTO.setTransacciones400(result.getTransacciones400());
	    resultDTO.setTresCC(result.getTresCC());
	    resultDTO.setVersionPOS(this.getVersionByDate(fechaNegocio).getDescription());

	    resultDTO.setTotalTrx200RSAT(result.getTotalTrx200RSAT());
	    resultDTO.setTotalTrx400RSAT(result.getTotalTrx400RSAT());
	    resultDTO.setTotalTrx200SAT(result.getTotalTrx200SAT());
	    resultDTO.setTotalTrx400SAT(result.getTotalTrx400SAT());
	    resultDTO.setTotalFinalRSAT(result.getTotalFinalRSAT());
	    resultDTO.setTotalFinalSAT(result.getTotalFinalSAT());

	    resultDTO.setDiferenciaSATCRCMR(result.getDiferenciaSATCRCMR());
	    resultDTO.setDiferenciaRSATCRCMR(result.getDiferenciaRSATCRCMR());

	    return resultDTO;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    @Override
    public CuadraturaActivacionGiftcardDTO getCuadraturaActivacionGiftCard(String fechaNegocio, long sucursal) {

	CuadraturaActivacionGiftcardDTO resultDTO = new CuadraturaActivacionGiftcardDTO();

	try {
	    String selectQuery = "Select cuad from CuadraturaActivacionGiftCard cuad where cuad.sucursal ='" + sucursal
		    + "' and cuad.fechaTrx='" + fechaNegocio + "'";

	    Query query = em.createQuery(selectQuery);
	    CuadraturaActivacionGiftCard result = (CuadraturaActivacionGiftCard) query.getSingleResult();

	    cuadraturaActivacionGiftCard2CuadraturaActivacionGiftCarDTO(fechaNegocio, resultDTO, result);
	    return resultDTO;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}

    }

    private void cuadraturaActivacionGiftCard2CuadraturaActivacionGiftCarDTO(String fechaNegocio,
	    CuadraturaActivacionGiftcardDTO resultDTO, CuadraturaActivacionGiftCard result) {
	resultDTO.setDiferenciaPlaCuadConPLGC(result.getDiferenciaPlaCuadConPLGC());
	resultDTO.setFechaTrx(result.getFechaTrx());
	resultDTO.setId(result.getId());
	resultDTO.setSucursal(result.getSucursal());
	resultDTO.setTotalACCGiftCMR(result.getTotalACCGiftCMR());
	resultDTO.setTotalACCGiftCorporativa(result.getTotalACCGiftCorporativa());
	resultDTO.setTotalActGiftCMR(result.getTotalActGiftCMR());
	resultDTO.setTotalActGiftCorporativa(result.getTotalActGiftCorporativa());
	resultDTO.setTotalGiftCard(result.getTotalGiftCard());
	resultDTO.setTotalGiftCard2(result.getTotalGiftCard2());
	resultDTO.setTotalGiftCMR(result.getTotalGiftCMR());
	resultDTO.setTotalGiftCMR2(result.getTotalGiftCMR2());
	resultDTO.setTotalGiftCorporativa(result.getTotalGiftCorporativa());
	resultDTO.setTotalGiftCorporativa2(result.getTotalGiftCorporativa2());
	resultDTO.setActivacionGiftCardCMR(result.getActivacionGiftCardCMR());
	resultDTO.setAnulacionGiftCardCMR(result.getAnulacionGiftCardCMR());
	resultDTO.setActivacionGiftCardCorporativa(result.getActivacionGiftCardCorporativa());
	resultDTO.setAnulacionGiftCardCorporativa(result.getAnulacionGiftCardCorporativa());
	resultDTO.setVersionPOS(this.getVersionByDate(fechaNegocio).getDescription());
    }

    @Override
    public void addNewVersion(VersionDTO dto) throws Exception {

	POSVersion version = new POSVersion();

	version.setDescription(dto.getDescription());
	version.setEndDate(dto.getEndDate());
	version.setInitDate(dto.getInitDate());
	version.setServer(dto.getServer());
	version.setYear(dto.getYear());

	try {
	    em.getTransaction().begin();
	    em.persist(version);
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    throw new Exception(ex.getMessage());
	}

    }

    @Override
    public void deleteVersion(long id) throws Exception {

	try {
	    Query q = em.createQuery("delete from POSVersion where id='" + id + "'");
	    em.getTransaction().begin();
	    q.executeUpdate();
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    throw new Exception(ex.getMessage());
	}

    }

    @Override
    public void updateVersion(VersionDTO dto) throws Exception {

	POSVersion version = new POSVersion();
	version.setId(dto.getId());
	version.setDescription(dto.getDescription());
	version.setEndDate(dto.getEndDate());
	version.setInitDate(dto.getInitDate());
	version.setServer(dto.getServer());
	version.setYear(dto.getYear());

	try {
	    em.getTransaction().begin();
	    em.merge(version);
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    throw new Exception(ex.getMessage());
	}

    }

    @Override
    public List<VersionDTO> getAllVersionPOS() {
	String selectQuery = "from POSVersion";
	VersionDTO version = new VersionDTO();
	Query query = em.createQuery(selectQuery);
	List<POSVersion> result = query.getResultList();

	List<VersionDTO> listVersionPOS = new ArrayList<VersionDTO>();

	for (int i = 0; i <= result.size() - 1; i++) {
	    version = new VersionDTO();
	    version.setId(result.get(i).getId());
	    version.setDescription(result.get(i).getDescription());
	    version.setEndDate(result.get(i).getEndDate());
	    version.setInitDate(result.get(i).getInitDate());
	    version.setServer(result.get(i).getServer());
	    version.setYear(result.get(i).getYear());
	    listVersionPOS.add(version);
	}

	return listVersionPOS;

    }

    @Override
    public VersionDTO getVersionByDate(String date) {

	String selectQuery = "from POSVersion pos where '" + date + "' >= pos.initDate and '" + date
		+ "' <= pos.endDate";
	VersionDTO version = new VersionDTO();
	Query query = em.createQuery(selectQuery);
	POSVersion result = (POSVersion) query.getSingleResult();

	version = new VersionDTO();
	version.setId(result.getId());
	version.setDescription(result.getDescription());
	version.setEndDate(result.getEndDate());
	version.setInitDate(result.getInitDate());
	version.setServer(result.getServer());
	version.setYear(result.getYear());

	return version;

    }

    @Override
    public CuadraturaVentasGiftCardDTO getCuadraturaVentasGiftCard(String fechaNegocio, long sucursal) {

	try {
	    CuadraturaVentasGiftCardDTO dto = new CuadraturaVentasGiftCardDTO();
	    String selectQuery = "Select cuad from CuadraturaVentasGiftCard cuad where cuad.sucursal ='" + sucursal
		    + "' and cuad.fechaTrx='" + fechaNegocio + "'";
	    Query query = em.createQuery(selectQuery);
	    CuadraturaVentasGiftCard result = (CuadraturaVentasGiftCard) query.getSingleResult();

	    dto.setAnulacionesVtaNCAGifCorporativa(result.getAnulacionesVtaNCAGifCorporativa());
	    dto.setAnulacionesVtaNCAGiftCMR(result.getAnulacionesVtaNCAGiftCMR());
	    dto.setDonacionesGiftCMR(result.getDonacionesGiftCMR());
	    dto.setDonacionesGiftCorporativa(result.getDonacionesGiftCorporativa());
	    dto.setId(result.getId());
	    dto.setFechaTrx(result.getFechaTrx());
	    dto.setNcrGiftCMR(result.getNcrGiftCMR());
	    dto.setNcrGiftCorporativa(result.getNcrGiftCorporativa());
	    dto.setSucursal(result.getSucursal());
	    dto.setTotalAnulacionesNCRGiftCMR(result.getTotalAnulacionesNCRGiftCMR());
	    dto.setTotalAnulacionesNCRGiftCorporativa(result.getTotalAnulacionesNCRGiftCorporativa());
	    dto.setTotalGifCorporativa(result.getTotalGifCorporativa());
	    dto.setTotalPlaCuaCorporativa(result.getTotalPlaCuaCorporativa());
	    dto.setTotalPlaCuadCMR(result.getTotalPlaCuadCMR());
	    dto.setTotalVentasGiftCardCMRPVGC(result.getTotalVentasGiftCardCMRPVGC());
	    dto.setTotalVentasGiftCMRPVGC(result.getTotalVentasGiftCMRPVGC());
	    dto.setTotalVentasGiftCorporativa(result.getTotalVentasGiftCorporativa());
	    dto.setVentasGiftCardCMR(result.getVentasGiftCardCMR());
	    dto.setVentasGiftCorporativa(result.getVentasGiftCorporativa());
	    dto.setSumatoriaMpvgc(result.getSumatoriaMpvgc());
	    dto.setSumatoriaPlcua(result.getSumatoriaPlcua());
	    dto.setDiferenciaPlacuadMpvgc(result.getDiferenciaPlacuadMpvgc());
	    dto.setVersionPOS(this.getVersionByDate(fechaNegocio).getDescription());
	    return dto;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    @Override
    public CuadraturaAvanceSuperAvanceDTO getCuadraturaAvanceSuperAvance(String fechaNegocio, long sucursal) {
	try {
	    CuadraturaAvanceSuperAvanceDTO dto = new CuadraturaAvanceSuperAvanceDTO();
	    String selectQuery = "Select cuad from CuadraturaAvanceSuperAvance cuad where cuad.sucursal ='" + sucursal
		    + "' and cuad.fechaTrx='" + fechaNegocio + "'";
	    Query query = em.createQuery(selectQuery);
	    CuadraturaAvanceSuperAvance result = (CuadraturaAvanceSuperAvance) query.getSingleResult();

	    dto.setDiferenciaAvancePLCUACRCMR(result.getDiferenciaAvancePLCUACRCMR());
	    dto.setDiferenciaAvancePLCUASCTFA(result.getDiferenciaAvancePLCUASCTFA());
	    dto.setDiferenciaAvanceSCTFACRCMR(result.getDiferenciaAvanceSCTFACRCMR());
	    dto.setDiferenciaSuperAvancePLCUACRCMR(result.getDiferenciaSuperAvancePLCUACRCMR());
	    dto.setDiferenciaSuperAvancePLCUASCTFA(result.getDiferenciaSuperAvancePLCUASCTFA());
	    dto.setDiferenciaSuperAvanceSCTFACRCMR(result.getDiferenciaSuperAvanceSCTFACRCMR());

	    dto.setFechaTrx(result.getFechaTrx());
	    dto.setId(result.getId());
	    dto.setSucursal(result.getSucursal());

	    dto.setTotalAnulacionesAvanceCMR(result.getTotalAnulacionesAvanceCMR());
	    dto.setTotalAnulacionesAvanceCMRARQTF(result.getTotalAnulacionesAvanceCMRARQTF());
	    dto.setTotalAnulacionesSuperAvanceCMR(result.getTotalAnulacionesSuperAvanceCMR());
	    dto.setTotalAnulacionesSuperAvanceCMRARQTF(result.getTotalAnulacionesSuperAvanceCMRARQTF());
	    dto.setTotalAnulacionesSuperAvanceCRCMR(result.getTotalAnulacionesSuperAvanceCRCMR());

	    dto.setTotalAvance(result.getTotalAvance());
	    dto.setTotalAvanceAnuladosCMRCRCMR(result.getTotalAvanceAnuladosCMRCRCMR());
	    dto.setTotalAvanceARQTF(result.getTotalAvanceARQTF());
	    dto.setTotalAvanceCMR(result.getTotalAvanceCMR());
	    dto.setTotalAvanceCMRARQTF(result.getTotalAvanceCMRARQTF());
	    dto.setTotalAvanceCMRCRCMR(result.getTotalAvanceCMRCRCMR());
	    dto.setTotalAvanceCRCMR(result.getTotalAvanceCRCMR());

	    dto.setTotalSuperavance(result.getTotalSuperavance());
	    dto.setTotalSuperAvanceARQTF(result.getTotalSuperAvanceARQTF());
	    dto.setTotalSuperAvanceCMR(result.getTotalSuperAvanceCMR());
	    dto.setTotalSuperAvanceCMRARQTF(result.getTotalSuperAvanceCMRARQTF());
	    dto.setTotalSuperAvanceCMRCRCMR(result.getTotalSuperAvanceCMRCRCMR());
	    dto.setTotalSuperAvanceCRCMR(result.getTotalSuperAvanceCRCMR());
	    dto.setVersionPOS(this.getVersionByDate(fechaNegocio).getDescription());

	    dto.setTotalTrx220SAT(result.getTotalTrx220SAT());
	    dto.setTotalTrx220RSAT(result.getTotalTrx220RSAT());

	    dto.setTotalTrx403SAT(result.getTotalTrx403SAT());
	    dto.setTotalTrx403RSAT(result.getTotalTrx403RSAT());

	    dto.setTotalAvanceFinalRSAT(result.getTotalAvanceFinalRSAT());
	    dto.setTotalAvanceFinalSAT(result.getTotalAvanceFinalSAT());

	    dto.setTotalTrx274SAT(result.getTotalTrx274SAT());
	    dto.setTotalTrx274RSAT(result.getTotalTrx274RSAT());

	    dto.setTotalTrx473SAT(result.getTotalTrx473SAT());
	    dto.setTotalTrx473RSAT(result.getTotalTrx473RSAT());

	    dto.setTotalSuperAvanceFinalSAT(result.getTotalSuperAvanceFinalSAT());
	    dto.setTotalSuperAvanceFinalRSAT(result.getTotalSuperAvanceFinalRSAT());

	    dto.setDiferenciaSATCRCMRAvance(result.getDiferenciaSATCRCMRAvance());
	    dto.setDiferenciaRSATCRCMRAvance(result.getDiferenciaRSATCRCMRAvance());

	    dto.setDiferenciaSATCRCMRSuperAvance(result.getDiferenciaSATCRCMRSuperAvance());
	    dto.setDiferenciaRSATCRCMRSuperAvance(result.getDiferenciaRSATCRCMRSuperAvance());

	    return dto;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    @Override
    public CuadraturaPagosCMRDTO getCuadraturaPagosCMR(String fechaNegocio, long sucursal) {
	try {
	    CuadraturaPagosCMRDTO dto = new CuadraturaPagosCMRDTO();
	    String selectQuery = "Select cuad from CuadraturaPagosCMR cuad where cuad.sucursal ='" + sucursal
		    + "' and cuad.fechaTrx='" + fechaNegocio + "'";
	    Query query = em.createQuery(selectQuery);
	    CuadraturaPagosCMR result = (CuadraturaPagosCMR) query.getSingleResult();

	    dto.setDiferenciaPLACUASCTFA(result.getDiferenciaPLACUASCTFA());
	    dto.setDiferenciaPLCUACRCMR(result.getDiferenciaPLCUACRCMR());
	    dto.setDiferenciaSCTFACRCMR(result.getDiferenciaSCTFACRCMR());
	    dto.setFechaTrx(result.getFechaTrx());
	    dto.setId(result.getId());
	    dto.setPagoAnulado(result.getPagoAnulado());
	    dto.setPagoNormal(result.getPagoNormal());
	    dto.setPagoRepactado(result.getPagoRepactado());
	    dto.setSucursal(result.getSucursal());
	    dto.setTotalAbonos(result.getTotalAbonos());
	    dto.setTotalAbonosCMRRepactacion(result.getTotalAbonosCMRRepactacion());
	    dto.setTotalAnulacionAbonoNormal(result.getTotalAnulacionAbonoNormal());
	    dto.setTotalAnulacionAbonoRepactacion(result.getTotalAnulacionAbonoRepactacion());
	    dto.setTotalCRCMR(result.getTotalCRCMR());
	    dto.setTotalPagos(result.getTotalPagos());
	    dto.setTotalPagosSctfa(result.getTotalPagosSctfa());
	    dto.setTrx217(result.getTrx217());
	    dto.setTrx402(result.getTrx402());

	    dto.setTotalPagosRSAT(result.getTotalPagosRSAT());
	    dto.setTotalFinalPagosRSAT(result.getTotalFinalPagosRSAT());
	    dto.setTotalAnulacionesRSAT(result.getTotalAnulacionesRSAT());

	    dto.setTotalPagosSAT(result.getTotalPagosSAT());
	    dto.setTotalFinalPagosSAT(result.getTotalFinalPagosSAT());
	    dto.setTotalAnulacionesSAT(result.getTotalAnulacionesSAT());

	    dto.setDiferenciaRSATCRCMR(result.getDiferenciaRSATCRCMR());
	    dto.setDiferenciaSATCRCMR(result.getDiferenciaSATCRCMR());

	    dto.setVersionPOS(this.getVersionByDate(fechaNegocio).getDescription());

	    return dto;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    @Override
    public CuadraturaTarjetaCreditoDTO getCuadraturaTarjetaCredito(String fechaNegocio, long sucursal) {
	try {
	    CuadraturaTarjetaCreditoDTO dto = new CuadraturaTarjetaCreditoDTO();
	    String selectQuery = "Select cuad from CuadraturaTarjetaCredito cuad where cuad.sucursal ='" + sucursal
		    + "' and cuad.fechaTrx='" + fechaNegocio + "'";
	    Query query = em.createQuery(selectQuery);
	    CuadraturaTarjetaCredito result = (CuadraturaTarjetaCredito) query.getSingleResult();

	    dto.setAnulacionRecaudacionesPSCRE(result.getAnulacionRecaudacionesPSCRE());
	    dto.setDiferenciaPLCUAPSCRE(result.getDiferenciaPLCUAPSCRE());
	    dto.setDiferenciaPSCREPLC(result.getDiferenciaPSCREPLC());
	    dto.setDonaciones(result.getDonaciones());
	    dto.setFechaTrx(result.getFechaTrx());
	    dto.setId(result.getId());
	    dto.setRecaudacionesPSCRE(result.getRecaudacionesPSCRE());
	    dto.setSucursal(result.getSucursal());
	    dto.setTarjetaBancariaDiners(result.getTarjetaBancariaDiners());
	    dto.setTarjetaBancariaVisa(result.getTarjetaBancariaVisa());
	    dto.setTotalAnulacionesNCAPLC(result.getTotalAnulacionesNCAPLC());
	    dto.setTotalAnulacionRecaudacionesPLC(result.getTotalAnulacionRecaudacionesPLC());
	    dto.setTotalPLC(result.getTotalPLC());
	    dto.setTotalPLCUA(result.getTotalPLCUA());
	    dto.setTotalPSCRE(result.getTotalPSCRE());
	    dto.setTotalRecaudacionesPLC(result.getTotalRecaudacionesPLC());
	    dto.setTotalVentasAnulacionesPSCRE(result.getTotalVentasAnulacionesPSCRE());
	    dto.setTotalVentasInternetCreditoPLC(result.getTotalVentasInternetCreditoPLC());
	    dto.setTotalVentasInternetCreditoPSCRE(result.getTotalVentasInternetCreditoPSCRE());
	    dto.setTotalVentasTarjetaCreditoPLC(result.getTotalVentasTarjetaCreditoPLC());
	    dto.setTotalVentasTarjetaCreditoPSCRE(result.getTotalVentasTarjetaCreditoPSCRE());

	    dto.setPagoRemotoCreditoPLCUA(result.getPagoRemotoCreditoPLCUA());
	    dto.setPagoRemotoCreditoPSCRE(result.getPagoRemotoCreditoPSCRE());
	    dto.setTotalAnulacionesPagoRemoto(result.getTotalAnulacionesPagoRemoto());

	    dto.setTotalAnulacionesPagoRemotoCreditoPLC(result.getTotalAnulacionesPagoRemotoCreditoPLC());

	    dto.setTotalPagoRemotoPLC(result.getTotalPagoRemotoPLC());
	    dto.setTotalVentasPagoRemotoCreditoPLC(result.getTotalVentasPagoRemotoCreditoPLC());
	    dto.setTotalPagoRemotoPSCRE(result.getTotalPagoRemotoPSCRE());

	    dto.setDiferenciaPagoRemotoPSCREPLC(result.getDiferenciaPagoRemotoPSCREPLC());
	    dto.setDiferenciaPagoRemotoPLCUAPSCRE(result.getDiferenciaPagoRemotoPLCUAPSCRE());
	    dto.setVersionPOS(this.getVersionByDate(fechaNegocio).getDescription());

	    return dto;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    @Override
    public CuadraturaNotaCreditoDTO getCuadraturaNotaCredito(String fechaNegocio, long sucursal) {
	try {
	    CuadraturaNotaCreditoDTO dto = new CuadraturaNotaCreditoDTO();
	    String selectQuery = "Select cuad from CuadraturaNotaCredito cuad where cuad.sucursal ='" + sucursal
		    + "' and cuad.fechaTrx='" + fechaNegocio + "'";
	    Query query = em.createQuery(selectQuery);
	    CuadraturaNotaCredito result = (CuadraturaNotaCredito) query.getSingleResult();

	    dto.setDiferenciaPLACUAPSCRE(result.getDiferenciaPLACUAPSCRE());
	    dto.setDiferenciaPSCREPLC(result.getDiferenciaPSCREPLC());
	    dto.setFechaTrx(result.getFechaTrx());
	    dto.setId(result.getId());
	    dto.setNcrTvPLCUa(result.getNcrTvPLCUa());
	    dto.setSucursal(result.getSucursal());
	    dto.setTotalAnulacionesNCRPLC(result.getTotalAnulacionesNCRPLC());
	    dto.setTotalAnulacionesNCRPSCRE(result.getTotalAnulacionesNCRPSCRE());
	    dto.setVersionPOS(this.getVersionByDate(fechaNegocio).getDescription());

	    return dto;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    @Override
    public CuadraturaTarjetaDebitoDTO getCuadraturaTarjetaDebito(String fechaNegocio, long sucursal) {
	try {
	    CuadraturaTarjetaDebitoDTO dto = new CuadraturaTarjetaDebitoDTO();
	    String selectQuery = "Select cuad from CuadraturaTarjetaDebito cuad where cuad.sucursal ='" + sucursal
		    + "' and cuad.fechaTrx='" + fechaNegocio + "'";
	    Query query = em.createQuery(selectQuery);
	    CuadraturaTarjetaDebito result = (CuadraturaTarjetaDebito) query.getSingleResult();

	    dto.setDiferenciaPagoRemotoPLCUAPSDEB(result.getDiferenciaPagoRemotoPLCUAPSDEB());
	    dto.setDiferenciaPagoRemotoPSDEBPLD(result.getDiferenciaPagoRemotoPSDEBPLD());
	    dto.setDiferenciaPLCUAPSDEB(result.getDiferenciaPLCUAPSDEB());
	    dto.setDiferenciaPSDEBPLD(result.getDiferenciaPSDEBPLD());
	    dto.setFechaTrx(result.getFechaTrx());
	    dto.setPagoRemotoDebitoPLCUA(result.getPagoRemotoDebitoPLCUA());
	    dto.setSucursal(result.getSucursal());
	    dto.setTotalAnulacionesPagoRemotoDebitoPSDEB(result.getTotalAnulacionesPagoRemotoDebitoPSDEB());
	    dto.setTotalAnulacionPagoRemotoDebitoPLD(result.getTotalAnulacionPagoRemotoDebitoPLD());
	    dto.setTotalPagoRemotoPSDEB(result.getTotalPagoRemotoPSDEB());
	    dto.setTotalTarjetaDebitoPSDEB(result.getTotalTarjetaDebitoPSDEB());
	    dto.setTotalVEntasDEbitoPLD(result.getTotalVEntasDEbitoPLD());
	    dto.setTotalVentasInternetDebitoPLD(result.getTotalVentasInternetDebitoPLD());
	    dto.setTotalVentasInternetTarjetaDebitoPSDEB(result.getTotalVentasInternetTarjetaDebitoPSDEB());
	    dto.setTotalVentasPagoRemotoDebitoPLD(result.getTotalVentasPagoRemotoDebitoPLD());
	    dto.setTotalVentasTarjetaDebitoPLD(result.getTotalVentasTarjetaDebitoPLD());
	    dto.setTotalVentasTarjetaDebitoPSDEB(result.getTotalVentasTarjetaDebitoPSDEB());
	    dto.setTarjetaDebitoPLCUA(result.getTarjetaDebitoPLCUA());
	    dto.setTotalPagoRemotoDebitoPLD(result.getTotalPagoRemotoDebitoPLD());
	    dto.setVersionPOS(this.getVersionByDate(fechaNegocio).getDescription());
	    return dto;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

}
