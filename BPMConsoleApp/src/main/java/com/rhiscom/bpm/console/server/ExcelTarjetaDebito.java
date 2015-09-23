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
import com.rhiscom.bpm.console.shared.model.dto.CuadraturaTarjetaDebitoDTO;

/**
 * Servlet implementation class ExcelAvanceSuperAvance
 */
public class ExcelTarjetaDebito extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelTarjetaDebito() {
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
	CuadraturaTarjetaDebitoDTO resultado = null;
	try {
	    resultado = dao.getCuadraturaTarjetaDebito(businessDate, sucursal);
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "attachment; filename=CuadraturaTarjetaDebito_" + businessDate + "_"
		+ sucursal + ".xls");
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet hoja = workbook.createSheet("Cuadratura Ventas de Tarjeta de Débito");

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

	    celdas[1][1].setCellValue("Revisión de Débito");
	    celdas[1][1].setCellStyle(celdaLetraNegrita);
	    celdas[1][2].setCellValue("Fecha: " + businessDate);
	    celdas[1][4].setCellValue("Sucursal: " + sucursal);
	    celdas[1][5].setCellValue("V: ");
	    // //////////Primer Bloque
	    celdas[2][1].setCellValue("PLCUA");
	    celdas[3][1].setCellValue("Tarjeta Débito");

	    celdas[3][2].setCellValue(resultado.getTarjetaDebitoPLCUA());

