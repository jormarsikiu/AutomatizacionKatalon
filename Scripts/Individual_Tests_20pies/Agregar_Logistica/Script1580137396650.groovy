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

List<String> data = CustomKeywords.'obtener_excels.obtener_logistica.getValuesExcelLogistic'(Index)
String IdPedido = data[3]
String Id_Cliente = data[4]
String IDCargo = data[5]
String IDCargo2 = data[6]

IDPedido = IdPedido
IDCliente = Id_Cliente
IDCargo = IDCargo
IDCargo2 = IDCargo2

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_menu_operaciones'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_click_operaciones'))

WebUI.click(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_click_operaciones_logistica'))

WebUI.click(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_btn_seleccione_cliente'))

WebUI.click(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_click_seleccione_cliente'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_assing_seleccione_cliente'), IDCliente, 
    true)

WebUI.click(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_Buscar_pedido'))

WebUI.executeJavaScript(('document.querySelector(\'.btn-success[href="/PedidoLubricante/Verificacion/' + IDPedido) + '"]\').click()', 
    null)

if (IDCargo == IDCargo2) {
    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_seleccione_cargos_logsticos'))

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_click_cargos_logsticos'))

    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_assing_cargos_logsticos'), IDCargo, 
        true)

    WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_SELLO'), GlobalVariable.Sello_CargoLogistico)

    WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_NRO_CONTENEDOR'), GlobalVariable.Contenedor_CargoLogistico)

    WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_NRO_RESERVA'), GlobalVariable.Reserva_CargoLogistico)

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_Seleccione_naviera_cargos'))

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_click_naviera_cargos'))

    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_assing_naviera_cargos'), GlobalVariable.Naviera, true)

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_Agregar_cargo_logistico'))
	
	WebUI.executeJavaScript("document.getElementById('input$IDCargo').value='" +GlobalVariable.Valor_CargoLogistico +"'", null)
	
  //  WebUI.executeJavaScript("document.getElementById('input' +$IDCargo).value='222.000'", null)
	

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_button_OK'))
} else {
    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_seleccione_cargos_logsticos'))

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_click_cargos_logsticos'))

    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_assing_cargos_logsticos'), IDCargo, 
        true)

    WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_SELLO'), GlobalVariable.Sello_CargoLogistico)

    WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_NRO_CONTENEDOR'), GlobalVariable.Contenedor_CargoLogistico)

    WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_NRO_RESERVA'), GlobalVariable.Reserva_CargoLogistico)

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_Seleccione_naviera_cargos'))

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_click_naviera_cargos'))

    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_assing_naviera_cargos'), GlobalVariable.Naviera, true)

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_Agregar_cargo_logistico'))
	
	WebUI.executeJavaScript("document.getElementById('input$IDCargo').value='" +GlobalVariable.Valor_CargoLogistico +"'", null)
		
    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_button_OK'))
	
	WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_seleccione_cargos_logsticos'))
	
	WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_click_cargos_logsticos'))

    //WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_seleccione_cargo_logistico2'))

    //WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_click_cargo_logistico2'))

    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_assing_cargos_logsticos'), IDCargo2, 
        true)

    WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_SELLO'), GlobalVariable.Sello_CargoLogistico2)

    WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_NRO_CONTENEDOR'), GlobalVariable.Contenedor_CargoLogistico2)

    WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_NRO_RESERVA'), GlobalVariable.Reserva_CargoLogistico2)

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_Seleccione_naviera_cargos'))

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_click_naviera_cargos'))

    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_assing_naviera_cargos'), GlobalVariable.Naviera, true)

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_Agregar_cargo_logistico'))

    //WebUI.executeJavaScript("document.getElementById('input' +$IDCargo2).value='444.000'", null)
	
	WebUI.executeJavaScript("document.getElementById('input$IDCargo2').value='" +GlobalVariable.Valor_CargoLogistico2 +"'", null)

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_button_OK'))

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_Confirmar-cargo_logistico'))

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_Aceptar_cargo_logistico'))

}

