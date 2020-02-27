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

/*String modalstyle = WebUI.executeJavaScript("return document.querySelector('.swal2-popup').style.display;", null)
*/
List<String> data = CustomKeywords.'obtener_excels.obtener_producto_almacen.getValuesExcelProductoAlmacen'(Index)

String Producto = data[3]

String CantidadMinima = data[4]

String CantidadMaxima = data[5]

String Almacen = data[6]

String Almacen2 = data[7]

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mvi_menu_Inventario'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mvi_menu_productos_por_almacen'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/mvi_agregar'))

WebUI.click(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_btn_seleccione'))

WebUI.setText(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_assing_prodcuto'), Producto)

WebUI.sendKeys(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_assing_prodcuto'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_assing_almacen'), Almacen, 
    true)

WebUI.delay(3)

String modal = WebUI.executeJavaScript('return document.querySelector(\'.swal2-popup\');', null)

print(modal)

/**Primer almacen*/
if (modal == null) //No existe el modal
{
    WebUI.setText(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_cantidad_mnima_almacn'), CantidadMinima)

    WebUI.setText(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_cantidad_mxima_en_almacn'), CantidadMaxima)

	
	if(WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_button_OK'), 5, FailureHandling.OPTIONAL))
	{
		WebUI.delay(7)
		
		WebUI.click(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_button_OK'))
		
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_assing_almacen'), '4',
			true)
	
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_assing_almacen'), Almacen,
			true)
		
		WebUI.click(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_Guardar')) //existe el modal
		
		
	}
	else
	{

    WebUI.click(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_Guardar')) //existe el modal
	
	}
	
	
} else {
    WebUI.executeJavaScript('document.querySelector(".swal2-confirm").click();', null)
}

/*Segundo Almacen*/
WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mvi_menu_Inventario'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mvi_menu_productos_por_almacen'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/mvi_agregar'))

WebUI.click(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_btn_seleccione'))

WebUI.setText(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_assing_prodcuto'), Producto)

WebUI.sendKeys(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_assing_prodcuto'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_assing_almacen'), Almacen2, 
    true)

WebUI.delay(3)

String modal2 = WebUI.executeJavaScript('return document.querySelector(\'.swal2-popup\');', null)

if (modal2 == null) {
	
    WebUI.setText(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_cantidad_mnima_almacn'), CantidadMinima)

    WebUI.setText(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_cantidad_mxima_en_almacn'), CantidadMaxima)

	if(WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_button_OK'), 5, FailureHandling.OPTIONAL))
	{
		WebUI.delay(7)
		
		WebUI.click(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_button_OK'))
		
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_assing_almacen'), '4',
			true)
	
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_assing_almacen'), Almacen2,
			true)
		
	}
	else
	{

	WebUI.click(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/mvi_Guardar')) //existe el modal
	
	}
} else {
    WebUI.executeJavaScript('document.querySelector(".swal2-confirm").click();', null)

    WebUI.closeBrowser()
}


