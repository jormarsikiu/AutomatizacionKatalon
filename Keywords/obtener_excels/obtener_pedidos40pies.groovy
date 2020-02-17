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

public class obtener_pedidos40pies {

	@Keyword
	def List<String> getValuesExcelCreate40(int index) {

		String archivo = "${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/Crear_Pedido40pies.xlsx";

		Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(archivo, "Sheet1", true);

		String Idioma = excelData.getValue("Idioma", index);
		String Usuario = excelData.getValue("Usuario", index);
		String Contrasena = excelData.getValue("Contrasena", index);
		String IdCliente = excelData.getValue("IdCliente", index);
		String IdDireccion = excelData.getValue("IdDireccion", index);
		String Contenedor = excelData.getValue("Contenedor", index);
		String Incoterms = excelData.getValue("Incoterms", index);

		String CapacidadDescarga = excelData.getValue("CapacidadDescarga", index);
		String CapacidadDisponible = excelData.getValue("CapacidadDisponible", index);
		String ProductoSoportaPeso = excelData.getValue("ProductoSoportaPeso", index);
		String PesoProducto1 = excelData.getValue("PesoProducto1", index);
		String ProductoNoSoportaPeso = excelData.getValue("ProductoNoSoportaPeso", index);
		String PesoProducto2 = excelData.getValue("PesoProducto2", index);
		String Iterar = excelData.getValue("Iterar", index);

		List<String,String> data = [
			Idioma,
			Usuario,
			Contrasena,
			IdCliente,
			IdDireccion,
			Contenedor,
			Incoterms,
			CapacidadDescarga,
			CapacidadDisponible,
			ProductoSoportaPeso,
			PesoProducto1,
			ProductoNoSoportaPeso,
			PesoProducto2,
			Iterar
		]

		return data
	}
}


