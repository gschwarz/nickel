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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaCreditoDTO;

/**
 * Servlet implementation class ExcelAvanceSuperAvance
 */
public class ExcelTarjetaCredito extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelTarjetaCredito() {
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
	CuadraturaTarjetaCreditoDTO resultado = null;
	try {
	    resultado = dao.getCuadraturaTarjetaCredito(businessDate, sucursal);
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "attachment; filename=CuadraturaTarjetaCredito_" + businessDate + "_"
		+ sucursal + ".xls");
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet hoja = workbook.createSheet("Cuadratura tarjeta de crédito");

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

	    celdas[1][1].setCellValue("Revisión de Crédito");
	    celdas[1][1].setCellStyle(celdaLetraNegrita);
	    celdas[1][2].setCellValue("Fecha: " + businessDate);
	    celdas[1][4].setCellValue("Sucursal: " + sucursal);
	    celdas[1][5].setCellValue("V: " + resultado.getVersionPOS());
	    // ///////////primer Bloque
	    celdas[2][1].setCellValue("PLCUA");
	    celdas[3][1].setCellValue("Tarjeta Bancaria Visa");
	    celdas[4][1].setCellValue("Tarjeta Bancaria Diners");
	    celdas[5][1].setCellValue("Donaciones");
	    celdas[11][1].setCellValue("Total PLCUA");

	    celdas[3][2].setCellValue(resultado.getTarjetaBancariaVisa());
	    celdas[4][2].setCellValue(resultado.getTarjetaBancariaDiners());
	    celdas[5][2].setCellValue(resultado.getDonaciones());
	    celdas[11][2].setCellValue(resultado.getTotalPLCUA());

