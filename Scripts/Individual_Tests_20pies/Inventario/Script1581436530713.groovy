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

List<String> data = CustomKeywords.'obtener_excels.obtener_inventario.getValuesExcelInventary'(Index)

String CodProducto = data[3]

String Cantidad = data[4]

WebUI.click(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/iv_btn_menu_Inventario'))

WebUI.click(findTestObject('Object Repository/Page_Agregar Productos - KAIZEN/iv_btn_menu_Movimientos'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/iv_btn_Agregar_inventario'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/iv_select_concepto'), GlobalVariable.Concepto, 
    true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/iv_select_motivo'), GlobalVariable.Motivo, 
    true)

WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/iv_btn_Buscar Producto'))

WebUI.setText(findTestObject('Object Repository/Page_Create - KAIZEN/iv_input_Buscar Producto'), CodProducto)

WebUI.sendKeys(findTestObject('Object Repository/Page_Create - KAIZEN/iv_input_Buscar Producto'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Object Repository/Page_Create - KAIZEN/iv_input_Cantidad'), Cantidad)

WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/iv_btn_Guardar'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Index - KAIZEN/iv_btn_Agregar_inventario'), 2)


