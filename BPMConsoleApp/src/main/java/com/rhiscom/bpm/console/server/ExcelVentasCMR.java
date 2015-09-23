package com.rhiscom.bpm.console.server;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.rhiscom.bpm.console.server.services.dao.QuadratureDAO;
import com.rhiscom.bpm.console.server.services.dao.ServiceDAOFactory;
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaVtaCMRDTO;

/**
 * Servlet implementation class ExcelAvanceSuperAvance
 */
public class ExcelVentasCMR extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelVentasCMR() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	    this.processRequest(request, response);
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	    IOException {
	try {
	    this.processRequest(request, response);
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    private void processRequest(HttpServletRequest request, final HttpServletResponse response)
	    throws ServletException, IOException, ParseException {
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	String businessDate = request.getParameter("businessDate");

	Long sucursal = Long.parseLong(request.getParameter("sucursal"));

	QuadratureDAO dao = ServiceDAOFactory.getInstance().getQuadratureDAO();
	CuadraturaVtaCMRDTO resultado = null;
	try {
	    resultado = dao.getCuadraturaVtaCMR(businessDate, sucursal);
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "attachment; filename=CuadraturaVentasCMR_" + businessDate + "_"
		+ sucursal + ".xls");
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet hoja = workbook.createSheet("Cuadratura Ventas CMR");

	HSSFCell[][] celdas = new HSSFCell[100][100];

	for (int f = 0; f < 100; f++) {
	    HSSFRow fila = hoja.createRow(f);
	    for (int c = 0; c < 100; c++) {
		celdas[f][c] = fila.createCell(c);
		celdas[f][c].setCellValue("");
	    }
	}

	hoja.setColumnWidth(0, 2 * 256);
	hoja.setColumnWidth(1, 30 * 256);
	hoja.setColumnWidth(2, 10 * 256);
	hoja.setColumnWidth(3, 2 * 256);
	hoja.setColumnWidth(4, 30 * 256);
	hoja.setColumnWidth(5, 10 * 256);
	hoja.setColumnWidth(6, 2 * 256);
	hoja.setColumnWidth(7, 30 * 256);
	hoja.setColumnWidth(8, 10 * 256);
	hoja.setColumnWidth(9, 2 * 256);

	HSSFCellStyle bordeTotal = workbook.createCellStyle();
	bordeTotal.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
	bordeTotal.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
	bordeTotal.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);
	bordeTotal.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);

	HSSFCellStyle bordeSuperiorDerecho = workbook.createCellStyle();
	bordeSuperiorDerecho.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
	bordeSuperiorDerecho.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);

	HSSFCellStyle bordeSuperiorIzquierdo = workbook.createCellStyle();
	bordeSuperiorIzquierdo.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
	bordeSuperiorIzquierdo.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);

	HSSFCellStyle bordeInferiorDerecho = workbook.createCellStyle();
	bordeInferiorDerecho.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
	bordeInferiorDerecho.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);

	HSSFCellStyle bordeInferiorIzquierdo = workbook.createCellStyle();
	bordeInferiorIzquierdo.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
	bordeInferiorIzquierdo.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);

	HSSFCellStyle bordeDerecho = workbook.createCellStyle();
	bordeDerecho.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);

	HSSFCellStyle bordeIzquierdo = workbook.createCellStyle();
	bordeIzquierdo.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);

	HSSFCellStyle bordeIzquierdoLetraAzul = workbook.createCellStyle();
	bordeIzquierdoLetraAzul.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);

	HSSFCellStyle bordeTotalLetraRoja = workbook.createCellStyle();
	bordeTotalLetraRoja.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
	bordeTotalLetraRoja.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
	bordeTotalLetraRoja.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);
	bordeTotalLetraRoja.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
	HSSFFont letraRoja = workbook.createFont();
	letraRoja.setColor(HSSFColor.RED.index);
	bordeTotalLetraRoja.setFont(letraRoja);

	HSSFCellStyle bordeTotalLetraAzul = workbook.createCellStyle();
	bordeTotalLetraAzul.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
	bordeTotalLetraAzul.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
	bordeTotalLetraAzul.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);
	bordeTotalLetraAzul.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
	HSSFFont letraAzul = workbook.createFont();
	letraAzul.setColor(HSSFColor.BLUE.index);
	bordeTotalLetraAzul.setFont(letraAzul);

	HSSFCellStyle bordeInferiorIzquierdoLetraRoja = workbook.createCellStyle();
	bordeInferiorIzquierdoLetraRoja.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
	bordeInferiorIzquierdoLetraRoja.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
	bordeInferiorIzquierdoLetraRoja.setFont(letraRoja);

	HSSFCellStyle bordeInferiorIzquierdoLetraAzul = workbook.createCellStyle();
	bordeInferiorIzquierdoLetraAzul.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
	bordeInferiorIzquierdoLetraAzul.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
	bordeInferiorIzquierdoLetraAzul.setFont(letraAzul);

	HSSFCellStyle bordeIzquierdoLetraRoja = workbook.createCellStyle();
	bordeIzquierdoLetraRoja.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
	bordeIzquierdoLetraRoja.setFont(letraRoja);

	bordeIzquierdoLetraAzul.setFont(letraAzul);

	HSSFCellStyle bordeInferiorDerechoLetraRoja = workbook.createCellStyle();
	bordeInferiorDerechoLetraRoja.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
	bordeInferiorDerechoLetraRoja.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);
	bordeInferiorDerechoLetraRoja.setFont(letraRoja);

	HSSFCellStyle bordeInferiorDerechoLetraAzul = workbook.createCellStyle();
	bordeInferiorDerechoLetraAzul.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
	bordeInferiorDerechoLetraAzul.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);
	bordeInferiorDerechoLetraAzul.setFont(letraAzul);

	HSSFFont letraNegrita = workbook.createFont();
	letraNegrita.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	HSSFCellStyle celdaLetraNegrita = workbook.createCellStyle();
	celdaLetraNegrita.setFont(letraNegrita);

	HSSFCellStyle celdaFecha = workbook.createCellStyle();
	celdaFecha.setDataFormat((short) HSSFCell.CELL_TYPE_STRING);

	if (resultado != null) {

	    celdas[1][1].setCellValue("VENTAS CMR");
	    celdas[1][1].setCellStyle(celdaLetraNegrita);
	    celdas[1][2].setCellValue("Fecha: " + businessDate);
	    celdas[1][4].setCellValue("Sucursal: " + sucursal);
	    celdas[1][5].setCellValue("V: " + resultado.getVersionPOS());
	    // //////////Primer Bloque
	    celdas[3][1].setCellValue("PLCUA");
	    celdas[4][1].setCellValue("");
	    celdas[5][1].setCellValue("Cuotas Normales");
	    celdas[6][1].setCellValue("Cuotas Diferidas");
	    celdas[7][1].setCellValue("3CC (tarjeta CMR)");
	    celdas[8][1].setCellValue("Donación");
	    celdas[9][1].setCellValue("NCR TF (campo Total)");
	    celdas[10][1].setCellValue("Total Final");

	    celdas[5][2].setCellValue(resultado.getCuotasNormales());
	    celdas[6][2].setCellValue(resultado.getCuotasDiferidas());
	    celdas[7][2].setCellValue(resultado.getTresCC());
	    celdas[8][2].setCellValue(resultado.getDonacionCMR());
	    celdas[9][2].setCellValue(resultado.getNcrTFTotal());
	    celdas[10][2].setCellValue(resultado.getTotalFinalPlaCuad());

	    celdas[4][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][1].setCellStyle(bordeIzquierdo);
	    celdas[6][1].setCellStyle(bordeIzquierdo);
	    celdas[7][1].setCellStyle(bordeIzquierdo);
	    celdas[8][1].setCellStyle(bordeIzquierdo);
	    celdas[9][1].setCellStyle(bordeIzquierdo);
	    celdas[10][1].setCellStyle(bordeTotalLetraAzul);

	    celdas[4][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][2].setCellStyle(bordeDerecho);
	    celdas[6][2].setCellStyle(bordeDerecho);
	    celdas[7][2].setCellStyle(bordeDerecho);
	    celdas[8][2].setCellStyle(bordeDerecho);
	    celdas[9][2].setCellStyle(bordeDerecho);
	    celdas[10][2].setCellStyle(bordeTotalLetraAzul);

	    // //////////Segundo Bloque
	    celdas[3][4].setCellValue("SCTFA");
	    celdas[4][4].setCellValue("");
	    celdas[5][4].setCellValue("Gran total de Ventas");
	    celdas[6][4].setCellValue("Gran total Recaudaciones");
	    celdas[7][4].setCellValue("Gran total Devoluciones CMR x NCA");
	    celdas[8][4].setCellValue("Gran total Devoluciones CMR x NCR");
	    celdas[9][4].setCellValue("Gran total anulación GIFTCARD");
	    celdas[10][4].setCellValue("Total Final");

	    celdas[5][5].setCellValue(resultado.getGranTotalVentas());
	    celdas[6][5].setCellValue(resultado.getGranTotalRecaudaciones());
	    celdas[7][5].setCellValue(resultado.getGranTotalDevolucionesCMRNCA());
	    celdas[8][5].setCellValue(resultado.getGranTotalDevolucionesCMRNCR());
	    celdas[9][5].setCellValue(resultado.getGranTotalAnulacionGiftcard());
	    celdas[10][5].setCellValue(resultado.getTotalFinalARQTF());

	    celdas[4][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][4].setCellStyle(bordeIzquierdo);
	    celdas[6][4].setCellStyle(bordeIzquierdo);
	    celdas[7][4].setCellStyle(bordeIzquierdo);
	    celdas[8][4].setCellStyle(bordeIzquierdo);
	    celdas[9][4].setCellStyle(bordeIzquierdo);
	    celdas[10][4].setCellStyle(bordeTotalLetraAzul);

	    celdas[4][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][5].setCellStyle(bordeDerecho);
	    celdas[6][5].setCellStyle(bordeDerecho);
	    celdas[7][5].setCellStyle(bordeDerecho);
	    celdas[8][5].setCellStyle(bordeDerecho);
	    celdas[9][5].setCellStyle(bordeDerecho);
	    celdas[9][5].setCellStyle(bordeDerecho);
	    celdas[10][5].setCellStyle(bordeTotalLetraAzul);
	    // //////////Tercer Bloque
	    celdas[3][7].setCellValue("CRCMR");
	    celdas[4][7].setCellValue("");
	    celdas[5][7].setCellValue("TRX 200");
	    celdas[6][7].setCellValue("TRX 400");
	    celdas[10][7].setCellValue("Total Final");

	    celdas[5][8].setCellValue(resultado.getTransacciones200());
	    celdas[6][8].setCellValue(resultado.getTransacciones400());
	    celdas[10][8].setCellValue(resultado.getTotalFinalTRX());

	    celdas[4][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][7].setCellStyle(bordeIzquierdo);
	    celdas[6][7].setCellStyle(bordeIzquierdo);
	    celdas[7][7].setCellStyle(bordeIzquierdo);
	    celdas[8][7].setCellStyle(bordeIzquierdo);
	    celdas[9][7].setCellStyle(bordeIzquierdo);
	    celdas[10][7].setCellStyle(bordeTotalLetraAzul);

	    celdas[4][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][8].setCellStyle(bordeDerecho);
	    celdas[6][8].setCellStyle(bordeDerecho);
	    celdas[7][8].setCellStyle(bordeDerecho);
	    celdas[8][8].setCellStyle(bordeDerecho);
	    celdas[9][8].setCellStyle(bordeDerecho);
	    celdas[10][8].setCellStyle(bordeTotalLetraAzul);
	    // //////////Cuarto Bloque
	    celdas[11 + 1][1].setCellValue("PLCUA");
	    celdas[12 + 1][1].setCellValue("CMR");
	    celdas[13 + 1][1].setCellValue("DIFERENCIA");

	    celdas[11 + 1][2].setCellValue(resultado.getTotalFinalPlaCuad());
	    celdas[12 + 1][2].setCellValue(resultado.getTotalFinalTRX());
	    celdas[13 + 1][2].setCellValue(resultado.getDiferenciaPlaCuadConVtaCMR());

	    celdas[11 + 1][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[12 + 1][1].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPlaCuadConVtaCMR() == 0) {
		celdas[14][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[14][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[11 + 1][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[12 + 1][2].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPlaCuadConVtaCMR() == 0) {
		celdas[14][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[14][2].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Quinto Bloque
	    celdas[11 + 1][4].setCellValue("PLCUA");
	    celdas[12 + 1][4].setCellValue("SCTFA");
	    celdas[13 + 1][4].setCellValue("DIFERENCIA");

	    celdas[11 + 1][5].setCellValue(resultado.getTotalFinalPlaCuad());
	    celdas[12 + 1][5].setCellValue(resultado.getTotalFinalARQTF());
	    celdas[13 + 1][5].setCellValue(resultado.getDiferenciaPlaCuadARQTF());

	    celdas[11 + 1][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[12 + 1][4].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPlaCuadARQTF() == 0) {
		celdas[14][4].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[14][4].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[11 + 1][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[12 + 1][5].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPlaCuadARQTF() == 0) {
		celdas[14][5].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[14][5].setCellStyle(bordeTotalLetraRoja);
	    }

	    // //////////Sexto Bloque
	    celdas[11 + 1][7].setCellValue("CRCMR");
	    celdas[12 + 1][7].setCellValue("SCTFA");
	    celdas[13 + 1][7].setCellValue("DIFERENCIA");

	    celdas[11 + 1][8].setCellValue(resultado.getTotalFinalTRX());
	    celdas[12 + 1][8].setCellValue(resultado.getTotalFinalARQTF());
	    celdas[13 + 1][8].setCellValue(resultado.getDiferenciaVtaCRMConARQTF());

	    celdas[11 + 1][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[12 + 1][7].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaVtaCRMConARQTF() == 0) {
		celdas[14][7].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[14][7].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[11 + 1][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[12 + 1][8].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaVtaCRMConARQTF() == 0) {
		celdas[14][8].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[14][8].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Septimo Bloque
	    celdas[15 + 1][1].setCellValue("PLDTF");
	    celdas[16 + 1][1].setCellValue("SCTFA (NCR)");
	    celdas[17 + 1][1].setCellValue("DIFERENCIA");

	    celdas[15 + 1][2].setCellValue(resultado.getPldtf());
	    celdas[17][2].setCellValue(resultado.getArqTFNCR());
	    celdas[17 + 1][2].setCellValue(resultado.getDiferenciaPldtfNCRConArqTFNCR());

	    celdas[15 + 1][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[16 + 1][1].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPldtfNCRConArqTFNCR() == 0) {
		celdas[18][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[18][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[15 + 1][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[16 + 1][2].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPldtfNCRConArqTFNCR() == 0) {
		celdas[18][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[18][2].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Octavo Bloque
	    celdas[15 + 1][4].setCellValue("PLDTF");
	    celdas[16 + 1][4].setCellValue("PLCUA");
	    celdas[17 + 1][4].setCellValue("DIFERENCIA");

	    celdas[15 + 1][5].setCellValue(resultado.getPldtf());
	    celdas[16 + 1][5].setCellValue(resultado.getPlacuadNCR());
	    celdas[17 + 1][5].setCellValue(resultado.getDiferenciaPlaCuadNCRConArqTFNCR());

	    celdas[15 + 1][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[16 + 1][4].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPlaCuadNCRConArqTFNCR() == 0) {
		celdas[18][4].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[18][4].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[15 + 1][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[16 + 1][5].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPlaCuadNCRConArqTFNCR() == 0) {
		celdas[18][5].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[18][5].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Noveno Bloque
	    celdas[15 + 1][7].setCellValue("LDTA");
	    celdas[16 + 1][7].setCellValue("LDTA DONACIÓN");
	    celdas[17 + 1][7].setCellValue("SCTFA (NCA)");
	    celdas[18 + 1][7].setCellValue("DIFERENCIA");

	    celdas[15 + 1][8].setCellValue(resultado.getLdta());
	    celdas[16 + 1][8].setCellValue(resultado.getLdtaDonacion());
	    celdas[17 + 1][8].setCellValue(resultado.getArqTFDonacion());
	    celdas[18 + 1][8].setCellValue(resultado.getDiferenciaLdtaConArqTFDonacion());

	    celdas[15 + 1][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[16 + 1][7].setCellStyle(bordeIzquierdo);
	    celdas[17 + 1][7].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaLdtaConArqTFDonacion() == 0) {
		celdas[18 + 1][7].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[18 + 1][7].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[15 + 1][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[16 + 1][8].setCellStyle(bordeDerecho);
	    celdas[17 + 1][8].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaLdtaConArqTFDonacion() == 0) {
		celdas[18 + 1][8].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[18 + 1][8].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Decimo Bloque
	    celdas[19 + 1][1].setCellValue("CRCMR");
	    celdas[20 + 1][1].setCellValue("RSAT");
	    celdas[21 + 1][1].setCellValue("DIFERENCIA");

	    celdas[19 + 1][2].setCellValue(resultado.getTotalFinalTRX());
	    celdas[20 + 1][2].setCellValue(resultado.getTotalFinalRSAT());
	    celdas[21 + 1][2].setCellValue(resultado.getDiferenciaRSATCRCMR());

	    celdas[19 + 1][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[20 + 1][1].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaRSATCRCMR() == 0) {
		celdas[22][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[22][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[19 + 1][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[20 + 1][2].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaRSATCRCMR() == 0) {
		celdas[22][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[22][2].setCellStyle(bordeTotalLetraRoja);
	    }

	    // ///////////Undecimo Bloque
	    celdas[19 + 1][4].setCellValue("CRCMR");
	    celdas[20 + 1][4].setCellValue("SAT");
	    celdas[21 + 1][4].setCellValue("DIFERENCIA");

	    celdas[19 + 1][5].setCellValue(resultado.getTotalFinalTRX());
	    celdas[20 + 1][5].setCellValue(resultado.getTotalFinalSAT());
	    celdas[21 + 1][5].setCellValue(resultado.getDiferenciaSATCRCMR());

	    celdas[19 + 1][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[20 + 1][4].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaSATCRCMR() == 0) {
		celdas[22][4].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[22][4].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[19 + 1][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[20 + 1][5].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaSATCRCMR() == 0) {
		celdas[22][5].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[22][5].setCellStyle(bordeTotalLetraRoja);
	    }

	} else {

	    celdas[1][2].setCellValue("Resultados no encontrados");
	}
	try {
	    workbook.write(response.getOutputStream());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}
