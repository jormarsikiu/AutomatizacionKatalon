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

public class obtener_producto_almacen {
	@Keyword
	def List<String> getValuesExcelProductoAlmacen(int index) {

		String archivo = "${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/Inventario/ProductoAlmacen.xlsx";

		Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(archivo, "Sheet1", true);

		String Idioma = excelData.getValue("Idioma", index);
		String Usuario = excelData.getValue("Usuario", index);
		String Contrasena = excelData.getValue("Contrasena", index);
		String Producto = excelData.getValue("Producto", index);
		String CantidadMinima = excelData.getValue("CantidadMinima", index);
		String CantidadMaxima = excelData.getValue("CantidadMaxima", index);
		String IdAlmacen = excelData.getValue("AgregarAlmacen1", index);
		String IdAlmacen2 = excelData.getValue("AgregarAlmacen2", index);


		List<String> data = [
			Idioma,
			Usuario,
			Contrasena,
			Producto,
			CantidadMinima,
			CantidadMaxima,
			IdAlmacen,
			IdAlmacen2
		]

		return data
	}
}
