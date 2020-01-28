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

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_menu_operaciones'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_click_operaciones'))

WebUI.click(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_click_operaciones_logistica'))

WebUI.click(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_btn_seleccione_cliente'))

WebUI.click(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_click_seleccione_cliente'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_assing_seleccione_cliente'), IDCliente, true)

WebUI.click(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_Buscar_pedido'))

WebUI.executeJavaScript('document.querySelector(\'.btn-success[href="/PedidoLubricante/Verificacion/' + IDPedido + '"]\').click()', null)

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_seleccione_cargos_logsticos'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_click_cargos_logsticos'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_assing_cargos_logsticos'), IDCargo, true)

WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_SELLO'), '20XYZ')

WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_NRO_CONTENEDOR'), '20XYZ')

WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_NRO_RESERVA'), '20XYZ')

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_Seleccione_naviera_cargos'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_click_naviera_cargos'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_assing_naviera_cargos'), '1', true)

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_Agregar_cargo_logistico'))

//WebUI.doubleClick(findTestObject('Object Repository/Page_- KAIZEN/lg_input_cantidad_cargos_logisticos'))

WebUI.executeJavaScript("document.getElementById('input' +$IDCargo).value='555.000'", null)

//WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_cantidad_cargos_logisticos'), '')

//WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_cantidad_cargos_logisticos'), '250,0000')

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_button_OK'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_seleccione_cargo_logistico2'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_click_cargo_logistico2'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_assing_cargos_logsticos'), IDCargo2, true)

WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_SELLO'), '30DSD')

WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_NRO_CONTENEDOR'), '30DSD')

WebUI.setText(findTestObject('Object Repository/Page_- KAIZEN/lg_input_Agregar_NRO_RESERVA'), '30DSD')

//WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_button_Naviera 1'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_Seleccione_naviera_cargos'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_click_naviera_cargos'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_- KAIZEN/lg_btn_assing_naviera_cargos'), '1', true)

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_Agregar_cargo_logistico'))

WebUI.executeJavaScript("document.getElementById('input' +$IDCargo2).value='555.000'", null)

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_button_OK'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_Confirmar-cargo_logistico'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/lg_Aceptar_cargo_logistico'))

//Navegador: document.querySelector(".btn-success[href=\"/PedidoLubricante/Verificacion/125\"]").click()

//WebUI.setText(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_input_Desde'), '01/01/2020')
//WebUI.setText(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_input_Hasta'), '01/01/2020')
//WebUI.click(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_btn_select_pedido_logistico'))
//WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Logstica - KAIZEN/lg_assing_seleccione_naviera_buscador'), '1', true)

