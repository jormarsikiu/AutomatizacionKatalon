package obtener_excels

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.List

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testdata.reader.ExcelFactory
import com.kms.katalon.core.configuration.RunConfiguration


import internal.GlobalVariable

public class obtener_aprobaciones {

	@Keyword
	def List<String> getValuesExcelAprob20(int index) {

		String archivo = "${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/AprobacionesPedidos.xlsx";

		Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(archivo, "Sheet1", true);

		String Idioma = excelData.getValue("Idioma", index);
		String Usuario = excelData.getValue("Usuario", index);
		String Contrasena = excelData.getValue("Contrasena", index);
		String IdPedido = excelData.getValue("IdPedido", index);
		String Id_Cliente = excelData.getValue("Id_Cliente", index);
		String AprobVentas = excelData.getValue("Aprob. Ventas", index);
		String AprobFinanciera = excelData.getValue("Aprob. Financiera", index);
		String AprobProduccion = excelData.getValue("Aprob. Produccion", index);

		List<String> data = [
			Idioma,
			Usuario,
			Contrasena,
			IdPedido,
			Id_Cliente,
			AprobVentas,
			AprobFinanciera,
			AprobProduccion
		]

		return data
	}
}

