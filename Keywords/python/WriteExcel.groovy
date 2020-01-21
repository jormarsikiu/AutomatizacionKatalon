package python

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
public class WriteExcel {


	@Keyword
	public void demoKey(String name) throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\kaizen\\Desktop\\jt\\JormarRespaldo\\Pedidos\\Data Excel\\Pedidos_Creados.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("IdPedido");
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		Row row = sheet.createRow(rowCount+1);
		Cell cell = row.createCell(0);

		cell.setCellType(cell.CELL_TYPE_STRING);

		cell.setCellValue(name);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\kaizen\\Desktop\\jt\\JormarRespaldo\\Pedidos\\Data Excel\\Pedidos_Creados.xlsx");
		workbook.write(fos);
		fos.close();
	}
}
