package obtener_excels

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import com.kms.katalon.core.testdata.reader.ExcelFactory
import com.kms.katalon.core.configuration.RunConfiguration

public class obtener_pedidos20pies {

	@Keyword
	def List<String> getValuesExcelCreate20(int index) {

		String archivo = "${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/Crear_Pedido20pies.xlsx";

		Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(archivo, "Sheet1", true);

		String Idioma = excelData.getValue("Idioma", index);
		String Usuario = excelData.getValue("Usuario", index);
		String Contrasena = excelData.getValue("Contrasena", index);
		String ID_Cliente = excelData.getValue("ID_Cliente", index);
		String ID_Direccion = excelData.getValue("ID_Direccion", index);
		String Contenedor = excelData.getValue("Contenedor", index);
		String Incoterms = excelData.getValue("Incoterms", index);
		String OpCompra = excelData.getValue("OpCompra", index);
		String Presentacion = excelData.getValue("Presentacion", index);
		String Producto = excelData.getValue("Producto", index);
		String Cantidad = excelData.getValue("Cantidad", index);
		String Presentacion2 = excelData.getValue("Presentacion2", index);
		String Producto2 = excelData.getValue("Producto2", index);
		String Cantidad2 = excelData.getValue("Cantidad2", index);
		String Iterar = excelData.getValue("Iterar", index);

		List<String,String> data = [
			Idioma,
			Usuario,
			Contrasena,
			ID_Cliente,
			ID_Direccion,
			Contenedor,
			Incoterms,
			OpCompra,
			Presentacion,
			Producto,
			Cantidad,
			Presentacion2, ,
			Producto2,
			Cantidad2,
			Iterar
		]

		return data
	}
}
