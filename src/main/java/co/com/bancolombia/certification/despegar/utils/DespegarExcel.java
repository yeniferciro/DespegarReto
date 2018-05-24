package co.com.bancolombia.certification.despegar.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;

public class DespegarExcel {

	public static void crearExcel(Object[][] data) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "Resultado_Busqueda_Vuelos");

		String[] headers = new String[] { "7 Precios M�s Baratos" };

		/*
		 * CellStyle headerStyle = workbook.createCellStyle(); Font font =
		 * workbook.createFont(); font.setColor(Font.COLOR_NORMAL);
		 * headerStyle.setFont(font);
		 */

		CellStyle style = workbook.createCellStyle();
		// style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());

		Font font = workbook.createFont();
		font.setColor(Font.COLOR_RED);
		style.setFont(font);

		HSSFRow headerRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; ++i) {
			String header = headers[i];
			HSSFCell cell = headerRow.createCell(i);
			cell.setCellValue(header);
			cell.setCellStyle(style);
		}

		HSSFCell cell = headerRow.createCell(1);
		cell.setCellStyle(style);

		for (int i = 0; i < data.length; ++i) {
			HSSFRow dataRow = sheet.createRow(i + 1);

			Object[] d = data[i];
			String product = (String) d[0];

			dataRow.createCell(0).setCellValue(product);
			dataRow.setRowStyle(style);
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}

		FileOutputStream file;
		try {
			file = new FileOutputStream("DespegarVuelos.xls");
			workbook.write(file);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}