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

List<String> data = CustomKeywords.'obtener_excels.obtener_despacho.getValuesExcelDespach'(Index)
String IdPedido = data[3]
String Id_Cliente = data[4]
String CantProd = data[5]

IDPedido = IdPedido
IDCliente = Id_Cliente
CantProductos = CantProd

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/dp_menu_Operaciones'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/dp_menu_Lista de Empaque'))

WebUI.executeJavaScript('document.querySelector(\'.btn-success[href="/DespachoPedido/Edit/' +IDPedido+ '"]\').click()', null)

for(int i=1; i<=GlobalVariable.CantProductosDespachar; i++)
{
	if(CantProductos=='1'){	
		
		WebUI.click(findTestObject('Object Repository/Page_Lista de Empaque - KAIZEN/dp_click_mas_1'))
		
	}
	else
	{
		WebUI.click(findTestObject('Object Repository/Page_Lista de Empaque - KAIZEN/dp_click_mas_1'))
		
		WebUI.click(findTestObject('Object Repository/Page_Lista de Empaque - KAIZEN/dp_click_mas_2'))
					
	}

}

WebUI.executeJavaScript("document.querySelector(\".btn-warning[onclick='GuardarModal()']\").click()", null)

WebUI.click(findTestObject('Object Repository/Page_Lista de Empaque - KAIZEN/dp_Aceptar'))



//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/dp_select_pedido'))

//WebUI.click(findTestObject('Object Repository/Page_Lista de Empaque - KAIZEN/dp_Despachar'))
