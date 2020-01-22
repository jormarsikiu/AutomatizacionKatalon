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

//WebUI.waitForElementPresent(findTestObject('Page_- KAIZEN/Element_presentacion'), 5)

String boton = WebUI.executeJavaScript('return document.getElementById("btn_next").style.display;', null)

if (boton == 'block') {
    //WebUI.executeJavaScript('alert(\'El boton SI ESTA\')', null)
    //WebUI.click(findTestObject('Page_- KAIZEN/btn_next')) 
	WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/a_Siguiente'))
} else {
   // WebUI.delay(5)
	
	if (Iterar=='1')
	{

	    WebUI.click(findTestObject('Page_- KAIZEN/Element_presentacion'))
	
	    WebUI.click(findTestObject('Page_- KAIZEN/click_select_presentation'))
	
	    WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/assing_select_presentation'), Presentacion, true)
	
	    WebUI.click(findTestObject('Page_- KAIZEN/Element_producto'))
	
	    WebUI.click(findTestObject('Page_- KAIZEN/click_select_product'))
	
	    WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/assing_select_product'), Producto, true)
	
	    WebUI.setText(findTestObject('Page_- KAIZEN/input_product_quantity'), Cantidad)
	
	    WebUI.click(findTestObject('Page_- KAIZEN/btn_add_product'))
		
		WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/a_Siguiente'))
		
	}
	else
	{
		WebUI.click(findTestObject('Page_- KAIZEN/Element_presentacion'))
	
		WebUI.click(findTestObject('Page_- KAIZEN/click_select_presentation'))
	
		WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/assing_select_presentation'), Presentacion, true)
	
		WebUI.click(findTestObject('Page_- KAIZEN/Element_producto'))
	
		WebUI.click(findTestObject('Page_- KAIZEN/click_select_product'))
	
		WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/assing_select_product'), Producto, true)
	
		WebUI.setText(findTestObject('Page_- KAIZEN/input_product_quantity'), Cantidad)
	
		WebUI.click(findTestObject('Page_- KAIZEN/btn_add_product'))
	
		WebUI.click(findTestObject('Page_- KAIZEN/Element_presentacion'))
	
		WebUI.click(findTestObject('Page_- KAIZEN/click_select_presentation'))

	    WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/assing_select_presentation'), Presentacion2, true)
	
	    WebUI.click(findTestObject('Page_- KAIZEN/Element_producto'))
	
	    WebUI.click(findTestObject('Page_- KAIZEN/click_select_product'))
	
	    WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/assing_select_product'), Producto2, true)
	
	    WebUI.setText(findTestObject('Page_- KAIZEN/input_product_quantity'), Cantidad2)
	
	    WebUI.click(findTestObject('Page_- KAIZEN/btn_add_product'))
		
		WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/a_Siguiente'))
	}	    
}

WebUI.waitForElementPresent(findTestObject('Page_- KAIZEN/btn_finish'), 5)
WebUI.click(findTestObject('Page_- KAIZEN/btn_finish'))
//WebUI.click(findTestObject('Object Repository/Page_Pedidos de Lubricantes - KAIZEN/td_20 ft'))
WebUI.delay(5)

WebUI.closeBrowser()

