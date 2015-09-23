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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaAvanceSuperAvanceDTO;

/**
 * Servlet implementation class ExcelAvanceSuperAvance
 */
public class ExcelAvanceSuperAvance extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelAvanceSuperAvance() {
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
	CuadraturaAvanceSuperAvanceDTO resultado = null;
	try {
	    resultado = dao.getCuadraturaAvanceSuperAvance(businessDate, sucursal);
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "attachment; filename=CuadraturAvanceSuperAvance_" + businessDate
		+ "_" + sucursal + ".xls");
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet hoja = workbook.createSheet("Cuadratura Avance y Súper Avance");

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
	hoja.setColumnWidth(10, 30 * 256);
	hoja.setColumnWidth(11, 10 * 256);
	hoja.setColumnWidth(12, 2 * 256);
	hoja.setColumnWidth(13, 30 * 256);
	hoja.setColumnWidth(14, 10 * 256);
	hoja.setColumnWidth(15, 2 * 256);

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

	HSSFCellStyle bordeInferiorIzquierdoLetraRoja = bordeInferiorIzquierdo;
	bordeInferiorIzquierdoLetraRoja.setFont(letraRoja);

	HSSFCellStyle bordeInferiorIzquierdoLetraAzul = bordeInferiorIzquierdo;
	bordeInferiorIzquierdoLetraAzul.setFont(letraAzul);

	HSSFCellStyle bordeIzquierdoLetraRoja = workbook.createCellStyle();
	bordeIzquierdoLetraRoja.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
	bordeIzquierdoLetraRoja.setFont(letraRoja);

	bordeIzquierdoLetraAzul.setFont(letraAzul);

	HSSFCellStyle bordeInferiorDerechoLetraRoja = bordeInferiorDerecho;
	bordeInferiorDerechoLetraRoja.setFont(letraRoja);

	HSSFFont letraNegrita = workbook.createFont();
	letraNegrita.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	HSSFCellStyle celdaLetraNegrita = workbook.createCellStyle();
	celdaLetraNegrita.setFont(letraNegrita);

	HSSFCellStyle celdaFecha = workbook.createCellStyle();
	celdaFecha.setDataFormat((short) HSSFCell.CELL_TYPE_STRING);

