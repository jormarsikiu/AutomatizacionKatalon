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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.lang.Integer as Integer
import com.kms.katalon.core.exception.StepFailedException

List<String> data = CustomKeywords.'obtener_excels.obtener_pedidos20pies.getValuesExcelCreate20'(Index)
String Presentacion = data[8]
String Producto = data[9]
String Cantidad = data[10]
String Presentacion2 = data[11]
String Producto2 = data[12]
String Cantidad2 = data[13]
String Iterar = data[14]
	
int Iterado = Iterar.toInteger()

int cantProductos = Iterado

//Se guarda el id del pedido
String IDPedidoCreado = WebUI.executeJavaScript('return document.getElementById(\'IdPedido\').value;', null)

IDPedidoCreado = IDPedidoCreado.toInteger()

CustomKeywords.'exportar_archivos.Ex_guardar_pedidos_creados.demoKey'(IDPedidoCreado, cantProductos)

String boton = WebUI.executeJavaScript('return document.getElementById("btn_next").style.display;', null)

if (boton == 'block') {
    //WebUI.executeJavaScript('alert(\'El boton SI ESTA\')', null)
    //WebUI.click(findTestObject('Page_- KAIZEN/sc_btn_next')) 
    WebUI.click(findTestObject('Page_- KAIZEN/sp_Siguiente')) // WebUI.delay(5)
} else {

    if (Iterar == '1') {
        WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_presentacion'))

        WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_presentation'))

        WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_presentation'), Presentacion, true)

        WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_producto'))

        WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_product'))

        WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_product'), Producto, true)

        WebUI.setText(findTestObject('Page_- KAIZEN/sp_input_product_quantity'), Cantidad)

        WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_add_product'))
		
		WebUI.delay(10)
		
		String boton2 = WebUI.executeJavaScript('return document.getElementById("btn_next").style.display;', null)
		
		if (boton2 == 'none') { //Sale mensaje de error 
		
			WebUI.closeBrowser()
									
		}
		else{
					
			WebUI.click(findTestObject('Page_- KAIZEN/sp_Siguiente'))
					
			//WebUI.waitForElementPresent(findTestObject('Page_- KAIZEN/sp_btn_finish'), 5)
					
			WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_finish'))
					
			WebUI.delay(3)
				
			WebUI.closeBrowser()
		}
		
		
    } else if (Iterar == '2') {
	
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

		WebUI.delay(3)
		
		String boton3 = WebUI.executeJavaScript('return document.getElementById("btn_next").style.display;', null)
		
		if (boton3 == 'none') { //Sale mensaje de error 
		
			WebUI.closeBrowser()
									
		}
		else{
					
			WebUI.click(findTestObject('Page_- KAIZEN/sp_Siguiente'))
					
			//WebUI.waitForElementPresent(findTestObject('Page_- KAIZEN/sp_btn_finish'), 5)
					
			WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_finish'))
					
			WebUI.delay(5)
				
			WebUI.closeBrowser()
		}
    }
}





