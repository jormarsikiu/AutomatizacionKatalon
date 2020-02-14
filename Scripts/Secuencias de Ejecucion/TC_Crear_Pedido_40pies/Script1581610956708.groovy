import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

String archivo = "${RunConfiguration.getProjectDir()}/Pedidos/DataExcel/Crear_Pedido40pies.xlsx"

Object excelData = ExcelFactory.getExcelDataWithDefaultSheet(archivo, 'Sheet1', true)

for (def Index = 1; Index <= excelData.getRowNumbers(); Index++) {
   
	 WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Login'), [('Evento') : 'Crear40', ('Index') : Index, ('Usuario') : Usuario
            , ('Contrasena') : Contrasena], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Idioma'), [('Evento') : 'Crear40', ('Index') : Index], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Anadir_pedido'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Cliente'), [('Evento') : 'Crear40', ('Index') : Index
            , ('Nombre') : Nombre, ('Direccion') : Direccion, ('Contenedor') : Contenedor], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Incoterm'), [('Evento') : 'Crear40', ('Index') : Index
            , ('Incoterm') : Incoterm], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Opcion_Compra'), [('Evento') : 'Crear40', ('Index') : Index
            , ('OpCompra1') : OpCompra1], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Productos40pies'), [('Index') : Index, ('Producto') : Producto, ('Producto2')  : Producto2, ('Iterar') : Iterar], 
        FailureHandling.STOP_ON_FAILURE)
}

