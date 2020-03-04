import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.io.IOException

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

//EntradaDeMercancias
WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mi_menu_Inventario'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mi_menu_Movimientos'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_concepto'), concepto, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_motivo'), motivo, true)

WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_buscar_Producto'))

WebUI.setText(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_producto'), codProducto)

WebUI.sendKeys(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_producto'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_cantidad'), cantidad)

WebUI.sendKeys(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_cantidad'), Keys.chord(Keys.ENTER))

WebUI.delay(5)

String modal = WebUI.executeJavaScript('return document.querySelector(\'.swal2-popup\');', null)

if (modal == null) //No existe el modal
{
    print(modal)

    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_almacen1'), IdAlmacen1, true)

    WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_btn_Guardar'))

    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'), 5)
} else {
    WebUI.executeJavaScript('document.querySelector(".swal2-confirm").click();', null)

    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_almacen1'), IdAlmacen1, true)

    WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_btn_Guardar'))

    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'), 5)
}

WebUI.delay(5)
	

CustomKeywords.'exportar_archivos.logInventario.reporteInv'(concepto, motivo, IdProducto, codProducto, Producto, IdGrupo, Existencia, IdAlmacen1, cantidadActual1,'NA', 'NA', cantidad)

