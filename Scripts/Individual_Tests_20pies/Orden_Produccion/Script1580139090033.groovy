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

List<String> data = CustomKeywords.'obtener_excels.obtener_produccion_20pies.getValuesExcelProduction'(Index)
String IdPedido = data[3]
IDPedido = IdPedido



WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/op_menu_Operaciones'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/op_click_Orden de Produccin'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_buscador_Produccion'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/opp_buscar_orden'))

WebUI.setText(findTestObject('Object Repository/Page_Index - KAIZEN/opp_escribir_orden'), IDPedido)

WebUI.sendKeys(findTestObject('Object Repository/Page_Index - KAIZEN/opp_escribir_orden'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_btn_Buscar'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_click_selecione_pedido'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/op_Iniciar Produccin'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_buscador_Produccion'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/opp_buscar_orden'))

WebUI.setText(findTestObject('Object Repository/Page_Index - KAIZEN/opp_escribir_orden'), IDPedido)

WebUI.sendKeys(findTestObject('Object Repository/Page_Index - KAIZEN/opp_escribir_orden'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_btn_Buscar'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_click_FInalizar_produccion'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/op_Finalizar Produccin'))


//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_Seleccione_Cliente'))
//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_click_Seleccione_Cliente'))
//WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Index - KAIZEN/op_assing_Seleccione_Cliente'), IDCliente, true)
//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_Seleccione_Cliente'))
//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_click_Seleccione_id_pedido'))
//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_Seleccione_idPedido'))
//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_click_Seleccione_id_pedido'))
//WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Index - KAIZEN/op_assing_seleccione_id_pedido'), IDPedido, true)
//WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Index - KAIZEN/opp_assing_orden'), '125', true)
//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_Buscar'))
//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_Seleccione_Cliente'))
//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_click_Seleccione_Cliente'))
//WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Index - KAIZEN/op_assing_cliente'), IDCliente, true)
//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_Seleccione_idPedido'))
//WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/op_click_Seleccione_id_pedido'))
//WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Index - KAIZEN/op_assing_seleccione_id_pedido2'), IDPedido, true)