	if (resultado != null) {

	    celdas[1][1].setCellValue("Avance - Súper Avance");
	    celdas[1][1].setCellStyle(celdaLetraNegrita);
	    celdas[1][2].setCellValue("Fecha: " + businessDate);
	    celdas[1][4].setCellValue("Sucursal: " + sucursal);
	    celdas[1][5].setCellValue("V: " + resultado.getVersionPOS());

	    // //////////Primer Cuadro
	    celdas[3][1].setCellValue("PLCUA");
	    celdas[4][1].setCellValue("CMR");
	    celdas[5][1].setCellValue("AVANCE");
	    celdas[6][1].setCellValue("AVANCES ANULADOS");
	    celdas[7][1].setCellValue("TOTAL FINAL");
	    celdas[9][1].setCellValue("SÚPER AVANCE");
	    celdas[10][1].setCellValue("SÚPER AVANCE ANULADOS");
	    celdas[11][1].setCellValue("TOTAL FINAL");

	    celdas[5][2].setCellValue(resultado.getTotalAvanceCMR());
	    celdas[6][2].setCellValue(resultado.getTotalAnulacionesAvanceCMR());
	    celdas[7][2].setCellValue(resultado.getTotalAvance());
	    celdas[9][2].setCellValue(resultado.getTotalSuperAvanceCMR());
	    celdas[10][2].setCellValue(resultado.getTotalAnulacionesSuperAvanceCMR());
	    celdas[11][2].setCellValue(resultado.getTotalSuperavance());

	    celdas[4][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][1].setCellStyle(bordeIzquierdo);
	    celdas[6][1].setCellStyle(bordeIzquierdo);
	    celdas[7][1].setCellStyle(bordeIzquierdoLetraAzul);
	    celdas[8][1].setCellStyle(bordeIzquierdo);
	    celdas[9][1].setCellStyle(bordeIzquierdo);
	    celdas[10][1].setCellStyle(bordeIzquierdo);
	    celdas[11][1].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[4][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][2].setCellStyle(bordeDerecho);
	    celdas[6][2].setCellStyle(bordeDerecho);
	    celdas[7][2].setCellStyle(bordeTotalLetraAzul);
	    celdas[8][2].setCellStyle(bordeDerecho);
	    celdas[9][2].setCellStyle(bordeDerecho);
	    celdas[10][2].setCellStyle(bordeDerecho);
	    celdas[11][2].setCellStyle(bordeTotalLetraAzul);
	    // //////////Segundo Bloque
	    celdas[14][1].setCellValue("PLCUA AVANCE");
	    celdas[15][1].setCellValue("CRCMR AVANCE");
	    celdas[16][1].setCellValue("DIFERENCIA");

	    celdas[14][2].setCellValue(resultado.getTotalAvance());
	    celdas[15][2].setCellValue(resultado.getTotalAvanceCRCMR());
	    celdas[16][2].setCellValue(resultado.getDiferenciaAvancePLCUACRCMR());

	    celdas[14][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[15][1].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaAvancePLCUACRCMR() == 0) {
		celdas[16][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[14][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[15][2].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaAvancePLCUACRCMR() == 0) {
		celdas[16][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][2].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Tercer Bloque
	    celdas[19][1].setCellValue("PLCUA S AVANCE");
	    celdas[20][1].setCellValue("CRCMR S AVANCE");
	    celdas[21][1].setCellValue("DIFERENCIA");

	    celdas[19][2].setCellValue(resultado.getTotalSuperavance());
	    celdas[20][2].setCellValue(resultado.getTotalSuperAvanceCRCMR());
	    celdas[21][2].setCellValue(resultado.getDiferenciaAvancePLCUACRCMR());

	    celdas[19][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[20][1].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaAvancePLCUACRCMR() == 0) {
		celdas[21][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[21][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[19][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[20][2].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaAvancePLCUACRCMR() == 0) {
		celdas[21][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[21][2].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Cuarto Bloque
	    celdas[3][4].setCellValue("SCTFA");
	    celdas[4][4].setCellValue("CMR");
	    celdas[5][4].setCellValue("AVANCE");
	    celdas[6][4].setCellValue("AVANCES ANULADOS");
	    celdas[7][4].setCellValue("TOTAL FINAL");
	    celdas[9][4].setCellValue("SÚPER AVANCE");
	    celdas[10][4].setCellValue("SÚPER AVANCE ANULADOS");
	    celdas[11][4].setCellValue("TOTAL FINAL");

	    celdas[5][5].setCellValue(resultado.getTotalAvanceCMRARQTF());
	    celdas[6][5].setCellValue(resultado.getTotalAnulacionesAvanceCMRARQTF());
	    celdas[7][5].setCellValue(resultado.getTotalAvanceARQTF());
	    celdas[9][5].setCellValue(resultado.getTotalSuperAvanceCMRARQTF());
	    celdas[10][5].setCellValue(resultado.getTotalSuperAvanceCMRCRCMR());
	    celdas[11][5].setCellValue(resultado.getTotalSuperAvanceARQTF());

	    celdas[4][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][4].setCellStyle(bordeIzquierdo);
	    celdas[6][4].setCellStyle(bordeIzquierdo);
	    celdas[7][4].setCellStyle(bordeIzquierdoLetraAzul);
	    celdas[8][4].setCellStyle(bordeIzquierdo);
	    celdas[9][4].setCellStyle(bordeIzquierdo);
	    celdas[10][4].setCellStyle(bordeIzquierdo);
	    celdas[11][4].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[4][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][5].setCellStyle(bordeDerecho);
	    celdas[6][5].setCellStyle(bordeDerecho);
	    celdas[7][5].setCellStyle(bordeTotalLetraAzul);
	    celdas[8][5].setCellStyle(bordeDerecho);
	    celdas[9][5].setCellStyle(bordeDerecho);
	    celdas[10][5].setCellStyle(bordeDerecho);
	    celdas[11][5].setCellStyle(bordeTotalLetraAzul);
	    // //////////Quinto Bloque
	    celdas[14][4].setCellValue("PLCUA AVANCE");
	    celdas[15][4].setCellValue("SCTFA AVANCE");
	    celdas[16][4].setCellValue("DIFERENCIA");

	    celdas[14][5].setCellValue(resultado.getTotalAvance());
	    celdas[15][5].setCellValue(resultado.getTotalAvanceARQTF());
	    celdas[16][5].setCellValue(resultado.getDiferenciaAvancePLCUACRCMR());

	    celdas[14][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[15][4].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaAvancePLCUACRCMR() == 0) {
		celdas[16][4].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][4].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[14][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[15][5].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaAvancePLCUACRCMR() == 0) {
		celdas[16][5].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][5].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Sexto Bloque
	    celdas[19][4].setCellValue("PLCUA S AVANCE");
	    celdas[20][4].setCellValue("SCTFA S AVANCE");
	    celdas[21][4].setCellValue("DIFERENCIA");

	    celdas[19][5].setCellValue(resultado.getTotalSuperavance());
	    celdas[20][5].setCellValue(resultado.getTotalSuperAvanceARQTF());
	    celdas[21][5].setCellValue(resultado.getDiferenciaSuperAvancePLCUASCTFA());

	    celdas[19][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[20][4].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaSuperAvancePLCUASCTFA() == 0) {
		celdas[21][4].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[21][4].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[19][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[20][5].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaSuperAvancePLCUASCTFA() == 0) {
		celdas[21][5].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[21][5].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Septimo Bloque
	    celdas[3][7].setCellValue("CRCMR");
	    celdas[4][7].setCellValue("CMR");
	    celdas[5][7].setCellValue("TRX 220");
	    celdas[6][7].setCellValue("TRX 403");
	    celdas[7][7].setCellValue("TOTAL FINAL");
	    celdas[9][7].setCellValue("TRX 274");
	    celdas[10][7].setCellValue("TRX 473");
	    celdas[11][7].setCellValue("TOTAL FINAL");

	    celdas[5][8].setCellValue(resultado.getTotalAvanceCMRCRCMR());
	    celdas[6][8].setCellValue(resultado.getTotalAvanceAnuladosCMRCRCMR());
	    celdas[7][8].setCellValue(resultado.getTotalAvanceCRCMR());
	    celdas[9][8].setCellValue(resultado.getTotalSuperAvanceCMRCRCMR());
	    celdas[10][8].setCellValue(resultado.getTotalAnulacionesSuperAvanceCRCMR());
	    celdas[11][8].setCellValue(resultado.getTotalSuperAvanceCRCMR());

	    celdas[4][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][7].setCellStyle(bordeIzquierdo);
	    celdas[6][7].setCellStyle(bordeIzquierdo);
	    celdas[7][7].setCellStyle(bordeIzquierdoLetraAzul);
	    celdas[8][7].setCellStyle(bordeIzquierdo);
	    celdas[9][7].setCellStyle(bordeIzquierdo);
	    celdas[10][7].setCellStyle(bordeIzquierdo);
	    celdas[11][7].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[4][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][8].setCellStyle(bordeDerecho);
	    celdas[6][8].setCellStyle(bordeDerecho);
	    celdas[7][8].setCellStyle(bordeTotalLetraAzul);
	    celdas[8][8].setCellStyle(bordeDerecho);
	    celdas[9][8].setCellStyle(bordeDerecho);
	    celdas[10][8].setCellStyle(bordeDerecho);
	    celdas[11][8].setCellStyle(bordeTotalLetraAzul);
	    // //////////Octavo Bloque
	    celdas[14][7].setCellValue("CRCMR AVANCE");
	    celdas[15][7].setCellValue("SCTFA AVANCE");
	    celdas[16][7].setCellValue("DIFERENCIA");

	    celdas[14][8].setCellValue(resultado.getTotalAvanceCRCMR());
	    celdas[15][8].setCellValue(resultado.getTotalAvanceARQTF());
	    celdas[16][8].setCellValue(resultado.getDiferenciaAvanceSCTFACRCMR());

	    celdas[14][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[15][7].setCellStyle(bordeIzquierdo);

	    if (resultado.getDiferenciaAvanceSCTFACRCMR() == 0) {
		celdas[16][7].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][7].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[14][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[15][8].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaAvanceSCTFACRCMR() == 0) {
		celdas[16][8].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][8].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Noveno Bloque
	    celdas[19][7].setCellValue("CRCMR S  AVANCE");
	    celdas[20][7].setCellValue("SCTFA S AVANCE");
	    celdas[21][7].setCellValue("DIFERENCIA");

	    celdas[19][8].setCellValue(resultado.getTotalSuperAvanceCRCMR());
	    celdas[20][8].setCellValue(resultado.getTotalSuperAvanceARQTF());
	    celdas[21][8].setCellValue(resultado.getDiferenciaSuperAvanceSCTFACRCMR());

	    celdas[19][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[20][7].setCellStyle(bordeIzquierdo);
	    celdas[21][7].setCellStyle(bordeInferiorIzquierdoLetraRoja);

	    if (resultado.getDiferenciaSuperAvanceSCTFACRCMR() == 0) {
		celdas[21][7].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[21][7].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[19][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[20][8].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaSuperAvanceSCTFACRCMR() == 0) {
		celdas[21][8].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[21][8].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Decimo Bloque
	    celdas[4][10].setCellValue("SAT");
	    celdas[5][10].setCellValue("TRX 220");
	    celdas[6][10].setCellValue("TRX 403");
	    celdas[7][10].setCellValue("TOTAL FINAL");
	    celdas[9][10].setCellValue("TRX 274");
	    celdas[10][10].setCellValue("TRX 473");
	    celdas[11][10].setCellValue("TOTAL FINAL");

	    celdas[5][11].setCellValue(resultado.getTotalAnulacionesSuperAvanceCRCMR());
	    celdas[6][11].setCellValue(resultado.getTotalTrx220SAT());
	    celdas[7][11].setCellValue(resultado.getTotalSuperAvanceCRCMR());
	    celdas[9][11].setCellValue(resultado.getTotalAvanceCRCMR());
	    celdas[10][11].setCellValue(resultado.getTotalAvanceARQTF());
	    celdas[11][11].setCellValue(resultado.getTotalSuperAvanceFinalSAT());

	    celdas[4][10].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][10].setCellStyle(bordeIzquierdo);
	    celdas[6][10].setCellStyle(bordeIzquierdo);
	    celdas[7][10].setCellStyle(bordeIzquierdoLetraAzul);
	    celdas[8][10].setCellStyle(bordeIzquierdo);
	    celdas[9][10].setCellStyle(bordeIzquierdo);
	    celdas[10][10].setCellStyle(bordeIzquierdo);
	    celdas[11][10].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[4][11].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][11].setCellStyle(bordeDerecho);
	    celdas[6][11].setCellStyle(bordeDerecho);
	    celdas[7][11].setCellStyle(bordeTotalLetraAzul);
	    celdas[8][11].setCellStyle(bordeDerecho);
	    celdas[9][11].setCellStyle(bordeDerecho);
	    celdas[10][11].setCellStyle(bordeDerecho);
	    celdas[11][11].setCellStyle(bordeTotalLetraAzul);
	    // //////////Undecimo bloque
	    celdas[14][10].setCellValue("SAT");
	    celdas[15][10].setCellValue("CRCMR AVANCE");
	    celdas[16][10].setCellValue("DIFERENCIA");

	    celdas[14][11].setCellValue(resultado.getTotalAvanceFinalSAT());
	    celdas[15][11].setCellValue(resultado.getTotalAvanceCRCMR());
	    celdas[16][11].setCellValue(resultado.getDiferenciaSATCRCMRAvance());

	    celdas[14][10].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[15][10].setCellStyle(bordeIzquierdo);

	    if (resultado.getDiferenciaSATCRCMRAvance() == 0) {
		celdas[16][10].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][10].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[14][11].setCellStyle(bordeSuperiorDerecho);
	    celdas[15][11].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaSATCRCMRAvance() == 0) {
		celdas[16][11].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][11].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Duodecimmo Bloque
	    celdas[4][13].setCellValue("RSAT");
	    celdas[5][13].setCellValue("TRX 220");
	    celdas[6][13].setCellValue("TRX 403");
	    celdas[7][13].setCellValue("TOTAL FINAL");
	    celdas[9][13].setCellValue("TRX 274");
	    celdas[10][13].setCellValue("TRX 473");
	    celdas[11][13].setCellValue("TOTAL FINAL");

	    celdas[5][14].setCellValue(resultado.getTotalTrx220RSAT());
	    celdas[6][14].setCellValue(resultado.getTotalTrx403RSAT());
	    celdas[7][14].setCellValue(resultado.getTotalAvanceFinalRSAT());
	    celdas[9][14].setCellValue(resultado.getTotalTrx274RSAT());
	    celdas[10][14].setCellValue(resultado.getTotalTrx473RSAT());
	    celdas[11][14].setCellValue(resultado.getTotalSuperAvanceFinalRSAT());

	    celdas[4][13].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][13].setCellStyle(bordeIzquierdo);
	    celdas[6][13].setCellStyle(bordeIzquierdo);
	    celdas[7][13].setCellStyle(bordeIzquierdoLetraAzul);
	    celdas[8][13].setCellStyle(bordeIzquierdo);
	    celdas[9][13].setCellStyle(bordeIzquierdo);
	    celdas[10][13].setCellStyle(bordeIzquierdo);
	    celdas[11][13].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[4][14].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][14].setCellStyle(bordeDerecho);
	    celdas[6][14].setCellStyle(bordeDerecho);
	    celdas[7][14].setCellStyle(bordeTotalLetraAzul);
	    celdas[8][14].setCellStyle(bordeDerecho);
	    celdas[9][14].setCellStyle(bordeDerecho);
	    celdas[10][14].setCellStyle(bordeDerecho);
	    celdas[11][14].setCellStyle(bordeTotalLetraAzul);
	    // //////////Treceavo Bloque
	    celdas[14][13].setCellValue("RSAT");
	    celdas[15][13].setCellValue("CRCMR AVANCE");
	    celdas[16][13].setCellValue("DIFERENCIA");

	    celdas[14][14].setCellValue(resultado.getTotalSuperAvanceFinalRSAT());
	    celdas[15][14].setCellValue(resultado.getTotalSuperAvanceCRCMR());
	    celdas[16][14].setCellValue(resultado.getDiferenciaSATCRCMRAvance());

	    celdas[14][13].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[15][13].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaSATCRCMRAvance() == 0) {
		celdas[16][13].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][13].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[14][14].setCellStyle(bordeSuperiorDerecho);
	    celdas[15][14].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaSuperAvancePLCUACRCMR() == 0) {
		celdas[16][14].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][14].setCellStyle(bordeTotalLetraRoja);
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
