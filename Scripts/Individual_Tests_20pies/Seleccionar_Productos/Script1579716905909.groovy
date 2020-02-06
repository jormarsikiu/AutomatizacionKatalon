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
String Presentacion = data[8]
String Producto = data[9]
String Cantidad = data[10]
String Presentacion2 = data[11]
String Producto2 = data[12]
String Cantidad2 = data[13]
String Iterar = data[15]



//WebUI.waitForElementPresent(findTestObject('Page_- KAIZEN/sp_Element_presentacion'), 5)

String boton = WebUI.executeJavaScript('return document.getElementById("btn_next").style.display;', null)
int cantPedido = 0

if (boton == 'block') {
    //WebUI.executeJavaScript('alert(\'El boton SI ESTA\')', null)
    //WebUI.click(findTestObject('Page_- KAIZEN/sc_btn_next')) 
	WebUI.click(findTestObject('Page_- KAIZEN/sp_Siguiente'))
} else {
   // WebUI.delay(5)
	
	if (Iterar=='1')
	{

	    WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_presentacion'))
	
	    WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_presentation'))
	
	    WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_presentation'), Presentacion, true)
	
	    WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_producto'))
	
	    WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_product'))
	
	    WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_product'), Producto, true)
	
	    WebUI.setText(findTestObject('Page_- KAIZEN/sp_input_product_quantity'), Cantidad)
	
	    WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_add_product'))
		
		WebUI.click(findTestObject('Page_- KAIZEN/sp_Siguiente'))
		
		cantPedido=1
		
	}
	else
	{
		WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_presentacion'))
	
		WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_presentation'))
	
		WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_presentation'), Presentacion, true)
	
		WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_producto'))
	
		WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_product'))
	
		WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_product'), Producto, true)
	
		WebUI.setText(findTestObject('Page_- KAIZEN/sp_input_product_quantity'), Cantidad)
	
		WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_add_product'))
	
		WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_presentacion'))
	
		WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_presentation'))

	    WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_presentation'), Presentacion2, true)
	
	    WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_producto'))
	
	    WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_product'))
	
	    WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_product'), Producto2, true)
	
	    WebUI.setText(findTestObject('Page_- KAIZEN/sp_input_product_quantity'), Cantidad2)
	
	    WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_add_product'))
		
		WebUI.click(findTestObject('Page_- KAIZEN/sp_Siguiente'))
		
		cantPedido=2
	}	    
}

//Se guarda el id del pedido
String IDPedidoCreado = WebUI.executeJavaScript('return document.getElementById(\'IdPedido\').value;', null)

CustomKeywords.'exportar_archivos.Ex_guardar_pedidos_creados.demoKey'(IDPedidoCreado, cantPedido)


WebUI.waitForElementPresent(findTestObject('Page_- KAIZEN/sp_btn_finish'), 5)
WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_finish'))
//WebUI.click(findTestObject('Object Repository/Page_Pedidos de Lubricantes - KAIZEN/td_20 ft'))
WebUI.delay(5)

WebUI.closeBrowser()

