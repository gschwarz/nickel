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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaPagosCMRDTO;

/**
 * Servlet implementation class ExcelAvanceSuperAvance
 */
public class ExcelPagosCMR extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelPagosCMR() {
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
	CuadraturaPagosCMRDTO resultado = null;
	try {
	    resultado = dao.getCuadraturaPagosCMR(businessDate, sucursal);
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "attachment; filename=CuadraturaPagosCMR_" + businessDate + "_"
		+ sucursal + ".xls");
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet hoja = workbook.createSheet("Cuadratura Pagos CMR");

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

	    celdas[1][1].setCellValue("PAGOS CMR");
	    celdas[1][1].setCellStyle(celdaLetraNegrita);
	    celdas[1][2].setCellValue("Fecha: " + businessDate);
	    celdas[1][4].setCellValue("Sucursal: " + sucursal);
	    celdas[1][5].setCellValue("V: " + resultado.getVersionPOS());

	    // //////////primer bloque
	    celdas[3][1].setCellValue("PLCUA");
	    celdas[5][1].setCellValue("PAGO NORMAL");
	    celdas[6][1].setCellValue("PAGO REPACTADO");
	    celdas[7][1].setCellValue("PAGO ANULADO");
	    celdas[8][1].setCellValue("Total Pagos");

	    celdas[5][2].setCellValue(resultado.getPagoNormal());
	    celdas[6][2].setCellValue(resultado.getPagoRepactado());
	    celdas[7][2].setCellValue(resultado.getPagoAnulado());
	    celdas[8][2].setCellValue(resultado.getTotalPagos());

	    celdas[4][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][1].setCellStyle(bordeIzquierdo);
	    celdas[6][1].setCellStyle(bordeIzquierdo);
	    celdas[7][1].setCellStyle(bordeIzquierdo);
	    celdas[8][1].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[4][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][2].setCellStyle(bordeDerecho);
	    celdas[6][2].setCellStyle(bordeDerecho);
	    celdas[7][2].setCellStyle(bordeDerecho);
	    celdas[8][2].setCellStyle(bordeInferiorDerechoLetraAzul);
	    // //////////Segundo bloque
	    celdas[3][4].setCellValue("SCTFA");
	    celdas[4][4].setCellValue("CMR");
	    celdas[5][4].setCellValue("TOTAL ABONOS");
	    celdas[6][4].setCellValue("TOTAL ANULACIÓN ABONO");
	    celdas[8][4].setCellValue("Total Abonos");

	    celdas[5][5].setCellValue(resultado.getTotalAbonos());
	    celdas[6][5].setCellValue(resultado.getTotalAnulacionAbonoNormal());
	    celdas[8][5].setCellValue(resultado.getTotalPagosSctfa());

	    celdas[4][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][4].setCellStyle(bordeIzquierdo);
	    celdas[6][4].setCellStyle(bordeIzquierdo);
	    celdas[7][4].setCellStyle(bordeIzquierdo);
	    celdas[8][4].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[4][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][5].setCellStyle(bordeDerecho);
	    celdas[6][5].setCellStyle(bordeDerecho);
	    celdas[7][5].setCellStyle(bordeDerecho);
	    celdas[8][5].setCellStyle(bordeInferiorDerechoLetraAzul);
	    // //////////Tercer Bloque

	    celdas[3][7].setCellValue("CRCMR");
	    celdas[4][7].setCellValue("CMR");
	    celdas[5][7].setCellValue("TRX 217");
	    celdas[6][7].setCellValue("TRX 402");
	    celdas[8][7].setCellValue("Total Abonos");

	    celdas[5][8].setCellValue(resultado.getTrx217());
	    celdas[6][8].setCellValue(resultado.getTrx402());
	    celdas[8][8].setCellValue(resultado.getTotalCRCMR());

	    celdas[4][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][7].setCellStyle(bordeIzquierdo);
	    celdas[6][7].setCellStyle(bordeIzquierdo);
	    celdas[7][7].setCellStyle(bordeIzquierdo);
	    celdas[8][7].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[4][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][8].setCellStyle(bordeDerecho);
	    celdas[6][8].setCellStyle(bordeDerecho);
	    celdas[7][8].setCellStyle(bordeDerecho);
	    celdas[8][8].setCellStyle(bordeInferiorDerechoLetraAzul);
	    // //////////Cuarto Bloque
	    celdas[11][1].setCellValue("SAT");
	    celdas[12][1].setCellValue("TRX 217");
	    celdas[13][1].setCellValue("TRX 402");
	    celdas[15][1].setCellValue("Total Abonos");

	    celdas[12][2].setCellValue(resultado.getTotalPagosSAT());
	    celdas[13][2].setCellValue(resultado.getTotalAnulacionesSAT());
	    celdas[15][2].setCellValue(resultado.getTotalPagosSAT());

	    celdas[11][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[12][1].setCellStyle(bordeIzquierdo);
	    celdas[13][1].setCellStyle(bordeIzquierdo);
	    celdas[14][1].setCellStyle(bordeIzquierdo);
	    celdas[15][1].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[11][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[12][2].setCellStyle(bordeDerecho);
	    celdas[13][2].setCellStyle(bordeDerecho);
	    celdas[14][2].setCellStyle(bordeDerecho);
	    celdas[15][2].setCellStyle(bordeInferiorDerechoLetraAzul);
	    // //////////Quinto Bloque
	    celdas[11][4].setCellValue("RSAT");
	    celdas[12][4].setCellValue("TRX 217");
	    celdas[13][4].setCellValue("TRX 402");
	    celdas[15][4].setCellValue("Total Abonos");

	    celdas[12][5].setCellValue(resultado.getTotalPagosRSAT());
	    celdas[13][5].setCellValue(resultado.getTotalAnulacionesRSAT());
	    celdas[15][5].setCellValue(resultado.getTotalPagosRSAT());

	    celdas[11][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[12][4].setCellStyle(bordeIzquierdo);
	    celdas[13][4].setCellStyle(bordeIzquierdo);
	    celdas[14][4].setCellStyle(bordeIzquierdo);
	    celdas[15][4].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[11][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[12][5].setCellStyle(bordeDerecho);
	    celdas[13][5].setCellStyle(bordeDerecho);
	    celdas[14][5].setCellStyle(bordeDerecho);
	    celdas[15][5].setCellStyle(bordeInferiorDerechoLetraAzul);

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
