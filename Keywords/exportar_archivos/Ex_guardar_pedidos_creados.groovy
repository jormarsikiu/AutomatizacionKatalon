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

public class Ex_guardar_pedidos_creados {


	@Keyword
	public void demoKey(int idpedido, int cantPedido) throws IOException{
		FileInputStream fis = new FileInputStream("${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/Pedidos_Creados_Katalon.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet");
		Row header = sheet.createRow(0);
		Cell c = header.createCell(0);
		c.setCellValue("IdPedido");
		Cell c2 = header.createCell(1);
		c2.setCellValue("CantProductos");

		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getFirstRowNum());
		Row row = sheet.createRow(rowCount+1);
		Cell c3 = row.createCell(0);
		c3.setCellType(c3.CELL_TYPE_STRING);
		c3.setCellValue(idpedido);
		Cell c4 = row.createCell(1);
		c4.setCellType(c4.CELL_TYPE_STRING);
		c4.setCellValue(cantPedido);
		FileOutputStream fos = new FileOutputStream("${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/Pedidos_Creados_Katalon.xlsx");
		workbook.write(fos);
		fos.close();
	}
}
