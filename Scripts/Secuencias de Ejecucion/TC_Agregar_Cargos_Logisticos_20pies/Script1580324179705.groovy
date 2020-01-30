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

/*def info = WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Refresh'), [:], FailureHandling.STOP_ON_FAILURE)

def Usuario = info.Usuario
def Contrasena = info.Contrasena
def Idioma = info.Idioma
def IDPedido = info.IDPedido
def IDCliente = info.IDCliente
def IDCargo = info.IDCargo
def IDCargo2 = info.IDCargo2
def CreadoDesde = info.CreadoDesde*/


WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Login'), [('Usuario') : Usuario, ('Contrasena') : Contrasena], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Seleccionar_Idioma'), [('Idioma') : Idioma], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Individual_Tests_20pies/Agregar_Logistica'), [('IDCliente') : IDCliente, ('CreadosDesde') : CreadosDesde, ('CreadosHasta') : CreadosHasta, ('IDPedido') : IDPedido,  ('IDCargo') : IDCargo,  ('IDCargo2') : IDCargo2], FailureHandling.STOP_ON_FAILURE)

