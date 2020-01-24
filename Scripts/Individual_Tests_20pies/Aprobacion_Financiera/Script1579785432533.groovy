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

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/af_btn_Crdito y Cobranza'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/af_btn_Aprobacin Financiera'))

WebUI.click(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_click_Aprobacin Financiera'))

WebUI.click(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_btn_seleccione_cliente'))

WebUI.click(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_click_seleccione_cliente'))

WebUI.selectOptionByValue(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_assing_seleccione_cliente'), IDCliente, 
    true)

//WebUI.setText(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_input_Creados desde'), CreadosDesde)

//WebUI.setText(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_input_Creados hasta'), CreadosHasta)

WebUI.click(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_btn_Buscar'))

WebUI.delay(5)

if (AprobacionFinanciera=="Aprobar"){
	
	String variable = 'btn_aprobar_'+IDPedido
	
	WebUI.executeJavaScript("document.getElementById('$variable').click();", null)

	WebUI.click(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_btn_Aceptar'))
			
}
else {
	
	WebUI.executeJavaScript("document.querySelector(\".btn-danger[onclick='AplazarPedido("+IDPedido+");']\").click()", null)
	
	WebUI.click(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_btn_Aceptar'))
	
	
}

WebUI.delay(10)

//WebUI.click(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_btn_aprobar'))

//WebUI.click(findTestObject('Page_Aprobacion Financiera - KAIZEN/af_btn_denegar'))


