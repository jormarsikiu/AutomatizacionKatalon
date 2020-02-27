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

public class obtener_mov_inventario {
	@Keyword
	def List<String> getValuesExcelMovInventario(int index) {

		String archivo = "${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/MovimientoDeInventario.xlsx";

		Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(archivo, "Sheet1", true);

		String Idioma = excelData.getValue("Idioma", index);
		String Usuario = excelData.getValue("Usuario", index);
		String Contrasena = excelData.getValue("Contrasena", index);
		String Concepto = excelData.getValue("Concepto", index);
		String Motivo = excelData.getValue("Motivo", index);
		String CodProducto = excelData.getValue("CodProducto", index);
		String IdGrupo = excelData.getValue("IdGrupo", index);
		String Producto = excelData.getValue("Producto", index);
		String Existencia = excelData.getValue("Existencia", index);
		String IdAlmacen1 = excelData.getValue("IdAlmacen1", index);
		String CantidadActual1 = excelData.getValue("CantidadActual1", index);
		String IdAlmacen2 = excelData.getValue("IdAlmacen2", index);
		String CantidadActual2 = excelData.getValue("CantidadActual2", index);
		String CantidadMovida = excelData.getValue("CantidadMovida", index);


		List<String> data = [
			Idioma,
			Usuario,
			Contrasena,
			Concepto,
			Motivo,
			CodProducto,
			IdGrupo,
			Producto,
			Existencia,
			IdAlmacen1,
			CantidadActual1,
			IdAlmacen2,
			CantidadActual2,
			CantidadMovida
		]

		return data
	}
}
