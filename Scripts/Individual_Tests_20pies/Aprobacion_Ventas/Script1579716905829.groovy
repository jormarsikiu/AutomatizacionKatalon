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

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/btn_ventas_av'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/btn_aprobacinventas_av'))

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/click_aprobacionventas_av'))

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/btn_seleccione_cliente_av'))

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/click_seleccione_cliente_av'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/assing_seleccione_cliente_av'), 
    IDCliente, true)

WebUI.setText(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/input_Creados desde_av'), CreadosDesde)

WebUI.setText(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/input_Creados hasta_av'), CreadosHasta)

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/btn_Buscar_av'))


if (Estado_Pedido=="Aprobar"){

	String variable = 'btn_aprobar_'+IDPedido

	WebUI.executeJavaScript("document.getElementById('$variable').click();", null)	

	WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/btn_aceptar_av'))

	
}
else {

	WebUI.executeJavaScript("document.querySelector('.btn-danger[onclick='AplazarPedidoV('$IDPedido');']').click()", null)
	
	WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/btn_aceptar_av'))
	
}


//Comprobacion 
WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/click_aprobacionventas_av'))

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/btn_seleccione_cliente_av'))

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/click_seleccione_cliente_av'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/assing_seleccione_cliente_av'),
	IDCliente, true)

WebUI.setText(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/input_Creados desde_av'), CreadosDesde)

WebUI.setText(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/input_Creados hasta_av'), CreadosHasta)

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Ventas - KAIZEN/btn_Buscar_av'))