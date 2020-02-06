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


List<String> data = CustomKeywords.'obtener_excels.obtener_pedidos20pies.getValuesExcelCreate20'(Index)
String Nombre = data[3]
String Direccion = data[4]
String Contenedor= data[5]

WebUI.delay(2)

String element = WebUI.executeJavaScript('return document.getElementById(\'ID_CLIENTE_LIST\').value;', null)

if ((element == Nombre)) {
 //WebUI.executeJavaScript('alert(\'Es igual\')', null)
    WebUI.delay(2)

    WebUI.waitForElementVisible(findTestObject('Page_- KAIZEN/sc_btn_next'), 0)

    WebUI.click(findTestObject('Page_- KAIZEN/sc_btn_next') )
} else {
//WebUI.executeJavaScript('alert(\'Es Diferente\')', null)

	print(Nombre+"\n")
	WebUI.click(findTestObject('Page_- KAIZEN/sc_select_cliente1'))

	WebUI.click(findTestObject('Page_- KAIZEN/sc_select_cliente2'))
	
	WebUI.waitForElementPresent(findTestObject('Page_- KAIZEN/sc_select_cliente3'), 5)

	WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sc_select_cliente3'), Nombre.toString(), true)
    
	WebUI.waitForElementPresent(findTestObject('Page_- KAIZEN/sc_span_select_address'), 5)
	
	WebUI.click(findTestObject('Page_- KAIZEN/sc_span_select_address'))

 //   WebUI.click(findTestObject('Page_- KAIZEN/click_select_address'))

    WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sc_assing_select_address'), Direccion, 
        true)

	if (Contenedor == '20'){
	
    	WebUI.click(findTestObject('Page_- KAIZEN/sc_btn_contenedor_20_pies'))
	}
	else{
		WebUI.click(findTestObject('Page_- KAIZEN/sc_btn_contenedor_40_pies'))
		
	}
    WebUI.delay(2)

    WebUI.waitForElementVisible(findTestObject('Page_- KAIZEN/sc_btn_next'), 3)

    WebUI.click(findTestObject('Page_- KAIZEN/sc_btn_next'))
}

