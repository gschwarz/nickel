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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaNotaCreditoDTO;

/**
 * Servlet implementation class ExcelAvanceSuperAvance
 */
public class ExcelNotaCredito extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelNotaCredito() {
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
	CuadraturaNotaCreditoDTO resultado = null;
	try {
	    resultado = dao.getCuadraturaNotaCredito(businessDate, sucursal);
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "attachment; filename=NotaCredito_" + businessDate + "_" + sucursal
		+ ".xls");
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet hoja = workbook.createSheet("Cuadratura Ventas de Tarjeta de Crédito");

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

	    celdas[1][1].setCellValue("Revisión de Crédito");
	    celdas[1][1].setCellStyle(celdaLetraNegrita);
	    celdas[1][2].setCellValue("Fecha: " + businessDate);
	    celdas[1][4].setCellValue("Sucursal: " + sucursal);
	    celdas[1][5].setCellValue("V: " + resultado.getVersionPOS());
	    // //////////Primer Bloque
	    celdas[3][1].setCellValue("PLCUA");
	    celdas[4][1].setCellValue("NCR TV");

	    celdas[4][2].setCellValue(resultado.getNcrTvPLCUa());

	    celdas[3][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[4][1].setCellStyle(bordeInferiorIzquierdo);

	    celdas[3][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[4][2].setCellStyle(bordeInferiorDerecho);
	    // //////////Segundo Bloque
	    celdas[3][4].setCellValue("PSCRE");
	    celdas[4][4].setCellValue("Anulaciones por NCR");

	    celdas[4][5].setCellValue(resultado.getTotalAnulacionesNCRPSCRE());

	    celdas[3][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[4][4].setCellStyle(bordeInferiorIzquierdo);

	    celdas[3][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[4][5].setCellStyle(bordeInferiorDerecho);
	    // //////////Tercer Bloque
	    celdas[3][7].setCellValue("PLVCR");
	    celdas[4][7].setCellValue("Anulaciones por NCR");

	    celdas[4][8].setCellValue(resultado.getTotalAnulacionesNCRPLC());

	    celdas[3][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[4][7].setCellStyle(bordeInferiorIzquierdo);

	    celdas[3][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[4][8].setCellStyle(bordeInferiorDerecho);
	    // //////////Cuarto Bloque
	    celdas[6][1].setCellValue("NCR TV (PLCUA)");
	    celdas[7][1].setCellValue("Anulación x NCR (PSCRE)");
	    celdas[8][1].setCellValue("Diferencia");

	    celdas[6][2].setCellValue(resultado.getNcrTvPLCUa());
	    celdas[7][2].setCellValue(resultado.getTotalAnulacionesNCRPSCRE());
	    celdas[8][2].setCellValue(resultado.getDiferenciaPLACUAPSCRE());

	    celdas[6][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[7][1].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPLACUAPSCRE() == 0) {
		celdas[8][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[8][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[6][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[7][2].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPLACUAPSCRE() == 0) {
		celdas[8][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[8][2].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Quinto Bloque
	    celdas[6][4].setCellValue("NCR TV (PSCRE)");
	    celdas[7][4].setCellValue("TOTAL ANULACIÓN RECAUDACIONES");
	    celdas[8][4].setCellValue("Diferencia");

	    celdas[6][5].setCellValue(resultado.getTotalAnulacionesNCRPSCRE());
	    celdas[7][5].setCellValue(resultado.getTotalAnulacionesNCRPLC());
	    celdas[8][5].setCellValue(resultado.getDiferenciaPSCREPLC());

	    celdas[6][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[7][4].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPSCREPLC() == 0) {
		celdas[8][4].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[8][4].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[6][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[7][5].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPSCREPLC() == 0) {
		celdas[8][5].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[8][5].setCellStyle(bordeTotalLetraRoja);
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
