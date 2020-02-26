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

List<String> data = CustomKeywords.'obtener_excels.obtener_aprobaciones.getValuesExcelAprob20'(Index)
String IdPedido = data[3]
String Id_Cliente = data[4]
String AprobProduccion = data[7]

IDPedido = IdPedido
IDCliente = Id_Cliente
AprobacionProduccion = AprobProduccion

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/apo_menuOperaciones'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/apo_menu_aprobacion_produccin'))

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Produccin - KAIZEN/apo_click_aprobacion_produccin'))

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Produccin - KAIZEN/apo_seleccione_cliente'))

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Produccin - KAIZEN/apo_click_selecione_cliente'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Aprobacin de Produccin - KAIZEN/apo_assing_selecione_cliente'), 
    IDCliente, true)

//WebUI.setText(findTestObject('Object Repository/Page_Aprobacin de Produccin - KAIZEN/apo_input_Creados desde'), CreadosDesde)

//WebUI.setText(findTestObject('Object Repository/Page_Aprobacin de Produccin - KAIZEN/apo_input_Creados hasta'), CreadosHasta)

WebUI.click(findTestObject('Object Repository/Page_Aprobacin de Produccin - KAIZEN/apo_Buscar'))


WebUI.executeJavaScript('document.querySelector(\'.btn-info[href="/PedidoLubricante/DetalleAprobacion/' + IDPedido + '?Ventana=3"]\').click()', 
    null)

WebUI.delay(5)

if (AprobacionProduccion == 'Aprobar') {
    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/apo_Aprobar'))

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/apo_btn_Aceptar'))

} else {

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/apo_Denegar'))

    WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/apo_btn_Aceptar'))
}

WebUI.delay(10)

//println('document.querySelector(\'.btn-info[href="/PedidoLubricante/DetalleAprobacion/' + IDPedido + '?Ventana=3"]\').click()')


