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

List<String> data = CustomKeywords.'obtener_excels.obtener_mov_inventario.getValuesExcelMovInventario'(Index)

String concepto = data[3]

String motivo = data[4]

String codProducto = data[5]

String IdAlmacen1=  data[9]

String IdAlmacen2= data[11]

String cantidad= data[13]

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mi_menu_Pedidos'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mi_menu_Inventario'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mi_menu_Movimientos'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_concepto'), concepto, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_motivo'), motivo , true)

WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_buscar_Producto'))

WebUI.setText(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_producto'), codProducto)

WebUI.sendKeys(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_producto'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_cantidad'), cantidad)

//WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_click_almacen1'))

//WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_almacen1'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_almacen1'), IdAlmacen1, true)

if (concepto=='TransferenciaDeMercancias'){

	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_almacen2'), IdAlmacen2, true)
}

WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_btn_Guardar'))

