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
import java.lang.Integer as Integer


List<String> data = CustomKeywords.'obtener_excels.obtener_pedidos40pies.getValuesExcelCreate40'(Index)
String IDProductoSoportaPeso = data[9]
String IDProductoNoSoportaPeso = data[11]
String Cantidad
String Iterar = data[13]

int CapacidadDisponible = (data[8]).toInteger()
int PesoProducto = (data[10]).toInteger()
int PesoProducto2 = (data[12]).toInteger()
String CantidadBase
int CantidadAñadida
int CantidadRestante
int Elementos
int cantProductos = Iterar.toInteger()
int CantidadSoporta
int CantidadNoSoporta

print(Iterar)

//Se guarda el id del pedido
String IDPedidoCreado = WebUI.executeJavaScript('return document.getElementById(\'IdPedido\').value;', null)
int IDPedidoCreado1 = IDPedidoCreado.toInteger()

CustomKeywords.'exportar_archivos.Ex_guardar_pedidos_creados.demoKey'(IDPedidoCreado1, cantProductos)

String boton = WebUI.executeJavaScript('return document.getElementById("btn_next").style.display;', null)

if (boton == 'block') {
	//EDITAR
	//WebUI.executeJavaScript('alert(\'El boton SI ESTA\')', null)
	//WebUI.click(findTestObject('Page_- KAIZEN/sc_btn_next'))
	WebUI.click(findTestObject('Page_- KAIZEN/sp_Siguiente')) // WebUI.delay(5)
} else {

	if ((Iterar == '1') && (PesoProducto<=CapacidadDisponible)){
		
		//Se añade un solo producto que soporta peso hasta que llene la capacidad de contenedor
		
		CantidadBase=GlobalVariable.CandidadSoporta40pies
		
		Cantidad = CantidadBase
		
		Producto = IDProductoSoportaPeso
					
		WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_producto'))
	
		WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_product'))
	
		WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_product'), Producto, true)
	
		WebUI.setText(findTestObject('Page_- KAIZEN/sp_input_product_quantity'), Cantidad)
	
		WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_add_product'))
		
		CantidadSoporta=Cantidad.toInteger()
		
		CantidadAñadida=CantidadSoporta*PesoProducto
		
		CantidadRestante=CapacidadDisponible-CantidadAñadida
		
		Elementos=CantidadRestante/PesoProducto
		
		String Cantidad2=Elementos.toString()
					
		WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_producto'))
		
		WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_product'))
		
		WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_product'), Producto, true)
		
		WebUI.setText(findTestObject('Page_- KAIZEN/sp_input_product_quantity'), Cantidad2)
		
		WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_add_product'))
		
		WebUI.delay(10)
			
		String boton2 = WebUI.executeJavaScript('return document.getElementById("btn_next").style.display;', null)
		
		if (boton2 == 'none') { //Sale mensaje de error
		
			WebUI.closeBrowser()
									
		}
		else{
					
			WebUI.click(findTestObject('Page_- KAIZEN/sp_Siguiente'))
					
			WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_finish'))
					
			WebUI.delay(3)
				
			WebUI.closeBrowser()
		}
		
		
	} else if ((Iterar == '2')&&(PesoProducto2<=CapacidadDisponible)) {
		/*Se añaden dos productos: 20 productos que No soportan peso y lo restante en productos
		que Si soportan peso hasta que llegue a completar la capacidad del contenedor*/
				
			CantidadBase=GlobalVariable.CantidadNSoporta40pies
			
			Cantidad = CantidadBase
			
			Producto = IDProductoNoSoportaPeso
			
			WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_producto'))
			
			WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_product'))
			
			WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_product'), Producto, true)
			
			WebUI.setText(findTestObject('Page_- KAIZEN/sp_input_product_quantity'), Cantidad)
			
			WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_add_product'))
			
			CantidadNoSoporta=Cantidad.toInteger()
			
			CantidadAñadida=CantidadNoSoporta*PesoProducto2
			
			CantidadRestante=CapacidadDisponible-CantidadAñadida
			
			Elementos=CantidadRestante/PesoProducto
			
			String Cantidad2=Elementos.toString()

			Producto = IDProductoSoportaPeso
					
			WebUI.click(findTestObject('Page_- KAIZEN/sp_Element_producto'))
			
			WebUI.click(findTestObject('Page_- KAIZEN/sp_click_select_product'))
			
			WebUI.selectOptionByValue(findTestObject('Page_- KAIZEN/sp_assing_select_product'), Producto, true)
			
			WebUI.setText(findTestObject('Page_- KAIZEN/sp_input_product_quantity'), Cantidad2)
			
			WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_add_product'))
			
			WebUI.delay(10)
			
			String boton3 = WebUI.executeJavaScript('return document.getElementById("btn_next").style.display;', null)
			
			if (boton3 == 'none') { //Sale mensaje de error
			
				WebUI.closeBrowser()
										
			}
			else{
						
				WebUI.click(findTestObject('Page_- KAIZEN/sp_Siguiente'))
						
				WebUI.click(findTestObject('Page_- KAIZEN/sp_btn_finish'))
						
				WebUI.delay(5)
					
				WebUI.closeBrowser()
			}
			
	}
	
}
