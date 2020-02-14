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

String OpCompra1=0

if (Evento=="Crear20"){

	List<String> data = CustomKeywords.'obtener_excels.obtener_pedidos20pies.getValuesExcelCreate20'(Index)
	OpCompra1 = data[7]
}
else if (Evento=="Crear40"){
	
	OpCompra1=GlobalVariable.OpcionCompra40pies
}

WebUI.delay(7)

WebUI.waitForElementClickable(findTestObject('Page_- KAIZEN/so_SelectorOP'), 7)

WebUI.delay(3)

WebUI.click(findTestObject('Page_- KAIZEN/so_select_SeleccioneOPCION'))

//WebUI.delay(3)
WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/so_select_SeleccioneOPCION'), OpCompra1, true)

//WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Page_- KAIZEN/sc_btn_next'), 7)

WebUI.click(findTestObject('Page_- KAIZEN/sc_btn_next'))

