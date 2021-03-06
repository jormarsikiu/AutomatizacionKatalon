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

WebUI.callTestCase(findTestCase('Individual_Tests/Login'), [('Usuario') : Usuario, ('Contrasena') : Contrasena], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Individual_Tests/Seleccionar_Idioma'), [('Idioma') : Idioma], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Individual_Tests/Buscar_pedido'), [('IDPedido') : IDPedido], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Individual_Tests/Seleccionar_Cliente'), [('Nombre') : Nombre, ('Direccion') : Direccion, ('Contenedor') : Contenedor], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Individual_Tests/Seleccionar_Incoterm'), [('Incoterm') : Incoterm], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Individual_Tests/Seleccionar_Opcion_Compra'), [('OpCompra1') : OpCompra], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Individual_Tests/Seleccionar_Productos20pies'), [('Presentacion') : Presentacion, ('Producto') : Producto, ('Cantidad') : Cantidad, ('Presentacion2') : Presentacion2
        , ('Producto2') : Producto2, ('Cantidad2') : Cantidad2], FailureHandling.STOP_ON_FAILURE)

