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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaActivacionGiftcardDTO;

/**
 * Servlet implementation class ExcelAvanceSuperAvance
 */
public class ExcelActivacionGiftCard extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelActivacionGiftCard() {
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
	CuadraturaActivacionGiftcardDTO resultado = null;
	try {
	    resultado = dao.getCuadraturaActivacionGiftCard(businessDate, sucursal);
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "attachment; filename=ActivacionGiftCard_" + businessDate + "_"
		+ sucursal + ".xls");
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet hoja = workbook.createSheet("Cuadratura Activación Gift Card CMR");

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

	HSSFCellStyle bordeIzquierdoLetraRoja = bordeInferiorIzquierdo;
	bordeIzquierdoLetraRoja.setFont(letraRoja);

	HSSFCellStyle bordeInferiorDerechoLetraRoja = bordeInferiorDerecho;
	bordeInferiorDerechoLetraRoja.setFont(letraRoja);

	HSSFFont letraNegrita = workbook.createFont();
	letraNegrita.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	HSSFCellStyle celdaLetraNegrita = workbook.createCellStyle();
	celdaLetraNegrita.setFont(letraNegrita);

	HSSFCellStyle celdaFecha = workbook.createCellStyle();
	celdaFecha.setDataFormat((short) HSSFCell.CELL_TYPE_STRING);
	if (resultado != null) {

	    celdas[1][1].setCellValue("Activación Giftcard CMR");
	    celdas[1][1].setCellStyle(celdaLetraNegrita);
	    celdas[1][2].setCellValue("Fecha: " + businessDate);
	    celdas[1][4].setCellValue("Sucursal: " + sucursal);
	    celdas[1][5].setCellValue("V: " + resultado.getVersionPOS());
	    // //////////Primer Bloque
	    celdas[3][1].setCellValue("PLCUA");
	    celdas[4][1].setCellValue("GIFT CARD CMR");
	    celdas[5][1].setCellValue("Activación GIFT CARD CMR");
	    celdas[6][1].setCellValue("Anulación GIFT CARD CMR");
	    celdas[7][1].setCellValue("Sub total");
	    celdas[8][1].setCellValue("GIFTCARD CORPORATIVA");
	    celdas[9][1].setCellValue("Activación GIFT CARD CORPORATIVA");
	    celdas[10][1].setCellValue("ANULACIÓN ACT GIFT CARD CORPORATIVA");
	    celdas[11][1].setCellValue("Sub total");
	    celdas[12][1].setCellValue("Total");

	    celdas[5][2].setCellValue(resultado.getActivacionGiftCardCMR());
	    celdas[6][2].setCellValue(resultado.getAnulacionGiftCardCMR());
	    celdas[7][2].setCellValue(resultado.getTotalGiftCMR());
	    celdas[9][2].setCellValue(resultado.getActivacionGiftCardCorporativa());
	    celdas[10][2].setCellValue(resultado.getAnulacionGiftCardCorporativa());
	    celdas[11][2].setCellValue(resultado.getTotalGiftCorporativa());
	    celdas[12][2].setCellValue(resultado.getTotalGiftCard());

	    celdas[4][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][1].setCellStyle(bordeIzquierdo);
	    celdas[6][1].setCellStyle(bordeIzquierdo);
	    celdas[7][1].setCellStyle(bordeIzquierdo);
	    celdas[8][1].setCellStyle(bordeIzquierdo);
	    celdas[9][1].setCellStyle(bordeIzquierdo);
	    celdas[10][1].setCellStyle(bordeIzquierdo);
	    celdas[11][1].setCellStyle(bordeIzquierdo);
	    celdas[12][1].setCellStyle(bordeTotalLetraAzul);

	    celdas[4][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][2].setCellStyle(bordeDerecho);
	    celdas[6][2].setCellStyle(bordeDerecho);
	    celdas[7][2].setCellStyle(bordeTotalLetraAzul);
	    celdas[8][2].setCellStyle(bordeDerecho);
	    celdas[9][2].setCellStyle(bordeDerecho);
	    celdas[10][2].setCellStyle(bordeDerecho);
	    celdas[11][2].setCellStyle(bordeTotalLetraAzul);
	    celdas[12][2].setCellStyle(bordeTotalLetraRoja);

	    // /////////Segundo Bloque
	    celdas[3][4].setCellValue("MPAGC");
	    celdas[4][4].setCellValue("COD. 05");
	    celdas[5][4].setCellValue("ACT (Activación) CMR Cod 55");
	    celdas[6][4].setCellValue("AAC (Anulación Activación) CMR Cod 58");
	    celdas[7][4].setCellValue("Sub total");
	    celdas[8][4].setCellValue("GIFTCARD CORPORATIVA");
	    celdas[9][4].setCellValue("ACT (Activación) Corporativa Cod 55");
	    celdas[10][4].setCellValue("AAC (Anulación Activación) corporativa");
	    celdas[11][4].setCellValue("Sub total");
	    celdas[12][4].setCellValue("Total");

	    celdas[5][5].setCellValue(resultado.getTotalActGiftCMR());
	    celdas[6][5].setCellValue(resultado.getTotalACCGiftCMR());
	    celdas[7][5].setCellValue(resultado.getTotalGiftCMR2());
	    celdas[9][5].setCellValue(resultado.getTotalActGiftCorporativa());
	    celdas[10][5].setCellValue(resultado.getTotalACCGiftCorporativa());
	    celdas[11][5].setCellValue(resultado.getTotalGiftCorporativa2());
	    celdas[12][5].setCellValue(resultado.getTotalGiftCard2());

	    celdas[4][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[5][4].setCellStyle(bordeIzquierdo);
	    celdas[6][4].setCellStyle(bordeIzquierdo);
	    celdas[7][4].setCellStyle(bordeIzquierdo);
	    celdas[8][4].setCellStyle(bordeIzquierdo);
	    celdas[9][4].setCellStyle(bordeIzquierdo);
	    celdas[10][4].setCellStyle(bordeIzquierdo);
	    celdas[11][4].setCellStyle(bordeIzquierdo);
	    celdas[12][4].setCellStyle(bordeTotalLetraRoja);

	    celdas[4][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[5][5].setCellStyle(bordeDerecho);
	    celdas[6][5].setCellStyle(bordeDerecho);
	    celdas[7][5].setCellStyle(bordeTotalLetraAzul);
	    celdas[8][5].setCellStyle(bordeDerecho);
	    celdas[9][5].setCellStyle(bordeDerecho);
	    celdas[10][5].setCellStyle(bordeDerecho);
	    celdas[11][5].setCellStyle(bordeTotalLetraAzul);
	    celdas[12][5].setCellStyle(bordeTotalLetraRoja);

	    // //////////Tercer Bloque
	    celdas[14][1].setCellValue("PLCUA GIFT CORPORATIVA");
	    celdas[15][1].setCellValue("PLCUA GIFT CMR");
	    celdas[16][1].setCellValue("MPAGC CMR+CORPORATIVA");
	    celdas[17][1].setCellValue("Diferencia");

	    celdas[14][2].setCellValue(resultado.getTotalGiftCorporativa());
	    celdas[15][2].setCellValue(resultado.getTotalGiftCMR());
	    celdas[16][2].setCellValue(resultado.getTotalGiftCard2());
	    celdas[17][2].setCellValue(resultado.getDiferenciaPlaCuadConPLGC());

	    celdas[14][1].setCellStyle(bordeTotal);
	    celdas[15][1].setCellStyle(bordeTotal);
	    celdas[16][1].setCellStyle(bordeTotal);
	    if (resultado.getDiferenciaPlaCuadConPLGC() == 0) {
		celdas[17][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[17][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[14][2].setCellStyle(bordeTotal);
	    celdas[15][2].setCellStyle(bordeTotal);
	    celdas[16][2].setCellStyle(bordeTotal);
	    if (resultado.getDiferenciaPlaCuadConPLGC() == 0) {
		celdas[17][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[17][2].setCellStyle(bordeTotalLetraRoja);
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