	    celdas[3][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[4][1].setCellStyle(bordeIzquierdo);
	    celdas[5][1].setCellStyle(bordeIzquierdo);
	    celdas[6][1].setCellStyle(bordeIzquierdo);
	    celdas[7][1].setCellStyle(bordeIzquierdo);
	    celdas[8][1].setCellStyle(bordeIzquierdo);
	    celdas[9][1].setCellStyle(bordeIzquierdo);
	    celdas[10][1].setCellStyle(bordeIzquierdo);
	    celdas[11][1].setCellStyle(bordeTotalLetraAzul);

	    celdas[3][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[4][2].setCellStyle(bordeDerecho);
	    celdas[5][2].setCellStyle(bordeDerecho);
	    celdas[6][2].setCellStyle(bordeDerecho);
	    celdas[7][2].setCellStyle(bordeDerecho);
	    celdas[8][2].setCellStyle(bordeDerecho);
	    celdas[9][2].setCellStyle(bordeDerecho);
	    celdas[10][2].setCellStyle(bordeDerecho);
	    celdas[11][2].setCellStyle(bordeTotalLetraAzul);
	    // //////////Segundo Bloque
	    celdas[2][4].setCellValue("PSCRE");

	    celdas[3][4].setCellValue("Total Ventas Tarjeta de Crédito");
	    celdas[4][4].setCellValue("Total Ventas Internet Crédito");
	    celdas[5][4].setCellValue("Total Ventas Anulaciones x NCA");
	    celdas[6][4].setCellValue("Donaciones");
	    celdas[7][4].setCellValue("Recaudaciones");
	    celdas[8][4].setCellValue("Anulaciones de Recaudación");
	    celdas[11][4].setCellValue("Total PSCRE");

	    celdas[3][5].setCellValue(resultado.getTotalVentasTarjetaCreditoPSCRE());
	    celdas[4][5].setCellValue(resultado.getTotalVentasInternetCreditoPSCRE());
	    celdas[5][5].setCellValue(resultado.getTotalVentasAnulacionesPSCRE());
	    celdas[6][5].setCellValue(resultado.getDonaciones());
	    celdas[7][5].setCellValue(resultado.getRecaudacionesPSCRE());
	    celdas[8][5].setCellValue(resultado.getAnulacionRecaudacionesPSCRE());
	    celdas[11][5].setCellValue(resultado.getTotalPSCRE());

	    celdas[3][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[4][4].setCellStyle(bordeIzquierdo);
	    celdas[5][4].setCellStyle(bordeIzquierdo);
	    celdas[6][4].setCellStyle(bordeIzquierdo);
	    celdas[7][4].setCellStyle(bordeIzquierdo);
	    celdas[8][4].setCellStyle(bordeIzquierdo);
	    celdas[9][4].setCellStyle(bordeIzquierdo);
	    celdas[10][4].setCellStyle(bordeIzquierdo);
	    celdas[11][4].setCellStyle(bordeTotalLetraAzul);

	    celdas[3][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[4][5].setCellStyle(bordeDerecho);
	    celdas[5][5].setCellStyle(bordeDerecho);
	    celdas[6][5].setCellStyle(bordeDerecho);
	    celdas[7][5].setCellStyle(bordeDerecho);
	    celdas[8][5].setCellStyle(bordeDerecho);
	    celdas[9][5].setCellStyle(bordeDerecho);
	    celdas[10][5].setCellStyle(bordeDerecho);
	    celdas[11][5].setCellStyle(bordeTotalLetraAzul);
	    // //////////Terce
	    celdas[2][7].setCellValue("PLVCR");
	    celdas[3][7].setCellValue("Total Ventas Tarjeta de Crédito");
	    celdas[4][7].setCellValue("Total Ventas Internet Crédito");
	    celdas[5][7].setCellValue("Total Ventas Anulaciones x NCA");
	    celdas[6][7].setCellValue("Total Ventas Anulaciones x NCR");
	    celdas[7][7].setCellValue("TOTAL ANULACIONES INTERNET NCA");
	    celdas[8][7].setCellValue("TOTAL ANULACIONES INTERNET NCR");
	    celdas[9][7].setCellValue("TOTAL RECAUDACIONES");
	    celdas[10][7].setCellValue("TOTAL ANULACION RECAUDACIONES");
	    celdas[11][7].setCellValue("Total PLVCR");

	    celdas[3][8].setCellValue(resultado.getTotalVentasInternetCreditoPLC());
	    celdas[4][8].setCellValue(resultado.getTotalVentasInternetCreditoPLC());
	    celdas[5][8].setCellValue(resultado.getTotalAnulacionesPagoRemoto());
	    celdas[6][8].setCellValue(0);
	    celdas[7][8].setCellValue(0);
	    celdas[8][8].setCellValue(0);
	    celdas[9][8].setCellValue(resultado.getTotalRecaudacionesPLC());
	    celdas[10][8].setCellValue(resultado.getTotalAnulacionRecaudacionesPLC());
	    celdas[11][8].setCellValue(resultado.getTotalPLC());

	    celdas[3][7].setCellStyle(bordeSuperiorDerecho);
	    celdas[4][7].setCellStyle(bordeDerecho);
	    celdas[5][7].setCellStyle(bordeDerecho);
	    celdas[6][7].setCellStyle(bordeDerecho);
	    celdas[7][7].setCellStyle(bordeDerecho);
	    celdas[8][7].setCellStyle(bordeDerecho);
	    celdas[9][7].setCellStyle(bordeDerecho);
	    celdas[10][7].setCellStyle(bordeDerecho);
	    celdas[11][7].setCellStyle(bordeTotalLetraAzul);

	    celdas[3][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[4][8].setCellStyle(bordeDerecho);
	    celdas[5][8].setCellStyle(bordeDerecho);
	    celdas[6][8].setCellStyle(bordeDerecho);
	    celdas[7][8].setCellStyle(bordeDerecho);
	    celdas[8][8].setCellStyle(bordeDerecho);
	    celdas[9][8].setCellStyle(bordeDerecho);
	    celdas[10][8].setCellStyle(bordeDerecho);
	    celdas[11][8].setCellStyle(bordeTotalLetraAzul);
	    // //////////Cuarto Bloque
	    celdas[14][1].setCellValue("PLCUA");
	    celdas[15][1].setCellValue("PSCRE");
	    celdas[16][1].setCellValue("Diferencia");

	    celdas[14][2].setCellValue(resultado.getTotalPLCUA());
	    celdas[15][2].setCellValue(resultado.getTotalPSCRE());
	    celdas[16][2].setCellValue(resultado.getTotalPSCRE());

	    celdas[14][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[15][1].setCellStyle(bordeIzquierdo);
	    if (resultado.getTotalPSCRE() == 0) {
		celdas[16][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[14][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[15][2].setCellStyle(bordeDerecho);
	    if (resultado.getTotalPSCRE() == 0) {
		celdas[16][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][2].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Quinto Bloque
	    celdas[14][4].setCellValue("PSCRE");
	    celdas[15][4].setCellValue("PLVCR");
	    celdas[16][4].setCellValue("Diferencia");

	    celdas[14][5].setCellValue(resultado.getTotalPSCRE());
	    celdas[15][5].setCellValue(resultado.getTotalPLC());
	    celdas[16][5].setCellValue(resultado.getDiferenciaPSCREPLC());

	    celdas[14][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[15][4].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPLCUAPSCRE() == 0) {
		celdas[16][4].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][4].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[14][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[15][5].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPLCUAPSCRE() == 0) {
		celdas[16][5].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[16][5].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Sexto Bloque
	    celdas[18][1].setCellValue("Revisión Pago Remoto Crédito");
	    celdas[19][1].setCellValue("PLCUA");
	    celdas[22][1].setCellValue("Pago Remoto Crédito");

	    celdas[22][2].setCellValue(resultado.getPagoRemotoCreditoPLCUA());

	    celdas[20][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[21][1].setCellStyle(bordeIzquierdo);
	    celdas[22][1].setCellStyle(bordeTotalLetraAzul);

	    celdas[20][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[21][2].setCellStyle(bordeDerecho);
	    celdas[22][2].setCellStyle(bordeTotalLetraAzul);
	    // //////////Septimo Bloque
	    celdas[19][4].setCellValue("PSCRE");
	    celdas[20][4].setCellValue("Total Ventas Pago Remoto Crédito");
	    celdas[21][4].setCellValue("Total Anulación Pago Remoto Crédito");
	    celdas[22][4].setCellValue("Total Pago Remoto PSCRE");

	    celdas[20][5].setCellValue(resultado.getPagoRemotoCreditoPSCRE());
	    celdas[21][5].setCellValue(resultado.getTotalAnulacionesPagoRemoto());
	    celdas[22][5].setCellValue(resultado.getTotalPagoRemotoPSCRE());

	    celdas[20][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[21][4].setCellStyle(bordeIzquierdo);
	    celdas[22][4].setCellStyle(bordeTotalLetraAzul);

	    celdas[20][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[21][5].setCellStyle(bordeDerecho);
	    celdas[22][5].setCellStyle(bordeTotalLetraAzul);
	    // //////////Octavo Bloque
	    celdas[19][7].setCellValue("PLVCR");
	    celdas[20][7].setCellValue("Total Ventas Pago Remoto Crédito");
	    celdas[21][7].setCellValue("Total Anulación Pago Remoto Crédito");
	    celdas[22][7].setCellValue("Total Pago Remoto PLVCR");

	    celdas[20][8].setCellValue(resultado.getTotalVentasPagoRemotoCreditoPLC());
	    celdas[21][8].setCellValue(resultado.getTotalAnulacionesPagoRemotoCreditoPLC());
	    celdas[22][8].setCellValue(resultado.getTotalPagoRemotoPLC());

	    celdas[20][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[21][7].setCellStyle(bordeIzquierdo);
	    celdas[22][7].setCellStyle(bordeTotalLetraAzul);

	    celdas[20][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[21][8].setCellStyle(bordeDerecho);
	    celdas[22][8].setCellStyle(bordeTotalLetraAzul);
	    // //////////Noveno Bloque
	    celdas[24][1].setCellValue("PLCUA");
	    celdas[25][1].setCellValue("PSCRE");
	    celdas[26][1].setCellValue("Diferencia");

	    celdas[24][2].setCellValue("");
	    celdas[25][2].setCellValue(resultado.getTotalPagoRemotoPSCRE());
	    celdas[26][2].setCellValue(resultado.getDiferenciaPagoRemotoPLCUAPSCRE());

	    celdas[24][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[25][1].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPagoRemotoPLCUAPSCRE() == 0) {
		celdas[26][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[26][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[24][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[25][2].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPagoRemotoPLCUAPSCRE() == 0) {
		celdas[26][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[26][2].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Decimo Bloque
	    celdas[24][4].setCellValue("PSCRE");
	    celdas[25][4].setCellValue("PLVCR");
	    celdas[26][4].setCellValue("Diferencia");

	    celdas[24][5].setCellValue(resultado.getTotalPagoRemotoPSCRE());
	    celdas[25][5].setCellValue(resultado.getTotalPagoRemotoPLC());
	    celdas[26][5].setCellValue(resultado.getDiferenciaPagoRemotoPSCREPLC());

	    celdas[24][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[25][4].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPagoRemotoPSCREPLC() == 0) {
		celdas[26][4].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[26][4].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[24][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[25][5].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPagoRemotoPSCREPLC() == 0) {
		celdas[26][5].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[26][5].setCellStyle(bordeTotalLetraRoja);
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
