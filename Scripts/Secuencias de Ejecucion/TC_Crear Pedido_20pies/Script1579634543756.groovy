import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testdata.reader.ExcelFactory
import com.kms.katalon.core.configuration.RunConfiguration

String archivo = "${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/Crear_Pedido20pies.xlsx"

Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(archivo, "Sheet1", true)

for (def Index = 1; Index<=excelData.getRowNumbers(); Index++)

{
	
	WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Login'), [('Evento') : "Crear", ('Index') : Index, ('Usuario') : Usuario, ('Contrasena') : Contrasena], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Idioma'), [('Evento') : "Crear", ('Index') : Index, ('Idioma') : Idioma], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Anadir_pedido'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Cliente'), [('Index') : Index, ('Nombre') : Nombre, ('Direccion') : Direccion
        , ('Contenedor') : Contenedor], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Incoterm'), [('Index') : Index, ('Incoterm') : Incoterm], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Opcion_Compra'), [('Index') : Index, ('OpCompra1') : OpCompra], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Productos'), [('Index') : Index, ('Iterar') : Iterar, ('Presentacion') : Presentacion
        , ('Producto') : Producto, ('Cantidad') : Cantidad, ('Presentacion2') : Presentacion2, ('Producto2') : Producto2
        , ('Cantidad2') : Cantidad2], FailureHandling.STOP_ON_FAILURE)

}