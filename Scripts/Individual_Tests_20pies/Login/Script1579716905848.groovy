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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

List<String> data = CustomKeywords.'getexcel.obtener_pedidos20pies.getValuesExcelCreate20'(Index)
String Usuario = data[1]
String Contrasena = data[2]

WebUI.openBrowser('http://test.kaizendev.net/Login/Accesar?salir=true')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/is_input_email'), Usuario)

WebUI.setEncryptedText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)

//WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)

WebUI.click(findTestObject('Page_Iniciar Sesion - KAIZEN/is_btn_ingresar_sistema'))



