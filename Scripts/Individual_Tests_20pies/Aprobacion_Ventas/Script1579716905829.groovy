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
import org.openqa.selenium.Keys as Keys

List<String> data = CustomKeywords.'obtener_excels.obtener_aprobaciones.getValuesExcelAprob20'(Index)
String IdPedido = data[3]
String Id_Cliente = data[4]
String AprobVentas = data[5]
print (Id_Cliente+"\n")
print (AprobVentas+"\n")

IDPedido = IdPedido 
IDCliente = Id_Cliente
AprobacionVentas = AprobVentas

WebUI.click(findTestObject('Page_- KAIZEN/av_btn_ventas'))

WebUI.click(findTestObject('Page_- KAIZEN/av_btn_aprobacinventas'))

WebUI.click(findTestObject('Page_Aprobacin de Ventas - KAIZEN/av_click_aprobacionventas'))

WebUI.click(findTestObject('Page_Aprobacin de Ventas - KAIZEN/av_btn_seleccione_cliente'))

WebUI.click(findTestObject('Page_Aprobacin de Ventas - KAIZEN/av_click_seleccione_cliente'))

WebUI.selectOptionByValue(findTestObject('Page_Aprobacin de Ventas - KAIZEN/av_assing_seleccione_cliente'), 
    IDCliente, true)

//WebUI.setText(findTestObject('Page_Aprobacin de Ventas - KAIZEN/av_input_Creados desde'), CreadosDesde)

//WebUI.setText(findTestObject('Page_Aprobacin de Ventas - KAIZEN/av_input_Creados hasta'), CreadosHasta)

WebUI.click(findTestObject('Page_Aprobacin de Ventas - KAIZEN/av_btn_Buscar'))

WebUI.delay(5)

if (AprobacionVentas=="Aprobar"){

	String variable = 'btn_aprobar_'+IDPedido
	
	print(variable)

	WebUI.executeJavaScript("document.getElementById('$variable').click();", null)	

	WebUI.click(findTestObject('Page_Aprobacin de Ventas - KAIZEN/av_btn_aceptar'))

	
}
else {
	
	WebUI.executeJavaScript("document.querySelector(\".btn-danger[onclick='AplazarPedidoV("+IDPedido+");']\").click()", null)
	
	WebUI.click(findTestObject('Page_Aprobacin de Ventas - KAIZEN/av_btn_aceptar'))
	
}

WebUI.delay(10)