	    celdas[3][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[4][1].setCellStyle(bordeIzquierdo);
	    celdas[5][1].setCellStyle(bordeIzquierdo);
	    celdas[6][1].setCellStyle(bordeInferiorIzquierdo);

	    celdas[3][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[4][2].setCellStyle(bordeDerecho);
	    celdas[5][2].setCellStyle(bordeDerecho);
	    celdas[6][2].setCellStyle(bordeInferiorDerecho);
	    // //////////Segundo Bloque
	    celdas[2][4].setCellValue("PSDEB");
	    celdas[3][4].setCellValue("TOTAL VENTAS TARJETA DÉBITO");
	    celdas[4][4].setCellValue("TOTAL VENTAS INTERNET DÉBITO");
	    celdas[5][4].setCellValue("TOTAL RECAUDACIONES");
	    celdas[6][4].setCellValue("Total PSDEB");

	    celdas[3][5].setCellValue(resultado.getTotalVentasTarjetaDebitoPSDEB());
	    celdas[4][5].setCellValue(resultado.getTotalVentasInternetTarjetaDebitoPSDEB());
	    celdas[5][5].setCellValue(0);
	    celdas[6][5].setCellValue(resultado.getTotalTarjetaDebitoPSDEB());

	    celdas[3][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[4][4].setCellStyle(bordeIzquierdo);
	    celdas[5][4].setCellStyle(bordeIzquierdo);
	    celdas[6][4].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[3][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[4][5].setCellStyle(bordeDerecho);
	    celdas[5][5].setCellStyle(bordeDerecho);
	    celdas[6][5].setCellStyle(bordeInferiorDerechoLetraAzul);
	    // //////////Tercer Bloque
	    celdas[2][7].setCellValue("PLVDB");
	    celdas[3][7].setCellValue("TOTAL VENTAS TARJETAS DÉBITO");
	    celdas[4][7].setCellValue("TOTAL VENTAS INTERNET DÉBITO");
	    celdas[5][7].setCellValue("");
	    celdas[6][7].setCellValue("TOTAL PLVDB");

	    celdas[3][8].setCellValue(resultado.getTotalVentasInternetDebitoPLD());
	    celdas[4][8].setCellValue(resultado.getTotalVentasTarjetaDebitoPLD());
	    celdas[5][8].setCellValue("");
	    celdas[6][8].setCellValue(resultado.getTotalVEntasDEbitoPLD());

	    celdas[3][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[4][7].setCellStyle(bordeIzquierdo);
	    celdas[5][7].setCellStyle(bordeIzquierdo);
	    celdas[6][7].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[3][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[4][8].setCellStyle(bordeDerecho);
	    celdas[5][8].setCellStyle(bordeDerecho);
	    celdas[6][8].setCellStyle(bordeInferiorDerechoLetraAzul);
	    // //////////Cuarto Bloque
	    celdas[8][1].setCellValue("PLCUA");
	    celdas[9][1].setCellValue("PSDEB");
	    celdas[10][1].setCellValue("Diferencia");

	    celdas[8][2].setCellValue(resultado.getTarjetaDebitoPLCUA());
	    celdas[9][2].setCellValue(resultado.getTotalTarjetaDebitoPSDEB());
	    celdas[10][2].setCellValue(resultado.getDiferenciaPLCUAPSDEB());

	    celdas[8][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[9][1].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPLCUAPSDEB() == 0) {
		celdas[10][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[10][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[8][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[9][2].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPLCUAPSDEB() == 0) {
		celdas[10][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[10][2].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Quinto Bloque
	    celdas[8][4].setCellValue("PSDEB");
	    celdas[9][4].setCellValue("PLVDB");
	    celdas[10][4].setCellValue("Diferencia");

	    celdas[8][5].setCellValue(resultado.getTotalTarjetaDebitoPSDEB());
	    celdas[9][5].setCellValue(resultado.getTotalVEntasDEbitoPLD());
	    celdas[10][5].setCellValue(resultado.getDiferenciaPSDEBPLD());

	    celdas[8][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[9][4].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPSDEBPLD() == 0) {
		celdas[10][4].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[10][4].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[8][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[9][5].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPSDEBPLD() == 0) {
		celdas[10][5].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[10][5].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Sexto Bloque
	    celdas[12][1].setCellValue("Pago Remoto Débito");
	    celdas[13][1].setCellValue("PLCUA");
	    celdas[14][1].setCellValue("Pago Remoto Débito");

	    celdas[14][2].setCellValue(resultado.getPagoRemotoDebitoPLCUA());

	    celdas[14][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[15][1].setCellStyle(bordeIzquierdo);
	    celdas[16][1].setCellStyle(bordeInferiorIzquierdoLetraRoja);

	    celdas[14][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[15][2].setCellStyle(bordeDerecho);
	    celdas[16][2].setCellStyle(bordeInferiorDerechoLetraRoja);
	    // //////////Septimo Bloque
	    celdas[13][4].setCellValue("PSCRE");
	    celdas[14][4].setCellValue("Total Ventas Pago Remoto Débito");
	    celdas[15][4].setCellValue("Total Anulaciones Pago Remoto Débito");
	    celdas[16][4].setCellValue("Total Pago Remoto PSCRE");

	    celdas[14][5].setCellValue(resultado.getTotalVentasPagoRemotoDebitoPSDEB());
	    celdas[15][5].setCellValue(resultado.getTotalAnulacionesPagoRemotoDebitoPSDEB());
	    celdas[16][5].setCellValue(resultado.getTotalPagoRemotoPSDEB());

	    celdas[14][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[15][4].setCellStyle(bordeIzquierdo);
	    celdas[16][4].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[14][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[15][5].setCellStyle(bordeDerecho);
	    celdas[16][5].setCellStyle(bordeInferiorDerechoLetraAzul);
	    // //////////Octavo Bloque
	    celdas[13][7].setCellValue("PLVCR");
	    celdas[14][7].setCellValue("Total Ventas Pago Remoto Débito");
	    celdas[15][7].setCellValue("Total Anulaciones Pago Remoto Débito");
	    celdas[16][7].setCellValue("Total Pago Remoto PLVCR");

	    celdas[14][8].setCellValue(resultado.getTotalVentasPagoRemotoDebitoPLD());
	    celdas[15][8].setCellValue(resultado.getTotalAnulacionPagoRemotoDebitoPLD());
	    celdas[16][8].setCellValue(resultado.getTotalPagoRemotoDebitoPLD());

	    celdas[14][7].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[15][7].setCellStyle(bordeIzquierdo);
	    celdas[16][7].setCellStyle(bordeInferiorIzquierdoLetraAzul);

	    celdas[14][8].setCellStyle(bordeSuperiorDerecho);
	    celdas[15][8].setCellStyle(bordeDerecho);
	    celdas[16][8].setCellStyle(bordeInferiorDerechoLetraAzul);
	    // //////////Noveno Bloque
	    celdas[18][1].setCellValue("PLCUA");
	    celdas[19][1].setCellValue("PSCRE");
	    celdas[20][1].setCellValue("Diferencia");

	    celdas[18][2].setCellValue(resultado.getPagoRemotoDebitoPLCUA());
	    celdas[19][2].setCellValue(resultado.getTotalPagoRemotoPSDEB());
	    celdas[20][2].setCellValue(resultado.getDiferenciaPagoRemotoPLCUAPSDEB());

	    celdas[18][1].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[19][1].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPagoRemotoPLCUAPSDEB() == 0) {
		celdas[20][1].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[20][1].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[18][2].setCellStyle(bordeSuperiorDerecho);
	    celdas[19][2].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPagoRemotoPLCUAPSDEB() == 0) {
		celdas[20][2].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[20][2].setCellStyle(bordeTotalLetraRoja);
	    }
	    // //////////Noveno Bloque
	    celdas[18][4].setCellValue("PSCRE");
	    celdas[19][4].setCellValue("PLVCR");
	    celdas[20][4].setCellValue("Diferencia");

	    celdas[18][5].setCellValue(resultado.getTotalPagoRemotoPSDEB());
	    celdas[19][5].setCellValue(resultado.getTotalPagoRemotoDebitoPLD());
	    celdas[20][5].setCellValue(resultado.getDiferenciaPagoRemotoPSDEBPLD());

	    celdas[18][4].setCellStyle(bordeSuperiorIzquierdo);
	    celdas[19][4].setCellStyle(bordeIzquierdo);
	    if (resultado.getDiferenciaPagoRemotoPSDEBPLD() == 0) {
		celdas[20][4].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[20][4].setCellStyle(bordeTotalLetraRoja);
	    }

	    celdas[18][5].setCellStyle(bordeSuperiorDerecho);
	    celdas[19][5].setCellStyle(bordeDerecho);
	    if (resultado.getDiferenciaPagoRemotoPSDEBPLD() == 0) {
		celdas[20][5].setCellStyle(bordeTotalLetraAzul);
	    } else {
		celdas[20][5].setCellStyle(bordeTotalLetraRoja);
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
