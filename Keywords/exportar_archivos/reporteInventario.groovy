package exportar_archivos

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.kms.katalon.core.configuration.RunConfiguration

public class logInventario {

	@Keyword
	public void reporteInv(String concepto, String motivo, String IdProducto, String codProducto, String Producto, String IdGrupo, String Existencia, String IdAlmacen1, String cantidadActual1, String IdAlmacen2, String cantidadActual2, String cantidadMovida) throws IOException{
		FileInputStream fis = new FileInputStream("${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/Inventario/LogReporteInventarioKatalon.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet");
		Row header = sheet.createRow(0);

		Cell c0 = header.createCell(0);
		c0.setCellValue("Concepto");

		Cell c1 = header.createCell(1);
		c1.setCellValue("Motivo");

		Cell c2 = header.createCell(2);
		c2.setCellValue("IdProducto");

		Cell c3 = header.createCell(3);
		c3.setCellValue("CodProducto");

		Cell c4 = header.createCell(4);
		c4.setCellValue("Producto");

		Cell c5 = header.createCell(5);
		c5.setCellValue("IdGrupo");

		Cell c6 = header.createCell(6);
		c6.setCellValue("Existencia");

		Cell c7 = header.createCell(7);
		c7.setCellValue("IdAlmacen1");

		Cell c8 = header.createCell(8);
		c8.setCellValue("CantidadActual1");

		Cell c9 = header.createCell(9);
		c9.setCellValue("IdAlmacen2");

		Cell c10 = header.createCell(10);
		c10.setCellValue("CantidadActual2");

		Cell c11 = header.createCell(11);
		c11.setCellValue("CantidadMovida");

		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		//System.out.println(sheet.getLastRowNum());
		//System.out.println(sheet.getFirstRowNum());
		Row row = sheet.createRow(rowCount+1);


		Cell ca = row.createCell(0);
		ca.setCellType(ca.CELL_TYPE_STRING);
		ca.setCellValue(concepto);

		Cell cb = row.createCell(1);
		cb.setCellType(cb.CELL_TYPE_STRING);
		cb.setCellValue(motivo);

		Cell cc = row.createCell(2);
		cc.setCellType(cc.CELL_TYPE_STRING);
		cc.setCellValue(IdProducto);

		Cell cd = row.createCell(3);
		cd.setCellType(cd.CELL_TYPE_STRING);
		cd.setCellValue(codProducto);

		Cell ce = row.createCell(4);
		ce.setCellType(ce.CELL_TYPE_STRING);
		ce.setCellValue(Producto);

		Cell cf = row.createCell(5);
		cf.setCellType(cf.CELL_TYPE_STRING);
		cf.setCellValue(IdGrupo);

		Cell cg = row.createCell(6);
		cg.setCellType(cg.CELL_TYPE_STRING);
		cg.setCellValue(Existencia);

		Cell ch = row.createCell(7);
		ch.setCellType(ch.CELL_TYPE_STRING);
		ch.setCellValue(IdAlmacen1);

		Cell ci = row.createCell(8);
		ci.setCellType(ci.CELL_TYPE_STRING);
		ci.setCellValue(cantidadActual1);

		Cell cj = row.createCell(9);
		cj.setCellType(cj.CELL_TYPE_STRING);
		cj.setCellValue(IdAlmacen2);

		Cell ck = row.createCell(10);
		ck.setCellType(ck.CELL_TYPE_STRING);
		ck.setCellValue(cantidadActual2);

		Cell cl = row.createCell(11);
		cl.setCellType(cl.CELL_TYPE_STRING);
		cl.setCellValue(cantidadMovida);

		FileOutputStream fos = new FileOutputStream("${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/Inventario/LogReporteInventarioKatalon.xlsx");
		workbook.write(fos);
		fos.close();
	}
}
