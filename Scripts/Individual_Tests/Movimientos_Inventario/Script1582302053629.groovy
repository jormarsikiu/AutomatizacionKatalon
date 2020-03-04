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
import org.apache.commons.lang.RandomStringUtils as RandStr
import java.lang.Integer as Integer


List<String> data = CustomKeywords.'obtener_excels.obtener_mov_inventario.getValuesExcelMovInventario'(Index)

String concepto = data[3]
String motivo = data[4]
String IdProducto = data[14]
String Existencia = data[8]
String cantidadActual1  = data[10]
String cantidadActual2 = data[12]
String codProducto = data[5]
String IdGrupo = data[6]
String Producto = data[7]
String IdAlmacen1 = data[9]
String IdAlmacen2 = data[11]
String cantidadAMover = data[13]
String cantidad = data[13]

Random rand = new Random();

int nuevacantidad = 0

if ((concepto == 'TransferenciaDeMercancias') & (cantidad == '0')) {
	
	//Aleatorio de 10 a 10000
	if(IdGrupo=='Materia Prima'){
		
		cantidad = rand.nextInt((10000 - 10) + 1) + 10;
	}
	else if(IdGrupo=='Producto Terminado'){
		
		cantidad = rand.nextInt((250 - 1) + 1) + 1;
	}
	else if(IdGrupo=='MP: Liquidos'){
		
		cantidad = rand.nextInt((20000 - 4000) + 1) + 4000;
	}
	
    WebUI.callTestCase(findTestCase('Individual_Tests/Producto_Faltante_Almacen'), [('concepto') : 'EntradaDeMercancias', ('motivo') : 'CompraProductos', ('IdProducto') : IdProducto, 
		('codProducto') : codProducto, ('Producto') : Producto, ('IdGrupo') : IdGrupo, ('Existencia') : Existencia, 
		('IdAlmacen1') : IdAlmacen1, ('cantidadActual1') : cantidadActual1,  ('cantidad') : cantidad], FailureHandling.STOP_ON_FAILURE)
	print(cantidad)
	
	int cantidad1 = cantidad.toInteger()
	nuevacantidad = rand.nextInt((cantidad1 - 1) + 1) + 1;
	print(nuevacantidad)
	cantidad = nuevacantidad
	cantidadAMover = cantidad.toString()
	
}

concepto = data[3]

motivo = data[4]

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mi_menu_Inventario'))

WebUI.click(findTestObject('Object Repository/Page_- KAIZEN/mi_menu_Movimientos'))

WebUI.click(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_concepto'), concepto, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_motivo'), motivo, true)

WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_buscar_Producto'))

WebUI.setText(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_producto'), codProducto)

WebUI.sendKeys(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_producto'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_cantidad'), cantidadAMover)

WebUI.sendKeys(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_cantidad'), Keys.chord(Keys.ENTER))

WebUI.delay(5)

String modal = WebUI.executeJavaScript('return document.querySelector(\'.swal2-popup\');', null)

if (modal == null) //No existe el modal
{
    print(modal)

    //WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_click_almacen1'))
    //WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_select_almacen1'))
    if (motivo == 'EntradaPorFabricacion') {
		
        WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_btn_Guardar'))

        WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'), 5) //Existe el modal
    } else {
	
        WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_almacen1'), IdAlmacen1, 
            true)

        if (concepto == 'TransferenciaDeMercancias') {
            WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_almacen2'), IdAlmacen2, 
                true)

            WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_btn_Guardar'))

            WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'), 5)
        } else {
            WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_btn_Guardar'))

            WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'), 5)
        }
    }
} else {
    WebUI.executeJavaScript('document.querySelector(".swal2-confirm").click();', null)

    if (motivo == 'EntradaPorFabricacion') {
		
        WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_btn_Guardar'))

        WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'), 5)
    } else {
        WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_almacen1'), IdAlmacen1, 
            true)

        if (concepto == 'TransferenciaDeMercancias') {
            WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create - KAIZEN/mi_assing_almacen2'), IdAlmacen2, 
                true)

            WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_btn_Guardar'))

            WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'), 5)
        } else {
            WebUI.click(findTestObject('Object Repository/Page_Create - KAIZEN/mi_btn_Guardar'))

            WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Index - KAIZEN/mi_btn_agregar'), 5)
        }
    }
}

WebUI.delay(5)

CustomKeywords.'exportar_archivos.logInventario.reporteInv'(concepto, motivo, IdProducto, codProducto, Producto, IdGrupo, Existencia, IdAlmacen1, cantidadActual1, IdAlmacen2, cantidadActual2, cantidad)


